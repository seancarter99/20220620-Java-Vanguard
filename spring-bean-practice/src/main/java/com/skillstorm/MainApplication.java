package com.skillstorm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.skillstorm.beans.Human;
import com.skillstorm.beans.Pistol;
import com.skillstorm.beans.Robot;
import com.skillstorm.beans.Sword;
import com.skillstorm.beans.Weapon;

public class MainApplication {

	public static void main(String[] args) {
		
		// Initialize Spring
		// 1. Configuration File (XML or AnnotationConfigFile)
		// 2. IOC Container/ApplicationContext
		
		// ApplicationContext is what holds all of my beans
//		ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringBeanConfiguration.class);
		
		// This class is tightly coupled to Sword now
//		Sword sword = new Sword();
//		sword.attack();
		
		Weapon weapon1 = (Weapon) context.getBean("weapon");
		weapon1.attack();
		
		Weapon weapon2 = (Weapon) context.getBean("weapon");
		// Beans are singletons by default.
		// ACcessing the same bean multiple times will be the same Java Object
		System.out.println(weapon1 == weapon2);
		System.out.println(weapon2);
		
		Human cowboy = (Human) context.getBean("cowboy");
		cowboy.act();
		
		Human knight = (Human) context.getBean("knight");
		knight.act();
		
		System.out.println(knight);
		System.out.println(cowboy);
		
		Robot robot = context.getBean(Robot.class); // Give me a bean of type Robot
		robot.act();
		
		context.getBean(Pistol.class);
		context.getBean(Pistol.class);
		context.getBean(Pistol.class);
		context.getBean("pistol");
		
		Human human = context.getBean(Human.class); // Give me a bean of type human
		human.act();
		
		
		// Once the context is closed, we cannot access beans anymore
		((AbstractApplicationContext) context).close();
		
//		context.getBean("weapon"); This throws an exception
	}

}
