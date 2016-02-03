package com.venticake.retrica.view.album;

import java.util.ArrayList;

public class MediaSet
{
  public static final int TYPE_FOLDER = 1;
  public static final int TYPE_SMART = 0;
  public static final int TYPE_USERDEFINED = 2;
  public DataSource mDataSource;
  public String mEditUri = null;
  public boolean mHasImages;
  public boolean mHasVideos;
  public long mId;
  private ArrayList<MediaItem> mItems = new ArrayList(16);
  public boolean mLatLongDetermined = false;
  public long mMaxAddedTimestamp = 0L;
  public double mMaxLatLatitude = -90.0D;
  public double mMaxLatLongitude;
  public double mMaxLonLatitude;
  public double mMaxLonLongitude = -180.0D;
  public long mMaxTimestamp = 0L;
  public long mMinAddedTimestamp = Long.MAX_VALUE;
  public double mMinLatLatitude = 90.0D;
  public double mMinLatLongitude;
  public double mMinLonLatitude;
  public double mMinLonLongitude = 180.0D;
  public long mMinTimestamp = Long.MAX_VALUE;
  public String mName;
  public String mNoCountTitleString;
  private int mNumExpectedItems = 0;
  private boolean mNumExpectedItemsCountAccurate = false;
  public int mNumItemsLoaded = 0;
  public long mPicasaAlbumId = -1L;
  public String mReverseGeocodedLocation;
  public boolean mReverseGeocodedLocationComputed = false;
  public boolean mReverseGeocodedLocationRequestMade = false;
  public boolean mSyncPending = false;
  public String mTitleString;
  public String mTruncTitleString;
  public int mType;
  
  public MediaSet()
  {
    this(null);
  }
  
  public MediaSet(DataSource paramDataSource)
  {
    this.mDataSource = paramDataSource;
    paramDataSource = new MediaItem();
    paramDataSource.mId = -1L;
    paramDataSource.mParentMediaSet = this;
    this.mItems.add(paramDataSource);
    this.mNumExpectedItems = 16;
  }
  
  public void addItem(MediaItem paramMediaItem)
  {
    if (this.mItems.size() == 0)
    {
      this.mItems.add(paramMediaItem);
      if (paramMediaItem != null) {
        break label70;
      }
    }
    label70:
    label307:
    for (;;)
    {
      return;
      if (((MediaItem)this.mItems.get(0)).mId == -1L)
      {
        this.mItems.set(0, paramMediaItem);
        break;
      }
      this.mItems.add(paramMediaItem);
      break;
      if (paramMediaItem.mId != -1L) {
        this.mNumItemsLoaded += 1;
      }
      long l;
      if (paramMediaItem.isDateTakenValid())
      {
        l = paramMediaItem.mDateTakenInMs;
        if (l < this.mMinTimestamp) {
          this.mMinTimestamp = l;
        }
        if (l > this.mMaxTimestamp) {
          this.mMaxTimestamp = l;
        }
      }
      for (;;)
      {
        if (!paramMediaItem.isLatLongValid()) {
          break label307;
        }
        double d1 = paramMediaItem.mLatitude;
        double d2 = paramMediaItem.mLongitude;
        if (this.mMinLatLatitude > d1)
        {
          this.mMinLatLatitude = d1;
          this.mMinLatLongitude = d2;
          this.mLatLongDetermined = true;
        }
        if (this.mMaxLatLatitude < d1)
        {
          this.mMaxLatLatitude = d1;
          this.mMaxLatLongitude = d2;
          this.mLatLongDetermined = true;
        }
        if (this.mMinLonLongitude > d2)
        {
          this.mMinLonLatitude = d1;
          this.mMinLonLongitude = d2;
          this.mLatLongDetermined = true;
        }
        if (this.mMaxLonLongitude >= d2) {
          break;
        }
        this.mMaxLonLatitude = d1;
        this.mMaxLonLongitude = d2;
        this.mLatLongDetermined = true;
        return;
        if (paramMediaItem.isDateAddedValid())
        {
          l = paramMediaItem.mDateAddedInSec * 1000L;
          if (l < this.mMinAddedTimestamp) {
            this.mMinAddedTimestamp = l;
          }
          if (l > this.mMaxAddedTimestamp) {
            this.mMaxAddedTimestamp = l;
          }
        }
      }
    }
  }
  
  public boolean areAddedTimestampsAvailable()
  {
    return (this.mMinAddedTimestamp < Long.MAX_VALUE) && (this.mMaxAddedTimestamp > 0L);
  }
  
  public boolean areTimestampsAvailable()
  {
    return (this.mMinTimestamp < Long.MAX_VALUE) && (this.mMaxTimestamp > 0L);
  }
  
  public void clear()
  {
    this.mItems.clear();
    MediaItem localMediaItem = new MediaItem();
    localMediaItem.mId = -1L;
    localMediaItem.mParentMediaSet = this;
    this.mItems.add(localMediaItem);
    this.mNumExpectedItems = 16;
    this.mNumExpectedItemsCountAccurate = false;
    this.mNumItemsLoaded = 0;
  }
  
  public boolean containsItem(MediaItem paramMediaItem)
  {
    return ArrayUtils.contains(this.mItems, paramMediaItem);
  }
  
  public void generateTitle(boolean paramBoolean)
  {
    if (this.mName == null) {
      this.mName = "";
    }
    int i;
    if (this.mNumExpectedItemsCountAccurate)
    {
      str = "  (" + this.mNumExpectedItems + ")";
      this.mTitleString = (this.mName + str);
      if (!paramBoolean) {
        break label180;
      }
      i = this.mName.length();
      if (i <= 16) {
        break label155;
      }
    }
    label155:
    for (String str = this.mName.substring(0, 12) + "..." + this.mName.substring(i - 4, i) + str;; str = this.mName + str)
    {
      this.mTruncTitleString = str;
      this.mNoCountTitleString = this.mName;
      return;
      str = "";
      break;
    }
    label180:
    this.mTruncTitleString = this.mTitleString;
  }
  
  public ArrayList<MediaItem> getItems()
  {
    return this.mItems;
  }
  
  public int getNumExpectedItems()
  {
    return this.mNumExpectedItems;
  }
  
  public int getNumItems()
  {
    return this.mItems.size();
  }
  
  public boolean isPicassaAlbum()
  {
    return this.mPicasaAlbumId != -1L;
  }
  
  public boolean isPicassaSet()
  {
    if (isPicassaAlbum()) {
      return true;
    }
    int j = this.mItems.size();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return true;
      }
      if (!((MediaItem)this.mItems.get(i)).isPicassaItem()) {
        return false;
      }
      i += 1;
    }
  }
  
  public boolean isTruncated()
  {
    return (this.mTitleString != null) && (!this.mTitleString.equals(this.mTruncTitleString));
  }
  
  public boolean removeItem(MediaItem paramMediaItem)
  {
    if (this.mItems.remove(paramMediaItem))
    {
      this.mNumExpectedItems -= 1;
      this.mNumItemsLoaded -= 1;
      return true;
    }
    return false;
  }
  
  public boolean setContainsValidItems()
  {
    return this.mNumExpectedItems != 0;
  }
  
  public void setNumExpectedItems(int paramInt)
  {
    this.mItems.ensureCapacity(paramInt);
    this.mNumExpectedItems = paramInt;
    this.mNumExpectedItemsCountAccurate = true;
  }
  
  public void updateNumExpectedItems()
  {
    this.mNumExpectedItems = this.mNumItemsLoaded;
    this.mNumExpectedItemsCountAccurate = true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/album/MediaSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */