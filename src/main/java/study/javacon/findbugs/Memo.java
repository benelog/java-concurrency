/*
 * @(#)LoginInfo.java $version 2011. 11. 16.
 *
 * Copyright 2007 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package study.javacon.findbugs;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import net.jcip.annotations.Immutable;

/**
 * @author benelog
 */
@Immutable
public class Memo implements Serializable {

	private static final long serialVersionUID = 1L;
	final SimpleDateFormat format = new SimpleDateFormat("yyyy");
	private String content;

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
