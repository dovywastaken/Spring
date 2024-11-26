package com.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.domain.Book;
import com.springmvc.domain.Order;
import com.springmvc.repository.BookRepository;
import com.springmvc.repository.CartRepository;
import com.springmvc.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService
{
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private CartRepository cartRepository;
	
	@Override
	public void confirmOrder(String bookId, long quantity) 
	{
		Book bookById = bookRepository.getBookById(bookId);
		if(bookById.getUnitsInstock() < quantity) 
		{
			throw new IllegalArgumentException("품절입니다. 사용가능한 재고수 : " + bookById.getUnitsInstock());
		}
		bookById.setUnitsInstock(bookById.getUnitsInstock() - quantity);
	}

	@Override
	public Long saveOrder(Order order) 
	{
		Long orderId = orderRepository.saveOrder(order);
		cartService.delete(order.getCart().getCartId());
		
		return orderId;
	}
	
	public void delete(String cartId) {cartRepository.delete(cartId);}
	
}
