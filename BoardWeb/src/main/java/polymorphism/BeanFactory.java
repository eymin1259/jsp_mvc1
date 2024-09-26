package polymorphism;

public class BeanFactory {
	
	public TV getBean(String beanname) {
		TV ret = null;
		switch(beanname) {
		case "samsung" : 
			ret = new SamgsungTV();
			break;
		case "lg" :
			ret = new LgTV();
			break;
		}
		return ret;
	}

}
