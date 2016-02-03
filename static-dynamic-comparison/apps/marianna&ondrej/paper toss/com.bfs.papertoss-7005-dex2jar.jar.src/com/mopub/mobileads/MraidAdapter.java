package com.mopub.mobileads;

import android.widget.FrameLayout.LayoutParams;

public class MraidAdapter
  extends BaseAdapter
{
  private MraidView mMraidView;
  private boolean mPreviousAutorefreshSetting;
  
  private void initMraidListeners()
  {
    this.mMraidView.setOnReadyListener(new MraidView.OnReadyListener()
    {
      public void onReady(MraidView paramAnonymousMraidView)
      {
        if (!MraidAdapter.this.isInvalidated())
        {
          MraidAdapter.this.mMoPubView.nativeAdLoaded();
          MraidAdapter.this.mMoPubView.trackNativeImpression();
        }
      }
    });
    this.mMraidView.setOnExpandListener(new MraidView.OnExpandListener()
    {
      public void onExpand(MraidView paramAnonymousMraidView)
      {
        if (!MraidAdapter.this.isInvalidated())
        {
          MraidAdapter.access$002(MraidAdapter.this, MraidAdapter.this.mMoPubView.getAutorefreshEnabled());
          MraidAdapter.this.mMoPubView.setAutorefreshEnabled(false);
          MraidAdapter.this.mMoPubView.adPresentedOverlay();
          MraidAdapter.this.mMoPubView.registerClick();
        }
      }
    });
    this.mMraidView.setOnCloseListener(new MraidView.OnCloseListener()
    {
      public void onClose(MraidView paramAnonymousMraidView, MraidView.ViewState paramAnonymousViewState)
      {
        if (!MraidAdapter.this.isInvalidated())
        {
          MraidAdapter.this.mMoPubView.setAutorefreshEnabled(MraidAdapter.this.mPreviousAutorefreshSetting);
          MraidAdapter.this.mMoPubView.adClosed();
        }
      }
    });
    this.mMraidView.setOnFailureListener(new MraidView.OnFailureListener()
    {
      public void onFailure(MraidView paramAnonymousMraidView)
      {
        if (!MraidAdapter.this.isInvalidated()) {
          MraidAdapter.this.mMoPubView.loadFailUrl();
        }
      }
    });
  }
  
  public void init(MoPubView paramMoPubView, String paramString)
  {
    super.init(paramMoPubView, paramString);
    this.mPreviousAutorefreshSetting = false;
  }
  
  public void invalidate()
  {
    this.mMoPubView = null;
    if (this.mMraidView != null) {
      this.mMraidView.destroy();
    }
    super.invalidate();
  }
  
  public void loadAd()
  {
    if (isInvalidated()) {
      return;
    }
    this.mMraidView = new MraidView(this.mMoPubView.getContext());
    this.mMraidView.loadHtmlData(this.mJsonParams);
    initMraidListeners();
    this.mMoPubView.removeAllViews();
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    localLayoutParams.gravity = 17;
    this.mMoPubView.addView(this.mMraidView, localLayoutParams);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/mopub/mobileads/MraidAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */