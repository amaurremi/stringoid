package twitter4j;

import java.net.Authenticator;
import java.net.Authenticator.RequestorType;
import java.net.PasswordAuthentication;

class HttpClientImpl$1
        extends Authenticator {
    HttpClientImpl$1(HttpClientImpl paramHttpClientImpl) {
    }

    protected PasswordAuthentication getPasswordAuthentication() {
        if (getRequestorType().equals(Authenticator.RequestorType.PROXY)) {
            return new PasswordAuthentication(this.this$0.CONF.getHttpProxyUser(), this.this$0.CONF.getHttpProxyPassword().toCharArray());
        }
        return null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/HttpClientImpl$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */