/**
 * Copyright 2016 Dillon Lynch
 */
package com.dnd.util;

public class DiceThrower {

	
	public int throwD10(){
		int res = (int) (Math.random() * 10);
		return res;
	}
	
	public int throwD20(){
		int res = (int) (Math.random() * 20);
		return res;
	}
	
	public int throwD100(){
		int res = (int) (Math.random() * 100);
		return res;
	}
}
