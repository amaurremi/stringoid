package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class jm
  implements SafeParcelable
{
  public static final jn CREATOR = new jn();
  final List<js> Wc;
  private final String Wd;
  private final boolean We;
  final List<jw> Wf;
  private final String Wg;
  final List<String> Wh;
  private final Set<js> Wi;
  private final Set<jw> Wj;
  private final Set<String> Wk;
  final int xM;
  
  jm(int paramInt, List<js> paramList, String paramString1, boolean paramBoolean, List<jw> paramList1, String paramString2, List<String> paramList2)
  {
    this.xM = paramInt;
    if (paramList == null)
    {
      paramList = Collections.emptyList();
      this.Wc = paramList;
      paramList = paramString1;
      if (paramString1 == null) {
        paramList = "";
      }
      this.Wd = paramList;
      this.We = paramBoolean;
      if (paramList1 != null) {
        break label128;
      }
      paramList = Collections.emptyList();
      label51:
      this.Wf = paramList;
      paramList = paramString2;
      if (paramString2 == null) {
        paramList = "";
      }
      this.Wg = paramList;
      if (paramList2 != null) {
        break label137;
      }
    }
    label128:
    label137:
    for (paramList = Collections.emptyList();; paramList = Collections.unmodifiableList(paramList2))
    {
      this.Wh = paramList;
      this.Wi = c(this.Wc);
      this.Wj = c(this.Wf);
      this.Wk = c(this.Wh);
      return;
      paramList = Collections.unmodifiableList(paramList);
      break;
      paramList = Collections.unmodifiableList(paramList1);
      break label51;
    }
  }
  
  private static <E> Set<E> c(List<E> paramList)
  {
    if (paramList.isEmpty()) {
      return Collections.emptySet();
    }
    return Collections.unmodifiableSet(new HashSet(paramList));
  }
  
  public int describeContents()
  {
    jn localjn = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof jm)) {
        return false;
      }
      paramObject = (jm)paramObject;
    } while ((this.Wi.equals(((jm)paramObject).Wi)) && (this.We == ((jm)paramObject).We) && (this.Wg.equals(((jm)paramObject).Wg)) && (this.Wj.equals(((jm)paramObject).Wj)) && (this.Wk.equals(((jm)paramObject).Wk)));
    return false;
  }
  
  public int hashCode()
  {
    return hk.hashCode(new Object[] { this.Wi, Boolean.valueOf(this.We), this.Wj, this.Wg, this.Wk });
  }
  
  @Deprecated
  public String jg()
  {
    return this.Wd;
  }
  
  public boolean jh()
  {
    return this.We;
  }
  
  public String ji()
  {
    return this.Wg;
  }
  
  public String toString()
  {
    return hk.e(this).a("types", this.Wi).a("placeIds", this.Wk).a("requireOpenNow", Boolean.valueOf(this.We)).a("userAccountName", this.Wg).a("requestedUserDataTypes", this.Wj).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    jn localjn = CREATOR;
    jn.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/jm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */