package com.pocket.l.a;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.media.AudioManager;
import android.media.RemoteControlClient;

@TargetApi(14)
public class c
  extends a
{
  private final RemoteControlClient a;
  private final AudioManager b;
  private final PendingIntent c;
  private d d;
  
  public c(AudioManager paramAudioManager, PendingIntent paramPendingIntent)
  {
    this.b = paramAudioManager;
    this.c = paramPendingIntent;
    this.a = new RemoteControlClient(paramPendingIntent);
  }
  
  public AudioManager a()
  {
    return this.b;
  }
  
  public b a(boolean paramBoolean)
  {
    d locald = new d(this, this.a.editMetadata(paramBoolean));
    if (!paramBoolean) {
      d.a(locald, d.a(this.d));
    }
    this.d = locald;
    return locald;
  }
  
  public void a(float paramFloat) {}
  
  public void a(int paramInt)
  {
    this.a.setPlaybackState(paramInt);
  }
  
  public void b(int paramInt)
  {
    this.a.setTransportControlFlags(paramInt);
  }
  
  public void c()
  {
    a().registerRemoteControlClient(this.a);
  }
  
  public void d()
  {
    a().unregisterRemoteControlClient(this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/l/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */