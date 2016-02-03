package retrofit;

import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.subscriptions.Subscriptions;

class RxSupport$1
        implements Observable.OnSubscribe<Object> {
    RxSupport$1(RxSupport paramRxSupport, RxSupport.Invoker paramInvoker) {
    }

    public void call(Subscriber<? super Object> paramSubscriber) {
        Object localObject = new RequestInterceptorTape();
        RxSupport.access$000(this.this$0).intercept((RequestInterceptor.RequestFacade) localObject);
        localObject = new FutureTask(RxSupport.access$100(this.this$0, paramSubscriber, this.val$invoker, (RequestInterceptorTape) localObject), null);
        paramSubscriber.add(Subscriptions.from((Future) localObject));
        RxSupport.access$200(this.this$0).execute((Runnable) localObject);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/retrofit/RxSupport$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */