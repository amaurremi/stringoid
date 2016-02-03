package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class db
  implements SafeParcelable
{
  public static final cg FJ = new cg();
  public String FK;
  public int FL;
  public int FM;
  public boolean FN;
  public final int versionCode;
  
  public db(int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  db(int paramInt1, String paramString, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    this.versionCode = paramInt1;
    this.FK = paramString;
    this.FL = paramInt2;
    this.FM = paramInt3;
    this.FN = paramBoolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    cg.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/db.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */