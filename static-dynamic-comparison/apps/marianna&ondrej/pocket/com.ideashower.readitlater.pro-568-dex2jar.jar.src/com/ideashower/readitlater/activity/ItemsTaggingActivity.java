package com.ideashower.readitlater.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.d;
import com.pocket.p.k;
import com.pocket.p.l;

public class ItemsTaggingActivity
  extends a
{
  public static void a(Context paramContext, Bundle paramBundle, boolean paramBoolean)
  {
    paramContext.startActivity(b(paramContext, paramBundle, paramBoolean));
  }
  
  public static Intent b(Context paramContext, Bundle paramBundle, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (paramContext = new Intent(paramContext, StandaloneItemsTaggingActivity.class);; paramContext = new Intent(paramContext, ItemsTaggingActivity.class))
    {
      paramContext.putExtra("args", paramBundle);
      paramContext.putExtra("isStandAlone", paramBoolean);
      return paramContext;
    }
  }
  
  public String f()
  {
    return "edit_tags";
  }
  
  protected b l()
  {
    return b.a;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle == null)
    {
      paramBundle = ad.l(getIntent().getBundleExtra("args"));
      if (ad.Y() == l.b) {
        b(paramBundle);
      }
    }
    else
    {
      return;
    }
    k.a((d)paramBundle, this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/ItemsTaggingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */