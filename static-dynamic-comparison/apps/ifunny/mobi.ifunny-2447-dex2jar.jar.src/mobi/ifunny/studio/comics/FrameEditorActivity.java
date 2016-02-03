package mobi.ifunny.studio.comics;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.g;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Pair;
import android.util.SparseArray;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Timer;

import mobi.ifunny.rest.content.RageCategory;
import mobi.ifunny.rest.content.RageFace;
import mobi.ifunny.rest.content.RageMeta;
import mobi.ifunny.rest.content.RageMetaWrapper;
import mobi.ifunny.rest.content.WebImage;
import mobi.ifunny.rest.retrofit.IFunnyRestRequest.Studio;
import mobi.ifunny.rest.retrofit.RestHttpHandler;
import mobi.ifunny.studio.comics.engine.EditorView;
import mobi.ifunny.studio.comics.engine.a.e;
import mobi.ifunny.studio.comics.view.EqualSpaceGridView;
import mobi.ifunny.studio.comics.view.HorizontalAdapterView;
import mobi.ifunny.studio.crop.free.FreeCropImageActivity;
import mobi.ifunny.util.aa;
import mobi.ifunny.util.an;

public class FrameEditorActivity
        extends mobi.ifunny.l.a
        implements View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener, SeekBar.OnSeekBarChangeListener, e, mobi.ifunny.studio.comics.engine.a.f, mobi.ifunny.studio.comics.engine.b, mobi.ifunny.studio.comics.view.c {
    private static int I = 0;
    private static RageCategory[] L;
    private static SparseArray<SparseArray<Point>> M = new SparseArray();
    private static final RestHttpHandler<RageMetaWrapper, FrameEditorActivity> Y = new b();
    private static final String Z = y.class.getSimpleName();
    public static final String o;
    private static final String p = FrameEditorActivity.class.getSimpleName();
    private static mobi.ifunny.studio.comics.engine.c.c t;
    private static mobi.ifunny.studio.comics.engine.c.l u;
    private int A;
    private int B;
    private float C;
    private ac[] D;
    private int E;
    private int F;
    private float G;
    private String H;
    private int J;
    private Uri K;
    private Integer[] N;
    private MenuItem O;
    private MenuItem P;
    private MenuItem Q;
    private MenuItem R;
    private MenuItem S;
    private Timer T;
    private boolean U;
    private int V;
    private Bundle W;
    private TextWatcher X = new a(this);
    private m q;
    private m r;
    private mobi.ifunny.studio.comics.engine.f s;
    private ViewGroup v;
    private ViewGroup w;
    private View x;
    private EditText y;
    private View z;

    static {
        o = r.class.getSimpleName();
    }

    private void D() {
        mobi.ifunny.studio.a.b.b localb = this.s.e();
        try {
            mobi.ifunny.util.l.a(this, "comics.frame.msgpack", aa.a(localb));
            return;
        } catch (IOException localIOException) {
            mobi.ifunny.d.c(p, "Failed to serialize frame into comics.frame.msgpack", localIOException);
        }
    }

    private void E() {
        Pair localPair = new Pair(this.s.A(), this.s.u());
        this.s.a(new mobi.ifunny.studio.comics.engine.b.d(localPair), mobi.ifunny.studio.comics.engine.c.a);
    }

    private void F() {
        if (this.W == null) {
            return;
        }
        int i = this.W.getInt("RESULT_BUNDLE_REQUEST_CODE");
        int j = this.W.getInt("RESULT_BUNDLE_RESULT_CODE");
        Object localObject = (Uri) this.W.getParcelable("RESULT_BUNDLE_DATA");
        switch (i) {
        }
        for (; ; ) {
            this.W = null;
            return;
            if ((j == -1) && (localObject != null)) {
                J();
                a((Uri) localObject);
                continue;
                if ((j == -1) && (localObject != null)) {
                    b((Uri) localObject);
                    continue;
                    if (j == -1) {
                        localObject = (WebImage) this.W.getBundle("RESULT_BUNDLE_EXTAS").getParcelable("intent.web_image");
                        if (localObject != null) {
                            b(Uri.parse(((WebImage) localObject).url));
                        }
                    }
                }
            }
        }
    }

    private void G() {
        g(-1);
        a(0.0F, 1.0F);
        f(-16777216);
        b(null);
    }

    private void H() {
        android.support.v4.app.q localq = f();
        g localg = (g) localq.a("dialog.loading");
        if (localg != null) {
            localg.b();
            localq.b();
        }
    }

    private void I() {
        android.support.v4.app.q localq = f();
        if ((g) localq.a("dialog.source") == null) {
            new o().a(localq, "dialog.source");
            localq.b();
        }
    }

    private void J() {
        android.support.v4.app.q localq = f();
        g localg = (g) localq.a("dialog.source");
        if (localg != null) {
            localg.b();
            localq.b();
        }
    }

    private void K() {
        HorizontalAdapterView localHorizontalAdapterView = (HorizontalAdapterView) this.w.findViewById(2131493096);
        if (localHorizontalAdapterView != null) {
            ((u) localHorizontalAdapterView.getAdapter()).a();
        }
        b(new String[]{"RAGEFACE_CATEGORY_LOAD_TASK_TAG"});
    }

    private void L() {
        View localView = findViewById(2131493098);
        Object localObject = getWindowManager().getDefaultDisplay();
        Point localPoint;
        if (Build.VERSION.SDK_INT >= 13) {
            localPoint = new Point();
            ((Display) localObject).getSize(localPoint);
        }
        for (int i = localPoint.x; ; i = ((Display) localObject).getWidth()) {
            localObject = this.s.f();
            float f = i / ((RectF) localObject).width();
            int j = (int) (((RectF) localObject).height() * f);
            localObject = localView.getLayoutParams();
            ((ViewGroup.LayoutParams) localObject).height = j;
            localView.setLayoutParams((ViewGroup.LayoutParams) localObject);
            getWindow().getDecorView().requestLayout();
            this.s.a(i, j);
            this.s.c(f);
            F();
            return;
        }
    }

    private void M() {
        boolean bool2 = true;
        boolean bool3;
        MenuItem localMenuItem;
        if (this.q == m.c) {
            bool3 = ((mobi.ifunny.studio.comics.engine.a.a) this.s.r().b()).a().a();
            if (!bool3) {
                break label104;
            }
            b(false);
            if (this.R != null) {
                localMenuItem = this.R;
                if (bool3) {
                    break label123;
                }
                bool1 = true;
                label60:
                localMenuItem.setEnabled(bool1);
            }
        }
        if (this.S != null) {
            localMenuItem = this.S;
            if (this.s.b()) {
                break label128;
            }
        }
        label104:
        label123:
        label128:
        for (boolean bool1 = bool2; ; bool1 = false) {
            localMenuItem.setEnabled(bool1);
            return;
            if (!bool3) {
            }
            for (bool1 = true; ; bool1 = false) {
                e(bool1);
                break;
            }
            bool1 = false;
            break label60;
        }
    }

    private void N() {
        if ((g) f().a("dialog.clear") == null) {
            new h().a(f(), "dialog.clear");
        }
    }

    private void O() {
        if ((g) f().a("dialog.font") == null) {
            new f().a(f(), "dialog.font");
        }
    }

    private int a(float paramFloat) {
        return (int) ((paramFloat - this.C) / 2.0F);
    }

    private int a(Integer paramInteger) {
        int j = this.N.length;
        int i = 0;
        while (i < j) {
            if (this.N[i].equals(paramInteger)) {
                return i;
            }
            i += 1;
        }
        return -1;
    }

    private void a(float paramFloat1, float paramFloat2) {
        this.G = paramFloat1;
        this.y.setTextSize(0, paramFloat1 * paramFloat2);
    }

    private void a(Uri paramUri) {
        Intent localIntent = new Intent(this, FreeCropImageActivity.class);
        localIntent.setData(paramUri);
        startActivityForResult(localIntent, 2);
    }

    private void a(String paramString1, String paramString2, Typeface paramTypeface, float paramFloat, int paramInt) {
        paramString1 = new mobi.ifunny.studio.comics.engine.c.l(paramString1, paramString2, paramTypeface, paramFloat, paramInt);
        this.s.a(paramString1, 0);
        paramString2 = this.s.g();
        paramString1.b(new PointF(paramString2.left, paramString2.top));
        paramString1.a(paramString2.width());
    }

    private void a(mobi.ifunny.util.a.d paramd, String paramString1, String paramString2) {
        int i = 1;
        if ((paramd == null) || (this.s == null)) {
            Toast.makeText(this, 2131689992, 0).show();
            return;
        }
        mobi.ifunny.view.drawable.f localf = new mobi.ifunny.view.drawable.f(paramd, true);
        float f1 = paramd.a;
        float f2 = paramd.b;
        paramd = this.s.f();
        RectF localRectF;
        if ((paramd.width() == f1) && (paramd.height() == f2)) {
            localRectF = this.s.g();
            if ((paramString1 == null) || (paramString2 == null)) {
                break label175;
            }
            paramd = new mobi.ifunny.studio.comics.engine.c.k(paramString1, paramString2, localf);
            label108:
            if (i == 0) {
                if ((f1 > 180.0F) || (f2 > 180.0F)) {
                    if (f1 >= f2) {
                        break label188;
                    }
                }
            }
        }
        label175:
        label188:
        for (f1 = 180.0F / f2; ; f1 = 180.0F / f1) {
            paramd.b(f1);
            paramd.b(localRectF);
            this.s.a(paramd, 0);
            return;
            i = 0;
            break;
            paramd = new mobi.ifunny.studio.comics.engine.c.a(localf);
            break label108;
        }
    }

    private void b(PointF paramPointF) {
        Object localObject = RageEditorActivity.p.a();
        PointF localPointF;
        if ((localObject instanceof mobi.ifunny.studio.comics.a.d)) {
            localObject = ((mobi.ifunny.studio.comics.a.d) localObject).b();
            localPointF = ((mobi.ifunny.studio.comics.engine.c.h) localObject).r();
        }
        try {
            mobi.ifunny.studio.comics.engine.c.h localh = (mobi.ifunny.studio.comics.engine.c.h) ((mobi.ifunny.studio.comics.engine.c.h) localObject).clone();
            localObject = paramPointF;
            if (paramPointF == null) {
                localObject = new PointF(localPointF.x + 10.0F, localPointF.y + 10.0F);
            }
            localh.c((PointF) localObject);
            localh.e(false);
            this.s.a(localh, 0);
            return;
        } catch (CloneNotSupportedException paramPointF) {
        }
    }

    private void b(Uri paramUri) {
        J();
        new n(this).execute(new Pair[]{new Pair(paramUri, mobi.ifunny.util.h.a(this))});
    }

    private void b(String paramString) {
        this.H = paramString;
        this.y.setText(paramString);
    }

    private void c(String paramString) {
        android.support.v4.app.q localq = f();
        if ((g) localq.a("dialog.loading") == null) {
            mobi.ifunny.fragment.h.a(this, new String[]{paramString}).a(localq, "dialog.loading");
            localq.b();
        }
    }

    private float e(int paramInt) {
        return this.C + paramInt * 2;
    }

    private void e(boolean paramBoolean) {
        this.v.findViewById(2131493191).setEnabled(paramBoolean);
    }

    private void f(int paramInt) {
        this.F = paramInt;
        this.y.setTextColor(paramInt);
    }

    private void g(int paramInt) {
        this.E = paramInt;
        if ((this.D != null) && (paramInt >= 0) && (paramInt < this.D.length)) {
            Typeface localTypeface = this.D[paramInt].c();
            this.y.setTypeface(localTypeface);
        }
    }

    private void h(int paramInt) {
        a(e(paramInt), this.s.t());
    }

    private int i(int paramInt) {
        return this.A + paramInt * 2;
    }

    private int j(int paramInt) {
        return (paramInt - this.A) / 2;
    }

    private void k(int paramInt) {
        K();
        Object localObject;
        u localu;
        RageCategory localRageCategory;
        int j;
        List localList;
        if ((L != null) && (paramInt >= 0) && (paramInt < L.length)) {
            localObject = (HorizontalAdapterView) this.w.findViewById(2131493096);
            localu = (u) ((HorizontalAdapterView) localObject).getAdapter();
            localRageCategory = L[paramInt];
            j = Math.min(((HorizontalAdapterView) localObject).getMeasuredHeight(), this.J);
            u.a(localu, j);
            localList = localRageCategory.sources;
            localObject = (SparseArray) M.get(paramInt);
            if (localObject != null) {
                break label237;
            }
            localObject = new SparseArray(localList.size());
            M.append(paramInt, localObject);
        }
        label232:
        label237:
        for (; ; ) {
            int k = ((SparseArray) localObject).size();
            int i = 0;
            while (i < k) {
                localu.a((RageFace) localList.get(i), (Point) ((SparseArray) localObject).get(i));
                i += 1;
            }
            if (k < localList.size()) {
                if (e("RAGEFACE_LOAD_TASK_TAG")) {
                    break label232;
                }
            }
            for (i = 1; ; i = 0) {
                if (i != 0) {
                    new t(this).execute(new q[]{new q(localRageCategory, j, k, paramInt, null)});
                }
                return;
            }
        }
    }

    public void a(int paramInt1, int paramInt2) {
        Object localObject2 = getLayoutInflater();
        Object localObject1;
        if (this.v.getChildCount() > 0) {
            localObject1 = this.v.getChildAt(0);
            if ((localObject1 == null) || (((View) localObject1).getId() != 2131493190)) {
                this.v.removeAllViews();
                localObject1 = ((LayoutInflater) localObject2).inflate(2130903137, this.v, false);
                Object localObject3 = ((View) localObject1).findViewById(2131493092);
                View localView = ((View) localObject1).findViewById(2131493191);
                ((View) localObject3).setOnClickListener(this);
                localView.setOnClickListener(this);
                localObject3 = (SeekBar) ((View) localObject1).findViewById(2131493193);
                ((SeekBar) localObject3).setProgress(j(paramInt2));
                ((SeekBar) localObject3).setOnSeekBarChangeListener(this);
                this.v.addView((View) localObject1);
            }
            if (this.w.getChildCount() <= 0) {
                break label252;
            }
            localObject1 = this.w.getChildAt(0);
            label145:
            if ((localObject1 != null) && (((View) localObject1).getId() == 2131493041)) {
                break label257;
            }
            this.w.removeAllViews();
            localObject2 = ((LayoutInflater) localObject2).inflate(2130903077, this.w, false);
            localObject1 = (EqualSpaceGridView) localObject2;
            ((EqualSpaceGridView) localObject1).setOnItemClickListener(this);
            ((EqualSpaceGridView) localObject1).setOnPrimarySelectedListener(this);
            this.w.addView((View) localObject2);
        }
        for (; ; ) {
            ((EqualSpaceGridView) localObject1).setAdapter(new k(this, this, this.N));
            ((EqualSpaceGridView) localObject1).setPrimarySelected(a(Integer.valueOf(paramInt1)));
            this.w.requestLayout();
            ((EqualSpaceGridView) localObject1).invalidate();
            return;
            localObject1 = null;
            break;
            label252:
            localObject1 = null;
            break label145;
            label257:
            localObject1 = (EqualSpaceGridView) this.w.findViewById(2131493041);
        }
    }

    public void a(int paramInt, View paramView, boolean paramBoolean) {
    }

    public void a(Dialog paramDialog) {
    }

    public void a(PointF paramPointF) {
        b(paramPointF);
    }

    public void a(View paramView, boolean paramBoolean) {
        ((j) paramView.getTag()).c.setSelected(paramBoolean);
    }

    public void a(String paramString, int paramInt1, float paramFloat1, int paramInt2, float paramFloat2) {
        LayoutInflater localLayoutInflater = getLayoutInflater();
        Object localObject;
        label98:
        float f2;
        float f1;
        if (this.v.getChildCount() > 0) {
            localObject = this.v.getChildAt(0);
            if ((localObject != null) && (((View) localObject).getId() == 2131493337)) {
                break label396;
            }
            this.v.removeAllViewsInLayout();
            View localView = localLayoutInflater.inflate(2130903173, this.v, false);
            localObject = (SeekBar) localView.findViewById(2131493339);
            localView.findViewById(2131493338).setOnClickListener(this);
            this.v.addView(localView);
            f2 = e(((SeekBar) localObject).getMax());
            f1 = 0.5F + (this.C + 0.14F * f2);
            if (paramFloat1 >= this.C) {
                break label446;
            }
            paramFloat1 = f1;
        }
        label148:
        label196:
        label280:
        label396:
        label412:
        label424:
        label429:
        label446:
        for (; ; ) {
            int j = paramInt1;
            int i;
            if (paramInt1 < 0) {
                i = 0;
                j = paramInt1;
                if (i < this.D.length) {
                    if (!TextUtils.equals("roboto/Regular.ttf", this.D[i].a())) {
                        break label412;
                    }
                    j = i;
                }
            }
            if (paramFloat1 < this.C) {
                paramFloat1 = f1;
                f1 = paramFloat1;
                if (paramFloat1 > f2) {
                    f1 = f2;
                }
                b(paramString);
                if (paramString != null) {
                    this.y.setSelection(paramString.length());
                }
                a(f1, paramFloat2);
                g(j);
                ((SeekBar) localObject).setProgress(a(f1));
                ((SeekBar) localObject).setOnSeekBarChangeListener(this);
                if (this.w.getChildCount() <= 0) {
                    break label424;
                }
                paramString = this.w.getChildAt(0);
                if ((paramString != null) && (paramString.getId() == 2131493041)) {
                    break label429;
                }
                this.w.removeAllViewsInLayout();
                localObject = localLayoutInflater.inflate(2130903077, this.w, false);
                paramString = (EqualSpaceGridView) localObject;
                paramString.setOnPrimarySelectedListener(this);
                paramString.setOnItemClickListener(this);
                this.w.addView((View) localObject);
            }
            for (; ; ) {
                paramString.setAdapter(new k(this, this, this.N));
                paramString.setPrimarySelected(a(Integer.valueOf(paramInt2)));
                paramString.setEnabled(true);
                f(paramInt2);
                this.w.requestLayout();
                return;
                localObject = null;
                break;
                localObject = (SeekBar) ((View) localObject).findViewById(2131493339);
                break label98;
                i += 1;
                break label148;
                break label196;
                paramString = null;
                break label280;
                paramString = (EqualSpaceGridView) this.w.findViewById(2131493041);
            }
        }
    }

    protected void a(RageMetaWrapper paramRageMetaWrapper) {
        L = paramRageMetaWrapper.comics.items;
        if ((this.q == m.b) || (this.q == m.d)) {
            if (L.length > I) {
                break label96;
            }
        }
        label96:
        for (int i = 0; ; i = I) {
            I = i;
            paramRageMetaWrapper = (Spinner) this.v.findViewById(2131493088);
            paramRageMetaWrapper.setAdapter(new z(this, this, L));
            paramRageMetaWrapper.setSelection(I);
            paramRageMetaWrapper.setEnabled(true);
            k(I);
            return;
        }
    }

    public void a(mobi.ifunny.studio.comics.engine.b.i parami, mobi.ifunny.studio.comics.engine.c paramc) {
        M();
    }

    public void a(mobi.ifunny.studio.comics.engine.c.h paramh) {
        try {
            paramh = new mobi.ifunny.studio.comics.a.d((mobi.ifunny.studio.comics.engine.c.h) paramh.clone());
            RageEditorActivity.p.a(paramh);
            this.Q.setEnabled(true);
            return;
        } catch (CloneNotSupportedException paramh) {
        }
    }

    public void a(m paramm) {
        a(paramm, null, false);
    }

    public void a(m paramm, Object paramObject, boolean paramBoolean) {
        int i = 1;
        boolean bool = false;
        if (this.q == paramm) {
            return;
        }
        this.s.b(0);
        switch (e.a[this.q.ordinal()]) {
            default:
                this.q = paramm;
                this.s.r().a(null);
                switch (e.a[this.q.ordinal()]) {
                }
                break;
        }
        for (; ; ) {
            d();
            this.r = this.q;
            return;
            Object localObject1 = (mobi.ifunny.studio.comics.engine.a.a) this.s.r().b();
            if (paramBoolean) {
                ((mobi.ifunny.studio.comics.engine.a.a) localObject1).g();
                break;
            }
            ((mobi.ifunny.studio.comics.engine.a.a) localObject1).f();
            break;
            K();
            break;
            if (this.T != null) {
                this.T.cancel();
                this.T = null;
            }
            this.U = false;
            this.x.setVisibility(8);
            localObject1 = this.y.getText().toString().trim();
            this.y.removeTextChangedListener(this.X);
            b(null);
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this.y.getWindowToken(), 0);
            Object localObject2 = this.D[this.E].c();
            String str = this.D[this.E].a();
            if (u != null) {
                if (!paramBoolean) {
                    if (TextUtils.isEmpty((CharSequence) localObject1)) {
                        this.s.a(new mobi.ifunny.studio.comics.engine.b.j(u, 0), mobi.ifunny.studio.comics.engine.c.a);
                    }
                }
            }
            for (; ; ) {
                G();
                u = null;
                break;
                this.s.a(new mobi.ifunny.studio.comics.engine.b.c(u, new mobi.ifunny.studio.comics.engine.c.m((String) localObject1, str, (Typeface) localObject2, this.G, this.F)), mobi.ifunny.studio.comics.engine.c.a);
                localObject1 = this.s.g();
                localObject2 = u.q();
                if (!((RectF) localObject1).contains(((PointF) localObject2).x, ((PointF) localObject2).y)) {
                    u.b(new PointF(((RectF) localObject1).left, ((RectF) localObject1).top));
                }
                this.s.a(u);
                u.b(true);
                continue;
                this.s.a(u);
                u.b(true);
                continue;
                if (!paramBoolean) {
                    a((String) localObject1, str, (Typeface) localObject2, this.G, this.F);
                }
            }
            ((mobi.ifunny.studio.comics.engine.a.i) this.s.r().b()).a(null);
            break;
            c(this.s.u().z());
            paramm = new mobi.ifunny.studio.comics.engine.a.i(this, this);
            paramm.a(this);
            this.s.r().a(paramm);
        }
        if ((L == null) || (L.length <= I)) {
        }
        for (i = 0; ; i = I) {
            I = i;
            d(I);
            this.s.r().a(new mobi.ifunny.studio.comics.engine.a.i(this, this));
            break;
        }
        label638:
        label644:
        int j;
        if (t == null) {
            paramm = (mobi.ifunny.studio.comics.engine.c.c) paramObject;
            if (paramm == null) {
                break label781;
            }
            paramBoolean = true;
            paramObject = paramm;
            if (paramm == null) {
                paramObject = new mobi.ifunny.studio.comics.engine.c.c(null);
            }
            paramm = new mobi.ifunny.studio.comics.engine.a.a((mobi.ifunny.studio.comics.engine.c.c) paramObject, paramBoolean, 0, this.A);
            this.s.r().a(paramm);
            j = paramm.d();
            i = (int) (i(this.B) * 0.24F + 0.5F);
            if (paramBoolean) {
                i = this.A;
            }
            if (j >= i) {
                break label786;
            }
            label728:
            paramm.b(i);
            a(paramm.b(), i);
            b(paramm.b());
            if (!paramm.c()) {
                break label793;
            }
            n();
        }
        for (; ; ) {
            paramm.e();
            t = null;
            break;
            paramm = t;
            break label638;
            label781:
            paramBoolean = false;
            break label644;
            label786:
            i = j;
            break label728;
            label793:
            paramBoolean = bool;
            if (!((mobi.ifunny.studio.comics.engine.c.c) paramObject).a()) {
                paramBoolean = true;
            }
            b(paramBoolean);
        }
        if (u != null) {
            label819:
            if (i == 0) {
                u = (mobi.ifunny.studio.comics.engine.c.l) paramObject;
            }
            this.s.a(null);
            this.x.setVisibility(0);
            this.y.addTextChangedListener(this.X);
            if (u != null) {
                break label910;
            }
            a(this.H, this.E, this.G, this.F, this.s.t());
        }
        for (; ; ) {
            this.s.b(200);
            break;
            i = 0;
            break label819;
            label910:
            if (i == 0) {
                break label952;
            }
            a(this.H, this.E, this.G, this.F, this.s.t());
            u.b(false);
        }
        label952:
        this.E = -1;
        paramm = u.c();
        i = 0;
        for (; ; ) {
            if (i < this.D.length) {
                if (TextUtils.equals(this.D[i].a(), paramm)) {
                    this.E = i;
                }
            } else {
                a(u.a(), this.E, u.d(), u.e(), this.s.t());
                break;
            }
            i += 1;
        }
    }

    public boolean a(mobi.ifunny.studio.comics.engine.a.d paramd, MotionEvent paramMotionEvent) {
        if (this.q == m.b) {
            a(m.d);
            return true;
        }
        return false;
    }

    public void b(int paramInt) {
        ((mobi.ifunny.studio.comics.engine.a.a) this.s.r().b()).a(paramInt);
    }

    public void b(mobi.ifunny.studio.comics.engine.c.h paramh) {
        if (this.q != m.c) {
        }
        switch (e.b[paramh.n().ordinal()]) {
            default:
                return;
            case 1:
                a(m.c, paramh, false);
                return;
        }
        a(m.e, paramh, false);
    }

    public void b(boolean paramBoolean) {
        Object localObject = this.v.findViewById(2131493092);
        View localView = this.v.findViewById(2131493191);
        e(paramBoolean);
        ((View) localObject).setSelected(true);
        localView.setSelected(false);
        localObject = (EqualSpaceGridView) findViewById(2131493041);
        ((EqualSpaceGridView) localObject).setEnabled(true);
        b(this.N[localObject.getPrimarySelectedIndex()].intValue());
        ((mobi.ifunny.studio.comics.engine.a.a) this.s.r().b()).a(false);
    }

    public void c(int paramInt) {
        Object localObject2 = getLayoutInflater();
        o();
        this.v.findViewById(2131493089).setSelected(true);
        Object localObject1;
        if (this.w.getChildCount() > 0) {
            localObject1 = this.w.getChildAt(0);
            if ((localObject1 != null) && (((View) localObject1).getId() == 2131493041)) {
                break label146;
            }
            this.w.removeAllViews();
            localObject2 = ((LayoutInflater) localObject2).inflate(2130903077, this.w, false);
            localObject1 = (EqualSpaceGridView) localObject2;
            ((EqualSpaceGridView) localObject1).setOnPrimarySelectedListener(this);
            ((EqualSpaceGridView) localObject1).setOnItemClickListener(this);
            this.w.addView((View) localObject2);
        }
        for (; ; ) {
            ((EqualSpaceGridView) localObject1).setAdapter(new k(this, this, this.N));
            ((EqualSpaceGridView) localObject1).setPrimarySelected(a(Integer.valueOf(paramInt)));
            ((EqualSpaceGridView) localObject1).setEnabled(true);
            this.w.requestLayout();
            return;
            localObject1 = null;
            break;
            label146:
            localObject1 = (EqualSpaceGridView) this.w.findViewById(2131493041);
        }
    }

    public void c(boolean paramBoolean) {
        if (this.P != null) {
            this.P.setEnabled(paramBoolean);
        }
    }

    public void d(int paramInt) {
        o();
        if (this.w.getChildCount() > 0) {
        }
        for (Object localObject = this.w.getChildAt(0); ; localObject = null) {
            if ((localObject == null) || (((View) localObject).getId() != 2131493096)) {
                localObject = getLayoutInflater();
                this.w.removeAllViews();
                localObject = (HorizontalAdapterView) ((LayoutInflater) localObject).inflate(2130903109, this.w, false);
                ((HorizontalAdapterView) localObject).setAdapter(new u(this, null, this.J));
                ((HorizontalAdapterView) localObject).setOnItemClickListener(this);
                this.w.addView((View) localObject);
            }
            k(paramInt);
            getWindow().getDecorView().requestLayout();
            return;
        }
    }

    public void d(boolean paramBoolean) {
        if (this.O != null) {
            this.O.setEnabled(paramBoolean);
        }
    }

    public void n() {
        Object localObject = this.v.findViewById(2131493092);
        View localView = this.v.findViewById(2131493191);
        localView.setEnabled(true);
        ((View) localObject).setSelected(false);
        localView.setSelected(true);
        localObject = (mobi.ifunny.studio.comics.engine.a.a) this.s.r().b();
        ((EqualSpaceGridView) findViewById(2131493041)).setEnabled(false);
        ((mobi.ifunny.studio.comics.engine.a.a) localObject).a(true);
    }

    public void o() {
        Object localObject = getLayoutInflater();
        View localView;
        Spinner localSpinner;
        if (this.v.getChildCount() > 0) {
            localView = this.v.getChildAt(0);
            if ((localView != null) && (localView.getId() == 2131493087)) {
                break label204;
            }
            this.v.removeAllViews();
            localObject = ((LayoutInflater) localObject).inflate(2130903105, this.v, false);
            localView = ((View) localObject).findViewById(2131493089);
            localView.setOnClickListener(this);
            ((View) localObject).findViewById(2131493090).setOnClickListener(this);
            ((View) localObject).findViewById(2131493091).setOnClickListener(this);
            ((View) localObject).findViewById(2131493092).setOnClickListener(this);
            localSpinner = (Spinner) ((View) localObject).findViewById(2131493088);
            if (L != null) {
                break label153;
            }
            localSpinner.setEnabled(false);
            localSpinner.setOnItemSelectedListener(this);
            this.v.addView((View) localObject);
        }
        for (; ; ) {
            localView.setSelected(false);
            return;
            localView = null;
            break;
            label153:
            if (L.length <= I) {
            }
            for (int i = 0; ; i = I) {
                I = i;
                localSpinner.setAdapter(new z(this, this, L));
                localSpinner.setSelection(I);
                break;
            }
            label204:
            localView = this.v.findViewById(2131493089);
        }
    }

    protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        this.W = new Bundle();
        if (paramIntent != null) {
            Object localObject = paramIntent.getExtras();
            this.W.putBundle("RESULT_BUNDLE_EXTAS", (Bundle) localObject);
            localObject = an.a(paramIntent);
            if (localObject != null) {
                this.W.putParcelable("RESULT_BUNDLE_DATA", (Parcelable) localObject);
            }
        }
        this.W.putInt("RESULT_BUNDLE_REQUEST_CODE", paramInt1);
        this.W.putInt("RESULT_BUNDLE_RESULT_CODE", paramInt2);
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
        if (this.s.c()) {
            F();
        }
    }

    public void onBackPressed() {
        if (this.q == m.c) {
            a(m.d, null, true);
            return;
        }
        if (this.q == m.e) {
            a(m.d, null, true);
            return;
        }
        if (this.s == null) {
            mobi.ifunny.d.e(p, "onBackPressed engine is null");
            return;
        }
        mobi.ifunny.studio.a.b.b localb = this.s.e();
        if (localb == null) {
            mobi.ifunny.d.e(p, "onBackPressed engine.getFrame() is null");
            return;
        }
        new y(this, Z, localb).execute(new Void[0]);
    }

    public void onClick(View paramView) {
        switch (paramView.getId()) {
            default:
                return;
            case 2131493089:
                switch (e.a[this.q.ordinal()]) {
                    default:
                        return;
                    case 3:
                        a(m.d);
                        return;
                }
                a(m.b);
                return;
            case 2131493090:
                a(m.e);
                return;
            case 2131493091:
                I();
                return;
            case 2131493338:
                O();
                return;
            case 2131493092:
                switch (e.a[this.q.ordinal()]) {
                    case 2:
                    default:
                        return;
                    case 1:
                        if (((mobi.ifunny.studio.comics.engine.a.a) this.s.r().b()).a().a()) {
                            break;
                        }
                }
                for (boolean bool = true; ; bool = false) {
                    b(bool);
                    return;
                    a(m.c);
                    return;
                }
        }
        n();
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(2130903112);
        this.A = getResources().getInteger(2131558418);
        this.B = getResources().getInteger(2131558414);
        this.C = getResources().getInteger(2131558419);
        this.J = getResources().getDimensionPixelSize(2131427414);
        Object localObject;
        try {
            String[] arrayOfString = getAssets().list("roboto");
            int j = arrayOfString.length;
            AssetManager localAssetManager = getAssets();
            this.D = new ac[j];
            int i = 0;
            while (i < j) {
                String str1 = arrayOfString[i];
                String str2 = "roboto" + File.separator + str1;
                Typeface localTypeface = Typeface.createFromAsset(localAssetManager, str2);
                this.D[i] = new ac(str2, str1.substring(0, str1.length() - 4), localTypeface, null);
                i += 1;
            }
            this.r = ((m) paramBundle.getSerializable("SAVE_INSTANCE_STATE"));
        } catch (IOException localIOException) {
            setResult(0);
            Toast.makeText(this, 2131690007, 0).show();
            finish();
            this.v = ((ViewGroup) findViewById(2131493340));
            this.w = ((ViewGroup) findViewById(2131493103));
            this.x = findViewById(2131493100);
            this.y = ((EditText) this.x.findViewById(2131493101));
            this.z = this.x.findViewById(2131493102);
            localObject = getResources().getIntArray(2131230720);
            j = localObject.length;
            this.N = new Integer[j];
            i = 0;
            while (i < j) {
                this.N[i] = Integer.valueOf(localObject[i]);
                i += 1;
            }
            localObject = (EditorView) findViewById(2131493099);
            this.q = m.a;
            this.r = m.d;
            G();
            if (paramBundle == null) {
                break label459;
            }
        }
        if ((this.r == m.c) && (t == null)) {
            this.r = m.d;
        }
        if (this.r == m.e) {
            if ((!paramBundle.getBoolean("SAVE_INSTANCE_TEXT_IS_EDITING")) || (u != null)) {
                break label507;
            }
            this.r = m.d;
        }
        for (; ; ) {
            I = paramBundle.getInt("SAVE_INSTANCE_SELECTED_CATEGORY");
            this.K = ((Uri) paramBundle.get("SAVE_INSTANCE_SELECTED_CAPTURE_URI"));
            label459:
            this.s = new mobi.ifunny.studio.comics.engine.f();
            try {
                paramBundle = aa.b(mobi.ifunny.util.l.a(this, "comics.frame.msgpack"));
                this.s.a(this, paramBundle);
                ((EditorView) localObject).a(this.s);
                this.s.a(this);
                return;
                label507:
                this.E = paramBundle.getInt("SAVE_INSTANCE_TEXT_TYPEFACE_INDEX");
                this.F = paramBundle.getInt("SAVE_INSTANCE_TEXT_COLOR");
                this.G = paramBundle.getFloat("SAVE_INSTANCE_TEXT_SIZE");
                this.H = paramBundle.getString("SAVE_INSTANCE_EDITING");
                this.F = paramBundle.getInt("SAVE_INSTANCE_TEXT_COLOR");
            } catch (IOException paramBundle) {
                for (; ; ) {
                    mobi.ifunny.d.c(p, "Can not deserialize frame from comics.frame.msgpack", paramBundle);
                    finish();
                }
            }
        }
    }

    public boolean onCreateOptionsMenu(Menu paramMenu) {
        boolean bool2 = true;
        boolean bool1 = true;
        paramMenu.clear();
        this.S = null;
        this.Q = null;
        this.R = null;
        Object localObject = getMenuInflater();
        if (this.q == m.c) {
            ((MenuInflater) localObject).inflate(2131820553, paramMenu);
            this.R = paramMenu.findItem(2131493085);
            bool1 = ((mobi.ifunny.studio.comics.engine.a.a) this.s.r().b()).a().a();
            localObject = this.R;
            if (!bool1) {
            }
            for (bool1 = true; ; bool1 = false) {
                ((MenuItem) localObject).setEnabled(bool1);
                this.O = paramMenu.findItem(2131493390);
                this.O.setEnabled(this.s.y());
                this.P = paramMenu.findItem(2131493391);
                this.P.setEnabled(this.s.z());
                return super.onCreateOptionsMenu(paramMenu);
            }
        }
        if (this.q == m.e) {
            ((MenuInflater) localObject).inflate(2131820554, paramMenu);
            this.R = paramMenu.findItem(2131493085);
            localObject = this.R;
            if (!TextUtils.isEmpty(this.y.getText())) {
            }
            for (; ; ) {
                ((MenuItem) localObject).setEnabled(bool1);
                break;
                bool1 = false;
            }
        }
        ((MenuInflater) localObject).inflate(2131820552, paramMenu);
        this.S = paramMenu.findItem(2131493389);
        localObject = this.S;
        if (!this.s.b()) {
        }
        for (bool1 = bool2; ; bool1 = false) {
            ((MenuItem) localObject).setEnabled(bool1);
            this.Q = paramMenu.findItem(2131493392);
            this.Q.setEnabled(RageEditorActivity.p.b());
            this.O = paramMenu.findItem(2131493390);
            this.O.setEnabled(this.s.y());
            this.P = paramMenu.findItem(2131493391);
            this.P.setEnabled(this.s.z());
            break;
        }
    }

    protected void onDestroy() {
        boolean bool = isChangingConfigurations();
        ((EditorView) findViewById(2131493099)).a();
        this.s.q();
        if (!bool) {
            this.s = null;
            t = null;
            u = null;
        }
        super.onDestroy();
    }

    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
        switch (e.a[this.q.ordinal()]) {
            default:
                return;
            case 4:
                paramAdapterView = x.a((x) paramView.getTag());
                paramView = new mobi.ifunny.util.a.a(paramAdapterView.url);
                paramView.a(paramAdapterView.id);
                new w(this).execute(new mobi.ifunny.util.a.a[]{paramView});
                return;
            case 3:
                ((EqualSpaceGridView) this.w.findViewById(2131493041)).setPrimarySelected(paramInt);
                paramInt = ((j) paramView.getTag()).a.intValue();
                ((mobi.ifunny.studio.comics.engine.a.i) this.s.r().b()).a(paramInt);
                a(m.d);
                return;
            case 1:
                ((EqualSpaceGridView) this.w.findViewById(2131493041)).setPrimarySelected(paramInt);
                paramInt = ((j) paramView.getTag()).a.intValue();
                ((mobi.ifunny.studio.comics.engine.a.a) this.s.r().b()).a(paramInt);
                return;
        }
        ((EqualSpaceGridView) this.w.findViewById(2131493041)).setPrimarySelected(paramInt);
        f(((j) paramView.getTag()).a.intValue());
    }

    public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
        if ((this.q == m.b) && (paramAdapterView.getId() == 2131493041)) {
            a(m.d);
        }
        while ((paramAdapterView.getId() != 2131493088) || (this.q != m.d) || (I == paramInt) || (L == null) || (L.length <= 0)) {
            return;
        }
        I = paramInt;
        k(I);
    }

    public void onNothingSelected(AdapterView<?> paramAdapterView) {
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
            default:
                return super.onOptionsItemSelected(paramMenuItem);
            case 16908332:
                onBackPressed();
                return true;
            case 2131493389:
                N();
                return true;
            case 2131493390:
                this.s.w();
                return true;
            case 2131493391:
                this.s.x();
                return true;
            case 2131493392:
                b(null);
                return true;
        }
        switch (e.a[this.q.ordinal()]) {
            default:
                return true;
            case 1:
                a(m.d);
                return true;
        }
        a(m.d);
        return true;
    }

    protected void onPause() {
        if (this.s != null) {
            this.s.l();
        }
        if (this.q == m.e) {
            if (this.T != null) {
                this.T.cancel();
                this.T = null;
            }
            this.U = false;
        }
        super.onPause();
    }

    public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean) {
        if (this.q == m.c) {
            ((mobi.ifunny.studio.comics.engine.a.a) this.s.r().b()).b(i(paramInt));
        }
        while (this.q != m.e) {
            return;
        }
        this.U = true;
        this.V = paramInt;
    }

    protected void onResume() {
        super.onResume();
        this.s.m();
        ((EditorView) findViewById(2131493099)).requestFocus();
        a(this.r);
        if ((L == null) && (!e("rest.getAllRages"))) {
            IFunnyRestRequest.Studio.getComicsSources(this, "rest.getAllRages", Y);
        }
    }

    protected void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        m localm = this.q;
        if (this.q == m.c) {
            t = ((mobi.ifunny.studio.comics.engine.a.a) this.s.r().b()).a();
            a(m.a);
        }
        while (this.q != m.e) {
            D();
            this.r = localm;
            paramBundle.putSerializable("SAVE_INSTANCE_STATE", localm);
            paramBundle.putInt("SAVE_INSTANCE_SELECTED_CATEGORY", I);
            paramBundle.putParcelable("SAVE_INSTANCE_SELECTED_CAPTURE_URI", this.K);
            return;
        }
        paramBundle.putString("SAVE_INSTANCE_EDITING", this.H);
        paramBundle.putInt("SAVE_INSTANCE_TEXT_COLOR", this.F);
        paramBundle.putFloat("SAVE_INSTANCE_TEXT_SIZE", this.G);
        paramBundle.putInt("SAVE_INSTANCE_TEXT_TYPEFACE_INDEX", this.E);
        if (u != null) {
        }
        for (boolean bool = true; ; bool = false) {
            paramBundle.putBoolean("SAVE_INSTANCE_TEXT_IS_EDITING", bool);
            break;
        }
    }

    protected void onStart() {
        super.onStart();
        L();
    }

    public void onStartTrackingTouch(SeekBar paramSeekBar) {
        if (this.q == m.e) {
            if (this.T != null) {
                this.T.cancel();
            }
            this.T = new Timer(true);
            this.T.schedule(new c(this), 200L, 700L);
            this.U = false;
        }
    }

    protected void onStop() {
        this.s.p();
        super.onStop();
    }

    public void onStopTrackingTouch(SeekBar paramSeekBar) {
        if (this.q == m.e) {
            h(paramSeekBar.getProgress());
            if (this.T != null) {
                this.T.cancel();
                this.T = null;
            }
        }
    }

    public void p() {
        M();
    }

    public void q() {
        M();
    }

    protected void r() {
        setResult(-1, null);
        finish();
    }

    protected void s() {
        if ((g) f().a("dialog.progress") == null) {
            mobi.ifunny.fragment.h.a(this, new String[]{o}).a(f(), "dialog.progress");
        }
    }

    protected void t() {
        g localg = (g) f().a("dialog.progress");
        if (localg != null) {
            localg.b();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/comics/FrameEditorActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */