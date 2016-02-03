package com.jumptap.adtag.events;

import android.content.Context;
import android.util.Log;
import com.jumptap.adtag.db.DBManager;
import com.jumptap.adtag.utils.JtAdManager;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.TimerTask;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;

public class SendConversionUrlTask
  extends TimerTask
{
  private Context context;
  
  public SendConversionUrlTask(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private static boolean sendReportToTL(Context paramContext, JtEvent paramJtEvent)
  {
    Object localObject = paramJtEvent.getUrl();
    EventType localEventType = paramJtEvent.getEventType();
    paramJtEvent = paramJtEvent.getDate();
    boolean bool2 = false;
    Log.i("JtAd-Tracking", "sending url to Jumptap servers:" + (String)localObject);
    DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient();
    localObject = new HttpGet((String)localObject);
    ((HttpGet)localObject).setHeader("User-Agent", System.getProperty("http.agent"));
    try
    {
      int i = localDefaultHttpClient.execute((HttpUriRequest)localObject).getStatusLine().getStatusCode();
      Log.i("JtAd-Tracking", "conversion/event tracking response status code:" + i);
      if (i == 200)
      {
        if ((EventType.download.equals(localEventType)) && (paramContext != null))
        {
          JtAdManager.savePreferences(paramContext, "isFirstLaunch", "0");
          JtAdManager.removePreferences(paramContext, "installDate");
        }
      }
      else
      {
        bool1 = bool2;
        if (!EventType.download.equals(localEventType)) {
          return bool1;
        }
        bool1 = bool2;
        if (paramContext == null) {
          return bool1;
        }
        JtAdManager.savePreferences(paramContext, "isFirstLaunch", paramJtEvent);
        return false;
      }
    }
    catch (IOException paramContext)
    {
      Log.e("JtAd-Tracking", "JTAppReport.sendReportToTL:" + paramContext.toString());
      return false;
    }
    boolean bool1 = true;
    return bool1;
  }
  
  public void run()
  {
    Log.d("JtAd-Tracking", "SendConversionUrlTask woke up");
    DBManager localDBManager = DBManager.getInstance(this.context);
    Iterator localIterator = localDBManager.selectAllEvents().iterator();
    while (localIterator.hasNext())
    {
      JtEvent localJtEvent = (JtEvent)localIterator.next();
      if (sendReportToTL(this.context, localJtEvent)) {
        localDBManager.deleteEventById(localJtEvent.getId());
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/jumptap/adtag/events/SendConversionUrlTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */