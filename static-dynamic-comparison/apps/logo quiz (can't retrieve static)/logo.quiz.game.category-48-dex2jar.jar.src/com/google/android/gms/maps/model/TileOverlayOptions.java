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
  public static final w CREATOR = new w();
  private final int BR;
  private float ajA;
  private boolean ajB = true;
  private i akg;
  private TileProvider akh;
  private boolean aki = true;
  
  public TileOverlayOptions()
  {
    this.BR = 1;
  }
  
  TileOverlayOptions(int paramInt, IBinder paramIBinder, boolean paramBoolean1, float paramFloat, boolean paramBoolean2)
  {
    this.BR = paramInt;
    this.akg = i.a.by(paramIBinder);
    if (this.akg == null) {}
    for (paramIBinder = null;; paramIBinder = new TileProvider()
        {
          private final i akj = TileOverlayOptions.a(TileOverlayOptions.this);
          
          public Tile getTile(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            try
            {
              Tile localTile = this.akj.getTile(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
              return localTile;
            }
            catch (RemoteException localRemoteException) {}
            return null;
          }
        })
    {
      this.akh = paramIBinder;
      this.ajB = paramBoolean1;
      this.ajA = paramFloat;
      this.aki = paramBoolean2;
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public TileOverlayOptions fadeIn(boolean paramBoolean)
  {
    this.aki = paramBoolean;
    return this;
  }
  
  public boolean getFadeIn()
  {
    return this.aki;
  }
  
  public TileProvider getTileProvider()
  {
    return this.akh;
  }
  
  int getVersionCode()
  {
    return this.BR;
  }
  
  public float getZIndex()
  {
    return this.ajA;
  }
  
  public boolean isVisible()
  {
    return this.ajB;
  }
  
  IBinder mP()
  {
    return this.akg.asBinder();
  }
  
  public TileOverlayOptions tileProvider(final TileProvider paramTileProvider)
  {
    this.akh = paramTileProvider;
    if (this.akh == null) {}
    for (paramTileProvider = null;; paramTileProvider = new i.a()
        {
          public Tile getTile(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            return paramTileProvider.getTile(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
          }
        })
    {
      this.akg = paramTileProvider;
      return this;
    }
  }
  
  public TileOverlayOptions visible(boolean paramBoolean)
  {
    this.ajB = paramBoolean;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (v.mK())
    {
      x.a(this, paramParcel, paramInt);
      return;
    }
    w.a(this, paramParcel, paramInt);
  }
  
  public TileOverlayOptions zIndex(float paramFloat)
  {
    this.ajA = paramFloat;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/maps/model/TileOverlayOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */