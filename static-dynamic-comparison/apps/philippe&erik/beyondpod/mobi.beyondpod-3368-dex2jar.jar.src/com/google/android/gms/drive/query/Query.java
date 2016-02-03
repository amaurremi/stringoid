package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import com.google.android.gms.drive.query.internal.Operator;
import java.util.ArrayList;
import java.util.List;

public class Query
  implements SafeParcelable
{
  public static final Parcelable.Creator<Query> CREATOR = new a();
  final int kg;
  LogicalFilter rO;
  String rP;
  
  Query(int paramInt, LogicalFilter paramLogicalFilter, String paramString)
  {
    this.kg = paramInt;
    this.rO = paramLogicalFilter;
    this.rP = paramString;
  }
  
  Query(LogicalFilter paramLogicalFilter, String paramString)
  {
    this(1, paramLogicalFilter, paramString);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Filter getFilter()
  {
    return this.rO;
  }
  
  public String getPageToken()
  {
    return this.rP;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
  
  public static class Builder
  {
    private String rP;
    private final List<Filter> rQ = new ArrayList();
    
    public Builder addFilter(Filter paramFilter)
    {
      this.rQ.add(paramFilter);
      return this;
    }
    
    public Query build()
    {
      return new Query(new LogicalFilter(Operator.si, this.rQ), this.rP);
    }
    
    public Builder setPageToken(String paramString)
    {
      this.rP = paramString;
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/drive/query/Query.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */