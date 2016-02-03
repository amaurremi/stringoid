package com.skplanet.tad.mraid.controller;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.skplanet.tad.common.a;
import com.skplanet.tad.mraid.view.MraidView;
import org.json.JSONObject;

public class TadController
  extends MraidController
{
  public TadController(MraidView paramMraidView, Context paramContext)
  {
    super(paramMraidView, paramContext);
  }
  
  private boolean a(String paramString)
  {
    return (paramString == null) || (paramString.equals("")) || (paramString.equals("undefined")) || (paramString.equals("null"));
  }
  
  private void b(String paramString)
  {
    try
    {
      a.c("TadController.launchmarket, url : " + paramString);
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.addFlags(268435456);
      localIntent.setData(Uri.parse(paramString));
      this.b.startActivity(localIntent);
      return;
    }
    catch (Exception paramString)
    {
      a.d("TadController.launchmarcket, Exception");
    }
  }
  
  private void c(String paramString)
  {
    try
    {
      paramString = (MraidController.DownloadInfoProperties)a(new JSONObject(paramString), MraidController.DownloadInfoProperties.class);
      if (paramString == null)
      {
        a.d("TadController.downloadApplicationCheckAndRun, pDownloadInfo is null");
        return;
      }
      if ((!a(paramString.tstore)) && (d("com.skt.skaf.A000Z00040")))
      {
        a.c("TadController.downloadApplicationCheckAndRun, run Tstore landing after checking installed");
        b(paramString.tstore);
        return;
      }
    }
    catch (Exception paramString)
    {
      a.d("TadController.downloadApplicationCheckAndRun, exception" + paramString.toString());
      return;
    }
    if (!a(paramString.market))
    {
      a.c("TadController.downloadApplicationCheckAndRun, run market landing after checking installed");
      b(paramString.market);
      return;
    }
    if (!a(paramString.alternative))
    {
      a.c("TadController.downloadApplicationCheckAndRun, run alternative landing");
      b(paramString.alternative);
      return;
    }
    if (!a(paramString.tstore))
    {
      a.c("TadController.downloadApplicationCheckAndRun, run tstore landing");
      b(paramString.tstore);
      return;
    }
    a.d("TadController.downloadApplicationCheckAndRun, three is no available URL");
  }
  
  private boolean d(String paramString)
  {
    if (this.b != null)
    {
      PackageManager localPackageManager = this.b.getPackageManager();
      try
      {
        localPackageManager.getApplicationInfo(paramString, 128);
        return true;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
    return false;
  }
  
  public void downloadApplication(String paramString)
  {
    c(paramString);
    if (this.a != null) {
      this.a.a("TAD.DOWNLOAD_APPLICATION");
    }
  }
  
  public void playVideo(String paramString)
  {
    if (this.a != null)
    {
      this.a.d(paramString);
      this.a.a("TAD.PLAY_VIDEO");
    }
  }
  
  public void runApplication(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = (MraidController.PackageInfoProperties)a(new JSONObject(paramString1), MraidController.PackageInfoProperties.class);
      if (!a(paramString1.android))
      {
        paramString1 = this.b.getPackageManager().getLaunchIntentForPackage(paramString1.android);
        this.b.startActivity(paramString1);
      }
      if (this.a != null) {
        this.a.a("TAD.RUN_APPLICATION");
      }
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        a.d("TadController.runApplication > exception");
        a.d(paramString1.toString());
        c(paramString2);
      }
    }
  }
  
  public void sendEventCode(int paramInt)
  {
    if (this.a != null) {
      this.a.a(paramInt);
    }
  }
  
  public void stopAllListeners() {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/skplanet/tad/mraid/controller/TadController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */