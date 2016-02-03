package com.vungle.publisher;

final class cu<T>
  extends cs<T>
{
  private final String a;
  private final ClassLoader b;
  private cs<?> c;
  
  public cu(String paramString1, Object paramObject, ClassLoader paramClassLoader, String paramString2)
  {
    super(paramString1, null, false, paramObject);
    this.b = paramClassLoader;
    this.a = paramString2;
  }
  
  public final void attach(cy paramcy)
  {
    this.c = paramcy.a(this.a, this.requiredBy, this.b);
  }
  
  public final T get()
  {
    return this.c;
  }
  
  public final void injectMembers(T paramT)
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/cu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */