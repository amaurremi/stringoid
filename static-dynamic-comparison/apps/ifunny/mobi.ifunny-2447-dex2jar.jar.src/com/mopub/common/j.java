package com.mopub.common;

import android.content.Context;
import android.os.AsyncTask;
import com.mopub.common.factories.MethodBuilderFactory;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Reflection.MethodBuilder;

import java.lang.ref.WeakReference;

class j
        extends AsyncTask<Void, Void, Void> {
    private WeakReference<Context> a;
    private WeakReference<GpsHelper.GpsHelperListener> b;

    public j(Context paramContext, GpsHelper.GpsHelperListener paramGpsHelperListener) {
        this.a = new WeakReference(paramContext);
        this.b = new WeakReference(paramGpsHelperListener);
    }

    protected Void a(Void... paramVarArgs) {
        try {
            paramVarArgs = (Context) this.a.get();
            if (paramVarArgs == null) {
                return null;
            }
            Object localObject = MethodBuilderFactory.create(null, "getAdvertisingIdInfo").setStatic(Class.forName(GpsHelper.a())).addParam(Context.class, paramVarArgs).execute();
            if (localObject != null) {
                GpsHelper.a(paramVarArgs, localObject);
                return null;
            }
        } catch (Exception paramVarArgs) {
            MoPubLog.d("Unable to obtain AdvertisingIdClient.getAdvertisingIdInfo()");
        }
        return null;
    }

    protected void a(Void paramVoid) {
        paramVoid = (GpsHelper.GpsHelperListener) this.b.get();
        if (paramVoid != null) {
            paramVoid.onFetchAdInfoCompleted();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/common/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */