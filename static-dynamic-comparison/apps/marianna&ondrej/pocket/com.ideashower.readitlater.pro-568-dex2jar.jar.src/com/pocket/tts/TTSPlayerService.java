package com.pocket.tts;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class TTSPlayerService
  extends Service
{
  private final h a = h.a(this);
  
  public IBinder onBind(Intent paramIntent)
  {
    return this.a;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.a.d();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/tts/TTSPlayerService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */