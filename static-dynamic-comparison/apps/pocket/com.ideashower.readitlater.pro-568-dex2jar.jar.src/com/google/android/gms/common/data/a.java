package com.google.android.gms.common.data;

import java.util.Iterator;

public abstract class a
  implements Iterable
{
  protected final d a;
  
  protected a(d paramd)
  {
    this.a = paramd;
    if (this.a != null) {
      this.a.a(this);
    }
  }
  
  public int a()
  {
    return this.a.g();
  }
  
  public abstract Object a(int paramInt);
  
  public void b()
  {
    this.a.i();
  }
  
  public Iterator iterator()
  {
    return new c(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/common/data/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */