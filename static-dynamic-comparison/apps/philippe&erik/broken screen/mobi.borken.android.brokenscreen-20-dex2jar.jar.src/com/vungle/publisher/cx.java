package com.vungle.publisher;

final class cx<T>
  extends cs<co<T>>
{
  private static final Object a = new Object();
  private final String b;
  private final ClassLoader c;
  private cs<T> d;
  
  public cx(String paramString1, Object paramObject, ClassLoader paramClassLoader, String paramString2)
  {
    super(paramString1, null, false, paramObject);
    this.c = paramClassLoader;
    this.b = paramString2;
  }
  
  public final void attach(cy paramcy)
  {
    this.d = paramcy.a(this.b, this.requiredBy, this.c);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/cx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */