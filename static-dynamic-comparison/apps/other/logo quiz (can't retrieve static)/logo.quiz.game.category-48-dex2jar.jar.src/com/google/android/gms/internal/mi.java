package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.m.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class mi
  implements SafeParcelable
{
  public static final mj CREATOR = new mj();
  final int BR;
  final List<mo> afg;
  private final String afh;
  private final boolean afi;
  final List<ms> afj;
  final List<String> afk;
  private final Set<mo> afl;
  private final Set<ms> afm;
  private final Set<String> afn;
  
  mi(int paramInt, List<mo> paramList, String paramString, boolean paramBoolean, List<ms> paramList1, List<String> paramList2)
  {
    this.BR = paramInt;
    if (paramList == null)
    {
      paramList = Collections.emptyList();
      this.afg = paramList;
      paramList = paramString;
      if (paramString == null) {
        paramList = "";
      }
      this.afh = paramList;
      this.afi = paramBoolean;
      if (paramList1 != null) {
        break label112;
      }
      paramList = Collections.emptyList();
      label51:
      this.afj = paramList;
      if (paramList2 != null) {
        break label121;
      }
    }
    label112:
    label121:
    for (paramList = Collections.emptyList();; paramList = Collections.unmodifiableList(paramList2))
    {
      this.afk = paramList;
      this.afl = f(this.afg);
      this.afm = f(this.afj);
      this.afn = f(this.afk);
      return;
      paramList = Collections.unmodifiableList(paramList);
      break;
      paramList = Collections.unmodifiableList(paramList1);
      break label51;
    }
  }
  
  private static <E> Set<E> f(List<E> paramList)
  {
    if (paramList.isEmpty()) {
      return Collections.emptySet();
    }
    return Collections.unmodifiableSet(new HashSet(paramList));
  }
  
  public int describeContents()
  {
    mj localmj = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof mi)) {
        return false;
      }
      paramObject = (mi)paramObject;
    } while ((this.afl.equals(((mi)paramObject).afl)) && (this.afi == ((mi)paramObject).afi) && (this.afm.equals(((mi)paramObject).afm)) && (this.afn.equals(((mi)paramObject).afn)));
    return false;
  }
  
  public int hashCode()
  {
    return m.hashCode(new Object[] { this.afl, Boolean.valueOf(this.afi), this.afm, this.afn });
  }
  
  @Deprecated
  public String mg()
  {
    return this.afh;
  }
  
  public boolean mh()
  {
    return this.afi;
  }
  
  public String toString()
  {
    return m.h(this).a("types", this.afl).a("placeIds", this.afn).a("requireOpenNow", Boolean.valueOf(this.afi)).a("requestedUserDataTypes", this.afm).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    mj localmj = CREATOR;
    mj.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/mi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */