package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.Filter;

public class FilterHolder
  implements SafeParcelable
{
  public static final Parcelable.Creator<FilterHolder> CREATOR = new d();
  final ComparisonFilter<?> KP;
  final FieldOnlyFilter KQ;
  final LogicalFilter KR;
  final NotFilter KS;
  final InFilter<?> KT;
  final MatchAllFilter KU;
  final HasFilter KV;
  private final Filter KW;
  final int xM;
  
  FilterHolder(int paramInt, ComparisonFilter<?> paramComparisonFilter, FieldOnlyFilter paramFieldOnlyFilter, LogicalFilter paramLogicalFilter, NotFilter paramNotFilter, InFilter<?> paramInFilter, MatchAllFilter paramMatchAllFilter, HasFilter<?> paramHasFilter)
  {
    this.xM = paramInt;
    this.KP = paramComparisonFilter;
    this.KQ = paramFieldOnlyFilter;
    this.KR = paramLogicalFilter;
    this.KS = paramNotFilter;
    this.KT = paramInFilter;
    this.KU = paramMatchAllFilter;
    this.KV = paramHasFilter;
    if (this.KP != null)
    {
      this.KW = this.KP;
      return;
    }
    if (this.KQ != null)
    {
      this.KW = this.KQ;
      return;
    }
    if (this.KR != null)
    {
      this.KW = this.KR;
      return;
    }
    if (this.KS != null)
    {
      this.KW = this.KS;
      return;
    }
    if (this.KT != null)
    {
      this.KW = this.KT;
      return;
    }
    if (this.KU != null)
    {
      this.KW = this.KU;
      return;
    }
    if (this.KV != null)
    {
      this.KW = this.KV;
      return;
    }
    throw new IllegalArgumentException("At least one filter must be set.");
  }
  
  public FilterHolder(Filter paramFilter)
  {
    this.xM = 2;
    if ((paramFilter instanceof ComparisonFilter))
    {
      localObject = (ComparisonFilter)paramFilter;
      this.KP = ((ComparisonFilter)localObject);
      if (!(paramFilter instanceof FieldOnlyFilter)) {
        break label192;
      }
      localObject = (FieldOnlyFilter)paramFilter;
      label38:
      this.KQ = ((FieldOnlyFilter)localObject);
      if (!(paramFilter instanceof LogicalFilter)) {
        break label197;
      }
      localObject = (LogicalFilter)paramFilter;
      label55:
      this.KR = ((LogicalFilter)localObject);
      if (!(paramFilter instanceof NotFilter)) {
        break label202;
      }
      localObject = (NotFilter)paramFilter;
      label72:
      this.KS = ((NotFilter)localObject);
      if (!(paramFilter instanceof InFilter)) {
        break label207;
      }
      localObject = (InFilter)paramFilter;
      label89:
      this.KT = ((InFilter)localObject);
      if (!(paramFilter instanceof MatchAllFilter)) {
        break label212;
      }
      localObject = (MatchAllFilter)paramFilter;
      label106:
      this.KU = ((MatchAllFilter)localObject);
      if (!(paramFilter instanceof HasFilter)) {
        break label217;
      }
    }
    label192:
    label197:
    label202:
    label207:
    label212:
    label217:
    for (Object localObject = (HasFilter)paramFilter;; localObject = null)
    {
      this.KV = ((HasFilter)localObject);
      if ((this.KP != null) || (this.KQ != null) || (this.KR != null) || (this.KS != null) || (this.KT != null) || (this.KU != null) || (this.KV != null)) {
        break label222;
      }
      throw new IllegalArgumentException("Invalid filter type or null filter.");
      localObject = null;
      break;
      localObject = null;
      break label38;
      localObject = null;
      break label55;
      localObject = null;
      break label72;
      localObject = null;
      break label89;
      localObject = null;
      break label106;
    }
    label222:
    this.KW = paramFilter;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    d.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/query/internal/FilterHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */