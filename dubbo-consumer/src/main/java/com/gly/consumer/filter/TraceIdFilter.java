package com.gly.consumer.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.rpc.RpcContext;
import org.slf4j.MDC;
import org.springframework.core.annotation.Order;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;

import javax.servlet.FilterChain;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @description: Web 请求日志拦截统一处理
 * @className: TraceIdFilter
 * @package: com.yuntai.cons.filter
 * @author: duanhr@hsyuntai.com
 * @date: 2020/3/23 13:41
 * @copyright: 版权归 HSYUNTAI 所有
 */
@Slf4j
@Order(0)
@WebFilter(urlPatterns = {"/*"})
public class TraceIdFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) {
        try {
        	String traceId = request.getHeader("traceId");
        	if(StringUtils.isBlank(traceId)) {
        	    traceId = UUID.randomUUID().toString().replace("-", "");
        	}
            MDC.put("traceId",traceId);
            RpcContext.getContext().setAttachment("traceId", MDC.get("traceId"));
            chain.doFilter(new ContentCachingRequestWrapper(request), response);
        } catch (Exception exception) {
            log.error("Web端traceId处理异常", exception);
        } finally {
            MDC.clear();
            RpcContext.getContext().clearAttachments();
        }
    }

}
