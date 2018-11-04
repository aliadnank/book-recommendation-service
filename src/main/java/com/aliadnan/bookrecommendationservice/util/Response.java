package com.aliadnan.bookrecommendationservice.util;

/**
 * @author Ali
 * @createdOn 2018/10/28
 *<pre> Primary object to send the response back to the client</pre>
 */
public class Response<T> {

    /*
     * Immutable result object, type is required on runtime
     */
    private final T result;

    private final Status status;

    public Response(T result, Status status) {
        this.result = result;
        this.status = status;
    }

    public T getResult() {
        return result;
    }

    public enum Status {
        SUCCESS, FAILURE;
    }

    @Override
    public String toString() {
        return "Response{" +
                "result=" + result +
                ", status=" + status +
                '}';
    }
}
