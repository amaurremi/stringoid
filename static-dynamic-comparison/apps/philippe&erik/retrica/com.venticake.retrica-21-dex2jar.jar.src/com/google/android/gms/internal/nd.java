package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;

class nd
  extends MutableContextWrapper
{
  private Activity a;
  private Context b;
  
  public nd(Context paramContext)
  {
    super(paramContext);
    setBaseContext(paramContext);
  }
  
  public Context a()
  {
    return this.a;
  }
  
  public void setBaseContext(Context paramContext)
  {
    this.b = paramContext.getApplicationContext();
    if ((paramContext instanceof Activity)) {}
    for (paramContext = (Activity)paramContext;; paramContext = null)
    {
      this.a = paramContext;
      super.setBaseContext(this.b);
      return;
    }
  }
  
  public void startActivity(Intent paramIntent)
  {
    if (this.a != null)
    {
      this.a.startActivity(paramIntent);
      return;
    }
    paramIntent.setFlags(268435456);
    this.b.startActivity(paramIntent);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/nd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */