package twitter4j;

import java.util.concurrent.ExecutorService;

class DispatcherImpl$2
        extends Thread {
    DispatcherImpl$2(DispatcherImpl paramDispatcherImpl) {
    }

    public void run() {
        DispatcherImpl.access$000(this.this$0).shutdown();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/DispatcherImpl$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */