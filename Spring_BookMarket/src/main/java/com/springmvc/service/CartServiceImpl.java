package com.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.domain.Cart;
import com.springmvc.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService
{
	@Autowired
	private CartRepository cartRepository;

	@Override
	public Cart create(Cart cart) 
	{
		return cartRepository.create(cart);
	}

	@Override
	public Cart read(String cartId) 
	{
		return cartRepository.read(cartId);
	}

	@Override
	public void update(String cartId, Cart cart) 
	{
		cartRepository.update(cartId, cart);
	}
	
	
}
