package mobi.ifunny.rest.retrofit;

import mobi.ifunny.rest.content.RestError;

public abstract interface RestHttpHandler<R, T> {
    public abstract void onCancelCallback(T paramT);

    public abstract void onExceptionCallback(T paramT, Throwable paramThrowable);

    public abstract void onFailureCallback(T paramT, RestError paramRestError);

    public abstract void onFinishCallback(T paramT);

    public abstract void onProgressCallback(T paramT, int paramInt);

    public abstract void onStartCallback(T paramT);

    public abstract void onSuccessCallback(T paramT, R paramR);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/RestHttpHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */