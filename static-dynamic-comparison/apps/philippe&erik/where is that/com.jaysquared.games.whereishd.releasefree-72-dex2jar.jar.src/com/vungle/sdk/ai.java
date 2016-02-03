package com.vungle.sdk;

public final class ai
{
  private static final ai a = new ai();
  private VungleBitmapFactory b;
  
  public static ai a()
  {
    return a;
  }
  
  public final void a(VungleBitmapFactory paramVungleBitmapFactory)
  {
    this.b = paramVungleBitmapFactory;
  }
  
  public final VungleBitmapFactory b()
  {
    if (this.b == null) {
      this.b = b.a();
    }
    return this.b;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/vungle/sdk/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */