package com.everimaging.fotorsdk.store;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;
import com.everimaging.fotorsdk.store.entity.FotorStoreJsonObjects.AdvsJsonObject;
import com.everimaging.fotorsdk.store.entity.FotorStoreJsonObjects.ResposeListJsonObject;
import com.everimaging.fotorsdk.store.utils.c.c;
import com.everimaging.fotorsdk.uil.core.c.a;

import java.util.List;

public class FotorStoreBannerController {
    private static final String a = FotorStoreBannerController.class.getSimpleName();
    private static final FotorLoggerFactory.c b = FotorLoggerFactory.a(a, FotorLoggerFactory.LoggerType.CONSOLE);
    private FrameLayout c;
    private Context d;
    private ViewPager e;
    private a f;
    private b g;
    private FragmentManager h;
    private boolean i = true;
    private Handler j = new Handler();
    private View.OnClickListener k;
    private c l;
    private Runnable m = new Runnable() {
        public void run() {
            if (FotorStoreBannerController.c(FotorStoreBannerController.this)) {
                FotorStoreBannerController.d(FotorStoreBannerController.this);
            }
        }
    };
    private ViewPager.OnPageChangeListener n = new ViewPager.OnPageChangeListener() {
        public void onPageScrollStateChanged(int paramAnonymousInt) {
            if (paramAnonymousInt == 0) {
                FotorStoreBannerController.h(FotorStoreBannerController.this);
            }
            if (paramAnonymousInt == 1) {
                FotorStoreBannerController.j(FotorStoreBannerController.this);
            }
            if (paramAnonymousInt == 2) {
                FotorStoreBannerController.j(FotorStoreBannerController.this);
            }
        }

        public void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {
            FotorStoreBannerController.i(FotorStoreBannerController.this).invalidate();
        }

        public void onPageSelected(int paramAnonymousInt) {
        }
    };

    public FotorStoreBannerController(Context paramContext, FragmentManager paramFragmentManager) {
        this.d = paramContext;
        this.h = paramFragmentManager;
        h();
        d();
    }

    private void a(boolean paramBoolean) {
        com.everimaging.fotorsdk.store.utils.c.a(new c.c() {
            public void a(FotorStoreJsonObjects.ResposeListJsonObject<FotorStoreJsonObjects.AdvsJsonObject> paramAnonymousResposeListJsonObject) {
                FotorStoreBannerController.a(FotorStoreBannerController.this, new FotorStoreBannerController.b(FotorStoreBannerController.this, FotorStoreBannerController.f(FotorStoreBannerController.this)));
                if ((paramAnonymousResposeListJsonObject != null) && (paramAnonymousResposeListJsonObject.status == true) && (paramAnonymousResposeListJsonObject.data != null)) {
                    FotorStoreBannerController.g(FotorStoreBannerController.this).a(paramAnonymousResposeListJsonObject.data);
                }
                FotorStoreBannerController.a(FotorStoreBannerController.this).setAdapter(null);
                FotorStoreBannerController.a(FotorStoreBannerController.this).setAdapter(FotorStoreBannerController.g(FotorStoreBannerController.this));
                FotorStoreBannerController.h(FotorStoreBannerController.this);
            }

            public void a(FotorStoreJsonObjects.ResposeListJsonObject<FotorStoreJsonObjects.AdvsJsonObject> paramAnonymousResposeListJsonObject, String paramAnonymousString) {
                FotorStoreBannerController.a(FotorStoreBannerController.this, new FotorStoreBannerController.b(FotorStoreBannerController.this, FotorStoreBannerController.f(FotorStoreBannerController.this)));
                FotorStoreBannerController.a(FotorStoreBannerController.this).setAdapter(null);
                FotorStoreBannerController.a(FotorStoreBannerController.this).setAdapter(FotorStoreBannerController.g(FotorStoreBannerController.this));
                FotorStoreBannerController.h(FotorStoreBannerController.this);
            }
        }, this.d, paramBoolean);
    }

    private void d() {
        this.c = ((FrameLayout) LayoutInflater.from(this.d).inflate(R.layout.fotor_store_banner, null));
        this.c.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @SuppressLint({"NewApi"})
            public void onGlobalLayout() {
                if (Build.VERSION.SDK_INT < 16) {
                    FotorStoreBannerController.e(FotorStoreBannerController.this).getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    return;
                }
                FotorStoreBannerController.e(FotorStoreBannerController.this).getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
        this.f = new a(this.d);
        this.c.addView(this.f, new ViewGroup.LayoutParams(-1, -1));
        this.e = ((ViewPager) this.c.findViewById(R.id.fotor_store_banner_viewpager));
        this.e.setOnPageChangeListener(this.n);
    }

    private void e() {
        int i1 = this.e.getCurrentItem();
        if (i1 < this.g.getCount() - 1) {
            this.e.setCurrentItem(i1 + 1);
            return;
        }
        this.e.setCurrentItem(0);
    }

    private void f() {
        if (this.j != null) {
            this.j.postDelayed(this.m, 5000L);
            this.f.invalidate();
        }
    }

    private void g() {
        this.j.removeCallbacks(this.m);
    }

    private void h() {
        this.k = new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                paramAnonymousView = (FotorStoreJsonObjects.AdvsJsonObject) paramAnonymousView.getTag();
                if (FotorStoreBannerController.k(FotorStoreBannerController.this) != null) {
                    FotorStoreBannerController.k(FotorStoreBannerController.this).a(paramAnonymousView);
                }
            }
        };
    }

    public void a() {
        this.j.removeCallbacksAndMessages(null);
    }

    public void a(c paramc) {
        this.l = paramc;
    }

    public View b() {
        return this.c;
    }

    public void c() {
        g();
        a(true);
    }

    public static class FotorBannerPageFragment
            extends Fragment {
        private com.everimaging.fotorsdk.uil.core.c a = new c.a().a(R.color.fotor_transparent).b(R.color.fotor_transparent).c(R.color.fotor_transparent).a(true).b(true).a(Bitmap.Config.RGB_565).a();
        private FotorStoreJsonObjects.AdvsJsonObject b = new FotorStoreJsonObjects.AdvsJsonObject();
        private View.OnClickListener c;

        public int a() {
            if (this.b != null) {
                return this.b.id;
            }
            return -1;
        }

        public void a(View.OnClickListener paramOnClickListener) {
            this.c = paramOnClickListener;
        }

        public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
            paramLayoutInflater = paramLayoutInflater.inflate(R.layout.fotor_store_banner_item, paramViewGroup, false);
            paramViewGroup = (ImageView) paramLayoutInflater.findViewById(R.id.fotor_store_banner_imageview);
            paramBundle = getArguments().getString("advs_json_string");
            this.b.parseFromJsonStr(paramBundle);
            com.everimaging.fotorsdk.uil.core.d.a().a(com.everimaging.fotorsdk.store.utils.d.b(this.b.previewImg), paramViewGroup, this.a);
            paramLayoutInflater.setOnClickListener(this.c);
            paramLayoutInflater.setTag(this.b);
            return paramLayoutInflater;
        }
    }

    private class a
            extends FrameLayout {
        private float b;
        private float c;
        private float d;
        private float e;
        private float f;
        private Paint g;
        private int h;
        private int i;

        public a(Context paramContext) {
            this(paramContext, null);
        }

        public a(Context paramContext, AttributeSet paramAttributeSet) {
            this(paramContext, paramAttributeSet, 0);
        }

        public a(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
            super(paramAttributeSet, paramInt);
            a();
        }

        @SuppressLint({"NewApi"})
        private void a() {
            if (Build.VERSION.SDK_INT >= 11) {
                setLayerType(1, null);
            }
            setWillNotDraw(false);
            Resources localResources = getContext().getResources();
            this.b = localResources.getDimension(R.dimen.fotor_store_banner_indicator_default);
            this.c = localResources.getDimension(R.dimen.fotor_store_banner_indicator_selected);
            this.d = localResources.getDimension(R.dimen.fotor_store_banner_indicator_margin_h);
            this.e = localResources.getDimension(R.dimen.fotor_store_banner_indicator_margin_bottom);
            this.f = ((this.c + this.d) * 2.0F);
            this.g = new Paint();
            this.g.setStyle(Paint.Style.FILL);
            this.h = -1;
            this.i = localResources.getColor(R.color.fotor_store_tab_text_pressed);
            this.g.setColor(this.h);
            this.g.setAntiAlias(true);
        }

        private void a(Canvas paramCanvas) {
            PagerAdapter localPagerAdapter = FotorStoreBannerController.a(FotorStoreBannerController.this).getAdapter();
            if ((localPagerAdapter != null) && (localPagerAdapter.getCount() > 0)) {
                int k = localPagerAdapter.getCount();
                int m = FotorStoreBannerController.a(FotorStoreBannerController.this).getCurrentItem();
                float f1 = this.f;
                float f2 = k;
                f1 = (getWidth() - f1 * f2) / 2.0F;
                f2 = this.f / 2.0F;
                float f3 = getHeight();
                float f4 = this.e;
                float f5 = this.c;
                f1 = f2 + f1;
                int j = 0;
                if (j < k) {
                    f2 = this.b;
                    if (j == m) {
                        f2 = this.c;
                        this.g.setColor(this.i);
                    }
                    for (; ; ) {
                        paramCanvas.drawCircle(f1, f3 - f4 - f5, f2, this.g);
                        f1 += this.f;
                        j += 1;
                        break;
                        this.g.setColor(this.h);
                    }
                }
            }
        }

        protected void onDraw(Canvas paramCanvas) {
            super.onDraw(paramCanvas);
            a(paramCanvas);
        }
    }

    private class b
            extends FragmentStatePagerAdapter {
        private List<FotorStoreJsonObjects.AdvsJsonObject> b;

        public b(FragmentManager paramFragmentManager) {
            super();
        }

        public void a(List<FotorStoreJsonObjects.AdvsJsonObject> paramList) {
            this.b = paramList;
            notifyDataSetChanged();
        }

        public int getCount() {
            if (this.b != null) {
                return this.b.size();
            }
            return 0;
        }

        public Fragment getItem(int paramInt) {
            FotorStoreBannerController.FotorBannerPageFragment localFotorBannerPageFragment = new FotorStoreBannerController.FotorBannerPageFragment();
            FotorStoreJsonObjects.AdvsJsonObject localAdvsJsonObject = (FotorStoreJsonObjects.AdvsJsonObject) this.b.get(paramInt);
            Bundle localBundle = new Bundle();
            localBundle.putString("advs_json_string", localAdvsJsonObject.toJsonStr());
            localFotorBannerPageFragment.setArguments(localBundle);
            localFotorBannerPageFragment.a(FotorStoreBannerController.b(FotorStoreBannerController.this));
            return localFotorBannerPageFragment;
        }

        public int getItemPosition(Object paramObject) {
            int k = ((FotorStoreBannerController.FotorBannerPageFragment) paramObject).a();
            int j;
            if (this.b != null) {
                j = -1;
                int i = 0;
                while (i < this.b.size()) {
                    if (k == ((FotorStoreJsonObjects.AdvsJsonObject) this.b.get(i)).id) {
                        j = i;
                    }
                    i += 1;
                }
            }
            for (; ; ) {
                if (j >= 0) {
                    return j;
                }
                return -2;
                j = -1;
            }
        }
    }

    public static abstract interface c {
        public abstract void a(FotorStoreJsonObjects.AdvsJsonObject paramAdvsJsonObject);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/store/FotorStoreBannerController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */