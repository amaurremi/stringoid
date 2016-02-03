package com.quoord.tapatalkpro.adapter.forum;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.quoord.tapatalkpro.adapter.CallBackInterface;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.RebrandingConfig;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.cache.AppCacheManager;
import com.quoord.tapatalkpro.ics.ics.blog.Blog;
import com.quoord.tapatalkpro.ics.ics.blog.BlogFragment;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.ui.ButtomProgress;
import com.quoord.tapatalkpro.util.BBcodeUtil;
import com.quoord.tapatalkpro.util.BBcodeUtil.BBElement;
import com.quoord.tapatalkpro.util.JsonRpcEngine;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tapatalkpro.view.AuthorView;
import com.quoord.tapatalkpro.view.ShortContentView;
import com.quoord.tapatalkpro.view.TimeStampView;
import com.quoord.tapatalkpro.view.TitleTextView;
import com.quoord.tools.ImageTools;
import com.quoord.tools.bitmap.ui.GifImageView;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BlogAdapter
        extends ForumRootAdapter
        implements CallBackInterface {
    public ArrayList<Blog> arrayList = new ArrayList();
    private String avatar = null;
    public Blog blog = new Blog();
    private List<BBcodeUtil.BBElement> blogContent = null;
    private String blogId = null;
    private String blogTitle = null;
    private TextView categoryView = null;
    private ShortContentView comment_shortContent = null;
    private TimeStampView comment_timeStamp = null;
    private GifImageView comment_userIcon = null;
    private TextView comment_userName = null;
    private int comments_count = 0;
    private MessageContentAdapter contentAdapter = null;
    private TextView contentView = null;
    private int currentScrollState;
    private LinearLayout footLay;
    private ForumStatus forumStatus = null;
    private boolean isLoadingMore = true;
    private JsonRpcEngine jsonEngine = null;
    private ListView listView = null;
    private Activity mActivity = null;
    private int maxWidth;
    private LinearLayout messageLayout = null;
    private int page = 1;
    private int perpage = 20;
    public LinearLayout shortContent_layout = null;
    public ImageView showImageView = null;
    public TimeStampView timeStamp = null;
    public TitleTextView title = null;
    private String total = null;
    public AuthorView userName = null;

    public BlogAdapter(BlogFragment paramBlogFragment, ForumStatus paramForumStatus, String paramString1, String paramString2, String paramString3, Activity paramActivity) {
        super(paramActivity, null);
        this.mActivity = paramActivity;
        this.forumStatus = paramForumStatus;
        this.blogId = paramString1;
        this.blogTitle = paramString2;
        this.avatar = paramString3;
        this.maxWidth = paramBlogFragment.finalWidth;
        paramBlogFragment = Typeface.createFromAsset(this.mActivity.getAssets(), "font/Roboto_Condensed.ttf");
        this.contentAdapter = new MessageContentAdapter(this.mActivity, this, this.forumStatus, 16, paramBlogFragment);
        this.listView = ((ListView) this.mActivity.findViewById(2131230876));
        this.footLay = ButtomProgress.get(this.mActivity);
        setLoadingMoreEnabled(true);
        this.listView.setAdapter(this);
        this.jsonEngine = new JsonRpcEngine(this, this.forumStatus, this.mActivity);
        callBlog(this.blogId);
    }

    public void callBack(EngineResponse paramEngineResponse) {
        Object localObject = paramEngineResponse.getMethod();
        if (((String) localObject).contains("tapatalk=blog")) {
            if (!paramEngineResponse.isSuccess()) {
            }
        }
        JSONObject localJSONObject;
        int i;
        while (!((String) localObject).equals("tapatalk=comments")) {
            for (; ; ) {
                try {
                    paramEngineResponse = ((JSONObject) paramEngineResponse.getResponse()).getJSONObject("result");
                    localObject = paramEngineResponse.getJSONObject("blog");
                    this.blog.setNext_id(((JSONObject) localObject).getString("next"));
                    this.blog.setNext_title(((JSONObject) localObject).getString("next_title"));
                    this.blog.setContent(((JSONObject) localObject).getString("content"));
                    this.blog.setPre_title(((JSONObject) localObject).getString("prev_title"));
                    this.blog.setTitle(((JSONObject) localObject).getString("title"));
                    this.blog.setBlog_id(((JSONObject) localObject).getString("blog_id"));
                    this.blog.setComment_account(((JSONObject) localObject).getString("comment_count"));
                    this.blog.setPrev_id(((JSONObject) localObject).getString("prev"));
                    this.blog.setTimestamp(((JSONObject) localObject).getString("timestamp"));
                    localJSONObject = ((JSONObject) localObject).getJSONObject("author");
                    this.blog.setAvatar(localJSONObject.getString("avatar"));
                    this.blog.setUser_id(localJSONObject.getString("user_id"));
                    this.blog.setUser_name(localJSONObject.getString("name"));
                    localObject = ((JSONObject) localObject).getJSONArray("category").getJSONObject(0);
                    this.blog.setCategory_id(((JSONObject) localObject).getString("cat_id"));
                    this.blog.setCategory_name(((JSONObject) localObject).getString("name"));
                    this.blog.setCategory_count(((JSONObject) localObject).getString("count"));
                    this.blog.setCategory_parent(((JSONObject) localObject).getString("parent"));
                    this.arrayList.add(this.blog);
                    if (paramEngineResponse.has("commonts")) {
                        paramEngineResponse = paramEngineResponse.getJSONArray("commonts");
                        this.comments_count = paramEngineResponse.length();
                        i = 0;
                        if (i < paramEngineResponse.length()) {
                            continue;
                        }
                        if (this.comments_count < Integer.parseInt(this.blog.getComment_account())) {
                            this.isLoadingMore = false;
                        }
                    }
                } catch (Exception paramEngineResponse) {
                    paramEngineResponse.printStackTrace();
                    continue;
                }
                loadmore();
                setLoadingMoreEnabled(false);
                notifyDataSetChanged();
                return;
                localObject = new Blog();
                localJSONObject = paramEngineResponse.getJSONObject(i);
                ((Blog) localObject).setComment_id(localJSONObject.getString("comment_id"));
                ((Blog) localObject).setContent(localJSONObject.getString("content"));
                ((Blog) localObject).setTimestamp(localJSONObject.getString("timestamp"));
                localJSONObject = localJSONObject.getJSONObject("author");
                ((Blog) localObject).setAvatar(localJSONObject.getString("avatar"));
                ((Blog) localObject).setUser_id(localJSONObject.getString("user_id"));
                ((Blog) localObject).setUser_name(localJSONObject.getString("name"));
                this.arrayList.add(localObject);
                i += 1;
            }
        }
        paramEngineResponse = (String) paramEngineResponse.getResponse();
        for (; ; ) {
            try {
                paramEngineResponse = new JSONObject(paramEngineResponse).getJSONObject("result");
                this.total = paramEngineResponse.getString("total");
                paramEngineResponse = paramEngineResponse.getJSONArray("commonts");
                i = 0;
                if (i < paramEngineResponse.length()) {
                    break label594;
                }
                this.comments_count += paramEngineResponse.length();
                if (this.comments_count >= Integer.parseInt(this.total)) {
                    break;
                }
                this.isLoadingMore = false;
            } catch (JSONException paramEngineResponse) {
                paramEngineResponse.printStackTrace();
            }
            break;
            label594:
            localObject = new Blog();
            localJSONObject = paramEngineResponse.getJSONObject(i);
            ((Blog) localObject).setComment_id(localJSONObject.getString("comment_id"));
            ((Blog) localObject).setContent(localJSONObject.getString("content"));
            ((Blog) localObject).setTimestamp(localJSONObject.getString("timestamp"));
            localJSONObject = localJSONObject.getJSONObject("author");
            ((Blog) localObject).setAvatar(localJSONObject.getString("avatar"));
            ((Blog) localObject).setUser_id(localJSONObject.getString("user_id"));
            ((Blog) localObject).setUser_name(localJSONObject.getString("name"));
            this.arrayList.add(localObject);
            i += 1;
        }
    }

    public void callBlog(String paramString) {
        if (this.mActivity.getResources().getBoolean(2131558401)) {
        }
        for (paramString = this.forumStatus.getRebrandingConfig().getCms_url() + "/index.php?tapatalk=blog&" + "blog_id=" + paramString + "&perpage=" + this.perpage; ; paramString = this.forumStatus.tapatalkForum.getCms_url() + "/index.php?tapatalk=blog&" + "blog_id=" + paramString + "&perpage=" + this.perpage) {
            this.jsonEngine.call(paramString);
            this.isLoadingMore = true;
            return;
        }
    }

    public void callComments(String paramString, int paramInt) {
        if (this.mActivity.getResources().getBoolean(2131558401)) {
        }
        for (paramString = this.forumStatus.getRebrandingConfig().getCms_url() + "/index.php?tapatalk=comments&" + "blog_id=" + paramString + "&page=" + paramInt + "&perpage=" + this.perpage; ; paramString = this.forumStatus.tapatalkForum.getCms_url() + "/index.php?tapatalk=comments&" + "blog_id=" + paramString + "&page=" + paramInt + "&perpage=" + this.perpage) {
            this.jsonEngine.call(paramString);
            this.isLoadingMore = true;
            return;
        }
    }

    public View getBlogView() {
        RelativeLayout localRelativeLayout = (RelativeLayout) LayoutInflater.from(this.mActivity).inflate(2130903077, null);
        this.userName = ((AuthorView) localRelativeLayout.findViewById(2131230882));
        this.showImageView = ((ImageView) localRelativeLayout.findViewById(2131230878));
        Object localObject;
        if (this.avatar != null) {
            localObject = AppCacheManager.getRemoteImageCacheDir(this.mActivity) + this.avatar.hashCode();
            this.showImageView.setImageBitmap(ImageTools.getBlogBigImage((String) localObject, this.mActivity, this.maxWidth));
        }
        this.title = ((TitleTextView) localRelativeLayout.findViewById(2131230877));
        this.title.setText(this.blogTitle);
        this.shortContent_layout = ((LinearLayout) localRelativeLayout.findViewById(2131230886));
        this.timeStamp = ((TimeStampView) localRelativeLayout.findViewById(2131230884));
        this.shortContent_layout = ((LinearLayout) localRelativeLayout.findViewById(2131230886));
        this.contentView = ((TextView) localRelativeLayout.findViewById(2131230880));
        this.categoryView = ((TextView) localRelativeLayout.findViewById(2131230885));
        this.categoryView.setTextColor(this.mActivity.getResources().getColor(2131165278));
        this.userName.setText(this.blog.getUser_name());
        this.userName.setTextSize(12.0F);
        this.userName.setTextColor(this.mActivity.getResources().getColor(2131165283));
        this.timeStamp.setText(Util.getSmartTime(this.mActivity, Integer.parseInt(this.blog.getTimestamp())));
        this.timeStamp.setTextColor(this.mActivity.getResources().getColor(2131165283));
        this.contentView.setText(this.blog.getComment_account());
        this.contentView.setTextSize(12.0F);
        this.contentView.setTextColor(this.mActivity.getResources().getColor(2131165278));
        this.categoryView.setText("# " + this.blog.getCategory_name());
        this.categoryView.setTextSize(12.0F);
        int i;
        if (this.messageLayout == null) {
            this.messageLayout = new LinearLayout(this.mActivity);
            this.messageLayout.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            this.messageLayout.setOrientation(1);
            this.blogContent = BBcodeUtil.process(this.blog.getContent(), this.forumStatus, true, true, false, 0);
            localObject = this.contentAdapter.getViewFromPost(this.blogContent, this.blog, 0, false);
            i = 0;
        }
        for (; ; ) {
            if (i >= localObject.length) {
                if (this.messageLayout.getParent() == null) {
                    break;
                }
                ((LinearLayout) this.messageLayout.getParent()).removeView(this.messageLayout);
                this.shortContent_layout.addView(this.messageLayout);
                return localRelativeLayout;
            }
            if (localObject[i] != null) {
                this.messageLayout.addView(localObject[i]);
            }
            i += 1;
        }
        this.shortContent_layout.addView(this.messageLayout);
        return localRelativeLayout;
    }

    public View getCommentsView(int paramInt) {
        RelativeLayout localRelativeLayout = (RelativeLayout) LayoutInflater.from(this.mActivity).inflate(2130903111, null);
        this.comment_userIcon = ((GifImageView) localRelativeLayout.findViewById(2131230949));
        this.comment_userName = ((TextView) localRelativeLayout.findViewById(2131230950));
        this.comment_timeStamp = ((TimeStampView) localRelativeLayout.findViewById(2131230951));
        this.comment_shortContent = ((ShortContentView) localRelativeLayout.findViewById(2131230952));
        Util.getUserImage(this.mActivity, this.forumStatus, this.comment_userIcon, ((Blog) this.arrayList.get(paramInt)).getAvatar(), null);
        this.comment_userName.setText(((Blog) this.arrayList.get(paramInt)).getUser_name());
        this.comment_userName.setTextSize(16.0F);
        if (SettingsFragment.getTimeStyle(this.mActivity) == 0) {
            this.comment_timeStamp.setText(Util.getSmartTime(this.mActivity, Integer.parseInt(((Blog) this.arrayList.get(paramInt)).getTimestamp())));
        }
        for (; ; ) {
            this.comment_timeStamp.setTextColor(this.mActivity.getResources().getColor(2131165283));
            this.comment_timeStamp.setTextSize(12.0F);
            this.comment_shortContent.setText(((Blog) this.arrayList.get(paramInt)).getContent());
            this.comment_shortContent.setTextSize(14.0F);
            return localRelativeLayout;
            this.comment_timeStamp.setText(Util.getShortTimeString(this.mActivity, Integer.parseInt(((Blog) this.arrayList.get(paramInt)).getTimestamp())));
        }
    }

    public int getCount() {
        return this.arrayList.size();
    }

    public Object getItem(int paramInt) {
        return this.arrayList.get(paramInt);
    }

    public long getItemId(int paramInt) {
        return paramInt;
    }

    public int getItemViewType(int paramInt) {
        if (paramInt == 0) {
            return 0;
        }
        return 1;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        if (paramInt == 0) {
            return getBlogView();
        }
        return getCommentsView(paramInt);
    }

    public int getViewTypeCount() {
        return 2;
    }

    public boolean isOpCancel() {
        return false;
    }

    public void loadmore() {
        this.listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {
                paramAnonymousInt1 += paramAnonymousInt2;
                if ((paramAnonymousInt1 != 0) && (paramAnonymousInt1 == paramAnonymousInt3) && (!BlogAdapter.this.isLoadingMore)) {
                    BlogAdapter.this.setLoadingMoreEnabled(true);
                    paramAnonymousAbsListView = BlogAdapter.this;
                    paramAnonymousAbsListView.page += 1;
                    BlogAdapter.this.callComments(BlogAdapter.this.blogId, BlogAdapter.this.page);
                }
            }

            public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {
                int j = 0;
                int i = j;
                if (paramAnonymousInt != 2) {
                    i = j;
                    if (BlogAdapter.this.currentScrollState == 2) {
                        i = 1;
                    }
                }
                j = i;
                if (paramAnonymousInt == 0) {
                    j = i;
                    if (BlogAdapter.this.currentScrollState == 1) {
                        j = 1;
                    }
                }
                BlogAdapter.this.currentScrollState = paramAnonymousInt;
                if (j != 0) {
                    BlogAdapter.this.notifyDataSetChanged();
                }
                if (paramAnonymousInt != 2) {
                    BlogAdapter.this.notifyDataSetChanged();
                }
            }
        });
    }

    public void parseCallBack(EngineResponse paramEngineResponse) {
    }

    public void refresh() {
    }

    public void setLoadingMoreEnabled(boolean paramBoolean) {
        if ((paramBoolean) && (this.listView.getFooterViewsCount() == 0)) {
            this.listView.addFooterView(this.footLay);
        }
        while ((paramBoolean) || (this.listView.getFooterViewsCount() <= 0)) {
            return;
        }
        this.listView.removeFooterView(this.footLay);
    }

    public void setOpCancel(boolean paramBoolean) {
    }

    public void updateSubclassDialog(int paramInt) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/forum/BlogAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */