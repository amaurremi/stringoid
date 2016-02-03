package com.google.android.gms.wearable;

import android.net.Uri;
import com.google.android.gms.common.data.Freezable;
import java.util.Map;

public abstract interface DataItem
  extends Freezable<DataItem>
{
  public abstract Map<String, DataItemAsset> getAssets();
  
  public abstract byte[] getData();
  
  public abstract Uri getUri();
  
  public abstract DataItem setData(byte[] paramArrayOfByte);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/wearable/DataItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */