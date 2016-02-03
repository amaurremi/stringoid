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
  private ParcelFileDescriptor Kx;
  private final LocalSocket XT;
  private final String Xg;
  
  RealTimeSocketImpl(LocalSocket paramLocalSocket, String paramString)
  {
    this.XT = paramLocalSocket;
    this.Xg = paramString;
  }
  
  public void close()
    throws IOException
  {
    this.XT.close();
  }
  
  public InputStream getInputStream()
    throws IOException
  {
    return this.XT.getInputStream();
  }
  
  public OutputStream getOutputStream()
    throws IOException
  {
    return this.XT.getOutputStream();
  }
  
  public ParcelFileDescriptor getParcelFileDescriptor()
    throws IOException
  {
    if ((this.Kx == null) && (!isClosed()))
    {
      Parcel localParcel = Parcel.obtain();
      localParcel.writeFileDescriptor(this.XT.getFileDescriptor());
      localParcel.setDataPosition(0);
      this.Kx = localParcel.readFileDescriptor();
    }
    return this.Kx;
  }
  
  public boolean isClosed()
  {
    return (!this.XT.isConnected()) && (!this.XT.isBound());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/games/internal/RealTimeSocketImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */