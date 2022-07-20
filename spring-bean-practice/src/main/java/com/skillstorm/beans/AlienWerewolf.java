package com.skillstorm.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class AlienWerewolf implements Character, BeanNameAware, BeanFactoryAware, InitializingBean, DisposableBean {

	@Autowired
	@Qualifier("nunchuck")
	private Weapon weapon;
	
	private String beanName;
	
	public AlienWerewolf() {
		System.out.println("Creating AlienWerewolf");
//		weapon.attack(); // This will be a null pointer exception. Do this in InitializingBean
	}

	@Override
	public void act() {
		System.out.println("Awooooooooooooo");
		weapon.attack();
	}

	// Automatically called by Spring
	@Override
	public void setBeanName(String name) {
		this.beanName = name; // Makes the Werewolf bean aware of its own name
		System.out.println("BeanNameAware : " + name);
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		// Gives me access to the BeanFactory/ApplicationContext that the bean was created from
		AlienWerewolf aw = (AlienWerewolf) beanFactory.getBean(this.beanName);
//		System.out.println(aw == this); // true because they're the exact same (Singleton beans)
		System.out.println("BeanFactoryAware : " + beanFactory);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// This method is called after all of the properties have been set
		// All initialization is done, so we can safely avoid race conditions that result in NullPointerExceptions
		System.out.println("InitializingBean : " + weapon);
	}
	
	public void init() {
		// Runs right after InitializingBean, but achieves the same purpose
		System.out.println("Custom Init Method");
	}

	@Override
	public void destroy() throws Exception {
		// Runs right before the bean is to be destroyed/garbage collected
		// This is a good place for cleanup. Sever any open connections to dbs, websockets, files
		System.out.println("DisposableBean");
	}
	
	public void delete() {
		// Runs right after DisposableBean, but achieves the same purpose
		System.out.println("Custom Destroy Method");
	}
}
