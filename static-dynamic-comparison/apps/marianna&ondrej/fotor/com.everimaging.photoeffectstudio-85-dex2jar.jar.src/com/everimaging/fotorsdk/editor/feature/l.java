package com.everimaging.fotorsdk.editor.feature;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.Layout.Alignment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.everimaging.fotorsdk.algorithms.filter.params.BaseParams;
import com.everimaging.fotorsdk.app.FotorAlertDialog;
import com.everimaging.fotorsdk.app.FotorAlertDialog.a;
import com.everimaging.fotorsdk.editor.FotorFeaturesFactory.FeatureType;
import com.everimaging.fotorsdk.editor.R.anim;
import com.everimaging.fotorsdk.editor.R.dimen;
import com.everimaging.fotorsdk.editor.R.id;
import com.everimaging.fotorsdk.editor.R.layout;
import com.everimaging.fotorsdk.editor.R.string;
import com.everimaging.fotorsdk.editor.filter.params.TextsParams;
import com.everimaging.fotorsdk.editor.filter.params.TextsParams.a;
import com.everimaging.fotorsdk.editor.widget.FotorTextCanvasView;
import com.everimaging.fotorsdk.editor.widget.FotorTextCanvasView.a;
import com.everimaging.fotorsdk.editor.widget.d;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;
import com.everimaging.fotorsdk.plugins.FeatureInternalPack;
import com.everimaging.fotorsdk.plugins.FeaturePack.b;
import com.everimaging.fotorsdk.plugins.FeaturePurchasedPack;
import com.everimaging.fotorsdk.plugins.UpdateType;
import com.everimaging.fotorsdk.services.PluginService;
import com.everimaging.fotorsdk.services.PluginService.e;
import com.everimaging.fotorsdk.services.PluginService.f;
import com.everimaging.fotorsdk.store.db.entity.PurchasedPack;
import com.everimaging.fotorsdk.store.g;
import com.everimaging.fotorsdk.utils.BitmapUtils;
import com.everimaging.fotorsdk.utils.DeviceUtils;
import com.everimaging.fotorsdk.utils.FotorAsyncTask;
import com.everimaging.fotorsdk.utils.SimpleStatusMachine;
import com.everimaging.fotorsdk.utils.Utils;
import com.everimaging.fotorsdk.widget.FotorImageView;
import com.everimaging.fotorsdk.widget.FotorImageView.b;
import com.everimaging.fotorsdk.widget.FotorNavigationButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class l
        extends k
        implements FotorTextCanvasView.a, com.everimaging.fotorsdk.input.a.a, PluginService.e, PluginService.f, FotorImageView.b {
    private static final String l = l.class.getSimpleName();
    private static final FotorLoggerFactory.c m = FotorLoggerFactory.a(l, FotorLoggerFactory.LoggerType.CONSOLE);
    private ImageButton A;
    private ImageButton B;
    private ImageButton C;
    private ImageButton D;
    private ImageButton G;
    private ImageButton H;
    private PluginService I;
    private LinearLayout J;
    private boolean K = false;
    private FotorAlertDialog L;
    private View.OnClickListener M = new View.OnClickListener() {
        public void onClick(View paramAnonymousView) {
            if (l.a(l.this).getCurrentStatus() == 1) {
                return;
            }
            l.c(l.this).d(l.b(l.this));
            com.everimaging.fotorsdk.a.a("EDIT_TEXT_ADD");
        }
    };
    private View.OnClickListener N = new View.OnClickListener() {
        public void onClick(View paramAnonymousView) {
            ImageButton localImageButton = (ImageButton) paramAnonymousView;
            if (localImageButton == l.e(l.this)) {
                return;
            }
            if (localImageButton != l.f(l.this)) {
                paramAnonymousView = "Unknow";
                if (localImageButton == l.g(l.this)) {
                    l.a(l.this, null);
                    l.c(l.this).a(false);
                    paramAnonymousView = "EDIT_TEXT_KEYBOARD";
                    if (l.e(l.this) != null) {
                        l.e(l.this).setSelected(false);
                    }
                    l.a(l.this, localImageButton);
                    l.e(l.this).setSelected(true);
                    com.everimaging.fotorsdk.a.a(paramAnonymousView);
                    return;
                }
                if (localImageButton == l.h(l.this)) {
                    l.a(l.this, l.i(l.this).a());
                    paramAnonymousView = "EDIT_TEXT_FONT";
                }
                for (; ; ) {
                    l.c(l.this).a();
                    break;
                    if (localImageButton == l.j(l.this)) {
                        l.a(l.this, l.k(l.this).a());
                        paramAnonymousView = "EDIT_TEXT_COLOR";
                    } else if (localImageButton == l.l(l.this)) {
                        l.a(l.this, l.m(l.this).a());
                        paramAnonymousView = "EDIT_TEXT_OPTION";
                    }
                }
            }
            l.n(l.this);
        }
    };
    private TextFeatureTypefaceController.e O = new TextFeatureTypefaceController.e() {
        public void a() {
        }

        public void a(TextFeatureTypefaceController.TypefaceInfo paramAnonymousTypefaceInfo) {
            l.c(l.this).setCurrentTypeface(paramAnonymousTypefaceInfo);
            int i = l.a(l.this, paramAnonymousTypefaceInfo);
            l.m(l.this).a(i);
        }

        public void a(FeaturePurchasedPack paramAnonymousFeaturePurchasedPack) {
            l.this.a(paramAnonymousFeaturePurchasedPack);
        }

        public void b() {
        }

        public boolean c() {
            return l.a(l.this).getCurrentStatus() != 0;
        }
    };
    private m.a P = new m.a() {
        public void a(int paramAnonymousInt) {
            l.c(l.this).setCurrentTextColor(paramAnonymousInt);
        }

        public void a(String paramAnonymousString) {
            l.c(l.this).setCurrentTextureId(paramAnonymousString);
        }
    };
    private TextFeatureOptionController.a Q = new TextFeatureOptionController.a() {
        public void a(int paramAnonymousInt) {
            if (l.o(l.this).getVisibility() == 0) {
                l.c(l.this).setCurrentTextOpacity(paramAnonymousInt);
            }
        }

        public void a(Layout.Alignment paramAnonymousAlignment) {
            l.c(l.this).setCurrentTextAlignment(paramAnonymousAlignment);
        }

        public void a(TextFeatureOptionController.ShadowType paramAnonymousShadowType) {
            l.c(l.this).setCurrentTextShadow(paramAnonymousShadowType);
        }

        public void a(boolean paramAnonymousBoolean) {
            l.c(l.this).b(paramAnonymousBoolean);
        }

        public void b(boolean paramAnonymousBoolean) {
            l.c(l.this).c(paramAnonymousBoolean);
        }

        public void c(boolean paramAnonymousBoolean) {
            l.c(l.this).setCurrentTextItalic(paramAnonymousBoolean);
        }

        public void d(boolean paramAnonymousBoolean) {
            l.c(l.this).setCurrentTextBold(paramAnonymousBoolean);
        }
    };
    private LinearLayout n;
    private FrameLayout o;
    private FrameLayout p;
    private TextFeatureTypefaceController q;
    private m r;
    private TextFeatureOptionController s;
    private FotorImageView t;
    private FotorTextCanvasView u;
    private com.everimaging.fotorsdk.input.a v;
    private RectF w = new RectF();
    private boolean x = false;
    private FotorNavigationButton y;
    private SimpleStatusMachine z;

    public l(com.everimaging.fotorsdk.editor.c paramc) {
        super(paramc);
    }

    private d L() {
        d locald = new d(this.h);
        locald.a(this.r.b());
        locald.a(this.q.b());
        locald.a(this.s.b());
        locald.a(this.s.c());
        locald.b(this.s.d());
        this.u.a(locald);
        return locald;
    }

    private void M() {
        Object localObject = this.u.getCurrentItemBounds();
        if (((RectF) localObject).bottom > this.w.bottom) {
            ((RectF) localObject).bottom = this.w.bottom;
        }
        float f2 = this.h.getResources().getDimension(R.dimen.fotor_text_keyboard_canvas_spacing);
        float f1 = this.a.a().o().getHeight() + ((RectF) localObject).bottom;
        localObject = (FrameLayout.LayoutParams) this.n.getLayoutParams();
        int i = View.MeasureSpec.makeMeasureSpec(0, 0);
        int j = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.n.measure(i, j);
        j = ((FrameLayout.LayoutParams) localObject).bottomMargin;
        i = this.n.getMeasuredHeight();
        localObject = (EditText) this.n.findViewById(R.id.fotor_feature_text_editor);
        if (((EditText) localObject).getLineCount() < 2) {
            Rect localRect = new Rect();
            ((EditText) localObject).getLineBounds(0, localRect);
            i = (2 - ((EditText) localObject).getLineCount()) * localRect.height() + i;
        }
        for (; ; ) {
            f2 = DeviceUtils.getScreenHeight() - i - j - f2;
            if (f1 > f2) {
            }
            for (i = (int) (f1 - f2); ; i = 0) {
                localObject = this.t.getImageViewMatrix();
                ((Matrix) localObject).postTranslate(0.0F, -i);
                this.t.setImageMatrix((Matrix) localObject);
                this.u.setDrawOffsetY(-i);
                return;
            }
        }
    }

    private void N() {
        this.t.setImageMatrix(this.t.getImageViewMatrix());
        this.u.setDrawOffsetY(0.0F);
        this.n.setVisibility(4);
        this.u.a();
        this.u.setIsToolsPanelDisplay(false);
        this.u.setIsKeyboardDisplay(false);
    }

    private void O() {
        if (this.H != null) {
            this.H.setSelected(false);
        }
        this.H = this.A;
        this.H.setSelected(true);
        a(null);
        d locald = this.u.getCurrentItem();
        if (locald != null) {
            TextFeatureTypefaceController.TypefaceInfo localTypefaceInfo = locald.p();
            Object localObject = localTypefaceInfo.title;
            this.q.a((String) localObject);
            int i = locald.m();
            localObject = locald.n();
            this.r.a(i, (String) localObject);
            boolean bool1 = locald.r();
            boolean bool2 = locald.q();
            localObject = locald.s();
            TextFeatureOptionController.ShadowType localShadowType = locald.t();
            i = locald.u();
            this.s.a(bool1, bool2, (Layout.Alignment) localObject, localShadowType, i);
            i = a(localTypefaceInfo);
            this.s.a(i);
        }
    }

    private List<TextsParams.a> P() {
        LinkedList localLinkedList = new LinkedList();
        Iterator localIterator = this.u.getTextItemsList().iterator();
        while (localIterator.hasNext()) {
            d locald = (d) localIterator.next();
            localLinkedList.add(new TextsParams.a(locald.j(), locald.u(), locald.n(), locald.s(), locald.q(), locald.r(), locald.t(), locald.v(), locald.m(), locald.b(), locald.c(), locald.d(), locald.p(), locald.a()));
        }
        return localLinkedList;
    }

    private int a(TextFeatureTypefaceController.TypefaceInfo paramTypefaceInfo) {
        int k = 0;
        String str = paramTypefaceInfo.bold;
        paramTypefaceInfo = paramTypefaceInfo.italic;
        int j;
        if ((str != null) && (!str.isEmpty())) {
            j = 1;
        }
        for (int i = 1; ; i = 0) {
            if ((paramTypefaceInfo != null) && (!paramTypefaceInfo.isEmpty())) {
                i = 2;
                k = 1;
            }
            for (; ; ) {
                int i1 = i;
                if (j != 0) {
                    i1 = i;
                    if (k != 0) {
                        i1 = 3;
                    }
                }
                return i1;
            }
            j = 0;
        }
    }

    private void a(View paramView) {
        this.o.removeAllViews();
        if (paramView != null) {
            FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.o.addView(paramView, localLayoutParams);
        }
    }

    private boolean a(Bundle paramBundle) {
        if ((paramBundle != null) && (paramBundle.containsKey("internal_update_plugins"))) {
            paramBundle = (ArrayList) paramBundle.getSerializable("internal_update_plugins");
            m.c(new Object[]{"updateTypes:" + paramBundle});
            if ((paramBundle != null) && (paramBundle.size() > 0)) {
                paramBundle = paramBundle.iterator();
                while (paramBundle.hasNext()) {
                    if (FeaturePack.b.d(((UpdateType) paramBundle.next()).getPluginType())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void A() {
        this.u.a();
        Bitmap localBitmap = BitmapUtils.createBitmap(this.d);
        this.u.a(localBitmap);
        TextsParams localTextsParams = new TextsParams();
        localTextsParams.setParamObjList(P());
        if (this.b != null) {
            this.b.a(this, localBitmap, new BaseParams[]{localTextsParams});
        }
    }

    public boolean B() {
        N();
        return super.B();
    }

    protected void C() {
        if (this.u.getTextItemsList().size() > 0) {
            this.i = true;
            return;
        }
        this.i = false;
    }

    protected void E() {
        Object localObject3 = "Unknow";
        Object localObject4 = "Unknow";
        Object localObject5 = this.u.getTextItemsList();
        Object localObject2 = localObject4;
        Object localObject1 = localObject3;
        if (localObject5 != null) {
            localObject2 = localObject4;
            localObject1 = localObject3;
            if (((List) localObject5).size() > 0) {
                localObject5 = (d) ((List) localObject5).get(((List) localObject5).size() - 1);
                localObject2 = localObject4;
                localObject1 = localObject3;
                if (localObject5 != null) {
                    localObject3 = Integer.toHexString(((d) localObject5).m());
                    localObject4 = ((d) localObject5).n();
                    localObject2 = localObject3;
                    localObject1 = localObject4;
                    if (((d) localObject5).p() != null) {
                        String str = ((d) localObject5).p().typefacePack.getPackName();
                        localObject2 = ((d) localObject5).p().title;
                        localObject1 = localObject4;
                        localObject5 = localObject3;
                        localObject4 = str;
                        localObject3 = localObject2;
                        localObject2 = localObject1;
                        localObject1 = localObject5;
                    }
                }
            }
        }
        for (; ; ) {
            localObject5 = new HashMap();
            ((Map) localObject5).put("Font_Category", localObject4);
            ((Map) localObject5).put("Font_Class", localObject3);
            ((Map) localObject5).put("Texture_Name", localObject2);
            ((Map) localObject5).put("Color_Value", localObject1);
            com.everimaging.fotorsdk.a.a("EDIT_TEXT_APPLY", (Map) localObject5);
            return;
            localObject3 = localObject1;
            localObject5 = "Unknow";
            localObject4 = "Unknow";
            localObject1 = localObject2;
            localObject2 = localObject3;
            localObject3 = localObject5;
        }
    }

    public void H() {
        super.H();
        if ((this.n.getVisibility() == 0) && (this.H == this.A)) {
            N();
        }
    }

    public void a() {
        if (this.K) {
            RectF localRectF = this.t.getPictureRectF();
            this.u.b(localRectF, this.d.getWidth(), this.d.getHeight());
            this.a.e().postDelayed(new Runnable() {
                public void run() {
                    l.s(l.this).a(l.this);
                }
            }, 100L);
            this.K = false;
        }
    }

    public void a(int paramInt) {
        int i = 0;
        if (!this.x) {
        }
        do {
            return;
            ViewGroup.LayoutParams localLayoutParams = this.o.getLayoutParams();
            if (this.n.getVisibility() != 0) {
                localLayoutParams.height = paramInt;
                this.o.requestLayout();
                O();
                ((FrameLayout.LayoutParams) this.n.getLayoutParams()).gravity = 80;
                this.n.requestLayout();
                this.n.setVisibility(0);
                i = View.MeasureSpec.makeMeasureSpec(0, 0);
                j = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.n.measure(i, j);
                this.u.setIsToolsPanelDisplay(true);
                i = 1;
            }
            int j = localLayoutParams.height;
            ((FrameLayout.LayoutParams) this.n.getLayoutParams()).bottomMargin = (paramInt - j);
            this.n.requestLayout();
            this.u.setIsKeyboardDisplay(true);
        } while (i == 0);
        this.a.e().post(new Runnable() {
            public void run() {
                l.d(l.this);
            }
        });
    }

    public void a(Configuration paramConfiguration) {
        super.a(paramConfiguration);
        this.v.a(null);
        this.K = true;
        N();
    }

    public void a(PluginService paramPluginService, Bundle paramBundle) {
        m.c(new Object[]{"====onUpdate===="});
        if (G()) {
            N();
            if ((paramBundle == null) || (!paramBundle.containsKey("internal_update_is_inapp_mode"))) {
                break label59;
            }
            this.q.c();
            this.q.a(false);
        }
        label59:
        do {
            do {
                return;
            } while (this.F.a());
            paramPluginService = this.a.a().q();
            Fragment localFragment = paramPluginService.getSupportFragmentManager().findFragmentByTag("update_fonts_pack");
            m.c(new Object[]{"showing dialog:" + localFragment});
            if (localFragment != null) {
                m.d(new Object[]{"update alert dialog is showing will return."});
                return;
            }
        } while (!a(paramBundle));
        paramBundle = new Bundle();
        paramBundle.putCharSequence("MESSAGE", this.h.getResources().getString(R.string.fotor_dialog_alert_message_plugin_update).replace("@FeatureName", this.h.getResources().getString(R.string.fotor_plugin_font)));
        paramBundle.putCharSequence("NEUTRAL_BUTTON_TEXT", paramPluginService.getText(17039370));
        this.L = FotorAlertDialog.a();
        this.L.setArguments(paramBundle);
        this.L.setCancelable(false);
        this.L.a(new FotorAlertDialog.a() {
            public void a(FotorAlertDialog paramAnonymousFotorAlertDialog) {
            }

            public void b(FotorAlertDialog paramAnonymousFotorAlertDialog) {
            }

            public void c(FotorAlertDialog paramAnonymousFotorAlertDialog) {
                new l.a(l.this, false).execute(new Void[0]);
            }
        });
        this.L.a(paramPluginService.getSupportFragmentManager(), "update_fonts_pack", true);
    }

    public void b() {
        if (!this.x) {
            return;
        }
        if ((this.n.getVisibility() == 0) && (this.H == this.A)) {
            N();
            return;
        }
        this.u.setIsKeyboardDisplay(false);
        ((FrameLayout.LayoutParams) this.n.getLayoutParams()).bottomMargin = 0;
        this.n.requestLayout();
    }

    protected void b(PurchasedPack paramPurchasedPack, float paramFloat) {
        super.b(paramPurchasedPack, paramFloat);
        if (this.q != null) {
            this.q.a(paramPurchasedPack, paramFloat);
        }
    }

    protected void b(PurchasedPack paramPurchasedPack, int paramInt) {
        super.b(paramPurchasedPack, paramInt);
        if (this.q != null) {
            this.q.a(paramPurchasedPack, paramInt);
        }
    }

    protected void b(PurchasedPack paramPurchasedPack, String paramString) {
        super.b(paramPurchasedPack, paramString);
        if (this.q != null) {
            this.q.a(paramPurchasedPack, paramString);
        }
    }

    public View c(LayoutInflater paramLayoutInflater) {
        return paramLayoutInflater.inflate(R.layout.fotor_feature_text_operation_panel, null);
    }

    protected String c() {
        return com.everimaging.fotorsdk.store.utils.c.d;
    }

    protected void c(PurchasedPack paramPurchasedPack) {
        super.c(paramPurchasedPack);
        if (this.q != null) {
            this.q.a(paramPurchasedPack);
        }
    }

    public View d(LayoutInflater paramLayoutInflater) {
        return paramLayoutInflater.inflate(R.layout.fotor_feature_fitscreen_draw_panel, null);
    }

    public void d() {
        z();
    }

    protected int e() {
        return 64;
    }

    public void f() {
        super.f();
        com.everimaging.fotorsdk.store.c.a().b(this);
        this.I.b(this);
        this.I.b(this);
    }

    public void h() {
        this.a.e().post(new Runnable() {
            public void run() {
                l.d(l.this);
            }
        });
    }

    public void i() {
        N();
    }

    public void j() {
    }

    protected void m() {
        super.m();
        this.t.setImageBitmap(this.d);
        this.a.a(this.u, null);
        this.w = this.t.getPictureRectF();
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams) this.u.getLayoutParams();
        localLayoutParams.width = -1;
        localLayoutParams.height = -1;
        this.u.setLayoutParams(localLayoutParams);
        this.u.a(this.w, this.d.getWidth(), this.d.getHeight());
        this.x = true;
        this.z.setStatus(0);
        new a(true).execute(new Void[0]);
        this.u.setTextCanvasListener(this);
        this.v.a(this);
        this.t.setFotorImageViewLayoutListener(this);
        this.y.setOnClickListener(this.M);
        this.G.setOnClickListener(this.N);
        this.A.setOnClickListener(this.N);
        this.B.setOnClickListener(this.N);
        this.D.setOnClickListener(this.N);
        this.C.setOnClickListener(this.N);
        this.q.a(this.O);
        this.r.a(this.P);
        this.s.a(this.Q);
    }

    public void n() {
        N();
    }

    protected void p() {
        this.z.setStatus(1);
        super.p();
        AnimationSet localAnimationSet = (AnimationSet) AnimationUtils.loadAnimation(this.h, R.anim.fotor_fit_view_fadeout_animation);
        this.u.startAnimation(localAnimationSet);
    }

    protected void q() {
        super.q();
        this.t.setImageBitmap(null);
    }

    protected void t() {
        this.z = new SimpleStatusMachine();
        this.z.setStatus(1);
        this.I = ((PluginService) this.a.a(PluginService.class));
        this.I.a(this);
        this.I.a(this);
    }

    protected void u() {
        LayoutInflater localLayoutInflater = (LayoutInflater) this.h.getSystemService("layout_inflater");
        this.t = ((FotorImageView) w().findViewById(R.id.fotor_fitscreen_imageview));
        this.t.setTouchable(false);
        this.u = new FotorTextCanvasView(this.h);
        this.v = new com.everimaging.fotorsdk.input.a((Activity) this.h);
        this.y = ((FotorNavigationButton) v().findViewById(R.id.fotor_text_add_button));
        this.J = ((LinearLayout) v().findViewById(R.id.fotor_texts_category_loading_container));
        this.n = ((LinearLayout) localLayoutInflater.inflate(R.layout.fotor_feature_text_operation_tools, null));
        this.n.setVisibility(4);
        this.a.c(this.n);
        ((FrameLayout.LayoutParams) this.n.getLayoutParams()).gravity = 48;
        this.n.requestLayout();
        this.p = ((FrameLayout) this.n.findViewById(R.id.fotor_feature_text_input_panel));
        this.u.setInputMaskLayout(this.p);
        this.A = ((ImageButton) this.n.findViewById(R.id.fotor_text_keyboard_button));
        this.B = ((ImageButton) this.n.findViewById(R.id.fotor_text_typeface_button));
        this.C = ((ImageButton) this.n.findViewById(R.id.fotor_text_color_button));
        this.D = ((ImageButton) this.n.findViewById(R.id.fotor_text_option_button));
        this.G = ((ImageButton) this.n.findViewById(R.id.fotor_text_done_button));
        this.o = ((FrameLayout) this.n.findViewById(R.id.fotor_text_operation_container));
        this.o.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent) {
                return true;
            }
        });
        this.q = new TextFeatureTypefaceController(this.a, this.F, this.I, this.e, this.d);
        this.r = new m(this.h);
        this.s = new TextFeatureOptionController(this.h);
    }

    public FotorFeaturesFactory.FeatureType x() {
        return FotorFeaturesFactory.FeatureType.TEXT;
    }

    public String y() {
        return this.h.getString(R.string.fotor_feature_text);
    }

    public boolean z() {
        if (this.z.getCurrentStatus() == 1) {
            return true;
        }
        if (this.n.getVisibility() == 0) {
            N();
            return true;
        }
        return super.z();
    }

    private class a
            extends FotorAsyncTask<Void, Void, Void> {
        private boolean b;

        public a(boolean paramBoolean) {
            this.b = paramBoolean;
        }

        protected Void a(Void... paramVarArgs) {
            while (!l.r(l.this).b()) {
                Utils.sleep(50);
                l.J().b(new Object[]{"waiting for plugin service"});
            }
            int i = 0;
            int j;
            do {
                if (l.r(l.this).a(6)) {
                    break;
                }
                j = i + 1;
                Utils.sleep(10);
                i = j;
            } while (j <= 300);
            while (!l.r(l.this).c()) {
                Utils.sleep(50);
                l.J().b(new Object[]{"waiting for plugin service init build-in and downloaded list"});
            }
            l.i(l.this).c();
            return null;
        }

        protected void a(Void paramVoid) {
            if (l.this.G()) {
                l.i(l.this).a(this.b);
                l.p(l.this).setVisibility(4);
                l.q(l.this).setVisibility(0);
                if (this.b) {
                    l.c(l.this).d(l.b(l.this));
                }
                com.everimaging.fotorsdk.store.c.a().a(l.this);
                l.a(l.this).setStatus(0);
            }
        }

        protected void onPreExecute() {
            l.a(l.this).setStatus(1);
            l.p(l.this).setVisibility(0);
            l.q(l.this).setVisibility(4);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/editor/feature/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */