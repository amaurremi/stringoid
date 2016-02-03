package com.magmamobile.game.engine;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

final class ErrorReporter
  implements Thread.UncaughtExceptionHandler
{
  private static final String EMAIL = "supportapp@magmamobile.com";
  private static final String TITLE = "[Furnace]";
  private String AndroidVersion;
  private String Board;
  private String Brand;
  private String CPU_ABI;
  private String Device;
  private String Display;
  private String FilePath;
  private String FingerPrint;
  private String Host;
  private String ID;
  private String Manufacturer;
  private String Model;
  private String PackageName;
  private String PhoneModel;
  private Thread.UncaughtExceptionHandler PreviousHandler = Thread.getDefaultUncaughtExceptionHandler();
  private String Product;
  private String Tags;
  private long Time;
  private String Type;
  private String User;
  private String VersionName;
  
  public ErrorReporter(Context paramContext)
  {
    Thread.setDefaultUncaughtExceptionHandler(this);
    RecoltInformations(paramContext);
  }
  
  private final String CreateInformationString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Version : ").append(this.VersionName).append("\n");
    localStringBuilder.append("Package : ").append(this.PackageName).append("\n");
    localStringBuilder.append("FilePath : ").append(this.FilePath).append("\n");
    localStringBuilder.append("Phone Model").append(this.PhoneModel).append("\n");
    localStringBuilder.append("Android Version : ").append(this.AndroidVersion).append("\n");
    localStringBuilder.append("Board : ").append(this.Board).append("\n");
    localStringBuilder.append("Brand : ").append(this.Brand).append("\n");
    localStringBuilder.append("Device : ").append(this.Device).append("\n");
    localStringBuilder.append("Display : ").append(this.Display).append("\n");
    localStringBuilder.append("Finger Print : ").append(this.FingerPrint).append("\n");
    localStringBuilder.append("Host : ").append(this.Host).append("\n");
    localStringBuilder.append("ID : ").append(this.ID).append("\n");
    localStringBuilder.append("Model : ").append(this.Model).append("\n");
    localStringBuilder.append("Product : ").append(this.Product).append("\n");
    localStringBuilder.append("Manufacturer : ").append(this.Manufacturer).append("\n");
    localStringBuilder.append("CPU ABI : ").append(this.CPU_ABI).append("\n");
    localStringBuilder.append("Tags : ").append(this.Tags).append("\n");
    localStringBuilder.append("Time : ").append(this.Time).append("\n");
    localStringBuilder.append("Type : ").append(this.Type).append("\n");
    localStringBuilder.append("User : ").append(this.User).append("\n");
    localStringBuilder.append("Total Internal memory : ").append(getTotalInternalMemorySize()).append("\n");
    localStringBuilder.append("Available Internal memory : ").append(getAvailableInternalMemorySize()).append("\n");
    return localStringBuilder.toString();
  }
  
  private final String[] GetErrorFileList()
  {
    File localFile = new File(this.FilePath.concat("/"));
    localFile.mkdir();
    localFile.list(new FilenameFilter()
    {
      public boolean accept(File paramAnonymousFile, String paramAnonymousString)
      {
        return paramAnonymousString.endsWith(".stacktrace");
      }
    });
  }
  
  private final void RecoltInformations(Context paramContext)
  {
    try
    {
      PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      this.VersionName = localPackageInfo.versionName;
      this.PackageName = localPackageInfo.packageName;
      this.FilePath = paramContext.getFilesDir().getAbsolutePath();
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
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private final void SaveAsFile(String paramString)
  {
    try
    {
      Object localObject = "stack-".concat(String.valueOf(System.currentTimeMillis())).concat(".stacktrace");
      localObject = new FileOutputStream(this.FilePath.concat("/").concat((String)localObject));
      ((FileOutputStream)localObject).write(paramString.getBytes());
      ((FileOutputStream)localObject).close();
      return;
    }
    catch (IOException paramString) {}
  }
  
  private final void SendErrorMail(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.SEND");
    String str = "[Furnace][Rapport d'erreur][" + this.VersionName + "]";
    paramString = "[Furnace][Rapport d'erreur]\n\n" + paramString + "\n\n";
    localIntent.putExtra("android.intent.extra.EMAIL", new String[] { "supportapp@magmamobile.com" });
    localIntent.putExtra("android.intent.extra.TEXT", paramString);
    localIntent.putExtra("android.intent.extra.SUBJECT", str);
    localIntent.setType("message/rfc822");
    paramContext.startActivity(Intent.createChooser(localIntent, "Title:"));
  }
  
  private final boolean bIsThereAnyErrorFile()
  {
    return GetErrorFileList().length > 0;
  }
  
  private static final long getAvailableInternalMemorySize()
  {
    StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
    long l = localStatFs.getBlockSize();
    return localStatFs.getAvailableBlocks() * l;
  }
  
  private static final long getTotalInternalMemorySize()
  {
    StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
    long l = localStatFs.getBlockSize();
    return localStatFs.getBlockCount() * l;
  }
  
  public final void CheckErrorAndSendMail(final Context paramContext)
  {
    try
    {
      if (bIsThereAnyErrorFile())
      {
        final Object localObject1 = "";
        String[] arrayOfString = GetErrorFileList();
        int k = arrayOfString.length;
        int j = 0;
        int i = 0;
        if (j >= k)
        {
          localObject2 = new AlertDialog.Builder(paramContext);
          ((AlertDialog.Builder)localObject2).setIcon(17301543);
          ((AlertDialog.Builder)localObject2).setMessage("Application has recently crashed. Would you like to send us the bug report ?");
          ((AlertDialog.Builder)localObject2).setTitle("Bug report");
          ((AlertDialog.Builder)localObject2).setCancelable(false);
          ((AlertDialog.Builder)localObject2).setPositiveButton("Yes", new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              ErrorReporter.this.SendErrorMail(paramContext, localObject1);
            }
          });
          ((AlertDialog.Builder)localObject2).setNegativeButton("No", new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              Toast.makeText(paramContext, "Action canceled", 0).show();
            }
          });
          ((AlertDialog.Builder)localObject2).show();
          return;
        }
        String str1 = arrayOfString[j];
        Object localObject2 = localObject1;
        if (i <= 5)
        {
          localObject1 = new StringBuilder(String.valueOf(localObject1)).append("New Trace collected :\n").toString() + "=====================\n ";
          localObject2 = new BufferedReader(new FileReader(this.FilePath + "/" + str1));
        }
        for (;;)
        {
          String str2 = ((BufferedReader)localObject2).readLine();
          if (str2 == null)
          {
            ((BufferedReader)localObject2).close();
            localObject2 = localObject1;
            new File(this.FilePath + "/" + str1).delete();
            j += 1;
            i += 1;
            localObject1 = localObject2;
            break;
          }
          localObject1 = localObject1 + str2 + "\n";
        }
      }
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public final void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    Object localObject = new Date();
    localObject = new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf("")).append("Error Report collected on : ").append(((Date)localObject).toString()).toString())).append("\n").toString())).append("\n").toString())).append("Informations :").toString())).append("\n").toString())).append("==============").toString())).append("\n").toString())).append("\n").toString())).append(CreateInformationString()).toString())).append("\n\n").toString())).append("Stack : \n").toString() + "======= \n";
    StringWriter localStringWriter = new StringWriter();
    PrintWriter localPrintWriter = new PrintWriter(localStringWriter);
    paramThrowable.printStackTrace(localPrintWriter);
    String str = localStringWriter.toString();
    str = new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(localObject)).append(str).toString())).append("\n").toString())).append("Cause : \n").toString() + "======= \n";
    for (localObject = paramThrowable.getCause();; localObject = ((Throwable)localObject).getCause())
    {
      if (localObject == null)
      {
        localPrintWriter.close();
        SaveAsFile(str + "****  End of current Report ***");
        this.PreviousHandler.uncaughtException(paramThread, paramThrowable);
        return;
      }
      ((Throwable)localObject).printStackTrace(localPrintWriter);
      str = str + localStringWriter.toString();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/ErrorReporter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */