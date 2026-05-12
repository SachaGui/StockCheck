package com.ala.stockcheck.common;

public class Result<T> {

    /**
     * ステータスコード
     */
    private Integer code;

    /**
     * メッセージ
     */
    private String message;

    /**
     * レスポンスデータ
     */
    private T data;

    /**
     * 成功レスポンス（データあり）
     */
    public static <T> Result<T> success(T data) {

        Result<T> result = new Result<>();

        result.setCode(200);

        result.setMessage("success");

        result.setData(data);

        return result;
    }

    /**
     * 成功レスポンス（データなし）
     */
    public static <T> Result<T> success() {

        Result<T> result = new Result<>();

        result.setCode(200);

        result.setMessage("success");

        return result;
    }

    /**
     * 失敗レスポンス
     */
    public static <T> Result<T> fail(String message) {

        Result<T> result = new Result<>();

        result.setCode(500);

        result.setMessage(message);

        return result;
    }

    /**
     * 任意のステータスコードによる失敗レスポンス
     */
    public static <T> Result<T> fail(Integer code, String message) {

        Result<T> result = new Result<>();

        result.setCode(code);

        result.setMessage(message);

        return result;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}