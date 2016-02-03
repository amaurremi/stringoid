package com.google.android.gms.auth.api;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class GoogleAuthApiResponse
  implements SafeParcelable
{
  public static final GoogleAuthApiResponseCreator CREATOR = new GoogleAuthApiResponseCreator();
  final byte[] DA;
  final Bundle Dz;
  final int responseCode;
  final int versionCode;
  
  public GoogleAuthApiResponse(int paramInt1, int paramInt2, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    this.versionCode = paramInt1;
    this.responseCode = paramInt2;
    this.Dz = paramBundle;
    this.DA = paramArrayOfByte;
  }
  
  public GoogleAuthApiResponse(int paramInt, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    this.versionCode = 1;
    this.responseCode = paramInt;
    this.Dz = paramBundle;
    this.DA = paramArrayOfByte;
  }
  
  public GoogleAuthApiResponse(int paramInt, Map<String, String> paramMap, byte[] paramArrayOfByte)
  {
    this(paramInt, B(paramMap), paramArrayOfByte);
  }
  
  private static Bundle B(Map<String, String> paramMap)
  {
    Bundle localBundle = new Bundle();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localBundle.putString((String)localEntry.getKey(), (String)localEntry.getValue());
    }
    return localBundle;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public byte[] getBody()
  {
    return this.DA;
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
  
  public int getResponseCode()
  {
    return this.responseCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    GoogleAuthApiResponseCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/auth/api/GoogleAuthApiResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */