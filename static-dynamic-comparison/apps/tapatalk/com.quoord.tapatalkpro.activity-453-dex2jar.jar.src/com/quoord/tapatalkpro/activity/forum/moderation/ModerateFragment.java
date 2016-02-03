package com.quoord.tapatalkpro.activity.forum.moderation;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.quoord.tapatalkpro.action.GetTopicAction;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.adapter.forum.moderation.ModerateAdapter;
import com.quoord.tapatalkpro.bean.Forum;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.Topic;
import com.quoord.tapatalkpro.ics.BaseListFragment;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tapatalkpro.view.SectionTitleListView;
import com.quoord.tapatalkpro.view.SectionTitleListView.OnScrollListenerForOtherUse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class ModerateFragment
        extends BaseListFragment {
    public static final int flatten = 1;
    public static final int hierarchical = 0;
    private ForumStatus forumStatus;
    private SectionTitleListView groupTreeView;
    private boolean isSortByName = false;
    private View layout = null;
    private Activity mActivity;
    public ModerateAdapter mForumAdapter = null;
    public ProgressDialog mProgressDlg;
    public Topic mTopic;
    public LinearLayout noResultDatas = null;
    public EditText targetForum = null;
    public TextView textView;

    public static ModerateFragment newInstance(ForumStatus paramForumStatus, Topic paramTopic) {
        ModerateFragment localModerateFragment = new ModerateFragment();
        localModerateFragment.forumStatus = paramForumStatus;
        localModerateFragment.mTopic = paramTopic;
        return localModerateFragment;
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        this.mActivity = getActivity();
        paramBundle = this.mActivity.getActionBar();
        paramBundle.setDisplayHomeAsUpEnabled(true);
        if ((this.mActivity instanceof ModerateActivity)) {
            if (((ModerateActivity) this.mActivity).select_forum_action == 0) {
                paramBundle.setTitle(this.mActivity.getResources().getString(2131100692));
            }
        }
        for (; ; ) {
            paramBundle.setIcon(2130837525);
            this.textView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramAnonymousView) {
                    if ((ModerateFragment.this.mForumAdapter.getTargetForumId() != null) && (ModerateFragment.this.mForumAdapter.getTargetForumId().length() > 0)) {
                        if ((ModerateFragment.this.mActivity instanceof ModerateActivity)) {
                            if (((ModerateActivity) ModerateFragment.this.mActivity).select_forum_action == 0) {
                                ModerateFragment.this.mForumAdapter.startNewTopic((Forum) ModerateFragment.this.mForumAdapter.forumDatas.get("forumId|" + ModerateFragment.this.mForumAdapter.currentForum.getId()));
                            }
                        }
                        for (; ; ) {
                            ModerateFragment.this.mForumAdapter.recentForums.add((Forum) ModerateFragment.this.mForumAdapter.forumDatas.get("forumId|" + ModerateFragment.this.mForumAdapter.currentForum.getId()));
                            ModerateFragment.this.mForumAdapter.saveRecentForums();
                            return;
                            if (((ModerateActivity) ModerateFragment.this.mActivity).select_forum_action == 2) {
                                ModerateFragment.this.mActivity.showDialog(80);
                            } else if (((ModerateActivity) ModerateFragment.this.mActivity).select_forum_action == 3) {
                                ModerateFragment.this.mActivity.showDialog(81);
                            } else if (((ModerateActivity) ModerateFragment.this.mActivity).select_forum_action == 6) {
                                ModerateFragment.this.mActivity.showDialog(82);
                            } else {
                                int i = ((ModerateActivity) ModerateFragment.this.mActivity).select_forum_action;
                                continue;
                                if ((ModerateFragment.this.mForumAdapter.forumDatas.get("forumId|" + ModerateFragment.this.mForumAdapter.currentForum.getId()) instanceof Forum)) {
                                    ModerateFragment.this.mForumAdapter.startNewTopic((Forum) ModerateFragment.this.mForumAdapter.forumDatas.get("forumId|" + ModerateFragment.this.mForumAdapter.currentForum.getId()));
                                }
                            }
                        }
                    }
                    Toast.makeText(ModerateFragment.this.mActivity, ModerateFragment.this.mActivity.getString(2131100066), 1).show();
                }
            });
            updateForum(false);
            this.groupTreeView.setOnScrollListenerForOther(new SectionTitleListView.OnScrollListenerForOtherUse() {
                public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {
                    if ((paramAnonymousInt1 + paramAnonymousInt2 == paramAnonymousInt3) && (ModerateFragment.this.mForumAdapter != null) && (!ModerateFragment.this.mForumAdapter.isLoadmore) && (ModerateFragment.this.mForumAdapter.getTopicAction != null) && (ModerateFragment.this.mForumAdapter.getTopicAction.mStart <= ModerateFragment.this.mForumAdapter.getTopicAction.total_topic_num)) {
                        ModerateFragment.this.groupTreeView.setLoadingMoreEnabled(true);
                        ModerateFragment.this.mForumAdapter.getTopicAction.getTopic();
                        ModerateFragment.this.mForumAdapter.isLoadmore = true;
                    }
                }

                public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {
                }
            });
            this.mActivity.invalidateOptionsMenu();
            return;
            if (((ModerateActivity) this.mActivity).select_forum_action == 3) {
                paramBundle.setTitle(this.mActivity.getResources().getString(2131100749));
            } else if (((ModerateActivity) this.mActivity).select_forum_action == 4) {
                paramBundle.setTitle(this.mActivity.getResources().getString(2131100750));
            } else if (((ModerateActivity) this.mActivity).select_forum_action == 4) {
                paramBundle.setTitle(this.mActivity.getResources().getString(2131100750));
            } else if ((((ModerateActivity) this.mActivity).select_forum_action == 2) && (this.mTopic != null)) {
                paramBundle.setTitle(this.mTopic.getTitle());
                continue;
                paramBundle.setTitle(this.mActivity.getResources().getString(2131100584));
            }
        }
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        this.layout = paramLayoutInflater.inflate(2130903171, null);
        this.groupTreeView = ((SectionTitleListView) this.layout.findViewById(2131231114));
        this.textView = ((TextView) this.layout.findViewById(2131231113));
        this.noResultDatas = ((LinearLayout) this.layout.findViewById(2131231112));
        return this.layout;
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
            default:
                return super.onOptionsItemSelected(paramMenuItem);
            case 1005:
                this.isSortByName = true;
                this.mForumAdapter.tabChange(1);
                getActivity().invalidateOptionsMenu();
                return true;
            case 1006:
                this.isSortByName = false;
                this.mForumAdapter.tabChange(0);
                getActivity().invalidateOptionsMenu();
                return true;
        }
        if ((this.mForumAdapter.forumStack != null) && (!this.mForumAdapter.forumStack.empty())) {
            this.mForumAdapter.backToTopLevel();
            this.mActivity.invalidateOptionsMenu();
            return true;
        }
        paramMenuItem = new Intent();
        paramMenuItem.putExtra("cookie", this.forumStatus.getCookie());
        this.mActivity.setResult(-1, paramMenuItem);
        this.mActivity.finish();
        return true;
    }

    public void onPrepareOptionsMenu(Menu paramMenu) {
        super.onPrepareOptionsMenu(paramMenu);
        paramMenu.removeGroup(0);
        if (((getActivity() instanceof ModerateActivity)) && (((ModerateActivity) getActivity()).select_forum_action != 4)) {
            if (!this.isSortByName) {
                paramMenu.add(0, 1005, 1, getString(2131099876)).setIcon(ThemeUtil.getMenuIconByPicName("menu_forum_by_name", getActivity())).setShowAsAction(0);
            }
        } else {
            if ((this.textView == null) || (this.mForumAdapter == null) || (!(getActivity() instanceof ModerateActivity))) {
                break label588;
            }
            if (((ModerateActivity) getActivity()).select_forum_action != 0) {
                break label237;
            }
            if (this.mForumAdapter.currentForum == null) {
                break label227;
            }
            this.textView.setText(getActivity().getResources().getString(2131100694) + "\"" + this.mForumAdapter.currentForum.getName() + "\"");
        }
        label227:
        label237:
        label588:
        while (this.textView == null) {
            return;
            paramMenu.add(0, 1006, 1, getString(2131099875)).setIcon(ThemeUtil.getMenuIconByPicName("menu_forum_by_category", getActivity())).setShowAsAction(0);
            break;
            this.textView.setVisibility(8);
            return;
            if ((((ModerateActivity) getActivity()).select_forum_action == 4) || (((ModerateActivity) getActivity()).select_forum_action == 5)) {
                this.textView.setVisibility(8);
                return;
            }
            if ((((ModerateActivity) getActivity()).select_forum_action == 2) || (((ModerateActivity) getActivity()).select_forum_action == 3)) {
                if (this.mForumAdapter.currentForum != null) {
                    this.textView.setText(getActivity().getResources().getString(2131099948) + "\"" + this.mForumAdapter.currentForum.getName() + "\"");
                    return;
                }
                this.textView.setVisibility(8);
                return;
            }
            if (((ModerateActivity) getActivity()).select_forum_action == 6) {
                if (this.mForumAdapter.currentForum != null) {
                    this.textView.setText(getActivity().getResources().getString(2131100753) + "\"" + this.mForumAdapter.currentForum.getName() + "\"");
                    return;
                }
                this.textView.setVisibility(8);
                return;
            }
            if ((this.mForumAdapter != null) && (this.mForumAdapter.forum_id.size() > 0) && (this.mForumAdapter.currentForum != null) && (!this.mForumAdapter.currentForum.isSubOnly())) {
                this.textView.setText(getActivity().getResources().getString(2131100585) + "\"" + this.mForumAdapter.currentForum.getName() + "\"");
                return;
            }
            this.textView.setVisibility(8);
            return;
        }
        if ((this.textView.getText().toString() != null) && (!this.textView.getText().toString().equals(""))) {
            this.textView.setVisibility(0);
            return;
        }
        this.textView.setVisibility(8);
    }

    public void updateForum(boolean paramBoolean) {
        if (this.mForumAdapter == null) {
            if ((this.forumStatus != null) && (this.groupTreeView != null)) {
                if (((this.mActivity instanceof ModerateActivity)) && (((ModerateActivity) this.mActivity).select_forum_action == 4)) {
                    this.groupTreeView.setLoadingMoreEnabled(true);
                }
                this.mForumAdapter = new ModerateAdapter(this.mActivity, this.groupTreeView, this.forumStatus);
                if (!(this.mActivity instanceof ModerateActivity)) {
                    break label148;
                }
                if (((ModerateActivity) this.mActivity).select_forum_action != 4) {
                    break label108;
                }
                this.mForumAdapter.updateTopicDatas();
            }
        }
        label108:
        label148:
        while ((!(this.mForumAdapter instanceof ModerateAdapter)) || (!paramBoolean)) {
            return;
            if (((ModerateActivity) this.mActivity).select_forum_action == 5) {
                this.mForumAdapter.updatePostDatas(((ModerateActivity) this.mActivity).postDatas);
                return;
            }
            this.mForumAdapter.updateForum();
            return;
            this.mForumAdapter.updateForum();
            return;
        }
        ((ForumActivityStatus) this.mActivity).showProgress();
        this.mForumAdapter.updateForum();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/activity/forum/moderation/ModerateFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */