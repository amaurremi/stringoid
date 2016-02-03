package retrofit;

import java.util.concurrent.Executor;

class Utils$SynchronousExecutor
        implements Executor {
    public void execute(Runnable paramRunnable) {
        paramRunnable.run();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/retrofit/Utils$SynchronousExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */