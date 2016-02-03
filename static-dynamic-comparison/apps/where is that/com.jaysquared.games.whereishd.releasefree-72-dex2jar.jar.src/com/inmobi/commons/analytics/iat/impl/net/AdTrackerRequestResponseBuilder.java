package com.inmobi.commons.analytics.iat.impl.net;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import com.inmobi.commons.InMobi;
import com.inmobi.commons.analytics.iat.impl.AdTrackerConstants.StatusCode;
import com.inmobi.commons.analytics.iat.impl.AdTrackerUtils;
import com.inmobi.commons.analytics.iat.impl.Goal;
import com.inmobi.commons.analytics.iat.impl.config.AdTrackerConfigParams;
import com.inmobi.commons.analytics.iat.impl.config.AdTrackerEventType;
import com.inmobi.commons.analytics.iat.impl.config.AdTrackerInitializer;
import com.inmobi.commons.internal.FileOperations;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.uid.UID;
import com.inmobi.commons.uid.UIDHelper;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class AdTrackerRequestResponseBuilder
{
  private static String a = null;
  private static long b = 0L;
  
  protected static String formHTTPRequest(String paramString1, String paramString2, int paramInt, boolean paramBoolean, String paramString3)
  {
    LinkedList localLinkedList = new LinkedList();
    String str = FileOperations.getPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "referrer");
    if ((paramString1 != null) && (!paramString1.trim().equals(""))) {
      localLinkedList.add(new BasicNameValuePair("appId", paramString1));
    }
    paramString1 = Integer.toString(new Random().nextInt());
    localLinkedList.add(new BasicNameValuePair("u-id-map", AdTrackerInitializer.getConfigParams().getUID().getUidMap(1, paramString1, null)));
    localLinkedList.add(new BasicNameValuePair("u-id-key", paramString1));
    localLinkedList.add(new BasicNameValuePair("u-key-ver", UIDHelper.getRSAKeyVersion()));
    if ((paramString2 != null) && (!paramString2.trim().equals(""))) {
      localLinkedList.add(new BasicNameValuePair("goalName", paramString2));
    }
    if (paramBoolean) {
      localLinkedList.add(new BasicNameValuePair("lp", "1"));
    }
    for (;;)
    {
      localLinkedList.add(new BasicNameValuePair("src", "and"));
      if (paramInt > 0) {
        localLinkedList.add(new BasicNameValuePair("goalCount", Integer.toString(paramInt)));
      }
      localLinkedList.add(new BasicNameValuePair("sdkVer", InMobi.getVersion()));
      localLinkedList.add(new BasicNameValuePair("sdkRelVer", InMobi.getVersion()));
      localLinkedList.add(new BasicNameValuePair("osV", String.valueOf(Build.VERSION.SDK_INT)));
      paramString2 = FileOperations.getPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "rlc");
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "0";
      }
      localLinkedList.add(new BasicNameValuePair("rlc", paramString1));
      try
      {
        paramString1 = InternalSDKUtil.getContext().getPackageManager().getPackageInfo(InternalSDKUtil.getContext().getPackageName(), 0).versionName;
        if ((paramString1 != null) && (!paramString1.trim().equals(""))) {
          localLinkedList.add(new BasicNameValuePair("appVer", paramString1));
        }
        if ((paramString3 != null) && (!paramString3.trim().equals(""))) {
          localLinkedList.add(new BasicNameValuePair("iat_ids", paramString3));
        }
        if (str != null)
        {
          paramInt = FileOperations.getIntPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "rfs");
          long l1 = FileOperations.getLongPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "t1");
          long l2 = FileOperations.getLongPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "t2");
          localLinkedList.add(new BasicNameValuePair("rfs", Integer.toString(paramInt)));
          localLinkedList.add(new BasicNameValuePair("rd", Long.toString(l2 - l1)));
        }
        if (1 == AdTrackerNetworkInterface.isUnstableNetwork()) {
          localLinkedList.add(new BasicNameValuePair("nus", Integer.toString(AdTrackerNetworkInterface.isUnstableNetwork())));
        }
        localLinkedList.add(new BasicNameValuePair("timeStamp", Long.toString(System.currentTimeMillis())));
        return URLEncodedUtils.format(localLinkedList, "utf-8");
        localLinkedList.add(new BasicNameValuePair("lp", "0"));
      }
      catch (PackageManager.NameNotFoundException paramString1)
      {
        for (;;)
        {
          Log.internal("[InMobi]-[AdTracker]-4.1.1", "Cant get appversion", paramString1);
          paramString1 = null;
        }
      }
    }
  }
  
  public static String getWebViewRequestParam()
  {
    return a;
  }
  
  public static void saveWebviewRequestParam(String paramString, Goal paramGoal)
  {
    a = formHTTPRequest(paramString, paramGoal.getGoalName(), paramGoal.getGoalCount(), paramGoal.isDuplicateGoal(), null);
  }
  
  public static AdTrackerConstants.StatusCode sendHTTPRequest(String paramString1, Goal paramGoal, String paramString2)
  {
    localObject1 = AdTrackerConstants.StatusCode.APP_ANALYTICS_UPLOAD_FAILURE;
    for (;;)
    {
      int i;
      Object localObject2;
      try
      {
        b = System.currentTimeMillis();
        DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient();
        String str = FileOperations.getPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "referrer");
        paramString2 = formHTTPRequest(paramString1, paramGoal.getGoalName(), paramGoal.getGoalCount(), paramGoal.isDuplicateGoal(), paramString2);
        i = AdTrackerInitializer.getConfigParams().getConnectionTimeout();
        localObject2 = AdTrackerNetworkInterface.a() + paramString2;
        paramString2 = (String)localObject2;
        if (str != null) {
          paramString2 = (String)localObject2 + "&referrer=" + str;
        }
        Log.internal("[InMobi]-[AdTracker]-4.1.1", paramString2);
        paramString2 = new HttpGet(paramString2);
        localObject2 = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout((HttpParams)localObject2, i);
        HttpConnectionParams.setSoTimeout((HttpParams)localObject2, i);
        localDefaultHttpClient.setParams((HttpParams)localObject2);
        paramString2 = localDefaultHttpClient.execute(paramString2);
        if (paramString2.getStatusLine().getStatusCode() == 200)
        {
          paramString2 = EntityUtils.toString(paramString2.getEntity());
          Log.internal("[InMobi]-[AdTracker]-4.1.1", "RESPONSE: " + paramString2);
          paramString2 = new JSONObject(paramString2);
          localObject2 = paramString2.getString("errmsg");
          i = paramString2.getInt("errcode");
          if (6000 == i)
          {
            long l1 = System.currentTimeMillis();
            long l2 = b;
            AdTrackerUtils.reportMetric(AdTrackerEventType.GOAL_SUCCESS, paramGoal, 1, l1 - l2, 0, null);
            paramString2 = AdTrackerConstants.StatusCode.APP_ANALYTICS_UPLOAD_SUCCESS;
            localObject1 = paramString2;
            if (6001 != i) {}
          }
        }
      }
      catch (Exception paramString1) {}
      try
      {
        Log.debug("[InMobi]-[AdTracker]-4.1.1", "Error uploading ping " + (String)localObject2 + "\nReloading webview");
        FileOperations.setPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "iat_ids", null);
        if (AdTrackerNetworkInterface.reportUsingWebview(paramString1, paramGoal))
        {
          localObject1 = AdTrackerConstants.StatusCode.APP_ANALYTICS_UPLOAD_SUCCESS;
          return (AdTrackerConstants.StatusCode)localObject1;
          AdTrackerUtils.reportMetric(AdTrackerEventType.GOAL_FAILURE, paramGoal, 1, 0L, i, null);
          paramString2 = (String)localObject1;
        }
        else
        {
          paramString1 = AdTrackerConstants.StatusCode.APP_ANALYTICS_UPLOAD_FAILURE;
          return paramString1;
        }
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          localObject1 = paramString2;
        }
      }
    }
    AdTrackerUtils.reportMetric(AdTrackerEventType.GOAL_FAILURE, paramGoal, 1, 0L, paramString2.getStatusLine().getStatusCode(), null);
    for (;;)
    {
      return (AdTrackerConstants.StatusCode)localObject1;
      AdTrackerUtils.reportMetric(AdTrackerEventType.GOAL_FAILURE, paramGoal, 1, 0L, 424, paramString1.getMessage());
      Log.internal("[InMobi]-[AdTracker]-4.1.1", "Error uploading Goal Ping", paramString1);
    }
  }
  
  public static boolean serverReachable(String paramString)
  {
    try
    {
      int i = new DefaultHttpClient().execute(new HttpGet(paramString)).getStatusLine().getStatusCode();
      if (i == 200) {
        return true;
      }
    }
    catch (Exception paramString)
    {
      Log.debug("[InMobi]-[AdTracker]-4.1.1", "Server not reachable..Logging events");
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/commons/analytics/iat/impl/net/AdTrackerRequestResponseBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */