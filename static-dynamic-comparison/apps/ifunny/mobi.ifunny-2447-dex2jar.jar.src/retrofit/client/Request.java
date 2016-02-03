package retrofit.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit.mime.TypedOutput;

public final class Request {
    private final TypedOutput body;
    private final List<Header> headers;
    private final String method;
    private final String url;

    public Request(String paramString1, String paramString2, List<Header> paramList, TypedOutput paramTypedOutput) {
        if (paramString1 == null) {
            throw new NullPointerException("Method must not be null.");
        }
        if (paramString2 == null) {
            throw new NullPointerException("URL must not be null.");
        }
        this.method = paramString1;
        this.url = paramString2;
        if (paramList == null) {
        }
        for (this.headers = Collections.emptyList(); ; this.headers = Collections.unmodifiableList(new ArrayList(paramList))) {
            this.body = paramTypedOutput;
            return;
        }
    }

    public TypedOutput getBody() {
        return this.body;
    }

    public List<Header> getHeaders() {
        return this.headers;
    }

    public String getMethod() {
        return this.method;
    }

    public String getUrl() {
        return this.url;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/retrofit/client/Request.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */