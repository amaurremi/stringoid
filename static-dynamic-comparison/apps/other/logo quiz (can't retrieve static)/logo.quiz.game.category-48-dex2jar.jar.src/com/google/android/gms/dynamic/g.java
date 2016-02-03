package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.n;

public abstract class g<T>
{
  private final String Sd;
  private T Se;
  
  protected g(String paramString)
  {
    this.Sd = paramString;
  }
  
  protected final T L(Context paramContext)
    throws g.a
  {
    if (this.Se == null)
    {
      n.i(paramContext);
      paramContext = GooglePlayServicesUtil.getRemoteContext(paramContext);
      if (paramContext == null) {
        throw new a("Could not get remote context.");
      }
      paramContext = paramContext.getClassLoader();
    }
    try
    {
      this.Se = d((IBinder)paramContext.loadClass(this.Sd).newInstance());
      return (T)this.Se;
    }
    catch (ClassNotFoundException paramContext)
    {
      throw new a("Could not load creator class.", paramContext);
    }
    catch (InstantiationException paramContext)
    {
      throw new a("Could not instantiate creator.", paramContext);
    }
    catch (IllegalAccessException paramContext)
    {
      throw new a("Could not access creator.", paramContext);
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/dynamic/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */