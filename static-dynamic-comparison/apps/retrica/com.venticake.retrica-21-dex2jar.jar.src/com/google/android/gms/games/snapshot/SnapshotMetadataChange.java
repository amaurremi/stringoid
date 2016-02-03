package com.google.android.gms.games.snapshot;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hm;

public final class SnapshotMetadataChange
  implements SafeParcelable
{
  public static final SnapshotMetadataChangeCreator CREATOR = new SnapshotMetadataChangeCreator();
  public static final SnapshotMetadataChange EMPTY_CHANGE = new SnapshotMetadataChange();
  private final String Mp;
  private final Long Ug;
  private final Uri Uh;
  private a Ui;
  private final int xM;
  
  SnapshotMetadataChange()
  {
    this(4, null, null, null, null);
  }
  
  SnapshotMetadataChange(int paramInt, String paramString, Long paramLong, a parama, Uri paramUri)
  {
    this.xM = paramInt;
    this.Mp = paramString;
    this.Ug = paramLong;
    this.Ui = parama;
    this.Uh = paramUri;
    if (this.Ui != null) {
      if (this.Uh == null) {
        hm.a(bool1, "Cannot set both a URI and an image");
      }
    }
    while (this.Uh == null) {
      for (;;)
      {
        return;
        bool1 = false;
      }
    }
    if (this.Ui == null) {}
    for (bool1 = bool2;; bool1 = false)
    {
      hm.a(bool1, "Cannot set both a URI and an image");
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
    if (this.Ui == null) {
      return null;
    }
    return this.Ui.eS();
  }
  
  public Uri getCoverImageUri()
  {
    return this.Uh;
  }
  
  public String getDescription()
  {
    return this.Mp;
  }
  
  public Long getPlayedTimeMillis()
  {
    return this.Ug;
  }
  
  public int getVersionCode()
  {
    return this.xM;
  }
  
  public a iN()
  {
    return this.Ui;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    SnapshotMetadataChangeCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/snapshot/SnapshotMetadataChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */