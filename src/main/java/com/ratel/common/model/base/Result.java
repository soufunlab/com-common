package com.ratel.common.model.base;

import java.io.Serializable;

public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private boolean success;//是否成功
    private int errCode;//错误编码
    private String errMsg;//错误信息
    private Object data; //操作数据
    private T result;

    /**
     * 执行正常无返回值
     */
    public Result() {
        this.success = true;
    }

    /**
     * 执行正常有返回值
     *
     * @param result
     */
    public Result(T result) {
        this.result = result;
        this.success = true;
    }

    /**
     * 执行正常有返回值 有操作实体
     *
     * @param result
     */
    public Result(T result, Object data) {
        this.result = result;
        this.data = data;
        this.success = true;
    }

    /**
     * 执行异常，无返回值，返回错误信息编码,名称
     *
     * @param errCode
     * @param errMsg
     */
    public Result(int errCode, String errMsg) {
        this.errMsg = errMsg;
        this.errCode = errCode;
        this.success = false;
    }

    /**
     * 执行异常，有返回值，返回错误信息编码,名称
     *
     * @param errCode
     * @param errMsg
     */
    public Result(T result, int errCode, String errMsg) {
        this.result = result;
        this.errMsg = errMsg;
        this.errCode = errCode;
        this.success = false;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
