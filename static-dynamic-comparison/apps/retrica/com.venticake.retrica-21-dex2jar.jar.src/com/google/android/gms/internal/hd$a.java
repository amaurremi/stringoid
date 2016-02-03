package com.google.android.gms.internal;

import android.content.ComponentName;
import android.os.IBinder;
import java.util.HashSet;

final class hd$a
{
  private final String b;
  private final hd.a.a c;
  private final HashSet<hb<?>.oq> d;
  private int e;
  private boolean f;
  private IBinder g;
  private ComponentName h;
  
  public hd$a(hd paramhd, String paramString)
  {
    this.b = paramString;
    this.c = new hd.a.a(this);
    this.d = new HashSet();
    this.e = 0;
  }
  
  public hd.a.a a()
  {
    return this.c;
  }
  
  public void a(hb<?>.oq paramhb)
  {
    this.d.add(paramhb);
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public void b(hb<?>.oq paramhb)
  {
    this.d.remove(paramhb);
  }
  
  public boolean c()
  {
    return this.f;
  }
  
  public boolean c(hb<?>.oq paramhb)
  {
    return this.d.contains(paramhb);
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/hd$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */