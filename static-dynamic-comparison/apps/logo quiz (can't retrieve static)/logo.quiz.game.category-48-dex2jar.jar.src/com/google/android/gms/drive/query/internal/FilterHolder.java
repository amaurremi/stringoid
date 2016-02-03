package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.Filter;

public class FilterHolder
  implements SafeParcelable
{
  public static final Parcelable.Creator<FilterHolder> CREATOR = new d();
  final int BR;
  final ComparisonFilter<?> QG;
  final FieldOnlyFilter QH;
  final LogicalFilter QI;
  final NotFilter QJ;
  final InFilter<?> QK;
  final MatchAllFilter QL;
  final HasFilter QM;
  private final Filter QN;
  
  FilterHolder(int paramInt, ComparisonFilter<?> paramComparisonFilter, FieldOnlyFilter paramFieldOnlyFilter, LogicalFilter paramLogicalFilter, NotFilter paramNotFilter, InFilter<?> paramInFilter, MatchAllFilter paramMatchAllFilter, HasFilter<?> paramHasFilter)
  {
    this.BR = paramInt;
    this.QG = paramComparisonFilter;
    this.QH = paramFieldOnlyFilter;
    this.QI = paramLogicalFilter;
    this.QJ = paramNotFilter;
    this.QK = paramInFilter;
    this.QL = paramMatchAllFilter;
    this.QM = paramHasFilter;
    if (this.QG != null)
    {
      this.QN = this.QG;
      return;
    }
    if (this.QH != null)
    {
      this.QN = this.QH;
      return;
    }
    if (this.QI != null)
    {
      this.QN = this.QI;
      return;
    }
    if (this.QJ != null)
    {
      this.QN = this.QJ;
      return;
    }
    if (this.QK != null)
    {
      this.QN = this.QK;
      return;
    }
    if (this.QL != null)
    {
      this.QN = this.QL;
      return;
    }
    if (this.QM != null)
    {
      this.QN = this.QM;
      return;
    }
    throw new IllegalArgumentException("At least one filter must be set.");
  }
  
  public FilterHolder(Filter paramFilter)
  {
    this.BR = 2;
    if ((paramFilter instanceof ComparisonFilter))
    {
      localObject = (ComparisonFilter)paramFilter;
      this.QG = ((ComparisonFilter)localObject);
      if (!(paramFilter instanceof FieldOnlyFilter)) {
        break label192;
      }
      localObject = (FieldOnlyFilter)paramFilter;
      label38:
      this.QH = ((FieldOnlyFilter)localObject);
      if (!(paramFilter instanceof LogicalFilter)) {
        break label197;
      }
      localObject = (LogicalFilter)paramFilter;
      label55:
      this.QI = ((LogicalFilter)localObject);
      if (!(paramFilter instanceof NotFilter)) {
        break label202;
      }
      localObject = (NotFilter)paramFilter;
      label72:
      this.QJ = ((NotFilter)localObject);
      if (!(paramFilter instanceof InFilter)) {
        break label207;
      }
      localObject = (InFilter)paramFilter;
      label89:
      this.QK = ((InFilter)localObject);
      if (!(paramFilter instanceof MatchAllFilter)) {
        break label212;
      }
      localObject = (MatchAllFilter)paramFilter;
      label106:
      this.QL = ((MatchAllFilter)localObject);
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
      this.QM = ((HasFilter)localObject);
      if ((this.QG != null) || (this.QH != null) || (this.QI != null) || (this.QJ != null) || (this.QK != null) || (this.QL != null) || (this.QM != null)) {
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
    this.QN = paramFilter;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Filter getFilter()
  {
    return this.QN;
  }
  
  public String toString()
  {
    return String.format("FilterHolder[%s]", new Object[] { this.QN });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    d.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/drive/query/internal/FilterHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */