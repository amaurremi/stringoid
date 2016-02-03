package com.vungle.publisher;

public abstract class p<T, V>
{
  public final String a;
  private final Class<V> b;
  
  public p(Class<V> paramClass, String paramString)
  {
    this.a = paramString;
    this.b = paramClass;
  }
  
  public abstract V a(T paramT);
  
  public void a(T paramT, V paramV)
  {
    throw new UnsupportedOperationException("Property " + this.a + " is read-only");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */