package com.google.android.gms.games.internal;

import android.net.LocalSocket;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.games.multiplayer.realtime.RealTimeSocket;
import java.io.InputStream;
import java.io.OutputStream;

final class dq
  implements RealTimeSocket
{
  private final LocalSocket a;
  private final String b;
  private ParcelFileDescriptor c;
  
  dq(LocalSocket paramLocalSocket, String paramString)
  {
    this.a = paramLocalSocket;
    this.b = paramString;
  }
  
  public void close()
  {
    this.a.close();
  }
  
  public InputStream getInputStream()
  {
    return this.a.getInputStream();
  }
  
  public OutputStream getOutputStream()
  {
    return this.a.getOutputStream();
  }
  
  public ParcelFileDescriptor getParcelFileDescriptor()
  {
    if ((this.c == null) && (!isClosed()))
    {
      Parcel localParcel = Parcel.obtain();
      localParcel.writeFileDescriptor(this.a.getFileDescriptor());
      localParcel.setDataPosition(0);
      this.c = localParcel.readFileDescriptor();
    }
    return this.c;
  }
  
  public boolean isClosed()
  {
    return (!this.a.isConnected()) && (!this.a.isBound());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/dq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */