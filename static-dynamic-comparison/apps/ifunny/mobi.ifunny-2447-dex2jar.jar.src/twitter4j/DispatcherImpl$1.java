package twitter4j;

import java.util.concurrent.ThreadFactory;

import twitter4j.conf.Configuration;

class DispatcherImpl$1
        implements ThreadFactory {
    int count = 0;

    DispatcherImpl$1(DispatcherImpl paramDispatcherImpl, Configuration paramConfiguration) {
    }

    public Thread newThread(Runnable paramRunnable) {
        paramRunnable = new Thread(paramRunnable);
        int i = this.count;
        this.count = (i + 1);
        paramRunnable.setName(String.format("Twitter4J Async Dispatcher[%d]", new Object[]{Integer.valueOf(i)}));
        paramRunnable.setDaemon(this.val$conf.isDaemonEnabled());
        return paramRunnable;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/DispatcherImpl$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */