package com.venticake.retrica.view.album;

import java.util.ArrayList;

public final class MediaClustering
{
  private static int CLUSTER_SPLIT_MULTIPLIER = 3;
  private static final int GEOGRAPHIC_DISTANCE_CUTOFF_IN_MILES = 20;
  private static final long MAX_CLUSTER_SPLIT_TIME_IN_MS = 7200000L;
  private static final int MAX_MAX_CLUSTER_SIZE = 50;
  private static final int MAX_MIN_CLUSTER_SIZE = 15;
  private static final long MIN_CLUSTER_SPLIT_TIME_IN_MS = 60000L;
  private static final int MIN_MAX_CLUSTER_SIZE = 20;
  private static final int MIN_MIN_CLUSTER_SIZE = 8;
  private static final int MIN_PARTITION_CHANGE_FACTOR = 2;
  private static final int NUM_CLUSTERS_TARGETED = 9;
  private static final int PARTITION_CLUSTER_SPLIT_TIME_FACTOR = 2;
  private long mClusterSplitTime = 3630000L;
  private ArrayList<MediaClustering.Cluster> mClusters = new ArrayList();
  private MediaClustering.Cluster mCurrCluster;
  private boolean mIsPicassaAlbum = false;
  private long mLargeClusterSplitTime = this.mClusterSplitTime / 2L;
  private int mMaxClusterSize = 35;
  private int mMinClusterSize = 11;
  
  MediaClustering(boolean paramBoolean)
  {
    this.mIsPicassaAlbum = paramBoolean;
    this.mCurrCluster = new MediaClustering.Cluster(this.mIsPicassaAlbum);
  }
  
  private int getPartitionIndexForCurrentCluster()
  {
    int i = -1;
    float f1 = 2.0F;
    ArrayList localArrayList = this.mCurrCluster.getItems();
    int m = this.mCurrCluster.mNumItemsLoaded;
    int k = this.mMinClusterSize;
    int j = i;
    if (m > k + 1)
    {
      j = k;
      if (j >= m - k) {
        j = i;
      }
    }
    else
    {
      return j;
    }
    MediaItem localMediaItem1 = (MediaItem)localArrayList.get(j - 1);
    MediaItem localMediaItem2 = (MediaItem)localArrayList.get(j);
    MediaItem localMediaItem3 = (MediaItem)localArrayList.get(j + 1);
    float f2;
    if ((localMediaItem1.isDateTakenValid()) && (localMediaItem2.isDateModifiedValid()) && (localMediaItem3.isDateModifiedValid()))
    {
      long l1 = Math.abs(localMediaItem3.mDateTakenInMs - localMediaItem2.mDateTakenInMs);
      long l2 = Math.abs(localMediaItem2.mDateTakenInMs - localMediaItem1.mDateTakenInMs);
      f2 = Math.max((float)l1 / ((float)l2 + 0.01F), (float)l2 / ((float)l1 + 0.01F));
      if (f2 > f1) {
        if (timeDistance(localMediaItem2, localMediaItem1) > this.mLargeClusterSplitTime)
        {
          f1 = f2;
          i = j;
        }
      }
    }
    for (;;)
    {
      j += 1;
      break;
      if (timeDistance(localMediaItem3, localMediaItem2) > this.mLargeClusterSplitTime)
      {
        i = j + 1;
        f1 = f2;
      }
    }
  }
  
  private static boolean isGeographicallySeparated(MediaItem paramMediaItem1, MediaItem paramMediaItem2)
  {
    return (paramMediaItem1 != null) && (paramMediaItem2 != null) && (paramMediaItem1.isLatLongValid()) && (paramMediaItem2.isLatLongValid()) && ((int)(LocationMediaFilter.toMile(LocationMediaFilter.distanceBetween(paramMediaItem1.mLatitude, paramMediaItem1.mLongitude, paramMediaItem2.mLatitude, paramMediaItem2.mLongitude)) + 0.5D) > 20);
  }
  
  private void mergeAndAddCurrentCluster()
  {
    int j = this.mClusters.size();
    MediaClustering.Cluster localCluster = (MediaClustering.Cluster)this.mClusters.get(j - 1);
    ArrayList localArrayList = this.mCurrCluster.getItems();
    int k = this.mCurrCluster.mNumItemsLoaded;
    if (localCluster.mNumItemsLoaded < this.mMinClusterSize)
    {
      int i = 0;
      for (;;)
      {
        if (i >= k)
        {
          this.mClusters.set(j - 1, localCluster);
          return;
        }
        localCluster.addItem((MediaItem)localArrayList.get(i));
        i += 1;
      }
    }
    this.mClusters.add(this.mCurrCluster);
  }
  
  private void splitAndAddCurrentCluster()
  {
    ArrayList localArrayList = this.mCurrCluster.getItems();
    int k = this.mCurrCluster.mNumItemsLoaded;
    int j = getPartitionIndexForCurrentCluster();
    if (j != -1)
    {
      MediaClustering.Cluster localCluster = new MediaClustering.Cluster(this.mIsPicassaAlbum);
      int i = 0;
      if (i >= j)
      {
        this.mClusters.add(localCluster);
        localCluster = new MediaClustering.Cluster(this.mIsPicassaAlbum);
        i = j;
      }
      for (;;)
      {
        if (i >= k)
        {
          this.mClusters.add(localCluster);
          return;
          localCluster.addItem((MediaItem)localArrayList.get(i));
          i += 1;
          break;
        }
        localCluster.addItem((MediaItem)localArrayList.get(i));
        i += 1;
      }
    }
    this.mClusters.add(this.mCurrCluster);
  }
  
  public static long timeDistance(MediaItem paramMediaItem1, MediaItem paramMediaItem2)
  {
    if ((paramMediaItem1 == null) || (paramMediaItem2 == null)) {
      return 0L;
    }
    return Math.abs(paramMediaItem1.mDateTakenInMs - paramMediaItem2.mDateTakenInMs);
  }
  
  public void addItemForClustering(MediaItem paramMediaItem)
  {
    compute(paramMediaItem, false);
  }
  
  public void clear()
  {
    int j = this.mClusters.size();
    int i = 0;
    for (;;)
    {
      if (i >= j)
      {
        if (this.mCurrCluster != null) {
          this.mCurrCluster.clear();
        }
        return;
      }
      ((MediaClustering.Cluster)this.mClusters.get(i)).clear();
      i += 1;
    }
  }
  
  public void compute(MediaItem paramMediaItem, boolean paramBoolean)
  {
    int j = 0;
    int i;
    int k;
    if (paramMediaItem != null)
    {
      i = this.mClusters.size();
      k = this.mCurrCluster.mNumItemsLoaded;
      if (k == 0) {
        this.mCurrCluster.addItem(paramMediaItem);
      }
    }
    else if ((paramBoolean) && (this.mCurrCluster.mNumItemsLoaded > 0))
    {
      i = this.mClusters.size();
      j = this.mCurrCluster.mNumItemsLoaded;
      if (j <= this.mMaxClusterSize) {
        break label269;
      }
      splitAndAddCurrentCluster();
    }
    for (;;)
    {
      this.mCurrCluster = new MediaClustering.Cluster(this.mIsPicassaAlbum);
      return;
      MediaItem localMediaItem = this.mCurrCluster.getLastItem();
      if (isGeographicallySeparated(localMediaItem, paramMediaItem))
      {
        this.mClusters.add(this.mCurrCluster);
        i = 1;
      }
      for (;;)
      {
        if (j != 0) {
          break label267;
        }
        this.mCurrCluster = new MediaClustering.Cluster(this.mIsPicassaAlbum);
        if (i != 0) {
          MediaClustering.Cluster.access$1(this.mCurrCluster, true);
        }
        this.mCurrCluster.addItem(paramMediaItem);
        break;
        if (k > this.mMaxClusterSize)
        {
          splitAndAddCurrentCluster();
          i = 0;
        }
        else if (timeDistance(localMediaItem, paramMediaItem) < this.mClusterSplitTime)
        {
          this.mCurrCluster.addItem(paramMediaItem);
          i = 0;
          j = 1;
        }
        else if ((i > 0) && (k < this.mMinClusterSize) && (!MediaClustering.Cluster.access$0(this.mCurrCluster)))
        {
          mergeAndAddCurrentCluster();
          i = 0;
        }
        else
        {
          this.mClusters.add(this.mCurrCluster);
          i = 0;
        }
      }
      label267:
      break;
      label269:
      if ((i > 0) && (j < this.mMinClusterSize) && (!MediaClustering.Cluster.access$0(this.mCurrCluster))) {
        mergeAndAddCurrentCluster();
      } else {
        this.mClusters.add(this.mCurrCluster);
      }
    }
  }
  
  /* Error */
  public ArrayList<MediaClustering.Cluster> getClusters()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 73	com/venticake/retrica/view/album/MediaClustering:mCurrCluster	Lcom/venticake/retrica/view/album/MediaClustering$Cluster;
    //   6: getfield 82	com/venticake/retrica/view/album/MediaClustering$Cluster:mNumItemsLoaded	I
    //   9: istore_1
    //   10: iload_1
    //   11: ifne +12 -> 23
    //   14: aload_0
    //   15: getfield 67	com/venticake/retrica/view/album/MediaClustering:mClusters	Ljava/util/ArrayList;
    //   18: astore_2
    //   19: aload_0
    //   20: monitorexit
    //   21: aload_2
    //   22: areturn
    //   23: new 64	java/util/ArrayList
    //   26: dup
    //   27: invokespecial 65	java/util/ArrayList:<init>	()V
    //   30: astore_3
    //   31: aload_3
    //   32: aload_0
    //   33: getfield 67	com/venticake/retrica/view/album/MediaClustering:mClusters	Ljava/util/ArrayList;
    //   36: invokevirtual 187	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   39: pop
    //   40: aload_3
    //   41: astore_2
    //   42: iload_1
    //   43: ifle -24 -> 19
    //   46: aload_3
    //   47: aload_0
    //   48: getfield 73	com/venticake/retrica/view/album/MediaClustering:mCurrCluster	Lcom/venticake/retrica/view/album/MediaClustering$Cluster;
    //   51: invokevirtual 153	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   54: pop
    //   55: aload_3
    //   56: astore_2
    //   57: goto -38 -> 19
    //   60: astore_2
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_2
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	MediaClustering
    //   9	34	1	i	int
    //   18	39	2	localObject1	Object
    //   60	4	2	localObject2	Object
    //   30	26	3	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   2	10	60	finally
    //   14	19	60	finally
    //   23	40	60	finally
    //   46	55	60	finally
  }
  
  public ArrayList<MediaClustering.Cluster> getClustersForDisplay()
  {
    return this.mClusters;
  }
  
  public void removeItemFromClustering(MediaItem paramMediaItem)
  {
    if (this.mCurrCluster.removeItem(paramMediaItem)) {}
    label73:
    for (;;)
    {
      return;
      int j = this.mClusters.size();
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label73;
        }
        MediaClustering.Cluster localCluster = (MediaClustering.Cluster)this.mClusters.get(i);
        if (localCluster.removeItem(paramMediaItem))
        {
          if (localCluster.mNumItemsLoaded != 0) {
            break;
          }
          this.mClusters.remove(localCluster);
          return;
        }
        i += 1;
      }
    }
  }
  
  public void setTimeRange(long paramLong, int paramInt)
  {
    if (paramInt != 0)
    {
      int i = paramInt / 9;
      this.mMinClusterSize = (i / 2);
      this.mMaxClusterSize = (i * 2);
      this.mClusterSplitTime = (paramLong / paramInt * CLUSTER_SPLIT_MULTIPLIER);
    }
    this.mClusterSplitTime = Shared.clamp(this.mClusterSplitTime, 60000L, 7200000L);
    this.mLargeClusterSplitTime = (this.mClusterSplitTime / 2L);
    this.mMinClusterSize = Shared.clamp(this.mMinClusterSize, 8, 15);
    this.mMaxClusterSize = Shared.clamp(this.mMaxClusterSize, 20, 50);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/album/MediaClustering.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */