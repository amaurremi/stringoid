package com.venticake.retrica.view.album;

import java.util.ArrayList;

public abstract interface DataSource
{
  public abstract void loadItemsForSet(MediaFeed paramMediaFeed, MediaSet paramMediaSet, int paramInt1, int paramInt2);
  
  public abstract void loadMediaSets(MediaFeed paramMediaFeed);
  
  public abstract boolean performOperation(int paramInt, ArrayList<MediaBucket> paramArrayList, Object paramObject);
  
  public abstract void shutdown();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/album/DataSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */