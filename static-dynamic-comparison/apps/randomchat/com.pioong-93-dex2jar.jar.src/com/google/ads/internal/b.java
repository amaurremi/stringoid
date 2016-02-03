package com.google.ads.internal;

public final class b
  extends Exception
{
  public final boolean a;
  
  public b(String paramString, boolean paramBoolean)
  {
    super(paramString);
    this.a = paramBoolean;
  }
  
  public b(String paramString, boolean paramBoolean, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
    this.a = paramBoolean;
  }
  
  public void a(String paramString)
  {
    com.google.ads.util.b.b(c(paramString));
    com.google.ads.util.b.a(null, this);
  }
  
  public void b(String paramString)
  {
    String str = c(paramString);
    if (this.a) {}
    for (paramString = this;; paramString = null) {
      throw new RuntimeException(str, paramString);
    }
  }
  
  public String c(String paramString)
  {
    String str = paramString;
    if (this.a) {
      str = paramString + ": " + getMessage();
    }
    return str;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/google/ads/internal/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */