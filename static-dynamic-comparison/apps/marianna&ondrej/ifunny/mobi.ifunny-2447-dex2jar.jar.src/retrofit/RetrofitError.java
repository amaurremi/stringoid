package retrofit;

import java.io.IOException;
import java.lang.reflect.Type;

import retrofit.client.Response;
import retrofit.converter.ConversionException;
import retrofit.converter.Converter;
import retrofit.mime.TypedInput;

public class RetrofitError
        extends RuntimeException {
    private final Converter converter;
    private final RetrofitError.Kind kind;
    private final Response response;
    private final Type successType;
    private final String url;

    RetrofitError(String paramString1, String paramString2, Response paramResponse, Converter paramConverter, Type paramType, RetrofitError.Kind paramKind, Throwable paramThrowable) {
        super(paramString1, paramThrowable);
        this.url = paramString2;
        this.response = paramResponse;
        this.converter = paramConverter;
        this.successType = paramType;
        this.kind = paramKind;
    }

    public static RetrofitError conversionError(String paramString, Response paramResponse, Converter paramConverter, Type paramType, ConversionException paramConversionException) {
        return new RetrofitError(paramConversionException.getMessage(), paramString, paramResponse, paramConverter, paramType, RetrofitError.Kind.CONVERSION, paramConversionException);
    }

    public static RetrofitError httpError(String paramString, Response paramResponse, Converter paramConverter, Type paramType) {
        return new RetrofitError(paramResponse.getStatus() + " " + paramResponse.getReason(), paramString, paramResponse, paramConverter, paramType, RetrofitError.Kind.HTTP, null);
    }

    public static RetrofitError networkError(String paramString, IOException paramIOException) {
        return new RetrofitError(paramIOException.getMessage(), paramString, null, null, null, RetrofitError.Kind.NETWORK, paramIOException);
    }

    public static RetrofitError unexpectedError(String paramString, Throwable paramThrowable) {
        return new RetrofitError(paramThrowable.getMessage(), paramString, null, null, null, RetrofitError.Kind.UNEXPECTED, paramThrowable);
    }

    public Object getBody() {
        return getBodyAs(this.successType);
    }

    public Object getBodyAs(Type paramType) {
        if (this.response == null) {
        }
        TypedInput localTypedInput;
        do {
            return null;
            localTypedInput = this.response.getBody();
        } while (localTypedInput == null);
        try {
            paramType = this.converter.fromBody(localTypedInput, paramType);
            return paramType;
        } catch (ConversionException paramType) {
            throw new RuntimeException(paramType);
        }
    }

    public RetrofitError.Kind getKind() {
        return this.kind;
    }

    public Response getResponse() {
        return this.response;
    }

    public Type getSuccessType() {
        return this.successType;
    }

    public String getUrl() {
        return this.url;
    }

    @Deprecated
    public boolean isNetworkError() {
        return this.kind == RetrofitError.Kind.NETWORK;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/retrofit/RetrofitError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */