package mobi.ifunny.studio.video;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.provider.SearchRecentSuggestions;
import android.support.v4.view.ah;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.gson.Gson;
import mobi.ifunny.l.a;
import mobi.ifunny.rest.IFunnyRestHttpClient.Youtube;
import mobi.ifunny.rest.content.YoutubeSearchResults;
import mobi.ifunny.rest.content.YoutubeSearchResults.YoutubeVideoData;
import mobi.ifunny.rest.content.YoutubeVideo;
import mobi.ifunny.rest.retrofit.SimpleRestHttpHandler;
import mobi.ifunny.studio.publish.PublishVideoActivity;
import mobi.ifunny.view.ProgressBar;

public class UploadVideoSearchActivity
        extends a
        implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener {
    private static final String o = UploadVideoActivity.class.getSimpleName();
    private static SimpleRestHttpHandler<String, UploadVideoSearchActivity> w = new c();
    private String p;
    private d q;
    private ListView r;
    private View s;
    private ProgressBar t;
    private Gson u = new Gson();
    private MenuItem v;

    private void a(YoutubeVideo paramYoutubeVideo) {
        Intent localIntent = new Intent(this, PublishVideoActivity.class);
        localIntent.putExtra("intent.video", paramYoutubeVideo);
        startActivityForResult(localIntent, 0);
    }

    private void c(Intent paramIntent) {
        if ("android.intent.action.SEARCH".equals(paramIntent.getAction())) {
            paramIntent = paramIntent.getStringExtra("query");
            if (!TextUtils.equals(paramIntent, this.p)) {
                this.q.b();
                this.p = paramIntent;
            }
            new SearchRecentSuggestions(this, "mobi.ifunny.RecentSuggestionsProvider", 1).saveRecentQuery(this.p, null);
            q();
            return;
        }
        finish();
    }

    private void o() {
        boolean bool = false;
        if (this.v != null) {
            bool = ah.b(this.v);
        }
        if (!bool) {
            onSearchRequested();
        }
    }

    private boolean p() {
        return e("task.youtube.video.search");
    }

    private void q() {
        int i = this.q.getCount();
        if (i == 0) {
            this.t.setVisibility(0);
            this.r.setVisibility(4);
        }
        if (!p()) {
            IFunnyRestHttpClient.Youtube.search(this, "task.youtube.video.search", this.p, i + 1, 20, w);
        }
    }

    protected void b(String paramString) {
        mobi.ifunny.d.b(o, "Youtube response:\n" + paramString);
        this.t.setVisibility(4);
        this.r.setVisibility(0);
        paramString = (YoutubeSearchResults) this.u.fromJson(paramString, YoutubeSearchResults.class);
        if (paramString == null) {
            Toast.makeText(this, 2131690143, 0).show();
        }
        do {
            return;
            paramString = paramString.getData().getItems();
            if (paramString != null) {
                break;
            }
        } while (this.q.getCount() != 0);
        Toast.makeText(this, 2131690142, 0).show();
        return;
        this.q.a(paramString);
    }

    protected boolean k() {
        return false;
    }

    protected void n() {
        this.t.setVisibility(8);
        if (this.q.getCount() == 0) {
            this.r.setVisibility(8);
            this.s.setVisibility(0);
            return;
        }
        this.r.setVisibility(0);
        this.s.setVisibility(8);
    }

    protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        switch (paramInt1) {
            default:
                super.onActivityResult(paramInt1, paramInt2, paramIntent);
        }
        do {
            return;
        } while (paramInt2 != -1);
        UploadVideoActivity.o = true;
        finish();
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(2130903179);
        this.q = new d(this);
        this.r = ((ListView) findViewById(2131493345));
        this.r.setAdapter(this.q);
        this.r.setOnItemClickListener(this);
        this.t = ((ProgressBar) findViewById(2131493346));
        this.s = findViewById(2131493093);
        ((TextView) this.s.findViewById(2131493094)).setText(2131689897);
        this.s.setVisibility(8);
        c(getIntent());
        this.r.setOnScrollListener(this);
    }

    public boolean onCreateOptionsMenu(Menu paramMenu) {
        getMenuInflater().inflate(2131820569, paramMenu);
        this.v = paramMenu.findItem(2131493410);
        SearchView localSearchView = (SearchView) ah.a(this.v);
        localSearchView.setSearchableInfo(((SearchManager) getSystemService("search")).getSearchableInfo(getComponentName()));
        localSearchView.setIconifiedByDefault(false);
        return super.onCreateOptionsMenu(paramMenu);
    }

    protected void onDestroy() {
        this.q.a();
        super.onDestroy();
    }

    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
        a(this.q.a(paramInt));
    }

    public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent) {
        if (paramInt == 84) {
            o();
            return true;
        }
        return super.onKeyUp(paramInt, paramKeyEvent);
    }

    protected void onNewIntent(Intent paramIntent) {
        super.onNewIntent(paramIntent);
        setIntent(paramIntent);
        c(paramIntent);
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
            default:
                return super.onOptionsItemSelected(paramMenuItem);
            case 16908332:
                onBackPressed();
                return true;
        }
        o();
        return true;
    }

    public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {
        if ((paramInt3 > 0) && (paramInt1 + paramInt2 >= paramInt3)) {
            mobi.ifunny.d.b(o, "Scrolled to last item");
            if (p()) {
                mobi.ifunny.d.b(o, " but search results already requested");
            }
        } else {
            return;
        }
        q();
    }

    public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/video/UploadVideoSearchActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */