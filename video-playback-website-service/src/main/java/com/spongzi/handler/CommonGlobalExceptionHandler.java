package com.spongzi.handler;

import com.spongzi.domain.JsonResponse;
import com.spongzi.exception.ConditionException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 通用全局异常处理程序
 *
 * @author spong
 * @date 2023/11/16
 */
@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CommonGlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public JsonResponse<String> handleConditionException(HttpServletRequest request, Exception e) {
        String errMsg = e.getMessage();
        if (e instanceof ConditionException) {
            String errCode = ((ConditionException) e).getCode();
            return JsonResponse.success(Integer.valueOf(errCode), errMsg, errMsg);
        } else {
            return JsonResponse.fail(errMsg);
        }
    }

}
