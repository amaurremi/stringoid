package com.appbrain.a;

final class i
{
  private final StringBuilder a = new StringBuilder();
  
  private i a(String paramString1, String paramString2)
  {
    this.a.append("&");
    this.a.append(paramString1);
    this.a.append("=");
    this.a.append(paramString2);
    return this;
  }
  
  public final i a(int paramInt)
  {
    return a("it", String.valueOf(paramInt));
  }
  
  public final i a(String paramString)
  {
    return a("ic", paramString);
  }
  
  public final i a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "1";; str = "0") {
      return a("sm", str);
    }
  }
  
  public final i b(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "1";; str = "0") {
      return a("mb", str);
    }
  }
  
  public final String toString()
  {
    return this.a.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */