package com.venticake.retrica.view.album;

public final class MediaItem
{
  public static final int CLUSTERED = 1;
  public static final String ID = new String("id");
  public static final long MAX_VALID_DATE_IN_MS = 2049840000000L;
  public static final long MAX_VALID_DATE_IN_SEC = 2049840000L;
  public static final int MEDIA_TYPE_IMAGE = 0;
  public static final int MEDIA_TYPE_VIDEO = 1;
  public static final long MIN_VALID_DATE_IN_MS = 157680000000L;
  public static final long MIN_VALID_DATE_IN_SEC = 157680000L;
  public static final int NOT_CLUSTERED = 0;
  public static final int NOT_PRIMED = 0;
  public static final int PRIMED = 2;
  public static final int STARTED_PRIMING = 1;
  private static final String VIDEO = "video/";
  public String mCaption = "";
  public int mClusteringState = 0;
  public String mContentUri;
  public long mDateAddedInSec = 0L;
  public long mDateModifiedInSec = 0L;
  public long mDateTakenInMs = 0L;
  public String mDescription;
  private String mDisplayMimeType;
  public int mDurationInSec;
  public String mEditUri;
  public String mFilePath;
  public String mGuid;
  public long mId;
  public double mLatitude;
  public double mLongitude;
  private int mMediaType = -1;
  public String mMicroThumbnailUri;
  public String mMimeType;
  public MediaSet mParentMediaSet;
  public int mPrimingState = 0;
  public String mReverseGeocodedLocation;
  public String mRole;
  public float mRotation;
  public String mScreennailUri;
  public int mThumbnailFocusX;
  public int mThumbnailFocusY;
  public long mThumbnailId;
  public String mThumbnailUri;
  public boolean mTriedRetrievingExifDateTaken = false;
  public String mWeblink;
  
  public String getDisplayMimeType()
  {
    int i;
    if ((this.mDisplayMimeType == null) && (this.mMimeType != null))
    {
      i = this.mMimeType.indexOf('/');
      if ((i == -1) || (i + 1 >= this.mMimeType.length())) {
        break label69;
      }
    }
    label69:
    for (this.mDisplayMimeType = this.mMimeType.substring(i + 1).toUpperCase(); this.mDisplayMimeType == null; this.mDisplayMimeType = this.mMimeType.toUpperCase()) {
      return "";
    }
    return this.mDisplayMimeType;
  }
  
  public int getMediaType()
  {
    if (this.mMediaType == -1) {
      if ((this.mMimeType == null) || (!this.mMimeType.startsWith("video/"))) {
        break label39;
      }
    }
    label39:
    for (int i = 1;; i = 0)
    {
      this.mMediaType = i;
      return this.mMediaType;
    }
  }
  
  public String getReverseGeocodedLocation(ReverseGeocoder paramReverseGeocoder)
  {
    if (this.mReverseGeocodedLocation != null) {
      return this.mReverseGeocodedLocation;
    }
    if ((paramReverseGeocoder == null) || (!isLatLongValid())) {
      return null;
    }
    this.mReverseGeocodedLocation = paramReverseGeocoder.getReverseGeocodedLocation(this.mLatitude, this.mLongitude, 2);
    return this.mReverseGeocodedLocation;
  }
  
  public boolean isDateAddedValid()
  {
    return (this.mDateAddedInSec > 157680000L) && (this.mDateAddedInSec < 2049840000L);
  }
  
  public boolean isDateModifiedValid()
  {
    return (this.mDateModifiedInSec > 157680000L) && (this.mDateModifiedInSec < 2049840000L);
  }
  
  public boolean isDateTakenValid()
  {
    return (this.mDateTakenInMs > 157680000000L) && (this.mDateTakenInMs < 2049840000000L);
  }
  
  public boolean isLatLongValid()
  {
    return (this.mLatitude != 0.0D) || (this.mLongitude != 0.0D);
  }
  
  public boolean isPicassaItem()
  {
    return (this.mParentMediaSet != null) && (this.mParentMediaSet.isPicassaAlbum());
  }
  
  public boolean isWellFormed()
  {
    return true;
  }
  
  public void setDisplayMimeType(String paramString)
  {
    this.mDisplayMimeType = paramString;
  }
  
  public void setMediaType(int paramInt)
  {
    this.mMediaType = paramInt;
  }
  
  public String toString()
  {
    return this.mCaption;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/album/MediaItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */