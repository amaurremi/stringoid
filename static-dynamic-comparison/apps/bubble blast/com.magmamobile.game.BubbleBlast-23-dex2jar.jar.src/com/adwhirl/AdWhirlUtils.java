package com.adwhirl;

import android.util.Log;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.adwhirl.obj.Extra2;
import com.google.ads.AdView;

public final class AdWhirlUtils
{
  public static final AdView findAdView(ViewGroup paramViewGroup)
  {
    int i;
    if (paramViewGroup != null) {
      i = 0;
    }
    for (;;)
    {
      if (i >= paramViewGroup.getChildCount()) {
        return null;
      }
      Object localObject = paramViewGroup.getChildAt(i);
      if ((localObject instanceof AdView)) {
        return (AdView)localObject;
      }
      if ((localObject instanceof ViewGroup))
      {
        localObject = findAdView((ViewGroup)localObject);
        if (localObject != null) {
          return (AdView)localObject;
        }
      }
      i += 1;
    }
  }
  
  public static final void killAdsenseAndAdmobWebViewOnDestroy(ViewGroup paramViewGroup)
  {
    for (;;)
    {
      int i;
      try
      {
        if ((paramViewGroup instanceof AdView))
        {
          if (Extra2.verboselog) {
            Log.d("AdWhirl SDK", "ADMOB ADSENSE WEBVIEW TO KILL");
          }
          paramViewGroup = (AdView)paramViewGroup;
          if (paramViewGroup != null)
          {
            i = 0;
            if (i >= paramViewGroup.getChildCount()) {
              return;
            }
            ViewGroup localViewGroup;
            int j;
            if ((paramViewGroup.getChildAt(i) instanceof ViewGroup))
            {
              if (Extra2.verboselog) {
                Log.d("AdWhirl SDK", "ViewGroup Inside Adsense View !");
              }
              localViewGroup = (ViewGroup)paramViewGroup.getChildAt(i);
              j = 0;
              if (j < localViewGroup.getChildCount()) {}
            }
            else
            {
              if (!(paramViewGroup.getChildAt(i) instanceof WebView)) {
                break label187;
              }
              if (Extra2.verboselog) {
                Log.e("AdWhirl SDK", "Admob Adsense WEBVIEW ! => ON DESTROY !!!");
              }
              ((WebView)paramViewGroup.getChildAt(i)).destroy();
              break label187;
            }
            if ((localViewGroup.getChildAt(j) instanceof WebView))
            {
              if (Extra2.verboselog) {
                Log.e("AdWhirl SDK", "Admob Adsense WEBVIEW ! => ON DESTROY !!!");
              }
              ((WebView)localViewGroup.getChildAt(j)).destroy();
            }
            j += 1;
            continue;
          }
        }
        return;
      }
      catch (Exception paramViewGroup)
      {
        if (Extra2.verboselog) {
          Log.e("AdWhirl SDK", "Adsense WEBVIEW onDestroy Failed !!!");
        }
        paramViewGroup.printStackTrace();
      }
      label187:
      i += 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/adwhirl/AdWhirlUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */