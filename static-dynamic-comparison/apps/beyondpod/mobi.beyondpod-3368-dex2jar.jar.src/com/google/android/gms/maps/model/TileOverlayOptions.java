package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.r;
import com.google.android.gms.maps.model.internal.g;
import com.google.android.gms.maps.model.internal.g.a;

public final class TileOverlayOptions
  implements SafeParcelable
{
  public static final TileOverlayOptionsCreator CREATOR = new TileOverlayOptionsCreator();
  private float Cw;
  private boolean Cx = true;
  private g Da;
  private TileProvider Db;
  private boolean Dc = true;
  private final int kg;
  
  public TileOverlayOptions()
  {
    this.kg = 1;
  }
  
  TileOverlayOptions(int paramInt, IBinder paramIBinder, boolean paramBoolean1, float paramFloat, boolean paramBoolean2)
  {
    this.kg = paramInt;
    this.Da = g.a.aq(paramIBinder);
    if (this.Da == null) {}
    for (paramIBinder = null;; paramIBinder = new TileProvider()
        {
          private final g Dd = TileOverlayOptions.a(TileOverlayOptions.this);
          
          public Tile getTile(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            try
            {
              Tile localTile = this.Dd.getTile(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
              return localTile;
            }
            catch (RemoteException localRemoteException) {}
            return null;
          }
        })
    {
      this.Db = paramIBinder;
      this.Cx = paramBoolean1;
      this.Cw = paramFloat;
      this.Dc = paramBoolean2;
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  IBinder eI()
  {
    return this.Da.asBinder();
  }
  
  public TileOverlayOptions fadeIn(boolean paramBoolean)
  {
    this.Dc = paramBoolean;
    return this;
  }
  
  public boolean getFadeIn()
  {
    return this.Dc;
  }
  
  public TileProvider getTileProvider()
  {
    return this.Db;
  }
  
  int getVersionCode()
  {
    return this.kg;
  }
  
  public float getZIndex()
  {
    return this.Cw;
  }
  
  public boolean isVisible()
  {
    return this.Cx;
  }
  
  public TileOverlayOptions tileProvider(final TileProvider paramTileProvider)
  {
    this.Db = paramTileProvider;
    if (this.Db == null) {}
    for (paramTileProvider = null;; paramTileProvider = new g.a()
        {
          public Tile getTile(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            return paramTileProvider.getTile(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
          }
        })
    {
      this.Da = paramTileProvider;
      return this;
    }
  }
  
  public TileOverlayOptions visible(boolean paramBoolean)
  {
    this.Cx = paramBoolean;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (r.eD())
    {
      j.a(this, paramParcel, paramInt);
      return;
    }
    TileOverlayOptionsCreator.a(this, paramParcel, paramInt);
  }
  
  public TileOverlayOptions zIndex(float paramFloat)
  {
    this.Cw = paramFloat;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/maps/model/TileOverlayOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */