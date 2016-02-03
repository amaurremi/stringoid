package android.support.v7.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.aa;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView.OnEditorActionListener;

import java.util.WeakHashMap;

public class SearchView
        extends LinearLayout
        implements android.support.v7.c.c {
    private static final boolean DBG = false;
    static final m HIDDEN_METHOD_INVOKER = new m();
    private static final String IME_OPTION_NO_MICROPHONE = "nm";
    private static final String LOG_TAG = "SearchView";
    private Bundle mAppSearchData;
    private boolean mClearingFocus;
    private ImageView mCloseButton;
    private int mCollapsedImeOptions;
    private View mDropDownAnchor;
    private boolean mExpandedInActionView;
    private boolean mIconified;
    private boolean mIconifiedByDefault;
    private int mMaxWidth;
    private CharSequence mOldQueryText;
    private final View.OnClickListener mOnClickListener = new j(this);
    private n mOnCloseListener;
    private final TextView.OnEditorActionListener mOnEditorActionListener = new l(this);
    private final AdapterView.OnItemClickListener mOnItemClickListener = new b(this);
    private final AdapterView.OnItemSelectedListener mOnItemSelectedListener = new c(this);
    private o mOnQueryChangeListener;
    private View.OnFocusChangeListener mOnQueryTextFocusChangeListener;
    private View.OnClickListener mOnSearchClickListener;
    private p mOnSuggestionListener;
    private final WeakHashMap<String, Drawable.ConstantState> mOutsideDrawablesCache = new WeakHashMap();
    private CharSequence mQueryHint;
    private boolean mQueryRefinement;
    private SearchView.SearchAutoComplete mQueryTextView;
    private Runnable mReleaseCursorRunnable = new f(this);
    private View mSearchButton;
    private View mSearchEditFrame;
    private ImageView mSearchHintIcon;
    private View mSearchPlate;
    private SearchableInfo mSearchable;
    private Runnable mShowImeRunnable = new a(this);
    private View mSubmitArea;
    private View mSubmitButton;
    private boolean mSubmitButtonEnabled;
    private android.support.v4.widget.a mSuggestionsAdapter;
    View.OnKeyListener mTextKeyListener = new k(this);
    private TextWatcher mTextWatcher = new d(this);
    private Runnable mUpdateDrawableStateRunnable = new e(this);
    private CharSequence mUserQuery;
    private final Intent mVoiceAppSearchIntent;
    private View mVoiceButton;
    private boolean mVoiceButtonEnabled;
    private final Intent mVoiceWebSearchIntent;

    public SearchView(Context paramContext) {
        this(paramContext, null);
    }

    public SearchView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        ((LayoutInflater) paramContext.getSystemService("layout_inflater")).inflate(android.support.v7.b.h.abc_search_view, this, true);
        this.mSearchButton = findViewById(android.support.v7.b.f.search_button);
        this.mQueryTextView = ((SearchView.SearchAutoComplete) findViewById(android.support.v7.b.f.search_src_text));
        this.mQueryTextView.setSearchView(this);
        this.mSearchEditFrame = findViewById(android.support.v7.b.f.search_edit_frame);
        this.mSearchPlate = findViewById(android.support.v7.b.f.search_plate);
        this.mSubmitArea = findViewById(android.support.v7.b.f.submit_area);
        this.mSubmitButton = findViewById(android.support.v7.b.f.search_go_btn);
        this.mCloseButton = ((ImageView) findViewById(android.support.v7.b.f.search_close_btn));
        this.mVoiceButton = findViewById(android.support.v7.b.f.search_voice_btn);
        this.mSearchHintIcon = ((ImageView) findViewById(android.support.v7.b.f.search_mag_icon));
        this.mSearchButton.setOnClickListener(this.mOnClickListener);
        this.mCloseButton.setOnClickListener(this.mOnClickListener);
        this.mSubmitButton.setOnClickListener(this.mOnClickListener);
        this.mVoiceButton.setOnClickListener(this.mOnClickListener);
        this.mQueryTextView.setOnClickListener(this.mOnClickListener);
        this.mQueryTextView.addTextChangedListener(this.mTextWatcher);
        this.mQueryTextView.setOnEditorActionListener(this.mOnEditorActionListener);
        this.mQueryTextView.setOnItemClickListener(this.mOnItemClickListener);
        this.mQueryTextView.setOnItemSelectedListener(this.mOnItemSelectedListener);
        this.mQueryTextView.setOnKeyListener(this.mTextKeyListener);
        this.mQueryTextView.setOnFocusChangeListener(new g(this));
        TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, android.support.v7.b.k.SearchView, 0, 0);
        setIconifiedByDefault(localTypedArray.getBoolean(3, true));
        int i = localTypedArray.getDimensionPixelSize(0, -1);
        if (i != -1) {
            setMaxWidth(i);
        }
        CharSequence localCharSequence = localTypedArray.getText(4);
        if (!TextUtils.isEmpty(localCharSequence)) {
            setQueryHint(localCharSequence);
        }
        i = localTypedArray.getInt(2, -1);
        if (i != -1) {
            setImeOptions(i);
        }
        i = localTypedArray.getInt(1, -1);
        if (i != -1) {
            setInputType(i);
        }
        localTypedArray.recycle();
        paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, android.support.v7.b.k.View, 0, 0);
        boolean bool = paramContext.getBoolean(0, true);
        paramContext.recycle();
        setFocusable(bool);
        this.mVoiceWebSearchIntent = new Intent("android.speech.action.WEB_SEARCH");
        this.mVoiceWebSearchIntent.addFlags(268435456);
        this.mVoiceWebSearchIntent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        this.mVoiceAppSearchIntent = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.mVoiceAppSearchIntent.addFlags(268435456);
        this.mDropDownAnchor = findViewById(this.mQueryTextView.getDropDownAnchor());
        if (this.mDropDownAnchor != null) {
            if (Build.VERSION.SDK_INT < 11) {
                break label628;
            }
            addOnLayoutChangeListenerToDropDownAnchorSDK11();
        }
        for (; ; ) {
            updateViewsVisibility(this.mIconifiedByDefault);
            updateQueryHint();
            return;
            label628:
            addOnLayoutChangeListenerToDropDownAnchorBase();
        }
    }

    private void addOnLayoutChangeListenerToDropDownAnchorBase() {
        this.mDropDownAnchor.getViewTreeObserver().addOnGlobalLayoutListener(new i(this));
    }

    private void addOnLayoutChangeListenerToDropDownAnchorSDK11() {
        this.mDropDownAnchor.addOnLayoutChangeListener(new h(this));
    }

    private void adjustDropDownSizeAndPosition() {
        Resources localResources;
        int j;
        Rect localRect;
        if (this.mDropDownAnchor.getWidth() > 1) {
            localResources = getContext().getResources();
            j = this.mSearchPlate.getPaddingLeft();
            localRect = new Rect();
            if (!this.mIconifiedByDefault) {
                break label136;
            }
            i = localResources.getDimensionPixelSize(android.support.v7.b.e.abc_dropdownitem_icon_width);
        }
        label136:
        for (int i = localResources.getDimensionPixelSize(android.support.v7.b.e.abc_dropdownitem_text_padding_left) + i; ; i = 0) {
            this.mQueryTextView.getDropDownBackground().getPadding(localRect);
            int k = localRect.left;
            this.mQueryTextView.setDropDownHorizontalOffset(j - (k + i));
            k = this.mDropDownAnchor.getWidth();
            int m = localRect.left;
            int n = localRect.right;
            this.mQueryTextView.setDropDownWidth(i + (n + (k + m)) - j);
            return;
        }
    }

    private Intent createIntent(String paramString1, Uri paramUri, String paramString2, String paramString3, int paramInt, String paramString4) {
        paramString1 = new Intent(paramString1);
        paramString1.addFlags(268435456);
        if (paramUri != null) {
            paramString1.setData(paramUri);
        }
        paramString1.putExtra("user_query", this.mUserQuery);
        if (paramString3 != null) {
            paramString1.putExtra("query", paramString3);
        }
        if (paramString2 != null) {
            paramString1.putExtra("intent_extra_data_key", paramString2);
        }
        if (this.mAppSearchData != null) {
            paramString1.putExtra("app_data", this.mAppSearchData);
        }
        if (paramInt != 0) {
            paramString1.putExtra("action_key", paramInt);
            paramString1.putExtra("action_msg", paramString4);
        }
        paramString1.setComponent(this.mSearchable.getSearchActivity());
        return paramString1;
    }

    private Intent createIntentFromSuggestion(Cursor paramCursor, int paramInt, String paramString) {
        try {
            localObject2 = q.a(paramCursor, "suggest_intent_action");
            localObject1 = localObject2;
            if (localObject2 != null) {
                break label206;
            }
            localObject1 = this.mSearchable.getSuggestIntentAction();
        } catch (RuntimeException paramString) {
            for (; ; ) {
                Object localObject1;
                Object localObject3;
                try {
                    String str;
                    paramInt = paramCursor.getPosition();
                    Log.w("SearchView", "Search suggestions cursor at row " + paramInt + " returned exception.", paramString);
                    return null;
                } catch (RuntimeException paramCursor) {
                    paramInt = -1;
                    continue;
                }
                label206:
                Object localObject2 = localObject1;
                if (localObject1 == null) {
                    localObject2 = "android.intent.action.SEARCH";
                    continue;
                    label223:
                    if (localObject3 == null) {
                        localObject1 = null;
                    }
                }
            }
        }
        localObject3 = q.a(paramCursor, "suggest_intent_data");
        localObject1 = localObject3;
        if (localObject3 == null) {
            localObject1 = this.mSearchable.getSuggestIntentData();
        }
        localObject3 = localObject1;
        if (localObject1 != null) {
            str = q.a(paramCursor, "suggest_intent_data_id");
            localObject3 = localObject1;
            if (str != null) {
                localObject3 = (String) localObject1 + "/" + Uri.encode(str);
                break label223;
                for (; ; ) {
                    localObject3 = q.a(paramCursor, "suggest_intent_query");
                    return createIntent((String) localObject2, (Uri) localObject1, q.a(paramCursor, "suggest_intent_extra_data"), (String) localObject3, paramInt, paramString);
                    localObject1 = Uri.parse((String) localObject3);
                }
            }
        }
    }

    private Intent createVoiceAppSearchIntent(Intent paramIntent, SearchableInfo paramSearchableInfo) {
        Object localObject3 = null;
        ComponentName localComponentName = paramSearchableInfo.getSearchActivity();
        Object localObject1 = new Intent("android.intent.action.SEARCH");
        ((Intent) localObject1).setComponent(localComponentName);
        PendingIntent localPendingIntent = PendingIntent.getActivity(getContext(), 0, (Intent) localObject1, 1073741824);
        Bundle localBundle = new Bundle();
        if (this.mAppSearchData != null) {
            localBundle.putParcelable("app_data", this.mAppSearchData);
        }
        Intent localIntent = new Intent(paramIntent);
        paramIntent = "free_form";
        int i = 1;
        Object localObject2 = getResources();
        if (paramSearchableInfo.getVoiceLanguageModeId() != 0) {
            paramIntent = ((Resources) localObject2).getString(paramSearchableInfo.getVoiceLanguageModeId());
        }
        if (paramSearchableInfo.getVoicePromptTextId() != 0) {
        }
        for (localObject1 = ((Resources) localObject2).getString(paramSearchableInfo.getVoicePromptTextId()); ; localObject1 = null) {
            if (paramSearchableInfo.getVoiceLanguageId() != 0) {
            }
            for (localObject2 = ((Resources) localObject2).getString(paramSearchableInfo.getVoiceLanguageId()); ; localObject2 = null) {
                if (paramSearchableInfo.getVoiceMaxResults() != 0) {
                    i = paramSearchableInfo.getVoiceMaxResults();
                }
                localIntent.putExtra("android.speech.extra.LANGUAGE_MODEL", paramIntent);
                localIntent.putExtra("android.speech.extra.PROMPT", (String) localObject1);
                localIntent.putExtra("android.speech.extra.LANGUAGE", (String) localObject2);
                localIntent.putExtra("android.speech.extra.MAX_RESULTS", i);
                if (localComponentName == null) {
                }
                for (paramIntent = (Intent) localObject3; ; paramIntent = localComponentName.flattenToShortString()) {
                    localIntent.putExtra("calling_package", paramIntent);
                    localIntent.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", localPendingIntent);
                    localIntent.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", localBundle);
                    return localIntent;
                }
            }
        }
    }

    private Intent createVoiceWebSearchIntent(Intent paramIntent, SearchableInfo paramSearchableInfo) {
        Intent localIntent = new Intent(paramIntent);
        paramIntent = paramSearchableInfo.getSearchActivity();
        if (paramIntent == null) {
        }
        for (paramIntent = null; ; paramIntent = paramIntent.flattenToShortString()) {
            localIntent.putExtra("calling_package", paramIntent);
            return localIntent;
        }
    }

    private void dismissSuggestions() {
        this.mQueryTextView.dismissDropDown();
    }

    private void forceSuggestionQuery() {
        HIDDEN_METHOD_INVOKER.a(this.mQueryTextView);
        HIDDEN_METHOD_INVOKER.b(this.mQueryTextView);
    }

    private CharSequence getDecoratedHint(CharSequence paramCharSequence) {
        if (!this.mIconifiedByDefault) {
            return paramCharSequence;
        }
        SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder("   ");
        localSpannableStringBuilder.append(paramCharSequence);
        paramCharSequence = getContext().getResources().getDrawable(getSearchIconId());
        int i = (int) (this.mQueryTextView.getTextSize() * 1.25D);
        paramCharSequence.setBounds(0, 0, i, i);
        localSpannableStringBuilder.setSpan(new ImageSpan(paramCharSequence), 1, 2, 33);
        return localSpannableStringBuilder;
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(android.support.v7.b.e.abc_search_view_preferred_width);
    }

    private int getSearchIconId() {
        TypedValue localTypedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(android.support.v7.b.c.searchViewSearchIcon, localTypedValue, true);
        return localTypedValue.resourceId;
    }

    private boolean hasVoiceSearch() {
        boolean bool2 = false;
        boolean bool1 = bool2;
        Intent localIntent;
        if (this.mSearchable != null) {
            bool1 = bool2;
            if (this.mSearchable.getVoiceSearchEnabled()) {
                localIntent = null;
                if (!this.mSearchable.getVoiceSearchLaunchWebSearch()) {
                    break label69;
                }
                localIntent = this.mVoiceWebSearchIntent;
            }
        }
        for (; ; ) {
            bool1 = bool2;
            if (localIntent != null) {
                bool1 = bool2;
                if (getContext().getPackageManager().resolveActivity(localIntent, 65536) != null) {
                    bool1 = true;
                }
            }
            return bool1;
            label69:
            if (this.mSearchable.getVoiceSearchLaunchRecognizer()) {
                localIntent = this.mVoiceAppSearchIntent;
            }
        }
    }

    static boolean isLandscapeMode(Context paramContext) {
        return paramContext.getResources().getConfiguration().orientation == 2;
    }

    private boolean isSubmitAreaEnabled() {
        return ((this.mSubmitButtonEnabled) || (this.mVoiceButtonEnabled)) && (!isIconified());
    }

    private void launchIntent(Intent paramIntent) {
        if (paramIntent == null) {
            return;
        }
        try {
            getContext().startActivity(paramIntent);
            return;
        } catch (RuntimeException localRuntimeException) {
            Log.e("SearchView", "Failed launch activity: " + paramIntent, localRuntimeException);
        }
    }

    private void launchQuerySearch(int paramInt, String paramString1, String paramString2) {
        paramString1 = createIntent("android.intent.action.SEARCH", null, null, paramString2, paramInt, paramString1);
        getContext().startActivity(paramString1);
    }

    private boolean launchSuggestion(int paramInt1, int paramInt2, String paramString) {
        Cursor localCursor = this.mSuggestionsAdapter.a();
        if ((localCursor != null) && (localCursor.moveToPosition(paramInt1))) {
            launchIntent(createIntentFromSuggestion(localCursor, paramInt2, paramString));
            return true;
        }
        return false;
    }

    private void onCloseClicked() {
        if (TextUtils.isEmpty(this.mQueryTextView.getText())) {
            if ((this.mIconifiedByDefault) && ((this.mOnCloseListener == null) || (!this.mOnCloseListener.a()))) {
                clearFocus();
                updateViewsVisibility(true);
            }
            return;
        }
        this.mQueryTextView.setText("");
        this.mQueryTextView.requestFocus();
        setImeVisibility(true);
    }

    private boolean onItemClicked(int paramInt1, int paramInt2, String paramString) {
        boolean bool = false;
        if ((this.mOnSuggestionListener == null) || (!this.mOnSuggestionListener.b(paramInt1))) {
            launchSuggestion(paramInt1, 0, null);
            setImeVisibility(false);
            dismissSuggestions();
            bool = true;
        }
        return bool;
    }

    private boolean onItemSelected(int paramInt) {
        if ((this.mOnSuggestionListener == null) || (!this.mOnSuggestionListener.a(paramInt))) {
            rewriteQueryFromSuggestion(paramInt);
            return true;
        }
        return false;
    }

    private void onSearchClicked() {
        updateViewsVisibility(false);
        this.mQueryTextView.requestFocus();
        setImeVisibility(true);
        if (this.mOnSearchClickListener != null) {
            this.mOnSearchClickListener.onClick(this);
        }
    }

    private void onSubmitQuery() {
        Editable localEditable = this.mQueryTextView.getText();
        if ((localEditable != null) && (TextUtils.getTrimmedLength(localEditable) > 0) && ((this.mOnQueryChangeListener == null) || (!this.mOnQueryChangeListener.a(localEditable.toString())))) {
            if (this.mSearchable != null) {
                launchQuerySearch(0, null, localEditable.toString());
                setImeVisibility(false);
            }
            dismissSuggestions();
        }
    }

    private boolean onSuggestionsKey(View paramView, int paramInt, KeyEvent paramKeyEvent) {
        if (this.mSearchable == null) {
        }
        do {
            do {
                return false;
            } while ((this.mSuggestionsAdapter == null) || (paramKeyEvent.getAction() != 0) || (!aa.a(paramKeyEvent)));
            if ((paramInt == 66) || (paramInt == 84) || (paramInt == 61)) {
                return onItemClicked(this.mQueryTextView.getListSelection(), 0, null);
            }
            if ((paramInt == 21) || (paramInt == 22)) {
                if (paramInt == 21) {
                }
                for (paramInt = 0; ; paramInt = this.mQueryTextView.length()) {
                    this.mQueryTextView.setSelection(paramInt);
                    this.mQueryTextView.setListSelection(0);
                    this.mQueryTextView.clearListSelection();
                    HIDDEN_METHOD_INVOKER.a(this.mQueryTextView, true);
                    return true;
                }
            }
        } while ((paramInt != 19) || (this.mQueryTextView.getListSelection() != 0));
        return false;
    }

    private void onTextChanged(CharSequence paramCharSequence) {
        boolean bool2 = true;
        Editable localEditable = this.mQueryTextView.getText();
        this.mUserQuery = localEditable;
        if (!TextUtils.isEmpty(localEditable)) {
            bool1 = true;
            updateSubmitButton(bool1);
            if (bool1) {
                break label97;
            }
        }
        label97:
        for (boolean bool1 = bool2; ; bool1 = false) {
            updateVoiceButton(bool1);
            updateCloseButton();
            updateSubmitArea();
            if ((this.mOnQueryChangeListener != null) && (!TextUtils.equals(paramCharSequence, this.mOldQueryText))) {
                this.mOnQueryChangeListener.b(paramCharSequence.toString());
            }
            this.mOldQueryText = paramCharSequence.toString();
            return;
            bool1 = false;
            break;
        }
    }

    private void onVoiceClicked() {
        if (this.mSearchable == null) {
        }
        do {
            return;
            Object localObject = this.mSearchable;
            try {
                if (((SearchableInfo) localObject).getVoiceSearchLaunchWebSearch()) {
                    localObject = createVoiceWebSearchIntent(this.mVoiceWebSearchIntent, (SearchableInfo) localObject);
                    getContext().startActivity((Intent) localObject);
                    return;
                }
            } catch (ActivityNotFoundException localActivityNotFoundException) {
                Log.w("SearchView", "Could not find voice search activity");
                return;
            }
        } while (!localActivityNotFoundException.getVoiceSearchLaunchRecognizer());
        Intent localIntent = createVoiceAppSearchIntent(this.mVoiceAppSearchIntent, localActivityNotFoundException);
        getContext().startActivity(localIntent);
    }

    private void postUpdateFocusedState() {
        post(this.mUpdateDrawableStateRunnable);
    }

    private void rewriteQueryFromSuggestion(int paramInt) {
        Editable localEditable = this.mQueryTextView.getText();
        Object localObject = this.mSuggestionsAdapter.a();
        if (localObject == null) {
            return;
        }
        if (((Cursor) localObject).moveToPosition(paramInt)) {
            localObject = this.mSuggestionsAdapter.c((Cursor) localObject);
            if (localObject != null) {
                setQuery((CharSequence) localObject);
                return;
            }
            setQuery(localEditable);
            return;
        }
        setQuery(localEditable);
    }

    private void setImeVisibility(boolean paramBoolean) {
        if (paramBoolean) {
            post(this.mShowImeRunnable);
        }
        InputMethodManager localInputMethodManager;
        do {
            return;
            removeCallbacks(this.mShowImeRunnable);
            localInputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        } while (localInputMethodManager == null);
        localInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
    }

    private void setQuery(CharSequence paramCharSequence) {
        this.mQueryTextView.setText(paramCharSequence);
        SearchView.SearchAutoComplete localSearchAutoComplete = this.mQueryTextView;
        if (TextUtils.isEmpty(paramCharSequence)) {
        }
        for (int i = 0; ; i = paramCharSequence.length()) {
            localSearchAutoComplete.setSelection(i);
            return;
        }
    }

    private void updateCloseButton() {
        int m = 1;
        int k = 0;
        int i;
        int j;
        label44:
        label56:
        Drawable localDrawable;
        if (!TextUtils.isEmpty(this.mQueryTextView.getText())) {
            i = 1;
            j = m;
            if (i == 0) {
                if ((!this.mIconifiedByDefault) || (this.mExpandedInActionView)) {
                    break label94;
                }
                j = m;
            }
            localObject = this.mCloseButton;
            if (j == 0) {
                break label99;
            }
            j = k;
            ((ImageView) localObject).setVisibility(j);
            localDrawable = this.mCloseButton.getDrawable();
            if (i == 0) {
                break label105;
            }
        }
        label94:
        label99:
        label105:
        for (Object localObject = ENABLED_STATE_SET; ; localObject = EMPTY_STATE_SET) {
            localDrawable.setState((int[]) localObject);
            return;
            i = 0;
            break;
            j = 0;
            break label44;
            j = 8;
            break label56;
        }
    }

    private void updateFocusedState() {
        boolean bool = this.mQueryTextView.hasFocus();
        Drawable localDrawable = this.mSearchPlate.getBackground();
        if (bool) {
            arrayOfInt = FOCUSED_STATE_SET;
            localDrawable.setState(arrayOfInt);
            localDrawable = this.mSubmitArea.getBackground();
            if (!bool) {
                break label64;
            }
        }
        label64:
        for (int[] arrayOfInt = FOCUSED_STATE_SET; ; arrayOfInt = EMPTY_STATE_SET) {
            localDrawable.setState(arrayOfInt);
            invalidate();
            return;
            arrayOfInt = EMPTY_STATE_SET;
            break;
        }
    }

    private void updateQueryHint() {
        if (this.mQueryHint != null) {
            this.mQueryTextView.setHint(getDecoratedHint(this.mQueryHint));
        }
        String str;
        do {
            return;
            if (this.mSearchable == null) {
                break;
            }
            str = null;
            int i = this.mSearchable.getHintId();
            if (i != 0) {
                str = getContext().getString(i);
            }
        } while (str == null);
        this.mQueryTextView.setHint(getDecoratedHint(str));
        return;
        this.mQueryTextView.setHint(getDecoratedHint(""));
    }

    private void updateSearchAutoComplete() {
        int j = 1;
        this.mQueryTextView.setThreshold(this.mSearchable.getSuggestThreshold());
        this.mQueryTextView.setImeOptions(this.mSearchable.getImeOptions());
        int k = this.mSearchable.getInputType();
        int i = k;
        if ((k & 0xF) == 1) {
            k &= 0xFFFEFFFF;
            i = k;
            if (this.mSearchable.getSuggestAuthority() != null) {
                i = k | 0x10000 | 0x80000;
            }
        }
        this.mQueryTextView.setInputType(i);
        if (this.mSuggestionsAdapter != null) {
            this.mSuggestionsAdapter.a(null);
        }
        if (this.mSearchable.getSuggestAuthority() != null) {
            this.mSuggestionsAdapter = new q(getContext(), this, this.mSearchable, this.mOutsideDrawablesCache);
            this.mQueryTextView.setAdapter(this.mSuggestionsAdapter);
            q localq = (q) this.mSuggestionsAdapter;
            i = j;
            if (this.mQueryRefinement) {
                i = 2;
            }
            localq.a(i);
        }
    }

    private void updateSubmitArea() {
        int j = 8;
        int i = j;
        if (isSubmitAreaEnabled()) {
            if (this.mSubmitButton.getVisibility() != 0) {
                i = j;
                if (this.mVoiceButton.getVisibility() != 0) {
                }
            } else {
                i = 0;
            }
        }
        this.mSubmitArea.setVisibility(i);
    }

    private void updateSubmitButton(boolean paramBoolean) {
        int j = 8;
        int i = j;
        if (this.mSubmitButtonEnabled) {
            i = j;
            if (isSubmitAreaEnabled()) {
                i = j;
                if (hasFocus()) {
                    if (!paramBoolean) {
                        i = j;
                        if (this.mVoiceButtonEnabled) {
                        }
                    } else {
                        i = 0;
                    }
                }
            }
        }
        this.mSubmitButton.setVisibility(i);
    }

    private void updateViewsVisibility(boolean paramBoolean) {
        boolean bool2 = true;
        int j = 8;
        this.mIconified = paramBoolean;
        int i;
        boolean bool1;
        if (paramBoolean) {
            i = 0;
            if (TextUtils.isEmpty(this.mQueryTextView.getText())) {
                break label115;
            }
            bool1 = true;
            label33:
            this.mSearchButton.setVisibility(i);
            updateSubmitButton(bool1);
            Object localObject = this.mSearchEditFrame;
            if (!paramBoolean) {
                break label121;
            }
            i = 8;
            label60:
            ((View) localObject).setVisibility(i);
            localObject = this.mSearchHintIcon;
            if (!this.mIconifiedByDefault) {
                break label126;
            }
            i = j;
            label81:
            ((ImageView) localObject).setVisibility(i);
            updateCloseButton();
            if (bool1) {
                break label131;
            }
        }
        label115:
        label121:
        label126:
        label131:
        for (paramBoolean = bool2; ; paramBoolean = false) {
            updateVoiceButton(paramBoolean);
            updateSubmitArea();
            return;
            i = 8;
            break;
            bool1 = false;
            break label33;
            i = 0;
            break label60;
            i = 0;
            break label81;
        }
    }

    private void updateVoiceButton(boolean paramBoolean) {
        int i;
        if ((this.mVoiceButtonEnabled) && (!isIconified()) && (paramBoolean)) {
            i = 0;
            this.mSubmitButton.setVisibility(8);
        }
        for (; ; ) {
            this.mVoiceButton.setVisibility(i);
            return;
            i = 8;
        }
    }

    public void clearFocus() {
        this.mClearingFocus = true;
        setImeVisibility(false);
        super.clearFocus();
        this.mQueryTextView.clearFocus();
        this.mClearingFocus = false;
    }

    public int getImeOptions() {
        return this.mQueryTextView.getImeOptions();
    }

    public int getInputType() {
        return this.mQueryTextView.getInputType();
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    public CharSequence getQuery() {
        return this.mQueryTextView.getText();
    }

    public CharSequence getQueryHint() {
        Object localObject2 = null;
        Object localObject1;
        if (this.mQueryHint != null) {
            localObject1 = this.mQueryHint;
        }
        int i;
        do {
            do {
                return (CharSequence) localObject1;
                localObject1 = localObject2;
            } while (this.mSearchable == null);
            i = this.mSearchable.getHintId();
            localObject1 = localObject2;
        } while (i == 0);
        return getContext().getString(i);
    }

    public android.support.v4.widget.a getSuggestionsAdapter() {
        return this.mSuggestionsAdapter;
    }

    public boolean isIconfiedByDefault() {
        return this.mIconifiedByDefault;
    }

    public boolean isIconified() {
        return this.mIconified;
    }

    public boolean isQueryRefinementEnabled() {
        return this.mQueryRefinement;
    }

    public boolean isSubmitButtonEnabled() {
        return this.mSubmitButtonEnabled;
    }

    public void onActionViewCollapsed() {
        clearFocus();
        updateViewsVisibility(true);
        this.mQueryTextView.setImeOptions(this.mCollapsedImeOptions);
        this.mExpandedInActionView = false;
    }

    public void onActionViewExpanded() {
        if (this.mExpandedInActionView) {
            return;
        }
        this.mExpandedInActionView = true;
        this.mCollapsedImeOptions = this.mQueryTextView.getImeOptions();
        this.mQueryTextView.setImeOptions(this.mCollapsedImeOptions | 0x2000000);
        this.mQueryTextView.setText("");
        setIconified(false);
    }

    protected void onDetachedFromWindow() {
        removeCallbacks(this.mUpdateDrawableStateRunnable);
        post(this.mReleaseCursorRunnable);
        super.onDetachedFromWindow();
    }

    public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
        if (this.mSearchable == null) {
            return false;
        }
        return super.onKeyDown(paramInt, paramKeyEvent);
    }

    protected void onMeasure(int paramInt1, int paramInt2) {
        if (isIconified()) {
            super.onMeasure(paramInt1, paramInt2);
            return;
        }
        int j = View.MeasureSpec.getMode(paramInt1);
        int i = View.MeasureSpec.getSize(paramInt1);
        switch (j) {
            default:
                paramInt1 = i;
        }
        for (; ; ) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), paramInt2);
            return;
            if (this.mMaxWidth > 0) {
                paramInt1 = Math.min(this.mMaxWidth, i);
            } else {
                paramInt1 = Math.min(getPreferredWidth(), i);
                continue;
                paramInt1 = i;
                if (this.mMaxWidth > 0) {
                    paramInt1 = Math.min(this.mMaxWidth, i);
                    continue;
                    if (this.mMaxWidth > 0) {
                        paramInt1 = this.mMaxWidth;
                    } else {
                        paramInt1 = getPreferredWidth();
                    }
                }
            }
        }
    }

    void onQueryRefine(CharSequence paramCharSequence) {
        setQuery(paramCharSequence);
    }

    void onTextFocusChanged() {
        updateViewsVisibility(isIconified());
        postUpdateFocusedState();
        if (this.mQueryTextView.hasFocus()) {
            forceSuggestionQuery();
        }
    }

    public void onWindowFocusChanged(boolean paramBoolean) {
        super.onWindowFocusChanged(paramBoolean);
        postUpdateFocusedState();
    }

    public boolean requestFocus(int paramInt, Rect paramRect) {
        if (this.mClearingFocus) {
        }
        while (!isFocusable()) {
            return false;
        }
        if (!isIconified()) {
            boolean bool = this.mQueryTextView.requestFocus(paramInt, paramRect);
            if (bool) {
                updateViewsVisibility(false);
            }
            return bool;
        }
        return super.requestFocus(paramInt, paramRect);
    }

    public void setAppSearchData(Bundle paramBundle) {
        this.mAppSearchData = paramBundle;
    }

    public void setIconified(boolean paramBoolean) {
        if (paramBoolean) {
            onCloseClicked();
            return;
        }
        onSearchClicked();
    }

    public void setIconifiedByDefault(boolean paramBoolean) {
        if (this.mIconifiedByDefault == paramBoolean) {
            return;
        }
        this.mIconifiedByDefault = paramBoolean;
        updateViewsVisibility(paramBoolean);
        updateQueryHint();
    }

    public void setImeOptions(int paramInt) {
        this.mQueryTextView.setImeOptions(paramInt);
    }

    public void setInputType(int paramInt) {
        this.mQueryTextView.setInputType(paramInt);
    }

    public void setMaxWidth(int paramInt) {
        this.mMaxWidth = paramInt;
        requestLayout();
    }

    public void setOnCloseListener(n paramn) {
        this.mOnCloseListener = paramn;
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener) {
        this.mOnQueryTextFocusChangeListener = paramOnFocusChangeListener;
    }

    public void setOnQueryTextListener(o paramo) {
        this.mOnQueryChangeListener = paramo;
    }

    public void setOnSearchClickListener(View.OnClickListener paramOnClickListener) {
        this.mOnSearchClickListener = paramOnClickListener;
    }

    public void setOnSuggestionListener(p paramp) {
        this.mOnSuggestionListener = paramp;
    }

    public void setQuery(CharSequence paramCharSequence, boolean paramBoolean) {
        this.mQueryTextView.setText(paramCharSequence);
        if (paramCharSequence != null) {
            this.mQueryTextView.setSelection(this.mQueryTextView.length());
            this.mUserQuery = paramCharSequence;
        }
        if ((paramBoolean) && (!TextUtils.isEmpty(paramCharSequence))) {
            onSubmitQuery();
        }
    }

    public void setQueryHint(CharSequence paramCharSequence) {
        this.mQueryHint = paramCharSequence;
        updateQueryHint();
    }

    public void setQueryRefinementEnabled(boolean paramBoolean) {
        this.mQueryRefinement = paramBoolean;
        q localq;
        if ((this.mSuggestionsAdapter instanceof q)) {
            localq = (q) this.mSuggestionsAdapter;
            if (!paramBoolean) {
                break label35;
            }
        }
        label35:
        for (int i = 2; ; i = 1) {
            localq.a(i);
            return;
        }
    }

    public void setSearchableInfo(SearchableInfo paramSearchableInfo) {
        this.mSearchable = paramSearchableInfo;
        if (this.mSearchable != null) {
            updateSearchAutoComplete();
            updateQueryHint();
        }
        this.mVoiceButtonEnabled = hasVoiceSearch();
        if (this.mVoiceButtonEnabled) {
            this.mQueryTextView.setPrivateImeOptions("nm");
        }
        updateViewsVisibility(isIconified());
    }

    public void setSubmitButtonEnabled(boolean paramBoolean) {
        this.mSubmitButtonEnabled = paramBoolean;
        updateViewsVisibility(isIconified());
    }

    public void setSuggestionsAdapter(android.support.v4.widget.a parama) {
        this.mSuggestionsAdapter = parama;
        this.mQueryTextView.setAdapter(this.mSuggestionsAdapter);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v7/widget/SearchView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */