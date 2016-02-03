package mobi.ifunny.rest.retrofit;

import android.content.Context;
import android.content.res.Resources;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;

import retrofit.Endpoint;
import retrofit.RestAdapter;
import retrofit.RestAdapter.Builder;
import retrofit.converter.Converter;

public class BaseRestAdapter {
    private BaseRestAdapter.RestAuthenticator authenticator;
    private Map<String, String> headers;
    private final RestAdapter restAdapter;

    private BaseRestAdapter(Context paramContext, Converter paramConverter, Endpoint paramEndpoint) {
        RestAdapter.Builder localBuilder = new RestAdapter.Builder();
        localBuilder.setClient(new BaseRestAdapter.TrustedUrlConnectionClient(this, createSSLSocketFactory(paramContext), null));
        localBuilder.setEndpoint(paramEndpoint);
        localBuilder.setRequestInterceptor(new BaseRestAdapter.BaseParamsInterceptor(this, null));
        if (paramConverter != null) {
            localBuilder.setConverter(paramConverter);
        }
        this.restAdapter = localBuilder.build();
        this.headers = new HashMap();
    }

    private SSLSocketFactory createSSLSocketFactory(Context paramContext) {
        try {
            Object localObject1 = CertificateFactory.getInstance("X.509");
            paramContext = new BufferedInputStream(paramContext.getResources().openRawResource(2131165184));
            try {
                localObject1 = ((CertificateFactory) localObject1).generateCertificate(paramContext);
                paramContext.close();
                paramContext = KeyStore.getInstance(KeyStore.getDefaultType());
                paramContext.load(null, null);
                paramContext.setCertificateEntry("ca", (Certificate) localObject1);
                localObject1 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                ((TrustManagerFactory) localObject1).init(paramContext);
                paramContext = SSLContext.getInstance("TLS");
                paramContext.init(null, ((TrustManagerFactory) localObject1).getTrustManagers(), null);
                return paramContext.getSocketFactory();
            } finally {
                paramContext.close();
            }
            return null;
        } catch (NoSuchAlgorithmException paramContext) {
            return null;
        } catch (CertificateException paramContext) {
            return null;
        } catch (IOException paramContext) {
            return null;
        } catch (KeyStoreException paramContext) {
            return null;
        } catch (KeyManagementException paramContext) {
        }
    }

    public <T> T create(Class<T> paramClass) {
        return (T) this.restAdapter.create(paramClass);
    }

    public void setAcceptHeader(String paramString) {
        this.headers.put("Accept", paramString);
    }

    public void setAuthenticator(BaseRestAdapter.RestAuthenticator paramRestAuthenticator) {
        this.authenticator = paramRestAuthenticator;
    }

    public void setHeader(String paramString1, String paramString2) {
        this.headers.put(paramString1, paramString2);
    }

    public void setUserAgent(String paramString) {
        this.headers.put("User-Agent", paramString);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/BaseRestAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */