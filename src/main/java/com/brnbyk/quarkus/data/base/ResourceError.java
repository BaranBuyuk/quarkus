package com.brnbyk.quarkus.data.base;

import java.io.Serializable;

/**
 * Username = baranbuyuk
 * Date = 18.09.2019 14:49
 **/
public class ResourceError implements Serializable {

    private static final long serialVersionUID = 4269834219970196789L;

    private String errorMessage;
    private String errorCode;


    public ResourceError() {

    }

    public ResourceError(String errorMessage, String errorCode) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResourceError)) return false;

        ResourceError that = (ResourceError) o;

        if (getErrorMessage() != null ? !getErrorMessage().equals(that.getErrorMessage()) : that.getErrorMessage() != null)
            return false;
        return getErrorCode() != null ? getErrorCode().equals(that.getErrorCode()) : that.getErrorCode() == null;
    }

    @Override
    public int hashCode() {
        int result = getErrorMessage() != null ? getErrorMessage().hashCode() : 0;
        result = 31 * result + (getErrorCode() != null ? getErrorCode().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ResourceError{" +
                "errorMessage='" + errorMessage + '\'' +
                ", errorCode='" + errorCode + '\'' +
                '}';
    }
}
