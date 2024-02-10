package com.suresh.order.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suresh.order.dto.OrderLineItemsDto;
import com.suresh.order.dto.OrderRequest;
import com.suresh.order.model.Order;
import com.suresh.order.model.OrderLineItems;
import com.suresh.order.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;

	public void placeOrder(OrderRequest orderRequest) {
		try {
		Order order=new Order();
		order.setOrderNumber(UUID.randomUUID().toString());
		
		List<OrderLineItems> orderLineItems=
				orderRequest.getOrderLineItemsDtoList().stream()
				.map(orderLineItemDto -> mapToRequest(orderLineItemDto))
				.toList();
		
		order.setOrderLineItemsList(orderLineItems);
		orderRepository.save(order);
		} catch(Exception e) {
			System.out.println("Exception occured: "+e.getStackTrace());
		}

		
	}

	private OrderLineItems mapToRequest(OrderLineItemsDto orderLineItemDto) {
		OrderLineItems orderLineItems=new OrderLineItems();
		orderLineItems.setPrice(orderLineItemDto.getPrice());
		orderLineItems.setQuantity(orderLineItemDto.getQuantity());
		orderLineItems.setSkuCode(orderLineItemDto.getSkuCode());
		return orderLineItems;
	}

}
