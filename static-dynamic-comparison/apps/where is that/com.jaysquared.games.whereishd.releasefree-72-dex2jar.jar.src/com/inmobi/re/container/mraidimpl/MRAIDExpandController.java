package com.inmobi.re.container.mraidimpl;

import android.app.Activity;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.webkit.URLUtil;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.internal.WrapperFunctions;
import com.inmobi.re.container.CustomView;
import com.inmobi.re.container.CustomView.SwitchIconType;
import com.inmobi.re.container.IMWebView;
import com.inmobi.re.container.IMWebView.IMWebViewListener;
import com.inmobi.re.container.IMWebView.ViewState;
import com.inmobi.re.controller.JSController.ExpandProperties;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class MRAIDExpandController
{
  public static int EXP_CLOSE_BUTTON = 225;
  protected static final int PLACEHOLDER_ID = 437;
  protected static final int RELATIVELAYOUT_ID = 438;
  private IMWebView a;
  private Activity b;
  private IMWebView c = null;
  private IMWebView d = null;
  public JSController.ExpandProperties expandProperties;
  public int initialExpandOrientation;
  public boolean mIsExpandUrlValid = false;
  public Display mSensorDisplay;
  public boolean tempExpPropsLock = true;
  public boolean useLockOrient;
  
  public MRAIDExpandController(IMWebView paramIMWebView, Activity paramActivity)
  {
    this.a = paramIMWebView;
    this.b = paramActivity;
  }
  
  private FrameLayout a(JSController.ExpandProperties paramExpandProperties)
  {
    FrameLayout localFrameLayout1 = (FrameLayout)((ViewGroup)this.a.getOriginalParent()).getRootView().findViewById(16908290);
    a();
    FrameLayout localFrameLayout2 = new FrameLayout(this.a.getContext());
    FrameLayout.LayoutParams localLayoutParams1 = new FrameLayout.LayoutParams(WrapperFunctions.getParamFillParent(), WrapperFunctions.getParamFillParent());
    localFrameLayout2.setId(435);
    localFrameLayout2.setOnTouchListener(new c());
    localFrameLayout2.setPadding(paramExpandProperties.x, paramExpandProperties.y, 0, 0);
    FrameLayout.LayoutParams localLayoutParams2 = new FrameLayout.LayoutParams(WrapperFunctions.getParamFillParent(), WrapperFunctions.getParamFillParent());
    RelativeLayout localRelativeLayout = new RelativeLayout(this.a.getContext());
    localRelativeLayout.setId(438);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(WrapperFunctions.getParamFillParent(), WrapperFunctions.getParamFillParent());
    if (this.mIsExpandUrlValid) {
      localRelativeLayout.addView(this.c, localLayoutParams);
    }
    for (;;)
    {
      a(localRelativeLayout, paramExpandProperties.useCustomClose);
      localFrameLayout2.addView(localRelativeLayout, localLayoutParams2);
      localFrameLayout1.addView(localFrameLayout2, localLayoutParams1);
      this.a.setFocusable(true);
      this.a.setFocusableInTouchMode(true);
      this.a.requestFocus();
      return localFrameLayout2;
      localRelativeLayout.addView(this.a, localLayoutParams);
    }
  }
  
  private void a()
  {
    try
    {
      if (this.a.getOriginalParent() != this.a.getParent())
      {
        ((ViewGroup)this.a.getParent()).removeView(this.a);
        return;
      }
      FrameLayout localFrameLayout = new FrameLayout(this.a.getContext());
      localFrameLayout.setId(437);
      ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(this.a.getWidth(), this.a.getHeight());
      ((ViewGroup)this.a.getOriginalParent()).addView(localFrameLayout, this.a.getOriginalIndex(), localLayoutParams);
      ((ViewGroup)this.a.getParent()).removeView(this.a);
      return;
    }
    catch (Exception localException)
    {
      Log.debug("[InMobi]-[RE]-4.1.1", "Exception in replaceByPlaceHolder ", localException);
    }
  }
  
  private void a(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams((int)(this.a.getDensity() * 50.0F), (int)(this.a.getDensity() * 50.0F));
    localLayoutParams.addRule(11);
    if (paramBoolean) {}
    for (CustomView localCustomView = new CustomView(this.a.getContext(), this.a.getDensity(), CustomView.SwitchIconType.CLOSE_TRANSPARENT);; localCustomView = new CustomView(this.a.getContext(), this.a.getDensity(), CustomView.SwitchIconType.CLOSE_BUTTON))
    {
      localCustomView.setId(EXP_CLOSE_BUTTON);
      paramViewGroup.addView(localCustomView, localLayoutParams);
      localCustomView.setOnClickListener(new b());
      return;
    }
  }
  
  private void b()
  {
    if (this.c == null)
    {
      ((ViewGroup)this.a.getParent().getParent().getParent()).removeView((View)this.a.getParent().getParent());
      ((ViewGroup)this.a.getParent()).removeView(this.a);
      localObject = ((View)this.a.getOriginalParent()).findViewById(437);
      ((ViewGroup)((View)localObject).getParent()).removeView((View)localObject);
      if (this.a.mOriginalWebviewForExpandUrl == null) {
        break label192;
      }
    }
    label192:
    for (Object localObject = this.a.mOriginalWebviewForExpandUrl;; localObject = this.a)
    {
      ((ViewGroup)this.a.getOriginalParent()).addView((View)localObject, this.a.getOriginalIndex());
      ((IMWebView)localObject).resetLayout();
      return;
      ((ViewGroup)this.c.getParent().getParent().getParent()).removeView((View)this.c.getParent().getParent());
      ((ViewGroup)this.c.getParent()).removeView(this.c);
      break;
    }
  }
  
  public void closeExpanded()
  {
    if (this.a.getViewState().compareTo(IMWebView.ViewState.DEFAULT) == 0) {
      return;
    }
    if (this.d != null) {
      this.d.destroy();
    }
    if (this.a.mOriginalWebviewForExpandUrl != null)
    {
      this.a.mOriginalWebviewForExpandUrl.setState(IMWebView.ViewState.DEFAULT);
      this.a.mAudioVideoController.releaseAllPlayers();
      this.a.mOriginalWebviewForExpandUrl.mAudioVideoController.releaseAllPlayers();
      this.a.mOriginalWebviewForExpandUrl.mExpandController.d = null;
      this.a.destroy();
    }
    synchronized (this.a.mutex)
    {
      this.a.isMutexAquired.set(false);
      this.a.mutex.notifyAll();
      if ((!this.tempExpPropsLock) && (this.a.publisherOrientation == -1)) {
        this.tempExpPropsLock = true;
      }
      this.a.doNotFireVisibilityChanged.set(true);
      b();
      this.a.mAudioVideoController.releaseAllPlayers();
      this.a.getMRAIDUrls().clear();
      this.a.closeExpanded();
      this.a.setVisibility(0);
      this.mIsExpandUrlValid = false;
      if (this.useLockOrient) {
        this.b.setRequestedOrientation(this.initialExpandOrientation);
      }
      this.a.setState(IMWebView.ViewState.DEFAULT);
      this.a.doNotFireVisibilityChanged.set(false);
      return;
      this.d = null;
    }
  }
  
  public void disableEnableHardwareAccelerationForExpandWithURLView()
  {
    if (this.d != null) {
      this.d.disableHardwareAcceleration();
    }
  }
  
  public void doExpand(Bundle arg1)
  {
    this.a.doNotFireVisibilityChanged.set(true);
    for (;;)
    {
      try
      {
        if (this.a.getOriginalParent() == null) {
          this.a.saveOriginalViewParent();
        }
        if (((FrameLayout)this.a.getParent().getParent()).getId() == 435) {
          ((ViewGroup)this.a.getParent().getParent().getParent()).removeView((View)this.a.getParent().getParent());
        }
      }
      catch (Exception localException)
      {
        String str;
        continue;
      }
      try
      {
        str = ???.getString("expand_url");
        if (URLUtil.isValidUrl(str))
        {
          this.mIsExpandUrlValid = true;
          this.c = new IMWebView(this.a.getContext(), this.a.mListener, false, false);
          this.d = this.c;
          this.c.publisherOrientation = this.a.publisherOrientation;
          this.c.mExpandController.tempExpPropsLock = this.a.mExpandController.tempExpPropsLock;
          this.c.mExpandController.expandProperties = new JSController.ExpandProperties();
          this.c.mExpandController.expandProperties.x = this.a.mExpandController.expandProperties.x;
          this.c.mExpandController.expandProperties.y = this.expandProperties.y;
          this.c.mExpandController.expandProperties.currentX = this.expandProperties.currentX;
          this.c.mExpandController.expandProperties.currentY = this.expandProperties.currentY;
          this.c.mExpandController.initialExpandOrientation = this.a.mExpandController.initialExpandOrientation;
          this.c.mExpandController.useLockOrient = this.a.mExpandController.useLockOrient;
          this.c.mOriginalWebviewForExpandUrl = this.a;
          this.c.setOriginalParent(this.a.getOriginalParent());
          this.a.doNotFireVisibilityChanged.set(false);
          a(this.expandProperties).setBackgroundColor(0);
          this.a.mAudioVideoController.videoValidateWidth = this.expandProperties.width;
          if (this.c != null) {
            this.c.mAudioVideoController.videoValidateWidth = this.expandProperties.width;
          }
          this.a.setState(IMWebView.ViewState.EXPANDED);
        }
      }
      catch (Exception ???)
      {
        synchronized (this.a.mutex)
        {
          this.a.isMutexAquired.set(false);
          this.a.mutex.notifyAll();
          if (this.mIsExpandUrlValid) {
            this.c.loadUrl(str);
          }
          this.a.requestLayout();
          this.a.invalidate();
          this.a.postInHandler(new a());
          this.a.doNotFireVisibilityChanged.set(false);
          return;
          this.mIsExpandUrlValid = false;
          continue;
          ??? = ???;
          Log.debug("[InMobi]-[RE]-4.1.1", "Exception in doexpand ", ???);
          this.a.setState(IMWebView.ViewState.DEFAULT);
          synchronized (this.a.mutex)
          {
            this.a.isMutexAquired.set(false);
            this.a.mutex.notifyAll();
          }
        }
      }
    }
  }
  
  public void handleOrientationFor2Piece()
  {
    try
    {
      int i = this.a.getIntegerCurrentRotation();
      if (this.a.mInterstitialController.lockOrientationValueForInterstitial)
      {
        if (this.a.mInterstitialController.orientationValueForInterstitial.equals("portrait"))
        {
          this.b.setRequestedOrientation(WrapperFunctions.getParamPortraitOrientation(i));
          return;
        }
        if (this.a.mInterstitialController.orientationValueForInterstitial.equals("landscape"))
        {
          this.b.setRequestedOrientation(WrapperFunctions.getParamLandscapeOrientation(i));
          return;
        }
      }
    }
    catch (Exception localException)
    {
      Log.internal("[InMobi]-[RE]-4.1.1", "IMWebview Handle orientation for 2 piece ", localException);
    }
  }
  
  public void reset()
  {
    this.expandProperties = new JSController.ExpandProperties();
  }
  
  class a
    implements Runnable
  {
    a() {}
    
    public void run()
    {
      if (MRAIDExpandController.a(MRAIDExpandController.this).mListener != null) {
        MRAIDExpandController.a(MRAIDExpandController.this).mListener.onExpand();
      }
    }
  }
  
  class b
    implements View.OnClickListener
  {
    b() {}
    
    public void onClick(View paramView)
    {
      IMWebView.userInitiatedClose = true;
      if (!MRAIDExpandController.this.mIsExpandUrlValid)
      {
        MRAIDExpandController.a(MRAIDExpandController.this).close();
        return;
      }
      MRAIDExpandController.b(MRAIDExpandController.this).close();
    }
  }
  
  class c
    implements View.OnTouchListener
  {
    c() {}
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      return true;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/re/container/mraidimpl/MRAIDExpandController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */