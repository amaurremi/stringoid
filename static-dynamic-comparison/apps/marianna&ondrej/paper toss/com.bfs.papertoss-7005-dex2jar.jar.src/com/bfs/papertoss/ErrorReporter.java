package com.bfs.papertoss;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import com.bfs.papertoss.platform.SaveData;
import com.flurry.android.FlurryAgent;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Date;
import java.util.HashMap;

public class ErrorReporter
  implements Thread.UncaughtExceptionHandler
{
  private static ErrorReporter S_mInstance;
  String AndroidVersion;
  String Board;
  String Brand;
  private Context CurContext;
  String Device;
  String Display;
  String FilePath;
  String FingerPrint;
  String Host;
  String ID;
  String Manufacturer;
  String Model;
  String PackageName;
  String PhoneModel;
  private Thread.UncaughtExceptionHandler PreviousHandler;
  String Product;
  String Tags;
  long Time;
  String Type;
  String User;
  String VersionName;
  
  static ErrorReporter getInstance()
  {
    if (S_mInstance == null) {
      S_mInstance = new ErrorReporter();
    }
    return S_mInstance;
  }
  
  public String CreateInformationString()
  {
    RecoltInformations(this.CurContext);
    String str = "" + "Version : " + this.VersionName;
    str = str + "\n";
    str = str + "Package : " + this.PackageName;
    str = str + "\n";
    str = str + "FilePath : " + this.FilePath;
    str = str + "\n";
    str = str + "Phone Model : " + this.PhoneModel;
    str = str + "\n";
    str = str + "Android Version : " + this.AndroidVersion;
    str = str + "\n";
    str = str + "Board : " + this.Board;
    str = str + "\n";
    str = str + "Brand : " + this.Brand;
    str = str + "\n";
    str = str + "Device : " + this.Device;
    str = str + "\n";
    str = str + "Display : " + this.Display;
    str = str + "\n";
    str = str + "Finger Print : " + this.FingerPrint;
    str = str + "\n";
    str = str + "Host : " + this.Host;
    str = str + "\n";
    str = str + "ID : " + this.ID;
    str = str + "\n";
    str = str + "Model : " + this.Model;
    str = str + "\n";
    str = str + "Product : " + this.Product;
    str = str + "\n";
    str = str + "Tags : " + this.Tags;
    str = str + "\n";
    str = str + "Time : " + this.Time;
    str = str + "\n";
    str = str + "Type : " + this.Type;
    str = str + "\n";
    str = str + "User : " + this.User;
    str = str + "\n";
    str = str + "Total Internal memory : " + getTotalInternalMemorySize();
    str = str + "\n";
    str = str + "Available Internal memory : " + getAvailableInternalMemorySize();
    return str + "\n";
  }
  
  public void Init(Context paramContext)
  {
    this.PreviousHandler = Thread.getDefaultUncaughtExceptionHandler();
    Thread.setDefaultUncaughtExceptionHandler(this);
    this.CurContext = paramContext;
  }
  
  void RecoltInformations(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      this.VersionName = paramContext.versionName;
      this.PackageName = paramContext.packageName;
      this.PhoneModel = Build.MODEL;
      this.AndroidVersion = Build.VERSION.RELEASE;
      this.Board = Build.BOARD;
      this.Brand = Build.BRAND;
      this.Device = Build.DEVICE;
      this.Display = Build.DISPLAY;
      this.FingerPrint = Build.FINGERPRINT;
      this.Host = Build.HOST;
      this.ID = Build.ID;
      this.Model = Build.MODEL;
      this.Product = Build.PRODUCT;
      this.Tags = Build.TAGS;
      this.Time = Build.TIME;
      this.Type = Build.TYPE;
      this.User = Build.USER;
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public long getAvailableInternalMemorySize()
  {
    StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
    long l = localStatFs.getBlockSize();
    return localStatFs.getAvailableBlocks() * l;
  }
  
  public long getTotalInternalMemorySize()
  {
    StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
    long l = localStatFs.getBlockSize();
    return localStatFs.getBlockCount() * l;
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    Object localObject2 = new StringWriter();
    Object localObject3 = new PrintWriter((Writer)localObject2);
    paramThrowable.printStackTrace((PrintWriter)localObject3);
    Object localObject1 = localObject2.toString();
    localObject1 = "" + (String)localObject1;
    localObject1 = (String)localObject1 + "\n";
    localObject1 = (String)localObject1 + "Cause : \n";
    String str1 = (String)localObject1 + "======= \n";
    for (localObject1 = paramThrowable.getCause(); localObject1 != null; localObject1 = ((Throwable)localObject1).getCause())
    {
      ((Throwable)localObject1).printStackTrace((PrintWriter)localObject3);
      str1 = str1 + localObject2.toString();
    }
    ((PrintWriter)localObject3).close();
    int i = str1.indexOf("Caused by");
    localObject1 = "";
    if (i >= 0) {
      localObject1 = str1.substring(i, Math.min(i + 250, str1.length()));
    }
    localObject2 = new Date();
    str1 = str1 + "\n\nError Report collected on : " + ((Date)localObject2).toString();
    str1 = str1 + "\n";
    str1 = str1 + "\n";
    str1 = str1 + "Information :";
    str1 = str1 + "\n";
    str1 = str1 + "==============";
    str1 = str1 + "\n";
    str1 = str1 + "\n";
    str1 = str1 + CreateInformationString();
    str1 = str1 + "****  End of current Report ***";
    localObject2 = "" + getAvailableInternalMemorySize() / 1024.0D / 1024.0D + "MB";
    localObject3 = "" + getTotalInternalMemorySize() / 1024.0D / 1024.0D + "MB";
    HashMap localHashMap = new HashMap();
    localHashMap.put("Trace", str1.substring(0, Math.min(250, str1.length())));
    localHashMap.put("Cause", localObject1);
    localHashMap.put("Model", this.PhoneModel);
    localHashMap.put("OS", this.AndroidVersion);
    localHashMap.put("FreeMem", localObject2);
    localHashMap.put("TotalMem", localObject3);
    String str2 = Build.BRAND + "/" + "/" + this.PhoneModel + "/" + this.AndroidVersion;
    localHashMap.put("MODEL/OS", this.PhoneModel + "/" + this.AndroidVersion);
    localHashMap.put("MY_FINGERPRINT", str2);
    FlurryAgent.onEvent("UncaughtExceptionEvent", localHashMap);
    SaveData.write(str1.substring(0, Math.min(250, str1.length())), "trace", "CRASH");
    SaveData.write(localObject1, "cause", "CRASH");
    SaveData.write(this.PhoneModel, "model", "CRASH");
    SaveData.write(this.AndroidVersion, "os", "CRASH");
    SaveData.write(localObject2, "freeMem", "CRASH");
    SaveData.write(localObject3, "TotalMem", "CRASH");
    SaveData.write(str2, "myFingerprint", "CRASH");
    if (str1.contains("descendant")) {
      SaveData.write(str1, "Report", "CRASH");
    }
    SaveData.save();
    this.PreviousHandler.uncaughtException(paramThread, paramThrowable);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/bfs/papertoss/ErrorReporter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */