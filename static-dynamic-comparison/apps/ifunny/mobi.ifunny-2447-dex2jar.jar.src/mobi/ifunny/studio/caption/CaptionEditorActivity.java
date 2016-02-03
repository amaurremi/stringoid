package mobi.ifunny.studio.caption;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.af;
import android.support.v4.app.ag;
import android.support.v4.app.g;
import android.support.v4.app.q;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

import java.util.ArrayList;

import mobi.ifunny.fragment.h;
import mobi.ifunny.fragment.i;
import mobi.ifunny.fragment.k;
import mobi.ifunny.rest.content.MemeSource;
import mobi.ifunny.studio.crop.free.FreeCropImageActivity;
import mobi.ifunny.studio.publish.PublishDraftActivity;
import mobi.ifunny.util.aj;
import mobi.ifunny.util.r;
import mobi.ifunny.view.FitImageView;
import mobi.ifunny.view.drawable.f;

public class CaptionEditorActivity
        extends mobi.ifunny.l.a
        implements ag<mobi.ifunny.util.a.d>, View.OnClickListener, k {
    public static mobi.ifunny.studio.a.a o;
    private static final String p = CaptionEditorActivity.class.getSimpleName();
    private static final String s = e.class.getSimpleName();
    @InjectView(2131493031)
    ScrollView container;
    @InjectView(2131493035)
    View imagePlaceholder;
    @InjectView(2131493034)
    View imageProgress;
    @InjectView(2131493032)
    FitImageView imageView;
    private String q;
    private Uri r;
    @InjectView(2131493033)
    EditText titleEditor;

    private void a(Uri paramUri) {
        q();
        Bundle localBundle = new Bundle();
        localBundle.putParcelable("loader.image.uri", paramUri);
        g().b(0, localBundle, this);
    }

    private void a(byte[] paramArrayOfByte) {
        q();
        Bundle localBundle = new Bundle();
        localBundle.putByteArray("loader.image.data", paramArrayOfByte);
        g().a(0, localBundle, this);
    }

    private void b(Uri paramUri) {
        Intent localIntent = new Intent(this, FreeCropImageActivity.class);
        localIntent.setData(paramUri);
        startActivityForResult(localIntent, 0);
    }

    private void q() {
        this.imageView.setImageDrawable(null);
        this.imageView.setVisibility(4);
        this.titleEditor.setVisibility(4);
        this.imageProgress.setVisibility(0);
        this.imagePlaceholder.setVisibility(4);
    }

    private void r() {
        q localq = f();
        Object localObject = (i) localq.a("dialog.pick");
        if (localObject != null) {
            ((i) localObject).b();
            localq.b();
        }
        localObject = new ArrayList();
        ((ArrayList) localObject).add(Integer.valueOf(0));
        ((ArrayList) localObject).add(Integer.valueOf(4));
        i.a((ArrayList) localObject, 0, 2131689969).a(f(), "dialog.pick");
        localq.b();
    }

    private void s() {
        q localq = f();
        i locali = (i) localq.a("dialog.pick");
        if (locali != null) {
            locali.b();
            localq.b();
        }
    }

    private void t() {
        Object localObject = (f) this.imageView.getDrawable();
        if (localObject == null) {
            u();
            return;
        }
        mobi.ifunny.util.a.d locald = ((f) localObject).e();
        if (locald == null) {
            u();
            return;
        }
        Resources localResources = getResources();
        int i = localResources.getDimensionPixelSize(2131427497);
        int j = localResources.getDimensionPixelSize(2131427496);
        if ((((f) localObject).getIntrinsicWidth() < i) || (((f) localObject).getIntrinsicHeight() < j)) {
            v();
            return;
        }
        localObject = this.titleEditor.getText().toString().trim();
        if (TextUtils.isEmpty((CharSequence) localObject)) {
            w();
            return;
        }
        new e(this, locald, this.imageView.getWidth(), this.imageView.getHeight(), r.a((String) localObject), this.titleEditor.getTextSize()).execute(new Void[0]);
    }

    private void u() {
        Toast.makeText(this, 2131689964, 0).show();
        r();
    }

    private void v() {
        Toast.makeText(this, 2131689972, 0).show();
    }

    private void w() {
        Toast.makeText(this, 2131689965, 0).show();
    }

    public void a(int paramInt) {
    }

    public void a(int paramInt1, int paramInt2, Uri paramUri) {
        switch (paramInt2) {
            default:
                return;
        }
        b(paramUri);
    }

    public void a(int paramInt, MemeSource paramMemeSource) {
    }

    public void a(android.support.v4.a.l<mobi.ifunny.util.a.d> paraml, mobi.ifunny.util.a.d paramd) {
        if (paramd == null) {
            this.imageView.setImageDrawable(null);
            this.imageView.setVisibility(4);
            this.titleEditor.setVisibility(4);
            this.imageProgress.setVisibility(4);
            this.imagePlaceholder.setVisibility(0);
            return;
        }
        this.imageView.setVisibility(0);
        this.titleEditor.setVisibility(0);
        this.imageView.setImageDrawable(new f(paramd));
        this.imageProgress.setVisibility(4);
        this.imagePlaceholder.setVisibility(4);
        this.container.post(new d(this));
    }

    protected void a(byte[] paramArrayOfByte, mobi.ifunny.studio.a.a parama) {
        PublishDraftActivity.v = parama;
        PublishDraftActivity.w = paramArrayOfByte;
        paramArrayOfByte = new Intent(this, PublishDraftActivity.class);
        paramArrayOfByte.putExtra("arg.draft.id", this.q);
        startActivityForResult(paramArrayOfByte, 1);
    }

    protected void n() {
        if ((g) f().a("dialog.progress") == null) {
            h.a(this, new String[]{s}).a(f(), "dialog.progress");
        }
    }

    protected void o() {
        g localg = (g) f().a("dialog.progress");
        if (localg != null) {
            localg.a();
        }
    }

    protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        switch (paramInt1) {
            default:
                super.onActivityResult(paramInt1, paramInt2, paramIntent);
        }
        do {
            return;
            if ((paramInt2 == -1) && (paramIntent != null)) {
                paramIntent = paramIntent.getData();
                s();
                this.r = paramIntent;
                a(paramIntent);
                return;
            }
        } while (paramInt2 != -1);
        finish();
    }

    @OnClick({2131493030, 2131493032})
    public void onClick(View paramView) {
        r();
    }

    protected void onCreate(Bundle paramBundle) {
        int i = 1;
        super.onCreate(paramBundle);
        setContentView(2130903071);
        ButterKnife.inject(this);
        Object localObject = Typeface.createFromAsset(getAssets(), getString(2131689882));
        this.titleEditor.setTypeface((Typeface) localObject);
        this.titleEditor.getBackground().setLevel(1);
        this.titleEditor.setFilters(aj.a(getResources().getInteger(2131558404)));
        this.titleEditor.addTextChangedListener(new c(this));
        this.q = getIntent().getStringExtra("intent.draft.id");
        if (this.q != null) {
            String str = p;
            StringBuilder localStringBuilder = new StringBuilder().append("Launched in ");
            if (i == 0) {
                break label186;
            }
            localObject = "UPDATE";
            label137:
            mobi.ifunny.d.c(str, (String) localObject + " mode");
            if ((i == 0) || (o != null)) {
                break label193;
            }
            mobi.ifunny.d.e(p, "Draft is null in update mode");
            finish();
        }
        label186:
        label193:
        do {
            do {
                return;
                i = 0;
                break;
                localObject = "ADD";
                break label137;
                if (paramBundle != null) {
                    this.r = ((Uri) paramBundle.getParcelable("state.capture.uri"));
                    return;
                }
                paramBundle = getIntent().getExtras();
            } while (paramBundle == null);
            paramBundle = (Uri) paramBundle.getParcelable("export.image.uri");
        } while ((paramBundle == null) || (TextUtils.isEmpty(paramBundle.getPath())));
        b(paramBundle);
    }

    public android.support.v4.a.l<mobi.ifunny.util.a.d> onCreateLoader(int paramInt, Bundle paramBundle) {
        mobi.ifunny.util.a.a locala = new mobi.ifunny.util.a.a(null, false);
        byte[] arrayOfByte = paramBundle.getByteArray("loader.image.data");
        if (arrayOfByte != null) {
            return new mobi.ifunny.e.b(this, arrayOfByte, locala);
        }
        paramBundle = (Uri) paramBundle.getParcelable("loader.image.uri");
        if (paramBundle != null) {
            return new mobi.ifunny.e.l(this, true, paramBundle, locala);
        }
        return null;
    }

    public boolean onCreateOptionsMenu(Menu paramMenu) {
        getMenuInflater().inflate(2131820545, paramMenu);
        return super.onCreateOptionsMenu(paramMenu);
    }

    public void onLoaderReset(android.support.v4.a.l<mobi.ifunny.util.a.d> paraml) {
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
            default:
                return super.onOptionsItemSelected(paramMenuItem);
        }
        t();
        return true;
    }

    protected void onPostCreate(Bundle paramBundle) {
        super.onPostCreate(paramBundle);
        if (o == null) {
            if (this.r == null) {
                r();
                return;
            }
            a(this.r);
            return;
        }
        if (TextUtils.equals(o.a.a, "caption")) {
            paramBundle = (mobi.ifunny.studio.a.a.a) o.b;
            this.titleEditor.setText(paramBundle.a);
            paramBundle = paramBundle.b;
            o = null;
            a(paramBundle);
            return;
        }
        throw new IllegalStateException();
    }

    protected void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        paramBundle.putParcelable("state.capture.uri", this.r);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/caption/CaptionEditorActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */