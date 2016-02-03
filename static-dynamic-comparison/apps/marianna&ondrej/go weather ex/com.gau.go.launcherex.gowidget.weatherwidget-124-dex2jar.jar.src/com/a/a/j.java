package com.a.a;

import java.util.ArrayList;

class j
  implements Cloneable
{
  public a a;
  public ArrayList b = null;
  public ArrayList c = null;
  public ArrayList d = null;
  public ArrayList e = null;
  public boolean f = false;
  
  public j(a parama)
  {
    this.a = parama;
  }
  
  public j a()
  {
    try
    {
      j localj = (j)super.clone();
      localj.a = this.a.g();
      return localj;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError();
    }
  }
  
  public void a(h paramh)
  {
    if (this.b == null)
    {
      this.b = new ArrayList();
      this.d = new ArrayList();
    }
    this.b.add(paramh);
    if (!this.d.contains(paramh.a)) {
      this.d.add(paramh.a);
    }
    paramh = paramh.a;
    if (paramh.e == null) {
      paramh.e = new ArrayList();
    }
    paramh.e.add(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/a/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */