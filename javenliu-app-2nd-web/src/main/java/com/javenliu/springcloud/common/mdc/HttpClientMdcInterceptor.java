package com.javenliu.springcloud.common.mdc;

import com.javenliu.springcloud.common.constant.Constants;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.protocol.HttpContext;
import org.slf4j.MDC;

import java.io.IOException;

/**
 * 生效方法：
 * HttpClientBuilder.addInterceptor(new HttpClientMdcInterceptor())
 */
@Slf4j
public class HttpClientMdcInterceptor implements HttpRequestInterceptor {
    @Override
    public void process(HttpRequest httpRequest, HttpContext httpContext)
            throws HttpException, IOException {
        String traceId = MDC.get(Constants.TRACE_ID);
        if(StringUtils.isNotEmpty(traceId)) {
            httpRequest.addHeader(Constants.TRACE_ID, traceId);
        }
    }
}
