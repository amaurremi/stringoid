package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class gt
  implements SafeParcelable
{
  public static final gu CREATOR = new gu();
  final int kg;
  private final int yf;
  final List<gx> yg;
  private final String yh;
  private final String yi;
  private final boolean yj;
  private final Set<gx> yk;
  
  gt(int paramInt1, int paramInt2, List<gx> paramList, String paramString1, String paramString2, boolean paramBoolean)
  {
    this.kg = paramInt1;
    this.yf = paramInt2;
    if (paramList == null) {}
    for (paramList = Collections.emptyList();; paramList = Collections.unmodifiableList(paramList))
    {
      this.yg = paramList;
      paramList = paramString1;
      if (paramString1 == null) {
        paramList = "";
      }
      this.yh = paramList;
      paramList = paramString2;
      if (paramString2 == null) {
        paramList = "";
      }
      this.yi = paramList;
      this.yj = paramBoolean;
      if (!this.yg.isEmpty()) {
        break;
      }
      this.yk = Collections.emptySet();
      return;
    }
    this.yk = Collections.unmodifiableSet(new HashSet(this.yg));
  }
  
  public int dO()
  {
    return this.yf;
  }
  
  public String dP()
  {
    return this.yh;
  }
  
  public String dQ()
  {
    return this.yi;
  }
  
  public boolean dR()
  {
    return this.yj;
  }
  
  public int describeContents()
  {
    gu localgu = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof gt)) {
        return false;
      }
      paramObject = (gt)paramObject;
    } while ((this.yf == ((gt)paramObject).yf) && (this.yk.equals(((gt)paramObject).yk)) && (this.yh == ((gt)paramObject).yh) && (this.yi == ((gt)paramObject).yi) && (this.yj == ((gt)paramObject).yj));
    return false;
  }
  
  public int hashCode()
  {
    return ee.hashCode(new Object[] { Integer.valueOf(this.yf), this.yk, this.yh, this.yi, Boolean.valueOf(this.yj) });
  }
  
  public String toString()
  {
    return ee.e(this).a("maxResults", Integer.valueOf(this.yf)).a("types", this.yk).a("nameQuery", this.yh).a("textQuery", this.yi).a("isOpenNowRequired", Boolean.valueOf(this.yj)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    gu localgu = CREATOR;
    gu.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/gt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */