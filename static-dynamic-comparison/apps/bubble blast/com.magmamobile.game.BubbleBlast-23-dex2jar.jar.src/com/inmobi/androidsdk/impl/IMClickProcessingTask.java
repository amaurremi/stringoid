package com.inmobi.androidsdk.impl;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Message;
import android.view.MotionEvent;
import com.inmobi.androidsdk.IMBrowserActivity;
import com.inmobi.androidsdk.ai.container.IMWebView.IMWebViewListener;
import com.inmobi.androidsdk.impl.net.IMHttpRequestBuilder;
import com.inmobi.androidsdk.impl.net.IMRequestResponseManager;
import com.inmobi.commons.internal.IMLog;
import java.util.ArrayList;
import java.util.List;

public class IMClickProcessingTask
  extends AsyncTask<Void, Void, String>
{
  private final IMAdUnit a;
  private final IMUserInfo b;
  private final Context c;
  private Message d;
  private Message e;
  private Message f;
  private IMWebView.IMWebViewListener g;
  private MotionEvent h;
  
  public IMClickProcessingTask(IMAdUnit paramIMAdUnit, IMUserInfo paramIMUserInfo, Context paramContext, MotionEvent paramMotionEvent, Message paramMessage1, Message paramMessage2, Message paramMessage3, IMWebView.IMWebViewListener paramIMWebViewListener)
  {
    this.a = paramIMAdUnit;
    this.b = paramIMUserInfo;
    this.c = paramContext;
    this.d = paramMessage1;
    this.e = paramMessage2;
    this.f = paramMessage3;
    this.g = paramIMWebViewListener;
    this.h = paramMotionEvent;
  }
  
  private void a(String paramString)
  {
    if (paramString == null) {}
    label300:
    do
    {
      do
      {
        for (;;)
        {
          return;
          try
          {
            IMLog.debug("InMobiAndroidSDK_3.6.1", "Click target URL: " + paramString);
            IMLog.debug("InMobiAndroidSDK_3.6.1", "AdActionName: " + this.a.getAdActionName());
            if (this.a.getAdActionName() == IMAdUnit.AdActionNames.AdActionName_SMS)
            {
              b(paramString);
              if (this.f == null) {
                continue;
              }
              this.f.sendToTarget();
            }
          }
          catch (ActivityNotFoundException localActivityNotFoundException)
          {
            IMLog.debug("InMobiAndroidSDK_3.6.1", "Operation could not be performed : " + paramString, localActivityNotFoundException);
            return;
            if ((this.a.getAdActionName() != IMAdUnit.AdActionNames.AdActionName_Web) && (this.a.getAdActionName() != IMAdUnit.AdActionNames.AdActionName_Search)) {
              break label300;
            }
            if ((paramString.startsWith("http://")) && (!paramString.contains("play.google.com")) && (!paramString.contains("market.android.com")))
            {
              Intent localIntent1 = new Intent(this.c, IMBrowserActivity.class);
              localIntent1.putExtra("extra_url", paramString);
              localIntent1.putExtra("extra_browser_type", 101);
              localIntent1.putExtra("FIRST_INSTANCE", true);
              IMBrowserActivity.setWebViewListener(this.g);
              this.c.startActivity(localIntent1);
              if (this.e == null) {
                continue;
              }
              this.e.sendToTarget();
            }
          }
          catch (Exception localException)
          {
            IMLog.debug("InMobiAndroidSDK_3.6.1", "Error executing post click actions on URL : " + paramString, localException);
            return;
          }
        }
        localIntent2 = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
        localIntent2.addFlags(268435456);
        this.c.startActivity(localIntent2);
      } while (this.f == null);
      this.f.sendToTarget();
      return;
      Intent localIntent2 = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
      localIntent2.addFlags(268435456);
      this.c.startActivity(localIntent2);
    } while (this.f == null);
    this.f.sendToTarget();
  }
  
  private void b(String paramString)
  {
    String str1 = null;
    int i = paramString.indexOf("&Body=", 0);
    String str2 = paramString;
    if (i > 0)
    {
      str1 = paramString.substring("&Body=".length() + i);
      str2 = paramString.substring(0, i);
    }
    paramString = new Intent("android.intent.action.SENDTO", Uri.parse(str2));
    paramString.addFlags(268435456);
    paramString.putExtra("compose_mode", true);
    if (str1 != null) {
      paramString.putExtra("sms_body", IMHttpRequestBuilder.getURLDecoded(str1, "UTF-8"));
    }
    this.c.startActivity(paramString);
  }
  
  protected String doInBackground(Void... paramVarArgs)
  {
    try
    {
      Object localObject = new IMRequestResponseManager();
      paramVarArgs = new ArrayList();
      paramVarArgs.add("x-mkhoj-adactiontype");
      paramVarArgs.add(this.a.getAdActionName().toString());
      if (this.a.getAdType().equals(IMAdUnit.AdTypes.SEARCH)) {
        this.h = null;
      }
      paramVarArgs = ((IMRequestResponseManager)localObject).initiateClick(this.a.getTargetUrl(), this.b, this.h, paramVarArgs);
      IMLog.debug("InMobiAndroidSDK_3.6.1", "Encountered generic exception initiating click", localException1);
    }
    catch (Exception localException1)
    {
      try
      {
        localObject = ((IMRequestResponseManager)localObject).getNewAdActionType();
        if (localObject != null) {
          this.a.setAdActionName(IMAdUnit.adActionNamefromString((String)localObject));
        }
        return paramVarArgs;
      }
      catch (Exception localException2)
      {
        for (;;) {}
      }
      localException1 = localException1;
      paramVarArgs = null;
    }
    return paramVarArgs;
  }
  
  protected void onPostExecute(String paramString)
  {
    a(paramString);
    try
    {
      if (this.d != null) {
        this.d.sendToTarget();
      }
      return;
    }
    catch (Exception paramString) {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/inmobi/androidsdk/impl/IMClickProcessingTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */