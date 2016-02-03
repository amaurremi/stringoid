package mobi.ifunny.studio.video;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.g;
import android.support.v4.app.q;
import android.support.v4.view.ah;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import mobi.ifunny.IFunnyApplication;
import mobi.ifunny.d;
import mobi.ifunny.fragment.h;
import mobi.ifunny.rest.IFunnyRestHttpClient.Youtube;
import mobi.ifunny.rest.content.YoutubeVideo;
import mobi.ifunny.rest.retrofit.SimpleRestHttpHandler;
import mobi.ifunny.studio.publish.PublishVideoActivity;

public class UploadVideoActivity
        extends mobi.ifunny.l.a {
    public static boolean o;
    private static final String p = UploadVideoActivity.class.getSimpleName();
    private static final Pattern s = Pattern.compile("https?:\\/\\/(?:[0-9A-Z-]+\\.)?(?:youtu\\.be\\/|youtube\\.com\\S*[^\\w\\-\\s])([\\w\\-]{11})(?=[^\\w\\-]|$)(?![?=&+%\\w]*(?:['\"][^<>]*>|<\\/a>))[?=&+%\\w]*", 2);
    private static SimpleRestHttpHandler<String, UploadVideoActivity> t = new b();
    private MenuItem q;
    private EditText r;

    private void b(String paramString) {
        IFunnyRestHttpClient.Youtube.info(this, "task.youtube.video.info", paramString, t);
    }

    private void q() {
        boolean bool = false;
        if (this.q != null) {
            bool = ah.b(this.q);
        }
        if (!bool) {
            onSearchRequested();
        }
    }

    protected void a(YoutubeVideo paramYoutubeVideo) {
        Intent localIntent = new Intent(this, PublishVideoActivity.class);
        localIntent.putExtra("intent.video", paramYoutubeVideo);
        startActivityForResult(localIntent, 0);
    }

    protected boolean k() {
        return false;
    }

    protected void n() {
        if ((g) f().a("dialog.progress") == null) {
            h.a(this, new String[]{"task.youtube.video.info"}).a(f(), "dialog.progress");
        }
    }

    protected void o() {
        g localg = (g) f().a("dialog.progress");
        if (localg != null) {
            localg.a();
        }
    }

    protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        switch (paramInt1) {
            default:
                super.onActivityResult(paramInt1, paramInt2, paramIntent);
        }
        do {
            return;
        } while (paramInt2 != -1);
        finish();
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(2130903178);
        this.r = ((EditText) findViewById(2131493344));
        o = false;
    }

    public boolean onCreateOptionsMenu(Menu paramMenu) {
        getMenuInflater().inflate(2131820568, paramMenu);
        this.q = paramMenu.findItem(2131493410);
        SearchView localSearchView = (SearchView) ah.a(this.q);
        localSearchView.setSearchableInfo(((SearchManager) getSystemService("search")).getSearchableInfo(new ComponentName(IFunnyApplication.a, UploadVideoSearchActivity.class)));
        localSearchView.setIconifiedByDefault(false);
        return super.onCreateOptionsMenu(paramMenu);
    }

    public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent) {
        if (paramInt == 84) {
            q();
            return true;
        }
        return super.onKeyUp(paramInt, paramKeyEvent);
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
            default:
                return super.onOptionsItemSelected(paramMenuItem);
            case 16908332:
                ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this.r.getWindowToken(), 1);
                onBackPressed();
                return false;
            case 2131493410:
                q();
                return true;
        }
        paramMenuItem = this.r.getText().toString();
        if (TextUtils.isEmpty(paramMenuItem)) {
            Toast.makeText(this, 2131690135, 0).show();
            return true;
        }
        if (!paramMenuItem.startsWith("http")) {
            Toast.makeText(this, 2131690137, 0).show();
            return true;
        }
        paramMenuItem = s.matcher(paramMenuItem);
        if (paramMenuItem.find()) {
            paramMenuItem = paramMenuItem.group(1);
            d.c(p, "Detected youtube id " + paramMenuItem);
            b(paramMenuItem);
        }
        for (; ; ) {
            return true;
            Toast.makeText(this, 2131690137, 0).show();
        }
    }

    protected void onResume() {
        super.onResume();
        if (o) {
            finish();
            o = false;
            return;
        }
        new Handler().postDelayed(new a(this), 50L);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/video/UploadVideoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */