package com.inmobi.commons.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class IMFileOperations
{
  public static boolean getBooleanPreferences(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramContext == null) || (paramString1 == null) || (paramString2 == null) || ("".equals(paramString1.trim())) || ("".equals(paramString2.trim())))
    {
      IMLog.debug("IMCOMMONS_3.6.1", "Failed to get preferences..App context NULL");
      return false;
    }
    return paramContext.getSharedPreferences(paramString1, 0).getBoolean(paramString2, false);
  }
  
  public static int getIntPreferences(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramContext == null) || (paramString1 == null) || (paramString2 == null) || ("".equals(paramString1.trim())) || ("".equals(paramString2.trim())))
    {
      IMLog.debug("IMCOMMONS_3.6.1", "Failed to get preferences..App context NULL");
      return 0;
    }
    return paramContext.getSharedPreferences(paramString1, 0).getInt(paramString2, 0);
  }
  
  public static String getPreferences(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramContext == null) || (paramString1 == null) || (paramString2 == null) || ("".equals(paramString1.trim())) || ("".equals(paramString2.trim())))
    {
      IMLog.debug("IMCOMMONS_3.6.1", "Failed to get preferences..App context NULL");
      return null;
    }
    return paramContext.getSharedPreferences(paramString1, 0).getString(paramString2, null);
  }
  
  /* Error */
  public static Object readFromFile(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +19 -> 20
    //   4: aload_1
    //   5: ifnull +15 -> 20
    //   8: ldc 13
    //   10: aload_1
    //   11: invokevirtual 19	java/lang/String:trim	()Ljava/lang/String;
    //   14: invokevirtual 23	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   17: ifeq +12 -> 29
    //   20: ldc 25
    //   22: ldc 71
    //   24: invokestatic 74	com/inmobi/commons/internal/IMLog:internal	(Ljava/lang/String;Ljava/lang/String;)V
    //   27: aconst_null
    //   28: areturn
    //   29: new 76	java/io/File
    //   32: dup
    //   33: aload_0
    //   34: ldc 78
    //   36: iconst_0
    //   37: invokevirtual 82	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   40: aload_1
    //   41: invokespecial 85	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   44: astore_0
    //   45: new 87	java/io/FileInputStream
    //   48: dup
    //   49: aload_0
    //   50: invokespecial 90	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   53: astore_0
    //   54: new 92	java/io/ObjectInputStream
    //   57: dup
    //   58: aload_0
    //   59: invokespecial 95	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   62: astore_0
    //   63: aload_0
    //   64: invokevirtual 99	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   67: astore_1
    //   68: aload_0
    //   69: invokevirtual 102	java/io/ObjectInputStream:close	()V
    //   72: aload_1
    //   73: areturn
    //   74: astore_0
    //   75: ldc 25
    //   77: ldc 104
    //   79: invokestatic 74	com/inmobi/commons/internal/IMLog:internal	(Ljava/lang/String;Ljava/lang/String;)V
    //   82: iconst_0
    //   83: invokestatic 110	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   86: areturn
    //   87: astore_0
    //   88: ldc 25
    //   90: ldc 112
    //   92: aload_0
    //   93: invokestatic 115	com/inmobi/commons/internal/IMLog:internal	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   96: aconst_null
    //   97: areturn
    //   98: astore_0
    //   99: ldc 25
    //   101: ldc 117
    //   103: aload_0
    //   104: invokestatic 115	com/inmobi/commons/internal/IMLog:internal	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   107: aconst_null
    //   108: areturn
    //   109: astore_0
    //   110: ldc 25
    //   112: ldc 119
    //   114: aload_0
    //   115: invokestatic 115	com/inmobi/commons/internal/IMLog:internal	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   118: aconst_null
    //   119: areturn
    //   120: astore_0
    //   121: ldc 25
    //   123: ldc 121
    //   125: aload_0
    //   126: invokestatic 115	com/inmobi/commons/internal/IMLog:internal	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   129: aconst_null
    //   130: areturn
    //   131: astore_0
    //   132: ldc 25
    //   134: ldc 123
    //   136: aload_0
    //   137: invokestatic 115	com/inmobi/commons/internal/IMLog:internal	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   140: aconst_null
    //   141: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	paramContext	Context
    //   0	142	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   68	72	74	java/io/IOException
    //   45	54	87	java/io/FileNotFoundException
    //   54	63	98	java/io/StreamCorruptedException
    //   54	63	109	java/io/IOException
    //   63	68	120	java/io/EOFException
    //   63	68	131	java/lang/Exception
  }
  
  /* Error */
  public static boolean saveToFile(Context paramContext, String paramString, Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +23 -> 24
    //   4: aload_1
    //   5: ifnull +19 -> 24
    //   8: ldc 13
    //   10: aload_1
    //   11: invokevirtual 19	java/lang/String:trim	()Ljava/lang/String;
    //   14: invokevirtual 23	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   17: ifne +7 -> 24
    //   20: aload_2
    //   21: ifnonnull +12 -> 33
    //   24: ldc 25
    //   26: ldc 127
    //   28: invokestatic 74	com/inmobi/commons/internal/IMLog:internal	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: iconst_0
    //   32: ireturn
    //   33: new 76	java/io/File
    //   36: dup
    //   37: aload_0
    //   38: ldc 78
    //   40: iconst_0
    //   41: invokevirtual 82	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   44: aload_1
    //   45: invokespecial 85	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   48: astore_0
    //   49: new 129	java/io/ObjectOutputStream
    //   52: dup
    //   53: new 131	java/io/FileOutputStream
    //   56: dup
    //   57: aload_0
    //   58: iconst_0
    //   59: invokespecial 134	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   62: invokespecial 137	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   65: astore_0
    //   66: aload_0
    //   67: aload_2
    //   68: invokevirtual 141	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   71: aload_0
    //   72: invokevirtual 144	java/io/ObjectOutputStream:flush	()V
    //   75: aload_0
    //   76: invokevirtual 145	java/io/ObjectOutputStream:close	()V
    //   79: iconst_1
    //   80: ireturn
    //   81: astore_0
    //   82: ldc 25
    //   84: ldc -109
    //   86: aload_0
    //   87: invokestatic 115	com/inmobi/commons/internal/IMLog:internal	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   90: iconst_0
    //   91: ireturn
    //   92: astore_0
    //   93: ldc 25
    //   95: ldc -107
    //   97: aload_0
    //   98: invokestatic 115	com/inmobi/commons/internal/IMLog:internal	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   101: iconst_0
    //   102: ireturn
    //   103: astore_0
    //   104: ldc 25
    //   106: ldc -105
    //   108: aload_0
    //   109: invokestatic 115	com/inmobi/commons/internal/IMLog:internal	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   112: iconst_0
    //   113: ireturn
    //   114: astore_0
    //   115: ldc 25
    //   117: ldc -107
    //   119: aload_0
    //   120: invokestatic 115	com/inmobi/commons/internal/IMLog:internal	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   123: iconst_0
    //   124: ireturn
    //   125: astore_0
    //   126: ldc 25
    //   128: ldc 104
    //   130: invokestatic 74	com/inmobi/commons/internal/IMLog:internal	(Ljava/lang/String;Ljava/lang/String;)V
    //   133: iconst_0
    //   134: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	paramContext	Context
    //   0	135	1	paramString	String
    //   0	135	2	paramObject	Object
    // Exception table:
    //   from	to	target	type
    //   49	66	81	java/io/FileNotFoundException
    //   49	66	92	java/io/IOException
    //   66	71	103	java/io/IOException
    //   71	75	114	java/io/IOException
    //   75	79	125	java/io/IOException
  }
  
  public static void setPreferences(Context paramContext, String paramString1, String paramString2, float paramFloat)
  {
    if ((paramContext == null) || (paramString1 == null) || (paramString2 == null) || ("".equals(paramString1.trim())) || ("".equals(paramString2.trim())))
    {
      IMLog.debug("IMCOMMONS_3.6.1", "Failed to set preferences..App context NULL");
      return;
    }
    paramContext = paramContext.getSharedPreferences(paramString1, 0).edit();
    paramContext.putFloat(paramString2, paramFloat);
    paramContext.commit();
  }
  
  public static void setPreferences(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    if ((paramContext == null) || (paramString1 == null) || (paramString2 == null) || ("".equals(paramString1.trim())) || ("".equals(paramString2.trim())))
    {
      IMLog.debug("IMCOMMONS_3.6.1", "Failed to set preferences..App context NULL");
      return;
    }
    paramContext = paramContext.getSharedPreferences(paramString1, 0).edit();
    paramContext.putInt(paramString2, paramInt);
    paramContext.commit();
  }
  
  public static void setPreferences(Context paramContext, String paramString1, String paramString2, long paramLong)
  {
    if ((paramContext == null) || (paramString1 == null) || (paramString2 == null) || ("".equals(paramString1.trim())) || ("".equals(paramString2.trim())))
    {
      IMLog.debug("IMCOMMONS_3.6.1", "Failed to set preferences..App context NULL");
      return;
    }
    paramContext = paramContext.getSharedPreferences(paramString1, 0).edit();
    paramContext.putLong(paramString2, paramLong);
    paramContext.commit();
  }
  
  public static void setPreferences(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramContext == null) || (paramString1 == null) || (paramString2 == null) || ("".equals(paramString1.trim())) || ("".equals(paramString2.trim())))
    {
      IMLog.debug("IMCOMMONS_3.6.1", "Failed to set preferences..App context NULL");
      return;
    }
    paramContext = paramContext.getSharedPreferences(paramString1, 0).edit();
    paramContext.putBoolean(paramString2, paramBoolean);
    paramContext.commit();
  }
  
  public static boolean setPreferences(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if ((paramContext == null) || (paramString1 == null) || (paramString2 == null) || ("".equals(paramString1.trim())) || ("".equals(paramString2.trim())))
    {
      IMLog.internal("IMCOMMONS_3.6.1", "Failed to set preferences..App context NULL");
      return false;
    }
    paramContext = paramContext.getSharedPreferences(paramString1, 0).edit();
    paramContext.putString(paramString2, paramString3);
    paramContext.commit();
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/inmobi/commons/internal/IMFileOperations.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */