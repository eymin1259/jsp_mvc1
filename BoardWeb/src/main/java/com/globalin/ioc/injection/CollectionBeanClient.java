package com.globalin.ioc.injection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanClient {


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		CollectionBean bean = (CollectionBean)factory.getBean("collectionBean");
		
		List<String> addressList = bean.getAddressList();
		Set<String> addressSet = bean.getAddressSet();
		Map<String, String> addressMap = bean.getAddressMap();
		Properties addressProps = bean.getAddressProp();
		
		
		
		for(String addr : addressList) {
			System.out.println("addr : " + addr);
		}
		
		for(String addr : addressSet) {
			System.out.println("addr2 : " + addr);
		}
		
		for(String key : addressMap.keySet()) {
			System.out.println("addr3 : " + key + ", " + addressMap.get(key));
		}
		
		for(String name: addressProps.stringPropertyNames()) {
			System.out.println("addr4 : " + name + ", " + addressProps.get(name));
		}
		
		
		
		
		
	
		
		factory.close();
	}

}
