package com.vungle.publisher;

import com.vungle.publisher.log.Logger;
import javax.inject.Inject;

public class bh
  implements bi
{
  @Inject
  public di f;
  
  public final void b()
  {
    Logger.d("VungleEvent", getClass().getName() + " listening");
    di localdi = this.f;
    localdi.a(this, localdi.c, false);
  }
  
  public final void c()
  {
    Logger.d("VungleEvent", getClass().getName() + " listening (sticky)");
    di localdi = this.f;
    localdi.a(this, localdi.c, true);
  }
  
  public final void d()
  {
    Logger.d("VungleEvent", getClass().getName() + " unregistered");
    this.f.a(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/bh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */