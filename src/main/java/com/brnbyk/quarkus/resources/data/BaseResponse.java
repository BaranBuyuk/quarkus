package com.brnbyk.quarkus.resources.data;

/**
 * Username = baranbuyuk
 * Date = 18.09.2019 14:49
 **/
public class BaseResponse<T> {

    private T data;
    private ResourceError resourceError;


    public BaseResponse() {
    }

    public BaseResponse(ResourceError resourceError) {
        this.resourceError = resourceError;
    }

    public BaseResponse(T data) {
        this.data = data;
    }

    public BaseResponse(T data, ResourceError resourceError) {
        this.data = data;
        this.resourceError = resourceError;
    }

    public BaseResponse<T> addResourceError(ResourceError resourceError) {
        this.resourceError = resourceError;
        return this;
    }

    public void addData(T data) {
        this.data = data;
    }

}
