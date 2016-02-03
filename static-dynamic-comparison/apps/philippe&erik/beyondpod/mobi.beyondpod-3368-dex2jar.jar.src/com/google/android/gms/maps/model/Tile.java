package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.r;

public final class Tile
  implements SafeParcelable
{
  public static final TileCreator CREATOR = new TileCreator();
  public final byte[] data;
  public final int height;
  private final int kg;
  public final int width;
  
  Tile(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    this.kg = paramInt1;
    this.width = paramInt2;
    this.height = paramInt3;
    this.data = paramArrayOfByte;
  }
  
  public Tile(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    this(1, paramInt1, paramInt2, paramArrayOfByte);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  int getVersionCode()
  {
    return this.kg;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (r.eD())
    {
      i.a(this, paramParcel, paramInt);
      return;
    }
    TileCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/maps/model/Tile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */