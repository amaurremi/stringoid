package mobi.ifunny.g;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.k;
import android.support.v4.app.q;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.Toast;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import mobi.ifunny.comments.AnswersActivity;
import mobi.ifunny.comments.views.MyCommentViews;
import mobi.ifunny.gallery.ContentAdapterFragment;
import mobi.ifunny.gallery.GalleryActivity;
import mobi.ifunny.gallery.fragment.m;
import mobi.ifunny.gallery.h;
import mobi.ifunny.main.IFunnyMenuActivity;
import mobi.ifunny.rest.Features;
import mobi.ifunny.rest.content.Comment;
import mobi.ifunny.rest.content.IFunny;
import mobi.ifunny.rest.content.MyCommented;
import mobi.ifunny.rest.content.MyCommented.CommentedContent;
import mobi.ifunny.rest.content.User;
import mobi.ifunny.rest.retrofit.IFunnyRestRequest.Comments;
import mobi.ifunny.rest.retrofit.RestHttpHandler;
import mobi.ifunny.social.auth.l;
import mobi.ifunny.view.DynamicStaggeredGridView;

public class b
        extends mobi.ifunny.profile.fragments.a<MyCommented.CommentedContent, MyCommented>
        implements mobi.ifunny.comments.views.d, mobi.ifunny.profile.i {
    private mobi.ifunny.comments.views.b a;

    private int a(List<MyCommented.CommentedContent> paramList, String paramString) {
        int j = paramList.size();
        int i = 0;
        while (i < j) {
            if (TextUtils.equals(((MyCommented.CommentedContent) paramList.get(i)).id, paramString)) {
                return i;
            }
            i += 1;
        }
        return -1;
    }

    private void a(ContextMenu paramContextMenu, Comment paramComment) {
        if (paramComment != null) {
            paramComment = getActivity().getMenuInflater();
            paramContextMenu.setHeaderTitle(2131689537);
            paramComment.inflate(2131820559, paramContextMenu);
        }
    }

    private void a(String paramString) {
        if (!TextUtils.isEmpty(paramString)) {
            paramString = new Intent(getActivity(), IFunnyMenuActivity.class);
            paramString.putExtra("intent.start_fragment", mobi.ifunny.main.a.b.f);
            paramString.addFlags(67108864);
            startActivity(paramString);
        }
    }

    private void a(String paramString, mobi.ifunny.comments.i parami) {
        int i = a(((MyCommented) B()).getList(), paramString);
        paramString = (Comment) ((MyCommented) B()).getList().get(i);
        parami.a(paramString);
        b(paramString);
    }

    private void a(MyCommented.CommentedContent paramCommentedContent, int paramInt) {
        if (B() == null) {
            return;
        }
        int i = b().getFirstVisiblePosition();
        d().a(new h(paramCommentedContent), paramInt);
        if (d().getCount() > 0) {
            d(i);
        }
        D();
    }

    private boolean a(Comment paramComment) {
        if ((paramComment == null) || (TextUtils.isEmpty(paramComment.id)) || (paramComment.isAbused()) || (paramComment.isDeleted())) {
            Toast.makeText(getActivity(), 2131689730, 0).show();
            return false;
        }
        return true;
    }

    private boolean a(IFunny paramIFunny) {
        if ((paramIFunny == null) || (TextUtils.isEmpty(paramIFunny.id)) || (paramIFunny.isDeleted()) || (paramIFunny.isAbused())) {
            Toast.makeText(getActivity(), 2131689731, 0).show();
            return false;
        }
        return true;
    }

    private boolean a(MyCommented.CommentedContent paramCommentedContent) {
        return (paramCommentedContent.isAbused()) || (paramCommentedContent.isDeleted()) || ((paramCommentedContent.content != null) && ((paramCommentedContent.content.isDeleted()) || (paramCommentedContent.content.isAbused())));
    }

    private View b(List<MyCommented.CommentedContent> paramList, String paramString) {
        int i = a(paramList, paramString);
        if (i < 0) {
            return null;
        }
        return b().b(i);
    }

    private void b(String paramString, mobi.ifunny.comments.i parami) {
        if (B() != null) {
            int i = a(((MyCommented) B()).getList(), paramString);
            paramString = (Comment) ((MyCommented) B()).getList().get(i);
            if (paramString != null) {
                parami.b(paramString);
                b(paramString);
            }
        }
    }

    private void b(Comment paramComment) {
        paramComment = b(((MyCommented) B()).getList(), paramComment.getId());
        if (paramComment != null) {
            ((MyCommentViews) paramComment.getTag()).c(this.a);
        }
    }

    private void b(IFunny paramIFunny) {
        Object localObject = getActivity();
        paramIFunny = paramIFunny.id;
        if (TextUtils.isEmpty(paramIFunny)) {
            Toast.makeText((Context) localObject, 2131689586, 0).show();
            return;
        }
        localObject = new Intent((Context) localObject, GalleryActivity.class);
        ((Intent) localObject).putExtra("intent.gallery.type", 14);
        ((Intent) localObject).putExtra("intent.content.id", paramIFunny);
        startActivity((Intent) localObject);
    }

    private void b(MyCommented.CommentedContent paramCommentedContent) {
        if (paramCommentedContent.is_reply) {
            localObject1 = new Intent(getActivity(), AnswersActivity.class);
            ((Intent) localObject1).putExtra("EXTRA_CONTENT_ID", paramCommentedContent.cid);
            ((Intent) localObject1).putExtra("EXTRA_COMMENT_ID", paramCommentedContent.root_comm_id);
            ((Intent) localObject1).putExtra("EXTRA_SHOW_REPLY", paramCommentedContent.id);
            startActivity((Intent) localObject1);
            return;
        }
        Object localObject2 = new Bundle();
        ((Bundle) localObject2).putSerializable("arg.origin.flipState", m.b);
        ((Bundle) localObject2).putString("ARG_SHOW_COMMENT_ID", paramCommentedContent.id);
        Object localObject1 = new HashMap();
        ((HashMap) localObject1).put(paramCommentedContent.cid, localObject2);
        localObject2 = new Intent(getActivity(), GalleryActivity.class);
        ((Intent) localObject2).putExtra("intent.gallery.type", 14);
        ((Intent) localObject2).putExtra("intent.content.id", paramCommentedContent.cid);
        ((Intent) localObject2).putExtra("ARG_OPTION_ARGS", (Serializable) localObject1);
        startActivity((Intent) localObject2);
    }

    private void c(String paramString, mobi.ifunny.comments.i parami) {
        int i = a(((MyCommented) B()).getList(), paramString);
        paramString = (Comment) ((MyCommented) B()).getList().get(i);
        parami.c(paramString);
        b(paramString);
    }

    private void c(MyCommented.CommentedContent paramCommentedContent) {
        android.support.v4.app.g localg = (android.support.v4.app.g) getChildFragmentManager().a("deleteCommentDialog");
        if (localg != null) {
            localg.b();
        }
        e.a(paramCommentedContent, getResources().getString(2131689520)).a(getChildFragmentManager(), "deleteCommentDialog");
    }

    private void d(String paramString, mobi.ifunny.comments.i parami) {
        if (B() != null) {
            int i = a(((MyCommented) B()).getList(), paramString);
            paramString = (Comment) ((MyCommented) B()).getList().get(i);
            if (paramString != null) {
                parami.d(paramString);
                b(paramString);
            }
        }
    }

    private void d(MyCommented.CommentedContent paramCommentedContent) {
        int i = a(((MyCommented) B()).getList(), paramCommentedContent.id);
        IFunnyRestRequest.Comments.deleteComment(this, "rest.deleteComment", paramCommentedContent.cid, paramCommentedContent.id, new d(paramCommentedContent, i, null));
    }

    private void e(MyCommented.CommentedContent paramCommentedContent) {
        if (B() == null) {
            return;
        }
        paramCommentedContent = paramCommentedContent.id;
        int i = a(((MyCommented) B()).getList(), paramCommentedContent);
        if (i >= 0) {
            d().d(i);
            i = b().getFirstVisiblePosition();
            if (d().getCount() > 0) {
                d(i);
            }
        }
        D();
    }

    private void f(MyCommented.CommentedContent paramCommentedContent) {
        if (paramCommentedContent.is_smiled) {
            IFunnyRestRequest.Comments.deleteCommentSmile(this, "rest.deleteSmileComment", paramCommentedContent.content.id, paramCommentedContent.id, new f(paramCommentedContent, false, null));
            return;
        }
        IFunnyRestRequest.Comments.smileComment(this, "rest.smileComment", paramCommentedContent.content.id, paramCommentedContent.id, new f(paramCommentedContent, true, null));
    }

    private void g(MyCommented.CommentedContent paramCommentedContent) {
        if (paramCommentedContent.is_unsmiled) {
            IFunnyRestRequest.Comments.deleteCommentUnsmile(this, "rest.deleteUnsmileComment", paramCommentedContent.content.id, paramCommentedContent.id, new g(paramCommentedContent, false, null));
            return;
        }
        IFunnyRestRequest.Comments.unsmileComment(this, "rest.unsmileComment", paramCommentedContent.content.id, paramCommentedContent.id, new g(paramCommentedContent, true, null));
    }

    protected void a(AdapterView<?> paramAdapterView, View paramView, int paramInt) {
    }

    public void a(MyCommented.CommentedContent paramCommentedContent, View paramView) {
        if (a(paramCommentedContent.content)) {
            b(paramCommentedContent.content);
        }
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

    protected void a(boolean paramBoolean) {
        super.a(paramBoolean);
        if ((paramBoolean) && (!l.a().h())) {
            H();
        }
    }

    protected <K extends ContentAdapterFragment<MyCommented.CommentedContent, MyCommented>> boolean a(String paramString1, String paramString2, String paramString3, RestHttpHandler<MyCommented, K> paramRestHttpHandler) {
        IFunnyRestRequest.Comments.getMyComments(this, paramString3, o(), paramString1, paramString2, paramRestHttpHandler);
        return true;
    }

    public boolean b(MyCommented.CommentedContent paramCommentedContent, View paramView) {
        return false;
    }

    protected a c() {
        Object localObject = l.a();
        if (localObject != null) {
        }
        for (localObject = ((l) localObject).e(); ; localObject = null) {
            return new a(null, b(), (String) localObject, l.a().f(), this, this.a);
        }
    }

    public void c(MyCommented.CommentedContent paramCommentedContent, View paramView) {
        if (a(paramCommentedContent)) {
            b().showContextMenuForChild(paramView);
        }
        while (!a(paramCommentedContent)) {
            return;
        }
        b(paramCommentedContent);
    }

    protected a d() {
        return (a) super.i();
    }

    public void d(MyCommented.CommentedContent paramCommentedContent, View paramView) {
        a(l.a().d());
    }

    public boolean e(MyCommented.CommentedContent paramCommentedContent, View paramView) {
        return false;
    }

    public void f(MyCommented.CommentedContent paramCommentedContent, View paramView) {
        f(paramCommentedContent);
    }

    public void g(MyCommented.CommentedContent paramCommentedContent, View paramView) {
        g(paramCommentedContent);
    }

    public boolean onContextItemSelected(MenuItem paramMenuItem) {
        int i = ((AdapterView.AdapterContextMenuInfo) paramMenuItem.getMenuInfo()).position - b().getHeaderViewsCount();
        if (i < 0) {
            return super.onContextItemSelected(paramMenuItem);
        }
        MyCommented.CommentedContent localCommentedContent = (MyCommented.CommentedContent) d().c(i).a;
        switch (paramMenuItem.getItemId()) {
        }
        for (; ; ) {
            return super.onContextItemSelected(paramMenuItem);
            c(localCommentedContent);
        }
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        k localk = getActivity();
        if (Features.isHideNewCommentsSmilesTurnedOn()) {
        }
        for (int i = Features.getHideNewCommentsSmilesInterval().intValue(); ; i = 0) {
            this.a = new mobi.ifunny.comments.views.b(localk, Integer.valueOf(i));
            if (paramBundle == null) {
                mobi.ifunny.b.g.a(getActivity(), "MyComments");
            }
            return;
        }
    }

    public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo) {
        super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
        if ((paramContextMenuInfo != null) && ((paramContextMenuInfo instanceof AdapterView.AdapterContextMenuInfo))) {
            int i = ((AdapterView.AdapterContextMenuInfo) paramContextMenuInfo).position - b().getHeaderViewsCount();
            if (i >= 0) {
                a(paramContextMenu, (Comment) d().c(i).a);
            }
        }
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        return paramLayoutInflater.inflate(2130903164, paramViewGroup, false);
    }

    public void onViewCreated(View paramView, Bundle paramBundle) {
        super.onViewCreated(paramView, paramBundle);
        registerForContextMenu(b());
        f(2131689732);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/g/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */