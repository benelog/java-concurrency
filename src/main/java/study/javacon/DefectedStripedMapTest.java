/*
 * @(#)StripedMapTest.java $version 2012. 5. 21.
 *
 * Copyright 2007 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package study.javacon;

import org.junit.Test;

/**
 * @author benelog
 */
public class DefectedStripedMapTest {

	String key = "polygenelubricants";

	@Test
	public void showDefect() throws Exception {
		DefectedStripedMap map = new DefectedStripedMap(100);
		map.get(key);
	}

	@Test
	public void printHash() throws Exception {
		int hash = Math.abs(key.hashCode());
		System.out.println(hash);
	}
}
