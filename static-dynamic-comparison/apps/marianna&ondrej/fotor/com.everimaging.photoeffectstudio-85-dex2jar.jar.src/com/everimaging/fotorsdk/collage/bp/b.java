package com.everimaging.fotorsdk.collage.bp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import com.everimaging.fotorsdk.collage.R.id;
import com.everimaging.fotorsdk.collage.R.layout;
import com.everimaging.fotorsdk.collage.entity.BackgroundInfo;
import com.everimaging.fotorsdk.collage.entity.ui.BackgroundCategory;
import com.everimaging.fotorsdk.collage.f;
import com.everimaging.fotorsdk.collage.params.BackgroundParam;
import com.everimaging.fotorsdk.collage.tp.e;
import com.everimaging.fotorsdk.collage.utils.c;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;
import com.everimaging.fotorsdk.plugins.FeatureInternalPack;
import com.everimaging.fotorsdk.plugins.g;
import com.everimaging.fotorsdk.plugins.h.a;
import com.everimaging.fotorsdk.utils.BitmapDecodeUtils;
import com.everimaging.fotorsdk.utils.BitmapUtils;
import com.everimaging.fotorsdk.utils.FotorIOUtils;

import java.io.Closeable;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class b
        extends e
        implements AdapterView.OnItemClickListener {
    private static final String a = b.class.getSimpleName();
    private static final FotorLoggerFactory.c b = FotorLoggerFactory.a(a, FotorLoggerFactory.LoggerType.CONSOLE);
    private BackgroundCategory c;
    private Bitmap d;
    private GridView e;
    private a f;
    private b g;

    public b(f paramf, BackgroundCategory paramBackgroundCategory, Bitmap paramBitmap) {
        super(paramf);
        this.c = paramBackgroundCategory;
        this.d = paramBitmap;
    }

    private void c() {
        this.e.setOnItemClickListener(this);
        this.f = new a(this.c.d());
        this.e.setAdapter(this.f);
    }

    public View a(LayoutInflater paramLayoutInflater) {
        paramLayoutInflater = paramLayoutInflater.inflate(R.layout.fotor_collage_background_fragment, null);
        this.e = ((GridView) paramLayoutInflater.findViewById(R.id.fotor_collage_background_grid));
        c();
        return paramLayoutInflater;
    }

    public void a(Bitmap paramBitmap) {
        if ((paramBitmap != null) && (paramBitmap != this.d) && (this.f != null)) {
            this.d = paramBitmap;
            this.f.a();
            this.f.notifyDataSetChanged();
        }
    }

    public void a(b paramb) {
        this.g = paramb;
    }

    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
        b.c(new Object[]{""});
        if (this.g != null) {
            paramAdapterView = this.f.a(paramInt);
            paramView = ((g) this.c.c()).d();
            BackgroundParam localBackgroundParam = new BackgroundParam();
            localBackgroundParam.setBackgroundInfo(new BackgroundInfo(paramAdapterView.a()));
            localBackgroundParam.setFeatureInternalPack(paramView.copy());
            this.g.a(localBackgroundParam);
        }
    }

    class a
            extends BaseAdapter {
        private c b;
        private List<com.everimaging.fotorsdk.collage.entity.ui.a> c;
        private List<Boolean> d;

        public a() {
            List localList;
            this.c = localList;
            this.b = c.a();
            b();
        }

        private void b() {
            this.d = new ArrayList();
            int i = 0;
            while (i < getCount()) {
                this.d.add(Boolean.valueOf(true));
                i += 1;
            }
        }

        public com.everimaging.fotorsdk.collage.entity.ui.a a(int paramInt) {
            return (com.everimaging.fotorsdk.collage.entity.ui.a) this.c.get(paramInt);
        }

        public void a() {
            if (this.d != null) {
                int i = 0;
                while (i < getCount()) {
                    this.d.set(i, Boolean.valueOf(true));
                    i += 1;
                }
            }
            b();
        }

        protected void finalize()
                throws Throwable {
            super.finalize();
        }

        public int getCount() {
            return this.c.size();
        }

        public long getItemId(int paramInt) {
            return paramInt;
        }

        public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
            com.everimaging.fotorsdk.collage.entity.ui.a locala = (com.everimaging.fotorsdk.collage.entity.ui.a) this.c.get(paramInt);
            View localView;
            Object localObject;
            if (paramView == null) {
                paramViewGroup = new a();
                localView = LayoutInflater.from(b.a(b.this)).inflate(R.layout.fotor_collage_background_grid_item, null);
                paramViewGroup.a = ((ImageView) localView.findViewById(R.id.fotor_collage_background_item_image));
                paramViewGroup.b = ((ImageView) localView.findViewById(R.id.fotor_collage_background_item_flag));
                localView.setTag(paramViewGroup);
                paramView = locala.b();
                if (paramView != null) {
                    break label483;
                }
                localObject = locala.a();
                if (localObject != null) {
                    if (!((BackgroundInfo) localObject).isTexture()) {
                        break label446;
                    }
                    localObject = ((h.a) b.b(b.this).c()).b(((BackgroundInfo) localObject).getResName());
                    paramView = BitmapDecodeUtils.decodeStream((InputStream) localObject);
                    paramView = new BitmapDrawable(b.c(b.this).getResources(), paramView);
                    paramView.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
                    FotorIOUtils.closeSilently((Closeable) localObject);
                }
                label178:
                locala.a(paramView);
            }
            label446:
            label483:
            for (; ; ) {
                localObject = this.b.a(String.valueOf(locala.hashCode()));
                if ((localObject == null) || (((Boolean) this.d.get(paramInt)).booleanValue() == true)) {
                    b.a().c(new Object[]{"bitmap is null will draw bitmap:"});
                    localObject = BitmapUtils.createBitmap(b.d(b.this).getWidth(), b.d(b.this).getHeight(), Bitmap.Config.RGB_565);
                    Canvas localCanvas = new Canvas((Bitmap) localObject);
                    paramView.setBounds(new Rect(0, 0, ((Bitmap) localObject).getWidth(), ((Bitmap) localObject).getHeight()));
                    paramView.draw(localCanvas);
                    localCanvas.drawBitmap(b.d(b.this), 0.0F, 0.0F, null);
                    this.b.a(String.valueOf(locala.hashCode()), (Bitmap) localObject);
                    this.d.set(paramInt, Boolean.valueOf(false));
                }
                for (; ; ) {
                    if ((com.everimaging.fotorsdk.collage.a.b != null) && (locala.a() != null) && (locala.a().isSameBackground(com.everimaging.fotorsdk.collage.a.b.getBackgroundInfo()))) {
                    }
                    for (boolean bool = true; ; bool = false) {
                        paramViewGroup.a.setSelected(bool);
                        paramViewGroup.a.setImageBitmap((Bitmap) localObject);
                        paramViewGroup.a.setTag(Integer.valueOf(paramInt));
                        paramViewGroup.b.setImageDrawable(paramView);
                        return localView;
                        paramViewGroup = (a) paramView.getTag();
                        localView = paramView;
                        break;
                        paramView = new ColorDrawable(Color.parseColor(((BackgroundInfo) localObject).getColor().replace("0x", "#")));
                        break label178;
                    }
                }
            }
        }

        class a {
            ImageView a;
            ImageView b;

            a() {
            }
        }
    }

    public static abstract interface b {
        public abstract void a(BackgroundParam paramBackgroundParam);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/collage/bp/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */