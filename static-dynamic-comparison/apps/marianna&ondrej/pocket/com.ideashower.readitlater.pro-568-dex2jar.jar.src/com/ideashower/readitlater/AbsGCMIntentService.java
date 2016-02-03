package com.ideashower.readitlater;

import android.content.Context;
import android.content.Intent;
import com.google.android.a.a;
import com.ideashower.readitlater.a.am;
import com.ideashower.readitlater.a.an;
import com.ideashower.readitlater.util.NoObfuscation;

public abstract class AbsGCMIntentService
  extends a
  implements NoObfuscation
{
  public AbsGCMIntentService()
  {
    super(new String[] { an.a });
  }
  
  protected void onError(Context paramContext, String paramString)
  {
    an localan = (an)am.c();
    if (localan != null) {
      localan.a(paramContext, paramString);
    }
  }
  
  protected void onMessage(Context paramContext, Intent paramIntent)
  {
    an localan = (an)am.c();
    if (localan != null) {
      localan.a(paramContext, paramIntent);
    }
  }
  
  protected void onRegistered(Context paramContext, String paramString)
  {
    an localan = (an)am.c();
    if (localan != null) {
      localan.b(paramContext, paramString);
    }
  }
  
  protected void onUnregistered(Context paramContext, String paramString)
  {
    an localan = (an)am.c();
    if (localan != null) {
      localan.c(paramContext, paramString);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/AbsGCMIntentService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */