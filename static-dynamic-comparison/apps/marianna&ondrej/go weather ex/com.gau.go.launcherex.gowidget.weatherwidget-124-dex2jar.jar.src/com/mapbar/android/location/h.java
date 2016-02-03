package com.mapbar.android.location;

import android.location.Address;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONObject;

public final class h
{
  private static Hashtable<String, String> a = new Hashtable();
  private static Hashtable<String, String> b = new Hashtable();
  private static String c = "中国";
  
  static
  {
    a.put("a", "0");
    a.put("b", "1");
    a.put("e", "2");
    a.put("f", "3");
    a.put("n", "4");
    a.put("m", "5");
    a.put("k", "6");
    a.put("l", "7");
    a.put("g", "8");
    a.put("h", "9");
    b.put("0", "a");
    b.put("1", "b");
    b.put("2", "e");
    b.put("3", "f");
    b.put("4", "n");
    b.put("5", "m");
    b.put("6", "k");
    b.put("7", "l");
    b.put("8", "g");
    b.put("9", "h");
  }
  
  public static int a(String paramString)
  {
    try
    {
      StringBuffer localStringBuffer = new StringBuffer();
      int i = 0;
      while (i < paramString.length())
      {
        localStringBuffer.append((String)a.get(String.valueOf(paramString.charAt(i))));
        i += 1;
      }
      i = Integer.parseInt(localStringBuffer.toString());
      return i;
    }
    catch (Exception paramString) {}
    return -1;
  }
  
  public static String a(int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    String str = String.valueOf(paramInt);
    if (str.length() < 8)
    {
      int i = str.length();
      paramInt = 0;
      while (paramInt < 8 - i)
      {
        localStringBuffer.append("a");
        paramInt += 1;
      }
    }
    paramInt = 0;
    while (paramInt < str.length())
    {
      localStringBuffer.append((String)b.get(String.valueOf(str.charAt(paramInt))));
      paramInt += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static List<Address> a(Locale paramLocale, String paramString)
  {
    Object localObject2;
    for (;;)
    {
      Object localObject4;
      String str4;
      int j;
      try
      {
        Object localObject1 = new JSONObject(paramString);
        localObject2 = ((JSONObject)localObject1).getString("districtName");
        paramString = ((JSONObject)localObject1).getString("cityName");
        String str1 = ((JSONObject)localObject1).getString("provinceName");
        localObject1 = ((JSONObject)localObject1).getJSONObject("poiList");
        if (((JSONObject)localObject1).getInt("poiItemCount") == 0) {
          return null;
        }
        localObject1 = ((JSONObject)localObject1).getJSONArray("poiItemList");
        int k = ((JSONArray)localObject1).length();
        StringBuilder localStringBuilder = new StringBuilder();
        if ((str1 != null) && (!"直辖市".equals(str1)) && (str1.trim().length() > 0)) {
          localStringBuilder.append(str1);
        }
        if ((paramString != null) && (paramString.trim().length() > 0)) {
          localStringBuilder.append(paramString);
        }
        if ((localObject2 != null) && (((String)localObject2).trim().length() > 0)) {
          localStringBuilder.append((String)localObject2);
        }
        localObject2 = new ArrayList();
        int i = 0;
        if (i >= k) {
          break;
        }
        localObject4 = (JSONObject)((JSONArray)localObject1).get(i);
        ((JSONObject)localObject4).getString("poiDirection");
        ((JSONObject)localObject4).getString("poiType");
        ((JSONObject)localObject4).getString("poiId");
        ((JSONObject)localObject4).getInt("poiCommentScore");
        ((JSONObject)localObject4).getString("poiDistance");
        ((JSONObject)localObject4).getString("poiCity");
        ((JSONObject)localObject4).getInt("poiCommentCount");
        ((JSONObject)localObject4).getString("poiDistrict");
        Object localObject3 = ((JSONObject)localObject4).getString("poiLatLon");
        String str2 = ((JSONObject)localObject4).getString("poiName");
        String str3 = ((JSONObject)localObject4).getString("poiAddress");
        ((JSONObject)localObject4).getString("roadDistance");
        ((JSONObject)localObject4).getString("roadDirection");
        ((JSONObject)localObject4).getString("roadLevel");
        str4 = ((JSONObject)localObject4).getString("roadName");
        localObject4 = new Address(paramLocale);
        j = 1;
        ((Address)localObject4).setAddressLine(0, c);
        if (localStringBuilder.toString().trim().length() > 0)
        {
          j = 2;
          ((Address)localObject4).setAddressLine(1, localStringBuilder.toString());
        }
        if ((str3 != null) && (str3.trim().length() > 0))
        {
          ((Address)localObject4).setAddressLine(j, str3);
          if ((str2 == null) || (str2.trim().length() <= 0)) {
            break label621;
          }
          ((Address)localObject4).setFeatureName(str2);
          ((Address)localObject4).setCountryName(c);
          ((Address)localObject4).setCountryCode("CN");
          if ((str1 == null) || ("直辖市".equals(str1)) || (str1.trim().length() <= 0)) {
            break label647;
          }
          ((Address)localObject4).setAdminArea(str1);
          ((Address)localObject4).setLocality(paramString);
          if ((str4 != null) && (str4.trim().length() > 0)) {
            ((Address)localObject4).setThoroughfare(str4);
          }
          if ((localObject3 == null) || (((String)localObject3).indexOf(",") <= 0)) {
            break label656;
          }
          localObject3 = ((String)localObject3).split(",");
          ((Address)localObject4).setLongitude(a(localObject3[0]) / 100000.0D);
          ((Address)localObject4).setLatitude(a(localObject3[1]) / 100000.0D);
          ((List)localObject2).add(localObject4);
          i += 1;
          continue;
        }
        if ((str2 != null) && (str2.trim().length() > 0))
        {
          ((Address)localObject4).setAddressLine(j, str2);
          continue;
        }
        if (str4 == null) {
          continue;
        }
      }
      catch (Exception paramLocale)
      {
        paramLocale.printStackTrace();
        return null;
      }
      if (str4.trim().length() > 0)
      {
        ((Address)localObject4).setAddressLine(j, str4);
        continue;
        label621:
        if ((str4 != null) && (str4.trim().length() > 0))
        {
          ((Address)localObject4).setFeatureName(str4);
          continue;
          label647:
          ((Address)localObject4).setAdminArea(paramString);
          continue;
          label656:
          ((Address)localObject4).setLatitude(0.0D);
          ((Address)localObject4).setLongitude(0.0D);
        }
      }
    }
    return (List<Address>)localObject2;
  }
  
  public static Vector<String> a(String paramString1, String paramString2)
  {
    Vector localVector = new Vector();
    String str = paramString1.trim();
    paramString1 = str;
    if (!str.startsWith(paramString2)) {
      paramString1 = paramString2 + str;
    }
    str = paramString1;
    if (!paramString1.endsWith(paramString2)) {
      str = paramString1 + paramString2;
    }
    int j;
    for (int i = str.indexOf(paramString2);; i = j)
    {
      j = str.indexOf(paramString2, i + 1);
      if (j == -1) {
        break;
      }
      localVector.addElement(str.substring(i + 1, j));
    }
    return localVector;
  }
  
  public static Vector<String[]> a(Vector<String> paramVector)
  {
    Vector localVector = new Vector();
    if (!((String)paramVector.elementAt(0)).equals("$#")) {
      return localVector;
    }
    try
    {
      i = Integer.parseInt((String)paramVector.elementAt(1));
      if (i < 0) {
        return localVector;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      int i;
      for (;;)
      {
        i = 0;
      }
      int n = Integer.parseInt((String)paramVector.elementAt(4));
      int k = 5;
      int j = 0;
      while (j <= i)
      {
        String[] arrayOfString = new String[n];
        int m = 0;
        while (m < n)
        {
          arrayOfString[m] = ((String)paramVector.elementAt(k));
          m += 1;
          k += 1;
        }
        localVector.addElement(arrayOfString);
        j += 1;
      }
    }
    return localVector;
  }
  
  public static List<Address> b(Locale paramLocale, String paramString)
  {
    String[] arrayOfString = paramString.split("\\|");
    if ((arrayOfString == null) || (arrayOfString.length < 6)) {
      return null;
    }
    if (!arrayOfString[1].equals("$#")) {
      return null;
    }
    int n;
    int m;
    try
    {
      n = Integer.parseInt(arrayOfString[2]);
      m = Integer.parseInt(arrayOfString[5]);
      if (n < 0) {
        return null;
      }
    }
    catch (NumberFormatException paramLocale)
    {
      return null;
    }
    int i = m + 5;
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    if (j < n) {}
    for (;;)
    {
      try
      {
        localAddress = new Address(paramLocale);
        if (j > 1) {
          break label674;
        }
        k = m * j;
        i = k + i;
        if (m <= 0) {
          continue;
        }
      }
      catch (Exception paramString)
      {
        Address localAddress;
        StringBuilder localStringBuilder;
        continue;
        String str6 = null;
        continue;
        String str5 = null;
        continue;
        String str4 = null;
        continue;
        String str3 = null;
        continue;
        String str2 = null;
        continue;
        String str1 = null;
        continue;
        paramString = null;
        continue;
        j += 1;
      }
      try
      {
        if (i + 1 >= arrayOfString.length) {
          continue;
        }
        paramString = arrayOfString[(i + 1)];
        if ((m < 3) || (i + 3 >= arrayOfString.length)) {
          continue;
        }
        str1 = arrayOfString[(i + 3)];
        if ((m < 4) || (i + 4 >= arrayOfString.length)) {
          continue;
        }
        str2 = arrayOfString[(i + 4)];
        if ((m < 6) || (i + 6 >= arrayOfString.length)) {
          continue;
        }
        str3 = arrayOfString[(i + 6)];
        if ((m < 10) || (i + 10 >= arrayOfString.length)) {
          continue;
        }
        str4 = arrayOfString[(i + 10)];
        if ((m < 11) || (i + 11 >= arrayOfString.length)) {
          continue;
        }
        str5 = arrayOfString[(i + 11)];
        if ((m < 12) || (i + 12 >= arrayOfString.length)) {
          continue;
        }
        str6 = arrayOfString[(i + 12)];
        k = 1;
        localAddress.setAddressLine(0, "中国");
        localStringBuilder = new StringBuilder();
        if ((str4 != null) && (!"直辖市".equals(str4)) && (str4.trim().length() > 0)) {
          localStringBuilder.append(str4);
        }
        if ((str5 != null) && (str5.trim().length() > 0)) {
          localStringBuilder.append(str5);
        }
        if ((str6 != null) && (str6.trim().length() > 0)) {
          localStringBuilder.append(str6);
        }
        if (localStringBuilder.toString().trim().length() > 0)
        {
          k = 2;
          localAddress.setAddressLine(1, localStringBuilder.toString());
        }
        if ((str1 != null) && (str1.trim().length() > 0))
        {
          localAddress.setAddressLine(k, str1);
          if ((str4 == null) || ("直辖市".equals(str4)) || (str4.trim().length() <= 0)) {
            continue;
          }
          localAddress.setAdminArea(str4);
          localAddress.setLocality(str5);
          localAddress.setCountryName("中国");
          localAddress.setCountryCode("CN");
          localAddress.setFeatureName(paramString);
          if ((str2 != null) && (str2.trim().length() > 0)) {
            localAddress.setPhone(str2);
          }
          if ((str3 != null) && (str3.indexOf(",") > 0))
          {
            paramString = str3.split(",");
            localAddress.setLongitude(a(paramString[0]) / 100000.0D);
            localAddress.setLatitude(a(paramString[1]) / 100000.0D);
          }
          localArrayList.add(localAddress);
          continue;
        }
        localAddress.setAddressLine(k, paramString);
        continue;
        paramString.printStackTrace();
      }
      catch (Exception paramString) {}
      continue;
      localAddress.setAdminArea(str5);
      continue;
      return localArrayList;
      break;
      label674:
      int k = m;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/mapbar/android/location/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */