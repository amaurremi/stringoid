package mobi.ifunny.comments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ab;
import android.support.v4.app.q;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import butterknife.ButterKnife;
import butterknife.InjectView;
import mobi.ifunny.b.g;
import mobi.ifunny.fragment.ProgressAndEmptyFragment;
import mobi.ifunny.fragment.m;
import mobi.ifunny.rest.content.Comment;
import mobi.ifunny.rest.content.IFunny;
import mobi.ifunny.rest.content.User;
import mobi.ifunny.rest.retrofit.IFunnyRestRequest.Content;
import mobi.ifunny.social.auth.l;
import uk.co.a.a.b.f;

public class AnswersActivity
        extends mobi.ifunny.l.a
        implements u, uk.co.a.a.b.a.b {
    public static final String o = ProgressAndEmptyFragment.class.getSimpleName();
    private Comment p;
    private IFunny q;
    private AnswersFragment r;
    @InjectView(2131493009)
    View rootFrame;
    private ProgressAndEmptyFragment s;
    private mobi.ifunny.a.a t;
    private uk.co.a.a.a.a.c u;

    private void a(String paramString1, String paramString2) {
        if (!e("TASK_REQUEST_COMMENT")) {
            IFunnyRestRequest.Content.getComment(this, "TASK_REQUEST_COMMENT", paramString1, paramString2, new b(null));
        }
    }

    private void a(boolean paramBoolean, Comment paramComment, IFunny paramIFunny) {
        if (paramBoolean) {
            setResult(0);
            return;
        }
        Intent localIntent = new Intent();
        localIntent.putExtra("EXTRA_COMMENT", paramComment);
        localIntent.putExtra("EXTRA_CONTENT", paramIFunny);
        setResult(-1, localIntent);
    }

    private void b(String paramString) {
        if (!e("TASK_REQUEST_CONTENT")) {
            IFunnyRestRequest.Content.getContent(this, "TASK_REQUEST_CONTENT", paramString, new c(null));
        }
    }

    private void b(Comment paramComment) {
        this.p = paramComment;
        if (this.q != null) {
            r();
        }
    }

    private void b(IFunny paramIFunny) {
        this.q = paramIFunny;
        if (this.p != null) {
            r();
        }
    }

    private void c(Comment paramComment) {
        b(paramComment);
    }

    private void c(IFunny paramIFunny) {
        b(paramIFunny);
    }

    private void q() {
        int i = 0;
        Object localObject2;
        Object localObject1;
        if (this.p == null) {
            localObject2 = getIntent().getStringExtra("EXTRA_COMMENT_ID");
            if (this.q == null) {
                localObject1 = getIntent().getStringExtra("EXTRA_CONTENT_ID");
                a((String) localObject1, (String) localObject2);
                i = 1;
            }
        } else {
            if (this.q == null) {
                b(getIntent().getStringExtra("EXTRA_CONTENT_ID"));
                i = 1;
            }
            localObject1 = f();
            if (i == 0) {
                break label166;
            }
            this.s = ((ProgressAndEmptyFragment) ((q) localObject1).a(o));
            if (this.s != null) {
                break label156;
            }
            this.s = ProgressAndEmptyFragment.a(m.a, 2131689542, 2130837614);
            localObject2 = ((q) localObject1).a();
            ((ab) localObject2).b(2131493009, this.s, o);
            ((ab) localObject2).c();
            ((q) localObject1).b();
        }
        for (; ; ) {
            this.r = null;
            return;
            localObject1 = this.q.id;
            break;
            label156:
            this.s.a();
        }
        label166:
        this.r = ((AnswersFragment) ((q) localObject1).a("TAG_ANSWERS_FRAGMENT"));
        if (this.r == null) {
            r();
        }
        for (; ; ) {
            this.s = null;
            return;
            this.r.setUserVisibleHint(true);
        }
    }

    private void r() {
        q localq = f();
        Object localObject = (Comment) getIntent().getParcelableExtra("EXTRA_REPLY_TO");
        this.r = AnswersFragment.a(getIntent().getStringExtra("EXTRA_SHOW_REPLY"), this.p, (Comment) localObject);
        localObject = localq.a();
        ((ab) localObject).b(2131493009, this.r, "TAG_ANSWERS_FRAGMENT");
        ((ab) localObject).c();
        localq.b();
        this.r.setUserVisibleHint(true);
        d();
    }

    private void s() {
        this.s.b();
    }

    public void a(Comment paramComment) {
        a(false, paramComment, this.q);
        finish();
    }

    public void a(IFunny paramIFunny) {
        setResult(100);
        finish();
    }

    public void a(IFunny paramIFunny, Comment paramComment) {
        a(paramComment);
    }

    public void b(boolean paramBoolean) {
        this.t.c(paramBoolean);
    }

    public IFunny n() {
        return this.q;
    }

    public void o() {
        this.u.a(this);
        this.u.a(true);
    }

    public void onBackPressed() {
        if (this.r == null) {
            a(true, null, null);
        }
        for (; ; ) {
            super.onBackPressed();
            return;
            a(false, this.r.g(), this.q);
        }
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(2130903067);
        ButterKnife.inject(this);
        this.p = ((Comment) getIntent().getParcelableExtra("EXTRA_COMMENT"));
        this.q = ((IFunny) getIntent().getParcelableExtra("EXTRA_CONTENT"));
        this.t = new mobi.ifunny.a.a();
        this.t.a(findViewById(2131492867));
        f localf = new f();
        localf.a(0.85F);
        localf.a();
        this.u = new uk.co.a.a.a.a.c(this, localf.b());
        if (paramBundle == null) {
            g.a(this, "CommentAnswers");
        }
    }

    public boolean onCreateOptionsMenu(Menu paramMenu) {
        getMenuInflater().inflate(2131820544, paramMenu);
        return true;
    }

    protected void onDestroy() {
        super.onDestroy();
        this.t.a();
        this.u.f();
        this.u = null;
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        boolean bool2 = true;
        boolean bool1;
        switch (paramMenuItem.getItemId()) {
            default:
                bool1 = super.onOptionsItemSelected(paramMenuItem);
            case 2131493381:
                do {
                    do {
                        return bool1;
                        if (this.r != null) {
                            this.r.J();
                            return true;
                        }
                        bool1 = bool2;
                    } while (this.s == null);
                    bool1 = bool2;
                } while (this.s.c() != m.b);
                q();
                return true;
        }
        this.r.n();
        return true;
    }

    protected void onPause() {
        super.onPause();
        this.t.b();
    }

    protected void onPostCreate(Bundle paramBundle) {
        super.onPostCreate(paramBundle);
        q();
    }

    public boolean onPrepareOptionsMenu(Menu paramMenu) {
        boolean bool2 = false;
        MenuItem localMenuItem = paramMenu.findItem(2131493380);
        if (this.r != null) {
            String str = l.a().d();
            User localUser = this.q.getOriginalAuthor();
            boolean bool1 = bool2;
            if (localUser != null) {
                bool1 = bool2;
                if (TextUtils.equals(str, localUser.id)) {
                    bool1 = true;
                }
            }
            localMenuItem.setVisible(bool1);
        }
        for (; ; ) {
            return super.onPrepareOptionsMenu(paramMenu);
            localMenuItem.setVisible(false);
        }
    }

    public void onRefreshStarted(View paramView) {
    }

    protected void onRestoreInstanceState(Bundle paramBundle) {
        super.onRestoreInstanceState(paramBundle);
        this.p = ((Comment) paramBundle.getParcelable("STATE_COMMENT"));
        this.q = ((IFunny) paramBundle.getParcelable("STATE_CONTENT"));
    }

    protected void onResume() {
        super.onResume();
        this.t.c();
    }

    protected void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        paramBundle.putParcelable("STATE_COMMENT", this.p);
        paramBundle.putParcelable("STATE_CONTENT", this.q);
    }

    public void p() {
        this.u.a(null);
        this.u.d();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/comments/AnswersActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */