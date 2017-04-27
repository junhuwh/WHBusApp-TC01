package com.ibm.wuhan.bus.web.tag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class RefererTag extends SimpleTagSupport {

	private String site;
	private String page;

	public void setSite(String site) {
		this.site = site;
	}

	public void setPage(String page) {
		this.page = page;
	}

	@Override
	public void doTag() throws JspException, IOException {

		PageContext pageContext = (PageContext) this.getJspContext();
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		HttpServletResponse response = (HttpServletResponse) pageContext.getResponse();
		// 1 得到来访者的 referer
		String referer = request.getHeader("referer");
		if (referer == null || !referer.startsWith(site)) {

			if (page.startsWith(request.getContextPath())) {
				response.sendRedirect(page);
			} else if (page.startsWith("/")) {
				response.sendRedirect(request.getContextPath() + page);
			} else {
				response.sendRedirect(request.getContextPath() + "/" + page);
			}
			throw new SkipPageException();
		}else{
			
		}

		// 2 判断来访者页面是不是 要防盗链的网站 site

	}

}
