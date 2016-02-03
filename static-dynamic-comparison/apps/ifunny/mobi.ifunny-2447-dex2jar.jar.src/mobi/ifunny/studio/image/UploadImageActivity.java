package mobi.ifunny.studio.image;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.af;
import android.support.v4.app.ag;
import android.support.v4.app.q;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

import mobi.ifunny.fragment.i;
import mobi.ifunny.fragment.k;
import mobi.ifunny.rest.content.MemeSource;
import mobi.ifunny.studio.crop.free.FreeCropImageActivity;
import mobi.ifunny.studio.publish.PublishImageActivity;
import mobi.ifunny.util.a.a;
import mobi.ifunny.util.a.d;
import mobi.ifunny.view.ProgressBar;
import mobi.ifunny.view.v;

public class UploadImageActivity
        extends mobi.ifunny.f
        implements ag<d>, View.OnClickListener, k {
    private Uri o;
    private ImageView p;
    private ProgressBar q;
    private View r;

    private void a(Uri paramUri) {
        Intent localIntent = new Intent(this, FreeCropImageActivity.class);
        localIntent.setData(paramUri);
        startActivityForResult(localIntent, 0);
    }

    private void n() {
        Toast.makeText(this, 2131689964, 0).show();
        p();
    }

    private void o() {
        Intent localIntent = new Intent(this, PublishImageActivity.class);
        localIntent.setData(this.o);
        startActivityForResult(localIntent, 1);
    }

    private void p() {
        q localq = f();
        Object localObject = (i) localq.a("dialog.pick");
        if (localObject != null) {
            ((i) localObject).b();
            localq.b();
        }
        localObject = new ArrayList();
        ((ArrayList) localObject).add(Integer.valueOf(0));
        i.a((ArrayList) localObject, 0, 2131690132).a(f(), "dialog.pick");
        localq.b();
    }

    private void q() {
        q localq = f();
        i locali = (i) localq.a("dialog.pick");
        if (locali != null) {
            locali.b();
            localq.b();
        }
    }

    private void r() {
        this.p.setImageDrawable(null);
        this.p.setVisibility(4);
        this.q.setVisibility(0);
        this.r.setVisibility(4);
    }

    private void s() {
        r();
        g().b(0, null, this);
    }

    public void a(int paramInt) {
    }

    public void a(int paramInt1, int paramInt2, Uri paramUri) {
        a(paramUri);
    }

    public void a(int paramInt, MemeSource paramMemeSource) {
    }

    public void a(android.support.v4.a.l<d> paraml, d paramd) {
        if (paramd == null) {
            this.p.setImageDrawable(null);
            this.p.setVisibility(4);
            this.q.setVisibility(4);
            this.r.setVisibility(0);
            return;
        }
        this.p.setImageDrawable(new mobi.ifunny.view.drawable.f(paramd));
        this.p.setVisibility(0);
        this.q.setVisibility(4);
        this.r.setVisibility(4);
    }

    protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        switch (paramInt1) {
            default:
                super.onActivityResult(paramInt1, paramInt2, paramIntent);
        }
        do {
            do {
                return;
            } while (paramInt2 != -1);
            this.o = paramIntent.getData();
            q();
            s();
            return;
        } while (paramInt2 != -1);
        finish();
    }

    public void onClick(View paramView) {
        switch (paramView.getId()) {
            default:
                return;
        }
        p();
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(2130903177);
        this.p = ((ImageView) findViewById(2131493343));
        this.q = ((ProgressBar) findViewById(2131493137));
        this.q.setMode(v.a);
        this.r = findViewById(2131493138);
        if (paramBundle != null) {
            this.o = ((Uri) paramBundle.getParcelable("state.image.uri"));
        }
        do {
            do {
                return;
                paramBundle = getIntent().getExtras();
            } while (paramBundle == null);
            paramBundle = (Uri) paramBundle.getParcelable("export.image.uri");
        } while ((paramBundle == null) || (TextUtils.isEmpty(paramBundle.getPath())));
        a(paramBundle);
    }

    public android.support.v4.a.l<d> onCreateLoader(int paramInt, Bundle paramBundle) {
        paramBundle = new a(null, false);
        return new mobi.ifunny.e.l(this, true, this.o, paramBundle);
    }

    public boolean onCreateOptionsMenu(Menu paramMenu) {
        getMenuInflater().inflate(2131820567, paramMenu);
        return super.onCreateOptionsMenu(paramMenu);
    }

    public void onLoaderReset(android.support.v4.a.l<d> paraml) {
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
            default:
                return super.onOptionsItemSelected(paramMenuItem);
        }
        if (this.o == null) {
            n();
            return true;
        }
        if (this.p.getDrawable() == null) {
            n();
            return true;
        }
        o();
        return true;
    }

    protected void onPostCreate(Bundle paramBundle) {
        super.onPostCreate(paramBundle);
        if (this.o == null) {
            p();
            return;
        }
        s();
    }

    protected void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        paramBundle.putParcelable("state.image.uri", this.o);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/image/UploadImageActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */