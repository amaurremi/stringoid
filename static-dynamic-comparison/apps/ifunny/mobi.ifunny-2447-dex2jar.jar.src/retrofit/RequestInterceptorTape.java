package retrofit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class RequestInterceptorTape
        implements RequestInterceptor, RequestInterceptor.RequestFacade {
    private final List<RequestInterceptorTape.CommandWithParams> tape = new ArrayList();

    public void addEncodedPathParam(String paramString1, String paramString2) {
        this.tape.add(new RequestInterceptorTape.CommandWithParams(RequestInterceptorTape.Command.ADD_ENCODED_PATH_PARAM, paramString1, paramString2));
    }

    public void addEncodedQueryParam(String paramString1, String paramString2) {
        this.tape.add(new RequestInterceptorTape.CommandWithParams(RequestInterceptorTape.Command.ADD_ENCODED_QUERY_PARAM, paramString1, paramString2));
    }

    public void addHeader(String paramString1, String paramString2) {
        this.tape.add(new RequestInterceptorTape.CommandWithParams(RequestInterceptorTape.Command.ADD_HEADER, paramString1, paramString2));
    }

    public void addPathParam(String paramString1, String paramString2) {
        this.tape.add(new RequestInterceptorTape.CommandWithParams(RequestInterceptorTape.Command.ADD_PATH_PARAM, paramString1, paramString2));
    }

    public void addQueryParam(String paramString1, String paramString2) {
        this.tape.add(new RequestInterceptorTape.CommandWithParams(RequestInterceptorTape.Command.ADD_QUERY_PARAM, paramString1, paramString2));
    }

    public void intercept(RequestInterceptor.RequestFacade paramRequestFacade) {
        Iterator localIterator = this.tape.iterator();
        while (localIterator.hasNext()) {
            RequestInterceptorTape.CommandWithParams localCommandWithParams = (RequestInterceptorTape.CommandWithParams) localIterator.next();
            localCommandWithParams.command.intercept(paramRequestFacade, localCommandWithParams.name, localCommandWithParams.value);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/retrofit/RequestInterceptorTape.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */