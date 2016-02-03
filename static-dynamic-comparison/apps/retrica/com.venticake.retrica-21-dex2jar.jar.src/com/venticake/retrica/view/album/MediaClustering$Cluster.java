package com.venticake.retrica.view.album;

import android.content.Context;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import java.util.ArrayList;
import java.util.TimeZone;

public final class MediaClustering$Cluster
  extends MediaSet
{
  private static final String MMDDYY_FORMAT = "MMddyy";
  private boolean mClusterChanged = false;
  private boolean mGeographicallySeparatedFromPrevCluster = false;
  private boolean mIsPicassaAlbum = false;
  
  public MediaClustering$Cluster(boolean paramBoolean)
  {
    this.mIsPicassaAlbum = paramBoolean;
  }
  
  public void addItem(MediaItem paramMediaItem)
  {
    super.addItem(paramMediaItem);
    this.mClusterChanged = true;
  }
  
  public void generateCaption(Context paramContext)
  {
    long l1;
    long l2;
    if (this.mClusterChanged)
    {
      paramContext.getResources();
      if (!areTimestampsAvailable()) {
        break label207;
      }
      l1 = this.mMinTimestamp;
      l2 = this.mMaxTimestamp;
    }
    for (;;)
    {
      long l4;
      long l3;
      if (l1 != -1L)
      {
        l4 = l1;
        l3 = l2;
        if (this.mIsPicassaAlbum)
        {
          l4 = l1 - TimeZone.getDefault().getOffset(l1);
          l3 = l2 - TimeZone.getDefault().getOffset(l2);
        }
        String str1 = DateFormat.format("MMddyy", l4).toString();
        String str2 = DateFormat.format("MMddyy", l3).toString();
        if (str1.substring(4).equals(str2.substring(4)))
        {
          this.mName = DateUtils.formatDateRange(paramContext, l4, l3, 524288);
          if ((str1.equals(str2)) && (!DateUtils.formatDateTime(paramContext, l4, 65552).equals(DateUtils.formatDateTime(paramContext, l4, 65556))))
          {
            l1 = (l4 + l3) / 2L;
            this.mName = DateUtils.formatDateRange(paramContext, l1, l1, 65553);
          }
        }
      }
      for (;;)
      {
        updateNumExpectedItems();
        generateTitle(false);
        this.mClusterChanged = false;
        return;
        label207:
        if (!areAddedTimestampsAvailable()) {
          break label254;
        }
        l1 = this.mMinAddedTimestamp;
        l2 = this.mMaxAddedTimestamp;
        break;
        this.mName = DateUtils.formatDateRange(paramContext, l4, l3, 65584);
        continue;
        this.mName = "date_unkown";
      }
      label254:
      l2 = -1L;
      l1 = -1L;
    }
  }
  
  public MediaItem getLastItem()
  {
    ArrayList localArrayList = super.getItems();
    if ((localArrayList == null) || (this.mNumItemsLoaded == 0)) {
      return null;
    }
    return (MediaItem)localArrayList.get(this.mNumItemsLoaded - 1);
  }
  
  public boolean removeItem(MediaItem paramMediaItem)
  {
    if (super.removeItem(paramMediaItem))
    {
      this.mClusterChanged = true;
      return true;
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/album/MediaClustering$Cluster.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */