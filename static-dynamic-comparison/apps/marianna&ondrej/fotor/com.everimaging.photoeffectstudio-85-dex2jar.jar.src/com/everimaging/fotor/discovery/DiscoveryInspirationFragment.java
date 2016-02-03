package com.everimaging.fotor.discovery;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ListView;
import com.everimaging.fotor.discovery.a.b.a;
import com.everimaging.fotor.discovery.entity.InspirationEntity;
import com.everimaging.fotor.discovery.entity.InspirationListInfo;
import com.everimaging.fotorsdk.uil.core.assist.FailReason;
import com.everimaging.fotorsdk.uil.core.c.a;
import com.everimaging.fotorsdk.uil.core.d;
import com.everimaging.fotorsdk.widget.FotorTextView;
import com.everimaging.fotorsdk.widget.pulltorefresh.library.PullToRefreshBase;
import com.everimaging.fotorsdk.widget.pulltorefresh.library.PullToRefreshBase.Mode;
import com.everimaging.fotorsdk.widget.pulltorefresh.library.PullToRefreshBase.c;
import com.everimaging.fotorsdk.widget.pulltorefresh.library.PullToRefreshListView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.OpenUDID.a;

public class DiscoveryInspirationFragment
        extends DiscoveryBaseFragment {
    private PullToRefreshListView b;
    private View c;
    private View d;
    private InspirationListInfo e;
    private a f;
    private ImageButton g;
    private PackageInfo h = null;
    private ActivityInfo i = null;
    private AdapterView.OnItemClickListener j = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong) {
            int i = ((ListView) DiscoveryInspirationFragment.c(DiscoveryInspirationFragment.this).getRefreshableView()).getHeaderViewsCount();
            paramAnonymousAdapterView = DiscoveryInspirationFragment.e(DiscoveryInspirationFragment.this).a(paramAnonymousInt - i);
            if ((paramAnonymousAdapterView == null) || (TextUtils.isEmpty(paramAnonymousAdapterView.getLink()))) {
                return;
            }
            paramAnonymousView = new HashMap();
            paramAnonymousView.put("ID", paramAnonymousAdapterView.getId());
            paramAnonymousView.put("UDID", a.a());
            com.everimaging.fotor.c.b.a(DiscoveryInspirationFragment.this.a, "Fotor_Discover_Click", "Fotor_Discover_Inspiration_Item_Click", paramAnonymousView);
            if (DiscoveryInspirationFragment.f(DiscoveryInspirationFragment.this) != null) {
                paramAnonymousView = new Intent("android.intent.action.VIEW");
                paramAnonymousView.addCategory("android.intent.category.DEFAULT");
                paramAnonymousView.addCategory("android.intent.category.BROWSABLE");
                paramAnonymousView.setClassName(DiscoveryInspirationFragment.f(DiscoveryInspirationFragment.this).packageName, DiscoveryInspirationFragment.f(DiscoveryInspirationFragment.this).name);
                paramAnonymousView.setData(Uri.parse(paramAnonymousAdapterView.getLink()));
                DiscoveryInspirationFragment.this.startActivity(paramAnonymousView);
                return;
            }
            paramAnonymousAdapterView = new Intent("android.intent.action.VIEW", Uri.parse(paramAnonymousAdapterView.getLink()));
            DiscoveryInspirationFragment.this.startActivity(paramAnonymousAdapterView);
        }
    };
    private PullToRefreshBase.c<ListView> k = new PullToRefreshBase.c() {
        public void a(PullToRefreshBase<ListView> paramAnonymousPullToRefreshBase) {
            DiscoveryInspirationFragment.a(DiscoveryInspirationFragment.this, true);
        }
    };
    private View.OnClickListener l = new View.OnClickListener() {
        public void onClick(View paramAnonymousView) {
            DiscoveryInspirationFragment.b(DiscoveryInspirationFragment.this).setVisibility(0);
            DiscoveryInspirationFragment.a(DiscoveryInspirationFragment.this, true);
        }
    };

    private void a() {
        Object localObject = this.a.getPackageManager();
        try {
            this.h = ((PackageManager) localObject).getPackageInfo("com.instagram.android", 1);
            int n;
            int m;
            if (this.h.activities != null) {
                localObject = this.h.activities;
                n = localObject.length;
                m = 0;
            }
            for (; ; ) {
                if (m < n) {
                    ActivityInfo localActivityInfo = localObject[m];
                    if (localActivityInfo.name.equals("com.instagram.android.activity.UrlHandlerActivity")) {
                        this.i = localActivityInfo;
                    }
                } else {
                    return;
                }
                m += 1;
            }
            return;
        } catch (Exception localException) {
            this.h = null;
            this.i = null;
        }
    }

    private void a(boolean paramBoolean) {
        this.c.setVisibility(8);
        com.everimaging.fotor.discovery.a.b.a(paramBoolean, new b.a() {
            public void a(InspirationListInfo paramAnonymousInspirationListInfo) {
                DiscoveryInspirationFragment.a(DiscoveryInspirationFragment.this, paramAnonymousInspirationListInfo);
                DiscoveryInspirationFragment.a(DiscoveryInspirationFragment.this);
                DiscoveryInspirationFragment.b(DiscoveryInspirationFragment.this).setVisibility(8);
                DiscoveryInspirationFragment.c(DiscoveryInspirationFragment.this).setVisibility(0);
                DiscoveryInspirationFragment.c(DiscoveryInspirationFragment.this).j();
            }

            public void b(InspirationListInfo paramAnonymousInspirationListInfo) {
                if ((paramAnonymousInspirationListInfo != null) && (paramAnonymousInspirationListInfo.getData() != null)) {
                    DiscoveryInspirationFragment.a(DiscoveryInspirationFragment.this, paramAnonymousInspirationListInfo);
                    DiscoveryInspirationFragment.a(DiscoveryInspirationFragment.this);
                    DiscoveryInspirationFragment.c(DiscoveryInspirationFragment.this).setVisibility(0);
                }
                for (; ; ) {
                    DiscoveryInspirationFragment.b(DiscoveryInspirationFragment.this).setVisibility(8);
                    DiscoveryInspirationFragment.c(DiscoveryInspirationFragment.this).j();
                    return;
                    DiscoveryInspirationFragment.c(DiscoveryInspirationFragment.this).setVisibility(4);
                    DiscoveryInspirationFragment.d(DiscoveryInspirationFragment.this).setVisibility(0);
                }
            }
        });
    }

    private void b() {
        if ((this.e != null) && (this.e.getData() != null)) {
            this.f = new a(this.e.getData());
            this.b.setAdapter(this.f);
            this.b.setOnItemClickListener(this.j);
        }
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        a();
        a(false);
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramLayoutInflater = paramLayoutInflater.inflate(2130903091, paramViewGroup, false);
        this.b = ((PullToRefreshListView) paramLayoutInflater.findViewById(2131558568));
        this.b.setMode(PullToRefreshBase.Mode.PULL_FROM_START);
        this.b.setOnRefreshListener(this.k);
        this.b.setVisibility(4);
        this.b.setScrollingWhileRefreshingEnabled(false);
        this.c = paramLayoutInflater.findViewById(2131558565);
        this.g = ((ImageButton) this.c.findViewById(2131558567));
        this.g.setOnClickListener(this.l);
        this.d = paramLayoutInflater.findViewById(2131558569);
        return paramLayoutInflater;
    }

    private class a
            extends BaseAdapter {
        private List<InspirationEntity> b;
        private LayoutInflater c;
        private com.everimaging.fotorsdk.uil.core.c d;

        public a() {
            List localList;
            this.b = localList;
            this.c = LayoutInflater.from(DiscoveryInspirationFragment.this.a);
            this.d = new c.a().a(new com.everimaging.fotorsdk.uil.core.display.b(200, true, true, false)).a(2130837711).b(2130837711).c(2130837711).a(true).b(true).c(true).a(Bitmap.Config.RGB_565).a();
        }

        public InspirationEntity a(int paramInt) {
            return (InspirationEntity) this.b.get(paramInt);
        }

        public int getCount() {
            return this.b.size();
        }

        public long getItemId(int paramInt) {
            return paramInt;
        }

        public View getView(int paramInt, View paramView, final ViewGroup paramViewGroup) {
            if (paramView == null) {
                paramView = this.c.inflate(2130903092, null, false);
                paramViewGroup = new a(null);
                paramViewGroup.a = ((ImageView) paramView.findViewById(2131558570));
                paramViewGroup.b = ((FotorTextView) paramView.findViewById(2131558571));
            }
            for (; ; ) {
                InspirationEntity localInspirationEntity = a(paramInt);
                paramViewGroup.b.setText(localInspirationEntity.getAuthor());
                d.a().a(localInspirationEntity.getImage_url(), new com.everimaging.fotorsdk.uil.core.imageaware.c(paramViewGroup.a, false), this.d, new com.everimaging.fotorsdk.uil.core.assist.c() {
                    public void a(String paramAnonymousString, View paramAnonymousView) {
                        paramViewGroup.a.setImageResource(2130837711);
                        paramViewGroup.a.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                    }

                    public void a(String paramAnonymousString, View paramAnonymousView, Bitmap paramAnonymousBitmap) {
                        if (TextUtils.isEmpty(paramAnonymousString)) {
                            paramViewGroup.a.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                            return;
                        }
                        paramViewGroup.a.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    }

                    public void a(String paramAnonymousString, View paramAnonymousView, FailReason paramAnonymousFailReason) {
                        paramViewGroup.a.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                    }

                    public void b(String paramAnonymousString, View paramAnonymousView) {
                    }
                });
                paramView.setTag(paramViewGroup);
                return paramView;
                paramViewGroup = (a) paramView.getTag();
            }
        }

        private class a {
            ImageView a;
            FotorTextView b;

            private a() {
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotor/discovery/DiscoveryInspirationFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */