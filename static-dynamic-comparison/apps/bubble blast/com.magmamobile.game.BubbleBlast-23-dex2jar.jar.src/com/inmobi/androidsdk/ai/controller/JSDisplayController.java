package com.inmobi.androidsdk.ai.controller;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.inmobi.androidsdk.ai.container.IMWebView;
import com.inmobi.androidsdk.ai.container.IMWebView.ViewState;
import com.inmobi.commons.internal.IMLog;
import com.inmobi.commons.internal.InternalSDKUtil;
import org.json.JSONObject;

public class JSDisplayController
  extends JSController
{
  private WindowManager a;
  private float b;
  
  public JSDisplayController(IMWebView paramIMWebView, Context paramContext)
  {
    super(paramIMWebView, paramContext);
    paramIMWebView = new DisplayMetrics();
    this.a = ((WindowManager)paramContext.getSystemService("window"));
    this.a.getDefaultDisplay().getMetrics(paramIMWebView);
    this.b = ((Activity)this.mContext).getResources().getDisplayMetrics().density;
  }
  
  private JSController.ExpandProperties a(JSController.ExpandProperties paramExpandProperties)
  {
    Object localObject = this.a.getDefaultDisplay();
    int k = ((Activity)this.mContext).getResources().getDisplayMetrics().widthPixels;
    int m = ((Activity)this.mContext).getResources().getDisplayMetrics().heightPixels;
    View localView = ((Activity)this.mContext).getWindow().findViewById(16908290);
    paramExpandProperties.topStuff = localView.getTop();
    paramExpandProperties.bottomStuff = (m - localView.getBottom());
    int j = InternalSDKUtil.getDisplayRotation((Display)localObject);
    int i = j;
    if (InternalSDKUtil.getWhetherTablet(j, k, m))
    {
      j += 1;
      i = j;
      if (j > 3) {
        i = 0;
      }
      this.imWebView.isTablet = true;
    }
    IMLog.debug("InMobiAndroidSDK_3.6.1", "Device current rotation: " + i);
    IMLog.debug("InMobiAndroidSDK_3.6.1", "Density of device: " + this.b);
    paramExpandProperties.width = ((int)(paramExpandProperties.width * this.b));
    paramExpandProperties.height = ((int)(paramExpandProperties.height * this.b));
    paramExpandProperties.x = ((int)(paramExpandProperties.x * this.b));
    paramExpandProperties.y = ((int)(paramExpandProperties.y * this.b));
    paramExpandProperties.currentX = 0;
    paramExpandProperties.currentY = 0;
    this.imWebView.publisherOrientation = ((Activity)this.imWebView.getContext()).getRequestedOrientation();
    if ((i == 0) || (i == 2))
    {
      paramExpandProperties.rotationAtExpand = "portrait";
      if ((paramExpandProperties.height <= 0) || (paramExpandProperties.width <= 0))
      {
        paramExpandProperties.height = m;
        paramExpandProperties.width = k;
        paramExpandProperties.zeroWidthHeight = true;
      }
      if ((i != 0) && (i != 2)) {
        break label710;
      }
      paramExpandProperties.portraitWidthRequested = paramExpandProperties.width;
    }
    for (paramExpandProperties.portraitHeightRequested = paramExpandProperties.height;; paramExpandProperties.portraitHeightRequested = paramExpandProperties.width)
    {
      IMLog.debug("InMobiAndroidSDK_3.6.1", "Device Width: " + k + " Device height: " + m);
      i = m - paramExpandProperties.topStuff;
      if (paramExpandProperties.width > k) {
        paramExpandProperties.width = k;
      }
      if (paramExpandProperties.height > i) {
        paramExpandProperties.height = i;
      }
      localObject = new int[2];
      this.imWebView.getLocationOnScreen((int[])localObject);
      if (paramExpandProperties.x < 0) {
        paramExpandProperties.x = localObject[0];
      }
      if (paramExpandProperties.y < 0)
      {
        paramExpandProperties.y = (localObject[1] - paramExpandProperties.topStuff);
        IMLog.debug("InMobiAndroidSDK_3.6.1", "topStuff: " + paramExpandProperties.topStuff + " ,bottomStuff: " + paramExpandProperties.bottomStuff);
      }
      IMLog.debug("InMobiAndroidSDK_3.6.1", "loc 0: " + localObject[0] + " loc 1: " + localObject[1]);
      j = k - (paramExpandProperties.x + paramExpandProperties.width);
      if (j < 0)
      {
        paramExpandProperties.x = (j + paramExpandProperties.x);
        if (paramExpandProperties.x < 0)
        {
          paramExpandProperties.width += paramExpandProperties.x;
          paramExpandProperties.x = 0;
        }
      }
      i -= paramExpandProperties.y + paramExpandProperties.height;
      if (i < 0)
      {
        paramExpandProperties.y = (i + paramExpandProperties.y);
        if (paramExpandProperties.y < 0)
        {
          paramExpandProperties.height += paramExpandProperties.y;
          paramExpandProperties.y = 0;
        }
      }
      paramExpandProperties.currentX = paramExpandProperties.x;
      paramExpandProperties.currentY = paramExpandProperties.y;
      IMLog.debug("InMobiAndroidSDK_3.6.1", "final expanded width after density : " + paramExpandProperties.width + "final expanded height after density " + paramExpandProperties.height + "portrait width requested :" + paramExpandProperties.portraitWidthRequested + "portrait height requested :" + paramExpandProperties.portraitHeightRequested);
      return paramExpandProperties;
      paramExpandProperties.rotationAtExpand = "landscape";
      break;
      label710:
      paramExpandProperties.portraitWidthRequested = paramExpandProperties.height;
    }
  }
  
  private void a(JSController.ExpandProperties paramExpandProperties1, JSController.ExpandProperties paramExpandProperties2)
  {
    paramExpandProperties1.width = paramExpandProperties2.width;
    paramExpandProperties1.height = paramExpandProperties2.height;
    paramExpandProperties1.x = paramExpandProperties2.x;
    paramExpandProperties1.y = paramExpandProperties2.y;
    paramExpandProperties1.actualWidthRequested = paramExpandProperties2.actualWidthRequested;
    paramExpandProperties1.actualHeightRequested = paramExpandProperties2.actualHeightRequested;
    paramExpandProperties1.lockOrientation = paramExpandProperties2.lockOrientation;
    paramExpandProperties1.isModal = paramExpandProperties2.isModal;
    paramExpandProperties1.useCustomClose = paramExpandProperties2.useCustomClose;
    paramExpandProperties1.orientation = paramExpandProperties2.orientation;
    paramExpandProperties1.topStuff = paramExpandProperties2.topStuff;
    paramExpandProperties1.bottomStuff = paramExpandProperties2.bottomStuff;
    paramExpandProperties1.portraitWidthRequested = paramExpandProperties2.portraitWidthRequested;
    paramExpandProperties1.portraitHeightRequested = paramExpandProperties2.portraitHeightRequested;
    paramExpandProperties1.zeroWidthHeight = paramExpandProperties2.zeroWidthHeight;
    paramExpandProperties1.rotationAtExpand = paramExpandProperties2.rotationAtExpand;
    paramExpandProperties1.currentX = paramExpandProperties2.currentX;
    paramExpandProperties1.currentY = paramExpandProperties2.currentY;
  }
  
  public void acceptAction(String paramString)
  {
    this.imWebView.acceptAction(paramString);
  }
  
  public void close()
  {
    IMLog.debug("InMobiAndroidSDK_3.6.1", "JSDisplayController-> close");
    if (this.imWebView.mOriginalWebviewForExpandUrl != null)
    {
      this.imWebView.mOriginalWebviewForExpandUrl.close();
      return;
    }
    this.imWebView.close();
  }
  
  public void expand(String paramString)
  {
    IMLog.debug("InMobiAndroidSDK_3.6.1", "JSDisplayController-> expand: url: " + paramString);
    try
    {
      if ((this.imWebView.getStateVariable() == IMWebView.ViewState.EXPANDED) || (this.imWebView.getStateVariable() == IMWebView.ViewState.EXPANDING))
      {
        IMLog.debug("InMobiAndroidSDK_3.6.1", "JSDisplayController-> Already expanded state");
        return;
      }
      this.imWebView.useLockOrient = false;
      if (this.imWebView.getStateVariable() != IMWebView.ViewState.DEFAULT)
      {
        this.imWebView.postInjectJavaScript("window.mraidview.fireErrorEvent(\"Current state is not default\", \"expand\")");
        return;
      }
    }
    catch (Exception paramString)
    {
      IMLog.debug("InMobiAndroidSDK_3.6.1", "Exception while expanding the ad. ", paramString);
      return;
    }
    if ((this.imWebView.getStateVariable() == IMWebView.ViewState.DEFAULT) && (this.imWebView.mIsInterstitialAd))
    {
      this.imWebView.postInjectJavaScript("window.mraidview.fireErrorEvent(\"Expand cannot be called on interstitial ad\", \"expand\")");
      return;
    }
    a(this.temporaryexpProps, this.expProps);
    IMLog.debug("InMobiAndroidSDK_3.6.1", "JSDisplayController-> At the time of expand the properties are: Expandable width: " + this.temporaryexpProps.width + " Expandable height: " + this.temporaryexpProps.height + " Expandable orientation: " + this.temporaryexpProps.orientation + " Expandable lock orientation: " + this.temporaryexpProps.lockOrientation + " Expandable Modality: " + this.temporaryexpProps.isModal + " Expandable Use custom close " + this.temporaryexpProps.useCustomClose);
    this.imWebView.lockExpandOrientation(this.temporaryexpProps);
    this.imWebView.expand(paramString, a(this.temporaryexpProps));
  }
  
  public String getOrientation()
  {
    try
    {
      String str = this.imWebView.getCurrentRotation(this.imWebView.getIntegerCurrentRotation());
      IMLog.debug("InMobiAndroidSDK_3.6.1", "JSDisplayController-> getOrientation: " + str);
      return str;
    }
    catch (Exception localException)
    {
      IMLog.debug("InMobiAndroidSDK_3.6.1", "Error getOrientation: " + "-1", localException);
    }
    return "-1";
  }
  
  public String getPlacementType()
  {
    IMLog.debug("InMobiAndroidSDK_3.6.1", "JSDisplayController-> getPlacementType");
    return this.imWebView.getPlacementType();
  }
  
  public String getState()
  {
    IMLog.debug("InMobiAndroidSDK_3.6.1", "JSDisplayController-> getState");
    return this.imWebView.getState();
  }
  
  public boolean isViewable()
  {
    IMLog.debug("InMobiAndroidSDK_3.6.1", "JSDisplayController-> isViewable");
    return this.imWebView.isViewable();
  }
  
  public void onOrientationChange()
  {
    this.imWebView.onOrientationEventChange();
  }
  
  public void open(String paramString)
  {
    IMLog.debug("InMobiAndroidSDK_3.6.1", "JSDisplayController-> open: url: " + paramString);
    this.imWebView.openURL(paramString);
  }
  
  public void rejectAction(String paramString)
  {
    this.imWebView.rejectAction(paramString);
  }
  
  public void setExpandProperties(String paramString)
  {
    try
    {
      this.expProps = ((JSController.ExpandProperties)getFromJSON(new JSONObject(paramString), JSController.ExpandProperties.class));
      IMLog.debug("InMobiAndroidSDK_3.6.1", "JSDisplayController-> ExpandProperties is set: Expandable Width: " + this.expProps.width + " Expandable height: " + this.expProps.height + " Expandable orientation: " + this.expProps.orientation + " Expandable lock orientation: " + this.expProps.lockOrientation + " Expandable Modality: " + this.expProps.isModal + " Expandable Use Custom close: " + this.expProps.useCustomClose);
      this.imWebView.setExpandPropertiesForInterstitial(this.expProps.useCustomClose, this.expProps.lockOrientation, this.expProps.orientation);
      return;
    }
    catch (Exception paramString)
    {
      IMLog.debug("InMobiAndroidSDK_3.6.1", "Exception while setting the expand properties " + paramString);
    }
  }
  
  public void stopAllListeners() {}
  
  public void useCustomClose(boolean paramBoolean)
  {
    IMLog.debug("InMobiAndroidSDK_3.6.1", "JSDisplayController-> useCustomClose" + paramBoolean);
    this.imWebView.setCustomClose(paramBoolean);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/inmobi/androidsdk/ai/controller/JSDisplayController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */