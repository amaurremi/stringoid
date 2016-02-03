package com.pocket.tts;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.ArrayList;
import java.util.Locale;

public abstract class i
  implements ServiceConnection
{
  private h a;
  public boolean b;
  private boolean c;
  
  protected void a() {}
  
  protected void a(float paramFloat) {}
  
  public abstract void a(int paramInt);
  
  protected void a(d paramd) {}
  
  public abstract void a(h paramh);
  
  public void a(String paramString) {}
  
  protected void a(ArrayList paramArrayList) {}
  
  protected void a(Locale paramLocale) {}
  
  protected void b() {}
  
  protected void b(float paramFloat) {}
  
  public abstract void b(int paramInt);
  
  public abstract void b(String paramString);
  
  protected void c() {}
  
  public abstract void c(int paramInt);
  
  public void d() {}
  
  protected void d(int paramInt) {}
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    this.c = false;
    this.b = false;
    this.a = ((h)paramIBinder);
    h.a(this.a, this);
    if (h.g(this.a))
    {
      a(this.a);
      return;
    }
    h.h(this.a);
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    this.c = false;
    h.b(this.a, this);
    this.a = null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/tts/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */