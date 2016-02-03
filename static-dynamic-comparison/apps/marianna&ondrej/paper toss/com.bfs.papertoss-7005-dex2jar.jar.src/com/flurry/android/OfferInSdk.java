package com.flurry.android;

public final class OfferInSdk
{
  long a;
  p b;
  String c;
  String d;
  int e;
  AdImage f;
  
  OfferInSdk(long paramLong, p paramp, AdImage paramAdImage, String paramString1, String paramString2, int paramInt)
  {
    this.a = paramLong;
    this.b = paramp;
    this.c = paramString1;
    this.f = paramAdImage;
    this.d = paramString2;
    this.e = paramInt;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[id=" + this.a).append(",name=" + this.c + "]");
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/flurry/android/OfferInSdk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */