package polymorphism;

import org.springframework.stereotype.Component;

@Component("sony")
public class SonySpeaker implements Speaker {

	@Override
	public void volumUP() {
		System.out.println("SonySpeaker volumUP ");

	}

	@Override
	public void volumDown() {
		System.out.println("SonySpeaker volumDown ");
	}

}
