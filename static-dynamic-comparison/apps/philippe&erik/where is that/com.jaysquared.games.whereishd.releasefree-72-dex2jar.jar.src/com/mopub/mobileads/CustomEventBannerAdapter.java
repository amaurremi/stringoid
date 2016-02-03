package com.mopub.mobileads;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import java.util.Map;

public class CustomEventBannerAdapter
  implements CustomEventBanner.CustomEventBannerListener
{
  public static final int DEFAULT_BANNER_TIMEOUT_DELAY = 10000;
  private Context mContext;
  private CustomEventBanner mCustomEventBanner;
  private final Handler mHandler;
  private boolean mInvalidated;
  private Map<String, Object> mLocalExtras;
  private MoPubView mMoPubView;
  private Map<String, String> mServerExtras;
  private boolean mStoredAutorefresh;
  private final Runnable mTimeout;
  
  /* Error */
  public CustomEventBannerAdapter(MoPubView paramMoPubView, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 36	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: new 38	android/os/Handler
    //   8: dup
    //   9: invokespecial 39	android/os/Handler:<init>	()V
    //   12: putfield 41	com/mopub/mobileads/CustomEventBannerAdapter:mHandler	Landroid/os/Handler;
    //   15: aload_0
    //   16: aload_1
    //   17: putfield 43	com/mopub/mobileads/CustomEventBannerAdapter:mMoPubView	Lcom/mopub/mobileads/MoPubView;
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 49	com/mopub/mobileads/MoPubView:getContext	()Landroid/content/Context;
    //   25: putfield 51	com/mopub/mobileads/CustomEventBannerAdapter:mContext	Landroid/content/Context;
    //   28: aload_0
    //   29: new 53	java/util/HashMap
    //   32: dup
    //   33: invokespecial 54	java/util/HashMap:<init>	()V
    //   36: putfield 56	com/mopub/mobileads/CustomEventBannerAdapter:mLocalExtras	Ljava/util/Map;
    //   39: aload_0
    //   40: new 53	java/util/HashMap
    //   43: dup
    //   44: invokespecial 54	java/util/HashMap:<init>	()V
    //   47: putfield 58	com/mopub/mobileads/CustomEventBannerAdapter:mServerExtras	Ljava/util/Map;
    //   50: aload_0
    //   51: new 8	com/mopub/mobileads/CustomEventBannerAdapter$1
    //   54: dup
    //   55: aload_0
    //   56: invokespecial 61	com/mopub/mobileads/CustomEventBannerAdapter$1:<init>	(Lcom/mopub/mobileads/CustomEventBannerAdapter;)V
    //   59: putfield 63	com/mopub/mobileads/CustomEventBannerAdapter:mTimeout	Ljava/lang/Runnable;
    //   62: ldc 65
    //   64: new 67	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   71: ldc 70
    //   73: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: aload_2
    //   77: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokestatic 84	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   86: pop
    //   87: aload_0
    //   88: aload_2
    //   89: invokestatic 90	com/mopub/mobileads/factories/CustomEventBannerFactory:create	(Ljava/lang/String;)Lcom/mopub/mobileads/CustomEventBanner;
    //   92: putfield 92	com/mopub/mobileads/CustomEventBannerAdapter:mCustomEventBanner	Lcom/mopub/mobileads/CustomEventBanner;
    //   95: aload_0
    //   96: aload_3
    //   97: invokestatic 98	com/mopub/mobileads/util/Json:jsonStringToMap	(Ljava/lang/String;)Ljava/util/Map;
    //   100: putfield 58	com/mopub/mobileads/CustomEventBannerAdapter:mServerExtras	Ljava/util/Map;
    //   103: aload_0
    //   104: aload_0
    //   105: getfield 43	com/mopub/mobileads/CustomEventBannerAdapter:mMoPubView	Lcom/mopub/mobileads/MoPubView;
    //   108: invokevirtual 102	com/mopub/mobileads/MoPubView:getLocalExtras	()Ljava/util/Map;
    //   111: putfield 56	com/mopub/mobileads/CustomEventBannerAdapter:mLocalExtras	Ljava/util/Map;
    //   114: aload_0
    //   115: getfield 43	com/mopub/mobileads/CustomEventBannerAdapter:mMoPubView	Lcom/mopub/mobileads/MoPubView;
    //   118: invokevirtual 106	com/mopub/mobileads/MoPubView:getLocation	()Landroid/location/Location;
    //   121: ifnull +22 -> 143
    //   124: aload_0
    //   125: getfield 56	com/mopub/mobileads/CustomEventBannerAdapter:mLocalExtras	Ljava/util/Map;
    //   128: ldc 108
    //   130: aload_0
    //   131: getfield 43	com/mopub/mobileads/CustomEventBannerAdapter:mMoPubView	Lcom/mopub/mobileads/MoPubView;
    //   134: invokevirtual 106	com/mopub/mobileads/MoPubView:getLocation	()Landroid/location/Location;
    //   137: invokeinterface 114 3 0
    //   142: pop
    //   143: aload_0
    //   144: getfield 43	com/mopub/mobileads/CustomEventBannerAdapter:mMoPubView	Lcom/mopub/mobileads/MoPubView;
    //   147: invokevirtual 118	com/mopub/mobileads/MoPubView:getAdViewController	()Lcom/mopub/mobileads/AdViewController;
    //   150: ifnull +25 -> 175
    //   153: aload_0
    //   154: getfield 56	com/mopub/mobileads/CustomEventBannerAdapter:mLocalExtras	Ljava/util/Map;
    //   157: ldc 120
    //   159: aload_0
    //   160: getfield 43	com/mopub/mobileads/CustomEventBannerAdapter:mMoPubView	Lcom/mopub/mobileads/MoPubView;
    //   163: invokevirtual 118	com/mopub/mobileads/MoPubView:getAdViewController	()Lcom/mopub/mobileads/AdViewController;
    //   166: invokevirtual 126	com/mopub/mobileads/AdViewController:getAdConfiguration	()Lcom/mopub/mobileads/AdConfiguration;
    //   169: invokeinterface 114 3 0
    //   174: pop
    //   175: return
    //   176: astore_1
    //   177: ldc 65
    //   179: new 67	java/lang/StringBuilder
    //   182: dup
    //   183: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   186: ldc -128
    //   188: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: aload_2
    //   192: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: ldc -126
    //   197: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: invokestatic 84	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   206: pop
    //   207: aload_0
    //   208: getfield 43	com/mopub/mobileads/CustomEventBannerAdapter:mMoPubView	Lcom/mopub/mobileads/MoPubView;
    //   211: getstatic 136	com/mopub/mobileads/MoPubErrorCode:ADAPTER_NOT_FOUND	Lcom/mopub/mobileads/MoPubErrorCode;
    //   214: invokevirtual 140	com/mopub/mobileads/MoPubView:loadFailUrl	(Lcom/mopub/mobileads/MoPubErrorCode;)V
    //   217: return
    //   218: astore_1
    //   219: ldc 65
    //   221: new 67	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   228: ldc -114
    //   230: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: aload_3
    //   234: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: aload_1
    //   238: invokevirtual 143	java/lang/Exception:toString	()Ljava/lang/String;
    //   241: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: invokestatic 84	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   250: pop
    //   251: goto -148 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	254	0	this	CustomEventBannerAdapter
    //   0	254	1	paramMoPubView	MoPubView
    //   0	254	2	paramString1	String
    //   0	254	3	paramString2	String
    // Exception table:
    //   from	to	target	type
    //   87	95	176	java/lang/Exception
    //   95	103	218	java/lang/Exception
  }
  
  private void cancelTimeout()
  {
    this.mHandler.removeCallbacks(this.mTimeout);
  }
  
  private int getTimeoutDelayMilliseconds()
  {
    if ((this.mMoPubView == null) || (this.mMoPubView.getAdTimeoutDelay() == null) || (this.mMoPubView.getAdTimeoutDelay().intValue() < 0)) {
      return 10000;
    }
    return this.mMoPubView.getAdTimeoutDelay().intValue() * 1000;
  }
  
  void invalidate()
  {
    if (this.mCustomEventBanner != null) {
      this.mCustomEventBanner.onInvalidate();
    }
    this.mContext = null;
    this.mCustomEventBanner = null;
    this.mLocalExtras = null;
    this.mServerExtras = null;
    this.mInvalidated = true;
  }
  
  boolean isInvalidated()
  {
    return this.mInvalidated;
  }
  
  void loadAd()
  {
    if ((isInvalidated()) || (this.mCustomEventBanner == null)) {
      return;
    }
    if (getTimeoutDelayMilliseconds() > 0) {
      this.mHandler.postDelayed(this.mTimeout, getTimeoutDelayMilliseconds());
    }
    this.mCustomEventBanner.loadBanner(this.mContext, this, this.mLocalExtras, this.mServerExtras);
  }
  
  public void onBannerClicked()
  {
    if (isInvalidated()) {}
    while (this.mMoPubView == null) {
      return;
    }
    this.mMoPubView.registerClick();
  }
  
  public void onBannerCollapsed()
  {
    if (isInvalidated()) {
      return;
    }
    this.mMoPubView.setAutorefreshEnabled(this.mStoredAutorefresh);
    this.mMoPubView.adClosed();
  }
  
  public void onBannerExpanded()
  {
    if (isInvalidated()) {
      return;
    }
    this.mStoredAutorefresh = this.mMoPubView.getAutorefreshEnabled();
    this.mMoPubView.setAutorefreshEnabled(false);
    this.mMoPubView.adPresentedOverlay();
  }
  
  public void onBannerFailed(MoPubErrorCode paramMoPubErrorCode)
  {
    if (isInvalidated()) {}
    while (this.mMoPubView == null) {
      return;
    }
    MoPubErrorCode localMoPubErrorCode = paramMoPubErrorCode;
    if (paramMoPubErrorCode == null) {
      localMoPubErrorCode = MoPubErrorCode.UNSPECIFIED;
    }
    cancelTimeout();
    this.mMoPubView.loadFailUrl(localMoPubErrorCode);
  }
  
  public void onBannerLoaded(View paramView)
  {
    if (isInvalidated()) {}
    do
    {
      do
      {
        return;
        cancelTimeout();
      } while (this.mMoPubView == null);
      this.mMoPubView.nativeAdLoaded();
      this.mMoPubView.setAdContentView(paramView);
    } while ((paramView instanceof HtmlBannerWebView));
    this.mMoPubView.trackNativeImpression();
  }
  
  public void onLeaveApplication()
  {
    onBannerClicked();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/mobileads/CustomEventBannerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */