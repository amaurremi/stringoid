package twitter4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import twitter4j.conf.Configuration;

final class DispatcherImpl
        implements Dispatcher {
    private final ExecutorService executorService;

    public DispatcherImpl(Configuration paramConfiguration) {
        this.executorService = Executors.newFixedThreadPool(paramConfiguration.getAsyncNumThreads(), new DispatcherImpl
        .1 (this, paramConfiguration));
        Runtime.getRuntime().addShutdownHook(new DispatcherImpl .2 (this));
    }

    public void invokeLater(Runnable paramRunnable) {
        try {
            this.executorService.execute(paramRunnable);
            return;
        } finally {
            paramRunnable =finally;
            throw paramRunnable;
        }
    }

    public void shutdown() {
        try {
            this.executorService.shutdown();
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/DispatcherImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */