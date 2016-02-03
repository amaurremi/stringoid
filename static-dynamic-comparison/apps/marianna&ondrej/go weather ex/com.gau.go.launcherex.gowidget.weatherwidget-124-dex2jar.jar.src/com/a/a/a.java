package com.a.a;

import android.view.animation.Interpolator;
import java.util.ArrayList;

public abstract class a
  implements Cloneable
{
  ArrayList a = null;
  
  public abstract a a(long paramLong);
  
  public void a() {}
  
  public abstract void a(Interpolator paramInterpolator);
  
  public void a(b paramb)
  {
    if (this.a == null) {
      this.a = new ArrayList();
    }
    this.a.add(paramb);
  }
  
  public void a(Object paramObject) {}
  
  public void b() {}
  
  public void b(b paramb)
  {
    if (this.a == null) {}
    do
    {
      return;
      this.a.remove(paramb);
    } while (this.a.size() != 0);
    this.a = null;
  }
  
  public void c() {}
  
  public abstract boolean d();
  
  public boolean e()
  {
    return d();
  }
  
  public ArrayList f()
  {
    return this.a;
  }
  
  public a g()
  {
    try
    {
      a locala = (a)super.clone();
      if (this.a != null)
      {
        ArrayList localArrayList = this.a;
        locala.a = new ArrayList();
        int j = localArrayList.size();
        int i = 0;
        while (i < j)
        {
          locala.a.add(localArrayList.get(i));
          i += 1;
        }
      }
      return localCloneNotSupportedException;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */