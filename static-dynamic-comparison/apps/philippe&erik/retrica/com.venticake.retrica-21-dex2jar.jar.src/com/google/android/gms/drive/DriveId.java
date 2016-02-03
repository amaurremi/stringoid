package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.af;
import com.google.android.gms.internal.hm;
import com.google.android.gms.internal.md;
import com.google.android.gms.internal.me;

public class DriveId
  implements SafeParcelable
{
  public static final Parcelable.Creator<DriveId> CREATOR = new c();
  final String HN;
  final long HO;
  final long HP;
  private volatile String HQ = null;
  final int xM;
  
  DriveId(int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    this.xM = paramInt;
    this.HN = paramString;
    if (!"".equals(paramString)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      hm.C(bool1);
      if (paramString == null)
      {
        bool1 = bool2;
        if (paramLong1 == -1L) {}
      }
      else
      {
        bool1 = true;
      }
      hm.C(bool1);
      this.HO = paramLong1;
      this.HP = paramLong2;
      return;
    }
  }
  
  public DriveId(String paramString, long paramLong1, long paramLong2)
  {
    this(1, paramString, paramLong1, paramLong2);
  }
  
  public static DriveId aL(String paramString)
  {
    hm.f(paramString);
    return new DriveId(paramString, -1L, -1L);
  }
  
  public static DriveId decodeFromString(String paramString)
  {
    hm.b(paramString.startsWith("DriveId:"), "Invalid DriveId: " + paramString);
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
        if ("".equals(localaf.Jt))
        {
          paramArrayOfByte = null;
          return new DriveId(localaf.versionCode, paramArrayOfByte, localaf.Ju, localaf.Jv);
        }
      }
      catch (md paramArrayOfByte)
      {
        throw new IllegalArgumentException();
      }
      paramArrayOfByte = localaf.Jt;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final String encodeToString()
  {
    if (this.HQ == null)
    {
      String str = Base64.encodeToString(gk(), 10);
      this.HQ = ("DriveId:" + str);
    }
    return this.HQ;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof DriveId)) {}
    do
    {
      return false;
      paramObject = (DriveId)paramObject;
      if (((DriveId)paramObject).HP != this.HP)
      {
        Log.w("DriveId", "Attempt to compare invalid DriveId detected. Has local storage been cleared?");
        return false;
      }
      if ((((DriveId)paramObject).HO == -1L) && (this.HO == -1L)) {
        return ((DriveId)paramObject).HN.equals(this.HN);
      }
    } while (((DriveId)paramObject).HO != this.HO);
    return true;
  }
  
  public String getResourceId()
  {
    return this.HN;
  }
  
  final byte[] gk()
  {
    af localaf = new af();
    localaf.versionCode = this.xM;
    if (this.HN == null) {}
    for (String str = "";; str = this.HN)
    {
      localaf.Jt = str;
      localaf.Ju = this.HO;
      localaf.Jv = this.HP;
      return me.d(localaf);
    }
  }
  
  public int hashCode()
  {
    if (this.HO == -1L) {
      return this.HN.hashCode();
    }
    return (String.valueOf(this.HP) + String.valueOf(this.HO)).hashCode();
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/DriveId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */