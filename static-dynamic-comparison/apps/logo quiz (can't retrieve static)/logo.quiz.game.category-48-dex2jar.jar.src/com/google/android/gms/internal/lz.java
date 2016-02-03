package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;

public class lz
  implements SafeParcelable
{
  public static final ma CREATOR = new ma();
  static final List<lr> aeW = ;
  private final int BR;
  LocationRequest Ux;
  boolean aeX;
  boolean aeY;
  boolean aeZ;
  List<lr> afa;
  final String mTag;
  
  lz(int paramInt, LocationRequest paramLocationRequest, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, List<lr> paramList, String paramString)
  {
    this.BR = paramInt;
    this.Ux = paramLocationRequest;
    this.aeX = paramBoolean1;
    this.aeY = paramBoolean2;
    this.aeZ = paramBoolean3;
    this.afa = paramList;
    this.mTag = paramString;
  }
  
  private lz(String paramString, LocationRequest paramLocationRequest)
  {
    this(1, paramLocationRequest, false, true, true, aeW, paramString);
  }
  
  public static lz a(String paramString, LocationRequest paramLocationRequest)
  {
    return new lz(paramString, paramLocationRequest);
  }
  
  public static lz b(LocationRequest paramLocationRequest)
  {
    return a(null, paramLocationRequest);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof lz)) {}
    do
    {
      return false;
      paramObject = (lz)paramObject;
    } while ((!m.equal(this.Ux, ((lz)paramObject).Ux)) || (this.aeX != ((lz)paramObject).aeX) || (this.aeY != ((lz)paramObject).aeY) || (this.aeZ != ((lz)paramObject).aeZ) || (!m.equal(this.afa, ((lz)paramObject).afa)));
    return true;
  }
  
  int getVersionCode()
  {
    return this.BR;
  }
  
  public int hashCode()
  {
    return this.Ux.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.Ux.toString());
    localStringBuilder.append(" requestNlpDebugInfo=");
    localStringBuilder.append(this.aeX);
    localStringBuilder.append(" restorePendingIntentListeners=");
    localStringBuilder.append(this.aeY);
    localStringBuilder.append(" triggerUpdate=");
    localStringBuilder.append(this.aeZ);
    localStringBuilder.append(" clients=");
    localStringBuilder.append(this.afa);
    if (this.mTag != null)
    {
      localStringBuilder.append(" tag=");
      localStringBuilder.append(this.mTag);
    }
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ma.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/lz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */