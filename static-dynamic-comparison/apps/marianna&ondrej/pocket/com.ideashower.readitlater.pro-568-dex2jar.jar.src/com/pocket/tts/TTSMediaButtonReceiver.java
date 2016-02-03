package com.pocket.tts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.ideashower.readitlater.db.operation.action.UiContext;
import com.ideashower.readitlater.db.operation.action.UiTrigger;
import com.ideashower.readitlater.db.operation.action.w;
import com.ideashower.readitlater.db.operation.action.x;

public class TTSMediaButtonReceiver
  extends BroadcastReceiver
{
  private void a(x paramx, UiTrigger paramUiTrigger)
  {
    new w(paramx, h.b(), UiContext.a(paramUiTrigger)).j();
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    j localj = h.a(this);
    if (localj == null) {}
    do
    {
      do
      {
        return;
        paramContext = paramIntent.getAction();
        if (paramContext.equals("android.media.AUDIO_BECOMING_NOISY"))
        {
          localj.a();
          return;
        }
        if (!paramContext.equals("android.intent.action.MEDIA_BUTTON")) {
          break;
        }
        paramContext = (KeyEvent)paramIntent.getExtras().get("android.intent.extra.KEY_EVENT");
      } while (paramContext.getAction() != 0);
      switch (paramContext.getKeyCode())
      {
      default: 
        return;
      case 79: 
      case 85: 
        if (h.a()) {}
        for (paramContext = x.b;; paramContext = x.a)
        {
          a(paramContext, UiTrigger.E);
          localj.b();
          return;
        }
      case 126: 
        a(x.a, UiTrigger.E);
        localj.c();
        return;
      case 127: 
        a(x.b, UiTrigger.E);
        localj.a();
        return;
      case 86: 
        a(x.b, UiTrigger.E);
        localj.d();
        return;
      case 87: 
      case 90: 
        a(x.d, UiTrigger.E);
        localj.a(1);
        return;
      }
      a(x.c, UiTrigger.E);
      localj.a(-1);
      return;
      if (paramContext.equals("com.pocket.tts.action.FAST_FORWARD"))
      {
        a(x.d, UiTrigger.F);
        localj.a(1);
        return;
      }
      if (paramContext.equals("com.pocket.tts.action.REWIND"))
      {
        a(x.c, UiTrigger.F);
        localj.a(-1);
        return;
      }
      if (paramContext.equals("com.pocket.tts.action.PLAY_PAUSE"))
      {
        if (h.a()) {}
        for (paramContext = x.b;; paramContext = x.a)
        {
          a(paramContext, UiTrigger.F);
          localj.b();
          return;
        }
      }
    } while (!paramContext.equals("com.pocket.tts.action.STOP"));
    a(x.b, UiTrigger.F);
    localj.d();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/tts/TTSMediaButtonReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */