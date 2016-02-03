package mobi.ifunny.comments.views;

import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import mobi.ifunny.view.ImageViewEx;

public class CommentViews$$ViewInjector {
    public static void inject(ButterKnife.Finder paramFinder, CommentViews paramCommentViews, Object paramObject) {
        paramCommentViews.commentLayout = paramFinder.findRequiredView(paramObject, 2131492993, "field 'commentLayout'");
        paramCommentViews.titleLayout = paramFinder.findRequiredView(paramObject, 2131493000, "field 'titleLayout'");
        paramCommentViews.imageViewLayout = paramFinder.findRequiredView(paramObject, 2131492997, "field 'imageViewLayout'");
        paramCommentViews.imageViewBackground = paramFinder.findRequiredView(paramObject, 2131492998, "field 'imageViewBackground'");
        paramCommentViews.imageView = ((ImageViewEx) paramFinder.findRequiredView(paramObject, 2131492999, "field 'imageView'"));
        paramCommentViews.nicknameTextView = ((TextView) paramFinder.findRequiredView(paramObject, 2131493001, "field 'nicknameTextView'"));
        paramCommentViews.dateTextView = ((TextView) paramFinder.findRequiredView(paramObject, 2131493002, "field 'dateTextView'"));
        paramCommentViews.commentTextView = ((TextView) paramFinder.findRequiredView(paramObject, 2131493007, "field 'commentTextView'"));
    }

    public static void reset(CommentViews paramCommentViews) {
        paramCommentViews.commentLayout = null;
        paramCommentViews.titleLayout = null;
        paramCommentViews.imageViewLayout = null;
        paramCommentViews.imageViewBackground = null;
        paramCommentViews.imageView = null;
        paramCommentViews.nicknameTextView = null;
        paramCommentViews.dateTextView = null;
        paramCommentViews.commentTextView = null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/comments/views/CommentViews$$ViewInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */