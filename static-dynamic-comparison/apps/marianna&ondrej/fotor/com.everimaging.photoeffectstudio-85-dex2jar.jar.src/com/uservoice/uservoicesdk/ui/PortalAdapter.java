package com.uservoice.uservoicesdk.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import com.uservoice.uservoicesdk.Config;
import com.uservoice.uservoicesdk.R.id;
import com.uservoice.uservoicesdk.R.layout;
import com.uservoice.uservoicesdk.R.plurals;
import com.uservoice.uservoicesdk.R.string;
import com.uservoice.uservoicesdk.Session;
import com.uservoice.uservoicesdk.UserVoice;
import com.uservoice.uservoicesdk.activity.ContactActivity;
import com.uservoice.uservoicesdk.activity.ForumActivity;
import com.uservoice.uservoicesdk.activity.SearchActivity;
import com.uservoice.uservoicesdk.flow.InitManager;
import com.uservoice.uservoicesdk.model.Article;
import com.uservoice.uservoicesdk.model.BaseModel;
import com.uservoice.uservoicesdk.model.ClientConfig;
import com.uservoice.uservoicesdk.model.Forum;
import com.uservoice.uservoicesdk.model.Suggestion;
import com.uservoice.uservoicesdk.model.Topic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PortalAdapter
        extends SearchAdapter<BaseModel>
        implements AdapterView.OnItemClickListener {
    private static int ARTICLE = 5;
    private static int CONTACT;
    private static int FORUM;
    private static int KB_HEADER;
    private static int LOADING;
    private static int POWERED_BY = 6;
    public static int SCOPE_ALL = 0;
    public static int SCOPE_ARTICLES = 1;
    public static int SCOPE_IDEAS = 2;
    private static int TOPIC;
    private boolean configLoaded = false;
    private final FragmentActivity context;
    private LayoutInflater inflater;
    private List<Integer> staticRows;

    static {
        KB_HEADER = 0;
        FORUM = 1;
        TOPIC = 2;
        LOADING = 3;
        CONTACT = 4;
    }

    public PortalAdapter(FragmentActivity paramFragmentActivity) {
        this.context = paramFragmentActivity;
        this.inflater = ((LayoutInflater) paramFragmentActivity.getSystemService("layout_inflater"));
        new InitManager(paramFragmentActivity, new Runnable() {
            public void run() {
                PortalAdapter.access$002(PortalAdapter.this, true);
                PortalAdapter.this.notifyDataSetChanged();
                PortalAdapter.this.loadForum();
                PortalAdapter.this.loadTopics();
            }
        }).init();
    }

    private void computeStaticRows() {
        if (this.staticRows == null) {
            this.staticRows = new ArrayList();
            Config localConfig = Session.getInstance().getConfig();
            if (localConfig.shouldShowContactUs()) {
                this.staticRows.add(Integer.valueOf(CONTACT));
            }
            if (localConfig.shouldShowForum()) {
                this.staticRows.add(Integer.valueOf(FORUM));
            }
            if (localConfig.shouldShowKnowledgeBase()) {
                this.staticRows.add(Integer.valueOf(KB_HEADER));
            }
        }
    }

    private List<Article> getArticles() {
        return Session.getInstance().getArticles();
    }

    private List<Topic> getTopics() {
        return Session.getInstance().getTopics();
    }

    private void loadForum() {
        Forum.loadForum(Session.getInstance().getConfig().getForumId(), new DefaultCallback(this.context) {
            public void onModel(Forum paramAnonymousForum) {
                Session.getInstance().setForum(paramAnonymousForum);
                PortalAdapter.this.notifyDataSetChanged();
            }
        });
    }

    private void loadTopics() {
        final DefaultCallback local3 = new DefaultCallback(this.context) {
            public void onModel(List<Article> paramAnonymousList) {
                Session.getInstance().setTopics(new ArrayList());
                Session.getInstance().setArticles(paramAnonymousList);
                PortalAdapter.this.notifyDataSetChanged();
            }
        };
        if (Session.getInstance().getConfig().getTopicId() != -1) {
            Article.loadForTopic(Session.getInstance().getConfig().getTopicId(), local3);
            return;
        }
        Topic.loadTopics(new DefaultCallback(this.context) {
            public void onModel(List<Topic> paramAnonymousList) {
                if (paramAnonymousList.isEmpty()) {
                    Session.getInstance().setTopics(paramAnonymousList);
                    Article.loadAll(local3);
                    return;
                }
                paramAnonymousList = new ArrayList(paramAnonymousList);
                paramAnonymousList.add(Topic.ALL_ARTICLES);
                Session.getInstance().setTopics(paramAnonymousList);
                PortalAdapter.this.notifyDataSetChanged();
            }
        });
    }

    private boolean shouldShowArticles() {
        return (Session.getInstance().getConfig().getTopicId() != -1) || ((getTopics() != null) && (getTopics().isEmpty()));
    }

    public int getCount() {
        if (!this.configLoaded) {
            j = 1;
            return j;
        }
        computeStaticRows();
        int j = this.staticRows.size();
        int i;
        if (Session.getInstance().getConfig().shouldShowKnowledgeBase()) {
            if ((getTopics() == null) || ((shouldShowArticles()) && (getArticles() == null))) {
                i = j + 1;
            }
        }
        for (; ; ) {
            j = i;
            if (Session.getInstance().getClientConfig().isWhiteLabel()) {
                break;
            }
            return i + 1;
            if (shouldShowArticles()) {
            }
            for (i = getArticles().size(); ; i = getTopics().size()) {
                i += j;
                break;
            }
            i = j;
        }
    }

    public Object getItem(int paramInt) {
        computeStaticRows();
        if ((paramInt < this.staticRows.size()) && (((Integer) this.staticRows.get(paramInt)).intValue() == FORUM)) {
            return Session.getInstance().getForum();
        }
        if ((getTopics() != null) && (!shouldShowArticles()) && (paramInt >= this.staticRows.size()) && (paramInt - this.staticRows.size() < getTopics().size())) {
            return getTopics().get(paramInt - this.staticRows.size());
        }
        if ((getArticles() != null) && (shouldShowArticles()) && (paramInt >= this.staticRows.size()) && (paramInt - this.staticRows.size() < getArticles().size())) {
            return getArticles().get(paramInt - this.staticRows.size());
        }
        return null;
    }

    public long getItemId(int paramInt) {
        return paramInt;
    }

    public int getItemViewType(int paramInt) {
        if (!this.configLoaded) {
            paramInt = LOADING;
        }
        do {
            int i;
            do {
                return paramInt;
                computeStaticRows();
                if (paramInt >= this.staticRows.size()) {
                    break;
                }
                i = ((Integer) this.staticRows.get(paramInt)).intValue();
                paramInt = i;
            } while (i != FORUM);
            paramInt = i;
        } while (Session.getInstance().getForum() != null);
        return LOADING;
        if (Session.getInstance().getConfig().shouldShowKnowledgeBase()) {
            if ((getTopics() == null) || ((shouldShowArticles()) && (getArticles() == null))) {
                if (paramInt - this.staticRows.size() == 0) {
                    return LOADING;
                }
            } else {
                if ((shouldShowArticles()) && (paramInt - this.staticRows.size() < getArticles().size())) {
                    return ARTICLE;
                }
                if ((!shouldShowArticles()) && (paramInt - this.staticRows.size() < getTopics().size())) {
                    return TOPIC;
                }
            }
        }
        return POWERED_BY;
    }

    public List<BaseModel> getScopedSearchResults() {
        if (this.scope == SCOPE_ALL) {
            return this.searchResults;
        }
        ArrayList localArrayList;
        Iterator localIterator;
        BaseModel localBaseModel;
        if (this.scope == SCOPE_ARTICLES) {
            localArrayList = new ArrayList();
            localIterator = this.searchResults.iterator();
            while (localIterator.hasNext()) {
                localBaseModel = (BaseModel) localIterator.next();
                if ((localBaseModel instanceof Article)) {
                    localArrayList.add(localBaseModel);
                }
            }
            return localArrayList;
        }
        if (this.scope == SCOPE_IDEAS) {
            localArrayList = new ArrayList();
            localIterator = this.searchResults.iterator();
            while (localIterator.hasNext()) {
                localBaseModel = (BaseModel) localIterator.next();
                if ((localBaseModel instanceof Suggestion)) {
                    localArrayList.add(localBaseModel);
                }
            }
            return localArrayList;
        }
        return null;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        int i = getItemViewType(paramInt);
        paramViewGroup = paramView;
        if (paramView == null) {
            if (i == LOADING) {
                paramViewGroup = this.inflater.inflate(R.layout.uv_loading_item, null);
            }
        } else {
            if (i != FORUM) {
                break label300;
            }
            ((TextView) paramViewGroup.findViewById(R.id.uv_text)).setText(R.string.uv_feedback_forum);
            paramView = (TextView) paramViewGroup.findViewById(R.id.uv_text2);
            paramView.setText(Utils.getQuantityString(paramView, R.plurals.uv_ideas, Session.getInstance().getForum().getNumberOfOpenSuggestions()));
            label88:
            paramView = paramViewGroup.findViewById(R.id.uv_divider);
            if (paramView != null) {
                if (((paramInt != getCount() - 2) || (getItemViewType(getCount() - 1) != POWERED_BY)) && (paramInt != getCount() - 1)) {
                    break label577;
                }
            }
        }
        label300:
        label577:
        for (paramInt = 8; ; paramInt = 0) {
            paramView.setVisibility(paramInt);
            if (i == FORUM) {
                paramView.setVisibility(8);
            }
            return paramViewGroup;
            if (i == FORUM) {
                paramViewGroup = this.inflater.inflate(R.layout.uv_text_item, null);
                break;
            }
            if (i == KB_HEADER) {
                paramViewGroup = this.inflater.inflate(R.layout.uv_header_item_light, null);
                break;
            }
            if (i == TOPIC) {
                paramViewGroup = this.inflater.inflate(R.layout.uv_text_item, null);
                break;
            }
            if (i == CONTACT) {
                paramViewGroup = this.inflater.inflate(R.layout.uv_text_item, null);
                break;
            }
            if (i == ARTICLE) {
                paramViewGroup = this.inflater.inflate(R.layout.uv_text_item, null);
                break;
            }
            paramViewGroup = paramView;
            if (i != POWERED_BY) {
                break;
            }
            paramViewGroup = this.inflater.inflate(R.layout.uv_powered_by_item, null);
            break;
            if (i == KB_HEADER) {
                ((TextView) paramViewGroup.findViewById(R.id.uv_header_text)).setText(R.string.uv_knowledge_base);
                break label88;
            }
            if (i == TOPIC) {
                paramView = (Topic) getItem(paramInt);
                ((TextView) paramViewGroup.findViewById(R.id.uv_text)).setText(paramView.getName());
                TextView localTextView = (TextView) paramViewGroup.findViewById(R.id.uv_text2);
                if (paramView == Topic.ALL_ARTICLES) {
                    localTextView.setVisibility(8);
                    break label88;
                }
                localTextView.setVisibility(0);
                localTextView.setText(String.format("%d %s", new Object[]{Integer.valueOf(paramView.getNumberOfArticles()), this.context.getResources().getQuantityString(R.plurals.uv_articles, paramView.getNumberOfArticles())}));
                break label88;
            }
            if (i == CONTACT) {
                ((TextView) paramViewGroup.findViewById(R.id.uv_text)).setText(R.string.uv_contact_us);
                paramViewGroup.findViewById(R.id.uv_text2).setVisibility(8);
                break label88;
            }
            if (i == ARTICLE) {
                ((TextView) paramViewGroup.findViewById(R.id.uv_text)).setText(((Article) getItem(paramInt)).getTitle());
                break label88;
            }
            if (i != POWERED_BY) {
                break label88;
            }
            ((TextView) paramViewGroup.findViewById(R.id.uv_version)).setText(this.context.getString(R.string.uv_android_sdk) + " v" + UserVoice.getVersion());
            break label88;
        }
    }

    public int getViewTypeCount() {
        return 7;
    }

    public boolean isEnabled(int paramInt) {
        if (!this.configLoaded) {
            return false;
        }
        computeStaticRows();
        if (paramInt < this.staticRows.size()) {
            paramInt = ((Integer) this.staticRows.get(paramInt)).intValue();
            if ((paramInt == KB_HEADER) || (paramInt == LOADING)) {
                return false;
            }
        }
        return true;
    }

    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
        int i = getItemViewType(paramInt);
        if (i == CONTACT) {
            this.context.startActivity(new Intent(this.context, ContactActivity.class));
        }
        do {
            return;
            if (i == FORUM) {
                this.context.startActivity(new Intent(this.context, ForumActivity.class));
                return;
            }
        } while ((i != TOPIC) && (i != ARTICLE));
        Utils.showModel(this.context, (BaseModel) getItem(paramInt));
    }

    protected void searchResultsUpdated() {
        Iterator localIterator = this.searchResults.iterator();
        int j = 0;
        int i = 0;
        if (localIterator.hasNext()) {
            int k;
            if (((BaseModel) localIterator.next() instanceof Article)) {
                k = j;
                j = i + 1;
            }
            for (i = k; ; i = k) {
                k = j;
                j = i;
                i = k;
                break;
                k = j + 1;
                j = i;
            }
        }
        ((SearchActivity) this.context).updateScopedSearch(this.searchResults.size(), i, j);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/uservoice/uservoicesdk/ui/PortalAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */