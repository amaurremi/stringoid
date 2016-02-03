package com.everimaging.fotor.camera.a;

import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.ShutterCallback;
import android.location.Location;
import com.everimaging.fotor.c.d;
import com.everimaging.fotor.camera.CameraActivity;
import com.everimaging.fotor.log.LoggerFactory;
import com.everimaging.fotor.log.LoggerFactory.LoggerType;
import com.everimaging.fotor.log.LoggerFactory.c;

public class c
        extends a
        implements Camera.AutoFocusCallback, Camera.PictureCallback {
    private static final String l = c.class.getSimpleName();
    private static final LoggerFactory.c m = LoggerFactory.a(l, LoggerFactory.LoggerType.CONSOLE);
    protected Camera.ShutterCallback k = new Camera.ShutterCallback() {
        public void onShutter() {
            if (c.this.e != null) {
                c.this.e.c();
            }
        }
    };

    public c(CameraActivity paramCameraActivity, boolean paramBoolean) {
        super(paramCameraActivity, paramBoolean);
    }

    public void a(Camera paramCamera, int paramInt, Location paramLocation) {
        for (; ; ) {
            try {
                boolean bool = this.d;
                if (bool) {
                    continue;
                }
            } catch (Exception paramCamera) {
                this.d = true;
                m.e(new Object[]{"onTake error:" + paramCamera.getMessage()});
                if (this.i == null) {
                    continue;
                }
                this.i.b(this);
                continue;
            } finally {
            }
            return;
            if (paramCamera != null) {
                this.b = paramInt;
                this.h = paramLocation;
                this.d = false;
                a = false;
                if (c()) {
                    paramCamera.autoFocus(this);
                } else {
                    paramCamera.takePicture(this.k, null, this);
                }
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
        for (; ; ) {
            try {
                paramCamera.takePicture(this.k, null, this);
                if (!paramBoolean) {
                    paramBoolean = true;
                    a(paramBoolean);
                    return;
                }
            } catch (Exception paramCamera) {
                this.d = true;
                m.e(new Object[]{"onAutoFocus errro:" + paramCamera.getMessage()});
                if (this.i == null) {
                    continue;
                }
                this.i.b(this);
            }
            paramBoolean = false;
        }
    }

    public void onPictureTaken(byte[] paramArrayOfByte, Camera paramCamera) {
        String str = b();
        if (a(paramArrayOfByte, str, true, this.h, this.b)) {
            int i = d.a(str);
            paramArrayOfByte = a(paramArrayOfByte, this.g, this.f, i);
            if (this.e != null) {
                this.e.a(paramArrayOfByte);
            }
        }
        if (this.e != null) {
            this.e.d();
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
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotor/camera/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */