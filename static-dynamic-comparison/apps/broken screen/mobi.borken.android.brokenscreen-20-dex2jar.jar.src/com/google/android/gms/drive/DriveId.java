package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.af;
import com.google.android.gms.internal.hn;
import com.google.android.gms.internal.me;
import com.google.android.gms.internal.mf;

public class DriveId
  implements SafeParcelable
{
  public static final Parcelable.Creator<DriveId> CREATOR = new c();
  final String HK;
  final long HL;
  final long HM;
  private volatile String HN = null;
  final int xJ;
  
  DriveId(int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    this.xJ = paramInt;
    this.HK = paramString;
    if (!"".equals(paramString)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      hn.C(bool1);
      if (paramString == null)
      {
        bool1 = bool2;
        if (paramLong1 == -1L) {}
      }
      else
      {
        bool1 = true;
      }
      hn.C(bool1);
      this.HL = paramLong1;
      this.HM = paramLong2;
      return;
    }
  }
  
  public DriveId(String paramString, long paramLong1, long paramLong2)
  {
    this(1, paramString, paramLong1, paramLong2);
  }
  
  public static DriveId aL(String paramString)
  {
    hn.f(paramString);
    return new DriveId(paramString, -1L, -1L);
  }
  
  public static DriveId decodeFromString(String paramString)
  {
    hn.b(paramString.startsWith("DriveId:"), "Invalid DriveId: " + paramString);
    return f(Base64.decode(paramString.substring("DriveId:".length()), 10));
  }
  
  static DriveId f(byte[] paramArrayOfByte)
  {
    for (;;)
    {
      af localaf;
      try
      {
        localaf = af.g(paramArrayOfByte);
        if ("".equals(localaf.Jq))
        {
          paramArrayOfByte = null;
          return new DriveId(localaf.versionCode, paramArrayOfByte, localaf.Jr, localaf.Js);
        }
      }
      catch (me paramArrayOfByte)
      {
        throw new IllegalArgumentException();
      }
      paramArrayOfByte = localaf.Jq;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final String encodeToString()
  {
    if (this.HN == null)
    {
      String str = Base64.encodeToString(gf(), 10);
      this.HN = ("DriveId:" + str);
    }
    return this.HN;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof DriveId)) {}
    do
    {
      return false;
      paramObject = (DriveId)paramObject;
      if (((DriveId)paramObject).HM != this.HM)
      {
        Log.w("DriveId", "Attempt to compare invalid DriveId detected. Has local storage been cleared?");
        return false;
      }
      if ((((DriveId)paramObject).HL == -1L) && (this.HL == -1L)) {
        return ((DriveId)paramObject).HK.equals(this.HK);
      }
    } while (((DriveId)paramObject).HL != this.HL);
    return true;
  }
  
  public String getResourceId()
  {
    return this.HK;
  }
  
  final byte[] gf()
  {
    af localaf = new af();
    localaf.versionCode = this.xJ;
    if (this.HK == null) {}
    for (String str = "";; str = this.HK)
    {
      localaf.Jq = str;
      localaf.Jr = this.HL;
      localaf.Js = this.HM;
      return mf.d(localaf);
    }
  }
  
  public int hashCode()
  {
    if (this.HL == -1L) {
      return this.HK.hashCode();
    }
    return (String.valueOf(this.HM) + String.valueOf(this.HL)).hashCode();
  }
  
  public String toString()
  {
    return encodeToString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    c.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/drive/DriveId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */