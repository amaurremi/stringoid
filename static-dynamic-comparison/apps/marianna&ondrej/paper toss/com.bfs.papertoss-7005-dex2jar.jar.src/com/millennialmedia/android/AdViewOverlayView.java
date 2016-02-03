package com.millennialmedia.android;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import java.lang.reflect.Method;

class AdViewOverlayView
  extends FrameLayout
{
  private static final int TITLE_MARGIN_X = 8;
  private static final int TITLE_MARGIN_Y = 9;
  private RelativeLayout content;
  private Button mraidCloseButton;
  private RelativeLayout navBar;
  private Button navCloseButton;
  private String overlayUrl;
  private ProgressBar progressBar;
  private boolean progressDone;
  private OverlaySettings settings;
  private TextView title;
  Handler viewHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      }
      AdViewOverlayView.this.dismiss(true);
    }
  };
  protected WebView webView;
  
  AdViewOverlayView(final Activity paramActivity, OverlaySettings paramOverlaySettings)
  {
    super(paramActivity);
    setId(15062);
    if (paramActivity == null) {}
    for (;;)
    {
      return;
      this.settings = paramOverlaySettings;
      this.settings.isBannerAd = false;
      NonConfigurationInstance localNonConfigurationInstance = (NonConfigurationInstance)paramActivity.getLastNonConfigurationInstance();
      if (localNonConfigurationInstance != null)
      {
        this.settings.shouldShowBottomBar = localNonConfigurationInstance.bottomBarVisible;
        this.settings.shouldEnableBottomBar = localNonConfigurationInstance.bottomBarEnabled;
        this.progressDone = localNonConfigurationInstance.progressDone;
        this.webView = localNonConfigurationInstance.webView;
      }
      setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
      float f = paramActivity.getResources().getDisplayMetrics().density;
      final Object localObject1 = Integer.valueOf((int)(0.0625F * f * this.settings.shouldResizeOverlay));
      setPadding(((Integer)localObject1).intValue(), ((Integer)localObject1).intValue(), ((Integer)localObject1).intValue(), ((Integer)localObject1).intValue());
      this.content = new RelativeLayout(paramActivity);
      this.content.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
      addView(this.content);
      Object localObject2 = null;
      localObject1 = localObject2;
      if (this.settings.shouldShowCustomClose)
      {
        localObject1 = localObject2;
        if (this.settings.shouldShowTitlebar)
        {
          localObject1 = new RelativeLayout(paramActivity);
          localObject2 = new RelativeLayout.LayoutParams(-1, -2);
          ((RelativeLayout.LayoutParams)localObject2).addRule(10);
          ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          ((RelativeLayout)localObject1).setBackgroundColor(-16777216);
          ((RelativeLayout)localObject1).setId(100);
          this.title = new TextView(paramActivity);
          this.title.setText(this.settings.overlayTitle);
          this.title.setTextColor(-1);
          this.title.setBackgroundColor(-16777216);
          this.title.setTypeface(Typeface.DEFAULT_BOLD);
          this.title.setPadding(8, 9, 8, 9);
          this.title.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
          ((RelativeLayout)localObject1).addView(this.title);
          localObject2 = new Button(paramActivity);
          ((Button)localObject2).setBackgroundColor(-16777216);
          ((Button)localObject2).setText("Close");
          ((Button)localObject2).setTextColor(-1);
          ((Button)localObject2).setOnTouchListener(new View.OnTouchListener()
          {
            public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
            {
              boolean bool = true;
              switch (paramAnonymousMotionEvent.getAction())
              {
              default: 
                bool = false;
              case 0: 
                return bool;
              }
              AdViewOverlayView.this.title.setBackgroundColor(-7829368);
              AdViewOverlayView.this.dismiss(true);
              return true;
            }
          });
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams.addRule(11);
          ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
          this.content.addView((View)localObject1);
        }
      }
      int i;
      if (paramOverlaySettings.shouldShowCustomClose)
      {
        this.navBar = new RelativeLayout(paramActivity);
        localObject2 = new RelativeLayout.LayoutParams(-1, -2);
        ((RelativeLayout.LayoutParams)localObject2).addRule(12);
        this.navBar.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        this.navBar.setBackgroundDrawable(new BottomBarDrawable());
        this.navBar.setId(300);
        this.navCloseButton = new Button(paramActivity);
        this.navCloseButton.setBackgroundColor(-16777216);
        setCloseButtonListener(this.settings.shouldEnableBottomBar);
        i = (int)(25.0F * f + 0.5F);
        localObject2 = new RelativeLayout.LayoutParams(i, i);
        i = (int)(12.0F * f + 0.5F);
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = i;
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = i;
        ((RelativeLayout.LayoutParams)localObject2).topMargin = ((int)(15.0F * f + 0.5F));
        ((RelativeLayout.LayoutParams)localObject2).addRule(11);
        ((RelativeLayout.LayoutParams)localObject2).addRule(15);
        this.navBar.addView(this.navCloseButton, (ViewGroup.LayoutParams)localObject2);
        this.navBar.post(new SetCloseButtonTouchDelegateRunnable(this.navCloseButton, ((RelativeLayout.LayoutParams)localObject2).topMargin, ((RelativeLayout.LayoutParams)localObject2).leftMargin, ((RelativeLayout.LayoutParams)localObject2).bottomMargin, ((RelativeLayout.LayoutParams)localObject2).rightMargin));
        this.content.addView(this.navBar);
        if (this.settings.shouldShowBottomBar)
        {
          this.navBar.setVisibility(0);
          label720:
          if (this.webView == null) {
            this.webView = new WebView(paramActivity);
          }
          this.webView.setId(200);
          localObject2 = new RelativeLayout.LayoutParams(-1, -1);
          if (localObject1 == null) {
            break label1366;
          }
          ((RelativeLayout.LayoutParams)localObject2).addRule(3, ((RelativeLayout)localObject1).getId());
          label776:
          if (this.navBar == null) {
            break label1376;
          }
          ((RelativeLayout.LayoutParams)localObject2).addRule(2, this.navBar.getId());
          label796:
          this.webView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          this.webView.setWebViewClient(new OverlayWebViewClient(paramOverlaySettings));
          this.webView.addJavascriptInterface(new OverlayJSInterface(), "interface");
          localObject1 = this.webView.getSettings();
          ((WebSettings)localObject1).setJavaScriptEnabled(true);
          ((WebSettings)localObject1).setDefaultTextEncodingName("UTF-8");
        }
      }
      try
      {
        localObject1.getClass().getMethod("setLoadWithOverviewMode", new Class[] { Boolean.TYPE }).invoke(localObject1, new Object[] { Boolean.valueOf(true) });
        try
        {
          localObject1.getClass().getMethod("setGeolocationEnabled", new Class[] { Boolean.TYPE }).invoke(localObject1, new Object[] { Boolean.valueOf(true) });
          localObject1 = new GestureDetector(paramActivity, new GestureDetector.SimpleOnGestureListener()
          {
            public boolean onSingleTapConfirmed(MotionEvent paramAnonymousMotionEvent)
            {
              MMAdViewSDK.Event.overlayTap(paramActivity);
              return false;
            }
          });
          this.webView.setOnTouchListener(new View.OnTouchListener()
          {
            public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
            {
              localObject1.onTouchEvent(paramAnonymousMotionEvent);
              return false;
            }
          });
          if (this.settings.shouldMakeOverlayTransparent) {
            this.webView.setBackgroundColor(0);
          }
          try
          {
            WebView.class.getMethod("setLayerType", new Class[] { Integer.TYPE, Paint.class }).invoke(this.webView, new Object[] { Integer.valueOf(1), null });
            this.content.setBackgroundColor(0);
            for (;;)
            {
              this.content.addView(this.webView);
              if (this.mraidCloseButton != null) {
                this.content.addView(this.mraidCloseButton);
              }
              if (!this.progressDone)
              {
                this.progressBar = new ProgressBar(paramActivity);
                this.progressBar.setIndeterminate(true);
                this.progressBar.setVisibility(0);
                paramActivity = new RelativeLayout.LayoutParams(-2, -2);
                paramActivity.addRule(13);
                this.content.addView(this.progressBar, paramActivity);
              }
              if (localNonConfigurationInstance == null) {
                animateView();
              }
              if (paramOverlaySettings.delayShowBottombar > 0L) {
                this.viewHandler.postDelayed(new Runnable()
                {
                  public void run()
                  {
                    AdViewOverlayView.this.settings.shouldShowBottomBar = true;
                    if (AdViewOverlayView.this.navBar != null) {
                      AdViewOverlayView.this.navBar.setVisibility(0);
                    }
                  }
                }, paramOverlaySettings.delayShowBottombar);
              }
              if (paramOverlaySettings.delayEnableBottombar <= 0L) {
                break;
              }
              this.viewHandler.postDelayed(new Runnable()
              {
                public void run()
                {
                  AdViewOverlayView.this.settings.shouldEnableBottomBar = true;
                  AdViewOverlayView.this.setCloseButtonListener(true);
                }
              }, paramOverlaySettings.delayEnableBottombar);
              return;
              this.navBar.setVisibility(8);
              break label720;
              this.mraidCloseButton = new Button(paramActivity);
              this.mraidCloseButton.setId(301);
              this.mraidCloseButton.setBackgroundDrawable(new CloseTopDrawable(true, f));
              this.mraidCloseButton.setOnClickListener(new View.OnClickListener()
              {
                public void onClick(View paramAnonymousView)
                {
                  MMAdViewSDK.Log.v("Close button clicked.");
                  AdViewOverlayView.this.dismiss(true);
                }
              });
              i = (int)(50.0F * f + 0.5F);
              localObject2 = new RelativeLayout.LayoutParams(i, i);
              ((RelativeLayout.LayoutParams)localObject2).addRule(11);
              ((RelativeLayout.LayoutParams)localObject2).addRule(10);
              this.mraidCloseButton.setLayoutParams((ViewGroup.LayoutParams)localObject2);
              this.mraidCloseButton.post(new SetCloseButtonTouchDelegateRunnable(this.mraidCloseButton, ((RelativeLayout.LayoutParams)localObject2).topMargin, ((RelativeLayout.LayoutParams)localObject2).leftMargin, ((RelativeLayout.LayoutParams)localObject2).bottomMargin, ((RelativeLayout.LayoutParams)localObject2).rightMargin));
              break label720;
              label1366:
              ((RelativeLayout.LayoutParams)localObject2).addRule(10);
              break label776;
              label1376:
              ((RelativeLayout.LayoutParams)localObject2).addRule(12);
              break label796;
              this.webView.setBackgroundColor(-1);
              this.content.setBackgroundColor(-1);
            }
          }
          catch (Exception localException1)
          {
            for (;;) {}
          }
        }
        catch (Exception localException2)
        {
          for (;;) {}
        }
      }
      catch (Exception localException3)
      {
        for (;;) {}
      }
    }
  }
  
  private void animateView()
  {
    if (this.settings.overlayTransition.equals("toptobottom"))
    {
      localObject = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, -1.0F, 1, 0.0F);
      ((TranslateAnimation)localObject).setDuration(this.settings.transitionTime);
      ((TranslateAnimation)localObject).setAnimationListener(new Animation.AnimationListener()
      {
        public void onAnimationEnd(Animation paramAnonymousAnimation) {}
        
        public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      MMAdViewSDK.Log.v("Translate down");
      startAnimation((Animation)localObject);
    }
    do
    {
      return;
      if (this.settings.overlayTransition.equals("explode"))
      {
        localObject = new ScaleAnimation(1.1F, 0.9F, 0.1F, 0.9F, 1, 0.5F, 1, 0.5F);
        ((ScaleAnimation)localObject).setDuration(this.settings.transitionTime);
        ((ScaleAnimation)localObject).setAnimationListener(new Animation.AnimationListener()
        {
          public void onAnimationEnd(Animation paramAnonymousAnimation) {}
          
          public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
          
          public void onAnimationStart(Animation paramAnonymousAnimation) {}
        });
        MMAdViewSDK.Log.v("Explode");
        startAnimation((Animation)localObject);
        return;
      }
    } while (this.settings.overlayTransition.equals("none"));
    Object localObject = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    ((TranslateAnimation)localObject).setDuration(this.settings.transitionTime);
    ((TranslateAnimation)localObject).setAnimationListener(new Animation.AnimationListener()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation) {}
      
      public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    MMAdViewSDK.Log.v("Translate up");
    startAnimation((Animation)localObject);
  }
  
  void dismiss(boolean paramBoolean)
  {
    MMAdViewSDK.Log.d("Ad overlay closed");
    Object localObject = (Activity)getContext();
    if (localObject == null) {
      return;
    }
    if (paramBoolean)
    {
      localObject = new AlphaAnimation(1.0F, 0.0F);
      ((AlphaAnimation)localObject).setAnimationListener(new Animation.AnimationListener()
      {
        public void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          ((Activity)AdViewOverlayView.this.getContext()).finish();
        }
        
        public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public void onAnimationStart(Animation paramAnonymousAnimation)
        {
          if (AdViewOverlayView.this.mraidCloseButton != null) {
            AdViewOverlayView.this.mraidCloseButton.setVisibility(8);
          }
        }
      });
      ((AlphaAnimation)localObject).setFillEnabled(true);
      ((AlphaAnimation)localObject).setFillBefore(true);
      ((AlphaAnimation)localObject).setFillAfter(true);
      ((AlphaAnimation)localObject).setDuration(400L);
      startAnimation((Animation)localObject);
      return;
    }
    ((Activity)localObject).finish();
  }
  
  Object getNonConfigurationInstance()
  {
    NonConfigurationInstance localNonConfigurationInstance = new NonConfigurationInstance(null);
    this.webView.setWebViewClient(null);
    ((ViewGroup)this.webView.getParent()).removeView(this.webView);
    if (this.navBar != null) {
      if (this.navBar.getVisibility() != 0) {
        break label87;
      }
    }
    label87:
    for (boolean bool = true;; bool = false)
    {
      localNonConfigurationInstance.bottomBarVisible = bool;
      localNonConfigurationInstance.bottomBarEnabled = this.navBar.isEnabled();
      localNonConfigurationInstance.progressDone = this.progressDone;
      localNonConfigurationInstance.webView = this.webView;
      return localNonConfigurationInstance;
    }
  }
  
  boolean goBack()
  {
    if (this.webView.canGoBack())
    {
      this.webView.goBack();
      return true;
    }
    return false;
  }
  
  void injectJS(String paramString)
  {
    this.webView.loadUrl(paramString);
  }
  
  void loadWebContent(String paramString)
  {
    this.overlayUrl = paramString;
    if (MMAdViewSDK.isConnected(getContext()))
    {
      this.webView.loadUrl(this.overlayUrl);
      return;
    }
    MMAdViewSDK.Log.e("No network available, can't load overlay.");
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean)
    {
      this.webView.loadUrl("javascript:MMSDK.mraid.stateChange('expanded');");
      this.webView.loadUrl("javascript:MMSDK.mraid.viewableChange(true)");
      return;
    }
    this.webView.loadUrl("javascript:MMSDK.mraid.stateChange('hidden');");
    this.webView.loadUrl("javascript:MMSDK.mraid.viewableChange(false)");
  }
  
  protected void setCloseButtonListener(boolean paramBoolean)
  {
    if (this.navCloseButton != null)
    {
      if (paramBoolean)
      {
        this.navCloseButton.setBackgroundDrawable(new CloseDrawable(true));
        this.navCloseButton.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            MMAdViewSDK.Log.v("Close button clicked.");
            AdViewOverlayView.this.dismiss(true);
          }
        });
        this.navCloseButton.setEnabled(true);
      }
    }
    else {
      return;
    }
    this.navCloseButton.setBackgroundDrawable(new CloseDrawable(false));
    this.navCloseButton.setEnabled(false);
  }
  
  void stopProgress()
  {
    if (!this.progressDone)
    {
      this.progressDone = true;
      this.progressBar.setVisibility(8);
      this.content.removeView(this.progressBar);
      this.progressBar = null;
    }
  }
  
  private class BottomBarDrawable
    extends Drawable
  {
    protected final Paint paint = new Paint();
    
    public BottomBarDrawable()
    {
      this.paint.setStrokeWidth(1.0F);
      this.paint.setStyle(Paint.Style.STROKE);
    }
    
    public void draw(Canvas paramCanvas)
    {
      Rect localRect = copyBounds();
      int i = Color.argb(255, 8, 8, 8);
      int j = Color.argb(255, 50, 50, 50);
      int k = Color.argb(255, 120, 120, 120);
      GradientDrawable localGradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[] { j, i });
      localGradientDrawable.setBounds(localRect);
      localGradientDrawable.draw(paramCanvas);
      this.paint.setARGB(255, 0, 0, 0);
      paramCanvas.drawLine(localRect.left, 0.0F, localRect.right, 0.0F, this.paint);
      this.paint.setColor(k);
      paramCanvas.drawLine(localRect.left, 1.0F, localRect.right, 1.0F, this.paint);
    }
    
    public int getOpacity()
    {
      return -3;
    }
    
    public void setAlpha(int paramInt) {}
    
    public void setColorFilter(ColorFilter paramColorFilter) {}
  }
  
  private class CloseDrawable
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
  
  private class CloseTopDrawable
    extends AdViewOverlayView.CloseDrawable
  {
    final float dist;
    final float scale;
    
    CloseTopDrawable(boolean paramBoolean, float paramFloat)
    {
      super(paramBoolean);
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
  
  private static final class NonConfigurationInstance
  {
    boolean bottomBarEnabled;
    boolean bottomBarVisible;
    boolean progressDone;
    WebView webView;
  }
  
  class OverlayJSInterface
  {
    OverlayJSInterface() {}
    
    public void shouldCloseOverlay()
    {
      AdViewOverlayView.this.viewHandler.sendEmptyMessage(2);
    }
    
    public void shouldEnableBottomBar(final boolean paramBoolean)
    {
      if (AdViewOverlayView.this.settings.shouldEnableBottomBar)
      {
        MMAdViewSDK.Log.d("Should Enable Bottom Bar: %b", new Object[] { Boolean.valueOf(paramBoolean) });
        AdViewOverlayView.this.viewHandler.post(new Runnable()
        {
          public void run()
          {
            AdViewOverlayView.this.setCloseButtonListener(paramBoolean);
          }
        });
      }
    }
    
    public void shouldShowBottomBar(final boolean paramBoolean)
    {
      if (AdViewOverlayView.this.settings.shouldShowBottomBar)
      {
        MMAdViewSDK.Log.d("Should show Bottom Bar: %b", new Object[] { Boolean.valueOf(paramBoolean) });
        AdViewOverlayView.this.viewHandler.post(new Runnable()
        {
          public void run()
          {
            if (AdViewOverlayView.this.navBar != null)
            {
              if (paramBoolean) {
                AdViewOverlayView.this.navBar.setVisibility(0);
              }
            }
            else {
              return;
            }
            AdViewOverlayView.this.navBar.setVisibility(8);
          }
        });
      }
    }
    
    public void shouldVibrate(long paramLong)
    {
      if (AdViewOverlayView.this.getContext().checkCallingOrSelfPermission("android.permission.VIBRATE") == 0) {
        ((Vibrator)AdViewOverlayView.this.getContext().getSystemService("vibrator")).vibrate(paramLong);
      }
    }
  }
  
  final class OverlayWebViewClient
    extends MMWebViewClient
  {
    OverlayWebViewClient(OverlaySettings paramOverlaySettings)
    {
      super();
    }
    
    public void onPageFinished(WebView paramWebView, String paramString)
    {
      if (!this.hasDoneMraidCalls)
      {
        this.hasDoneMraidCalls = true;
        AdViewOverlayView.this.webView.loadUrl("javascript:MMSDK.mraid.setPlacementType('interstitial');");
        if (!AdViewOverlayView.this.hasWindowFocus()) {
          break label84;
        }
        AdViewOverlayView.this.webView.loadUrl("javascript:MMSDK.mraid.stateChange('expanded');");
        AdViewOverlayView.this.webView.loadUrl("javascript:MMSDK.mraid.viewableChange(true)");
      }
      for (;;)
      {
        AdViewOverlayView.this.webView.loadUrl("javascript:MMSDK.mraid.ready();");
        AdViewOverlayView.this.stopProgress();
        super.onPageFinished(paramWebView, paramString);
        return;
        label84:
        AdViewOverlayView.this.webView.loadUrl("javascript:MMSDK.mraid.stateChange('hidden');");
        AdViewOverlayView.this.webView.loadUrl("javascript:MMSDK.mraid.viewableChange(false)");
      }
    }
    
    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      MMAdViewSDK.Log.d("onPageStarted: %s", new Object[] { paramString });
      if (paramString != null)
      {
        paramWebView = (Activity)AdViewOverlayView.this.getContext();
        if (paramWebView == null) {
          MMAdViewSDK.Log.d("Activity is null. Returning from click");
        }
      }
      else
      {
        return;
      }
      paramString = Uri.parse(paramString);
      if ((paramString != null) && (paramString.getScheme() != null) && (paramString.getScheme().equalsIgnoreCase("mmvideo")))
      {
        paramString = paramString.getHost();
        if (paramString != null)
        {
          paramString = (VideoAd)AdCache.load(paramWebView, paramString);
          if ((paramString != null) && (paramString.canShow(paramWebView, null, false))) {
            paramString.show(paramWebView, null);
          }
        }
        AdViewOverlayView.this.webView.goBack();
        return;
      }
      if ((paramString.getScheme() != null) && (paramString.getScheme().equalsIgnoreCase("http")))
      {
        if ((paramString.getLastPathSegment() != null) && ((paramString.getLastPathSegment().endsWith(".mp4")) || (paramString.getLastPathSegment().endsWith(".3gp"))))
        {
          MMAdViewSDK.Log.v("Creating video player intent.");
          paramBitmap = new Intent(paramWebView, MMActivity.class);
          paramBitmap.setData(paramString);
          paramBitmap.putExtra("class", "com.millennialmedia.android.VideoPlayerActivity");
          paramWebView.startActivity(paramBitmap);
          MMAdViewSDK.Event.intentStarted(AdViewOverlayView.this.getContext(), null, "streamingVideo");
          return;
        }
        shouldShowAndEnableBottomBar();
        return;
      }
      try
      {
        paramString = HttpRedirection.getIntentFromUri(paramWebView, paramString, null);
        if (paramString != null)
        {
          paramWebView.startActivity(paramString);
          AdViewOverlayView.this.webView.stopLoading();
          AdViewOverlayView.this.webView.goBack();
          return;
        }
      }
      catch (ActivityNotFoundException paramWebView)
      {
        MMAdViewSDK.Log.e(paramWebView.getMessage());
        return;
      }
      MMAdViewSDK.Log.d("Uncertain about content. Stay in the overlay");
      shouldShowAndEnableBottomBar();
    }
    
    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      MMAdViewSDK.Log.e("Error: %s %s %s", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
    }
    
    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      MMAdViewSDK.Log.d("shouldOverrideUrlLoading: %s", new Object[] { paramString });
      return super.shouldOverrideUrlLoading(paramWebView, paramString);
    }
    
    public void shouldShowAndEnableBottomBar()
    {
      if (this.settings.shouldShowBottomBar)
      {
        MMAdViewSDK.Log.v("Showing bottom bar");
        if (AdViewOverlayView.this.navBar != null)
        {
          AdViewOverlayView.this.navBar.setVisibility(0);
          if (this.settings.shouldEnableBottomBar)
          {
            MMAdViewSDK.Log.v("Enabling bottom bar");
            AdViewOverlayView.this.setCloseButtonListener(true);
          }
        }
      }
    }
  }
  
  private class SetCloseButtonTouchDelegateRunnable
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/millennialmedia/android/AdViewOverlayView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */