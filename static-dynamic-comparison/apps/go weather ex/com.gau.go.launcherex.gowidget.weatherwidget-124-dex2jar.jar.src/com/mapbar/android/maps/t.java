package com.mapbar.android.maps;

import java.util.Calendar;

public class t
{
  private String a;
  private String b;
  private u c;
  private Calendar d = null;
  private Calendar e = null;
  
  public t() {}
  
  public t(String paramString)
    throws Exception
  {
    paramString = paramString.trim();
    String[] arrayOfString = paramString.split("&");
    if (arrayOfString.length <= 0) {
      throw new Exception("API Key 字段数量无效");
    }
    Object localObject = arrayOfString[0];
    if (localObject == null) {
      throw new Exception("Fingerprint is null");
    }
    this.a = ((String)localObject);
    if (arrayOfString.length > 1)
    {
      localObject = arrayOfString[1];
      if (localObject == null) {
        throw new Exception("uid 参数无效。");
      }
      localObject = ((String)localObject).trim();
      if (((String)localObject).length() > 16) {
        throw new Exception("uid 参数长度必须小于 16。");
      }
      this.b = ((String)localObject).trim();
    }
    if (arrayOfString.length > 2) {
      this.c = u.a(Integer.parseInt(arrayOfString[2]));
    }
    if (arrayOfString.length > 3)
    {
      if (!arrayOfString[3].equals(""))
      {
        localObject = Calendar.getInstance();
        ((Calendar)localObject).setTimeInMillis(Long.parseLong(arrayOfString[3], 16));
        this.d = ((Calendar)localObject);
      }
    }
    else if (arrayOfString.length > 4)
    {
      if (arrayOfString[4].equals("")) {
        break label237;
      }
      localObject = Calendar.getInstance();
      ((Calendar)localObject).setTimeInMillis(Long.parseLong(arrayOfString[4], 16));
    }
    label237:
    for (this.e = ((Calendar)localObject);; this.e = null)
    {
      if (paramString != null) {
        break label245;
      }
      throw new Exception("key 参数无效。");
      this.d = null;
      break;
    }
    label245:
    paramString.trim();
  }
  
  public final String a()
  {
    return this.a;
  }
  
  public String toString()
  {
    String str1;
    String str2;
    label20:
    String str3;
    if (this.d == null)
    {
      str1 = "";
      if (this.e != null) {
        break label110;
      }
      str2 = "";
      if (this.b != null) {
        break label124;
      }
      str3 = "";
      label30:
      if (this.c != null) {
        break label132;
      }
    }
    label110:
    label124:
    label132:
    for (String str4 = "";; str4 = String.valueOf(this.c.ordinal()))
    {
      return this.a + "&" + str3 + "&" + str4 + "&" + str1 + "&" + str2;
      str1 = Long.toHexString(this.d.getTimeInMillis());
      break;
      str2 = Long.toHexString(this.e.getTimeInMillis());
      break label20;
      str3 = this.b;
      break label30;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/mapbar/android/maps/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */