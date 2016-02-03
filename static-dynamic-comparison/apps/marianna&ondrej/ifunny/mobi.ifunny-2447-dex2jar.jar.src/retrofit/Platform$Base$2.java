package retrofit;

import java.util.concurrent.ThreadFactory;

class Platform$Base$2
        implements ThreadFactory {
    Platform$Base$2(Platform.Base paramBase) {
    }

    public Thread newThread(Runnable paramRunnable) {
        return new Thread(new Platform.Base .2 .1 (this, paramRunnable),"Retrofit-Idle");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/retrofit/Platform$Base$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */