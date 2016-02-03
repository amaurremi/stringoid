package com.everimaging.fotor.camera;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.media.ToneGenerator;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Toast;
import com.everimaging.fotor.App;
import com.everimaging.fotor.HomeActivity;
import com.everimaging.fotor.HomeActivity.SDKModule;
import com.everimaging.fotor.app.FotorAlertDialog;
import com.everimaging.fotor.app.FotorAlertDialog.a;
import com.everimaging.fotor.c.e;
import com.everimaging.fotor.camera.a.a.a;
import com.everimaging.fotor.camera.a.c;
import com.everimaging.fotor.log.LoggerFactory;
import com.everimaging.fotor.log.LoggerFactory.LoggerType;
import com.everimaging.fotor.log.LoggerFactory.c;
import com.everimaging.fotor.picture.album.ImagePickerActivity;
import com.everimaging.fotor.share.ShareActivity;
import com.everimaging.fotor.widget.CameraContainer;
import com.everimaging.fotor.widget.CameraContainer.a;
import com.everimaging.fotor.widget.LockEventView;
import com.everimaging.fotor.widget.VerticalSeekBar;
import com.everimaging.fotorsdk.FotorUtils;
import com.everimaging.fotorsdk.editor.FotorEditorActivity;
import com.everimaging.fotorsdk.provider.FotorContentProvider.SessionColumns;
import com.everimaging.fotorsdk.utils.DeviceUtils;
import com.everimaging.fotorsdk.utils.SystemUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CameraActivity
        extends com.everimaging.fotor.b
        implements SurfaceHolder.Callback, View.OnClickListener, View.OnTouchListener, a.a, CameraContainer.a {
    private static final String c = CameraActivity.class.getSimpleName();
    private static final LoggerFactory.c d = LoggerFactory.a(c, LoggerFactory.LoggerType.CONSOLE);
    private PreviewFrameLayout A;
    private SensorManager B;
    private SensorEventListener C;
    private Sensor D;
    private CameraMenu E;
    private CameraTimer F;
    private f G = new f();
    private a H = new a();
    private b I = new b();
    private float J = 0.0F;
    private float K = 0.0F;
    private ViewGroup L;
    private SurfaceHolder M;
    private SurfaceView N;
    private ImageView O;
    private Bitmap P = null;
    private boolean Q = true;
    private int R = a.a();
    private boolean S = a.c();
    private c T;
    private int U = 1;
    private boolean V = true;
    private boolean W = false;
    private Location X = null;
    private LocationManager Y;
    private CameraContainer Z;
    Thread a = new Thread() {
        public void run() {
            super.run();
            CameraActivity.l(CameraActivity.this);
            CameraActivity.b(CameraActivity.this).sendEmptyMessageDelayed(6, 500L);
        }
    };
    private boolean aa = false;
    private FotorAlertDialog ab;
    private boolean ac = false;
    private boolean ad = false;
    @SuppressLint({"HandlerLeak"})
    private Handler ae = new Handler() {
        public void handleMessage(Message paramAnonymousMessage) {
            super.handleMessage(paramAnonymousMessage);
            switch (paramAnonymousMessage.what) {
                case 3:
                case 7:
                case 8:
                case 9:
                default:
                    return;
                case 10:
                    if (CameraActivity.a(CameraActivity.this) != null) {
                        CameraActivity.this.b(true);
                        return;
                    }
                    CameraActivity.b(CameraActivity.this).sendEmptyMessageDelayed(10, 50L);
                    return;
                case 1:
                    if (CameraActivity.c(CameraActivity.this) == 1) {
                        CameraActivity.this.e();
                        return;
                    }
                    CameraActivity.b(CameraActivity.this).sendEmptyMessageDelayed(1, 10L);
                    return;
                case 2:
                    removeMessages(2);
                    CameraActivity.d(CameraActivity.this).a(true);
                    CameraActivity.a(CameraActivity.this, 0);
                    if (CameraActivity.c(CameraActivity.this) != 1) {
                        CameraActivity.b(CameraActivity.this, 1);
                        CameraActivity.e(CameraActivity.this).setVisibility(4);
                    }
                    CameraActivity.f(CameraActivity.this);
                    CameraActivity.g(CameraActivity.this).setProgress(0);
                    return;
                case 4:
                    if (CameraActivity.h(CameraActivity.this)) {
                        removeMessages(4);
                        CameraActivity.this.e();
                    }
                case 5:
                    while ((CameraActivity.i(CameraActivity.this) == null) || (CameraActivity.i(CameraActivity.this).getStatus() == AsyncTask.Status.FINISHED)) {
                        removeMessages(5);
                        CameraActivity.this.a();
                        return;
                        sendEmptyMessage(4);
                    }
                    sendEmptyMessageDelayed(5, 10L);
                    return;
            }
            CameraActivity.this.j();
        }
    };
    private CameraMenu.a af = new CameraMenu.a() {
        public void a(int paramAnonymousInt) {
            CameraActivity.d(CameraActivity.this, paramAnonymousInt);
            CameraActivity.n(CameraActivity.this);
            String str2 = "";
            String str1 = str2;
            switch (paramAnonymousInt) {
                default:
                    str1 = str2;
            }
            for (; ; ) {
                CameraActivity.a(CameraActivity.this, str1);
                return;
                str1 = "Normal";
                continue;
                str1 = "Burst";
                continue;
                str1 = "BigButton";
                continue;
                str1 = "Square";
                continue;
                str1 = "Stabilizer";
                continue;
                str1 = "Timer";
            }
        }

        public void a(boolean paramAnonymousBoolean) {
            int i = 8;
            if (CameraActivity.m(CameraActivity.this)) {
                CameraActivity.b(CameraActivity.this, paramAnonymousBoolean);
                VerticalSeekBar localVerticalSeekBar = CameraActivity.g(CameraActivity.this);
                if (paramAnonymousBoolean) {
                    i = 0;
                }
                localVerticalSeekBar.setVisibility(i);
                if (paramAnonymousBoolean) {
                    CameraActivity.a(CameraActivity.this, "Zoom");
                }
            }
            for (; ; ) {
                CameraActivity.n(CameraActivity.this);
                return;
                CameraActivity.g(CameraActivity.this).setVisibility(8);
            }
        }

        public void b(boolean paramAnonymousBoolean) {
            GridView localGridView = CameraActivity.o(CameraActivity.this);
            if (paramAnonymousBoolean) {
            }
            for (int i = 0; ; i = 8) {
                localGridView.setVisibility(i);
                CameraActivity.n(CameraActivity.this);
                if (paramAnonymousBoolean) {
                    CameraActivity.a(CameraActivity.this, "Grid");
                }
                return;
            }
        }
    };
    private View.OnTouchListener ag = new View.OnTouchListener() {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent) {
            switch (paramAnonymousView.getId()) {
            }
            do {
                return false;
            } while (CameraActivity.p(CameraActivity.this));
            if (CameraActivity.q(CameraActivity.this) == 3) {
                if (paramAnonymousMotionEvent.getAction() != 0) {
                    break label141;
                }
                CameraActivity.e(CameraActivity.this).setVisibility(4);
                CameraActivity.b(CameraActivity.this, 1);
                CameraActivity.r(CameraActivity.this).setPressed(true);
                CameraActivity.b(CameraActivity.this).removeCallbacks(CameraActivity.s(CameraActivity.this));
                CameraActivity.b.a(CameraActivity.s(CameraActivity.this), false);
                CameraActivity.b(CameraActivity.this).post(CameraActivity.s(CameraActivity.this));
                CameraActivity.this.f();
            }
            for (; ; ) {
                return true;
                label141:
                if (paramAnonymousMotionEvent.getAction() == 1) {
                    CameraActivity.r(CameraActivity.this).setPressed(false);
                    CameraActivity.b(CameraActivity.this).removeCallbacks(CameraActivity.s(CameraActivity.this));
                    CameraActivity.b.a(CameraActivity.s(CameraActivity.this), true);
                    CameraActivity.this.g();
                }
            }
        }
    };
    private final LocationListener ah = new LocationListener() {
        public void onLocationChanged(Location paramAnonymousLocation) {
            CameraActivity.a(CameraActivity.this, paramAnonymousLocation);
        }

        public void onProviderDisabled(String paramAnonymousString) {
            CameraActivity.p().f(new Object[]{"Provider now is disabled..."});
        }

        public void onProviderEnabled(String paramAnonymousString) {
            CameraActivity.p().f(new Object[]{"Provider now is enabled..."});
        }

        public void onStatusChanged(String paramAnonymousString, int paramAnonymousInt, Bundle paramAnonymousBundle) {
        }
    };
    private final LocationListener ai = new LocationListener() {
        public void onLocationChanged(Location paramAnonymousLocation) {
            CameraActivity.a(CameraActivity.this, paramAnonymousLocation);
        }

        public void onProviderDisabled(String paramAnonymousString) {
            CameraActivity.p().f(new Object[]{"Provider now is disabled..."});
        }

        public void onProviderEnabled(String paramAnonymousString) {
            CameraActivity.p().f(new Object[]{"Provider now is enabled..."});
        }

        public void onStatusChanged(String paramAnonymousString, int paramAnonymousInt, Bundle paramAnonymousBundle) {
        }
    };
    Camera.AutoFocusCallback b = new Camera.AutoFocusCallback() {
        public void onAutoFocus(boolean paramAnonymousBoolean, Camera paramAnonymousCamera) {
            if ((paramAnonymousBoolean) && (CameraActivity.A(CameraActivity.this) != null)) {
                CameraActivity.A(CameraActivity.this).startTone(24);
            }
            paramAnonymousCamera = CameraActivity.this;
            if (!paramAnonymousBoolean) {
            }
            for (paramAnonymousBoolean = true; ; paramAnonymousBoolean = false) {
                CameraActivity.a(paramAnonymousCamera, paramAnonymousBoolean);
                CameraActivity.e(CameraActivity.this).setVisibility(4);
                CameraActivity.b(CameraActivity.this, 1);
                CameraActivity.j(CameraActivity.this).a(CameraActivity.k(CameraActivity.this));
                return;
            }
        }
    };
    private OrientationEventListener e;
    private int f = -1;
    private ImageButton g;
    private ImageButton h;
    private ImageButton i;
    private GridView j;
    private Camera k;
    private View l;
    private com.everimaging.fotor.camera.a.a m;
    private VerticalSeekBar n;
    private LockEventView o;
    private boolean p = false;
    private int q;
    private SeekBar.OnSeekBarChangeListener r;
    private ImageView s;
    private ImageButton t;
    private CameraFlashView u;
    private d v;
    private boolean w = a.b();
    private CameraFrameMaskView x;
    private String y = a.d();
    private ToneGenerator z;

    private boolean A() {
        if (this.k == null) {
            z();
        }
        return this.k != null;
    }

    private void B() {
        this.o.c();
        this.p = true;
        switch (this.q) {
            case 1:
            default:
            case 3:
                do {
                    return;
                } while (b.a(this.I));
                if (this.w) {
                }
                for (int i1 = 10; ; i1 = 300) {
                    this.ae.postDelayed(this.I, i1);
                    return;
                }
            case 6:
                this.i.setSelected(false);
                g();
                return;
            case 0:
                g();
                return;
            case 2:
                this.i.setEnabled(true);
                g();
                return;
            case 4:
                this.i.setEnabled(true);
                this.F.a();
                g();
                return;
        }
        g();
    }

    private Camera.Size a(List<Camera.Size> paramList, int paramInt1, int paramInt2) {
        double d2 = paramInt1 / paramInt2;
        Object localObject2;
        if (paramList == null) {
            localObject2 = null;
            return (Camera.Size) localObject2;
        }
        Object localObject1 = null;
        double d1 = Double.MAX_VALUE;
        Iterator localIterator = paramList.iterator();
        label33:
        while (localIterator.hasNext()) {
            localObject2 = (Camera.Size) localIterator.next();
            if (Math.abs(((Camera.Size) localObject2).width / ((Camera.Size) localObject2).height - d2) <= 0.05D) {
                if (Math.abs(((Camera.Size) localObject2).height - paramInt2) >= d1) {
                    break label205;
                }
                d1 = Math.abs(((Camera.Size) localObject2).height - paramInt2);
                localObject1 = localObject2;
            }
        }
        label205:
        for (; ; ) {
            break label33;
            localObject2 = localObject1;
            if (localObject1 != null) {
                break;
            }
            localIterator = paramList.iterator();
            d1 = Double.MAX_VALUE;
            localObject2 = localObject1;
            if (!localIterator.hasNext()) {
                break;
            }
            paramList = (Camera.Size) localIterator.next();
            if (Math.abs(paramList.height - paramInt2) < d1) {
                d1 = Math.abs(paramList.height - paramInt2);
            }
            for (; ; ) {
                localObject1 = paramList;
                break;
                paramList = (List<Camera.Size>) localObject1;
            }
        }
    }

    private void a(Location paramLocation) {
        if ((paramLocation != null) && (a(paramLocation, this.X))) {
            this.X = paramLocation;
        }
        for (paramLocation = "Latitude:" + paramLocation.getLatitude() + "  Longitude:" + paramLocation.getLongitude(); ; paramLocation = "Can't access your location") {
            d.f(new Object[]{"The location has changed.."});
            d.f(new Object[]{"Your Location:" + paramLocation});
            return;
        }
    }

    private void a(Uri paramUri) {
        Intent localIntent = new Intent(this, FotorEditorActivity.class);
        localIntent.setData(paramUri);
        paramUri = new File(App.b.f(), "share_tempory.jpg");
        if (paramUri.exists()) {
            paramUri.delete();
        }
        try {
            paramUri.createNewFile();
            localIntent.putExtra("extra_output_path", Uri.fromFile(paramUri));
            localIntent.putExtra("extra_max_preview_size", (int) (Math.max(DeviceUtils.getScreenWidth(), DeviceUtils.getScreenHeight()) / 1.2F));
            localIntent.putExtra("extra_output_quality", 90);
            paramUri = FotorUtils.generateSessionId(this);
            getContentResolver().delete(FotorContentProvider.SessionColumns.getContentUri(this, paramUri), null, null);
            localIntent.putExtra("extra_fotor_session_id", paramUri);
            localIntent.putExtra("extra_save_on_no_changes", true);
            startActivityForResult(localIntent, 2);
            return;
        } catch (IOException localIOException) {
            for (; ; ) {
                localIOException.printStackTrace();
            }
        }
    }

    private void a(Uri paramUri, String paramString, boolean paramBoolean) {
        d.c(new Object[]{"share image :" + paramUri});
        Intent localIntent = new Intent(this, ShareActivity.class);
        localIntent.setData(paramUri);
        localIntent.putExtra("extra_fotor_session_id", paramString);
        localIntent.putExtra("extra_is_bitmap_changed", paramBoolean);
        localIntent.putExtra("extra_sdk_module", HomeActivity.SDKModule.EDITOR);
        startActivity(localIntent);
    }

    private void a(List<String> paramList) {
        if ((this.w) && (this.k != null)) {
            paramList = this.k.getParameters();
            paramList.getSupportedFlashModes();
            paramList.getFlashMode();
        }
    }

    private boolean a(Camera paramCamera, Location paramLocation, int paramInt) {
        if (paramCamera != null) {
            try {
                Camera.Parameters localParameters = paramCamera.getParameters();
                if (paramLocation != null) {
                    localParameters.removeGpsData();
                    localParameters.setGpsLatitude(paramLocation.getLatitude());
                    localParameters.setGpsLongitude(paramLocation.getLongitude());
                    if (!paramLocation.hasAltitude()) {
                        break label93;
                    }
                    localParameters.setGpsAltitude(paramLocation.getAltitude());
                }
                for (; ; ) {
                    if (paramLocation.getTime() != 0L) {
                        localParameters.setGpsTimestamp(paramLocation.getTime() / 1000L);
                    }
                    localParameters.setRotation(paramInt % 360);
                    paramCamera.setParameters(localParameters);
                    return true;
                    label93:
                    localParameters.setGpsAltitude(0.0D);
                }
                return false;
            } catch (Exception paramCamera) {
                paramCamera.printStackTrace();
            }
        }
    }

    private boolean a(String paramString1, String paramString2) {
        if (paramString1 == null) {
            return paramString2 == null;
        }
        return paramString1.equals(paramString2);
    }

    private Camera.Size b(List<Camera.Size> paramList, int paramInt1, int paramInt2) {
        Object localObject1 = null;
        int i3 = paramInt1 * paramInt2;
        Object localObject2 = localObject1;
        if (paramList != null) {
            localObject2 = localObject1;
            if (!paramList.isEmpty()) {
                localObject1 = (Camera.Size) paramList.get(0);
                paramInt2 = Math.abs(((Camera.Size) localObject1).height * ((Camera.Size) localObject1).width - i3);
                paramInt1 = 1;
                for (; ; ) {
                    localObject2 = localObject1;
                    if (paramInt1 >= paramList.size()) {
                        break;
                    }
                    localObject2 = (Camera.Size) paramList.get(paramInt1);
                    int i2 = Math.abs(((Camera.Size) localObject2).height * ((Camera.Size) localObject2).width - i3);
                    int i1 = paramInt2;
                    if (paramInt2 >= i2) {
                        i1 = i2;
                    }
                    if (i1 >= i2) {
                        localObject1 = localObject2;
                    }
                    paramInt1 += 1;
                    paramInt2 = i1;
                }
            }
        }
        return (Camera.Size) localObject2;
    }

    private void b(int paramInt) {
        int i1 = 0;
        this.m = null;
        this.q = paramInt;
        a(paramInt);
        this.W = false;
        x();
        this.L.setVisibility(0);
        CameraTimer localCameraTimer;
        switch (paramInt) {
            case 1:
            default:
                localCameraTimer = this.F;
                if (paramInt != 4) {
                    break;
                }
        }
        for (paramInt = i1; ; paramInt = 8) {
            localCameraTimer.setVisibility(paramInt);
            return;
            this.i.setImageResource(2130837617);
            this.m = new c(this, this.V);
            this.i.setOnClickListener(null);
            this.i.setOnTouchListener(this.ag);
            this.x.setVisibility(8);
            if (this.w) {
                this.E.setZoomToolEnable(true);
            }
            this.j.setRatio(0.0F);
            break;
            this.m = new c(this, this.V);
            this.i.setImageResource(2130837626);
            this.i.setOnClickListener(this);
            this.i.setOnTouchListener(null);
            this.x.setVisibility(4);
            if (this.w) {
                this.E.setZoomToolEnable(true);
            }
            this.j.setRatio(0.0F);
            break;
            this.m = new c(this, this.V);
            this.i.setImageResource(2130837620);
            this.i.setOnClickListener(this);
            this.i.setOnTouchListener(null);
            this.x.setVisibility(4);
            if (this.w) {
                this.E.setZoomToolEnable(true);
            }
            this.j.setRatio(0.0F);
            break;
            this.m = new c(this, this.V);
            this.i.setImageResource(2130837629);
            this.i.setOnClickListener(this);
            this.i.setOnTouchListener(null);
            this.x.setVisibility(4);
            if (this.w) {
                this.E.setZoomToolEnable(true);
            }
            this.j.setRatio(0.0F);
            break;
            this.m = new com.everimaging.fotor.camera.a.b(this, this.V);
            this.i.setImageResource(2130837623);
            this.i.setOnClickListener(this);
            this.i.setOnTouchListener(null);
            this.x.setVisibility(0);
            if (this.w) {
                this.E.setZoomToolEnable(true);
            }
            this.j.setRatio(1.0F);
            break;
            this.m = new c(this, this.V);
            this.i.setImageResource(2130837614);
            this.i.setOnClickListener(this);
            this.i.setOnTouchListener(null);
            this.x.setVisibility(4);
            this.W = true;
            if (this.w) {
                this.E.setZoomToolEnable(true);
            }
            this.j.setRatio(0.0F);
            break;
        }
    }

    private void b(String paramString) {
        HashMap localHashMap = new HashMap();
        localHashMap.put("Fotor_Camera_Menu_Tap", paramString);
        a("Fotor_Camera_Menu_Tap", localHashMap);
    }

    private int c(boolean paramBoolean) {
        if ((Build.MODEL.toLowerCase().contains("incredible s")) || (Build.MODEL.toLowerCase().contains("desire s"))) {
            return e.a(this.f + 90);
        }
        if (paramBoolean) {
            return e.a(this.f + 90);
        }
        return e.b(this.f + 270);
    }

    private void q() {
        this.ae.sendEmptyMessage(5);
    }

    private void r() {
        this.Z = ((CameraContainer) findViewById(2131558515));
        this.Z.setTouchOutsideListener(this);
        this.N = ((SurfaceView) findViewById(2131558523));
        this.N.setOnTouchListener(this);
        Object localObject = this.N.getHolder();
        ((SurfaceHolder) localObject).addCallback(this);
        ((SurfaceHolder) localObject).setType(3);
        this.g = ((ImageButton) findViewById(2131558520));
        this.g.setOnClickListener(this);
        this.h = ((ImageButton) findViewById(2131558521));
        this.h.setOnClickListener(this);
        localObject = this.h;
        if (this.aa) {
        }
        for (int i1 = 0; ; i1 = 8) {
            ((ImageButton) localObject).setVisibility(i1);
            this.i = ((ImageButton) findViewById(2131558519));
            this.i.setOnClickListener(this);
            this.F = ((CameraTimer) findViewById(2131558528));
            this.F.setTime(a.f());
            this.O = ((ImageView) findViewById(2131558525));
            this.j = ((GridView) findViewById(2131558524));
            this.o = ((LockEventView) findViewById(2131558529));
            this.n = ((VerticalSeekBar) findViewById(2131558526));
            this.r = new e();
            this.n.setOnSeekBarChangeListener(this.r);
            this.s = ((ImageView) findViewById(2131558518));
            this.s.setOnClickListener(this);
            this.u = ((CameraFlashView) findViewById(2131558513));
            this.v = new d();
            this.u.setOnFlashModeChangeListener(this.v);
            a(a.h());
            this.t = ((ImageButton) findViewById(2131558514));
            this.t.setOnClickListener(this);
            this.l = findViewById(2131558530);
            x();
            this.A = ((PreviewFrameLayout) findViewById(2131558522));
            this.E = ((CameraMenu) findViewById(2131558527));
            this.E.setMenuChangeListener(this.af);
            this.E.setZoomSupported(a.g());
            this.L = ((ViewGroup) findViewById(2131558517));
            this.x = ((CameraFrameMaskView) findViewById(2131558511));
            q();
            return;
        }
    }

    private void s() {
        this.Z.setDummyPopupView(null);
        if (this.E.getVisibility() == 0) {
            u();
        }
    }

    private void t() {
        try {
            FragmentManager localFragmentManager = getSupportFragmentManager();
            if (localFragmentManager.findFragmentByTag("APP_DIALOG_NO_SPACE") == null) {
                FotorAlertDialog localFotorAlertDialog = FotorAlertDialog.a();
                Bundle localBundle = new Bundle();
                localBundle.putCharSequence("MESSAGE", getBaseContext().getText(2131296377));
                localBundle.putCharSequence("POSITIVE_BUTTON_TEXT", getBaseContext().getText(17039370));
                localFotorAlertDialog.setArguments(localBundle);
                localFotorAlertDialog.setCancelable(false);
                localFotorAlertDialog.show(localFragmentManager, "APP_DIALOG_NO_SPACE");
            }
            return;
        } catch (Exception localException) {
            localException.printStackTrace();
        }
    }

    private void u() {
        int i1 = this.E.getHeight();
        float f1;
        if (this.E.getVisibility() == 0) {
            f1 = 0.0F;
            if (this.E.getVisibility() != 0) {
                break label86;
            }
        }
        label86:
        for (float f2 = i1; ; f2 = 0.0F) {
            this.E.setVisibility(this.E.getVisibility() ^ 0x4);
            TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, f1, f2);
            localTranslateAnimation.setDuration(300L);
            this.E.startAnimation(localTranslateAnimation);
            return;
            f1 = i1;
            break;
        }
    }

    private void v() {
        Intent localIntent = new Intent(this, ImagePickerActivity.class);
        localIntent.putExtra("extra_is_choose_fotor_album", true);
        startActivityForResult(localIntent, 1);
    }

    private void w() {
        boolean bool = true;
        if (!this.w) {
        }
        for (; ; ) {
            this.w = bool;
            this.E.setZoomToolEnable(this.w);
            try {
                this.U = 1;
                this.p = false;
                z();
                b(true);
                return;
            } catch (Exception localException) {
                localException.printStackTrace();
                return;
            } finally {
                this.ae.postDelayed(new Runnable() {
                    public void run() {
                        CameraActivity.d(CameraActivity.this).c();
                    }
                }, 1000L);
            }
            bool = false;
        }
    }

    private void x() {
        if (k() > 1) {
            this.t.setVisibility(0);
            this.t.setOnClickListener(this);
            return;
        }
        this.t.setVisibility(8);
    }

    private void y() {
        int i1 = c(this.w);
        d.c(new Object[]{"latchedOrientation = " + i1});
        this.p = false;
        boolean bool = a(this.k, this.X, i1);
        this.m.a(this.k, i1, this.X, bool, this);
    }

    private void z() {
        int i2 = 1;
        int i3 = 0;
        for (; ; ) {
            try {
                if (this.k != null) {
                    this.k.release();
                    this.k = null;
                }
                try {
                    i4 = Camera.getNumberOfCameras();
                    if (!this.w) {
                        break label244;
                    }
                    i2 = 0;
                } catch (Exception localException) {
                    int i4;
                    Camera.CameraInfo localCameraInfo;
                    if (getSupportFragmentManager().findFragmentByTag("dialog_camera_error") != null) {
                        continue;
                    }
                    this.ab = FotorAlertDialog.a();
                    Bundle localBundle = new Bundle();
                    localBundle.putCharSequence("TITLE", getText(2131296602));
                    localBundle.putCharSequence("MESSAGE", getText(2131296603));
                    localBundle.putCharSequence("POSITIVE_BUTTON_TEXT", getText(17039370));
                    this.ab.setArguments(localBundle);
                    this.ab.setCancelable(false);
                    this.ab.a(new FotorAlertDialog.a() {
                        public void a(FotorAlertDialog paramAnonymousFotorAlertDialog) {
                            CameraActivity.this.finish();
                            CameraActivity.a(CameraActivity.this, null);
                        }

                        public void b(FotorAlertDialog paramAnonymousFotorAlertDialog) {
                        }

                        public void c(FotorAlertDialog paramAnonymousFotorAlertDialog) {
                        }
                    });
                    this.ab.show(getSupportFragmentManager(), "dialog_camera_error");
                    d.e(new Object[]{localException.getMessage()});
                    continue;
                }
                if (i1 < i4) {
                    localCameraInfo = new Camera.CameraInfo();
                    Camera.getCameraInfo(i1, localCameraInfo);
                    if (localCameraInfo.facing != i2) {
                        break label249;
                    }
                    i3 = i1;
                    break label249;
                }
                l();
                this.k = Camera.open(i3);
                return;
            } finally {
            }
            label244:
            int i1 = 0;
            continue;
            label249:
            i1 += 1;
        }
    }

    public void a() {
        if (this.P != null) {
            a(this.P);
        }
        new c().execute(new Void[0]);
    }

    public void a(int paramInt) {
        CameraFlashView localCameraFlashView = this.u;
        if (this.w) {
        }
        for (int i1 = 0; ; i1 = 8) {
            localCameraFlashView.setVisibility(i1);
            switch (paramInt) {
                case 1:
                default:
                    return;
            }
        }
        this.u.setVisibility(8);
        i();
        return;
        a(a.h());
        h();
        return;
        a(a.h());
        h();
        return;
        a(a.h());
        h();
        return;
        a(a.h());
        h();
        return;
        a(a.h());
        h();
    }

    public void a(final Bitmap paramBitmap) {
        runOnUiThread(new Runnable() {
            public void run() {
                CameraActivity.a(CameraActivity.this, paramBitmap);
                CameraActivity.y(CameraActivity.this).setImageBitmap(paramBitmap);
            }
        });
    }

    public void a(Camera.Size paramSize) {
        if (paramSize == null) {
            d.d(new Object[]{"set picture size is null"});
        }
        do {
            return;
            d.c(new Object[]{"picture size:" + paramSize.width + "x" + paramSize.height});
        } while (this.k == null);
        Camera.Parameters localParameters = this.k.getParameters();
        localParameters.setPictureSize(paramSize.width, paramSize.height);
        double d1 = paramSize.width * 1.0D / paramSize.height;
        d.c(new Object[]{"picture ratio>>>>>>>>>>>>>>>>>>>>>" + d1});
        this.A.setAspectRatio(d1);
        paramSize = a(localParameters.getSupportedPreviewSizes(), paramSize.width, paramSize.height);
        if (paramSize != null) {
            localParameters.setPreviewSize(paramSize.width, paramSize.height);
            d.c(new Object[]{"preview ratio>>>>>>>>>>>>>>>>>>>>>" + paramSize.width * 1.0D / paramSize.height});
        }
        try {
            this.k.setParameters(localParameters);
            return;
        } catch (Exception paramSize) {
            paramSize.printStackTrace();
        }
    }

    public void a(com.everimaging.fotor.camera.a.a parama) {
        d.c(new Object[]{"onCaptureFinished"});
        B();
    }

    public void a(boolean paramBoolean) {
        this.V = paramBoolean;
    }

    protected boolean a(Location paramLocation1, Location paramLocation2) {
        if (paramLocation2 == null) {
        }
        int i2;
        int i3;
        label41:
        int i1;
        label68:
        label74:
        label77:
        for (; ; ) {
            return true;
            long l1 = paramLocation1.getTime() - paramLocation2.getTime();
            if (l1 > 120000L) {
                i2 = 1;
                if (l1 >= -120000L) {
                    break label68;
                }
                i3 = 1;
                if (l1 <= 0L) {
                    break label74;
                }
            }
            for (i1 = 1; ; i1 = 0) {
                if (i2 != 0) {
                    break label77;
                }
                if (i3 == 0) {
                    break label79;
                }
                return false;
                i2 = 0;
                break;
                i3 = 0;
                break label41;
            }
        }
        label79:
        int i4 = (int) (paramLocation1.getAccuracy() - paramLocation2.getAccuracy());
        if (i4 > 0) {
            i2 = 1;
            label99:
            if (i4 >= 0) {
                break label168;
            }
            i3 = 1;
            label107:
            if (i4 <= 200) {
                break label174;
            }
        }
        label168:
        label174:
        for (i4 = 1; ; i4 = 0) {
            boolean bool = a(paramLocation1.getProvider(), paramLocation2.getProvider());
            if ((i3 != 0) || ((i1 != 0) && (i2 == 0)) || ((i1 != 0) && (i4 == 0) && (bool))) {
                break;
            }
            return false;
            i2 = 0;
            break label99;
            i3 = 0;
            break label107;
        }
    }

    public void b() {
        if ((this.p) && (this.m.a())) {
            if (this.k != null) {
                this.U = 2;
                this.k.autoFocus(this.b);
            }
            return;
        }
        this.U = 1;
        this.l.setVisibility(4);
    }

    public void b(com.everimaging.fotor.camera.a.a parama) {
        d.c(new Object[]{"onCaptureError"});
        B();
    }

    /* Error */
    public void b(boolean paramBoolean) {
        // Byte code:
        //   0: iload_1
        //   1: ifne +4 -> 5
        //   4: return
        //   5: aload_0
        //   6: aload_0
        //   7: getfield 280	com/everimaging/fotor/camera/CameraActivity:q	I
        //   10: invokevirtual 627	com/everimaging/fotor/camera/CameraActivity:a	(I)V
        //   13: aload_0
        //   14: invokevirtual 1076	com/everimaging/fotor/camera/CameraActivity:j	()V
        //   17: aload_0
        //   18: invokespecial 1078	com/everimaging/fotor/camera/CameraActivity:A	()Z
        //   21: ifeq -17 -> 4
        //   24: aload_0
        //   25: getfield 191	com/everimaging/fotor/camera/CameraActivity:p	Z
        //   28: ifeq +7 -> 35
        //   31: aload_0
        //   32: invokevirtual 1080	com/everimaging/fotor/camera/CameraActivity:m	()V
        //   35: aload_0
        //   36: getfield 353	com/everimaging/fotor/camera/CameraActivity:M	Landroid/view/SurfaceHolder;
        //   39: ifnull -35 -> 4
        //   42: aload_0
        //   43: getfield 270	com/everimaging/fotor/camera/CameraActivity:k	Landroid/hardware/Camera;
        //   46: ifnull +26 -> 72
        //   49: invokestatic 1083	com/everimaging/fotor/c/a:a	()I
        //   52: istore_2
        //   53: aload_0
        //   54: getfield 270	com/everimaging/fotor/camera/CameraActivity:k	Landroid/hardware/Camera;
        //   57: iload_2
        //   58: invokevirtual 1086	android/hardware/Camera:setDisplayOrientation	(I)V
        //   61: aload_0
        //   62: getfield 270	com/everimaging/fotor/camera/CameraActivity:k	Landroid/hardware/Camera;
        //   65: aload_0
        //   66: getfield 353	com/everimaging/fotor/camera/CameraActivity:M	Landroid/view/SurfaceHolder;
        //   69: invokevirtual 1090	android/hardware/Camera:setPreviewDisplay	(Landroid/view/SurfaceHolder;)V
        //   72: aload_0
        //   73: getfield 270	com/everimaging/fotor/camera/CameraActivity:k	Landroid/hardware/Camera;
        //   76: invokevirtual 552	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
        //   79: astore 5
        //   81: aload 5
        //   83: bipush 17
        //   85: invokevirtual 1093	android/hardware/Camera$Parameters:setPreviewFormat	(I)V
        //   88: aload 5
        //   90: sipush 256
        //   93: invokevirtual 1096	android/hardware/Camera$Parameters:setPictureFormat	(I)V
        //   96: aload 5
        //   98: bipush 90
        //   100: invokevirtual 1099	android/hardware/Camera$Parameters:setJpegQuality	(I)V
        //   103: aload_0
        //   104: getfield 270	com/everimaging/fotor/camera/CameraActivity:k	Landroid/hardware/Camera;
        //   107: aload 5
        //   109: invokevirtual 602	android/hardware/Camera:setParameters	(Landroid/hardware/Camera$Parameters;)V
        //   112: aconst_null
        //   113: astore 4
        //   115: aload 4
        //   117: astore_3
        //   118: aload_0
        //   119: getfield 198	com/everimaging/fotor/camera/CameraActivity:w	Z
        //   122: ifeq +45 -> 167
        //   125: invokestatic 1104	com/everimaging/fotor/settings/a:b	()Lcom/everimaging/fotor/c/c;
        //   128: astore 6
        //   130: aload 4
        //   132: astore_3
        //   133: aload 6
        //   135: ifnull +32 -> 167
        //   138: aload_0
        //   139: getfield 270	com/everimaging/fotor/camera/CameraActivity:k	Landroid/hardware/Camera;
        //   142: astore_3
        //   143: aload_3
        //   144: invokevirtual 1108	java/lang/Object:getClass	()Ljava/lang/Class;
        //   147: pop
        //   148: new 331	android/hardware/Camera$Size
        //   151: dup
        //   152: aload_3
        //   153: aload 6
        //   155: getfield 1112	com/everimaging/fotor/c/c:a	I
        //   158: aload 6
        //   160: getfield 1114	com/everimaging/fotor/c/c:b	I
        //   163: invokespecial 1117	android/hardware/Camera$Size:<init>	(Landroid/hardware/Camera;II)V
        //   166: astore_3
        //   167: aload_3
        //   168: astore 4
        //   170: aload_3
        //   171: ifnonnull +42 -> 213
        //   174: aload_0
        //   175: aload 5
        //   177: invokevirtual 1120	android/hardware/Camera$Parameters:getSupportedPictureSizes	()Ljava/util/List;
        //   180: invokestatic 456	com/everimaging/fotorsdk/utils/DeviceUtils:getScreenWidth	()I
        //   183: invokestatic 459	com/everimaging/fotorsdk/utils/DeviceUtils:getScreenHeight	()I
        //   186: aload_0
        //   187: invokevirtual 1124	com/everimaging/fotor/camera/CameraActivity:getResources	()Landroid/content/res/Resources;
        //   190: ldc_w 1125
        //   193: invokevirtual 1130	android/content/res/Resources:getDimensionPixelSize	(I)I
        //   196: isub
        //   197: aload_0
        //   198: invokevirtual 1124	com/everimaging/fotor/camera/CameraActivity:getResources	()Landroid/content/res/Resources;
        //   201: ldc_w 1131
        //   204: invokevirtual 1130	android/content/res/Resources:getDimensionPixelSize	(I)I
        //   207: isub
        //   208: invokespecial 1133	com/everimaging/fotor/camera/CameraActivity:b	(Ljava/util/List;II)Landroid/hardware/Camera$Size;
        //   211: astore 4
        //   213: aload_0
        //   214: aload_0
        //   215: getfield 280	com/everimaging/fotor/camera/CameraActivity:q	I
        //   218: invokevirtual 627	com/everimaging/fotor/camera/CameraActivity:a	(I)V
        //   221: aload_0
        //   222: invokevirtual 1076	com/everimaging/fotor/camera/CameraActivity:j	()V
        //   225: aload_0
        //   226: aload 4
        //   228: invokevirtual 1135	com/everimaging/fotor/camera/CameraActivity:a	(Landroid/hardware/Camera$Size;)V
        //   231: aload_0
        //   232: getfield 270	com/everimaging/fotor/camera/CameraActivity:k	Landroid/hardware/Camera;
        //   235: invokevirtual 1138	android/hardware/Camera:startPreview	()V
        //   238: aload_0
        //   239: iconst_1
        //   240: putfield 191	com/everimaging/fotor/camera/CameraActivity:p	Z
        //   243: return
        //   244: astore_3
        //   245: aload_3
        //   246: invokevirtual 603	java/lang/Exception:printStackTrace	()V
        //   249: return
        //   250: astore_3
        //   251: aload_3
        //   252: invokevirtual 507	java/io/IOException:printStackTrace	()V
        //   255: aload_0
        //   256: invokevirtual 1080	com/everimaging/fotor/camera/CameraActivity:m	()V
        //   259: aload_0
        //   260: invokevirtual 976	com/everimaging/fotor/camera/CameraActivity:l	()V
        //   263: return
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	264	0	this	CameraActivity
        //   0	264	1	paramBoolean	boolean
        //   52	6	2	i1	int
        //   117	54	3	localObject1	Object
        //   244	2	3	localException	Exception
        //   250	2	3	localIOException	IOException
        //   113	114	4	localObject2	Object
        //   79	97	5	localParameters	Camera.Parameters
        //   128	31	6	localc	com.everimaging.fotor.c.c
        // Exception table:
        //   from	to	target	type
        //   5	35	244	java/lang/Exception
        //   35	61	244	java/lang/Exception
        //   61	72	244	java/lang/Exception
        //   72	112	244	java/lang/Exception
        //   118	130	244	java/lang/Exception
        //   138	167	244	java/lang/Exception
        //   174	213	244	java/lang/Exception
        //   213	243	244	java/lang/Exception
        //   251	263	244	java/lang/Exception
        //   61	72	250	java/io/IOException
    }

    public void c() {
        this.O.setBackgroundColor(getResources().getColor(2131493041));
    }

    public void d() {
        this.O.setBackgroundColor(0);
    }

    void e() {
        if (this.ad) {
            return;
        }
        if (this.U == 2) {
            this.ae.removeMessages(1);
            this.ae.sendEmptyMessageDelayed(1, 10L);
            return;
        }
        this.o.a(true);
        switch (this.q) {
            case 3:
            case 1:
            default:
                return;
            case 0:
            case 6:
                for (; ; ) {
                    f();
                    y();
                    return;
                    this.i.setSelected(true);
                }
            case 2:
                f();
                this.i.setEnabled(false);
                this.ae.post(this.H);
                return;
            case 4:
                f();
                this.i.setEnabled(false);
                this.F.a(new Animation.AnimationListener() {
                    public void onAnimationEnd(Animation paramAnonymousAnimation) {
                        CameraActivity.b(CameraActivity.this).postDelayed(CameraActivity.t(CameraActivity.this), 1000L);
                    }

                    public void onAnimationRepeat(Animation paramAnonymousAnimation) {
                    }

                    public void onAnimationStart(Animation paramAnonymousAnimation) {
                    }
                });
                a.a(this.F.getTime());
                return;
        }
        f();
        y();
    }

    public void f() {
        this.t.setEnabled(false);
        this.g.setEnabled(false);
        this.h.setEnabled(false);
    }

    protected void finalize()
            throws Throwable {
        super.finalize();
    }

    public void g() {
        this.t.setEnabled(true);
        this.g.setEnabled(true);
        this.h.setEnabled(true);
    }

    public void h() {
        try {
            if (this.k != null) {
                Camera.Parameters localParameters = this.k.getParameters();
                localParameters.setFlashMode(this.y);
                this.k.setParameters(localParameters);
            }
            this.u.setCurrentFlashMode(this.y);
            return;
        } catch (Exception localException) {
            localException.printStackTrace();
        }
    }

    public void i() {
        this.y = "off";
        h();
    }

    public void j() {
        for (int i1 = 0; ; i1 = 8) {
            try {
                if (!this.w) {
                    break label109;
                }
                if (this.E.a()) {
                    if (a.g()) {
                        this.n.setProgress(this.R);
                        this.r.onProgressChanged(this.n, this.R, false);
                        VerticalSeekBar localVerticalSeekBar = this.n;
                        if (!this.S) {
                            continue;
                        }
                        localVerticalSeekBar.setVisibility(i1);
                        this.E.setZoomSelected(this.S);
                        return;
                    }
                    this.n.setVisibility(8);
                    return;
                }
            } catch (Exception localException) {
                localException.printStackTrace();
                return;
            }
            this.n.setVisibility(8);
            return;
            label109:
            this.E.setZoomToolEnable(false);
            this.n.setVisibility(8);
            return;
        }
    }

    public int k() {
        try {
            if (Build.VERSION.SDK_INT <= 8) {
                break label100;
            }
            Object localObject = Camera.class.getMethod("getNumberOfCameras", new Class[0]).invoke(null, (Object[]) null);
            if ((localObject == null) || (!TextUtils.isDigitsOnly(localObject.toString()))) {
                break label100;
            }
            i1 = Integer.parseInt(localObject.toString());
        } catch (Exception localException) {
            for (; ; ) {
                localException.printStackTrace();
                label100:
                int i1 = 0;
            }
        }
        d.c(new Object[]{" current device has " + i1 + " camera(s)"});
        return i1;
    }

    public void l() {
        if (this.k != null) {
            this.k.release();
            this.k = null;
        }
    }

    public void m() {
        this.p = false;
        if (this.k != null) {
            this.k.setPreviewCallback(null);
            this.k.stopPreview();
        }
    }

    void n() {
        try {
            Location localLocation = this.Y.getLastKnownLocation("gps");
            this.Y.requestLocationUpdates("gps", 1000L, 1.0F, this.ah, Looper.getMainLooper());
            if (localLocation != null) {
                a(localLocation);
            }
            localLocation = this.Y.getLastKnownLocation("network");
            this.Y.requestLocationUpdates("network", 1000L, 1.0F, this.ai, Looper.getMainLooper());
            if (localLocation != null) {
                a(localLocation);
            }
            return;
        } catch (Exception localException) {
            localException.printStackTrace();
        }
    }

    void o() {
        try {
            this.Y.removeUpdates(this.ah);
            this.Y.removeUpdates(this.ai);
            return;
        } catch (Exception localException) {
            localException.printStackTrace();
        }
    }

    protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        if (paramInt2 == -1) {
            if (paramInt1 != 1) {
                break label61;
            }
            paramIntent = paramIntent.getData();
            d.c(new Object[]{"uri:" + paramIntent});
            if (paramIntent != null) {
                break label55;
            }
        }
        label55:
        label61:
        while (paramInt1 != 2) {
            return;
            a(paramIntent);
            return;
        }
        d.c(new Object[]{"do original image."});
        Uri localUri = paramIntent.getData();
        paramIntent = paramIntent.getExtras();
        if ((localUri != null) && (paramIntent != null) && (paramIntent.containsKey("extra_fotor_session_id"))) {
            a(localUri, paramIntent.getString("extra_fotor_session_id"), paramIntent.getBoolean("extra_is_bitmap_changed"));
            return;
        }
        Toast.makeText(this, "Out put image is null", 1).show();
    }

    public void onBackPressed() {
        if (this.E.getVisibility() == 0) {
            u();
            this.Z.setDummyPopupView(null);
            return;
        }
        this.ac = true;
        super.onBackPressed();
    }

    public void onClick(View paramView) {
        switch (paramView.getId()) {
            case 2131558515:
            case 2131558516:
            case 2131558517:
            default:
                return;
            case 2131558520:
                if (this.E.getVisibility() != 0) {
                    this.Z.setDummyPopupView(this.E);
                }
                for (; ; ) {
                    u();
                    return;
                    this.Z.setDummyPopupView(null);
                }
            case 2131558519:
                e();
                return;
            case 2131558518:
                v();
                return;
            case 2131558514:
                this.ae.sendEmptyMessage(2);
                a("ToggleCamera");
                return;
        }
        paramView = new Intent(this, HomeActivity.class);
        paramView.setFlags(67108864);
        startActivity(paramView);
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        paramBundle = getIntent();
        if (paramBundle != null) {
            this.aa = paramBundle.getBooleanExtra("camera_show_home", false);
        }
        this.a.start();
        setContentView(2130903084);
        int i1 = a.e();
        r();
        b(i1);
        this.E.setCaptureMode(i1);
        this.e = new OrientationEventListener(this) {
            public void onOrientationChanged(int paramAnonymousInt) {
                if (paramAnonymousInt != -1) {
                    CameraActivity.c(CameraActivity.this, paramAnonymousInt);
                }
            }
        };
        try {
            this.z = new ToneGenerator(1, 100);
            this.Y = ((LocationManager) getSystemService("location"));
            this.B = ((SensorManager) getSystemService("sensor"));
            this.D = this.B.getDefaultSensor(1);
            this.C = new SensorEventListener() {
                private long b = 0L;
                private float c = 0.0F;
                private float d = 0.0F;
                private float e = 0.0F;

                public void onAccuracyChanged(Sensor paramAnonymousSensor, int paramAnonymousInt) {
                }

                public void onSensorChanged(SensorEvent paramAnonymousSensorEvent) {
                    float f1 = paramAnonymousSensorEvent.values[0];
                    float f2 = paramAnonymousSensorEvent.values[1];
                    float f3 = paramAnonymousSensorEvent.values[2];
                    CameraActivity.a(CameraActivity.this, Math.abs(f1 * f2 * f3));
                    if ((CameraActivity.h(CameraActivity.this)) && (CameraActivity.j(CameraActivity.this).a())) {
                        long l = System.currentTimeMillis();
                        if (l - this.b > 1000L) {
                            if ((Math.abs(this.c - f1) > 1.0F) || (Math.abs(this.d - f2) > 1.0F) || (Math.abs(this.e - f3) > 1.0F)) {
                                CameraActivity.a(CameraActivity.this, true);
                                CameraActivity.j(CameraActivity.this).a(CameraActivity.k(CameraActivity.this));
                                this.b = l;
                            }
                            this.c = f1;
                            this.d = f2;
                            this.e = f3;
                        }
                    }
                }
            };
        } catch (RuntimeException paramBundle) {
            try {
                this.a.join();
                j();
                return;
                paramBundle = paramBundle;
                d.c(new Object[]{c, "Exception caught while creating local tone generator: " + paramBundle});
                this.z = null;
            } catch (InterruptedException paramBundle) {
                for (; ; ) {
                    paramBundle.printStackTrace();
                }
            }
        }
    }

    protected void onDestroy() {
        if (this.z != null) {
            this.z.release();
        }
        super.onDestroy();
    }

    protected void onNewIntent(Intent paramIntent) {
        super.onNewIntent(paramIntent);
        if (this.aa) {
            setIntent(paramIntent);
        }
    }

    protected void onPause() {
        super.onPause();
        this.l.setVisibility(4);
        this.U = 1;
        this.Q = true;
        if (!this.G.a()) {
            a.a(this.F.getTime());
        }
        int i1;
        if ((this.q == 2) && (this.H.a())) {
            this.ae.removeCallbacks(this.H);
            this.i.setEnabled(true);
            this.e.disable();
            this.B.unregisterListener(this.C);
            if (!this.E.a()) {
                break label267;
            }
            i1 = this.R;
            label112:
            a.a(i1, this.w, this.y, this.q, this.E.a());
            if (this.j.getVisibility() != 0) {
                break label272;
            }
        }
        label267:
        label272:
        for (boolean bool = true; ; bool = false) {
            a.a(bool, false);
            l();
            o();
            if (this.ab != null) {
            }
            try {
                this.ab.dismiss();
                this.ab = null;
                return;
            } catch (Exception localException) {
                localException.printStackTrace();
            }
            if ((this.q == 4) && (this.G.a())) {
                this.ae.removeCallbacks(this.G);
                this.G.b();
                if (this.ac) {
                    break;
                }
                this.F.a(a.f());
                break;
            }
            if (this.q != 3) {
                break;
            }
            b.a(this.I, true);
            this.ae.removeCallbacks(this.I);
            break;
            i1 = 0;
            break label112;
        }
    }

    protected void onResume() {
        super.onResume();
        q();
        this.Q = false;
        this.e.enable();
        this.B.registerListener(this.C, this.D, 2);
        this.o.c();
        this.w = a.b();
        this.R = a.a();
        this.q = a.e();
        this.y = a.d();
        this.S = a.c();
        this.E.setGridEnable(a.a(false));
        this.ae.sendEmptyMessageDelayed(10, 50L);
        if (this.q == 4) {
            g();
        }
        for (; ; ) {
            if (this.m != null) {
                this.m.d();
            }
            d();
            n();
            if (SystemUtils.haveEnoughExternalStorage()) {
                break;
            }
            t();
            this.ad = true;
            return;
            if (this.q == 2) {
                g();
            }
        }
        this.ad = false;
    }

    protected void onStart() {
        super.onStart();
    }

    protected void onStop() {
        super.onStop();
        this.U = 1;
        this.l.setVisibility(4);
    }

    public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
        switch (paramView.getId()) {
        }
        do {
            do {
                return false;
            } while (paramMotionEvent.getAction() != 0);
            if ((this.W) && (this.p)) {
                e();
                return false;
            }
        } while ((this.U != 1) || (this.k == null) || (!this.p) || (!this.m.a()));
        paramView = (FrameLayout.LayoutParams) this.l.getLayoutParams();
        int i6 = this.l.getHeight();
        int i7 = this.l.getWidth();
        int i3 = (int) paramMotionEvent.getRawX();
        int i4 = (int) paramMotionEvent.getRawY();
        int i5 = i4 - i6 / 2;
        int i2 = i3 - i7 / 2;
        int i1;
        if (i2 < 0) {
            i1 = 0;
            if (i5 >= 0) {
                break label289;
            }
            i1 = 0;
        }
        for (; ; ) {
            d.c(new Object[]{"x = " + i3 + " y = " + i4});
            paramView.leftMargin = i1;
            paramView.topMargin = i5;
            paramView.gravity = 48;
            this.l.setLayoutParams(paramView);
            paramView = AnimationUtils.loadAnimation(getApplicationContext(), 2130968582);
            this.l.startAnimation(paramView);
            this.l.setVisibility(0);
            b();
            return true;
            i1 = i2;
            if (i2 <= DeviceUtils.getScreenWidth() - i7) {
                break;
            }
            i1 = DeviceUtils.getScreenWidth() - i7;
            break;
            label289:
            if (i5 > DeviceUtils.getScreenHeight() - i6) {
                i1 = DeviceUtils.getScreenHeight() - i6;
            }
        }
    }

    public void onTouchOutside(View paramView) {
        if ((paramView == this.E) && (this.E.getVisibility() == 0)) {
            u();
        }
        this.Z.setDummyPopupView(null);
    }

    public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {
        d.c(new Object[]{"surfaceChanged-------------------->>>>>>>"});
        if (paramSurfaceHolder.getSurface() == null) {
            d.c(new Object[]{c, "holder.getSurface() == null"});
        }
    }

    public void surfaceCreated(SurfaceHolder paramSurfaceHolder) {
        this.M = paramSurfaceHolder;
    }

    public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder) {
        m();
        l();
        this.M = null;
    }

    class a
            implements Runnable {
        private boolean b = false;

        a() {
        }

        public boolean a() {
            return this.b;
        }

        public void run() {
            this.b = true;
            if (Math.abs(CameraActivity.w(CameraActivity.this) - CameraActivity.x(CameraActivity.this)) > 1.0F) {
                CameraActivity.b(CameraActivity.this, CameraActivity.w(CameraActivity.this));
                CameraActivity.b(CameraActivity.this).postDelayed(this, 300L);
                return;
            }
            CameraActivity.v(CameraActivity.this);
            this.b = false;
        }
    }

    class b
            implements Runnable {
        private boolean b = false;

        b() {
        }

        public void run() {
            if (this.b) {
                CameraActivity.c(CameraActivity.this, true);
                return;
            }
            CameraActivity.b(CameraActivity.this).post(new Runnable() {
                public void run() {
                    CameraActivity.v(CameraActivity.this);
                }
            });
        }
    }

    class c
            extends AsyncTask<Void, Void, Bitmap> {
        c() {
        }

        /* Error */
        protected Bitmap a(Void... paramVarArgs) {
            // Byte code:
            //   0: invokestatic 29	com/everimaging/fotor/App:h	()Ljava/lang/String;
            //   3: astore_1
            //   4: aload_1
            //   5: aload_1
            //   6: ldc 31
            //   8: invokevirtual 37	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
            //   11: iconst_1
            //   12: iadd
            //   13: aload_1
            //   14: invokevirtual 41	java/lang/String:length	()I
            //   17: invokevirtual 45	java/lang/String:substring	(II)Ljava/lang/String;
            //   20: astore_1
            //   21: invokestatic 49	com/everimaging/fotor/camera/CameraActivity:p	()Lcom/everimaging/fotor/log/LoggerFactory$c;
            //   24: iconst_1
            //   25: anewarray 51	java/lang/Object
            //   28: dup
            //   29: iconst_0
            //   30: new 53	java/lang/StringBuilder
            //   33: dup
            //   34: invokespecial 54	java/lang/StringBuilder:<init>	()V
            //   37: ldc 56
            //   39: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   42: aload_1
            //   43: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   46: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
            //   49: aastore
            //   50: invokeinterface 68 2 0
            //   55: aload_0
            //   56: getfield 14	com/everimaging/fotor/camera/CameraActivity$c:a	Lcom/everimaging/fotor/camera/CameraActivity;
            //   59: invokevirtual 72	com/everimaging/fotor/camera/CameraActivity:getContentResolver	()Landroid/content/ContentResolver;
            //   62: getstatic 78	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
            //   65: aconst_null
            //   66: ldc 80
            //   68: iconst_1
            //   69: anewarray 33	java/lang/String
            //   72: dup
            //   73: iconst_0
            //   74: aload_1
            //   75: aastore
            //   76: ldc 82
            //   78: invokevirtual 88	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
            //   81: astore 7
            //   83: aload 7
            //   85: ifnull +286 -> 371
            //   88: aload 7
            //   90: invokeinterface 94 1 0
            //   95: ifeq +271 -> 366
            //   98: aload 7
            //   100: invokeinterface 97 1 0
            //   105: istore_2
            //   106: getstatic 103	java/lang/System:out	Ljava/io/PrintStream;
            //   109: new 53	java/lang/StringBuilder
            //   112: dup
            //   113: invokespecial 54	java/lang/StringBuilder:<init>	()V
            //   116: ldc 105
            //   118: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   121: iload_2
            //   122: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
            //   125: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
            //   128: invokevirtual 114	java/io/PrintStream:println	(Ljava/lang/String;)V
            //   131: aload 7
            //   133: aload 7
            //   135: ldc 116
            //   137: invokeinterface 119 2 0
            //   142: invokeinterface 123 2 0
            //   147: astore_1
            //   148: aload 7
            //   150: aload 7
            //   152: ldc 125
            //   154: invokeinterface 119 2 0
            //   159: invokeinterface 129 2 0
            //   164: lstore_3
            //   165: aload 7
            //   167: aload 7
            //   169: ldc -125
            //   171: invokeinterface 119 2 0
            //   176: invokeinterface 123 2 0
            //   181: astore 5
            //   183: aload_0
            //   184: getfield 14	com/everimaging/fotor/camera/CameraActivity$c:a	Lcom/everimaging/fotor/camera/CameraActivity;
            //   187: invokevirtual 72	com/everimaging/fotor/camera/CameraActivity:getContentResolver	()Landroid/content/ContentResolver;
            //   190: lload_3
            //   191: aload 5
            //   193: invokestatic 137	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
            //   196: invokevirtual 140	java/lang/Integer:intValue	()I
            //   199: i2l
            //   200: iconst_1
            //   201: aconst_null
            //   202: invokestatic 146	android/provider/MediaStore$Images$Thumbnails:getThumbnail	(Landroid/content/ContentResolver;JJILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
            //   205: astore 5
            //   207: aload 7
            //   209: aload 7
            //   211: ldc -108
            //   213: invokeinterface 119 2 0
            //   218: invokeinterface 152 2 0
            //   223: istore_2
            //   224: aload 5
            //   226: ifnonnull +65 -> 291
            //   229: aload_1
            //   230: aload_0
            //   231: getfield 14	com/everimaging/fotor/camera/CameraActivity$c:a	Lcom/everimaging/fotor/camera/CameraActivity;
            //   234: invokevirtual 156	com/everimaging/fotor/camera/CameraActivity:getResources	()Landroid/content/res/Resources;
            //   237: ldc -99
            //   239: invokevirtual 162	android/content/res/Resources:getDimensionPixelSize	(I)I
            //   242: aload_0
            //   243: getfield 14	com/everimaging/fotor/camera/CameraActivity$c:a	Lcom/everimaging/fotor/camera/CameraActivity;
            //   246: invokevirtual 156	com/everimaging/fotor/camera/CameraActivity:getResources	()Landroid/content/res/Resources;
            //   249: ldc -93
            //   251: invokevirtual 162	android/content/res/Resources:getDimensionPixelSize	(I)I
            //   254: iload_2
            //   255: invokestatic 168	com/everimaging/fotor/c/d:a	(Ljava/lang/String;III)Landroid/graphics/Bitmap;
            //   258: astore_1
            //   259: aload 7
            //   261: invokeinterface 171 1 0
            //   266: aload_1
            //   267: areturn
            //   268: astore_1
            //   269: getstatic 175	com/everimaging/fotor/App:e	Ljava/lang/String;
            //   272: astore_1
            //   273: ldc -79
            //   275: astore_1
            //   276: goto -255 -> 21
            //   279: astore 6
            //   281: aload 6
            //   283: invokevirtual 180	java/lang/Exception:printStackTrace	()V
            //   286: iconst_0
            //   287: istore_2
            //   288: goto -64 -> 224
            //   291: iload_2
            //   292: sipush 360
            //   295: irem
            //   296: ifeq +64 -> 360
            //   299: aload 5
            //   301: iload_2
            //   302: iconst_0
            //   303: iconst_0
            //   304: invokestatic 186	com/everimaging/fotorsdk/utils/BitmapUtils:rotateBitmap	(Landroid/graphics/Bitmap;IZZ)Landroid/graphics/Bitmap;
            //   307: astore 6
            //   309: aload 6
            //   311: astore_1
            //   312: aload 5
            //   314: aload 6
            //   316: if_acmpeq -57 -> 259
            //   319: aload 5
            //   321: invokevirtual 191	android/graphics/Bitmap:recycle	()V
            //   324: aload 6
            //   326: astore_1
            //   327: goto -68 -> 259
            //   330: astore_1
            //   331: aload 5
            //   333: astore 6
            //   335: aload_1
            //   336: astore 5
            //   338: aload 6
            //   340: astore_1
            //   341: aload 5
            //   343: invokevirtual 192	android/content/res/Resources$NotFoundException:printStackTrace	()V
            //   346: aload_1
            //   347: areturn
            //   348: astore 5
            //   350: aconst_null
            //   351: astore_1
            //   352: goto -11 -> 341
            //   355: astore 5
            //   357: goto -16 -> 341
            //   360: aload 5
            //   362: astore_1
            //   363: goto -104 -> 259
            //   366: aconst_null
            //   367: astore_1
            //   368: goto -109 -> 259
            //   371: aconst_null
            //   372: areturn
            // Local variable table:
            //   start	length	slot	name	signature
            //   0	373	0	this	c
            //   0	373	1	paramVarArgs	Void[]
            //   105	197	2	i	int
            //   164	27	3	l	long
            //   181	161	5	localObject1	Object
            //   348	1	5	localNotFoundException1	android.content.res.Resources.NotFoundException
            //   355	6	5	localNotFoundException2	android.content.res.Resources.NotFoundException
            //   279	3	6	localException	Exception
            //   307	32	6	localObject2	Object
            //   81	179	7	localCursor	android.database.Cursor
            // Exception table:
            //   from	to	target	type
            //   4	21	268	java/lang/Exception
            //   207	224	279	java/lang/Exception
            //   207	224	330	android/content/res/Resources$NotFoundException
            //   229	259	330	android/content/res/Resources$NotFoundException
            //   281	286	330	android/content/res/Resources$NotFoundException
            //   299	309	330	android/content/res/Resources$NotFoundException
            //   319	324	330	android/content/res/Resources$NotFoundException
            //   0	4	348	android/content/res/Resources$NotFoundException
            //   4	21	348	android/content/res/Resources$NotFoundException
            //   21	83	348	android/content/res/Resources$NotFoundException
            //   88	207	348	android/content/res/Resources$NotFoundException
            //   269	273	348	android/content/res/Resources$NotFoundException
            //   259	266	355	android/content/res/Resources$NotFoundException
        }

        protected void a(Bitmap paramBitmap) {
            super.onPostExecute(paramBitmap);
            CameraActivity.a(CameraActivity.this, paramBitmap);
            CameraActivity.this.a(paramBitmap);
        }
    }

    class d
            implements CameraFlashView.a {
        d() {
        }

        public void a(String paramString) {
            CameraActivity.b(CameraActivity.this, paramString);
            CameraActivity.this.h();
            HashMap localHashMap = new HashMap();
            localHashMap.put("Fotor_Camera_Flash_Mode", paramString);
            CameraActivity.a(CameraActivity.this, "Fotor_Camera_Flash_Mode", localHashMap);
        }
    }

    class e
            implements SeekBar.OnSeekBarChangeListener {
        e() {
        }

        public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean) {
            if (CameraActivity.z(CameraActivity.this) == null) {
            }
            Camera.Parameters localParameters;
            do {
                return;
                localParameters = CameraActivity.z(CameraActivity.this).getParameters();
            } while (!localParameters.isZoomSupported());
            localParameters.setZoom(localParameters.getMaxZoom() * paramInt / paramSeekBar.getMax());
            try {
                CameraActivity.z(CameraActivity.this).setParameters(localParameters);
                CameraActivity.a(CameraActivity.this, paramInt);
                return;
            } catch (Exception paramSeekBar) {
                localParameters.setZoom(0);
            }
        }

        public void onStartTrackingTouch(SeekBar paramSeekBar) {
        }

        public void onStopTrackingTouch(SeekBar paramSeekBar) {
        }
    }

    class f
            implements Runnable {
        private boolean b = false;

        f() {
        }

        public boolean a() {
            return this.b;
        }

        public void b() {
            this.b = false;
        }

        public void run() {
            this.b = true;
            CameraActivity.u(CameraActivity.this).b();
            if (CameraActivity.u(CameraActivity.this).getTime() > 0) {
                CameraActivity.b(CameraActivity.this).postDelayed(this, 1000L);
                return;
            }
            App.f.post(new Runnable() {
                public void run() {
                    CameraActivity.u(CameraActivity.this).c();
                }
            });
            CameraActivity.v(CameraActivity.this);
            this.b = false;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotor/camera/CameraActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */