package logo.quiz.commons.utils.image;

import android.media.ExifInterface;
import android.os.Bundle;
import java.io.IOException;

public class ExifUtils
{
  public static final String[] EXIF_TAGS = { "FNumber", "DateTime", "ExposureTime", "Flash", "FocalLength", "GPSAltitude", "GPSAltitudeRef", "GPSDateStamp", "GPSLatitude", "GPSLatitudeRef", "GPSLongitude", "GPSLongitudeRef", "GPSProcessingMethod", "GPSTimeStamp", "ImageLength", "ImageWidth", "ISOSpeedRatings", "Make", "Model", "WhiteBalance" };
  
  /* Error */
  public static int getExifOrientation(android.content.Context paramContext, android.net.Uri paramUri)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_1
    //   3: invokevirtual 68	android/net/Uri:getScheme	()Ljava/lang/String;
    //   6: astore 5
    //   8: aload 5
    //   10: ifnull +13 -> 23
    //   13: ldc 70
    //   15: aload 5
    //   17: invokevirtual 74	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   20: ifeq +13 -> 33
    //   23: aload_1
    //   24: invokevirtual 77	android/net/Uri:getPath	()Ljava/lang/String;
    //   27: invokestatic 80	logo/quiz/commons/utils/image/ExifUtils:getExifOrientation	(Ljava/lang/String;)I
    //   30: istore_2
    //   31: iload_2
    //   32: ireturn
    //   33: iload_3
    //   34: istore_2
    //   35: aload 5
    //   37: ldc 82
    //   39: invokevirtual 74	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   42: ifeq -11 -> 31
    //   45: aload_0
    //   46: invokevirtual 88	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   49: aload_1
    //   50: invokevirtual 94	android/content/ContentResolver:acquireContentProviderClient	(Landroid/net/Uri;)Landroid/content/ContentProviderClient;
    //   53: astore_0
    //   54: iload_3
    //   55: istore_2
    //   56: aload_0
    //   57: ifnull -26 -> 31
    //   60: aload_0
    //   61: aload_1
    //   62: iconst_2
    //   63: anewarray 10	java/lang/String
    //   66: dup
    //   67: iconst_0
    //   68: ldc 96
    //   70: aastore
    //   71: dup
    //   72: iconst_1
    //   73: ldc 98
    //   75: aastore
    //   76: aconst_null
    //   77: aconst_null
    //   78: aconst_null
    //   79: invokevirtual 104	android/content/ContentProviderClient:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   82: astore_0
    //   83: iload_3
    //   84: istore_2
    //   85: aload_0
    //   86: ifnull -55 -> 31
    //   89: aload_0
    //   90: ldc 96
    //   92: invokeinterface 109 2 0
    //   97: istore_3
    //   98: aload_0
    //   99: ldc 98
    //   101: invokeinterface 109 2 0
    //   106: istore 4
    //   108: aload_0
    //   109: invokeinterface 113 1 0
    //   114: ifle +67 -> 181
    //   117: aload_0
    //   118: invokeinterface 117 1 0
    //   123: pop
    //   124: iconst_0
    //   125: istore_2
    //   126: iload_3
    //   127: iconst_m1
    //   128: if_icmple +11 -> 139
    //   131: aload_0
    //   132: iload_3
    //   133: invokeinterface 121 2 0
    //   138: istore_2
    //   139: iload_2
    //   140: istore_3
    //   141: iload 4
    //   143: iconst_m1
    //   144: if_icmple +19 -> 163
    //   147: aload_0
    //   148: iload 4
    //   150: invokeinterface 125 2 0
    //   155: invokestatic 80	logo/quiz/commons/utils/image/ExifUtils:getExifOrientation	(Ljava/lang/String;)I
    //   158: istore_3
    //   159: iload_2
    //   160: iload_3
    //   161: ior
    //   162: istore_3
    //   163: aload_0
    //   164: invokeinterface 128 1 0
    //   169: iload_3
    //   170: ireturn
    //   171: astore_0
    //   172: iconst_0
    //   173: ireturn
    //   174: astore_0
    //   175: aload_0
    //   176: invokevirtual 131	java/lang/Exception:printStackTrace	()V
    //   179: iconst_0
    //   180: ireturn
    //   181: aload_0
    //   182: invokeinterface 128 1 0
    //   187: iconst_0
    //   188: ireturn
    //   189: astore_1
    //   190: aload_0
    //   191: invokeinterface 128 1 0
    //   196: aload_1
    //   197: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	paramContext	android.content.Context
    //   0	198	1	paramUri	android.net.Uri
    //   30	132	2	i	int
    //   1	169	3	j	int
    //   106	43	4	k	int
    //   6	30	5	str	String
    // Exception table:
    //   from	to	target	type
    //   45	54	171	java/lang/SecurityException
    //   60	83	174	java/lang/Exception
    //   108	124	189	finally
    //   131	139	189	finally
    //   147	159	189	finally
  }
  
  public static int getExifOrientation(ExifInterface paramExifInterface)
  {
    int i;
    if (paramExifInterface != null)
    {
      i = paramExifInterface.getAttributeInt("Orientation", -1);
      if (i == -1) {}
    }
    switch (i)
    {
    case 4: 
    case 5: 
    case 7: 
    default: 
      return 0;
    case 6: 
      return 90;
    case 3: 
      return 180;
    }
    return 270;
  }
  
  public static int getExifOrientation(String paramString)
  {
    if (paramString == null) {
      return 0;
    }
    try
    {
      paramString = new ExifInterface(paramString);
      return getExifOrientation(paramString);
    }
    catch (IOException paramString) {}
    return 0;
  }
  
  public static String getExifOrientation(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new AssertionError("invalid: " + paramInt);
    case 0: 
      return String.valueOf(1);
    case 90: 
      return String.valueOf(6);
    case 180: 
      return String.valueOf(3);
    }
    return String.valueOf(8);
  }
  
  public static boolean loadAttributes(String paramString, Bundle paramBundle)
  {
    try
    {
      paramString = new ExifInterface(paramString);
      String[] arrayOfString = EXIF_TAGS;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        paramBundle.putString(str, paramString.getAttribute(str));
        i += 1;
      }
      return true;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
      return false;
    }
  }
  
  public static boolean saveAttributes(String paramString, Bundle paramBundle)
  {
    try
    {
      paramString = new ExifInterface(paramString);
      String[] arrayOfString = EXIF_TAGS;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        if (paramBundle.containsKey(str)) {
          paramString.setAttribute(str, paramBundle.getString(str));
        }
        i += 1;
      }
      try
      {
        paramString.saveAttributes();
        return true;
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
      }
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
      return false;
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/utils/image/ExifUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */