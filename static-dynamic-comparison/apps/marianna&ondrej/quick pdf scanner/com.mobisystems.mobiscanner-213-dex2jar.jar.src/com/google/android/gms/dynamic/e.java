package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.d;
import com.google.android.gms.internal.dc;

public abstract class e<T>
{
  private final String va;
  private T vb;
  
  protected e(String paramString)
  {
    this.va = paramString;
  }
  
  protected final T B(Context paramContext)
  {
    if (this.vb == null)
    {
      dc.N(paramContext);
      paramContext = d.z(paramContext);
      if (paramContext == null) {
        throw new a("Could not get remote context.");
      }
      paramContext = paramContext.getClassLoader();
    }
    try
    {
      this.vb = i((IBinder)paramContext.loadClass(this.va).newInstance());
      return (T)this.vb;
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
  
  protected abstract T i(IBinder paramIBinder);
  
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/dynamic/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */