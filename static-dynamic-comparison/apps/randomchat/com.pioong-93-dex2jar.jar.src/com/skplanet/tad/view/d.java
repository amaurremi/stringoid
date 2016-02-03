package com.skplanet.tad.view;

public class d
{
  private static d a;
  private long b;
  
  public static d b()
  {
    try
    {
      if (a == null) {
        a = new d();
      }
      d locald = a;
      return locald;
    }
    finally {}
  }
  
  public long a()
  {
    return this.b;
  }
  
  public void a(long paramLong)
  {
    this.b = paramLong;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/skplanet/tad/view/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */