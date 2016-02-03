package com.quoord.tapatalkpro.activity.forum;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.quoord.tapatalkpro.adapter.forum.moderation.ModerateAdapter;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.ui.ics.QuoordFragment;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tapatalkpro.view.SectionTitleListView;

import java.util.HashMap;

public class CategoriesFragment
        extends QuoordFragment {
    private ForumStatus forumStatus;
    private SectionTitleListView groupTreeView;
    private ImageView imgView = null;
    public Intent intent;
    private boolean isSortByName = false;
    private View layout = null;
    private Activity mActivity;
    public ModerateAdapter mForumAdapter = null;
    private Handler mUIhandler = new Handler() {
        public void handleMessage(Message paramAnonymousMessage) {
            if (paramAnonymousMessage.what == 14) {
                if (CategoriesFragment.this.mForumAdapter != null) {
                    CategoriesFragment.this.mForumAdapter.notifyDataSetChanged();
                }
            }
            while (13 != paramAnonymousMessage.what) {
                return;
            }
            try {
                paramAnonymousMessage = (String) ((HashMap) paramAnonymousMessage.obj).get("errormessage");
                Toast.makeText(CategoriesFragment.this.mActivity, CategoriesFragment.this.mActivity.getString(2131100071), 1).show();
                ((ForumActivityStatus) CategoriesFragment.this.mActivity).closeProgress();
                return;
            } catch (Exception paramAnonymousMessage) {
                ((ForumActivityStatus) CategoriesFragment.this.mActivity).closeProgress();
            }
        }
    };
    private LinearLayout quick_lay;
    public EditText textView = null;

    public static CategoriesFragment newInstance(ForumStatus paramForumStatus) {
        CategoriesFragment localCategoriesFragment = new CategoriesFragment();
        localCategoriesFragment.forumStatus = paramForumStatus;
        return localCategoriesFragment;
    }

    private void updateForum(boolean paramBoolean) {
        if (this.mForumAdapter == null) {
            ((ForumActivityStatus) this.mActivity).showProgress();
            if (this.forumStatus != null) {
                this.mForumAdapter = new ModerateAdapter(this.mActivity, this.groupTreeView, this.forumStatus);
                this.mForumAdapter.updateForum();
            }
        }
        while ((!(this.mForumAdapter instanceof ModerateAdapter)) || (!paramBoolean)) {
            return;
        }
        ((ForumActivityStatus) this.mActivity).showProgress();
        this.mForumAdapter.updateForum();
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        this.mActivity = getActivity();
        this.groupTreeView.setGroupIndicator(null);
        this.groupTreeView.setSelector(2131165212);
        updateForum(false);
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        this.layout = paramLayoutInflater.inflate(2130903089, null);
        this.groupTreeView = ((SectionTitleListView) this.layout.findViewById(2131230909));
        this.intent = getActivity().getIntent();
        this.textView = ((EditText) this.layout.findViewById(2131230841));
        this.quick_lay = ((LinearLayout) this.layout.findViewById(2131230840));
        this.imgView = ((ImageView) this.layout.findViewById(2131230843));
        this.imgView.setImageResource(ThemeUtil.getDrawableIdByPicName("menu_send", getActivity()));
        this.quick_lay.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("thread_bottom_background", getActivity()));
        this.imgView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                if ((CategoriesFragment.this.mForumAdapter.getTargetForumName() != null) && (!CategoriesFragment.this.mForumAdapter.getTargetForumName().equals(""))) {
                    paramAnonymousView = new Bundle();
                    paramAnonymousView.putString("forum_name", CategoriesFragment.this.mForumAdapter.getTargetForumName());
                    paramAnonymousView.putString("forum_id", CategoriesFragment.this.mForumAdapter.getTargetForumName());
                    CategoriesFragment.this.intent.putExtras(paramAnonymousView);
                    CategoriesFragment.this.getActivity().setResult(-1, CategoriesFragment.this.intent);
                    CategoriesFragment.this.getActivity().finish();
                    return;
                }
                Toast.makeText(CategoriesFragment.this.mActivity, CategoriesFragment.this.mActivity.getResources().getString(2131100550), 1).show();
            }
        });
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
        this.mActivity.finish();
        return true;
    }

    public void onPrepareOptionsMenu(Menu paramMenu) {
        super.onPrepareOptionsMenu(paramMenu);
        paramMenu.removeGroup(0);
        if (!this.isSortByName) {
            paramMenu.add(0, 1005, 1, getString(2131099876)).setIcon(ThemeUtil.getMenuIconByPicName("menu_forum_by_name", getActivity())).setShowAsAction(2);
            return;
        }
        paramMenu.add(0, 1006, 1, getString(2131099875)).setIcon(ThemeUtil.getMenuIconByPicName("menu_forum_by_category", getActivity())).setShowAsAction(2);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/activity/forum/CategoriesFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */