package com.quoord.tapatalkpro.ics.ics.blog;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.quoord.tapatalkpro.adapter.forum.BlogAdapter;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.RebrandingConfig;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.ics.BaseListFragment;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tools.TwoPanelController;

public class BlogFragment
        extends BaseListFragment
        implements TwoPanelController {
    private BlogAdapter adapter = null;
    private String avatar = null;
    private ActionBar bar = null;
    private String blog_id = null;
    private String blog_title = null;
    public int finalWidth;
    private ForumStatus forumStatus = null;
    private RelativeLayout layout = null;
    private ListView listView = null;

    public static BlogFragment newInstance(ForumStatus paramForumStatus, String paramString1, String paramString2, String paramString3) {
        BlogFragment localBlogFragment = new BlogFragment();
        localBlogFragment.forumStatus = paramForumStatus;
        localBlogFragment.blog_id = paramString1;
        localBlogFragment.blog_title = paramString2;
        localBlogFragment.avatar = paramString3;
        return localBlogFragment;
    }

    public BaseAdapter getAdapter() {
        return null;
    }

    public String getBlogUrl() {
        if (getActivity().getResources().getBoolean(2131558401)) {
            return this.forumStatus.getRebrandingConfig().getCms_url() + "/?p=" + this.blog_id;
        }
        return this.forumStatus.tapatalkForum.getCms_url() + "/?p=" + this.blog_id;
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        setActionBarStyle();
        paramBundle = this.layout.getViewTreeObserver();
        this.finalWidth = this.layout.getMeasuredWidth();
        if (paramBundle != null) {
            paramBundle.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                public boolean onPreDraw() {
                    BlogFragment.this.finalWidth = BlogFragment.this.layout.getMeasuredWidth();
                    if (BlogFragment.this.adapter == null) {
                        BlogFragment.this.adapter = new BlogAdapter(BlogFragment.this, BlogFragment.this.forumStatus, BlogFragment.this.blog_id, BlogFragment.this.blog_title, BlogFragment.this.avatar, BlogFragment.this.getActivity());
                    }
                    return true;
                }
            });
        }
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramLayoutInflater = paramLayoutInflater.inflate(2130903075, null);
        this.layout = ((RelativeLayout) paramLayoutInflater.findViewById(2131230875));
        this.listView = ((ListView) paramLayoutInflater.findViewById(2131230876));
        return paramLayoutInflater;
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        boolean bool = true;
        switch (paramMenuItem.getItemId()) {
            default:
                bool = super.onOptionsItemSelected(paramMenuItem);
            case 16908332:
                return bool;
            case 46:
                paramMenuItem = new Intent();
                paramMenuItem.setAction("android.intent.action.SEND");
                paramMenuItem.setType("text/plain");
                paramMenuItem.addFlags(1);
                paramMenuItem.putExtra("android.intent.extra.TEXT", getBlogUrl() + "\r\n" + this.blog_title);
                paramMenuItem.putExtra("android.intent.extra.SUBJECT", this.blog_title);
                startActivity(Intent.createChooser(paramMenuItem, "Share"));
                return true;
        }
        paramMenuItem = new Intent("android.intent.action.VIEW", Uri.parse(getBlogUrl()));
        getActivity().startActivity(paramMenuItem);
        return true;
    }

    public void onPrepareOptionsMenu(Menu paramMenu) {
        super.onPrepareOptionsMenu(paramMenu);
        paramMenu.add(0, 46, 0, getString(2131100054));
        paramMenu.add(0, 44, 0, getString(2131099968));
    }

    public void setActionBar(Activity paramActivity) {
    }

    public void setActionBarStyle() {
        this.bar = getActivity().getActionBar();
        this.bar.setDisplayHomeAsUpEnabled(true);
        this.bar.setDisplayShowCustomEnabled(true);
        Object localObject = LayoutInflater.from(getActivity()).inflate(2130903045, null);
        this.bar.setCustomView((View) localObject);
        localObject = (TextView) ((View) localObject).findViewById(2131230767);
        ((TextView) localObject).setText(this.blog_title);
        if (!SettingsFragment.isLightTheme(getActivity())) {
            ((TextView) localObject).setTextColor(getResources().getColor(2131165213));
        }
        this.bar.setNavigationMode(0);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ics/ics/blog/BlogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */