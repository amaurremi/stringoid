package com.google.android.gms.games.snapshot;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.a;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class SnapshotMetadataChange
  implements SafeParcelable
{
  public static final SnapshotMetadataChangeCreator CREATOR = new SnapshotMetadataChangeCreator();
  public static final SnapshotMetadataChange EMPTY_CHANGE = new SnapshotMetadataChange();
  private final int BR;
  private final String Tg;
  private final Long acY;
  private final Uri acZ;
  private a ada;
  
  SnapshotMetadataChange()
  {
    this(4, null, null, null, null);
  }
  
  SnapshotMetadataChange(int paramInt, String paramString, Long paramLong, a parama, Uri paramUri)
  {
    this.BR = paramInt;
    this.Tg = paramString;
    this.acY = paramLong;
    this.ada = parama;
    this.acZ = paramUri;
    if (this.ada != null) {
      if (this.acZ == null) {
        n.a(bool1, "Cannot set both a URI and an image");
      }
    }
    while (this.acZ == null) {
      for (;;)
      {
        return;
        bool1 = false;
      }
    }
    if (this.ada == null) {}
    for (bool1 = bool2;; bool1 = false)
    {
      n.a(bool1, "Cannot set both a URI and an image");
      return;
    }
  }
  
  SnapshotMetadataChange(String paramString, Long paramLong, a parama, Uri paramUri)
  {
    this(4, paramString, paramLong, parama, paramUri);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Bitmap getCoverImage()
  {
    if (this.ada == null) {
      return null;
    }
    return this.ada.gx();
  }
  
  public Uri getCoverImageUri()
  {
    return this.acZ;
  }
  
  public String getDescription()
  {
    return this.Tg;
  }
  
  public Long getPlayedTimeMillis()
  {
    return this.acY;
  }
  
  public int getVersionCode()
  {
    return this.BR;
  }
  
  public a lK()
  {
    return this.ada;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    SnapshotMetadataChangeCreator.a(this, paramParcel, paramInt);
  }
  
  public static final class Builder
  {
    private String Tg;
    private Uri acZ;
    private Long adb;
    private a adc;
    
    public SnapshotMetadataChange build()
    {
      return new SnapshotMetadataChange(this.Tg, this.adb, this.adc, this.acZ);
    }
    
    public Builder fromMetadata(SnapshotMetadata paramSnapshotMetadata)
    {
      this.Tg = paramSnapshotMetadata.getDescription();
      this.adb = Long.valueOf(paramSnapshotMetadata.getPlayedTime());
      if (this.adb.longValue() == -1L) {
        this.adb = null;
      }
      this.acZ = paramSnapshotMetadata.getCoverImageUri();
      if (this.acZ != null) {
        this.adc = null;
      }
      return this;
    }
    
    public Builder setCoverImage(Bitmap paramBitmap)
    {
      this.adc = new a(paramBitmap);
      this.acZ = null;
      return this;
    }
    
    public Builder setDescription(String paramString)
    {
      this.Tg = paramString;
      return this;
    }
    
    public Builder setPlayedTimeMillis(long paramLong)
    {
      this.adb = Long.valueOf(paramLong);
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/games/snapshot/SnapshotMetadataChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */