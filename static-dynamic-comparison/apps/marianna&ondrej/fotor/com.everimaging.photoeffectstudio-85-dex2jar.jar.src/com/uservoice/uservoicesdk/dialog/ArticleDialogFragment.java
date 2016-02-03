package com.uservoice.uservoicesdk.dialog;

import android.annotation.SuppressLint;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.webkit.WebView;
import com.uservoice.uservoicesdk.R.string;
import com.uservoice.uservoicesdk.activity.InstantAnswersActivity;
import com.uservoice.uservoicesdk.babayaga.Babayaga;
import com.uservoice.uservoicesdk.babayaga.Babayaga.Event;
import com.uservoice.uservoicesdk.deflection.Deflection;
import com.uservoice.uservoicesdk.model.Article;
import com.uservoice.uservoicesdk.ui.InstantAnswersAdapter;
import com.uservoice.uservoicesdk.ui.Utils;

@SuppressLint({"ValidFragment", "NewApi"})
public class ArticleDialogFragment
        extends DialogFragmentBugfixed {
    private final Article article;
    private String deflectingType;
    private WebView webView;

    public ArticleDialogFragment(Article paramArticle, String paramString) {
        this.article = paramArticle;
        this.deflectingType = paramString;
    }

    public Dialog onCreateDialog(Bundle paramBundle) {
        paramBundle = new AlertDialog.Builder(getActivity());
        paramBundle.setTitle(R.string.uv_article_instant_answer_question);
        this.webView = new WebView(getActivity());
        if (!Utils.isDarkTheme(getActivity())) {
            paramBundle.setInverseBackgroundForced(true);
        }
        paramBundle.setView(this.webView);
        Utils.displayArticle(this.webView, this.article, getActivity());
        paramBundle.setNegativeButton(R.string.uv_no, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                if ((ArticleDialogFragment.this.getActivity() instanceof InstantAnswersActivity)) {
                    Deflection.trackDeflection("unhelpful", ArticleDialogFragment.this.deflectingType, ArticleDialogFragment.this.article);
                    ((InstantAnswersAdapter) ((InstantAnswersActivity) ArticleDialogFragment.this.getActivity()).getListAdapter()).notHelpful();
                    return;
                }
                new UnhelpfulDialogFragment().show(ArticleDialogFragment.this.getActivity().getSupportFragmentManager(), "UnhelpfulDialogFragment");
            }
        });
        paramBundle.setPositiveButton(R.string.uv_very_yes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                Babayaga.track(Babayaga.Event.VOTE_ARTICLE, ArticleDialogFragment.this.article.getId());
                if ((ArticleDialogFragment.this.getActivity() instanceof InstantAnswersActivity)) {
                    Deflection.trackDeflection("helpful", ArticleDialogFragment.this.deflectingType, ArticleDialogFragment.this.article);
                    new HelpfulDialogFragment().show(ArticleDialogFragment.this.getActivity().getSupportFragmentManager(), "HelpfulDialogFragment");
                }
            }
        });
        Babayaga.track(Babayaga.Event.VIEW_ARTICLE, this.article.getId());
        return paramBundle.create();
    }

    public void onDismiss(DialogInterface paramDialogInterface) {
        this.webView.onPause();
        this.webView.loadUrl("about:blank");
        super.onDismiss(paramDialogInterface);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/uservoice/uservoicesdk/dialog/ArticleDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */