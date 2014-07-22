/*
 * @(#)LoginInfo.java $version 2011. 11. 16.
 *
 * Copyright 2007 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package study.javacon.findbugs;

import java.io.Serializable;

import net.jcip.annotations.NotThreadSafe;



/**
 * @author benelog
 */
@NotThreadSafe
public class LoginInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	String id;
	String password;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
