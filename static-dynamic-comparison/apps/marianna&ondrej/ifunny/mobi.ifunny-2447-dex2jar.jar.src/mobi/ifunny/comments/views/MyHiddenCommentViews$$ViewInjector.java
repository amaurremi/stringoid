package mobi.ifunny.comments.views;

import android.widget.TextView;
import butterknife.ButterKnife.Finder;

public class MyHiddenCommentViews$$ViewInjector {
    public static void inject(ButterKnife.Finder paramFinder, MyHiddenCommentViews paramMyHiddenCommentViews, Object paramObject) {
        MyCommentViews..ViewInjector.inject(paramFinder, paramMyHiddenCommentViews, paramObject);
        paramMyHiddenCommentViews.reasonView = ((TextView) paramFinder.findRequiredView(paramObject, 2131493144, "field 'reasonView'"));
        paramMyHiddenCommentViews.hideReasonLayout = paramFinder.findRequiredView(paramObject, 2131493143, "field 'hideReasonLayout'");
    }

    public static void reset(MyHiddenCommentViews paramMyHiddenCommentViews) {
        MyCommentViews..ViewInjector.reset(paramMyHiddenCommentViews);
        paramMyHiddenCommentViews.reasonView = null;
        paramMyHiddenCommentViews.hideReasonLayout = null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/comments/views/MyHiddenCommentViews$$ViewInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */