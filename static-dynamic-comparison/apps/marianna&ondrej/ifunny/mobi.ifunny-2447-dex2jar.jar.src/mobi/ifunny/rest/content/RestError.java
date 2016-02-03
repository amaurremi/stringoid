package mobi.ifunny.rest.content;

import java.io.IOException;

import retrofit.RetrofitError;
import retrofit.RetrofitError.Kind;
import retrofit.client.Response;

public class RestError {
    public static final String ALREADY_SMILED = "already_smiled";
    public static final String ALREADY_UNSMILED = "already_unsmiled";
    public static final String CONTENT_WAS_DELETED = "content_was_deleted";
    public static final String ENTITY_ABUSED = "entity_abused";
    public static final String NOT_SMILED = "not_smiled";
    public static final String NOT_UNSMILED = "not_unsmiled";
    public static final String ROOT_COMMENT_WAS_DELETED = "root_comment_was_deleted";
    private Throwable cause;
    public int code;
    public String error;
    private RetrofitError.Kind errorKind;
    public String errorMessage;
    public int status;

    private RestError(int paramInt, String paramString) {
        this.status = paramInt;
        this.error = paramString;
    }

    private RestError(Class<? extends RestError.RestErrorProxy> paramClass, RetrofitError paramRetrofitError) {
        this.cause = paramRetrofitError;
        parseRetrofitError(paramClass, paramRetrofitError);
    }

    private RestError(Throwable paramThrowable) {
        this.cause = paramThrowable;
        if ((paramThrowable instanceof IOException)) {
            this.errorKind = RetrofitError.Kind.NETWORK;
            return;
        }
        this.errorKind = RetrofitError.Kind.UNEXPECTED;
    }

    public static RestError conversionError(Throwable paramThrowable) {
        paramThrowable = new RestError(paramThrowable);
        paramThrowable.errorKind = RetrofitError.Kind.CONVERSION;
        return paramThrowable;
    }

    public static RestError httpError(int paramInt, String paramString) {
        return new RestError(paramInt, paramString);
    }

    private void parseRetrofitError(Class<? extends RestError.RestErrorProxy> paramClass, RetrofitError paramRetrofitError) {
        this.errorKind = paramRetrofitError.getKind();
        switch (RestError .1.$SwitchMap$retrofit$RetrofitError$Kind[this.errorKind.ordinal()])
        {
        }
        do {
            return;
            Response localResponse = paramRetrofitError.getResponse();
            this.error = localResponse.getReason();
            this.status = localResponse.getStatus();
        } while (paramClass == null);
        try {
            paramClass = (RestError.RestErrorProxy) paramRetrofitError.getBodyAs(paramClass);
            this.code = paramClass.getCode();
            this.error = paramClass.getError();
            this.errorMessage = paramClass.getErrorMessage();
            return;
        } catch (Exception paramClass) {
        }
    }

    public static RestError retrofitError(Class<? extends RestError.RestErrorProxy> paramClass, RetrofitError paramRetrofitError) {
        return new RestError(paramClass, paramRetrofitError);
    }

    public static RestError unexpectedError(Throwable paramThrowable) {
        return new RestError(paramThrowable);
    }

    public Throwable getCause() {
        return this.cause;
    }

    public RetrofitError.Kind getErrorKind() {
        return this.errorKind;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/RestError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */