package com.uservoice.uservoicesdk.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import com.uservoice.uservoicesdk.Config;
import com.uservoice.uservoicesdk.R.id;
import com.uservoice.uservoicesdk.R.layout;
import com.uservoice.uservoicesdk.R.menu;
import com.uservoice.uservoicesdk.R.string;
import com.uservoice.uservoicesdk.Session;
import com.uservoice.uservoicesdk.babayaga.Babayaga;
import com.uservoice.uservoicesdk.babayaga.Babayaga.Event;
import com.uservoice.uservoicesdk.dialog.SuggestionDialogFragment;
import com.uservoice.uservoicesdk.flow.InitManager;
import com.uservoice.uservoicesdk.model.Forum;
import com.uservoice.uservoicesdk.model.Suggestion;
import com.uservoice.uservoicesdk.rest.Callback;
import com.uservoice.uservoicesdk.rest.RestResult;
import com.uservoice.uservoicesdk.rest.RestTask;
import com.uservoice.uservoicesdk.ui.DefaultCallback;
import com.uservoice.uservoicesdk.ui.PaginatedAdapter;
import com.uservoice.uservoicesdk.ui.PaginationScrollListener;
import com.uservoice.uservoicesdk.ui.SearchAdapter;
import com.uservoice.uservoicesdk.ui.SearchExpandListener;
import com.uservoice.uservoicesdk.ui.SearchQueryListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ForumActivity
        extends BaseListActivity
        implements SearchActivity {
    private Forum forum;
    private List<Suggestion> suggestions;

    private void loadForum() {
        if (Session.getInstance().getForum() != null) {
            this.forum = Session.getInstance().getForum();
            Babayaga.track(Babayaga.Event.VIEW_FORUM, this.forum.getId());
            setTitle(this.forum.getName());
            getModelAdapter().loadMore();
            return;
        }
        Forum.loadForum(Session.getInstance().getConfig().getForumId(), new DefaultCallback(this) {
            public void onModel(Forum paramAnonymousForum) {
                Session.getInstance().setForum(paramAnonymousForum);
                ForumActivity.access$002(ForumActivity.this, paramAnonymousForum);
                ForumActivity.this.setTitle(ForumActivity.this.forum.getName());
                ForumActivity.this.getModelAdapter().loadMore();
            }
        });
    }

    public PaginatedAdapter<Suggestion> getModelAdapter() {
        return (PaginatedAdapter) getListAdapter();
    }

    public SearchAdapter<?> getSearchAdapter() {
        return getModelAdapter();
    }

    public void hideSearch() {
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setTitle(R.string.uv_feedback_forum);
        this.suggestions = new ArrayList();
        getListView().setDivider(null);
        setListAdapter(new PaginatedAdapter(this, R.layout.uv_suggestion_item, this.suggestions) {
            boolean initializing = true;

            protected void customizeLayout(View paramAnonymousView, Suggestion paramAnonymousSuggestion) {
                ((TextView) paramAnonymousView.findViewById(R.id.uv_suggestion_title)).setText(paramAnonymousSuggestion.getTitle());
                ((TextView) paramAnonymousView.findViewById(R.id.uv_subscriber_count)).setText(String.valueOf(paramAnonymousSuggestion.getNumberOfSubscribers()));
                TextView localTextView = (TextView) paramAnonymousView.findViewById(R.id.uv_suggestion_status);
                paramAnonymousView = paramAnonymousView.findViewById(R.id.uv_suggestion_status_color);
                if (paramAnonymousSuggestion.getStatus() == null) {
                    localTextView.setVisibility(8);
                    paramAnonymousView.setVisibility(8);
                    return;
                }
                int i = Color.parseColor(paramAnonymousSuggestion.getStatusColor());
                localTextView.setVisibility(0);
                localTextView.setTextColor(i);
                localTextView.setText(paramAnonymousSuggestion.getStatus().toUpperCase(Locale.getDefault()));
                paramAnonymousView.setVisibility(0);
                paramAnonymousView.setBackgroundColor(i);
            }

            public int getCount() {
                int j = super.getCount();
                if (this.initializing) {
                }
                for (int i = 1; ; i = 0) {
                    return i + (j + 2);
                }
            }

            public Object getItem(int paramAnonymousInt) {
                return super.getItem(paramAnonymousInt - 2);
            }

            public int getItemViewType(int paramAnonymousInt) {
                if (paramAnonymousInt == 0) {
                    return 2;
                }
                if (paramAnonymousInt == 1) {
                    return 3;
                }
                if ((paramAnonymousInt == 2) && (this.initializing)) {
                    return 1;
                }
                return super.getItemViewType(paramAnonymousInt - 2);
            }

            public int getTotalNumberOfObjects() {
                return ForumActivity.this.forum.getNumberOfOpenSuggestions();
            }

            public View getView(int paramAnonymousInt, View paramAnonymousView, ViewGroup paramAnonymousViewGroup) {
                int i = getItemViewType(paramAnonymousInt);
                if ((i == 2) || (i == 3)) {
                    paramAnonymousViewGroup = paramAnonymousView;
                    if (paramAnonymousView == null) {
                        if (i != 2) {
                            break label88;
                        }
                        paramAnonymousViewGroup = ForumActivity.this.getLayoutInflater().inflate(R.layout.uv_text_item, null);
                        ((TextView) paramAnonymousViewGroup.findViewById(R.id.uv_text)).setText(R.string.uv_post_an_idea);
                        paramAnonymousViewGroup.findViewById(R.id.uv_divider).setVisibility(8);
                        paramAnonymousViewGroup.findViewById(R.id.uv_text2).setVisibility(8);
                    }
                    label88:
                    do {
                        return paramAnonymousViewGroup;
                        paramAnonymousViewGroup = paramAnonymousView;
                    } while (i != 3);
                    paramAnonymousView = ForumActivity.this.getLayoutInflater().inflate(R.layout.uv_header_item_light, null);
                    ((TextView) paramAnonymousView.findViewById(R.id.uv_header_text)).setText(R.string.uv_idea_text_heading);
                    return paramAnonymousView;
                }
                return super.getView(paramAnonymousInt, paramAnonymousView, paramAnonymousViewGroup);
            }

            public int getViewTypeCount() {
                return super.getViewTypeCount() + 2;
            }

            public boolean isEnabled(int paramAnonymousInt) {
                return (getItemViewType(paramAnonymousInt) == 2) || (super.isEnabled(paramAnonymousInt));
            }

            public void loadMore() {
                if (this.initializing) {
                    notifyDataSetChanged();
                }
                this.initializing = false;
                super.loadMore();
            }

            public void loadPage(int paramAnonymousInt, Callback<List<Suggestion>> paramAnonymousCallback) {
                Suggestion.loadSuggestions(ForumActivity.this.forum, paramAnonymousInt, paramAnonymousCallback);
            }

            public RestTask search(final String paramAnonymousString, final Callback<List<Suggestion>> paramAnonymousCallback) {
                if (ForumActivity.this.forum == null) {
                    return null;
                }
                Suggestion.searchSuggestions(ForumActivity.this.forum, paramAnonymousString, new Callback() {
                    public void onError(RestResult paramAnonymous2RestResult) {
                        paramAnonymousCallback.onError(paramAnonymous2RestResult);
                    }

                    public void onModel(List<Suggestion> paramAnonymous2List) {
                        Babayaga.track(Babayaga.Event.SEARCH_IDEAS, paramAnonymousString, paramAnonymous2List);
                        paramAnonymousCallback.onModel(paramAnonymous2List);
                    }
                });
            }
        });
        getListView().setOnScrollListener(new PaginationScrollListener(getModelAdapter()) {
            public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {
                if (ForumActivity.this.forum != null) {
                    super.onScroll(paramAnonymousAbsListView, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
                }
            }
        });
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong) {
                if (paramAnonymousInt == 0) {
                    ForumActivity.this.startActivity(new Intent(ForumActivity.this, PostIdeaActivity.class));
                }
                while (paramAnonymousInt == 1) {
                    return;
                }
                paramAnonymousAdapterView = (Suggestion) ForumActivity.this.getModelAdapter().getItem(paramAnonymousInt);
                Session.getInstance().setSuggestion(paramAnonymousAdapterView);
                new SuggestionDialogFragment(paramAnonymousAdapterView, null).show(ForumActivity.this.getSupportFragmentManager(), "SuggestionDialogFragment");
            }
        });
        new InitManager(this, new Runnable() {
            public void run() {
                ForumActivity.this.loadForum();
                Session.getInstance().setSignInListener(new Runnable() {
                    public void run() {
                        if (ForumActivity.this.forum != null) {
                            ForumActivity.this.getModelAdapter().reload();
                        }
                    }
                });
            }
        }).init();
    }

    @SuppressLint({"NewApi"})
    public boolean onCreateOptionsMenu(Menu paramMenu) {
        getMenuInflater().inflate(R.menu.uv_forum, paramMenu);
        if (hasActionBar()) {
            paramMenu.findItem(R.id.uv_menu_search).setOnActionExpandListener(new SearchExpandListener(this));
            ((SearchView) paramMenu.findItem(R.id.uv_menu_search).getActionView()).setOnQueryTextListener(new SearchQueryListener(this));
        }
        for (; ; ) {
            paramMenu.findItem(R.id.uv_new_idea).setVisible(Session.getInstance().getConfig().shouldShowPostIdea());
            return true;
            paramMenu.findItem(R.id.uv_menu_search).setVisible(false);
        }
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        if (paramMenuItem.getItemId() == R.id.uv_new_idea) {
            startActivity(new Intent(this, PostIdeaActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(paramMenuItem);
    }

    protected void onStop() {
        Session.getInstance().setSignInListener(null);
        super.onStop();
    }

    public void showSearch() {
    }

    public void suggestionUpdated(Suggestion paramSuggestion) {
        getModelAdapter().notifyDataSetChanged();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/uservoice/uservoicesdk/activity/ForumActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */