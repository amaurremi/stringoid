package com.pocket.tts;

import java.util.HashMap;

public class d
{
  public final String a;
  public final g b;
  public final int c;
  public final boolean d;
  public final int e;
  public final int f;
  public final int g;
  protected final HashMap h = new HashMap();
  
  private d(String paramString, g paramg, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a = paramString;
    this.b = paramg;
    this.c = paramInt1;
    this.d = paramBoolean;
    this.e = paramInt2;
    this.f = paramInt3;
    this.g = paramInt4;
    this.h.put("utteranceId", String.valueOf(paramInt4));
  }
  
  public boolean a()
  {
    return this.f >= 0;
  }
  
  public String toString()
  {
    return "Utterance [text=" + this.a + ", jQuerySelector=" + this.b + ", nodeIndex=" + this.c + ", isHeader=" + this.d + ", endPosition=" + this.e + ", segmentIndex=" + this.f + ", position=" + this.g + "]";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/tts/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */