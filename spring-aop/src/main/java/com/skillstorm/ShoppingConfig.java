package com.skillstorm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;

import com.skillstorm.beans.Costco;
import com.skillstorm.beans.Item;
import com.skillstorm.beans.ShoppingCenter;

@Configuration
@ComponentScan(basePackages = "com.skillstorm")
@EnableAspectJAutoProxy // Works similar to ComponentScan, but for @Aspect
public class ShoppingConfig {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(ShoppingConfig.class);
		
		Item[] groceryList = new Item[3];
		
		groceryList[0] = context.getBean(Item.class, "Milk", 3.00);
		groceryList[1] = context.getBean(Item.class, "Bread", 1.51);
		groceryList[2] = context.getBean(Item.class, "Eggs", 1.00);
		ShoppingCenter shop = context.getBean(ShoppingCenter.class);
//		shop.shop(); // when shop() is called, the Aspect will cut in
		try {
			double totalPrice = shop.shop(groceryList, true);
			System.out.println("Total Price: " + totalPrice);
		} catch (Throwable e) {
			System.err.println(e.getMessage());
		}
		
	}
	
//	@Bean
//	@Scope("prototype")
//	public Item item(String name, double price) {
//		return new Item(name, price);
//	}
	
}
