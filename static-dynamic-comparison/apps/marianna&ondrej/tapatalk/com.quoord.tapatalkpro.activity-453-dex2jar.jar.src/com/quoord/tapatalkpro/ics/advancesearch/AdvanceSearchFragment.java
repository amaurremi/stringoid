package com.quoord.tapatalkpro.ics.advancesearch;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SearchView.OnCloseListener;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.TextView;
import android.widget.Toast;
import com.quoord.tapatalkpro.activity.forum.CategoryActivity;
import com.quoord.tapatalkpro.activity.forum.DrawerLayoutStatus;
import com.quoord.tapatalkpro.activity.forum.SearchActivity;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.ui.ics.QuoordFragment;
import com.quoord.tapatalkpro.util.AdvancesearchContrast;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tools.tracking.GoogleAnalyticsTools;

import java.util.Stack;

public class AdvanceSearchFragment
        extends QuoordFragment
        implements SearchView.OnQueryTextListener, SearchView.OnCloseListener {
    private TextView advance_search = null;
    private String author = null;
    public EditText authorEdit = null;
    private RelativeLayout authorlay;
    private ActionBar bar;
    private boolean byPost = false;
    private CheckBox byTopicCheckBox = null;
    private String category = null;
    private RelativeLayout categoryLayout;
    public TextView categroiesText = null;
    private AdvancesearchContrast constrast = null;
    private ImageView diver;
    private ImageView diver1;
    private ImageView diver2;
    public String forumId = "";
    private ForumStatus forumStatus = null;
    private Activity mActivity = null;
    public View searchMenu = null;
    private String searchTitle = null;
    private RelativeLayout searchlayout = null;
    public String threadId = "";
    private boolean titleOnly = false;
    private CheckBox titleOnlyCheckBox;

    private void initActionBar() {
        this.bar.setNavigationMode(0);
        this.bar.setTitle(2131100136);
        this.bar.setSubtitle(null);
    }

    public static AdvanceSearchFragment newInstance(ForumStatus paramForumStatus, String paramString, AdvancesearchContrast paramAdvancesearchContrast) {
        AdvanceSearchFragment localAdvanceSearchFragment = new AdvanceSearchFragment();
        localAdvanceSearchFragment.forumStatus = paramForumStatus;
        localAdvanceSearchFragment.threadId = paramString;
        localAdvanceSearchFragment.constrast = paramAdvancesearchContrast;
        return localAdvanceSearchFragment;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void initView() {
        this.searchlayout = ((RelativeLayout) this.searchMenu.findViewById(2131230816));
        this.authorlay = ((RelativeLayout) this.searchMenu.findViewById(2131230824));
        this.authorEdit = ((EditText) this.searchMenu.findViewById(2131230826));
        this.categoryLayout = ((RelativeLayout) this.searchMenu.findViewById(2131230828));
        if (((getActivity() instanceof AdvanceSearchActivity)) || ((getActivity() instanceof SearchActivity))) {
            this.categoryLayout.setVisibility(8);
            this.categroiesText = ((TextView) this.searchMenu.findViewById(2131230830));
            this.titleOnlyCheckBox = ((CheckBox) this.searchMenu.findViewById(2131230818));
            RelativeLayout localRelativeLayout1 = (RelativeLayout) this.searchMenu.findViewById(2131230817);
            this.advance_search = ((TextView) this.searchMenu.findViewById(2131230831));
            localRelativeLayout1.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("forum_top_item_bg", getActivity()));
            localRelativeLayout1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramAnonymousView) {
                    if (AdvanceSearchFragment.this.constrast != null) {
                        if (AdvanceSearchFragment.this.titleOnlyCheckBox.isChecked()) {
                            AdvanceSearchFragment.this.titleOnlyCheckBox.setChecked(false);
                            AdvanceSearchFragment.this.titleOnly = false;
                            AdvanceSearchFragment.this.constrast.TITLEONLY = AdvanceSearchFragment.this.titleOnly;
                        }
                    } else {
                        return;
                    }
                    AdvanceSearchFragment.this.titleOnlyCheckBox.setChecked(true);
                    AdvanceSearchFragment.this.titleOnly = true;
                    AdvanceSearchFragment.this.constrast.TITLEONLY = AdvanceSearchFragment.this.titleOnly;
                }
            });
            this.titleOnlyCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean) {
                    if (AdvanceSearchFragment.this.constrast != null) {
                        if (paramAnonymousBoolean) {
                            AdvanceSearchFragment.this.titleOnly = true;
                            AdvanceSearchFragment.this.constrast.TITLEONLY = AdvanceSearchFragment.this.titleOnly;
                        }
                    } else {
                        return;
                    }
                    AdvanceSearchFragment.this.titleOnly = false;
                    AdvanceSearchFragment.this.constrast.TITLEONLY = AdvanceSearchFragment.this.titleOnly;
                }
            });
            this.byTopicCheckBox = ((CheckBox) this.searchMenu.findViewById(2131230821));
            RelativeLayout localRelativeLayout2 = (RelativeLayout) this.searchMenu.findViewById(2131230820);
            localRelativeLayout2.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("forum_mid_item_bg", getActivity()));
            localRelativeLayout2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramAnonymousView) {
                    if (AdvanceSearchFragment.this.constrast != null) {
                        if (AdvanceSearchFragment.this.byTopicCheckBox.isChecked()) {
                            AdvanceSearchFragment.this.byTopicCheckBox.setChecked(false);
                            AdvanceSearchFragment.this.byPost = false;
                            AdvanceSearchFragment.this.constrast.SHOWPOSTS = AdvanceSearchFragment.this.byPost;
                        }
                    } else {
                        return;
                    }
                    AdvanceSearchFragment.this.byTopicCheckBox.setChecked(true);
                    AdvanceSearchFragment.this.byPost = true;
                    AdvanceSearchFragment.this.constrast.SHOWPOSTS = AdvanceSearchFragment.this.byPost;
                }
            });
            this.byTopicCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean) {
                    if (AdvanceSearchFragment.this.constrast != null) {
                        if (paramAnonymousBoolean) {
                            AdvanceSearchFragment.this.byPost = true;
                            AdvanceSearchFragment.this.constrast.SHOWPOSTS = AdvanceSearchFragment.this.byPost;
                        }
                    } else {
                        return;
                    }
                    AdvanceSearchFragment.this.byPost = false;
                    AdvanceSearchFragment.this.constrast.SHOWPOSTS = AdvanceSearchFragment.this.byPost;
                }
            });
            if ((this.constrast != null) && (!this.constrast.FORUMNAME.equals("")) && (this.constrast.FORUMID != null)) {
                this.categroiesText.setText(this.constrast.FORUMNAME);
                setForumId(this.constrast.FORUMID);
            }
            if ((this.constrast != null) && (!this.constrast.USERNAME.equals(""))) {
                this.authorEdit.setText(this.constrast.USERNAME);
            }
            if ((this.constrast != null) && (this.titleOnlyCheckBox != null)) {
                this.titleOnlyCheckBox.setChecked(this.constrast.TITLEONLY);
            }
            if ((this.constrast != null) && (this.byTopicCheckBox != null)) {
                this.byTopicCheckBox.setChecked(this.constrast.SHOWPOSTS);
            }
            if ((this.constrast != null) && (this.constrast.THREADID != null) && (!this.constrast.THREADID.equals("")) && (((getActivity() instanceof AdvanceSearchActivity)) || (Util.isHDDevice(getActivity())))) {
                this.threadId = this.constrast.THREADID;
                localRelativeLayout1.setVisibility(8);
                this.titleOnly = false;
                this.constrast.TITLEONLY = this.titleOnly;
                localRelativeLayout2.setVisibility(8);
                this.byPost = true;
                this.constrast.SHOWPOSTS = this.byPost;
            }
            this.categoryLayout.setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramAnonymousView) {
                    paramAnonymousView = new Intent(AdvanceSearchFragment.this.getActivity(), CategoryActivity.class);
                    Bundle localBundle = new Bundle();
                    localBundle.putSerializable("forumStatus", AdvanceSearchFragment.this.forumStatus);
                    paramAnonymousView.putExtras(localBundle);
                    AdvanceSearchFragment.this.getActivity().startActivityForResult(paramAnonymousView, 52);
                }
            });
            this.advance_search.setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramAnonymousView) {
                    if ((AdvanceSearchFragment.this.searchTitle == null) || ((AdvanceSearchFragment.this.searchTitle.equals("")) && ((AdvanceSearchFragment.this.authorEdit.getText().toString().trim() == null) || (AdvanceSearchFragment.this.authorEdit.getText().toString().trim().equals(""))))) {
                        Toast.makeText(AdvanceSearchFragment.this.getActivity(), 2131100134, 0).show();
                    }
                    for (; ; ) {
                        ((InputMethodManager) AdvanceSearchFragment.this.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(paramAnonymousView.getWindowToken(), 0);
                        return;
                        AdvanceSearchFragment.this.forumId = AdvanceSearchFragment.this.getForumId();
                        AdvanceSearchFragment.this.queryResult(AdvanceSearchFragment.this.searchTitle);
                    }
                }
            });
            this.diver = ((ImageView) this.searchMenu.findViewById(2131230776));
            this.diver1 = ((ImageView) this.searchMenu.findViewById(2131230823));
            this.diver2 = ((ImageView) this.searchMenu.findViewById(2131230827));
            if (!(getActivity() instanceof SlidingMenuActivity)) {
                break label724;
            }
            this.authorlay.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("forum_mid_item_bg", getActivity()));
            this.diver2.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("forum_item_diver", getActivity()));
        }
        for (; ; ) {
            if ((!(getActivity() instanceof AdvanceSearchActivity)) && (!(getActivity() instanceof SearchActivity))) {
                this.categoryLayout.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("forum_bottom_item_bg", getActivity()));
            }
            this.diver.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("forum_item_diver", getActivity()));
            this.diver1.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("forum_item_diver", getActivity()));
            return;
            this.categoryLayout.setVisibility(0);
            break;
            label724:
            if (((getActivity() instanceof AdvanceSearchActivity)) || ((getActivity() instanceof SearchActivity))) {
                this.authorlay.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("forum_bottom_item_bg", getActivity()));
                this.diver2.setBackgroundDrawable(null);
            }
        }
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        this.mActivity = getActivity();
        this.bar = getActivity().getActionBar();
        this.bar.setDisplayHomeAsUpEnabled(true);
        initActionBar();
        if ((this.constrast != null) && (!this.constrast.KEYWORD.equals(""))) {
            this.searchTitle = this.constrast.KEYWORD;
        }
        try {
            GoogleAnalyticsTools.trackPageView(this.mActivity, "search", this.forumStatus.getForumId(), this.forumStatus.getUrl());
            return;
        } catch (Exception paramBundle) {
            paramBundle.printStackTrace();
        }
    }

    public boolean onClose() {
        return false;
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        this.searchMenu = LayoutInflater.from(getActivity()).inflate(2130903059, null);
        initView();
        return this.searchMenu;
    }

    public void onHiddenChanged(boolean paramBoolean) {
        super.onHiddenChanged(paramBoolean);
        this.bar.setDisplayShowTitleEnabled(true);
        if (!paramBoolean) {
            initActionBar();
        }
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        return super.onOptionsItemSelected(paramMenuItem);
    }

    public void onPrepareOptionsMenu(Menu paramMenu) {
        super.onPrepareOptionsMenu(paramMenu);
        if (((getActivity() instanceof DrawerLayoutStatus)) && (((DrawerLayoutStatus) getActivity()).isDrawMenuOpen())) {
        }
    }

    public boolean onQueryTextChange(String paramString) {
        return false;
    }

    public boolean onQueryTextSubmit(String paramString) {
        queryResult(paramString);
        ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.searchMenu.getWindowToken(), 0);
        return true;
    }

    public void queryResult(String paramString) {
        this.author = this.authorEdit.getText().toString().trim();
        this.category = this.categroiesText.getText().toString().trim();
        AdvancesearchContrast localAdvancesearchContrast1 = new AdvancesearchContrast();
        AdvancesearchContrast localAdvancesearchContrast2 = new AdvancesearchContrast();
        localAdvancesearchContrast1.KEYWORD = paramString.trim();
        localAdvancesearchContrast2.KEYWORD = paramString.trim();
        if ((this.category != null) && (!this.category.equals(this.mActivity.getResources().getString(2131100128)))) {
            localAdvancesearchContrast1.FORUMNAME = this.category;
            localAdvancesearchContrast2.FORUMNAME = this.category;
        }
        if ((this.forumId != null) && (!this.forumId.equals(""))) {
            localAdvancesearchContrast1.FORUMID = this.forumId;
            localAdvancesearchContrast2.FORUMID = this.forumId;
        }
        if ((this.author != null) && (this.author.length() > 0)) {
            localAdvancesearchContrast1.USERNAME = this.author;
            localAdvancesearchContrast2.USERNAME = this.author;
        }
        if (!this.byPost) {
            localAdvancesearchContrast1.SHOWPOSTS = false;
            localAdvancesearchContrast2.SHOWPOSTS = false;
            localAdvancesearchContrast1.THREADID = this.threadId;
            localAdvancesearchContrast2.THREADID = this.threadId;
            localAdvancesearchContrast1.TITLEONLY = this.titleOnly;
            localAdvancesearchContrast2.TITLEONLY = this.titleOnly;
            localAdvancesearchContrast1.SHOWPOSTS = this.byPost;
            localAdvancesearchContrast2.SHOWPOSTS = this.byPost;
            paramString = null;
            if (!(getActivity() instanceof SlidingMenuActivity)) {
                break label388;
            }
            paramString = (QuoordFragment) ((SlidingMenuActivity) getActivity()).advanceFragmentStack.get(0);
            label279:
            if (((paramString instanceof AdvanceSearchHistoryFragment)) && ((localAdvancesearchContrast1.THREADID == null) || (localAdvancesearchContrast1.THREADID.equals("")))) {
                ((AdvanceSearchHistoryFragment) paramString).adapter.addSearchHistory(localAdvancesearchContrast2);
            }
            if ((localAdvancesearchContrast1.THREADID != null) && (!localAdvancesearchContrast1.THREADID.equals(""))) {
                localAdvancesearchContrast1.SHOWPOSTS = true;
            }
            paramString = AdvanceSearchResultFragment.newInstance(this.forumStatus, localAdvancesearchContrast1);
            if (!(this.mActivity instanceof SlidingMenuActivity)) {
                break label450;
            }
            ((SlidingMenuActivity) this.mActivity).addFragmentToStack(paramString, "advance_fragment_stack_tag", true);
        }
        label388:
        label450:
        do {
            return;
            localAdvancesearchContrast1.SHOWPOSTS = true;
            localAdvancesearchContrast2.SHOWPOSTS = true;
            break;
            if ((getActivity() instanceof AdvanceSearchActivity)) {
                paramString = (QuoordFragment) ((AdvanceSearchActivity) getActivity()).advanceFragmentStack.get(0);
                break label279;
            }
            if (!(getActivity() instanceof SearchActivity)) {
                break label279;
            }
            paramString = (QuoordFragment) ((SearchActivity) getActivity()).advanceFragmentStack.get(0);
            break label279;
            if ((this.mActivity instanceof AdvanceSearchActivity)) {
                ((AdvanceSearchActivity) this.mActivity).addFragmentToStack(paramString, "advance_fragment_stack_tag", true);
                return;
            }
        } while (!(getActivity() instanceof SearchActivity));
        ((SearchActivity) this.mActivity).addFragmentToStack(paramString, "advance_fragment_stack_tag", true);
    }

    public void setForumId(String paramString) {
        this.forumId = paramString;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ics/advancesearch/AdvanceSearchFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */