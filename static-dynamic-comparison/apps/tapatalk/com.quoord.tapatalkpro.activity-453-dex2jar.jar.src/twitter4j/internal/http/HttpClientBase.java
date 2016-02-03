package twitter4j.internal.http;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;

import twitter4j.internal.logging.Logger;

public abstract class HttpClientBase
        implements HttpClient, Serializable {
    private static final Logger logger = Logger.getLogger(HttpClientBase.class);
    private static final long serialVersionUID = 6944924907755685265L;
    protected final HttpClientConfiguration CONF;

    public HttpClientBase(HttpClientConfiguration paramHttpClientConfiguration) {
        this.CONF = paramHttpClientConfiguration;
    }

    public boolean equals(Object paramObject) {
        if (this == paramObject) {
        }
        do {
            return true;
            if (!(paramObject instanceof HttpClientBase)) {
                return false;
            }
            paramObject = (HttpClientBase) paramObject;
        } while (this.CONF.equals(((HttpClientBase) paramObject).CONF));
        return false;
    }

    public int hashCode() {
        return this.CONF.hashCode();
    }

    protected boolean isProxyConfigured() {
        return (this.CONF.getHttpProxyHost() != null) && (!this.CONF.getHttpProxyHost().equals(""));
    }

    public void shutdown() {
    }

    public String toString() {
        return "HttpClientBase{CONF=" + this.CONF + '}';
    }

    public void write(DataOutputStream paramDataOutputStream, String paramString)
            throws IOException {
        paramDataOutputStream.writeBytes(paramString);
        logger.debug(paramString);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/twitter4j/internal/http/HttpClientBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */