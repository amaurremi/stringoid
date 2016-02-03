package com.google.ads;

import com.google.android.gms.ads.c;

@Deprecated
public final class a
{
  public static final a gI = new a(-1, -2, "mb");
  public static final a gJ = new a(320, 50, "mb");
  public static final a gK = new a(300, 250, "as");
  public static final a gL = new a(468, 60, "as");
  public static final a gM = new a(728, 90, "as");
  public static final a gN = new a(160, 600, "as");
  private final c gH;
  
  private a(int paramInt1, int paramInt2, String paramString)
  {
    this(new c(paramInt1, paramInt2));
  }
  
  public a(c paramc)
  {
    this.gH = paramc;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof a)) {
      return false;
    }
    paramObject = (a)paramObject;
    return this.gH.equals(((a)paramObject).gH);
  }
  
  public int hashCode()
  {
    return this.gH.hashCode();
  }
  
  public String toString()
  {
    return this.gH.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/ads/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */