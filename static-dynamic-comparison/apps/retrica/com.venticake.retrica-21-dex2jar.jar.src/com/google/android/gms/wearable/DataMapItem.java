package com.google.android.gms.wearable;

import android.net.Uri;
import com.google.android.gms.internal.lv;
import com.google.android.gms.internal.lv.a;
import com.google.android.gms.internal.lw;
import com.google.android.gms.internal.md;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataMapItem
{
  private final DataMap all;
  private final Uri mUri;
  
  private DataMapItem(DataItem paramDataItem)
  {
    this.mUri = paramDataItem.getUri();
    this.all = a((DataItem)paramDataItem.freeze());
  }
  
  private DataMap a(DataItem paramDataItem)
  {
    if ((paramDataItem.getData() == null) && (paramDataItem.getAssets().size() > 0)) {
      throw new IllegalArgumentException("Cannot create DataMapItem from a DataItem  that wasn't made with DataMapItem.");
    }
    if (paramDataItem.getData() == null) {
      return new DataMap();
    }
    ArrayList localArrayList;
    for (;;)
    {
      int i;
      DataItemAsset localDataItemAsset;
      try
      {
        localArrayList = new ArrayList();
        int j = paramDataItem.getAssets().size();
        i = 0;
        if (i >= j) {
          break;
        }
        localDataItemAsset = (DataItemAsset)paramDataItem.getAssets().get(Integer.toString(i));
        if (localDataItemAsset == null) {
          throw new IllegalStateException("Cannot find DataItemAsset referenced in data at " + i + " for " + paramDataItem);
        }
      }
      catch (md paramDataItem)
      {
        throw new IllegalStateException("Unable to parse. Not a DataItem.");
      }
      localArrayList.add(Asset.createFromRef(localDataItemAsset.getId()));
      i += 1;
    }
    paramDataItem = lv.a(new lv.a(lw.n(paramDataItem.getData()), localArrayList));
    return paramDataItem;
  }
  
  public static DataMapItem fromDataItem(DataItem paramDataItem)
  {
    if (paramDataItem == null) {
      throw new IllegalStateException("provided dataItem is null");
    }
    return new DataMapItem(paramDataItem);
  }
  
  public DataMap getDataMap()
  {
    return this.all;
  }
  
  public Uri getUri()
  {
    return this.mUri;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/wearable/DataMapItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */