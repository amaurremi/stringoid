package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class jw
  implements SafeParcelable
{
  public static final jx CREATOR = new jx();
  public static final jw YP = w("test_type", 1);
  public static final jw YQ = w("saved_offers", 4);
  public static final Set<jw> YR = Collections.unmodifiableSet(new HashSet(Arrays.asList(new jw[] { YP, YQ })));
  final int YS;
  final String qX;
  final int xM;
  
  jw(int paramInt1, String paramString, int paramInt2)
  {
    hm.aE(paramString);
    this.xM = paramInt1;
    this.qX = paramString;
    this.YS = paramInt2;
  }
  
  private static jw w(String paramString, int paramInt)
  {
    return new jw(0, paramString, paramInt);
  }
  
  public int describeContents()
  {
    jx localjx = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof jw)) {
        return false;
      }
      paramObject = (jw)paramObject;
    } while ((this.qX.equals(((jw)paramObject).qX)) && (this.YS == ((jw)paramObject).YS));
    return false;
  }
  
  public int hashCode()
  {
    return this.qX.hashCode();
  }
  
  public String toString()
  {
    return this.qX;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    jx localjx = CREATOR;
    jx.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/jw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */