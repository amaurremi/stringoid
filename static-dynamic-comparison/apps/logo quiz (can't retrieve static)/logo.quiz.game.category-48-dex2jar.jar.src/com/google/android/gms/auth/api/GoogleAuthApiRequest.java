package com.google.android.gms.auth.api;

import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class GoogleAuthApiRequest
  implements SafeParcelable
{
  public static final GoogleAuthApiRequestCreator CREATOR = new GoogleAuthApiRequestCreator();
  public static final String DEFAULT_SCOPE_PREFIX = "oauth2:";
  public static final int HTTP_METHOD_DELETE = 3;
  public static final int HTTP_METHOD_GET = 0;
  public static final int HTTP_METHOD_HEAD = 4;
  public static final int HTTP_METHOD_OPTIONS = 5;
  public static final int HTTP_METHOD_PATCH = 7;
  public static final int HTTP_METHOD_POST = 1;
  public static final int HTTP_METHOD_PUT = 2;
  public static final int HTTP_METHOD_TRACE = 6;
  public static final int VERSION_CODE = 1;
  byte[] DA;
  long DB;
  String Dt;
  Bundle Du;
  String Dv;
  List<String> Dw;
  String Dx;
  int Dy;
  Bundle Dz;
  String name;
  String version;
  final int versionCode;
  String yR;
  
  GoogleAuthApiRequest(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, Bundle paramBundle1, String paramString5, List<String> paramList, String paramString6, int paramInt2, Bundle paramBundle2, byte[] paramArrayOfByte, long paramLong)
  {
    this.versionCode = paramInt1;
    this.name = paramString1;
    this.version = paramString2;
    this.Dt = paramString3;
    this.yR = paramString4;
    this.Du = paramBundle1;
    this.Dv = paramString5;
    this.Dw = paramList;
    this.Dx = paramString6;
    this.Dy = paramInt2;
    this.Dz = paramBundle2;
    this.DA = paramArrayOfByte;
    this.DB = paramLong;
  }
  
  public GoogleAuthApiRequest(String paramString1, String paramString2, String paramString3)
  {
    this.versionCode = 1;
    this.name = paramString1;
    ay(paramString2);
    this.Dt = paramString3;
    this.Du = new Bundle();
    this.Dw = new ArrayList();
    this.Dx = "oauth2:";
    this.Dz = new Bundle();
    this.DA = new byte[0];
  }
  
  public GoogleAuthApiRequest(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this.versionCode = 1;
    this.name = paramString1;
    ay(paramString2);
    setPath(paramString3);
    T(paramInt);
    this.Du = new Bundle();
    this.Dw = new ArrayList();
    this.Dx = "oauth2:";
    this.Dz = new Bundle();
    this.DA = new byte[0];
  }
  
  private void T(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 7)) {
      throw new IllegalArgumentException("Invalid HTTP method.");
    }
    this.Dy = paramInt;
  }
  
  private void ay(String paramString)
  {
    String str = paramString;
    if (paramString.charAt(0) >= '0')
    {
      str = paramString;
      if (paramString.charAt(0) <= '9') {
        str = "v" + paramString;
      }
    }
    this.version = str;
  }
  
  private void setPath(String paramString)
  {
    String str = paramString;
    if (paramString.charAt(0) == '/') {
      str = paramString.substring(1);
    }
    paramString = str;
    if (str.charAt(str.length() - 1) == '/') {
      paramString = str.substring(0, str.length() - 1);
    }
    this.yR = paramString;
  }
  
  public void addParameter(String paramString1, String paramString2)
  {
    if (!this.Du.containsKey(paramString1))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramString2);
      this.Du.putStringArrayList(paramString1, localArrayList);
      return;
    }
    this.Du.getStringArrayList(paramString1).add(paramString2);
  }
  
  public void addScope(String paramString)
  {
    this.Dw.add(paramString);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getAccountName()
  {
    return this.Dv;
  }
  
  public String getApiId()
  {
    return this.Dt;
  }
  
  public String getFullScope()
  {
    String str = getScope();
    if (str == null) {
      return null;
    }
    return this.Dx + str;
  }
  
  public String getHeader(String paramString)
  {
    return this.Dz.getString(paramString);
  }
  
  public Bundle getHeaders()
  {
    return this.Dz;
  }
  
  public Map<String, String> getHeadersAsMap()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.Dz.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashMap.put(str, this.Dz.getString(str));
    }
    return localHashMap;
  }
  
  public byte[] getHttpBody()
  {
    return this.DA;
  }
  
  public JSONObject getHttpBodyAsJson()
    throws JSONException
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(new String(this.DA, "UTF-8"));
      return localJSONObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      Log.e("GoogleAuthApiRequest", "Unsupported encoding error.");
    }
    return null;
  }
  
  public int getHttpMethod()
  {
    return this.Dy;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public Bundle getParameters()
  {
    return this.Du;
  }
  
  public Map<String, List<String>> getParametersAsMap()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.Du.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashMap.put(str, this.Du.getStringArrayList(str));
    }
    return localHashMap;
  }
  
  public String getPath()
  {
    return this.yR;
  }
  
  public String getScope()
  {
    if (this.Dw.size() == 0) {
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < this.Dw.size())
    {
      localStringBuffer.append((String)this.Dw.get(i));
      if (i != this.Dw.size() - 1) {
        localStringBuffer.append(" ");
      }
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public long getTimeout()
  {
    return this.DB;
  }
  
  public String getVersion()
  {
    return this.version;
  }
  
  public void putHeader(String paramString1, String paramString2)
  {
    this.Dz.putString(paramString1, paramString2);
  }
  
  public void setAccountName(String paramString)
  {
    this.Dv = paramString;
  }
  
  public void setHttpBody(String paramString)
  {
    try
    {
      this.DA = paramString.getBytes("UTF-8");
      return;
    }
    catch (UnsupportedEncodingException paramString)
    {
      Log.e("GoogleAuthApiRequest", "Unsupported encoding error.");
    }
  }
  
  public void setTimeout(long paramLong)
  {
    this.DB = paramLong;
  }
  
  public String toString()
  {
    return "{ API: " + this.name + "/" + this.version + ", Scope: " + getFullScope() + ", Account: " + getAccountName() + " }";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    GoogleAuthApiRequestCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/auth/api/GoogleAuthApiRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */