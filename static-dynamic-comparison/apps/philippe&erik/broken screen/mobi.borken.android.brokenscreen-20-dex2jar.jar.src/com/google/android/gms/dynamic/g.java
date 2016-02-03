package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.hn;

public abstract class g<T>
{
  private final String Mi;
  private T Mj;
  
  protected g(String paramString)
  {
    this.Mi = paramString;
  }
  
  protected final T D(Context paramContext)
    throws g.a
  {
    if (this.Mj == null)
    {
      hn.f(paramContext);
      paramContext = GooglePlayServicesUtil.getRemoteContext(paramContext);
      if (paramContext == null) {
        throw new a("Could not get remote context.");
      }
      paramContext = paramContext.getClassLoader();
    }
    try
    {
      this.Mj = d((IBinder)paramContext.loadClass(this.Mi).newInstance());
      return (T)this.Mj;
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
  
  protected abstract T d(IBinder paramIBinder);
  
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/dynamic/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */