package com.google.android.gms.internal;

import android.content.ComponentName;
import android.os.IBinder;
import java.util.HashSet;

final class ac
{
  private final String b;
  private final ad c;
  private final HashSet d;
  private int e;
  private boolean f;
  private IBinder g;
  private ComponentName h;
  
  public ac(ab paramab, String paramString)
  {
    this.b = paramString;
    this.c = new ad(this);
    this.d = new HashSet();
    this.e = 0;
  }
  
  public ad a()
  {
    return this.c;
  }
  
  public void a(z paramz)
  {
    this.d.add(paramz);
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public void b(z paramz)
  {
    this.d.remove(paramz);
  }
  
  public boolean c()
  {
    return this.f;
  }
  
  public boolean c(z paramz)
  {
    return this.d.contains(paramz);
  }
  
  public int d()
  {
    return this.e;
  }
  
  public boolean e()
  {
    return this.d.isEmpty();
  }
  
  public IBinder f()
  {
    return this.g;
  }
  
  public ComponentName g()
  {
    return this.h;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/internal/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */