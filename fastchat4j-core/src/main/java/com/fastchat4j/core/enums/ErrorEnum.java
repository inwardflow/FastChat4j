package com.fastchat4j.core.enums;

/**
 * 自定义错误代码
 * @author Scar
 * @date 2023/12/10
 */

public enum ErrorEnum {
    SUCCESS(200, "Success"),
    NOT_FOUND(1004, "Not Found"),
    FORMAT_ERROR(1003, "Format Error");

    private final int code;
    private final String message;

    ErrorEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "Error Code: " + code + ", Message: " + message;
    }
}
