package org.a.a.e;

import java.io.DataInput;

final class g
{
  final e a;
  final String b;
  final int c;
  
  g(e parame, String paramString, int paramInt)
  {
    this.a = parame;
    this.b = paramString;
    this.c = paramInt;
  }
  
  static g a(DataInput paramDataInput)
  {
    return new g(e.a(paramDataInput), paramDataInput.readUTF(), (int)c.a(paramDataInput));
  }
  
  public long a(long paramLong, int paramInt1, int paramInt2)
  {
    return this.a.a(paramLong, paramInt1, paramInt2);
  }
  
  public String a()
  {
    return this.b;
  }
  
  public int b()
  {
    return this.c;
  }
  
  public long b(long paramLong, int paramInt1, int paramInt2)
  {
    return this.a.b(paramLong, paramInt1, paramInt2);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof g)) {
        break;
      }
      paramObject = (g)paramObject;
    } while ((this.c == ((g)paramObject).c) && (this.b.equals(((g)paramObject).b)) && (this.a.equals(((g)paramObject).a)));
    return false;
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/a/a/e/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */