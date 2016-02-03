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
  public static final Parcelable.Creator<LogicalFilter> CREATOR = new f();
  final int kg;
  private List<Filter> rQ;
  final Operator rR;
  final List<FilterHolder> sb;
  
  LogicalFilter(int paramInt, Operator paramOperator, List<FilterHolder> paramList)
  {
    this.kg = paramInt;
    this.rR = paramOperator;
    this.sb = paramList;
  }
  
  public LogicalFilter(Operator paramOperator, Filter paramFilter, Filter... paramVarArgs)
  {
    this.kg = 1;
    this.rR = paramOperator;
    this.sb = new ArrayList(paramVarArgs.length + 1);
    this.sb.add(new FilterHolder(paramFilter));
    this.rQ = new ArrayList(paramVarArgs.length + 1);
    this.rQ.add(paramFilter);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      paramOperator = paramVarArgs[i];
      this.sb.add(new FilterHolder(paramOperator));
      this.rQ.add(paramOperator);
      i += 1;
    }
  }
  
  public LogicalFilter(Operator paramOperator, List<Filter> paramList)
  {
    this.kg = 1;
    this.rR = paramOperator;
    this.rQ = paramList;
    this.sb = new ArrayList(paramList.size());
    paramOperator = paramList.iterator();
    while (paramOperator.hasNext())
    {
      paramList = (Filter)paramOperator.next();
      this.sb.add(new FilterHolder(paramList));
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    f.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/drive/query/internal/LogicalFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */