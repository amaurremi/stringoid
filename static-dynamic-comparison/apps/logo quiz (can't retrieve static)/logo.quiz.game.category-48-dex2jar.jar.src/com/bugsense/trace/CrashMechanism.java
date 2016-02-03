package com.bugsense.trace;

import android.util.Log;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.json.JSONException;
import org.json.JSONObject;

public final class CrashMechanism
{
  protected static final int CRASH = 1;
  public static final int HANDLEDEXCEPTION = 0;
  private static final int MAX_CRASHES = 5;
  private static final int MAX_EXCEPTIONS = 8;
  static final String fixfilename = "fixnotification";
  private static volatile CrashMechanism instance;
  
  protected static String createJSONFromCrash(String paramString1, int paramInt1, int paramInt2, int paramInt3, String[] paramArrayOfString, String paramString2, Map<String, String> paramMap1, Map<String, String> paramMap2, int paramInt4, long paramLong, Map<String, String> paramMap3)
    throws Exception
  {
    JSONObject localJSONObject1 = new JSONObject();
    Object localObject = new JSONObject();
    JSONObject localJSONObject6 = new JSONObject();
    JSONObject localJSONObject5 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    JSONObject localJSONObject3 = new JSONObject();
    JSONObject localJSONObject4 = new JSONObject();
    if (G.userIdentifier != null) {
      ((JSONObject)localObject).put("user_id", G.userIdentifier);
    }
    localJSONObject1.put("request", localObject);
    BufferedReader localBufferedReader = new BufferedReader(new StringReader(paramString1));
    if (paramString2 == null) {
      localJSONObject6.put("occured_at", localBufferedReader.readLine());
    }
    for (;;)
    {
      localJSONObject6.put("message", localBufferedReader.readLine());
      paramString2 = localBufferedReader.readLine();
      try
      {
        localObject = paramString2.substring(paramString2.lastIndexOf("(") + 1, paramString2.lastIndexOf(")"));
        paramString2 = (String)localObject;
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
      localJSONObject6.put("where", paramString2);
      localJSONObject6.put("handled", paramInt4);
      localJSONObject6.put("klass", getClass(paramString1));
      localJSONObject6.put("backtrace", paramString1);
      localJSONObject6.put("breadcrumbs", getBreadcrumbsLine(G.breadcrumbs));
      localJSONObject1.put("exception", localJSONObject6);
      localBufferedReader.close();
      localJSONObject2.put("uid", G.UID);
      localJSONObject2.put("phone", G.PHONE_MODEL);
      localJSONObject2.put("brand", G.PHONE_BRAND);
      localJSONObject2.put("appver", G.APP_VERSION);
      localJSONObject2.put("appname", G.APP_PACKAGE);
      localJSONObject2.put("internal_version", G.APP_VERSIONCODE);
      localJSONObject2.put("osver", G.ANDROID_VERSION);
      localJSONObject2.put("wifi_on", paramInt1);
      localJSONObject2.put("mobile_net_on", paramInt2);
      localJSONObject2.put("gps_on", paramInt3);
      localJSONObject2.put("screen:width", paramArrayOfString[0]);
      localJSONObject2.put("screen:height", paramArrayOfString[1]);
      localJSONObject2.put("screen:orientation", paramArrayOfString[2]);
      localJSONObject2.put("screen_dpi(x:y)", paramArrayOfString[3] + ":" + paramArrayOfString[4]);
      localJSONObject2.put("locale", G.LOCALE);
      localJSONObject2.put("apps_running", G.APPS_RUNNING);
      if (paramMap2 != null) {
        paramMap1.putAll(paramMap2);
      }
      if ((G.SEND_LOG) && (paramInt4 == 1)) {
        paramMap1.put("log", Utils.readLogs());
      }
      paramMap1.put("rooted", String.valueOf(G.HAS_ROOT));
      paramMap1.put("ms_from_start", String.valueOf(paramLong));
      if ((paramMap1 == null) || (paramMap1.isEmpty())) {
        break label609;
      }
      paramString1 = paramMap1.entrySet().iterator();
      while (paramString1.hasNext())
      {
        paramArrayOfString = (Map.Entry)paramString1.next();
        localJSONObject5.put((String)paramArrayOfString.getKey(), paramArrayOfString.getValue());
      }
      localJSONObject6.put("occured_at", paramString2);
    }
    localJSONObject2.put("log_data", localJSONObject5);
    label609:
    if ((paramMap3 != null) && (!paramMap3.isEmpty()))
    {
      paramString1 = paramMap3.entrySet().iterator();
      while (paramString1.hasNext())
      {
        paramArrayOfString = (Map.Entry)paramString1.next();
        localJSONObject3.put((String)paramArrayOfString.getKey(), paramArrayOfString.getValue());
      }
      localJSONObject1.put("performance", localJSONObject3);
    }
    localJSONObject1.put("application_environment", localJSONObject2);
    localJSONObject4.put("version", "3.6.1");
    localJSONObject4.put("name", "bugsense-android");
    localJSONObject1.put("client", localJSONObject4);
    return localJSONObject1.toString();
  }
  
  private static String getBreadcrumbsLine(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      String str = ((String)localIterator.next()).replaceAll("\\|", "_");
      paramArrayList = str;
      if (str.charAt(0) == '_') {
        paramArrayList = str.replaceFirst("_", "-");
      }
      localStringBuilder.append(paramArrayList);
      localStringBuilder.append("|");
    }
    try
    {
      paramArrayList = localStringBuilder.toString().substring(0, localStringBuilder.toString().length() - 1);
      return paramArrayList;
    }
    catch (Exception paramArrayList)
    {
      Log.e(G.TAG, "Error occured in breadcrumbs");
    }
    return "";
  }
  
  private static String getClass(String paramString)
  {
    String str2 = "";
    try
    {
      int i = paramString.indexOf(":");
      String str1 = str2;
      if (i != -1)
      {
        str1 = str2;
        if (i + 1 < paramString.length()) {
          str1 = paramString.substring(0, i);
        }
      }
      return str1;
    }
    catch (Exception paramString) {}
    return "";
  }
  
  protected static CrashMechanism getInstance()
  {
    if (instance == null) {
      instance = new CrashMechanism();
    }
    return instance;
  }
  
  protected static void saveCrash(final String paramString, int paramInt)
  {
    paramString = new Thread(new Runnable()
    {
      public void run()
      {
        Object localObject = "Crash_";
        if (this.val$type == 0) {
          localObject = "Exception_";
        }
        localObject = (String)localObject + String.valueOf(System.currentTimeMillis()) + "-" + Integer.toString(new Random(System.currentTimeMillis()).nextInt(99999));
        try
        {
          localObject = new BufferedWriter(new FileWriter(G.FILES_PATH + "/" + (String)localObject));
          ((BufferedWriter)localObject).write(paramString);
          ((BufferedWriter)localObject).flush();
          ((BufferedWriter)localObject).close();
          return;
        }
        catch (IOException localIOException)
        {
          do
          {
            Log.e(G.TAG, "Error saving crash data");
          } while (!BugSenseHandler.I_WANT_TO_DEBUG);
          localIOException.printStackTrace();
        }
      }
    });
    ExecutorService localExecutorService = BugSense.getExecutor();
    if ((paramString != null) && (localExecutorService != null)) {
      localExecutorService.submit(paramString);
    }
  }
  
  private static void saveFixNotification(String paramString)
  {
    paramString = new Thread(new Runnable()
    {
      public void run()
      {
        Object localObject = new File(G.FILES_PATH + "/" + "fixnotification");
        if ((localObject != null) && (((File)localObject).exists())) {
          ((File)localObject).delete();
        }
        try
        {
          localObject = new BufferedWriter(new FileWriter(G.FILES_PATH + "/" + "fixnotification"));
          ((BufferedWriter)localObject).write(this.val$line);
          ((BufferedWriter)localObject).flush();
          ((BufferedWriter)localObject).close();
          return;
        }
        catch (IOException localIOException)
        {
          do
          {
            Log.e(G.TAG, "Error saving crash data");
          } while (!BugSenseHandler.I_WANT_TO_DEBUG);
          localIOException.printStackTrace();
        }
      }
    });
    ExecutorService localExecutorService = BugSense.getExecutor();
    if ((paramString != null) && (localExecutorService != null)) {
      localExecutorService.submit(paramString);
    }
  }
  
  protected static void transmitCrashASync(String paramString, final int paramInt)
  {
    paramString = new Thread(new Runnable()
    {
      public void run()
      {
        if (G.sendOnlyWiFi) {
          if (G.IS_WIFI_ON == 1) {
            if (!CrashMechanism.transmitCrashSync(this.val$jsonCrashData, paramInt)) {
              CrashMechanism.saveCrash(this.val$jsonCrashData, paramInt);
            }
          }
        }
        while (CrashMechanism.transmitCrashSync(this.val$jsonCrashData, paramInt))
        {
          return;
          CrashMechanism.saveCrash(this.val$jsonCrashData, paramInt);
          return;
        }
        CrashMechanism.saveCrash(this.val$jsonCrashData, paramInt);
      }
    });
    ExecutorService localExecutorService = BugSense.getExecutor();
    if ((paramString != null) && (localExecutorService != null)) {
      localExecutorService.submit(paramString);
    }
  }
  
  private static boolean transmitCrashSync(String paramString, int paramInt)
  {
    if (BugSenseHandler.I_WANT_TO_DEBUG) {
      Log.d(G.TAG, "Transmitting Crash, URL: " + G.URL + " APIKEY: " + G.API_KEY);
    }
    if (paramString.length() > 10)
    {
      Object localObject1 = new ArrayList();
      DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient();
      Object localObject2 = localDefaultHttpClient.getParams();
      HttpProtocolParams.setUseExpectContinue((HttpParams)localObject2, false);
      HttpConnectionParams.setConnectionTimeout((HttpParams)localObject2, 20000);
      HttpConnectionParams.setSoTimeout((HttpParams)localObject2, 20000);
      localObject2 = new HttpPost(G.URL);
      ((HttpPost)localObject2).addHeader("X-BugSense-Api-Key", G.API_KEY);
      try
      {
        ((List)localObject1).add(new BasicNameValuePair("data", paramString));
        ((HttpPost)localObject2).setEntity(new UrlEncodedFormEntity((List)localObject1, "UTF-8"));
        paramString = localDefaultHttpClient.execute((HttpUriRequest)localObject2).getEntity();
        if (paramString == null)
        {
          Log.w(G.TAG, "It seems that there is no internet connectivity");
          throw new Exception("no internet connection");
        }
      }
      catch (Exception paramString)
      {
        Log.w(G.TAG, "Transmitting crash Exception " + paramString.getMessage());
        if (BugSenseHandler.I_WANT_TO_DEBUG) {
          paramString.printStackTrace();
        }
        return false;
      }
      localObject1 = new BufferedReader(new InputStreamReader(paramString.getContent()));
      paramString = ((BufferedReader)localObject1).readLine();
      ((BufferedReader)localObject1).close();
      if (BugSenseHandler.I_WANT_TO_DEBUG) {
        Log.i(G.TAG, "Crash Response: " + paramString);
      }
      if ((paramInt == 1) && (paramString != null))
      {
        boolean bool = paramString.contains("eid");
        if (!bool) {}
      }
      try
      {
        localObject1 = new JSONObject(new JSONObject(paramString).getString("data"));
        if (localObject1 != null)
        {
          paramInt = ((JSONObject)localObject1).getInt("eid");
          if (paramInt != 0) {
            Utils.saveLastCrashID(String.valueOf(paramInt));
          }
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          if (BugSenseHandler.I_WANT_TO_DEBUG) {
            localJSONException.printStackTrace();
          }
        }
      }
      if ((paramString != null) && (paramString.contains("tickerText")) && (paramString.contains("contentTitle")) && (paramString.contains("url"))) {
        saveFixNotification(paramString);
      }
    }
    return true;
  }
  
  protected void sendSavedCrashes()
  {
    try
    {
      Thread localThread = new Thread(new Runnable()
      {
        public void run()
        {
          int k = 0;
          Object localObject2 = new File(G.FILES_PATH);
          if (!((File)localObject2).exists()) {
            ((File)localObject2).mkdir();
          }
          Object localObject1 = new FilenameFilter()
          {
            public boolean accept(File paramAnonymous2File, String paramAnonymous2String)
            {
              return paramAnonymous2String.startsWith("Crash_");
            }
          };
          FilenameFilter local2 = new FilenameFilter()
          {
            public boolean accept(File paramAnonymous2File, String paramAnonymous2String)
            {
              return paramAnonymous2String.startsWith("Exception_");
            }
          };
          localObject1 = ((File)localObject2).list((FilenameFilter)localObject1);
          localObject2 = ((File)localObject2).list(local2);
          if (BugSenseHandler.I_WANT_TO_DEBUG)
          {
            Log.d(G.TAG, "Crash List has: " + localObject1.length + " items");
            Log.d(G.TAG, "HandledEx List has: " + localObject2.length + " items");
          }
          int i = 5;
          if (5 > localObject1.length) {
            i = localObject1.length;
          }
          int j = 0;
          for (;;)
          {
            if ((j >= i) || (!CrashMechanism.transmitCrashSync(Utils.readFile(G.FILES_PATH + "/" + localObject1[j]), 1)))
            {
              if (j >= 1)
              {
                i = 0;
                label203:
                if (i >= localObject1.length) {}
              }
            }
            else {
              try
              {
                new File(G.FILES_PATH + "/" + localObject1[i]).delete();
                i += 1;
                break label203;
                j += 1;
              }
              catch (Exception localException2)
              {
                for (;;)
                {
                  Log.e(G.TAG, "Error deleting trace file: " + G.FILES_PATH + "/" + localObject1[i], localException2);
                }
              }
            }
          }
          i = 8;
          if (8 > localObject2.length) {
            i = localObject2.length;
          }
          j = 0;
          for (;;)
          {
            if ((j >= i) || (!CrashMechanism.transmitCrashSync(Utils.readFile(G.FILES_PATH + "/" + localObject2[j]), 0)))
            {
              if (j >= 1)
              {
                i = k;
                label377:
                if (i >= localObject2.length) {}
              }
            }
            else {
              try
              {
                new File(G.FILES_PATH + "/" + localObject2[i]).delete();
                i += 1;
                break label377;
                j += 1;
              }
              catch (Exception localException1)
              {
                for (;;)
                {
                  Log.e(G.TAG, "Error deleting trace file: " + G.FILES_PATH + "/" + localObject2[i], localException1);
                }
              }
            }
          }
        }
      });
      ExecutorService localExecutorService = BugSense.getExecutor();
      if ((localThread != null) && (localExecutorService != null)) {
        localExecutorService.submit(localThread);
      }
      return;
    }
    finally {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bugsense/trace/CrashMechanism.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */