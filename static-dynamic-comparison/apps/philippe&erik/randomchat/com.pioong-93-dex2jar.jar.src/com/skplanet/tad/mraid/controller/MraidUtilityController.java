package com.skplanet.tad.mraid.controller;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.webkit.URLUtil;
import android.widget.Toast;
import com.skplanet.tad.common.a;
import com.skplanet.tad.mraid.controller.util.MraidUtils;
import com.skplanet.tad.mraid.view.MraidView;
import java.io.File;
import java.io.InputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;

public class MraidUtilityController
  extends MraidController
{
  private MraidDisplayController c;
  private TadController d;
  
  public MraidUtilityController(MraidView paramMraidView, Context paramContext)
  {
    super(paramMraidView, paramContext);
    this.c = new MraidDisplayController(paramMraidView, paramContext);
    this.d = new TadController(paramMraidView, paramContext);
    if (paramMraidView != null)
    {
      paramMraidView.addJavascriptInterface(this.c, "MRAIDDisplayControllerBridge");
      paramMraidView.addJavascriptInterface(this.d, "TadController");
    }
  }
  
  private String a()
  {
    return "{ 'sms' : true, 'tel' : true, 'calendar' : true, 'storePicture' : true, 'inlinevideo' : true }";
  }
  
  public void createCalendarEvent(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    a.a("createCalendarEvent", "description : " + paramString1 + ", location : " + paramString2 + ", summary : " + paramString3 + ", start : " + paramString4 + ", end : " + paramString5);
    try
    {
      long l1 = Long.parseLong(paramString4);
      long l2 = Long.parseLong(paramString5);
      paramString4 = new Intent("android.intent.action.EDIT");
      paramString4.setType("vnd.android.cursor.item/event");
      paramString4.putExtra("beginTime", l1);
      paramString4.putExtra("endTime", l2);
      paramString4.putExtra("title", paramString3);
      paramString4.putExtra("description", paramString1);
      paramString4.putExtra("eventLocation", paramString2);
      this.b.startActivity(paramString4);
      if (this.a != null) {
        this.a.a("CREATE_CALENDAR_EVENT");
      }
      return;
    }
    catch (Exception paramString1)
    {
      for (;;) {}
    }
  }
  
  public boolean getUseCustomClose()
  {
    return this.c.getUseCustomClose();
  }
  
  public void init(float paramFloat)
  {
    if (this.c == null)
    {
      a.d("mDisplayController is null");
      return;
    }
    String str = "window.mraidview.fireChangeEvent({ 'onSupports' : " + a() + ", 'onExpandProperties' : " + this.c.getExpandProperties() + ", 'onOrientationProperties' : " + this.c.getOrientationProperties() + ", 'onResizeProperties' : " + this.c.getResizeProperties() + ", 'onState' : " + "'default'" + ", 'onReady' : null" + " })";
    this.a.b(str);
  }
  
  public void setDefaultPosition(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.c.setDefaultPosition(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void showAlert(String paramString)
  {
    a.a("showAlert", paramString);
  }
  
  public void stopAllListeners()
  {
    try
    {
      this.c.stopAllListeners();
      this.d.stopAllListeners();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void storePicture(String paramString)
  {
    String str = null;
    a.a("storePicture()", "url : " + paramString);
    if (this.a != null) {
      this.a.a("STORE_PICTURE");
    }
    try
    {
      HttpEntity localHttpEntity = MraidUtils.getHttpEntity(paramString);
      InputStream localInputStream = localHttpEntity.getContent();
      File localFile = new File(Environment.getExternalStorageDirectory().getPath() + File.separator + "TadGallery");
      localFile.mkdirs();
      Header localHeader = localHttpEntity.getContentType();
      if (localHeader != null) {
        str = localHeader.getValue();
      }
      paramString = URLUtil.guessFileName(paramString, null, str);
      MraidUtils.writeToDisk(localInputStream, new File(localFile, paramString));
      Toast.makeText(this.b, paramString + " is stored in " + localFile.getPath(), 0).show();
      try
      {
        localHttpEntity.consumeContent();
        return;
      }
      catch (Exception paramString) {}
      return;
    }
    catch (Exception paramString) {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/skplanet/tad/mraid/controller/MraidUtilityController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */