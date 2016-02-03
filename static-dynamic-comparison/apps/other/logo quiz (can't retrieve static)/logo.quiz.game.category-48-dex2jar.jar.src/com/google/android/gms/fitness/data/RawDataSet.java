package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public final class RawDataSet
  implements SafeParcelable
{
  public static final Parcelable.Creator<RawDataSet> CREATOR = new o();
  final int BR;
  final boolean Sy;
  final int Tb;
  final int Td;
  final List<RawDataPoint> Te;
  
  RawDataSet(int paramInt1, int paramInt2, int paramInt3, List<RawDataPoint> paramList, boolean paramBoolean)
  {
    this.BR = paramInt1;
    this.Tb = paramInt2;
    this.Td = paramInt3;
    this.Te = paramList;
    this.Sy = paramBoolean;
  }
  
  public RawDataSet(DataSet paramDataSet, List<DataSource> paramList, List<DataType> paramList1)
  {
    this.BR = 2;
    this.Te = paramDataSet.e(paramList);
    this.Sy = paramDataSet.iB();
    this.Tb = t.a(paramDataSet.getDataSource(), paramList);
    this.Td = t.a(paramDataSet.getDataType(), paramList1);
  }
  
  private boolean a(RawDataSet paramRawDataSet)
  {
    return (this.Tb == paramRawDataSet.Tb) && (this.Td == paramRawDataSet.Td) && (this.Sy == paramRawDataSet.Sy) && (m.equal(this.Te, paramRawDataSet.Te));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof RawDataSet)) && (a((RawDataSet)paramObject)));
  }
  
  public int hashCode()
  {
    return m.hashCode(new Object[] { Integer.valueOf(this.Tb), Integer.valueOf(this.Td) });
  }
  
  public String toString()
  {
    return String.format("RawDataSet{%s@[%s, %s]}", new Object[] { Integer.valueOf(this.Tb), Integer.valueOf(this.Td), this.Te });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    o.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/fitness/data/RawDataSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */