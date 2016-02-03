package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ce
  implements SafeParcelable
{
  public static final cd CREATOR = new cd();
  public final String mimeType;
  public final String oa;
  public final String ob;
  public final String oc;
  public final String od;
  public final String oe;
  public final String packageName;
  public final int versionCode;
  
  public ce(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    this.versionCode = paramInt;
    this.oa = paramString1;
    this.ob = paramString2;
    this.mimeType = paramString3;
    this.packageName = paramString4;
    this.oc = paramString5;
    this.od = paramString6;
    this.oe = paramString7;
  }
  
  public ce(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    this(1, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    cd.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/ce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */