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
  private List<Filter> KH;
  final Operator KL;
  final List<FilterHolder> KY;
  final int xM;
  
  LogicalFilter(int paramInt, Operator paramOperator, List<FilterHolder> paramList)
  {
    this.xM = paramInt;
    this.KL = paramOperator;
    this.KY = paramList;
  }
  
  public LogicalFilter(Operator paramOperator, Filter paramFilter, Filter... paramVarArgs)
  {
    this.xM = 1;
    this.KL = paramOperator;
    this.KY = new ArrayList(paramVarArgs.length + 1);
    this.KY.add(new FilterHolder(paramFilter));
    this.KH = new ArrayList(paramVarArgs.length + 1);
    this.KH.add(paramFilter);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      paramOperator = paramVarArgs[i];
      this.KY.add(new FilterHolder(paramOperator));
      this.KH.add(paramOperator);
      i += 1;
    }
  }
  
  public LogicalFilter(Operator paramOperator, Iterable<Filter> paramIterable)
  {
    this.xM = 1;
    this.KL = paramOperator;
    this.KH = new ArrayList();
    this.KY = new ArrayList();
    paramOperator = paramIterable.iterator();
    while (paramOperator.hasNext())
    {
      paramIterable = (Filter)paramOperator.next();
      this.KH.add(paramIterable);
      this.KY.add(new FilterHolder(paramIterable));
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/query/internal/LogicalFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */