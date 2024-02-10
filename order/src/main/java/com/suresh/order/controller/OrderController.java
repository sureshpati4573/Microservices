package com.suresh.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.suresh.order.dto.OrderRequest;
import com.suresh.order.service.OrderService;

@RestController
@RequestMapping("/order/v1")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	
	@PostMapping("/placeOrder")
	@ResponseStatus(HttpStatus.CREATED)
	public String placeOrder(@RequestBody OrderRequest orderRequest) {
		orderService.placeOrder(orderRequest);
		return "Order Placed Successfully";
		
	}

}
