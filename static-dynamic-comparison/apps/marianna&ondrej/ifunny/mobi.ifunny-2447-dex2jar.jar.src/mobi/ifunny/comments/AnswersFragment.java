package mobi.ifunny.comments;

import android.os.Bundle;
import android.support.v4.app.k;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import mobi.ifunny.comments.views.b;
import mobi.ifunny.gallery.ContentAdapterFragment;
import mobi.ifunny.gallery.h;
import mobi.ifunny.rest.content.Comment;
import mobi.ifunny.rest.content.CommentsFeed;
import mobi.ifunny.rest.content.Counters;
import mobi.ifunny.rest.content.IFunny;
import mobi.ifunny.rest.content.RepliesFeed;
import mobi.ifunny.rest.content.User;
import mobi.ifunny.rest.retrofit.IFunnyRestRequest.Comments;
import mobi.ifunny.rest.retrofit.RestHttpHandler;
import mobi.ifunny.rest.retrofit.SimpleRestHttpHandler;
import mobi.ifunny.social.auth.l;
import mobi.ifunny.util.r;
import mobi.ifunny.view.EditTextEx;

public class AnswersFragment
        extends CommentsFragment<Comment, RepliesFeed> {
    private Comment h;
    private Comment i;
    @InjectView(2131493015)
    View replyToLayout;
    @InjectView(2131493016)
    TextView replyToNick;

    private boolean Q() {
        boolean bool2 = false;
        boolean bool1 = bool2;
        if (!c().isEmpty()) {
            bool1 = bool2;
            if (c().c(0).b == 2) {
                bool1 = true;
            }
        }
        return bool1;
    }

    public static AnswersFragment a(String paramString, Comment paramComment1, Comment paramComment2) {
        AnswersFragment localAnswersFragment = new AnswersFragment();
        paramString = CommentsFragment.c(paramString);
        paramString.putParcelable("ARG_COMMENT", paramComment1);
        paramString.putParcelable("ARG_REPLY_TO", paramComment2);
        localAnswersFragment.setArguments(paramString);
        return localAnswersFragment;
    }

    private void h(Comment paramComment) {
        this.i = paramComment;
        if ((paramComment != null) && (paramComment.equals(this.h))) {
            this.replyToLayout.setVisibility(8);
            return;
        }
        if (paramComment == null) {
            this.replyToLayout.setVisibility(8);
            this.writeCommentView.setText(null);
            ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.writeCommentView.getWindowToken(), 0);
            return;
        }
        this.replyToLayout.setVisibility(0);
        this.replyToNick.setText(paramComment.user.nick);
    }

    protected String a(int paramInt) {
        return r.b(getResources(), 2131623937, 2131689524, paramInt);
    }

    protected void a(int paramInt, RepliesFeed paramRepliesFeed) {
        super.a(paramInt, paramRepliesFeed);
        if (paramInt == 0) {
            if ((!paramRepliesFeed.hasPrev()) && (!Q())) {
                c().a(this.h);
            }
            d();
        }
        for (; ; ) {
            D();
            return;
            if ((paramInt == -1) && (!paramRepliesFeed.hasPrev()) && (!Q())) {
                c().a(this.h);
            }
        }
    }

    protected void a(ContextMenu paramContextMenu, Comment paramComment) {
        super.a(paramContextMenu, paramComment);
        if ((paramComment != null) && (paramComment.depth >= this.c.h)) {
            paramContextMenu = paramContextMenu.findItem(2131493383);
            if (paramContextMenu != null) {
                paramContextMenu.setVisible(false);
            }
        }
    }

    protected <F extends CommentsFeed<Comment>, K extends CommentsFragment<Comment, F>> void a(String paramString1, String paramString2, Comment paramComment, SimpleRestHttpHandler<Comment, K> paramSimpleRestHttpHandler) {
        IFunnyRestRequest.Comments.addReplyToComment(this, paramString1, paramString2, paramComment.parent_comm_id, paramComment.text, paramSimpleRestHttpHandler);
    }

    protected void a(List<Comment> paramList) {
        Object localObject = new LinkedList();
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext()) {
            Comment localComment = (Comment) localIterator.next();
            localComment.setState("deleted_self");
            ((LinkedList) localObject).add(Integer.valueOf(a(((RepliesFeed) B()).getList(), localComment.id)));
        }
        c().a(paramList, (List) localObject);
        localObject = m().num;
        ((Counters) localObject).comments -= paramList.size();
        localObject = this.h;
        ((Comment) localObject).num_replies -= paramList.size();
    }

    protected void a(Comment paramComment) {
        if (TextUtils.equals(paramComment.id, this.h.id)) {
            F_();
            return;
        }
        paramComment.setState("deleted_self");
        Object localObject = m().num;
        ((Counters) localObject).comments -= 1;
        localObject = this.h;
        ((Comment) localObject).num_replies -= 1;
        ((RepliesFeed) B()).setExhibitCommentsCount(((RepliesFeed) B()).getExhibitCommentsCount() - 1);
        localObject = paramComment.id;
        int j = a(((RepliesFeed) B()).getList(), (String) localObject);
        if (j >= 0) {
            c().a(j, paramComment);
        }
        b(((RepliesFeed) B()).getExhibitCommentsCount());
    }

    protected void a(Comment paramComment, String paramString, int paramInt) {
        if (!TextUtils.equals(paramComment.id, this.h.id)) {
            paramComment.setState(paramString);
            paramComment = m().num;
            paramComment.comments += 1;
            paramComment = this.h;
            paramComment.num_replies += 1;
            ((RepliesFeed) B()).setExhibitCommentsCount(((RepliesFeed) B()).getExhibitCommentsCount() + 1);
            paramComment = this.h.id;
            paramInt = a(((RepliesFeed) B()).getList(), paramComment);
            if (paramInt >= 0) {
                c().a(paramInt, this.h);
            }
            b(((RepliesFeed) B()).getExhibitCommentsCount());
        }
    }

    protected <K extends CommentsFragment<Comment, RepliesFeed>> void a(Comment paramComment, String paramString, RestHttpHandler<Void, K> paramRestHttpHandler) {
        IFunnyRestRequest.Comments.deleteComment(this, paramString, m().id, paramComment.id, paramRestHttpHandler);
    }

    protected void a(RepliesFeed paramRepliesFeed) {
        super.a(paramRepliesFeed);
        if ((!paramRepliesFeed.hasPrev()) && (!Q())) {
            c().a(this.h);
        }
        D();
    }

    protected void a(boolean paramBoolean) {
        super.a(paramBoolean);
        if ((paramBoolean) && (B() != null) && (C() != 0)) {
            d();
        }
    }

    protected boolean a(String paramString) {
        boolean bool2 = super.a(paramString);
        boolean bool1 = bool2;
        if (!bool2) {
            bool1 = bool2;
            if (TextUtils.equals(paramString, "root_comment_was_deleted")) {
                Toast.makeText(getActivity(), 2131689538, 0).show();
                l().a(m(), g());
                bool1 = true;
            }
        }
        return bool1;
    }

    protected <K extends ContentAdapterFragment<Comment, RepliesFeed>> boolean a(String paramString1, String paramString2, String paramString3, RestHttpHandler<RepliesFeed, K> paramRestHttpHandler) {
        IFunnyRestRequest.Comments.getReplies(this, paramString3, this.h.cid, this.h.id, o(), this.a, paramString1, paramString2, paramRestHttpHandler);
        return true;
    }

    protected AnswersAdapter b() {
        return new AnswersAdapter(this.g, this, this.c, this.h);
    }

    protected Comment b(String paramString) {
        Object localObject = l.a();
        User localUser = User.createForNewComment(((l) localObject).d(), ((l) localObject).e(), ((l) localObject).f());
        localObject = new Comment();
        ((Comment) localObject).setState("normal");
        ((Comment) localObject).cid = m().id;
        ((Comment) localObject).text = paramString;
        ((Comment) localObject).date = (System.currentTimeMillis() / 1000L);
        ((Comment) localObject).user = localUser;
        if (this.i != null) {
            paramString = this.i.id;
            ((Comment) localObject).parent_comm_id = paramString;
            ((Comment) localObject).root_comm_id = this.h.id;
            if (this.i == null) {
                break label135;
            }
        }
        label135:
        for (int j = this.i.depth + 1; ; j = 1) {
            ((Comment) localObject).depth = j;
            return (Comment) localObject;
            paramString = this.h.id;
            break;
        }
    }

    protected void b(Comment paramComment) {
        super.b(paramComment);
        if (TextUtils.equals(paramComment.id, this.h.id)) {
            Counters localCounters = m().num;
            localCounters.comments -= this.h.num_replies + 1;
            paramComment.setState("deleted");
            f().a(paramComment);
        }
    }

    protected AnswersAdapter c() {
        return (AnswersAdapter) super.h();
    }

    protected void c(Comment paramComment) {
        if (TextUtils.equals(paramComment.id, this.h.id)) {
            y();
        }
    }

    protected void d() {
        f(this.i);
    }

    protected void d(Comment paramComment) {
        super.d(paramComment);
        paramComment = this.h;
        paramComment.num_replies += 1;
        h(null);
    }

    protected int e(Comment paramComment) {
        if (TextUtils.equals(this.h.id, paramComment.parent_comm_id)) {
            if (Q()) {
                return 1;
            }
            return 0;
        }
        return a(((RepliesFeed) B()).getList(), paramComment.parent_comm_id) + 1;
    }

    public void e() {
        super.e();
        h(null);
    }

    protected AnswersActivity f() {
        return (AnswersActivity) getActivity();
    }

    protected void f(Comment paramComment) {
        h(paramComment);
        if (paramComment != null) {
            this.writeCommentView.requestFocus();
            this.writeCommentView.postDelayed(new e(this), 100L);
        }
    }

    public Comment g() {
        return this.h;
    }

    protected boolean g(Comment paramComment) {
        return !TextUtils.equals(paramComment.id, this.h.id);
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        paramBundle = getArguments();
        if (paramBundle != null) {
            this.h = ((Comment) paramBundle.getParcelable("ARG_COMMENT"));
            this.i = ((Comment) paramBundle.getParcelable("ARG_REPLY_TO"));
        }
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramLayoutInflater = paramLayoutInflater.inflate(2130903068, paramViewGroup, false);
        ButterKnife.inject(this, paramLayoutInflater);
        this.sendCommentView.setEnabled(false);
        return paramLayoutInflater;
    }

    @OnClick({2131493015})
    protected void onReplyToCloseClick(View paramView) {
        h(null);
    }

    public void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        paramBundle.putParcelable("STATE_REPLY_TO", this.i);
        paramBundle.putParcelable("STATE_COMMENT", this.h);
    }

    public void onViewStateRestored(Bundle paramBundle) {
        super.onViewStateRestored(paramBundle);
        if (paramBundle != null) {
            this.i = ((Comment) paramBundle.getParcelable("STATE_REPLY_TO"));
            this.h = ((Comment) paramBundle.getParcelable("STATE_COMMENT"));
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/comments/AnswersFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */