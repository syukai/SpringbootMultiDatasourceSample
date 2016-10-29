package com.example.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.example.datasource.SchemaContextHolder;
import com.example.datasource.SchemaType;

/**
 * データソース選択用インターセプタ（リクエストがあった際に割り込む処理）
 * @author u0268
 *
 */
public class DatasourceInterceptor extends HandlerInterceptorAdapter {

	/**
	 * 事前処理
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// セッションに保持しているデータソースに切り替える
		if(!StringUtils.isEmpty(request.getSession().getAttribute("datasource"))){
			SchemaContextHolder.setSchemaType((SchemaType)request.getSession().getAttribute("datasource"));
		}
		return true;
	}

	
}
