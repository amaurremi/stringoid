package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.Query;

public class QueryRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<QueryRequest> CREATOR = new at();
  final Query JE;
  final int xM;
  
  QueryRequest(int paramInt, Query paramQuery)
  {
    this.xM = paramInt;
    this.JE = paramQuery;
  }
  
  public QueryRequest(Query paramQuery)
  {
    this(1, paramQuery);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    at.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/internal/QueryRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */