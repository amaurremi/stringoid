package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class jn
  implements SafeParcelable
{
  public static final jo CREATOR = new jo();
  final List<jt> VZ;
  private final String Wa;
  private final boolean Wb;
  final List<jx> Wc;
  private final String Wd;
  final List<String> We;
  private final Set<jt> Wf;
  private final Set<jx> Wg;
  private final Set<String> Wh;
  final int xJ;
  
  jn(int paramInt, List<jt> paramList, String paramString1, boolean paramBoolean, List<jx> paramList1, String paramString2, List<String> paramList2)
  {
    this.xJ = paramInt;
    if (paramList == null)
    {
      paramList = Collections.emptyList();
      this.VZ = paramList;
      paramList = paramString1;
      if (paramString1 == null) {
        paramList = "";
      }
      this.Wa = paramList;
      this.Wb = paramBoolean;
      if (paramList1 != null) {
        break label128;
      }
      paramList = Collections.emptyList();
      label51:
      this.Wc = paramList;
      paramList = paramString2;
      if (paramString2 == null) {
        paramList = "";
      }
      this.Wd = paramList;
      if (paramList2 != null) {
        break label137;
      }
    }
    label128:
    label137:
    for (paramList = Collections.emptyList();; paramList = Collections.unmodifiableList(paramList2))
    {
      this.We = paramList;
      this.Wf = c(this.VZ);
      this.Wg = c(this.Wc);
      this.Wh = c(this.We);
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
    jo localjo = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof jn)) {
        return false;
      }
      paramObject = (jn)paramObject;
    } while ((this.Wf.equals(((jn)paramObject).Wf)) && (this.Wb == ((jn)paramObject).Wb) && (this.Wd.equals(((jn)paramObject).Wd)) && (this.Wg.equals(((jn)paramObject).Wg)) && (this.Wh.equals(((jn)paramObject).Wh)));
    return false;
  }
  
  public int hashCode()
  {
    return hl.hashCode(new Object[] { this.Wf, Boolean.valueOf(this.Wb), this.Wg, this.Wd, this.Wh });
  }
  
  @Deprecated
  public String jb()
  {
    return this.Wa;
  }
  
  public boolean jc()
  {
    return this.Wb;
  }
  
  public String jd()
  {
    return this.Wd;
  }
  
  public String toString()
  {
    return hl.e(this).a("types", this.Wf).a("placeIds", this.Wh).a("requireOpenNow", Boolean.valueOf(this.Wb)).a("userAccountName", this.Wd).a("requestedUserDataTypes", this.Wg).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    jo localjo = CREATOR;
    jo.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/jn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */