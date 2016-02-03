package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.Node;

public class ai
  implements SafeParcelable, Node
{
  public static final Parcelable.Creator<ai> CREATOR = new aj();
  private final String Ln;
  private final String xG;
  final int xM;
  
  ai(int paramInt, String paramString1, String paramString2)
  {
    this.xM = paramInt;
    this.xG = paramString1;
    this.Ln = paramString2;
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
    } while ((!((ai)paramObject).xG.equals(this.xG)) || (!((ai)paramObject).Ln.equals(this.Ln)));
    return true;
  }
  
  public String getDisplayName()
  {
    return this.Ln;
  }
  
  public String getId()
  {
    return this.xG;
  }
  
  public int hashCode()
  {
    return (this.xG.hashCode() + 629) * 37 + this.Ln.hashCode();
  }
  
  public String toString()
  {
    return "NodeParcelable{" + this.xG + "," + this.Ln + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    aj.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/wearable/internal/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */