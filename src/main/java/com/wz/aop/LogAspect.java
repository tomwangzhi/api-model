package com.wz.aop;


import com.wz.util.LogUtils;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 1.定义切面
 */
@Aspect
public class LogAspect {

    /**
     * 2.定义切点
     * 切点 controller上面的所有方法
     */
    @Pointcut("public * com.wz.controller.*Controller.*(..))")
    public void pointCut() {

    }

    /**
     * 3.通知
     * 返回的结果打印，或者日志记录到数据库，缓存，文件系统中
     * @param ret
     */
    @AfterReturning(returning = "ret", pointcut = "pointCut()")
    public void doAfterReturning(Object ret) {
        /**
         * 打印返回的对象json
         */
        LogUtils.doAfterReturning(ret);
    }

}
