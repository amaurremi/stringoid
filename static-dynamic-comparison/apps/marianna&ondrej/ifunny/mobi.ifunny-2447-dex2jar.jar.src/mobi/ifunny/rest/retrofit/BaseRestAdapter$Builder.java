package mobi.ifunny.rest.retrofit;

import android.content.Context;
import retrofit.Endpoint;
import retrofit.converter.Converter;

public class BaseRestAdapter$Builder {
    private String acceptHeader;
    private BaseRestAdapter.RestAuthenticator authenticator;
    private Context context;
    private Converter converter;
    private Endpoint endpoint;
    private String userAgent;

    public BaseRestAdapter$Builder(Context paramContext) {
        this.context = paramContext;
    }

    public BaseRestAdapter build() {
        BaseRestAdapter localBaseRestAdapter = new BaseRestAdapter(this.context, this.converter, this.endpoint, null);
        localBaseRestAdapter.setUserAgent(this.userAgent);
        localBaseRestAdapter.setAuthenticator(this.authenticator);
        localBaseRestAdapter.setAcceptHeader(this.acceptHeader);
        return localBaseRestAdapter;
    }

    public Builder setAcceptHeader(String paramString) {
        this.acceptHeader = paramString;
        return this;
    }

    public Builder setAuthenticator(BaseRestAdapter.RestAuthenticator paramRestAuthenticator) {
        this.authenticator = paramRestAuthenticator;
        return this;
    }

    public Builder setConverter(Converter paramConverter) {
        this.converter = paramConverter;
        return this;
    }

    public Builder setEndpoint(Endpoint paramEndpoint) {
        this.endpoint = paramEndpoint;
        return this;
    }

    public Builder setUserAgent(String paramString) {
        this.userAgent = paramString;
        return this;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/BaseRestAdapter$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */