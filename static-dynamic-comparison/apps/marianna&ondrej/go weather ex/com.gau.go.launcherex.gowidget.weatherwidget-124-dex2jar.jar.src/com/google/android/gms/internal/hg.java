package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class hg
  implements SafeParcelable
{
  public static final hh CREATOR = new hh();
  final List<hm> OA;
  private final String OB;
  private final boolean OC;
  private final Set<hm> OD;
  final int xH;
  
  hg(int paramInt, List<hm> paramList, String paramString, boolean paramBoolean)
  {
    this.xH = paramInt;
    if (paramList == null) {}
    for (paramList = Collections.emptyList();; paramList = Collections.unmodifiableList(paramList))
    {
      this.OA = paramList;
      paramList = paramString;
      if (paramString == null) {
        paramList = "";
      }
      this.OB = paramList;
      this.OC = paramBoolean;
      if (!this.OA.isEmpty()) {
        break;
      }
      this.OD = Collections.emptySet();
      return;
    }
    this.OD = Collections.unmodifiableSet(new HashSet(this.OA));
  }
  
  public int describeContents()
  {
    hh localhh = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof hg)) {
        return false;
      }
      paramObject = (hg)paramObject;
    } while ((this.OD.equals(((hg)paramObject).OD)) && (this.OC == ((hg)paramObject).OC));
    return false;
  }
  
  @Deprecated
  public String hW()
  {
    return this.OB;
  }
  
  public boolean hX()
  {
    return this.OC;
  }
  
  public int hashCode()
  {
    return fo.hashCode(new Object[] { this.OD, Boolean.valueOf(this.OC) });
  }
  
  public String toString()
  {
    return fo.e(this).a("types", this.OD).a("requireOpenNow", Boolean.valueOf(this.OC)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    hh localhh = CREATOR;
    hh.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/hg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */