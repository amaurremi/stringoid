package com.jiubang.core.c;

import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import java.lang.ref.WeakReference;

public class l
  extends Handler
{
  public l(j paramj, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject1 = (ContentResolver)this.a.b.get();
    if (localObject1 == null) {
      return;
    }
    k localk = (k)paramMessage.obj;
    int i = paramMessage.what;
    switch (paramMessage.arg1)
    {
    }
    for (;;)
    {
      localObject1 = localk.b.obtainMessage(i);
      ((Message)localObject1).obj = localk;
      ((Message)localObject1).arg1 = paramMessage.arg1;
      ((Message)localObject1).sendToTarget();
      return;
      try
      {
        Cursor localCursor = ((ContentResolver)localObject1).query(localk.a, localk.c, localk.d, localk.e, localk.f);
        localObject1 = localCursor;
        if (localCursor != null)
        {
          localCursor.getCount();
          localObject1 = localCursor;
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          localObject2 = null;
        }
      }
      localk.g = localObject1;
      continue;
      try
      {
        Object localObject2;
        localk.g = ((ContentResolver)localObject2).insert(localk.a, localk.i);
      }
      catch (Exception localException2)
      {
        localk.g = null;
      }
      continue;
      try
      {
        localk.g = Integer.valueOf(localException2.update(localk.a, localk.i, localk.d, localk.e));
      }
      catch (Exception localException3)
      {
        localk.g = Integer.valueOf(55536);
      }
      continue;
      try
      {
        localk.g = Integer.valueOf(localException3.delete(localk.a, localk.d, localk.e));
      }
      catch (Exception localException4)
      {
        localk.g = Integer.valueOf(55536);
      }
      continue;
      try
      {
        localk.g = localException4.applyBatch(localk.j, localk.k);
      }
      catch (RemoteException localRemoteException)
      {
        localRemoteException.printStackTrace();
      }
      catch (OperationApplicationException localOperationApplicationException)
      {
        localOperationApplicationException.printStackTrace();
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/core/c/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */