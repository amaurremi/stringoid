package retrofit;

import com.google.gson.Gson;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import retrofit.client.Client;
import retrofit.client.Client.Provider;
import retrofit.client.UrlConnectionClient;
import retrofit.converter.Converter;
import retrofit.converter.GsonConverter;

class Platform$Base
        extends Platform {
    Executor defaultCallbackExecutor() {
        return new Utils.SynchronousExecutor();
    }

    Client.Provider defaultClient() {
        if (Platform.access$300()) {
        }
        for (Object localObject = Platform.OkClientInstantiator.instantiate(); ; localObject = new UrlConnectionClient()) {
            return new Platform.Base .1 (this, (Client) localObject);
        }
    }

    Converter defaultConverter() {
        return new GsonConverter(new Gson());
    }

    Executor defaultHttpExecutor() {
        return Executors.newCachedThreadPool(new Platform.Base .2 (this));
    }

    RestAdapter.Log defaultLog() {
        return new Platform.Base .3 (this);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/retrofit/Platform$Base.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */