package retrofit;

public abstract interface ErrorHandler {
    public static final ErrorHandler DEFAULT = new ErrorHandler
    .1();

    public abstract Throwable handleError(RetrofitError paramRetrofitError);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/retrofit/ErrorHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */