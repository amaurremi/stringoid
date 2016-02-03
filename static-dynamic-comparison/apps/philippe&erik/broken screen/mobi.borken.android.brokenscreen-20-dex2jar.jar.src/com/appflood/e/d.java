package com.appflood.e;

import android.content.Context;
import android.content.Intent;

public final class d
  implements Runnable
{
  public d(Context paramContext, Intent paramIntent) {}
  
  public final void run()
  {
    try
    {
      this.a.startActivity(this.b);
      return;
    }
    catch (Throwable localThrowable)
    {
      j.b(localThrowable, "startActivity failed");
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appflood/e/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */