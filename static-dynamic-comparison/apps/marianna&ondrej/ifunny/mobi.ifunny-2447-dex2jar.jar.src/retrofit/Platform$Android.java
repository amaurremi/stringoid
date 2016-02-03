package retrofit;

import android.os.Build.VERSION;
import com.google.gson.Gson;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import retrofit.android.AndroidApacheClient;
import retrofit.android.AndroidLog;
import retrofit.android.MainThreadExecutor;
import retrofit.client.Client;
import retrofit.client.Client.Provider;
import retrofit.client.UrlConnectionClient;
import retrofit.converter.Converter;
import retrofit.converter.GsonConverter;

class Platform$Android
        extends Platform {
    Executor defaultCallbackExecutor() {
        return new MainThreadExecutor();
    }

    Client.Provider defaultClient() {
        Object localObject;
        if (Platform.access$300()) {
            localObject = Platform.OkClientInstantiator.instantiate();
        }
        for (; ; ) {
            return new Platform.Android .1 (this, (Client) localObject);
            if (Build.VERSION.SDK_INT < 9) {
                localObject = new AndroidApacheClient();
            } else {
                localObject = new UrlConnectionClient();
            }
        }
    }

    Converter defaultConverter() {
        return new GsonConverter(new Gson());
    }

    Executor defaultHttpExecutor() {
        return Executors.newCachedThreadPool(new Platform.Android .2 (this));
    }

    RestAdapter.Log defaultLog() {
        return new AndroidLog("Retrofit");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/retrofit/Platform$Android.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */