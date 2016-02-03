package com.everimaging.fotorsdk.editor.feature;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.everimaging.fotorsdk.editor.R.color;
import com.everimaging.fotorsdk.editor.R.dimen;
import com.everimaging.fotorsdk.editor.R.drawable;
import com.everimaging.fotorsdk.editor.R.id;
import com.everimaging.fotorsdk.editor.R.layout;
import com.everimaging.fotorsdk.widget.FotorTextColorsBtn;
import com.everimaging.fotorsdk.widget.FotorTextTexturesBtn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class m {
    private Context a;
    private View b;
    private ImageButton c;
    private ImageButton d;
    private ImageButton e;
    private FrameLayout f;
    private LinearLayout g;
    private LinearLayout h;
    private int i;
    private List<FotorTextColorsBtn> j;
    private List<FotorTextTexturesBtn> k;
    private FotorTextColorsBtn l;
    private FotorTextTexturesBtn m;
    private a n;
    private HashMap<String, FotorTextColorsBtn> o;
    private HashMap<String, FotorTextTexturesBtn> p;
    private View.OnClickListener q = new View.OnClickListener() {
        public void onClick(View paramAnonymousView) {
            paramAnonymousView = (ImageButton) paramAnonymousView;
            if (paramAnonymousView != m.a(m.this)) {
                if (paramAnonymousView != m.b(m.this)) {
                    break label83;
                }
                m.a(m.this, m.c(m.this));
            }
            for (; ; ) {
                if (m.a(m.this) != null) {
                    m.a(m.this).setSelected(false);
                }
                m.a(m.this, paramAnonymousView);
                m.a(m.this).setSelected(true);
                return;
                label83:
                if (paramAnonymousView == m.d(m.this)) {
                    m.a(m.this, m.e(m.this));
                }
            }
        }
    };
    private View.OnClickListener r = new View.OnClickListener() {
        public void onClick(View paramAnonymousView) {
            paramAnonymousView = (FotorTextColorsBtn) paramAnonymousView;
            if (paramAnonymousView != m.f(m.this)) {
                if (m.f(m.this) != null) {
                    m.f(m.this).setSelected(false);
                }
                m.a(m.this, paramAnonymousView);
                m.f(m.this).setSelected(true);
                if (m.g(m.this) != null) {
                    m.g(m.this).setSelected(false);
                    m.a(m.this, null);
                }
                if (m.h(m.this) != null) {
                    m.h(m.this).a(m.f(m.this).getColor());
                }
                paramAnonymousView = String.valueOf(m.f(m.this).getColor());
                if (!m.i(m.this).containsKey(paramAnonymousView)) {
                    m.i(m.this).put(paramAnonymousView, m.f(m.this));
                }
            }
        }
    };
    private View.OnClickListener s = new View.OnClickListener() {
        public void onClick(View paramAnonymousView) {
            paramAnonymousView = (FotorTextTexturesBtn) paramAnonymousView;
            if (paramAnonymousView != m.g(m.this)) {
                if (m.g(m.this) != null) {
                    m.g(m.this).setSelected(false);
                }
                m.a(m.this, paramAnonymousView);
                m.g(m.this).setSelected(true);
                int i = Integer.parseInt(m.g(m.this).getTag().toString());
                if (m.f(m.this) != null) {
                    m.f(m.this).setSelected(false);
                    m.a(m.this, null);
                }
                if (!m.j(m.this).containsValue(String.valueOf(i))) {
                    m.j(m.this).put(String.valueOf(i), m.g(m.this));
                }
                if (m.h(m.this) != null) {
                    m.h(m.this).a(String.valueOf(i));
                }
            }
        }
    };

    public m(Context paramContext) {
        this.a = paramContext;
        c();
    }

    private void a(View paramView) {
        this.f.removeAllViews();
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        this.f.addView(paramView, localLayoutParams);
    }

    private void c() {
        this.b = ((LayoutInflater) this.a.getSystemService("layout_inflater")).inflate(R.layout.fotor_feature_text_color_panel, null);
        this.c = ((ImageButton) this.b.findViewById(R.id.fotor_text_color_color_button));
        this.c.setOnClickListener(this.q);
        this.d = ((ImageButton) this.b.findViewById(R.id.fotor_text_color_texture_button));
        this.d.setOnClickListener(this.q);
        this.f = ((FrameLayout) this.b.findViewById(R.id.fotor_text_colors_container));
        d();
        e();
        a(this.g);
        this.e = this.c;
        this.e.setSelected(true);
        this.o = new HashMap();
        this.p = new HashMap();
        this.o.put(String.valueOf(this.l.getColor()), this.l);
    }

    private void d() {
        this.j = new ArrayList();
        int i5 = (int) this.a.getResources().getDimension(R.dimen.fotor_text_color_button_size);
        this.g = new LinearLayout(this.a);
        this.g.setOrientation(1);
        this.g.setGravity(1);
        int[] arrayOfInt = new int[28];
        arrayOfInt[0] = R.color.fotor_feature_text_color_button1;
        arrayOfInt[1] = R.color.fotor_feature_text_color_button2;
        arrayOfInt[2] = R.color.fotor_feature_text_color_button3;
        arrayOfInt[3] = R.color.fotor_feature_text_color_button4;
        arrayOfInt[4] = R.color.fotor_feature_text_color_button5;
        arrayOfInt[5] = R.color.fotor_feature_text_color_button6;
        arrayOfInt[6] = R.color.fotor_feature_text_color_button7;
        arrayOfInt[7] = R.color.fotor_feature_text_color_button8;
        arrayOfInt[8] = R.color.fotor_feature_text_color_button9;
        arrayOfInt[9] = R.color.fotor_feature_text_color_button10;
        arrayOfInt[10] = R.color.fotor_feature_text_color_button11;
        arrayOfInt[11] = R.color.fotor_feature_text_color_button12;
        arrayOfInt[12] = R.color.fotor_feature_text_color_button13;
        arrayOfInt[13] = R.color.fotor_feature_text_color_button14;
        arrayOfInt[14] = R.color.fotor_feature_text_color_button15;
        arrayOfInt[15] = R.color.fotor_feature_text_color_button16;
        arrayOfInt[16] = R.color.fotor_feature_text_color_button17;
        arrayOfInt[17] = R.color.fotor_feature_text_color_button18;
        arrayOfInt[18] = R.color.fotor_feature_text_color_button19;
        arrayOfInt[19] = R.color.fotor_feature_text_color_button20;
        arrayOfInt[20] = R.color.fotor_feature_text_color_button21;
        arrayOfInt[21] = R.color.fotor_feature_text_color_button22;
        arrayOfInt[22] = R.color.fotor_feature_text_color_button23;
        arrayOfInt[23] = R.color.fotor_feature_text_color_button24;
        arrayOfInt[24] = R.color.fotor_feature_text_color_button25;
        arrayOfInt[25] = R.color.fotor_feature_text_color_button26;
        arrayOfInt[26] = R.color.fotor_feature_text_color_button27;
        arrayOfInt[27] = R.color.fotor_feature_text_color_button28;
        Object localObject2 = null;
        int i3 = 0;
        int i2 = 0;
        int i1 = 0;
        Object localObject1;
        int i6;
        int i4;
        if (i3 < arrayOfInt.length) {
            localObject1 = localObject2;
            if (localObject2 == null) {
                localObject1 = new LinearLayout(this.a);
                ((LinearLayout) localObject1).setOrientation(0);
                localObject2 = new LinearLayout.LayoutParams(-2, -2, 1.0F);
                this.g.addView((View) localObject1, (ViewGroup.LayoutParams) localObject2);
            }
            i6 = this.a.getResources().getColor(arrayOfInt[i3]);
            localObject2 = new FotorTextColorsBtn(this.a);
            ((FotorTextColorsBtn) localObject2).setColor(i6);
            ((FotorTextColorsBtn) localObject2).setOnClickListener(this.r);
            this.j.add(localObject2);
            ((LinearLayout) localObject1).addView((View) localObject2, i5, i5);
            i4 = i2 + 1;
            if (i1 % 2 == 0) {
                i2 = 6;
                label433:
                if (i4 != i2) {
                    break label490;
                }
                i1 += 1;
                localObject1 = null;
            }
        }
        label490:
        for (i2 = 0; ; i2 = i4) {
            if (i3 == 1) {
                this.i = i6;
                this.l = ((FotorTextColorsBtn) localObject2);
                this.l.setSelected(true);
            }
            i3 += 1;
            localObject2 = localObject1;
            break;
            i2 = 5;
            break label433;
            return;
        }
    }

    private void e() {
        int i4 = this.a.getResources().getColor(R.color.fotor_text_texture_border_selected);
        this.k = new ArrayList();
        int i5 = (int) this.a.getResources().getDimension(R.dimen.fotor_text_texture_button_size);
        this.h = new LinearLayout(this.a);
        this.h.setOrientation(1);
        this.h.setGravity(1);
        int[] arrayOfInt = new int[20];
        arrayOfInt[0] = R.drawable.fotor_text_texture1;
        arrayOfInt[1] = R.drawable.fotor_text_texture2;
        arrayOfInt[2] = R.drawable.fotor_text_texture3;
        arrayOfInt[3] = R.drawable.fotor_text_texture4;
        arrayOfInt[4] = R.drawable.fotor_text_texture5;
        arrayOfInt[5] = R.drawable.fotor_text_texture6;
        arrayOfInt[6] = R.drawable.fotor_text_texture7;
        arrayOfInt[7] = R.drawable.fotor_text_texture8;
        arrayOfInt[8] = R.drawable.fotor_text_texture9;
        arrayOfInt[9] = R.drawable.fotor_text_texture10;
        arrayOfInt[10] = R.drawable.fotor_text_texture11;
        arrayOfInt[11] = R.drawable.fotor_text_texture12;
        arrayOfInt[12] = R.drawable.fotor_text_texture13;
        arrayOfInt[13] = R.drawable.fotor_text_texture14;
        arrayOfInt[14] = R.drawable.fotor_text_texture15;
        arrayOfInt[15] = R.drawable.fotor_text_texture16;
        arrayOfInt[16] = R.drawable.fotor_text_texture17;
        arrayOfInt[17] = R.drawable.fotor_text_texture18;
        arrayOfInt[18] = R.drawable.fotor_text_texture19;
        arrayOfInt[19] = R.drawable.fotor_text_texture20;
        int i2 = 0;
        Object localObject2 = null;
        int i1 = 0;
        while (i2 < arrayOfInt.length) {
            Object localObject1 = localObject2;
            if (localObject2 == null) {
                localObject1 = new LinearLayout(this.a);
                ((LinearLayout) localObject1).setOrientation(0);
                localObject2 = new LinearLayout.LayoutParams(-2, -2, 1.0F);
                this.h.addView((View) localObject1, (ViewGroup.LayoutParams) localObject2);
            }
            localObject2 = new FotorTextTexturesBtn(this.a);
            ((FotorTextTexturesBtn) localObject2).setBorderDefaultColor(-16777216);
            ((FotorTextTexturesBtn) localObject2).setBorderSelectedColor(i4);
            ((FotorTextTexturesBtn) localObject2).setTextureDrawable(this.a.getResources().getDrawable(arrayOfInt[i2]));
            ((FotorTextTexturesBtn) localObject2).setTag(Integer.valueOf(arrayOfInt[i2]));
            ((FotorTextTexturesBtn) localObject2).setOnClickListener(this.s);
            this.k.add(localObject2);
            ((LinearLayout) localObject1).addView((View) localObject2, i5, i5);
            int i3 = i1 + 1;
            i1 = i3;
            if (i3 == 5) {
                localObject1 = null;
                i1 = 0;
            }
            i2 += 1;
            localObject2 = localObject1;
        }
    }

    public View a() {
        return this.b;
    }

    public void a(int paramInt, String paramString) {
        if (this.l != null) {
            this.l.setSelected(false);
        }
        if (this.m != null) {
            this.m.setSelected(false);
        }
        if (this.e != null) {
            this.e.setSelected(false);
        }
        if (paramString != null) {
            this.m = ((FotorTextTexturesBtn) this.p.get(paramString));
            this.m.setSelected(true);
            this.l = null;
            this.e = this.d;
            this.e.setSelected(true);
            a(this.h);
            return;
        }
        this.l = ((FotorTextColorsBtn) this.o.get(String.valueOf(paramInt)));
        this.l.setSelected(true);
        this.m = null;
        this.e = this.c;
        this.e.setSelected(true);
        a(this.g);
    }

    public void a(a parama) {
        this.n = parama;
    }

    public int b() {
        return this.i;
    }

    public static abstract interface a {
        public abstract void a(int paramInt);

        public abstract void a(String paramString);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/editor/feature/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */