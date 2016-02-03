package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.common.images.WebImage;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class dp
{
  private static final dk lA = new dk("MetadataUtils");
  private static final String[] mx = { "Z", "+hh", "+hhmm", "+hh:mm" };
  private static final String my = "yyyyMMdd'T'HHmmss" + mx[0];
  
  public static Calendar G(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      lA.b("Input string is empty or null", new Object[0]);
      return null;
    }
    Object localObject2 = H(paramString);
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      lA.b("Invalid date format", new Object[0]);
      return null;
    }
    String str = I(paramString);
    paramString = "yyyyMMdd";
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty(str))
    {
      localObject1 = (String)localObject2 + "T" + str;
      if (str.length() != "HHmmss".length()) {
        break label127;
      }
    }
    for (paramString = "yyyyMMdd'T'HHmmss";; paramString = my)
    {
      localObject2 = GregorianCalendar.getInstance();
      try
      {
        paramString = new SimpleDateFormat(paramString).parse((String)localObject1);
        ((Calendar)localObject2).setTime(paramString);
        return (Calendar)localObject2;
      }
      catch (ParseException paramString)
      {
        label127:
        lA.b("Error parsing string: %s", new Object[] { paramString.getMessage() });
      }
    }
    return null;
  }
  
  private static String H(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      lA.b("Input string is empty or null", new Object[0]);
      return null;
    }
    try
    {
      paramString = paramString.substring(0, "yyyyMMdd".length());
      return paramString;
    }
    catch (IndexOutOfBoundsException paramString)
    {
      lA.c("Error extracting the date: %s", new Object[] { paramString.getMessage() });
    }
    return null;
  }
  
  private static String I(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      lA.b("string is empty or null", new Object[0]);
    }
    do
    {
      do
      {
        return null;
        int i = paramString.indexOf('T');
        if (i != "yyyyMMdd".length())
        {
          lA.b("T delimeter is not found", new Object[0]);
          return null;
        }
        try
        {
          paramString = paramString.substring(i + 1);
          if (paramString.length() == "HHmmss".length()) {
            return paramString;
          }
        }
        catch (IndexOutOfBoundsException paramString)
        {
          lA.b("Error extracting the time substring: %s", new Object[] { paramString.getMessage() });
          return null;
        }
        switch (paramString.charAt("HHmmss".length()))
        {
        default: 
          return null;
        }
      } while (!J(paramString));
      return paramString.replaceAll("([\\+\\-]\\d\\d):(\\d\\d)", "$1$2");
    } while (paramString.length() != "HHmmss".length() + mx[0].length());
    return paramString.substring(0, paramString.length() - 1) + "+0000";
  }
  
  private static boolean J(String paramString)
  {
    int i = paramString.length();
    int j = "HHmmss".length();
    return (i == mx[1].length() + j) || (i == mx[2].length() + j) || (i == j + mx[3].length());
  }
  
  public static String a(Calendar paramCalendar)
  {
    if (paramCalendar == null)
    {
      lA.b("Calendar object cannot be null", new Object[0]);
      paramCalendar = null;
    }
    Object localObject;
    do
    {
      return paramCalendar;
      String str = my;
      localObject = str;
      if (paramCalendar.get(11) == 0)
      {
        localObject = str;
        if (paramCalendar.get(12) == 0)
        {
          localObject = str;
          if (paramCalendar.get(13) == 0) {
            localObject = "yyyyMMdd";
          }
        }
      }
      localObject = new SimpleDateFormat((String)localObject);
      ((SimpleDateFormat)localObject).setTimeZone(paramCalendar.getTimeZone());
      localObject = ((SimpleDateFormat)localObject).format(paramCalendar.getTime());
      paramCalendar = (Calendar)localObject;
    } while (!((String)localObject).endsWith("+0000"));
    return ((String)localObject).replace("+0000", mx[0]);
  }
  
  /* Error */
  public static void a(List<WebImage> paramList, JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokeinterface 193 1 0
    //   6: aload_1
    //   7: ldc -61
    //   9: invokevirtual 201	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   12: astore_1
    //   13: aload_1
    //   14: invokevirtual 204	org/json/JSONArray:length	()I
    //   17: istore_3
    //   18: iconst_0
    //   19: istore_2
    //   20: iload_2
    //   21: iload_3
    //   22: if_icmpge +34 -> 56
    //   25: aload_1
    //   26: iload_2
    //   27: invokevirtual 208	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   30: astore 4
    //   32: aload_0
    //   33: new 210	com/google/android/gms/common/images/WebImage
    //   36: dup
    //   37: aload 4
    //   39: invokespecial 213	com/google/android/gms/common/images/WebImage:<init>	(Lorg/json/JSONObject;)V
    //   42: invokeinterface 217 2 0
    //   47: pop
    //   48: iload_2
    //   49: iconst_1
    //   50: iadd
    //   51: istore_2
    //   52: goto -32 -> 20
    //   55: astore_0
    //   56: return
    //   57: astore 4
    //   59: goto -11 -> 48
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	paramList	List<WebImage>
    //   0	62	1	paramJSONObject	JSONObject
    //   19	33	2	i	int
    //   17	6	3	j	int
    //   30	8	4	localJSONObject	JSONObject
    //   57	1	4	localIllegalArgumentException	IllegalArgumentException
    // Exception table:
    //   from	to	target	type
    //   0	18	55	org/json/JSONException
    //   25	32	55	org/json/JSONException
    //   32	48	55	org/json/JSONException
    //   32	48	57	java/lang/IllegalArgumentException
  }
  
  public static void a(JSONObject paramJSONObject, List<WebImage> paramList)
  {
    JSONArray localJSONArray;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      localJSONArray = new JSONArray();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localJSONArray.put(((WebImage)paramList.next()).aP());
      }
    }
    try
    {
      paramJSONObject.put("images", localJSONArray);
      return;
    }
    catch (JSONException paramJSONObject) {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/dp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */