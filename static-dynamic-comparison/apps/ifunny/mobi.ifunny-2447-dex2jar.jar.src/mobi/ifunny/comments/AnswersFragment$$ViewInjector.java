package mobi.ifunny.comments;

import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;

public class AnswersFragment$$ViewInjector {
    public static void inject(ButterKnife.Finder paramFinder, AnswersFragment paramAnswersFragment, Object paramObject) {
        CommentsFragment..ViewInjector.inject(paramFinder, paramAnswersFragment, paramObject);
        View localView = paramFinder.findRequiredView(paramObject, 2131493015, "field 'replyToLayout' and method 'onReplyToCloseClick'");
        paramAnswersFragment.replyToLayout = localView;
        localView.setOnClickListener(new d(paramAnswersFragment));
        paramAnswersFragment.replyToNick = ((TextView) paramFinder.findRequiredView(paramObject, 2131493016, "field 'replyToNick'"));
    }

    public static void reset(AnswersFragment paramAnswersFragment) {
        CommentsFragment..ViewInjector.reset(paramAnswersFragment);
        paramAnswersFragment.replyToLayout = null;
        paramAnswersFragment.replyToNick = null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/comments/AnswersFragment$$ViewInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */