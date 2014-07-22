/*
 * @(#)WrongWait.java $version 2012. 6. 28.
 *
 * Copyright 2007 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package study.javacon;

/**
 * @author benelog
 */
public class WrongWait {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {

		Object lock = new Object();
		lock.wait();
	}

}
