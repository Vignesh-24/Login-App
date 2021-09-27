package com.login.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SessionCheckFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession(false);
		
		//if there is session, proceed with next step
		if(session!=null && session.getAttribute("loginFlag") != null) {
			chain.doFilter(request, response);
		}
		
		else {
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			httpResponse.sendRedirect("/sessionerror");
		}
		
	}
	
	
	
	@Bean
	public FilterRegistrationBean<SessionCheckFilter> sessionFilter(){
	    FilterRegistrationBean<SessionCheckFilter> registrationBean = new FilterRegistrationBean<>();
	    registrationBean.setFilter(new SessionCheckFilter());
	    registrationBean.addUrlPatterns("/app/*");
	    return registrationBean;    
	}
	
	

}
