package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.internal.LogicalFilter;

public class Query
  implements SafeParcelable
{
  public static final Parcelable.Creator<Query> CREATOR = new a();
  final LogicalFilter KE;
  final String KF;
  final SortOrder KG;
  final int xM;
  
  Query(int paramInt, LogicalFilter paramLogicalFilter, String paramString, SortOrder paramSortOrder)
  {
    this.xM = paramInt;
    this.KE = paramLogicalFilter;
    this.KF = paramString;
    this.KG = paramSortOrder;
  }
  
  Query(LogicalFilter paramLogicalFilter, String paramString, SortOrder paramSortOrder)
  {
    this(1, paramLogicalFilter, paramString, paramSortOrder);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Filter getFilter()
  {
    return this.KE;
  }
  
  public String getPageToken()
  {
    return this.KF;
  }
  
  public SortOrder getSortOrder()
  {
    return this.KG;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/query/Query.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */