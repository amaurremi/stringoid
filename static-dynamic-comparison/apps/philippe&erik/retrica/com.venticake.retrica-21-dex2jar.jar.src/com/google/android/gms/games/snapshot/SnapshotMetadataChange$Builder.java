package com.google.android.gms.games.snapshot;

import android.graphics.Bitmap;
import android.net.Uri;
import com.google.android.gms.common.data.a;

public final class SnapshotMetadataChange$Builder
{
  private String Mp;
  private Uri Uh;
  private Long Uj;
  private a Uk;
  
  public SnapshotMetadataChange build()
  {
    return new SnapshotMetadataChange(this.Mp, this.Uj, this.Uk, this.Uh);
  }
  
  public Builder fromMetadata(SnapshotMetadata paramSnapshotMetadata)
  {
    this.Mp = paramSnapshotMetadata.getDescription();
    this.Uj = Long.valueOf(paramSnapshotMetadata.getPlayedTime());
    if (this.Uj.longValue() == -1L) {
      this.Uj = null;
    }
    this.Uh = paramSnapshotMetadata.getCoverImageUri();
    if (this.Uh != null) {
      this.Uk = null;
    }
    return this;
  }
  
  public Builder setCoverImage(Bitmap paramBitmap)
  {
    this.Uk = new a(paramBitmap);
    this.Uh = null;
    return this;
  }
  
  public Builder setDescription(String paramString)
  {
    this.Mp = paramString;
    return this;
  }
  
  public Builder setPlayedTimeMillis(long paramLong)
  {
    this.Uj = Long.valueOf(paramLong);
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/snapshot/SnapshotMetadataChange$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */