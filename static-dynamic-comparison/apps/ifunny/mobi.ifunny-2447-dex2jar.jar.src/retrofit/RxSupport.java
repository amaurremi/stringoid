package retrofit;

import java.util.concurrent.Executor;

import rx.Observable;
import rx.Subscriber;

final class RxSupport {
    private final ErrorHandler errorHandler;
    private final Executor executor;
    private final RequestInterceptor requestInterceptor;

    RxSupport(Executor paramExecutor, ErrorHandler paramErrorHandler, RequestInterceptor paramRequestInterceptor) {
        this.executor = paramExecutor;
        this.errorHandler = paramErrorHandler;
        this.requestInterceptor = paramRequestInterceptor;
    }

    private Runnable getRunnable(Subscriber<? super Object> paramSubscriber, RxSupport.Invoker paramInvoker, RequestInterceptorTape paramRequestInterceptorTape) {
        return new RxSupport .2 (this, paramSubscriber, paramInvoker, paramRequestInterceptorTape);
    }

    Observable createRequestObservable(RxSupport.Invoker paramInvoker) {
        return Observable.create(new RxSupport .1 (this, paramInvoker));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/retrofit/RxSupport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */