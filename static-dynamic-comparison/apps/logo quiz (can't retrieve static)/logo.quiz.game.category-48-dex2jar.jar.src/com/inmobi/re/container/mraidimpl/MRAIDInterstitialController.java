package com.inmobi.re.container.mraidimpl;

import android.app.Activity;
import android.os.Message;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.inmobi.commons.internal.Log;
import com.inmobi.re.configs.ConfigParams;
import com.inmobi.re.configs.Initializer;
import com.inmobi.re.container.CustomView;
import com.inmobi.re.container.CustomView.SwitchIconType;
import com.inmobi.re.container.IMWebView;
import com.inmobi.re.container.IMWebView.ViewState;
import com.inmobi.re.container.WrapperFunctions;
import java.util.concurrent.atomic.AtomicBoolean;

public class MRAIDInterstitialController
{
  protected static final int INT_BACKGROUND_ID = 224;
  public static final int INT_CLOSE_BUTTON = 225;
  public static AtomicBoolean isInterstitialDisplayed = new AtomicBoolean();
  private IMWebView a;
  private Activity b;
  private int c;
  public boolean lockOrientationValueForInterstitial = false;
  public Message mMsgOnInterstitialClosed;
  public Message mMsgOnInterstitialShown;
  public Display mSensorDisplay;
  public String orientationValueForInterstitial;
  
  public MRAIDInterstitialController(IMWebView paramIMWebView, Activity paramActivity)
  {
    this.a = paramIMWebView;
    this.b = paramActivity;
  }
  
  public void changeContentAreaForInterstitials()
  {
    try
    {
      int i = Initializer.getConfigParams(this.b.getApplicationContext()).getWebviewBgColor();
      this.c = this.b.getRequestedOrientation();
      handleOrientationForInterstitial();
      FrameLayout localFrameLayout = (FrameLayout)this.b.findViewById(16908290);
      RelativeLayout localRelativeLayout = new RelativeLayout(this.a.getContext());
      Object localObject = new RelativeLayout.LayoutParams(WrapperFunctions.getParamFillParent(), WrapperFunctions.getParamFillParent());
      ((RelativeLayout.LayoutParams)localObject).addRule(10);
      this.a.setFocusable(true);
      this.a.setFocusableInTouchMode(true);
      localRelativeLayout.addView(this.a, (ViewGroup.LayoutParams)localObject);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams((int)(this.a.getDensity() * 50.0F), (int)(this.a.getDensity() * 50.0F));
      if (!this.a.getCustomClose()) {}
      for (localObject = new CustomView(this.a.getContext(), this.a.getDensity(), CustomView.SwitchIconType.CLOSE_BUTTON);; localObject = new CustomView(this.a.getContext(), this.a.getDensity(), CustomView.SwitchIconType.CLOSE_TRANSPARENT))
      {
        localLayoutParams.addRule(11);
        ((CustomView)localObject).setId(225);
        localRelativeLayout.addView((View)localObject, localLayoutParams);
        ((CustomView)localObject).setOnClickListener(new e());
        localObject = new RelativeLayout.LayoutParams(WrapperFunctions.getParamFillParent(), WrapperFunctions.getParamFillParent());
        localRelativeLayout.setId(224);
        localRelativeLayout.setBackgroundColor(i);
        localFrameLayout.addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject);
        this.a.setBackgroundColor(i);
        this.a.requestFocus();
        this.a.setOnKeyListener(new d());
        this.a.setOnTouchListener(new f());
        isInterstitialDisplayed.set(true);
        if (this.mMsgOnInterstitialShown == null) {
          break;
        }
        this.mMsgOnInterstitialShown.sendToTarget();
        this.mMsgOnInterstitialShown = null;
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      Log.debug("IMRE_3.7.1", "Failed showing interstitial ad", localException);
    }
  }
  
  @Deprecated
  public void changeContentAreaForInterstitials(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        this.c = this.b.getRequestedOrientation();
        handleOrientationForInterstitial();
        FrameLayout localFrameLayout = (FrameLayout)this.b.findViewById(16908290);
        RelativeLayout localRelativeLayout = new RelativeLayout(this.a.getContext());
        Object localObject = new RelativeLayout.LayoutParams(WrapperFunctions.getParamFillParent(), WrapperFunctions.getParamFillParent());
        ((RelativeLayout.LayoutParams)localObject).addRule(10);
        this.a.setFocusable(true);
        this.a.setFocusableInTouchMode(true);
        localRelativeLayout.addView(this.a, (ViewGroup.LayoutParams)localObject);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams((int)(this.a.getDensity() * 50.0F), (int)(this.a.getDensity() * 50.0F));
        if (!this.a.getCustomClose())
        {
          localObject = new CustomView(this.a.getContext(), this.a.getDensity(), CustomView.SwitchIconType.CLOSE_BUTTON);
          localLayoutParams.addRule(11);
          ((CustomView)localObject).setId(225);
          localRelativeLayout.addView((View)localObject, localLayoutParams);
          ((CustomView)localObject).setOnClickListener(new c());
          localObject = new RelativeLayout.LayoutParams(WrapperFunctions.getParamFillParent(), WrapperFunctions.getParamFillParent());
          localRelativeLayout.setId(224);
          if (paramBoolean)
          {
            i = 0;
            localRelativeLayout.setBackgroundColor(i);
            localFrameLayout.addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject);
            localObject = this.a;
            if (!paramBoolean) {
              break label358;
            }
            i = 0;
            ((IMWebView)localObject).setBackgroundColor(i);
            this.a.requestFocus();
            this.a.setOnKeyListener(new a());
            this.a.setOnTouchListener(new b());
            isInterstitialDisplayed.set(true);
            if (this.mMsgOnInterstitialShown == null) {
              break;
            }
            this.mMsgOnInterstitialShown.sendToTarget();
            this.mMsgOnInterstitialShown = null;
          }
        }
        else
        {
          localObject = new CustomView(this.a.getContext(), this.a.getDensity(), CustomView.SwitchIconType.CLOSE_TRANSPARENT);
          continue;
        }
        i = -16777216;
      }
      catch (Exception localException)
      {
        Log.debug("IMRE_3.7.1", "Failed showing interstitial ad", localException);
        return;
      }
      continue;
      label358:
      int i = -16777216;
    }
  }
  
  public void handleInterstitialClose()
  {
    IMWebView.userInitiatedClose = true;
    isInterstitialDisplayed.set(false);
    this.a.close();
  }
  
  public void handleOrientationForInterstitial()
  {
    this.a.lockExpandOrientation(this.lockOrientationValueForInterstitial, this.orientationValueForInterstitial);
  }
  
  public void resetContentsForInterstitials()
  {
    try
    {
      if (this.a.getParent() == null) {
        return;
      }
      this.b.setRequestedOrientation(this.c);
      this.a.mAudioVideoController.releaseAllPlayers();
      FrameLayout localFrameLayout = (FrameLayout)this.b.findViewById(16908290);
      RelativeLayout localRelativeLayout = (RelativeLayout)localFrameLayout.findViewById(224);
      if (localRelativeLayout != null)
      {
        localRelativeLayout.removeView(this.a);
        localFrameLayout.removeView(localRelativeLayout);
      }
      if (this.mMsgOnInterstitialClosed != null)
      {
        this.mMsgOnInterstitialClosed.sendToTarget();
        this.mMsgOnInterstitialClosed = null;
      }
      this.a.injectJavaScript("window.mraidview.unRegisterOrientationListener()");
      this.a.setState(IMWebView.ViewState.HIDDEN);
      return;
    }
    catch (Exception localException)
    {
      Log.debug("IMRE_3.7.1", "Failed to close the interstitial ad", localException);
    }
  }
  
  class a
    implements View.OnKeyListener
  {
    a() {}
    
    public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
    {
      if ((4 == paramKeyEvent.getKeyCode()) && (paramKeyEvent.getAction() == 0))
      {
        Log.debug("IMRE_3.7.1", "Back Button pressed while Interstitial ad is in active state ");
        MRAIDInterstitialController.this.handleInterstitialClose();
        return true;
      }
      return false;
    }
  }
  
  class b
    implements View.OnTouchListener
  {
    b() {}
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      switch (paramMotionEvent.getAction())
      {
      }
      for (;;)
      {
        return false;
        paramView.requestFocus();
        continue;
        paramView.requestFocus();
      }
    }
  }
  
  class c
    implements View.OnClickListener
  {
    c() {}
    
    public void onClick(View paramView)
    {
      MRAIDInterstitialController.this.handleInterstitialClose();
    }
  }
  
  class d
    implements View.OnKeyListener
  {
    d() {}
    
    public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
    {
      if ((4 == paramKeyEvent.getKeyCode()) && (paramKeyEvent.getAction() == 0))
      {
        Log.debug("IMRE_3.7.1", "Back Button pressed while Interstitial ad is in active state ");
        MRAIDInterstitialController.this.handleInterstitialClose();
        return true;
      }
      return false;
    }
  }
  
  class e
    implements View.OnClickListener
  {
    e() {}
    
    public void onClick(View paramView)
    {
      MRAIDInterstitialController.this.handleInterstitialClose();
    }
  }
  
  class f
    implements View.OnTouchListener
  {
    f() {}
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      switch (paramMotionEvent.getAction())
      {
      }
      for (;;)
      {
        return false;
        paramView.requestFocus();
        continue;
        paramView.requestFocus();
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/inmobi/re/container/mraidimpl/MRAIDInterstitialController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */