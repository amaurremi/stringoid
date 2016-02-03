package com.flurry.android;

public final class Offer
{
  private long a;
  private String b;
  private String c;
  private int d;
  private AdImage e;
  
  Offer(long paramLong, AdImage paramAdImage, String paramString1, String paramString2, int paramInt)
  {
    this.a = paramLong;
    this.b = paramString1;
    this.e = paramAdImage;
    this.c = paramString2;
    this.d = paramInt;
  }
  
  public final String getDescription()
  {
    return this.c;
  }
  
  public final long getId()
  {
    return this.a;
  }
  
  public final AdImage getImage()
  {
    return this.e;
  }
  
  public final String getName()
  {
    return this.b;
  }
  
  public final int getPrice()
  {
    return this.d;
  }
  
  public final String getUrl()
  {
    return "";
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[id=" + this.a + ",name=" + this.b + ",price=" + this.d + ", image size: " + this.e.e.length);
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/flurry/android/Offer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */