package twitter4j.internal.http;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;

import twitter4j.auth.Authorization;

public final class HttpRequest
        implements Serializable {
    private static final HttpParameter[] NULL_PARAMETERS = new HttpParameter[0];
    private static final long serialVersionUID = -3463594029098858381L;
    private final Authorization authorization;
    private final RequestMethod method;
    private final HttpParameter[] parameters;
    private Map<String, String> requestHeaders;
    private final String url;

    public HttpRequest(RequestMethod paramRequestMethod, String paramString, HttpParameter[] paramArrayOfHttpParameter, Authorization paramAuthorization, Map<String, String> paramMap) {
        this.method = paramRequestMethod;
        if ((paramRequestMethod != RequestMethod.POST) && (paramArrayOfHttpParameter != null) && (paramArrayOfHttpParameter.length != 0)) {
            this.url = (paramString + "?" + HttpParameter.encodeParameters(paramArrayOfHttpParameter));
        }
        for (this.parameters = NULL_PARAMETERS; ; this.parameters = paramArrayOfHttpParameter) {
            this.authorization = paramAuthorization;
            this.requestHeaders = paramMap;
            return;
            this.url = paramString;
        }
    }

    public boolean equals(Object paramObject) {
        if (this == paramObject) {
        }
        do {
            return true;
            if ((paramObject == null) || (getClass() != paramObject.getClass())) {
                return false;
            }
            paramObject = (HttpRequest) paramObject;
            if (this.authorization != null) {
                if (this.authorization.equals(((HttpRequest) paramObject).authorization)) {
                }
            } else {
                while (((HttpRequest) paramObject).authorization != null) {
                    return false;
                }
            }
            if (!Arrays.equals(this.parameters, ((HttpRequest) paramObject).parameters)) {
                return false;
            }
            if (this.requestHeaders != null) {
                if (this.requestHeaders.equals(((HttpRequest) paramObject).requestHeaders)) {
                }
            } else {
                while (((HttpRequest) paramObject).requestHeaders != null) {
                    return false;
                }
            }
            if (this.method != null) {
                if (this.method.equals(((HttpRequest) paramObject).method)) {
                }
            } else {
                while (((HttpRequest) paramObject).method != null) {
                    return false;
                }
            }
            if (this.url == null) {
                break;
            }
        } while (this.url.equals(((HttpRequest) paramObject).url));
        for (; ; ) {
            return false;
            if (((HttpRequest) paramObject).url == null) {
                break;
            }
        }
    }

    public Authorization getAuthorization() {
        return this.authorization;
    }

    public RequestMethod getMethod() {
        return this.method;
    }

    public HttpParameter[] getParameters() {
        return this.parameters;
    }

    public Map<String, String> getRequestHeaders() {
        return this.requestHeaders;
    }

    public String getURL() {
        return this.url;
    }

    public int hashCode() {
        int n = 0;
        int i;
        int j;
        label33:
        int k;
        if (this.method != null) {
            i = this.method.hashCode();
            if (this.url == null) {
                break label111;
            }
            j = this.url.hashCode();
            if (this.parameters == null) {
                break label116;
            }
            k = Arrays.hashCode(this.parameters);
            label48:
            if (this.authorization == null) {
                break label121;
            }
        }
        label111:
        label116:
        label121:
        for (int m = this.authorization.hashCode(); ; m = 0) {
            if (this.requestHeaders != null) {
                n = this.requestHeaders.hashCode();
            }
            return (((i * 31 + j) * 31 + k) * 31 + m) * 31 + n;
            i = 0;
            break;
            j = 0;
            break label33;
            k = 0;
            break label48;
        }
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder().append("HttpRequest{requestMethod=").append(this.method).append(", url='").append(this.url).append('\'').append(", postParams=");
        if (this.parameters == null) {
        }
        for (Object localObject = null; ; localObject = Arrays.asList(this.parameters)) {
            return localObject + ", authentication=" + this.authorization + ", requestHeaders=" + this.requestHeaders + '}';
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/twitter4j/internal/http/HttpRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */