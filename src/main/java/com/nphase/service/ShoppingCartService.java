package com.nphase.service;

import com.nphase.entity.ShoppingCart;

import java.math.BigDecimal;

public class ShoppingCartService {
	//@Value... can be injected form property file
	private final static DISCOUNT = 10;
	//@Value...
	private final static ITEMS_NEEDED = 3;

    public BigDecimal calculateTotalPrice(ShoppingCart shoppingCart) {
    	BigDecimal res = new BigDecimal(0);
    	if (shoppingCart != null) {
    		List<Product> products = shoppingCart.getProducts();
    		for (Product p: products) {
    			Bigdecimal ppu = p.getPricePerUnit();
    			int q = p.getQuantity();
    			res.add(ppu.multiply(q));
    		
    			
    		}
    	}
        return res;     	
    }
    
    public BigDecimal calculateTotalPrice2(ShoppingCart shoppingCart) { 
    	BigDecimal res = new BigDecimal(0);
    	if (shoppingCart != null) {
    		List<Product> products = shoppingCart.getProducts();
    		if (products == null) {
    			return res;
    		}
    		for (Product p: products) {
    			Bigdecimal ppu = p.getPricePerUnit();
    			int q = p.getQuantity();
    			if (q > ITEMS_NEEDED) {
    				res.add(ppu.multiply(q).multiply((100.0 - DISCOUNT)/ 10);
    			} else {
    				res.add(ppu.multiply(q));
    			}
    		}
    	}
        return res;    	
    }
    
    public BigDecimal calculateTotalPrice3(ShoppingCart shoppingCart) { 
    	BigDecimal res = new BigDecimal(0);
    	Map<String, Integer> map = new HashMap<>();
    	if (shoppingCart != null) {
    		List<Product> products = shoppingCart.getProducts();
    		for (Product p: products) {
    			map.put(p.getCategory(),
    					Math.max(p.getOrDefault(p.getCategory(), 0), p.getQuantity());
    		}
    		if (products == null) {
    			return res;
    		}    		
    		for (Product p: products) {
    			Bigdecimal ppu = p.getPricePerUnit();
    			int q = p.getQuantity();
    			if (map.get(p.getCategory())  > ITEMS_NEEDED) {
    				res.add(ppu.multiply(q).multiply(100.0 - DISCOUNT)/ 10));
    			} else {
    				res.add(ppu.multiply(q));
    			}
    		}
    	}
        return res;      	
    	
    }
    

}
