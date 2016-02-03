package com.everimaging.fotor.discovery;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
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
import android.widget.TextView;
import com.everimaging.fotor.discovery.entity.NewsDataInfo.NewsData;
import com.everimaging.fotor.discovery.entity.NewsEntity;
import com.everimaging.fotor.discovery.widget.DiscoveryImageView;
import com.everimaging.fotorsdk.uil.core.assist.FailReason;
import com.everimaging.fotorsdk.uil.core.d;
import com.everimaging.fotorsdk.widget.pulltorefresh.library.PullToRefreshBase;
import com.everimaging.fotorsdk.widget.pulltorefresh.library.PullToRefreshBase.Mode;
import com.everimaging.fotorsdk.widget.pulltorefresh.library.PullToRefreshBase.d;
import com.everimaging.fotorsdk.widget.pulltorefresh.library.PullToRefreshListView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class DiscoveryNewsFragment
        extends DiscoveryBaseFragment {
    private PullToRefreshListView b;
    private View c;
    private View d;
    private a e;
    private ImageButton f;
    private NewsDataInfo.NewsData g;
    private int h = 1;
    private PullToRefreshBase.d<ListView> i = new PullToRefreshBase.d() {
        public void a(PullToRefreshBase<ListView> paramAnonymousPullToRefreshBase) {
            DiscoveryNewsFragment.a(DiscoveryNewsFragment.this, 1);
            DiscoveryNewsFragment.a(DiscoveryNewsFragment.this, true, DiscoveryNewsFragment.a(DiscoveryNewsFragment.this), 3);
        }

        public void b(PullToRefreshBase<ListView> paramAnonymousPullToRefreshBase) {
            DiscoveryNewsFragment.a(DiscoveryNewsFragment.this, false, DiscoveryNewsFragment.a(DiscoveryNewsFragment.this), 3);
        }
    };
    private AdapterView.OnItemClickListener j = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong) {
            int i = ((ListView) DiscoveryNewsFragment.d(DiscoveryNewsFragment.this).getRefreshableView()).getHeaderViewsCount();
            paramAnonymousAdapterView = DiscoveryNewsFragment.f(DiscoveryNewsFragment.this).a(paramAnonymousInt - i);
            if ((paramAnonymousAdapterView == null) || (TextUtils.isEmpty(paramAnonymousAdapterView.getUrl()))) {
                return;
            }
            paramAnonymousView = new HashMap();
            paramAnonymousView.put("ID", String.valueOf(paramAnonymousAdapterView.getId()));
            paramAnonymousView.put("UDID", org.OpenUDID.a.a());
            com.everimaging.fotor.c.b.a(DiscoveryNewsFragment.this.a, "Fotor_Discover_Click", "Fotor_Discover_News_Item_Click", paramAnonymousView);
            paramAnonymousView = new Intent(DiscoveryNewsFragment.this.a, DiscoveryNewsDetailsActivity.class);
            paramAnonymousView.putExtra("Discovery_News_Link_Url", paramAnonymousAdapterView.getUrl());
            DiscoveryNewsFragment.this.startActivity(paramAnonymousView);
        }
    };
    private View.OnClickListener k = new View.OnClickListener() {
        public void onClick(View paramAnonymousView) {
            DiscoveryNewsFragment.a(DiscoveryNewsFragment.this, 1);
            DiscoveryNewsFragment.c(DiscoveryNewsFragment.this).setVisibility(0);
            DiscoveryNewsFragment.a(DiscoveryNewsFragment.this, true, DiscoveryNewsFragment.a(DiscoveryNewsFragment.this), 3);
        }
    };

    private void a() {
        if ((this.g != null) && (this.g.getDiscoverList() != null)) {
            this.h = (this.g.getDiscoverList().size() / 3 + 1);
            if (this.e == null) {
                this.e = new a(this.g.getDiscoverList());
                this.b.setAdapter(this.e);
                this.b.setOnItemClickListener(this.j);
            }
        } else {
            return;
        }
        this.e.a(this.g.getDiscoverList());
    }

    private void a(boolean paramBoolean, int paramInt1, int paramInt2) {
        this.c.setVisibility(8);
        com.everimaging.fotor.discovery.a.c.a(paramBoolean, Locale.getDefault().getLanguage(), "fotor", org.OpenUDID.a.a(), paramInt1, paramInt2, new com.everimaging.fotor.discovery.a.c.a() {
            public void a(NewsDataInfo.NewsData paramAnonymousNewsData) {
                DiscoveryNewsFragment.a(DiscoveryNewsFragment.this, paramAnonymousNewsData);
                DiscoveryNewsFragment.b(DiscoveryNewsFragment.this);
                DiscoveryNewsFragment.c(DiscoveryNewsFragment.this).setVisibility(8);
                DiscoveryNewsFragment.d(DiscoveryNewsFragment.this).setVisibility(0);
                DiscoveryNewsFragment.d(DiscoveryNewsFragment.this).j();
            }

            public void b(NewsDataInfo.NewsData paramAnonymousNewsData) {
                DiscoveryNewsFragment.d(DiscoveryNewsFragment.this).j();
                DiscoveryNewsFragment.c(DiscoveryNewsFragment.this).setVisibility(8);
                if ((paramAnonymousNewsData == null) || (paramAnonymousNewsData.getDiscoverList() == null)) {
                    DiscoveryNewsFragment.e(DiscoveryNewsFragment.this).setVisibility(0);
                    DiscoveryNewsFragment.d(DiscoveryNewsFragment.this).setVisibility(4);
                    return;
                }
                DiscoveryNewsFragment.a(DiscoveryNewsFragment.this, paramAnonymousNewsData);
                DiscoveryNewsFragment.b(DiscoveryNewsFragment.this);
                DiscoveryNewsFragment.d(DiscoveryNewsFragment.this).setVisibility(0);
            }
        });
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        a(false, this.h, 3);
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramLayoutInflater = paramLayoutInflater.inflate(2130903095, paramViewGroup, false);
        this.b = ((PullToRefreshListView) paramLayoutInflater.findViewById(2131558576));
        this.b.setMode(PullToRefreshBase.Mode.BOTH);
        this.b.setOnRefreshListener(this.i);
        this.b.setVisibility(4);
        this.b.setScrollingWhileRefreshingEnabled(false);
        this.c = paramLayoutInflater.findViewById(2131558565);
        this.f = ((ImageButton) this.c.findViewById(2131558567));
        this.f.setOnClickListener(this.k);
        this.d = paramLayoutInflater.findViewById(2131558577);
        return paramLayoutInflater;
    }

    private class a
            extends BaseAdapter {
        private List<NewsEntity> b;
        private LayoutInflater c;
        private com.everimaging.fotorsdk.uil.core.c d;

        public a() {
            List localList;
            this.b = localList;
            this.c = LayoutInflater.from(DiscoveryNewsFragment.this.a);
            this.d = new com.everimaging.fotorsdk.uil.core.c.a().a(new com.everimaging.fotorsdk.uil.core.display.b(200, true, true, false)).a(2130837711).b(2130837711).c(2130837711).a(true).b(true).c(true).a(Bitmap.Config.RGB_565).a();
        }

        public NewsEntity a(int paramInt) {
            return (NewsEntity) this.b.get(paramInt);
        }

        public void a(List<NewsEntity> paramList) {
            this.b = paramList;
            notifyDataSetChanged();
        }

        public int getCount() {
            return this.b.size();
        }

        public long getItemId(int paramInt) {
            return paramInt;
        }

        public View getView(int paramInt, View paramView, final ViewGroup paramViewGroup) {
            NewsEntity localNewsEntity;
            if (paramView == null) {
                paramView = this.c.inflate(2130903096, paramViewGroup, false);
                paramViewGroup = new a(null);
                paramViewGroup.b = ((ImageView) paramView.findViewById(2131558580));
                paramViewGroup.a = ((DiscoveryImageView) paramView.findViewById(2131558579));
                paramViewGroup.c = ((TextView) paramView.findViewById(2131558578));
                paramViewGroup.d = ((TextView) paramView.findViewById(2131558581));
                localNewsEntity = a(paramInt);
                if ((TextUtils.isEmpty(localNewsEntity.getHotStatus())) || (!localNewsEntity.getHotStatus().equals("1"))) {
                    break label237;
                }
                paramViewGroup.b.setVisibility(0);
            }
            for (; ; ) {
                String str = SimpleDateFormat.getDateInstance(2, Locale.getDefault()).format(new Date(localNewsEntity.getPublishDate()));
                paramViewGroup.c.setText(str);
                paramViewGroup.d.setText(localNewsEntity.getTitle());
                d.a().a(com.everimaging.fotor.discovery.a.a.a("store/v1/" + localNewsEntity.getImage()), new com.everimaging.fotorsdk.uil.core.imageaware.c(paramViewGroup.a, false), this.d, new com.everimaging.fotorsdk.uil.core.assist.c() {
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
                break;
                label237:
                paramViewGroup.b.setVisibility(4);
            }
        }

        private class a {
            DiscoveryImageView a;
            ImageView b;
            TextView c;
            TextView d;

            private a() {
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotor/discovery/DiscoveryNewsFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */