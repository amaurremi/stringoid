package com.jiubang.core.c;

import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public abstract class j
  extends Handler
{
  private static Looper a = null;
  final WeakReference b;
  private Handler c;
  
  public j(ContentResolver paramContentResolver)
  {
    this.b = new WeakReference(paramContentResolver);
    try
    {
      if (a == null)
      {
        paramContentResolver = new HandlerThread("WeatherAsyncQueryWorker");
        paramContentResolver.start();
        a = paramContentResolver.getLooper();
      }
      this.c = a(a);
      return;
    }
    finally {}
  }
  
  protected Handler a(Looper paramLooper)
  {
    return new l(this, paramLooper);
  }
  
  protected void a(int paramInt1, Object paramObject, int paramInt2) {}
  
  protected void a(int paramInt, Object paramObject, Cursor paramCursor) {}
  
  protected void a(int paramInt, Object paramObject, Uri paramUri) {}
  
  public final void a(int paramInt, Object paramObject, Uri paramUri, ContentValues paramContentValues)
  {
    Message localMessage = this.c.obtainMessage(paramInt);
    localMessage.arg1 = 2;
    k localk = new k();
    localk.b = this;
    localk.a = paramUri;
    localk.h = paramObject;
    localk.i = paramContentValues;
    localMessage.obj = localk;
    this.c.sendMessage(localMessage);
  }
  
  public final void a(int paramInt, Object paramObject, Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    Message localMessage = this.c.obtainMessage(paramInt);
    localMessage.arg1 = 3;
    k localk = new k();
    localk.b = this;
    localk.a = paramUri;
    localk.h = paramObject;
    localk.i = paramContentValues;
    localk.d = paramString;
    localk.e = paramArrayOfString;
    localMessage.obj = localk;
    this.c.sendMessage(localMessage);
  }
  
  public final void a(int paramInt, Object paramObject, Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    Message localMessage = this.c.obtainMessage(paramInt);
    localMessage.arg1 = 4;
    k localk = new k();
    localk.b = this;
    localk.a = paramUri;
    localk.h = paramObject;
    localk.d = paramString;
    localk.e = paramArrayOfString;
    localMessage.obj = localk;
    this.c.sendMessage(localMessage);
  }
  
  public void a(int paramInt, Object paramObject, Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    Message localMessage = this.c.obtainMessage(paramInt);
    localMessage.arg1 = 1;
    k localk = new k();
    localk.b = this;
    localk.a = paramUri;
    localk.c = paramArrayOfString1;
    localk.d = paramString1;
    localk.e = paramArrayOfString2;
    localk.f = paramString2;
    localk.h = paramObject;
    localMessage.obj = localk;
    this.c.sendMessage(localMessage);
  }
  
  public final void a(int paramInt, Object paramObject, String paramString, ArrayList paramArrayList)
  {
    Message localMessage = this.c.obtainMessage(paramInt);
    localMessage.arg1 = 5;
    k localk = new k();
    localk.b = this;
    localk.j = paramString;
    localk.h = paramObject;
    localk.k = paramArrayList;
    localMessage.obj = localk;
    this.c.sendMessage(localMessage);
  }
  
  protected void a(int paramInt, Object paramObject, ContentProviderResult[] paramArrayOfContentProviderResult) {}
  
  protected void b(int paramInt1, Object paramObject, int paramInt2) {}
  
  public void handleMessage(Message paramMessage)
  {
    k localk = (k)paramMessage.obj;
    int i = paramMessage.what;
    switch (paramMessage.arg1)
    {
    default: 
      return;
    case 1: 
      a(i, localk.h, (Cursor)localk.g);
      return;
    case 2: 
      a(i, localk.h, (Uri)localk.g);
      return;
    case 3: 
      a(i, localk.h, ((Integer)localk.g).intValue());
      return;
    case 4: 
      b(i, localk.h, ((Integer)localk.g).intValue());
      return;
    }
    a(i, localk.h, (ContentProviderResult[])localk.g);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/core/c/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */