package com.google.android.gms.maps.internal;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.eg;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class q
{
  private static Context Ci;
  private static c Cj;
  
  private static <T> T a(ClassLoader paramClassLoader, String paramString)
  {
    try
    {
      paramClassLoader = c(((ClassLoader)eg.f(paramClassLoader)).loadClass(paramString));
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
  
  private static boolean eB()
  {
    return false;
  }
  
  private static Class<?> eC()
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
  
  private static Context getRemoteContext(Context paramContext)
  {
    if (Ci == null) {
      if (!eB()) {
        break label20;
      }
    }
    label20:
    for (Ci = paramContext;; Ci = GooglePlayServicesUtil.getRemoteContext(paramContext)) {
      return Ci;
    }
  }
  
  public static c u(Context paramContext)
    throws GooglePlayServicesNotAvailableException
  {
    eg.f(paramContext);
    if (Cj != null) {
      return Cj;
    }
    v(paramContext);
    Cj = w(paramContext);
    try
    {
      Cj.a(com.google.android.gms.dynamic.c.h(getRemoteContext(paramContext).getResources()), 4242000);
      return Cj;
    }
    catch (RemoteException paramContext)
    {
      throw new RuntimeRemoteException(paramContext);
    }
  }
  
  private static void v(Context paramContext)
    throws GooglePlayServicesNotAvailableException
  {
    int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(paramContext);
    switch (i)
    {
    default: 
      throw new GooglePlayServicesNotAvailableException(i);
    }
  }
  
  private static c w(Context paramContext)
  {
    if (eB())
    {
      Log.i(q.class.getSimpleName(), "Making Creator statically");
      return (c)c(eC());
    }
    return c.a.Q((IBinder)a(getRemoteContext(paramContext).getClassLoader(), "com.google.android.gms.maps.internal.CreatorImpl"));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/maps/internal/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */