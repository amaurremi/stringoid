package com.millennialmedia.android;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Externalizable;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class VideoAd
  extends CachedAd
  implements Parcelable, Externalizable
{
  public static final Parcelable.Creator<VideoAd> CREATOR = new Parcelable.Creator()
  {
    public VideoAd createFromParcel(Parcel paramAnonymousParcel)
    {
      return new VideoAd(paramAnonymousParcel);
    }
    
    public VideoAd[] newArray(int paramAnonymousInt)
    {
      return new VideoAd[paramAnonymousInt];
    }
  };
  static final String VIDEO_FILE_ID = "video.dat";
  static final long serialVersionUID = 2679125946930815832L;
  ArrayList<VideoLogEvent> activities = new ArrayList();
  ArrayList<VideoImage> buttons = new ArrayList();
  String[] cacheComplete;
  String[] cacheFailed;
  String cacheMissURL;
  DTOCachedVideo cachedVideoDto;
  long closeDelayMillis;
  long contentLength;
  long duration;
  String[] endActivity;
  String endOverlayURL;
  String onCompletionUrl;
  boolean reloadNonEndOverlayOnRestart;
  boolean showControls;
  boolean showCountdown;
  String[] startActivity;
  boolean stayInPlayer;
  boolean usingInternalStorage;
  String[] videoError;
  private String videoFileId;
  String webOverlayURL;
  
  public VideoAd() {}
  
  VideoAd(Parcel paramParcel)
  {
    super(paramParcel);
    try
    {
      this.startActivity = new String[paramParcel.readInt()];
      paramParcel.readStringArray(this.startActivity);
      this.endActivity = new String[paramParcel.readInt()];
      paramParcel.readStringArray(this.endActivity);
      boolean[] arrayOfBoolean = new boolean[5];
      paramParcel.readBooleanArray(arrayOfBoolean);
      this.showControls = arrayOfBoolean[0];
      this.stayInPlayer = arrayOfBoolean[1];
      this.showCountdown = arrayOfBoolean[2];
      this.reloadNonEndOverlayOnRestart = arrayOfBoolean[3];
      this.usingInternalStorage = arrayOfBoolean[4];
      this.onCompletionUrl = paramParcel.readString();
      this.webOverlayURL = paramParcel.readString();
      this.endOverlayURL = paramParcel.readString();
      this.cacheMissURL = paramParcel.readString();
      this.videoFileId = paramParcel.readString();
      this.duration = paramParcel.readLong();
      this.contentLength = paramParcel.readLong();
      this.closeDelayMillis = paramParcel.readLong();
      this.buttons = paramParcel.readArrayList(VideoImage.class.getClassLoader());
      this.activities = paramParcel.readArrayList(VideoLogEvent.class.getClassLoader());
      this.cacheComplete = new String[paramParcel.readInt()];
      paramParcel.readStringArray(this.cacheComplete);
      this.cacheFailed = new String[paramParcel.readInt()];
      paramParcel.readStringArray(this.cacheFailed);
      this.videoError = new String[paramParcel.readInt()];
      paramParcel.readStringArray(this.videoError);
      return;
    }
    catch (Exception paramParcel)
    {
      paramParcel.printStackTrace();
    }
  }
  
  VideoAd(String paramString)
  {
    Object localObject;
    if (paramString != null) {
      localObject = null;
    }
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString != null)
      {
        paramString = paramString.optJSONObject("video");
        if (paramString != null) {
          deserializeFromObj(paramString);
        }
      }
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = (String)localObject;
      }
    }
  }
  
  static boolean downloadVideoFile(Context paramContext, String paramString1, String paramString2)
  {
    File localFile = AdCache.getCacheDirectory(paramContext);
    if ((localFile == null) || (!localFile.isDirectory())) {
      return false;
    }
    MMSDK.Log.v("Downloading (" + paramString2 + "video.dat" + ") content to %s", new Object[] { localFile });
    boolean bool = AdCache.downloadComponent(paramString1, paramString2 + "video.dat", localFile, paramContext);
    MMSDK.Log.v("Caching completed successfully (" + paramString2 + "video.dat" + ")? %b", new Object[] { Boolean.valueOf(bool) });
    return bool;
  }
  
  static Uri getVideoUri(Context paramContext, String paramString)
  {
    return Uri.fromFile(AdCache.getDownloadFile(paramContext, paramString + "video.dat"));
  }
  
  private void handleSharedVideoFile(Context paramContext)
  {
    AdCache.iterateCachedAds(paramContext, 2, new VideoIterator(paramContext, this));
  }
  
  static boolean hasVideoFile(Context paramContext, String paramString)
  {
    return AdCache.hasDownloadFile(paramContext, paramString + "video.dat");
  }
  
  static void playAd(Context paramContext, String paramString, HttpRedirection.RedirectionListenerImpl paramRedirectionListenerImpl)
  {
    if (paramString != null)
    {
      VideoAd localVideoAd = (VideoAd)AdCache.load(paramContext, paramString);
      if ((localVideoAd != null) && (localVideoAd.canShow(paramContext, null, false)))
      {
        paramRedirectionListenerImpl.updateLastVideoViewedTime();
        MMSDK.Log.v("mmvideo: attempting to play video %s", new Object[] { paramString });
        localVideoAd.show(paramContext, paramRedirectionListenerImpl.creatorAdImplInternalId);
        paramRedirectionListenerImpl.startingVideo();
      }
    }
    else
    {
      return;
    }
    MMSDK.Log.v("mmvideo: Ad %s cannot be shown at this time.", new Object[] { paramString });
  }
  
  boolean canShow(Context paramContext, MMAdImpl paramMMAdImpl, boolean paramBoolean)
  {
    if (paramBoolean) {
      if ((isExpired()) || (!isOnDisk(paramContext)) || (!HandShake.sharedHandShake(paramContext).canDisplayCachedAd(paramMMAdImpl.adType, this.deferredViewStart))) {}
    }
    while ((!isExpired()) && (isOnDisk(paramContext)))
    {
      return true;
      return false;
    }
    return false;
  }
  
  void delete(Context paramContext)
  {
    super.delete(paramContext);
    handleSharedVideoFile(paramContext);
    AdCache.cachedVideoWasRemoved(paramContext, this.acid);
    MMSDK.Log.v("Ad %s was deleted.", new Object[] { getId() });
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  protected void deserializeFromObj(JSONObject paramJSONObject)
  {
    super.deserializeFromObj(paramJSONObject);
    Object localObject1 = paramJSONObject.optJSONArray("startActivity");
    this.webOverlayURL = paramJSONObject.optString("overlayURL", null);
    this.endOverlayURL = paramJSONObject.optString("endURL", null);
    this.cacheMissURL = paramJSONObject.optString("cacheMissURL", null);
    this.videoFileId = paramJSONObject.optString("videoFileId", null);
    int i;
    if (localObject1 != null)
    {
      this.startActivity = new String[((JSONArray)localObject1).length()];
      i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        this.startActivity[i] = ((JSONArray)localObject1).optString(i);
        i += 1;
      }
    }
    this.startActivity = new String[0];
    localObject1 = paramJSONObject.optJSONArray("endActivity");
    if (localObject1 != null)
    {
      this.endActivity = new String[((JSONArray)localObject1).length()];
      i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        this.endActivity[i] = ((JSONArray)localObject1).optString(i);
        i += 1;
      }
    }
    this.endActivity = new String[0];
    localObject1 = paramJSONObject.optJSONArray("cacheComplete");
    if (localObject1 != null)
    {
      this.cacheComplete = new String[((JSONArray)localObject1).length()];
      i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        this.cacheComplete[i] = ((JSONArray)localObject1).optString(i);
        i += 1;
      }
    }
    this.cacheComplete = new String[0];
    localObject1 = paramJSONObject.optJSONArray("cacheFailed");
    if (localObject1 != null)
    {
      this.cacheFailed = new String[((JSONArray)localObject1).length()];
      i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        this.cacheFailed[i] = ((JSONArray)localObject1).optString(i);
        i += 1;
      }
    }
    this.cacheFailed = new String[0];
    localObject1 = paramJSONObject.optJSONArray("videoError");
    if (localObject1 != null)
    {
      this.videoError = new String[((JSONArray)localObject1).length()];
      i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        this.videoError[i] = ((JSONArray)localObject1).optString(i);
        i += 1;
      }
    }
    this.videoError = new String[0];
    this.showControls = paramJSONObject.optBoolean("showVideoPlayerControls");
    this.showCountdown = paramJSONObject.optBoolean("showCountdownHUD");
    this.reloadNonEndOverlayOnRestart = paramJSONObject.optBoolean("reloadOverlayOnRestart");
    localObject1 = paramJSONObject.optJSONObject("onCompletion");
    if (localObject1 != null)
    {
      this.onCompletionUrl = ((JSONObject)localObject1).optString("url", null);
      this.stayInPlayer = ((JSONObject)localObject1).optBoolean("stayInPlayer");
    }
    this.duration = ((paramJSONObject.optDouble("duration", 0.0D) * 1000.0D));
    this.contentLength = paramJSONObject.optLong("contentLength");
    this.closeDelayMillis = paramJSONObject.optLong("closeAfterDelay");
    localObject1 = paramJSONObject.optJSONArray("buttons");
    if (localObject1 != null)
    {
      i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        Object localObject2 = ((JSONArray)localObject1).optJSONObject(i);
        if (localObject2 != null)
        {
          localObject2 = new VideoImage((JSONObject)localObject2);
          this.buttons.add(localObject2);
        }
        i += 1;
      }
    }
    paramJSONObject = paramJSONObject.optJSONArray("log");
    if (paramJSONObject != null)
    {
      i = 0;
      while (i < paramJSONObject.length())
      {
        localObject1 = paramJSONObject.optJSONObject(i);
        if (localObject1 != null)
        {
          localObject1 = new VideoLogEvent((JSONObject)localObject1);
          this.activities.add(localObject1);
        }
        i += 1;
      }
    }
  }
  
  boolean download(Context paramContext)
  {
    File localFile = AdCache.getCacheDirectory(paramContext);
    if ((localFile == null) || (!localFile.isDirectory())) {
      return false;
    }
    this.usingInternalStorage = AdCache.isInternalDir(paramContext, localFile);
    MMSDK.Log.v("Downloading content to %s", new Object[] { localFile });
    boolean bool2 = AdCache.downloadComponent(this.contentUrl, this.videoFileId + "video.dat", localFile, paramContext);
    boolean bool1 = bool2;
    int i;
    if (bool2)
    {
      i = 0;
      bool1 = bool2;
      if (i < this.buttons.size())
      {
        VideoImage localVideoImage = (VideoImage)this.buttons.get(i);
        bool1 = AdCache.downloadComponent(localVideoImage.imageUrl, getId() + localVideoImage.getImageName(), localFile, paramContext);
        if (bool1) {
          break label200;
        }
      }
    }
    if (!bool1)
    {
      if (this.downloadAllOrNothing) {
        delete(paramContext);
      }
      HttpGetRequest.log(this.cacheFailed);
    }
    for (;;)
    {
      MMSDK.Log.v("Caching completed successfully? %b", new Object[] { Boolean.valueOf(bool1) });
      return bool1;
      label200:
      i += 1;
      break;
      if (bool1)
      {
        if ((this.acid != null) && (this.acid.length() > 0)) {
          AdCache.cachedVideoWasAdded(paramContext, this.acid);
        }
        HttpGetRequest.log(this.cacheComplete);
      }
    }
  }
  
  int getType()
  {
    return 1;
  }
  
  String getTypeString()
  {
    return "Video";
  }
  
  Intent getVideoExtrasIntent(Context paramContext, long paramLong)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("videoId", getId());
    if (paramLong != -4L) {
      localIntent.putExtra("internalId", paramLong);
    }
    localIntent.setData(Uri.parse(AdCache.getCacheDirectory(paramContext).getAbsolutePath() + File.separator + this.videoFileId + "video.dat"));
    return localIntent;
  }
  
  boolean hasEndCard()
  {
    Iterator localIterator = this.buttons.iterator();
    while (localIterator.hasNext()) {
      if (((VideoImage)localIterator.next()).isLeaveBehind) {
        return true;
      }
    }
    return false;
  }
  
  boolean isOnDisk(Context paramContext)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    paramContext = AdCache.getCacheDirectory(paramContext);
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      bool1 = bool2;
      if (paramContext.exists())
      {
        localObject = paramContext.list(new VideoFilenameFilter(this));
        bool2 = bool3;
        if (localObject != null)
        {
          bool2 = bool3;
          if (localObject.length >= this.buttons.size() + 1) {
            bool2 = true;
          }
        }
        bool1 = bool2;
        if (bool2)
        {
          if (new File(paramContext, this.videoFileId + "video.dat").exists()) {
            break label113;
          }
          bool1 = false;
        }
      }
    }
    return bool1;
    label113:
    Object localObject = this.buttons.iterator();
    VideoImage localVideoImage;
    do
    {
      bool1 = bool2;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localVideoImage = (VideoImage)((Iterator)localObject).next();
    } while (new File(paramContext, getId() + localVideoImage.getImageName()).exists());
    return false;
  }
  
  void logBeginEvent()
  {
    if (this.startActivity != null)
    {
      MMSDK.Log.d("Cached video begin event logged");
      int i = 0;
      while (i < this.startActivity.length)
      {
        MMSDK.Event.logEvent(this.startActivity[i]);
        i += 1;
      }
    }
  }
  
  void logEndEvent()
  {
    if (this.endActivity != null)
    {
      MMSDK.Log.d("Cached video end event logged");
      int i = 0;
      while (i < this.endActivity.length)
      {
        MMSDK.Event.logEvent(this.endActivity[i]);
        i += 1;
      }
    }
  }
  
  public void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
    super.readExternal(paramObjectInput);
    this.showControls = paramObjectInput.readBoolean();
    this.onCompletionUrl = ((String)paramObjectInput.readObject());
    this.webOverlayURL = ((String)paramObjectInput.readObject());
    this.endOverlayURL = ((String)paramObjectInput.readObject());
    this.cacheMissURL = ((String)paramObjectInput.readObject());
    this.videoFileId = ((String)paramObjectInput.readObject());
    this.stayInPlayer = paramObjectInput.readBoolean();
    this.showCountdown = paramObjectInput.readBoolean();
    this.reloadNonEndOverlayOnRestart = paramObjectInput.readBoolean();
    int j = paramObjectInput.readInt();
    this.startActivity = new String[j];
    int i = 0;
    while (i < j)
    {
      this.startActivity[i] = ((String)paramObjectInput.readObject());
      i += 1;
    }
    j = paramObjectInput.readInt();
    this.endActivity = new String[j];
    i = 0;
    while (i < j)
    {
      this.endActivity[i] = ((String)paramObjectInput.readObject());
      i += 1;
    }
    this.duration = paramObjectInput.readLong();
    this.usingInternalStorage = paramObjectInput.readBoolean();
    this.contentLength = paramObjectInput.readLong();
    this.closeDelayMillis = paramObjectInput.readLong();
    j = paramObjectInput.readInt();
    this.cacheComplete = new String[j];
    i = 0;
    while (i < j)
    {
      this.cacheComplete[i] = ((String)paramObjectInput.readObject());
      i += 1;
    }
    j = paramObjectInput.readInt();
    this.cacheFailed = new String[j];
    i = 0;
    while (i < j)
    {
      this.cacheFailed[i] = ((String)paramObjectInput.readObject());
      i += 1;
    }
    j = paramObjectInput.readInt();
    this.videoError = new String[j];
    i = 0;
    while (i < j)
    {
      this.videoError[i] = ((String)paramObjectInput.readObject());
      i += 1;
    }
    this.buttons.clear();
    j = paramObjectInput.readInt();
    i = 0;
    Object localObject;
    while (i < j)
    {
      localObject = (VideoImage)paramObjectInput.readObject();
      this.buttons.add(localObject);
      i += 1;
    }
    this.activities.clear();
    j = paramObjectInput.readInt();
    i = 0;
    while (i < j)
    {
      localObject = (VideoLogEvent)paramObjectInput.readObject();
      this.activities.add(localObject);
      i += 1;
    }
  }
  
  boolean saveAssets(Context paramContext)
  {
    return true;
  }
  
  void setDtoCachedVideo(DTOCachedVideo paramDTOCachedVideo)
  {
    this.cachedVideoDto = paramDTOCachedVideo;
  }
  
  void show(Context paramContext, long paramLong)
  {
    Utils.IntentUtils.startCachedVideoPlayerActivity(paramContext, getVideoExtrasIntent(paramContext, paramLong));
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    super.writeExternal(paramObjectOutput);
    paramObjectOutput.writeBoolean(this.showControls);
    paramObjectOutput.writeObject(this.onCompletionUrl);
    paramObjectOutput.writeObject(this.webOverlayURL);
    paramObjectOutput.writeObject(this.endOverlayURL);
    paramObjectOutput.writeObject(this.cacheMissURL);
    paramObjectOutput.writeObject(this.videoFileId);
    paramObjectOutput.writeBoolean(this.stayInPlayer);
    paramObjectOutput.writeBoolean(this.showCountdown);
    paramObjectOutput.writeBoolean(this.reloadNonEndOverlayOnRestart);
    paramObjectOutput.writeInt(this.startActivity.length);
    Object localObject = this.startActivity;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      paramObjectOutput.writeObject(localObject[i]);
      i += 1;
    }
    paramObjectOutput.writeInt(this.endActivity.length);
    localObject = this.endActivity;
    j = localObject.length;
    i = 0;
    while (i < j)
    {
      paramObjectOutput.writeObject(localObject[i]);
      i += 1;
    }
    paramObjectOutput.writeLong(this.duration);
    paramObjectOutput.writeBoolean(this.usingInternalStorage);
    paramObjectOutput.writeLong(this.contentLength);
    paramObjectOutput.writeLong(this.closeDelayMillis);
    paramObjectOutput.writeInt(this.cacheComplete.length);
    localObject = this.cacheComplete;
    j = localObject.length;
    i = 0;
    while (i < j)
    {
      paramObjectOutput.writeObject(localObject[i]);
      i += 1;
    }
    paramObjectOutput.writeInt(this.cacheFailed.length);
    localObject = this.cacheFailed;
    j = localObject.length;
    i = 0;
    while (i < j)
    {
      paramObjectOutput.writeObject(localObject[i]);
      i += 1;
    }
    paramObjectOutput.writeInt(this.videoError.length);
    localObject = this.videoError;
    j = localObject.length;
    i = 0;
    while (i < j)
    {
      paramObjectOutput.writeObject(localObject[i]);
      i += 1;
    }
    paramObjectOutput.writeInt(this.buttons.size());
    localObject = this.buttons.iterator();
    while (((Iterator)localObject).hasNext()) {
      paramObjectOutput.writeObject((VideoImage)((Iterator)localObject).next());
    }
    paramObjectOutput.writeInt(this.activities.size());
    localObject = this.activities.iterator();
    while (((Iterator)localObject).hasNext()) {
      paramObjectOutput.writeObject((VideoLogEvent)((Iterator)localObject).next());
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.startActivity.length);
    paramParcel.writeStringArray(this.startActivity);
    paramParcel.writeInt(this.endActivity.length);
    paramParcel.writeStringArray(this.endActivity);
    paramParcel.writeBooleanArray(new boolean[] { this.showControls, this.stayInPlayer, this.showCountdown, this.reloadNonEndOverlayOnRestart, this.usingInternalStorage });
    paramParcel.writeString(this.onCompletionUrl);
    paramParcel.writeString(this.endOverlayURL);
    paramParcel.writeString(this.webOverlayURL);
    paramParcel.writeString(this.cacheMissURL);
    paramParcel.writeString(this.videoFileId);
    paramParcel.writeLong(this.duration);
    paramParcel.writeLong(this.contentLength);
    paramParcel.writeLong(this.closeDelayMillis);
    paramParcel.writeList(this.buttons);
    paramParcel.writeList(this.activities);
    paramParcel.writeInt(this.cacheComplete.length);
    paramParcel.writeStringArray(this.cacheComplete);
    paramParcel.writeInt(this.cacheFailed.length);
    paramParcel.writeStringArray(this.cacheFailed);
    paramParcel.writeInt(this.videoError.length);
    paramParcel.writeStringArray(this.videoError);
  }
  
  private static class VideoFilenameFilter
    implements FilenameFilter
  {
    private WeakReference<VideoAd> videoAdRef;
    
    public VideoFilenameFilter(VideoAd paramVideoAd)
    {
      this.videoAdRef = new WeakReference(paramVideoAd);
    }
    
    public boolean accept(File paramFile, String paramString)
    {
      paramFile = (VideoAd)this.videoAdRef.get();
      if (paramFile != null)
      {
        paramFile = paramFile.getId();
        if (paramFile != null) {}
      }
      else
      {
        return false;
      }
      return paramString.startsWith(paramFile);
    }
  }
  
  private static class VideoIterator
    extends AdCache.Iterator
  {
    private WeakReference<Context> contextRef;
    boolean hasSharedVideoFile = false;
    private WeakReference<VideoAd> videoAdRef;
    
    public VideoIterator(Context paramContext, VideoAd paramVideoAd)
    {
      this.videoAdRef = new WeakReference(paramVideoAd);
      this.contextRef = new WeakReference(paramContext);
    }
    
    boolean callback(CachedAd paramCachedAd)
    {
      if ((paramCachedAd != null) && ((paramCachedAd instanceof VideoAd)))
      {
        VideoAd localVideoAd1 = (VideoAd)paramCachedAd;
        VideoAd localVideoAd2 = (VideoAd)this.videoAdRef.get();
        if ((localVideoAd2 != null) && (localVideoAd1.videoFileId.equals(localVideoAd2.videoFileId))) {
          this.hasSharedVideoFile = true;
        }
      }
      return super.callback(paramCachedAd);
    }
    
    void deleteVideoFile(Context paramContext)
    {
      VideoAd localVideoAd = (VideoAd)this.videoAdRef.get();
      if ((localVideoAd != null) && (AdCache.deleteFile(paramContext, localVideoAd.videoFileId + "video.dat"))) {
        MMSDK.Log.v("VideoAd video file %s was deleted.", new Object[] { localVideoAd.videoFileId });
      }
    }
    
    void done()
    {
      if (!this.hasSharedVideoFile)
      {
        Context localContext = (Context)this.contextRef.get();
        if (localContext != null) {
          deleteVideoFile(localContext);
        }
      }
      super.done();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/millennialmedia/android/VideoAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */