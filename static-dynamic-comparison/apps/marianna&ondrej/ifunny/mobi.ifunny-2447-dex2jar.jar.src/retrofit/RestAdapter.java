package retrofit;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

import retrofit.client.Client.Provider;
import retrofit.client.Header;
import retrofit.client.Request;
import retrofit.client.Response;
import retrofit.converter.Converter;
import retrofit.mime.MimeUtil;
import retrofit.mime.TypedByteArray;
import retrofit.mime.TypedInput;
import retrofit.mime.TypedOutput;

public class RestAdapter {
    static final String IDLE_THREAD_NAME = "Retrofit-Idle";
    static final String THREAD_PREFIX = "Retrofit-";
    final Executor callbackExecutor;
    private final Client.Provider clientProvider;
    final Converter converter;
    final ErrorHandler errorHandler;
    final Executor httpExecutor;
    final RestAdapter.Log log;
    volatile RestAdapter.LogLevel logLevel;
    private final Profiler profiler;
    final RequestInterceptor requestInterceptor;
    private RxSupport rxSupport;
    final Endpoint server;
    private final Map<Class<?>, Map<Method, RestMethodInfo>> serviceMethodInfoCache = new LinkedHashMap();

    private RestAdapter(Endpoint paramEndpoint, Client.Provider paramProvider, Executor paramExecutor1, Executor paramExecutor2, RequestInterceptor paramRequestInterceptor, Converter paramConverter, Profiler paramProfiler, ErrorHandler paramErrorHandler, RestAdapter.Log paramLog, RestAdapter.LogLevel paramLogLevel) {
        this.server = paramEndpoint;
        this.clientProvider = paramProvider;
        this.httpExecutor = paramExecutor1;
        this.callbackExecutor = paramExecutor2;
        this.requestInterceptor = paramRequestInterceptor;
        this.converter = paramConverter;
        this.profiler = paramProfiler;
        this.errorHandler = paramErrorHandler;
        this.log = paramLog;
        this.logLevel = paramLogLevel;
    }

    static RestMethodInfo getMethodInfo(Map<Method, RestMethodInfo> paramMap, Method paramMethod) {
        try {
            RestMethodInfo localRestMethodInfo2 = (RestMethodInfo) paramMap.get(paramMethod);
            RestMethodInfo localRestMethodInfo1 = localRestMethodInfo2;
            if (localRestMethodInfo2 == null) {
                localRestMethodInfo1 = new RestMethodInfo(paramMethod);
                paramMap.put(paramMethod, localRestMethodInfo1);
            }
            return localRestMethodInfo1;
        } finally {
        }
    }

    private static Profiler.RequestInformation getRequestInfo(String paramString, RestMethodInfo paramRestMethodInfo, Request paramRequest) {
        long l = 0L;
        Object localObject = null;
        TypedOutput localTypedOutput = paramRequest.getBody();
        paramRequest = (Request) localObject;
        if (localTypedOutput != null) {
            l = localTypedOutput.length();
            paramRequest = localTypedOutput.mimeType();
        }
        return new Profiler.RequestInformation(paramRestMethodInfo.requestMethod, paramString, paramRestMethodInfo.requestUrl, l, paramRequest);
    }

    private Response logAndReplaceResponse(String paramString, Response paramResponse, long paramLong) {
        this.log.log(String.format("<--- HTTP %s %s (%sms)", new Object[]{Integer.valueOf(paramResponse.getStatus()), paramString, Long.valueOf(paramLong)}));
        paramString = paramResponse;
        if (this.logLevel.ordinal() >= RestAdapter.LogLevel.HEADERS.ordinal()) {
            paramString = paramResponse.getHeaders().iterator();
            Object localObject;
            while (paramString.hasNext()) {
                localObject = (Header) paramString.next();
                this.log.log(((Header) localObject).toString());
            }
            paramLong = 0L;
            TypedInput localTypedInput = paramResponse.getBody();
            paramString = paramResponse;
            if (localTypedInput != null) {
                paramLong = localTypedInput.length();
                paramString = paramResponse;
                if (this.logLevel.ordinal() >= RestAdapter.LogLevel.FULL.ordinal()) {
                    if (!paramResponse.getHeaders().isEmpty()) {
                        this.log.log("");
                    }
                    localObject = localTypedInput;
                    paramString = paramResponse;
                    if (!(localTypedInput instanceof TypedByteArray)) {
                        paramString = Utils.readBodyToBytesIfNecessary(paramResponse);
                        localObject = paramString.getBody();
                    }
                    paramResponse = ((TypedByteArray) localObject).getBytes();
                    paramLong = paramResponse.length;
                    localObject = MimeUtil.parseCharset(((TypedInput) localObject).mimeType());
                    this.log.log(new String(paramResponse, (String) localObject));
                }
            }
            this.log.log(String.format("<--- END HTTP (%s-byte body)", new Object[]{Long.valueOf(paramLong)}));
        }
        return paramString;
    }

    private void logResponseBody(TypedInput paramTypedInput, Object paramObject) {
        if (this.logLevel.ordinal() == RestAdapter.LogLevel.HEADERS_AND_ARGS.ordinal()) {
            this.log.log("<--- BODY:");
            this.log.log(paramObject.toString());
        }
    }

    public <T> T create(Class<T> paramClass) {
        Utils.validateServiceClass(paramClass);
        ClassLoader localClassLoader = paramClass.getClassLoader();
        RestAdapter.RestHandler localRestHandler = new RestAdapter.RestHandler(this, getMethodInfoCache(paramClass));
        return (T) Proxy.newProxyInstance(localClassLoader, new Class[]{paramClass}, localRestHandler);
    }

    public RestAdapter.LogLevel getLogLevel() {
        return this.logLevel;
    }

    Map<Method, RestMethodInfo> getMethodInfoCache(Class<?> paramClass) {
        synchronized (this.serviceMethodInfoCache) {
            Map localMap1 = (Map) this.serviceMethodInfoCache.get(paramClass);
            Object localObject = localMap1;
            if (localMap1 == null) {
                localObject = new LinkedHashMap();
                this.serviceMethodInfoCache.put(paramClass, localObject);
            }
            return (Map<Method, RestMethodInfo>) localObject;
        }
    }

    Request logAndReplaceRequest(String paramString, Request paramRequest, Object[] paramArrayOfObject) {
        this.log.log(String.format("---> %s %s %s", new Object[]{paramString, paramRequest.getMethod(), paramRequest.getUrl()}));
        Object localObject1 = paramRequest;
        Object localObject2;
        if (this.logLevel.ordinal() >= RestAdapter.LogLevel.HEADERS.ordinal()) {
            localObject1 = paramRequest.getHeaders().iterator();
            while (((Iterator) localObject1).hasNext()) {
                localObject2 = (Header) ((Iterator) localObject1).next();
                this.log.log(((Header) localObject2).toString());
            }
            localObject2 = "no";
            TypedOutput localTypedOutput = paramRequest.getBody();
            localObject1 = paramRequest;
            if (localTypedOutput != null) {
                localObject1 = localTypedOutput.mimeType();
                if (localObject1 != null) {
                    this.log.log("Content-Type: " + (String) localObject1);
                }
                long l = localTypedOutput.length();
                localObject1 = l + "-byte";
                if (l != -1L) {
                    this.log.log("Content-Length: " + l);
                }
                if (this.logLevel.ordinal() < RestAdapter.LogLevel.FULL.ordinal()) {
                    break label382;
                }
                if (!paramRequest.getHeaders().isEmpty()) {
                    this.log.log("");
                }
                localObject2 = localTypedOutput;
                paramArrayOfObject = paramRequest;
                if (!(localTypedOutput instanceof TypedByteArray)) {
                    paramArrayOfObject = Utils.readBodyToBytesIfNecessary(paramRequest);
                    localObject2 = paramArrayOfObject.getBody();
                }
                paramRequest = ((TypedByteArray) localObject2).getBytes();
                localObject2 = MimeUtil.parseCharset(((TypedOutput) localObject2).mimeType());
                this.log.log(new String(paramRequest, (String) localObject2));
                localObject2 = localObject1;
            }
        }
        for (localObject1 = paramArrayOfObject; ; localObject1 = paramRequest) {
            this.log.log(String.format("---> END %s (%s body)", new Object[]{paramString, localObject2}));
            return (Request) localObject1;
            label382:
            if (this.logLevel.ordinal() >= RestAdapter.LogLevel.HEADERS_AND_ARGS.ordinal()) {
                if (!paramRequest.getHeaders().isEmpty()) {
                    this.log.log("---> REQUEST:");
                }
                int i = 0;
                while (i < paramArrayOfObject.length) {
                    this.log.log("#" + i + ": " + paramArrayOfObject[i].toString());
                    i += 1;
                }
            }
            localObject2 = localObject1;
        }
    }

    void logException(Throwable paramThrowable, String paramString) {
        RestAdapter.Log localLog = this.log;
        if (paramString != null) {
        }
        for (; ; ) {
            localLog.log(String.format("---- ERROR %s", new Object[]{paramString}));
            paramString = new StringWriter();
            paramThrowable.printStackTrace(new PrintWriter(paramString));
            this.log.log(paramString.toString());
            this.log.log("---- END ERROR");
            return;
            paramString = "";
        }
    }

    public void setLogLevel(RestAdapter.LogLevel paramLogLevel) {
        if (this.logLevel == null) {
            throw new NullPointerException("Log level may not be null.");
        }
        this.logLevel = paramLogLevel;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/retrofit/RestAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */