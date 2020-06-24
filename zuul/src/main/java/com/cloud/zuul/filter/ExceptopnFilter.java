package com.cloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class ExceptopnFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        try {
            doSomething();
        } catch (Exception e) {
            context.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            context.set("error.exception", e);
        }
        return null;
    }

    private static void doSomething() {
        throw new RuntimeException("runtime exception");
    }
}
