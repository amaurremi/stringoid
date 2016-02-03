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
  private float aax;
  private boolean aay = true;
  private i abd;
  private TileProvider abe;
  private boolean abf = true;
  private final int xM;
  
  public TileOverlayOptions()
  {
    this.xM = 1;
  }
  
  TileOverlayOptions(int paramInt, IBinder paramIBinder, boolean paramBoolean1, float paramFloat, boolean paramBoolean2)
  {
    this.xM = paramInt;
    this.abd = i.a.bg(paramIBinder);
    if (this.abd == null) {}
    for (paramIBinder = null;; paramIBinder = new TileProvider()
        {
          private final i b = TileOverlayOptions.a(TileOverlayOptions.this);
          
          public Tile getTile(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            try
            {
              Tile localTile = this.b.getTile(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
              return localTile;
            }
            catch (RemoteException localRemoteException) {}
            return null;
          }
        })
    {
      this.abe = paramIBinder;
      this.aay = paramBoolean1;
      this.aax = paramFloat;
      this.abf = paramBoolean2;
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public TileOverlayOptions fadeIn(boolean paramBoolean)
  {
    this.abf = paramBoolean;
    return this;
  }
  
  public boolean getFadeIn()
  {
    return this.abf;
  }
  
  public TileProvider getTileProvider()
  {
    return this.abe;
  }
  
  int getVersionCode()
  {
    return this.xM;
  }
  
  public float getZIndex()
  {
    return this.aax;
  }
  
  public boolean isVisible()
  {
    return this.aay;
  }
  
  IBinder jQ()
  {
    return this.abd.asBinder();
  }
  
  public TileOverlayOptions tileProvider(final TileProvider paramTileProvider)
  {
    this.abe = paramTileProvider;
    if (this.abe == null) {}
    for (paramTileProvider = null;; paramTileProvider = new i.a()
        {
          public Tile getTile(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            return paramTileProvider.getTile(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
          }
        })
    {
      this.abd = paramTileProvider;
      return this;
    }
  }
  
  public TileOverlayOptions visible(boolean paramBoolean)
  {
    this.aay = paramBoolean;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (v.jL())
    {
      j.a(this, paramParcel, paramInt);
      return;
    }
    TileOverlayOptionsCreator.a(this, paramParcel, paramInt);
  }
  
  public TileOverlayOptions zIndex(float paramFloat)
  {
    this.aax = paramFloat;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/maps/model/TileOverlayOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */