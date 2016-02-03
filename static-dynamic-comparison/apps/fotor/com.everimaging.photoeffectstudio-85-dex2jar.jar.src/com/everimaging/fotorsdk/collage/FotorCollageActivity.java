package com.everimaging.fotorsdk.collage;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore.Images.Media;
import android.support.v4.app.FragmentActivity;
import android.support.v8.renderscript.RenderScript;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.everimaging.fotorsdk.FotorSDKInitiator;
import com.everimaging.fotorsdk.algorithms.filter.d;
import com.everimaging.fotorsdk.collage.widget.CollageSwitchMaskView;
import com.everimaging.fotorsdk.imagepicker.ImagePickerActivity;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;
import com.everimaging.fotorsdk.store.h;
import com.everimaging.fotorsdk.widget.FotorTitleBackButton;

import java.io.Closeable;
import java.io.FileOutputStream;
import java.io.IOException;

public class FotorCollageActivity
        extends com.everimaging.fotorsdk.engine.b
        implements View.OnClickListener, FotorCollageController.a, FotorCollageController.b, c {
    private static final String a = FotorCollageActivity.class.getSimpleName();
    private static FotorLoggerFactory.c b = FotorLoggerFactory.a(a, FotorLoggerFactory.LoggerType.CONSOLE);
    private FotorTitleBackButton c;
    private ImageButton d;
    private LinearLayout e;
    private FrameLayout f;
    private FrameLayout g;
    private FrameLayout h;
    private FrameLayout i;
    private CollageSwitchMaskView j;
    private FrameLayout k;
    private FotorCollageController l;
    private boolean m;
    private String n;
    private Uri o;
    private int p;
    private Handler q = new Handler();

    private void a(int paramInt, Intent paramIntent) {
        if (paramIntent != null) {
            paramIntent.putExtra("extra_fotor_session_id", this.n);
        }
        setResult(paramInt, paramIntent);
    }

    private void a(Intent paramIntent) {
        b.b(new Object[]{"handleIntent"});
        if (paramIntent != null) {
            paramIntent = paramIntent.getExtras();
            if (paramIntent != null) {
                if (paramIntent.containsKey("extra_fotor_session_id")) {
                    this.n = paramIntent.getString("extra_fotor_session_id");
                }
                if (paramIntent.containsKey("extra_output_path")) {
                    this.o = ((Uri) paramIntent.getParcelable("extra_output_path"));
                }
                this.p = paramIntent.getInt("extra_output_quality", 90);
                if (paramIntent.containsKey("extra_store_enable")) {
                    this.m = paramIntent.getBoolean("extra_store_enable", false);
                }
            }
        }
    }

    private void n() {
        this.c = ((FotorTitleBackButton) findViewById(R.id.fotor_collage_title));
        this.c.setOnClickListener(this);
        this.d = ((ImageButton) findViewById(R.id.fotor_collage_apply));
        this.d.setOnClickListener(this);
        this.f = ((FrameLayout) findViewById(R.id.fotor_collage_edit_area_container));
        this.g = ((FrameLayout) findViewById(R.id.fotor_collage_tools_container));
        this.h = ((FrameLayout) findViewById(R.id.fotor_collage_top_layer));
        this.k = ((FrameLayout) findViewById(R.id.fotor_collage_operation_container));
        this.e = ((LinearLayout) findViewById(R.id.fotor_collage_main_layer));
        this.i = ((FrameLayout) findViewById(R.id.fotor_collage_main_progress_layer));
        this.j = ((CollageSwitchMaskView) findViewById(R.id.fotor_collage_switch_mask_view));
    }

    public Context a() {
        return this;
    }

    public void a(FotorCollageController paramFotorCollageController) {
        setResult(0, null);
        finish();
    }

    public void a(FotorCollageController paramFotorCollageController, int paramInt) {
        paramFotorCollageController = new Intent(this, ImagePickerActivity.class);
        paramFotorCollageController.putExtra("extra_in_selection", paramInt);
        startActivityForResult(paramFotorCollageController, 2);
    }

    public void a(FotorCollageController paramFotorCollageController, Bitmap paramBitmap) {
        Object localObject = null;
        FotorCollageController localFotorCollageController = null;
        Uri localUri = this.o;
        if (localUri != null) {
            b.c(new Object[]{"do Save to the output uri:" + localUri});
            if (localUri.getScheme() != null) {
            }
        }
        for (; ; ) {
            try {
                paramFotorCollageController = new FileOutputStream(localUri.getPath());
                if (paramFotorCollageController != null) {
                    localFotorCollageController = paramFotorCollageController;
                    localObject = paramFotorCollageController;
                    paramBitmap.compress(Bitmap.CompressFormat.JPEG, this.p, paramFotorCollageController);
                }
                com.everimaging.fotorsdk.uil.utils.b.a(paramFotorCollageController);
                paramFotorCollageController = localUri;
            } catch (IOException paramFotorCollageController) {
                localObject = localFotorCollageController;
                b.e(new Object[]{"Cannot open file", localUri, paramFotorCollageController});
                com.everimaging.fotorsdk.uil.utils.b.a(localFotorCollageController);
                paramFotorCollageController = localUri;
                continue;
            } finally {
                com.everimaging.fotorsdk.uil.utils.b.a((Closeable) localObject);
            }
            paramBitmap = new Intent();
            paramBitmap.setData(paramFotorCollageController);
            a(-1, paramBitmap);
            finish();
            return;
            paramFotorCollageController = getContentResolver().openOutputStream(localUri);
            continue;
            paramBitmap = MediaStore.Images.Media.insertImage(getContentResolver(), paramBitmap, "title", "modified with Fotor SDK");
            b.c(new Object[]{"output uri isn't declared ,and auto created uri is:" + paramBitmap});
            paramFotorCollageController = localUri;
            if (paramBitmap != null) {
                paramFotorCollageController = Uri.parse(paramBitmap);
                getContentResolver().notifyChange(paramFotorCollageController, null);
            }
        }
    }

    public LinearLayout b() {
        return this.e;
    }

    public FrameLayout c() {
        return this.f;
    }

    public FrameLayout d() {
        return this.g;
    }

    public FrameLayout e() {
        return this.h;
    }

    public FrameLayout f() {
        return this.k;
    }

    public String g() {
        return this.n;
    }

    public FragmentActivity h() {
        return this;
    }

    public RenderScript i() {
        return FotorSDKInitiator.a();
    }

    public d j() {
        return FotorSDKInitiator.b();
    }

    public FrameLayout k() {
        return this.i;
    }

    public CollageSwitchMaskView l() {
        return this.j;
    }

    public boolean m() {
        return this.m;
    }

    protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        b.c(new Object[]{"onActivityResult:" + paramInt2 + ",requestCode:" + paramInt1});
        if (this.l.a(paramInt1, paramInt2, paramIntent)) {
            return;
        }
        switch (paramInt2) {
        }
        for (; ; ) {
            super.onActivityResult(paramInt2, paramInt1, paramIntent);
            return;
            if (paramInt1 == 2) {
                this.l.k();
            }
        }
    }

    public void onBackPressed() {
        if ((this.l != null) && (this.l.b())) {
            return;
        }
        super.onBackPressed();
    }

    public void onClick(View paramView) {
        if (paramView == this.c) {
            this.l.d();
        }
        while (paramView != this.d) {
            return;
        }
        this.l.c();
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        a(getIntent());
        b.c(new Object[]{"onCreate bundle:" + paramBundle});
        b.a(this);
        h.a(this);
        setContentView(R.layout.fotor_collage_main);
        n();
        this.l = new FotorCollageController(this, this.q);
        this.l.a();
        this.l.a(this);
        this.l.a(this);
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.l != null) {
            this.l.j();
        }
        h.b(this);
        System.gc();
    }

    protected void onPause() {
        super.onPause();
        if (this.l != null) {
            this.l.i();
        }
    }

    protected void onResume() {
        super.onResume();
        if (this.l != null) {
            this.l.h();
        }
    }

    protected void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
    }

    protected void onStart() {
        super.onStart();
    }

    protected void onStop() {
        super.onStop();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/collage/FotorCollageActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */