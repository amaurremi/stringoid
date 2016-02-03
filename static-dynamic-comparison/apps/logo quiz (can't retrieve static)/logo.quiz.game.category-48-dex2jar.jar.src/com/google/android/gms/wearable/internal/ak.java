package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.Node;

public class ak
  implements SafeParcelable, Node
{
  public static final Parcelable.Creator<ak> CREATOR = new al();
  private final String BL;
  final int BR;
  private final String Nz;
  
  ak(int paramInt, String paramString1, String paramString2)
  {
    this.BR = paramInt;
    this.BL = paramString1;
    this.Nz = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ak)) {}
    do
    {
      return false;
      paramObject = (ak)paramObject;
    } while ((!((ak)paramObject).BL.equals(this.BL)) || (!((ak)paramObject).Nz.equals(this.Nz)));
    return true;
  }
  
  public String getDisplayName()
  {
    return this.Nz;
  }
  
  public String getId()
  {
    return this.BL;
  }
  
  public int hashCode()
  {
    return (this.BL.hashCode() + 629) * 37 + this.Nz.hashCode();
  }
  
  public String toString()
  {
    return "NodeParcelable{" + this.BL + "," + this.Nz + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    al.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/wearable/internal/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */