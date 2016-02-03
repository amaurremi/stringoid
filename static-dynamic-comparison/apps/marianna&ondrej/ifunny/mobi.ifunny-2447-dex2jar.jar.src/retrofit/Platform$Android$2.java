package retrofit;

import java.util.concurrent.ThreadFactory;

class Platform$Android$2
        implements ThreadFactory {
    Platform$Android$2(Platform.Android paramAndroid) {
    }

    public Thread newThread(Runnable paramRunnable) {
        return new Thread(new Platform.Android .2 .1 (this, paramRunnable),"Retrofit-Idle");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/retrofit/Platform$Android$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */