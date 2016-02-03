package com.uservoice.uservoicesdk.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.util.TypedValue;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import com.uservoice.uservoicesdk.R.drawable;
import com.uservoice.uservoicesdk.R.id;
import com.uservoice.uservoicesdk.Session;
import com.uservoice.uservoicesdk.activity.TopicActivity;
import com.uservoice.uservoicesdk.dialog.ArticleDialogFragment;
import com.uservoice.uservoicesdk.dialog.SuggestionDialogFragment;
import com.uservoice.uservoicesdk.model.Article;
import com.uservoice.uservoicesdk.model.BaseModel;
import com.uservoice.uservoicesdk.model.Suggestion;
import com.uservoice.uservoicesdk.model.Topic;

import java.util.Locale;

public class Utils {
    @SuppressLint({"SetJavaScriptEnabled"})
    public static void displayArticle(WebView paramWebView, Article paramArticle, Context paramContext) {
        String str = "iframe, img { width: 100%; }";
        if (isDarkTheme(paramContext)) {
            paramWebView.setBackgroundColor(-16777216);
            str = "iframe, img { width: 100%; }" + "body { background-color: #000000; color: #F6F6F6; } a { color: #0099FF; }";
        }
        paramArticle = String.format("<html><head><meta charset=\"utf-8\"><link rel=\"stylesheet\" type=\"text/css\" href=\"http://cdn.uservoice.com/stylesheets/vendor/typeset.css\"/><style>%s</style></head><body class=\"typeset\" style=\"font-family: sans-serif; margin: 1em\"><h3>%s</h3>%s</body></html>", new Object[]{str, paramArticle.getTitle(), paramArticle.getHtml()});
        paramWebView.setWebChromeClient(new WebChromeClient());
        paramWebView.getSettings().setJavaScriptEnabled(true);
        paramWebView.getSettings().setPluginState(WebSettings.PluginState.ON);
        paramWebView.loadUrl(String.format("data:text/html;charset=utf-8,%s", new Object[]{Uri.encode(paramArticle)}));
    }

    public static void displayInstantAnswer(View paramView, BaseModel paramBaseModel) {
        TextView localTextView1 = (TextView) paramView.findViewById(R.id.uv_title);
        TextView localTextView2 = (TextView) paramView.findViewById(R.id.uv_detail);
        View localView = paramView.findViewById(R.id.uv_suggestion_details);
        paramView = (ImageView) paramView.findViewById(R.id.uv_icon);
        if ((paramBaseModel instanceof Article)) {
            paramBaseModel = (Article) paramBaseModel;
            paramView.setImageResource(R.drawable.uv_article);
            localTextView1.setText(paramBaseModel.getTitle());
            if (paramBaseModel.getTopicName() != null) {
                localTextView2.setVisibility(0);
                localTextView2.setText(paramBaseModel.getTopicName());
                localView.setVisibility(8);
            }
        }
        while (!(paramBaseModel instanceof Suggestion)) {
            for (; ; ) {
                return;
                localTextView2.setVisibility(8);
            }
        }
        paramBaseModel = (Suggestion) paramBaseModel;
        paramView.setImageResource(R.drawable.uv_idea);
        localTextView1.setText(paramBaseModel.getTitle());
        localTextView2.setVisibility(0);
        localTextView2.setText(paramBaseModel.getForumName());
        if (paramBaseModel.getStatus() != null) {
            paramView = localView.findViewById(R.id.uv_suggestion_status_color);
            localTextView1 = (TextView) localView.findViewById(R.id.uv_suggestion_status);
            int i = Color.parseColor(paramBaseModel.getStatusColor());
            localView.setVisibility(0);
            localTextView1.setText(paramBaseModel.getStatus().toUpperCase(Locale.getDefault()));
            localTextView1.setTextColor(i);
            paramView.setBackgroundColor(i);
            return;
        }
        localView.setVisibility(8);
    }

    @SuppressLint({"DefaultLocale"})
    public static String getQuantityString(View paramView, int paramInt1, int paramInt2) {
        return String.format("%,d %s", new Object[]{Integer.valueOf(paramInt2), paramView.getContext().getResources().getQuantityString(paramInt1, paramInt2)});
    }

    public static boolean isDarkTheme(Context paramContext) {
        TypedValue localTypedValue = new TypedValue();
        float[] arrayOfFloat = new float[3];
        paramContext.getTheme().resolveAttribute(16842806, localTypedValue, true);
        Color.colorToHSV(paramContext.getResources().getColor(localTypedValue.resourceId), arrayOfFloat);
        return arrayOfFloat[2] > 0.5F;
    }

    public static void showModel(FragmentActivity paramFragmentActivity, BaseModel paramBaseModel) {
        showModel(paramFragmentActivity, paramBaseModel, null);
    }

    public static void showModel(FragmentActivity paramFragmentActivity, BaseModel paramBaseModel, String paramString) {
        if ((paramBaseModel instanceof Article)) {
            new ArticleDialogFragment((Article) paramBaseModel, paramString).show(paramFragmentActivity.getSupportFragmentManager(), "ArticleDialogFragment");
        }
        do {
            return;
            if ((paramBaseModel instanceof Suggestion)) {
                new SuggestionDialogFragment((Suggestion) paramBaseModel, paramString).show(paramFragmentActivity.getSupportFragmentManager(), "SuggestionDialogFragment");
                return;
            }
        } while (!(paramBaseModel instanceof Topic));
        Session.getInstance().setTopic((Topic) paramBaseModel);
        paramFragmentActivity.startActivity(new Intent(paramFragmentActivity, TopicActivity.class));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/uservoice/uservoicesdk/ui/Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */