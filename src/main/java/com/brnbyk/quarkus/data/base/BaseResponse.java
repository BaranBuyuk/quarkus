package com.brnbyk.quarkus.data.base;

import io.quarkus.runtime.annotations.RegisterForReflection;

import java.io.Serializable;

/**
 * Username = baranbuyuk
 * Date = 18.09.2019 14:49
 **/
@RegisterForReflection
public class BaseResponse<T> implements Serializable {

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

    public void addResourceError(ResourceError resourceError) {
        this.resourceError = resourceError;
    }

    public void addData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ResourceError getResourceError() {
        return resourceError;
    }

    public void setResourceError(ResourceError resourceError) {
        this.resourceError = resourceError;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseResponse)) return false;

        BaseResponse<?> that = (BaseResponse<?>) o;

        if (getData() != null ? !getData().equals(that.getData()) : that.getData() != null) return false;
        return getResourceError() != null ? getResourceError().equals(that.getResourceError()) : that.getResourceError() == null;
    }

    @Override
    public int hashCode() {
        int result = getData() != null ? getData().hashCode() : 0;
        result = 31 * result + (getResourceError() != null ? getResourceError().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "data=" + data +
                ", resourceError=" + resourceError +
                '}';
    }
}
