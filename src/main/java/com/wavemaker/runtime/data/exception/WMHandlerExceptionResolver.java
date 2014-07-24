package com.wavemaker.runtime.data.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

public class WMHandlerExceptionResolver extends
		AbstractHandlerExceptionResolver {

	@Override
	protected ModelAndView doResolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		ModelAndView modelAndView = null;
		if (ex instanceof EntityNotFoundException) {
			ErrorDetails errorDetails = new ErrorDetails();
			errorDetails.setCode(ex.getClass().getSimpleName());
			errorDetails.setMessage(ExceptionUtils.getRootCauseMessage(ex));
			modelAndView = new ModelAndView(new MappingJackson2JsonView());
			modelAndView.addObject(errorDetails);
			return modelAndView;
		}

		return modelAndView;
	}

}
