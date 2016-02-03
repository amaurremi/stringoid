package com.mopub.common.util;

import android.os.AsyncTask;
import java.lang.reflect.Field;
import java.util.concurrent.Executor;

public class AsyncTasks
{
  public static <P> void safeExecuteOnExecutor(AsyncTask<P, ?, ?> paramAsyncTask, P... paramVarArgs)
  {
    if (paramAsyncTask == null) {
      throw new IllegalArgumentException("Unable to execute null AsyncTask.");
    }
    if (VersionCode.currentApiLevel().isAtLeast(VersionCode.ICE_CREAM_SANDWICH)) {
      try
      {
        Executor localExecutor = (Executor)AsyncTask.class.getField("THREAD_POOL_EXECUTOR").get(AsyncTask.class);
        new Reflection.MethodBuilder(paramAsyncTask, "executeOnExecutor").addParam(Executor.class, localExecutor).addParam(Object[].class, paramVarArgs).execute();
        return;
      }
      catch (Exception localException)
      {
        paramAsyncTask.execute(paramVarArgs);
        return;
      }
    }
    paramAsyncTask.execute(paramVarArgs);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/common/util/AsyncTasks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */