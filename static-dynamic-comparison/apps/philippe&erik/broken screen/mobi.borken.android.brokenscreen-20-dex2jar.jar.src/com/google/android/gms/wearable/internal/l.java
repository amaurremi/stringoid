package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class l
  implements DataItem
{
  private byte[] TC;
  private Map<String, DataItemAsset> alH;
  private Uri mUri;
  
  public l(DataItem paramDataItem)
  {
    this.mUri = paramDataItem.getUri();
    this.TC = paramDataItem.getData();
    HashMap localHashMap = new HashMap();
    paramDataItem = paramDataItem.getAssets().entrySet().iterator();
    while (paramDataItem.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramDataItem.next();
      if (localEntry.getKey() != null) {
        localHashMap.put(localEntry.getKey(), ((DataItemAsset)localEntry.getValue()).freeze());
      }
    }
    this.alH = Collections.unmodifiableMap(localHashMap);
  }
  
  public Map<String, DataItemAsset> getAssets()
  {
    return this.alH;
  }
  
  public byte[] getData()
  {
    return this.TC;
  }
  
  public Uri getUri()
  {
    return this.mUri;
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public DataItem nm()
  {
    return this;
  }
  
  public DataItem setData(byte[] paramArrayOfByte)
  {
    throw new UnsupportedOperationException();
  }
  
  public String toString()
  {
    return toString(Log.isLoggable("DataItem", 3));
  }
  
  public String toString(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder("DataItemEntity[");
    localStringBuilder.append("@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    Object localObject2 = new StringBuilder().append(",dataSz=");
    if (this.TC == null) {}
    for (Object localObject1 = "null";; localObject1 = Integer.valueOf(this.TC.length))
    {
      localStringBuilder.append(localObject1);
      localStringBuilder.append(", numAssets=" + this.alH.size());
      localStringBuilder.append(", uri=" + this.mUri);
      if (paramBoolean) {
        break;
      }
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
    localStringBuilder.append("]\n  assets: ");
    localObject1 = this.alH.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      localStringBuilder.append("\n    " + (String)localObject2 + ": " + this.alH.get(localObject2));
    }
    localStringBuilder.append("\n  ]");
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/wearable/internal/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */