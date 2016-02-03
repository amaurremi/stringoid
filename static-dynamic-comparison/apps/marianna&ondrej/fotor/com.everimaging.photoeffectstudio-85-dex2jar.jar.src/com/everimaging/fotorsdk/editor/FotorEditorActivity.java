package com.everimaging.fotorsdk.editor;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore.Images.Media;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v8.renderscript.RenderScript;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.everimaging.fotorsdk.FotorSDKInitiator;
import com.everimaging.fotorsdk.app.FotorAlertDialog;
import com.everimaging.fotorsdk.app.FotorAlertDialog.a;
import com.everimaging.fotorsdk.engine.a;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;
import com.everimaging.fotorsdk.store.h;
import com.everimaging.fotorsdk.utils.DeviceUtils;
import com.everimaging.fotorsdk.utils.FotorCommonDirUtils;
import com.everimaging.fotorsdk.utils.ImageSize;
import com.everimaging.fotorsdk.utils.LoadImageTask;
import com.everimaging.fotorsdk.utils.LoadImageTask.OnLoadImageListener;
import com.everimaging.fotorsdk.utils.PackageManagerUtils;
import com.everimaging.fotorsdk.widget.FotorFlipperBarContainer;
import com.everimaging.fotorsdk.widget.FotorImageView;
import com.everimaging.fotorsdk.widget.FotorLockEventView;
import com.everimaging.fotorsdk.widget.FotorTitleBackButton;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

public class FotorEditorActivity
        extends com.everimaging.fotorsdk.engine.b
        implements View.OnClickListener, FotorMainController.a, FotorMainController.b, FotorMainController.c, a, LoadImageTask.OnLoadImageListener {
    private static final String a = FotorEditorActivity.class.getSimpleName();
    private static FotorLoggerFactory.c b = FotorLoggerFactory.a(a, FotorLoggerFactory.LoggerType.CONSOLE);
    private a A;
    private List<String> B;
    private LoadImageTask C;
    private int D;
    private View E;
    private boolean F;
    private Drawable G;
    private Handler H = new Handler() {
        public void handleMessage(Message paramAnonymousMessage) {
            switch (paramAnonymousMessage.what) {
                case 1:
                case 5:
                default:
                    return;
                case 0:
                    FotorEditorActivity.a(FotorEditorActivity.this).setVisibility(8);
                    FotorEditorActivity.b(FotorEditorActivity.this).setVisibility(8);
                    return;
                case 2:
                    FotorEditorActivity.c(FotorEditorActivity.this).setVisibility(0);
                    return;
                case 3:
                    FotorEditorActivity.a(FotorEditorActivity.this).setVisibility(0);
                    FotorEditorActivity.b(FotorEditorActivity.this).setVisibility(0);
                    return;
            }
            FotorEditorActivity.c(FotorEditorActivity.this).setVisibility(8);
        }
    };
    private View.OnClickListener I = new View.OnClickListener() {
        public void onClick(View paramAnonymousView) {
            if (paramAnonymousView == FotorEditorActivity.a(FotorEditorActivity.this)) {
                FotorEditorActivity.d(FotorEditorActivity.this).f();
            }
            while (paramAnonymousView != FotorEditorActivity.b(FotorEditorActivity.this)) {
                return;
            }
            FotorEditorActivity.d(FotorEditorActivity.this).h();
        }
    };
    private FotorImageView c;
    private LinearLayout d;
    private FotorFlipperBarContainer e;
    private FotorFlipperBarContainer f;
    private FrameLayout g;
    private FrameLayout h;
    private FrameLayout i;
    private FrameLayout j;
    private FrameLayout k;
    private FotorLockEventView l;
    private FotorMainController m;
    private ImageButton n;
    private FotorTitleBackButton o;
    private ImageButton p;
    private ImageButton q;
    private String r;
    private String s;
    private Uri t;
    private Uri u;
    private int v;
    private int w;
    private boolean x = true;
    private boolean y = false;
    private boolean z = false;

    static {
        System.loadLibrary("fotor_sdk_editor");
    }

    private Uri a(Intent paramIntent) {
        b.b(new Object[]{"handleIntent"});
        Bundle localBundle = null;
        Object localObject = localBundle;
        if (paramIntent != null) {
            localObject = localBundle;
            if (paramIntent.getData() != null) {
                localObject = paramIntent.getData();
                this.t = ((Uri) localObject);
                b.f(new Object[]{"intent data:" + localObject});
                localBundle = paramIntent.getExtras();
                if (localBundle != null) {
                    if (localBundle.containsKey("extra_fotor_session_id")) {
                        this.s = localBundle.getString("extra_fotor_session_id");
                    }
                    if (localBundle.containsKey("extra_output_path")) {
                        this.u = ((Uri) localBundle.getParcelable("extra_output_path"));
                    }
                    this.v = localBundle.getInt("extra_output_quality", 90);
                    this.w = localBundle.getInt("extra_max_preview_size", Math.max(DeviceUtils.getScreenWidth(), DeviceUtils.getScreenHeight()));
                    if (localBundle.containsKey("extra_feature_list")) {
                        this.B = Arrays.asList(localBundle.getStringArray("extra_feature_list"));
                    }
                    if (localBundle.containsKey("extra_hide_discard_alert")) {
                        this.x = localBundle.getBoolean("extra_hide_discard_alert", true);
                    }
                    if (localBundle.containsKey("extra_save_on_no_changes")) {
                        this.y = localBundle.getBoolean("extra_save_on_no_changes", false);
                    }
                    if (localBundle.containsKey("extra_store_enable")) {
                        this.z = localBundle.getBoolean("extra_store_enable", false);
                    }
                }
                b(paramIntent);
            }
        }
        return (Uri) localObject;
    }

    private void a(int paramInt, Intent paramIntent) {
        if ((paramIntent != null) && (this.f != null)) {
            paramIntent.putExtra("extra_fotor_session_id", this.s);
            paramIntent.putExtra("extra_is_bitmap_changed", this.m.i());
        }
        setResult(paramInt, paramIntent);
    }

    private void a(Uri paramUri) {
        if (this.C != null) {
            this.C.setOnLoadListener(null);
            this.C = null;
        }
        this.C = new LoadImageTask(this, paramUri, this.w);
        this.C.setOnLoadListener(this);
        this.C.execute(new Void[0]);
    }

    private void b(Intent paramIntent) {
        b.c(new Object[]{"======printBundle======="});
        this.s = paramIntent.getStringExtra("extra_fotor_session_id");
        b.c(new Object[]{"mFotorSessionId:" + this.s});
        this.u = ((Uri) paramIntent.getParcelableExtra("extra_output_path"));
        b.c(new Object[]{"    mOutputPath:" + this.u});
        this.v = paramIntent.getIntExtra("extra_output_quality", 90);
        b.c(new Object[]{"  mImageQuality:" + this.v});
        this.w = paramIntent.getIntExtra("extra_max_preview_size", Math.max(DeviceUtils.getScreenWidth(), DeviceUtils.getScreenHeight()));
        b.c(new Object[]{"mMaxPreviewSize:" + this.w});
    }

    private void v() {
        File localFile1 = new File(FotorCommonDirUtils.getWorkspacePath());
        File localFile2 = new File(localFile1, "mosaic");
        if (!localFile2.exists()) {
            localFile2.mkdirs();
        }
        b.c(new Object[]{"initFiles,workspaceDir:" + localFile1});
        this.r = localFile2.getAbsolutePath();
    }

    private void w() {
        b.b(new Object[]{"setupViews"});
        this.c = ((FotorImageView) findViewById(R.id.fotor_imageView));
        this.d = ((LinearLayout) findViewById(R.id.fotor_headerContainer));
        this.e = ((FotorFlipperBarContainer) findViewById(R.id.fotor_main_header_text_container));
        this.f = ((FotorFlipperBarContainer) findViewById(R.id.fotor_footerContainer));
        this.h = ((FrameLayout) findViewById(R.id.fotor_operation_tool_layer));
        this.i = ((FrameLayout) findViewById(R.id.fotor_image_top_layer));
        this.g = ((FrameLayout) findViewById(R.id.fotor_feature_draw_panel_container));
        this.j = ((FrameLayout) findViewById(R.id.fotor_content_layer));
        this.k = ((FrameLayout) findViewById(R.id.fotor_screen_top_layer));
        this.l = ((FotorLockEventView) findViewById(R.id.fotor_lock_event_view));
        this.E = findViewById(R.id.fotor_main_loading_view);
        this.n = ((ImageButton) findViewById(R.id.fotor_main_apply));
        this.n.setOnClickListener(this);
        this.o = ((FotorTitleBackButton) this.e.getSecondView());
        this.o.setOnClickListener(this);
        this.p = ((ImageButton) findViewById(R.id.fotor_main_btn_undo));
        this.p.setEnabled(false);
        this.p.setOnClickListener(this.I);
        this.q = ((ImageButton) findViewById(R.id.fotor_main_btn_redo));
        this.q.setEnabled(false);
        this.q.setOnClickListener(this.I);
    }

    private boolean x() {
        if ((this.m != null) && (this.m.i()) && (this.x)) {
            y();
            return true;
        }
        return false;
    }

    private void y() {
        b.c(new Object[]{"showSaveAlert"});
        FotorAlertDialog localFotorAlertDialog = FotorAlertDialog.a();
        localFotorAlertDialog.setCancelable(true);
        Object localObject = new Bundle();
        ((Bundle) localObject).putCharSequence("TITLE", getText(R.string.fotor_dialog_alert_title_save));
        ((Bundle) localObject).putCharSequence("MESSAGE", getText(R.string.fotor_dialog_alert_message_save));
        ((Bundle) localObject).putCharSequence("POSITIVE_BUTTON_TEXT", getText(R.string.fotor_dialog_alert_positive_save));
        ((Bundle) localObject).putCharSequence("NEGATIVE_BUTTON_TEXT", getText(R.string.fotor_dialog_alert_negative_save));
        localFotorAlertDialog.setArguments((Bundle) localObject);
        localObject = getSupportFragmentManager().beginTransaction();
        ((FragmentTransaction) localObject).setTransition(4099);
        localFotorAlertDialog.a(new FotorAlertDialog.a() {
            public void a(FotorAlertDialog paramAnonymousFotorAlertDialog) {
                if (FotorEditorActivity.d(FotorEditorActivity.this) != null) {
                    FotorEditorActivity.d(FotorEditorActivity.this).d();
                }
            }

            public void b(FotorAlertDialog paramAnonymousFotorAlertDialog) {
                FotorEditorActivity.this.a(FotorEditorActivity.d(FotorEditorActivity.this));
            }

            public void c(FotorAlertDialog paramAnonymousFotorAlertDialog) {
            }
        });
        localFotorAlertDialog.show((FragmentTransaction) localObject, "Save");
    }

    private void z() {
        Animation localAnimation = AnimationUtils.loadAnimation(this, 17432577);
        localAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation paramAnonymousAnimation) {
                FotorEditorActivity.e(FotorEditorActivity.this).setVisibility(8);
            }

            public void onAnimationRepeat(Animation paramAnonymousAnimation) {
            }

            public void onAnimationStart(Animation paramAnonymousAnimation) {
            }
        });
        this.E.startAnimation(localAnimation);
    }

    public FotorFlipperBarContainer a() {
        return this.e;
    }

    public void a(Bitmap paramBitmap) {
        this.c.setImageBitmap(paramBitmap);
    }

    public void a(FotorMainController paramFotorMainController) {
        setResult(0, null);
        finish();
    }

    public void a(FotorMainController paramFotorMainController, Bitmap paramBitmap) {
        Object localObject3 = null;
        Object localObject2 = null;
        if ((paramFotorMainController == null) || ((!paramFotorMainController.i()) && (!this.y)) || (paramBitmap == null)) {
            a(paramFotorMainController);
            return;
        }
        Uri localUri = this.u;
        if (localUri != null) {
            b.c(new Object[]{"do Save to the output uri:" + localUri});
            if (localUri.getScheme() != null) {
            }
        }
        for (; ; ) {
            try {
                localObject1 = new FileOutputStream(localUri.getPath());
                if (localObject1 != null) {
                    localObject2 = localObject1;
                    localObject3 = localObject1;
                    paramBitmap.compress(Bitmap.CompressFormat.JPEG, this.v, (OutputStream) localObject1);
                }
                com.everimaging.fotorsdk.uil.utils.b.a((Closeable) localObject1);
                paramFotorMainController = localUri;
            } catch (Exception paramBitmap) {
                Object localObject1;
                localObject3 = localObject2;
                b.e(new Object[]{"Cannot open file", localUri, paramBitmap});
                localObject3 = localObject2;
                a(paramFotorMainController);
                com.everimaging.fotorsdk.uil.utils.b.a((Closeable) localObject2);
                paramFotorMainController = localUri;
                continue;
            } finally {
                com.everimaging.fotorsdk.uil.utils.b.a((Closeable) localObject3);
            }
            paramBitmap = new Intent();
            paramBitmap.setData(paramFotorMainController);
            a(-1, paramBitmap);
            finish();
            return;
            localObject1 = getContentResolver().openOutputStream(localUri);
            continue;
            paramBitmap = MediaStore.Images.Media.insertImage(getContentResolver(), paramBitmap, "title", "modified with Fotor SDK");
            b.c(new Object[]{"output uri isn't declared ,and auto created uri is:" + paramBitmap});
            paramFotorMainController = localUri;
            if (paramBitmap != null) {
                paramFotorMainController = Uri.parse(paramBitmap);
                getContentResolver().notifyChange(paramFotorMainController, null);
            }
        }
    }

    public void a(boolean paramBoolean1, boolean paramBoolean2) {
        this.p.setEnabled(paramBoolean1);
        this.q.setEnabled(paramBoolean2);
    }

    public FotorTitleBackButton b() {
        return this.o;
    }

    public FotorFlipperBarContainer c() {
        return this.f;
    }

    public FrameLayout d() {
        return (FrameLayout) this.f.getFirstView();
    }

    public FrameLayout e() {
        return (FrameLayout) this.f.getSecondView();
    }

    public FrameLayout f() {
        return this.h;
    }

    public void finish() {
        FotorCommonDirUtils.cleanTemporaryDir();
        super.finish();
    }

    public Context g() {
        return this;
    }

    public FotorImageView h() {
        return this.c;
    }

    public FrameLayout i() {
        return this.i;
    }

    public FrameLayout j() {
        return this.g;
    }

    public String k() {
        return this.r;
    }

    public String l() {
        return this.s;
    }

    public Uri m() {
        return this.t;
    }

    public int n() {
        return this.v;
    }

    public LinearLayout o() {
        return this.d;
    }

    protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        if (this.m != null) {
            this.m.a(paramInt1, paramInt2, paramIntent);
        }
        super.onActivityResult(paramInt2, paramInt1, paramIntent);
    }

    public void onBackPressed() {
        if ((!this.m.b()) && (!x())) {
            super.onBackPressed();
        }
    }

    public void onClick(View paramView) {
        if (this.F) {
        }
        do {
            return;
            if (paramView == this.n) {
                this.m.d();
                return;
            }
        } while (paramView != this.o);
        this.m.c();
    }

    public void onConfigurationChanged(Configuration paramConfiguration) {
        super.onConfigurationChanged(paramConfiguration);
        b.c(new Object[]{"onConfigurationChanged:" + paramConfiguration});
        if (this.D != paramConfiguration.orientation) {
            DeviceUtils.init(this);
            this.c.postInvalidate();
            if (this.m != null) {
                this.m.a(paramConfiguration);
            }
        }
        this.D = paramConfiguration.orientation;
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        b.f(new Object[]{"onCreate:false"});
        h.a(this);
        setContentView(R.layout.fotor_main);
        getWindow().setSoftInputMode(32);
        v();
        w();
        paramBundle = a(getIntent());
        if (paramBundle == null) {
            setResult(0);
            finish();
            return;
        }
        this.m = new FotorMainController(this, this.H);
        this.m.a(PackageManagerUtils.getApikey(this), this.B);
        this.m.a(this);
        this.m.a(this);
        this.m.a(this);
        this.A = new a();
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("fotor.android.intent.ACTION_PLUGIN_ADDED");
        localIntentFilter.addAction("fotor.android.intent.ACTION_PLUGIN_REMOVED");
        localIntentFilter.addAction("fotor.android.intent.ACTION_PLUGIN_REPLACED");
        registerReceiver(this.A, localIntentFilter);
        a(paramBundle);
    }

    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.A);
        if (this.m != null) {
            this.m.m();
        }
        h.b(this);
    }

    @SuppressLint({"NewApi"})
    public void onLoadComplete(Bitmap paramBitmap, Drawable paramDrawable, ImageSize paramImageSize) {
        b.c(new Object[]{"on load source bitmap completion"});
        this.C = null;
        this.G = paramDrawable;
        this.c.setImageBitmap(paramBitmap);
        this.c.setVisibility(0);
        paramDrawable = AnimationUtils.loadAnimation(this, 17432576);
        this.c.startAnimation(paramDrawable);
        if (this.G != null) {
            if (Build.VERSION.SDK_INT <= 16) {
                break label112;
            }
            this.g.setBackground(this.G);
        }
        for (; ; ) {
            this.g.startAnimation(paramDrawable);
            this.m.a(paramBitmap);
            z();
            this.F = false;
            return;
            label112:
            this.g.setBackgroundDrawable(this.G);
        }
    }

    public void onLoadError(String paramString) {
        b.e(new Object[]{"on load source bitmap error:" + paramString});
        this.C = null;
        z();
        this.F = false;
    }

    public void onLoadStart() {
        b.c(new Object[]{"on load source bitmap start"});
        this.c.setVisibility(4);
        this.E.setVisibility(0);
        this.F = true;
    }

    protected void onPause() {
        super.onPause();
        com.everimaging.fotorsdk.engine.d.a(this, 0);
        if (this.m != null) {
            this.m.j();
        }
    }

    protected void onResume() {
        super.onResume();
        com.everimaging.fotorsdk.engine.d.a(this, 4);
        if (this.m != null) {
            this.m.k();
        }
    }

    protected void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
    }

    protected void onStart() {
        super.onStart();
        this.D = getResources().getConfiguration().orientation;
    }

    protected void onStop() {
        super.onStop();
    }

    public FrameLayout p() {
        return this.k;
    }

    public FragmentActivity q() {
        return this;
    }

    public RenderScript r() {
        return FotorSDKInitiator.a();
    }

    public com.everimaging.fotorsdk.algorithms.filter.d s() {
        return FotorSDKInitiator.b();
    }

    public boolean t() {
        return this.z;
    }

    class a
            extends BroadcastReceiver {
        a() {
        }

        public void onReceive(Context paramContext, Intent paramIntent) {
            FotorEditorActivity.u().c(new Object[]{"PluginChangedReceiver->onReceive:" + paramIntent});
            if ((FotorEditorActivity.d(FotorEditorActivity.this) != null) && (paramIntent != null)) {
                Bundle localBundle = paramIntent.getExtras();
                if ((localBundle != null) && (localBundle.containsKey("APPLICATION_CONTEXT")) && (localBundle.getString("APPLICATION_CONTEXT").equals(paramContext.getApplicationContext().getPackageName()))) {
                    FotorEditorActivity.d(FotorEditorActivity.this).a(paramIntent);
                }
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/editor/FotorEditorActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */