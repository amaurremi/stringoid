package com.google.android.gms.drive.metadata;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hn;

public class CustomPropertyKey
  implements SafeParcelable
{
  public static final Parcelable.Creator<CustomPropertyKey> CREATOR = new c();
  final String JI;
  final int JJ;
  final int xJ;
  
  CustomPropertyKey(int paramInt1, String paramString, int paramInt2)
  {
    this.xJ = paramInt1;
    hn.b(paramString, "key");
    boolean bool1 = bool2;
    if (paramInt2 != 0) {
      if (paramInt2 != 1) {
        break label54;
      }
    }
    label54:
    for (bool1 = bool2;; bool1 = false)
    {
      hn.a(bool1, "visibility must be either PUBLIC or PRIVATE");
      this.JI = paramString;
      this.JJ = paramInt2;
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
    if ((((CustomPropertyKey)paramObject).getKey().equals(this.JI)) && (((CustomPropertyKey)paramObject).getVisibility() == this.JJ)) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public String getKey()
  {
    return this.JI;
  }
  
  public int getVisibility()
  {
    return this.JJ;
  }
  
  public int hashCode()
  {
    return (this.JI + this.JJ).hashCode();
  }
  
  public String toString()
  {
    return "CustomPropertyKey(" + this.JI + "," + this.JJ + ")";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    c.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/drive/metadata/CustomPropertyKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */