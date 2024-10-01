package com.globalin.ioc.injection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanClient {

	public static void main(String[] args) {

		// 1. Spring 컨테이너를 구동한다.
				AbstractApplicationContext factory =
						new GenericXmlApplicationContext("applicationContext.xml");
				
				
		CollectionBean bean =(CollectionBean)factory.getBean("collectionBean");
		
		Properties addressList = bean.getAddressList();
		
		for(String key : addressList.stringPropertyNames()) {
			System.out.println(
					String.format("키 : %s, 값 : %s", key, addressList.get(key)));
		}

		factory.close();
	}

}
