package com.flurry.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import java.io.File;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class InstallReceiver
  extends BroadcastReceiver
{
  private final Handler aG;
  private File eq = null;
  
  public InstallReceiver()
  {
    HandlerThread localHandlerThread = new HandlerThread("InstallReceiver");
    localHandlerThread.start();
    this.aG = new Handler(localHandlerThread.getLooper());
  }
  
  /* Error */
  private static String a(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: new 43	java/io/FileInputStream
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 46	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   11: astore 4
    //   13: aload 4
    //   15: astore_2
    //   16: new 48	java/lang/StringBuffer
    //   19: dup
    //   20: invokespecial 49	java/lang/StringBuffer:<init>	()V
    //   23: astore_0
    //   24: aload 4
    //   26: astore_2
    //   27: sipush 1024
    //   30: newarray <illegal type>
    //   32: astore_3
    //   33: aload 4
    //   35: astore_2
    //   36: aload 4
    //   38: aload_3
    //   39: invokevirtual 53	java/io/FileInputStream:read	([B)I
    //   42: istore_1
    //   43: iload_1
    //   44: ifle +55 -> 99
    //   47: aload 4
    //   49: astore_2
    //   50: aload_0
    //   51: new 55	java/lang/String
    //   54: dup
    //   55: aload_3
    //   56: iconst_0
    //   57: iload_1
    //   58: invokespecial 58	java/lang/String:<init>	([BII)V
    //   61: invokevirtual 62	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   64: pop
    //   65: goto -32 -> 33
    //   68: astore_3
    //   69: aload 4
    //   71: astore_2
    //   72: ldc 18
    //   74: ldc 64
    //   76: aload_3
    //   77: invokestatic 70	com/flurry/android/db:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   80: aload 4
    //   82: invokestatic 75	com/flurry/android/bd:a	(Ljava/io/Closeable;)V
    //   85: aload 5
    //   87: astore_2
    //   88: aload_0
    //   89: ifnull +8 -> 97
    //   92: aload_0
    //   93: invokevirtual 79	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   96: astore_2
    //   97: aload_2
    //   98: areturn
    //   99: aload 4
    //   101: invokestatic 75	com/flurry/android/bd:a	(Ljava/io/Closeable;)V
    //   104: goto -19 -> 85
    //   107: astore_0
    //   108: aconst_null
    //   109: astore_2
    //   110: aload_2
    //   111: invokestatic 75	com/flurry/android/bd:a	(Ljava/io/Closeable;)V
    //   114: aload_0
    //   115: athrow
    //   116: astore_0
    //   117: goto -7 -> 110
    //   120: astore_3
    //   121: aconst_null
    //   122: astore_0
    //   123: aconst_null
    //   124: astore 4
    //   126: goto -57 -> 69
    //   129: astore_3
    //   130: aconst_null
    //   131: astore_0
    //   132: goto -63 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	paramFile	File
    //   42	16	1	i	int
    //   15	96	2	localObject1	Object
    //   32	24	3	arrayOfByte	byte[]
    //   68	9	3	localThrowable1	Throwable
    //   120	1	3	localThrowable2	Throwable
    //   129	1	3	localThrowable3	Throwable
    //   11	114	4	localFileInputStream	java.io.FileInputStream
    //   1	85	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   27	33	68	java/lang/Throwable
    //   36	43	68	java/lang/Throwable
    //   50	65	68	java/lang/Throwable
    //   3	13	107	finally
    //   16	24	116	finally
    //   27	33	116	finally
    //   36	43	116	finally
    //   50	65	116	finally
    //   72	80	116	finally
    //   3	13	120	java/lang/Throwable
    //   16	24	129	java/lang/Throwable
  }
  
  static Map<String, List<String>> e(String paramString)
  {
    HashMap localHashMap = new HashMap();
    String[] arrayOfString = paramString.split("&");
    int j = arrayOfString.length;
    int i = 0;
    if (i < j)
    {
      Object localObject = arrayOfString[i].split("=");
      if (localObject.length != 2) {
        db.c("InstallReceiver", "Invalid referrer Element: " + arrayOfString[i] + " in referrer tag " + paramString);
      }
      for (;;)
      {
        i += 1;
        break;
        String str = URLDecoder.decode(localObject[0]);
        localObject = URLDecoder.decode(localObject[1]);
        if (localHashMap.get(str) == null) {
          localHashMap.put(str, new ArrayList());
        }
        ((List)localHashMap.get(str)).add(localObject);
      }
    }
    paramString = new StringBuilder();
    if (localHashMap.get("utm_source") == null) {
      paramString.append("Campaign Source is missing.\n");
    }
    if (localHashMap.get("utm_medium") == null) {
      paramString.append("Campaign Medium is missing.\n");
    }
    if (localHashMap.get("utm_campaign") == null) {
      paramString.append("Campaign Name is missing.\n");
    }
    if (paramString.length() > 0) {
      Log.w("Detected missing referrer keys", paramString.toString());
    }
    return localHashMap;
  }
  
  private void x(String paramString)
  {
    try
    {
      paramString = new cj(this, paramString);
      this.aG.post(paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    db.e("InstallReceiver", "Received an Install nofication of " + paramIntent.getAction());
    this.eq = paramContext.getFileStreamPath(".flurryinstallreceiver.");
    db.e("InstallReceiver", "fInstallReceiverFile is " + this.eq);
    if (FlurryAgent.isCaptureUncaughtExceptions()) {
      Thread.setDefaultUncaughtExceptionHandler(new FlurryAgent.FlurryDefaultExceptionHandler());
    }
    String str = paramIntent.getExtras().getString("referrer");
    db.e("InstallReceiver", "Received an Install referrer of " + str);
    if ((str == null) || (!"com.android.vending.INSTALL_REFERRER".equals(paramIntent.getAction())))
    {
      db.e("InstallReceiver", "referrer is null");
      return;
    }
    paramContext = str;
    if (!str.contains("="))
    {
      db.e("InstallReceiver", "referrer is before decoding: " + str);
      paramContext = URLDecoder.decode(str);
      db.e("InstallReceiver", "referrer is: " + paramContext);
    }
    x(paramContext);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/InstallReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */