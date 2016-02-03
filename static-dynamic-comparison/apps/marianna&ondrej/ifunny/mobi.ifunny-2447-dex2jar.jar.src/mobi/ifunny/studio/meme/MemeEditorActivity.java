package mobi.ifunny.studio.meme;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.af;
import android.support.v4.app.ag;
import android.support.v4.app.g;
import android.support.v4.app.q;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Toast;

import java.util.ArrayList;

import mobi.ifunny.fragment.h;
import mobi.ifunny.fragment.i;
import mobi.ifunny.fragment.k;
import mobi.ifunny.rest.content.MemeSource;
import mobi.ifunny.studio.crop.free.FreeCropImageActivity;
import mobi.ifunny.studio.publish.PublishDraftActivity;
import mobi.ifunny.util.aj;
import mobi.ifunny.util.r;
import mobi.ifunny.view.drawable.f;

public class MemeEditorActivity
        extends mobi.ifunny.l.a
        implements ag<mobi.ifunny.util.a.d>, View.OnClickListener, View.OnFocusChangeListener, SeekBar.OnSeekBarChangeListener, k {
    private static final String F = e.class.getSimpleName();
    public static mobi.ifunny.studio.a.a o;
    private static final String p = MemeEditorActivity.class.getSimpleName();
    private ScrollView A;
    private View B;
    private int C;
    private volatile int D;
    private volatile int E;
    private String q;
    private String r;
    private String s;
    private MemeFitImageView t;
    private View u;
    private View v;
    private EditText w;
    private EditText x;
    private View y;
    private SeekBar z;

    private void D() {
        Toast.makeText(this, 2131690068, 0).show();
    }

    private int a(float paramFloat) {
        int i = this.z.getMax();
        if (paramFloat >= 70.0F) {
            return i;
        }
        if (paramFloat <= 20.0F) {
            return 0;
        }
        paramFloat = (paramFloat - 20.0F) / 50.0F;
        return (int) (i * paramFloat);
    }

    private void a(Uri paramUri) {
        Intent localIntent = new Intent(this, FreeCropImageActivity.class);
        localIntent.setData(paramUri);
        startActivityForResult(localIntent, 0);
    }

    private void a(String paramString, byte[] paramArrayOfByte) {
        r();
        paramString = c(paramString, paramArrayOfByte);
        g().a(0, paramString, this);
    }

    private float b(int paramInt) {
        return this.C + paramInt * 2;
    }

    private void b(String paramString, byte[] paramArrayOfByte) {
        r();
        paramString = c(paramString, paramArrayOfByte);
        g().b(0, paramString, this);
    }

    private Bundle c(String paramString, byte[] paramArrayOfByte) {
        if (paramString == null) {
        }
        for (paramString = null; ; paramString = Uri.parse(paramString)) {
            Bundle localBundle = new Bundle();
            localBundle.putParcelable("loader.image.uri", paramString);
            localBundle.putByteArray("loader.image.data", paramArrayOfByte);
            return localBundle;
        }
    }

    private void c(int paramInt) {
        float f = b(paramInt);
        if (this.w.isFocused()) {
            this.w.setTextSize(f);
        }
        for (; ; ) {
            this.t.postInvalidate();
            return;
            if (this.x.isFocused()) {
                this.x.setTextSize(f);
            }
        }
    }

    private void p() {
        this.y.setVisibility(4);
    }

    private void q() {
        if (this.w.isFocused()) {
            this.y.setVisibility(0);
        }
        while (!this.x.isFocused()) {
            return;
        }
        this.y.setVisibility(0);
    }

    private void r() {
        this.t.setImageBitmap(null);
        this.t.setVisibility(4);
        this.u.setVisibility(0);
        this.v.setVisibility(4);
    }

    private void s() {
        if ((this.D == -1) && (this.E == -1)) {
            this.z.setProgress(10);
            this.D = 10;
            this.E = 10;
        }
    }

    private void t() {
        float f = b(this.D);
        this.w.setTextSize(f);
        f = b(this.E);
        this.x.setTextSize(f);
        this.t.postInvalidate();
    }

    private void u() {
        q localq = f();
        Object localObject = (i) localq.a("dialog.pick");
        if (localObject != null) {
            ((i) localObject).b();
            localq.b();
        }
        localObject = new ArrayList();
        ((ArrayList) localObject).add(Integer.valueOf(6));
        ((ArrayList) localObject).add(Integer.valueOf(0));
        ((ArrayList) localObject).add(Integer.valueOf(4));
        i.a((ArrayList) localObject, 0, 2131690065).a(f(), "dialog.pick");
        localq.b();
    }

    private void v() {
        q localq = f();
        i locali = (i) localq.a("dialog.pick");
        if (locali != null) {
            locali.b();
            localq.b();
        }
    }

    private void w() {
        Toast.makeText(this, 2131690067, 0).show();
        u();
    }

    public void a(int paramInt) {
    }

    public void a(int paramInt1, int paramInt2, Uri paramUri) {
        switch (paramInt2) {
            default:
                return;
        }
        a(paramUri);
    }

    public void a(int paramInt, MemeSource paramMemeSource) {
        if ((TextUtils.isEmpty(this.w.getText())) && (TextUtils.isEmpty(this.x.getText()))) {
            this.w.setText(paramMemeSource.top_label);
            this.x.setText(paramMemeSource.bottom_label);
        }
        b(paramMemeSource.url, null);
    }

    public void a(android.support.v4.a.l<mobi.ifunny.util.a.d> paraml, mobi.ifunny.util.a.d paramd) {
        if (paramd == null) {
            this.t.setImageDrawable(null);
            this.t.setVisibility(4);
            this.u.setVisibility(4);
            this.v.setVisibility(0);
            return;
        }
        this.t.setImageDrawable(new f(paramd));
        this.t.setVisibility(0);
        this.w.setVisibility(0);
        this.x.setVisibility(0);
        s();
        t();
        this.u.setVisibility(4);
        this.v.setVisibility(4);
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
            h.a(this, new String[]{F, "task.content.add_update_meme"}).a(f(), "dialog.progress");
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
            do {
                return;
            } while (paramInt2 != -1);
            paramIntent = paramIntent.getData();
            v();
            b(paramIntent.toString(), null);
            return;
        } while (paramInt2 != -1);
        finish();
    }

    public void onClick(View paramView) {
        switch (paramView.getId()) {
            case 2131493173:
            case 2131493174:
            case 2131493175:
            case 2131493176:
            default:
                return;
        }
        this.t.requestFocus();
        u();
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(2130903133);
        this.E = -1;
        this.D = -1;
        this.t = ((MemeFitImageView) findViewById(2131493172));
        this.u = findViewById(2131493176);
        this.v = findViewById(2131493177);
        this.A = ((ScrollView) findViewById(2131493170));
        this.A.setPersistentDrawingCache(2);
        this.A.setDrawingCacheEnabled(true);
        Object localObject1 = aj.a(getResources().getInteger(2131558417));
        Object localObject2 = Typeface.createFromAsset(getAssets(), getString(2131689578));
        this.w = ((EditText) findViewById(2131493173));
        this.w.setOnFocusChangeListener(this);
        this.w.setFilters((InputFilter[]) localObject1);
        this.w.addTextChangedListener(new a(this));
        this.w.setTypeface((Typeface) localObject2);
        this.w.getBackground().setLevel(1);
        this.t.setTitleView(this.w);
        this.x = ((EditText) findViewById(2131493174));
        this.x.setOnFocusChangeListener(this);
        this.x.setFilters((InputFilter[]) localObject1);
        this.x.addTextChangedListener(new b(this));
        this.x.setTypeface((Typeface) localObject2);
        this.x.getBackground().setLevel(1);
        this.t.setSubtitleView(this.x);
        this.y = findViewById(2131493178);
        this.z = ((SeekBar) findViewById(2131493179));
        this.z.setOnSeekBarChangeListener(this);
        this.q = getIntent().getStringExtra("intent.draft.id");
        int i;
        StringBuilder localStringBuilder;
        if (this.q != null) {
            i = 1;
            localObject2 = p;
            localStringBuilder = new StringBuilder().append("Launched in ");
            if (i == 0) {
                break label405;
            }
        }
        label405:
        for (localObject1 = "UPDATE"; ; localObject1 = "ADD") {
            mobi.ifunny.d.c((String) localObject2, (String) localObject1 + " mode");
            if ((i == 0) || (o != null)) {
                break label412;
            }
            mobi.ifunny.d.e(p, "Draft is null in update mode");
            finish();
            return;
            i = 0;
            break;
        }
        label412:
        if (paramBundle != null) {
            this.r = paramBundle.getString("state.src.id");
            this.s = paramBundle.getString("state.src.url");
        }
        for (; ; ) {
            this.C = ((int) getResources().getDimension(2131427442));
            this.B = findViewById(2131493169);
            this.B.getViewTreeObserver().addOnGlobalLayoutListener(new c(this));
            return;
            paramBundle = getIntent().getExtras();
            if (paramBundle != null) {
                paramBundle = (Uri) paramBundle.getParcelable("export.image.uri");
                if ((paramBundle != null) && (!TextUtils.isEmpty(paramBundle.getPath()))) {
                    a(paramBundle);
                }
            }
        }
    }

    public android.support.v4.a.l<mobi.ifunny.util.a.d> onCreateLoader(int paramInt, Bundle paramBundle) {
        if (paramBundle != null) {
            mobi.ifunny.util.a.a locala = new mobi.ifunny.util.a.a(null, false);
            Uri localUri = (Uri) paramBundle.getParcelable("loader.image.uri");
            if (localUri != null) {
                return new mobi.ifunny.e.l(this, true, localUri, locala);
            }
            paramBundle = paramBundle.getByteArray("loader.image.data");
            if (paramBundle != null) {
                return new mobi.ifunny.e.b(this, paramBundle, locala);
            }
        }
        return null;
    }

    public boolean onCreateOptionsMenu(Menu paramMenu) {
        getMenuInflater().inflate(2131820557, paramMenu);
        return super.onCreateOptionsMenu(paramMenu);
    }

    public void onFocusChange(View paramView, boolean paramBoolean) {
        if (paramBoolean) {
            if (paramView == this.w) {
                this.z.setOnSeekBarChangeListener(null);
                this.z.setProgress(this.D);
                this.z.setOnSeekBarChangeListener(this);
            }
        }
        do {
            do {
                return;
            } while (paramView != this.x);
            this.z.setOnSeekBarChangeListener(null);
            this.z.setProgress(this.E);
            this.z.setOnSeekBarChangeListener(this);
            return;
            if (paramView == this.w) {
                this.D = this.z.getProgress();
                return;
            }
        } while (paramView != this.x);
        this.E = this.z.getProgress();
    }

    public void onLoaderReset(android.support.v4.a.l<mobi.ifunny.util.a.d> paraml) {
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
            default:
                return super.onOptionsItemSelected(paramMenuItem);
        }
        Object localObject = this.t.getDrawable();
        if (localObject == null) {
            w();
            return true;
        }
        paramMenuItem = null;
        if ((localObject instanceof BitmapDrawable)) {
            paramMenuItem = ((BitmapDrawable) localObject).getBitmap();
            if (paramMenuItem == null) {
                w();
                return true;
            }
            int i = paramMenuItem.getWidth();
            int j = paramMenuItem.getHeight();
            localObject = new ArrayList(1);
            ((ArrayList) localObject).add(new mobi.ifunny.util.a.e(paramMenuItem, new Rect(0, 0, i, j)));
            paramMenuItem = new mobi.ifunny.util.a.d(i, j, (ArrayList) localObject);
        }
        while ((paramMenuItem == null) || (paramMenuItem.b())) {
            w();
            return true;
            if ((localObject instanceof f)) {
                paramMenuItem = ((f) localObject).e();
            }
        }
        String str = this.w.getText().toString().trim().toUpperCase();
        localObject = this.x.getText().toString().trim().toUpperCase();
        if ((TextUtils.isEmpty(str)) && (TextUtils.isEmpty((CharSequence) localObject))) {
            D();
            return true;
        }
        str = r.a(str);
        localObject = r.a((String) localObject);
        new e(this, F, paramMenuItem, this.t.getWidth(), this.t.getHeight(), str, this.w.getTextSize(), (String) localObject, this.x.getTextSize(), this.r, this.s).execute(new Void[0]);
        return true;
    }

    protected void onPostCreate(Bundle paramBundle) {
        super.onPostCreate(paramBundle);
        Object localObject;
        if (o != null) {
            if (TextUtils.equals(o.a.a, "mem")) {
                localObject = (mobi.ifunny.studio.a.c.a) o.b;
                if (!TextUtils.isEmpty(((mobi.ifunny.studio.a.c.a) localObject).a)) {
                    paramBundle = ((mobi.ifunny.studio.a.c.a) localObject).a.toUpperCase();
                    this.w.setText(paramBundle);
                    this.w.setTextSize(((mobi.ifunny.studio.a.c.a) localObject).b);
                    this.D = a(((mobi.ifunny.studio.a.c.a) localObject).b);
                    if (TextUtils.isEmpty(((mobi.ifunny.studio.a.c.a) localObject).c)) {
                        break label204;
                    }
                    paramBundle = ((mobi.ifunny.studio.a.c.a) localObject).c.toUpperCase();
                    label106:
                    this.x.setText(paramBundle);
                    this.x.setTextSize(((mobi.ifunny.studio.a.c.a) localObject).d);
                    this.E = a(((mobi.ifunny.studio.a.c.a) localObject).d);
                    if (((mobi.ifunny.studio.a.c.a) localObject).g != null) {
                        break label211;
                    }
                    this.r = ((mobi.ifunny.studio.a.c.a) localObject).e;
                    this.s = ((mobi.ifunny.studio.a.c.a) localObject).f;
                    localObject = this.s;
                    paramBundle = null;
                    label167:
                    o = null;
                }
            }
        }
        for (; ; ) {
            af localaf = g();
            if ((localObject == null) && (paramBundle == null)) {
                if (localaf.b(0) == null) {
                    u();
                    return;
                    paramBundle = "";
                    break;
                    label204:
                    paramBundle = "";
                    break label106;
                    label211:
                    paramBundle = ((mobi.ifunny.studio.a.c.a) localObject).g;
                    localObject = null;
                    break label167;
                    throw new IllegalStateException();
                }
                localaf.a(0, null, this);
                return;
            }
            a((String) localObject, paramBundle);
            return;
            paramBundle = null;
            localObject = null;
        }
    }

    public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean) {
        c(paramInt);
    }

    protected void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        paramBundle.putString("state.src.id", this.r);
        paramBundle.putString("state.src.url", this.s);
    }

    public void onStartTrackingTouch(SeekBar paramSeekBar) {
    }

    public void onStopTrackingTouch(SeekBar paramSeekBar) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/meme/MemeEditorActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */