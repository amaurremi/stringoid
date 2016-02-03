package com.skplanet.tad.mraid.controller;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import com.skplanet.tad.common.a;
import com.skplanet.tad.mraid.view.MraidView;
import com.skplanet.tad.mraid.view.MraidView.a;
import org.json.JSONObject;

public class MraidDisplayController
  extends MraidController
{
  private WindowManager c;
  private float d;
  private MraidController.Dimensions e;
  private boolean f = false;
  
  public MraidDisplayController(MraidView paramMraidView, Context paramContext)
  {
    super(paramMraidView, paramContext);
    if (paramContext == null)
    {
      a.d("MraidDisplayController constructor context is null");
      return;
    }
    paramMraidView = new DisplayMetrics();
    this.c = ((WindowManager)paramContext.getSystemService("window"));
    this.c.getDefaultDisplay().getMetrics(paramMraidView);
    this.d = paramMraidView.density;
  }
  
  public void close()
  {
    a.a("close", "");
    if (this.a != null) {
      this.a.j();
    }
  }
  
  public void expand(String paramString1, String paramString2, String paramString3)
  {
    a.a("expand", "url : " + paramString1 + ", expandProperties : " + paramString2 + ", orientationProperties : " + paramString3);
    if ((this.a.i() == MraidView.a.a) || (this.a.i() == MraidView.a.b)) {}
    try
    {
      paramString2 = (MraidController.ExpandProperties)a(new JSONObject(paramString2), MraidController.ExpandProperties.class);
      paramString3 = (MraidController.OrientationProperties)a(new JSONObject(paramString3), MraidController.OrientationProperties.class);
      this.a.a(paramString1, paramString2, paramString3);
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public String getCurrentPosition()
  {
    Object localObject = new int[2];
    if (this.a == null)
    {
      a.d("MraidDisplayControl.getCurrnetPosition, mMraidView is null");
      return "{ 'x' : 0, 'y' : 0 }";
    }
    this.a.getLocationInWindow((int[])localObject);
    FrameLayout localFrameLayout = (FrameLayout)this.a.getRootView().findViewById(16908290);
    if (localFrameLayout == null)
    {
      a.d("MraidDisplayControl.getCurrnetPosition, contentView is null");
      return "{ 'x' : 0, 'y' : 0 }";
    }
    int i = localFrameLayout.getLeft();
    int j = localFrameLayout.getTop();
    i = (int)((localObject[0] - i) / this.d);
    j = (int)((localObject[1] - j) / this.d);
    int k = (int)(this.a.getWidth() / this.d);
    int m = (int)(this.a.getHeight() / this.d);
    localObject = "{ 'x' : " + i + ", 'y' : " + j + ", 'width' : " + k + ", 'height' : " + m + "}";
    a.a("getCurrentPosition", (String)localObject);
    return (String)localObject;
  }
  
  public String getDefaultPosition()
  {
    if (this.e != null) {}
    for (String str = "{ 'x' : " + this.e.x + ", 'y' : " + this.e.y + ", 'width' : " + this.e.width + ", 'height' : " + this.e.height + "}";; str = getCurrentPosition())
    {
      a.a("getDefaultPosition", str);
      return str;
    }
  }
  
  public String getExpandProperties()
  {
    return "{ 'width' : " + 320 + ", 'height' : " + 480 + ", 'useCustomClose' : " + this.f + ", 'isModal' : true }";
  }
  
  public String getMaxSize()
  {
    try
    {
      Object localObject = new Rect();
      Window localWindow = ((Activity)this.a.getContext()).getWindow();
      localWindow.getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
      int i = localWindow.findViewById(16908290).getTop();
      int j = ((Rect)localObject).bottom;
      int k = ((Rect)localObject).right;
      int m = ((Rect)localObject).left;
      localObject = "{ 'width' : " + (int)((k - m) / this.d) + ", 'height' : " + (int)((j - i) / this.d) + "}";
      a.a("getMaxSize", "ret : " + (String)localObject);
      return (String)localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        a.d(localException.toString());
        String str = "{ 'width' : 0, 'height' : 0 }";
      }
    }
  }
  
  public String getOrientationProperties()
  {
    return "{ 'allowOrientationChange' : true, 'forceOrientation' : 'none' }";
  }
  
  public String getPlacementType()
  {
    String str2 = "inline";
    String str1 = str2;
    if (this.a != null)
    {
      str1 = str2;
      if (this.a.b()) {
        str1 = "interstitial";
      }
    }
    a.a("getPlacementType", "ret : " + str1);
    return str1;
  }
  
  public String getResizeProperties()
  {
    return "{ 'width' : 0, 'height' : 0, 'customClosePosition' : \"top-right\", 'offsetX' : 0, 'offsetY' : 0, 'allowOffscreen' : true }";
  }
  
  public String getScreenSize()
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    this.c.getDefaultDisplay().getMetrics(localDisplayMetrics);
    int i = (int)(localDisplayMetrics.widthPixels / localDisplayMetrics.density);
    int j = (int)(localDisplayMetrics.heightPixels / localDisplayMetrics.density);
    a.a("getScreenSize", "ret { width : " + i + ", height : " + j + "}");
    return "{ 'width' : " + i + ", 'height' : " + j + "}";
  }
  
  public boolean getUseCustomClose()
  {
    return this.f;
  }
  
  public boolean isViewable()
  {
    boolean bool = false;
    if (this.a != null) {
      bool = this.a.isShown();
    }
    a.a("getVisible", "ret : " + bool);
    return bool;
  }
  
  public void open(String paramString)
  {
    a.a("open", "url : " + paramString);
    if (this.a != null) {
      this.a.c(paramString);
    }
  }
  
  public void playVideo(String paramString)
  {
    a.a("playVideo", "url : " + paramString);
    if (!URLUtil.isValidUrl(paramString)) {
      if (this.a != null) {
        this.a.a("Invalid url", "playVideo");
      }
    }
    while (this.a == null) {
      return;
    }
    this.a.a(paramString, true, true, true, false, "fullscreen", "normal");
  }
  
  public void resize(String paramString)
  {
    a.a("resize", "properties : " + paramString);
    try
    {
      paramString = (MraidController.ResizeProperties)a(new JSONObject(paramString), MraidController.ResizeProperties.class);
      this.a.a(paramString);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void setDefaultPosition(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.e == null)
    {
      this.e = new MraidController.Dimensions();
      this.e.x = paramInt1;
      this.e.y = paramInt2;
      this.e.width = paramInt3;
      this.e.height = paramInt4;
      a.a("setDefaultPosition", "x:" + paramInt1 + "y:" + paramInt2 + "width" + paramInt3 + "height" + paramInt4);
      a.c("x : " + this.e.x);
      a.c("y : " + this.e.y);
      a.c("w : " + this.e.width);
      a.c("h : " + this.e.height);
    }
  }
  
  public void setOrientationProperties(String paramString)
  {
    a.a("setOrientationProperties", "properties : " + paramString);
    try
    {
      if ((this.a.i() == MraidView.a.c) || (this.a.b()))
      {
        paramString = (MraidController.OrientationProperties)a(new JSONObject(paramString), MraidController.OrientationProperties.class);
        this.a.setOrientation(paramString);
      }
      return;
    }
    catch (Exception paramString)
    {
      a.d(paramString.toString());
    }
  }
  
  public void stopAllListeners() {}
  
  public void useCustomClose(boolean paramBoolean)
  {
    a.a("useCustomClose", "flag : " + paramBoolean);
    this.f = paramBoolean;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/skplanet/tad/mraid/controller/MraidDisplayController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */