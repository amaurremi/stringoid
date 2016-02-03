package com.quoord.tapatalkpro.activity.forum.conversation;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SearchView.OnCloseListener;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.Toast;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.adapter.TryTwiceCallBackInterface;
import com.quoord.tapatalkpro.adapter.forum.conversation.ConversationInviteAdapter;
import com.quoord.tapatalkpro.adapter.forum.conversation.ParticipatesAdapter;
import com.quoord.tapatalkpro.bean.Conversation;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.ui.ics.QuoordFragment;
import com.quoord.tapatalkpro.util.CustomTracker;
import com.quoord.tapatalkpro.util.TapatalkEngine;
import com.quoord.tapatalkpro.util.ThemeUtil;

import java.util.ArrayList;
import java.util.Stack;

public class ConversationInviteFragment
        extends QuoordFragment
        implements ForumActivityStatus, SearchView.OnQueryTextListener, SearchView.OnCloseListener, TryTwiceCallBackInterface {
    private ActionBar bar;
    private Conversation conv;
    private ConversationInviteAdapter conversationInviteAdapter;
    protected TapatalkEngine engine = null;
    private ForumStatus forumStatus;
    private ListView listview;
    private SearchView mSearchView;
    private ParticipatesAdapter participatesAdapter;
    private ProgressDialog progress = null;
    private String query = null;
    private Button submitButton;
    private boolean tryTwice = false;

    public static ConversationInviteFragment newInstance(ParticipatesAdapter paramParticipatesAdapter) {
        ConversationInviteFragment localConversationInviteFragment = new ConversationInviteFragment();
        localConversationInviteFragment.participatesAdapter = paramParticipatesAdapter;
        return localConversationInviteFragment;
    }

    private void setupSearchView() {
        this.mSearchView.setOnQueryTextListener(this);
        this.mSearchView.setOnCloseListener(this);
    }

    public void addSubmitButtonEvent() {
        this.submitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                ConversationInviteFragment.this.submit();
                ConversationInviteFragment.this.submitButton.setEnabled(false);
            }
        });
    }

    public void callBack(EngineResponse paramEngineResponse) {
        int i;
        if (paramEngineResponse.getMethod().equals("invite_participant")) {
            this.submitButton.setEnabled(true);
            if (!paramEngineResponse.isSuccess()) {
                break label259;
            }
            paramEngineResponse = "";
            i = 0;
            if (i < this.conversationInviteAdapter.userNameList.size()) {
                break label190;
            }
            Toast.makeText(getActivity(), getActivity().getString(2131100171) + " " + paramEngineResponse, 1).show();
            if ((getActivity() instanceof ParticipatesActivity)) {
                ((ParticipatesActivity) getActivity()).participateStack.pop();
                paramEngineResponse = (QuoordFragment) ((ParticipatesActivity) getActivity()).participateStack.peek();
                ((ParticipatesActivity) getActivity()).showToFront(paramEngineResponse, false);
            }
            this.participatesAdapter.notifyDataSetChanged();
            paramEngineResponse = getActivity();
            getActivity();
            ((InputMethodManager) paramEngineResponse.getSystemService("input_method")).hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 2);
        }
        for (; ; ) {
            this.progress.dismiss();
            return;
            label190:
            if (paramEngineResponse.length() == 0) {
            }
            for (paramEngineResponse = (String) this.conversationInviteAdapter.userNameList.get(i); ; paramEngineResponse = paramEngineResponse + "; " + (String) this.conversationInviteAdapter.userNameList.get(i)) {
                i += 1;
                break;
            }
            label259:
            paramEngineResponse = paramEngineResponse.getErrorMessage();
            Toast.makeText(getActivity(), new String(paramEngineResponse), 1).show();
        }
    }

    public void closeProgress() {
    }

    public Activity getDefaultActivity() {
        return getActivity();
    }

    public ForumActivityStatus getForumActivityStatus() {
        return this;
    }

    public ForumStatus getForumStatus() {
        return this.forumStatus;
    }

    public ForumStatus getForumStatus(TapatalkForum paramTapatalkForum) {
        return null;
    }

    public boolean getSaxCall() {
        return false;
    }

    public boolean getTryTwice() {
        return this.tryTwice;
    }

    public boolean isOpCancel() {
        return false;
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        this.bar = getActivity().getActionBar();
        this.bar.setDisplayHomeAsUpEnabled(true);
        this.bar.setDisplayShowTitleEnabled(true);
        this.bar.setTitle(getActivity().getResources().getString(2131100173));
        this.forumStatus = ((ParticipatesActivity) getActivity()).forumStatus;
        this.conv = ((ParticipatesActivity) getActivity()).conv;
        if (this.forumStatus != null) {
            this.engine = new TapatalkEngine(this, this.forumStatus, getActivity());
            this.conversationInviteAdapter = new ConversationInviteAdapter(getActivity(), this.forumStatus.getUrl(), this.conv, this.listview, this.submitButton, this.participatesAdapter);
            ThemeUtil.setListViewStyle(this.listview, getActivity());
            this.listview.setAdapter(this.conversationInviteAdapter);
        }
        this.progress = new ProgressDialog(getActivity());
        this.progress.setMessage(getActivity().getResources().getString(2131099873));
        addSubmitButtonEvent();
        getActivity().invalidateOptionsMenu();
    }

    public boolean onClose() {
        return false;
    }

    public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater) {
        super.onCreateOptionsMenu(paramMenu, paramMenuInflater);
        paramMenuInflater.inflate(2131623937, paramMenu);
        this.mSearchView = ((SearchView) paramMenu.findItem(2131231753).getActionView());
        this.mSearchView.setFocusable(true);
        int i = getResources().getIdentifier("android:id/search_plate", null, null);
        ((ViewGroup) this.mSearchView.findViewById(i)).setBackgroundResource(2130839292);
        setupSearchView();
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramLayoutInflater = paramLayoutInflater.inflate(2130903116, null);
        this.listview = ((ListView) paramLayoutInflater.findViewById(2131230959));
        this.submitButton = ((Button) paramLayoutInflater.findViewById(2131230960));
        this.submitButton.setEnabled(false);
        return paramLayoutInflater;
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
            default:
                return super.onOptionsItemSelected(paramMenuItem);
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

    public boolean onQueryTextChange(String paramString) {
        this.query = paramString.toString();
        this.conversationInviteAdapter.allDatas = this.conversationInviteAdapter.mDatas;
        this.conversationInviteAdapter.mDatas.clear();
        this.conversationInviteAdapter.allDatas.addAll(this.conversationInviteAdapter.userNameList);
        int i = 0;
        if (i >= this.conversationInviteAdapter.sourceDatas.size()) {
            if ((this.conversationInviteAdapter.UsermDatas == null) || (this.conversationInviteAdapter.UsermDatas.size() <= 0)) {
                break label201;
            }
        }
        label201:
        for (this.conversationInviteAdapter.mDatas = this.conversationInviteAdapter.UsermDatas; ; this.conversationInviteAdapter.mDatas = this.conversationInviteAdapter.allDatas) {
            this.conversationInviteAdapter.notifyDataSetChanged();
            return true;
            if ((((String) this.conversationInviteAdapter.sourceDatas.get(i)).toLowerCase().contains(this.query.toLowerCase())) && (!this.conversationInviteAdapter.userNameList.contains(((String) this.conversationInviteAdapter.sourceDatas.get(i)).toLowerCase()))) {
                this.conversationInviteAdapter.UsermDatas.add(this.conversationInviteAdapter.sourceDatas.get(i));
            }
            i += 1;
            break;
        }
    }

    public boolean onQueryTextSubmit(String paramString) {
        if ((this.conversationInviteAdapter.userNameList != null) && (!this.conversationInviteAdapter.userNameList.contains(this.query))) {
            this.conversationInviteAdapter.userNameList.add(this.query);
            if (!this.conversationInviteAdapter.mDatas.contains(this.query)) {
                this.conversationInviteAdapter.mDatas.add(this.query);
            }
        }
        if (this.conversationInviteAdapter.userNameList.size() > 0) {
            this.submitButton.setEnabled(true);
        }
        for (; ; ) {
            this.conversationInviteAdapter.notifyDataSetChanged();
            ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.mSearchView.getWindowToken(), 0);
            this.mSearchView.clearFocus();
            return true;
            this.submitButton.setEnabled(false);
        }
    }

    public void onStart() {
        super.onStart();
        CustomTracker.start(getActivity());
    }

    public void onStop() {
        super.onStop();
        CustomTracker.stop(getActivity());
    }

    public void setOpCancel(boolean paramBoolean) {
    }

    public void setSaxCall(boolean paramBoolean) {
    }

    public void setTryTwice(boolean paramBoolean) {
        this.tryTwice = paramBoolean;
    }

    public void showDialog(int paramInt) {
    }

    public void showProgress() {
    }

    public void showProgress(String paramString) {
    }

    public void submit() {
        setTryTwice(false);
        ArrayList localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        int i = 0;
        for (; ; ) {
            if (i >= this.conversationInviteAdapter.userNameList.size()) {
                localArrayList1.add(localArrayList2);
                localArrayList1.add(this.conv.getConv_id());
                this.engine.call("invite_participant", localArrayList1);
                this.progress.show();
                ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.mSearchView.getWindowToken(), 0);
                this.mSearchView.clearFocus();
                return;
            }
            localArrayList2.add(((String) this.conversationInviteAdapter.userNameList.get(i)).getBytes());
            i += 1;
        }
    }

    public void tryFailed(String paramString) {
    }

    public void updateDialog(int paramInt) {
    }

    public void updateSubclassDialog(int paramInt) {
    }

    public void updateUI(int paramInt, Object paramObject) {
    }

    public void updateUI(String paramString) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/activity/forum/conversation/ConversationInviteFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */