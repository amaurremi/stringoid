package com.jiubang.core.util;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.widget.Toast;
import com.gau.go.launcherex.gowidget.statistics.y;
import com.gtp.a.a.b.a;
import com.gtp.a.a.b.c;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;

public class ErrorReporter
  implements Thread.UncaughtExceptionHandler
{
  private static final String ANDROID_VERSION_KEY = "AndroidVersion";
  private static final String APP_CHANNEL_KEY = "PackageChannel";
  private static final String AVAILABLE_MEM_SIZE_KEY = "AvaliableMemSize";
  private static final String BOARD_KEY = "BOARD";
  private static final String BRAND_KEY = "BRAND";
  private static final String CUSTOM_DATA_KEY = "CustomData";
  private static final String DEVICE_KEY = "DEVICE";
  private static final String DISPLAY_KEY = "DISPLAY";
  static final String ERROR_FILE_TYPE = "_stk.txt";
  static final String EXTRA_REPORT_FILE_NAME = "REPORT_FILE_NAME";
  private static final String FILE_PATH_KEY = "FilePath";
  private static final String FINGERPRINT_KEY = "FINGERPRINT";
  private static final String HOST_KEY = "HOST";
  private static final String ID_KEY = "ID";
  static final String IS_SILENT_KEY = "silent";
  private static final String LOG_TAG = "ACRA";
  private static final int MAX_SEND_REPORTS = 5;
  private static final String MODEL_KEY = "MODEL";
  private static final String OUT_OF_MEMORY_ERROR = "bitmap size exceeds VM";
  private static final String PACKAGE_NAME_KEY = "PackageName";
  private static final String PHONE_MODEL_KEY = "PhoneModel";
  private static final String PRODUCT_KEY = "PRODUCT";
  static final String SILENT_PREFIX = "silent-";
  private static final String STACK_TRACE_KEY = "StackTrace";
  private static final String SVN_KEY = "SVN";
  private static final String TAGS_KEY = "TAGS";
  private static final String TIME_KEY = "TIME";
  private static final String TOTAL_MEM_SIZE_KEY = "TotalMemSize";
  private static final String TYPE_KEY = "TYPE";
  private static final String UPGRADE_ERROR = "result:3java.lang.ArrayIndexOutOfBoundsException: result:3";
  static final String USER_COMMENT_KEY = "user.comment";
  private static final String USER_KEY = "USER";
  private static final String VERSION_CODE_KEY = "VersionCode";
  private static final String VERSION_NAME_KEY = "VersionName";
  private static final String WIDGET_INIT = "android.widget.RemoteViews.<init>";
  private static ErrorReporter sInstanceSingleton;
  private Context mContext;
  private String mCrashFilePath = null;
  private Properties mCrashProperties = new Properties();
  private Bundle mCrashResources = new Bundle();
  Map mCustomParameters = new HashMap();
  private Thread.UncaughtExceptionHandler mDfltExceptionHandler;
  private Uri mFormUri;
  private boolean mIsOutOfMemoryError = false;
  private boolean mIsUpgradeError = false;
  private ReportingInteractionMode mReportingInteractionMode = ReportingInteractionMode.SILENT;
  
  private String createCustomInfoString()
  {
    Iterator localIterator = this.mCustomParameters.keySet().iterator();
    String str2;
    String str3;
    for (String str1 = ""; localIterator.hasNext(); str1 = str1 + str2 + " = " + str3 + "\n")
    {
      str2 = (String)localIterator.next();
      str3 = (String)this.mCustomParameters.get(str2);
    }
    return str1;
  }
  
  private String createSaveFilePath()
  {
    if (this.mCrashFilePath == null)
    {
      this.mCrashFilePath = a.a;
      File localFile = new File(this.mCrashFilePath);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
    }
    return this.mCrashFilePath;
  }
  
  public static long getAvailableInternalMemorySize()
  {
    StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
    long l = localStatFs.getBlockSize();
    return localStatFs.getAvailableBlocks() * l;
  }
  
  public static ErrorReporter getInstance()
  {
    try
    {
      if (sInstanceSingleton == null) {
        sInstanceSingleton = new ErrorReporter();
      }
      return sInstanceSingleton;
    }
    finally {}
  }
  
  public static long getTotalInternalMemorySize()
  {
    StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
    long l = localStatFs.getBlockSize();
    return localStatFs.getBlockCount() * l;
  }
  
  private void retrieveCrashData(Context paramContext)
  {
    for (;;)
    {
      try
      {
        PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
        if (localPackageInfo != null)
        {
          this.mCrashProperties.put("SVN", y.g(this.mContext));
          Properties localProperties = this.mCrashProperties;
          if (localPackageInfo.versionName != null)
          {
            str = localPackageInfo.versionName;
            localProperties.put("VersionName", str);
            this.mCrashProperties.put("VersionCode", Integer.toString(localPackageInfo.versionCode));
            this.mCrashProperties.put("PackageChannel", y.f(this.mContext));
            this.mCrashProperties.put("PackageName", paramContext.getPackageName());
            this.mCrashProperties.put("PhoneModel", Build.MODEL);
            this.mCrashProperties.put("AndroidVersion", Build.VERSION.RELEASE);
            this.mCrashProperties.put("BOARD", Build.BOARD);
            this.mCrashProperties.put("BRAND", Build.BRAND);
            this.mCrashProperties.put("DEVICE", Build.DEVICE);
            this.mCrashProperties.put("DISPLAY", Build.DISPLAY);
            this.mCrashProperties.put("FINGERPRINT", Build.FINGERPRINT);
            this.mCrashProperties.put("HOST", Build.HOST);
            this.mCrashProperties.put("ID", Build.ID);
            this.mCrashProperties.put("MODEL", Build.MODEL);
            this.mCrashProperties.put("PRODUCT", Build.PRODUCT);
            this.mCrashProperties.put("TAGS", Build.TAGS);
            this.mCrashProperties.put("TIME", "" + Build.TIME);
            this.mCrashProperties.put("TYPE", Build.TYPE);
            this.mCrashProperties.put("USER", Build.USER);
            this.mCrashProperties.put("TotalMemSize", "" + getTotalInternalMemorySize());
            this.mCrashProperties.put("AvaliableMemSize", "" + getAvailableInternalMemorySize());
            this.mCrashProperties.put("FilePath", paramContext.getFilesDir().getAbsolutePath());
          }
        }
        else
        {
          this.mCrashProperties.put("VersionName", "Package info unavailable");
          this.mCrashProperties.put("VersionCode", "Package info unavailable");
          continue;
        }
        String str = "not set";
      }
      catch (Exception paramContext)
      {
        c.b("ACRA", "Error while retrieving crash data", paramContext);
        return;
      }
    }
  }
  
  private String saveCrashReportFile()
  {
    for (;;)
    {
      try
      {
        c.a("ACRA", "Writing crash report file.");
        long l = System.currentTimeMillis();
        String str1 = this.mCrashProperties.getProperty("silent");
        Object localObject = createSaveFilePath();
        localObject = new StringBuilder().append((String)localObject);
        if (str1 != null)
        {
          str1 = "silent-";
          str1 = str1 + "stack-" + l + "_stk.txt";
          localObject = new FileOutputStream(new File(str1), true);
          c.a("ACRA", str1, this);
          String str3 = this.mCrashProperties.getProperty("StackTrace");
          if ((str3.contains("bitmap size exceeds VM")) && (str3.contains("android.widget.RemoteViews.<init>")))
          {
            this.mIsOutOfMemoryError = true;
            str3 = str3.replaceAll("\\n\\t", "\n");
            this.mCrashProperties.setProperty("StackTrace", str3);
            storeToOutputStream((OutputStream)localObject, this.mCrashProperties);
            ((FileOutputStream)localObject).flush();
            ((FileOutputStream)localObject).close();
            return str1;
          }
          if (!str3.contains("result:3java.lang.ArrayIndexOutOfBoundsException: result:3")) {
            continue;
          }
          this.mIsUpgradeError = true;
          continue;
        }
        String str2 = "";
      }
      catch (Exception localException)
      {
        c.b("ACRA", "An error occured while writing the report file...", localException);
        return null;
      }
    }
  }
  
  private void sendCrashReport(Context paramContext, Properties paramProperties)
  {
    paramProperties.put("pageNumber", "0");
    paramProperties.put("backupCache", "");
    paramProperties.put("submit", "Envoyer");
    paramContext = new URL(this.mFormUri.toString());
    c.a("ACRA", "Connect to " + paramContext.toString());
    HttpUtils.doPost(paramProperties, paramContext);
  }
  
  private void sendMail(Context paramContext, String paramString1, String paramString2)
  {
    c.a("ACRA", paramString1, this);
    Intent localIntent = new Intent("android.intent.action.SEND");
    localIntent.addFlags(268435456);
    Object localObject = paramContext.getPackageManager();
    try
    {
      localObject = ((PackageManager)localObject).getPackageInfo(paramContext.getPackageName(), 0);
      if (localObject != null)
      {
        localObject = ((PackageInfo)localObject).versionName;
        String str2 = y.f(this.mContext);
        localObject = " v" + (String)localObject + " " + str2 + " Fix ";
        localObject = "GO Weather EX" + (String)localObject + "Error";
        localIntent.putExtra("android.intent.extra.EMAIL", new String[] { "gowidgetbugs@gmail.com" });
        localIntent.putExtra("android.intent.extra.SUBJECT", (String)localObject);
        if (paramString2 != null) {
          localIntent.putExtra("android.intent.extra.TEXT", paramString2);
        }
        localIntent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(paramString1)));
        localIntent.setType("plain/text");
        paramContext.startActivity(localIntent);
        return;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        localNameNotFoundException.printStackTrace();
        String str1 = null;
        continue;
        str1 = "unknow";
      }
    }
  }
  
  public void addCustomData(String paramString1, String paramString2)
  {
    this.mCustomParameters.put(paramString1, paramString2);
  }
  
  void checkAndSendReports(Context paramContext, String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        Object localObject = getCrashReportFilesList();
        TreeSet localTreeSet = new TreeSet();
        if (localObject != null) {
          localTreeSet.addAll(Arrays.asList((Object[])localObject));
        }
        if ((localObject != null) && (localObject.length > 0))
        {
          Properties localProperties = new Properties();
          Iterator localIterator = localTreeSet.iterator();
          i = 0;
          if (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            c.b("ACRA", str);
            if (i >= 5) {
              break label323;
            }
            localObject = paramContext.openFileInput(str);
            localProperties.load((InputStream)localObject);
            ((FileInputStream)localObject).close();
            if ((str.equals(paramString)) || ((i == localTreeSet.size() - 1) && (this.mCustomParameters.containsKey("user.comment"))))
            {
              localObject = localProperties.getProperty("CustomData");
              if (localObject == null)
              {
                localObject = "";
                localProperties.put("CustomData", (String)localObject + "user.comment" + " = " + (String)this.mCustomParameters.get("user.comment"));
                this.mCustomParameters.remove("user.comment");
              }
            }
            else
            {
              sendCrashReport(paramContext, localProperties);
              new File(paramContext.getFilesDir(), str).delete();
              break label323;
            }
            localObject = (String)localObject + "\n";
            continue;
          }
        }
        paramContext = this.mCustomParameters;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        paramContext = this.mCustomParameters;
        return;
      }
      finally
      {
        this.mCustomParameters.remove("user.comment");
      }
      continue;
      label323:
      i += 1;
    }
  }
  
  public void checkReportsOnApplicationStart()
  {
    String[] arrayOfString = getCrashReportFilesList();
    if ((arrayOfString != null) && (arrayOfString.length > 0))
    {
      boolean bool = containsOnlySilentReports(arrayOfString);
      if ((this.mReportingInteractionMode != ReportingInteractionMode.SILENT) && (this.mReportingInteractionMode != ReportingInteractionMode.TOAST) && ((this.mReportingInteractionMode != ReportingInteractionMode.NOTIFICATION) || (!bool))) {
        break label97;
      }
      if (this.mReportingInteractionMode == ReportingInteractionMode.TOAST) {
        Toast.makeText(this.mContext, this.mCrashResources.getInt("RES_TOAST_TEXT"), 1).show();
      }
      new ErrorReporter.ReportsSenderWorker(this).start();
    }
    label97:
    while (this.mReportingInteractionMode != ReportingInteractionMode.NOTIFICATION) {
      return;
    }
    getInstance().notifySendReport(arrayOfString[(arrayOfString.length - 1)]);
  }
  
  public boolean containsOnlySilentReports(String[] paramArrayOfString)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (!paramArrayOfString[i].startsWith("silent-")) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public void deletePendingReports()
  {
    String[] arrayOfString = getCrashReportFilesList();
    if (arrayOfString != null)
    {
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        new File(this.mContext.getFilesDir(), str).delete();
        i += 1;
      }
    }
  }
  
  public void disable()
  {
    if (this.mDfltExceptionHandler != null) {
      Thread.setDefaultUncaughtExceptionHandler(this.mDfltExceptionHandler);
    }
  }
  
  String[] getCrashReportFilesList()
  {
    File localFile = this.mContext.getFilesDir();
    ErrorReporter.2 local2 = new ErrorReporter.2(this);
    if (localFile != null) {
      return localFile.list(local2);
    }
    return null;
  }
  
  public void handleException(Throwable paramThrowable)
  {
    handleException(paramThrowable, this.mReportingInteractionMode);
  }
  
  void handleException(Throwable paramThrowable, ReportingInteractionMode paramReportingInteractionMode)
  {
    ReportingInteractionMode localReportingInteractionMode = paramReportingInteractionMode;
    if (paramReportingInteractionMode == null) {
      localReportingInteractionMode = this.mReportingInteractionMode;
    }
    paramReportingInteractionMode = paramThrowable;
    if (paramThrowable == null) {
      paramReportingInteractionMode = new Exception("Report requested by developer");
    }
    if (localReportingInteractionMode == ReportingInteractionMode.TOAST) {
      new ErrorReporter.1(this).start();
    }
    retrieveCrashData(this.mContext);
    this.mCrashProperties.put("CustomData", createCustomInfoString());
    StringWriter localStringWriter = new StringWriter();
    PrintWriter localPrintWriter = new PrintWriter(localStringWriter);
    localPrintWriter.append(paramReportingInteractionMode.getMessage());
    paramReportingInteractionMode.printStackTrace(localPrintWriter);
    c.a(paramReportingInteractionMode);
    for (paramThrowable = paramReportingInteractionMode.getCause(); paramThrowable != null; paramThrowable = paramThrowable.getCause()) {
      paramThrowable.printStackTrace(localPrintWriter);
    }
    this.mCrashProperties.put("StackTrace", localStringWriter.toString());
    localPrintWriter.close();
    this.mIsOutOfMemoryError = false;
    this.mIsUpgradeError = false;
    paramThrowable = saveCrashReportFile();
    c.a("ACRA", paramThrowable, this);
    if ((!this.mIsOutOfMemoryError) && (!this.mIsUpgradeError))
    {
      if ((localReportingInteractionMode != ReportingInteractionMode.SILENT) && (localReportingInteractionMode != ReportingInteractionMode.TOAST)) {
        break label212;
      }
      checkAndSendReports(this.mContext, null);
    }
    label212:
    while (localReportingInteractionMode != ReportingInteractionMode.NOTIFICATION) {
      return;
    }
    notifySendReport(paramThrowable);
  }
  
  public void handleSilentException(Throwable paramThrowable)
  {
    this.mCrashProperties.put("silent", "true");
    handleException(paramThrowable, ReportingInteractionMode.SILENT);
  }
  
  public void init(Context paramContext)
  {
    this.mDfltExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
    Thread.setDefaultUncaughtExceptionHandler(this);
    this.mContext = paramContext;
  }
  
  void notifySendReport(String paramString)
  {
    NotificationManager localNotificationManager = (NotificationManager)this.mContext.getSystemService("notification");
    int i = 17301624;
    if (this.mCrashResources.containsKey("RES_NOTIF_ICON")) {
      i = this.mCrashResources.getInt("RES_NOTIF_ICON");
    }
    CharSequence localCharSequence1 = this.mContext.getText(this.mCrashResources.getInt("RES_NOTIF_TICKER_TEXT"));
    long l = System.currentTimeMillis();
    Notification localNotification = new Notification();
    localNotification.icon = i;
    localNotification.tickerText = localCharSequence1;
    localNotification.when = l;
    localCharSequence1 = this.mContext.getText(this.mCrashResources.getInt("RES_NOTIF_TITLE"));
    CharSequence localCharSequence2 = this.mContext.getText(this.mCrashResources.getInt("RES_NOTIF_TEXT"));
    Intent localIntent = new Intent(this.mContext, CrashReportDialog.class);
    localIntent.putExtra("REPORT_FILE_NAME", paramString);
    c.a("ACRA", paramString, this);
    paramString = PendingIntent.getActivity(this.mContext, 0, localIntent, 0);
    localNotification.setLatestEventInfo(this.mContext, localCharSequence1, localCharSequence2, paramString);
    localNotificationManager.notify(666, localNotification);
  }
  
  void setCrashResources(Bundle paramBundle)
  {
    this.mCrashResources = paramBundle;
  }
  
  public void setFormUri(Uri paramUri)
  {
    this.mFormUri = paramUri;
  }
  
  void setReportingInteractionMode(ReportingInteractionMode paramReportingInteractionMode)
  {
    this.mReportingInteractionMode = paramReportingInteractionMode;
  }
  
  public void storeToOutputStream(OutputStream paramOutputStream, Properties paramProperties)
  {
    if (paramProperties == null) {
      return;
    }
    label177:
    for (;;)
    {
      try
      {
        String str = System.getProperty("line.separator");
        if (str != null) {
          break label177;
        }
        str = "\n";
        StringBuilder localStringBuilder = new StringBuilder();
        paramOutputStream = new OutputStreamWriter(paramOutputStream, "ISO8859_1");
        paramOutputStream.write("#");
        paramOutputStream.write(new Date().toString());
        paramOutputStream.write(str);
        paramProperties = paramProperties.entrySet().iterator();
        if (paramProperties.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramProperties.next();
          localStringBuilder.append((String)localEntry.getKey());
          localStringBuilder.append('=');
          localStringBuilder.append((String)localEntry.getValue());
          localStringBuilder.append(str);
          paramOutputStream.write(localStringBuilder.toString());
          localStringBuilder.setLength(0);
          continue;
        }
        paramOutputStream.flush();
      }
      finally {}
      break;
    }
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    if ((paramThread != null) && (paramThread.getName().startsWith("AdWorker")))
    {
      c.a("ADMOB", "AdWorker thread thrown an exception.", paramThrowable);
      return;
    }
    try
    {
      disable();
      handleException(paramThrowable);
      if (this.mReportingInteractionMode == ReportingInteractionMode.TOAST) {}
      try
      {
        Thread.sleep(4000L);
        if (this.mReportingInteractionMode == ReportingInteractionMode.SILENT)
        {
          this.mDfltExceptionHandler.uncaughtException(paramThread, paramThrowable);
          return;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          c.b("ACRA", "Error : ", localInterruptedException);
        }
        try
        {
          paramThread = this.mContext.getPackageManager().getApplicationInfo(this.mContext.getPackageName(), 0).loadLabel(this.mContext.getPackageManager());
          c.b("ACRA", paramThread + " fatal error : " + paramThrowable.getMessage(), paramThrowable);
          c.a("ACRA", "process id" + Process.myPid(), this);
          Process.killProcess(Process.myPid());
        }
        catch (PackageManager.NameNotFoundException paramThread)
        {
          for (;;)
          {
            c.b("ACRA", "Error : ", paramThread);
            c.a("ACRA", "process id" + Process.myPid(), this);
            Process.killProcess(Process.myPid());
          }
        }
        finally
        {
          c.a("ACRA", "process id" + Process.myPid(), this);
          Process.killProcess(Process.myPid());
          System.exit(10);
        }
        System.exit(10);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/core/util/ErrorReporter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */