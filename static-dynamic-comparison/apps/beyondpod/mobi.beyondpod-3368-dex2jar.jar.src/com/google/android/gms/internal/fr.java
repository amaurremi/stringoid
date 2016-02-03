package com.google.android.gms.internal;

import android.net.LocalSocket;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.games.multiplayer.realtime.RealTimeSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

final class fr
  implements RealTimeSocket
{
  private ParcelFileDescriptor om;
  private final LocalSocket uM;
  private final String up;
  
  fr(LocalSocket paramLocalSocket, String paramString)
  {
    this.uM = paramLocalSocket;
    this.up = paramString;
  }
  
  public void close()
    throws IOException
  {
    this.uM.close();
  }
  
  public InputStream getInputStream()
    throws IOException
  {
    return this.uM.getInputStream();
  }
  
  public OutputStream getOutputStream()
    throws IOException
  {
    return this.uM.getOutputStream();
  }
  
  public ParcelFileDescriptor getParcelFileDescriptor()
    throws IOException
  {
    if ((this.om == null) && (!isClosed()))
    {
      Parcel localParcel = Parcel.obtain();
      localParcel.writeFileDescriptor(this.uM.getFileDescriptor());
      localParcel.setDataPosition(0);
      this.om = localParcel.readFileDescriptor();
    }
    return this.om;
  }
  
  public boolean isClosed()
  {
    return (!this.uM.isConnected()) && (!this.uM.isBound());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/fr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */