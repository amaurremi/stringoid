package com.jiubang.goweather.c;

import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.gau.go.launcherex.gowidget.weather.model.b;

public class g
  implements Handler.Callback
{
  private Context a;
  private m b;
  private boolean c;
  private boolean d;
  private volatile boolean e;
  private Handler f;
  private i g;
  
  public g(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
    this.c = false;
    this.d = false;
    this.e = false;
    this.f = new Handler(Looper.getMainLooper(), this);
    this.b = new m(this.a);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.b.a(paramInt1, paramInt2, paramInt3, new h(this, paramInt1, paramInt2));
  }
  
  private void a(int paramInt, Location paramLocation)
  {
    if (this.g != null) {
      this.g.a(paramInt, paramLocation);
    }
  }
  
  private void a(int paramInt, b paramb)
  {
    if (this.g != null) {
      this.g.a(paramInt, paramb);
    }
  }
  
  private void b(int paramInt1, int paramInt2, int paramInt3)
  {
    switch (paramInt2)
    {
    default: 
      return;
    case 1: 
      a(paramInt2, 2, 10);
      return;
    case 2: 
      a(paramInt2, 3, 30);
      return;
    }
    this.f.sendEmptyMessage(5);
  }
  
  public void a()
  {
    if (!this.c)
    {
      this.c = true;
      a(0, 1, 15);
    }
  }
  
  public void a(Location paramLocation)
  {
    if (paramLocation == null) {
      b();
    }
    while (this.d) {
      return;
    }
    this.d = true;
    this.b.a(paramLocation);
  }
  
  public void a(i parami)
  {
    this.g = parami;
  }
  
  public void b()
  {
    this.e = true;
    a();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      throw new IllegalThreadStateException("need a new case?");
    case 2: 
      this.c = false;
      a(2, null);
      this.d = false;
      if (this.e)
      {
        this.e = false;
        a(2, null);
      }
    case 5: 
    case 3: 
      do
      {
        do
        {
          return false;
          this.c = false;
          a(5, null);
          this.d = false;
        } while (!this.e);
        this.e = false;
        a(5, null);
        return false;
        this.c = false;
        a(3, null);
        this.d = false;
      } while (!this.e);
      this.e = false;
      a(3, null);
      return false;
    case 1: 
      this.c = false;
      a(1, (Location)paramMessage.obj);
      return false;
    }
    this.d = false;
    a(4, (b)paramMessage.obj);
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/goweather/c/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */