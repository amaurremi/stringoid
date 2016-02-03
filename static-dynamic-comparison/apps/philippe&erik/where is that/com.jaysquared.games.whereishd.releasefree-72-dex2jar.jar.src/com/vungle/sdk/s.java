package com.vungle.sdk;

import java.util.ArrayList;

final class s
  extends y.g
{
  s(VungleAdvert paramVungleAdvert) {}
  
  public final void a()
  {
    ay.c().a("videoerror");
    VungleAdvert.a(this.a, 3);
    VungleAdvert.b(this.a);
  }
  
  public final void a(long paramLong1, long paramLong2)
  {
    new StringBuilder("Video Completion. Len: ").append(paramLong2 / 1000.0D);
    ay.d().a = paramLong1;
    ay.d().c = paramLong2;
    ay.d().b = paramLong2;
    ay.c().d.add(VungleAdvert.a());
    VungleAdvert.a(this.a, 3);
    VungleAdvert.b(this.a);
  }
  
  public final void a(long paramLong1, long paramLong2, long paramLong3)
  {
    new StringBuilder("Video Cancelled. Watched ").append(paramLong2 / 1000.0D).append(" of ").append(paramLong3 / 1000.0D);
    ay.d().a = paramLong1;
    ay.d().c = paramLong2;
    ay.d().b = paramLong3;
    ay.c().d.add(VungleAdvert.a());
    VungleAdvert.a(this.a, 3);
    VungleAdvert.b(this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/vungle/sdk/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */