package com.appflood.e;

import android.util.Log;
import java.security.Key;
import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.zip.Adler32;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import org.json.JSONArray;
import org.json.JSONObject;

public final class j
{
  private static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  private static String[][] b = { { "daily", "weekly", "monthly", "yearly" }, { "", "daysInWeek", "daysInMonth", "daysInYear" }, { "", "BYDAY", "BYMONTHDAY", "BYYEARDAY" } };
  private static String[] c = { "MO", "TU", "WE", "TH", "FR", "SA", "SU" };
  
  public static int a(String paramString, int paramInt)
  {
    if (paramString == null) {
      return paramInt;
    }
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (Throwable localThrowable)
    {
      b(localThrowable, "failed to parse int (" + paramString + ") using default value :" + paramInt);
    }
    return paramInt;
  }
  
  public static int a(JSONObject paramJSONObject, String paramString, int paramInt)
  {
    if (paramJSONObject == null) {
      return paramInt;
    }
    try
    {
      int i = paramJSONObject.getInt(paramString);
      return i;
    }
    catch (Throwable paramJSONObject) {}
    return paramInt;
  }
  
  public static String a(int paramInt)
  {
    paramInt /= 1000;
    StringBuilder localStringBuilder = new StringBuilder();
    int i = paramInt / 3600;
    if (i > 0)
    {
      if (i > 9)
      {
        localObject = Integer.valueOf(i);
        localStringBuilder.append(String.valueOf(localObject));
      }
    }
    else
    {
      paramInt %= 3600;
      i = paramInt / 60;
      if ((!a(localStringBuilder)) || (i > 0))
      {
        if (i <= 9) {
          break label147;
        }
        localObject = Integer.valueOf(i);
        label77:
        localStringBuilder.append(String.valueOf(localObject));
      }
      paramInt %= 60;
      if ((!a(localStringBuilder)) || (paramInt > 0)) {
        if (paramInt <= 9) {
          break label167;
        }
      }
    }
    label147:
    label167:
    for (Object localObject = Integer.valueOf(paramInt);; localObject = "0" + paramInt)
    {
      localStringBuilder.append(String.valueOf(localObject));
      return localStringBuilder.toString();
      localObject = "0" + i;
      break;
      localObject = "0" + i;
      break label77;
    }
  }
  
  public static String a(String paramString)
  {
    return b(b(paramString));
  }
  
  public static String a(HashMap<String, Object> paramHashMap)
  {
    if ((paramHashMap == null) || (paramHashMap.isEmpty())) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{");
    Iterator localIterator1 = paramHashMap.entrySet().iterator();
    label327:
    for (;;)
    {
      String str2;
      if (localIterator1.hasNext())
      {
        paramHashMap = (Map.Entry)localIterator1.next();
        str2 = (String)paramHashMap.getKey();
        paramHashMap = paramHashMap.getValue();
        if (paramHashMap == null) {
          continue;
        }
        if ((paramHashMap instanceof Integer)) {
          paramHashMap = String.valueOf(paramHashMap);
        }
      }
      for (;;)
      {
        if (a(paramHashMap)) {
          break label327;
        }
        localStringBuilder.append(str2);
        localStringBuilder.append(":");
        localStringBuilder.append(paramHashMap);
        localStringBuilder.append("; ");
        break;
        if ((paramHashMap instanceof ArrayList))
        {
          ArrayList localArrayList = (ArrayList)paramHashMap;
          if (localArrayList.size() <= 0) {
            break;
          }
          paramHashMap = "[";
          Iterator localIterator2 = localArrayList.iterator();
          while (localIterator2.hasNext())
          {
            Object localObject = localIterator2.next();
            if ((localObject instanceof String))
            {
              String str1 = paramHashMap + "\"" + (String)localObject + "\"";
              paramHashMap = str1;
              if (localArrayList.indexOf(localObject) < localArrayList.size() - 1) {
                paramHashMap = str1 + ",";
              }
            }
          }
          paramHashMap = paramHashMap + "]";
          continue;
        }
        if ((paramHashMap instanceof String))
        {
          paramHashMap = (String)paramHashMap;
          continue;
          localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
          localStringBuilder.append("}");
          return localStringBuilder.toString();
        }
        else
        {
          paramHashMap = "";
        }
      }
    }
  }
  
  private static String a(Map<String, String> paramMap)
  {
    String str1 = "";
    Object localObject = a(paramMap, "frequency", "");
    new StringBuilder("rrrrrrrr ").append((String)localObject).toString();
    if (a((CharSequence)localObject)) {
      localObject = "";
    }
    int i;
    do
    {
      return (String)localObject;
      i = 0;
      if (i >= b[0].length) {
        break label540;
      }
      if (!((String)localObject).equals(b[0][i])) {
        break;
      }
      str1 = "FREQ=" + b[0][i].toUpperCase() + ";";
      localObject = str1;
    } while (i == 0);
    for (;;)
    {
      String str2 = a(paramMap, b[1][i], "");
      if (!a(str2))
      {
        if (i == 1)
        {
          localObject = str2.split(",");
          paramMap = b[2][i] + "=";
          i = 0;
          label176:
          if (i < localObject.length)
          {
            int j = a(localObject[i], 0);
            StringBuilder localStringBuilder = new StringBuilder().append(paramMap).append(c[j]);
            if (i == localObject.length - 1) {}
            for (paramMap = ";";; paramMap = ",")
            {
              paramMap = paramMap;
              i += 1;
              break label176;
              new StringBuilder("i ===== 444   ").append(i).toString();
              if (i == b[0].length - 1) {
                return "";
              }
              i += 1;
              break;
            }
          }
          new StringBuilder("sub array + ").append(localObject).append("  ").append(localObject.length).append(" subR ").append(str2).append(" weekley ").append(paramMap).toString();
          return str1 + paramMap;
        }
        return str1 + b[2][i] + "=" + str2 + ";";
      }
      localObject = str1;
      if (!a(str2)) {
        break;
      }
      localObject = str1;
      if (i != 3) {
        break;
      }
      localObject = str1;
      if (!paramMap.containsKey("daysInMonth")) {
        break;
      }
      localObject = a(paramMap, "daysInMonth", "");
      str2 = str1;
      if (!a((CharSequence)localObject)) {
        str2 = str1 + b[2][2] + "=" + (String)localObject + ";";
      }
      paramMap = a(paramMap, "monthsInYear", "");
      localObject = str2;
      if (a(paramMap)) {
        break;
      }
      return str2 + "BYMONTH=" + paramMap + ";";
      label540:
      i = 0;
    }
  }
  
  private static String a(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    if (paramMap == null) {}
    do
    {
      return paramString2;
      paramMap = (String)paramMap.get(paramString1);
    } while (paramMap == null);
    return paramMap;
  }
  
  public static String a(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    if (paramJSONObject == null) {
      return paramString2;
    }
    paramString2 = "";
    try
    {
      paramJSONObject = paramJSONObject.getString(paramString1);
      return paramJSONObject;
    }
    catch (Throwable paramJSONObject)
    {
      for (;;)
      {
        paramJSONObject = paramString2;
      }
    }
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    char[] arrayOfChar = new char[paramArrayOfByte.length << 1];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i] & 0xFF;
      arrayOfChar[(i << 1)] = a[(j >> 4)];
      arrayOfChar[((i << 1) + 1)] = a[(j & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar);
  }
  
  public static String a(byte[] paramArrayOfByte, String paramString)
  {
    int j = 0;
    if (paramArrayOfByte == null) {
      return paramString;
    }
    int i = j;
    try
    {
      if (paramArrayOfByte.length >= 3)
      {
        i = j;
        if (paramArrayOfByte[0] == -17)
        {
          i = j;
          if (paramArrayOfByte[1] == -69)
          {
            i = j;
            if (paramArrayOfByte[2] == -65) {
              i = 3;
            }
          }
        }
      }
      paramArrayOfByte = new String(paramArrayOfByte, i, paramArrayOfByte.length - i, "UTF-8");
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      a(paramArrayOfByte, "failed to get utf8String");
    }
    return paramString;
  }
  
  public static JSONObject a(String paramString, Object paramObject)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put(paramString, paramObject);
      return localJSONObject;
    }
    catch (Throwable paramString)
    {
      a(paramString, "failed to add type into json");
    }
    return localJSONObject;
  }
  
  public static JSONObject a(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      paramJSONObject = paramJSONObject.getJSONObject(paramString);
      return paramJSONObject;
    }
    catch (Throwable paramJSONObject) {}
    return null;
  }
  
  public static void a() {}
  
  /* Error */
  public static void a(android.content.Context paramContext, Map<String, String> paramMap)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: ldc_w 297
    //   6: new 89	java/lang/StringBuilder
    //   9: dup
    //   10: ldc_w 299
    //   13: invokespecial 95	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   16: aload_1
    //   17: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   20: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   23: invokestatic 305	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   26: pop
    //   27: aload_1
    //   28: ldc_w 307
    //   31: ldc 47
    //   33: invokestatic 214	com/appflood/e/j:a	(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   36: pop
    //   37: aload_1
    //   38: ldc_w 309
    //   41: ldc 47
    //   43: invokestatic 214	com/appflood/e/j:a	(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   46: astore 6
    //   48: ldc_w 311
    //   51: aload 6
    //   53: invokevirtual 220	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   56: ifeq +329 -> 385
    //   59: iconst_1
    //   60: istore_2
    //   61: aload_1
    //   62: ldc_w 313
    //   65: ldc 47
    //   67: invokestatic 214	com/appflood/e/j:a	(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   70: astore 8
    //   72: aload_1
    //   73: ldc_w 315
    //   76: ldc 47
    //   78: invokestatic 214	com/appflood/e/j:a	(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   81: astore 9
    //   83: aload_1
    //   84: ldc_w 317
    //   87: ldc 47
    //   89: invokestatic 214	com/appflood/e/j:a	(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   92: astore 10
    //   94: aload_1
    //   95: ldc_w 319
    //   98: ldc 47
    //   100: invokestatic 214	com/appflood/e/j:a	(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   103: invokestatic 322	com/appflood/e/j:i	(Ljava/lang/String;)Ljava/util/Date;
    //   106: astore 11
    //   108: aload_1
    //   109: ldc_w 324
    //   112: ldc 47
    //   114: invokestatic 214	com/appflood/e/j:a	(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   117: invokestatic 322	com/appflood/e/j:i	(Ljava/lang/String;)Ljava/util/Date;
    //   120: astore 12
    //   122: aload_1
    //   123: ldc_w 326
    //   126: ldc 47
    //   128: invokestatic 214	com/appflood/e/j:a	(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   131: invokestatic 330	com/appflood/e/j:h	(Ljava/lang/String;)J
    //   134: pop2
    //   135: aload_1
    //   136: invokestatic 332	com/appflood/e/j:a	(Ljava/util/Map;)Ljava/lang/String;
    //   139: astore 7
    //   141: aload 7
    //   143: astore 6
    //   145: aload 7
    //   147: invokestatic 130	com/appflood/e/j:a	(Ljava/lang/CharSequence;)Z
    //   150: ifne +18 -> 168
    //   153: aload 7
    //   155: iconst_0
    //   156: aload 7
    //   158: invokevirtual 333	java/lang/String:length	()I
    //   161: iconst_1
    //   162: isub
    //   163: invokevirtual 337	java/lang/String:substring	(II)Ljava/lang/String;
    //   166: astore 6
    //   168: ldc_w 297
    //   171: new 89	java/lang/StringBuilder
    //   174: dup
    //   175: ldc_w 339
    //   178: invokespecial 95	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   181: aload 6
    //   183: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: invokestatic 305	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   192: pop
    //   193: ldc_w 341
    //   196: aload_1
    //   197: ldc_w 343
    //   200: ldc 47
    //   202: invokestatic 214	com/appflood/e/j:a	(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   205: invokevirtual 220	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   208: ifeq +193 -> 401
    //   211: iconst_1
    //   212: istore_3
    //   213: getstatic 349	com/appflood/e/c:j	I
    //   216: bipush 14
    //   218: if_icmplt +188 -> 406
    //   221: iconst_1
    //   222: istore 4
    //   224: iload 4
    //   226: ifeq +186 -> 412
    //   229: new 351	android/content/Intent
    //   232: dup
    //   233: ldc_w 353
    //   236: invokespecial 354	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   239: getstatic 360	android/provider/CalendarContract$Events:CONTENT_URI	Landroid/net/Uri;
    //   242: invokevirtual 364	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
    //   245: astore_1
    //   246: aload_1
    //   247: ldc_w 366
    //   250: aload 11
    //   252: invokevirtual 372	java/util/Date:getTime	()J
    //   255: invokevirtual 376	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   258: pop
    //   259: aload_1
    //   260: ldc_w 378
    //   263: iload_2
    //   264: invokevirtual 381	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   267: pop
    //   268: aload_1
    //   269: ldc_w 343
    //   272: iload_3
    //   273: invokevirtual 381	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   276: pop
    //   277: aload 6
    //   279: invokestatic 130	com/appflood/e/j:a	(Ljava/lang/CharSequence;)Z
    //   282: ifne +13 -> 295
    //   285: aload_1
    //   286: ldc_w 383
    //   289: aload 6
    //   291: invokevirtual 386	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   294: pop
    //   295: aload_1
    //   296: ldc_w 388
    //   299: aload 12
    //   301: invokevirtual 372	java/util/Date:getTime	()J
    //   304: invokevirtual 376	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   307: pop
    //   308: aload_1
    //   309: ldc_w 390
    //   312: aload 9
    //   314: invokevirtual 386	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   317: pop
    //   318: aload_1
    //   319: ldc_w 392
    //   322: aload 10
    //   324: invokevirtual 386	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   327: pop
    //   328: aload_1
    //   329: ldc_w 313
    //   332: aload 8
    //   334: invokevirtual 386	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   337: pop
    //   338: aload_0
    //   339: aload_1
    //   340: invokevirtual 398	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   343: iconst_0
    //   344: istore_2
    //   345: iload_2
    //   346: ifeq +38 -> 384
    //   349: aload_1
    //   350: ifnull +34 -> 384
    //   353: aload_1
    //   354: invokevirtual 401	android/content/Intent:getAction	()Ljava/lang/String;
    //   357: ldc_w 403
    //   360: if_acmpne +90 -> 450
    //   363: aload_1
    //   364: ldc_w 353
    //   367: invokevirtual 407	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   370: pop
    //   371: aload_1
    //   372: getstatic 360	android/provider/CalendarContract$Events:CONTENT_URI	Landroid/net/Uri;
    //   375: invokevirtual 364	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
    //   378: pop
    //   379: aload_0
    //   380: aload_1
    //   381: invokevirtual 398	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   384: return
    //   385: ldc_w 409
    //   388: aload 6
    //   390: invokevirtual 220	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   393: ifeq +97 -> 490
    //   396: iconst_2
    //   397: istore_2
    //   398: goto -337 -> 61
    //   401: iconst_0
    //   402: istore_3
    //   403: goto -190 -> 213
    //   406: iconst_0
    //   407: istore 4
    //   409: goto -185 -> 224
    //   412: new 351	android/content/Intent
    //   415: dup
    //   416: ldc_w 403
    //   419: invokespecial 354	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   422: astore_1
    //   423: aload_1
    //   424: ldc_w 411
    //   427: invokevirtual 414	android/content/Intent:setType	(Ljava/lang/String;)Landroid/content/Intent;
    //   430: pop
    //   431: goto -185 -> 246
    //   434: astore 6
    //   436: aload 6
    //   438: ldc_w 416
    //   441: invokestatic 111	com/appflood/e/j:b	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   444: iload 5
    //   446: istore_2
    //   447: goto -102 -> 345
    //   450: aload_1
    //   451: ldc_w 403
    //   454: invokevirtual 407	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   457: pop
    //   458: aload_1
    //   459: ldc_w 411
    //   462: invokevirtual 414	android/content/Intent:setType	(Ljava/lang/String;)Landroid/content/Intent;
    //   465: pop
    //   466: goto -87 -> 379
    //   469: astore_0
    //   470: aload_0
    //   471: ldc_w 418
    //   474: invokestatic 111	com/appflood/e/j:b	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   477: return
    //   478: astore 6
    //   480: aconst_null
    //   481: astore_1
    //   482: goto -46 -> 436
    //   485: astore 6
    //   487: goto -51 -> 436
    //   490: iconst_0
    //   491: istore_2
    //   492: goto -431 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	495	0	paramContext	android.content.Context
    //   0	495	1	paramMap	Map<String, String>
    //   60	432	2	i	int
    //   212	191	3	j	int
    //   222	186	4	k	int
    //   1	444	5	m	int
    //   46	343	6	localObject	Object
    //   434	3	6	localException1	Exception
    //   478	1	6	localException2	Exception
    //   485	1	6	localException3	Exception
    //   139	18	7	str1	String
    //   70	263	8	str2	String
    //   81	232	9	str3	String
    //   92	231	10	str4	String
    //   106	145	11	localDate1	Date
    //   120	180	12	localDate2	Date
    // Exception table:
    //   from	to	target	type
    //   423	431	434	java/lang/Exception
    //   353	379	469	java/lang/Exception
    //   379	384	469	java/lang/Exception
    //   450	466	469	java/lang/Exception
    //   229	246	478	java/lang/Exception
    //   412	423	478	java/lang/Exception
    //   246	295	485	java/lang/Exception
    //   295	343	485	java/lang/Exception
  }
  
  public static void a(Throwable paramThrowable, String paramString)
  {
    if (paramThrowable != null) {
      paramThrowable.printStackTrace();
    }
    Log.e("AppFlood", paramString);
  }
  
  public static boolean a(CharSequence paramCharSequence)
  {
    return (paramCharSequence == null) || (paramCharSequence.length() == 0);
  }
  
  public static boolean a(List<?> paramList)
  {
    return (paramList == null) || (paramList.size() == 0);
  }
  
  public static String b()
  {
    Object localObject = new Random();
    byte[] arrayOfByte = new byte[16];
    ((Random)localObject).nextBytes(arrayOfByte);
    arrayOfByte[13] = 0;
    arrayOfByte[12] = 0;
    arrayOfByte[5] = 0;
    arrayOfByte[2] = 0;
    localObject = new Adler32();
    ((Adler32)localObject).update(arrayOfByte);
    long l = ((Adler32)localObject).getValue();
    arrayOfByte[2] = ((byte)(int)(0xF ^ l));
    arrayOfByte[5] = ((byte)(int)(l >> 8 ^ 0x71));
    arrayOfByte[12] = ((byte)(int)(l >> 16 ^ 0x77));
    arrayOfByte[13] = ((byte)(int)(l >> 24 ^ 0x6A));
    return a(arrayOfByte);
  }
  
  private static String b(byte[] paramArrayOfByte)
  {
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).reset();
      ((MessageDigest)localObject).update(paramArrayOfByte);
      localObject = a(((MessageDigest)localObject).digest());
      return (String)localObject;
    }
    catch (Throwable localThrowable)
    {
      a(localThrowable, "failed to compute md5");
    }
    return a(paramArrayOfByte, "");
  }
  
  public static void b(Throwable paramThrowable, String paramString)
  {
    if (paramThrowable != null) {
      paramThrowable.printStackTrace();
    }
    Log.w("AppFlood", paramString);
  }
  
  public static byte[] b(String paramString)
  {
    if (paramString != null) {
      try
      {
        byte[] arrayOfByte = paramString.getBytes("UTF-8");
        return arrayOfByte;
      }
      catch (Throwable localThrowable)
      {
        b(localThrowable, "failed to getBytes: " + paramString);
      }
    }
    return new byte[0];
  }
  
  public static void c(String paramString)
  {
    Log.w("AppFlood", paramString);
  }
  
  public static void d(String paramString)
  {
    Log.i("AppFlood", paramString);
  }
  
  public static JSONObject e(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      return localJSONObject;
    }
    catch (Throwable localThrowable)
    {
      b(localThrowable, "failed to parseJsonObject," + paramString);
    }
    return new JSONObject();
  }
  
  public static JSONArray f(String paramString)
  {
    try
    {
      JSONArray localJSONArray = new JSONArray(paramString);
      return localJSONArray;
    }
    catch (Throwable localThrowable)
    {
      b(localThrowable, "failed to parseJsonArray array = " + paramString);
    }
    return new JSONArray();
  }
  
  public static int g(String paramString)
  {
    int j = 0;
    String[] arrayOfString = paramString.split(":");
    int i = j;
    if (arrayOfString != null)
    {
      i = j;
      if (arrayOfString.length >= 3)
      {
        i = Integer.parseInt(arrayOfString[0]) * 3600 + Integer.parseInt(arrayOfString[1]) * 60 + Integer.parseInt(arrayOfString[2]);
        Log.w("AppFlood", "dura " + paramString + " totalSec " + i);
      }
    }
    return i;
  }
  
  private static long h(String paramString)
  {
    if (paramString == null) {
      return 0L;
    }
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (Exception localException)
    {
      b(localException, "failed to parse long [" + paramString + "], using default value [0]");
    }
    return 0L;
  }
  
  private static Date i(String paramString)
  {
    localObject2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssS");
    localObject1 = null;
    try
    {
      localObject2 = ((SimpleDateFormat)localObject2).parse(paramString);
      localObject1 = localObject2;
    }
    catch (ParseException localParseException2)
    {
      for (;;)
      {
        Log.w("AppFlood", "first try to parse time from w3c error. time = " + paramString);
        localObject2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mmS");
        try
        {
          localObject2 = ((SimpleDateFormat)localObject2).parse(paramString);
          localObject1 = localObject2;
        }
        catch (ParseException localParseException1)
        {
          a(localParseException2, " parse time from w3c error again! S =  " + paramString);
        }
      }
    }
    Log.i("AppFlood", " time " + paramString + " date " + localObject1);
    return (Date)localObject1;
  }
  
  public static final class a
  {
    private static char[] a;
    private static byte[] b;
    
    static
    {
      int m = 0;
      a = new char[64];
      int i = 65;
      int j = 0;
      while (i <= 90)
      {
        a[j] = i;
        i = (char)(i + 1);
        j += 1;
      }
      i = 97;
      while (i <= 122)
      {
        a[j] = i;
        i = (char)(i + 1);
        j += 1;
      }
      i = 48;
      while (i <= 57)
      {
        a[j] = i;
        i = (char)(i + 1);
        j += 1;
      }
      a[j] = '+';
      a[(j + 1)] = '/';
      b = new byte[''];
      j = 0;
      int k;
      for (;;)
      {
        k = m;
        if (j >= b.length) {
          break;
        }
        b[j] = -1;
        j += 1;
      }
      while (k < 64)
      {
        b[a[k]] = ((byte)k);
        k += 1;
      }
    }
    
    public static String a(byte[] paramArrayOfByte)
    {
      return new String(a(paramArrayOfByte, paramArrayOfByte.length));
    }
    
    private static char[] a(byte[] paramArrayOfByte, int paramInt)
    {
      int i2 = ((paramInt << 2) + 2) / 3;
      char[] arrayOfChar = new char[(paramInt + 2) / 3 << 2];
      int k = 0;
      int j = 0;
      if (j < paramInt)
      {
        int m = j + 1;
        int i3 = paramArrayOfByte[j] & 0xFF;
        int n;
        if (m < paramInt)
        {
          j = paramArrayOfByte[m] & 0xFF;
          n = m + 1;
          m = j;
          j = n;
          label71:
          if (j >= paramInt) {
            break label224;
          }
          n = j + 1;
          int i1 = paramArrayOfByte[j] & 0xFF;
          j = n;
          n = i1;
          label97:
          i1 = k + 1;
          arrayOfChar[k] = a[(i3 >>> 2)];
          k = i1 + 1;
          arrayOfChar[i1] = a[((i3 & 0x3) << 4 | m >>> 4)];
          if (k >= i2) {
            break label230;
          }
          i = a[((m & 0xF) << 2 | n >>> 6)];
          label167:
          arrayOfChar[k] = i;
          k += 1;
          if (k >= i2) {
            break label236;
          }
        }
        label224:
        label230:
        label236:
        for (int i = a[(n & 0x3F)];; i = 61)
        {
          arrayOfChar[k] = i;
          k += 1;
          break;
          n = 0;
          j = m;
          m = n;
          break label71;
          n = 0;
          break label97;
          i = 61;
          break label167;
        }
      }
      return arrayOfChar;
    }
  }
  
  public static final class b
  {
    private Key a;
    private PBEParameterSpec b;
    private Cipher c;
    
    public b(String paramString, byte[] paramArrayOfByte)
    {
      try
      {
        this.a = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(new PBEKeySpec(paramString.toCharArray()));
        this.b = new PBEParameterSpec(paramArrayOfByte, 1);
        this.c = Cipher.getInstance("PBEWithMD5AndDES/CBC/PKCS5Padding");
        this.c = Cipher.getInstance("PBEWithMD5AndDES");
        return;
      }
      catch (Throwable paramString) {}
    }
    
    private String a(byte[] paramArrayOfByte)
    {
      try
      {
        this.c.init(1, this.a, this.b);
        String str = j.a.a(this.c.doFinal(paramArrayOfByte));
        return str;
      }
      catch (Throwable localThrowable) {}
      return j.a(paramArrayOfByte, "");
    }
    
    public final String a(String paramString)
    {
      try
      {
        String str = a(j.b(paramString));
        return str;
      }
      catch (Throwable localThrowable)
      {
        j.a(localThrowable, "failed to encrypt");
      }
      return paramString;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appflood/e/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */