package com.mopub.common.util;

import android.annotation.TargetApi;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AsyncTasks {
    private static Executor a;

    static {
    }

    @TargetApi(11)
    private static void a() {
        if (Build.VERSION.SDK_INT >= 11) {
            a = AsyncTask.THREAD_POOL_EXECUTOR;
            return;
        }
        a = Executors.newSingleThreadExecutor();
    }

    @TargetApi(11)
    public static <P> void safeExecuteOnExecutor(AsyncTask<P, ?, ?> paramAsyncTask, P... paramVarArgs) {
        Preconditions.checkNotNull(paramAsyncTask, "Unable to execute null AsyncTask.");
        Preconditions.checkUiThread("AsyncTask must be executed on the main thread");
        if (Build.VERSION.SDK_INT >= 11) {
            paramAsyncTask.executeOnExecutor(a, paramVarArgs);
            return;
        }
        paramAsyncTask.execute(paramVarArgs);
    }

    @VisibleForTesting
    public static void setExecutor(Executor paramExecutor) {
        a = paramExecutor;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/common/util/AsyncTasks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */