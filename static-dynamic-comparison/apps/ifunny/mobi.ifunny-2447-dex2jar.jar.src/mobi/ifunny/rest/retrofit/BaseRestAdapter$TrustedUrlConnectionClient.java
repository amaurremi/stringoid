package mobi.ifunny.rest.retrofit;

import java.net.HttpURLConnection;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSocketFactory;

import retrofit.client.Request;
import retrofit.client.Response;
import retrofit.client.UrlConnectionClient;

class BaseRestAdapter$TrustedUrlConnectionClient
        extends UrlConnectionClient {
    private SSLSocketFactory socketFactory;
    private boolean useDefaultSSLSocketFactory;

    private BaseRestAdapter$TrustedUrlConnectionClient(BaseRestAdapter paramBaseRestAdapter, SSLSocketFactory paramSSLSocketFactory) {
        this.socketFactory = paramSSLSocketFactory;
        this.useDefaultSSLSocketFactory = true;
    }

    public Response execute(Request paramRequest) {
        try {
            paramRequest = super.execute(paramRequest);
            return paramRequest;
        } catch (Exception paramRequest) {
            if ((paramRequest instanceof SSLException)) {
                this.useDefaultSSLSocketFactory = false;
            }
            throw new RuntimeException(paramRequest);
        }
    }

    protected HttpURLConnection openConnection(Request paramRequest) {
        paramRequest = super.openConnection(paramRequest);
        if ((!this.useDefaultSSLSocketFactory) && ((paramRequest instanceof HttpsURLConnection))) {
            ((HttpsURLConnection) paramRequest).setSSLSocketFactory(this.socketFactory);
        }
        return paramRequest;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/BaseRestAdapter$TrustedUrlConnectionClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */