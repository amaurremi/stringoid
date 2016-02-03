package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;

public class gh
  implements SafeParcelable, Cloneable
{
  public static final gi CREATOR = new gi();
  private final int kg;
  private final boolean xK;
  private final boolean xL;
  private final boolean xM;
  private final boolean xN;
  private final ArrayList<el> xO;
  
  public gh(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, ArrayList<el> paramArrayList)
  {
    this.kg = paramInt;
    this.xK = paramBoolean1;
    this.xL = paramBoolean2;
    this.xM = paramBoolean3;
    this.xN = paramBoolean4;
    this.xO = paramArrayList;
  }
  
  public Object clone()
  {
    int i = this.kg;
    boolean bool1 = this.xK;
    boolean bool2 = this.xL;
    boolean bool3 = this.xM;
    boolean bool4 = this.xN;
    if (this.xO == null) {}
    for (ArrayList localArrayList = null;; localArrayList = (ArrayList)this.xO.clone()) {
      return new gh(i, bool1, bool2, bool3, bool4, localArrayList);
    }
  }
  
  public boolean dD()
  {
    return this.xL;
  }
  
  public boolean dE()
  {
    return this.xM;
  }
  
  public boolean dF()
  {
    return this.xN;
  }
  
  public List<el> dG()
  {
    return this.xO;
  }
  
  public int describeContents()
  {
    gi localgi = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (gh)paramObject;
      if (this.xO == null)
      {
        if (((gh)paramObject).xO != null) {
          return false;
        }
      }
      else if (!this.xO.equals(((gh)paramObject).xO)) {
        return false;
      }
      if (this.xK != ((gh)paramObject).xK) {
        return false;
      }
      if (this.xL != ((gh)paramObject).xL) {
        return false;
      }
      if (this.xN != ((gh)paramObject).xN) {
        return false;
      }
      if (this.xM != ((gh)paramObject).xM) {
        return false;
      }
    } while (this.kg == ((gh)paramObject).kg);
    return false;
  }
  
  public int getVersionCode()
  {
    return this.kg;
  }
  
  public int hashCode()
  {
    int n = 1231;
    int i;
    int j;
    label25:
    int k;
    label36:
    int m;
    if (this.xO == null)
    {
      i = 0;
      if (!this.xK) {
        break label101;
      }
      j = 1231;
      if (!this.xL) {
        break label108;
      }
      k = 1231;
      if (!this.xN) {
        break label115;
      }
      m = 1231;
      label48:
      if (!this.xM) {
        break label123;
      }
    }
    for (;;)
    {
      return ((m + (k + (j + (i + 31) * 31) * 31) * 31) * 31 + n) * 31 + this.kg;
      i = this.xO.hashCode();
      break;
      label101:
      j = 1237;
      break label25;
      label108:
      k = 1237;
      break label36;
      label115:
      m = 1237;
      break label48;
      label123:
      n = 1237;
    }
  }
  
  public boolean isEnabled()
  {
    return this.xK;
  }
  
  public String toString()
  {
    return "CopresenceSettings [mVersionCode=" + this.kg + ", mEnabled=" + this.xK + "," + "mAcl={" + this.xO.toArray() + "}," + ", mNotifiedForNonAcl=" + this.xM + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    gi localgi = CREATOR;
    gi.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/gh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */