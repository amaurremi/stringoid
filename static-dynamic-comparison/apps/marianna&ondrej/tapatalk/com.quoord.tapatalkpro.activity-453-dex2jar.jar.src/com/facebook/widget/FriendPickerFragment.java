package com.facebook.widget;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.facebook.FacebookException;
import com.facebook.Request;
import com.facebook.Session;
import com.facebook.android.R.drawable;
import com.facebook.android.R.layout;
import com.facebook.android.R.string;
import com.facebook.android.R.styleable;
import com.facebook.model.GraphUser;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SuppressLint({"ValidFragment"})
public class FriendPickerFragment
        extends PickerFragment<GraphUser> {
    private static final String ID = "id";
    public static final String MULTI_SELECT_BUNDLE_KEY = "com.facebook.widget.FriendPickerFragment.MultiSelect";
    private static final String NAME = "name";
    public static final String USER_ID_BUNDLE_KEY = "com.facebook.widget.FriendPickerFragment.UserId";
    private boolean multiSelect = true;
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
        paramString = Request.newGraphPathRequest(paramSession, paramString + "/friends", null);
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
        }
    }

    PickerFragment<GraphUser>.PickerFragmentAdapter<GraphUser> createAdapter() {
        PickerFragment.PickerFragmentAdapter local1 = new PickerFragment.PickerFragmentAdapter(this, getActivity()) {
            protected int getDefaultPicture() {
                return R.drawable.com_facebook_profile_default_icon;
            }

            protected int getGraphObjectRowLayoutId(GraphUser paramAnonymousGraphUser) {
                return R.layout.com_facebook_picker_list_row;
            }
        };
        local1.setShowCheckbox(true);
        local1.setShowPicture(getShowPictures());
        local1.setSortFields(Arrays.asList(new String[]{"name"}));
        local1.setGroupByField("name");
        return local1;
    }

    PickerFragment<GraphUser>.LoadingStrategy createLoadingStrategy() {
        return new ImmediateLoadingStrategy(null);
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

    public void onInflate(Activity paramActivity, AttributeSet paramAttributeSet, Bundle paramBundle) {
        super.onInflate(paramActivity, paramAttributeSet, paramBundle);
        paramActivity = paramActivity.obtainStyledAttributes(paramAttributeSet, R.styleable.com_facebook_friend_picker_fragment);
        setMultiSelect(paramActivity.getBoolean(0, this.multiSelect));
        paramActivity.recycle();
    }

    void saveSettingsToBundle(Bundle paramBundle) {
        super.saveSettingsToBundle(paramBundle);
        paramBundle.putString("com.facebook.widget.FriendPickerFragment.UserId", this.userId);
        paramBundle.putBoolean("com.facebook.widget.FriendPickerFragment.MultiSelect", this.multiSelect);
    }

    public void setMultiSelect(boolean paramBoolean) {
        if (this.multiSelect != paramBoolean) {
            this.multiSelect = paramBoolean;
            setSelectionStrategy(createSelectionStrategy());
        }
    }

    public void setSettingsFromBundle(Bundle paramBundle) {
        super.setSettingsFromBundle(paramBundle);
        setFriendPickerSettingsFromBundle(paramBundle);
    }

    public void setUserId(String paramString) {
        this.userId = paramString;
    }

    private class ImmediateLoadingStrategy
            extends PickerFragment<GraphUser>.LoadingStrategy {
        private ImmediateLoadingStrategy() {
            super();
        }

        private void followNextLink() {
            FriendPickerFragment.this.displayActivityCircle();
            this.loader.followNextLink();
        }

        protected void onLoadFinished(GraphObjectPagingLoader<GraphUser> paramGraphObjectPagingLoader, SimpleGraphObjectCursor<GraphUser> paramSimpleGraphObjectCursor) {
            super.onLoadFinished(paramGraphObjectPagingLoader, paramSimpleGraphObjectCursor);
            if ((paramSimpleGraphObjectCursor == null) || (paramGraphObjectPagingLoader.isLoading())) {
            }
            do {
                return;
                if (paramSimpleGraphObjectCursor.areMoreObjectsAvailable()) {
                    followNextLink();
                    return;
                }
                FriendPickerFragment.this.hideActivityCircle();
            } while (!paramSimpleGraphObjectCursor.isFromCache());
            if (paramSimpleGraphObjectCursor.getCount() == 0) {
            }
            for (int i = 2000; ; i = 0) {
                paramGraphObjectPagingLoader.refreshOriginalRequest(i);
                return;
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/facebook/widget/FriendPickerFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */