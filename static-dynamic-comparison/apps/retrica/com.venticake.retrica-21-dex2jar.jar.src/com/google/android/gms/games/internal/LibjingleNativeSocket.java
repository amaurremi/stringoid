package com.google.android.gms.games.internal;

import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.ParcelFileDescriptor.AutoCloseOutputStream;
import com.google.android.gms.games.multiplayer.realtime.RealTimeSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class LibjingleNativeSocket
  implements RealTimeSocket
{
  private static final String TAG = LibjingleNativeSocket.class.getSimpleName();
  private final ParcelFileDescriptor Fj;
  private final InputStream OW;
  private final OutputStream OX;
  
  LibjingleNativeSocket(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    this.Fj = paramParcelFileDescriptor;
    this.OW = new ParcelFileDescriptor.AutoCloseInputStream(paramParcelFileDescriptor);
    this.OX = new ParcelFileDescriptor.AutoCloseOutputStream(paramParcelFileDescriptor);
  }
  
  public void close()
  {
    this.Fj.close();
  }
  
  public InputStream getInputStream()
  {
    return this.OW;
  }
  
  public OutputStream getOutputStream()
  {
    return this.OX;
  }
  
  public ParcelFileDescriptor getParcelFileDescriptor()
  {
    return this.Fj;
  }
  
  public boolean isClosed()
  {
    try
    {
      this.OW.available();
      return false;
    }
    catch (IOException localIOException) {}
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/LibjingleNativeSocket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */