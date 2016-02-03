package com.everimaging.fotor.discovery;

import android.content.Intent;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.everimaging.fotor.discovery.entity.Suggestion;
import com.everimaging.fotor.discovery.entity.SuggestionList;
import com.everimaging.fotor.log.LoggerFactory;
import com.everimaging.fotor.log.LoggerFactory.LoggerType;
import com.everimaging.fotor.log.LoggerFactory.c;
import com.everimaging.fotorsdk.uil.core.c.a;
import com.everimaging.fotorsdk.utils.FotorAsyncTask;
import com.everimaging.fotorsdk.utils.FotorAsyncTask.Status;
import com.everimaging.fotorsdk.widget.pulltorefresh.library.PullToRefreshBase;
import com.everimaging.fotorsdk.widget.pulltorefresh.library.PullToRefreshBase.Mode;
import com.everimaging.fotorsdk.widget.pulltorefresh.library.PullToRefreshBase.c;
import com.everimaging.fotorsdk.widget.pulltorefresh.library.PullToRefreshListView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.OpenUDID.a;

public class DiscoverySuggestionFragment
        extends DiscoveryBaseFragment
        implements AdapterView.OnItemClickListener, PullToRefreshBase.c<ListView> {
    private static final String b = DiscoverySuggestionFragment.class.getSimpleName();
    private static final LoggerFactory.c c = LoggerFactory.a(b, LoggerFactory.LoggerType.CONSOLE);
    private PullToRefreshListView d;
    private a e;
    private List<Suggestion> f;
    private View g;
    private View h;
    private ImageButton i;
    private com.everimaging.fotorsdk.uil.core.c j;
    private View.OnClickListener k = new View.OnClickListener() {
        public void onClick(View paramAnonymousView) {
            DiscoverySuggestionFragment.a(DiscoverySuggestionFragment.this, true);
        }
    };

    private void a(boolean paramBoolean) {
        this.h.setVisibility(8);
        if ((this.e == null) || (this.e.getStatus() != FotorAsyncTask.Status.FINISHED)) {
            this.e = new a(paramBoolean);
            this.e.executeOnExecutor(FotorAsyncTask.SERIAL_EXECUTOR, new Void[0]);
        }
    }

    public void a(PullToRefreshBase<ListView> paramPullToRefreshBase) {
        c.c(new Object[]{"do onRefresh"});
        a(true);
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        a(false);
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        paramBundle = new BitmapFactory.Options();
        paramBundle.inDensity = 320;
        this.j = new c.a().a(true).a(new com.everimaging.fotorsdk.uil.core.display.b(200, true, true, false)).b(2130837715).c(2130837715).b(true).a(Bitmap.Config.RGB_565).a(paramBundle).a();
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramLayoutInflater = paramLayoutInflater.inflate(2130903089, null);
        this.d = ((PullToRefreshListView) paramLayoutInflater.findViewById(2131558563));
        this.d.setMode(PullToRefreshBase.Mode.PULL_FROM_START);
        this.d.setOnRefreshListener(this);
        this.g = paramLayoutInflater.findViewById(2131558564);
        this.h = paramLayoutInflater.findViewById(2131558565);
        this.i = ((ImageButton) this.h.findViewById(2131558567));
        this.i.setOnClickListener(this.k);
        this.d.setVisibility(4);
        this.d.setOnItemClickListener(this);
        return paramLayoutInflater;
    }

    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
        paramAdapterView = (Suggestion) paramAdapterView.getAdapter().getItem(paramInt);
        c.c(new Object[]{"item click:" + paramAdapterView.getApp_url()});
        paramView = new Intent("android.intent.action.VIEW");
        paramView.setData(Uri.parse(paramAdapterView.getApp_url()));
        startActivity(paramView);
        paramView = new HashMap();
        paramView.put("AppName", paramAdapterView.getApp_name());
        paramView.put("UDID", a.a());
        com.everimaging.fotor.c.b.a(this.a, "Fotor_Discover_Click", "Fotor_Discover_Suggestion_Item_Click", paramView);
    }

    class a
            extends FotorAsyncTask<Void, Void, List<Suggestion>> {
        private boolean b;

        public a(boolean paramBoolean) {
            this.b = paramBoolean;
        }

        protected List<Suggestion> a(Void... paramVarArgs) {
            DiscoverySuggestionFragment.a().c(new Object[]{"begin load suggestions"});
            SuggestionList localSuggestionList = com.everimaging.fotor.discovery.a.d.a(this.b);
            paramVarArgs = null;
            if (localSuggestionList != null) {
                paramVarArgs = localSuggestionList.getData();
            }
            return paramVarArgs;
        }

        protected void a(List<Suggestion> paramList) {
            if ((paramList != null) && (paramList.size() > 0)) {
                DiscoverySuggestionFragment.a(DiscoverySuggestionFragment.this, paramList);
                paramList = new DiscoverySuggestionFragment.b(DiscoverySuggestionFragment.this, DiscoverySuggestionFragment.b(DiscoverySuggestionFragment.this));
                DiscoverySuggestionFragment.c(DiscoverySuggestionFragment.this).setAdapter(paramList);
                DiscoverySuggestionFragment.c(DiscoverySuggestionFragment.this).setVisibility(0);
            }
            for (; ; ) {
                DiscoverySuggestionFragment.c(DiscoverySuggestionFragment.this).j();
                DiscoverySuggestionFragment.a(DiscoverySuggestionFragment.this).setVisibility(8);
                DiscoverySuggestionFragment.a(DiscoverySuggestionFragment.this, null);
                return;
                if ((DiscoverySuggestionFragment.b(DiscoverySuggestionFragment.this) == null) || (DiscoverySuggestionFragment.b(DiscoverySuggestionFragment.this).size() == 0)) {
                    DiscoverySuggestionFragment.c(DiscoverySuggestionFragment.this).setVisibility(4);
                    DiscoverySuggestionFragment.d(DiscoverySuggestionFragment.this).setVisibility(0);
                }
            }
        }

        protected void onCancelled() {
            DiscoverySuggestionFragment.c(DiscoverySuggestionFragment.this).j();
            DiscoverySuggestionFragment.a(DiscoverySuggestionFragment.this).setVisibility(8);
            DiscoverySuggestionFragment.a(DiscoverySuggestionFragment.this, null);
        }

        protected void onPreExecute() {
            if (!this.b) {
                DiscoverySuggestionFragment.a(DiscoverySuggestionFragment.this).setVisibility(0);
            }
        }
    }

    class b
            extends BaseAdapter {
        private List<Suggestion> b;

        public b() {
            List localList;
            this.b = localList;
        }

        public Suggestion a(int paramInt) {
            return (Suggestion) this.b.get(paramInt);
        }

        public int getCount() {
            return this.b.size();
        }

        public long getItemId(int paramInt) {
            return paramInt;
        }

        public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
            Suggestion localSuggestion = (Suggestion) this.b.get(paramInt);
            View localView;
            if (paramView == null) {
                paramView = new a();
                localView = LayoutInflater.from(DiscoverySuggestionFragment.this.a).inflate(2130903097, null);
                paramView.a = ((ImageView) localView.findViewById(2131558582));
                paramView.b = ((TextView) localView.findViewById(2131558584));
                paramView.c = ((TextView) localView.findViewById(2131558585));
                paramViewGroup = paramView;
                if (paramInt % 2 != 0) {
                    break label180;
                }
                localView.setBackgroundResource(2130837716);
            }
            for (; ; ) {
                com.everimaging.fotorsdk.uil.core.d.a().a(localSuggestion.getIcon_url(), new com.everimaging.fotorsdk.uil.core.imageaware.c(paramViewGroup.a, false), DiscoverySuggestionFragment.e(DiscoverySuggestionFragment.this));
                paramViewGroup.b.setText(localSuggestion.getApp_name());
                paramViewGroup.c.setText(localSuggestion.getApp_description());
                localView.setTag(paramViewGroup);
                return localView;
                paramViewGroup = (a) paramView.getTag();
                localView = paramView;
                break;
                label180:
                localView.setBackgroundResource(2130837717);
            }
        }

        class a {
            ImageView a;
            TextView b;
            TextView c;

            a() {
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotor/discovery/DiscoverySuggestionFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */