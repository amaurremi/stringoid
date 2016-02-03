package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class Operator
  implements SafeParcelable
{
  public static final Parcelable.Creator<Operator> CREATOR = new j();
  public static final Operator GU = new Operator("=");
  public static final Operator GV = new Operator("<");
  public static final Operator GW = new Operator("<=");
  public static final Operator GX = new Operator(">");
  public static final Operator GY = new Operator(">=");
  public static final Operator GZ = new Operator("and");
  public static final Operator Ha = new Operator("or");
  public static final Operator Hb = new Operator("not");
  public static final Operator Hc = new Operator("contains");
  final String mTag;
  final int xH;
  
  Operator(int paramInt, String paramString)
  {
    this.xH = paramInt;
    this.mTag = paramString;
  }
  
  private Operator(String paramString)
  {
    this(1, paramString);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        paramObject = (Operator)paramObject;
        if (this.mTag != null) {
          break;
        }
      } while (((Operator)paramObject).mTag == null);
      return false;
    } while (this.mTag.equals(((Operator)paramObject).mTag));
    return false;
  }
  
  public int hashCode()
  {
    if (this.mTag == null) {}
    for (int i = 0;; i = this.mTag.hashCode()) {
      return i + 31;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    j.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/drive/query/internal/Operator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */