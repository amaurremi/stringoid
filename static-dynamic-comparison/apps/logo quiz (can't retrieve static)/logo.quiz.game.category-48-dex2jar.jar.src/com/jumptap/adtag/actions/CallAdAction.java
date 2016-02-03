package com.jumptap.adtag.actions;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.jumptap.adtag.JtAdView;

public class CallAdAction
  extends AdAction
{
  public void perform(Context paramContext, JtAdView paramJtAdView)
  {
    Log.i("JtAd", "Performing CallAdAction: " + this.redirectedUrl);
    if (this.redirectedUrl != null)
    {
      this.redirectedUrl = getRedirectedUrlWithPredicate(this.redirectedUrl, this.useragent, new AdAction.UrlPredicate()
      {
        public boolean test(String paramAnonymousString)
        {
          return "tel".equals(Uri.parse(paramAnonymousString).getScheme());
        }
      });
      if (this.redirectedUrl == null) {
        break label130;
      }
      if (paramJtAdView == null) {}
    }
    try
    {
      paramJtAdView.setLaunchedActivity(true);
      paramJtAdView.notifyLaunchActivity();
      paramContext.startActivity(new Intent("android.intent.action.DIAL", Uri.parse(this.redirectedUrl)));
      return;
    }
    catch (ActivityNotFoundException paramContext)
    {
      Log.e("JtAd", "cannot initiate phone call:url=" + this.redirectedUrl, paramContext);
      return;
    }
    label130:
    Log.i("JtAd", "no tel url to dial");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/jumptap/adtag/actions/CallAdAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */