package com.br.eudecido.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class GerenciadorAcesso extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String uri = request.getRequestURI();
		if (uri.endsWith("/") || uri.endsWith("/usuarioController/logar")
				|| uri.endsWith("/projetoController/listarProjetos")) {
			return true;
		}

		// TODO Auto-generated method stub
		return super.preHandle(request, response, handler);
	}

}
