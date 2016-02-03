package com.google.android.gms.games.internal;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.common.data.DataHolder;

public abstract interface IRoomService
  extends IInterface
{
  public abstract void G(boolean paramBoolean);
  
  public abstract void a(IBinder paramIBinder, IRoomServiceCallbacks paramIRoomServiceCallbacks);
  
  public abstract void a(DataHolder paramDataHolder, boolean paramBoolean);
  
  public abstract void a(byte[] paramArrayOfByte, String paramString, int paramInt);
  
  public abstract void a(byte[] paramArrayOfByte, String[] paramArrayOfString);
  
  public abstract void be(String paramString);
  
  public abstract void bf(String paramString);
  
  public abstract void c(String paramString1, String paramString2, String paramString3);
  
  public abstract void hF();
  
  public abstract void hG();
  
  public abstract void hH();
  
  public abstract void hI();
  
  public abstract void r(String paramString, int paramInt);
  
  public abstract void s(String paramString, int paramInt);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/IRoomService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */