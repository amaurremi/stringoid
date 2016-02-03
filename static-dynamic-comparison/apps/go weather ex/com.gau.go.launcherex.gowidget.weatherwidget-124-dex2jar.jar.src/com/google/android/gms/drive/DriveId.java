package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.y;
import com.google.android.gms.internal.fq;
import com.google.android.gms.internal.ks;
import com.google.android.gms.internal.kt;

public class DriveId
  implements SafeParcelable
{
  public static final Parcelable.Creator<DriveId> CREATOR = new d();
  final String EH;
  final long EI;
  final long EJ;
  private volatile String EK = null;
  final int xH;
  
  DriveId(int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    this.xH = paramInt;
    this.EH = paramString;
    if (!"".equals(paramString)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      fq.z(bool1);
      if (paramString == null)
      {
        bool1 = bool2;
        if (paramLong1 == -1L) {}
      }
      else
      {
        bool1 = true;
      }
      fq.z(bool1);
      this.EI = paramLong1;
      this.EJ = paramLong2;
      return;
    }
  }
  
  public DriveId(String paramString, long paramLong1, long paramLong2)
  {
    this(1, paramString, paramLong1, paramLong2);
  }
  
  public static DriveId aw(String paramString)
  {
    fq.f(paramString);
    return new DriveId(paramString, -1L, -1L);
  }
  
  public static DriveId decodeFromString(String paramString)
  {
    fq.b(paramString.startsWith("DriveId:"), "Invalid DriveId: " + paramString);
    return f(Base64.decode(paramString.substring("DriveId:".length()), 10));
  }
  
  static DriveId f(byte[] paramArrayOfByte)
  {
    for (;;)
    {
      y localy;
      try
      {
        localy = y.g(paramArrayOfByte);
        if ("".equals(localy.FC))
        {
          paramArrayOfByte = null;
          return new DriveId(localy.versionCode, paramArrayOfByte, localy.FD, localy.FE);
        }
      }
      catch (ks paramArrayOfByte)
      {
        throw new IllegalArgumentException();
      }
      paramArrayOfByte = localy.FC;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final String encodeToString()
  {
    if (this.EK == null)
    {
      String str = Base64.encodeToString(fC(), 10);
      this.EK = ("DriveId:" + str);
    }
    return this.EK;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof DriveId)) {}
    do
    {
      return false;
      paramObject = (DriveId)paramObject;
      if (((DriveId)paramObject).EJ != this.EJ)
      {
        Log.w("DriveId", "Attempt to compare invalid DriveId detected. Has local storage been cleared?");
        return false;
      }
      if ((((DriveId)paramObject).EI == -1L) && (this.EI == -1L)) {
        return ((DriveId)paramObject).EH.equals(this.EH);
      }
    } while (((DriveId)paramObject).EI != this.EI);
    return true;
  }
  
  final byte[] fC()
  {
    y localy = new y();
    localy.versionCode = this.xH;
    if (this.EH == null) {}
    for (String str = "";; str = this.EH)
    {
      localy.FC = str;
      localy.FD = this.EI;
      localy.FE = this.EJ;
      return kt.d(localy);
    }
  }
  
  public String getResourceId()
  {
    return this.EH;
  }
  
  public int hashCode()
  {
    if (this.EI == -1L) {
      return this.EH.hashCode();
    }
    return (String.valueOf(this.EJ) + String.valueOf(this.EI)).hashCode();
  }
  
  public String toString()
  {
    return encodeToString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    d.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/drive/DriveId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */