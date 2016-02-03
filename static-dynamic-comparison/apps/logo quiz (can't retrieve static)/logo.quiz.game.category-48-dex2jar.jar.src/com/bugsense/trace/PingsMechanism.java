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

public final class PingsMechanism
{
  protected static final int GNIP = 1;
  private static final int MAX_GNIPS_SIZE = 2;
  private static final int MAX_PERFS_SIZE = 10;
  private static final int MAX_PINGS_SIZE = 2;
  protected static final int PING = 0;
  protected static final int TRANS_END = 3;
  protected static final int TRANS_START = 2;
  private static volatile PingsMechanism instance;
  
  protected static String getFlatLine(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    String str = "";
    if (paramInt == 0) {
      str = "_ping";
    }
    for (;;)
    {
      str = "3.6.1:" + str + ":" + G.PHONE_MODEL + ":" + G.PHONE_BRAND + ":" + G.ANDROID_VERSION + ":" + G.APP_VERSION + ":" + Locale.getDefault().getDisplayLanguage() + ":" + Utils.getTime();
      paramString1 = str;
      if (paramString2 != null)
      {
        paramString1 = str;
        if (paramString3 != null)
        {
          paramString1 = str;
          if (paramString2.length() > 0)
          {
            paramString1 = str;
            if (paramString3.length() > 0) {
              paramString1 = str + ":" + paramString2 + ":" + paramString3;
            }
          }
        }
      }
      return paramString1;
      if (paramInt == 1) {
        str = "_gnip";
      } else if (paramInt == 2) {
        str = "_trstart-" + paramString1;
      } else if (paramInt == 3) {
        str = "_trend-" + paramString1;
      }
    }
  }
  
  protected static PingsMechanism getInstance()
  {
    if (instance == null) {
      instance = new PingsMechanism();
    }
    return instance;
  }
  
  protected static void savePing(int paramInt, final String paramString)
  {
    new Thread(new Runnable()
    {
      public void run()
      {
        if ((this.val$type == 2) || (this.val$type == 3))
        {
          PingsMechanism.savePing(this.val$type, paramString, Utils.getCPU(), Utils.getMem());
          return;
        }
        PingsMechanism.savePing(this.val$type, null, null, null);
      }
    }).start();
  }
  
  protected static void savePing(int paramInt, final String paramString1, final String paramString2, final String paramString3)
  {
    paramString1 = new Thread(new Runnable()
    {
      public void run()
      {
        String str = PingsMechanism.getFlatLine(this.val$type, paramString1, paramString2, paramString3);
        Object localObject = "Ping_";
        if (this.val$type == 1) {
          localObject = "Gnip_";
        }
        if ((this.val$type == 2) || (this.val$type == 3)) {
          localObject = "Perf_";
        }
        localObject = (String)localObject + String.valueOf(System.currentTimeMillis()) + "-" + Integer.toString(new Random(System.currentTimeMillis()).nextInt(99999));
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
            Log.e(G.TAG, "Error saving ping data");
          } while (!BugSenseHandler.I_WANT_TO_DEBUG);
          localIOException.printStackTrace();
        }
      }
    });
    paramString2 = BugSense.getExecutor();
    if ((paramString1 != null) && (paramString2 != null)) {
      paramString2.submit(paramString1);
    }
  }
  
  protected static void transmitPingASync(int paramInt)
  {
    transmitPingASync(getFlatLine(paramInt, null, null, null), paramInt);
  }
  
  protected static void transmitPingASync(String paramString, final int paramInt)
  {
    paramString = new Thread(new Runnable()
    {
      public void run()
      {
        if (!PingsMechanism.transmitPingSync(this.val$jsonCrashData)) {
          PingsMechanism.savePing(paramInt, null, null, null);
        }
      }
    });
    ExecutorService localExecutorService = BugSense.getExecutor();
    if ((paramString != null) && (localExecutorService != null)) {
      localExecutorService.submit(paramString);
    }
  }
  
  protected static boolean transmitPingSync(String paramString)
  {
    if (BugSenseHandler.I_WANT_TO_DEBUG) {
      Log.d(G.TAG, "Transmitting Ping, URL: " + G.URL + " APIKEY: " + G.API_KEY);
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
      Log.i(G.TAG, "Ping Response: " + ((StringBuilder)localObject1).toString());
    }
    return true;
  }
  
  protected void sendSavedPings()
  {
    try
    {
      Thread localThread = new Thread(new Runnable()
      {
        public void run()
        {
          int m = 2;
          int k = 0;
          Object localObject3 = new File(G.FILES_PATH);
          if (!((File)localObject3).exists()) {
            ((File)localObject3).mkdir();
          }
          Object localObject1 = new FilenameFilter()
          {
            public boolean accept(File paramAnonymous2File, String paramAnonymous2String)
            {
              return paramAnonymous2String.startsWith("Ping_");
            }
          };
          Object localObject2 = new FilenameFilter()
          {
            public boolean accept(File paramAnonymous2File, String paramAnonymous2String)
            {
              return paramAnonymous2String.startsWith("Gnip_");
            }
          };
          FilenameFilter local3 = new FilenameFilter()
          {
            public boolean accept(File paramAnonymous2File, String paramAnonymous2String)
            {
              return paramAnonymous2String.startsWith("Perf_");
            }
          };
          localObject1 = ((File)localObject3).list((FilenameFilter)localObject1);
          localObject2 = ((File)localObject3).list((FilenameFilter)localObject2);
          localObject3 = ((File)localObject3).list(local3);
          if (BugSenseHandler.I_WANT_TO_DEBUG)
          {
            Log.d(G.TAG, "Ping List has: " + localObject1.length + " items");
            Log.d(G.TAG, "Gnip List has: " + localObject2.length + " items");
            Log.d(G.TAG, "Perf List has: " + localObject3.length + " items");
          }
          if (2 > localObject1.length) {}
          for (int i = localObject1.length;; i = 2)
          {
            int j = 0;
            for (;;)
            {
              if ((j >= i) || (!PingsMechanism.transmitPingSync(Utils.readFile(G.FILES_PATH + "/" + localObject1[j]))))
              {
                if (j >= 1)
                {
                  i = 0;
                  label255:
                  if (i >= localObject1.length) {}
                }
              }
              else {
                try
                {
                  new File(G.FILES_PATH + "/" + localObject1[i]).delete();
                  i += 1;
                  break label255;
                  j += 1;
                }
                catch (Exception localException3)
                {
                  for (;;)
                  {
                    Log.e(G.TAG, "Error deleting trace file: " + G.FILES_PATH + "/" + localObject1[i], localException3);
                  }
                }
              }
            }
            i = m;
            if (2 > localObject2.length) {
              i = localObject2.length;
            }
            j = 0;
            for (;;)
            {
              if ((j >= i) || (!PingsMechanism.transmitPingSync(Utils.readFile(G.FILES_PATH + "/" + localObject2[j]))))
              {
                if (j >= 1)
                {
                  i = 0;
                  label427:
                  if (i >= localObject2.length) {}
                }
              }
              else {
                try
                {
                  new File(G.FILES_PATH + "/" + localObject2[i]).delete();
                  i += 1;
                  break label427;
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
            i = 10;
            if (10 > localObject3.length) {
              i = localObject3.length;
            }
            j = 0;
            for (;;)
            {
              if ((j >= i) || (!PingsMechanism.transmitPingSync(Utils.readFile(G.FILES_PATH + "/" + localObject3[j]))))
              {
                if (j >= 1)
                {
                  i = k;
                  label600:
                  if (i >= localObject3.length) {}
                }
              }
              else {
                try
                {
                  new File(G.FILES_PATH + "/" + localObject3[i]).delete();
                  i += 1;
                  break label600;
                  j += 1;
                }
                catch (Exception localException2)
                {
                  for (;;)
                  {
                    Log.e(G.TAG, "Error deleting trace file: " + G.FILES_PATH + "/" + localObject3[i], localException2);
                  }
                }
              }
            }
            return;
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bugsense/trace/PingsMechanism.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */