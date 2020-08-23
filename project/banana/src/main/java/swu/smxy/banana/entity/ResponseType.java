/*
 * @Date: 2020-08-22 11:50:54
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-08-22 11:52:54
 */
package swu.smxy.banana.entity;

import java.io.Serializable;

public class ResponseType<T> implements Serializable
{
    private int status;
    private String message;
    private T data;

    /**
     * @return int return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @return String return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return T return the data
     */
    public T getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(T data) {
        this.data = data;
    }

}