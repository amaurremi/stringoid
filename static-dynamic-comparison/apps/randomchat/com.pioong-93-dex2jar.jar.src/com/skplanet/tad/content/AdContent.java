package com.skplanet.tad.content;

public abstract class AdContent
{
  private String a;
  private int b;
  private String c;
  
  public abstract AD_TYPE a();
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public String b()
  {
    return this.a;
  }
  
  public void b(String paramString)
  {
    this.c = paramString;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public static enum AD_TYPE {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/skplanet/tad/content/AdContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */