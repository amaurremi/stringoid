package com.jtpgodorncrqoeurl;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.webkit.JavascriptInterface;

public class AdJSInterface
{
  private Context a;
  private AdController b;
  private AdListener c;
  
  public AdJSInterface(Context paramContext, AdController paramAdController, AdListener paramAdListener)
  {
    this.a = paramContext;
    this.b = paramAdController;
    this.c = paramAdListener;
  }
  
  @JavascriptInterface
  private void a()
  {
    SharedPreferences.Editor localEditor = this.a.getSharedPreferences("Preference", 0).edit();
    localEditor.putBoolean("AD_CLOSEBUTTON_CLICKED", true);
    localEditor.commit();
    ((Activity)this.a).runOnUiThread(new J(this));
  }
  
  @JavascriptInterface
  public void close()
  {
    try
    {
      a();
      return;
    }
    catch (Exception localException) {}
  }
  
  @JavascriptInterface
  public void complete()
  {
    try
    {
      this.b.setCompleted(true);
      a();
      this.b.triggerAdCompleted();
      return;
    }
    catch (Exception localException) {}
  }
  
  @JavascriptInterface
  public void processAudio(String paramString1, String paramString2)
  {
    AdLog.d("LBAdController", "Going to process Audio URLs - " + paramString1 + ", " + paramString2);
    this.b.checkForAudioAd(paramString1, paramString2);
  }
  
  @JavascriptInterface
  public void processHTML(String paramString1, String paramString2, String paramString3)
  {
    ((Activity)this.a).runOnUiThread(new I(this, paramString1, paramString2, paramString3));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/jtpgodorncrqoeurl/AdJSInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */