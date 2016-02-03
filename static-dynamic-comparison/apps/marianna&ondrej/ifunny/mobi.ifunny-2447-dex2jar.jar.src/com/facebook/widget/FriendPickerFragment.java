package com.facebook.widget;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.facebook.AppEventsLogger;
import com.facebook.FacebookException;
import com.facebook.Request;
import com.facebook.Session;
import com.facebook.android.R.layout;
import com.facebook.android.R.string;
import com.facebook.android.R.styleable;
import com.facebook.model.GraphUser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class FriendPickerFragment
        extends PickerFragment<GraphUser> {
    public static final String FRIEND_PICKER_TYPE_KEY = "com.facebook.widget.FriendPickerFragment.FriendPickerType";
    private static final String ID = "id";
    public static final String MULTI_SELECT_BUNDLE_KEY = "com.facebook.widget.FriendPickerFragment.MultiSelect";
    private static final String NAME = "name";
    public static final String USER_ID_BUNDLE_KEY = "com.facebook.widget.FriendPickerFragment.UserId";
    private FriendPickerFragment.FriendPickerType friendPickerType = FriendPickerFragment.FriendPickerType.FRIENDS;
    private boolean multiSelect = true;
    private List<String> preSelectedFriendIds = new ArrayList();
    private String userId;

    public FriendPickerFragment() {
        this(null);
    }

    @SuppressLint({"ValidFragment"})
    public FriendPickerFragment(Bundle paramBundle) {
        super(GraphUser.class, R.layout.com_facebook_friendpickerfragment, paramBundle);
        setFriendPickerSettingsFromBundle(paramBundle);
    }

    private Request createRequest(String paramString, Set<String> paramSet, Session paramSession) {
        paramString = Request.newGraphPathRequest(paramSession, paramString + this.friendPickerType.getRequestPath(), null);
        paramSet = new HashSet(paramSet);
        paramSet.addAll(Arrays.asList(new String[]{"id", "name"}));
        paramSession = this.adapter.getPictureFieldSpecifier();
        if (paramSession != null) {
            paramSet.add(paramSession);
        }
        paramSession = paramString.getParameters();
        paramSession.putString("fields", TextUtils.join(",", paramSet));
        paramString.setParameters(paramSession);
        return paramString;
    }

    private void setFriendPickerSettingsFromBundle(Bundle paramBundle) {
        if (paramBundle != null) {
            if (paramBundle.containsKey("com.facebook.widget.FriendPickerFragment.UserId")) {
                setUserId(paramBundle.getString("com.facebook.widget.FriendPickerFragment.UserId"));
            }
            setMultiSelect(paramBundle.getBoolean("com.facebook.widget.FriendPickerFragment.MultiSelect", this.multiSelect));
            if (!paramBundle.containsKey("com.facebook.widget.FriendPickerFragment.FriendPickerType")) {
            }
        }
        try {
            this.friendPickerType = FriendPickerFragment.FriendPickerType.valueOf(paramBundle.getString("com.facebook.widget.FriendPickerFragment.FriendPickerType"));
            return;
        } catch (Exception paramBundle) {
        }
    }

    PickerFragment<GraphUser>.PickerFragmentAdapter<GraphUser> createAdapter() {
        FriendPickerFragment .1 local1 = new FriendPickerFragment .1 (this, getActivity());
        local1.setShowCheckbox(true);
        local1.setShowPicture(getShowPictures());
        local1.setSortFields(Arrays.asList(new String[]{"name"}));
        local1.setGroupByField("name");
        return local1;
    }

    PickerFragment<GraphUser>.LoadingStrategy createLoadingStrategy() {
        return new FriendPickerFragment.ImmediateLoadingStrategy(this, null);
    }

    PickerFragment<GraphUser>.SelectionStrategy createSelectionStrategy() {
        if (this.multiSelect) {
            return new PickerFragment.MultiSelectionStrategy(this);
        }
        return new PickerFragment.SingleSelectionStrategy(this);
    }

    String getDefaultTitleText() {
        return getString(R.string.com_facebook_choose_friends);
    }

    public boolean getMultiSelect() {
        return this.multiSelect;
    }

    Request getRequestForLoadData(Session paramSession) {
        if (this.adapter == null) {
            throw new FacebookException("Can't issue requests until Fragment has been created.");
        }
        if (this.userId != null) {
        }
        for (String str = this.userId; ; str = "me") {
            return createRequest(str, this.extraFields, paramSession);
        }
    }

    public List<GraphUser> getSelection() {
        return getSelectedGraphObjects();
    }

    public String getUserId() {
        return this.userId;
    }

    public void loadData(boolean paramBoolean) {
        super.loadData(paramBoolean);
        setSelectedGraphObjects(this.preSelectedFriendIds);
    }

    void logAppEvents(boolean paramBoolean) {
        AppEventsLogger localAppEventsLogger = AppEventsLogger.newLogger(getActivity(), getSession());
        Bundle localBundle = new Bundle();
        if (paramBoolean) {
        }
        for (String str = "Completed"; ; str = "Unknown") {
            localBundle.putString("fb_dialog_outcome", str);
            localBundle.putInt("num_friends_picked", getSelection().size());
            localAppEventsLogger.logSdkEvent("fb_friend_picker_usage", null, localBundle);
            return;
        }
    }

    public void onInflate(Activity paramActivity, AttributeSet paramAttributeSet, Bundle paramBundle) {
        super.onInflate(paramActivity, paramAttributeSet, paramBundle);
        paramActivity = paramActivity.obtainStyledAttributes(paramAttributeSet, R.styleable.com_facebook_friend_picker_fragment);
        setMultiSelect(paramActivity.getBoolean(R.styleable.com_facebook_friend_picker_fragment_multi_select, this.multiSelect));
        paramActivity.recycle();
    }

    void saveSettingsToBundle(Bundle paramBundle) {
        super.saveSettingsToBundle(paramBundle);
        paramBundle.putString("com.facebook.widget.FriendPickerFragment.UserId", this.userId);
        paramBundle.putBoolean("com.facebook.widget.FriendPickerFragment.MultiSelect", this.multiSelect);
    }

    public void setFriendPickerType(FriendPickerFragment.FriendPickerType paramFriendPickerType) {
        this.friendPickerType = paramFriendPickerType;
    }

    public void setMultiSelect(boolean paramBoolean) {
        if (this.multiSelect != paramBoolean) {
            this.multiSelect = paramBoolean;
            setSelectionStrategy(createSelectionStrategy());
        }
    }

    public void setSelection(List<GraphUser> paramList) {
        ArrayList localArrayList = new ArrayList();
        paramList = paramList.iterator();
        while (paramList.hasNext()) {
            localArrayList.add(((GraphUser) paramList.next()).getId());
        }
        setSelectionByIds(localArrayList);
    }

    public void setSelection(GraphUser... paramVarArgs) {
        setSelection(Arrays.asList(paramVarArgs));
    }

    public void setSelectionByIds(List<String> paramList) {
        this.preSelectedFriendIds.addAll(paramList);
    }

    public void setSelectionByIds(String... paramVarArgs) {
        setSelectionByIds(Arrays.asList(paramVarArgs));
    }

    public void setSettingsFromBundle(Bundle paramBundle) {
        super.setSettingsFromBundle(paramBundle);
        setFriendPickerSettingsFromBundle(paramBundle);
    }

    public void setUserId(String paramString) {
        this.userId = paramString;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/widget/FriendPickerFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */