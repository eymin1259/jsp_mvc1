package polymorphism;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("lg")
public class LgTV implements TV {

	
	@Resource(name="apple")
	private Speaker speaker;
	
	
	@Override
	public void powerOn() {
		System.out.println(" LgTV powerOn ");
		
	}

	@Override
	public void volumeUp() {
		System.out.print(" LgTV  =>  ");
		this.speaker.volumUP();
		
	}

	@Override
	public void volumeDown() {
		System.out.print(" LgTV =>  ");
		this.speaker.volumDown();
	}

	@Override
	public void powerOff() {
		System.out.println(" LgTV powerOff");
		
	}

}
