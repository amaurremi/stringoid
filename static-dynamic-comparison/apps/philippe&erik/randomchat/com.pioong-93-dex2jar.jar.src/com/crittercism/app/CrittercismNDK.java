package com.crittercism.app;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class CrittercismNDK
{
  private static final String LIBNAME = "libcrittercism-ndk.so";
  private static String LIBPATH;
  private static final int LIBRARYVERSION = 2;
  
  public static native boolean checkLibraryVersion(int paramInt);
  
  public static boolean installLib(Context paramContext)
  {
    Object localObject = "armeabi";
    if (System.getProperty("os.arch").contains("v7")) {
      localObject = "armeabi" + "-v7a";
    }
    try
    {
      new File(LIBPATH).mkdirs();
      FileOutputStream localFileOutputStream = new FileOutputStream(new File(LIBPATH + "libcrittercism-ndk.so"));
      paramContext = paramContext.getAssets().open((String)localObject + "/libcrittercism-ndk.so");
      localObject = new byte[' '];
      for (;;)
      {
        int i = paramContext.read((byte[])localObject);
        if (i < 0) {
          break;
        }
        localFileOutputStream.write((byte[])localObject, 0, i);
      }
      paramContext.close();
      localFileOutputStream.close();
      System.load(LIBPATH + "libcrittercism-ndk.so");
      return true;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  public static native boolean installNdk(String paramString);
  
  public static void installNdkLib(Context paramContext, String paramString)
  {
    LIBPATH = paramContext.getFilesDir().getAbsolutePath() + "/com.crittercism/lib/";
    paramString = paramContext.getFilesDir().getAbsolutePath() + "/" + paramString;
    if (new File(LIBPATH + "libcrittercism-ndk.so").exists()) {}
    for (;;)
    {
      try
      {
        System.load(LIBPATH + "libcrittercism-ndk.so");
        bool = checkLibraryVersion(2);
        if (!bool) {
          installLib(paramContext);
        }
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        try
        {
          if (installNdk(paramString))
          {
            paramContext = new File(paramString);
            paramContext.getAbsolutePath();
            paramContext.mkdirs();
          }
          return;
        }
        catch (Throwable paramContext) {}
        localUnsatisfiedLinkError = localUnsatisfiedLinkError;
        boolean bool = installLib(paramContext);
        continue;
      }
      installLib(paramContext);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/crittercism/app/CrittercismNDK.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */