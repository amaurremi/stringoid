package com.google.android.b.a.a;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater.Factory;
import android.view.View;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

final class b
  implements LayoutInflater.Factory
{
  private final ClassLoader a;
  
  public b(ClassLoader paramClassLoader)
  {
    this.a = ((ClassLoader)d.a(paramClassLoader, "remoteClassLoader cannot be null"));
  }
  
  public final View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    try
    {
      paramString = (View)this.a.loadClass(paramString).asSubclass(View.class).getConstructor(a.a()).newInstance(new Object[] { paramContext, paramAttributeSet });
      return paramString;
    }
    catch (NoClassDefFoundError paramString)
    {
      return null;
    }
    catch (ClassNotFoundException paramString)
    {
      return null;
    }
    catch (NoSuchMethodException paramString)
    {
      return null;
    }
    catch (IllegalArgumentException paramString)
    {
      return null;
    }
    catch (InstantiationException paramString)
    {
      return null;
    }
    catch (IllegalAccessException paramString)
    {
      return null;
    }
    catch (InvocationTargetException paramString) {}
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/b/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */