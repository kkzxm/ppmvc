package com.kkzxm.ppmvc.controller.result;

public enum ResultCode {
    SUCCESS(true, 10000, "操作成功！"),
    //---系统错误返回码-----
    FAIL(false, 10001, "操作失败"),
    SERVER_ERROR(false, 99999, "抱歉，系统繁忙，请稍后重试！"),

    //---用户操作返回码  2xxxx----
    LOGIN_SUCCESS(true, 20000, "登录成功"),
    UNAUTHENTICATED(false, 20001, "您还未登录"),
    LOGIN_ERROR(false, 20002, "登录失败:账号或密码错误"),
    UN_AUTHORISE(false, 20003, "权限不足");
    //---企业操作返回码  3xxxx----
    //---权限操作返回码----
    //---其他操作返回码----

    //操作是否成功
    final boolean success;
    //操作代码
    final int code;
    //提示信息
    final String message;

    ResultCode(boolean success, int code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }
}