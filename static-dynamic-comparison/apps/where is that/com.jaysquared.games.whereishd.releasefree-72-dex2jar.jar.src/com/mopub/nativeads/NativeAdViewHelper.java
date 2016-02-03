package com.mopub.nativeads;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.mopub.common.MoPubBrowser;
import com.mopub.common.util.IntentUtils;
import com.mopub.nativeads.util.Utils;
import java.lang.ref.SoftReference;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class NativeAdViewHelper
{
  private static void attachClickListeners(Context paramContext, View paramView, NativeViewHolder paramNativeViewHolder, NativeResponse paramNativeResponse, MoPubNative.MoPubNativeListener paramMoPubNativeListener)
  {
    if ((paramView == null) || (paramNativeResponse == null)) {
      return;
    }
    paramContext = new NativeViewClickListener(paramContext, paramNativeResponse.getClickTracker(), paramNativeResponse.getClickDestinationUrl(), paramMoPubNativeListener);
    paramView.setOnClickListener(paramContext);
    setCtaClickListener(paramNativeViewHolder, paramContext);
  }
  
  private static View createConvertView(Context paramContext, ViewGroup paramViewGroup, ViewBinder paramViewBinder)
  {
    return LayoutInflater.from(paramContext).inflate(paramViewBinder.layoutId, paramViewGroup, false);
  }
  
  static View getAdView(View paramView, ViewGroup paramViewGroup, Context paramContext, NativeResponse paramNativeResponse, ViewBinder paramViewBinder, MoPubNative.MoPubNativeListener paramMoPubNativeListener)
  {
    if (paramViewBinder == null)
    {
      Utils.MoPubLog("ViewBinder is null, returning empty view.");
      return new View(paramContext);
    }
    View localView = paramView;
    if (paramView == null) {
      localView = createConvertView(paramContext, paramViewGroup, paramViewBinder);
    }
    paramView = getOrCreateNativeViewHolder(localView, paramViewBinder);
    removeClickListeners(localView, paramView);
    ImpressionTrackingManager.removeView(localView);
    if (paramNativeResponse == null)
    {
      Utils.MoPubLog("NativeResponse is null, returning hidden view.");
      localView.setVisibility(8);
      return localView;
    }
    if (paramNativeResponse.isDestroyed())
    {
      Utils.MoPubLog("NativeResponse is destroyed, returning hidden view.");
      localView.setVisibility(8);
      return localView;
    }
    if (paramView == null)
    {
      Utils.MoPubLog("Could not create NativeViewHolder, returning hidden view.");
      localView.setVisibility(8);
      return localView;
    }
    populateConvertViewSubViews(localView, paramView, paramNativeResponse, paramViewBinder);
    attachClickListeners(paramContext, localView, paramView, paramNativeResponse, paramMoPubNativeListener);
    localView.setVisibility(0);
    ImpressionTrackingManager.addView(localView, paramNativeResponse, paramMoPubNativeListener);
    return localView;
  }
  
  static NativeViewHolder getOrCreateNativeViewHolder(View paramView, ViewBinder paramViewBinder)
  {
    Object localObject = ImageViewService.getViewTag(paramView);
    if ((localObject == null) || (!(localObject instanceof NativeViewHolder)))
    {
      paramViewBinder = NativeViewHolder.fromViewBinder(paramView, paramViewBinder);
      ImageViewService.setViewTag(paramView, paramViewBinder);
      return paramViewBinder;
    }
    return (NativeViewHolder)localObject;
  }
  
  private static void populateConvertViewSubViews(View paramView, NativeViewHolder paramNativeViewHolder, NativeResponse paramNativeResponse, ViewBinder paramViewBinder)
  {
    paramNativeViewHolder.update(paramNativeResponse);
    paramNativeViewHolder.updateExtras(paramView, paramNativeResponse, paramViewBinder);
  }
  
  private static void removeClickListeners(View paramView, NativeViewHolder paramNativeViewHolder)
  {
    if (paramView == null) {
      return;
    }
    paramView.setOnClickListener(null);
    setCtaClickListener(paramNativeViewHolder, null);
  }
  
  private static void setCtaClickListener(NativeViewHolder paramNativeViewHolder, NativeViewClickListener paramNativeViewClickListener)
  {
    if ((paramNativeViewHolder == null) || (paramNativeViewClickListener == null)) {}
    while ((paramNativeViewHolder.callToActionView == null) || (!(paramNativeViewHolder.callToActionView instanceof Button))) {
      return;
    }
    paramNativeViewHolder.callToActionView.setOnClickListener(paramNativeViewClickListener);
  }
  
  private static class ClickDestinationUrlResolutionListener
    implements UrlResolutionTask.UrlResolutionListener
  {
    private final Context mContext;
    private final MoPubNative.MoPubNativeListener mMoPubNativeListener;
    private final SoftReference<SpinningProgressView> mSpinningProgressView;
    private final Iterator<String> mUrlIterator;
    private final SoftReference<View> mView;
    
    public ClickDestinationUrlResolutionListener(Context paramContext, Iterator<String> paramIterator, SpinningProgressView paramSpinningProgressView, MoPubNative.MoPubNativeListener paramMoPubNativeListener, View paramView)
    {
      this.mContext = paramContext;
      this.mUrlIterator = paramIterator;
      this.mSpinningProgressView = new SoftReference(paramSpinningProgressView);
      paramContext = paramMoPubNativeListener;
      if (paramMoPubNativeListener == null) {
        paramContext = MoPubNative.MoPubNativeListener.EMPTY_MOPUB_NATIVE_LISTENER;
      }
      this.mMoPubNativeListener = paramContext;
      this.mView = new SoftReference(paramView);
    }
    
    public void onFailure()
    {
      Utils.MoPubLog("Failed to resolve URL for click.");
      if (this.mSpinningProgressView.get() != null) {
        ((SpinningProgressView)this.mSpinningProgressView.get()).removeFromRoot();
      }
    }
    
    public void onSuccess(String paramString)
    {
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.setData(Uri.parse(paramString));
      localIntent.addFlags(268435456);
      if (IntentUtils.isDeepLink(paramString)) {
        if (IntentUtils.deviceCanHandleIntent(this.mContext, localIntent))
        {
          this.mMoPubNativeListener.onNativeClick((View)this.mView.get());
          this.mContext.startActivity(localIntent);
        }
      }
      for (;;)
      {
        if (this.mSpinningProgressView.get() != null) {
          ((SpinningProgressView)this.mSpinningProgressView.get()).removeFromRoot();
        }
        return;
        if (this.mUrlIterator.hasNext())
        {
          NativeHttpClient.getResolvedUrl((String)this.mUrlIterator.next(), this);
        }
        else
        {
          this.mMoPubNativeListener.onNativeClick((View)this.mView.get());
          MoPubBrowser.open(this.mContext, paramString);
          continue;
          this.mMoPubNativeListener.onNativeClick((View)this.mView.get());
          MoPubBrowser.open(this.mContext, paramString);
        }
      }
    }
  }
  
  static class NativeViewClickListener
    implements View.OnClickListener
  {
    private final String mClickTrackerUrl;
    private final Context mContext;
    private final String mDestinationUrl;
    private final MoPubNative.MoPubNativeListener mMoPubNativeListener;
    
    NativeViewClickListener(Context paramContext, String paramString1, String paramString2, MoPubNative.MoPubNativeListener paramMoPubNativeListener)
    {
      this.mContext = paramContext.getApplicationContext();
      this.mClickTrackerUrl = paramString1;
      this.mDestinationUrl = paramString2;
      this.mMoPubNativeListener = paramMoPubNativeListener;
    }
    
    public void onClick(View paramView)
    {
      SpinningProgressView localSpinningProgressView = new SpinningProgressView(this.mContext);
      localSpinningProgressView.addToRoot(paramView);
      NativeHttpClient.makeTrackingHttpRequest(this.mClickTrackerUrl);
      if (this.mDestinationUrl != null)
      {
        Iterator localIterator = Arrays.asList(new String[] { this.mDestinationUrl }).iterator();
        paramView = new NativeAdViewHelper.ClickDestinationUrlResolutionListener(this.mContext, localIterator, localSpinningProgressView, this.mMoPubNativeListener, paramView);
        NativeHttpClient.getResolvedUrl((String)localIterator.next(), paramView);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/nativeads/NativeAdViewHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */