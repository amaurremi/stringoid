package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.hm;

public abstract class g<T>
{
  private final String Ml;
  private T Mm;
  
  protected g(String paramString)
  {
    this.Ml = paramString;
  }
  
  protected final T G(Context paramContext)
  {
    if (this.Mm == null)
    {
      hm.f(paramContext);
      paramContext = GooglePlayServicesUtil.getRemoteContext(paramContext);
      if (paramContext == null) {
        throw new g.a("Could not get remote context.");
      }
      paramContext = paramContext.getClassLoader();
    }
    try
    {
      this.Mm = d((IBinder)paramContext.loadClass(this.Ml).newInstance());
      return (T)this.Mm;
    }
    catch (ClassNotFoundException paramContext)
    {
      throw new g.a("Could not load creator class.");
    }
    catch (InstantiationException paramContext)
    {
      throw new g.a("Could not instantiate creator.");
    }
    catch (IllegalAccessException paramContext)
    {
      throw new g.a("Could not access creator.");
    }
  }
  
  protected abstract T d(IBinder paramIBinder);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/dynamic/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */