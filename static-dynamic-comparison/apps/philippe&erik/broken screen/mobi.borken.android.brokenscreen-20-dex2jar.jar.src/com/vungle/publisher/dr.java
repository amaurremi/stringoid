package com.vungle.publisher;

final class dr
{
  final Object a;
  final dp b;
  final int c;
  volatile boolean d;
  
  dr(Object paramObject, dp paramdp)
  {
    this.a = paramObject;
    this.b = paramdp;
    this.c = 0;
    this.d = true;
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof dr))
    {
      paramObject = (dr)paramObject;
      bool1 = bool2;
      if (this.a == ((dr)paramObject).a)
      {
        bool1 = bool2;
        if (this.b.equals(((dr)paramObject).b)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public final int hashCode()
  {
    return this.a.hashCode() + this.b.d.hashCode();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/dr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */