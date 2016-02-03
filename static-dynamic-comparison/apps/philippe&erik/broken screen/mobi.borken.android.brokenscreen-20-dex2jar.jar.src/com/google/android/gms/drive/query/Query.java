package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import com.google.android.gms.drive.query.internal.MatchAllFilter;
import com.google.android.gms.drive.query.internal.Operator;
import java.util.ArrayList;
import java.util.List;

public class Query
  implements SafeParcelable
{
  public static final Parcelable.Creator<Query> CREATOR = new a();
  final LogicalFilter KB;
  final String KC;
  final SortOrder KD;
  final int xJ;
  
  Query(int paramInt, LogicalFilter paramLogicalFilter, String paramString, SortOrder paramSortOrder)
  {
    this.xJ = paramInt;
    this.KB = paramLogicalFilter;
    this.KC = paramString;
    this.KD = paramSortOrder;
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
    return this.KB;
  }
  
  public String getPageToken()
  {
    return this.KC;
  }
  
  public SortOrder getSortOrder()
  {
    return this.KD;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
  
  public static class Builder
  {
    private String KC;
    private SortOrder KD;
    private final List<Filter> KE = new ArrayList();
    
    public Builder addFilter(Filter paramFilter)
    {
      if (!(paramFilter instanceof MatchAllFilter)) {
        this.KE.add(paramFilter);
      }
      return this;
    }
    
    public Query build()
    {
      return new Query(new LogicalFilter(Operator.Lc, this.KE), this.KC, this.KD);
    }
    
    public Builder setPageToken(String paramString)
    {
      this.KC = paramString;
      return this;
    }
    
    public Builder setSortOrder(SortOrder paramSortOrder)
    {
      this.KD = paramSortOrder;
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/drive/query/Query.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */