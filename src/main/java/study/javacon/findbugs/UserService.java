/*
 * @(#)UserService.java $version 2011. 11. 16.
 *
 * Copyright 2007 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package study.javacon.findbugs;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.jcip.annotations.ThreadSafe;

/**
 * @author benelog
 */
@ThreadSafe
public class UserService extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private LoginInfo loginInfo = new LoginInfo();

	public void setLoginInfo(LoginInfo loginInfo) {
		this.loginInfo = loginInfo;
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		this.loginInfo.setId(id);
		System.out.println(loginInfo.getPassword());
		
		Memo memo = new Memo();
		memo.setContent("");

	}

}
