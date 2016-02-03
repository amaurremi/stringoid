package mobi.ifunny.comments;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.k;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ImageView;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import mobi.ifunny.comments.views.SmilyCommentViews;
import mobi.ifunny.main.IFunnyMenuActivity;
import mobi.ifunny.rest.Features;
import mobi.ifunny.rest.content.Comment;
import mobi.ifunny.rest.content.CommentsFeed;
import mobi.ifunny.rest.content.Counters;
import mobi.ifunny.rest.content.DeleteResponcesList;
import mobi.ifunny.rest.content.IFunny;
import mobi.ifunny.rest.content.RestError;
import mobi.ifunny.rest.content.User;
import mobi.ifunny.rest.retrofit.IFunnyRestRequest.Comments;
import mobi.ifunny.rest.retrofit.RestErrorBody;
import mobi.ifunny.rest.retrofit.RestHttpHandler;
import mobi.ifunny.rest.retrofit.SimpleRestHttpHandler;
import mobi.ifunny.social.auth.AuthActivity;
import mobi.ifunny.view.DynamicListView;
import mobi.ifunny.view.EditTextEx;

public abstract class CommentsFragment<C extends Comment, F extends CommentsFeed<C>>
        extends mobi.ifunny.gallery.e<C, F>
        implements mobi.ifunny.comments.views.e<C>, mobi.ifunny.util.y {
    protected String a;
    protected ArrayList<C> b;
    protected mobi.ifunny.comments.views.b c;
    @InjectView(2131493014)
    View commentsDim;
    protected mobi.ifunny.util.c d;
    protected boolean e;
    protected CommentsFragment<C, F>.ab f;
    private int h;
    private Handler i;
    private android.support.v7.c.a j;
    private CommentsFragment<C, F>.v k;
    private ArrayList<C> l;
    private String m;
    @InjectView(2131493020)
    protected ImageView myAvatar;
    @InjectView(2131493019)
    protected View myAvatarBackground;
    private u n;
    private mobi.ifunny.util.w o;
    private Runnable p = new o(this);
    private TextWatcher q = new p(this);
    @InjectView(2131493022)
    protected View sendCommentView;
    @InjectView(2131493021)
    protected EditTextEx writeCommentView;

    private void Q() {
    }

    private void R() {
        Toast.makeText(getActivity(), 2131689525, 0).show();
    }

    private void a(int paramInt, Comment paramComment, boolean paramBoolean) {
        if (paramBoolean) {
            h().b(paramInt);
        }
        paramInt = a(((CommentsFeed) B()).getList(), paramComment.id);
        if (paramInt >= 0) {
            paramComment = c(paramInt);
            if (paramComment != null) {
                h().a(h().c(paramInt), paramComment, false);
            }
        }
    }

    private void a(Bitmap paramBitmap, mobi.ifunny.util.a.a parama) {
        paramBitmap = new com.makeramen.c(paramBitmap);
        paramBitmap.a(true);
        this.myAvatar.setTag(parama.c());
        a(paramBitmap);
    }

    private void a(String paramString, i parami) {
        if (B() == null) {
            return;
        }
        int i1 = a(((CommentsFeed) B()).getList(), paramString);
        paramString = (Comment) ((CommentsFeed) B()).getItem(i1);
        parami.a(paramString);
        k(paramString);
    }

    private void a(Comment paramComment, String paramString) {
        android.support.v4.app.g localg = (android.support.v4.app.g) getChildFragmentManager().a("deleteCommentDialog");
        if (localg != null) {
            localg.b();
        }
        z.a(paramComment, paramString).a(getChildFragmentManager(), "deleteCommentDialog");
    }

    private void a(C paramC, boolean paramBoolean) {
        if (paramBoolean) {
            h().d(paramC);
        }
        int i1 = a(((CommentsFeed) B()).getList(), paramC.id);
        if (i1 >= 0) {
            paramC = c(i1);
            if (paramC != null) {
                h().a(h().c(i1), paramC, true);
            }
        }
    }

    private void b() {
        this.writeCommentView.removeCallbacks(this.p);
        this.writeCommentView.removeTextChangedListener(this.q);
        this.writeCommentView.setOnEditorActionListener(null);
        if (TextUtils.isEmpty(this.m)) {
            this.m = this.writeCommentView.getText().toString();
        }
        this.writeCommentView.setText(null);
        this.writeCommentView.getText().clearSpans();
    }

    private void b(String paramString, i parami) {
        if (B() != null) {
            int i1 = a(((CommentsFeed) B()).getList(), paramString);
            paramString = (Comment) ((CommentsFeed) B()).getItem(i1);
            if (paramString != null) {
                parami.b(paramString);
                k(paramString);
            }
        }
    }

    private int c() {
        return ((CommentsFeed) B()).getExhibitCommentsCount();
    }

    public static Bundle c(String paramString) {
        Bundle localBundle = new Bundle();
        localBundle.putString("ARG_SHOW_COMMENT_ID", paramString);
        return localBundle;
    }

    private void c(String paramString, i parami) {
        int i1 = a(((CommentsFeed) B()).getList(), paramString);
        paramString = (Comment) ((CommentsFeed) B()).getItem(i1);
        parami.c(paramString);
        k(paramString);
    }

    private void c(List<C> paramList) {
        h().a(paramList);
        paramList = paramList.iterator();
        while (paramList.hasNext()) {
            a((Comment) paramList.next(), false);
        }
    }

    private void d() {
        List localList = h().c();
        int i2 = localList.size();
        int i1 = 0;
        while (i1 < i2) {
            a(i1, (Comment) localList.get(i1), false);
            i1 += 1;
        }
        h().b();
    }

    private void d(String paramString, i parami) {
        if (B() != null) {
            int i1 = a(((CommentsFeed) B()).getList(), paramString);
            paramString = (Comment) ((CommentsFeed) B()).getItem(i1);
            if (paramString != null) {
                parami.d(paramString);
                k(paramString);
            }
        }
    }

    private void d(List<C> paramList) {
        if (paramList.size() == 0) {
            return;
        }
        IFunnyRestRequest.Comments.deleteComments(this, "rest.deleteComments", m().id, paramList, new y(paramList, null));
    }

    private void f() {
        String str = this.writeCommentView.getText().toString().trim();
        if (TextUtils.isEmpty(str)) {
            Toast.makeText(getActivity(), 2131689549, 0).show();
            return;
        }
        ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.writeCommentView.getWindowToken(), 0);
        if (mobi.ifunny.social.auth.l.a().h()) {
            h(str);
            return;
        }
        G_();
    }

    private void g() {
        d(h().c());
        this.j.b();
    }

    private void g(String paramString) {
        if (!TextUtils.isEmpty(paramString)) {
            if ((getActivity() instanceof mobi.ifunny.main.f)) {
                paramString = new Intent(getActivity(), IFunnyMenuActivity.class);
                paramString.putExtra("intent.start_fragment", mobi.ifunny.main.a.b.f);
                paramString.addFlags(67108864);
                startActivity(paramString);
            }
        } else {
            return;
        }
        mobi.ifunny.util.v.a(getActivity(), paramString);
    }

    private void h(String paramString) {
        if (f("rest.addComment")) {
            return;
        }
        paramString = b(paramString);
        a("rest.addComment", m().id, paramString, new s(paramString, null));
    }

    private void h(C paramC) {
        int i1 = h().e(paramC);
        if (i1 < 0) {
            a(paramC, true);
        }
        for (; ; ) {
            this.j.c();
            return;
            a(i1, paramC, true);
        }
    }

    private void i(String paramString) {
        android.support.v4.app.q localq = getChildFragmentManager();
        android.support.v4.app.g localg = (android.support.v4.app.g) getChildFragmentManager().a("deleteBatchCommentDialog");
        if (localg != null) {
            localg.b();
            localq.b();
        }
        w.a(paramString).a(localq, "deleteCommentDialog");
    }

    private void i(Comment paramComment) {
        if (paramComment.is_smiled) {
            IFunnyRestRequest.Comments.deleteCommentSmile(this, "rest.deleteSmileComment", m().id, paramComment.id, new ac(paramComment, false, null));
            return;
        }
        IFunnyRestRequest.Comments.smileComment(this, "rest.smileComment", m().id, paramComment.id, new ac(paramComment, true, null));
    }

    private void j(Comment paramComment) {
        if (paramComment.is_unsmiled) {
            IFunnyRestRequest.Comments.deleteCommentUnsmile(this, "rest.deleteUnsmileComment", m().id, paramComment.id, new ad(paramComment, false, null));
            return;
        }
        IFunnyRestRequest.Comments.unsmileComment(this, "rest.unsmileComment", m().id, paramComment.id, new ad(paramComment, true, null));
    }

    private void k(Comment paramComment) {
        paramComment = b(((CommentsFeed) B()).getList(), paramComment.getId());
        if (paramComment != null) {
            ((SmilyCommentViews) paramComment.getTag()).c(this.c);
        }
    }

    private void l(C paramC) {
        if (f("rest.deleteComment")) {
            return;
        }
        a(paramC, "rest.deleteComment", new x(paramC, a(((CommentsFeed) B()).getList(), paramC.id), null));
    }

    private void m(Comment paramComment) {
        IFunnyRestRequest.Comments.abuseComment(this, "rest.abuseComment", m().id, paramComment.id, new r(null));
    }

    private void n(Comment paramComment) {
        android.support.v4.app.g localg = (android.support.v4.app.g) getChildFragmentManager().a("abuseCommentDialog");
        if (localg != null) {
            localg.b();
        }
        q.a(paramComment, getResources().getString(2131689515)).a(getChildFragmentManager(), "abuseCommentDialog");
    }

    protected final void F_() {
        if ((android.support.v4.app.g) getChildFragmentManager().a("DIALOG_PROGRESS") == null) {
            mobi.ifunny.fragment.h localh = new mobi.ifunny.fragment.h();
            localh.b(false);
            localh.a(getChildFragmentManager(), "DIALOG_PROGRESS");
        }
    }

    protected void G_() {
        ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.writeCommentView.getWindowToken(), 0);
        startActivity(new Intent(getActivity(), AuthActivity.class));
    }

    protected int a(List<C> paramList, String paramString) {
        int i2 = paramList.size();
        int i1 = 0;
        while (i1 < i2) {
            if (TextUtils.equals(((Comment) paramList.get(i1)).getId(), paramString)) {
                return i1;
            }
            i1 += 1;
        }
        return -1;
    }

    protected String a(int paramInt) {
        return mobi.ifunny.util.r.b(getResources(), 2131623942, 2131689548, paramInt);
    }

    protected void a(int paramInt, F paramF) {
        int i1 = -1;
        super.a(paramInt, paramF);
        if (paramInt == 0) {
            this.b.clear();
            if (TextUtils.isEmpty(this.a)) {
                paramInt = i1;
                d(paramInt);
                this.a = null;
            }
        }
        for (; ; ) {
            b(c());
            return;
            paramInt = a(paramF.getList(), this.a);
            break;
            if (paramInt == 1) {
                ((CommentsFeed) B()).setExhibitCommentsCount(paramF.getExhibitCommentsCount());
            } else if (paramInt == -1) {
                int i4 = this.g.getFirstVisiblePosition();
                ((CommentsFeed) B()).setExhibitCommentsCount(paramF.getExhibitCommentsCount());
                List localList1 = paramF.getList();
                List localList2 = ((CommentsFeed) B()).getList();
                if (localList1.size() > 0) {
                    paramInt = this.b.size();
                    int i3;
                    for (i1 = 0; i1 < paramInt; i1 = i3 + 1) {
                        Comment localComment = (Comment) this.b.get(i1);
                        i3 = i1;
                        int i2 = paramInt;
                        if (a(localList1, localComment.id) >= 0) {
                            this.b.remove(i1);
                            i3 = i1 - 1;
                            i2 = paramInt - 1;
                            localList2.remove(localComment);
                            h().c(localComment);
                        }
                        paramInt = i2;
                    }
                }
                i1 = paramF.size() + i4 - 1;
                paramInt = i1;
                if (i1 < 0) {
                    paramInt = 0;
                }
                d(paramInt);
            }
        }
    }

    protected void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
        if (c(paramInt) == null) {
            if ((!paramBoolean2) || (((paramInt >= this.g.getFirstVisiblePosition()) || (this.g.getFirstVisiblePosition() - paramInt > 6)) && ((paramInt <= this.g.getLastVisiblePosition()) || (paramInt - this.g.getLastVisiblePosition() > 6)))) {
                break label72;
            }
        }
        label72:
        for (paramBoolean2 = true; ; paramBoolean2 = false) {
            b(paramInt, paramBoolean1, paramBoolean2);
            return;
        }
    }

    protected void a(Drawable paramDrawable) {
        if (paramDrawable == null) {
            this.d.a(this.myAvatar, mobi.ifunny.social.auth.l.a().g());
            this.myAvatar.setTag(null);
        }
        for (; ; ) {
            mobi.ifunny.util.b.a(this.myAvatar);
            return;
            this.myAvatar.setImageDrawable(paramDrawable);
        }
    }

    protected void a(ContextMenu paramContextMenu, Comment paramComment) {
        MenuInflater localMenuInflater;
        User localUser;
        if (paramComment != null) {
            localMenuInflater = getActivity().getMenuInflater();
            paramContextMenu.setHeaderTitle(2131689537);
            localUser = m().getOriginalAuthor();
            if (this.c.a(paramComment.user.id)) {
                localMenuInflater.inflate(2131820548, paramContextMenu);
            }
        } else {
            return;
        }
        if ((localUser != null) && (this.c.a(localUser.id))) {
            localMenuInflater.inflate(2131820547, paramContextMenu);
            return;
        }
        localMenuInflater.inflate(2131820546, paramContextMenu);
    }

    protected void a(AdapterView<?> paramAdapterView, View paramView, int paramInt) {
    }

    protected abstract <F1 extends CommentsFeed<C>, K extends CommentsFragment<C, F1>> void a(String paramString1, String paramString2, Comment paramComment, SimpleRestHttpHandler<C, K> paramSimpleRestHttpHandler);

    protected abstract void a(List<C> paramList);

    protected void a(List<C> paramList, DeleteResponcesList paramDeleteResponcesList) {
        LinkedList localLinkedList = new LinkedList();
        int i2 = paramDeleteResponcesList.responses.size();
        int i1 = 0;
        while (i1 < i2) {
            if (((RestErrorBody) paramDeleteResponcesList.responses.get(i1)).status == 200) {
                localLinkedList.add(paramList.get(i1));
            }
            i1 += 1;
        }
        if (localLinkedList.size() == 0) {
            Toast.makeText(getActivity(), 2131689583, 0).show();
            return;
        }
        ((CommentsFeed) B()).setExhibitCommentsCount(((CommentsFeed) B()).getExhibitCommentsCount() - localLinkedList.size());
        a(localLinkedList);
        D();
        b(c());
    }

    protected void a(Comment paramComment) {
        if (B() == null) {
            return;
        }
        paramComment = paramComment.id;
        int i1 = a(((CommentsFeed) B()).getList(), paramComment);
        Counters localCounters = m().num;
        localCounters.comments -= 1;
        ((CommentsFeed) B()).setExhibitCommentsCount(((CommentsFeed) B()).getExhibitCommentsCount() - 1);
        if (i1 >= 0) {
            int i2 = this.g.getFirstVisiblePosition();
            if (i1 >= 0) {
                h().d(i1);
            }
            if (h().getCount() > 0) {
                a(i2, true, false);
            }
        }
        i1 = a(this.b, paramComment);
        if (i1 >= 0) {
            this.b.remove(i1);
        }
        D();
        b(c());
    }

    protected void a(C paramC, String paramString, int paramInt) {
        if (B() == null) {
            return;
        }
        ((CommentsFeed) B()).setExhibitCommentsCount(((CommentsFeed) B()).getExhibitCommentsCount() + 1);
        paramString = m().num;
        paramString.comments += 1;
        int i1 = this.g.getFirstVisiblePosition();
        h().a(paramC, paramInt);
        if (h().getCount() > 0) {
            a(i1, true, false);
        }
        D();
        b(c());
    }

    protected abstract <K extends CommentsFragment<C, F>> void a(C paramC, String paramString, RestHttpHandler<Void, K> paramRestHttpHandler);

    protected void a(boolean paramBoolean) {
        super.a(paramBoolean);
        if (paramBoolean) {
            this.o.a(getView());
            this.commentsDim.setVisibility(8);
            this.writeCommentView.setOnEditorActionListener(new n(this));
            this.writeCommentView.clearFocus();
            registerForContextMenu(this.g);
            this.writeCommentView.addTextChangedListener(this.q);
            this.writeCommentView.setText(this.m);
            if (!TextUtils.isEmpty(this.m)) {
                this.writeCommentView.setSelection(this.m.length());
                this.m = null;
                if (B() != null) {
                    b(c());
                }
                if (v()) {
                    Object localObject = mobi.ifunny.social.auth.l.a().f();
                    ViewGroup.LayoutParams localLayoutParams = this.myAvatar.getLayoutParams();
                    localObject = new mobi.ifunny.util.a.a((String) localObject, new Point(localLayoutParams.width, localLayoutParams.height), false);
                    new aa(this, "TASK_LOAD_AVATAR", (mobi.ifunny.util.a.a) localObject).execute(new String[]{((mobi.ifunny.util.a.a) localObject).c()});
                }
                if (this.l != null) {
                    c(this.l);
                    this.l = null;
                    this.j = w().a(this.k);
                }
            }
        }
        do {
            return;
            this.writeCommentView.setSelection(0);
            break;
            this.o.a();
            l().b(true);
            this.e = false;
            b();
            ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.writeCommentView.getWindowToken(), 0);
            this.commentsDim.setVisibility(8);
            unregisterForContextMenu(this.g);
        } while (this.j == null);
        this.l = new ArrayList(h().c());
        this.j.b();
        this.j = null;
    }

    protected boolean a(int paramInt, RestError paramRestError) {
        e();
        this.myAvatar.setVisibility(4);
        this.writeCommentView.setVisibility(4);
        this.sendCommentView.setVisibility(4);
        return super.a(paramInt, paramRestError);
    }

    protected boolean a(String paramString) {
        boolean bool = false;
        if (TextUtils.equals(paramString, "content_was_deleted")) {
            Toast.makeText(getActivity(), 2131689651, 0).show();
            l().a(m());
            bool = true;
        }
        return bool;
    }

    public boolean a(C paramC, View paramView) {
        if ((this.j != null) && (g(paramC))) {
            h(paramC);
            return true;
        }
        return false;
    }

    protected boolean a(C paramC, RestError paramRestError) {
        if (paramRestError != null) {
            if (paramRestError.code == 403) {
                if (TextUtils.equals(paramRestError.error, "text_too_long")) {
                    Toast.makeText(getActivity(), 2131689540, 0).show();
                    return true;
                }
                if (TextUtils.equals(paramRestError.error, "wrong_text")) {
                    Toast.makeText(getActivity(), 2131689549, 0).show();
                    return true;
                }
                if (TextUtils.equals(paramRestError.error, "spam_comment")) {
                    Toast.makeText(getActivity(), 2131689517, 0).show();
                    return true;
                }
            } else if (paramRestError.code == 404) {
                return a(paramRestError.error);
            }
        }
        return false;
    }

    protected int b(List<C> paramList) {
        int i2 = paramList.size();
        int i1 = 0;
        while (i1 < i2) {
            if (!((Comment) paramList.get(i1)).isTop()) {
                return i1;
            }
            i1 += 1;
        }
        return -1;
    }

    protected View b(List<C> paramList, String paramString) {
        int i1 = a(paramList, paramString);
        if (i1 < 0) {
            return null;
        }
        return c(i1);
    }

    protected abstract C b(String paramString);

    protected void b(int paramInt) {
        if (!getUserVisibleHint()) {
            return;
        }
        String str = a(paramInt);
        a().a(str);
    }

    protected void b(int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
        if (paramBoolean1) {
            if (this.f != null) {
                this.i.removeCallbacks(this.f);
            }
            this.f = new ab(this, paramInt, paramBoolean2);
            this.i.post(this.f);
            return;
        }
        if (paramBoolean2) {
            e(paramInt);
            return;
        }
        d(paramInt);
    }

    protected void b(Comment paramComment) {
        mobi.ifunny.social.auth.l locall = mobi.ifunny.social.auth.l.a();
        if ((locall.h()) && (TextUtils.equals(paramComment.user.id, locall.d()))) {
            mobi.ifunny.profile.l.h.add(mobi.ifunny.profile.u.e);
        }
    }

    public void b(C paramC, View paramView) {
        this.g.showContextMenuForChild(paramView);
    }

    protected View c(int paramInt) {
        return this.g.a(paramInt);
    }

    protected void c(Comment paramComment) {
    }

    public void c(C paramC, View paramView) {
        mobi.ifunny.util.v.a(getActivity(), paramC.user.id);
    }

    protected void d(C paramC) {
        if (B() == null) {
        }
        while (paramC == null) {
            return;
        }
        ((CommentsFeed) B()).setExhibitCommentsCount(((CommentsFeed) B()).getExhibitCommentsCount() + 1);
        Counters localCounters = m().num;
        localCounters.comments += 1;
        this.b.add(paramC);
        int i1 = e(paramC);
        if (i1 >= 0) {
            h().a(paramC, i1);
        }
        for (; ; ) {
            a(i1, true, true);
            this.writeCommentView.setText(null);
            b(c());
            D();
            mobi.ifunny.profile.l.h.add(mobi.ifunny.profile.u.e);
            return;
            h().b(paramC);
        }
    }

    public boolean d(C paramC, View paramView) {
        User localUser = m().getOriginalAuthor();
        if ((localUser == null) || (!this.c.a(localUser.id))) {
            this.g.showContextMenuForChild(paramView);
            return true;
        }
        if (g(paramC)) {
            if (this.j == null) {
                this.j = w().a(this.k);
            }
            h(paramC);
            return true;
        }
        this.g.showContextMenuForChild(paramView);
        return true;
    }

    protected int e(C paramC) {
        return b(((CommentsFeed) B()).getList());
    }

    public void e() {
        super.e();
        this.writeCommentView.setVisibility(0);
        this.sendCommentView.setVisibility(0);
        this.myAvatar.setVisibility(0);
        this.sendCommentView.setEnabled(false);
        mobi.ifunny.l.g.a(this, new String[]{"rest.getComments", "rest.deleteSmileComment", "rest.deleteComment", "rest.smileComment", "rest.addComment"});
        this.l = null;
        if (this.j != null) {
            this.j.b();
        }
        this.b.clear();
    }

    public void e(C paramC, View paramView) {
        if (mobi.ifunny.social.auth.l.a().h()) {
            i(paramC);
            return;
        }
        G_();
    }

    protected void f(C paramC) {
    }

    public void f(C paramC, View paramView) {
        if (mobi.ifunny.social.auth.l.a().h()) {
            j(paramC);
            return;
        }
        G_();
    }

    protected boolean g(C paramC) {
        return true;
    }

    protected t<C, F> h() {
        return (t) super.i();
    }

    protected u k() {
        if ((getParentFragment() instanceof u)) {
            return (u) getParentFragment();
        }
        if ((getActivity() instanceof u)) {
            return (u) getActivity();
        }
        return null;
    }

    protected u l() {
        if (this.n == null) {
            this.n = k();
        }
        return this.n;
    }

    protected IFunny m() {
        return l().n();
    }

    public void n() {
        if ((h().getCount() > 0) && (this.j == null)) {
            this.j = w().a(this.k);
            this.j.c();
        }
    }

    protected int o() {
        return this.h;
    }

    public boolean onContextItemSelected(MenuItem paramMenuItem) {
        if (!A()) {
            return false;
        }
        Object localObject = (AdapterView.AdapterContextMenuInfo) paramMenuItem.getMenuInfo();
        int i1 = this.g.b(((AdapterView.AdapterContextMenuInfo) localObject).position);
        if (i1 < 0) {
            return super.onContextItemSelected(paramMenuItem);
        }
        localObject = (Comment) h().c(i1).a;
        switch (paramMenuItem.getItemId()) {
            default:
            case 2131493384:
            case 2131493385:
            case 2131493383:
                for (; ; ) {
                    return super.onContextItemSelected(paramMenuItem);
                    mobi.ifunny.util.v.a(getActivity(), ((Comment) localObject).user.id);
                    return true;
                    if (mobi.ifunny.social.auth.l.a().h()) {
                        n((Comment) localObject);
                    }
                    for (; ; ) {
                        return true;
                        G_();
                    }
                    if (mobi.ifunny.social.auth.l.a().h()) {
                        f((Comment) localObject);
                    } else {
                        G_();
                    }
                }
            case 2131493387:
                if (mobi.ifunny.social.auth.l.a().h()) {
                    a((Comment) localObject, getResources().getString(2131689519));
                }
                for (; ; ) {
                    return true;
                    G_();
                }
        }
        if (mobi.ifunny.social.auth.l.a().h()) {
            a((Comment) localObject, getResources().getString(2131689520));
        }
        for (; ; ) {
            return true;
            G_();
        }
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        paramBundle = getArguments();
        if (paramBundle != null) {
            this.a = paramBundle.getString("ARG_SHOW_COMMENT_ID");
        }
        setHasOptionsMenu(true);
        this.i = new Handler();
        this.k = new v(this, null);
        paramBundle = getActivity();
        if (Features.isHideNewCommentsSmilesTurnedOn()) {
        }
        for (int i1 = Features.getHideNewCommentsSmilesInterval().intValue(); ; i1 = 0) {
            this.c = new mobi.ifunny.comments.views.b(paramBundle, Integer.valueOf(i1));
            this.d = new mobi.ifunny.util.c(getActivity());
            this.h = getResources().getInteger(2131558406);
            return;
        }
    }

    public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo) {
        super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
        if ((paramContextMenuInfo != null) && ((paramContextMenuInfo instanceof AdapterView.AdapterContextMenuInfo))) {
            paramView = (AdapterView.AdapterContextMenuInfo) paramContextMenuInfo;
            int i1 = this.g.b(paramView.position);
            if (i1 >= 0) {
                a(paramContextMenu, (Comment) h().c(i1).a);
            }
        }
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramLayoutInflater = paramLayoutInflater.inflate(2130903095, paramViewGroup, false);
        ButterKnife.inject(this, paramLayoutInflater);
        this.sendCommentView.setEnabled(false);
        return paramLayoutInflater;
    }

    public void onDestroyView() {
        this.writeCommentView.removeTextChangedListener(this.q);
        super.onDestroyView();
    }

    @OnClick({2131493019})
    public void onMyAvatarClicked(View paramView) {
        if (mobi.ifunny.social.auth.l.a().h()) {
            g(mobi.ifunny.social.auth.l.a().d());
            return;
        }
        G_();
    }

    public void onSaveInstanceState(Bundle paramBundle) {
        b();
        super.onSaveInstanceState(paramBundle);
        if (this.j != null) {
            this.l = new ArrayList(h().c());
            this.j.b();
            this.j = null;
        }
        paramBundle.putString("SAVE_COMMENT_INPUT", this.m);
        paramBundle.putString("SAVE_SHOW_ID", this.a);
        paramBundle.putParcelableArrayList("SAVE_UNVERIFIED_COMMENTS", this.b);
        paramBundle.putParcelableArrayList("SAVE_CHECKED_COMMENTS", this.l);
    }

    @OnClick({2131493022})
    public void onSendClick(View paramView) {
        f();
    }

    public void onViewCreated(View paramView, Bundle paramBundle) {
        super.onViewCreated(paramView, paramBundle);
        int i1 = mobi.ifunny.util.a.a(paramView.getRootView()).y;
        this.o = new mobi.ifunny.util.w(getActivity(), this, i1 * 3);
        f(2131689542);
    }

    public void onViewStateRestored(Bundle paramBundle) {
        super.onViewStateRestored(paramBundle);
        if (paramBundle != null) {
            this.m = paramBundle.getString("SAVE_COMMENT_INPUT");
            this.a = paramBundle.getString("SAVE_SHOW_ID");
            this.l = paramBundle.getParcelableArrayList("SAVE_CHECKED_COMMENTS");
        }
        for (this.b = paramBundle.getParcelableArrayList("SAVE_UNVERIFIED_COMMENTS"); ; this.b = new ArrayList()) {
            h().a(this.a);
            v();
            return;
        }
    }

    protected String p() {
        return "rest.getComments";
    }

    protected String q() {
        return "rest.refreshComments";
    }

    protected void r() {
        l().o();
    }

    protected void s() {
        l().p();
    }

    public void t() {
        if (A()) {
            l().b(false);
            this.commentsDim.setVisibility(0);
        }
    }

    public void u() {
        l().b(true);
        this.commentsDim.setVisibility(8);
    }

    protected boolean v() {
        String str = mobi.ifunny.social.auth.l.a().f();
        int i1;
        if ((!TextUtils.equals((String) this.myAvatar.getTag(), str)) || (this.myAvatar.getDrawable() == null)) {
            i1 = 1;
            if (!TextUtils.isEmpty(str)) {
                break label59;
            }
            if (i1 != 0) {
                a(null);
            }
        }
        label59:
        do {
            do {
                return false;
                i1 = 0;
                break;
            } while (i1 == 0);
            if (this.myAvatarBackground.getBackground().getLevel() == 0) {
                this.myAvatarBackground.getBackground().setLevel(mobi.ifunny.util.r.b(1, 6));
            }
        } while (f("TASK_LOAD_AVATAR"));
        return true;
    }

    protected mobi.ifunny.f w() {
        return (mobi.ifunny.f) getActivity();
    }

    protected final void y() {
        android.support.v4.app.g localg = (android.support.v4.app.g) getChildFragmentManager().a("DIALOG_PROGRESS");
        if (localg != null) {
            localg.b();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/comments/CommentsFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */