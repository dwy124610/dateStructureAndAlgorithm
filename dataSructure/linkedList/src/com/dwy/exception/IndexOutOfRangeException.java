package com.dwy.exception;

/**
 * @Author: DongWenYu
 * @Date: 2021/6/14 20:40
 */
public class IndexOutOfRangeException extends Exception{

    public IndexOutOfRangeException(String message) {
        super(message);
    }

    public IndexOutOfRangeException() {
        super("indexOutOfRange");
    }
}
