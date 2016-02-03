package com.vungle.publisher;

public final class cv
  extends cz
{
  private final da<Class<?>, db<?>> a = new da() {};
  
  public final cs<?> a(String paramString1, String paramString2, ClassLoader paramClassLoader, boolean paramBoolean)
  {
    cs localcs = (cs)a(paramString2.concat("$$InjectAdapter"), paramClassLoader);
    if (localcs != null) {
      return localcs;
    }
    paramClassLoader = a(paramClassLoader, paramString2);
    if (paramClassLoader.equals(Void.class)) {
      throw new IllegalStateException(String.format("Could not load class %s needed for binding %s", new Object[] { paramString2, paramString1 }));
    }
    if (paramClassLoader.isInterface()) {
      return null;
    }
    return df.a(paramClassLoader, paramBoolean);
  }
  
  public final <T> db<T> a(Class<T> paramClass)
  {
    return (db)this.a.b(paramClass);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/cv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */