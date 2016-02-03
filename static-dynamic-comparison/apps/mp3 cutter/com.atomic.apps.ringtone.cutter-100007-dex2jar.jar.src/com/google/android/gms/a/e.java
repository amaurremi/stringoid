package com.google.android.gms.a;

import android.content.Context;
import android.os.IBinder;
import com.atomic.apps.ringtone.cutter.aa;

public abstract class e
{
  private final String a;
  private Object b;
  
  protected e(String paramString)
  {
    this.a = paramString;
  }
  
  protected final Object a(Context paramContext)
  {
    if (this.b == null)
    {
      aa.a(paramContext);
      paramContext = com.google.android.gms.common.f.c(paramContext);
      if (paramContext == null) {
        throw new f("Could not get remote context.");
      }
      paramContext = paramContext.getClassLoader();
    }
    try
    {
      this.b = a((IBinder)paramContext.loadClass(this.a).newInstance());
      return this.b;
    }
    catch (ClassNotFoundException paramContext)
    {
      throw new f("Could not load creator class.");
    }
    catch (InstantiationException paramContext)
    {
      throw new f("Could not instantiate creator.");
    }
    catch (IllegalAccessException paramContext)
    {
      throw new f("Could not access creator.");
    }
  }
  
  protected abstract Object a(IBinder paramIBinder);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/google/android/gms/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */