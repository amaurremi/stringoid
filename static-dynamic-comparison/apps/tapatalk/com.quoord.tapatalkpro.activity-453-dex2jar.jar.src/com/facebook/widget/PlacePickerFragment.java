package com.facebook.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.FacebookException;
import com.facebook.LoggingBehavior;
import com.facebook.Request;
import com.facebook.Session;
import com.facebook.android.R.drawable;
import com.facebook.android.R.id;
import com.facebook.android.R.layout;
import com.facebook.android.R.string;
import com.facebook.android.R.styleable;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.model.GraphPlace;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

public class PlacePickerFragment
        extends PickerFragment<GraphPlace> {
    private static final String CATEGORY = "category";
    public static final int DEFAULT_RADIUS_IN_METERS = 1000;
    public static final int DEFAULT_RESULTS_LIMIT = 100;
    private static final String ID = "id";
    private static final String LOCATION = "location";
    public static final String LOCATION_BUNDLE_KEY = "com.facebook.widget.PlacePickerFragment.Location";
    private static final String NAME = "name";
    public static final String RADIUS_IN_METERS_BUNDLE_KEY = "com.facebook.widget.PlacePickerFragment.RadiusInMeters";
    public static final String RESULTS_LIMIT_BUNDLE_KEY = "com.facebook.widget.PlacePickerFragment.ResultsLimit";
    public static final String SEARCH_TEXT_BUNDLE_KEY = "com.facebook.widget.PlacePickerFragment.SearchText";
    public static final String SHOW_SEARCH_BOX_BUNDLE_KEY = "com.facebook.widget.PlacePickerFragment.ShowSearchBox";
    private static final String TAG = "PlacePickerFragment";
    private static final String WERE_HERE_COUNT = "were_here_count";
    private static final int searchTextTimerDelayInMilliseconds = 2000;
    private boolean hasSearchTextChangedSinceLastQuery;
    private Location location;
    private int radiusInMeters = 1000;
    private int resultsLimit = 100;
    private EditText searchBox;
    private String searchText;
    private Timer searchTextTimer;
    private boolean showSearchBox = true;

    public PlacePickerFragment() {
        this(null);
    }

    public PlacePickerFragment(Bundle paramBundle) {
        super(GraphPlace.class, R.layout.com_facebook_placepickerfragment, paramBundle);
        setPlacePickerSettingsFromBundle(paramBundle);
    }

    private Request createRequest(Location paramLocation, int paramInt1, int paramInt2, String paramString, Set<String> paramSet, Session paramSession) {
        paramLocation = Request.newPlacesSearchRequest(paramSession, paramLocation, paramInt1, paramInt2, paramString, null);
        paramString = new HashSet(paramSet);
        paramString.addAll(Arrays.asList(new String[]{"id", "name", "location", "category", "were_here_count"}));
        paramSet = this.adapter.getPictureFieldSpecifier();
        if (paramSet != null) {
            paramString.add(paramSet);
        }
        paramSet = paramLocation.getParameters();
        paramSet.putString("fields", TextUtils.join(",", paramString));
        paramLocation.setParameters(paramSet);
        return paramLocation;
    }

    private Timer createSearchTextTimer() {
        Timer localTimer = new Timer();
        localTimer.schedule(new TimerTask() {
            public void run() {
                PlacePickerFragment.this.onSearchTextTimerTriggered();
            }
        }, 0L, 2000L);
        return localTimer;
    }

    private void onSearchTextTimerTriggered() {
        if (this.hasSearchTextChangedSinceLastQuery) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    for (; ; ) {
                        try {
                            PlacePickerFragment.this.loadData(true);
                            PickerFragment.OnErrorListener localOnErrorListener1;
                            return;
                        } catch (FacebookException localFacebookException1) {
                            if (localFacebookException1 == null) {
                                continue;
                            }
                            localOnErrorListener2 = PlacePickerFragment.this.getOnErrorListener();
                            if (localOnErrorListener2 != null) {
                                localOnErrorListener2.onError(PlacePickerFragment.this, localFacebookException1);
                                return;
                            }
                            Logger.log(LoggingBehavior.REQUESTS, "PlacePickerFragment", "Error loading data : %s", new Object[]{localFacebookException1});
                            return;
                        } catch (Exception localException) {
                            FacebookException localFacebookException2 = new FacebookException(localException);
                            if (localFacebookException2 == null) {
                                break;
                            }
                            localOnErrorListener2 = PlacePickerFragment.this.getOnErrorListener();
                            if (localOnErrorListener2 != null) {
                                localOnErrorListener2.onError(PlacePickerFragment.this, localFacebookException2);
                                return;
                            }
                            Logger.log(LoggingBehavior.REQUESTS, "PlacePickerFragment", "Error loading data : %s", new Object[]{localFacebookException2});
                            return;
                        } finally {
                            PickerFragment.OnErrorListener localOnErrorListener2;
                            if (0 != 0) {
                                localOnErrorListener2 = PlacePickerFragment.this.getOnErrorListener();
                                if (localOnErrorListener2 == null) {
                                    break label171;
                                }
                                localOnErrorListener2.onError(PlacePickerFragment.this, null);
                            }
                        }
                        label171:
                        Logger.log(LoggingBehavior.REQUESTS, "PlacePickerFragment", "Error loading data : %s", new Object[]{null});
                    }
                    Logger.log(LoggingBehavior.REQUESTS, "PlacePickerFragment", "Error loading data : %s", new Object[]{null});
                    return;
                }
            });
            return;
        }
        this.searchTextTimer.cancel();
        this.searchTextTimer = null;
    }

    private void setPlacePickerSettingsFromBundle(Bundle paramBundle) {
        if (paramBundle != null) {
            setRadiusInMeters(paramBundle.getInt("com.facebook.widget.PlacePickerFragment.RadiusInMeters", this.radiusInMeters));
            setResultsLimit(paramBundle.getInt("com.facebook.widget.PlacePickerFragment.ResultsLimit", this.resultsLimit));
            if (paramBundle.containsKey("com.facebook.widget.PlacePickerFragment.SearchText")) {
                setSearchText(paramBundle.getString("com.facebook.widget.PlacePickerFragment.SearchText"));
            }
            if (paramBundle.containsKey("com.facebook.widget.PlacePickerFragment.Location")) {
                setLocation((Location) paramBundle.getParcelable("com.facebook.widget.PlacePickerFragment.Location"));
            }
            this.showSearchBox = paramBundle.getBoolean("com.facebook.widget.PlacePickerFragment.ShowSearchBox", this.showSearchBox);
        }
    }

    PickerFragment<GraphPlace>.PickerFragmentAdapter<GraphPlace> createAdapter() {
        PickerFragment.PickerFragmentAdapter local1 = new PickerFragment.PickerFragmentAdapter(this, getActivity()) {
            protected int getDefaultPicture() {
                return R.drawable.com_facebook_place_default_icon;
            }

            protected int getGraphObjectRowLayoutId(GraphPlace paramAnonymousGraphPlace) {
                return R.layout.com_facebook_placepickerfragment_list_row;
            }

            protected CharSequence getSubTitleOfGraphObject(GraphPlace paramAnonymousGraphPlace) {
                String str = paramAnonymousGraphPlace.getCategory();
                Integer localInteger = (Integer) paramAnonymousGraphPlace.getProperty("were_here_count");
                Object localObject = null;
                if ((str != null) && (localInteger != null)) {
                    paramAnonymousGraphPlace = PlacePickerFragment.this.getString(R.string.com_facebook_placepicker_subtitle_format, new Object[]{str, localInteger});
                }
                do {
                    do {
                        return paramAnonymousGraphPlace;
                        if ((str == null) && (localInteger != null)) {
                            return PlacePickerFragment.this.getString(R.string.com_facebook_placepicker_subtitle_were_here_only_format, new Object[]{localInteger});
                        }
                        paramAnonymousGraphPlace = (GraphPlace) localObject;
                    } while (str == null);
                    paramAnonymousGraphPlace = (GraphPlace) localObject;
                } while (localInteger != null);
                return PlacePickerFragment.this.getString(R.string.com_facebook_placepicker_subtitle_catetory_only_format, new Object[]{str});
            }
        };
        local1.setShowCheckbox(false);
        local1.setShowPicture(getShowPictures());
        return local1;
    }

    PickerFragment<GraphPlace>.LoadingStrategy createLoadingStrategy() {
        return new AsNeededLoadingStrategy(null);
    }

    PickerFragment<GraphPlace>.SelectionStrategy createSelectionStrategy() {
        return new PickerFragment.SingleSelectionStrategy(this);
    }

    String getDefaultTitleText() {
        return getString(R.string.com_facebook_nearby);
    }

    public Location getLocation() {
        return this.location;
    }

    public int getRadiusInMeters() {
        return this.radiusInMeters;
    }

    Request getRequestForLoadData(Session paramSession) {
        return createRequest(this.location, this.radiusInMeters, this.resultsLimit, this.searchText, this.extraFields, paramSession);
    }

    public int getResultsLimit() {
        return this.resultsLimit;
    }

    public String getSearchText() {
        return this.searchText;
    }

    public GraphPlace getSelection() {
        List localList = getSelectedGraphObjects();
        if ((localList != null) && (localList.size() > 0)) {
            return (GraphPlace) localList.iterator().next();
        }
        return null;
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        paramBundle = (ViewGroup) getView();
        if (this.showSearchBox) {
            Object localObject = (ViewStub) paramBundle.findViewById(R.id.com_facebook_placepickerfragment_search_box_stub);
            if (localObject != null) {
                this.searchBox = ((EditText) ((ViewStub) localObject).inflate());
                localObject = new RelativeLayout.LayoutParams(-1, -1);
                ((RelativeLayout.LayoutParams) localObject).addRule(3, R.id.search_box);
                ((ListView) paramBundle.findViewById(R.id.com_facebook_picker_list_view)).setLayoutParams((ViewGroup.LayoutParams) localObject);
                if (paramBundle.findViewById(R.id.com_facebook_picker_title_bar) != null) {
                    paramBundle = new RelativeLayout.LayoutParams(-1, -2);
                    paramBundle.addRule(3, R.id.com_facebook_picker_title_bar);
                    this.searchBox.setLayoutParams(paramBundle);
                }
                this.searchBox.addTextChangedListener(new SearchTextWatcher(null));
                if (!TextUtils.isEmpty(this.searchText)) {
                    this.searchBox.setText(this.searchText);
                }
            }
        }
    }

    public void onAttach(Activity paramActivity) {
        super.onAttach(paramActivity);
        if (this.searchBox != null) {
            ((InputMethodManager) getActivity().getSystemService("input_method")).showSoftInput(this.searchBox, 1);
        }
    }

    public void onDetach() {
        super.onDetach();
        if (this.searchBox != null) {
            ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.searchBox.getWindowToken(), 0);
        }
    }

    public void onInflate(Activity paramActivity, AttributeSet paramAttributeSet, Bundle paramBundle) {
        super.onInflate(paramActivity, paramAttributeSet, paramBundle);
        paramActivity = paramActivity.obtainStyledAttributes(paramAttributeSet, R.styleable.com_facebook_place_picker_fragment);
        setRadiusInMeters(paramActivity.getInt(0, this.radiusInMeters));
        setResultsLimit(paramActivity.getInt(1, this.resultsLimit));
        if (paramActivity.hasValue(1)) {
            setSearchText(paramActivity.getString(2));
        }
        this.showSearchBox = paramActivity.getBoolean(3, this.showSearchBox);
        paramActivity.recycle();
    }

    void onLoadingData() {
        this.hasSearchTextChangedSinceLastQuery = false;
    }

    public void onSearchBoxTextChanged(String paramString, boolean paramBoolean) {
        if ((!paramBoolean) && (Utility.stringsEqualOrEmpty(this.searchText, paramString))) {
        }
        do {
            return;
            String str = paramString;
            if (TextUtils.isEmpty(paramString)) {
                str = null;
            }
            this.searchText = str;
            this.hasSearchTextChangedSinceLastQuery = true;
        } while (this.searchTextTimer != null);
        this.searchTextTimer = createSearchTextTimer();
    }

    void saveSettingsToBundle(Bundle paramBundle) {
        super.saveSettingsToBundle(paramBundle);
        paramBundle.putInt("com.facebook.widget.PlacePickerFragment.RadiusInMeters", this.radiusInMeters);
        paramBundle.putInt("com.facebook.widget.PlacePickerFragment.ResultsLimit", this.resultsLimit);
        paramBundle.putString("com.facebook.widget.PlacePickerFragment.SearchText", this.searchText);
        paramBundle.putParcelable("com.facebook.widget.PlacePickerFragment.Location", this.location);
        paramBundle.putBoolean("com.facebook.widget.PlacePickerFragment.ShowSearchBox", this.showSearchBox);
    }

    public void setLocation(Location paramLocation) {
        this.location = paramLocation;
    }

    public void setRadiusInMeters(int paramInt) {
        this.radiusInMeters = paramInt;
    }

    public void setResultsLimit(int paramInt) {
        this.resultsLimit = paramInt;
    }

    public void setSearchText(String paramString) {
        String str = paramString;
        if (TextUtils.isEmpty(paramString)) {
            str = null;
        }
        this.searchText = str;
        if (this.searchBox != null) {
            this.searchBox.setText(str);
        }
    }

    public void setSettingsFromBundle(Bundle paramBundle) {
        super.setSettingsFromBundle(paramBundle);
        setPlacePickerSettingsFromBundle(paramBundle);
    }

    private class AsNeededLoadingStrategy
            extends PickerFragment<GraphPlace>.LoadingStrategy {
        private AsNeededLoadingStrategy() {
            super();
        }

        public void attach(GraphObjectAdapter<GraphPlace> paramGraphObjectAdapter) {
            super.attach(paramGraphObjectAdapter);
            this.adapter.setDataNeededListener(new GraphObjectAdapter.DataNeededListener() {
                public void onDataNeeded() {
                    if (!PlacePickerFragment.AsNeededLoadingStrategy.this.loader.isLoading()) {
                        PlacePickerFragment.AsNeededLoadingStrategy.this.loader.followNextLink();
                    }
                }
            });
        }

        protected void onLoadFinished(GraphObjectPagingLoader<GraphPlace> paramGraphObjectPagingLoader, SimpleGraphObjectCursor<GraphPlace> paramSimpleGraphObjectCursor) {
            super.onLoadFinished(paramGraphObjectPagingLoader, paramSimpleGraphObjectCursor);
            if ((paramSimpleGraphObjectCursor == null) || (paramGraphObjectPagingLoader.isLoading())) {
            }
            do {
                return;
                PlacePickerFragment.this.hideActivityCircle();
            } while (!paramSimpleGraphObjectCursor.isFromCache());
            if (paramSimpleGraphObjectCursor.areMoreObjectsAvailable()) {
            }
            for (int i = 2000; ; i = 0) {
                paramGraphObjectPagingLoader.refreshOriginalRequest(i);
                return;
            }
        }
    }

    private class SearchTextWatcher
            implements TextWatcher {
        private SearchTextWatcher() {
        }

        public void afterTextChanged(Editable paramEditable) {
        }

        public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {
        }

        public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {
            PlacePickerFragment.this.onSearchBoxTextChanged(paramCharSequence.toString(), false);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/facebook/widget/PlacePickerFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */