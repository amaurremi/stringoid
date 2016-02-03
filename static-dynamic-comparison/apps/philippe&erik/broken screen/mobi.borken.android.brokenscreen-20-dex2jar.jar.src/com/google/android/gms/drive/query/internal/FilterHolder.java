package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.Filter;

public class FilterHolder
  implements SafeParcelable
{
  public static final Parcelable.Creator<FilterHolder> CREATOR = new d();
  final ComparisonFilter<?> KM;
  final FieldOnlyFilter KN;
  final LogicalFilter KO;
  final NotFilter KP;
  final InFilter<?> KQ;
  final MatchAllFilter KR;
  final HasFilter KS;
  private final Filter KT;
  final int xJ;
  
  FilterHolder(int paramInt, ComparisonFilter<?> paramComparisonFilter, FieldOnlyFilter paramFieldOnlyFilter, LogicalFilter paramLogicalFilter, NotFilter paramNotFilter, InFilter<?> paramInFilter, MatchAllFilter paramMatchAllFilter, HasFilter<?> paramHasFilter)
  {
    this.xJ = paramInt;
    this.KM = paramComparisonFilter;
    this.KN = paramFieldOnlyFilter;
    this.KO = paramLogicalFilter;
    this.KP = paramNotFilter;
    this.KQ = paramInFilter;
    this.KR = paramMatchAllFilter;
    this.KS = paramHasFilter;
    if (this.KM != null)
    {
      this.KT = this.KM;
      return;
    }
    if (this.KN != null)
    {
      this.KT = this.KN;
      return;
    }
    if (this.KO != null)
    {
      this.KT = this.KO;
      return;
    }
    if (this.KP != null)
    {
      this.KT = this.KP;
      return;
    }
    if (this.KQ != null)
    {
      this.KT = this.KQ;
      return;
    }
    if (this.KR != null)
    {
      this.KT = this.KR;
      return;
    }
    if (this.KS != null)
    {
      this.KT = this.KS;
      return;
    }
    throw new IllegalArgumentException("At least one filter must be set.");
  }
  
  public FilterHolder(Filter paramFilter)
  {
    this.xJ = 2;
    if ((paramFilter instanceof ComparisonFilter))
    {
      localObject = (ComparisonFilter)paramFilter;
      this.KM = ((ComparisonFilter)localObject);
      if (!(paramFilter instanceof FieldOnlyFilter)) {
        break label192;
      }
      localObject = (FieldOnlyFilter)paramFilter;
      label38:
      this.KN = ((FieldOnlyFilter)localObject);
      if (!(paramFilter instanceof LogicalFilter)) {
        break label197;
      }
      localObject = (LogicalFilter)paramFilter;
      label55:
      this.KO = ((LogicalFilter)localObject);
      if (!(paramFilter instanceof NotFilter)) {
        break label202;
      }
      localObject = (NotFilter)paramFilter;
      label72:
      this.KP = ((NotFilter)localObject);
      if (!(paramFilter instanceof InFilter)) {
        break label207;
      }
      localObject = (InFilter)paramFilter;
      label89:
      this.KQ = ((InFilter)localObject);
      if (!(paramFilter instanceof MatchAllFilter)) {
        break label212;
      }
      localObject = (MatchAllFilter)paramFilter;
      label106:
      this.KR = ((MatchAllFilter)localObject);
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
      this.KS = ((HasFilter)localObject);
      if ((this.KM != null) || (this.KN != null) || (this.KO != null) || (this.KP != null) || (this.KQ != null) || (this.KR != null) || (this.KS != null)) {
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
    this.KT = paramFilter;
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/drive/query/internal/FilterHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */