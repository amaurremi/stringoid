package com.google.android.gms.drive.query;

import com.google.android.gms.drive.query.internal.LogicalFilter;
import com.google.android.gms.drive.query.internal.MatchAllFilter;
import com.google.android.gms.drive.query.internal.Operator;
import java.util.ArrayList;
import java.util.List;

public class Query$Builder
{
  private String KF;
  private SortOrder KG;
  private final List<Filter> KH = new ArrayList();
  
  public Builder addFilter(Filter paramFilter)
  {
    if (!(paramFilter instanceof MatchAllFilter)) {
      this.KH.add(paramFilter);
    }
    return this;
  }
  
  public Query build()
  {
    return new Query(new LogicalFilter(Operator.Lf, this.KH), this.KF, this.KG);
  }
  
  public Builder setPageToken(String paramString)
  {
    this.KF = paramString;
    return this;
  }
  
  public Builder setSortOrder(SortOrder paramSortOrder)
  {
    this.KG = paramSortOrder;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/query/Query$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */