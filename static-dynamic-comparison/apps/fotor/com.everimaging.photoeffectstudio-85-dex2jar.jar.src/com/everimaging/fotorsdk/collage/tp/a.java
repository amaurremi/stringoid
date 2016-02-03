package com.everimaging.fotorsdk.collage.tp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Parcelable;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.GridView;
import android.widget.ImageView;
import com.everimaging.fotorsdk.collage.R.id;
import com.everimaging.fotorsdk.collage.R.layout;
import com.everimaging.fotorsdk.collage.R.string;
import com.everimaging.fotorsdk.collage.entity.Template;
import com.everimaging.fotorsdk.collage.entity.ui.TemplateCategory;
import com.everimaging.fotorsdk.collage.entity.ui.TemplateCategory.TemplatePackType;
import com.everimaging.fotorsdk.collage.f;
import com.everimaging.fotorsdk.collage.params.TemplateParam;
import com.everimaging.fotorsdk.collage.utils.TemplateThumbnailCreator;
import com.everimaging.fotorsdk.collage.utils.TemplateThumbnailCreator.ThumbnailState;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;
import com.everimaging.fotorsdk.plugins.h.b;
import com.everimaging.fotorsdk.utils.SystemUtils;
import com.everimaging.fotorsdk.widget.FotorCustomViewPager;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class a
        extends BaseVFragment
        implements ViewPager.OnPageChangeListener {
    private static final String o = a.class.getSimpleName();
    private static final FotorLoggerFactory.c p = FotorLoggerFactory.a(o, FotorLoggerFactory.LoggerType.CONSOLE);
    private com.everimaging.fotorsdk.collage.utils.c q;
    private b r;

    public a(f paramf) {
        super(paramf);
        p.c(new Object[]{"onCreate:"});
        int i = (int) (SystemUtils.getApplicationTotalMemory() * 1024.0D * 1024.0D / 3.0D);
        this.q = com.everimaging.fotorsdk.collage.utils.c.a();
    }

    public int a() {
        return R.string.fotor_collage_template_classic;
    }

    protected void a(Context paramContext, List<TemplateCategory> paramList) {
        if (this.m.l()) {
            TemplateCategory localTemplateCategory = new TemplateCategory();
            localTemplateCategory.a(this.n.getText(R.string.fotor_store_title));
            localTemplateCategory.a(TemplateCategory.TemplatePackType.STORE);
            paramList.add(localTemplateCategory);
        }
        paramList.addAll(a(paramContext, 7));
        paramList.addAll(a(paramContext, "collage_template_config", 7));
    }

    public void a(List<TemplateCategory> paramList) {
        super.a(paramList);
        p.c(new Object[]{"onCategoryLoadCompleted mCategoryDatas:" + this.g});
        if (paramList != null) {
            if (this.r == null) {
                this.r = new b(paramList);
                this.a.setAdapter(this.r);
            }
        } else {
            return;
        }
        this.r.a(paramList);
    }

    public void b() {
        super.b();
        p.c(new Object[]{"onAttached:" + this.g});
    }

    public void c() {
        super.c();
        if ((this.g != null) && (this.r == null)) {
            this.r = new b(this.g);
            this.a.setAdapter(this.r);
        }
        while ((this.g == null) || (this.r == null)) {
            return;
        }
        this.r.b();
    }

    public void d() {
        super.d();
        if (this.r != null) {
            this.r.a();
        }
    }

    public void e() {
        super.e();
    }

    protected void finalize()
            throws Throwable {
        super.finalize();
    }

    protected String g() {
        return com.everimaging.fotorsdk.store.utils.c.e;
    }

    protected int k() {
        return 7;
    }

    class a
            extends BaseVFragment.a {
        private final String g = a.class.getSimpleName();
        private final FotorLoggerFactory.c h = FotorLoggerFactory.a(this.g, FotorLoggerFactory.LoggerType.CONSOLE);
        private int i = 120;
        private GridView j;
        private Parcelable k;

        public a(f paramf, TemplateCategory paramTemplateCategory, int paramInt) {
            super(paramf, paramTemplateCategory, paramInt);
        }

        private void g() {
            this.h.c(new Object[]{"bind data"});
            if (this.a != null) {
                this.b = new a(this.a.d(), this.a.e());
                this.j.setAdapter(this.b);
                this.j.setOnItemClickListener(this);
            }
        }

        public View a(LayoutInflater paramLayoutInflater) {
            this.h.c(new Object[]{"onCreateView"});
            paramLayoutInflater = paramLayoutInflater.inflate(R.layout.fotor_collage_template_picker_classic_gridview, null);
            this.j = ((GridView) paramLayoutInflater.findViewById(R.id.fotor_collage_template_classic_gridview));
            this.j.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    int i = a.a.a(a.a.this).getWidth();
                    a.a.a(a.a.this, i / 4);
                    a.a.b(a.a.this).c(new Object[]{"GridView layout listener:" + a.a.a(a.a.this).getWidth()});
                    if (a.a.c(a.a.this) > 0) {
                        a.a.a(a.a.this).getViewTreeObserver().removeGlobalOnLayoutListener(this);
                        a.a.d(a.a.this);
                    }
                }
            });
            return paramLayoutInflater;
        }

        public void b() {
            super.b();
        }

        public void d() {
            if (this.j != null) {
                this.k = this.j.onSaveInstanceState();
            }
        }

        public void e() {
            super.e();
            this.h.c(new Object[]{"onDetach"});
        }

        public void f() {
            if ((this.k != null) && (this.j != null)) {
                this.j.onRestoreInstanceState(this.k);
                this.k = null;
            }
        }

        public class a
                extends b {
            private h.b c;

            public a(h.b paramb) {
                super();
                h.b localb;
                this.c = localb;
            }

            private StateListDrawable a(com.everimaging.fotorsdk.collage.entity.ui.b paramb) {
                if (a.a(a.this) != null) {
                    Object localObject1 = paramb.a().getName();
                    String str1 = (String) localObject1 + "_default";
                    String str2 = (String) localObject1 + "_pressed";
                    localObject1 = a.a(a.this).a(str1);
                    Bitmap localBitmap = a.a(a.this).a(str2);
                    if ((localObject1 != null) && (!((Bitmap) localObject1).isRecycled()) && (localBitmap != null)) {
                        localObject2 = localBitmap;
                        if (!localBitmap.isRecycled()) {
                        }
                    } else {
                        localObject1 = TemplateThumbnailCreator.a(a.a.this.n, paramb.a(), this.c, TemplateThumbnailCreator.ThumbnailState.NORMAL, 0, a.a.c(a.a.this));
                        localObject2 = TemplateThumbnailCreator.a(a.a.this.n, paramb.a(), this.c, TemplateThumbnailCreator.ThumbnailState.PRESSED, 0, a.a.c(a.a.this));
                        a.a(a.this).a(str1, (Bitmap) localObject1);
                        a.a(a.this).a(str2, (Bitmap) localObject2);
                    }
                    paramb = new StateListDrawable();
                    Object localObject2 = new BitmapDrawable(a.a.this.n.getResources(), (Bitmap) localObject2);
                    paramb.addState(new int[]{16842919}, (Drawable) localObject2);
                    paramb.addState(new int[]{16842913}, (Drawable) localObject2);
                    paramb.addState(new int[]{16842908}, (Drawable) localObject2);
                    localObject1 = new BitmapDrawable(a.a.this.n.getResources(), (Bitmap) localObject1);
                    paramb.addState(new int[]{0}, (Drawable) localObject1);
                    return paramb;
                }
                return null;
            }

            public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
                paramViewGroup = LayoutInflater.from(a.a.this.n);
                com.everimaging.fotorsdk.collage.entity.ui.b localb = (com.everimaging.fotorsdk.collage.entity.ui.b) this.b.get(paramInt);
                View localView;
                if (paramView == null) {
                    localView = paramViewGroup.inflate(R.layout.fotor_collage_template_picker_classic_grid_item, null);
                    paramView = new a();
                    paramView.a = ((ImageView) localView.findViewById(R.id.fotor_collage_template_icon_view));
                    paramViewGroup = paramView;
                }
                for (; ; ) {
                    a.a.b(a.a.this).c(new Object[]{"item view size:" + localView.getWidth(), "h:" + localView.getHeight()});
                    paramViewGroup.a.setImageDrawable(a(localb));
                    paramViewGroup.a.setTag(Integer.valueOf(paramInt));
                    paramViewGroup.a.setSelected(false);
                    if ((com.everimaging.fotorsdk.collage.a.a != null) && (localb.a().getName().equals(com.everimaging.fotorsdk.collage.a.a.getTemplate().getName()))) {
                        paramViewGroup.a.setSelected(true);
                    }
                    localView.setTag(paramViewGroup);
                    return localView;
                    paramViewGroup = (a) paramView.getTag();
                    localView = paramView;
                }
            }

            class a {
                ImageView a;

                a() {
                }
            }
        }
    }

    private class b
            extends BaseVFragment.d {
        public b() {
            super(localList);
        }

        public void a() {
            Iterator localIterator = this.a.entrySet().iterator();
            while (localIterator.hasNext()) {
                ((a.a) ((Map.Entry) localIterator.next()).getValue()).d();
            }
        }

        public BaseVFragment.a b(int paramInt) {
            a.a locala = new a.a(a.this, a.this.m, c(paramInt), paramInt);
            locala.a(a.this.h);
            return locala;
        }

        public void b() {
            Iterator localIterator = this.a.entrySet().iterator();
            while (localIterator.hasNext()) {
                ((a.a) ((Map.Entry) localIterator.next()).getValue()).f();
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/collage/tp/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */