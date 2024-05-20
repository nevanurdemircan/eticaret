package org.example.repository;

import org.example.entity.Cart;

public class CartRepository implements BaseRepository<Cart, Integer> {
    private static CartRepository cartRepository;
    public static  CartRepository getInstance(){
        if(cartRepository == null){
            cartRepository = new CartRepository();
        }
        return cartRepository;
    }
    @Override
    public Cart save(Cart entity) {
        return null;
    }

    @Override
    public Cart findById(Integer integer) {
        return null;
    }
}
