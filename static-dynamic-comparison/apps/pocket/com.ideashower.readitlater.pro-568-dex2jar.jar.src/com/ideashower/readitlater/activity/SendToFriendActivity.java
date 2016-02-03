package com.ideashower.readitlater.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.d;
import com.ideashower.readitlater.db.operation.action.UiContext;
import com.ideashower.readitlater.views.ak;
import com.pocket.p.k;
import com.pocket.p.l;

public class SendToFriendActivity
  extends a
{
  public static Intent a(Context paramContext, ak paramak, int paramInt, UiContext paramUiContext)
  {
    return a(paramContext, paramak, paramInt, paramUiContext, false);
  }
  
  private static Intent a(Context paramContext, ak paramak, int paramInt, UiContext paramUiContext, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (paramContext = new Intent(paramContext, StandAloneSendToFriendActivity.class);; paramContext = new Intent(paramContext, SendToFriendActivity.class))
    {
      paramContext.putExtra("item", paramak.f());
      paramContext.putExtra("friendId", paramInt);
      paramContext.putExtra("uiContext", paramUiContext);
      paramContext.putExtra("isStandAlone", paramBoolean);
      return paramContext;
    }
  }
  
  public static Intent b(Context paramContext, ak paramak, int paramInt, UiContext paramUiContext)
  {
    return a(paramContext, paramak, paramInt, paramUiContext, true);
  }
  
  public static void c(Context paramContext, ak paramak, int paramInt, UiContext paramUiContext)
  {
    paramContext.startActivity(a(paramContext, paramak, paramInt, paramUiContext));
  }
  
  public String f()
  {
    return "send_to_friend";
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
      paramBundle = getIntent();
      paramBundle = ba.a(new ak(paramBundle.getBundleExtra("item")), paramBundle.getIntExtra("friendId", 0), (UiContext)paramBundle.getParcelableExtra("uiContext"));
      if (v.Y() == l.b) {
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/SendToFriendActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */