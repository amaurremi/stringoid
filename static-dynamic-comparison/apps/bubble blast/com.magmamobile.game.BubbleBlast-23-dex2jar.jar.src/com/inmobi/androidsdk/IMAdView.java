package com.inmobi.androidsdk;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.inmobi.androidsdk.ai.container.IMWebView;
import com.inmobi.androidsdk.ai.container.IMWebView.IMWebViewListener;
import com.inmobi.androidsdk.ai.container.IMWebView.ViewState;
import com.inmobi.androidsdk.ai.container.IMWrapperFunctions;
import com.inmobi.androidsdk.ai.controller.util.IMConfigException;
import com.inmobi.androidsdk.ai.controller.util.IMSDKUtil;
import com.inmobi.androidsdk.impl.IMAdUnit;
import com.inmobi.androidsdk.impl.IMAdUnit.AdActionNames;
import com.inmobi.androidsdk.impl.IMAdUnit.AdTypes;
import com.inmobi.androidsdk.impl.IMClickProcessingTask;
import com.inmobi.androidsdk.impl.IMNiceInfo;
import com.inmobi.androidsdk.impl.IMUserInfo;
import com.inmobi.androidsdk.impl.net.IMHttpRequestCallback;
import com.inmobi.androidsdk.impl.net.IMRequestResponseManager;
import com.inmobi.androidsdk.impl.net.IMRequestResponseManager.ActionType;
import com.inmobi.commons.internal.IMLog;
import com.inmobi.commons.internal.InternalSDKUtil;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

public final class IMAdView
  extends RelativeLayout
{
  public static final int INMOBI_AD_UNIT_120X600 = 13;
  public static final int INMOBI_AD_UNIT_300X250 = 10;
  public static final int INMOBI_AD_UNIT_320X48 = 9;
  public static final int INMOBI_AD_UNIT_320X50 = 15;
  public static final int INMOBI_AD_UNIT_468X60 = 12;
  public static final int INMOBI_AD_UNIT_728X90 = 11;
  public static final String INMOBI_INTERNAL_TAG = "ref-__in__rt";
  public static final String INMOBI_REF_TAG = "ref-tag";
  public static final int REFRESH_INTERVAL_DEFAULT = 60;
  public static final int REFRESH_INTERVAL_OFF = -1;
  private String A = "http://i.w.inmobi.com/showad.asm";
  private String B = "http://i.w.sandbox.inmobi.com/showad.asm";
  private String C;
  private IMRequestResponseManager D;
  private a E = new a(this);
  private View.OnTouchListener F = new View.OnTouchListener()
  {
    public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
    {
      IMLog.debug("InMobiAndroidSDK_3.6.1", "onTouch: view: " + paramAnonymousView + ", event: " + paramAnonymousMotionEvent);
      if ((IMAdView.a(IMAdView.this) != null) && (paramAnonymousView.equals(IMAdView.a(IMAdView.this)))) {
        paramAnonymousView.requestFocusFromTouch();
      }
      do
      {
        return true;
        if ((IMAdView.b(IMAdView.this) != null) && (paramAnonymousView.equals(IMAdView.b(IMAdView.this))))
        {
          paramAnonymousView.requestFocusFromTouch();
          return true;
        }
        if (paramAnonymousMotionEvent.getAction() == 1)
        {
          IMAdView.c(IMAdView.this);
          IMAdView.a(IMAdView.this, paramAnonymousMotionEvent);
          return true;
        }
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          if ((IMAdView.d(IMAdView.this)) || (IMAdView.e(IMAdView.this)) || (IMAdView.f(IMAdView.this) == null))
          {
            IMAdView.c(IMAdView.this);
            return true;
          }
          IMAdView.g(IMAdView.this);
          return true;
        }
        if (paramAnonymousMotionEvent.getAction() == 3)
        {
          IMAdView.c(IMAdView.this);
          return true;
        }
      } while (paramAnonymousMotionEvent.getAction() != 4);
      IMAdView.c(IMAdView.this);
      return true;
    }
  };
  private Animation.AnimationListener G = new Animation.AnimationListener()
  {
    public void onAnimationEnd(Animation paramAnonymousAnimation)
    {
      boolean bool = false;
      for (;;)
      {
        try
        {
          if (!paramAnonymousAnimation.equals(IMAdView.this.a())) {
            continue;
          }
          IMAdView.this.removeAllViews();
          if (!IMAdView.h(IMAdView.this)) {
            continue;
          }
          IMAdView.this.addView(IMAdView.a(IMAdView.this));
          if ((IMAdView.f(IMAdView.this) != null) && (IMAdView.f(IMAdView.this).getAdActionName() == IMAdUnit.AdActionNames.AdActionName_Search)) {
            IMAdView.a(IMAdView.this).requestFocusFromTouch();
          }
          if ((IMAdView.f(IMAdView.this).getAdType() != IMAdUnit.AdTypes.RICH_MEDIA) && (IMAdView.f(IMAdView.this).getAdActionName() != IMAdUnit.AdActionNames.AdActionName_Search)) {
            IMAdView.this.addView(IMAdView.i(IMAdView.this));
          }
          IMAdView.this.startAnimation(IMAdView.this.b());
        }
        catch (Exception localException)
        {
          IMLog.debug("InMobiAndroidSDK_3.6.1", "Error animating banner ads", localException);
          return;
          localIMAdView = IMAdView.this;
          if (!IMAdView.h(IMAdView.this)) {
            break label322;
          }
          IMAdView.a(localIMAdView, bool);
          IMAdView.b(IMAdView.this, false);
          IMAdView.c(IMAdView.this);
          continue;
        }
        finally
        {
          if (paramAnonymousAnimation.equals(IMAdView.this.a())) {
            continue;
          }
          IMAdView.a(IMAdView.this, 100, null);
        }
        if (!paramAnonymousAnimation.equals(IMAdView.this.a())) {
          IMAdView.a(IMAdView.this, 100, null);
        }
        return;
        IMAdView.this.addView(IMAdView.b(IMAdView.this));
        if ((IMAdView.f(IMAdView.this) != null) && (IMAdView.f(IMAdView.this).getAdActionName() == IMAdUnit.AdActionNames.AdActionName_Search)) {
          IMAdView.b(IMAdView.this).requestFocusFromTouch();
        }
      }
      for (;;)
      {
        IMAdView localIMAdView;
        label322:
        bool = true;
      }
    }
    
    public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
    
    public void onAnimationStart(Animation paramAnonymousAnimation) {}
  };
  private IMHttpRequestCallback H = new IMHttpRequestCallback()
  {
    public void notifyResult(int paramAnonymousInt, Object paramAnonymousObject)
    {
      IMLog.debug("InMobiAndroidSDK_3.6.1", ">>> Got HTTP REQUEST callback. Status: " + paramAnonymousInt + " ,data=" + paramAnonymousObject);
      if (paramAnonymousInt == 0)
      {
        IMAdView.a(IMAdView.this, (IMAdUnit)paramAnonymousObject);
        IMAdView.j(IMAdView.this).sendEmptyMessage(109);
      }
      while (paramAnonymousInt != 1) {
        return;
      }
      Message localMessage = IMAdView.j(IMAdView.this).obtainMessage(110);
      localMessage.obj = paramAnonymousObject;
      localMessage.sendToTarget();
    }
  };
  private IMWebView.IMWebViewListener I = new IMWebView.IMWebViewListener()
  {
    public void onDismissAdScreen()
    {
      IMAdView.a(IMAdView.this, 103, null);
    }
    
    public void onError()
    {
      IMLog.debug("InMobiAndroidSDK_3.6.1", "Error loading ad ");
      IMAdView.j(IMAdView.this).sendEmptyMessage(111);
    }
    
    public void onExpand()
    {
      IMAdView.a(IMAdView.this, 102, null);
    }
    
    public void onExpandClose()
    {
      IMAdView.a(IMAdView.this, 103, null);
    }
    
    public void onLeaveApplication()
    {
      IMAdView.a(IMAdView.this, 104, null);
    }
    
    public void onShowAdScreen()
    {
      IMAdView.a(IMAdView.this, 102, null);
    }
  };
  private int a = 60;
  private IMWebView b;
  private IMWebView c;
  private LinearLayout d;
  private Activity e;
  private boolean f = true;
  private IMUserInfo g;
  private IMNiceInfo h;
  private AtomicBoolean i = new AtomicBoolean();
  private AtomicBoolean j = new AtomicBoolean();
  private Animation k;
  private Animation l;
  private IMAdUnit m = null;
  private String n;
  private String o;
  private String p;
  private IMAdListener q;
  private IMAdRequest r;
  private String s;
  private int t;
  private long u = -1L;
  private boolean v;
  private boolean w = true;
  private AnimationType x = AnimationType.ROTATE_HORIZONTAL_AXIS;
  private boolean y = true;
  private a z;
  
  public IMAdView(Activity paramActivity, int paramInt, String paramString)
  {
    this(paramActivity);
    String str = Integer.toString(InternalSDKUtil.incrementBaseUrl());
    this.C = ("http://localhost/" + str + "/");
    a(paramActivity, paramInt, paramString);
  }
  
  public IMAdView(Activity paramActivity, int paramInt, String paramString, long paramLong)
  {
    this(paramActivity);
    String str = Integer.toString(InternalSDKUtil.incrementBaseUrl());
    this.C = ("http://localhost/" + str + "/");
    this.u = paramLong;
    a(paramActivity, paramInt, paramString);
  }
  
  private IMAdView(Context paramContext)
  {
    super(paramContext);
  }
  
  public IMAdView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    String str = Integer.toString(InternalSDKUtil.incrementBaseUrl());
    this.C = ("http://localhost/" + str + "/");
    IMLog.debug("InMobiAndroidSDK_3.6.1", "IMAdView Constructor context: " + paramContext);
    str = paramAttributeSet.getAttributeValue(null, "appId");
    int i1 = paramAttributeSet.getAttributeIntValue(null, "adSize", -1);
    paramAttributeSet = paramAttributeSet.getAttributeValue(null, "slotId");
    if (paramAttributeSet != null) {
      this.u = Long.parseLong(paramAttributeSet);
    }
    a((Activity)paramContext, i1, str);
  }
  
  private void a(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("Invalid Ad Size. Please provide a valid Ad Size. If Ad Size is declared in the layout XML, please provide a valid 'adSize' attribute in the 'com.inmobi.androidsdk.IMAdView' tag of layout XML. For example, adSize=\"yourAdSize\"");
    }
  }
  
  private void a(final int paramInt, final IMAdRequest.ErrorCode paramErrorCode)
  {
    if (!this.y) {
      IMLog.debug("InMobiAndroidSDK_3.6.1", "IMAdView not sending callback because the view is not added to any window.");
    }
    while (this.q == null) {
      return;
    }
    this.e.runOnUiThread(new Runnable()
    {
      public void run()
      {
        try
        {
          switch (paramInt)
          {
          case 100: 
            IMAdView.s(IMAdView.this).onAdRequestCompleted(IMAdView.this);
            IMAdView.t(IMAdView.this);
            return;
          }
        }
        catch (Exception localException)
        {
          IMLog.debug("InMobiAndroidSDK_3.6.1", "Exception giving callback to the publisher ", localException);
          return;
        }
        IMAdView.t(IMAdView.this);
        switch (a()[paramErrorCode.ordinal()])
        {
        }
        for (;;)
        {
          IMAdView.s(IMAdView.this).onAdRequestFailed(IMAdView.this, paramErrorCode);
          return;
          IMLog.debug("InMobiAndroidSDK_3.6.1", "Ad click in progress. Your request cannot be processed at this time. Try again later.");
          continue;
          IMLog.debug("InMobiAndroidSDK_3.6.1", "Ad download in progress. Your request cannot be processed at this time. Try again later.");
          continue;
          IMLog.debug("InMobiAndroidSDK_3.6.1", "Ad request successful, but no ad was returned due to lack of ad inventory.");
          continue;
          IMLog.debug("InMobiAndroidSDK_3.6.1", "Your App Id may be invalid or inactive. Please verify the app ID");
          continue;
          IMAdView.s(IMAdView.this).onDismissAdScreen(IMAdView.this);
          return;
          IMAdView.s(IMAdView.this).onShowAdScreen(IMAdView.this);
          return;
          IMAdView.s(IMAdView.this).onLeaveApplication(IMAdView.this);
          return;
          return;
        }
      }
    });
  }
  
  private void a(Activity paramActivity, int paramInt, String paramString)
  {
    if (paramActivity == null) {
      throw new NullPointerException("Activity cannot be null");
    }
    try
    {
      IMSDKUtil.validateAdConfiguration(paramActivity);
      a(paramInt);
      IMSDKUtil.validateAppID(paramString);
      this.s = paramString;
      this.t = paramInt;
      this.e = IMSDKUtil.getRootActivity(paramActivity);
      if (this.b == null) {
        this.b = new IMWebView(this.e, this.I, false, false);
      }
      if (this.c == null)
      {
        this.c = new IMWebView(this.e, this.I, false, false);
        addView(this.c);
      }
      if (this.d == null)
      {
        this.d = new LinearLayout(this.e);
        this.d.setLayoutParams(new LinearLayout.LayoutParams(IMWrapperFunctions.getParamFillParent(), IMWrapperFunctions.getParamFillParent()));
        this.d.setOnTouchListener(this.F);
        this.d.setBackgroundColor(0);
        addView(this.d);
      }
      e();
      d();
      this.z = new a(this, this.G);
      return;
    }
    catch (IMConfigException localIMConfigException)
    {
      for (;;)
      {
        localIMConfigException.printStackTrace();
      }
    }
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    try
    {
      if ((this.m != null) && (!i()))
      {
        b(true);
        if (this.m.getTargetUrl() != null)
        {
          IMBrowserActivity.requestOnAdDismiss(this.E.obtainMessage(104));
          new IMClickProcessingTask(this.m, this.g, this.e, paramMotionEvent, this.E.obtainMessage(102), this.E.obtainMessage(105), this.E.obtainMessage(106), this.I).execute(new Void[] { null });
        }
      }
      l();
      return;
    }
    catch (Exception paramMotionEvent)
    {
      for (;;)
      {
        IMLog.debug("InMobiAndroidSDK_3.6.1", "Exception processing ad click ", paramMotionEvent);
        b(false);
      }
    }
  }
  
  private void a(IMAdUnit paramIMAdUnit)
  {
    if ((paramIMAdUnit != null) && (IMAdUnit.AdTypes.NONE != paramIMAdUnit.getAdType()) && (paramIMAdUnit.getCDATABlock() != null))
    {
      Object localObject = new StringBuffer(paramIMAdUnit.getCDATABlock());
      if (paramIMAdUnit.getAdType() == IMAdUnit.AdTypes.TEXT) {
        a((StringBuffer)localObject);
      }
      String str = ((StringBuffer)localObject).toString();
      if (j())
      {
        if (this.b == null) {
          this.b = new IMWebView(this.e, this.I, false, false);
        }
        localObject = this.b;
        if (paramIMAdUnit.getAdActionName() != IMAdUnit.AdActionNames.AdActionName_Search) {
          break label239;
        }
        IMLog.debug("InMobiAndroidSDK_3.6.1", "It came to AdActionType_Search method of displayad");
        ((IMWebView)localObject).requestOnSearchAdClicked(this.E.obtainMessage(103));
        ((IMWebView)localObject).setAdUnitData(true, paramIMAdUnit.getDefaultTargetUrl());
      }
      for (;;)
      {
        ((IMWebView)localObject).requestOnPageFinishedCallback(this.E.obtainMessage(101));
        this.E.sendEmptyMessageDelayed(108, 60000L);
        ((IMWebView)localObject).reinitializeExpandProperties();
        ((IMWebView)localObject).loadDataWithBaseURL(this.C, "<html><head><meta name=\"viewport\" content=\"width=device-width,initial-scale=1,user-scalable=no,maximum-scale=1\"><meta http-equiv=\"Content-Type\" content=\"text/html charset=utf-16le\"></head><body style=\"margin:0;padding:0\">" + str + "</body></html>", "text/html", null, this.C);
        return;
        if (this.c == null) {
          this.c = new IMWebView(this.e, this.I, false, false);
        }
        localObject = this.c;
        break;
        label239:
        ((IMWebView)localObject).setAdUnitData(false, null);
      }
    }
    a(false);
    IMLog.debug("InMobiAndroidSDK_3.6.1", "Cannot load Ad. Invalid Ad Response");
    a(101, IMAdRequest.ErrorCode.INTERNAL_ERROR);
  }
  
  private void a(StringBuffer paramStringBuffer)
  {
    if (this.n != null)
    {
      if (this.o == null) {
        break label68;
      }
      paramStringBuffer.append("<style>#im_c { background: -webkit-gradient(linear, left top, left bottom, from(#BGCOLOR1), to(#BGCOLOR2)) !important;\tbackground: -moz-linear-gradient(top,  #BGCOLOR1,  #BGCOLOR2) !important;} </style>".replaceAll("#BGCOLOR1", this.n).replaceAll("#BGCOLOR2", this.o));
    }
    for (;;)
    {
      if (this.p != null) {
        paramStringBuffer.append("<style>#im_text {\tcolor:#TEXTCOLOR !important;} </style>".replaceAll("#TEXTCOLOR", this.p));
      }
      return;
      label68:
      paramStringBuffer.append("<style>#im_c { \tbackground:#BGCOLOR1 !important;} </style>".replaceAll("#BGCOLOR1", this.n));
    }
  }
  
  private void a(boolean paramBoolean)
  {
    this.i.set(paramBoolean);
  }
  
  private boolean a(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("Color cannot be null");
    }
    int i1 = paramString.length();
    if ((!paramString.startsWith("#")) || ((i1 != 4) && (i1 != 7))) {
      throw new IllegalArgumentException("Invalid color format.Color should be of the format #rgb or #rrggbb ");
    }
    return true;
  }
  
  private void b(boolean paramBoolean)
  {
    this.j.set(paramBoolean);
  }
  
  private void c()
  {
    int i2 = 320;
    float f1 = this.e.getResources().getDisplayMetrics().density;
    for (;;)
    {
      try
      {
        switch (this.t)
        {
        case 9: 
          i2 = (int)(i2 * f1);
          i1 = (int)(i1 * f1);
          getLayoutParams().height = i1;
          getLayoutParams().width = i2;
          setLayoutParams(getLayoutParams());
          return;
        }
      }
      catch (Exception localException)
      {
        IMLog.internal("InMobiAndroidSDK_3.6.1", "Cannot set default size for adview", localException);
        return;
      }
      int i1 = 48;
      continue;
      i2 = 300;
      i1 = 250;
      continue;
      i2 = 729;
      i1 = 90;
      continue;
      i2 = 468;
      i1 = 60;
      continue;
      i2 = 120;
      i1 = 600;
      continue;
      i1 = 50;
    }
  }
  
  private void c(boolean paramBoolean)
  {
    this.f = paramBoolean;
    if (paramBoolean)
    {
      this.b.deinit();
      this.b = null;
      return;
    }
    this.c.deinit();
    this.c = null;
  }
  
  private void d()
  {
    if (this.h == null) {
      this.h = new IMNiceInfo(this.e.getApplicationContext(), this.g);
    }
  }
  
  private void e()
  {
    if (this.g == null)
    {
      this.g = new IMUserInfo(this.e.getApplicationContext());
      Object localObject = new DisplayMetrics();
      this.e.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
      float f1 = ((DisplayMetrics)localObject).density;
      localObject = ((WindowManager)this.e.getSystemService("window")).getDefaultDisplay();
      int i1 = IMWrapperFunctions.getDisplayWidth((Display)localObject);
      int i2 = IMWrapperFunctions.getDisplayHeight((Display)localObject);
      this.g.setScreenDensity(String.valueOf(f1));
      this.g.setScreenSize(i1 + "X" + i2);
    }
    try
    {
      if ((this.b != null) && (this.g.getPhoneDefaultUserAgent().equals(""))) {
        this.g.setPhoneDefaultUserAgent(InternalSDKUtil.getUserAgent(this.e));
      }
      this.g.setAdUnitSlot(String.valueOf(this.t));
      if (this.u != -1L) {
        this.g.setSlotId(Long.toString(this.u));
      }
      this.g.updateInfo(this.s, this.r);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        IMLog.debug("InMobiAndroidSDK_3.6.1", "Exception occured while setting user agent" + localException);
      }
    }
  }
  
  private void f()
  {
    bool = false;
    for (;;)
    {
      try
      {
        removeAllViews();
        if (!j()) {
          continue;
        }
        addView(this.b);
        if ((this.m != null) && (this.m.getAdActionName() == IMAdUnit.AdActionNames.AdActionName_Search)) {
          this.b.requestFocusFromTouch();
        }
        if ((this.m.getAdType() != IMAdUnit.AdTypes.RICH_MEDIA) && (this.m.getAdActionName() != IMAdUnit.AdActionNames.AdActionName_Search)) {
          addView(this.d);
        }
        if (!j()) {
          continue;
        }
      }
      catch (Exception localException)
      {
        IMLog.debug("InMobiAndroidSDK_3.6.1", "Error swapping banner ads", localException);
        return;
        bool = true;
        continue;
      }
      finally
      {
        a(100, null);
      }
      c(bool);
      a(false);
      l();
      a(100, null);
      return;
      addView(this.c);
      if ((this.m != null) && (this.m.getAdActionName() == IMAdUnit.AdActionNames.AdActionName_Search)) {
        this.c.requestFocusFromTouch();
      }
    }
  }
  
  private boolean g()
  {
    if ((!this.v) && (!InternalSDKUtil.validateAppId(this.s))) {
      return false;
    }
    if (this.t < 0)
    {
      IMLog.debug("InMobiAndroidSDK_3.6.1", "Invalid Ad Size. Please provide a valid adSize.");
      return false;
    }
    return true;
  }
  
  private boolean h()
  {
    return this.i.get();
  }
  
  private boolean i()
  {
    if (this.j.get()) {
      return true;
    }
    if (j()) {}
    for (IMWebView localIMWebView = this.c;; localIMWebView = this.b)
    {
      String str = localIMWebView.getState();
      IMLog.debug("InMobiAndroidSDK_3.6.1", "Current Ad State: " + str);
      if ((!IMWebView.ViewState.EXPANDED.toString().equalsIgnoreCase(str)) && (!IMWebView.ViewState.RESIZED.toString().equalsIgnoreCase(str)) && (!IMWebView.ViewState.EXPANDING.toString().equalsIgnoreCase(str))) {
        break;
      }
      IMLog.debug("InMobiAndroidSDK_3.6.1", "Current Ad State is neither default nor loading. New ad will not be shown.");
      return true;
    }
    if (localIMWebView.isBusy())
    {
      IMLog.debug("InMobiAndroidSDK_3.6.1", "New ad will not be shown because the present ad is busy. Eg. Video/audio is playing, etc.");
      return true;
    }
    return false;
  }
  
  private boolean j()
  {
    return this.f;
  }
  
  private void k()
  {
    try
    {
      int i1 = Color.argb(100, 0, 0, 0);
      if (this.c != null) {
        this.c.setBackgroundColor(i1);
      }
      if (this.b != null) {
        this.b.setBackgroundColor(i1);
      }
      this.d.setBackgroundColor(i1);
      return;
    }
    catch (Exception localException)
    {
      IMLog.debug("InMobiAndroidSDK_3.6.1", "Error setHighlightedBGColor", localException);
    }
  }
  
  private void l()
  {
    try
    {
      if (this.c != null) {
        this.c.setBackgroundColor(0);
      }
      if (this.b != null) {
        this.b.setBackgroundColor(0);
      }
      this.d.setBackgroundColor(0);
      return;
    }
    catch (Exception localException)
    {
      IMLog.debug("InMobiAndroidSDK_3.6.1", "Error setNormalBGColor", localException);
    }
  }
  
  private void m()
  {
    if (this.E.hasMessages(100)) {
      this.E.removeMessages(100);
    }
    this.E.sendEmptyMessageDelayed(100, this.a * 1000);
  }
  
  private void setAdServerTestUrl(String paramString)
  {
    this.B = paramString;
  }
  
  private void setAdServerUrl(String paramString)
  {
    this.A = paramString;
  }
  
  Animation a()
  {
    return this.k;
  }
  
  void a(Animation paramAnimation)
  {
    this.k = paramAnimation;
  }
  
  Animation b()
  {
    return this.l;
  }
  
  void b(Animation paramAnimation)
  {
    this.l = paramAnimation;
  }
  
  public int getAdSize()
  {
    return this.t;
  }
  
  public String getAppId()
  {
    return this.s;
  }
  
  public IMAdListener getIMAdListener()
  {
    return this.q;
  }
  
  public IMAdRequest getIMAdRequest()
  {
    return this.r;
  }
  
  public long getSlotId()
  {
    return this.u;
  }
  
  public void loadNewAd()
  {
    for (;;)
    {
      try
      {
        IMLog.debug("InMobiAndroidSDK_3.6.1", " >>>> Start loading new Ad <<<<");
        try
        {
          if (h())
          {
            a(101, IMAdRequest.ErrorCode.AD_DOWNLOAD_IN_PROGRESS);
            return;
          }
          if (i())
          {
            a(101, IMAdRequest.ErrorCode.AD_CLICK_IN_PROGRESS);
            continue;
          }
        }
        catch (Exception localException)
        {
          IMLog.debug("InMobiAndroidSDK_3.6.1", "Error in loading ad ", localException);
          continue;
        }
        if (g()) {
          break label85;
        }
      }
      finally {}
      a(101, IMAdRequest.ErrorCode.INVALID_REQUEST);
      continue;
      label85:
      a(true);
      e();
      if (this.g != null) {
        this.g.setRefreshType(0);
      }
      this.E.sendEmptyMessageDelayed(107, 60000L);
      this.E.removeMessages(100);
      this.D = new IMRequestResponseManager();
      this.D.asyncRequestAd(this.g, this.h, IMRequestResponseManager.ActionType.AdRequest, this.A, this.B, this.H);
    }
  }
  
  public void loadNewAd(IMAdRequest paramIMAdRequest)
  {
    if (paramIMAdRequest != null)
    {
      this.v = paramIMAdRequest.isTestMode();
      setIMAdRequest(paramIMAdRequest);
    }
    loadNewAd();
  }
  
  protected void onAttachedToWindow()
  {
    IMLog.debug("InMobiAndroidSDK_3.6.1", "onAttachedToWindow");
    this.y = true;
    c();
    setRefreshInterval(this.a);
  }
  
  protected void onDetachedFromWindow()
  {
    IMLog.debug("InMobiAndroidSDK_3.6.1", "onDetatchedFromWindow");
    this.y = false;
    setRefreshInterval(-1);
    if (j()) {}
    for (IMWebView localIMWebView = this.c;; localIMWebView = this.b)
    {
      if (localIMWebView != null) {
        localIMWebView.deinit();
      }
      return;
    }
  }
  
  public void setAdBackgroundColor(String paramString)
  {
    if (!a(paramString)) {
      return;
    }
    this.n = paramString;
    a(this.m);
  }
  
  public void setAdBackgroundGradientColor(String paramString1, String paramString2)
  {
    if ((!a(paramString1)) && (!a(paramString2))) {
      return;
    }
    this.n = paramString1;
    this.o = paramString2;
    a(this.m);
  }
  
  public void setAdSize(int paramInt)
  {
    a(paramInt);
    this.t = paramInt;
  }
  
  public void setAdTextColor(String paramString)
  {
    if (!a(paramString)) {
      return;
    }
    this.p = paramString;
    a(this.m);
  }
  
  public void setAnimationType(AnimationType paramAnimationType)
  {
    this.x = paramAnimationType;
  }
  
  public void setAppId(String paramString)
  {
    IMSDKUtil.validateAppID(paramString);
    this.s = paramString;
  }
  
  public void setIMAdListener(IMAdListener paramIMAdListener)
  {
    this.q = paramIMAdListener;
  }
  
  public void setIMAdRequest(IMAdRequest paramIMAdRequest)
  {
    this.r = paramIMAdRequest;
  }
  
  public void setRefTagParam(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      throw new NullPointerException("Key or Value cannot be null");
    }
    if ((paramString1.trim().equals("")) || (paramString2.trim().equals(""))) {
      throw new IllegalArgumentException("Key or Value cannot be empty");
    }
    if (this.g != null)
    {
      this.g.setRefTagKey(paramString1.toLowerCase());
      this.g.setRefTagValue(paramString2.toLowerCase());
    }
  }
  
  public void setRefreshInterval(int paramInt)
  {
    if (paramInt == -1)
    {
      this.a = -1;
      this.E.removeMessages(100);
      return;
    }
    if (paramInt < 20) {
      throw new IllegalArgumentException("Refresh Interval cannot be less than 20 seconds.");
    }
    this.a = paramInt;
    this.E.removeMessages(100);
    this.E.sendEmptyMessageDelayed(100, paramInt * 1000);
  }
  
  public void setSlotId(long paramLong)
  {
    this.u = paramLong;
  }
  
  public void stopLoading()
  {
    if (this.E.hasMessages(107))
    {
      this.E.removeMessages(107);
      this.E.sendEmptyMessage(107);
    }
    while (!this.E.hasMessages(108)) {
      return;
    }
    this.E.removeMessages(108);
    this.E.sendEmptyMessage(108);
  }
  
  public static enum AnimationType {}
  
  static class a
    extends Handler
  {
    private final WeakReference<IMAdView> a;
    
    public a(IMAdView paramIMAdView)
    {
      this.a = new WeakReference(paramIMAdView);
    }
    
    public void handleMessage(Message paramMessage)
    {
      IMAdView localIMAdView = (IMAdView)this.a.get();
      if (localIMAdView != null) {
        switch (paramMessage.what)
        {
        }
      }
      for (;;)
      {
        super.handleMessage(paramMessage);
        Object localObject;
        do
        {
          return;
          removeMessages(107);
          IMAdView.b(localIMAdView, IMAdView.f(localIMAdView));
          break;
          removeMessages(107);
          IMAdView.a(localIMAdView, 101, (IMAdRequest.ErrorCode)paramMessage.obj);
          IMAdView.b(localIMAdView, false);
          break;
          removeMessages(108);
          removeMessages(101);
          IMAdView.a(localIMAdView, 101, IMAdRequest.ErrorCode.INTERNAL_ERROR);
          break;
          removeMessages(111);
          removeMessages(101);
          IMAdView.b(localIMAdView, false);
          if (IMAdView.h(localIMAdView))
          {
            localObject = IMAdView.a(localIMAdView);
            IMAdView.a(localIMAdView, null);
          }
          for (;;)
          {
            ((IMWebView)localObject).cancelLoad();
            ((IMWebView)localObject).stopLoading();
            ((IMWebView)localObject).deinit();
            IMAdView.a(localIMAdView, 101, IMAdRequest.ErrorCode.AD_RENDERING_TIMEOUT);
            break;
            localObject = IMAdView.b(localIMAdView);
            IMAdView.b(localIMAdView, null);
          }
          removeMessages(109);
          removeMessages(110);
          IMAdView.k(localIMAdView).doCancel();
          IMAdView.b(localIMAdView, false);
          IMAdView.a(localIMAdView, 101, IMAdRequest.ErrorCode.AD_FETCH_TIMEOUT);
          break;
        } while (IMAdView.l(localIMAdView) == -1);
        if (!IMAdView.m(localIMAdView).hasWindowFocus()) {
          IMLog.debug("InMobiAndroidSDK_3.6.1", "Activity is not in the foreground. New ad will not be loaded.");
        }
        while (IMAdView.n(localIMAdView) != null)
        {
          IMAdView.n(localIMAdView).setRefreshType(1);
          break;
          if (IMWebView.isInterstitialDisplayed.get()) {
            IMLog.debug("InMobiAndroidSDK_3.6.1", "Ad cannot be loaded.Interstitial Ad is displayed.");
          } else {
            localIMAdView.loadNewAd();
          }
        }
        removeMessages(108);
        if (IMAdView.o(localIMAdView))
        {
          IMAdView.p(localIMAdView);
          IMAdView.c(localIMAdView, false);
        }
        else if (IMAdView.q(localIMAdView) == IMAdView.AnimationType.ANIMATION_OFF)
        {
          IMAdView.p(localIMAdView);
        }
        else
        {
          IMAdView.r(localIMAdView).a(IMAdView.q(localIMAdView));
          continue;
          IMAdView.d(localIMAdView, false);
          continue;
          localObject = paramMessage.getData();
          if ((localObject != null) && (IMAdView.f(localIMAdView) != null) && (((Bundle)localObject).getString("finaltargeturl") != null)) {
            IMAdView.f(localIMAdView).setTargetUrl(((Bundle)localObject).getString("finaltargeturl"));
          }
          IMAdView.a(localIMAdView, null);
          continue;
          IMAdView.a(localIMAdView, 103, null);
          continue;
          IMAdView.a(localIMAdView, 102, null);
          continue;
          IMAdView.a(localIMAdView, 104, null);
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/inmobi/androidsdk/IMAdView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */