package com.javenliu.springcloud.common.mdc;

import com.javenliu.springcloud.common.constant.Constants;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FeignInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        String traceId = MDC.get(Constants.TRACE_ID);
        log.info("进入feign拦截器. traceId={}", traceId);

        if (StringUtils.isEmpty(traceId)) {
            //设置新值
            traceId = null;
        }
        requestTemplate.header(Constants.TRACE_ID, traceId);
    }
}
