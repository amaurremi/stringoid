package retrofit;

import java.util.concurrent.Executor;

import retrofit.client.Client;
import retrofit.client.Client.Provider;
import retrofit.converter.Converter;

public class RestAdapter$Builder {
    private Executor callbackExecutor;
    private Client.Provider clientProvider;
    private Converter converter;
    private Endpoint endpoint;
    private ErrorHandler errorHandler;
    private Executor httpExecutor;
    private RestAdapter.Log log;
    private RestAdapter.LogLevel logLevel = RestAdapter.LogLevel.NONE;
    private Profiler profiler;
    private RequestInterceptor requestInterceptor;

    private void ensureSaneDefaults() {
        if (this.converter == null) {
            this.converter = Platform.get().defaultConverter();
        }
        if (this.clientProvider == null) {
            this.clientProvider = Platform.get().defaultClient();
        }
        if (this.httpExecutor == null) {
            this.httpExecutor = Platform.get().defaultHttpExecutor();
        }
        if (this.callbackExecutor == null) {
            this.callbackExecutor = Platform.get().defaultCallbackExecutor();
        }
        if (this.errorHandler == null) {
            this.errorHandler = ErrorHandler.DEFAULT;
        }
        if (this.log == null) {
            this.log = Platform.get().defaultLog();
        }
        if (this.requestInterceptor == null) {
            this.requestInterceptor = RequestInterceptor.NONE;
        }
    }

    public RestAdapter build() {
        if (this.endpoint == null) {
            throw new IllegalArgumentException("Endpoint may not be null.");
        }
        ensureSaneDefaults();
        return new RestAdapter(this.endpoint, this.clientProvider, this.httpExecutor, this.callbackExecutor, this.requestInterceptor, this.converter, this.profiler, this.errorHandler, this.log, this.logLevel, null);
    }

    public Builder setClient(Client.Provider paramProvider) {
        if (paramProvider == null) {
            throw new NullPointerException("Client provider may not be null.");
        }
        this.clientProvider = paramProvider;
        return this;
    }

    public Builder setClient(Client paramClient) {
        if (paramClient == null) {
            throw new NullPointerException("Client may not be null.");
        }
        return setClient(new RestAdapter.Builder .1 (this, paramClient));
    }

    public Builder setConverter(Converter paramConverter) {
        if (paramConverter == null) {
            throw new NullPointerException("Converter may not be null.");
        }
        this.converter = paramConverter;
        return this;
    }

    public Builder setEndpoint(String paramString) {
        if ((paramString == null) || (paramString.trim().length() == 0)) {
            throw new NullPointerException("Endpoint may not be blank.");
        }
        this.endpoint = Endpoints.newFixedEndpoint(paramString);
        return this;
    }

    public Builder setEndpoint(Endpoint paramEndpoint) {
        if (paramEndpoint == null) {
            throw new NullPointerException("Endpoint may not be null.");
        }
        this.endpoint = paramEndpoint;
        return this;
    }

    public Builder setErrorHandler(ErrorHandler paramErrorHandler) {
        if (paramErrorHandler == null) {
            throw new NullPointerException("Error handler may not be null.");
        }
        this.errorHandler = paramErrorHandler;
        return this;
    }

    public Builder setExecutors(Executor paramExecutor1, Executor paramExecutor2) {
        if (paramExecutor1 == null) {
            throw new NullPointerException("HTTP executor may not be null.");
        }
        Object localObject = paramExecutor2;
        if (paramExecutor2 == null) {
            localObject = new Utils.SynchronousExecutor();
        }
        this.httpExecutor = paramExecutor1;
        this.callbackExecutor = ((Executor) localObject);
        return this;
    }

    public Builder setLog(RestAdapter.Log paramLog) {
        if (paramLog == null) {
            throw new NullPointerException("Log may not be null.");
        }
        this.log = paramLog;
        return this;
    }

    public Builder setLogLevel(RestAdapter.LogLevel paramLogLevel) {
        if (paramLogLevel == null) {
            throw new NullPointerException("Log level may not be null.");
        }
        this.logLevel = paramLogLevel;
        return this;
    }

    public Builder setProfiler(Profiler paramProfiler) {
        if (paramProfiler == null) {
            throw new NullPointerException("Profiler may not be null.");
        }
        this.profiler = paramProfiler;
        return this;
    }

    public Builder setRequestInterceptor(RequestInterceptor paramRequestInterceptor) {
        if (paramRequestInterceptor == null) {
            throw new NullPointerException("Request interceptor may not be null.");
        }
        this.requestInterceptor = paramRequestInterceptor;
        return this;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/retrofit/RestAdapter$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */