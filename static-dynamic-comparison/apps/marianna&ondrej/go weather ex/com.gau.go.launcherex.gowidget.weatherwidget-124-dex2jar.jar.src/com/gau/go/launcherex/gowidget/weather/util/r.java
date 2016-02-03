package com.gau.go.launcherex.gowidget.weather.util;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.text.format.Time;
import android.view.View;
import android.widget.Toast;
import com.gau.go.launcherex.gowidget.weather.model.ForecastBean;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import com.gtp.a.a.b.c;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class r
{
  public static float a(float paramFloat)
  {
    if (paramFloat < 10000.0F) {
      return paramFloat;
    }
    return -10000.0F;
  }
  
  public static float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return Math.max(Math.min(paramFloat1, paramFloat3), paramFloat2);
  }
  
  public static int a(int paramInt, float paramFloat)
  {
    return (int)(paramInt * paramFloat);
  }
  
  public static int a(int paramInt, boolean paramBoolean)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 2: 
      if (paramBoolean) {
        return 1;
      }
      return 2;
    case 3: 
      if (paramBoolean) {
        return 3;
      }
      return 4;
    case 4: 
      return 5;
    case 5: 
      return 6;
    case 6: 
      return 7;
    case 7: 
      return 8;
    }
    return 9;
  }
  
  public static int a(int paramInt, int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length >= 10)) {
      switch (paramInt)
      {
      default: 
        paramInt = paramArrayOfInt[0];
      }
    }
    for (;;)
    {
      int i = paramInt;
      if (paramInt == 0)
      {
        i = paramInt;
        if (paramArrayOfInt[0] != 0) {
          i = paramArrayOfInt[0];
        }
      }
      return i;
      paramInt = paramArrayOfInt[0];
      continue;
      paramInt = paramArrayOfInt[1];
      continue;
      paramInt = paramArrayOfInt[2];
      continue;
      paramInt = paramArrayOfInt[3];
      continue;
      paramInt = paramArrayOfInt[4];
      continue;
      paramInt = paramArrayOfInt[5];
      continue;
      paramInt = paramArrayOfInt[6];
      continue;
      paramInt = paramArrayOfInt[7];
      continue;
      paramInt = paramArrayOfInt[8];
      continue;
      paramInt = paramArrayOfInt[9];
      continue;
      paramInt = 0;
    }
  }
  
  public static int a(Context paramContext)
  {
    paramContext = paramContext.getResources().getConfiguration().locale;
    if ((paramContext.getCountry().indexOf("CN") != -1) && (paramContext.getLanguage().equalsIgnoreCase("zh"))) {
      return 1;
    }
    return 2;
  }
  
  public static int a(Bundle paramBundle, String paramString)
  {
    int i = 0;
    try
    {
      int j = Integer.parseInt(paramBundle.getString(paramString));
      i = j;
    }
    catch (Exception paramBundle)
    {
      while (!c.a()) {}
      paramBundle.printStackTrace();
    }
    return i;
    return 0;
  }
  
  /* Error */
  public static int a(boolean paramBoolean, String paramString)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_2
    //   2: bipush 6
    //   4: istore 5
    //   6: aload_1
    //   7: invokestatic 90	com/gau/go/launcherex/gowidget/weather/util/r:a	(Ljava/lang/String;)Z
    //   10: ifeq +209 -> 219
    //   13: aload_1
    //   14: ldc 92
    //   16: invokevirtual 96	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   19: astore_1
    //   20: aload_1
    //   21: ifnull +188 -> 209
    //   24: aload_1
    //   25: arraylength
    //   26: iconst_2
    //   27: if_icmpne +182 -> 209
    //   30: aload_1
    //   31: iconst_0
    //   32: aaload
    //   33: invokestatic 78	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   36: istore_3
    //   37: aload_1
    //   38: iconst_1
    //   39: aaload
    //   40: invokestatic 78	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   43: istore 4
    //   45: iload 4
    //   47: istore_2
    //   48: iload_2
    //   49: ifle +139 -> 188
    //   52: iconst_1
    //   53: istore_2
    //   54: iload_2
    //   55: iload_3
    //   56: iadd
    //   57: istore_2
    //   58: iload_2
    //   59: bipush 24
    //   61: if_icmpne +132 -> 193
    //   64: iconst_0
    //   65: istore_2
    //   66: iload_2
    //   67: ireturn
    //   68: astore_1
    //   69: aconst_null
    //   70: astore_1
    //   71: goto -51 -> 20
    //   74: astore 6
    //   76: iconst_m1
    //   77: istore 4
    //   79: aload_1
    //   80: iconst_1
    //   81: aload_1
    //   82: iconst_1
    //   83: aaload
    //   84: invokevirtual 99	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   87: aastore
    //   88: aload_1
    //   89: iconst_1
    //   90: aaload
    //   91: ldc 101
    //   93: invokevirtual 105	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   96: ifeq +31 -> 127
    //   99: aload_1
    //   100: iconst_1
    //   101: aaload
    //   102: iconst_0
    //   103: aload_1
    //   104: iconst_1
    //   105: aaload
    //   106: ldc 101
    //   108: invokevirtual 55	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   111: invokevirtual 109	java/lang/String:substring	(II)Ljava/lang/String;
    //   114: invokevirtual 112	java/lang/String:trim	()Ljava/lang/String;
    //   117: invokestatic 78	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   120: istore_2
    //   121: iload 4
    //   123: istore_3
    //   124: goto -76 -> 48
    //   127: iload 4
    //   129: istore_3
    //   130: aload_1
    //   131: iconst_1
    //   132: aaload
    //   133: ldc 114
    //   135: invokevirtual 105	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   138: ifeq -90 -> 48
    //   141: aload_1
    //   142: iconst_1
    //   143: aaload
    //   144: iconst_0
    //   145: aload_1
    //   146: iconst_1
    //   147: aaload
    //   148: ldc 114
    //   150: invokevirtual 55	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   153: invokevirtual 109	java/lang/String:substring	(II)Ljava/lang/String;
    //   156: invokevirtual 112	java/lang/String:trim	()Ljava/lang/String;
    //   159: invokestatic 78	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   162: istore_2
    //   163: iload 4
    //   165: bipush 12
    //   167: iadd
    //   168: istore_3
    //   169: goto -121 -> 48
    //   172: astore_1
    //   173: iload_0
    //   174: ifeq +8 -> 182
    //   177: bipush 6
    //   179: istore_2
    //   180: iload_2
    //   181: ireturn
    //   182: bipush 18
    //   184: istore_2
    //   185: goto -5 -> 180
    //   188: iconst_0
    //   189: istore_2
    //   190: goto -136 -> 54
    //   193: iload_2
    //   194: bipush 24
    //   196: if_icmple +41 -> 237
    //   199: iload 5
    //   201: istore_2
    //   202: iload_0
    //   203: ifne -137 -> 66
    //   206: bipush 18
    //   208: ireturn
    //   209: iload 5
    //   211: istore_2
    //   212: iload_0
    //   213: ifne -147 -> 66
    //   216: bipush 18
    //   218: ireturn
    //   219: iload 5
    //   221: istore_2
    //   222: iload_0
    //   223: ifne -157 -> 66
    //   226: bipush 18
    //   228: ireturn
    //   229: astore 6
    //   231: iload_3
    //   232: istore 4
    //   234: goto -155 -> 79
    //   237: iload_2
    //   238: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	239	0	paramBoolean	boolean
    //   0	239	1	paramString	String
    //   1	237	2	i	int
    //   36	196	3	j	int
    //   43	190	4	k	int
    //   4	216	5	m	int
    //   74	1	6	localException1	Exception
    //   229	1	6	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   13	20	68	java/lang/Exception
    //   30	37	74	java/lang/Exception
    //   79	121	172	java/lang/Exception
    //   130	163	172	java/lang/Exception
    //   37	45	229	java/lang/Exception
  }
  
  public static int a(int[] paramArrayOfInt, int paramInt, boolean paramBoolean)
  {
    int i = paramArrayOfInt[0];
    switch (paramInt)
    {
    default: 
      return paramArrayOfInt[0];
    case 2: 
      if (paramBoolean) {
        return paramArrayOfInt[1];
      }
      return paramArrayOfInt[2];
    case 3: 
      if (paramBoolean) {
        return paramArrayOfInt[3];
      }
      return paramArrayOfInt[4];
    case 4: 
      return paramArrayOfInt[5];
    case 5: 
      return paramArrayOfInt[6];
    case 6: 
      return paramArrayOfInt[7];
    case 7: 
      return paramArrayOfInt[8];
    }
    return paramArrayOfInt[9];
  }
  
  public static Intent a(Context paramContext, String paramString1, String paramString2)
  {
    j = 0;
    Object localObject = null;
    i = j;
    if (!TextUtils.isEmpty(paramString1)) {}
    try
    {
      paramContext.getPackageManager().getPackageInfo(paramString1, 0);
      i = 1;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        i = j;
      }
    }
    paramContext = (Context)localObject;
    if (i != 0)
    {
      paramContext = (Context)localObject;
      if (!TextUtils.isEmpty(paramString2))
      {
        paramContext = new Intent("android.intent.action.MAIN");
        paramContext.addFlags(268435456);
        paramContext.setComponent(new ComponentName(paramString1, paramString2));
      }
    }
    return paramContext;
  }
  
  public static Bitmap a(Bitmap paramBitmap, float paramFloat)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(paramFloat, paramFloat);
    return Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, true);
  }
  
  public static Bitmap a(Bitmap[] paramArrayOfBitmap, int paramInt)
  {
    if ((paramArrayOfBitmap == null) || (paramArrayOfBitmap.length == 0)) {
      return null;
    }
    if (paramInt >= paramArrayOfBitmap.length) {
      return paramArrayOfBitmap[0];
    }
    return paramArrayOfBitmap[paramInt];
  }
  
  public static String a(int paramInt)
  {
    Object localObject = new Time();
    ((Time)localObject).setToNow();
    if (paramInt == 2)
    {
      localObject = ((Time)localObject).format("%m/%d/%Y");
      return (String)localObject + " ";
    }
    if (paramInt == 3)
    {
      localObject = ((Time)localObject).format("%d/%m/%Y");
      return (String)localObject + " ";
    }
    localObject = ((Time)localObject).format("%Y/%m/%d");
    return (String)localObject + " ";
  }
  
  public static String a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    String str1;
    if (paramInt2 < 10)
    {
      str1 = "0" + paramInt2;
      label27:
      if (paramInt3 >= 10) {
        break label119;
      }
    }
    label119:
    for (String str2 = "0" + paramInt3;; str2 = String.valueOf(paramInt3)) {
      switch (paramInt4)
      {
      default: 
        if (!paramBoolean) {
          break label222;
        }
        return "%Y/%m/%d".replaceFirst("%Y", String.valueOf(paramInt1)).replaceFirst("%m", str1).replaceFirst("%d", str2);
        str1 = String.valueOf(paramInt2);
        break label27;
      }
    }
    if (paramBoolean) {
      return "%m/%d/%Y".replaceFirst("%Y", String.valueOf(paramInt1)).replaceFirst("%m", str1).replaceFirst("%d", str2);
    }
    return "%m/%d".replaceFirst("%m", str1).replaceFirst("%d", str2);
    if (paramBoolean) {
      return "%d/%m/%Y".replaceFirst("%Y", String.valueOf(paramInt1)).replaceFirst("%m", str1).replaceFirst("%d", str2);
    }
    return "%d/%m".replaceFirst("%m", str1).replaceFirst("%d", str2);
    label222:
    return "%m/%d".replaceFirst("%m", str1).replaceFirst("%d", str2);
  }
  
  public static String a(Context paramContext, long paramLong)
  {
    if ((paramLong == -10000L) || (paramLong == 0L)) {
      return "-10000";
    }
    for (;;)
    {
      try
      {
        long l1 = Calendar.getInstance().getTimeInMillis() - paramLong;
        long l2 = l1 / 3600000L;
        if (b(paramContext))
        {
          localObject = "HH:mm";
          SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat((String)localObject, Locale.ENGLISH);
          if (l2 >= 0L)
          {
            if (l2 < 24L)
            {
              if (l2 == 0L)
              {
                paramLong = l1 / 60000L;
                if (paramLong < 1L) {
                  return paramContext.getString(2131165892);
                }
                if (paramLong == 1L) {
                  return paramContext.getString(2131165893, new Object[] { Long.valueOf(paramLong), "" });
                }
                return paramContext.getString(2131165893, new Object[] { Long.valueOf(paramLong), paramContext.getString(2131165898) });
              }
              if (l2 == 1L) {
                return paramContext.getString(2131165894, new Object[] { Long.valueOf(l2), "" });
              }
              return paramContext.getString(2131165894, new Object[] { Long.valueOf(l2), paramContext.getString(2131165898) });
            }
            if (l2 < 48L)
            {
              localObject = new Date(paramLong);
              return paramContext.getString(2131165889) + localSimpleDateFormat.format((Date)localObject).toLowerCase();
            }
            if (l2 < 168L)
            {
              localObject = new Date(paramLong);
              paramLong = l2 / 24L;
              return String.format(paramContext.getString(2131165897), new Object[] { Long.valueOf(paramLong) }) + localSimpleDateFormat.format((Date)localObject).toLowerCase();
            }
            if (l2 < 720L)
            {
              paramLong = l2 / 168L;
              if (paramLong == 1L) {
                return String.format(paramContext.getString(2131165896), new Object[] { Long.valueOf(paramLong), "" });
              }
              return String.format(paramContext.getText(2131165896).toString(), new Object[] { Long.valueOf(paramLong), paramContext.getString(2131165898) });
            }
            if (l2 < 8760L)
            {
              paramLong = l2 / 720L;
              if (paramLong == 1L) {
                return String.format(paramContext.getString(2131165895), new Object[] { Long.valueOf(paramLong), "" });
              }
              return String.format(paramContext.getString(2131165895), new Object[] { Long.valueOf(paramLong), paramContext.getString(2131165898) });
            }
            localObject = new Date(paramLong);
            return String.format(paramContext.getString(2131165897), new Object[] { Long.valueOf(l2 / 24L) }) + localSimpleDateFormat.format((Date)localObject).toLowerCase();
          }
          paramContext = new Date(paramLong);
          localSimpleDateFormat.applyPattern("yyyy/MM/dd " + (String)localObject);
          paramContext = localSimpleDateFormat.format(paramContext);
          return paramContext;
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        return "N/A";
      }
      Object localObject = "hh:mm a";
    }
  }
  
  public static ArrayList a(List paramList, Time paramTime, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (!paramBoolean) {}
    Object localObject;
    ForecastBean localForecastBean;
    for (int k = 6; paramList != null; k = 10)
    {
      localObject = paramList.iterator();
      int j;
      for (int i = 0; ((Iterator)localObject).hasNext(); i = j)
      {
        localForecastBean = (ForecastBean)((Iterator)localObject).next();
        j = i;
        if (localForecastBean != null)
        {
          j = i;
          if (localForecastBean.e() != 55536)
          {
            j = i;
            if (localForecastBean.f() != 55536)
            {
              j = i;
              if (localForecastBean.g() != 55536)
              {
                if (a(localForecastBean.e(), localForecastBean.f(), localForecastBean.g(), paramTime)) {
                  i = 1;
                }
                j = i;
                if (i != 0)
                {
                  j = i;
                  if (localArrayList.size() < k)
                  {
                    localArrayList.add(localForecastBean);
                    j = i;
                  }
                }
              }
            }
          }
        }
      }
    }
    if (localArrayList.isEmpty())
    {
      localObject = new Time();
      if ((paramList != null) && (paramList.size() > 0))
      {
        localForecastBean = (ForecastBean)paramList.get(0);
        ((Time)localObject).set(localForecastBean.g(), localForecastBean.f() - 1, localForecastBean.e());
        if (((Time)localObject).after(paramTime))
        {
          paramList = paramList.iterator();
          while (paramList.hasNext())
          {
            paramTime = (ForecastBean)paramList.next();
            if (localArrayList.size() < k) {
              localArrayList.add(paramTime);
            }
          }
        }
      }
    }
    return localArrayList;
  }
  
  public static final void a(File paramFile)
  {
    if ((paramFile != null) && (paramFile.exists()))
    {
      if (!paramFile.isFile()) {
        break label24;
      }
      paramFile.delete();
    }
    label24:
    while (!paramFile.isDirectory()) {
      return;
    }
    File[] arrayOfFile = paramFile.listFiles();
    int i = 0;
    while (i < arrayOfFile.length)
    {
      a(arrayOfFile[i]);
      i += 1;
    }
    paramFile.delete();
  }
  
  public static boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    return (paramInt1 >= paramInt2) && (paramInt1 < paramInt3);
  }
  
  public static boolean a(int paramInt1, int paramInt2, int paramInt3, Time paramTime)
  {
    return (paramTime.year == paramInt1) && (paramTime.month == paramInt2 - 1) && (paramTime.monthDay == paramInt3);
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    boolean bool = false;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      paramContext.getPackageManager().getPackageInfo(paramString, 0);
      bool = true;
      return bool;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  /* Error */
  public static boolean a(Context paramContext, String paramString, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 6
    //   9: aconst_null
    //   10: astore 9
    //   12: aconst_null
    //   13: astore 5
    //   15: iconst_1
    //   16: istore 4
    //   18: new 383	java/io/File
    //   21: dup
    //   22: aload_0
    //   23: invokevirtual 424	android/content/Context:getFilesDir	()Ljava/io/File;
    //   26: aload_1
    //   27: invokespecial 427	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   30: astore_1
    //   31: aload_1
    //   32: invokevirtual 386	java/io/File:exists	()Z
    //   35: ifne +8 -> 43
    //   38: aload_1
    //   39: invokevirtual 430	java/io/File:mkdirs	()Z
    //   42: pop
    //   43: aload_0
    //   44: invokevirtual 29	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   47: iload_2
    //   48: invokevirtual 433	android/content/res/Resources:getResourceEntryName	(I)Ljava/lang/String;
    //   51: astore 10
    //   53: new 383	java/io/File
    //   56: dup
    //   57: aload_1
    //   58: invokevirtual 436	java/io/File:getPath	()Ljava/lang/String;
    //   61: aload 10
    //   63: invokespecial 437	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   66: astore 10
    //   68: aload 10
    //   70: invokevirtual 386	java/io/File:exists	()Z
    //   73: ifeq +9 -> 82
    //   76: aload 10
    //   78: invokevirtual 392	java/io/File:delete	()Z
    //   81: pop
    //   82: aload_0
    //   83: invokevirtual 29	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   86: iload_2
    //   87: invokevirtual 441	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   90: astore_0
    //   91: aload 9
    //   93: astore 5
    //   95: aload_0
    //   96: astore_1
    //   97: new 443	java/io/FileOutputStream
    //   100: dup
    //   101: aload 10
    //   103: invokespecial 445	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   106: astore 6
    //   108: sipush 8192
    //   111: newarray <illegal type>
    //   113: astore_1
    //   114: aload_0
    //   115: aload_1
    //   116: invokevirtual 451	java/io/InputStream:read	([B)I
    //   119: istore_2
    //   120: iload_2
    //   121: ifle +288 -> 409
    //   124: aload 6
    //   126: aload_1
    //   127: iconst_0
    //   128: iload_2
    //   129: invokevirtual 455	java/io/FileOutputStream:write	([BII)V
    //   132: goto -18 -> 114
    //   135: astore_1
    //   136: invokestatic 83	com/gtp/a/a/b/c:a	()Z
    //   139: ifeq +7 -> 146
    //   142: aload_1
    //   143: invokevirtual 456	android/content/res/Resources$NotFoundException:printStackTrace	()V
    //   146: aload 6
    //   148: ifnull +8 -> 156
    //   151: aload 6
    //   153: invokevirtual 459	java/io/FileOutputStream:close	()V
    //   156: aload_0
    //   157: ifnull +7 -> 164
    //   160: aload_0
    //   161: invokevirtual 460	java/io/InputStream:close	()V
    //   164: iconst_0
    //   165: istore_3
    //   166: iload_3
    //   167: ireturn
    //   168: astore 6
    //   170: aconst_null
    //   171: astore_0
    //   172: aload 7
    //   174: astore 5
    //   176: aload_0
    //   177: astore_1
    //   178: invokestatic 83	com/gtp/a/a/b/c:a	()Z
    //   181: ifeq +14 -> 195
    //   184: aload 7
    //   186: astore 5
    //   188: aload_0
    //   189: astore_1
    //   190: aload 6
    //   192: invokevirtual 461	java/io/FileNotFoundException:printStackTrace	()V
    //   195: aload 7
    //   197: ifnull +8 -> 205
    //   200: aload 7
    //   202: invokevirtual 459	java/io/FileOutputStream:close	()V
    //   205: aload_0
    //   206: ifnull +7 -> 213
    //   209: aload_0
    //   210: invokevirtual 460	java/io/InputStream:close	()V
    //   213: iconst_0
    //   214: ireturn
    //   215: astore 6
    //   217: aconst_null
    //   218: astore_0
    //   219: aload 8
    //   221: astore 7
    //   223: aload 7
    //   225: astore 5
    //   227: aload_0
    //   228: astore_1
    //   229: invokestatic 83	com/gtp/a/a/b/c:a	()Z
    //   232: ifeq +14 -> 246
    //   235: aload 7
    //   237: astore 5
    //   239: aload_0
    //   240: astore_1
    //   241: aload 6
    //   243: invokevirtual 462	java/io/IOException:printStackTrace	()V
    //   246: aload 7
    //   248: ifnull +8 -> 256
    //   251: aload 7
    //   253: invokevirtual 459	java/io/FileOutputStream:close	()V
    //   256: aload_0
    //   257: ifnull +7 -> 264
    //   260: aload_0
    //   261: invokevirtual 460	java/io/InputStream:close	()V
    //   264: iconst_0
    //   265: ireturn
    //   266: astore_1
    //   267: aconst_null
    //   268: astore_0
    //   269: aload 6
    //   271: astore 5
    //   273: aload_1
    //   274: astore 6
    //   276: aload 5
    //   278: ifnull +8 -> 286
    //   281: aload 5
    //   283: invokevirtual 459	java/io/FileOutputStream:close	()V
    //   286: aload_0
    //   287: ifnull +7 -> 294
    //   290: aload_0
    //   291: invokevirtual 460	java/io/InputStream:close	()V
    //   294: aload 6
    //   296: athrow
    //   297: astore_1
    //   298: invokestatic 83	com/gtp/a/a/b/c:a	()Z
    //   301: ifeq -15 -> 286
    //   304: aload_1
    //   305: invokevirtual 462	java/io/IOException:printStackTrace	()V
    //   308: goto -22 -> 286
    //   311: astore_0
    //   312: invokestatic 83	com/gtp/a/a/b/c:a	()Z
    //   315: ifeq -21 -> 294
    //   318: aload_0
    //   319: invokevirtual 462	java/io/IOException:printStackTrace	()V
    //   322: goto -28 -> 294
    //   325: astore_1
    //   326: invokestatic 83	com/gtp/a/a/b/c:a	()Z
    //   329: ifeq -173 -> 156
    //   332: aload_1
    //   333: invokevirtual 462	java/io/IOException:printStackTrace	()V
    //   336: goto -180 -> 156
    //   339: astore_0
    //   340: invokestatic 83	com/gtp/a/a/b/c:a	()Z
    //   343: ifeq -179 -> 164
    //   346: aload_0
    //   347: invokevirtual 462	java/io/IOException:printStackTrace	()V
    //   350: goto -186 -> 164
    //   353: astore_1
    //   354: invokestatic 83	com/gtp/a/a/b/c:a	()Z
    //   357: ifeq -152 -> 205
    //   360: aload_1
    //   361: invokevirtual 462	java/io/IOException:printStackTrace	()V
    //   364: goto -159 -> 205
    //   367: astore_0
    //   368: invokestatic 83	com/gtp/a/a/b/c:a	()Z
    //   371: ifeq -158 -> 213
    //   374: aload_0
    //   375: invokevirtual 462	java/io/IOException:printStackTrace	()V
    //   378: goto -165 -> 213
    //   381: astore_1
    //   382: invokestatic 83	com/gtp/a/a/b/c:a	()Z
    //   385: ifeq -129 -> 256
    //   388: aload_1
    //   389: invokevirtual 462	java/io/IOException:printStackTrace	()V
    //   392: goto -136 -> 256
    //   395: astore_0
    //   396: invokestatic 83	com/gtp/a/a/b/c:a	()Z
    //   399: ifeq -135 -> 264
    //   402: aload_0
    //   403: invokevirtual 462	java/io/IOException:printStackTrace	()V
    //   406: goto -142 -> 264
    //   409: aload 6
    //   411: ifnull +8 -> 419
    //   414: aload 6
    //   416: invokevirtual 459	java/io/FileOutputStream:close	()V
    //   419: iload 4
    //   421: istore_3
    //   422: aload_0
    //   423: ifnull -257 -> 166
    //   426: aload_0
    //   427: invokevirtual 460	java/io/InputStream:close	()V
    //   430: iconst_1
    //   431: ireturn
    //   432: astore_0
    //   433: iload 4
    //   435: istore_3
    //   436: invokestatic 83	com/gtp/a/a/b/c:a	()Z
    //   439: ifeq -273 -> 166
    //   442: aload_0
    //   443: invokevirtual 462	java/io/IOException:printStackTrace	()V
    //   446: iconst_1
    //   447: ireturn
    //   448: astore_1
    //   449: invokestatic 83	com/gtp/a/a/b/c:a	()Z
    //   452: ifeq -33 -> 419
    //   455: aload_1
    //   456: invokevirtual 462	java/io/IOException:printStackTrace	()V
    //   459: goto -40 -> 419
    //   462: astore 6
    //   464: aload_1
    //   465: astore_0
    //   466: goto -190 -> 276
    //   469: astore_1
    //   470: aload 6
    //   472: astore 5
    //   474: aload_1
    //   475: astore 6
    //   477: goto -201 -> 276
    //   480: astore_1
    //   481: aload 6
    //   483: astore 5
    //   485: aload_1
    //   486: astore 6
    //   488: goto -212 -> 276
    //   491: astore 6
    //   493: aload 8
    //   495: astore 7
    //   497: goto -274 -> 223
    //   500: astore_1
    //   501: aload 6
    //   503: astore 7
    //   505: aload_1
    //   506: astore 6
    //   508: goto -285 -> 223
    //   511: astore 6
    //   513: goto -341 -> 172
    //   516: astore_1
    //   517: aload 6
    //   519: astore 7
    //   521: aload_1
    //   522: astore 6
    //   524: goto -352 -> 172
    //   527: astore_1
    //   528: aconst_null
    //   529: astore 6
    //   531: aload 5
    //   533: astore_0
    //   534: goto -398 -> 136
    //   537: astore_1
    //   538: aconst_null
    //   539: astore 6
    //   541: goto -405 -> 136
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	544	0	paramContext	Context
    //   0	544	1	paramString	String
    //   0	544	2	paramInt	int
    //   165	271	3	bool1	boolean
    //   16	418	4	bool2	boolean
    //   13	519	5	localObject1	Object
    //   7	145	6	localFileOutputStream	java.io.FileOutputStream
    //   168	23	6	localFileNotFoundException1	java.io.FileNotFoundException
    //   215	55	6	localIOException1	java.io.IOException
    //   274	141	6	str1	String
    //   462	9	6	localObject2	Object
    //   475	12	6	str2	String
    //   491	11	6	localIOException2	java.io.IOException
    //   506	1	6	str3	String
    //   511	7	6	localFileNotFoundException2	java.io.FileNotFoundException
    //   522	18	6	str4	String
    //   1	519	7	localObject3	Object
    //   4	490	8	localObject4	Object
    //   10	82	9	localObject5	Object
    //   51	51	10	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   108	114	135	android/content/res/Resources$NotFoundException
    //   114	120	135	android/content/res/Resources$NotFoundException
    //   124	132	135	android/content/res/Resources$NotFoundException
    //   82	91	168	java/io/FileNotFoundException
    //   82	91	215	java/io/IOException
    //   82	91	266	finally
    //   281	286	297	java/io/IOException
    //   290	294	311	java/io/IOException
    //   151	156	325	java/io/IOException
    //   160	164	339	java/io/IOException
    //   200	205	353	java/io/IOException
    //   209	213	367	java/io/IOException
    //   251	256	381	java/io/IOException
    //   260	264	395	java/io/IOException
    //   426	430	432	java/io/IOException
    //   414	419	448	java/io/IOException
    //   97	108	462	finally
    //   178	184	462	finally
    //   190	195	462	finally
    //   229	235	462	finally
    //   241	246	462	finally
    //   108	114	469	finally
    //   114	120	469	finally
    //   124	132	469	finally
    //   136	146	480	finally
    //   97	108	491	java/io/IOException
    //   108	114	500	java/io/IOException
    //   114	120	500	java/io/IOException
    //   124	132	500	java/io/IOException
    //   97	108	511	java/io/FileNotFoundException
    //   108	114	516	java/io/FileNotFoundException
    //   114	120	516	java/io/FileNotFoundException
    //   124	132	516	java/io/FileNotFoundException
    //   82	91	527	android/content/res/Resources$NotFoundException
    //   97	108	537	android/content/res/Resources$NotFoundException
  }
  
  public static final boolean a(View paramView)
  {
    return a(paramView, 800);
  }
  
  public static final boolean a(View paramView, int paramInt)
  {
    Object localObject = paramView.getTag();
    if (localObject != null) {}
    for (long l1 = ((Long)localObject).longValue();; l1 = 0L)
    {
      long l2 = SystemClock.elapsedRealtime();
      if ((l2 - l1 < paramInt) && (l2 > l1)) {
        return false;
      }
      paramView.setTag(Long.valueOf(l2));
      return true;
    }
  }
  
  public static boolean a(String paramString)
  {
    return (paramString != null) && (!"".equals(paramString)) && (!"--".equals(paramString)) && (!paramString.contains("N/A")) && (!"-10000".equals(paramString));
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    Object localObject = Calendar.getInstance();
    int i = ((Calendar)localObject).get(1);
    int j = ((Calendar)localObject).get(2) + 1;
    int k = ((Calendar)localObject).get(5);
    int m = ((Calendar)localObject).get(11);
    if ((!a(paramString1)) || (!a(paramString2))) {
      if ((m < 6) || (m >= 18)) {}
    }
    for (;;)
    {
      return true;
      return false;
      try
      {
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yy:MM:dd:hh:mm");
        localObject = new Date();
        paramString1 = localSimpleDateFormat.parse(i + ":" + j + ":" + k + ":" + paramString1);
        paramString2 = localSimpleDateFormat.parse(i + ":" + j + ":" + k + ":" + paramString2);
        if (((Date)localObject).compareTo(paramString1) >= 0)
        {
          i = ((Date)localObject).compareTo(paramString2);
          if (i < 0) {}
        }
        else
        {
          return false;
        }
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
    }
    return true;
  }
  
  public static boolean a(String paramString1, String paramString2, Time paramTime)
  {
    int i = paramTime.year;
    int j = paramTime.month + 1;
    int k = paramTime.monthDay;
    int m = paramTime.hour;
    if ((!a(paramString1)) || (!a(paramString2))) {
      if ((m < 6) || (m >= 18)) {}
    }
    for (;;)
    {
      return true;
      return false;
      try
      {
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yy:MM:dd:hh:mm");
        Date localDate = new Date();
        localDate.setTime(paramTime.toMillis(false));
        paramString1 = localSimpleDateFormat.parse(i + ":" + j + ":" + k + ":" + paramString1);
        paramString2 = localSimpleDateFormat.parse(i + ":" + j + ":" + k + ":" + paramString2);
        if (localDate.compareTo(paramString1) >= 0)
        {
          i = localDate.compareTo(paramString2);
          if (i < 0) {}
        }
        else
        {
          return false;
        }
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
    }
    return true;
  }
  
  public static boolean a(double[] paramArrayOfDouble)
  {
    return (paramArrayOfDouble != null) && (paramArrayOfDouble.length == 2) && (paramArrayOfDouble[0] != -10000.0D) && (paramArrayOfDouble[1] != -10000.0D);
  }
  
  public static int b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 1;
    case 0: 
      return 2;
    case 1: 
      return 3;
    case 2: 
      return 4;
    case 3: 
      return 7;
    case 4: 
      return 5;
    }
    return 6;
  }
  
  public static int b(int paramInt1, int paramInt2, int paramInt3)
  {
    int j = 7;
    int i = j;
    if (paramInt1 != 55536)
    {
      i = j;
      if (paramInt2 != 55536)
      {
        i = j;
        if (paramInt3 != 55536)
        {
          Time localTime = new Time();
          localTime.set(paramInt3, paramInt2 - 1, paramInt1);
          localTime.normalize(false);
          i = localTime.weekDay;
        }
      }
    }
    return i;
  }
  
  public static final int b(Context paramContext, String paramString)
  {
    int i = -1;
    paramContext = paramContext.getPackageManager();
    try
    {
      int j = paramContext.getPackageInfo(paramString, 0).versionCode;
      i = j;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      while (!c.a()) {}
      paramContext.printStackTrace();
    }
    return i;
    return -1;
  }
  
  public static SQLiteDatabase b(Context paramContext, String paramString, int paramInt)
  {
    File localFile = new File(paramContext.getFilesDir(), paramString + File.separator + paramContext.getResources().getResourceEntryName(paramInt));
    if (!localFile.exists()) {}
    for (boolean bool = a(paramContext, paramString, paramInt); !bool; bool = true) {
      return null;
    }
    return SQLiteDatabase.openOrCreateDatabase(localFile, null);
  }
  
  public static String b(String paramString)
  {
    Object localObject = new SimpleDateFormat("yyyy/MM/dd HH:mm Z");
    try
    {
      paramString = ((SimpleDateFormat)localObject).parse(paramString);
      localObject = Calendar.getInstance();
      int i = ((Calendar)localObject).get(15);
      int j = ((Calendar)localObject).get(16);
      long l1 = paramString.getTime();
      long l2 = (i + j) * 2;
      return String.valueOf(l1 - l2);
    }
    catch (ParseException paramString)
    {
      paramString.printStackTrace();
    }
    return "--";
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2)
  {
    paramString1 = new Intent("android.intent.action.VIEW", Uri.parse(paramString1));
    paramString1.setPackage("com.android.vending");
    paramString1.setFlags(268435456);
    try
    {
      paramContext.startActivity(paramString1);
      return;
    }
    catch (ActivityNotFoundException paramString1)
    {
      paramString1 = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + paramString2));
      paramString1.setFlags(268435456);
      try
      {
        paramContext.startActivity(paramString1);
        return;
      }
      catch (ActivityNotFoundException paramString1)
      {
        Toast.makeText(paramContext, 2131165768, 0).show();
      }
    }
  }
  
  public static boolean b(float paramFloat)
  {
    return paramFloat != -10000.0F;
  }
  
  public static boolean b(Context paramContext)
  {
    return DateFormat.is24HourFormat(paramContext);
  }
  
  public static int c(int paramInt)
  {
    switch (paramInt)
    {
    case 17: 
    default: 
      return 1;
    case 0: 
      return 2;
    case 1: 
      return 7;
    case 2: 
      return 15;
    case 3: 
      return 11;
    case 4: 
      return 3;
    case 5: 
      return 5;
    case 6: 
      return 17;
    case 7: 
      return 9;
    case 8: 
      return 13;
    case 9: 
      return 8;
    case 10: 
      return 10;
    case 11: 
      return 6;
    case 12: 
      return 4;
    case 13: 
      return 14;
    case 14: 
      return 12;
    case 15: 
      return 16;
    }
    return 18;
  }
  
  public static boolean c(int paramInt1, int paramInt2, int paramInt3)
  {
    return (paramInt1 >= paramInt2) && (paramInt1 <= paramInt3);
  }
  
  public static boolean c(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext != null)
      {
        paramContext = paramContext.getActiveNetworkInfo();
        if ((paramContext != null) && (paramContext.isConnected())) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean c(String paramString)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm Z");
    Object localObject = null;
    try
    {
      paramString = localSimpleDateFormat.parse(paramString);
      if (paramString != null) {
        return new Date().after(paramString);
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = (String)localObject;
      }
    }
    return false;
  }
  
  public static int d(int paramInt)
  {
    int i = 6;
    switch (paramInt)
    {
    default: 
      i = 1;
    case 10: 
    case 16: 
    case 21: 
      return i;
    case 0: 
      return 7;
    case 1: 
      return 15;
    case 2: 
      return 11;
    case 3: 
      return 3;
    case 4: 
      return 5;
    case 5: 
      return 17;
    case 6: 
      return 9;
    case 7: 
      return 13;
    case 8: 
      return 8;
    case 9: 
      return 10;
    case 11: 
      return 4;
    case 12: 
      return 14;
    case 13: 
      return 12;
    case 14: 
      return 16;
    case 15: 
      return 18;
    case 17: 
      return 4;
    case 18: 
      return 14;
    case 19: 
      return 16;
    case 20: 
      return 18;
    case 22: 
      return 4;
    case 23: 
      return 14;
    case 24: 
      return 16;
    case 25: 
      return 18;
    case 26: 
      return 10;
    case 27: 
      return 12;
    case 28: 
      return 9;
    case 29: 
      return 5;
    case 30: 
      return 13;
    case 31: 
      return 17;
    }
    return 1;
  }
  
  public static String d(Context paramContext)
  {
    paramContext = paramContext.getContentResolver();
    if (paramContext != null)
    {
      Cursor localCursor = paramContext.query(WeatherContentProvider.g, new String[] { "setting_value" }, "setting_key=?", new String[] { "app_widget_theme" }, null);
      if (localCursor != null)
      {
        if (localCursor.moveToFirst()) {}
        for (paramContext = localCursor.getString(0);; paramContext = "") {
          try
          {
            localCursor.close();
            return paramContext;
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
            return paramContext;
          }
        }
      }
    }
    return "";
  }
  
  public static boolean d(String paramString)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm Z");
    Date localDate = null;
    try
    {
      paramString = localSimpleDateFormat.parse(paramString);
      if (paramString != null)
      {
        localDate = new Date();
        paramString.setTime(paramString.getTime() + 86400000L);
        return localDate.after(paramString);
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = localDate;
      }
    }
    return false;
  }
  
  public static String e(int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if ((paramInt >= 0) && (paramInt <= 9)) {
      localStringBuffer.append("0").append(paramInt);
    }
    for (;;)
    {
      return localStringBuffer.toString();
      localStringBuffer.append(paramInt).append("");
    }
  }
  
  @SuppressLint({"DefaultLocale"})
  public static String e(String paramString)
  {
    String str = paramString.replaceAll("\\.", "");
    if (TextUtils.isEmpty(str)) {}
    for (;;)
    {
      str = paramString.toUpperCase();
      if (!TextUtils.isEmpty(str)) {
        paramString = str;
      }
      return paramString;
      paramString = str;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/util/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */