package com.pocket.app;

import android.support.v4.app.Fragment;
import android.support.v4.app.n;
import java.util.ArrayList;

public class d
  extends n
{
  private final n a;
  private final b b;
  private final ArrayList c = new ArrayList();
  private final ArrayList d = new ArrayList();
  private boolean e;
  
  public d(n paramn, b paramb)
  {
    this.a = paramn;
    this.b = paramb;
  }
  
  public int a()
  {
    this.b.a(this.c, this.d, this.e);
    return this.a.a();
  }
  
  public n a(int paramInt)
  {
    return this.a.a(paramInt);
  }
  
  public n a(int paramInt, Fragment paramFragment, String paramString)
  {
    this.a.a(paramInt, paramFragment, paramString);
    this.c.add(paramFragment);
    return this;
  }
  
  public n a(Fragment paramFragment)
  {
    this.a.a(paramFragment);
    this.d.add(paramFragment);
    return this;
  }
  
  public n a(Fragment paramFragment, String paramString)
  {
    this.a.a(paramFragment, paramString);
    this.c.add(paramFragment);
    return this;
  }
  
  public n a(String paramString)
  {
    this.a.a(paramString);
    this.e = true;
    return this;
  }
  
  public int b()
  {
    this.b.a(this.c, this.d, this.e);
    return this.a.b();
  }
  
  public n b(Fragment paramFragment)
  {
    this.a.b(paramFragment);
    this.d.add(paramFragment);
    return this;
  }
  
  public n c(Fragment paramFragment)
  {
    this.a.c(paramFragment);
    this.c.add(paramFragment);
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/app/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */