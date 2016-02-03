package com.everimaging.fotorsdk.collage.tp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.everimaging.fotorsdk.collage.R.id;
import com.everimaging.fotorsdk.collage.R.layout;
import com.everimaging.fotorsdk.collage.R.string;
import com.everimaging.fotorsdk.collage.a;
import com.everimaging.fotorsdk.collage.entity.Template;
import com.everimaging.fotorsdk.collage.entity.ui.TemplateCategory;
import com.everimaging.fotorsdk.collage.entity.ui.TemplateCategory.TemplatePackType;
import com.everimaging.fotorsdk.collage.f;
import com.everimaging.fotorsdk.collage.k;
import com.everimaging.fotorsdk.collage.params.TemplateParam;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;
import com.everimaging.fotorsdk.plugins.h.a;
import com.everimaging.fotorsdk.utils.BitmapDecodeUtils;
import com.everimaging.fotorsdk.utils.FotorIOUtils;
import com.everimaging.fotorsdk.utils.GridThumbStreamLoader;
import com.everimaging.fotorsdk.utils.GridThumbStreamLoader.IInputStreamReader;
import com.everimaging.fotorsdk.widget.FotorCustomViewPager;
import com.everimaging.fotorsdk.widget.etsy.staggeredgrid.StaggeredGridView;
import com.everimaging.fotorsdk.widget.etsy.staggeredgrid.util.DynamicHeightImageView;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class c
        extends BaseVFragment {
    private static final String o = c.class.getSimpleName();
    private static final FotorLoggerFactory.c p = FotorLoggerFactory.a(o, FotorLoggerFactory.LoggerType.CONSOLE);
    private a q;

    public c(f paramf) {
        super(paramf);
    }

    public int a() {
        return R.string.fotor_collage_template_poster;
    }

    protected void a(Context paramContext, List<TemplateCategory> paramList) {
        if (this.m.l()) {
            TemplateCategory localTemplateCategory = new TemplateCategory();
            localTemplateCategory.a(this.n.getText(R.string.fotor_store_title));
            localTemplateCategory.a(TemplateCategory.TemplatePackType.STORE);
            paramList.add(localTemplateCategory);
        }
        paramList.addAll(a(paramContext, 8));
        paramList.addAll(a(paramContext, "collage_poster_config", 8));
    }

    public void a(List<TemplateCategory> paramList) {
        super.a(paramList);
        if (paramList != null) {
            if (this.q == null) {
                this.q = new a(paramList);
                this.a.setAdapter(this.q);
            }
        } else {
            return;
        }
        this.q.a(paramList);
    }

    public void c() {
        super.c();
        if ((this.g != null) && (this.q == null)) {
            this.q = new a(this.g);
            this.a.setAdapter(this.q);
        }
        while ((this.g == null) || (this.q == null)) {
            return;
        }
        this.q.b();
    }

    public void d() {
        super.d();
        if (this.q != null) {
            this.q.a();
        }
    }

    protected void finalize()
            throws Throwable {
        super.finalize();
    }

    protected String g() {
        return com.everimaging.fotorsdk.store.utils.c.f;
    }

    protected int k() {
        return 8;
    }

    private class a
            extends BaseVFragment.d {
        public a() {
            super(localList);
        }

        public void a() {
            Iterator localIterator = this.a.entrySet().iterator();
            while (localIterator.hasNext()) {
                ((c.b) ((Map.Entry) localIterator.next()).getValue()).d();
            }
        }

        public BaseVFragment.a b(int paramInt) {
            c.b localb = new c.b(c.this, c.this.m, c(paramInt), paramInt);
            localb.a(c.this.h);
            return localb;
        }

        public void b() {
            Iterator localIterator = this.a.entrySet().iterator();
            while (localIterator.hasNext()) {
                ((c.b) ((Map.Entry) localIterator.next()).getValue()).f();
            }
        }
    }

    class b
            extends BaseVFragment.a {
        private StaggeredGridView g;
        private Parcelable h;

        public b(f paramf, TemplateCategory paramTemplateCategory, int paramInt) {
            super(paramf, paramTemplateCategory, paramInt);
        }

        @SuppressLint({"NewApi"})
        private void g() {
            this.b = new a(this.a.d());
            this.g.setAdapter(this.b);
            this.g.setOnItemClickListener(this);
        }

        public View a(LayoutInflater paramLayoutInflater) {
            paramLayoutInflater = paramLayoutInflater.inflate(R.layout.fotor_collage_template_picker_poster_gridview, null);
            this.g = ((StaggeredGridView) paramLayoutInflater.findViewById(R.id.fotor_collage_template_poster_gridview));
            this.g.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    c.b.a(c.b.this).getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    c.b.b(c.b.this);
                }
            });
            return paramLayoutInflater;
        }

        public void d() {
            if (this.g != null) {
                this.h = this.g.onSaveInstanceState();
            }
        }

        public void f() {
            if ((this.h != null) && (this.g != null)) {
                this.g.onRestoreInstanceState(this.h);
                this.h = null;
            }
        }

        public class a
                extends b
                implements GridThumbStreamLoader.IInputStreamReader {
            private GridThumbStreamLoader c = k.a(c.b.this.n);

            public a() {
                super();
            }

            protected void finalize()
                    throws Throwable {
                super.finalize();
                c.m().c(new Object[]{"PosterGrid finalize clear memory:"});
            }

            public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
                com.everimaging.fotorsdk.collage.entity.ui.b localb;
                int[] arrayOfInt;
                String str;
                if (paramView == null) {
                    paramViewGroup = new a();
                    paramView = LayoutInflater.from(c.b.this.n).inflate(R.layout.fotor_collage_template_picker_poster_grid_item, null);
                    paramViewGroup.a = ((DynamicHeightImageView) paramView.findViewById(R.id.fotor_collage_template_icon_view));
                    paramViewGroup.b = paramView.findViewById(R.id.fotor_collage_template_icon_view_mask);
                    paramView.setTag(paramViewGroup);
                    localb = (com.everimaging.fotorsdk.collage.entity.ui.b) this.b.get(paramInt);
                    arrayOfInt = new int[2];
                    str = localb.a().getMediumThumbnail();
                    if ((localb.b() <= 0) || (localb.c() <= 0)) {
                        break label329;
                    }
                    c.m().c(new Object[]{"use cache width and height:" + localb.b(), Integer.valueOf(localb.c())});
                    arrayOfInt[0] = localb.b();
                    arrayOfInt[1] = localb.c();
                }
                for (; ; ) {
                    if (arrayOfInt[1] > 0) {
                        double d = arrayOfInt[1] / arrayOfInt[0];
                        paramViewGroup.a.setHeightRatio(d);
                    }
                    this.c.displayImage(new com.everimaging.fotorsdk.uil.core.imageaware.c(paramViewGroup.a, false), this, c.b.this.a.a() + File.separator + str, str, null);
                    paramViewGroup.b.setSelected(false);
                    if ((a.a != null) && (localb.a().getName().equals(a.a.getTemplate().getName()))) {
                        paramViewGroup.b.setSelected(true);
                    }
                    paramViewGroup.a.setTag(Integer.valueOf(paramInt));
                    return paramView;
                    paramViewGroup = (a) paramView.getTag();
                    break;
                    label329:
                    InputStream localInputStream = ((h.a) c.b.this.a.e()).a(str);
                    BitmapDecodeUtils.decodeImageBounds(localInputStream, arrayOfInt);
                    FotorIOUtils.closeSilently(localInputStream);
                }
            }

            public InputStream readInputStream(String paramString) {
                return ((h.a) c.b.this.a.e()).a(paramString);
            }

            class a {
                DynamicHeightImageView a;
                View b;

                a() {
                }
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/collage/tp/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */