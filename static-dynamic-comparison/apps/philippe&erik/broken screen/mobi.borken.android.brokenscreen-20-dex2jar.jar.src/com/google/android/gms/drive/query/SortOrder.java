package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.drive.query.internal.FieldWithSortOrder;
import java.util.ArrayList;
import java.util.List;

public class SortOrder
  implements SafeParcelable
{
  public static final Parcelable.Creator<SortOrder> CREATOR = new b();
  final List<FieldWithSortOrder> KH;
  final int xJ;
  
  SortOrder(int paramInt, List<FieldWithSortOrder> paramList)
  {
    this.xJ = paramInt;
    this.KH = paramList;
  }
  
  private SortOrder(List<FieldWithSortOrder> paramList)
  {
    this(1, paramList);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    b.a(this, paramParcel, paramInt);
  }
  
  public static class Builder
  {
    private final List<FieldWithSortOrder> KH = new ArrayList();
    
    public Builder addSortAscending(SortableMetadataField paramSortableMetadataField)
    {
      this.KH.add(new FieldWithSortOrder(paramSortableMetadataField.getName(), true));
      return this;
    }
    
    public Builder addSortDescending(SortableMetadataField paramSortableMetadataField)
    {
      this.KH.add(new FieldWithSortOrder(paramSortableMetadataField.getName(), false));
      return this;
    }
    
    public SortOrder build()
    {
      return new SortOrder(this.KH, null);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/drive/query/SortOrder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */