package com.quoord.tapatalkpro.adapter.forum;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.quoord.tapatalkpro.adapter.CallBackInterface;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.RebrandingConfig;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.ics.ics.blog.Blogs;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.ui.ButtomProgress;
import com.quoord.tapatalkpro.util.JsonRpcEngine;
import com.quoord.tools.tracking.GoogleAnalyticsTools;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BlogsAdapter
        extends BaseAdapter
        implements CallBackInterface {
    private Blogs blogItem = new Blogs();
    private int categoryId = 0;
    private ViewGroup container;
    public int currentScrollState;
    private int currentSelectPosition = -1;
    private LinearLayout footlay = null;
    private ForumStatus forumStatus = null;
    public HashMap<String, Object> hashMap = new HashMap();
    private boolean isCanRefresh = true;
    private boolean isLoadingMore = true;
    private JsonRpcEngine jsonEngine = null;
    private ListView listView = null;
    private SlidingMenuActivity mActivity;
    private ArrayList<Blogs> mData = new ArrayList();
    TextView nodataView;
    private int page = 1;
    private int perpage = 20;
    private String total = null;

    public BlogsAdapter(Activity paramActivity, ForumStatus paramForumStatus, ListView paramListView, TextView paramTextView) {
        this.nodataView = paramTextView;
        this.mActivity = ((SlidingMenuActivity) paramActivity);
        this.listView = paramListView;
        this.forumStatus = paramForumStatus;
        this.jsonEngine = new JsonRpcEngine(this, this.forumStatus, this.mActivity);
        get_Blogs(this.page, 0);
        this.footlay = ButtomProgress.get(this.mActivity);
        setLoadingMoreEnabled(true);
        this.listView.setAdapter(this);
        setOnclick();
        GoogleAnalyticsTools.trackPageView(this.mActivity, "portal", this.forumStatus.getForumId(), this.forumStatus.getUrl());
    }

    public void callBack(EngineResponse paramEngineResponse) {
        Object localObject = paramEngineResponse.getMethod();
        if ((localObject != null) && (((String) localObject).contains("tapatalk=blogs"))) {
            if (paramEngineResponse.isSuccess()) {
                paramEngineResponse = paramEngineResponse.getResponse().toString();
            }
        }
        for (; ; ) {
            try {
                paramEngineResponse = new JSONObject(paramEngineResponse);
                if (paramEngineResponse == null) {
                    return;
                }
                localObject = paramEngineResponse.getJSONObject("result");
                paramEngineResponse = ((JSONObject) localObject).getJSONArray("blogs");
                j = paramEngineResponse.length();
                if (!(((JSONObject) localObject).get("total") instanceof String)) {
                    continue;
                }
                this.total = ((String) ((JSONObject) localObject).get("total"));
            } catch (JSONException paramEngineResponse) {
                int j;
                paramEngineResponse.printStackTrace();
                continue;
                localObject = new Blogs();
                JSONObject localJSONObject1 = paramEngineResponse.getJSONObject(i);
                ((Blogs) localObject).setBlog_id(localJSONObject1.getString("blog_id"));
                ((Blogs) localObject).setPreview_image(localJSONObject1.getString("preview_image"));
                ((Blogs) localObject).setBlog_title(localJSONObject1.getString("title"));
                ((Blogs) localObject).setPassword(localJSONObject1.getString("password"));
                ((Blogs) localObject).setStatus(localJSONObject1.getString("status"));
                ((Blogs) localObject).setPreview(localJSONObject1.getString("preview"));
                ((Blogs) localObject).setTimestamp(localJSONObject1.getString("timestamp"));
                ((Blogs) localObject).setComment_count(localJSONObject1.getString("comment_count"));
                JSONObject localJSONObject2 = localJSONObject1.getJSONObject("author");
                ((Blogs) localObject).setAvatar(localJSONObject2.getString("avatar"));
                ((Blogs) localObject).setUser_id(localJSONObject2.getString("user_id"));
                ((Blogs) localObject).setUser_name(localJSONObject2.getString("name"));
                if (!localJSONObject1.has("category")) {
                    continue;
                }
                localJSONObject1 = localJSONObject1.getJSONArray("category").getJSONObject(0);
                ((Blogs) localObject).setCategory_id(localJSONObject1.getString("cat_id"));
                ((Blogs) localObject).setCategory_name(localJSONObject1.getString("name"));
                ((Blogs) localObject).setCategory_count(localJSONObject1.getString("count"));
                ((Blogs) localObject).setCategory_parent(localJSONObject1.getString("parent"));
                this.mData.add(localObject);
                i += 1;
                continue;
                this.isLoadingMore = false;
                continue;
            }
            if (i >= j) {
                if (j >= this.perpage) {
                    continue;
                }
                this.isLoadingMore = true;
                setLoadingMoreEnabled(false);
                loadmore();
                this.isCanRefresh = true;
                notifyDataSetChanged();
                return;
                this.total = ((Integer) ((JSONObject) localObject).get("total"));
                break label455;
            }
            this.nodataView.setVisibility(0);
            continue;
            label455:
            int i = 0;
        }
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public int getCount() {
        return this.mData.size();
    }

    public Object getItem(int paramInt) {
        return this.mData.get(paramInt);
    }

    public long getItemId(int paramInt) {
        return paramInt;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        View localView = paramView;
        if ((getItem(paramInt) instanceof Blogs)) {
            localView = ((Blogs) getItem(paramInt)).getBlogView(paramInt, paramView, paramViewGroup, this, this.mActivity, this.currentSelectPosition);
        }
        return localView;
    }

    public void get_Blogs(int paramInt1, int paramInt2) {
        String str;
        if (this.mActivity.getResources().getBoolean(2131558401)) {
            if (paramInt2 == 0) {
                str = get_blogsurl(true);
            }
        }
        for (; ; ) {
            this.jsonEngine.call(str);
            this.isLoadingMore = true;
            return;
            str = get_blogsurl(true) + "&category=" + paramInt2;
            continue;
            if (paramInt2 == 0) {
                str = get_blogsurl(false);
            } else {
                str = get_blogsurl(false) + "&category=" + paramInt2;
            }
        }
    }

    public String get_blogsurl(boolean paramBoolean) {
        if (paramBoolean) {
            return this.forumStatus.getRebrandingConfig().getCms_url() + "/index.php?tapatalk=blogs&" + "page=" + this.page + "&perpage=" + this.perpage;
        }
        return this.forumStatus.tapatalkForum.getCms_url() + "/index.php?tapatalk=blogs&" + "page=" + this.page + "&perpage=" + this.perpage;
    }

    public boolean isOpCancel() {
        return false;
    }

    public void loadmore() {
        this.listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {
                if ((paramAnonymousInt1 + paramAnonymousInt2 == paramAnonymousInt3) && (!BlogsAdapter.this.isLoadingMore) && (BlogsAdapter.this.mData.size() < Integer.parseInt(BlogsAdapter.this.total) + 1)) {
                    BlogsAdapter.this.setLoadingMoreEnabled(true);
                    paramAnonymousAbsListView = BlogsAdapter.this;
                    paramAnonymousAbsListView.page += 1;
                    BlogsAdapter.this.get_Blogs(BlogsAdapter.this.page, BlogsAdapter.this.getCategoryId());
                }
            }

            public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {
            }
        });
    }

    public void refresh() {
        if (this.isCanRefresh) {
            this.isCanRefresh = false;
            if (this.nodataView.getVisibility() == 0) {
                this.nodataView.setVisibility(8);
            }
            if (this.mData != null) {
                this.mData.clear();
            }
            this.page = 1;
            setLoadingMoreEnabled(true);
            get_Blogs(this.page, 0);
        }
    }

    public void refresh(int paramInt) {
        if (this.isCanRefresh) {
            this.isCanRefresh = false;
            if (this.nodataView.getVisibility() == 0) {
                this.nodataView.setVisibility(8);
            }
            if (this.mData != null) {
                this.mData.clear();
            }
            this.page = 1;
            setLoadingMoreEnabled(true);
            get_Blogs(this.page, paramInt);
        }
    }

    public void setCategoryId(int paramInt) {
        this.categoryId = paramInt;
    }

    public void setLoadingMoreEnabled(boolean paramBoolean) {
        if ((paramBoolean) && (this.listView.getFooterViewsCount() == 0)) {
            this.listView.addFooterView(this.footlay);
        }
        while ((paramBoolean) || (this.listView.getFooterViewsCount() <= 0)) {
            return;
        }
        this.listView.removeFooterView(this.footlay);
    }

    public void setOnclick() {
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong) {
                if ((BlogsAdapter.this.listView.getFooterViewsCount() > 0) && ((BlogsAdapter.this.mData.size() <= 0) || (paramAnonymousInt >= BlogsAdapter.this.mData.size()))) {
                    return;
                }
                BlogsAdapter.this.currentSelectPosition = paramAnonymousInt;
                if ((BlogsAdapter.this.mData.get(paramAnonymousInt) instanceof Blogs)) {
                    BlogsAdapter.this.blogItem.openBlog(BlogsAdapter.this.mActivity, BlogsAdapter.this.forumStatus, ((Blogs) BlogsAdapter.this.mData.get(paramAnonymousInt)).getBlog_id(), ((Blogs) BlogsAdapter.this.mData.get(paramAnonymousInt)).getBlog_title(), ((Blogs) BlogsAdapter.this.mData.get(paramAnonymousInt)).getPreview_image());
                }
                BlogsAdapter.this.notifyDataSetChanged();
            }
        });
    }

    public void setOpCancel(boolean paramBoolean) {
    }

    public void updateSubclassDialog(int paramInt) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/forum/BlogsAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */