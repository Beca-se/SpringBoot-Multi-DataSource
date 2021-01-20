package com.stee.mobility.platform.services.atms.dms.message.domain;

import org.springframework.http.HttpStatus;

/**
 * @author zhouhu
 * @Class Name ResultBean
 * @Desc
 * @create: 2019-09-05 14:26
 **/
public class ResultBean {
    private int code;
    private String message;
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultBean{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public static ResultBean isOK(String message) {
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(HttpStatus.OK.value());
        resultBean.setMessage(message);
        resultBean.setData(null);
        return resultBean;
    }

    public static ResultBean isOK(String message, Object object) {
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(HttpStatus.OK.value());
        resultBean.setMessage(message);
        resultBean.setData(object);
        return resultBean;
    }

    public static ResultBean isBad(String message) {
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(HttpStatus.BAD_REQUEST.value());
        resultBean.setMessage(message);
        return resultBean;
    }

    public static ResultBean isBad(String message, String field) {
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(HttpStatus.BAD_REQUEST.value());
        resultBean.setMessage(message);
        resultBean.setData(field);
        return resultBean;
    }

    public static ResultBean isError(String message) {
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        resultBean.setMessage(message);
        resultBean.setData(null);
        return resultBean;
    }
    
}
