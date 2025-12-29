package com.learn.treeEn.base.controller.result;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Result {
    private boolean success;// 是否成功
    private Integer code;// 返回码
    private String message;// 返回信息
    private Object data;// 返回数据

    // region 构造方法
    public Result(ResultCode resultCode, Object data) {
        if (data != null) this.data = data;
        setResultCode(resultCode);
    }

    public Result(ResultCode resultCode) {
        setResultCode(resultCode);
    }

    public Result() {
        setResultCode(ResultCode.SUCCESS);
    }
    // endregion

    // region success
    public static Result success(Object o) {
        return new Result(ResultCode.SUCCESS, o);
    }

    public static Result success() {
        return new Result(ResultCode.SUCCESS);
    }
// endregion

    // region 根据success的值,直接返回
    public static Result result(boolean success,Object data) {
        Result result = result(success);
        result.setData(data);
        return result;
    }

    public static Result result(boolean success) {
        Result result = new Result();
        if (success) {
            result.setResultCode(ResultCode.SUCCESS);
        } else {
            result.setResultCode(ResultCode.FAIL);
        }
        return result;
    }
    // endregion

    private void setResultCode(ResultCode resultCode) {
        this.success = resultCode.success;
        this.code = resultCode.code;
        this.message = resultCode.message;
    }


}