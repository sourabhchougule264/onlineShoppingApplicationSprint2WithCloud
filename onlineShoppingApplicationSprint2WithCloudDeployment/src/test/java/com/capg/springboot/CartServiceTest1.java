package com.capg.springboot;

import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capg.springboot.entity.Cart;
import com.capg.springboot.repository.CartRepository;
import com.capg.springboot.service.CartServiceImpl;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class CartServiceTest1 {

	@InjectMocks
	private CartServiceImpl cart_ser;
	
	@Mock
	private CartRepository cart_repo;
	
	@Test
    public void addCartTest() {
		Cart cart=new Cart();
		cart.setCartId("1212");
		Mockito.when(cart_repo.save(cart)).thenReturn(cart);	
	}
	
}
