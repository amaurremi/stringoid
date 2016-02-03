package com.facebook.widget;

import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.Request;
import com.facebook.Session;
import com.facebook.android.R.id;
import com.facebook.android.R.string;
import com.facebook.android.R.styleable;
import com.facebook.internal.SessionTracker;
import com.facebook.model.GraphObject;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public abstract class PickerFragment<T extends GraphObject>
        extends Fragment {
    private static final String ACTIVITY_CIRCLE_SHOW_KEY = "com.facebook.android.PickerFragment.ActivityCircleShown";
    public static final String DONE_BUTTON_TEXT_BUNDLE_KEY = "com.facebook.widget.PickerFragment.DoneButtonText";
    public static final String EXTRA_FIELDS_BUNDLE_KEY = "com.facebook.widget.PickerFragment.ExtraFields";
    private static final int PROFILE_PICTURE_PREFETCH_BUFFER = 5;
    private static final String SELECTION_BUNDLE_KEY = "com.facebook.android.PickerFragment.Selection";
    public static final String SHOW_PICTURES_BUNDLE_KEY = "com.facebook.widget.PickerFragment.ShowPictures";
    public static final String SHOW_TITLE_BAR_BUNDLE_KEY = "com.facebook.widget.PickerFragment.ShowTitleBar";
    public static final String TITLE_TEXT_BUNDLE_KEY = "com.facebook.widget.PickerFragment.TitleText";
    private ProgressBar activityCircle;
    GraphObjectAdapter<T> adapter;
    private boolean appEventsLogged;
    private Button doneButton;
    private Drawable doneButtonBackground;
    private String doneButtonText;
    HashSet<String> extraFields = new HashSet();
    private PickerFragment.GraphObjectFilter<T> filter;
    private final Class<T> graphObjectClass;
    private final int layout;
    private ListView listView;
    private PickerFragment<T>.LoadingStrategy loadingStrategy;
    private PickerFragment.OnDataChangedListener onDataChangedListener;
    private PickerFragment.OnDoneButtonClickedListener onDoneButtonClickedListener;
    private PickerFragment.OnErrorListener onErrorListener;
    private AbsListView.OnScrollListener onScrollListener = new PickerFragment
    .6(this);
    private PickerFragment.OnSelectionChangedListener onSelectionChangedListener;
    private PickerFragment<T>.SelectionStrategy selectionStrategy;
    private SessionTracker sessionTracker;
    private boolean showPictures = true;
    private boolean showTitleBar = true;
    private Drawable titleBarBackground;
    private String titleText;
    private TextView titleTextView;

    PickerFragment(Class<T> paramClass, int paramInt, Bundle paramBundle) {
        this.graphObjectClass = paramClass;
        this.layout = paramInt;
        setPickerFragmentSettingsFromBundle(paramBundle);
    }

    private void clearResults() {
        int j = 1;
        int i;
        if (this.adapter != null) {
            if (this.selectionStrategy.isEmpty()) {
                break label95;
            }
            i = 1;
            if (this.adapter.isEmpty()) {
                break label100;
            }
        }
        for (; ; ) {
            this.loadingStrategy.clearResults();
            this.selectionStrategy.clear();
            this.adapter.notifyDataSetChanged();
            if ((j != 0) && (this.onDataChangedListener != null)) {
                this.onDataChangedListener.onDataChanged(this);
            }
            if ((i != 0) && (this.onSelectionChangedListener != null)) {
                this.onSelectionChangedListener.onSelectionChanged(this);
            }
            return;
            label95:
            i = 0;
            break;
            label100:
            j = 0;
        }
    }

    private void inflateTitleBar(ViewGroup paramViewGroup) {
        Object localObject = (ViewStub) paramViewGroup.findViewById(R.id.com_facebook_picker_title_bar_stub);
        if (localObject != null) {
            localObject = ((ViewStub) localObject).inflate();
            RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
            localLayoutParams.addRule(3, R.id.com_facebook_picker_title_bar);
            this.listView.setLayoutParams(localLayoutParams);
            if (this.titleBarBackground != null) {
                ((View) localObject).setBackgroundDrawable(this.titleBarBackground);
            }
            this.doneButton = ((Button) paramViewGroup.findViewById(R.id.com_facebook_picker_done_button));
            if (this.doneButton != null) {
                this.doneButton.setOnClickListener(new PickerFragment .5 (this));
                if (getDoneButtonText() != null) {
                    this.doneButton.setText(getDoneButtonText());
                }
                if (this.doneButtonBackground != null) {
                    this.doneButton.setBackgroundDrawable(this.doneButtonBackground);
                }
            }
            this.titleTextView = ((TextView) paramViewGroup.findViewById(R.id.com_facebook_picker_title));
            if ((this.titleTextView != null) && (getTitleText() != null)) {
                this.titleTextView.setText(getTitleText());
            }
        }
    }

    private void loadDataSkippingRoundTripIfCached() {
        clearResults();
        Request localRequest = getRequestForLoadData(getSession());
        if (localRequest != null) {
            onLoadingData();
            this.loadingStrategy.startLoading(localRequest);
        }
    }

    private void onListItemClick(ListView paramListView, View paramView, int paramInt) {
        paramListView = (GraphObject) paramListView.getItemAtPosition(paramInt);
        paramListView = this.adapter.getIdOfGraphObject(paramListView);
        this.selectionStrategy.toggleSelection(paramListView);
        this.adapter.notifyDataSetChanged();
        if (this.onSelectionChangedListener != null) {
            this.onSelectionChangedListener.onSelectionChanged(this);
        }
    }

    private void reprioritizeDownloads() {
        int i = this.listView.getLastVisiblePosition();
        if (i >= 0) {
            int j = this.listView.getFirstVisiblePosition();
            this.adapter.prioritizeViewRange(j, i, 5);
        }
    }

    private static void setAlpha(View paramView, float paramFloat) {
        AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramFloat, paramFloat);
        localAlphaAnimation.setDuration(0L);
        localAlphaAnimation.setFillAfter(true);
        paramView.startAnimation(localAlphaAnimation);
    }

    private void setPickerFragmentSettingsFromBundle(Bundle paramBundle) {
        if (paramBundle != null) {
            this.showPictures = paramBundle.getBoolean("com.facebook.widget.PickerFragment.ShowPictures", this.showPictures);
            String str = paramBundle.getString("com.facebook.widget.PickerFragment.ExtraFields");
            if (str != null) {
                setExtraFields(Arrays.asList(str.split(",")));
            }
            this.showTitleBar = paramBundle.getBoolean("com.facebook.widget.PickerFragment.ShowTitleBar", this.showTitleBar);
            str = paramBundle.getString("com.facebook.widget.PickerFragment.TitleText");
            if (str != null) {
                this.titleText = str;
                if (this.titleTextView != null) {
                    this.titleTextView.setText(this.titleText);
                }
            }
            paramBundle = paramBundle.getString("com.facebook.widget.PickerFragment.DoneButtonText");
            if (paramBundle != null) {
                this.doneButtonText = paramBundle;
                if (this.doneButton != null) {
                    this.doneButton.setText(this.doneButtonText);
                }
            }
        }
    }

    abstract PickerFragment<T>.PickerFragmentAdapter<T> createAdapter();

    abstract PickerFragment<T>.LoadingStrategy createLoadingStrategy();

    abstract PickerFragment<T>.SelectionStrategy createSelectionStrategy();

    void displayActivityCircle() {
        if (this.activityCircle != null) {
            layoutActivityCircle();
            this.activityCircle.setVisibility(0);
        }
    }

    boolean filterIncludesItem(T paramT) {
        if (this.filter != null) {
            return this.filter.includeItem(paramT);
        }
        return true;
    }

    String getDefaultDoneButtonText() {
        return getString(R.string.com_facebook_picker_done_button_text);
    }

    String getDefaultTitleText() {
        return null;
    }

    public String getDoneButtonText() {
        if (this.doneButtonText == null) {
            this.doneButtonText = getDefaultDoneButtonText();
        }
        return this.doneButtonText;
    }

    public Set<String> getExtraFields() {
        return new HashSet(this.extraFields);
    }

    public PickerFragment.GraphObjectFilter<T> getFilter() {
        return this.filter;
    }

    public PickerFragment.OnDataChangedListener getOnDataChangedListener() {
        return this.onDataChangedListener;
    }

    public PickerFragment.OnDoneButtonClickedListener getOnDoneButtonClickedListener() {
        return this.onDoneButtonClickedListener;
    }

    public PickerFragment.OnErrorListener getOnErrorListener() {
        return this.onErrorListener;
    }

    public PickerFragment.OnSelectionChangedListener getOnSelectionChangedListener() {
        return this.onSelectionChangedListener;
    }

    abstract Request getRequestForLoadData(Session paramSession);

    List<T> getSelectedGraphObjects() {
        return this.adapter.getGraphObjectsById(this.selectionStrategy.getSelectedIds());
    }

    public Session getSession() {
        return this.sessionTracker.getSession();
    }

    public boolean getShowPictures() {
        return this.showPictures;
    }

    public boolean getShowTitleBar() {
        return this.showTitleBar;
    }

    public String getTitleText() {
        if (this.titleText == null) {
            this.titleText = getDefaultTitleText();
        }
        return this.titleText;
    }

    void hideActivityCircle() {
        if (this.activityCircle != null) {
            this.activityCircle.clearAnimation();
            this.activityCircle.setVisibility(4);
        }
    }

    void layoutActivityCircle() {
        if (!this.adapter.isEmpty()) {
        }
        for (float f = 0.25F; ; f = 1.0F) {
            setAlpha(this.activityCircle, f);
            return;
        }
    }

    public void loadData(boolean paramBoolean) {
        if ((!paramBoolean) && (this.loadingStrategy.isDataPresentOrLoading())) {
            return;
        }
        loadDataSkippingRoundTripIfCached();
    }

    void logAppEvents(boolean paramBoolean) {
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        this.sessionTracker = new SessionTracker(getActivity(), new PickerFragment .4 (this));
        setSettingsFromBundle(paramBundle);
        this.loadingStrategy = createLoadingStrategy();
        this.loadingStrategy.attach(this.adapter);
        this.selectionStrategy = createSelectionStrategy();
        this.selectionStrategy.readSelectionFromBundle(paramBundle, "com.facebook.android.PickerFragment.Selection");
        if (this.showTitleBar) {
            inflateTitleBar((ViewGroup) getView());
        }
        if ((this.activityCircle != null) && (paramBundle != null)) {
            if (paramBundle.getBoolean("com.facebook.android.PickerFragment.ActivityCircleShown", false)) {
                displayActivityCircle();
            }
        } else {
            return;
        }
        hideActivityCircle();
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        this.adapter = createAdapter();
        this.adapter.setFilter(new PickerFragment .1 (this));
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramLayoutInflater = (ViewGroup) paramLayoutInflater.inflate(this.layout, paramViewGroup, false);
        this.listView = ((ListView) paramLayoutInflater.findViewById(R.id.com_facebook_picker_list_view));
        this.listView.setOnItemClickListener(new PickerFragment .2 (this));
        this.listView.setOnLongClickListener(new PickerFragment .3 (this));
        this.listView.setOnScrollListener(this.onScrollListener);
        this.activityCircle = ((ProgressBar) paramLayoutInflater.findViewById(R.id.com_facebook_picker_activity_circle));
        setupViews(paramLayoutInflater);
        this.listView.setAdapter(this.adapter);
        return paramLayoutInflater;
    }

    public void onDetach() {
        super.onDetach();
        this.listView.setOnScrollListener(null);
        this.listView.setAdapter(null);
        this.loadingStrategy.detach();
        this.sessionTracker.stopTracking();
    }

    public void onInflate(Activity paramActivity, AttributeSet paramAttributeSet, Bundle paramBundle) {
        super.onInflate(paramActivity, paramAttributeSet, paramBundle);
        paramActivity = paramActivity.obtainStyledAttributes(paramAttributeSet, R.styleable.com_facebook_picker_fragment);
        setShowPictures(paramActivity.getBoolean(R.styleable.com_facebook_picker_fragment_show_pictures, this.showPictures));
        paramAttributeSet = paramActivity.getString(R.styleable.com_facebook_picker_fragment_extra_fields);
        if (paramAttributeSet != null) {
            setExtraFields(Arrays.asList(paramAttributeSet.split(",")));
        }
        this.showTitleBar = paramActivity.getBoolean(R.styleable.com_facebook_picker_fragment_show_title_bar, this.showTitleBar);
        this.titleText = paramActivity.getString(R.styleable.com_facebook_picker_fragment_title_text);
        this.doneButtonText = paramActivity.getString(R.styleable.com_facebook_picker_fragment_done_button_text);
        this.titleBarBackground = paramActivity.getDrawable(R.styleable.com_facebook_picker_fragment_title_bar_background);
        this.doneButtonBackground = paramActivity.getDrawable(R.styleable.com_facebook_picker_fragment_done_button_background);
        paramActivity.recycle();
    }

    void onLoadingData() {
    }

    public void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        saveSettingsToBundle(paramBundle);
        this.selectionStrategy.saveSelectionToBundle(paramBundle, "com.facebook.android.PickerFragment.Selection");
        if (this.activityCircle != null) {
            if (this.activityCircle.getVisibility() != 0) {
                break label47;
            }
        }
        label47:
        for (boolean bool = true; ; bool = false) {
            paramBundle.putBoolean("com.facebook.android.PickerFragment.ActivityCircleShown", bool);
            return;
        }
    }

    public void onStop() {
        if (!this.appEventsLogged) {
            logAppEvents(false);
        }
        super.onStop();
    }

    void saveSettingsToBundle(Bundle paramBundle) {
        paramBundle.putBoolean("com.facebook.widget.PickerFragment.ShowPictures", this.showPictures);
        if (!this.extraFields.isEmpty()) {
            paramBundle.putString("com.facebook.widget.PickerFragment.ExtraFields", TextUtils.join(",", this.extraFields));
        }
        paramBundle.putBoolean("com.facebook.widget.PickerFragment.ShowTitleBar", this.showTitleBar);
        paramBundle.putString("com.facebook.widget.PickerFragment.TitleText", this.titleText);
        paramBundle.putString("com.facebook.widget.PickerFragment.DoneButtonText", this.doneButtonText);
    }

    public void setArguments(Bundle paramBundle) {
        super.setArguments(paramBundle);
        setSettingsFromBundle(paramBundle);
    }

    public void setDoneButtonText(String paramString) {
        this.doneButtonText = paramString;
    }

    public void setExtraFields(Collection<String> paramCollection) {
        this.extraFields = new HashSet();
        if (paramCollection != null) {
            this.extraFields.addAll(paramCollection);
        }
    }

    public void setFilter(PickerFragment.GraphObjectFilter<T> paramGraphObjectFilter) {
        this.filter = paramGraphObjectFilter;
    }

    public void setOnDataChangedListener(PickerFragment.OnDataChangedListener paramOnDataChangedListener) {
        this.onDataChangedListener = paramOnDataChangedListener;
    }

    public void setOnDoneButtonClickedListener(PickerFragment.OnDoneButtonClickedListener paramOnDoneButtonClickedListener) {
        this.onDoneButtonClickedListener = paramOnDoneButtonClickedListener;
    }

    public void setOnErrorListener(PickerFragment.OnErrorListener paramOnErrorListener) {
        this.onErrorListener = paramOnErrorListener;
    }

    public void setOnSelectionChangedListener(PickerFragment.OnSelectionChangedListener paramOnSelectionChangedListener) {
        this.onSelectionChangedListener = paramOnSelectionChangedListener;
    }

    void setSelectedGraphObjects(List<String> paramList) {
        paramList = paramList.iterator();
        while (paramList.hasNext()) {
            String str = (String) paramList.next();
            if (!this.selectionStrategy.isSelected(str)) {
                this.selectionStrategy.toggleSelection(str);
            }
        }
    }

    void setSelectionStrategy(PickerFragment<T>.SelectionStrategy paramPickerFragment) {
        if (paramPickerFragment != this.selectionStrategy) {
            this.selectionStrategy = paramPickerFragment;
            if (this.adapter != null) {
                this.adapter.notifyDataSetChanged();
            }
        }
    }

    public void setSession(Session paramSession) {
        this.sessionTracker.setSession(paramSession);
    }

    public void setSettingsFromBundle(Bundle paramBundle) {
        setPickerFragmentSettingsFromBundle(paramBundle);
    }

    public void setShowPictures(boolean paramBoolean) {
        this.showPictures = paramBoolean;
    }

    public void setShowTitleBar(boolean paramBoolean) {
        this.showTitleBar = paramBoolean;
    }

    public void setTitleText(String paramString) {
        this.titleText = paramString;
    }

    void setupViews(ViewGroup paramViewGroup) {
    }

    void updateAdapter(SimpleGraphObjectCursor<T> paramSimpleGraphObjectCursor) {
        View localView;
        int j;
        GraphObjectAdapter.SectionAndItem localSectionAndItem;
        if (this.adapter != null) {
            localView = this.listView.getChildAt(1);
            j = this.listView.getFirstVisiblePosition();
            i = j;
            if (j > 0) {
                i = j + 1;
            }
            localSectionAndItem = this.adapter.getSectionAndItem(i);
            if ((localView == null) || (localSectionAndItem.getType() == GraphObjectAdapter.SectionAndItem.Type.ACTIVITY_CIRCLE)) {
                break label142;
            }
        }
        label142:
        for (int i = localView.getTop(); ; i = 0) {
            boolean bool = this.adapter.changeCursor(paramSimpleGraphObjectCursor);
            if ((localView != null) && (localSectionAndItem != null)) {
                j = this.adapter.getPosition(localSectionAndItem.sectionKey, localSectionAndItem.graphObject);
                if (j != -1) {
                    this.listView.setSelectionFromTop(j, i);
                }
            }
            if ((bool) && (this.onDataChangedListener != null)) {
                this.onDataChangedListener.onDataChanged(this);
            }
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/widget/PickerFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */