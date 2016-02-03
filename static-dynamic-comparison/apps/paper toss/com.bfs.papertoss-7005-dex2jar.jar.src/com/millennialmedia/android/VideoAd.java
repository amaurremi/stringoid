package com.millennialmedia.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Externalizable;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
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
  static final long serialVersionUID = 2679125946930815832L;
  ArrayList<VideoLogEvent> activities = new ArrayList();
  ArrayList<VideoImage> buttons = new ArrayList();
  String[] cacheComplete;
  String[] cacheFailed;
  long contentLength;
  long duration;
  String[] endActivity;
  String onCompletionUrl;
  boolean showControls;
  boolean showCountdown;
  String[] startActivity;
  boolean stayInPlayer;
  String[] videoError;
  
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
      boolean[] arrayOfBoolean = new boolean[3];
      paramParcel.readBooleanArray(arrayOfBoolean);
      this.showControls = arrayOfBoolean[0];
      this.stayInPlayer = arrayOfBoolean[1];
      this.showCountdown = arrayOfBoolean[2];
      this.onCompletionUrl = paramParcel.readString();
      this.duration = paramParcel.readLong();
      this.contentLength = paramParcel.readLong();
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
  
  boolean canShow(Context paramContext, MMAdView paramMMAdView, boolean paramBoolean)
  {
    if (paramBoolean) {
      if ((isExpired()) || (!isOnDisk(paramContext)) || (!HandShake.sharedHandShake(paramContext).canDisplayCachedAd(paramMMAdView.adType, this.deferredViewStart))) {}
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
    AdCache.cachedVideoWasRemoved(paramContext, this.acid);
    MMAdViewSDK.Log.v("Ad %s was deleted.", new Object[] { this.id });
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  protected void deserializeFromObj(JSONObject paramJSONObject)
  {
    super.deserializeFromObj(paramJSONObject);
    Object localObject1 = paramJSONObject.optJSONArray("startActivity");
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
    localObject1 = paramJSONObject.optJSONObject("onCompletion");
    if (localObject1 != null)
    {
      this.onCompletionUrl = ((JSONObject)localObject1).optString("url", null);
      this.stayInPlayer = ((JSONObject)localObject1).optBoolean("stayInPlayer");
    }
    this.duration = ((paramJSONObject.optDouble("duration", 0.0D) * 1000.0D));
    this.contentLength = paramJSONObject.optLong("contentLength");
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
    MMAdViewSDK.Log.v("Downloading content to %s", new Object[] { localFile });
    boolean bool2 = AdCache.downloadComponent(this.contentUrl, this.id + "video.dat", localFile);
    boolean bool1 = bool2;
    int i;
    if (bool2)
    {
      i = 0;
      bool1 = bool2;
      if (i < this.buttons.size())
      {
        VideoImage localVideoImage = (VideoImage)this.buttons.get(i);
        bool1 = AdCache.downloadComponent(localVideoImage.imageUrl, this.id + localVideoImage.getImageName(), localFile);
        if (bool1) {
          break label189;
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
      MMAdViewSDK.Log.v("Caching completed successfully? %b", new Object[] { Boolean.valueOf(bool1) });
      return bool1;
      label189:
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
        localObject = paramContext.list(new FilenameFilter()
        {
          public boolean accept(File paramAnonymousFile, String paramAnonymousString)
          {
            return paramAnonymousString.startsWith(VideoAd.this.id);
          }
        });
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
          if (new File(paramContext, this.id + "video.dat").exists()) {
            break label114;
          }
          bool1 = false;
        }
      }
    }
    return bool1;
    label114:
    Object localObject = this.buttons.iterator();
    VideoImage localVideoImage;
    do
    {
      bool1 = bool2;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localVideoImage = (VideoImage)((Iterator)localObject).next();
    } while (new File(paramContext, this.id + localVideoImage.getImageName()).exists());
    return false;
  }
  
  public void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
    super.readExternal(paramObjectInput);
    this.showControls = paramObjectInput.readBoolean();
    this.onCompletionUrl = ((String)paramObjectInput.readObject());
    this.stayInPlayer = paramObjectInput.readBoolean();
    this.showCountdown = paramObjectInput.readBoolean();
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
    this.contentLength = paramObjectInput.readLong();
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
  
  void show(Context paramContext, MMAdView paramMMAdView)
  {
    paramMMAdView = new Intent().setClass(paramContext, VideoPlayer.class);
    if (!(paramContext instanceof MMActivity)) {
      paramMMAdView.setFlags(603979776);
    }
    paramMMAdView.putExtra("cached", true);
    paramMMAdView.putExtra("videoId", this.id);
    paramMMAdView.putExtra("class", "com.millennialmedia.android.VideoPlayerActivity");
    if ((this.storedOnSdCard) && (Environment.getExternalStorageState().equals("mounted"))) {
      paramMMAdView.setData(Uri.parse(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + ".mmsyscache" + File.separator + this.id + "video.dat"));
    }
    for (;;)
    {
      if (!(paramContext instanceof Activity)) {
        paramMMAdView.addFlags(268435456);
      }
      paramContext.startActivity(paramMMAdView);
      return;
      paramMMAdView.setData(Uri.parse(this.id));
    }
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    super.writeExternal(paramObjectOutput);
    paramObjectOutput.writeBoolean(this.showControls);
    paramObjectOutput.writeObject(this.onCompletionUrl);
    paramObjectOutput.writeBoolean(this.stayInPlayer);
    paramObjectOutput.writeBoolean(this.showCountdown);
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
    paramObjectOutput.writeLong(this.contentLength);
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
    paramParcel.writeBooleanArray(new boolean[] { this.showControls, this.stayInPlayer, this.showCountdown });
    paramParcel.writeString(this.onCompletionUrl);
    paramParcel.writeLong(this.duration);
    paramParcel.writeLong(this.contentLength);
    paramParcel.writeList(this.buttons);
    paramParcel.writeList(this.activities);
    paramParcel.writeInt(this.cacheComplete.length);
    paramParcel.writeStringArray(this.cacheComplete);
    paramParcel.writeInt(this.cacheFailed.length);
    paramParcel.writeStringArray(this.cacheFailed);
    paramParcel.writeInt(this.videoError.length);
    paramParcel.writeStringArray(this.videoError);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/millennialmedia/android/VideoAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */