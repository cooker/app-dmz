package com.github.grant.admin.exception;

/**
 * @author kqyu
 * 19/11/2020 6:26 下午
 * 描述：服务异常
 */
public class ServerErrorException extends RuntimeException {

    public ServerErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServerErrorException(String message) {

        super(message);
    }
}
