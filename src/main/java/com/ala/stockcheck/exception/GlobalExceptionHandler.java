package com.ala.stockcheck.exception;

import com.ala.stockcheck.common.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * グローバル例外ハンドラー
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 業務例外処理
     *
     * @param e 業務例外
     * @return エラーレスポンス
     */
    @ExceptionHandler(BusinessException.class)
    public Result<String> handleBusinessException(BusinessException e) {

        return Result.fail(e.getMessage());
    }

    /**
     * システム例外処理
     *
     * @param e システム例外
     * @return エラーレスポンス
     */
    @ExceptionHandler(Exception.class)
    public Result<String> handleException(Exception e) {

        e.printStackTrace();

        return Result.fail("システムエラーが発生しました");
    }
}