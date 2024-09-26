package polymorphism;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("apple")
@Primary
public class AppleSpeaker implements Speaker {

	@Override
	public void volumUP() {
		System.out.println("AppleSpeaker volumUP ");

	}

	@Override
	public void volumDown() {
		System.out.println("AppleSpeaker volumDown ");
	}

}
