package com.example.designpatterns;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestSingleton {

	public static void main(String args[])
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// 1) Singleton Class By Enum --> This is helps to break from reflection
		SingletonEnum singletonenum1 = SingletonEnum.INSTANCE;
		SingletonEnum singletonenum2 = SingletonEnum.INSTANCE;

		singletonenum1.setFirstname("Mahesh");
		singletonenum1.setLastname("CM");

		singletonenum2.setFirstname("Vishwa");
		singletonenum2.setLastname("N");

		System.out.println(singletonenum1.hashCode());
		System.out.println(singletonenum2.hashCode());

		// 2) Singleton by Eager instanciation -> means at the time of class loading

		SingletonEager singletonEager1 = SingletonEager.getInstance();
		SingletonEager singletonEager2 = SingletonEager.getInstance();

		System.out.println(singletonEager1.hashCode());
		System.out.println(singletonEager2.hashCode());

		// Break by refelction -> this can be prevented by Using Enum Singleton

		SingletonEager singletonEager3 = null;
		Constructor[] constructors = SingletonEager.class.getDeclaredConstructors();
		for (Constructor constructor : constructors) {
			constructor.setAccessible(true);
			Object object = constructor.newInstance();

			singletonEager3 = (SingletonEager) object;
		}
		System.out.println(singletonEager3.hashCode());

		// 3) SingletonLazy

		SingletonLazy singletonLazy1 = SingletonLazy.getInstance();
		SingletonLazy singletonLazy2 = SingletonLazy.getInstance();
		System.out.println(singletonLazy1.hashCode());
		System.out.println(singletonLazy2.hashCode());

		// MultiThreaded Environment breaking Singleton class

		ExecutorService executorService = Executors.newFixedThreadPool(5);
		MyThreadTask mytask = new MyThreadTask();
		executorService.execute(mytask);
		executorService.execute(mytask);
		executorService.execute(mytask);
		executorService.execute(mytask);
		
		/**
		 * Save from multithreading break same as Upper One
		 */
		
		// By Cloning we can able to break
		
	/**
	 *  Implement clonging by implementing interface clonable and overriding method clone() where just need to return super.clone();
	 *  
	 *  
	 */
		// Cloning can be avoided by not retruning super.clone() except throw CloneNotSupportedException
		
		// By serialization also we can able to break while deserialization
	
		
		/**
		 * to Avoid failure while Deserailization 
		 * 
		 * override readResolve() method 
		 * 
		 * public Object readResolve() {
				return getInstance();
		   }
		 */
		
	}

}
