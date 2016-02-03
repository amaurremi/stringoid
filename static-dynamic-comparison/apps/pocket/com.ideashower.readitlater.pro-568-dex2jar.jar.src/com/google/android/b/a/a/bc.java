package com.google.android.b.a.a;

import android.app.Activity;
import android.content.Context;
import android.os.IBinder;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class bc
{
  private static IBinder a(Class paramClass, IBinder paramIBinder1, IBinder paramIBinder2)
  {
    try
    {
      paramIBinder1 = (IBinder)paramClass.getConstructor(new Class[] { IBinder.class, IBinder.class }).newInstance(new Object[] { paramIBinder1, paramIBinder2 });
      return paramIBinder1;
    }
    catch (NoSuchMethodException paramIBinder1)
    {
      throw new bd("Could not find the right constructor for " + paramClass.getName(), paramIBinder1);
    }
    catch (InvocationTargetException paramIBinder1)
    {
      throw new bd("Exception thrown by invoked constructor in " + paramClass.getName(), paramIBinder1);
    }
    catch (InstantiationException paramIBinder1)
    {
      throw new bd("Unable to instantiate the dynamic class " + paramClass.getName(), paramIBinder1);
    }
    catch (IllegalAccessException paramIBinder1)
    {
      throw new bd("Unable to call the default constructor of " + paramClass.getName(), paramIBinder1);
    }
  }
  
  private static IBinder a(ClassLoader paramClassLoader, String paramString, IBinder paramIBinder1, IBinder paramIBinder2)
  {
    try
    {
      paramClassLoader = a(paramClassLoader.loadClass(paramString), paramIBinder1, paramIBinder2);
      return paramClassLoader;
    }
    catch (ClassNotFoundException paramClassLoader)
    {
      throw new bd("Unable to find dynamic class " + paramString, paramClassLoader);
    }
  }
  
  public static j a(Activity paramActivity, IBinder paramIBinder)
  {
    d.a(paramActivity, "activity cannot be null");
    d.a(paramIBinder, "serviceBinder cannot be null");
    Context localContext = bg.b(paramActivity);
    if (localContext == null) {
      throw new bd("Could not create remote context");
    }
    paramActivity = new a(paramActivity, localContext.getResources(), localContext.getClassLoader(), bg.a(paramActivity, localContext));
    return k.a(a(localContext.getClassLoader(), "com.google.android.youtube.api.jar.client.RemoteEmbeddedPlayer", bb.a(paramActivity).asBinder(), paramIBinder));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/b/a/a/bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */