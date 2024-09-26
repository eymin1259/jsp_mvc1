package com.globalin.biz.common;

import org.aopalliance.intercept.Joinpoint;

public class BeforeAdvice {

	public void beforeLog() {
		
		
		System.out.println("@@ BeforeAdvice : beforeLog => "  + " called");
	}
}
