package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.v;
import com.google.android.gms.maps.model.internal.i;
import com.google.android.gms.maps.model.internal.i.a;

public final class TileOverlayOptions
  implements SafeParcelable
{
  public static final TileOverlayOptionsCreator CREATOR = new TileOverlayOptionsCreator();
  private float SN;
  private boolean SO = true;
  private i Tt;
  private TileProvider Tu;
  private boolean Tv = true;
  private final int xH;
  
  public TileOverlayOptions()
  {
    this.xH = 1;
  }
  
  TileOverlayOptions(int paramInt, IBinder paramIBinder, boolean paramBoolean1, float paramFloat, boolean paramBoolean2)
  {
    this.xH = paramInt;
    this.Tt = i.a.aK(paramIBinder);
    if (this.Tt == null) {}
    for (paramIBinder = null;; paramIBinder = new TileProvider()
        {
          private final i Tw = TileOverlayOptions.a(TileOverlayOptions.this);
          
          public Tile getTile(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            try
            {
              Tile localTile = this.Tw.getTile(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
              return localTile;
            }
            catch (RemoteException localRemoteException) {}
            return null;
          }
        })
    {
      this.Tu = paramIBinder;
      this.SO = paramBoolean1;
      this.SN = paramFloat;
      this.Tv = paramBoolean2;
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public TileOverlayOptions fadeIn(boolean paramBoolean)
  {
    this.Tv = paramBoolean;
    return this;
  }
  
  public boolean getFadeIn()
  {
    return this.Tv;
  }
  
  public TileProvider getTileProvider()
  {
    return this.Tu;
  }
  
  int getVersionCode()
  {
    return this.xH;
  }
  
  public float getZIndex()
  {
    return this.SN;
  }
  
  IBinder iG()
  {
    return this.Tt.asBinder();
  }
  
  public boolean isVisible()
  {
    return this.SO;
  }
  
  public TileOverlayOptions tileProvider(final TileProvider paramTileProvider)
  {
    this.Tu = paramTileProvider;
    if (this.Tu == null) {}
    for (paramTileProvider = null;; paramTileProvider = new i.a()
        {
          public Tile getTile(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            return paramTileProvider.getTile(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
          }
        })
    {
      this.Tt = paramTileProvider;
      return this;
    }
  }
  
  public TileOverlayOptions visible(boolean paramBoolean)
  {
    this.SO = paramBoolean;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (v.iB())
    {
      j.a(this, paramParcel, paramInt);
      return;
    }
    TileOverlayOptionsCreator.a(this, paramParcel, paramInt);
  }
  
  public TileOverlayOptions zIndex(float paramFloat)
  {
    this.SN = paramFloat;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/maps/model/TileOverlayOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */