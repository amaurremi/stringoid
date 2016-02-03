package com.pocket.tts;

public class o
  implements Comparable
{
  public final String a;
  public final String b;
  public final int c;
  public final int d;
  public final boolean e;
  
  private o(String paramString1, String paramString2, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramBoolean;
  }
  
  public int a(o paramo)
  {
    if ((this.e) && (!paramo.e)) {
      return -1;
    }
    if ((paramo.e) && (!this.e)) {
      return 1;
    }
    return paramo.d - this.d;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/tts/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */