package com.jumptap.adtag.actions;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.jumptap.adtag.JtAdView;

public class YouTubeAdAction
  extends AdAction
{
  private static final String CLASS_NAME1 = "com.google.android.youtube.YouTubePlayer";
  private static final String CLASS_NAME2 = "com.google.android.youtube.PlayerActivity";
  private static final String PACKAGE_NAME = "com.google.android.youtube";
  
  private void openYoutubePlayer(Context paramContext, Uri paramUri, String paramString)
  {
    paramUri = new Intent("android.intent.action.VIEW", paramUri);
    paramUri.setComponent(new ComponentName("com.google.android.youtube", paramString));
    paramUri.setFlags(268435456);
    paramContext.startActivity(paramUri);
  }
  
  public void perform(Context paramContext, JtAdView paramJtAdView)
  {
    Log.i("JtAd", "Performing YouTubeAdAction:" + this.redirectedUrl);
    Uri localUri = Uri.parse(this.redirectedUrl);
    if (paramJtAdView != null)
    {
      paramJtAdView.setLaunchedActivity(true);
      paramJtAdView.notifyLaunchActivity();
    }
    try
    {
      openYoutubePlayer(paramContext, localUri, "com.google.android.youtube.PlayerActivity");
      return;
    }
    catch (ActivityNotFoundException paramJtAdView)
    {
      Log.e("JtAd", "cannot start activity: com.google.android.youtube.PlayerActivity");
      Log.e("JtAd", paramJtAdView.getMessage());
      try
      {
        openYoutubePlayer(paramContext, localUri, "com.google.android.youtube.YouTubePlayer");
        return;
      }
      catch (ActivityNotFoundException paramJtAdView)
      {
        Log.e("JtAd", "cannot start activity: com.google.android.youtube.YouTubePlayer");
        Log.e("JtAd", paramJtAdView.getMessage());
        paramContext.startActivity(new Intent("android.intent.action.VIEW", localUri));
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/jumptap/adtag/actions/YouTubeAdAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */