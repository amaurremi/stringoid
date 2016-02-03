package com.google.android.gms.games.internal;

import android.net.LocalSocket;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.games.multiplayer.realtime.RealTimeSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

final class RealTimeSocketImpl
  implements RealTimeSocket
{
  private ParcelFileDescriptor Fg;
  private final String On;
  private final LocalSocket Pa;
  
  RealTimeSocketImpl(LocalSocket paramLocalSocket, String paramString)
  {
    this.Pa = paramLocalSocket;
    this.On = paramString;
  }
  
  public void close()
    throws IOException
  {
    this.Pa.close();
  }
  
  public InputStream getInputStream()
    throws IOException
  {
    return this.Pa.getInputStream();
  }
  
  public OutputStream getOutputStream()
    throws IOException
  {
    return this.Pa.getOutputStream();
  }
  
  public ParcelFileDescriptor getParcelFileDescriptor()
    throws IOException
  {
    if ((this.Fg == null) && (!isClosed()))
    {
      Parcel localParcel = Parcel.obtain();
      localParcel.writeFileDescriptor(this.Pa.getFileDescriptor());
      localParcel.setDataPosition(0);
      this.Fg = localParcel.readFileDescriptor();
    }
    return this.Fg;
  }
  
  public boolean isClosed()
  {
    return (!this.Pa.isConnected()) && (!this.Pa.isBound());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/games/internal/RealTimeSocketImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */