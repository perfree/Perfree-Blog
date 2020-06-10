package com.perfree.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ResponseBean 接口响应实体类")
public class ResponseBean {

    @ApiModelProperty(value = "http 响应状态码")
    private int code;

    @ApiModelProperty(value = "http 响应信息")
    private String msg;

    @ApiModelProperty(value = "http 响应结果")
    private Object data;

    public ResponseBean(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
