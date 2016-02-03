package com.ideashower.readitlater.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class HTSActivity
  extends a
{
  public static Intent c(Context paramContext)
  {
    return new Intent(paramContext, HTSActivity.class);
  }
  
  public static void d(Context paramContext)
  {
    paramContext.startActivity(c(paramContext));
  }
  
  public String f()
  {
    return "how_to_save";
  }
  
  protected b l()
  {
    return b.a;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle == null) {
      b(w.Z());
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/HTSActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */