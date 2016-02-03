package mobi.ifunny.comments.views;

import android.widget.TextView;
import butterknife.ButterKnife.Finder;

public class FirstLevelCommentViews$$ViewInjector {
    public static void inject(ButterKnife.Finder paramFinder, FirstLevelCommentViews paramFirstLevelCommentViews, Object paramObject) {
        SmilyCommentViews..ViewInjector.inject(paramFinder, paramFirstLevelCommentViews, paramObject);
        paramFirstLevelCommentViews.repliesTextView = ((TextView) paramFinder.findRequiredView(paramObject, 2131493069, "field 'repliesTextView'"));
    }

    public static void reset(FirstLevelCommentViews paramFirstLevelCommentViews) {
        SmilyCommentViews..ViewInjector.reset(paramFirstLevelCommentViews);
        paramFirstLevelCommentViews.repliesTextView = null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/comments/views/FirstLevelCommentViews$$ViewInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */