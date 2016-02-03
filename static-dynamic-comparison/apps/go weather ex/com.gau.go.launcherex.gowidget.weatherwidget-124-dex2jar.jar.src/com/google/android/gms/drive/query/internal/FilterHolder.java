package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.Filter;

public class FilterHolder
  implements SafeParcelable
{
  public static final Parcelable.Creator<FilterHolder> CREATOR = new d();
  final ComparisonFilter<?> GK;
  final FieldOnlyFilter GL;
  final LogicalFilter GM;
  final NotFilter GN;
  final InFilter<?> GO;
  final MatchAllFilter GP;
  private final Filter GQ;
  final int xH;
  
  FilterHolder(int paramInt, ComparisonFilter<?> paramComparisonFilter, FieldOnlyFilter paramFieldOnlyFilter, LogicalFilter paramLogicalFilter, NotFilter paramNotFilter, InFilter<?> paramInFilter, MatchAllFilter paramMatchAllFilter)
  {
    this.xH = paramInt;
    this.GK = paramComparisonFilter;
    this.GL = paramFieldOnlyFilter;
    this.GM = paramLogicalFilter;
    this.GN = paramNotFilter;
    this.GO = paramInFilter;
    this.GP = paramMatchAllFilter;
    if (this.GK != null)
    {
      this.GQ = this.GK;
      return;
    }
    if (this.GL != null)
    {
      this.GQ = this.GL;
      return;
    }
    if (this.GM != null)
    {
      this.GQ = this.GM;
      return;
    }
    if (this.GN != null)
    {
      this.GQ = this.GN;
      return;
    }
    if (this.GO != null)
    {
      this.GQ = this.GO;
      return;
    }
    if (this.GP != null)
    {
      this.GQ = this.GP;
      return;
    }
    throw new IllegalArgumentException("At least one filter must be set.");
  }
  
  public FilterHolder(Filter paramFilter)
  {
    this.xH = 1;
    if ((paramFilter instanceof ComparisonFilter))
    {
      localObject = (ComparisonFilter)paramFilter;
      this.GK = ((ComparisonFilter)localObject);
      if (!(paramFilter instanceof FieldOnlyFilter)) {
        break label168;
      }
      localObject = (FieldOnlyFilter)paramFilter;
      label38:
      this.GL = ((FieldOnlyFilter)localObject);
      if (!(paramFilter instanceof LogicalFilter)) {
        break label173;
      }
      localObject = (LogicalFilter)paramFilter;
      label55:
      this.GM = ((LogicalFilter)localObject);
      if (!(paramFilter instanceof NotFilter)) {
        break label178;
      }
      localObject = (NotFilter)paramFilter;
      label72:
      this.GN = ((NotFilter)localObject);
      if (!(paramFilter instanceof InFilter)) {
        break label183;
      }
      localObject = (InFilter)paramFilter;
      label89:
      this.GO = ((InFilter)localObject);
      if (!(paramFilter instanceof MatchAllFilter)) {
        break label188;
      }
    }
    label168:
    label173:
    label178:
    label183:
    label188:
    for (Object localObject = (MatchAllFilter)paramFilter;; localObject = null)
    {
      this.GP = ((MatchAllFilter)localObject);
      if ((this.GK != null) || (this.GL != null) || (this.GM != null) || (this.GN != null) || (this.GO != null) || (this.GP != null)) {
        break label193;
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
    }
    label193:
    this.GQ = paramFilter;
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/drive/query/internal/FilterHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */