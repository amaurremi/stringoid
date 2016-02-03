package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class bj
  implements SafeParcelable
{
  public static final bi CREATOR = new bi();
  public final String gn;
  public final String go;
  public final String gp;
  public final String gq;
  public final String gr;
  public final String mimeType;
  public final String packageName;
  public final int versionCode;
  
  public bj(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    this.versionCode = paramInt;
    this.gn = paramString1;
    this.go = paramString2;
    this.mimeType = paramString3;
    this.packageName = paramString4;
    this.gp = paramString5;
    this.gq = paramString6;
    this.gr = paramString7;
  }
  
  public bj(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    this(1, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    bi.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/bj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */