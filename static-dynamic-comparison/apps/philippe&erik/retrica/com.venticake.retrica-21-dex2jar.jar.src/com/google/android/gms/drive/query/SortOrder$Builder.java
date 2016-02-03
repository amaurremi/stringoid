package com.google.android.gms.drive.query;

import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.drive.query.internal.FieldWithSortOrder;
import java.util.ArrayList;
import java.util.List;

public class SortOrder$Builder
{
  private final List<FieldWithSortOrder> KK = new ArrayList();
  
  public Builder addSortAscending(SortableMetadataField paramSortableMetadataField)
  {
    this.KK.add(new FieldWithSortOrder(paramSortableMetadataField.getName(), true));
    return this;
  }
  
  public Builder addSortDescending(SortableMetadataField paramSortableMetadataField)
  {
    this.KK.add(new FieldWithSortOrder(paramSortableMetadataField.getName(), false));
    return this;
  }
  
  public SortOrder build()
  {
    return new SortOrder(this.KK, null);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/query/SortOrder$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */