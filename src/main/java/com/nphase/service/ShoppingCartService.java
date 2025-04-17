package com.nphase.service;

import com.nphase.entity.Product;
import com.nphase.entity.ShoppingCart;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCartService {

    public BigDecimal calculateTotalPrice(ShoppingCart shoppingCart) {

        List<Product> productList = shoppingCart.getProducts();
        BigDecimal totalPriceForALLUnitProducts = BigDecimal.valueOf(0);
        Map<String, Integer> mappingValueOfCategory = new HashMap<>();
        for (Product product : productList) {
            if(mappingValueOfCategory.get(product.getCategory())!= null){
                //retrive the value and add it
                int valueOfCategory = mappingValueOfCategory.get(product.getCategory());
                valueOfCategory = valueOfCategory + product.getQuantity();
                mappingValueOfCategory.put(product.getCategory(),valueOfCategory);
            }
            else{
                mappingValueOfCategory.put(product.getCategory(),product.getQuantity());
            }
        }

        for (Product product : productList) {
            BigDecimal totalPriceForALLUnit = product.getPricePerUnit().multiply(BigDecimal.valueOf(product.getQuantity()));
            if(mappingValueOfCategory.get(product.getCategory()) > 3){
                totalPriceForALLUnit = totalPriceForALLUnit.subtract(totalPriceForALLUnit.multiply(BigDecimal.valueOf(0.1)));
            }
            totalPriceForALLUnitProducts = totalPriceForALLUnitProducts.add(totalPriceForALLUnit);
        }
        return totalPriceForALLUnitProducts;

    }
}
