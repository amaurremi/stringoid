package com.flurry.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import com.flurry.android.monolithic.sdk.impl.h;
import com.flurry.android.monolithic.sdk.impl.ja;
import com.flurry.android.monolithic.sdk.impl.jf;
import java.io.File;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class InstallReceiver
  extends BroadcastReceiver
{
  private final Handler a;
  private File b = null;
  
  public InstallReceiver()
  {
    HandlerThread localHandlerThread = new HandlerThread("InstallReceiver");
    localHandlerThread.start();
    this.a = new Handler(localHandlerThread.getLooper());
  }
  
  private String a()
  {
    return ".flurryinstallreceiver.";
  }
  
  /* Error */
  private String a(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: new 48	java/io/FileInputStream
    //   6: dup
    //   7: aload_1
    //   8: invokespecial 51	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   11: astore 5
    //   13: aload 5
    //   15: astore_3
    //   16: new 53	java/lang/StringBuffer
    //   19: dup
    //   20: invokespecial 54	java/lang/StringBuffer:<init>	()V
    //   23: astore_1
    //   24: aload 5
    //   26: astore_3
    //   27: sipush 1024
    //   30: newarray <illegal type>
    //   32: astore 4
    //   34: aload 5
    //   36: astore_3
    //   37: aload 5
    //   39: aload 4
    //   41: invokevirtual 58	java/io/FileInputStream:read	([B)I
    //   44: istore_2
    //   45: iload_2
    //   46: ifle +60 -> 106
    //   49: aload 5
    //   51: astore_3
    //   52: aload_1
    //   53: new 60	java/lang/String
    //   56: dup
    //   57: aload 4
    //   59: iconst_0
    //   60: iload_2
    //   61: invokespecial 63	java/lang/String:<init>	([BII)V
    //   64: invokevirtual 67	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   67: pop
    //   68: goto -34 -> 34
    //   71: astore 4
    //   73: aload 5
    //   75: astore_3
    //   76: bipush 6
    //   78: ldc 18
    //   80: ldc 69
    //   82: aload 4
    //   84: invokestatic 74	com/flurry/android/monolithic/sdk/impl/ja:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   87: aload 5
    //   89: invokestatic 79	com/flurry/android/monolithic/sdk/impl/je:a	(Ljava/io/Closeable;)V
    //   92: aload 6
    //   94: astore_3
    //   95: aload_1
    //   96: ifnull +8 -> 104
    //   99: aload_1
    //   100: invokevirtual 82	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   103: astore_3
    //   104: aload_3
    //   105: areturn
    //   106: aload 5
    //   108: invokestatic 79	com/flurry/android/monolithic/sdk/impl/je:a	(Ljava/io/Closeable;)V
    //   111: goto -19 -> 92
    //   114: astore_1
    //   115: aconst_null
    //   116: astore_3
    //   117: aload_3
    //   118: invokestatic 79	com/flurry/android/monolithic/sdk/impl/je:a	(Ljava/io/Closeable;)V
    //   121: aload_1
    //   122: athrow
    //   123: astore_1
    //   124: goto -7 -> 117
    //   127: astore 4
    //   129: aconst_null
    //   130: astore_1
    //   131: aconst_null
    //   132: astore 5
    //   134: goto -61 -> 73
    //   137: astore 4
    //   139: aconst_null
    //   140: astore_1
    //   141: goto -68 -> 73
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	this	InstallReceiver
    //   0	144	1	paramFile	File
    //   44	17	2	i	int
    //   15	103	3	localObject1	Object
    //   32	26	4	arrayOfByte	byte[]
    //   71	12	4	localThrowable1	Throwable
    //   127	1	4	localThrowable2	Throwable
    //   137	1	4	localThrowable3	Throwable
    //   11	122	5	localFileInputStream	java.io.FileInputStream
    //   1	92	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   27	34	71	java/lang/Throwable
    //   37	45	71	java/lang/Throwable
    //   52	68	71	java/lang/Throwable
    //   3	13	114	finally
    //   16	24	123	finally
    //   27	34	123	finally
    //   37	45	123	finally
    //   52	68	123	finally
    //   76	87	123	finally
    //   3	13	127	java/lang/Throwable
    //   16	24	137	java/lang/Throwable
  }
  
  public static Map<String, List<String>> a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    String[] arrayOfString = paramString.split("&");
    int j = arrayOfString.length;
    int i = 0;
    if (i < j)
    {
      Object localObject = arrayOfString[i].split("=");
      if (localObject.length != 2) {
        ja.a(5, "InstallReceiver", "Invalid referrer Element: " + arrayOfString[i] + " in referrer tag " + paramString);
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
      ja.a(5, "InstallReceiver", "Detected missing referrer keys : " + paramString.toString());
    }
    return localHashMap;
  }
  
  private void a(jf paramjf)
  {
    this.a.post(paramjf);
  }
  
  private void b(String paramString)
  {
    try
    {
      a(new h(this, paramString));
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    ja.a(4, "InstallReceiver", "Received an Install nofication of " + paramIntent.getAction());
    this.b = paramContext.getFileStreamPath(a());
    ja.a(4, "InstallReceiver", "fInstallReceiverFile is " + this.b);
    String str = paramIntent.getExtras().getString("referrer");
    ja.a(4, "InstallReceiver", "Received an Install referrer of " + str);
    if ((str == null) || (!"com.android.vending.INSTALL_REFERRER".equals(paramIntent.getAction())))
    {
      ja.a(5, "InstallReceiver", "referrer is null");
      return;
    }
    paramContext = str;
    if (!str.contains("="))
    {
      ja.a(4, "InstallReceiver", "referrer is before decoding: " + str);
      paramContext = URLDecoder.decode(str);
      ja.a(4, "InstallReceiver", "referrer is: " + paramContext);
    }
    b(paramContext);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/InstallReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */