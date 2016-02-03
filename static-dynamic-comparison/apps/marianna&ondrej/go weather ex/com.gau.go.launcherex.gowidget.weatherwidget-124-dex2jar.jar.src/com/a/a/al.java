package com.a.a;

import android.util.Log;
import com.a.b.b;
import com.a.b.c;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class al
  extends ai
{
  n h;
  int i;
  private b j;
  
  public al(c paramc, int... paramVarArgs)
  {
    super(paramc, null);
    a(paramVarArgs);
    if ((paramc instanceof b)) {
      this.j = ((b)this.b);
    }
  }
  
  public al(String paramString, int... paramVarArgs)
  {
    super(paramString, null);
    a(paramVarArgs);
  }
  
  void a(float paramFloat)
  {
    this.i = this.h.b(paramFloat);
  }
  
  void a(Class paramClass)
  {
    if (this.b != null) {
      return;
    }
    super.a(paramClass);
  }
  
  public void a(int... paramVarArgs)
  {
    super.a(paramVarArgs);
    this.h = ((n)this.e);
  }
  
  void b(Object paramObject)
  {
    if (this.j != null) {
      this.j.a(paramObject, this.i);
    }
    do
    {
      return;
      if (this.b != null)
      {
        this.b.a(paramObject, Integer.valueOf(this.i));
        return;
      }
    } while (this.c == null);
    try
    {
      this.g[0] = Integer.valueOf(this.i);
      this.c.invoke(paramObject, this.g);
      return;
    }
    catch (InvocationTargetException paramObject)
    {
      Log.e("PropertyValuesHolder", ((InvocationTargetException)paramObject).toString());
      return;
    }
    catch (IllegalAccessException paramObject)
    {
      Log.e("PropertyValuesHolder", ((IllegalAccessException)paramObject).toString());
    }
  }
  
  Object d()
  {
    return Integer.valueOf(this.i);
  }
  
  public al e()
  {
    al localal = (al)super.a();
    localal.h = ((n)localal.e);
    return localal;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/a/a/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */