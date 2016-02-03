package com.bfs.papertoss;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.backflipstudios.android.debug.BFSDebug;
import com.backflipstudios.android.engine.io.BFSAssetFile;
import com.bfs.papertoss.platform.Globals;
import com.bfs.papertoss.platform.SaveData;
import com.bfs.papertoss.platform.SoundMgr;
import com.flurry.android.FlurryAgent;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
import org.json.JSONTokener;

public class PaperTossApplication
  extends Application
{
  private static boolean m_firstFlurrySession = true;
  private static boolean m_flurrySessionOpen;
  private static PaperTossApplication m_instance = null;
  private ErrorReporter errorReporter = null;
  private HashMap<String, String> m_configurationParameters = null;
  private int m_runCount = 0;
  
  static
  {
    m_flurrySessionOpen = false;
  }
  
  public PaperTossApplication()
  {
    m_instance = this;
  }
  
  private void checkForErrorLog()
  {
    if (SaveData.groupExists("CRASH"))
    {
      String str1 = SaveData.read("empty", "trace", "CRASH");
      Object localObject = SaveData.read("empty", "cause", "CRASH");
      String str2 = SaveData.read("empty", "model", "CRASH");
      String str3 = SaveData.read("empty", "os", "CRASH");
      String str4 = SaveData.read("empty", "freeMem", "CRASH");
      String str5 = SaveData.read("empty", "TotalMem", "CRASH");
      String str6 = SaveData.read("empty", "myFingerprint", "CRASH");
      Log.d("BFS", "Found crash report: " + str1 + (String)localObject + str2 + str3 + str4 + str5);
      HashMap localHashMap = new HashMap();
      localHashMap.put("Trace", str1);
      localHashMap.put("Cause", localObject);
      localHashMap.put("Model", str2);
      localHashMap.put("OS", str3);
      localHashMap.put("FreeMem", str4);
      localHashMap.put("TotalMem", str5);
      localHashMap.put("Model/OS", str2 + "/" + str3);
      localHashMap.put("MyFingerprint", str6);
      FlurryAgent.onEvent("POST_UNCAUGHT_EXCEPTION", localHashMap);
      if (SaveData.keyExists("Report", "CRASH"))
      {
        str1 = SaveData.read("", "Report", "CRASH");
        int i = 0;
        localObject = new HashMap();
        while ((str1.length() > 0) && (i < 10))
        {
          int j = Math.min(250, str1.length());
          str2 = str1.substring(0, j);
          ((HashMap)localObject).put("" + i, str2);
          str1 = str1.substring(j);
          i += 1;
        }
        FlurryAgent.onEvent("VIEW_ERROR", (Map)localObject);
      }
      SaveData.deleteGroup("CRASH");
      SaveData.save();
    }
  }
  
  public static String getFirstLineOfException(Exception paramException)
  {
    try
    {
      Log.d("BFS", "getFirstLineOfException", paramException);
      StringWriter localStringWriter = new StringWriter();
      paramException.printStackTrace(new PrintWriter(localStringWriter));
      paramException = localStringWriter.toString();
      paramException = paramException.substring(0, Math.min(250, paramException.length()));
      return paramException;
    }
    catch (Exception paramException) {}
    return "exception - getFirstLineOfException";
  }
  
  public static PaperTossApplication getInstance()
  {
    return m_instance;
  }
  
  private void loadConfigurationParameters()
  {
    try
    {
      Object localObject1 = BFSAssetFile.readContentsOfFile("configuration.json");
      if (localObject1 != null)
      {
        localObject1 = (JSONObject)new JSONTokener(new String((byte[])localObject1)).nextValue();
        Iterator localIterator1 = ((JSONObject)localObject1).keys();
        while (localIterator1.hasNext())
        {
          Object localObject2 = (String)localIterator1.next();
          if ("parameters".equals(localObject2))
          {
            localObject2 = ((JSONObject)localObject1).getJSONObject((String)localObject2);
            Iterator localIterator2 = ((JSONObject)localObject2).keys();
            while (localIterator2.hasNext())
            {
              String str1 = (String)localIterator2.next();
              String str2 = ((JSONObject)localObject2).optString(str1);
              if (this.m_configurationParameters == null) {
                this.m_configurationParameters = new HashMap();
              }
              this.m_configurationParameters.put(str1, str2);
            }
          }
        }
      }
      return;
    }
    catch (Exception localException)
    {
      BFSDebug.e("BFS", "BFSEngineApplication.loadConfigurationParameters()", localException);
    }
  }
  
  public static void logErrorWithFlurry(String paramString1, Exception paramException, String paramString2)
  {
    try
    {
      Log.d("BFS", "logErrorWithFlurry", paramException);
      StringWriter localStringWriter = new StringWriter();
      PrintWriter localPrintWriter = new PrintWriter(localStringWriter);
      paramException.printStackTrace(localPrintWriter);
      paramString2 = localStringWriter.toString();
      paramString2 = "" + paramString2;
      Object localObject = paramString2 + "\nCause : \n";
      paramString2 = paramException.getCause();
      paramException = (Exception)localObject;
      while (paramString2 != null)
      {
        paramString2.printStackTrace(localPrintWriter);
        paramException = paramException + localStringWriter.toString();
        paramString2 = paramString2.getCause();
      }
      localPrintWriter.close();
      int i = paramException.indexOf("Caused by");
      paramString2 = "empty";
      if (i >= 0) {
        paramString2 = paramException.substring(i, Math.min(i + 250, paramException.length()));
      }
      localObject = new HashMap();
      ((HashMap)localObject).put("Trace", paramException.substring(0, Math.min(250, paramException.length())));
      ((HashMap)localObject).put("Cause", paramString2);
      ((HashMap)localObject).put("In method", paramString1);
      FlurryAgent.onEvent("PAPERTOSS_ERROR", (Map)localObject);
      return;
    }
    catch (Exception paramString1) {}
  }
  
  public boolean checkBuildConfigurationParameter(String paramString1, String paramString2)
  {
    return (this.m_configurationParameters != null) && (this.m_configurationParameters.containsKey(paramString1)) && (((String)this.m_configurationParameters.get(paramString1)).equals(paramString2));
  }
  
  public void closeFlurrySession()
  {
    if (m_flurrySessionOpen)
    {
      FlurryAgent.onEndSession(this);
      m_flurrySessionOpen = false;
    }
  }
  
  public String getBuildConfigurationParameter(String paramString)
  {
    if ((this.m_configurationParameters != null) && (this.m_configurationParameters.containsKey(paramString))) {
      return (String)this.m_configurationParameters.get(paramString);
    }
    return "";
  }
  
  public int getRunCount()
  {
    return this.m_runCount;
  }
  
  public void onCreate()
  {
    super.onCreate();
    BFSDebug.i("PaperTossApplication.onCreate");
    Globals.m_context = this;
    Globals.mainHandler = new Handler();
    if (Globals.soundMgr == null) {
      Globals.soundMgr = new SoundMgr();
    }
    if (((WindowManager)getSystemService("window")).getDefaultDisplay().getHeight() > 480)
    {
      Globals.HI_RES = true;
      Globals.SCALE_FACTOR = 0.613027F;
    }
    for (;;)
    {
      SaveData.load();
      if (this.errorReporter == null)
      {
        this.errorReporter = new ErrorReporter();
        this.errorReporter.Init(this);
      }
      try
      {
        String str = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        this.m_runCount = SaveData.read(0, str, "STARTS");
        this.m_runCount += 1;
        SaveData.write(Integer.valueOf(this.m_runCount), str, "STARTS");
        Globals.STARTS_ANY_VERSION = SaveData.read(0, "STARTS_ANY_VERSION");
        Globals.STARTS_ANY_VERSION += 1;
        SaveData.write(Integer.valueOf(Globals.STARTS_ANY_VERSION), "STARTS_ANY_VERSION");
        SaveData.save();
        loadConfigurationParameters();
        return;
        Globals.HI_RES = false;
        Globals.SCALE_FACTOR = 1.0F;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          BFSDebug.e("PaperTossApplication.onCreate", localException);
        }
      }
    }
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    BFSDebug.i("PaperTossApplication.onLowMemory");
  }
  
  public void onTerminate()
  {
    super.onTerminate();
    BFSDebug.i("PaperTossApplication.onTerminate");
  }
  
  public void startFlurrySession()
  {
    if (!m_flurrySessionOpen)
    {
      FlurryAgent.onStartSession(this, "WAJQV9CWNGIK5DKA8L17");
      checkForErrorLog();
      if (m_firstFlurrySession) {
        m_firstFlurrySession = false;
      }
    }
    for (;;)
    {
      try
      {
        str1 = getPackageManager().getInstallerPackageName(getPackageName());
        HashMap localHashMap = new HashMap();
        localHashMap.put("ID", ((TelephonyManager)getSystemService("phone")).getDeviceId());
        Object localObject = ((WindowManager)getSystemService("window")).getDefaultDisplay();
        int i = ((Display)localObject).getWidth();
        int j = ((Display)localObject).getHeight();
        localHashMap.put("HEIGHT", "" + j);
        localHashMap.put("WIDTHxHEIGHT", i + "x" + j);
        localObject = Build.MODEL;
        String str2 = Build.VERSION.RELEASE;
        String str3 = Build.FINGERPRINT;
        String str4 = Build.BRAND + "/" + (String)localObject + "/" + str2;
        localHashMap.put("MODEL/OS", (String)localObject + "/" + str2);
        localHashMap.put("FINGERPRINT", str3);
        localHashMap.put("MY_FINGERPRINT", str4);
        if (str1 == null) {
          continue;
        }
        localHashMap.put("SOURCE", str1);
        FlurryAgent.onEvent("USER_START", localHashMap);
      }
      catch (Exception localException)
      {
        String str1;
        BFSDebug.e("PaperTossApplication.startFlurrySession(): Reportin device characteristics", localException);
        continue;
      }
      m_flurrySessionOpen = true;
      return;
      str1 = "null";
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/bfs/papertoss/PaperTossApplication.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */