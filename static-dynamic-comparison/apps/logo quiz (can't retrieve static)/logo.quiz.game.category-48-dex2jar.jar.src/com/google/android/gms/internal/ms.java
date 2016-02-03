package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class ms
  implements SafeParcelable
{
  public static final mt CREATOR = new mt();
  public static final ms ahR = y("test_type", 1);
  public static final ms ahS = y("trellis_store", 2);
  public static final ms ahT = y("labeled_place", 6);
  public static final Set<ms> ahU = Collections.unmodifiableSet(new HashSet(Arrays.asList(new ms[] { ahR, ahS, ahT })));
  final int BR;
  final int ahV;
  final String uO;
  
  ms(int paramInt1, String paramString, int paramInt2)
  {
    n.aZ(paramString);
    this.BR = paramInt1;
    this.uO = paramString;
    this.ahV = paramInt2;
  }
  
  private static ms y(String paramString, int paramInt)
  {
    return new ms(0, paramString, paramInt);
  }
  
  public int describeContents()
  {
    mt localmt = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof ms)) {
        return false;
      }
      paramObject = (ms)paramObject;
    } while ((this.uO.equals(((ms)paramObject).uO)) && (this.ahV == ((ms)paramObject).ahV));
    return false;
  }
  
  public int hashCode()
  {
    return this.uO.hashCode();
  }
  
  public String toString()
  {
    return this.uO;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    mt localmt = CREATOR;
    mt.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/ms.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */