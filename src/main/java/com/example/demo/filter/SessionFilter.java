package com.example.demo.filter;

import com.alibaba.fastjson.JSON;
import com.example.demo.consts.Result;
import com.example.demo.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
@Component
public class SessionFilter implements Filter {
    private static final String session_user_key = "user_key";

    String[] includeUrls = new String[]{"/api/*"};

    @Override
    public void init(FilterConfig filterConfig) throws ServletException { }

    @Override
    public void destroy() { }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);// 获取当前请求的 session
        String uri = request.getRequestURI();// 获取访问路径

        log.info("uri: {}", uri);
        boolean needLogin = shouldLogin(uri);
        log.info("need login: {}", needLogin);
        if (!needLogin) {
            chain.doFilter(request, response);
        } else {
            if(null != session && null != session.getAttribute(session_user_key)){
                chain.doFilter(request, response);
            }else{
                String ajaxHeader = request.getHeader("X-Requested-With");
                if ("XMLHttpRequest".equals(ajaxHeader)){
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    Result result = ResultUtil.error(401, "please login");
                    PrintWriter writer = response.getWriter();
                    writer.write(JSON.toJSONString(result));
                    writer.flush();
                    writer.close();
                    return;
                } else {
                    response.sendRedirect("/login");
                }
            }
        }
    }

    public boolean shouldLogin(String uri) {
        for (String includeUrl : includeUrls) {
            if(!uri.matches(includeUrl)) {
                return false;
            }
        }

        return true;
    }
}
