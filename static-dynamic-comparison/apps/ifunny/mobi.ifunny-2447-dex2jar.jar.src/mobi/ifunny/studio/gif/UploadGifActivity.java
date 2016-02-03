package mobi.ifunny.studio.gif;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ab;
import android.support.v4.app.af;
import android.support.v4.app.ag;
import android.support.v4.app.q;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

import mobi.ifunny.e.c;
import mobi.ifunny.f;
import mobi.ifunny.studio.crop.free.FreeCropImageActivity;
import mobi.ifunny.studio.publish.PublishGifActivity;
import mobi.ifunny.util.a.b;
import mobi.ifunny.util.an;
import mobi.ifunny.view.ProgressBar;

public class UploadGifActivity
        extends f
        implements ag<File>, View.OnClickListener {
    private static final String y = l.class.getSimpleName();
    private Uri o;
    private Uri p;
    private ImageView q;
    private ProgressBar r;
    private View s;
    private mobi.ifunny.video.a t;
    private Rect u;
    private int v;
    private int w;
    private Handler x;

    private void a(Uri paramUri) {
        if (this.t != null) {
            this.q.setImageDrawable(null);
            this.t.b(false);
            this.t.d();
            this.t = null;
        }
        Intent localIntent = new Intent(this, PublishGifActivity.class);
        localIntent.setData(paramUri);
        localIntent.putExtra("INTENT_EXTRA_CROP", this.u);
        startActivityForResult(localIntent, 10);
    }

    private void a(File paramFile) {
        long l = paramFile.length();
        Point localPoint = b.a(paramFile);
        if ((l > 10485760L) || (localPoint.x > this.v) || (localPoint.y > this.w)) {
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
        this.q.setImageDrawable(null);
        this.q.setVisibility(4);
        this.r.setVisibility(4);
        this.s.setVisibility(0);
        Toast.makeText(this, paramInt, 0).show();
        this.x.post(new k(this));
    }

    private void b(Uri paramUri) {
        Intent localIntent = new Intent(this, FreeCropImageActivity.class);
        localIntent.setData(paramUri);
        localIntent.putExtra("INTENT_CROP_GIFS", true);
        startActivityForResult(localIntent, 20);
    }

    private void b(File paramFile) {
        try {
            this.t = new mobi.ifunny.video.a(paramFile, this.u);
            this.q.setImageDrawable(this.t);
            this.t.start();
            this.q.setVisibility(0);
            this.r.setVisibility(4);
            this.s.setVisibility(4);
            return;
        } catch (UnsatisfiedLinkError paramFile) {
            this.t = null;
            b(2131689610);
            return;
        } catch (Exception paramFile) {
            this.t = null;
            b(2131690122);
        }
    }

    private void p() {
        this.q.setImageDrawable(null);
        this.q.setVisibility(4);
        this.r.setVisibility(0);
        this.s.setVisibility(4);
        if (this.t != null) {
            this.t.d();
        }
    }

    private void q() {
        p();
        g().a(0, null, this);
    }

    public void a(android.support.v4.a.l<File> paraml, File paramFile) {
        if (paramFile == null) {
            b(2131690122);
            return;
        }
        a(paramFile);
    }

    protected void n() {
        q localq = f();
        l locall = (l) localq.a(y);
        if (locall != null) {
            locall.b();
            localq.b();
        }
        locall = new l();
        ab localab = localq.a();
        localab.a(locall, y);
        localab.c();
        localq.b();
    }

    protected void o() {
        q localq = f();
        l locall = (l) localq.a(y);
        if (locall != null) {
            locall.b();
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
                                return;
                            } while ((paramInt2 != -1) || (paramIntent == null));
                            paramIntent = an.a(paramIntent);
                        } while (paramIntent == null);
                        o();
                        b(paramIntent);
                        return;
                    } while ((paramInt2 != -1) || (paramIntent == null));
                    paramIntent = an.a(paramIntent);
                } while (paramIntent == null);
                o();
                b(paramIntent);
                return;
            } while (paramInt2 != -1);
            finish();
            return;
            if ((paramInt2 == -1) && (paramIntent != null)) {
                this.o = paramIntent.getData();
                this.u = ((Rect) paramIntent.getParcelableExtra("INTENT_CROP_RECT"));
                o();
                a(new File(an.b(this.o)));
                return;
            }
        } while (this.o != null);
        n();
    }

    public void onClick(View paramView) {
        switch (paramView.getId()) {
            default:
                return;
        }
        n();
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(2130903177);
        h().a(true);
        this.q = ((ImageView) findViewById(2131493343));
        this.r = ((ProgressBar) findViewById(2131493137));
        this.s = findViewById(2131493138);
        ((TextView) this.s.findViewById(2131493139)).setText(2131690123);
        this.x = new Handler();
        Resources localResources = getResources();
        this.v = localResources.getDimensionPixelSize(2131427489);
        this.w = localResources.getDimensionPixelSize(2131427488);
        if (paramBundle == null) {
            paramBundle = getIntent().getExtras();
            if (paramBundle != null) {
                this.o = ((Uri) paramBundle.getParcelable("state.loader.uri"));
            }
        }
    }

    public android.support.v4.a.l<File> onCreateLoader(int paramInt, Bundle paramBundle) {
        return new c(this, this.o);
    }

    public boolean onCreateOptionsMenu(Menu paramMenu) {
        getMenuInflater().inflate(2131820567, paramMenu);
        return super.onCreateOptionsMenu(paramMenu);
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.t != null) {
            this.t.d();
        }
    }

    public void onLoaderReset(android.support.v4.a.l<File> paraml) {
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
            default:
                return super.onOptionsItemSelected(paramMenuItem);
        }
        if ((this.p == null) || (this.t == null)) {
            b(2131690122);
            return true;
        }
        a(this.p);
        return true;
    }

    protected void onPostCreate(Bundle paramBundle) {
        super.onPostCreate(paramBundle);
        if (this.o == null) {
            n();
            return;
        }
        if (this.p == null) {
            q();
            return;
        }
        b(new File(an.b(this.p)));
    }

    protected void onRestoreInstanceState(Bundle paramBundle) {
        super.onRestoreInstanceState(paramBundle);
        this.o = ((Uri) paramBundle.getParcelable("state.loader.uri"));
        this.p = ((Uri) paramBundle.getParcelable("state.gif.file.uri"));
        this.u = ((Rect) paramBundle.getParcelable("state.crop.rect"));
    }

    protected void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        paramBundle.putParcelable("state.loader.uri", this.o);
        paramBundle.putParcelable("state.gif.file.uri", this.p);
        paramBundle.putParcelable("state.crop.rect", this.u);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/gif/UploadGifActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */