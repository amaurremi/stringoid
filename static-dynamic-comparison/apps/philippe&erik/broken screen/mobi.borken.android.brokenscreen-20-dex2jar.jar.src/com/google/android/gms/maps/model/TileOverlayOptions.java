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
  private float aau;
  private boolean aav = true;
  private i aba;
  private TileProvider abb;
  private boolean abc = true;
  private final int xJ;
  
  public TileOverlayOptions()
  {
    this.xJ = 1;
  }
  
  TileOverlayOptions(int paramInt, IBinder paramIBinder, boolean paramBoolean1, float paramFloat, boolean paramBoolean2)
  {
    this.xJ = paramInt;
    this.aba = i.a.bg(paramIBinder);
    if (this.aba == null) {}
    for (paramIBinder = null;; paramIBinder = new TileProvider()
        {
          private final i abd = TileOverlayOptions.a(TileOverlayOptions.this);
          
          public Tile getTile(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            try
            {
              Tile localTile = this.abd.getTile(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
              return localTile;
            }
            catch (RemoteException localRemoteException) {}
            return null;
          }
        })
    {
      this.abb = paramIBinder;
      this.aav = paramBoolean1;
      this.aau = paramFloat;
      this.abc = paramBoolean2;
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public TileOverlayOptions fadeIn(boolean paramBoolean)
  {
    this.abc = paramBoolean;
    return this;
  }
  
  public boolean getFadeIn()
  {
    return this.abc;
  }
  
  public TileProvider getTileProvider()
  {
    return this.abb;
  }
  
  int getVersionCode()
  {
    return this.xJ;
  }
  
  public float getZIndex()
  {
    return this.aau;
  }
  
  public boolean isVisible()
  {
    return this.aav;
  }
  
  IBinder jL()
  {
    return this.aba.asBinder();
  }
  
  public TileOverlayOptions tileProvider(final TileProvider paramTileProvider)
  {
    this.abb = paramTileProvider;
    if (this.abb == null) {}
    for (paramTileProvider = null;; paramTileProvider = new i.a()
        {
          public Tile getTile(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            return paramTileProvider.getTile(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
          }
        })
    {
      this.aba = paramTileProvider;
      return this;
    }
  }
  
  public TileOverlayOptions visible(boolean paramBoolean)
  {
    this.aav = paramBoolean;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (v.jG())
    {
      j.a(this, paramParcel, paramInt);
      return;
    }
    TileOverlayOptionsCreator.a(this, paramParcel, paramInt);
  }
  
  public TileOverlayOptions zIndex(float paramFloat)
  {
    this.aau = paramFloat;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/maps/model/TileOverlayOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */