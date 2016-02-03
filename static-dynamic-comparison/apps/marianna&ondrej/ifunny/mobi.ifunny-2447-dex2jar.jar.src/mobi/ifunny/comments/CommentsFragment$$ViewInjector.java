package mobi.ifunny.comments;

import android.view.View;
import android.widget.ImageView;
import butterknife.ButterKnife.Finder;
import mobi.ifunny.gallery.ContentAdapterFragment..ViewInjector;
import mobi.ifunny.view.EditTextEx;

public class CommentsFragment$$ViewInjector {
    public static void inject(ButterKnife.Finder paramFinder, CommentsFragment paramCommentsFragment, Object paramObject) {
        ContentAdapterFragment..ViewInjector.inject(paramFinder, paramCommentsFragment, paramObject);
        paramCommentsFragment.writeCommentView = ((EditTextEx) paramFinder.findRequiredView(paramObject, 2131493021, "field 'writeCommentView'"));
        View localView = paramFinder.findRequiredView(paramObject, 2131493022, "field 'sendCommentView' and method 'onSendClick'");
        paramCommentsFragment.sendCommentView = localView;
        localView.setOnClickListener(new l(paramCommentsFragment));
        paramCommentsFragment.myAvatar = ((ImageView) paramFinder.findRequiredView(paramObject, 2131493020, "field 'myAvatar'"));
        localView = paramFinder.findRequiredView(paramObject, 2131493019, "field 'myAvatarBackground' and method 'onMyAvatarClicked'");
        paramCommentsFragment.myAvatarBackground = localView;
        localView.setOnClickListener(new m(paramCommentsFragment));
        paramCommentsFragment.commentsDim = paramFinder.findRequiredView(paramObject, 2131493014, "field 'commentsDim'");
    }

    public static void reset(CommentsFragment paramCommentsFragment) {
        ContentAdapterFragment..ViewInjector.reset(paramCommentsFragment);
        paramCommentsFragment.writeCommentView = null;
        paramCommentsFragment.sendCommentView = null;
        paramCommentsFragment.myAvatar = null;
        paramCommentsFragment.myAvatarBackground = null;
        paramCommentsFragment.commentsDim = null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/comments/CommentsFragment$$ViewInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */