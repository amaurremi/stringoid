package com.vungle.publisher;

public abstract class cz
{
  private final da<ClassLoader, da<String, Class<?>>> a = new da() {};
  
  public abstract cs<?> a(String paramString1, String paramString2, ClassLoader paramClassLoader, boolean paramBoolean);
  
  public abstract <T> db<T> a(Class<T> paramClass);
  
  protected final Class<?> a(ClassLoader paramClassLoader, String paramString)
  {
    if (paramClassLoader != null) {}
    for (;;)
    {
      return (Class)((da)this.a.b(paramClassLoader)).b(paramString);
      paramClassLoader = ClassLoader.getSystemClassLoader();
    }
  }
  
  protected final <T> T a(String paramString, ClassLoader paramClassLoader)
  {
    try
    {
      paramClassLoader = a(paramClassLoader, paramString);
      if (paramClassLoader == Void.class) {
        return null;
      }
      paramClassLoader = paramClassLoader.newInstance();
      return paramClassLoader;
    }
    catch (InstantiationException paramClassLoader)
    {
      throw new RuntimeException("Failed to initialize " + paramString, paramClassLoader);
    }
    catch (IllegalAccessException paramClassLoader)
    {
      throw new RuntimeException("Failed to initialize " + paramString, paramClassLoader);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/cz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */