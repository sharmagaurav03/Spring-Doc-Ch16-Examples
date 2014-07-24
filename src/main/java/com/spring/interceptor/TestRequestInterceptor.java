package com.spring.interceptor;

import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;


public class TestRequestInterceptor implements WebRequestInterceptor {
	private static final Logger LOG = LoggerFactory.getLogger(TestRequestInterceptor.class);

	public void preHandle(WebRequest request) throws Exception {
		LOG.debug("****************************************");
		Iterator<String> headers=request.getHeaderNames();
		while(headers.hasNext())
		{
			LOG.debug("------------------->"+headers.next()+" ");
		}
		LOG.debug("****************************************");
	}

	public void postHandle(WebRequest request, ModelMap model) throws Exception {
		LOG.debug("#######################################"+model);
		
	}

	public void afterCompletion(WebRequest request, Exception ex)
			throws Exception {
		
	}

}
