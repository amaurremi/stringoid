package com.millennialmedia.android;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import java.lang.ref.WeakReference;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;

class AdViewOverlayView
  extends MMLayout
{
  private Button mraidCloseButton;
  CloseTopDrawable mraidCloseDrawable;
  WeakReference<AdViewOverlayActivity> overlayActivityRef;
  private ProgressBar progressBar;
  private boolean progressDone;
  OverlaySettings settings;
  
  AdViewOverlayView(AdViewOverlayActivity paramAdViewOverlayActivity, OverlaySettings paramOverlaySettings)
  {
    super(paramAdViewOverlayActivity.activity);
    this.overlayActivityRef = new WeakReference(paramAdViewOverlayActivity);
    this.adImpl = new AdViewOverlayViewMMAdImpl(paramAdViewOverlayActivity.activity);
    setId(15062);
    this.adImpl.adType = "i";
    this.settings = paramOverlaySettings;
    paramOverlaySettings = null;
    Object localObject;
    if ((paramAdViewOverlayActivity.activity instanceof Activity))
    {
      paramOverlaySettings = (NonConfigurationInstance)paramAdViewOverlayActivity.activity.getLastNonConfigurationInstance();
      if (paramOverlaySettings != null)
      {
        this.progressDone = paramOverlaySettings.progressDone;
        this.adImpl.controller = paramOverlaySettings.controller;
        this.settings = paramOverlaySettings.settings;
        if ((this.adImpl != null) && (this.adImpl.controller != null) && (this.adImpl.controller.webView != null)) {
          addView(this.adImpl.controller.webView);
        }
        MMSDK.Log.d("Restoring configurationinstance w/ controller= " + paramOverlaySettings.controller);
      }
    }
    else
    {
      float f = paramAdViewOverlayActivity.activity.getResources().getDisplayMetrics().density;
      if ((this.settings.height == 0) || (this.settings.width == 0)) {
        break label541;
      }
      localObject = new RelativeLayout.LayoutParams((int)(this.settings.width * f), (int)(this.settings.height * f));
      label245:
      ((RelativeLayout.LayoutParams)localObject).addRule(13);
      setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = Integer.valueOf((int)(0.0625F * f * this.settings.shouldResizeOverlay));
      setPadding(((Integer)localObject).intValue(), ((Integer)localObject).intValue(), ((Integer)localObject).intValue(), ((Integer)localObject).intValue());
      this.mraidCloseButton = initMRaidCloseButton(paramAdViewOverlayActivity.activity, f);
      if ((this.settings.isExpanded()) && (!this.settings.hasExpandUrl())) {
        this.adImpl.linkForExpansionId = this.settings.creatorAdImplId;
      }
      MMAdImplController.assignAdViewController(this.adImpl);
      if (this.mraidCloseButton != null) {
        addView(this.mraidCloseButton);
      }
      if ((!this.progressDone) && (!this.settings.isExpanded()) && (!this.settings.isFromInterstitial())) {
        initProgressBar();
      }
      if (!this.settings.getIsTransparent()) {
        break label555;
      }
      if ((this.adImpl != null) && (this.adImpl.controller != null) && (this.adImpl.controller.webView != null)) {
        this.adImpl.controller.webView.setBackgroundColor(0);
      }
      setBackgroundColor(0);
    }
    for (;;)
    {
      if ((this.settings.enableHardwareAccel()) && (this.adImpl != null) && (this.adImpl.controller != null) && (this.adImpl.controller.webView != null)) {
        this.adImpl.controller.webView.enableHardwareAcceleration();
      }
      if (paramOverlaySettings == null) {
        animateView();
      }
      setUseCustomClose(this.settings.getUseCustomClose());
      return;
      MMSDK.Log.d("Null configurationinstance ");
      break;
      label541:
      localObject = new RelativeLayout.LayoutParams(-1, -1);
      break label245;
      label555:
      if ((this.adImpl != null) && (this.adImpl.controller != null) && (this.adImpl.controller.webView != null)) {
        this.adImpl.controller.webView.setBackgroundColor(-1);
      }
      setBackgroundColor(-1);
    }
  }
  
  private void animateView()
  {
    Object localObject;
    if (this.settings.getTransition().equals("slideup"))
    {
      localObject = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
      MMSDK.Log.v("Translate up");
    }
    for (;;)
    {
      ((Animation)localObject).setDuration(this.settings.getTransitionDurationInMillis());
      startAnimation((Animation)localObject);
      do
      {
        return;
        if (this.settings.getTransition().equals("slidedown"))
        {
          localObject = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, -1.0F, 1, 0.0F);
          MMSDK.Log.v("Translate down");
          break;
        }
      } while (!this.settings.getTransition().equals("explode"));
      localObject = new ScaleAnimation(1.1F, 0.9F, 0.1F, 0.9F, 1, 0.5F, 1, 0.5F);
      MMSDK.Log.v("Explode");
    }
  }
  
  private RelativeLayout.LayoutParams getCloseAreaParams(float paramFloat)
  {
    int i = (int)(50.0F * paramFloat + 0.5F);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i, i);
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(10);
    return localLayoutParams;
  }
  
  private Button initMRaidCloseButton(Context paramContext, float paramFloat)
  {
    paramContext = new Button(paramContext);
    paramContext.setId(301);
    this.mraidCloseDrawable = new CloseTopDrawable(true, paramFloat);
    paramContext.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        MMSDK.Log.v("Close button clicked.");
        AdViewOverlayView.this.finishOverlayWithAnimation();
      }
    });
    RelativeLayout.LayoutParams localLayoutParams = getCloseAreaParams(paramFloat);
    paramContext.setLayoutParams(localLayoutParams);
    paramContext.post(new SetCloseButtonTouchDelegateRunnable(paramContext, localLayoutParams.topMargin, localLayoutParams.leftMargin, localLayoutParams.bottomMargin, localLayoutParams.rightMargin));
    return paramContext;
  }
  
  private void initProgressBar()
  {
    Object localObject = (AdViewOverlayActivity)this.overlayActivityRef.get();
    if (localObject != null)
    {
      this.progressBar = new ProgressBar(((AdViewOverlayActivity)localObject).activity);
      this.progressBar.setIndeterminate(true);
      this.progressBar.setVisibility(0);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(13);
      addView(this.progressBar, (ViewGroup.LayoutParams)localObject);
    }
  }
  
  private void removeProgressBar()
  {
    if ((!this.progressDone) && (this.progressBar != null))
    {
      this.progressDone = true;
      this.progressBar.setVisibility(8);
      removeView(this.progressBar);
      this.progressBar = null;
    }
  }
  
  void addInlineVideo()
  {
    super.addInlineVideo();
    bringMraidCloseToFront();
  }
  
  boolean attachWebViewToLink()
  {
    return (this.adImpl != null) && (this.adImpl.linkForExpansionId != 0L) && (MMAdImplController.attachWebViewFromOverlay(this.adImpl));
  }
  
  void bringMraidCloseToFront()
  {
    if (this.mraidCloseButton != null) {
      this.mraidCloseButton.bringToFront();
    }
  }
  
  void closeAreaTouched()
  {
    post(new Runnable()
    {
      public void run()
      {
        AdViewOverlayView.this.finishOverlayWithAnimation();
      }
    });
  }
  
  void finishOverlayWithAnimation()
  {
    MMSDK.Log.d("Ad overlay closed");
    if ((Activity)getContext() == null) {
      return;
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setAnimationListener(new AnimationListener(this));
    localAlphaAnimation.setFillEnabled(true);
    localAlphaAnimation.setFillBefore(true);
    localAlphaAnimation.setFillAfter(true);
    localAlphaAnimation.setDuration(400L);
    startAnimation(localAlphaAnimation);
  }
  
  void fullScreenVideoLayout()
  {
    removeView(this.inlineVideoLayout);
    addView(this.inlineVideoLayout, new RelativeLayout.LayoutParams(-1, -1));
    bringMraidCloseToFront();
  }
  
  Object getNonConfigurationInstance()
  {
    if (this.adImpl != null)
    {
      MMSDK.Log.d("Saving getNonConfigurationInstance for " + this.adImpl);
      if ((this.adImpl.controller != null) && (this.adImpl.controller.webView != null)) {
        this.adImpl.controller.webView.removeFromParent();
      }
    }
    NonConfigurationInstance localNonConfigurationInstance = new NonConfigurationInstance(null);
    localNonConfigurationInstance.progressDone = this.progressDone;
    localNonConfigurationInstance.controller = this.adImpl.controller;
    localNonConfigurationInstance.settings = this.settings;
    return localNonConfigurationInstance;
  }
  
  void getWebContent(String paramString)
  {
    new FetchWebViewContentTask(this, paramString).execute(new Void[0]);
  }
  
  void injectJS(String paramString)
  {
    if (this.adImpl.controller != null) {
      this.adImpl.controller.loadUrl(paramString);
    }
  }
  
  void inlineConfigChange()
  {
    if ((this.inlineVideoView != null) && (this.inlineVideoLayout != null))
    {
      this.inlineVideoLayout.setLayoutParams(this.inlineVideoView.getCustomLayoutParams());
      bringMraidCloseToFront();
    }
  }
  
  void killWebView()
  {
    BridgeMMSpeechkit.releaseSpeechKit();
    if ((this.adImpl != null) && (this.adImpl.controller != null) && (this.adImpl.controller.webView != null))
    {
      this.adImpl.controller.webView.clearFocus();
      this.adImpl.controller.webView.setMraidViewableHidden();
      this.adImpl.controller.webView.onPauseWebView();
    }
  }
  
  void removeSelfAndAll()
  {
    removeAllViews();
    ViewParent localViewParent = getParent();
    if ((localViewParent != null) && ((localViewParent instanceof ViewGroup))) {
      ((ViewGroup)localViewParent).removeView(this);
    }
  }
  
  void repositionVideoLayout()
  {
    removeView(this.inlineVideoLayout);
    addView(this.inlineVideoLayout, this.inlineVideoView.getCustomLayoutParams());
    bringMraidCloseToFront();
  }
  
  void setUseCustomClose(boolean paramBoolean)
  {
    this.settings.setUseCustomClose(paramBoolean);
    Button localButton = this.mraidCloseButton;
    if (paramBoolean) {}
    for (Object localObject = null;; localObject = this.mraidCloseDrawable)
    {
      localButton.setBackgroundDrawable((Drawable)localObject);
      return;
    }
  }
  
  class AdViewOverlayViewMMAdImpl
    extends MMLayout.MMLayoutMMAdImpl
  {
    public AdViewOverlayViewMMAdImpl(Context paramContext)
    {
      super(paramContext);
      this.mmWebViewClientListener = new AdViewOverlayView.OverlayWebViewClientListener(this);
    }
    
    MMWebViewClient getMMWebViewClient()
    {
      MMSDK.Log.d("Returning a client for user: OverlayWebViewClient, adimpl=" + AdViewOverlayView.this.adImpl);
      if ((AdViewOverlayView.this.adImpl.linkForExpansionId != 0L) || (AdViewOverlayView.this.settings.hasExpandUrl()))
      {
        localObject = new BannerExpandedWebViewClient(this.mmWebViewClientListener, new AdViewOverlayView.OverlayRedirectionListenerImpl(this));
        this.mmWebViewClient = ((MMWebViewClient)localObject);
        return (MMWebViewClient)localObject;
      }
      Object localObject = new InterstitialWebViewClient(this.mmWebViewClientListener, new AdViewOverlayView.OverlayRedirectionListenerImpl(this));
      this.mmWebViewClient = ((MMWebViewClient)localObject);
      return (MMWebViewClient)localObject;
    }
    
    boolean isExpandingToUrl()
    {
      return (AdViewOverlayView.this.settings.hasExpandUrl()) && (!AdViewOverlayView.this.settings.hasLoadedExpandUrl());
    }
    
    void removeProgressBar()
    {
      AdViewOverlayView.this.removeProgressBar();
    }
  }
  
  private static class AnimationListener
    implements Animation.AnimationListener
  {
    private WeakReference<AdViewOverlayView> overlayRef;
    
    public AnimationListener(AdViewOverlayView paramAdViewOverlayView)
    {
      this.overlayRef = new WeakReference(paramAdViewOverlayView);
    }
    
    public void onAnimationEnd(Animation paramAnimation)
    {
      paramAnimation = (AdViewOverlayView)this.overlayRef.get();
      if (paramAnimation != null)
      {
        paramAnimation = (Activity)paramAnimation.getContext();
        MMSDK.Log.d("Finishing overlay this is in w/ anim finishOverLayWithAnim()");
        paramAnimation.finish();
      }
    }
    
    public void onAnimationRepeat(Animation paramAnimation) {}
    
    public void onAnimationStart(Animation paramAnimation)
    {
      paramAnimation = (AdViewOverlayView)this.overlayRef.get();
      if ((paramAnimation != null) && (paramAnimation.mraidCloseButton != null)) {
        paramAnimation.mraidCloseButton.setVisibility(8);
      }
    }
  }
  
  private static class CloseDrawable
    extends Drawable
  {
    protected boolean enabled = true;
    protected final Paint paint;
    
    CloseDrawable(boolean paramBoolean)
    {
      this.enabled = paramBoolean;
      this.paint = new Paint();
      this.paint.setAntiAlias(true);
      this.paint.setStyle(Paint.Style.STROKE);
    }
    
    public void draw(Canvas paramCanvas)
    {
      Rect localRect = copyBounds();
      int j = localRect.right - localRect.left;
      int k = localRect.bottom - localRect.top;
      float f = j / 6.0F;
      this.paint.setStrokeWidth(f);
      if (this.enabled) {}
      for (int i = 255;; i = 80)
      {
        this.paint.setARGB(255, i, i, i);
        paramCanvas.drawLine(f / 2.0F, f / 2.0F, j - f / 2.0F, k - f / 2.0F, this.paint);
        paramCanvas.drawLine(j - f / 2.0F, f / 2.0F, f / 2.0F, k - f / 2.0F, this.paint);
        return;
      }
    }
    
    public int getOpacity()
    {
      return -3;
    }
    
    public void setAlpha(int paramInt) {}
    
    public void setColorFilter(ColorFilter paramColorFilter) {}
  }
  
  private static class CloseTopDrawable
    extends AdViewOverlayView.CloseDrawable
  {
    final float dist;
    final float scale;
    
    CloseTopDrawable(boolean paramBoolean, float paramFloat)
    {
      super();
      this.scale = paramFloat;
      this.dist = (4.0F * paramFloat);
      this.paint.setColor(-16777216);
    }
    
    public void draw(Canvas paramCanvas)
    {
      Rect localRect = copyBounds();
      float f1 = (localRect.right - localRect.left) / 10.0F;
      float f2 = localRect.right - this.scale * 20.0F;
      float f3 = localRect.top + this.scale * 20.0F;
      this.paint.setStrokeWidth(f1);
      this.paint.setColor(-16777216);
      this.paint.setStyle(Paint.Style.STROKE);
      paramCanvas.drawCircle(f2, f3, 12.0F * this.scale, this.paint);
      this.paint.setColor(-1);
      this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
      paramCanvas.drawCircle(f2, f3, this.scale * 10.0F, this.paint);
      this.paint.setColor(-16777216);
      paramCanvas.drawCircle(f2, f3, 7.0F * this.scale, this.paint);
      this.paint.setColor(-1);
      this.paint.setStrokeWidth(f1 / 2.0F);
      this.paint.setStyle(Paint.Style.STROKE);
      paramCanvas.drawLine(f2 - this.dist, f3 - this.dist, f2 + this.dist, f3 + this.dist, this.paint);
      paramCanvas.drawLine(f2 + this.dist, f3 - this.dist, f2 - this.dist, f3 + this.dist, this.paint);
    }
  }
  
  private static class FetchWebViewContentTask
    extends AsyncTask<Void, Void, String>
  {
    private WeakReference<AdViewOverlayView> _overlayViewRef;
    private String baseUrl;
    private boolean cancelVideo;
    
    public FetchWebViewContentTask(AdViewOverlayView paramAdViewOverlayView, String paramString)
    {
      this.baseUrl = paramString;
      this._overlayViewRef = new WeakReference(paramAdViewOverlayView);
    }
    
    protected String doInBackground(Void... paramVarArgs)
    {
      this.cancelVideo = true;
      if (!TextUtils.isEmpty(this.baseUrl)) {
        try
        {
          paramVarArgs = new HttpGetRequest().get(this.baseUrl);
          if (paramVarArgs != null)
          {
            StatusLine localStatusLine = paramVarArgs.getStatusLine();
            if ((paramVarArgs != null) && (localStatusLine != null) && (localStatusLine.getStatusCode() != 404))
            {
              paramVarArgs = paramVarArgs.getEntity();
              if (paramVarArgs != null)
              {
                paramVarArgs = HttpGetRequest.convertStreamToString(paramVarArgs.getContent());
                this.cancelVideo = false;
                return paramVarArgs;
              }
            }
          }
        }
        catch (Exception paramVarArgs)
        {
          paramVarArgs.printStackTrace();
        }
      }
      return null;
    }
    
    protected void onPostExecute(String paramString)
    {
      AdViewOverlayView localAdViewOverlayView = (AdViewOverlayView)this._overlayViewRef.get();
      if (localAdViewOverlayView != null) {
        if (this.cancelVideo)
        {
          AdViewOverlayActivity localAdViewOverlayActivity = (AdViewOverlayActivity)localAdViewOverlayView.overlayActivityRef.get();
          if (localAdViewOverlayActivity == null) {
            break label78;
          }
          localAdViewOverlayActivity.finish();
        }
      }
      for (;;)
      {
        if ((paramString != null) && (localAdViewOverlayView.adImpl != null) && (localAdViewOverlayView.adImpl.controller != null)) {
          localAdViewOverlayView.adImpl.controller.setWebViewContent(paramString, this.baseUrl);
        }
        return;
        label78:
        localAdViewOverlayView.removeProgressBar();
      }
    }
    
    protected void onPreExecute()
    {
      AdViewOverlayView localAdViewOverlayView = (AdViewOverlayView)this._overlayViewRef.get();
      if ((localAdViewOverlayView != null) && (localAdViewOverlayView.progressBar == null)) {
        localAdViewOverlayView.initProgressBar();
      }
      super.onPreExecute();
    }
  }
  
  private static final class NonConfigurationInstance
  {
    MMAdImplController controller;
    boolean progressDone;
    OverlaySettings settings;
  }
  
  static class OverlayRedirectionListenerImpl
    extends MMAdImpl.MMAdImplRedirectionListenerImpl
  {
    public OverlayRedirectionListenerImpl(MMAdImpl paramMMAdImpl)
    {
      super();
    }
    
    public boolean isExpandingToUrl()
    {
      MMAdImpl localMMAdImpl = (MMAdImpl)this.adImplRef.get();
      if ((localMMAdImpl != null) && ((localMMAdImpl instanceof AdViewOverlayView.AdViewOverlayViewMMAdImpl))) {
        return localMMAdImpl.isExpandingToUrl();
      }
      return false;
    }
  }
  
  private static class OverlayWebViewClientListener
    extends MMAdImpl.BasicWebViewClientListener
  {
    OverlayWebViewClientListener(MMAdImpl paramMMAdImpl)
    {
      super();
    }
    
    public void onPageFinished(String paramString)
    {
      super.onPageFinished(paramString);
      paramString = (MMAdImpl)this.adImplRef.get();
      if (paramString != null) {
        paramString.removeProgressBar();
      }
    }
  }
  
  static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
    {
      public AdViewOverlayView.SavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new AdViewOverlayView.SavedState(paramAnonymousParcel, null);
      }
      
      public AdViewOverlayView.SavedState[] newArray(int paramAnonymousInt)
      {
        return new AdViewOverlayView.SavedState[paramAnonymousInt];
      }
    };
    public Object customInlineLayoutParams;
    String gson;
    
    private SavedState(Parcel paramParcel)
    {
      super();
      this.gson = paramParcel.readString();
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.gson);
    }
  }
  
  private static class SetCloseButtonTouchDelegateRunnable
    implements Runnable
  {
    int bottom;
    private final Button closeButton;
    int left;
    int right;
    int top;
    
    SetCloseButtonTouchDelegateRunnable(Button paramButton, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.closeButton = paramButton;
      this.top = paramInt1;
      this.left = paramInt2;
      this.bottom = paramInt3;
      this.right = paramInt4;
    }
    
    public void run()
    {
      Object localObject = new Rect();
      this.closeButton.getHitRect((Rect)localObject);
      ((Rect)localObject).top += this.top;
      ((Rect)localObject).right += this.right;
      ((Rect)localObject).bottom += this.bottom;
      ((Rect)localObject).left += this.left;
      localObject = new TouchDelegate((Rect)localObject, this.closeButton);
      if (View.class.isInstance(this.closeButton.getParent())) {
        ((View)this.closeButton.getParent()).setTouchDelegate((TouchDelegate)localObject);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/millennialmedia/android/AdViewOverlayView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */