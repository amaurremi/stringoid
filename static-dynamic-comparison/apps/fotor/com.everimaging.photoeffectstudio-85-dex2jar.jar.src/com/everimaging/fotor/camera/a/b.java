package com.everimaging.fotor.camera.a;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.ShutterCallback;
import android.location.Location;
import android.os.AsyncTask;
import com.everimaging.fotor.c.d;
import com.everimaging.fotor.camera.CameraActivity;
import com.everimaging.fotor.log.LoggerFactory;
import com.everimaging.fotor.log.LoggerFactory.LoggerType;
import com.everimaging.fotor.log.LoggerFactory.c;
import com.everimaging.fotorsdk.utils.BitmapDecodeUtils;
import com.everimaging.fotorsdk.utils.BitmapUtils;
import com.everimaging.fotorsdk.utils.Utils;

public class b
        extends a
        implements Camera.AutoFocusCallback, Camera.PictureCallback {
    private static final String l = b.class.getSimpleName();
    private static final LoggerFactory.c m = LoggerFactory.a(l, LoggerFactory.LoggerType.CONSOLE);
    protected Camera.ShutterCallback k = new Camera.ShutterCallback() {
        public void onShutter() {
        }
    };

    public b(CameraActivity paramCameraActivity, boolean paramBoolean) {
        super(paramCameraActivity, paramBoolean);
    }

    public void a(Camera paramCamera, int paramInt, Location paramLocation) {
        try {
            if (!this.d) {
                return;
            }
            if (paramCamera != null) {
                this.b = paramInt;
                this.h = paramLocation;
                this.d = false;
                a = false;
                if (c()) {
                    paramCamera.autoFocus(this);
                    return;
                }
            }
        } catch (Exception paramCamera) {
            m.e(new Object[]{"onTake error:" + paramCamera.getMessage()});
            this.d = true;
            if (this.i != null) {
                this.i.b(this);
                return;
                paramCamera.takePicture(this.k, null, this);
            }
        }
    }

    public void a(boolean paramBoolean) {
        super.a(paramBoolean);
        if (this.e != null) {
            this.e.a(paramBoolean);
        }
    }

    public boolean a() {
        return this.d;
    }

    public void d() {
        this.d = true;
    }

    public void onAutoFocus(boolean paramBoolean, Camera paramCamera) {
        paramCamera.takePicture(this.k, null, this);
        if (!paramBoolean) {
        }
        for (paramBoolean = true; ; paramBoolean = false) {
            a(paramBoolean);
            return;
        }
    }

    public void onPictureTaken(byte[] paramArrayOfByte, Camera paramCamera) {
        String str = b();
        if (a(paramArrayOfByte, str, false, this.h, this.b)) {
            int i = d.a(str);
            paramArrayOfByte = a(paramArrayOfByte, this.g, this.f, i);
            if (this.e != null) {
                this.e.a(paramArrayOfByte);
            }
            new a(str, i).execute(new Void[0]);
        }
        paramCamera.startPreview();
        if (this.e != null) {
            this.e.h();
        }
        this.d = true;
        if (this.i != null) {
            this.i.a(this);
        }
    }

    class a
            extends AsyncTask<Void, Void, Void> {
        private String b;
        private int c;

        public a(String paramString, int paramInt) {
            this.b = paramString;
            this.c = paramInt;
        }

        protected Void a(Void... paramVarArgs) {
            paramVarArgs = BitmapDecodeUtils.decodeFile(this.b);
            int k = paramVarArgs.getWidth();
            int m = paramVarArgs.getHeight();
            int i;
            int j;
            if (k > m) {
                i = m;
                if (k <= m) {
                    break label170;
                }
                j = (k - m) / 2;
                label45:
                if (k <= m) {
                    break label175;
                }
                k = 0;
                label55:
                paramVarArgs = BitmapUtils.cropBitmap(paramVarArgs, new Rect(j, k, j + i, i + k));
                if (this.c % 360 == 0) {
                    break label187;
                }
                paramVarArgs = BitmapUtils.rotateBitmap(paramVarArgs, this.c, false, false);
                Utils.saveBitmap2Path(this.b, paramVarArgs, 90);
                b.e().c(new Object[]{"rotate spend time:" + b.e().b()});
            }
            for (; ; ) {
                com.everimaging.fotor.picture.album.a.a(this.b);
                a.a = true;
                return null;
                i = k;
                break;
                label170:
                j = 0;
                break label45;
                label175:
                k = (m - k) / 2;
                break label55;
                label187:
                Utils.saveBitmap2Path(this.b, paramVarArgs, 90);
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotor/camera/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */