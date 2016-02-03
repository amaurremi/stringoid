package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class hn
  implements SafeParcelable
{
  public static final es Nb = new es();
  final List<ht> Nc;
  private final String Nd;
  private final boolean Ne;
  private final Set<ht> Nf;
  final int qh;
  
  hn(int paramInt, List<ht> paramList, String paramString, boolean paramBoolean)
  {
    this.qh = paramInt;
    if (paramList == null) {}
    for (paramList = Collections.emptyList();; paramList = Collections.unmodifiableList(paramList))
    {
      this.Nc = paramList;
      paramList = paramString;
      if (paramString == null) {
        paramList = "";
      }
      this.Nd = paramList;
      this.Ne = paramBoolean;
      if (!this.Nc.isEmpty()) {
        break;
      }
      this.Nf = Collections.emptySet();
      return;
    }
    this.Nf = Collections.unmodifiableSet(new HashSet(this.Nc));
  }
  
  public int describeContents()
  {
    es locales = Nb;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof hn)) {
        return false;
      }
      paramObject = (hn)paramObject;
    } while ((this.Nf.equals(((hn)paramObject).Nf)) && (this.Nd == ((hn)paramObject).Nd) && (this.Ne == ((hn)paramObject).Ne));
    return false;
  }
  
  public int hashCode()
  {
    return cz.hashCode(new Object[] { this.Nf, this.Nd, Boolean.valueOf(this.Ne) });
  }
  
  public String rn()
  {
    return this.Nd;
  }
  
  public boolean ro()
  {
    return this.Ne;
  }
  
  public String toString()
  {
    return cz.M(this).a("types", this.Nf).a("textQuery", this.Nd).a("isOpenNowRequired", Boolean.valueOf(this.Ne)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    es locales = Nb;
    es.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/hn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */