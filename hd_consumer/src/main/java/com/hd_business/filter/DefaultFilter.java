package com.hd_business.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class DefaultFilter
 */
public class DefaultFilter implements Filter {
	private String excludePages;
	private String[] excludePageArray;
    /**
     * Default constructor. 
     */
    public DefaultFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		boolean isChain = false;
		String path = req.getServletPath();
		for(String p : excludePageArray){
			if(path.equals(p)){
				isChain=true;
				break;
			}
		}
		HttpSession session = req.getSession();
		if(isChain){
			chain.doFilter(request, response);							
		}else{
			if(session.getAttribute("currentUser")!=null){
				chain.doFilter(request, response);
			}else {
				if("/.do".equals(path)){
					req.getRequestDispatcher("/userLogin.do?method=tologin").forward(req, resp);
				}else{
					req.getRequestDispatcher("/userLogin.do?method=tologin").forward(req, resp);					
				}
			}
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
		this.excludePages = fConfig.getInitParameter("excludePages");
		if(this.excludePages != null){
			this.excludePageArray = this.excludePages.split(",");			
		}
	}

	
	//getter/setter
	public String getExcludePages() {
		return excludePages;
	}

	public void setExcludePages(String excludePages) {
		this.excludePages = excludePages;
	}

}
