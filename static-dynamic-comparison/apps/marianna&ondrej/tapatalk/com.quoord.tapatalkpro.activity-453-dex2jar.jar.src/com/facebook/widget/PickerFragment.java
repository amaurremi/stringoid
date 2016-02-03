package com.facebook.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.FacebookException;
import com.facebook.Request;
import com.facebook.Session;
import com.facebook.Session.StatusCallback;
import com.facebook.SessionState;
import com.facebook.android.R.id;
import com.facebook.android.R.string;
import com.facebook.android.R.styleable;
import com.facebook.internal.SessionTracker;
import com.facebook.model.GraphObject;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
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
    private Button doneButton;
    private Drawable doneButtonBackground;
    private String doneButtonText;
    HashSet<String> extraFields = new HashSet();
    private GraphObjectFilter<T> filter;
    private final Class<T> graphObjectClass;
    private final int layout;
    private ListView listView;
    private PickerFragment<T>.LoadingStrategy loadingStrategy;
    private OnDataChangedListener onDataChangedListener;
    private OnDoneButtonClickedListener onDoneButtonClickedListener;
    private OnErrorListener onErrorListener;
    private AbsListView.OnScrollListener onScrollListener = new AbsListView.OnScrollListener() {
        public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {
            PickerFragment.this.reprioritizeDownloads();
        }

        public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {
        }
    };
    private OnSelectionChangedListener onSelectionChangedListener;
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
        int i;
        if (this.adapter != null) {
            if (!this.selectionStrategy.isEmpty()) {
                break label95;
            }
            i = 0;
            if (!this.adapter.isEmpty()) {
                break label100;
            }
        }
        label95:
        label100:
        for (int j = 0; ; j = 1) {
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
            i = 1;
            break;
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
                this.doneButton.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View paramAnonymousView) {
                        if (PickerFragment.this.onDoneButtonClickedListener != null) {
                            PickerFragment.this.onDoneButtonClickedListener.onDoneButtonClicked(PickerFragment.this);
                        }
                    }
                });
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

    public GraphObjectFilter<T> getFilter() {
        return this.filter;
    }

    public OnDataChangedListener getOnDataChangedListener() {
        return this.onDataChangedListener;
    }

    public OnDoneButtonClickedListener getOnDoneButtonClickedListener() {
        return this.onDoneButtonClickedListener;
    }

    public OnErrorListener getOnErrorListener() {
        return this.onErrorListener;
    }

    public OnSelectionChangedListener getOnSelectionChangedListener() {
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

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        this.sessionTracker = new SessionTracker(getActivity(), new Session.StatusCallback() {
            public void call(Session paramAnonymousSession, SessionState paramAnonymousSessionState, Exception paramAnonymousException) {
                if (!paramAnonymousSession.isOpened()) {
                    PickerFragment.this.clearResults();
                }
            }
        });
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
        this.adapter.setFilter(new GraphObjectAdapter.Filter() {
            public boolean includeItem(T paramAnonymousT) {
                return PickerFragment.this.filterIncludesItem(paramAnonymousT);
            }
        });
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramLayoutInflater = (ViewGroup) paramLayoutInflater.inflate(this.layout, paramViewGroup, false);
        this.listView = ((ListView) paramLayoutInflater.findViewById(R.id.com_facebook_picker_list_view));
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong) {
                PickerFragment.this.onListItemClick((ListView) paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt);
            }
        });
        this.listView.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View paramAnonymousView) {
                return false;
            }
        });
        this.listView.setOnScrollListener(this.onScrollListener);
        this.listView.setAdapter(this.adapter);
        this.activityCircle = ((ProgressBar) paramLayoutInflater.findViewById(R.id.com_facebook_picker_activity_circle));
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
        setShowPictures(paramActivity.getBoolean(0, this.showPictures));
        paramAttributeSet = paramActivity.getString(1);
        if (paramAttributeSet != null) {
            setExtraFields(Arrays.asList(paramAttributeSet.split(",")));
        }
        this.showTitleBar = paramActivity.getBoolean(2, this.showTitleBar);
        this.titleText = paramActivity.getString(3);
        this.doneButtonText = paramActivity.getString(4);
        this.titleBarBackground = paramActivity.getDrawable(5);
        this.doneButtonBackground = paramActivity.getDrawable(6);
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

    public void setFilter(GraphObjectFilter<T> paramGraphObjectFilter) {
        this.filter = paramGraphObjectFilter;
    }

    public void setOnDataChangedListener(OnDataChangedListener paramOnDataChangedListener) {
        this.onDataChangedListener = paramOnDataChangedListener;
    }

    public void setOnDoneButtonClickedListener(OnDoneButtonClickedListener paramOnDoneButtonClickedListener) {
        this.onDoneButtonClickedListener = paramOnDoneButtonClickedListener;
    }

    public void setOnErrorListener(OnErrorListener paramOnErrorListener) {
        this.onErrorListener = paramOnErrorListener;
    }

    public void setOnSelectionChangedListener(OnSelectionChangedListener paramOnSelectionChangedListener) {
        this.onSelectionChangedListener = paramOnSelectionChangedListener;
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

    public static abstract interface GraphObjectFilter<T> {
        public abstract boolean includeItem(T paramT);
    }

    abstract class LoadingStrategy {
        protected static final int CACHED_RESULT_REFRESH_DELAY = 2000;
        protected GraphObjectAdapter<T> adapter;
        protected GraphObjectPagingLoader<T> loader;

        LoadingStrategy() {
        }

        public void attach(GraphObjectAdapter<T> paramGraphObjectAdapter) {
            this.loader = ((GraphObjectPagingLoader) PickerFragment.this.getLoaderManager().initLoader(0, null, new LoaderManager.LoaderCallbacks() {
                public Loader<SimpleGraphObjectCursor<T>> onCreateLoader(int paramAnonymousInt, Bundle paramAnonymousBundle) {
                    return PickerFragment.LoadingStrategy.this.onCreateLoader();
                }

                public void onLoadFinished(Loader<SimpleGraphObjectCursor<T>> paramAnonymousLoader, SimpleGraphObjectCursor<T> paramAnonymousSimpleGraphObjectCursor) {
                    if (paramAnonymousLoader != PickerFragment.LoadingStrategy.this.loader) {
                        throw new FacebookException("Received callback for unknown loader.");
                    }
                    PickerFragment.LoadingStrategy.this.onLoadFinished((GraphObjectPagingLoader) paramAnonymousLoader, paramAnonymousSimpleGraphObjectCursor);
                }

                public void onLoaderReset(Loader<SimpleGraphObjectCursor<T>> paramAnonymousLoader) {
                    if (paramAnonymousLoader != PickerFragment.LoadingStrategy.this.loader) {
                        throw new FacebookException("Received callback for unknown loader.");
                    }
                    PickerFragment.LoadingStrategy.this.onLoadReset((GraphObjectPagingLoader) paramAnonymousLoader);
                }
            }));
            this.loader.setOnErrorListener(new GraphObjectPagingLoader.OnErrorListener() {
                public void onError(FacebookException paramAnonymousFacebookException, GraphObjectPagingLoader<?> paramAnonymousGraphObjectPagingLoader) {
                    PickerFragment.this.hideActivityCircle();
                    if (PickerFragment.this.onErrorListener != null) {
                        PickerFragment.this.onErrorListener.onError(PickerFragment.this, paramAnonymousFacebookException);
                    }
                }
            });
            this.adapter = paramGraphObjectAdapter;
            this.adapter.changeCursor(this.loader.getCursor());
            this.adapter.setOnErrorListener(new GraphObjectAdapter.OnErrorListener() {
                public void onError(GraphObjectAdapter<?> paramAnonymousGraphObjectAdapter, FacebookException paramAnonymousFacebookException) {
                    if (PickerFragment.this.onErrorListener != null) {
                        PickerFragment.this.onErrorListener.onError(PickerFragment.this, paramAnonymousFacebookException);
                    }
                }
            });
        }

        public void clearResults() {
            if (this.loader != null) {
                this.loader.clearResults();
            }
        }

        public void detach() {
            this.adapter.setDataNeededListener(null);
            this.adapter.setOnErrorListener(null);
            this.loader.setOnErrorListener(null);
            this.loader = null;
            this.adapter = null;
        }

        public boolean isDataPresentOrLoading() {
            return (!this.adapter.isEmpty()) || (this.loader.isLoading());
        }

        protected GraphObjectPagingLoader<T> onCreateLoader() {
            return new GraphObjectPagingLoader(PickerFragment.this.getActivity(), PickerFragment.this.graphObjectClass);
        }

        protected void onLoadFinished(GraphObjectPagingLoader<T> paramGraphObjectPagingLoader, SimpleGraphObjectCursor<T> paramSimpleGraphObjectCursor) {
            PickerFragment.this.updateAdapter(paramSimpleGraphObjectCursor);
        }

        protected void onLoadReset(GraphObjectPagingLoader<T> paramGraphObjectPagingLoader) {
            this.adapter.changeCursor(null);
        }

        protected void onStartLoading(GraphObjectPagingLoader<T> paramGraphObjectPagingLoader, Request paramRequest) {
            PickerFragment.this.displayActivityCircle();
        }

        public void startLoading(Request paramRequest) {
            if (this.loader != null) {
                this.loader.startLoading(paramRequest, true);
                onStartLoading(this.loader, paramRequest);
            }
        }
    }

    class MultiSelectionStrategy
            extends PickerFragment<T>.SelectionStrategy {
        private Set<String> selectedIds = new HashSet();

        MultiSelectionStrategy() {
            super();
        }

        public void clear() {
            this.selectedIds.clear();
        }

        public Collection<String> getSelectedIds() {
            return this.selectedIds;
        }

        boolean isEmpty() {
            return this.selectedIds.isEmpty();
        }

        boolean isSelected(String paramString) {
            return (paramString != null) && (this.selectedIds.contains(paramString));
        }

        void readSelectionFromBundle(Bundle paramBundle, String paramString) {
            if (paramBundle != null) {
                paramBundle = paramBundle.getString(paramString);
                if (paramBundle != null) {
                    paramBundle = TextUtils.split(paramBundle, ",");
                    this.selectedIds.clear();
                    Collections.addAll(this.selectedIds, paramBundle);
                }
            }
        }

        void saveSelectionToBundle(Bundle paramBundle, String paramString) {
            if (!this.selectedIds.isEmpty()) {
                paramBundle.putString(paramString, TextUtils.join(",", this.selectedIds));
            }
        }

        boolean shouldShowCheckBoxIfUnselected() {
            return true;
        }

        void toggleSelection(String paramString) {
            if (paramString != null) {
                if (this.selectedIds.contains(paramString)) {
                    this.selectedIds.remove(paramString);
                }
            } else {
                return;
            }
            this.selectedIds.add(paramString);
        }
    }

    public static abstract interface OnDataChangedListener {
        public abstract void onDataChanged(PickerFragment<?> paramPickerFragment);
    }

    public static abstract interface OnDoneButtonClickedListener {
        public abstract void onDoneButtonClicked(PickerFragment<?> paramPickerFragment);
    }

    public static abstract interface OnErrorListener {
        public abstract void onError(PickerFragment<?> paramPickerFragment, FacebookException paramFacebookException);
    }

    public static abstract interface OnSelectionChangedListener {
        public abstract void onSelectionChanged(PickerFragment<?> paramPickerFragment);
    }

    abstract class PickerFragmentAdapter<U extends GraphObject>
            extends GraphObjectAdapter<T> {
        public PickerFragmentAdapter(Context paramContext) {
            super();
        }

        boolean isGraphObjectSelected(String paramString) {
            return PickerFragment.this.selectionStrategy.isSelected(paramString);
        }

        void updateCheckboxState(CheckBox paramCheckBox, boolean paramBoolean) {
            paramCheckBox.setChecked(paramBoolean);
            if ((paramBoolean) || (PickerFragment.this.selectionStrategy.shouldShowCheckBoxIfUnselected())) {
            }
            for (int i = 0; ; i = 8) {
                paramCheckBox.setVisibility(i);
                return;
            }
        }
    }

    abstract class SelectionStrategy {
        SelectionStrategy() {
        }

        abstract void clear();

        abstract Collection<String> getSelectedIds();

        abstract boolean isEmpty();

        abstract boolean isSelected(String paramString);

        abstract void readSelectionFromBundle(Bundle paramBundle, String paramString);

        abstract void saveSelectionToBundle(Bundle paramBundle, String paramString);

        abstract boolean shouldShowCheckBoxIfUnselected();

        abstract void toggleSelection(String paramString);
    }

    class SingleSelectionStrategy
            extends PickerFragment<T>.SelectionStrategy {
        private String selectedId;

        SingleSelectionStrategy() {
            super();
        }

        public void clear() {
            this.selectedId = null;
        }

        public Collection<String> getSelectedIds() {
            return Arrays.asList(new String[]{this.selectedId});
        }

        boolean isEmpty() {
            return this.selectedId == null;
        }

        boolean isSelected(String paramString) {
            return (this.selectedId != null) && (paramString != null) && (this.selectedId.equals(paramString));
        }

        void readSelectionFromBundle(Bundle paramBundle, String paramString) {
            if (paramBundle != null) {
                this.selectedId = paramBundle.getString(paramString);
            }
        }

        void saveSelectionToBundle(Bundle paramBundle, String paramString) {
            if (!TextUtils.isEmpty(this.selectedId)) {
                paramBundle.putString(paramString, this.selectedId);
            }
        }

        boolean shouldShowCheckBoxIfUnselected() {
            return false;
        }

        void toggleSelection(String paramString) {
            if ((this.selectedId != null) && (this.selectedId.equals(paramString))) {
                this.selectedId = null;
                return;
            }
            this.selectedId = paramString;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/facebook/widget/PickerFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */