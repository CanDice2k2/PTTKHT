//package com.example.ecommerce.service;
//
//import org.springframework.stereotype.Service;
//
//import com.example.ecommerce.model.OrderItem;
//import com.example.ecommerce.repository.OrderItemRepository;
//
//@Service
//public class OrderItemServiceImplementation implements OrderItemService {
//
//	private OrderItemRepository orderItemRepository;
//	public OrderItemServiceImplementation(OrderItemRepository orderItemRepository) {
//		this.orderItemRepository=orderItemRepository;
//	}
//	@Override
//	public OrderItem createOrderItem(OrderItem orderItem) {
//
//		return orderItemRepository.save(orderItem);
//	}
//
//}
