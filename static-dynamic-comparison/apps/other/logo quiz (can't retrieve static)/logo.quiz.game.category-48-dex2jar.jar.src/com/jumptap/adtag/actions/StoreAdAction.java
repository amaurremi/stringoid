package com.jumptap.adtag.actions;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.jumptap.adtag.JtAdView;

public class StoreAdAction
  extends AdAction
{
  public void perform(Context paramContext, JtAdView paramJtAdView)
  {
    Log.i("JtAd", "Performing StoreAdAction: " + this.redirectedUrl);
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(this.redirectedUrl));
    if (paramJtAdView != null) {}
    try
    {
      paramJtAdView.setLaunchedActivity(true);
      paramJtAdView.notifyLaunchActivity();
      paramContext.startActivity(localIntent);
      return;
    }
    catch (ActivityNotFoundException paramContext)
    {
      Log.e("JtAd", "cannot initiate Store", paramContext);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/jumptap/adtag/actions/StoreAdAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */