package com.javenliu.springcloud.common.mdc;

import com.netflix.hystrix.strategy.HystrixPlugins;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategy;
import org.springframework.stereotype.Component;

import java.util.concurrent.Callable;

/**
 * Hystrix线程池隔离支持日志链路跟踪
 */
@Component
public class MdcHystrixConcurrencyStrategy extends HystrixConcurrencyStrategy {

    public MdcHystrixConcurrencyStrategy() {
        //干掉原有包里的bean，否则启动会报重复注入
        HystrixPlugins.reset();
        HystrixPlugins.getInstance().registerConcurrencyStrategy(this);
    }

    @Override
    public <T> Callable<T> wrapCallable(Callable<T> callable) {
        return ThreadMdcUtils.wrap(callable);
    }
}
