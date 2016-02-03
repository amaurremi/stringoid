package com.scoreloop.client.android.core.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public abstract class Logger
{
  private static final String a = File.separator + "sdcard" + File.separator + "scoreloop" + File.separator;
  
  public static void a(String paramString)
  {
    a("Scoreloop", paramString);
  }
  
  public static void a(String paramString1, String paramString2) {}
  
  public static void a(String paramString1, String paramString2, Exception paramException) {}
  
  public static void b(String paramString)
  {
    b("Scoreloop", paramString);
  }
  
  public static void b(String paramString1, String paramString2) {}
  
  public static void c(String paramString)
  {
    c("Scoreloop", paramString);
  }
  
  public static void c(String paramString1, String paramString2) {}
  
  public static void d(String paramString1, String paramString2)
    throws IOException
  {
    Object localObject = new File(a);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    paramString1 = ((File)localObject).getAbsolutePath() + File.separator + paramString1 + "_" + System.currentTimeMillis() + ".log";
    localObject = new File(paramString1);
    ((File)localObject).createNewFile();
    localObject = new FileWriter((File)localObject);
    a("printTOSDCard", "printing to:" + paramString1);
    ((FileWriter)localObject).append(paramString2);
    ((FileWriter)localObject).flush();
    ((FileWriter)localObject).close();
    a("printTOSDCard", "print to:" + paramString1 + " finished");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/utils/Logger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */