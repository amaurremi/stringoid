package com.bluebird.mobile.tools.pictures;

import android.os.Environment;
import java.io.File;
import java.util.Calendar;

public class PictureUtils
{
  public static String generateFileName()
  {
    Calendar localCalendar = Calendar.getInstance();
    return localCalendar.get(1) + "_" + localCalendar.get(2) + "_" + localCalendar.get(5) + "_" + localCalendar.get(11) + "_" + localCalendar.get(12) + "_" + localCalendar.get(13);
  }
  
  public static String getGalleryDir()
  {
    return Environment.getExternalStorageDirectory() + File.separator + Environment.DIRECTORY_DCIM;
  }
  
  /* Error */
  public static void saveBitmapInGallery(android.graphics.Bitmap paramBitmap, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 48	java/io/File
    //   3: dup
    //   4: invokestatic 63	com/bluebird/mobile/tools/pictures/PictureUtils:getGalleryDir	()Ljava/lang/String;
    //   7: aload_1
    //   8: invokespecial 66	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   11: astore_3
    //   12: aload_3
    //   13: invokevirtual 70	java/io/File:mkdirs	()Z
    //   16: pop
    //   17: new 19	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   24: aload_3
    //   25: invokevirtual 73	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   28: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: getstatic 52	java/io/File:separator	Ljava/lang/String;
    //   34: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload_2
    //   38: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: ldc 75
    //   43: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: astore_3
    //   50: new 77	java/io/FileOutputStream
    //   53: dup
    //   54: aload_3
    //   55: invokespecial 80	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   58: astore_3
    //   59: aload_0
    //   60: getstatic 86	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   63: bipush 90
    //   65: aload_3
    //   66: invokevirtual 92	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   69: pop
    //   70: aload_3
    //   71: invokevirtual 95	java/io/FileOutputStream:flush	()V
    //   74: aload_3
    //   75: invokevirtual 98	java/io/FileOutputStream:close	()V
    //   78: return
    //   79: astore_0
    //   80: ldc 100
    //   82: new 19	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   89: ldc 102
    //   91: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: aload_2
    //   95: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: ldc 104
    //   100: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: aload_1
    //   104: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: aload_0
    //   111: invokestatic 110	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   114: pop
    //   115: return
    //   116: astore_0
    //   117: ldc 100
    //   119: new 19	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   126: ldc 102
    //   128: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: aload_2
    //   132: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: ldc 104
    //   137: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload_1
    //   141: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: aload_0
    //   148: invokestatic 110	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   151: pop
    //   152: return
    //   153: astore_0
    //   154: goto -37 -> 117
    //   157: astore_0
    //   158: goto -78 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	paramBitmap	android.graphics.Bitmap
    //   0	161	1	paramString1	String
    //   0	161	2	paramString2	String
    //   11	64	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   50	59	79	java/io/FileNotFoundException
    //   50	59	116	java/io/IOException
    //   59	78	153	java/io/IOException
    //   59	78	157	java/io/FileNotFoundException
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bluebird/mobile/tools/pictures/PictureUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */