package com.ideashower.readitlater.g;

import com.ideashower.readitlater.objects.g;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class a
  extends f
{
  private g e;
  private String f;
  
  public a(int paramInt, String paramString)
  {
    this(paramInt, false, paramString);
  }
  
  public a(int paramInt, boolean paramBoolean, String paramString)
  {
    super(paramInt, paramString);
    if (paramBoolean) {
      a();
    }
  }
  
  public FutureTask a(k paramk)
  {
    this.e.a();
    return super.a(paramk);
  }
  
  public void a()
  {
    if (this.e != null) {
      this.e.c();
    }
    this.e = new g();
    this.e.a(this.f);
  }
  
  public void a(int paramInt, TimeUnit paramTimeUnit)
  {
    super.a(paramInt, paramTimeUnit);
    if (this.e != null) {
      this.e.c();
    }
  }
  
  public void a(Runnable paramRunnable)
  {
    super.a(paramRunnable);
    if (this.e != null) {
      this.e.b();
    }
  }
  
  public void a(String paramString)
  {
    this.f = (paramString + " | ");
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    a();
  }
  
  public boolean b()
  {
    if (this.e == null) {
      return false;
    }
    return this.e.d();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/g/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */