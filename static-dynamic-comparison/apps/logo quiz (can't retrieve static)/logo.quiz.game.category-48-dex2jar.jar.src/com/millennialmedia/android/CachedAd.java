package com.millennialmedia.android;

import android.content.Context;
import android.os.Parcel;
import java.io.Externalizable;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

abstract class CachedAd
  implements Externalizable
{
  static final int INTERSTITIAL = 2;
  static final int NATIVE = 3;
  static final int VIDEO = 1;
  static final long serialVersionUID = 316862728709355974L;
  String acid;
  String contentUrl;
  long deferredViewStart;
  boolean downloadAllOrNothing = false;
  int downloadPriority;
  Date expiration;
  private String id;
  
  CachedAd()
  {
    this.deferredViewStart = System.currentTimeMillis();
  }
  
  protected CachedAd(Parcel paramParcel)
  {
    try
    {
      this.id = paramParcel.readString();
      this.acid = paramParcel.readString();
      this.expiration = ((Date)paramParcel.readSerializable());
      this.deferredViewStart = paramParcel.readLong();
      boolean[] arrayOfBoolean = new boolean[1];
      paramParcel.readBooleanArray(arrayOfBoolean);
      this.downloadAllOrNothing = arrayOfBoolean[0];
      this.contentUrl = paramParcel.readString();
      this.downloadPriority = paramParcel.readInt();
      return;
    }
    catch (Exception paramParcel)
    {
      paramParcel.printStackTrace();
    }
  }
  
  static CachedAd parseJSON(String paramString)
  {
    VideoAd localVideoAd = null;
    if (MMSDK.logLevel >= 5)
    {
      MMSDK.Log.v("Received cached ad.");
      int n = paramString.length();
      if (n <= 1000) {
        break label112;
      }
      int i = 999;
      int j = 0;
      int k;
      do
      {
        m = i;
        k = j;
        if (i >= n) {
          break;
        }
        MMSDK.Log.v(paramString.substring(j, i));
        k = i;
        m = i + 1000;
        i = m;
        j = k;
      } while (m <= n);
      int m = n - 1;
      MMSDK.Log.v(paramString.substring(k, m));
    }
    for (;;)
    {
      if (paramString.length() > 0) {
        localVideoAd = new VideoAd(paramString);
      }
      return localVideoAd;
      label112:
      MMSDK.Log.v(paramString);
    }
  }
  
  abstract boolean canShow(Context paramContext, MMAdImpl paramMMAdImpl, boolean paramBoolean);
  
  void delete(Context paramContext)
  {
    paramContext = AdCache.getCacheDirectory(paramContext);
    if ((paramContext != null) && (paramContext.isDirectory())) {
      try
      {
        paramContext = paramContext.listFiles(new FileFilter()
        {
          public boolean accept(File paramAnonymousFile)
          {
            return (paramAnonymousFile.isFile()) && (paramAnonymousFile.getName().startsWith(CachedAd.this.id));
          }
        });
        MMSDK.Log.v("Deleting %d files for %s.", new Object[] { Integer.valueOf(paramContext.length), this.id });
        int i = 0;
        while (i < paramContext.length)
        {
          paramContext[i].delete();
          i += 1;
        }
        return;
      }
      catch (Exception paramContext)
      {
        MMSDK.Log.v(paramContext);
      }
    }
  }
  
  protected void deserializeFromObj(JSONObject paramJSONObject)
  {
    this.id = paramJSONObject.optString("id", null);
    this.acid = paramJSONObject.optString("vid", null);
    this.contentUrl = paramJSONObject.optString("content-url", null);
    paramJSONObject = paramJSONObject.optString("expiration", null);
    SimpleDateFormat localSimpleDateFormat;
    if (paramJSONObject != null) {
      localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ZZZZ");
    }
    try
    {
      this.expiration = localSimpleDateFormat.parse(paramJSONObject);
      return;
    }
    catch (ParseException paramJSONObject)
    {
      MMSDK.Log.e(paramJSONObject);
    }
  }
  
  abstract boolean download(Context paramContext);
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof CachedAd)) {
      return false;
    }
    paramObject = (CachedAd)paramObject;
    return this.id.equals(((CachedAd)paramObject).id);
  }
  
  String getId()
  {
    return this.id;
  }
  
  abstract int getType();
  
  abstract String getTypeString();
  
  boolean isExpired()
  {
    return (this.expiration != null) && (this.expiration.getTime() <= System.currentTimeMillis());
  }
  
  abstract boolean isOnDisk(Context paramContext);
  
  boolean isValid()
  {
    return (this.id != null) && (this.id.length() > 0) && (this.contentUrl != null) && (this.contentUrl.length() > 0);
  }
  
  public void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
    this.id = ((String)paramObjectInput.readObject());
    this.acid = ((String)paramObjectInput.readObject());
    this.expiration = ((Date)paramObjectInput.readObject());
    this.deferredViewStart = paramObjectInput.readLong();
    this.contentUrl = ((String)paramObjectInput.readObject());
  }
  
  abstract boolean saveAssets(Context paramContext);
  
  void setId(String paramString)
  {
    this.id = paramString;
  }
  
  abstract void show(Context paramContext, long paramLong);
  
  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    paramObjectOutput.writeObject(this.id);
    paramObjectOutput.writeObject(this.acid);
    paramObjectOutput.writeObject(this.expiration);
    paramObjectOutput.writeLong(this.deferredViewStart);
    paramObjectOutput.writeObject(this.contentUrl);
  }
  
  protected void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.id);
    paramParcel.writeString(this.acid);
    paramParcel.writeSerializable(this.expiration);
    paramParcel.writeLong(this.deferredViewStart);
    paramParcel.writeBooleanArray(new boolean[] { this.downloadAllOrNothing });
    paramParcel.writeString(this.contentUrl);
    paramParcel.writeInt(this.downloadPriority);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/millennialmedia/android/CachedAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */