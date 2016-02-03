package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LogicalFilter
  implements SafeParcelable, a
{
  public static final Parcelable.Creator<LogicalFilter> CREATOR = new f();
  final int qh;
  final List<FilterHolder> uB;
  private List<a> uf;
  final Operator uq;
  
  LogicalFilter(int paramInt, Operator paramOperator, List<FilterHolder> paramList)
  {
    this.qh = paramInt;
    this.uq = paramOperator;
    this.uB = paramList;
  }
  
  public LogicalFilter(Operator paramOperator, Iterable<a> paramIterable)
  {
    this.qh = 1;
    this.uq = paramOperator;
    this.uf = new ArrayList();
    this.uB = new ArrayList();
    paramOperator = paramIterable.iterator();
    while (paramOperator.hasNext())
    {
      paramIterable = (a)paramOperator.next();
      this.uf.add(paramIterable);
      this.uB.add(new FilterHolder(paramIterable));
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/drive/query/internal/LogicalFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */