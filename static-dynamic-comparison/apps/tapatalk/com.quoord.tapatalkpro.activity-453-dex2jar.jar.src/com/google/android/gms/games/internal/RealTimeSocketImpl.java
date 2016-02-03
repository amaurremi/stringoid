package com.google.android.gms.games.internal;

import android.net.LocalSocket;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.games.multiplayer.realtime.RealTimeSocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

final class RealTimeSocketImpl
        implements RealTimeSocket {
    private ParcelFileDescriptor Cj;
    private final LocalSocket JP;
    private final String Jg;

    RealTimeSocketImpl(LocalSocket paramLocalSocket, String paramString) {
        this.JP = paramLocalSocket;
        this.Jg = paramString;
    }

    public void close()
            throws IOException {
        this.JP.close();
    }

    public InputStream getInputStream()
            throws IOException {
        return this.JP.getInputStream();
    }

    public OutputStream getOutputStream()
            throws IOException {
        return this.JP.getOutputStream();
    }

    public ParcelFileDescriptor getParcelFileDescriptor()
            throws IOException {
        if ((this.Cj == null) && (!isClosed())) {
            Parcel localParcel = Parcel.obtain();
            localParcel.writeFileDescriptor(this.JP.getFileDescriptor());
            localParcel.setDataPosition(0);
            this.Cj = localParcel.readFileDescriptor();
        }
        return this.Cj;
    }

    public boolean isClosed() {
        return (!this.JP.isConnected()) && (!this.JP.isBound());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/games/internal/RealTimeSocketImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */