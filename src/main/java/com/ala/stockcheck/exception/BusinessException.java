package com.ala.stockcheck.exception;

/**
 * 業務例外クラス
 */
public class BusinessException extends RuntimeException {

    /**
     * コンストラクタ
     *
     * @param message エラーメッセージ
     */
    public BusinessException(String message) {
        super(message);
    }
}