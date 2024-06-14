package com.facebookspringboot.utility;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class HandleLogAspect {
	@Before()
	public void entryPoint() {
		log
	}
	@After
	@Around
}
