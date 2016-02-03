package com.vungle.sdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.Map;

final class au
  extends Handler
{
  au(VungleIntentService.a parama, Looper paramLooper1, VungleIntentService paramVungleIntentService, Looper paramLooper2, String paramString)
  {
    super(paramLooper1);
  }
  
  public final void handleMessage(Message arg1)
  {
    this.d.a(???);
    synchronized (this.a.b)
    {
      if (!hasMessages(1))
      {
        String str = VungleIntentService.a;
        new StringBuilder("Stopping ").append(this.d.a);
        this.b.quit();
        this.a.b.remove(this.c);
        if (this.a.b.isEmpty())
        {
          str = VungleIntentService.a;
          this.a.stopSelf();
        }
      }
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/vungle/sdk/au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */