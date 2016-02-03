package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.fq;

public abstract class g<T>
{
  private final String Hx;
  private T Hy;
  
  protected g(String paramString)
  {
    this.Hx = paramString;
  }
  
  protected abstract T d(IBinder paramIBinder);
  
  protected final T z(Context paramContext)
    throws g.a
  {
    if (this.Hy == null)
    {
      fq.f(paramContext);
      paramContext = GooglePlayServicesUtil.getRemoteContext(paramContext);
      if (paramContext == null) {
        throw new a("Could not get remote context.");
      }
      paramContext = paramContext.getClassLoader();
    }
    try
    {
      this.Hy = d((IBinder)paramContext.loadClass(this.Hx).newInstance());
      return (T)this.Hy;
    }
    catch (ClassNotFoundException paramContext)
    {
      throw new a("Could not load creator class.");
    }
    catch (InstantiationException paramContext)
    {
      throw new a("Could not instantiate creator.");
    }
    catch (IllegalAccessException paramContext)
    {
      throw new a("Could not access creator.");
    }
  }
  
  public static class a
    extends Exception
  {
    public a(String paramString)
    {
      super();
    }
    
    public a(String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/dynamic/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */