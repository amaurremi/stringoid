package com.google.android.gms.games.snapshot;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hn;

public final class SnapshotMetadataChange
  implements SafeParcelable
{
  public static final SnapshotMetadataChangeCreator CREATOR = new SnapshotMetadataChangeCreator();
  public static final SnapshotMetadataChange EMPTY_CHANGE = new SnapshotMetadataChange();
  private final String Mm;
  private final Long Ud;
  private final Uri Ue;
  private a Uf;
  private final int xJ;
  
  SnapshotMetadataChange()
  {
    this(4, null, null, null, null);
  }
  
  SnapshotMetadataChange(int paramInt, String paramString, Long paramLong, a parama, Uri paramUri)
  {
    this.xJ = paramInt;
    this.Mm = paramString;
    this.Ud = paramLong;
    this.Uf = parama;
    this.Ue = paramUri;
    if (this.Uf != null) {
      if (this.Ue == null) {
        hn.a(bool1, "Cannot set both a URI and an image");
      }
    }
    while (this.Ue == null) {
      for (;;)
      {
        return;
        bool1 = false;
      }
    }
    if (this.Uf == null) {}
    for (bool1 = bool2;; bool1 = false)
    {
      hn.a(bool1, "Cannot set both a URI and an image");
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
    if (this.Uf == null) {
      return null;
    }
    return this.Uf.eN();
  }
  
  public Uri getCoverImageUri()
  {
    return this.Ue;
  }
  
  public String getDescription()
  {
    return this.Mm;
  }
  
  public Long getPlayedTimeMillis()
  {
    return this.Ud;
  }
  
  public int getVersionCode()
  {
    return this.xJ;
  }
  
  public a iI()
  {
    return this.Uf;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    SnapshotMetadataChangeCreator.a(this, paramParcel, paramInt);
  }
  
  public static final class Builder
  {
    private String Mm;
    private Uri Ue;
    private Long Ug;
    private a Uh;
    
    public SnapshotMetadataChange build()
    {
      return new SnapshotMetadataChange(this.Mm, this.Ug, this.Uh, this.Ue);
    }
    
    public Builder fromMetadata(SnapshotMetadata paramSnapshotMetadata)
    {
      this.Mm = paramSnapshotMetadata.getDescription();
      this.Ug = Long.valueOf(paramSnapshotMetadata.getPlayedTime());
      if (this.Ug.longValue() == -1L) {
        this.Ug = null;
      }
      this.Ue = paramSnapshotMetadata.getCoverImageUri();
      if (this.Ue != null) {
        this.Uh = null;
      }
      return this;
    }
    
    public Builder setCoverImage(Bitmap paramBitmap)
    {
      this.Uh = new a(paramBitmap);
      this.Ue = null;
      return this;
    }
    
    public Builder setDescription(String paramString)
    {
      this.Mm = paramString;
      return this;
    }
    
    public Builder setPlayedTimeMillis(long paramLong)
    {
      this.Ug = Long.valueOf(paramLong);
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/games/snapshot/SnapshotMetadataChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */