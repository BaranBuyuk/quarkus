package com.brnbyk.quarkus;

import com.brnbyk.quarkus.data.BaseResponse;

import javax.ws.rs.core.Response;

/**
 * Username = baranbuyuk
 * Date = 19.09.2019 10:43
 **/
public final class ProcessResourceResult {

    private ProcessResourceResult() {
    }

    public static <T extends BaseResponse> Response ok(T data) {
        return responseWithStatus(data, Response.Status.OK);
    }

    public static <T extends BaseResponse> Response responseWithStatus(T data, Response.Status status) {
        return Response.status(status).entity(data).build();
    }
}
