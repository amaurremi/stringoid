package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class gy$a
  implements SafeParcelable
{
  public static final hl CREATOR = new hl();
  private final int DI;
  private final String DK;
  private final List<String> Ef = new ArrayList();
  private final int xM;
  private final String yQ;
  
  gy$a(int paramInt1, String paramString1, List<String> paramList, int paramInt2, String paramString2)
  {
    this.xM = paramInt1;
    this.yQ = paramString1;
    this.Ef.addAll(paramList);
    this.DI = paramInt2;
    this.DK = paramString2;
  }
  
  public gy$a(String paramString1, Collection<String> paramCollection, int paramInt, String paramString2)
  {
    this(3, paramString1, new ArrayList(paramCollection), paramInt, paramString2);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String fj()
  {
    if (this.yQ != null) {
      return this.yQ;
    }
    return "<<default account>>";
  }
  
  public int fk()
  {
    return this.DI;
  }
  
  public List<String> fl()
  {
    return new ArrayList(this.Ef);
  }
  
  public String fn()
  {
    return this.DK;
  }
  
  public String getAccountName()
  {
    return this.yQ;
  }
  
  public int getVersionCode()
  {
    return this.xM;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    hl.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/gy$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */