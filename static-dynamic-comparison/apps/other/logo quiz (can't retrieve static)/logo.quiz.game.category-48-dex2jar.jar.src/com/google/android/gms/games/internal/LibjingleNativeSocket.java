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
  private final ParcelFileDescriptor Kx;
  private final InputStream XM;
  private final OutputStream XN;
  
  LibjingleNativeSocket(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    this.Kx = paramParcelFileDescriptor;
    this.XM = new ParcelFileDescriptor.AutoCloseInputStream(paramParcelFileDescriptor);
    this.XN = new ParcelFileDescriptor.AutoCloseOutputStream(paramParcelFileDescriptor);
  }
  
  public void close()
    throws IOException
  {
    this.Kx.close();
  }
  
  public InputStream getInputStream()
    throws IOException
  {
    return this.XM;
  }
  
  public OutputStream getOutputStream()
    throws IOException
  {
    return this.XN;
  }
  
  public ParcelFileDescriptor getParcelFileDescriptor()
    throws IOException
  {
    return this.Kx;
  }
  
  public boolean isClosed()
  {
    try
    {
      this.XM.available();
      return false;
    }
    catch (IOException localIOException) {}
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/games/internal/LibjingleNativeSocket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */