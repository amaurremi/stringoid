package android.support.v4.preference;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.support.v4.app.Fragment;
import android.support.v4.preferencefragment.R.layout;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.widget.ListView;

public abstract class PreferenceFragment
        extends Fragment
        implements PreferenceManagerCompat.OnPreferenceTreeClickListener {
    private static final int FIRST_REQUEST_CODE = 100;
    private static final int MSG_BIND_PREFERENCES = 1;
    private static final String PREFERENCES_TAG = "android:preferences";
    private Handler mHandler = new Handler() {
        public void handleMessage(Message paramAnonymousMessage) {
            switch (paramAnonymousMessage.what) {
                default:
                    return;
            }
            PreferenceFragment.this.bindPreferences();
        }
    };
    private boolean mHavePrefs;
    private boolean mInitDone;
    private ListView mList;
    private View.OnKeyListener mListOnKeyListener = new View.OnKeyListener() {
        public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent) {
            if ((PreferenceFragment.this.mList.getSelectedItem() instanceof Preference)) {
                PreferenceFragment.this.mList.getSelectedView();
            }
            return false;
        }
    };
    private PreferenceManager mPreferenceManager;
    private final Runnable mRequestFocus = new Runnable() {
        public void run() {
            PreferenceFragment.this.mList.focusableViewAvailable(PreferenceFragment.this.mList);
        }
    };

    private void bindPreferences() {
        PreferenceScreen localPreferenceScreen = getPreferenceScreen();
        if (localPreferenceScreen != null) {
            localPreferenceScreen.bind(getListView());
        }
    }

    private void ensureList() {
        if (this.mList != null) {
            return;
        }
        View localView = getView();
        if (localView == null) {
            throw new IllegalStateException("Content view not yet created");
        }
        localView = localView.findViewById(16908298);
        if (!(localView instanceof ListView)) {
            throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
        }
        this.mList = ((ListView) localView);
        if (this.mList == null) {
            throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
        }
        this.mList.setOnKeyListener(this.mListOnKeyListener);
        this.mHandler.post(this.mRequestFocus);
    }

    private void postBindPreferences() {
        if (this.mHandler.hasMessages(1)) {
            return;
        }
        this.mHandler.obtainMessage(1).sendToTarget();
    }

    private void requirePreferenceManager() {
        if (this.mPreferenceManager == null) {
            throw new RuntimeException("This should be called after super.onCreate.");
        }
    }

    public void addPreferencesFromIntent(Intent paramIntent) {
        requirePreferenceManager();
        setPreferenceScreen(PreferenceManagerCompat.inflateFromIntent(this.mPreferenceManager, paramIntent, getPreferenceScreen()));
    }

    public void addPreferencesFromResource(int paramInt) {
        requirePreferenceManager();
        setPreferenceScreen(PreferenceManagerCompat.inflateFromResource(this.mPreferenceManager, getActivity(), paramInt, getPreferenceScreen()));
    }

    public Preference findPreference(CharSequence paramCharSequence) {
        if (this.mPreferenceManager == null) {
            return null;
        }
        return this.mPreferenceManager.findPreference(paramCharSequence);
    }

    public ListView getListView() {
        ensureList();
        return this.mList;
    }

    public PreferenceManager getPreferenceManager() {
        return this.mPreferenceManager;
    }

    public PreferenceScreen getPreferenceScreen() {
        return PreferenceManagerCompat.getPreferenceScreen(this.mPreferenceManager);
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        if (this.mHavePrefs) {
            bindPreferences();
        }
        this.mInitDone = true;
        if (paramBundle != null) {
            paramBundle = paramBundle.getBundle("android:preferences");
            if (paramBundle != null) {
                PreferenceScreen localPreferenceScreen = getPreferenceScreen();
                if (localPreferenceScreen != null) {
                    localPreferenceScreen.restoreHierarchyState(paramBundle);
                }
            }
        }
    }

    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
        PreferenceManagerCompat.dispatchActivityResult(this.mPreferenceManager, paramInt1, paramInt2, paramIntent);
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        this.mPreferenceManager = PreferenceManagerCompat.newInstance(getActivity(), 100);
        PreferenceManagerCompat.setFragment(this.mPreferenceManager, this);
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        return paramLayoutInflater.inflate(R.layout.preference_list_fragment, paramViewGroup, false);
    }

    public void onDestroy() {
        super.onDestroy();
        PreferenceManagerCompat.dispatchActivityDestroy(this.mPreferenceManager);
    }

    public void onDestroyView() {
        this.mList = null;
        this.mHandler.removeCallbacks(this.mRequestFocus);
        this.mHandler.removeMessages(1);
        super.onDestroyView();
    }

    public boolean onPreferenceTreeClick(PreferenceScreen paramPreferenceScreen, Preference paramPreference) {
        if ((getActivity() instanceof OnPreferenceStartFragmentCallback)) {
            return ((OnPreferenceStartFragmentCallback) getActivity()).onPreferenceStartFragment(this, paramPreference);
        }
        return false;
    }

    public void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        PreferenceScreen localPreferenceScreen = getPreferenceScreen();
        if (localPreferenceScreen != null) {
            Bundle localBundle = new Bundle();
            localPreferenceScreen.saveHierarchyState(localBundle);
            paramBundle.putBundle("android:preferences", localBundle);
        }
    }

    public void onStart() {
        super.onStart();
        PreferenceManagerCompat.setOnPreferenceTreeClickListener(this.mPreferenceManager, this);
    }

    public void onStop() {
        super.onStop();
        PreferenceManagerCompat.dispatchActivityStop(this.mPreferenceManager);
        PreferenceManagerCompat.setOnPreferenceTreeClickListener(this.mPreferenceManager, null);
    }

    public void setPreferenceScreen(PreferenceScreen paramPreferenceScreen) {
        if ((PreferenceManagerCompat.setPreferences(this.mPreferenceManager, paramPreferenceScreen)) && (paramPreferenceScreen != null)) {
            this.mHavePrefs = true;
            if (this.mInitDone) {
                postBindPreferences();
            }
        }
    }

    public static abstract interface OnPreferenceStartFragmentCallback {
        public abstract boolean onPreferenceStartFragment(PreferenceFragment paramPreferenceFragment, Preference paramPreference);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/android/support/v4/preference/PreferenceFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */