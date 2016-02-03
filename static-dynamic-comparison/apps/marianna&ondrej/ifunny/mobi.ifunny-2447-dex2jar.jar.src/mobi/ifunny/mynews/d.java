package mobi.ifunny.mynews;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.k;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.RecyclerListener;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;

import mobi.ifunny.comments.AnswersActivity;
import mobi.ifunny.gallery.ContentAdapterFragment;
import mobi.ifunny.gallery.GalleryActivity;
import mobi.ifunny.gallery.fragment.m;
import mobi.ifunny.gallery.h;
import mobi.ifunny.main.IFunnyMenuActivity;
import mobi.ifunny.profile.i;
import mobi.ifunny.profile.l;
import mobi.ifunny.rest.content.Comment;
import mobi.ifunny.rest.content.IFunny;
import mobi.ifunny.rest.content.News;
import mobi.ifunny.rest.content.NewsFeed;
import mobi.ifunny.rest.content.RestError;
import mobi.ifunny.rest.content.User;
import mobi.ifunny.rest.retrofit.IFunnyRestRequest.Users;
import mobi.ifunny.rest.retrofit.RestHttpHandler;
import mobi.ifunny.social.auth.AuthActivity;
import mobi.ifunny.util.r;
import mobi.ifunny.util.v;
import uk.co.a.a.b.a.b;

public class d
        extends mobi.ifunny.profile.fragments.a<News, NewsFeed>
        implements AbsListView.RecyclerListener, c, i, mobi.ifunny.view.a, b {
    private static final String a = d.class.getSimpleName();
    private int b = -1;

    private boolean a(Comment paramComment) {
        if ((paramComment == null) || (TextUtils.isEmpty(paramComment.id)) || (paramComment.isAbused()) || (paramComment.isDeleted())) {
            Toast.makeText(getActivity(), 2131689752, 0).show();
            return false;
        }
        return true;
    }

    private boolean b(Comment paramComment) {
        if ((paramComment == null) || (TextUtils.isEmpty(paramComment.id)) || (paramComment.isAbused()) || (paramComment.isDeleted())) {
            Toast.makeText(getActivity(), 2131689764, 0).show();
            return false;
        }
        return true;
    }

    private boolean b(IFunny paramIFunny) {
        if ((paramIFunny == null) || (TextUtils.isEmpty(paramIFunny.id)) || (paramIFunny.isDeleted())) {
            Toast.makeText(getActivity(), 2131689754, 0).show();
            return false;
        }
        if (paramIFunny.isAbused()) {
            Toast.makeText(getActivity(), 2131689753, 0).show();
            return false;
        }
        return true;
    }

    private void c(Comment paramComment) {
        Object localObject = new Bundle();
        ((Bundle) localObject).putSerializable("arg.origin.flipState", m.b);
        ((Bundle) localObject).putString("ARG_SHOW_COMMENT_ID", paramComment.id);
        HashMap localHashMap = new HashMap();
        localHashMap.put(paramComment.cid, localObject);
        localObject = new Intent(getActivity(), GalleryActivity.class);
        ((Intent) localObject).putExtra("intent.gallery.type", 14);
        ((Intent) localObject).putExtra("intent.content.id", paramComment.cid);
        ((Intent) localObject).putExtra("ARG_OPTION_ARGS", localHashMap);
        startActivity((Intent) localObject);
    }

    private void c(IFunny paramIFunny) {
        Intent localIntent = new Intent(getActivity(), GalleryActivity.class);
        localIntent.putExtra("intent.gallery.type", 14);
        localIntent.putExtra("intent.content.id", paramIFunny.id);
        startActivity(localIntent);
    }

    private void d(Comment paramComment) {
        Intent localIntent = new Intent(getActivity(), AnswersActivity.class);
        localIntent.putExtra("EXTRA_CONTENT_ID", paramComment.cid);
        localIntent.putExtra("EXTRA_COMMENT_ID", paramComment.root_comm_id);
        localIntent.putExtra("EXTRA_SHOW_REPLY", paramComment.id);
        startActivity(localIntent);
    }

    private l h() {
        return (l) getParentFragment();
    }

    private void k() {
        this.b = -1;
        d().a(this.b);
    }

    public boolean J() {
        if (r.a()) {
            e();
            k();
            super.g(0);
            return true;
        }
        f();
        return false;
    }

    protected void a(int paramInt, NewsFeed paramNewsFeed) {
        List localList = paramNewsFeed.getList();
        int i = 0;
        while (i < localList.size()) {
            News localNews = (News) localList.get(i);
            if (!News.AVAILABLE_NEWS_TYPES.contains(localNews.type)) {
                localList.remove(localNews);
            }
            i += 1;
        }
        super.a(paramInt, paramNewsFeed);
    }

    protected void a(AdapterView<?> paramAdapterView, View paramView, int paramInt) {
        paramAdapterView = (News) d().c(paramInt).a;
        paramView = paramAdapterView.type;
        paramInt = -1;
        switch (paramView.hashCode()) {
            default:
                switch (paramInt) {
                }
                break;
        }
        do {
            do {
                do {
                    do {
                        do {
                            return;
                            if (!paramView.equals("smile")) {
                                break;
                            }
                            paramInt = 0;
                            break;
                            if (!paramView.equals("smile_for_repub")) {
                                break;
                            }
                            paramInt = 1;
                            break;
                            if (!paramView.equals("repub")) {
                                break;
                            }
                            paramInt = 2;
                            break;
                            if (!paramView.equals("repub_of_repub")) {
                                break;
                            }
                            paramInt = 3;
                            break;
                            if (!paramView.equals("comment")) {
                                break;
                            }
                            paramInt = 4;
                            break;
                            if (!paramView.equals("comment_for_repub")) {
                                break;
                            }
                            paramInt = 5;
                            break;
                            if (!paramView.equals("smile_for_comment")) {
                                break;
                            }
                            paramInt = 6;
                            break;
                            if (!paramView.equals("reply_for_comment")) {
                                break;
                            }
                            paramInt = 7;
                            break;
                            if (!paramView.equals("smile_for_reply")) {
                                break;
                            }
                            paramInt = 8;
                            break;
                            if (!paramView.equals("subscribe")) {
                                break;
                            }
                            paramInt = 9;
                            break;
                            if (!paramView.equals("friend_registered")) {
                                break;
                            }
                            paramInt = 10;
                            break;
                            if (!paramView.equals("featured")) {
                                break;
                            }
                            paramInt = 11;
                            break;
                            paramAdapterView = paramAdapterView.content;
                        } while (!b(paramAdapterView));
                        v.a(getActivity(), paramAdapterView);
                        return;
                        paramAdapterView = paramAdapterView.content;
                    } while (!b(paramAdapterView));
                    v.b(getActivity(), paramAdapterView);
                    return;
                    paramView = paramAdapterView.comment;
                } while ((!b(paramAdapterView.content)) || (!a(paramView)));
                c(paramView);
                return;
                paramView = paramAdapterView.reply;
            } while ((!b(paramAdapterView.content)) || (!b(paramView)));
            d(paramView);
            return;
            paramAdapterView = paramAdapterView.user;
            v.a(getActivity(), paramAdapterView.id);
            return;
            paramAdapterView = paramAdapterView.content;
        } while (!b(paramAdapterView));
        c(paramAdapterView);
    }

    public void a(IFunny paramIFunny) {
        mobi.ifunny.d.b(a, "onContentClicked " + paramIFunny);
        if (b(paramIFunny)) {
            c(paramIFunny);
        }
    }

    protected void a(NewsFeed paramNewsFeed) {
        a(0, paramNewsFeed);
    }

    public void a(User paramUser) {
    }

    public void a(User paramUser, boolean paramBoolean) {
        if (paramBoolean) {
            e();
        }
        if (B() == null) {
            g(0);
        }
        D();
    }

    protected <K extends ContentAdapterFragment<News, NewsFeed>> boolean a(String paramString1, String paramString2, String paramString3, RestHttpHandler<NewsFeed, K> paramRestHttpHandler) {
        IFunnyRestRequest.Users.getMyNews(this, paramString3, o(), paramString1, paramString2, paramRestHttpHandler);
        return true;
    }

    protected boolean a(RestError paramRestError) {
        f();
        return true;
    }

    public void b(User paramUser) {
        mobi.ifunny.d.b(a, "onUserClicked " + paramUser);
        paramUser = paramUser.id;
        k localk = getActivity();
        if (TextUtils.isEmpty(paramUser)) {
            Toast.makeText(localk, 2131689586, 0).show();
            return;
        }
        v.a(getActivity(), paramUser);
    }

    protected MyNewsAdapter c() {
        MyNewsAdapter localMyNewsAdapter = new MyNewsAdapter(b());
        localMyNewsAdapter.a(this);
        g();
        return localMyNewsAdapter;
    }

    protected MyNewsAdapter d() {
        return (MyNewsAdapter) super.i();
    }

    protected void f() {
        startActivityForResult(new Intent(getActivity(), AuthActivity.class), 0);
    }

    public void g() {
        Object localObject = getActivity();
        if ((localObject instanceof IFunnyMenuActivity)) {
            this.b = ((IFunnyMenuActivity) localObject).p();
            localObject = d();
            if (localObject != null) {
                ((MyNewsAdapter) localObject).a(this.b);
            }
        }
    }

    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        switch (paramInt1) {
            default:
                super.onActivityResult(paramInt1, paramInt2, paramIntent);
                return;
        }
        if (paramInt2 == -1) {
            J();
            return;
        }
        e();
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        return paramLayoutInflater.inflate(2130903164, paramViewGroup, false);
    }

    public void onMovedToScrapHeap(View paramView) {
        mobi.ifunny.d.b(a, "onMovedToScrapHeap " + paramView);
        d().onMovedToScrapHeap(paramView);
    }

    public void onRefreshStarted(View paramView) {
    }

    public void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        paramBundle.putInt("state.last_fresh_index", this.b);
    }

    public void onViewCreated(View paramView, Bundle paramBundle) {
        super.onViewCreated(paramView, paramBundle);
        e(getResources().getString(2131689756));
    }

    public void onViewStateRestored(Bundle paramBundle) {
        super.onViewStateRestored(paramBundle);
        if (paramBundle != null) {
            this.b = paramBundle.getInt("state.last_fresh_index", -1);
            paramBundle = d();
            if (paramBundle != null) {
                paramBundle.a(this.b);
            }
        }
    }

    protected void r() {
        h().a(this);
    }

    protected void s() {
        h().l();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/mynews/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */