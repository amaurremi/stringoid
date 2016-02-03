package mobi.ifunny.studio.gif;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.a.l;
import android.support.v4.app.ab;
import android.support.v4.app.af;
import android.support.v4.app.ag;
import android.support.v4.app.q;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

import java.io.File;

import mobi.ifunny.rest.content.WebImage;
import mobi.ifunny.studio.crop.free.FreeCropImageActivity;
import mobi.ifunny.studio.publish.PublishGifCaptionActivity;
import mobi.ifunny.util.a.b;
import mobi.ifunny.util.aj;
import mobi.ifunny.util.an;
import mobi.ifunny.view.ImageViewEx;
import mobi.ifunny.view.ProgressBar;

public class GifCaptionActivity
        extends mobi.ifunny.l.a
        implements ag<File> {
    private static final String B = i.class.getSimpleName();
    private g A;
    @InjectView(2131493133)
    View captionEditor;
    @InjectView(2131493136)
    SeekBar gifSpeedSeek;
    @InjectView(2131493137)
    ProgressBar imageProgress;
    @InjectView(2131493032)
    ImageViewEx imageView;
    private Uri o;
    private Uri p;
    private Rect q;
    private mobi.ifunny.video.a r;
    private int s = 3;
    private float t = 1.0F;
    @InjectView(2131493138)
    View textFrame;
    @InjectView(2131493033)
    EditText titleEditor;
    private float u = 1.0F;
    private int v;
    private int w = this.s;
    private int x;
    private int y;
    private Handler z;

    private void a(Bitmap paramBitmap, String paramString) {
        a(this.p, paramBitmap, paramString);
    }

    private void a(Uri paramUri) {
        Intent localIntent = new Intent(this, FreeCropImageActivity.class);
        localIntent.setData(paramUri);
        localIntent.putExtra("INTENT_CROP_GIFS", true);
        startActivityForResult(localIntent, 20);
    }

    private void a(Uri paramUri, Bitmap paramBitmap, String paramString) {
        if (this.r != null) {
            this.imageView.setImageDrawable(null);
            this.r.b(false);
            this.r.d();
            this.r = null;
        }
        Intent localIntent = new Intent(this, PublishGifCaptionActivity.class);
        localIntent.setData(paramUri);
        localIntent.putExtra("INTENT_EXTRA_CAPTION_TEXT", paramString);
        localIntent.putExtra("INTENT_EXTRA_SCALE", this.u);
        localIntent.putExtra("INTENT_EXTRA_CROP", this.q);
        PublishGifCaptionActivity.v = paramBitmap;
        startActivityForResult(localIntent, 10);
    }

    private void a(File paramFile) {
        long l = paramFile.length();
        Point localPoint = b.a(paramFile);
        if ((l > 10485760L) || (localPoint.x > this.x) || (localPoint.y > this.y)) {
            b(2131690129);
            return;
        }
        Resources localResources = getResources();
        int i = localResources.getDimensionPixelSize(2131427491);
        int j = localResources.getDimensionPixelSize(2131427490);
        if ((localPoint.x < i) || (localPoint.y < j)) {
            b(2131690061);
            return;
        }
        this.p = Uri.fromFile(paramFile);
        b(paramFile);
    }

    private void b(int paramInt) {
        p();
        this.o = null;
        this.p = null;
        Toast.makeText(this, paramInt, 0).show();
        this.z.post(new e(this));
    }

    private void b(File paramFile) {
        try {
            this.r = new mobi.ifunny.video.a(paramFile, this.q);
            float f = this.r.getIntrinsicWidth() / this.A.e();
            this.A.a(f);
            this.imageView.setUpscaleRatioLimit(this.v);
            this.imageView.getViewTreeObserver().addOnGlobalLayoutListener(new f(this));
            this.imageView.setImageDrawable(this.r);
            this.r.a(this.u);
            this.r.start();
            this.captionEditor.setVisibility(0);
            this.imageProgress.setVisibility(4);
            this.textFrame.setVisibility(4);
            return;
        } catch (UnsatisfiedLinkError paramFile) {
            this.r = null;
            b(2131689610);
            return;
        } catch (Exception paramFile) {
            this.r = null;
            b(2131690122);
        }
    }

    private void p() {
        this.imageView.setImageDrawable(null);
        this.captionEditor.setVisibility(4);
        this.imageProgress.setVisibility(4);
        this.textFrame.setVisibility(0);
    }

    private void q() {
        Toast.makeText(this, 2131690052, 0).show();
        n();
    }

    private void r() {
        this.imageView.setImageDrawable(null);
        this.captionEditor.setVisibility(4);
        this.imageProgress.setVisibility(0);
        this.textFrame.setVisibility(4);
        if (this.r != null) {
            this.r.d();
        }
    }

    private void s() {
        r();
        g().a(0, null, this);
    }

    private void t() {
        Toast.makeText(this, 2131690047, 1).show();
    }

    private void u() {
        q localq = f();
        if ((android.support.v4.app.g) localq.a("DIALOG_LOADING") == null) {
            mobi.ifunny.fragment.h.a(this, new String[]{"TASK_CREATE_CAPTION"}).a(f(), "DIALOG_LOADING");
            localq.b();
        }
    }

    private void v() {
        q localq = f();
        android.support.v4.app.g localg = (android.support.v4.app.g) localq.a("DIALOG_LOADING");
        if (localg != null) {
            localg.b();
            localq.b();
        }
    }

    public void a(l<File> paraml, File paramFile) {
        if (paramFile == null) {
            b(2131690122);
            return;
        }
        a(paramFile);
    }

    protected void n() {
        q localq = f();
        i locali = (i) localq.a(B);
        if (locali != null) {
            locali.b();
            localq.b();
        }
        locali = new i();
        ab localab = localq.a();
        localab.a(locali, B);
        localab.c();
        localq.b();
    }

    protected void o() {
        q localq = f();
        i locali = (i) localq.a(B);
        if (locali != null) {
            locali.b();
            localq.b();
        }
    }

    protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        switch (paramInt1) {
            default:
                super.onActivityResult(paramInt1, paramInt2, paramIntent);
        }
        do {
            do {
                do {
                    do {
                        do {
                            do {
                                do {
                                    do {
                                        return;
                                    } while ((paramInt2 != -1) || (paramIntent == null));
                                    paramIntent = an.a(paramIntent);
                                } while (paramIntent == null);
                                o();
                                a(paramIntent);
                                return;
                            } while ((paramInt2 != -1) || (paramIntent == null));
                            paramIntent = an.a(paramIntent);
                        } while (paramIntent == null);
                        o();
                        a(paramIntent);
                        return;
                    } while ((paramInt2 != -1) || (paramIntent == null));
                    paramIntent = (WebImage) paramIntent.getParcelableExtra("intent.web_image");
                } while (paramIntent == null);
                paramIntent = Uri.parse(paramIntent.url);
                o();
                a(paramIntent);
                return;
                if ((paramInt2 == -1) && (paramIntent != null)) {
                    this.o = paramIntent.getData();
                    this.q = ((Rect) paramIntent.getParcelableExtra("INTENT_CROP_RECT"));
                    o();
                    a(new File(an.b(this.o)));
                    return;
                }
            } while (this.o != null);
            n();
            return;
        } while (paramInt2 != -1);
        finish();
    }

    @OnClick({2131493138, 2131493032})
    public void onClick() {
        n();
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(2130903120);
        ButterKnife.inject(this);
        h().a(true);
        this.gifSpeedSeek.setMax(7);
        this.gifSpeedSeek.setOnSeekBarChangeListener(new c(this));
        this.gifSpeedSeek.setProgress(this.s);
        ((TextView) ButterKnife.findById(this.textFrame, 2131493139)).setText(2131690123);
        this.A = new g(null);
        this.A.a(Typeface.createFromAsset(getAssets(), getString(2131689578)));
        paramBundle = getResources();
        this.x = paramBundle.getDimensionPixelSize(2131427489);
        this.y = paramBundle.getDimensionPixelSize(2131427488);
        this.v = paramBundle.getInteger(2131558412);
        Object localObject = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics) localObject);
        float f = this.v;
        this.v = ((int) (((DisplayMetrics) localObject).density * 0.75F * f));
        localObject = new Rect();
        ((Rect) localObject).left = paramBundle.getDimensionPixelSize(2131427427);
        ((Rect) localObject).right = paramBundle.getDimensionPixelSize(2131427428);
        ((Rect) localObject).top = paramBundle.getDimensionPixelSize(2131427429);
        ((Rect) localObject).bottom = paramBundle.getDimensionPixelSize(2131427426);
        this.A.a((Rect) localObject);
        localObject = new Point();
        ((Point) localObject).x = paramBundle.getDimensionPixelSize(2131427433);
        ((Point) localObject).y = paramBundle.getDimensionPixelSize(2131427432);
        this.A.a((Point) localObject);
        this.A.c(paramBundle.getColor(2131361841));
        this.A.b(paramBundle.getColor(2131361842));
        this.A.a(paramBundle.getDimensionPixelSize(2131427431));
        this.A.d(paramBundle.getDimensionPixelSize(2131427430));
        this.titleEditor.setTypeface(this.A.a());
        this.titleEditor.getBackground().setLevel(1);
        this.titleEditor.setFilters(aj.a(getResources().getInteger(2131558404)));
        this.titleEditor.addTextChangedListener(new d(this));
        getWindow().setSoftInputMode(3);
        this.z = new Handler();
        paramBundle = getIntent().getExtras();
        if (paramBundle != null) {
            this.o = ((Uri) paramBundle.getParcelable("state.loader.uri"));
        }
    }

    public l<File> onCreateLoader(int paramInt, Bundle paramBundle) {
        return new mobi.ifunny.e.c(this, this.o);
    }

    public boolean onCreateOptionsMenu(Menu paramMenu) {
        getMenuInflater().inflate(2131820567, paramMenu);
        return super.onCreateOptionsMenu(paramMenu);
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.r != null) {
            this.r.d();
        }
    }

    public void onLoaderReset(l<File> paraml) {
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
            default:
                return super.onOptionsItemSelected(paramMenuItem);
        }
        if (this.r == null) {
            q();
            return true;
        }
        if (this.p == null) {
            b(2131690122);
            return true;
        }
        paramMenuItem = this.titleEditor.getText().toString().trim();
        if (TextUtils.isEmpty(paramMenuItem)) {
            Toast.makeText(this, 2131690053, 0).show();
            return true;
        }
        if (!e("TASK_CREATE_CAPTION")) {
            this.r.stop();
            new h(this, "TASK_CREATE_CAPTION", paramMenuItem, this.r.getIntrinsicWidth(), this.A, null).execute(new Void[0]);
        }
        return true;
    }

    protected void onPostResume() {
        super.onPostResume();
        if (this.o == null) {
            n();
        }
        while (this.r != null) {
            return;
        }
        if (this.p == null) {
            s();
            return;
        }
        b(new File(this.p.getPath()));
    }

    protected void onRestoreInstanceState(Bundle paramBundle) {
        super.onRestoreInstanceState(paramBundle);
        this.o = ((Uri) paramBundle.getParcelable("state.loader.uri"));
        this.p = ((Uri) paramBundle.getParcelable("state.gif.file.uri"));
        this.w = paramBundle.getInt("STATE_SCALE_PROGRESS");
        this.q = ((Rect) paramBundle.getParcelable("STATE_CROP_RECT"));
        this.gifSpeedSeek.setProgress(this.w);
    }

    protected void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        paramBundle.putParcelable("state.loader.uri", this.o);
        paramBundle.putParcelable("state.gif.file.uri", this.p);
        paramBundle.putInt("STATE_SCALE_PROGRESS", this.w);
        paramBundle.putParcelable("STATE_CROP_RECT", this.q);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/gif/GifCaptionActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */