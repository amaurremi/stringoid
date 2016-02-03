package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.query.Filter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LogicalFilter
  extends AbstractFilter
{
  public static final Parcelable.Creator<LogicalFilter> CREATOR = new i();
  final int BR;
  final Operator QC;
  final List<FilterHolder> QP;
  private List<Filter> Qx;
  
  LogicalFilter(int paramInt, Operator paramOperator, List<FilterHolder> paramList)
  {
    this.BR = paramInt;
    this.QC = paramOperator;
    this.QP = paramList;
  }
  
  public LogicalFilter(Operator paramOperator, Filter paramFilter, Filter... paramVarArgs)
  {
    this.BR = 1;
    this.QC = paramOperator;
    this.QP = new ArrayList(paramVarArgs.length + 1);
    this.QP.add(new FilterHolder(paramFilter));
    this.Qx = new ArrayList(paramVarArgs.length + 1);
    this.Qx.add(paramFilter);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      paramOperator = paramVarArgs[i];
      this.QP.add(new FilterHolder(paramOperator));
      this.Qx.add(paramOperator);
      i += 1;
    }
  }
  
  public LogicalFilter(Operator paramOperator, Iterable<Filter> paramIterable)
  {
    this.BR = 1;
    this.QC = paramOperator;
    this.Qx = new ArrayList();
    this.QP = new ArrayList();
    paramOperator = paramIterable.iterator();
    while (paramOperator.hasNext())
    {
      paramIterable = (Filter)paramOperator.next();
      this.Qx.add(paramIterable);
      this.QP.add(new FilterHolder(paramIterable));
    }
  }
  
  public <T> T a(f<T> paramf)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.QP.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((FilterHolder)localIterator.next()).getFilter().a(paramf));
    }
    return (T)paramf.b(this.QC, localArrayList);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    i.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/drive/query/internal/LogicalFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */