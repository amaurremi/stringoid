package retrofit;

import rx.Subscriber;

class RxSupport$2
        implements Runnable {
    RxSupport$2(RxSupport paramRxSupport, Subscriber paramSubscriber, RxSupport.Invoker paramInvoker, RequestInterceptorTape paramRequestInterceptorTape) {
    }

    public void run() {
        try {
            if (this.val$subscriber.isUnsubscribed()) {
                return;
            }
            ResponseWrapper localResponseWrapper = this.val$invoker.invoke(this.val$interceptorTape);
            this.val$subscriber.onNext(localResponseWrapper.responseBody);
            this.val$subscriber.onCompleted();
            return;
        } catch (RetrofitError localRetrofitError) {
            this.val$subscriber.onError(RxSupport.access$300(this.this$0).handleError(localRetrofitError));
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/retrofit/RxSupport$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */