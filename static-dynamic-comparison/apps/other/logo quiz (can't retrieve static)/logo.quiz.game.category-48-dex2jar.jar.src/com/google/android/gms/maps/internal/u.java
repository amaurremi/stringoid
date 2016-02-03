package com.google.android.gms.maps.internal;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class u
{
  private static Context ajm;
  private static c ajn;
  
  public static c R(Context paramContext)
    throws GooglePlayServicesNotAvailableException
  {
    n.i(paramContext);
    if (ajn != null) {
      return ajn;
    }
    S(paramContext);
    ajn = T(paramContext);
    try
    {
      ajn.a(e.k(getRemoteContext(paramContext).getResources()), 6111000);
      return ajn;
    }
    catch (RemoteException paramContext)
    {
      throw new RuntimeRemoteException(paramContext);
    }
  }
  
  private static void S(Context paramContext)
    throws GooglePlayServicesNotAvailableException
  {
    int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(paramContext);
    switch (i)
    {
    default: 
      throw new GooglePlayServicesNotAvailableException(i);
    }
  }
  
  private static c T(Context paramContext)
  {
    if (mI())
    {
      Log.i(u.class.getSimpleName(), "Making Creator statically");
      return (c)c(mJ());
    }
    Log.i(u.class.getSimpleName(), "Making Creator dynamically");
    return c.a.aP((IBinder)a(getRemoteContext(paramContext).getClassLoader(), "com.google.android.gms.maps.internal.CreatorImpl"));
  }
  
  private static <T> T a(ClassLoader paramClassLoader, String paramString)
  {
    try
    {
      paramClassLoader = c(((ClassLoader)n.i(paramClassLoader)).loadClass(paramString));
      return paramClassLoader;
    }
    catch (ClassNotFoundException paramClassLoader)
    {
      throw new IllegalStateException("Unable to find dynamic class " + paramString);
    }
  }
  
  private static <T> T c(Class<?> paramClass)
  {
    try
    {
      Object localObject = paramClass.newInstance();
      return (T)localObject;
    }
    catch (InstantiationException localInstantiationException)
    {
      throw new IllegalStateException("Unable to instantiate the dynamic class " + paramClass.getName());
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new IllegalStateException("Unable to call the default constructor of " + paramClass.getName());
    }
  }
  
  private static Context getRemoteContext(Context paramContext)
  {
    if (ajm == null) {
      if (!mI()) {
        break label23;
      }
    }
    label23:
    for (ajm = paramContext.getApplicationContext();; ajm = GooglePlayServicesUtil.getRemoteContext(paramContext)) {
      return ajm;
    }
  }
  
  private static boolean mI()
  {
    return false;
  }
  
  private static Class<?> mJ()
  {
    try
    {
      if (Build.VERSION.SDK_INT < 15) {
        return Class.forName("com.google.android.gms.maps.internal.CreatorImplGmm6");
      }
      Class localClass = Class.forName("com.google.android.gms.maps.internal.CreatorImpl");
      return localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new RuntimeException(localClassNotFoundException);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/maps/internal/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */