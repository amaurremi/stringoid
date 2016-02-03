package com.google.android.gms.maps.model;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public abstract class UrlTileProvider
        implements TileProvider {
    private final int kr;
    private final int ks;

    public UrlTileProvider(int paramInt1, int paramInt2) {
        this.kr = paramInt1;
        this.ks = paramInt2;
    }

    private static long a(InputStream paramInputStream, OutputStream paramOutputStream)
            throws IOException {
        byte[] arrayOfByte = new byte['က'];
        int i;
        for (long l = 0L; ; l += i) {
            i = paramInputStream.read(arrayOfByte);
            if (i == -1) {
                return l;
            }
            paramOutputStream.write(arrayOfByte, 0, i);
        }
    }

    private static byte[] a(InputStream paramInputStream)
            throws IOException {
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        a(paramInputStream, localByteArrayOutputStream);
        return localByteArrayOutputStream.toByteArray();
    }

    public final Tile getTile(int paramInt1, int paramInt2, int paramInt3) {
        Object localObject = getTileUrl(paramInt1, paramInt2, paramInt3);
        if (localObject == null) {
            return NO_TILE;
        }
        try {
            localObject = new Tile(this.kr, this.ks, a(((URL) localObject).openStream()));
            return (Tile) localObject;
        } catch (IOException localIOException) {
        }
        return null;
    }

    public abstract URL getTileUrl(int paramInt1, int paramInt2, int paramInt3);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/maps/model/UrlTileProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */