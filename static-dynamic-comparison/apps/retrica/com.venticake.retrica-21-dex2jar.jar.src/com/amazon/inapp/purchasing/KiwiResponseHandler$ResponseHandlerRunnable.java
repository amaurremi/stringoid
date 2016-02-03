package com.amazon.inapp.purchasing;

import android.content.Context;
import android.content.Intent;

abstract class KiwiResponseHandler$ResponseHandlerRunnable
  implements Runnable
{
  private final Context _context;
  private final Intent _intent;
  
  public KiwiResponseHandler$ResponseHandlerRunnable(KiwiResponseHandler paramKiwiResponseHandler, Context paramContext, Intent paramIntent)
  {
    this._context = paramContext;
    this._intent = paramIntent;
  }
  
  protected final Context getContext()
  {
    return this._context;
  }
  
  protected final Intent getIntent()
  {
    return this._intent;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazon/inapp/purchasing/KiwiResponseHandler$ResponseHandlerRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */