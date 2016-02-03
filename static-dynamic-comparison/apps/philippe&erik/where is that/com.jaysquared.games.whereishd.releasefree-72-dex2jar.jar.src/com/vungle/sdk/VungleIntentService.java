package com.vungle.sdk;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import com.vungle.sdk.a.a.h;
import java.util.HashMap;
import java.util.Map;

public class VungleIntentService
  extends Service
{
  public static final String a = VungleIntentService.class.getSimpleName();
  final Map<String, a> b = new HashMap();
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onStart(Intent paramIntent, int paramInt)
  {
    String str;
    if (paramIntent != null) {
      str = paramIntent.getAction();
    }
    synchronized (this.b)
    {
      if (this.b.isEmpty()) {
        localObject = a;
      }
      a locala = (a)this.b.get(str);
      Object localObject = locala;
      if (locala == null)
      {
        localObject = locala;
        if ("Http".equals(str))
        {
          localObject = new h(this);
          this.b.put("Http", localObject);
        }
      }
      if (localObject != null) {
        ((a)localObject).a(paramIntent);
      }
      if (localObject == null)
      {
        localObject = a;
        new StringBuilder("Unknown action").append(paramIntent);
      }
      return;
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    onStart(paramIntent, paramInt2);
    return 2;
  }
  
  public static abstract class a
  {
    final String a;
    protected final Handler b;
    
    public a(VungleIntentService paramVungleIntentService, String paramString)
    {
      this.a = ("VungleIntentService[" + paramString + "@" + Integer.toHexString(hashCode()) + "]");
      Object localObject = VungleIntentService.a;
      new StringBuilder("Starting ").append(this.a);
      localObject = new HandlerThread(this.a);
      ((HandlerThread)localObject).start();
      localObject = ((HandlerThread)localObject).getLooper();
      this.b = new au(this, (Looper)localObject, paramVungleIntentService, (Looper)localObject, paramString);
    }
    
    protected abstract void a(Intent paramIntent);
    
    protected abstract void a(Message paramMessage);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/vungle/sdk/VungleIntentService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */