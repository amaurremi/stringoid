package com.inmobi.re.controller;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.JavascriptInterface;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.re.container.IMWebView;
import com.inmobi.re.container.IMWebView.ViewState;
import org.json.JSONException;
import org.json.JSONObject;

public class JSDisplayController
  extends JSController
{
  private WindowManager a;
  private float b;
  private JSController.OrientationProperties c = null;
  private JSController.ResizeProperties d = null;
  
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
    int i = InternalSDKUtil.getDisplayRotation((Display)localObject);
    int j = i;
    if (InternalSDKUtil.isDefOrientationLandscape(i, k, m))
    {
      j = i + 1;
      i = j;
      if (j > 3) {
        i = 0;
      }
      j = i;
      if (InternalSDKUtil.isTablet(this.mContext))
      {
        this.imWebView.isTablet = true;
        j = i;
      }
    }
    Log.debug("IMRE_3.7.1", "Device current rotation: " + j);
    Log.debug("IMRE_3.7.1", "Density of device: " + this.b);
    paramExpandProperties.width = ((int)(paramExpandProperties.width * this.b));
    paramExpandProperties.height = ((int)(paramExpandProperties.height * this.b));
    paramExpandProperties.x = ((int)(paramExpandProperties.x * this.b));
    paramExpandProperties.y = ((int)(paramExpandProperties.y * this.b));
    paramExpandProperties.currentX = 0;
    paramExpandProperties.currentY = 0;
    this.imWebView.publisherOrientation = ((Activity)this.imWebView.getContext()).getRequestedOrientation();
    if ((j == 0) || (j == 2))
    {
      paramExpandProperties.rotationAtExpand = "portrait";
      if ((paramExpandProperties.height <= 0) || (paramExpandProperties.width <= 0))
      {
        paramExpandProperties.height = m;
        paramExpandProperties.width = k;
        paramExpandProperties.zeroWidthHeight = true;
      }
      if ((j != 0) && (j != 2)) {
        break label742;
      }
      paramExpandProperties.portraitWidthRequested = paramExpandProperties.width;
    }
    for (paramExpandProperties.portraitHeightRequested = paramExpandProperties.height;; paramExpandProperties.portraitHeightRequested = paramExpandProperties.width)
    {
      Log.debug("IMRE_3.7.1", "Device Width: " + k + " Device height: " + m);
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
        Log.debug("IMRE_3.7.1", "topStuff: " + paramExpandProperties.topStuff + " ,bottomStuff: " + paramExpandProperties.bottomStuff);
      }
      Log.debug("IMRE_3.7.1", "loc 0: " + localObject[0] + " loc 1: " + localObject[1]);
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
      Log.debug("IMRE_3.7.1", "final expanded width after density : " + paramExpandProperties.width + "final expanded height after density " + paramExpandProperties.height + "portrait width requested :" + paramExpandProperties.portraitWidthRequested + "portrait height requested :" + paramExpandProperties.portraitHeightRequested);
      return paramExpandProperties;
      paramExpandProperties.rotationAtExpand = "landscape";
      break;
      label742:
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
  
  private void a(JSController.ResizeProperties paramResizeProperties1, JSController.ResizeProperties paramResizeProperties2)
  {
    paramResizeProperties1.width = paramResizeProperties2.width;
    paramResizeProperties1.height = paramResizeProperties2.height;
    paramResizeProperties1.allowOffscreen = paramResizeProperties2.allowOffscreen;
    paramResizeProperties1.customClosePosition = paramResizeProperties2.customClosePosition;
    paramResizeProperties1.offsetX = paramResizeProperties2.offsetX;
    paramResizeProperties1.offsetY = paramResizeProperties2.offsetY;
  }
  
  @JavascriptInterface
  public void acceptAction(String paramString)
  {
    this.imWebView.acceptAction(paramString);
  }
  
  @JavascriptInterface
  public void close()
  {
    Log.debug("IMRE_3.7.1", "JSDisplayController-> close");
    if (this.imWebView.mOriginalWebviewForExpandUrl != null) {
      this.imWebView.mOriginalWebviewForExpandUrl.close();
    }
    this.imWebView.close();
  }
  
  @JavascriptInterface
  public void expand(String paramString)
  {
    boolean bool = false;
    Log.debug("IMRE_3.7.1", "JSDisplayController-> expand: url: " + paramString);
    try
    {
      if ((this.imWebView.getStateVariable() == IMWebView.ViewState.EXPANDED) || (this.imWebView.getStateVariable() == IMWebView.ViewState.EXPANDING))
      {
        Log.debug("IMRE_3.7.1", "JSDisplayController-> Already expanded state");
        return;
      }
      if (this.imWebView.getStateVariable() == IMWebView.ViewState.HIDDEN)
      {
        Log.debug("IMRE_3.7.1", "JSDisplayController-> Expand cannot be called in hidden state. Doing nothing.");
        return;
      }
    }
    catch (Exception paramString)
    {
      Log.debug("IMRE_3.7.1", "Exception while expanding the ad. ", paramString);
      return;
    }
    this.imWebView.mExpandController.useLockOrient = false;
    if ((this.imWebView.getStateVariable() != IMWebView.ViewState.DEFAULT) && (this.imWebView.getStateVariable() != IMWebView.ViewState.RESIZED) && (this.imWebView.getStateVariable() != IMWebView.ViewState.RESIZING))
    {
      this.imWebView.raiseError("Current state is not default", "expand");
      return;
    }
    if ((this.imWebView.getStateVariable() == IMWebView.ViewState.DEFAULT) && (this.imWebView.mIsInterstitialAd))
    {
      this.imWebView.raiseError("Expand cannot be called on interstitial ad", "expand");
      return;
    }
    a(this.temporaryexpProps, this.expProps);
    Object localObject = this.temporaryexpProps;
    this.temporaryexpProps.height = 0;
    ((JSController.ExpandProperties)localObject).width = 0;
    Log.debug("IMRE_3.7.1", "JSDisplayController-> At the time of expand the properties are: Expandable width: " + this.temporaryexpProps.width + " Expandable height: " + this.temporaryexpProps.height + " Expandable orientation: " + this.temporaryexpProps.orientation + " Expandable lock orientation: " + this.temporaryexpProps.lockOrientation + " Expandable Modality: " + this.temporaryexpProps.isModal + " Expandable Use custom close " + this.temporaryexpProps.useCustomClose);
    this.expProps = a(this.expProps);
    if (this.c != null)
    {
      localObject = this.imWebView;
      if (!this.c.allowOrientationChange) {
        bool = true;
      }
      ((IMWebView)localObject).lockExpandOrientation(bool, this.c.forceOrientation);
    }
    for (;;)
    {
      this.imWebView.expand(paramString, a(this.temporaryexpProps));
      return;
      this.imWebView.lockExpandOrientation(this.temporaryexpProps.lockOrientation, this.temporaryexpProps.orientation);
    }
  }
  
  @JavascriptInterface
  public String getExpandProperties()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("width", this.expProps.width);
      localJSONObject.put("height", this.expProps.height);
      localJSONObject.put("isModal", this.expProps.isModal);
      localJSONObject.put("useCustomClose", this.expProps.useCustomClose);
      localJSONObject.put("lockOrientation", this.expProps.lockOrientation);
      localJSONObject.put("orientation", this.expProps.orientation);
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Log.debug("IMRE_3.7.1", "Failed to get screen size");
      }
    }
  }
  
  @JavascriptInterface
  public String getOrientation()
  {
    try
    {
      String str = this.imWebView.getCurrentRotation(this.imWebView.getIntegerCurrentRotation());
      Log.debug("IMRE_3.7.1", "JSDisplayController-> getOrientation: " + str);
      return str;
    }
    catch (Exception localException)
    {
      Log.debug("IMRE_3.7.1", "Error getOrientation: " + "-1", localException);
    }
    return "-1";
  }
  
  @JavascriptInterface
  public String getOrientationProperties()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("allowOrientationChange", this.c.allowOrientationChange);
      localJSONObject.put("orientation", this.c.forceOrientation);
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Log.debug("IMRE_3.7.1", "Failed to get screen size");
      }
    }
  }
  
  @JavascriptInterface
  public String getPlacementType()
  {
    Log.debug("IMRE_3.7.1", "JSDisplayController-> getPlacementType");
    return this.imWebView.getPlacementType();
  }
  
  @JavascriptInterface
  public String getResizeProperties()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("width", this.d.width);
      localJSONObject.put("height", this.d.height);
      localJSONObject.put("offsetX", this.d.offsetX);
      localJSONObject.put("offsetY", this.d.offsetY);
      localJSONObject.put("customClosePosition", this.d.customClosePosition);
      localJSONObject.put("allowOffscreen", this.d.allowOffscreen);
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Log.debug("IMRE_3.7.1", "Failed to get screen size");
      }
    }
  }
  
  @JavascriptInterface
  public String getState()
  {
    Log.debug("IMRE_3.7.1", "JSDisplayController-> getState");
    return this.imWebView.getState();
  }
  
  @JavascriptInterface
  public boolean isViewable()
  {
    Log.debug("IMRE_3.7.1", "JSDisplayController-> isViewable");
    return this.imWebView.isViewable();
  }
  
  @JavascriptInterface
  public void onOrientationChange()
  {
    this.imWebView.onOrientationEventChange();
  }
  
  @JavascriptInterface
  public void open(String paramString)
  {
    Log.debug("IMRE_3.7.1", "JSDisplayController-> open: url: " + paramString);
    this.imWebView.openURL(paramString);
  }
  
  @JavascriptInterface
  public void rejectAction(String paramString)
  {
    this.imWebView.rejectAction(paramString);
  }
  
  public void reset()
  {
    if (this.expProps != null) {
      this.expProps.reinitializeExpandProperties();
    }
    if (this.d != null) {
      this.d.initializeResizeProperties();
    }
  }
  
  @JavascriptInterface
  public void resize()
  {
    Log.debug("IMRE_3.7.1", "JSDisplayController-> resize");
    try
    {
      if (this.imWebView.getStateVariable() == IMWebView.ViewState.RESIZING)
      {
        Log.debug("IMRE_3.7.1", "JSDisplayController-> Already resize state");
        return;
      }
      if (this.imWebView.getStateVariable() == IMWebView.ViewState.HIDDEN)
      {
        Log.debug("IMRE_3.7.1", "JSDisplayController-> Resize cannot be called in hidden state. Doing nothing.");
        return;
      }
    }
    catch (Exception localException)
    {
      Log.debug("IMRE_3.7.1", "Exception while expanding the ad. ", localException);
      return;
    }
    if ((this.imWebView.getStateVariable() != IMWebView.ViewState.DEFAULT) && (this.imWebView.getStateVariable() != IMWebView.ViewState.RESIZED))
    {
      this.imWebView.raiseError("Current state is neither default nor resized", "resize");
      return;
    }
    if (this.imWebView.mIsInterstitialAd)
    {
      this.imWebView.raiseError("Resize cannot be called on interstitial ad", "resize");
      return;
    }
    JSController.ResizeProperties localResizeProperties = new JSController.ResizeProperties();
    a(localResizeProperties, this.d);
    localResizeProperties.width = ((int)(localResizeProperties.width * this.imWebView.getDensity()));
    localResizeProperties.height = ((int)(localResizeProperties.height * this.imWebView.getDensity()));
    localResizeProperties.offsetX = ((int)(localResizeProperties.offsetX * this.imWebView.getDensity()));
    localResizeProperties.offsetY = ((int)(localResizeProperties.offsetY * this.imWebView.getDensity()));
    Log.debug("IMRE_3.7.1", "JSDisplayController-> At the time of resize the properties are: Resize width: " + localResizeProperties.width + " Resize height: " + localResizeProperties.height + " Resize offsetX: " + localResizeProperties.offsetX + " Resize offsetY: " + localResizeProperties.offsetY + " customClosePosition: " + localResizeProperties.customClosePosition + " allowOffscreen: " + localResizeProperties.allowOffscreen);
    this.imWebView.resize(localResizeProperties);
  }
  
  @JavascriptInterface
  public void setExpandProperties(String paramString)
  {
    try
    {
      this.expProps = ((JSController.ExpandProperties)getFromJSON(new JSONObject(paramString), JSController.ExpandProperties.class));
      this.expProps.isModal = true;
      Log.debug("IMRE_3.7.1", "JSDisplayController-> ExpandProperties is set: Expandable Width: " + this.expProps.width + " Expandable height: " + this.expProps.height + " Expandable orientation: " + this.expProps.orientation + " Expandable lock orientation: " + this.expProps.lockOrientation + " Expandable Modality: " + this.expProps.isModal + " Expandable Use Custom close: " + this.expProps.useCustomClose);
      this.imWebView.setCustomClose(this.expProps.useCustomClose);
      if (this.d == null) {
        this.imWebView.setOrientationPropertiesForInterstitial(this.expProps.lockOrientation, this.expProps.orientation);
      }
      return;
    }
    catch (Exception paramString)
    {
      Log.debug("IMRE_3.7.1", "Exception while setting the expand properties " + paramString);
    }
  }
  
  @JavascriptInterface
  public void setOrientationProperties(String paramString)
  {
    try
    {
      this.c = ((JSController.OrientationProperties)getFromJSON(new JSONObject(paramString), JSController.OrientationProperties.class));
      Log.debug("IMRE_3.7.1", "JSDisplayController-> OrientationProperties is set: Expandable orientation: " + this.expProps.orientation + " Expandable lock orientation: " + this.expProps.lockOrientation);
      paramString = this.imWebView;
      if (!this.c.allowOrientationChange) {}
      for (boolean bool = true;; bool = false)
      {
        paramString.setOrientationPropertiesForInterstitial(bool, this.c.forceOrientation);
        return;
      }
      return;
    }
    catch (Exception paramString)
    {
      Log.debug("IMRE_3.7.1", "Exception while setting the expand properties " + paramString);
    }
  }
  
  @JavascriptInterface
  public void setResizeProperties(String paramString)
  {
    try
    {
      this.d = ((JSController.ResizeProperties)getFromJSON(new JSONObject(paramString), JSController.ResizeProperties.class));
      Log.debug("IMRE_3.7.1", "JSDisplayController-> ResizeProperties is set: Resize Width: " + this.d.width + " Resize height: " + this.d.height + " Resize offsetX: " + this.d.offsetX + " Resize offsetY: " + this.d.offsetY + " customClosePosition: " + this.d.customClosePosition + " allowOffscreen: " + this.d.allowOffscreen);
      return;
    }
    catch (Exception paramString)
    {
      Log.debug("IMRE_3.7.1", "Exception while setting the expand properties " + paramString);
    }
  }
  
  public void stopAllListeners() {}
  
  @JavascriptInterface
  public void useCustomClose(boolean paramBoolean)
  {
    Log.debug("IMRE_3.7.1", "JSDisplayController-> useCustomClose" + paramBoolean);
    this.imWebView.setCustomClose(paramBoolean);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/inmobi/re/controller/JSDisplayController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */