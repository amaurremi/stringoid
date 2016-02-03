package mobi.ifunny.comments.views;

import butterknife.ButterKnife.Finder;
import mobi.ifunny.view.DotsView;

public class AnswersCommentViews$$ViewInjector {
    public static void inject(ButterKnife.Finder paramFinder, AnswersCommentViews paramAnswersCommentViews, Object paramObject) {
        SmilyCommentViews..ViewInjector.inject(paramFinder, paramAnswersCommentViews, paramObject);
        paramAnswersCommentViews.dotsView = ((DotsView) paramFinder.findRequiredView(paramObject, 2131492996, "field 'dotsView'"));
        paramAnswersCommentViews.dotsLayout = paramFinder.findRequiredView(paramObject, 2131492994, "field 'dotsLayout'");
    }

    public static void reset(AnswersCommentViews paramAnswersCommentViews) {
        SmilyCommentViews..ViewInjector.reset(paramAnswersCommentViews);
        paramAnswersCommentViews.dotsView = null;
        paramAnswersCommentViews.dotsLayout = null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/comments/views/AnswersCommentViews$$ViewInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */