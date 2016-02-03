package org.apache.a.c;

public enum d
{
  private float j;
  private String k;
  
  private d(float paramFloat, String paramString1)
  {
    this.j = paramFloat;
    this.k = paramString1;
  }
  
  static d a(String paramString)
  {
    if ("0.9".equals(paramString)) {
      return a;
    }
    if ("1.1".equals(paramString)) {
      return b;
    }
    if ("1.2".equals(paramString)) {
      return c;
    }
    if ("1.3".equals(paramString)) {
      return d;
    }
    if ("1.4".equals(paramString)) {
      return e;
    }
    if ("1.5".equals(paramString)) {
      return f;
    }
    if ("1.6".equals(paramString)) {
      return g;
    }
    if ("1.7".equals(paramString)) {
      return h;
    }
    if ("1.8".equals(paramString)) {
      return i;
    }
    return null;
  }
  
  public String toString()
  {
    return this.k;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/apache/a/c/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */