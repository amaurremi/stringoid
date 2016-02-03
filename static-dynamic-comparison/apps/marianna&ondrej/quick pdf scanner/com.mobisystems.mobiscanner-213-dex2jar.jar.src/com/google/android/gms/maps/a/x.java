package com.google.android.gms.maps.a;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.internal.dc;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class x
{
  private static Context UJ;
  private static j UK;
  
  public static j Q(Context paramContext)
  {
    dc.N(paramContext);
    if (UK != null) {
      return UK;
    }
    R(paramContext);
    UK = S(paramContext);
    try
    {
      UK.a(com.google.android.gms.dynamic.d.J(z(paramContext).getResources()), 4323000);
      return UK;
    }
    catch (RemoteException paramContext)
    {
      throw new RuntimeRemoteException(paramContext);
    }
  }
  
  private static void R(Context paramContext)
  {
    int i = com.google.android.gms.common.d.w(paramContext);
    switch (i)
    {
    default: 
      throw new GooglePlayServicesNotAvailableException(i);
    }
  }
  
  private static j S(Context paramContext)
  {
    if (uJ())
    {
      Log.i(x.class.getSimpleName(), "Making Creator statically");
      return (j)e(uK());
    }
    return j.a.R((IBinder)a(z(paramContext).getClassLoader(), "com.google.android.gms.maps.internal.CreatorImpl"));
  }
  
  private static <T> T a(ClassLoader paramClassLoader, String paramString)
  {
    try
    {
      paramClassLoader = e(((ClassLoader)dc.N(paramClassLoader)).loadClass(paramString));
      return paramClassLoader;
    }
    catch (ClassNotFoundException paramClassLoader)
    {
      throw new IllegalStateException("Unable to find dynamic class " + paramString);
    }
  }
  
  private static <T> T e(Class<?> paramClass)
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
  
  private static boolean uJ()
  {
    return false;
  }
  
  private static Class<?> uK()
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
  
  private static Context z(Context paramContext)
  {
    if (UJ == null) {
      if (!uJ()) {
        break label20;
      }
    }
    label20:
    for (UJ = paramContext;; UJ = com.google.android.gms.common.d.z(paramContext)) {
      return UJ;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/maps/a/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */