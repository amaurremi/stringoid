package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.Filter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LogicalFilter
  implements SafeParcelable, Filter
{
  public static final Parcelable.Creator<LogicalFilter> CREATOR = new h();
  private List<Filter> KE;
  final Operator KI;
  final List<FilterHolder> KV;
  final int xJ;
  
  LogicalFilter(int paramInt, Operator paramOperator, List<FilterHolder> paramList)
  {
    this.xJ = paramInt;
    this.KI = paramOperator;
    this.KV = paramList;
  }
  
  public LogicalFilter(Operator paramOperator, Filter paramFilter, Filter... paramVarArgs)
  {
    this.xJ = 1;
    this.KI = paramOperator;
    this.KV = new ArrayList(paramVarArgs.length + 1);
    this.KV.add(new FilterHolder(paramFilter));
    this.KE = new ArrayList(paramVarArgs.length + 1);
    this.KE.add(paramFilter);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      paramOperator = paramVarArgs[i];
      this.KV.add(new FilterHolder(paramOperator));
      this.KE.add(paramOperator);
      i += 1;
    }
  }
  
  public LogicalFilter(Operator paramOperator, Iterable<Filter> paramIterable)
  {
    this.xJ = 1;
    this.KI = paramOperator;
    this.KE = new ArrayList();
    this.KV = new ArrayList();
    paramOperator = paramIterable.iterator();
    while (paramOperator.hasNext())
    {
      paramIterable = (Filter)paramOperator.next();
      this.KE.add(paramIterable);
      this.KV.add(new FilterHolder(paramIterable));
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    h.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/drive/query/internal/LogicalFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */