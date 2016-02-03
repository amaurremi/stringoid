package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class Operator
  implements SafeParcelable
{
  public static final Parcelable.Creator<Operator> CREATOR = new h();
  public static final Operator sd = new Operator("=");
  public static final Operator se = new Operator("<");
  public static final Operator sf = new Operator("<=");
  public static final Operator sg = new Operator(">");
  public static final Operator sh = new Operator(">=");
  public static final Operator si = new Operator("and");
  public static final Operator sj = new Operator("or");
  public static final Operator sk = new Operator("not");
  public static final Operator sl = new Operator("contains");
  final int kg;
  final String mTag;
  
  Operator(int paramInt, String paramString)
  {
    this.kg = paramInt;
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
    h.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/drive/query/internal/Operator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */