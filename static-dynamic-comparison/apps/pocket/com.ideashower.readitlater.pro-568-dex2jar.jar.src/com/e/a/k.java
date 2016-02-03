package com.e.a;

public final class k
{
  private final String a;
  private final String b;
  
  public k(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof k)) && (((k)paramObject).a.equals(this.a)) && (((k)paramObject).b.equals(this.b));
  }
  
  public int hashCode()
  {
    return this.a.hashCode() + this.b.hashCode() * 31;
  }
  
  public String toString()
  {
    return this.a + " realm=\"" + this.b + "\"";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/e/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */