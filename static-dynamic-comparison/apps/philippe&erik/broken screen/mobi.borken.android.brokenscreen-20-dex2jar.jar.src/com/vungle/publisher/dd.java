package com.vungle.publisher;

public abstract class dd<T>
  extends cs<T>
{
  protected final String a;
  protected final String b;
  
  public dd(String paramString1, boolean paramBoolean, String paramString2, String paramString3)
  {
    super(paramString1, null, paramBoolean, paramString2 + "." + paramString3 + "()");
    this.a = paramString2;
    this.b = paramString3;
  }
  
  public abstract T get();
  
  public String toString()
  {
    return getClass().getName() + "[key=" + this.provideKey + " method=" + this.a + "." + this.b + "()]";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/dd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */