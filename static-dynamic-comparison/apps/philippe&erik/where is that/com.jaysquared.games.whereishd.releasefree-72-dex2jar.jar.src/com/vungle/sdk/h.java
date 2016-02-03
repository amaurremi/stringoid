package com.vungle.sdk;

final class h
  extends e.a
{
  private double b;
  private double c;
  
  h(VunglePub.EventListener paramEventListener)
  {
    super(paramEventListener);
  }
  
  public final e.a a(double paramDouble1, double paramDouble2)
  {
    this.b = paramDouble1;
    this.c = paramDouble2;
    return this;
  }
  
  public final void run()
  {
    this.a.onVungleView(this.b, this.c);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/vungle/sdk/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */