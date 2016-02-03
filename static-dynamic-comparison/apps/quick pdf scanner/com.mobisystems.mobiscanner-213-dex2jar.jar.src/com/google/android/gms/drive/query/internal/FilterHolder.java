package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.a;

public class FilterHolder
  implements SafeParcelable
{
  public static final Parcelable.Creator<FilterHolder> CREATOR = new c();
  final int qh;
  final ComparisonFilter<?> ut;
  final FieldOnlyFilter uu;
  final LogicalFilter uv;
  final NotFilter uw;
  final InFilter<?> ux;
  private final a uy;
  
  FilterHolder(int paramInt, ComparisonFilter<?> paramComparisonFilter, FieldOnlyFilter paramFieldOnlyFilter, LogicalFilter paramLogicalFilter, NotFilter paramNotFilter, InFilter<?> paramInFilter)
  {
    this.qh = paramInt;
    this.ut = paramComparisonFilter;
    this.uu = paramFieldOnlyFilter;
    this.uv = paramLogicalFilter;
    this.uw = paramNotFilter;
    this.ux = paramInFilter;
    if (this.ut != null)
    {
      this.uy = this.ut;
      return;
    }
    if (this.uu != null)
    {
      this.uy = this.uu;
      return;
    }
    if (this.uv != null)
    {
      this.uy = this.uv;
      return;
    }
    if (this.uw != null)
    {
      this.uy = this.uw;
      return;
    }
    if (this.ux != null)
    {
      this.uy = this.ux;
      return;
    }
    throw new IllegalArgumentException("At least one filter must be set.");
  }
  
  public FilterHolder(a parama)
  {
    this.qh = 1;
    if ((parama instanceof ComparisonFilter))
    {
      localObject = (ComparisonFilter)parama;
      this.ut = ((ComparisonFilter)localObject);
      if (!(parama instanceof FieldOnlyFilter)) {
        break label144;
      }
      localObject = (FieldOnlyFilter)parama;
      label38:
      this.uu = ((FieldOnlyFilter)localObject);
      if (!(parama instanceof LogicalFilter)) {
        break label149;
      }
      localObject = (LogicalFilter)parama;
      label55:
      this.uv = ((LogicalFilter)localObject);
      if (!(parama instanceof NotFilter)) {
        break label154;
      }
      localObject = (NotFilter)parama;
      label72:
      this.uw = ((NotFilter)localObject);
      if (!(parama instanceof InFilter)) {
        break label159;
      }
    }
    label144:
    label149:
    label154:
    label159:
    for (Object localObject = (InFilter)parama;; localObject = null)
    {
      this.ux = ((InFilter)localObject);
      if ((this.ut != null) || (this.uu != null) || (this.uv != null) || (this.uw != null) || (this.ux != null)) {
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
    this.uy = parama;
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/drive/query/internal/FilterHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */