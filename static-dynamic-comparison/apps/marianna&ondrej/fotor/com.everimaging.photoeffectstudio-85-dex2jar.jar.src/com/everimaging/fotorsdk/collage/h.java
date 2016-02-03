package com.everimaging.fotorsdk.collage;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.everimaging.fotorsdk.collage.entity.Template;
import com.everimaging.fotorsdk.collage.entity.ui.TemplateCategory;
import com.everimaging.fotorsdk.collage.entity.ui.b;
import com.everimaging.fotorsdk.collage.params.TemplateParam;
import com.everimaging.fotorsdk.collage.widget.MagzineImageView;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;
import com.everimaging.fotorsdk.plugins.FeatureInternalPack;
import com.everimaging.fotorsdk.plugins.g;
import com.everimaging.fotorsdk.uil.core.imageaware.c;
import com.everimaging.fotorsdk.utils.BitmapDecodeUtils;
import com.everimaging.fotorsdk.utils.FotorIOUtils;
import com.everimaging.fotorsdk.utils.GridThumbStreamLoader;
import com.everimaging.fotorsdk.utils.GridThumbStreamLoader.IInputStreamReader;
import com.everimaging.fotorsdk.widget.FotorNavigationButton;
import com.everimaging.fotorsdk.widget.lib.hlist.AdapterView;
import com.everimaging.fotorsdk.widget.lib.hlist.AdapterView.c;
import com.everimaging.fotorsdk.widget.lib.hlist.HListView;

import java.io.File;
import java.io.InputStream;
import java.util.List;

public class h
        extends FooterBase
        implements View.OnClickListener, AdapterView.c {
    private static final String d = h.class.getSimpleName();
    private static final FotorLoggerFactory.c e = FotorLoggerFactory.a(d, FotorLoggerFactory.LoggerType.CONSOLE);
    private HListView f;
    private TemplateCategory g;
    private a h;
    private Template i;
    private FotorNavigationButton j;

    public h(f paramf) {
        super(paramf);
    }

    private void d() {
        e.c(new Object[]{"initDatas:" + this.g});
        this.j.setOnClickListener(this);
        if (this.g != null) {
            this.h = new a(this.g.d(), (com.everimaging.fotorsdk.plugins.h.a) this.g.e());
            this.f.setAdapter(this.h);
            this.f.setVisibility(4);
            this.f.setOnItemClickListener(this);
            this.c.e().post(new Runnable() {
                public void run() {
                    h.a(h.this).notifyDataSetChanged();
                    h.b(h.this).setVisibility(0);
                }
            });
            return;
        }
        throw new IllegalStateException("data source not be setted.");
    }

    protected View a(LayoutInflater paramLayoutInflater) {
        paramLayoutInflater = paramLayoutInflater.inflate(R.layout.fotor_collage_magzine_footer, null);
        this.f = ((HListView) paramLayoutInflater.findViewById(R.id.fotor_collage_magzine_footer_list));
        this.j = ((FotorNavigationButton) paramLayoutInflater.findViewById(R.id.fotor_collage_magzine_footer_template));
        d();
        return paramLayoutInflater;
    }

    public FooterBase.FooterType a() {
        return FooterBase.FooterType.MAGZINE;
    }

    public void a(final Template paramTemplate) {
        e.c(new Object[]{"selected template :" + paramTemplate.getName()});
        this.i = paramTemplate;
        if (this.h != null) {
            this.h.notifyDataSetChanged();
            this.c.e().post(new Runnable() {
                public void run() {
                    h.b(h.this).setSelection(h.a(h.this).a(paramTemplate));
                }
            });
        }
    }

    public void a(TemplateCategory paramTemplateCategory) {
        if ((this.g != null) && (paramTemplateCategory == null)) {
            e.d(new Object[]{"come from internal change."});
            return;
        }
        if ((this.g != null) && (this.g != paramTemplateCategory)) {
            this.h = new a(paramTemplateCategory.d(), (com.everimaging.fotorsdk.plugins.h.a) paramTemplateCategory.e());
            this.f.setAdapter(this.h);
        }
        this.g = paramTemplateCategory;
    }

    public void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
        paramAdapterView = this.h.a(paramInt - this.f.getHeaderViewsCount());
        if (paramAdapterView.a().getName().equals(this.i.getName())) {
            return;
        }
        paramView = new TemplateParam();
        paramView.setFeaturePack(((g) this.g.e()).d().copy());
        paramView.setTemplate(new Template(paramAdapterView.a()));
        if (this.a != null) {
            this.a.a(this, paramView);
        }
        this.i = paramAdapterView.a();
        this.h.notifyDataSetChanged();
    }

    public void onClick(View paramView) {
        if (this.a != null) {
            this.a.a(this, null);
        }
    }

    class a
            extends BaseAdapter
            implements GridThumbStreamLoader.IInputStreamReader {
        private List<b> b;
        private com.everimaging.fotorsdk.plugins.h.a c;
        private LayoutInflater d;
        private GridThumbStreamLoader e;

        public a(com.everimaging.fotorsdk.plugins.h.a parama) {
            this.b = parama;
            com.everimaging.fotorsdk.plugins.h.a locala;
            this.c = locala;
            this.d = LayoutInflater.from(h.this.b);
            this.e = k.a(h.this.b);
        }

        public int a(Template paramTemplate) {
            if ((paramTemplate != null) && (this.b != null)) {
                int i = 0;
                while (i < this.b.size()) {
                    if (((b) this.b.get(i)).a().getName().equals(paramTemplate.getName())) {
                        return i;
                    }
                    i += 1;
                }
            }
            return -1;
        }

        public b a(int paramInt) {
            return (b) this.b.get(paramInt);
        }

        protected void finalize()
                throws Throwable {
            super.finalize();
            if (this.e != null) {
                this.e.clearMemory();
            }
        }

        public int getCount() {
            if (this.b == null) {
                return 0;
            }
            return this.b.size();
        }

        public long getItemId(int paramInt) {
            return paramInt;
        }

        public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
            Object localObject;
            int[] arrayOfInt;
            String str;
            if (paramView == null) {
                paramView = this.d.inflate(R.layout.fotor_collage_magzine_footer_list_item, null);
                localObject = (MagzineImageView) paramView.findViewById(R.id.fotor_collage_magzine_footer_list_item_image);
                paramViewGroup = new a();
                paramViewGroup.a = ((MagzineImageView) localObject);
                localObject = (b) this.b.get(paramInt);
                arrayOfInt = new int[2];
                str = ((b) localObject).a().getMediumThumbnail();
                if ((((b) localObject).b() <= 0) || (((b) localObject).c() <= 0)) {
                    break label350;
                }
                h.c().c(new Object[]{"use cache width and height:" + ((b) localObject).b(), Integer.valueOf(((b) localObject).c())});
                arrayOfInt[0] = ((b) localObject).b();
                arrayOfInt[1] = ((b) localObject).c();
            }
            for (; ; ) {
                if (arrayOfInt[0] > 0) {
                    float f = arrayOfInt[0] / arrayOfInt[1];
                    paramViewGroup.a.setWidthRatio(f);
                }
                this.e.displayImage(new c(paramViewGroup.a, false), this, h.c(h.this).a() + File.separator + str, str, null);
                paramViewGroup.a.setSelected(false);
                if (((b) localObject).a().getName().equals(h.d(h.this).getName())) {
                    paramViewGroup.a.setSelected(true);
                }
                paramViewGroup.a.setTag(Integer.valueOf(paramInt));
                paramView.setTag(paramViewGroup);
                h.c().c(new Object[]{"Position :" + paramInt + " Magzine footer getview completion."});
                return paramView;
                paramViewGroup = (a) paramView.getTag();
                break;
                label350:
                InputStream localInputStream = ((com.everimaging.fotorsdk.plugins.h.a) h.c(h.this).e()).a(str);
                BitmapDecodeUtils.decodeImageBounds(localInputStream, arrayOfInt);
                FotorIOUtils.closeSilently(localInputStream);
                ((b) localObject).a(arrayOfInt[0]);
                ((b) localObject).b(arrayOfInt[1]);
            }
        }

        public void notifyDataSetChanged() {
            super.notifyDataSetChanged();
        }

        public InputStream readInputStream(String paramString) {
            return this.c.a(paramString);
        }

        class a {
            MagzineImageView a;

            a() {
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/collage/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */