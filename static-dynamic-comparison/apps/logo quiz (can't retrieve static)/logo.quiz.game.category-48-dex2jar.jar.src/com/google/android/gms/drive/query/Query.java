package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import com.google.android.gms.drive.query.internal.MatchAllFilter;
import com.google.android.gms.drive.query.internal.Operator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Query
  implements SafeParcelable
{
  public static final Parcelable.Creator<Query> CREATOR = new a();
  final int BR;
  final LogicalFilter Qt;
  final String Qu;
  final SortOrder Qv;
  final List<String> Qw;
  
  Query(int paramInt, LogicalFilter paramLogicalFilter, String paramString, SortOrder paramSortOrder, List<String> paramList)
  {
    this.BR = paramInt;
    this.Qt = paramLogicalFilter;
    this.Qu = paramString;
    this.Qv = paramSortOrder;
    this.Qw = paramList;
  }
  
  Query(LogicalFilter paramLogicalFilter, String paramString, SortOrder paramSortOrder, List<String> paramList)
  {
    this(1, paramLogicalFilter, paramString, paramSortOrder, paramList);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Filter getFilter()
  {
    return this.Qt;
  }
  
  public String getPageToken()
  {
    return this.Qu;
  }
  
  public SortOrder getSortOrder()
  {
    return this.Qv;
  }
  
  public List<String> iq()
  {
    return this.Qw;
  }
  
  public String toString()
  {
    return String.format(Locale.US, "Query[%s,%s,PageToken=%s]", new Object[] { this.Qt, this.Qv, this.Qu });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
  
  public static class Builder
  {
    private String Qu;
    private SortOrder Qv;
    private List<String> Qw;
    private final List<Filter> Qx = new ArrayList();
    
    public Builder() {}
    
    public Builder(Query paramQuery)
    {
      this.Qx.add(paramQuery.getFilter());
      this.Qu = paramQuery.getPageToken();
      this.Qv = paramQuery.getSortOrder();
      this.Qw = paramQuery.iq();
    }
    
    public Builder addFilter(Filter paramFilter)
    {
      if (!(paramFilter instanceof MatchAllFilter)) {
        this.Qx.add(paramFilter);
      }
      return this;
    }
    
    public Query build()
    {
      return new Query(new LogicalFilter(Operator.QW, this.Qx), this.Qu, this.Qv, this.Qw);
    }
    
    public Builder setPageToken(String paramString)
    {
      this.Qu = paramString;
      return this;
    }
    
    public Builder setSortOrder(SortOrder paramSortOrder)
    {
      this.Qv = paramSortOrder;
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/drive/query/Query.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */