package com.youxifan.utils;

import java.io.IOException;
import java.util.Enumeration; 
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
 
 
import com.youxifan.pojo.User;
import com.youxifan.service.UserService;

public class LoginFilter implements Filter {

	protected final transient Log log = LogFactory
	.getLog(LoginFilter.class);
	


	private String loginJSP = "/";
	
	// ① 不需要登录即可访问的URI资源
	private static String[] INHERENT_ESCAPE_URIS = null;
	// ② 执行过滤
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession();
//		log.info("sessionid：==="+session.getId());
		// ②-1 保证该过滤器在一次请求中只被调用一次
		if (request != null && httpRequest.getAttribute(CommonUtil.FILTERED_REQUEST) != null) {
			chain.doFilter(request, response);
		} else {
			
			// ②-2 设置过滤标识，防止一次请求多次过滤
			httpRequest.setAttribute(CommonUtil.FILTERED_REQUEST, Boolean.TRUE);
			
			User userContext = (User)session.getAttribute(CommonUtil.USER_CONTEXT);
			
			// ②-3 用户未登录, 且当前URI资源需要登录才能访问    &&  !isURILogin(httpRequest.getRequestURI(), httpRequest)
			if (userContext == null &&  !isURILogin(httpRequest.getRequestURI(), httpRequest)) {
//				Cookie[] cookies =httpRequest.getCookies();
//				boolean autologin = false;
//				String email = null;
//				for (Cookie cookie : cookies) {
//					if ("autologin".equals(cookie.getName())) {
//						if ("1".equals(cookie.getValue())) {
//							autologin = true;
//						}
//					}else if("email".equals(cookie.getName())){
//						email = cookie.getValue();
//					}
//				}
//				if (autologin) {
//					User user = userService.getUserByEmail(email);
//					session.setAttribute(CommonUtil.USER_CONTEXT, user);
//					chain.doFilter(request, response);
//					return;
//				}
//				
//				System.out.println("httpRequest.getRequestURI() == "+httpRequest.getRequestURI());
//				System.out.println("httpRequest.getRequestURL() == "+httpRequest.getRequestURL());
//				System.out.println("httpRequest.getRequestURL() == "+httpRequest.getQueryString());
//				
				String toUrl = httpRequest.getRequestURL().toString();
				if (!StringUtils.isEmpty(httpRequest.getQueryString())) {
					toUrl = httpRequest.getQueryString();
				}
				// ②-4将用户的请求URL保存在session中，用于登录成功之后，跳到目标URL
				session.setAttribute(CommonUtil.LOGIN_TO_URL, toUrl); 
				Map paraMap = new HashMap(request.getParameterMap());	
				session.setAttribute(CommonUtil.REQUEST_PARAMETERS, paraMap);
				// ②-5转发到登录页面
				log.info("通不过的链接：==="+toUrl);
				for (Object key : paraMap.keySet()) {
					log.info(key+"=="+StringUtils.join((String[])paraMap.get(key), ","));
				}	
				request.getRequestDispatcher(this.loginJSP).forward(request,
						response);
				return;
			}
			chain.doFilter(request, response);
		}
	}

	// ③ 当前URI资源是否需要登录才能访问
	private boolean isURILogin(String requestURI, HttpServletRequest request) {
		if (request.getContextPath().equalsIgnoreCase(requestURI)
				|| (request.getContextPath() + "/")
						.equalsIgnoreCase(requestURI))
			return true;
		for (String uri : INHERENT_ESCAPE_URIS) {
			if (requestURI != null && requestURI.indexOf(uri) >= 0) {
				return true;
			}
		}
		return false;
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}


	public void init(FilterConfig arg0) throws ServletException {


		log.debug("arg0"+arg0.getFilterName());
		Enumeration e= arg0.getInitParameterNames();
		while (e.hasMoreElements()) { 
			String key = (String)e.nextElement();
			String value = arg0.getInitParameter(key);
			if ("loginJSP".equals(key)) {
				this.loginJSP = value;
			}else if ("extpaths".equals(key)) {
				INHERENT_ESCAPE_URIS = value.split(",");
				for (int i = 0; i < INHERENT_ESCAPE_URIS.length; i++) {
					INHERENT_ESCAPE_URIS[i] = INHERENT_ESCAPE_URIS[i].trim();
				}
			}
			
			log.debug(key +"===="+value);

		}

		// TODO Auto-generated method stub
		
	}
}