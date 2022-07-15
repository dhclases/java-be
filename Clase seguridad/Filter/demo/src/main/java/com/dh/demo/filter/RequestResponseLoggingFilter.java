package com.dh.demo.filter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(2)
public class RequestResponseLoggingFilter implements Filter {

    private static final Logger logger = LogManager.getLogger(TransactionFilter.class);

    @Override
    public void init(final FilterConfig filterConfig) throws ServletException {
        logger.info("Initializing filter 2 :{}", this);
    }

    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        logger.info("Segundo Filtro Request  {} : {}", req.getMethod(), req.getRequestURI());
        chain.doFilter(request, response);
        logger.info("Segundo Filtro Response :{}", res.getContentType());
    }

    @Override
    public void destroy() {
        logger.warn("Destructing filter 2/**/ :{}", this);
    }
}
