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
  private final ParcelFileDescriptor Fg;
  private final InputStream OT;
  private final OutputStream OU;
  
  LibjingleNativeSocket(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    this.Fg = paramParcelFileDescriptor;
    this.OT = new ParcelFileDescriptor.AutoCloseInputStream(paramParcelFileDescriptor);
    this.OU = new ParcelFileDescriptor.AutoCloseOutputStream(paramParcelFileDescriptor);
  }
  
  public void close()
    throws IOException
  {
    this.Fg.close();
  }
  
  public InputStream getInputStream()
    throws IOException
  {
    return this.OT;
  }
  
  public OutputStream getOutputStream()
    throws IOException
  {
    return this.OU;
  }
  
  public ParcelFileDescriptor getParcelFileDescriptor()
    throws IOException
  {
    return this.Fg;
  }
  
  public boolean isClosed()
  {
    try
    {
      this.OT.available();
      return false;
    }
    catch (IOException localIOException) {}
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/games/internal/LibjingleNativeSocket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */