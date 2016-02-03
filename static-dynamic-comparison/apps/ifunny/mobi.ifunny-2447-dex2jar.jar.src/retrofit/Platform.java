package retrofit;

import android.os.Build.VERSION;

import java.util.concurrent.Executor;

import retrofit.client.Client.Provider;
import retrofit.converter.Converter;

abstract class Platform {
    static final boolean HAS_RX_JAVA = hasRxJavaOnClasspath();
    private static final Platform PLATFORM = ;

    private static Platform findPlatform() {
        try {
            Class.forName("android.os.Build");
            if (Build.VERSION.SDK_INT != 0) {
                Platform.Android localAndroid = new Platform.Android(null);
                return localAndroid;
            }
        } catch (ClassNotFoundException localClassNotFoundException) {
            if (System.getProperty("com.google.appengine.runtime.version") != null) {
                return new Platform.AppEngine(null);
            }
        }
        return new Platform.Base(null);
    }

    static Platform get() {
        return PLATFORM;
    }

    private static boolean hasOkHttpOnClasspath() {
        bool2 = true;
        try {
            Class.forName("com.squareup.okhttp.OkUrlFactory");
            boolean bool1 = true;
            return bool2;
        } catch (ClassNotFoundException localClassNotFoundException1) {
            try {
                for (; ; ) {
                    Class.forName("com.squareup.okhttp.OkHttpClient");
                    if (bool2 == bool1) {
                        break;
                    }
                    throw new RuntimeException("Retrofit detected an unsupported OkHttp on the classpath.\nTo use OkHttp with this version of Retrofit, you'll need:\n1. com.squareup.okhttp:okhttp:1.6.0 (or newer)\n2. com.squareup.okhttp:okhttp-urlconnection:1.6.0 (or newer)\nNote that OkHttp 2.0.0+ is supported!");
                    localClassNotFoundException1 = localClassNotFoundException1;
                    bool1 = false;
                }
            } catch (ClassNotFoundException localClassNotFoundException2) {
                for (; ; ) {
                    bool2 = false;
                }
            }
        }
    }

    private static boolean hasRxJavaOnClasspath() {
        try {
            Class.forName("rx.Observable");
            return true;
        } catch (ClassNotFoundException localClassNotFoundException) {
        }
        return false;
    }

    abstract Executor defaultCallbackExecutor();

    abstract Client.Provider defaultClient();

    abstract Converter defaultConverter();

    abstract Executor defaultHttpExecutor();

    abstract RestAdapter.Log defaultLog();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/retrofit/Platform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */