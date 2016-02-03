package com.jumptap.adtag.actions;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.jumptap.adtag.JtAdView;

public class MapAdAction
  extends AdAction
{
  public void perform(Context paramContext, JtAdView paramJtAdView)
  {
    Log.i("JtAd", "Performing MapAdAction: " + this.redirectedUrl);
    Intent localIntent;
    if ((this.redirectedUrl != null) && (!"".equals(this.redirectedUrl)))
    {
      this.redirectedUrl = getRedirectedUrlWithPredicate(this.redirectedUrl, this.useragent, new AdAction.UrlPredicate()
      {
        public boolean test(String paramAnonymousString)
        {
          return "geo".equals(Uri.parse(paramAnonymousString).getScheme());
        }
      });
      if (this.redirectedUrl == null) {
        break label124;
      }
      localIntent = new Intent("android.intent.action.VIEW", Uri.parse(this.redirectedUrl));
      if (paramJtAdView == null) {}
    }
    try
    {
      paramJtAdView.setLaunchedActivity(true);
      paramJtAdView.notifyLaunchActivity();
      paramContext.startActivity(localIntent);
      return;
    }
    catch (ActivityNotFoundException paramContext)
    {
      Log.e("JtAd", "cannot initiate Map", paramContext);
      return;
    }
    label124:
    Log.i("JtAd", "no geo url to navigate to");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/jumptap/adtag/actions/MapAdAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */