package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.Node;

public class ai
  implements SafeParcelable, Node
{
  public static final Parcelable.Creator<ai> CREATOR = new aj();
  private final String Lk;
  private final String xD;
  final int xJ;
  
  ai(int paramInt, String paramString1, String paramString2)
  {
    this.xJ = paramInt;
    this.xD = paramString1;
    this.Lk = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ai)) {}
    do
    {
      return false;
      paramObject = (ai)paramObject;
    } while ((!((ai)paramObject).xD.equals(this.xD)) || (!((ai)paramObject).Lk.equals(this.Lk)));
    return true;
  }
  
  public String getDisplayName()
  {
    return this.Lk;
  }
  
  public String getId()
  {
    return this.xD;
  }
  
  public int hashCode()
  {
    return (this.xD.hashCode() + 629) * 37 + this.Lk.hashCode();
  }
  
  public String toString()
  {
    return "NodeParcelable{" + this.xD + "," + this.Lk + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    aj.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/wearable/internal/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */