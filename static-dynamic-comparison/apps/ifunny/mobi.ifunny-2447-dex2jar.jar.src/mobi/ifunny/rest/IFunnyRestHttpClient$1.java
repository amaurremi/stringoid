package mobi.ifunny.rest;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.protocol.HttpContext;

final class IFunnyRestHttpClient$1
        implements HttpRequestInterceptor {
    public void process(HttpRequest paramHttpRequest, HttpContext paramHttpContext) {
        if (!paramHttpRequest.containsHeader("Accept-Encoding")) {
            paramHttpRequest.addHeader("Accept-Encoding", "gzip");
        }
        paramHttpContext = IFunnyRestHttpClient.access$000().keySet().iterator();
        while (paramHttpContext.hasNext()) {
            String str = (String) paramHttpContext.next();
            paramHttpRequest.addHeader(str, (String) IFunnyRestHttpClient.access$000().get(str));
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/IFunnyRestHttpClient$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */