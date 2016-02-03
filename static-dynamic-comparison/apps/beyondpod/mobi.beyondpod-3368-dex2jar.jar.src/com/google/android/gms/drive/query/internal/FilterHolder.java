package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.Filter;

public class FilterHolder
  implements SafeParcelable
{
  public static final Parcelable.Creator<FilterHolder> CREATOR = new c();
  final int kg;
  final ComparisonFilter<?> rU;
  final FieldOnlyFilter rV;
  final LogicalFilter rW;
  final NotFilter rX;
  final InFilter<?> rY;
  private final Filter rZ;
  
  FilterHolder(int paramInt, ComparisonFilter<?> paramComparisonFilter, FieldOnlyFilter paramFieldOnlyFilter, LogicalFilter paramLogicalFilter, NotFilter paramNotFilter, InFilter<?> paramInFilter)
  {
    this.kg = paramInt;
    this.rU = paramComparisonFilter;
    this.rV = paramFieldOnlyFilter;
    this.rW = paramLogicalFilter;
    this.rX = paramNotFilter;
    this.rY = paramInFilter;
    if (this.rU != null)
    {
      this.rZ = this.rU;
      return;
    }
    if (this.rV != null)
    {
      this.rZ = this.rV;
      return;
    }
    if (this.rW != null)
    {
      this.rZ = this.rW;
      return;
    }
    if (this.rX != null)
    {
      this.rZ = this.rX;
      return;
    }
    if (this.rY != null)
    {
      this.rZ = this.rY;
      return;
    }
    throw new IllegalArgumentException("At least one filter must be set.");
  }
  
  public FilterHolder(Filter paramFilter)
  {
    this.kg = 1;
    if ((paramFilter instanceof ComparisonFilter))
    {
      localObject = (ComparisonFilter)paramFilter;
      this.rU = ((ComparisonFilter)localObject);
      if (!(paramFilter instanceof FieldOnlyFilter)) {
        break label144;
      }
      localObject = (FieldOnlyFilter)paramFilter;
      label38:
      this.rV = ((FieldOnlyFilter)localObject);
      if (!(paramFilter instanceof LogicalFilter)) {
        break label149;
      }
      localObject = (LogicalFilter)paramFilter;
      label55:
      this.rW = ((LogicalFilter)localObject);
      if (!(paramFilter instanceof NotFilter)) {
        break label154;
      }
      localObject = (NotFilter)paramFilter;
      label72:
      this.rX = ((NotFilter)localObject);
      if (!(paramFilter instanceof InFilter)) {
        break label159;
      }
    }
    label144:
    label149:
    label154:
    label159:
    for (Object localObject = (InFilter)paramFilter;; localObject = null)
    {
      this.rY = ((InFilter)localObject);
      if ((this.rU != null) || (this.rV != null) || (this.rW != null) || (this.rX != null) || (this.rY != null)) {
        break label164;
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
    }
    label164:
    this.rZ = paramFilter;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    c.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/drive/query/internal/FilterHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */