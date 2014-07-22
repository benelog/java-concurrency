package jdm.appendixa.holder;

import java.util.Date;

public class MySystem {
	private Date date = new Date();
	private MySystem(){
	}
	public Date getDate() {
		return date;
	}
	
	public static MySystem getInstance(){
		return null;
	}
}
