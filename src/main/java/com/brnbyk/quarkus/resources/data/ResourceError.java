package com.brnbyk.quarkus.resources.data;

/**
 * Username = baranbuyuk
 * Date = 18.09.2019 14:49
 **/
public class ResourceError {

    private String errorMessage;
    private String errorCode;


    public static final class ResourceErrorBuilder {
        private String errorMessage;
        private String errorCode;

        private ResourceErrorBuilder() {
        }

        public static ResourceErrorBuilder builder() {
            return new ResourceErrorBuilder();
        }

        public ResourceErrorBuilder withErrorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
            return this;
        }

        public ResourceErrorBuilder withErrorCode(String errorCode) {
            this.errorCode = errorCode;
            return this;
        }

        public ResourceError build() {
            ResourceError resourceError = new ResourceError();
            resourceError.errorCode = this.errorCode;
            resourceError.errorMessage = this.errorMessage;
            return resourceError;
        }
    }
}
