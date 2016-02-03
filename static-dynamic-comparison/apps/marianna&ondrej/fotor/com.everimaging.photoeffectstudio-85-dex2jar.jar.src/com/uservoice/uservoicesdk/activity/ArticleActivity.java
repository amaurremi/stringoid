package com.uservoice.uservoicesdk.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.uservoice.uservoicesdk.R.id;
import com.uservoice.uservoicesdk.R.layout;
import com.uservoice.uservoicesdk.R.menu;
import com.uservoice.uservoicesdk.R.string;
import com.uservoice.uservoicesdk.Session;
import com.uservoice.uservoicesdk.babayaga.Babayaga;
import com.uservoice.uservoicesdk.babayaga.Babayaga.Event;
import com.uservoice.uservoicesdk.dialog.UnhelpfulDialogFragment;
import com.uservoice.uservoicesdk.model.Article;
import com.uservoice.uservoicesdk.ui.Utils;

public class ArticleActivity
        extends BaseActivity
        implements SearchActivity {
    public void finish() {
        ((WebView) findViewById(R.id.uv_webview)).loadData("", "text/html", "utf-8");
        super.finish();
    }

    protected void onCreate(final Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.uv_article_layout);
        paramBundle = Session.getInstance().getArticle();
        setTitle(paramBundle.getTitle());
        WebView localWebView = (WebView) findViewById(R.id.uv_webview);
        Utils.displayArticle(localWebView, paramBundle, this);
        View localView = findViewById(R.id.uv_container);
        if (Utils.isDarkTheme(this)) {
        }
        for (int i = -16777216; ; i = -1) {
            localView.setBackgroundColor(i);
            localWebView.setWebViewClient(new WebViewClient() {
                public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString) {
                    super.onPageFinished(paramAnonymousWebView, paramAnonymousString);
                    ArticleActivity.this.findViewById(R.id.uv_helpful_section).setVisibility(0);
                }
            });
            findViewById(R.id.uv_helpful_button).setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramAnonymousView) {
                    Babayaga.track(Babayaga.Event.VOTE_ARTICLE, paramBundle.getId());
                    Toast.makeText(ArticleActivity.this, R.string.uv_thanks, 0).show();
                }
            });
            findViewById(R.id.uv_unhelpful_button).setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramAnonymousView) {
                    new UnhelpfulDialogFragment().show(ArticleActivity.this.getSupportFragmentManager(), "UnhelpfulDialogFragment");
                }
            });
            Babayaga.track(Babayaga.Event.VIEW_ARTICLE, paramBundle.getId());
            return;
        }
    }

    @SuppressLint({"NewApi"})
    public boolean onCreateOptionsMenu(Menu paramMenu) {
        getMenuInflater().inflate(R.menu.uv_portal, paramMenu);
        setupScopedSearch(paramMenu);
        return true;
    }

    public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem) {
        if (paramMenuItem.getItemId() == R.id.uv_action_contact) {
            startActivity(new Intent(this, ContactActivity.class));
            return true;
        }
        return super.onMenuItemSelected(paramInt, paramMenuItem);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/uservoice/uservoicesdk/activity/ArticleActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */