package com.google.android.gms.drive.metadata;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hm;

public class CustomPropertyKey
  implements SafeParcelable
{
  public static final Parcelable.Creator<CustomPropertyKey> CREATOR = new c();
  final String JL;
  final int JM;
  final int xM;
  
  CustomPropertyKey(int paramInt1, String paramString, int paramInt2)
  {
    this.xM = paramInt1;
    hm.b(paramString, "key");
    boolean bool1 = bool2;
    if (paramInt2 != 0) {
      if (paramInt2 != 1) {
        break label54;
      }
    }
    label54:
    for (bool1 = bool2;; bool1 = false)
    {
      hm.a(bool1, "visibility must be either PUBLIC or PRIVATE");
      this.JL = paramString;
      this.JM = paramInt2;
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == null) {}
    do
    {
      return false;
      if (paramObject == this) {
        return true;
      }
    } while (!(paramObject instanceof CustomPropertyKey));
    paramObject = (CustomPropertyKey)paramObject;
    if ((((CustomPropertyKey)paramObject).getKey().equals(this.JL)) && (((CustomPropertyKey)paramObject).getVisibility() == this.JM)) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public String getKey()
  {
    return this.JL;
  }
  
  public int getVisibility()
  {
    return this.JM;
  }
  
  public int hashCode()
  {
    return (this.JL + this.JM).hashCode();
  }
  
  public String toString()
  {
    return "CustomPropertyKey(" + this.JL + "," + this.JM + ")";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    c.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/metadata/CustomPropertyKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */