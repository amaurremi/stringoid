package mobi.ifunny.rest;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.protocol.HttpContext;

final class IFunnyRestHttpClient$2
        implements HttpResponseInterceptor {
    public void process(HttpResponse paramHttpResponse, HttpContext paramHttpContext) {
        paramHttpContext = paramHttpResponse.getEntity();
        if (paramHttpContext == null) {
        }
        for (; ; ) {
            return;
            paramHttpContext = paramHttpContext.getContentEncoding();
            if (paramHttpContext != null) {
                paramHttpContext = paramHttpContext.getElements();
                int j = paramHttpContext.length;
                int i = 0;
                while (i < j) {
                    if (paramHttpContext[i].getName().equalsIgnoreCase("gzip")) {
                        paramHttpResponse.setEntity(new IFunnyRestHttpClient.InflatingEntity(paramHttpResponse.getEntity()));
                        return;
                    }
                    i += 1;
                }
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/IFunnyRestHttpClient$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */