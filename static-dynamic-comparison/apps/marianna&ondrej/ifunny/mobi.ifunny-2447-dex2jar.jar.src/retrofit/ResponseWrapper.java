package retrofit;

import retrofit.client.Response;

final class ResponseWrapper {
    final Response response;
    final Object responseBody;

    ResponseWrapper(Response paramResponse, Object paramObject) {
        this.response = paramResponse;
        this.responseBody = paramObject;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/retrofit/ResponseWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */