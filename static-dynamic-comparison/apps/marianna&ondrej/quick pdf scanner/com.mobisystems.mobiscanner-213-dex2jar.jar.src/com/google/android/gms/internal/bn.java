package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class bn
  implements SafeParcelable
{
  public static final aq Cs = new aq();
  public final String Ct;
  public final String Cu;
  public final String Cv;
  public final String Cw;
  public final String Cx;
  public final String mimeType;
  public final String packageName;
  public final int versionCode;
  
  public bn(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    this.versionCode = paramInt;
    this.Ct = paramString1;
    this.Cu = paramString2;
    this.mimeType = paramString3;
    this.packageName = paramString4;
    this.Cv = paramString5;
    this.Cw = paramString6;
    this.Cx = paramString7;
  }
  
  public bn(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    this(1, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    aq.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/bn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */