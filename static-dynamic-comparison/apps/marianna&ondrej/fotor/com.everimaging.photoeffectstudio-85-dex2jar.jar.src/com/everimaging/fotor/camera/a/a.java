package com.everimaging.fotor.camera.a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.hardware.Camera;
import android.location.Location;
import android.media.AudioManager;
import android.media.ExifInterface;
import com.everimaging.fotor.App;
import com.everimaging.fotor.c.e;
import com.everimaging.fotor.camera.CameraActivity;
import com.everimaging.fotor.log.LoggerFactory;
import com.everimaging.fotor.log.LoggerFactory.LoggerType;
import com.everimaging.fotor.log.LoggerFactory.c;
import com.everimaging.fotorsdk.utils.BitmapUtils;
import com.everimaging.fotorsdk.utils.ExifUtils;

import java.io.File;

public abstract class a {
    public static boolean a = false;
    private static final String k = a.class.getSimpleName();
    private static final LoggerFactory.c l = LoggerFactory.a(k, LoggerFactory.LoggerType.CONSOLE);
    protected int b;
    protected boolean c;
    protected boolean d = true;
    protected CameraActivity e;
    protected int f = 0;
    protected int g = 0;
    protected Location h;
    protected a i;
    protected boolean j;
    private AudioManager m;

    public a(CameraActivity paramCameraActivity, boolean paramBoolean) {
        this.e = paramCameraActivity;
        this.m = ((AudioManager) this.e.getSystemService("audio"));
        this.c = paramBoolean;
        this.g = this.e.getResources().getDimensionPixelSize(2131165386);
        this.f = this.e.getResources().getDimensionPixelSize(2131165387);
    }

    protected Bitmap a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3) {
        l.a();
        Object localObject = new BitmapFactory.Options();
        ((BitmapFactory.Options) localObject).inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, (BitmapFactory.Options) localObject);
        int n = ((BitmapFactory.Options) localObject).outWidth;
        int i1 = ((BitmapFactory.Options) localObject).outHeight;
        l.c(new Object[]{"taken picture size:" + n + "x" + i1});
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        paramInt1 = Math.max(n / paramInt1, i1 / paramInt2);
        ((BitmapFactory.Options) localObject).inJustDecodeBounds = false;
        localOptions.inSampleSize = paramInt1;
        localObject = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, localOptions);
        paramArrayOfByte = null;
        if (paramInt3 % 360 != 0) {
            paramArrayOfByte = new Matrix();
            paramArrayOfByte.setRotate(paramInt3);
        }
        paramArrayOfByte = BitmapUtils.createBitmap((Bitmap) localObject, 0, 0, ((Bitmap) localObject).getWidth(), ((Bitmap) localObject).getHeight(), paramArrayOfByte, true);
        l.c(new Object[]{"camera create thumbnail :" + l.b()});
        return paramArrayOfByte;
    }

    protected abstract void a(Camera paramCamera, int paramInt, Location paramLocation);

    public void a(Camera paramCamera, int paramInt, Location paramLocation, boolean paramBoolean, a parama) {
        this.i = parama;
        this.j = paramBoolean;
        a(paramCamera, paramInt, paramLocation);
    }

    public void a(boolean paramBoolean) {
        this.c = paramBoolean;
    }

    public abstract boolean a();

    public boolean a(byte[] paramArrayOfByte, String paramString, boolean paramBoolean, Location paramLocation, int paramInt) {
        if (!this.j) {
        }
        for (boolean bool1 = true; ; bool1 = false) {
            l.c(new Object[]{"is need save exif:" + bool1});
            try {
                l.a();
                File localFile = new File(paramString);
                if (localFile.exists()) {
                    localFile.delete();
                }
                bool2 = e.a(paramArrayOfByte, paramString);
                if ((!bool2) || (bool1)) {
                }
                for (; ; ) {
                    try {
                        paramArrayOfByte = ExifUtils.getExif(paramString);
                        if (paramArrayOfByte != null) {
                            if (paramLocation != null) {
                                paramArrayOfByte.setAttribute("GPSLatitude", ExifUtils.convertFloatToRotationLocation(paramLocation.getLatitude()));
                                paramArrayOfByte.setAttribute("GPSLatitudeRef", ExifUtils.getLatRef(paramLocation.getLatitude()));
                                paramArrayOfByte.setAttribute("GPSLongitude", ExifUtils.convertFloatToRotationLocation(paramLocation.getLongitude()));
                                paramArrayOfByte.setAttribute("GPSLongitudeRef", ExifUtils.getLonRef(paramLocation.getLongitude()));
                                if (paramLocation.hasAltitude()) {
                                    paramArrayOfByte.setAttribute("GPSAltitude", "" + paramLocation.getAltitude());
                                }
                                if (paramLocation.getTime() != 0L) {
                                    long l1 = paramLocation.getTime() / 1000L;
                                    paramArrayOfByte.setAttribute("GPSTimeStamp", "" + l1);
                                }
                            }
                            paramArrayOfByte.setAttribute("Orientation", "" + ExifUtils.convertToExifOrientation(paramInt));
                            paramArrayOfByte.saveAttributes();
                        }
                        if (paramBoolean) {
                            com.everimaging.fotor.picture.album.a.a(paramString);
                        }
                        l.c(new Object[]{"save picture :" + l.b()});
                        return bool2;
                    } catch (Exception paramArrayOfByte) {
                        paramBoolean = bool2;
                    }
                    if ((localFile != null) && (localFile.exists())) {
                        localFile.delete();
                        l.c(new Object[]{"delete file when save faild."});
                    }
                }
            } catch (Exception paramArrayOfByte) {
                for (; ; ) {
                    boolean bool2;
                    paramBoolean = false;
                }
            }
            paramArrayOfByte.printStackTrace();
            return paramBoolean;
        }
    }

    protected String b() {
        return App.b.e();
    }

    public boolean c() {
        return this.c;
    }

    public abstract void d();

    protected void finalize()
            throws Throwable {
        super.finalize();
    }

    public static abstract interface a {
        public abstract void a(a parama);

        public abstract void b(a parama);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotor/camera/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */