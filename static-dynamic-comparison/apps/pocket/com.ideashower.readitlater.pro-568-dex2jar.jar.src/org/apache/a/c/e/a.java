package org.apache.a.c.e;

public class a
  extends Number
  implements Comparable
{
  private int a;
  
  public a() {}
  
  public a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public int a(a parama)
  {
    int i = parama.a;
    if (this.a < i) {
      return -1;
    }
    if (this.a == i) {
      return 0;
    }
    return 1;
  }
  
  public void a()
  {
    this.a += 1;
  }
  
  public double doubleValue()
  {
    return this.a;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof a))
    {
      bool1 = bool2;
      if (this.a == ((a)paramObject).intValue()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public float floatValue()
  {
    return this.a;
  }
  
  public int hashCode()
  {
    return this.a;
  }
  
  public int intValue()
  {
    return this.a;
  }
  
  public long longValue()
  {
    return this.a;
  }
  
  public String toString()
  {
    return String.valueOf(this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/apache/a/c/e/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */