package com.quoord.tapatalkpro.ics.slidingMenu;

import android.app.ActionBar;
import android.app.ActionBar.OnNavigationListener;
import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.quoord.tapatalkpro.adapter.forum.conversation.PmTitleAdapter;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.ics.BaseListFragment;
import com.quoord.tapatalkpro.ui.ics.IQuoordInterface;
import com.quoord.tapatalkpro.ui.ics.QuoordFragment;
import com.quoord.tools.TwoPanelController;

import java.util.ArrayList;
import java.util.HashMap;

public class ModerationFragment
        extends BaseListFragment
        implements TwoPanelController {
    private ActionBar bar;
    public IQuoordInterface currentFragment = null;
    public int currentPosition;
    private String deletePost;
    private String deleteTopic;
    private ForumStatus forumStatus;
    public HashMap<Integer, IQuoordInterface> fragmentMap = new HashMap();
    private String moderatePost;
    private String moderateTopic;
    private String reportTopic;

    public static ModerationFragment newInstance() {
        return new ModerationFragment();
    }

    public BaseAdapter getAdapter() {
        return null;
    }

    public void initDropDown() {
        final ArrayList localArrayList = new ArrayList();
        if (this.forumStatus.isModApprove()) {
            localArrayList.add(this.moderateTopic);
            localArrayList.add(this.moderatePost);
        }
        if (this.forumStatus.isModDelete()) {
            localArrayList.add(this.deleteTopic);
            localArrayList.add(this.deletePost);
        }
        if (this.forumStatus.isModReport()) {
            localArrayList.add(this.reportTopic);
        }
        this.bar.setListNavigationCallbacks(new PmTitleAdapter(getActivity(), localArrayList), new ActionBar.OnNavigationListener() {
            public boolean onNavigationItemSelected(int paramAnonymousInt, long paramAnonymousLong) {
                if (((String) localArrayList.get(paramAnonymousInt)).equals(ModerationFragment.this.moderateTopic)) {
                    ModerationFragment.this.showFragment(1043, paramAnonymousInt);
                }
                for (; ; ) {
                    return true;
                    if (((String) localArrayList.get(paramAnonymousInt)).equals(ModerationFragment.this.moderatePost)) {
                        ModerationFragment.this.showFragment(1039, paramAnonymousInt);
                    } else if (((String) localArrayList.get(paramAnonymousInt)).equals(ModerationFragment.this.deleteTopic)) {
                        ModerationFragment.this.showFragment(1040, paramAnonymousInt);
                    } else if (((String) localArrayList.get(paramAnonymousInt)).equals(ModerationFragment.this.deletePost)) {
                        ModerationFragment.this.showFragment(1041, paramAnonymousInt);
                    } else if (((String) localArrayList.get(paramAnonymousInt)).equals(ModerationFragment.this.reportTopic)) {
                        ModerationFragment.this.showFragment(1042, paramAnonymousInt);
                    }
                }
            }
        });
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        this.mActivity = getActivity();
        this.bar = getActivity().getActionBar();
        this.bar.setDisplayHomeAsUpEnabled(true);
        this.bar.setDisplayShowTitleEnabled(false);
        this.bar.setNavigationMode(1);
        this.forumStatus = ((SlidingMenuActivity) this.mActivity).forumStatus;
        this.moderateTopic = this.mActivity.getResources().getString(2131100040);
        this.moderatePost = this.mActivity.getResources().getString(2131100041);
        this.deleteTopic = this.mActivity.getResources().getString(2131100042);
        this.deletePost = this.mActivity.getResources().getString(2131100043);
        this.reportTopic = this.mActivity.getResources().getString(2131100044);
        initDropDown();
        this.bar.setSelectedNavigationItem(this.currentPosition);
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        return paramLayoutInflater.inflate(2130903273, paramViewGroup, false);
    }

    public void onHiddenChanged(boolean paramBoolean) {
        super.onHiddenChanged(paramBoolean);
        if (!paramBoolean) {
            initDropDown();
            setDropDownListTitle();
        }
        while (this.currentFragment == null) {
            return;
        }
        FragmentTransaction localFragmentTransaction = getChildFragmentManager().beginTransaction();
        localFragmentTransaction.hide((QuoordFragment) this.currentFragment);
        localFragmentTransaction.commit();
    }

    public void setActionBar(Activity paramActivity) {
        if (this.bar == null) {
            this.bar = paramActivity.getActionBar();
        }
        setDropDownListTitle();
        initDropDown();
        this.bar.setSelectedNavigationItem(this.currentPosition);
    }

    public void setDropDownListTitle() {
        this.bar.setDisplayShowTitleEnabled(false);
        this.bar.setNavigationMode(1);
    }

    public void showFragment(int paramInt1, int paramInt2) {
        switch (paramInt1) {
            default:
                return;
            case 1043:
                if (this.fragmentMap.containsKey(Integer.valueOf(1043))) {
                    showToFront((IQuoordInterface) this.fragmentMap.get(Integer.valueOf(1043)), paramInt2, false);
                    return;
                }
                localObject = ModerationTopicFragment.newInstance();
                this.fragmentMap.put(Integer.valueOf(1043), localObject);
                showToFront((IQuoordInterface) localObject, paramInt2, true);
                return;
            case 1039:
                if (this.fragmentMap.containsKey(Integer.valueOf(1039))) {
                    showToFront((IQuoordInterface) this.fragmentMap.get(Integer.valueOf(1039)), paramInt2, false);
                    return;
                }
                localObject = ModerationPostFragment.newInstance();
                this.fragmentMap.put(Integer.valueOf(1039), localObject);
                showToFront((IQuoordInterface) localObject, paramInt2, true);
                return;
            case 1040:
                if (this.fragmentMap.containsKey(Integer.valueOf(1040))) {
                    showToFront((IQuoordInterface) this.fragmentMap.get(Integer.valueOf(1040)), paramInt2, false);
                    return;
                }
                localObject = DeleteTopicFragment.newInstance();
                this.fragmentMap.put(Integer.valueOf(1040), localObject);
                showToFront((IQuoordInterface) localObject, paramInt2, true);
                return;
            case 1041:
                if (this.fragmentMap.containsKey(Integer.valueOf(1041))) {
                    showToFront((IQuoordInterface) this.fragmentMap.get(Integer.valueOf(1041)), paramInt2, false);
                    return;
                }
                localObject = DeletePostFragment.newInstance();
                this.fragmentMap.put(Integer.valueOf(1041), localObject);
                showToFront((IQuoordInterface) localObject, paramInt2, true);
                return;
        }
        if (this.fragmentMap.containsKey(Integer.valueOf(1042))) {
            showToFront((IQuoordInterface) this.fragmentMap.get(Integer.valueOf(1042)), paramInt2, false);
            return;
        }
        Object localObject = ReportTopicFragment.newInstance();
        this.fragmentMap.put(Integer.valueOf(1042), localObject);
        showToFront((IQuoordInterface) localObject, paramInt2, true);
    }

    public void showToFront(IQuoordInterface paramIQuoordInterface, int paramInt, boolean paramBoolean) {
        FragmentTransaction localFragmentTransaction = getChildFragmentManager().beginTransaction();
        if (this.currentFragment == null) {
            localFragmentTransaction.add(2131230953, (QuoordFragment) paramIQuoordInterface, String.valueOf(paramIQuoordInterface.hashCode()));
        }
        for (; ; ) {
            this.currentFragment = paramIQuoordInterface;
            this.currentPosition = paramInt;
            localFragmentTransaction.commit();
            return;
            if ((QuoordFragment) getChildFragmentManager().findFragmentByTag(String.valueOf(paramIQuoordInterface.hashCode())) != null) {
                localFragmentTransaction.hide((QuoordFragment) this.currentFragment);
                localFragmentTransaction.show((QuoordFragment) paramIQuoordInterface);
            } else {
                localFragmentTransaction.add(2131230953, (QuoordFragment) paramIQuoordInterface, String.valueOf(paramIQuoordInterface.hashCode()));
                localFragmentTransaction.hide((QuoordFragment) this.currentFragment);
                localFragmentTransaction.show((QuoordFragment) paramIQuoordInterface);
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ics/slidingMenu/ModerationFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */