package com.connect_group.tdd_demo.thymeleaf;

import org.thymeleaf.dialect.AbstractDialect;

public class TddDemoDialect extends AbstractDialect {

	@Override
	public String getPrefix() {
		return "demo";
	}
	
	@Override
	public boolean isLenient() {
		return false;
	}
}
