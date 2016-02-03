package mobi.ifunny.studio.publish;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.g;
import android.support.v4.app.q;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;
import mobi.ifunny.fragment.h;
import mobi.ifunny.rest.content.TaskInfo;
import mobi.ifunny.rest.retrofit.RestHttpHandler;
import mobi.ifunny.util.aj;
import mobi.ifunny.util.r;
import mobi.ifunny.view.ImageViewEx;
import mobi.ifunny.view.ProgressBar;

public abstract class a
        extends mobi.ifunny.l.a
        implements View.OnClickListener {
    protected static final RestHttpHandler<TaskInfo, a> u = new c(null);
    protected ImageViewEx o;
    protected ImageViewEx p;
    protected View q;
    protected View r;
    protected ProgressBar s;
    protected EditText t;

    protected abstract void a(String paramString1, String paramString2, RestHttpHandler<TaskInfo, a> paramRestHttpHandler);

    protected void a(TaskInfo paramTaskInfo) {
        Toast.makeText(this, 2131690089, 1).show();
        Intent localIntent = new Intent(this, PublishService.class);
        localIntent.putExtra("arg.info", paramTaskInfo);
        startService(localIntent);
        setResult(-1);
        finish();
    }

    protected void a(String... paramVarArgs) {
        if ((g) f().a("dialog.progress") == null) {
            h.a(this, paramVarArgs).a(f(), "dialog.progress");
        }
    }

    protected void b(String paramString) {
        if (!e("task.publish")) {
            a("task.publish", paramString, u);
        }
    }

    protected String n() {
        return r.a(this.t.getText().toString().trim());
    }

    protected void o() {
        Toast.makeText(this, 2131690100, 0).show();
    }

    public void onClick(View paramView) {
        switch (paramView.getId()) {
            case 2131493134:
            default:
                return;
        }
        paramView = n();
        if (TextUtils.isEmpty(paramView)) {
            o();
            return;
        }
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this.t.getWindowToken(), 0);
        b(paramView);
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(2130903152);
        this.o = ((ImageViewEx) findViewById(2131493265));
        this.p = ((ImageViewEx) findViewById(2131493264));
        this.s = ((ProgressBar) findViewById(2131493268));
        this.q = findViewById(2131493267);
        this.r = findViewById(2131493266);
        this.t = ((EditText) findViewById(2131493262));
        this.t.setFilters(aj.a(getResources().getInteger(2131558422)));
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
            default:
                return super.onOptionsItemSelected(paramMenuItem);
        }
        onBackPressed();
        return true;
    }

    protected void p() {
        a(r());
    }

    protected void q() {
        s();
    }

    protected String[] r() {
        return new String[]{"task.publish"};
    }

    protected void s() {
        g localg = (g) f().a("dialog.progress");
        if (localg != null) {
            localg.b();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/publish/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */