package com.venticake.retrica.view.album;

import android.content.Context;
import android.os.Process;
import android.view.View;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;

public final class MediaFeed
  implements Runnable
{
  private static final int NUM_ITEMS_LOOKAHEAD = 60;
  public static final int OPERATION_CROP = 2;
  public static final int OPERATION_DELETE = 0;
  public static final int OPERATION_ROTATE = 1;
  private Thread mAlbumSourceThread = null;
  private IndexRange mBufferedRange = new IndexRange();
  private HashMap<MediaSet, MediaClustering> mClusterSets = new HashMap(32);
  private Context mContext;
  private DataSource mDataSource;
  private Thread mDataSourceThread = null;
  private int mExpandedMediaSetIndex = -1;
  private boolean mInClusteringMode = false;
  private MediaFeed.Listener mListener;
  private boolean mListenerNeedsLayout;
  private boolean mListenerNeedsUpdate = false;
  private boolean mLoading;
  private boolean mMediaFeedNeedsToRun = false;
  private MediaFilter mMediaFilter;
  private MediaSet mMediaFilteredSet;
  private ArrayList<MediaSet> mMediaSets = new ArrayList();
  private boolean mSingleImageMode;
  private MediaSet mSingleWrapper = new MediaSet();
  private IndexRange mVisibleRange = new IndexRange();
  private boolean mWaitingForMediaScanner;
  
  public MediaFeed(Context paramContext, DataSource paramDataSource, MediaFeed.Listener paramListener)
  {
    this.mContext = paramContext;
    this.mListener = paramListener;
    this.mDataSource = paramDataSource;
    this.mSingleWrapper.setNumExpectedItems(1);
    this.mLoading = true;
  }
  
  private boolean disableClusteringIfNecessary()
  {
    if (this.mInClusteringMode)
    {
      this.mInClusteringMode = false;
      this.mMediaFeedNeedsToRun = true;
      return true;
    }
    return false;
  }
  
  private void removeItemFromMediaSet(MediaItem paramMediaItem, MediaSet paramMediaSet)
  {
    paramMediaSet.removeItem(paramMediaItem);
    synchronized (this.mClusterSets)
    {
      paramMediaSet = (MediaClustering)this.mClusterSets.get(paramMediaSet);
      if (paramMediaSet != null) {
        paramMediaSet.removeItemFromClustering(paramMediaItem);
      }
      this.mMediaFeedNeedsToRun = true;
      return;
    }
  }
  
  private void showToast(String paramString, int paramInt)
  {
    showToast(paramString, paramInt, false);
  }
  
  private void showToast(final String paramString, final int paramInt, final boolean paramBoolean)
  {
    if (this.mContext != null) {
      ((QuickViewActivity)this.mContext).getHandler().post(new Runnable()
      {
        public void run()
        {
          if (MediaFeed.this.mContext != null)
          {
            Toast localToast = Toast.makeText(MediaFeed.this.mContext, paramString, paramInt);
            if (paramBoolean) {
              localToast.setGravity(17, 0, 0);
            }
            localToast.show();
          }
        }
      });
    }
  }
  
  public void addItemToMediaSet(MediaItem paramMediaItem, MediaSet paramMediaSet)
  {
    paramMediaItem.mParentMediaSet = paramMediaSet;
    paramMediaSet.addItem(paramMediaItem);
    synchronized (this.mClusterSets)
    {
      if (paramMediaItem.mClusteringState == 0)
      {
        MediaClustering localMediaClustering2 = (MediaClustering)this.mClusterSets.get(paramMediaSet);
        MediaClustering localMediaClustering1 = localMediaClustering2;
        if (localMediaClustering2 == null)
        {
          localMediaClustering1 = new MediaClustering(paramMediaSet.isPicassaAlbum());
          this.mClusterSets.put(paramMediaSet, localMediaClustering1);
        }
        localMediaClustering1.setTimeRange(paramMediaSet.mMaxTimestamp - paramMediaSet.mMinTimestamp, paramMediaSet.getNumExpectedItems());
        localMediaClustering1.addItemForClustering(paramMediaItem);
        paramMediaItem.mClusteringState = 1;
      }
      this.mMediaFeedNeedsToRun = true;
      return;
    }
  }
  
  public MediaSet addMediaSet(long paramLong, DataSource paramDataSource)
  {
    paramDataSource = new MediaSet(paramDataSource);
    paramDataSource.mId = paramLong;
    this.mMediaSets.add(paramDataSource);
    if ((this.mDataSourceThread != null) && (!this.mDataSourceThread.isAlive())) {
      this.mDataSourceThread.start();
    }
    this.mMediaFeedNeedsToRun = true;
    return paramDataSource;
  }
  
  public boolean canExpandSet(int paramInt)
  {
    if ((paramInt < this.mMediaSets.size()) && (paramInt >= 0))
    {
      MediaSet localMediaSet = (MediaSet)this.mMediaSets.get(paramInt);
      if (localMediaSet.getNumItems() > 0) {
        return ((MediaItem)localMediaSet.getItems().get(0)).mId != -1L;
      }
    }
    return false;
  }
  
  public void expandMediaSet(int paramInt)
  {
    if (this.mListener != null) {
      this.mListener.onFeedAboutToChange(this);
    }
    if ((this.mExpandedMediaSetIndex > 0) && (paramInt == -1) && (paramInt < this.mMediaSets.size()) && (this.mExpandedMediaSetIndex >= 0) && (this.mExpandedMediaSetIndex < this.mMediaSets.size()))
    {
      MediaSet localMediaSet = (MediaSet)this.mMediaSets.get(this.mExpandedMediaSetIndex);
      if (localMediaSet.getNumItems() == 0) {
        localMediaSet.clear();
      }
    }
    this.mExpandedMediaSetIndex = paramInt;
    if (paramInt < this.mMediaSets.size()) {}
    updateListener(true);
    this.mMediaFeedNeedsToRun = true;
  }
  
  public MediaClustering getClustering()
  {
    if ((this.mExpandedMediaSetIndex != -1) && (this.mExpandedMediaSetIndex < this.mMediaSets.size())) {
      return (MediaClustering)this.mClusterSets.get(this.mMediaSets.get(this.mExpandedMediaSetIndex));
    }
    return null;
  }
  
  public ArrayList<MediaClustering.Cluster> getClustersForSet(MediaSet paramMediaSet)
  {
    if ((this.mClusterSets != null) && (this.mClusterSets.containsKey(paramMediaSet)))
    {
      paramMediaSet = (MediaClustering)this.mClusterSets.get(paramMediaSet);
      if (paramMediaSet != null) {
        return paramMediaSet.getClusters();
      }
    }
    return null;
  }
  
  public MediaSet getCurrentSet()
  {
    if ((this.mExpandedMediaSetIndex != -1) && (this.mExpandedMediaSetIndex < this.mMediaSets.size())) {
      return (MediaSet)this.mMediaSets.get(this.mExpandedMediaSetIndex);
    }
    return null;
  }
  
  public DataSource getDataSource()
  {
    return this.mDataSource;
  }
  
  public MediaSet getExpandedMediaSet()
  {
    if (this.mExpandedMediaSetIndex == -1) {}
    while (this.mExpandedMediaSetIndex >= this.mMediaSets.size()) {
      return null;
    }
    return (MediaSet)this.mMediaSets.get(this.mExpandedMediaSetIndex);
  }
  
  public MediaSet getFilteredSet()
  {
    return this.mMediaFilteredSet;
  }
  
  public MediaSet getMediaSet(long paramLong)
  {
    if (paramLong != -1L)
    {
      int j;
      int i;
      do
      {
        try
        {
          j = this.mMediaSets.size();
          i = 0;
        }
        catch (Exception localException)
        {
          MediaSet localMediaSet;
          return null;
        }
        if (((MediaSet)this.mMediaSets.get(i)).mId == paramLong)
        {
          localMediaSet = (MediaSet)this.mMediaSets.get(i);
          return localMediaSet;
        }
        i += 1;
      } while (i < j);
    }
    return null;
  }
  
  public ArrayList<MediaSet> getMediaSets()
  {
    return this.mMediaSets;
  }
  
  public int getNumSlots()
  {
    int i = this.mExpandedMediaSetIndex;
    Object localObject = this.mMediaSets;
    int j = ((ArrayList)localObject).size();
    if (!this.mInClusteringMode)
    {
      if ((i == -1) || (i >= j)) {
        return j;
      }
      if (this.mMediaFilteredSet == null) {}
      for (localObject = (MediaSet)((ArrayList)localObject).get(i);; localObject = this.mMediaFilteredSet) {
        return ((MediaSet)localObject).getNumItems();
      }
    }
    if ((i != -1) && (i < j))
    {
      localObject = (MediaSet)((ArrayList)localObject).get(i);
      localObject = (MediaClustering)this.mClusterSets.get(localObject);
      if (localObject != null) {
        return ((MediaClustering)localObject).getClustersForDisplay().size();
      }
    }
    return 0;
  }
  
  public MediaSet getSetForSlot(int paramInt)
  {
    if (paramInt < 0) {
      return null;
    }
    Object localObject = this.mMediaSets;
    int i = ((ArrayList)localObject).size();
    int j = this.mExpandedMediaSetIndex;
    if (!this.mInClusteringMode)
    {
      if ((j == -1) || (j >= i))
      {
        if (paramInt >= i) {
          return null;
        }
        return (MediaSet)this.mMediaSets.get(paramInt);
      }
      if (this.mSingleWrapper.getNumItems() == 0) {
        this.mSingleWrapper.addItem(null);
      }
      if (this.mMediaFilteredSet == null) {}
      ArrayList localArrayList;
      for (localObject = (MediaSet)this.mMediaSets.get(j);; localObject = this.mMediaFilteredSet)
      {
        localArrayList = ((MediaSet)localObject).getItems();
        if (paramInt < ((MediaSet)localObject).getNumItems()) {
          break;
        }
        return null;
      }
      this.mSingleWrapper.getItems().set(0, (MediaItem)localArrayList.get(paramInt));
      return this.mSingleWrapper;
    }
    if ((j != -1) && (j < i))
    {
      localObject = (MediaSet)((ArrayList)localObject).get(j);
      localObject = (MediaClustering)this.mClusterSets.get(localObject);
      if (localObject != null)
      {
        localObject = ((MediaClustering)localObject).getClustersForDisplay();
        if (((ArrayList)localObject).size() > paramInt)
        {
          localObject = (MediaClustering.Cluster)((ArrayList)localObject).get(paramInt);
          ((MediaClustering.Cluster)localObject).generateCaption(this.mContext);
          return (MediaSet)localObject;
        }
      }
    }
    return null;
  }
  
  public boolean getWaitingForMediaScanner()
  {
    return this.mWaitingForMediaScanner;
  }
  
  public boolean hasExpandedMediaSet()
  {
    return this.mExpandedMediaSetIndex != -1;
  }
  
  public boolean isClustered()
  {
    return this.mInClusteringMode;
  }
  
  public boolean isLoading()
  {
    return this.mLoading;
  }
  
  public boolean isSingleImageMode()
  {
    return this.mSingleImageMode;
  }
  
  public void moveSetToFront(MediaSet paramMediaSet)
  {
    ArrayList localArrayList = this.mMediaSets;
    int j = localArrayList.size();
    if (j == 0) {
      localArrayList.add(paramMediaSet);
    }
    MediaSet localMediaSet;
    do
    {
      return;
      localMediaSet = (MediaSet)localArrayList.get(0);
    } while (localMediaSet == paramMediaSet);
    localArrayList.set(0, paramMediaSet);
    int i = 1;
    if (i >= j)
    {
      i = -1;
      label58:
      if (i == -1) {}
    }
    for (;;)
    {
      if (i <= 1)
      {
        this.mMediaFeedNeedsToRun = true;
        return;
        if ((MediaSet)localArrayList.get(i) == paramMediaSet)
        {
          localArrayList.set(i, localMediaSet);
          break label58;
        }
        i += 1;
        break;
      }
      paramMediaSet = (MediaSet)localArrayList.get(i);
      localArrayList.set(i, (MediaSet)localArrayList.get(i - 1));
      localArrayList.set(i - 1, paramMediaSet);
      i -= 1;
    }
  }
  
  public void performClustering()
  {
    Object localObject1 = null;
    if (this.mListener != null) {
      this.mListener.onFeedAboutToChange(this);
    }
    if ((this.mExpandedMediaSetIndex != -1) || (this.mExpandedMediaSetIndex < this.mMediaSets.size())) {
      localObject1 = (MediaSet)this.mMediaSets.get(this.mExpandedMediaSetIndex);
    }
    if (localObject1 != null) {}
    synchronized (this.mClusterSets)
    {
      localObject1 = (MediaClustering)this.mClusterSets.get(localObject1);
      if (localObject1 != null)
      {
        ((MediaClustering)localObject1).compute(null, true);
        this.mInClusteringMode = true;
        this.mMediaFeedNeedsToRun = true;
        updateListener(true);
        return;
      }
      return;
    }
  }
  
  public void performOperation(final int paramInt, ArrayList<MediaBucket> paramArrayList, final Object paramObject)
  {
    int j = paramArrayList.size();
    final ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    for (;;)
    {
      if (i >= j)
      {
        if ((paramInt == 0) && (this.mListener != null)) {
          this.mListener.onFeedAboutToChange(this);
        }
        paramArrayList = new Thread(new Runnable()
        {
          public void run()
          {
            ArrayList localArrayList = localArrayList;
            if (paramInt == 0)
            {
              int k = localArrayList.size();
              int i = 0;
              if (i >= k)
              {
                MediaFeed.this.updateListener(true);
                MediaFeed.this.mMediaFeedNeedsToRun = true;
                if (MediaFeed.this.mDataSource != null) {
                  MediaFeed.this.mDataSource.performOperation(0, localArrayList, null);
                }
                return;
              }
              Object localObject = (MediaBucket)localArrayList.get(i);
              MediaSet localMediaSet = ((MediaBucket)localObject).mediaSet;
              localObject = ((MediaBucket)localObject).mediaItems;
              if ((localMediaSet != null) && (localObject == null)) {
                MediaFeed.this.removeMediaSet(localMediaSet);
              }
              while ((localMediaSet == null) || (localObject == null))
              {
                i += 1;
                break;
              }
              int m = ((ArrayList)localObject).size();
              MediaClustering localMediaClustering = (MediaClustering)MediaFeed.this.mClusterSets.get(localMediaSet);
              int j = 0;
              for (;;)
              {
                if (j >= m)
                {
                  localMediaSet.updateNumExpectedItems();
                  localMediaSet.generateTitle(true);
                  break;
                }
                MediaItem localMediaItem = (MediaItem)((ArrayList)localObject).get(j);
                MediaFeed.this.removeItemFromMediaSet(localMediaItem, localMediaSet);
                if (localMediaClustering != null) {
                  localMediaClustering.removeItemFromClustering(localMediaItem);
                }
                j += 1;
              }
            }
            MediaFeed.this.mDataSource.performOperation(paramInt, localArrayList, paramObject);
          }
        });
        paramArrayList.setName("Operation " + paramInt);
        paramArrayList.start();
        return;
      }
      localArrayList.add((MediaBucket)paramArrayList.get(i));
      i += 1;
    }
  }
  
  public void removeFilter()
  {
    this.mMediaFilter = null;
    this.mMediaFilteredSet = null;
    if (this.mListener != null)
    {
      this.mListener.onFeedAboutToChange(this);
      updateListener(true);
    }
    this.mMediaFeedNeedsToRun = true;
  }
  
  public void removeMediaSet(MediaSet paramMediaSet)
  {
    synchronized (this.mMediaSets)
    {
      this.mMediaSets.remove(paramMediaSet);
      this.mMediaFeedNeedsToRun = true;
      return;
    }
  }
  
  public MediaSet replaceMediaSet(long paramLong, DataSource paramDataSource)
  {
    paramDataSource = new MediaSet(paramDataSource);
    paramDataSource.mId = paramLong;
    ArrayList localArrayList = this.mMediaSets;
    int j = localArrayList.size();
    int i = 0;
    for (;;)
    {
      if (i >= j) {}
      for (;;)
      {
        this.mMediaFeedNeedsToRun = true;
        return paramDataSource;
        MediaSet localMediaSet = (MediaSet)localArrayList.get(i);
        if (localMediaSet.mId != paramLong) {
          break;
        }
        paramDataSource.mName = localMediaSet.mName;
        paramDataSource.mHasImages = localMediaSet.mHasImages;
        paramDataSource.mHasVideos = localMediaSet.mHasVideos;
        localArrayList.set(i, paramDataSource);
      }
      i += 1;
    }
  }
  
  public boolean restorePreviousClusteringState()
  {
    boolean bool = disableClusteringIfNecessary();
    if (bool)
    {
      if (this.mListener != null) {
        this.mListener.onFeedAboutToChange(this);
      }
      updateListener(true);
      this.mMediaFeedNeedsToRun = true;
    }
    return bool;
  }
  
  public void run()
  {
    DataSource localDataSource = this.mDataSource;
    int i = 10;
    Process.setThreadPriority(10);
    if ((localDataSource == null) || (Thread.interrupted())) {
      return;
    }
    long l;
    if (this.mListenerNeedsUpdate)
    {
      this.mListenerNeedsUpdate = false;
      if (this.mListener != null) {
        this.mListener.onFeedChanged(this, this.mListenerNeedsLayout);
      }
      l = i;
    }
    for (;;)
    {
      int i4;
      int i3;
      int n;
      int m;
      int k;
      label168:
      int i1;
      try
      {
        Thread.sleep(l);
        i = 300;
        if (!this.mMediaFeedNeedsToRun) {
          break;
        }
        this.mMediaFeedNeedsToRun = false;
        synchronized (this.mMediaSets)
        {
          int i2 = this.mExpandedMediaSetIndex;
          if (i2 < this.mMediaSets.size()) {
            break label1043;
          }
          i2 = -1;
          if (i2 != -1) {
            break label1036;
          }
          i4 = ???.size();
          Object localObject4 = this.mVisibleRange;
          Object localObject3 = this.mBufferedRange;
          i3 = 0;
          i = 1;
          j = 300;
          break label1046;
          n = ???.size();
          m = 0;
          k = i;
          i = j;
          break label1056;
          if (i2 != -1)
          {
            k = this.mMediaSets.size();
            j = 0;
            if (j < k) {
              continue;
            }
            n = ((MediaSet)???.get(i2)).mNumItemsLoaded;
            j = this.mVisibleRange.end;
            if ((!this.mInClusteringMode) || (this.mClusterSets == null)) {
              break label1033;
            }
            k = 0;
            j = 0;
            localObject3 = (MediaClustering)this.mClusterSets.get(???.get(i2));
            if (localObject3 != null)
            {
              localObject3 = ((MediaClustering)localObject3).getClustersForDisplay();
              i1 = ((ArrayList)localObject3).size();
              m = 0;
              j = k;
              k = m;
              break label1066;
            }
            label279:
            localObject3 = (MediaSet)???.get(i2);
            if (n < ((MediaSet)localObject3).getNumExpectedItems())
            {
              localDataSource.loadItemsForSet(this, (MediaSet)localObject3, n, j / 60 * 60 + 60);
              if (((MediaSet)localObject3).getNumExpectedItems() == 0)
              {
                ???.remove(localObject3);
                this.mListener.onFeedChanged(this, false);
              }
              if ((n != ((MediaSet)localObject3).mNumItemsLoaded) && (this.mListener != null)) {
                this.mListener.onFeedChanged(this, false);
              }
            }
          }
          localObject3 = this.mMediaFilter;
          Object localObject5;
          if ((localObject3 != null) && (this.mMediaFilteredSet == null))
          {
            if (i2 != -1)
            {
              localObject5 = (MediaSet)???.get(i2);
              localObject4 = ((MediaSet)localObject5).getItems();
              k = ((MediaSet)localObject5).getNumItems();
              localObject5 = new MediaSet();
              ((MediaSet)localObject5).setNumExpectedItems(k);
              this.mMediaFilteredSet = ((MediaSet)localObject5);
              j = 0;
              if (j >= k)
              {
                ((MediaSet)localObject5).updateNumExpectedItems();
                ((MediaSet)localObject5).generateTitle(true);
              }
            }
            else
            {
              updateListener(true);
            }
          }
          else
          {
            break;
            if (this.mWaitingForMediaScanner) {}
            synchronized (this.mMediaSets)
            {
              this.mMediaSets.clear();
              l = i;
              try
              {
                Thread.sleep(l);
              }
              catch (InterruptedException localInterruptedException1)
              {
                return;
              }
            }
            n = i;
            i1 = j;
            if (i3 < ((IndexRange)localObject4).begin) {
              break label1084;
            }
            n = i;
            i1 = j;
            if (i3 > ((IndexRange)localObject4).end) {
              break label1084;
            }
            n = i;
            i1 = j;
            if (i == 0) {
              break label1084;
            }
            localObject5 = (MediaSet)???.get(i3);
            n = ((MediaSet)localObject5).mNumItemsLoaded;
            k = i;
            m = j;
            if (n < ((MediaSet)localObject5).getNumExpectedItems())
            {
              k = i;
              m = j;
              if (n < 8)
              {
                ((DataSource)localObject1).loadItemsForSet(this, (MediaSet)localObject5, n, 8);
                if (((MediaSet)localObject5).getNumExpectedItems() == 0)
                {
                  ???.remove(localObject5);
                  continue;
                }
                if (this.mListener == null) {
                  break label1075;
                }
                this.mListener.onFeedChanged(this, false);
                break label1075;
              }
            }
            label668:
            n = k;
            i1 = m;
            if (((MediaSet)localObject5).setContainsValidItems()) {
              break label1084;
            }
            ???.remove(localObject5);
            i = k;
            j = m;
            if (this.mListener == null) {
              break label1053;
            }
            this.mListener.onFeedChanged(this, false);
            j = m;
            i = k;
            continue;
            localObject4 = (MediaSet)???.get(m);
            if ((m >= ((IndexRange)localObject3).begin) && (m <= ((IndexRange)localObject3).end))
            {
              if (k == 0) {
                break label1117;
              }
              j = ((MediaSet)localObject4).mNumItemsLoaded;
              if ((j >= ((MediaSet)localObject4).getNumExpectedItems()) || (j >= 8)) {
                break label1117;
              }
              ((DataSource)localObject1).loadItemsForSet(this, (MediaSet)localObject4, j, 8);
              if (((MediaSet)localObject4).getNumExpectedItems() == 0)
              {
                ???.remove(localObject4);
                continue;
              }
              if (this.mListener == null) {
                break label1099;
              }
              this.mListener.onFeedChanged(this, false);
              break label1099;
            }
            if ((m >= ((IndexRange)localObject3).begin) && (m <= ((IndexRange)localObject3).end)) {
              break label1117;
            }
            localObject5 = (MediaClustering)this.mClusterSets.get(localObject4);
            if (localObject5 != null)
            {
              ((MediaClustering)localObject5).clear();
              this.mClusterSets.remove(localObject4);
            }
            if (((MediaSet)localObject4).getNumItems() == 0) {
              break label1117;
            }
            ((MediaSet)localObject4).clear();
            break label1117;
            if (j == i2) {
              break label1124;
            }
            localObject3 = (MediaSet)???.get(j);
            localObject4 = (MediaClustering)this.mClusterSets.get(localObject3);
            if (localObject4 != null)
            {
              ((MediaClustering)localObject4).clear();
              this.mClusterSets.remove(localObject3);
            }
            if (((MediaSet)localObject3).getNumItems() == 0) {
              break label1124;
            }
            ((MediaSet)localObject3).clear();
            break label1124;
            label969:
            j += ((MediaClustering.Cluster)((ArrayList)localObject3).get(k)).getNumExpectedItems();
            k += 1;
            break label1066;
          }
          MediaItem localMediaItem = (MediaItem)((ArrayList)localObject4).get(j);
          if (!((MediaFilter)localObject3).pass(localMediaItem)) {
            break label1131;
          }
          ((MediaSet)localObject5).addItem(localMediaItem);
        }
        continue;
      }
      catch (InterruptedException localInterruptedException2)
      {
        return;
      }
      label1033:
      label1036:
      i = 300;
      continue;
      label1043:
      continue;
      for (;;)
      {
        label1046:
        if (i3 < i4) {
          break label1097;
        }
        label1053:
        break;
        label1056:
        if (m < n) {
          break label1115;
        }
        break label168;
        label1066:
        if (k < i1) {
          break label969;
        }
        break label279;
        label1075:
        m = 100;
        k = 0;
        break label668;
        label1084:
        i3 += 1;
        j = i1;
        i = n;
      }
      label1097:
      continue;
      label1099:
      int j = 100;
      for (i = 0;; i = k)
      {
        m += 1;
        k = i;
        i = j;
        break label1056;
        label1115:
        break;
        label1117:
        j = i;
      }
      label1124:
      j += 1;
      continue;
      label1131:
      j += 1;
    }
  }
  
  public void setFilter(MediaFilter paramMediaFilter)
  {
    this.mMediaFilter = paramMediaFilter;
    this.mMediaFilteredSet = null;
    if (this.mListener != null) {
      this.mListener.onFeedAboutToChange(this);
    }
    this.mMediaFeedNeedsToRun = true;
  }
  
  public void setSingleImageMode(boolean paramBoolean)
  {
    this.mSingleImageMode = paramBoolean;
  }
  
  public void setVisibleRange(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != this.mVisibleRange.begin) || (paramInt2 != this.mVisibleRange.end))
    {
      this.mVisibleRange.begin = paramInt1;
      this.mVisibleRange.end = paramInt2;
      this.mBufferedRange.begin = (paramInt1 / 48 * 48 - 24);
      this.mBufferedRange.end = (96 + this.mBufferedRange.begin);
      this.mMediaFeedNeedsToRun = true;
    }
  }
  
  public void shutdown()
  {
    int j = 0;
    if (this.mDataSourceThread != null)
    {
      this.mDataSource.shutdown();
      this.mDataSourceThread.interrupt();
      this.mDataSourceThread = null;
    }
    if (this.mAlbumSourceThread != null)
    {
      this.mAlbumSourceThread.interrupt();
      this.mAlbumSourceThread = null;
    }
    int k = this.mMediaSets.size();
    int i = 0;
    if (i >= k) {}
    for (;;)
    {
      synchronized (this.mMediaSets)
      {
        this.mMediaSets.clear();
        k = this.mClusterSets.size();
        i = j;
        if (i >= k)
        {
          this.mClusterSets.clear();
          this.mListener = null;
          this.mDataSource = null;
          this.mSingleWrapper = null;
          return;
          ((MediaSet)this.mMediaSets.get(i)).clear();
          i += 1;
        }
      }
      ??? = (MediaClustering)this.mClusterSets.get(Integer.valueOf(i));
      if (??? != null) {
        ((MediaClustering)???).clear();
      }
      i += 1;
    }
  }
  
  public void start()
  {
    this.mLoading = true;
    this.mDataSourceThread = new Thread(this);
    this.mDataSourceThread.setName("MediaFeed");
    this.mAlbumSourceThread = new Thread(new Runnable()
    {
      public void run()
      {
        if (MediaFeed.this.mContext == null) {}
        for (;;)
        {
          return;
          Process.setThreadPriority(10);
          DataSource localDataSource = MediaFeed.this.mDataSource;
          if (localDataSource != null) {
            localDataSource.loadMediaSets(jdField_this);
          }
          MediaFeed.this.mWaitingForMediaScanner = false;
          if (!ImageManager.isMediaScannerScanning(MediaFeed.this.mContext.getContentResolver()))
          {
            if (MediaFeed.this.mWaitingForMediaScanner)
            {
              MediaFeed.this.showToast("loading new", 1);
              MediaFeed.this.mWaitingForMediaScanner = false;
              if (localDataSource != null) {
                localDataSource.loadMediaSets(jdField_this);
              }
            }
            MediaFeed.this.mLoading = false;
            return;
          }
          if (!Thread.interrupted())
          {
            MediaFeed.this.mWaitingForMediaScanner = true;
            try
            {
              if (MediaFeed.this.mContext != null)
              {
                MediaFeed.this.showToast("initializing", 1);
                Thread.sleep(6000L);
              }
            }
            catch (InterruptedException localInterruptedException) {}
          }
        }
      }
    });
    this.mAlbumSourceThread.setName("MediaSets");
    this.mAlbumSourceThread.start();
  }
  
  public void updateListener(boolean paramBoolean)
  {
    this.mListenerNeedsUpdate = true;
    this.mListenerNeedsLayout = paramBoolean;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/album/MediaFeed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */