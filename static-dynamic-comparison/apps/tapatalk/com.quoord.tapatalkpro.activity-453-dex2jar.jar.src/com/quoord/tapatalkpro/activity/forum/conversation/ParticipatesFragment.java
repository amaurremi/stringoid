package com.quoord.tapatalkpro.activity.forum.conversation;

import android.app.ActionBar;
import android.app.ProgressDialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import com.quoord.tapatalkpro.action.ConvDeleteAction;
import com.quoord.tapatalkpro.adapter.forum.conversation.ParticipatesAdapter;
import com.quoord.tapatalkpro.bean.Conversation;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.ui.ics.QuoordFragment;
import com.quoord.tapatalkpro.util.ThemeUtil;

import java.util.HashMap;
import java.util.Stack;

public class ParticipatesFragment
        extends QuoordFragment {
    public static final int MENU_INVITE = 0;
    public ParticipatesAdapter adapter = null;
    private ActionBar bar = null;
    private TextView button = null;
    public boolean can_upload;
    private Conversation conv;
    private ForumStatus forumStatus;
    private ListView listView = null;
    private ProgressDialog progress = null;
    private String title = null;

    public static ParticipatesFragment newInstance() {
        return new ParticipatesFragment();
    }

    public void getParticipates() {
        if (((ParticipatesActivity) getActivity()).raw_parts != null) {
            this.adapter = new ParticipatesAdapter(getActivity(), this.forumStatus, this.listView, ((ParticipatesActivity) getActivity()).raw_parts);
        }
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        this.title = getActivity().getResources().getString(2131100188);
        this.bar = getActivity().getActionBar();
        this.bar.setDisplayHomeAsUpEnabled(true);
        this.bar.setDisplayShowTitleEnabled(true);
        this.forumStatus = ((ParticipatesActivity) getActivity()).forumStatus;
        this.conv = ((ParticipatesActivity) getActivity()).conv;
        this.can_upload = ((ParticipatesActivity) getActivity()).can_upload;
        this.progress = new ProgressDialog(getActivity());
        this.progress.setMessage(getActivity().getResources().getString(2131099873));
        onClick();
        if (((ParticipatesActivity) getActivity()).raw_parts != null) {
            this.bar.setTitle(((ParticipatesActivity) getActivity()).raw_parts.size() + " " + this.title);
        }
        getParticipates();
        getActivity().invalidateOptionsMenu();
    }

    public void onClick() {
        this.button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                new ConvDeleteAction(ParticipatesFragment.this.getActivity(), ParticipatesFragment.this.forumStatus, ParticipatesFragment.this.conv, null);
            }
        });
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramLayoutInflater = paramLayoutInflater.inflate(2130903196, null);
        this.listView = ((ListView) paramLayoutInflater.findViewById(2131231199));
        this.listView.setDivider(null);
        this.listView.setSelector(2131165212);
        this.button = ((TextView) paramLayoutInflater.findViewById(2131231200));
        return paramLayoutInflater;
    }

    public void onHiddenChanged(boolean paramBoolean) {
        super.onHiddenChanged(paramBoolean);
        if ((!paramBoolean) && (this.adapter != null)) {
            this.bar.setTitle(this.adapter.getCount() + " " + this.title);
        }
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
            default:
                return super.onOptionsItemSelected(paramMenuItem);
            case 0:
                paramMenuItem = ConversationInviteFragment.newInstance(this.adapter);
                ((ParticipatesActivity) getActivity()).addFragmentToStack(paramMenuItem, true);
                return true;
        }
        if (((ParticipatesActivity) getActivity()).participateStack.size() > 1) {
            ((ParticipatesActivity) getActivity()).participateStack.pop();
            paramMenuItem = (QuoordFragment) ((ParticipatesActivity) getActivity()).participateStack.peek();
            ((ParticipatesActivity) getActivity()).showToFront(paramMenuItem, false);
        }
        for (; ; ) {
            return true;
            getActivity().finish();
        }
    }

    public void onPrepareOptionsMenu(Menu paramMenu) {
        paramMenu.removeGroup(0);
        if (((ParticipatesActivity) getActivity()).can_invite) {
            paramMenu = paramMenu.add(0, 0, 0, getString(2131100173));
            paramMenu.setIcon(ThemeUtil.getMenuIconByPicName("invite", getActivity()));
            paramMenu.setShowAsAction(2);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/activity/forum/conversation/ParticipatesFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */