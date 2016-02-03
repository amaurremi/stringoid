package com.google.android.gms.maps.internal;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.internal.hm;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class u
{
  private static Context aaj;
  private static c aak;
  
  public static c H(Context paramContext)
  {
    hm.f(paramContext);
    if (aak != null) {
      return aak;
    }
    I(paramContext);
    aak = J(paramContext);
    try
    {
      aak.a(e.h(getRemoteContext(paramContext).getResources()), 5089000);
      return aak;
    }
    catch (RemoteException paramContext)
    {
      throw new RuntimeRemoteException(paramContext);
    }
  }
  
  private static void I(Context paramContext)
  {
    int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(paramContext);
    switch (i)
    {
    default: 
      throw new GooglePlayServicesNotAvailableException(i);
    }
  }
  
  private static c J(Context paramContext)
  {
    if (jJ())
    {
      Log.i(u.class.getSimpleName(), "Making Creator statically");
      return (c)c(jK());
    }
    Log.i(u.class.getSimpleName(), "Making Creator dynamically");
    return c.a.ax((IBinder)a(getRemoteContext(paramContext).getClassLoader(), "com.google.android.gms.maps.internal.CreatorImpl"));
  }
  
  private static <T> T a(ClassLoader paramClassLoader, String paramString)
  {
    try
    {
      paramClassLoader = c(((ClassLoader)hm.f(paramClassLoader)).loadClass(paramString));
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
    if (aaj == null) {
      if (!jJ()) {
        break label23;
      }
    }
    label23:
    for (aaj = paramContext.getApplicationContext();; aaj = GooglePlayServicesUtil.getRemoteContext(paramContext)) {
      return aaj;
    }
  }
  
  private static boolean jJ()
  {
    return false;
  }
  
  private static Class<?> jK()
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/maps/internal/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */