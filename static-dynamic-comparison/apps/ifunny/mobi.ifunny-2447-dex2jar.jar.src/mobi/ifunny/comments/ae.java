package mobi.ifunny.comments;

import android.content.Intent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import mobi.ifunny.comments.views.SmilyCommentViews;
import mobi.ifunny.comments.views.c;
import mobi.ifunny.gallery.ContentAdapterFragment;
import mobi.ifunny.gallery.g;
import mobi.ifunny.rest.content.Comment;
import mobi.ifunny.rest.content.CommentsFeed;
import mobi.ifunny.rest.content.CommentsFeedImpl;
import mobi.ifunny.rest.content.Counters;
import mobi.ifunny.rest.content.IFunny;
import mobi.ifunny.rest.content.User;
import mobi.ifunny.rest.retrofit.IFunnyRestRequest.Comments;
import mobi.ifunny.rest.retrofit.IFunnyRestRequest.Content;
import mobi.ifunny.rest.retrofit.RestHttpHandler;
import mobi.ifunny.rest.retrofit.SimpleRestHttpHandler;
import mobi.ifunny.social.auth.l;

public class ae
        extends CommentsFragment<Comment, CommentsFeedImpl>
        implements c {
    public static ae d(String paramString) {
        ae localae = new ae();
        localae.setArguments(CommentsFragment.c(paramString));
        return localae;
    }

    protected void a(int paramInt1, int paramInt2, Intent paramIntent) {
        if (paramInt1 == 100) {
            if (paramInt2 != -1) {
                break label204;
            }
            localComment = (Comment) paramIntent.getParcelableExtra("EXTRA_COMMENT");
            if (localComment != null) {
                if (!localComment.isDeleted()) {
                    break label111;
                }
                a(localComment);
                b(localComment);
            }
            paramIntent = (IFunny) paramIntent.getParcelableExtra("EXTRA_CONTENT");
            if ((paramIntent != null) && (paramIntent.num != null)) {
                m().num = paramIntent.num;
                ((CommentsFeedImpl) B()).content.comments_count = paramIntent.num.comments;
                b(paramIntent.num.comments);
            }
        }
        label111:
        label204:
        while (paramInt2 != 100) {
            for (; ; ) {
                Comment localComment;
                return;
                paramInt1 = a(((CommentsFeedImpl) B()).getList(), localComment.id);
                if (paramInt1 >= 0) {
                    h().a(paramInt1, localComment);
                    Object localObject = b(((CommentsFeedImpl) B()).getList(), localComment.id);
                    if (localObject != null) {
                        localObject = (SmilyCommentViews) ((View) localObject).getTag();
                        ((SmilyCommentViews) localObject).b = localComment;
                        ((SmilyCommentViews) localObject).a(getActivity(), this.c);
                    }
                }
            }
        }
        l().a(m());
    }

    protected void a(int paramInt, CommentsFeedImpl paramCommentsFeedImpl) {
        super.a(paramInt, paramCommentsFeedImpl);
        if (paramInt == 0) {
            m().num.comments = paramCommentsFeedImpl.getExhibitCommentsCount();
        }
        do {
            return;
            if (paramInt == 1) {
                m().num.comments = ((CommentsFeedImpl) B()).getExhibitCommentsCount();
                return;
            }
        } while (paramInt != -1);
        m().num.comments = ((CommentsFeedImpl) B()).getExhibitCommentsCount();
    }

    protected <F extends CommentsFeed<Comment>, K extends CommentsFragment<Comment, F>> void a(String paramString1, String paramString2, Comment paramComment, SimpleRestHttpHandler<Comment, K> paramSimpleRestHttpHandler) {
        IFunnyRestRequest.Content.addComment(this, paramString1, m().id, paramComment.text, paramSimpleRestHttpHandler);
    }

    protected void a(List<Comment> paramList) {
        Counters localCounters = m().num;
        localCounters.comments -= paramList.size();
        h().b(paramList);
        this.b.removeAll(paramList);
    }

    protected void a(Comment paramComment) {
        super.a(paramComment);
        Counters localCounters = m().num;
        localCounters.comments -= paramComment.num_replies;
    }

    protected void a(Comment paramComment, String paramString, int paramInt) {
        super.a(paramComment, paramString, paramInt);
        paramString = m().num;
        paramString.comments += paramComment.num_replies;
    }

    protected <K extends CommentsFragment<Comment, CommentsFeedImpl>> void a(Comment paramComment, String paramString, RestHttpHandler<Void, K> paramRestHttpHandler) {
        IFunnyRestRequest.Comments.deleteComment(this, paramString, m().id, paramComment.id, paramRestHttpHandler);
    }

    protected <K extends ContentAdapterFragment<Comment, CommentsFeedImpl>> boolean a(String paramString1, String paramString2, String paramString3, RestHttpHandler<CommentsFeedImpl, K> paramRestHttpHandler) {
        IFunnyRestRequest.Content.getComments(this, paramString3, m().id, o(), this.a, paramString1, paramString2, paramRestHttpHandler);
        return true;
    }

    protected Comment b(String paramString) {
        Object localObject = l.a();
        localObject = User.createForNewComment(((l) localObject).d(), ((l) localObject).e(), ((l) localObject).f());
        Comment localComment = new Comment();
        localComment.setState("normal");
        localComment.cid = m().id;
        localComment.text = paramString;
        localComment.date = (System.currentTimeMillis() / 1000L);
        localComment.user = ((User) localObject);
        return localComment;
    }

    protected void f(Comment paramComment) {
        Intent localIntent = new Intent(getActivity(), AnswersActivity.class);
        localIntent.putExtra("EXTRA_CONTENT", m());
        localIntent.putExtra("EXTRA_COMMENT", paramComment);
        localIntent.putExtra("EXTRA_REPLY_TO", paramComment);
        a(localIntent, 100);
    }

    public void g(Comment paramComment, View paramView) {
        paramView = new Intent(getActivity(), AnswersActivity.class);
        paramView.putExtra("EXTRA_CONTENT", m());
        paramView.putExtra("EXTRA_COMMENT", paramComment);
        a(paramView, 100);
    }

    protected g<Comment, CommentsFeedImpl> j() {
        return new ag(this.g, this, this.c, null);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/comments/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */