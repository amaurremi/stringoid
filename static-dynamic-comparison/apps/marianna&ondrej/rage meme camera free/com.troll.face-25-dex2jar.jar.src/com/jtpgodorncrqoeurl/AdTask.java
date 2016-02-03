package com.jtpgodorncrqoeurl;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import java.util.List;
import java.util.Random;
import org.json.JSONObject;

public class AdTask
  extends AsyncTask
{
  private AdController a;
  private Activity b;
  private Context c;
  private String d;
  private String e;
  private List f;
  private JSONObject g;
  private boolean h = false;
  private String i;
  
  public AdTask(AdController paramAdController, Context paramContext, String paramString1, String paramString2)
  {
    if ((paramContext instanceof Activity)) {
      this.b = ((Activity)paramContext);
    }
    for (;;)
    {
      this.a = paramAdController;
      this.d = paramString1;
      this.i = paramString2;
      return;
      this.c = paramContext;
    }
  }
  
  private String a()
  {
    try
    {
      int j = new Random().nextInt(350) + 250;
      AdLog.d("LBAdController", "Going to halt for " + j + "ms");
      Thread.sleep(j);
      if (this.b != null) {}
      for (Object localObject = this.b;; localObject = this.c)
      {
        if (((ConnectivityManager)((Context)localObject).getSystemService("connectivity")).getActiveNetworkInfo() != null)
        {
          localObject = new AdRequest((Context)localObject, this.d, this.i);
          ((AdRequest)localObject).setSubId(this.e);
          ((AdRequest)localObject).setTokens(this.f);
          ((AdRequest)localObject).setUseLocation(this.h);
          this.g = ((AdRequest)localObject).makeLBRequest();
        }
        return null;
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  protected void onCancelled()
  {
    AdLog.d("LBAdController", "AdTask cancelled");
    super.onCancelled();
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
  }
  
  public void setSubId(String paramString)
  {
    this.e = paramString;
  }
  
  public void setTokens(List paramList)
  {
    this.f = paramList;
  }
  
  public void setUseLocation(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/jtpgodorncrqoeurl/AdTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */