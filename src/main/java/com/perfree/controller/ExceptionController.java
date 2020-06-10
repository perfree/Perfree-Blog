package com.perfree.controller;

import com.perfree.common.ResponseBean;
import com.perfree.exception.UnauthorizedException;
import org.apache.shiro.ShiroException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常拦截
 * @author Perfree
 */
@RestControllerAdvice
public class ExceptionController {

    /**
     * 捕捉Shiro的异常
     * @param e ShiroException
     * @return ResponseBean
     */
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(ShiroException.class)
    public ResponseBean handle401(ShiroException e) {
        return new ResponseBean(401, e.getMessage(), null);
    }

    /**
     * 捕捉自定义异常UnauthorizedException
     * @return ResponseBean
     */
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedException.class)
    public ResponseBean handle401(UnauthorizedException e) {
        return new ResponseBean(e.getCode(), e.getMsg(), null);
    }

    /**
     * 捕捉其他所有异常
     * @param request HttpServletRequest
     * @param ex Throwable
     * @return ResponseBean
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseBean globalException(HttpServletRequest request, Throwable ex) {
        return new ResponseBean(getStatus(request).value(), ex.getMessage(), null);
    }

    /**
     * 获取Http状态码
     * @param request HttpServletRequest
     * @return HttpStatus
     */
    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }
}
