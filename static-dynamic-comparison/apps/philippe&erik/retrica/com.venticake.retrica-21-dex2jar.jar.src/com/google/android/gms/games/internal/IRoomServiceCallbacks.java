package com.google.android.gms.games.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.ParcelFileDescriptor;

public abstract interface IRoomServiceCallbacks
  extends IInterface
{
  public abstract void a(ParcelFileDescriptor paramParcelFileDescriptor, int paramInt);
  
  public abstract void a(ConnectionInfo paramConnectionInfo);
  
  public abstract void a(String paramString, byte[] paramArrayOfByte, int paramInt);
  
  public abstract void a(String paramString, String[] paramArrayOfString);
  
  public abstract void al(IBinder paramIBinder);
  
  public abstract void b(String paramString, String[] paramArrayOfString);
  
  public abstract void bg(String paramString);
  
  public abstract void bh(String paramString);
  
  public abstract void bi(String paramString);
  
  public abstract void bj(String paramString);
  
  public abstract void bk(String paramString);
  
  public abstract void bl(String paramString);
  
  public abstract void bm(String paramString);
  
  public abstract void c(int paramInt1, int paramInt2, String paramString);
  
  public abstract void c(String paramString, String[] paramArrayOfString);
  
  public abstract void ck(int paramInt);
  
  public abstract void d(String paramString, String[] paramArrayOfString);
  
  public abstract void e(String paramString, String[] paramArrayOfString);
  
  public abstract void f(String paramString, String[] paramArrayOfString);
  
  public abstract void g(String paramString, String[] paramArrayOfString);
  
  public abstract void hJ();
  
  public abstract void hK();
  
  public abstract void onP2PConnected(String paramString);
  
  public abstract void onP2PDisconnected(String paramString);
  
  public abstract void t(String paramString, int paramInt);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/IRoomServiceCallbacks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */