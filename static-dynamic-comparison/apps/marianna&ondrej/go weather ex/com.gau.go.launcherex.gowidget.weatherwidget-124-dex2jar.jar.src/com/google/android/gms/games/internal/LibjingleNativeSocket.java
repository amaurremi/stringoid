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
  private final ParcelFileDescriptor Cj;
  private final InputStream JI;
  private final OutputStream JJ;
  
  LibjingleNativeSocket(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    this.Cj = paramParcelFileDescriptor;
    this.JI = new ParcelFileDescriptor.AutoCloseInputStream(paramParcelFileDescriptor);
    this.JJ = new ParcelFileDescriptor.AutoCloseOutputStream(paramParcelFileDescriptor);
  }
  
  public void close()
    throws IOException
  {
    this.Cj.close();
  }
  
  public InputStream getInputStream()
    throws IOException
  {
    return this.JI;
  }
  
  public OutputStream getOutputStream()
    throws IOException
  {
    return this.JJ;
  }
  
  public ParcelFileDescriptor getParcelFileDescriptor()
    throws IOException
  {
    return this.Cj;
  }
  
  public boolean isClosed()
  {
    try
    {
      this.JI.available();
      return false;
    }
    catch (IOException localIOException) {}
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/games/internal/LibjingleNativeSocket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */