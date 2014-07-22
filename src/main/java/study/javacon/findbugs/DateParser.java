/*
 * @(#)DateParser.java $version 2011. 11. 16.
 *
 * Copyright 2007 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package study.javacon.findbugs;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author benelog
 */
public class DateParser {

	private final static SimpleDateFormat format = new SimpleDateFormat("yyyy");
	
	public static Date parse(String source) throws ParseException {
		return format.parse(source);
	}

}
