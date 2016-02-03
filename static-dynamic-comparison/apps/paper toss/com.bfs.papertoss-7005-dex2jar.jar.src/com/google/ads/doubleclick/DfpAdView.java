package com.google.ads.doubleclick;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import com.google.ads.AppEventListener;

public class DfpAdView
  extends AdView
{
  public DfpAdView(Activity paramActivity, AdSize paramAdSize, String paramString)
  {
    super(paramActivity, paramAdSize, paramString);
  }
  
  public DfpAdView(Activity paramActivity, AdSize[] paramArrayOfAdSize, String paramString)
  {
    super(paramActivity, paramArrayOfAdSize, paramString);
  }
  
  public DfpAdView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public DfpAdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void setAppEventListener(AppEventListener paramAppEventListener)
  {
    super.setAppEventListener(paramAppEventListener);
  }
  
  public void setSupportedAdSizes(AdSize... paramVarArgs)
  {
    super.setSupportedAdSizes(paramVarArgs);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/google/ads/doubleclick/DfpAdView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */