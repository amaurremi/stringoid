package com.mopub.mobileads;

import android.content.Intent;
import android.view.View;

public class MoPubActivity
  extends BaseActivity
  implements MoPubView.OnAdLoadedListener
{
  public static final int MOPUB_ACTIVITY_NO_AD = 1234;
  private MoPubView mMoPubView;
  
  private String sourceWithImpressionTrackingDisabled(String paramString)
  {
    return paramString.replaceAll("http://ads.mopub.com/m/imp", "mopub://null");
  }
  
  public void OnAdLoaded(MoPubView paramMoPubView)
  {
    paramMoPubView.adAppeared();
  }
  
  public View getAdView()
  {
    String str1 = getIntent().getStringExtra("com.mopub.mobileads.AdUnitId");
    String str2 = getIntent().getStringExtra("com.mopub.mobileads.Keywords");
    String str3 = getIntent().getStringExtra("com.mopub.mobileads.ClickthroughUrl");
    int i = getIntent().getIntExtra("com.mopub.mobileads.Timeout", 0);
    if (str1 == null) {
      throw new RuntimeException("AdUnitId isn't set in com.mopub.mobileads.MoPubActivity");
    }
    this.mMoPubView = new MoPubView(this);
    this.mMoPubView.setAdUnitId(str1);
    this.mMoPubView.setKeywords(str2);
    this.mMoPubView.setClickthroughUrl(str3);
    this.mMoPubView.setTimeout(i);
    this.mMoPubView.setOnAdLoadedListener(this);
    str1 = getIntent().getStringExtra("com.mopub.mobileads.Source");
    if (str1 != null)
    {
      str1 = sourceWithImpressionTrackingDisabled(str1);
      this.mMoPubView.loadHtmlString(str1);
    }
    return this.mMoPubView;
  }
  
  protected void onDestroy()
  {
    this.mMoPubView.destroy();
    super.onDestroy();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/mopub/mobileads/MoPubActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */