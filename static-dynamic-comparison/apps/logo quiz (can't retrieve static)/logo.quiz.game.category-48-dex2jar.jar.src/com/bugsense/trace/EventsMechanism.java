package com.bugsense.trace;

import android.util.Log;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

public final class EventsMechanism
{
  private static final int MAX_BYTES = 256;
  private static final int MAX_EVENTS_SIZE = 12;
  private static volatile EventsMechanism instance;
  
  protected static String getFlatLine(String paramString)
  {
    String str1 = paramString;
    if (paramString.getBytes().length > 256) {
      str1 = paramString.substring(0, 256);
    }
    String str2;
    if (!str1.equals("_ping"))
    {
      str2 = str1;
      if (!str1.equals("_gnip")) {}
    }
    else
    {
      str2 = str1.replaceAll("_", "-");
    }
    if (!str2.contains(":"))
    {
      paramString = str2;
      if (!str2.contains("|")) {}
    }
    else
    {
      paramString = str2.replaceAll(":", "_").replace("|", "_");
    }
    str1 = ":" + G.PHONE_MODEL + ":" + G.PHONE_BRAND + ":" + G.ANDROID_VERSION + ":" + G.APP_VERSION + ":" + Locale.getDefault().getDisplayLanguage() + ":" + Utils.getTime();
    int i = 256 - ("3.6.1:".getBytes().length + str1.getBytes().length);
    str1 = paramString;
    if (paramString.getBytes().length > i) {
      str1 = paramString.substring(0, i);
    }
    return "3.6.1:" + str1 + ":" + G.PHONE_MODEL + ":" + G.PHONE_BRAND + ":" + G.ANDROID_VERSION + ":" + G.APP_VERSION + ":" + Locale.getDefault().getDisplayLanguage() + ":" + Utils.getTime();
  }
  
  protected static EventsMechanism getInstance()
  {
    if (instance == null) {
      instance = new EventsMechanism();
    }
    return instance;
  }
  
  protected static void saveEvent(String paramString)
  {
    paramString = new Thread(new Runnable()
    {
      public void run()
      {
        String str = EventsMechanism.getFlatLine(this.val$tag);
        Object localObject = "Event_" + String.valueOf(System.currentTimeMillis()) + "-" + Integer.toString(new Random(System.currentTimeMillis()).nextInt(99999));
        try
        {
          localObject = new BufferedWriter(new FileWriter(G.FILES_PATH + "/" + (String)localObject));
          ((BufferedWriter)localObject).write(str);
          ((BufferedWriter)localObject).flush();
          ((BufferedWriter)localObject).close();
          return;
        }
        catch (IOException localIOException)
        {
          do
          {
            Log.e(G.TAG, "Error saving event data");
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
  
  protected static boolean transmitEventSync(String paramString)
  {
    if (BugSenseHandler.I_WANT_TO_DEBUG) {
      Log.d(G.TAG, "Transmitting Event, URL: " + G.URL + " APIKEY: " + G.API_KEY);
    }
    Object localObject2;
    for (;;)
    {
      try
      {
        if (G.ANALYTICS_URL.startsWith("https://"))
        {
          localObject1 = new CryptoHttpClient(0);
          localObject2 = ((DefaultHttpClient)localObject1).getParams();
          HttpProtocolParams.setUseExpectContinue((HttpParams)localObject2, false);
          HttpConnectionParams.setConnectionTimeout((HttpParams)localObject2, 20000);
          HttpConnectionParams.setSoTimeout((HttpParams)localObject2, 20000);
          localObject2 = new HttpPost(G.ANALYTICS_URL);
          ((HttpPost)localObject2).addHeader("X-BugSense-Api-Key", G.API_KEY);
          new ArrayList().add(new BasicNameValuePair("data", paramString));
          ((HttpPost)localObject2).setEntity(new StringEntity(paramString));
          paramString = ((DefaultHttpClient)localObject1).execute((HttpUriRequest)localObject2).getEntity();
          if (paramString != null) {
            break;
          }
          Log.w(G.TAG, "It seems that there is no internet connectivity");
          throw new Exception("no internet connection");
        }
      }
      catch (Exception paramString)
      {
        Log.w(G.TAG, "Transmitting ping Exception " + paramString.getMessage());
        if (BugSenseHandler.I_WANT_TO_DEBUG) {
          paramString.printStackTrace();
        }
        return false;
      }
      localObject1 = new DefaultHttpClient();
    }
    paramString = new BufferedReader(new InputStreamReader(paramString.getContent()));
    Object localObject1 = new StringBuilder();
    for (;;)
    {
      localObject2 = paramString.readLine();
      if (localObject2 == null) {
        break;
      }
      ((StringBuilder)localObject1).append((String)localObject2);
    }
    if (BugSenseHandler.I_WANT_TO_DEBUG) {
      Log.i(G.TAG, "Event Response: " + ((StringBuilder)localObject1).toString());
    }
    return true;
  }
  
  protected void sendSavedEvents()
  {
    try
    {
      Thread localThread = new Thread(new Runnable()
      {
        public void run()
        {
          Object localObject = new File(G.FILES_PATH);
          if (!((File)localObject).exists()) {
            ((File)localObject).mkdir();
          }
          localObject = ((File)localObject).list(new FilenameFilter()
          {
            public boolean accept(File paramAnonymous2File, String paramAnonymous2String)
            {
              return paramAnonymous2String.startsWith("Event_");
            }
          });
          if (BugSenseHandler.I_WANT_TO_DEBUG) {
            Log.d(G.TAG, "Events List has: " + localObject.length + " items");
          }
          int i = 12;
          if (12 > localObject.length) {
            i = localObject.length;
          }
          int j = 0;
          for (;;)
          {
            if ((j >= i) || (!EventsMechanism.transmitEventSync(Utils.readFile(G.FILES_PATH + "/" + localObject[j]))))
            {
              if (j >= 1)
              {
                i = 0;
                label137:
                if (i >= localObject.length) {}
              }
            }
            else {
              try
              {
                new File(G.FILES_PATH + "/" + localObject[i]).delete();
                i += 1;
                break label137;
                j += 1;
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  Log.e(G.TAG, "Error deleting trace file: " + G.FILES_PATH + "/" + localObject[i], localException);
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bugsense/trace/EventsMechanism.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */