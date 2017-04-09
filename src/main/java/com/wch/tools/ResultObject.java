package com.wch.tools;

import org.springframework.transaction.SavepointManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.sql.Savepoint;

/**
 * 通过该类可以手动的控制事务的相关事务
 * Created by SL131 on 2017/4/3.
 */
public class ResultObject<T> {

    private String errorCode;

    private String errorMessage;

    private boolean success = true;

    private Savepoint savePoint;

    private  T  content;

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public String getErrorCode() {
        return errorCode;
    }

    /**
     * 设置事务回滚
     * @param errorCode 错误码
     */
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
        TransactionStatus status = TransactionAspectSupport.currentTransactionStatus();
        if (status.hasSavepoint())  {
            status.rollbackToSavepoint(savePoint);
        }
        else {
            status.setRollbackOnly();
        }
    }

    /**
     * 设置错误码和错误信息
     * @param errorCode 错误码
     * @param errorMessage 错误信息
     */
    public void setErrorCode(String errorCode, String errorMessage) {
        this.setErrorCode(errorCode);
        this.errorMessage  = errorMessage;
    }

    /**
     * 设置事务保存点
     */
    public void setSavePoint() {
        TransactionStatus status = TransactionAspectSupport.currentTransactionStatus();
        if (status.hasSavepoint()) {
            status.releaseSavepoint(savePoint);
        }
        savePoint = (Savepoint) status.createSavepoint();
    }

    /**
     * 取消所有事务保存点， 可以一键回滚所有操作
     */
    public void releaseSavepoint() {
        TransactionStatus status = TransactionAspectSupport.currentTransactionStatus();
        if (status.hasSavepoint()) {
            status.releaseSavepoint(savePoint);
        }
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean isFailed() {
        return !this.success;
    }
}
