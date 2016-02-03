package com.inneractive.api.ads.sdk;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

import java.io.File;
import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.http.Header;
import org.apache.http.HttpResponse;

final class IAmraidWebViewController {
    private static final int CLOSE_BUTTON_SIZE_DP = 50;
    private static final String[] DATE_FORMATS = {"yyyy-MM-dd'T'HH:mm:ssZZZZZ", "yyyy-MM-dd'T'HH:mmZZZZZ"};
    private static final int MAX_NUMBER_DAYS_IN_MONTH = 31;
    protected IAmraidWebViewController.ForceOrientationType forceOrientation = IAmraidWebViewController.ForceOrientationType.NONE;
    private FrameLayout mAdContainerLayout;
    protected int mAdHeight = -1;
    private boolean mAdWantsCustomCloseButton;
    protected int mAdWidth = -1;
    private ImageView mCloseButton;
    protected float mDensity;
    private RelativeLayout mExpandLayout;
    private final IAmraidWebView.ExpandMode mExpandMode;
    private Handler mHandler = new Handler();
    protected int mMaxHeight = -1;
    protected int mMaxWidth = -1;
    IAmraidWebView mMraidView;
    private final IAmraidWebView.NativeCloseButtonMode mNativeCloseButtonMode;
    private IAmraidWebViewController.b mOrientationBroadcastReceiver = new IAmraidWebViewController.b(this);
    private final int mOriginalRequestedOrientation;
    private FrameLayout mPlaceholderView;
    private FrameLayout mRootView;
    protected int mScreenHeight = -1;
    protected int mScreenWidth = -1;
    private IAmraidWebView mSecondExpandView;
    private int mViewIndexInParent;
    private IAbaseWebView.IAviewState mViewState = IAbaseWebView.IAviewState.e;
    View resizedContentView;

    IAmraidWebViewController(IAmraidWebView paramIAmraidWebView, IAmraidWebView.ExpandMode paramExpandMode, IAmraidWebView.NativeCloseButtonMode paramNativeCloseButtonMode) {
        this.mMraidView = paramIAmraidWebView;
        this.mExpandMode = paramExpandMode;
        this.mNativeCloseButtonMode = paramNativeCloseButtonMode;
        paramIAmraidWebView = getContext();
        if ((paramIAmraidWebView instanceof Activity)) {
        }
        for (int i = ((Activity) paramIAmraidWebView).getRequestedOrientation(); ; i = -1) {
            this.mOriginalRequestedOrientation = i;
            this.mAdContainerLayout = generateAdContainerLayout();
            this.mExpandLayout = generateExpandLayout();
            this.mPlaceholderView = generatePlaceholderView();
            initialize();
            this.mMraidView.setOnKeyListener(new IAmraidWebViewController .1 (this));
            return;
        }
    }

    private String dayNumberToDayOfMonthString(int paramInt) {
        if ((paramInt != 0) && (paramInt >= -31) && (paramInt <= 31)) {
            return paramInt;
        }
        throw new IllegalArgumentException("invalid day of month " + paramInt);
    }

    private String dayNumberToDayOfWeekString(int paramInt) {
        switch (paramInt) {
            default:
                throw new IllegalArgumentException("invalid day of week " + paramInt);
            case 0:
                return "SU";
            case 1:
                return "MO";
            case 2:
                return "TU";
            case 3:
                return "WE";
            case 4:
                return "TH";
            case 5:
                return "FR";
        }
        return "SA";
    }

    private void displayDialog(String paramString) {
        new AlertDialog.Builder(getContext()).setTitle("Save Image").setMessage("Download image to Picture gallery?").setNegativeButton("Cancel", null).setPositiveButton("Okay", new IAmraidWebViewController
        .5 (this, paramString)).setCancelable(true).show();
    }

    private void displayToast(String paramString) {
        this.mHandler.post(new IAmraidWebViewController .3 (this, paramString));
    }

    private void downloadImage(String paramString) {
        File localFile = getPictureStoragePath();
        localFile.mkdirs();
        new Thread(new IAmraidWebViewController .4 (this, paramString, localFile)).start();
    }

    private void expandLayouts(View paramView, int paramInt1, int paramInt2) {
        int i = (int) (50.0F * this.mDensity + 0.5F);
        int j = paramInt1;
        if (paramInt1 < i) {
            j = i;
        }
        paramInt1 = paramInt2;
        if (paramInt2 < i) {
            paramInt1 = i;
        }
        View localView = new View(getContext());
        localView.setBackgroundColor(0);
        localView.setOnTouchListener(new IAmraidWebViewController .6 (this));
        this.mExpandLayout.addView(localView, new RelativeLayout.LayoutParams(-1, -1));
        c.a(paramView);
        this.mAdContainerLayout.addView(paramView, new RelativeLayout.LayoutParams(-1, -1));
        c.a(this.mAdContainerLayout);
        paramView = new RelativeLayout.LayoutParams(j, paramInt1);
        paramView.addRule(13);
        this.mExpandLayout.addView(this.mAdContainerLayout, paramView);
    }

    private Context getContext() {
        return getView().getContext();
    }

    private int getDisplayOrientation() {
        return ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getOrientation();
    }

    private String getFileNameForUriAndHttpResponse(URI paramURI, HttpResponse paramHttpResponse) {
        paramURI = paramURI.getPath();
        if (paramURI == null) {
            paramURI = null;
        }
        String str;
        do {
            return paramURI;
            str = new File(paramURI).getName();
            paramHttpResponse = paramHttpResponse.getFirstHeader("text/html");
            paramURI = str;
        } while (paramHttpResponse == null);
        paramHttpResponse = paramHttpResponse.getValue().split(";");
        int j = paramHttpResponse.length;
        int i = 0;
        for (; ; ) {
            paramURI = str;
            if (i >= j) {
                break;
            }
            paramURI = paramHttpResponse[i];
            if (paramURI.contains("image/")) {
                paramHttpResponse = "." + paramURI.split("/")[1];
                paramURI = str;
                if (str.endsWith(paramHttpResponse)) {
                    break;
                }
                return str + paramHttpResponse;
            }
            i += 1;
        }
    }

    private File getPictureStoragePath() {
        return new File(Environment.getExternalStorageDirectory(), "Pictures");
    }

    private void initialize() {
        this.mViewState = IAbaseWebView.IAviewState.a;
        initializeScreenMetrics();
        this.mOrientationBroadcastReceiver.register(getContext());
    }

    private void initializeScreenMetrics() {
        int j = 0;
        Object localObject = getContext();
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        ((WindowManager) ((Context) localObject).getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
        this.mDensity = localDisplayMetrics.density;
        if ((localObject instanceof Activity)) {
            localObject = ((Activity) localObject).getWindow();
            Rect localRect = new Rect();
            ((Window) localObject).getDecorView().getWindowVisibleDisplayFrame(localRect);
            j = localRect.top;
        }
        for (int i = ((Window) localObject).findViewById(16908290).getTop() - j; ; i = 0) {
            int k = localDisplayMetrics.widthPixels;
            int m = localDisplayMetrics.heightPixels;
            this.mScreenWidth = ((int) (k * (160.0D / localDisplayMetrics.densityDpi)));
            this.mScreenHeight = ((int) (m * (160.0D / localDisplayMetrics.densityDpi)));
            m = localDisplayMetrics.heightPixels;
            this.mMaxWidth = ((int) (k * (160.0D / localDisplayMetrics.densityDpi)));
            this.mMaxHeight = ((int) ((m - j - i) * (160.0D / localDisplayMetrics.densityDpi)));
            return;
        }
    }

    private void onOrientationChanged(int paramInt) {
        initializeScreenMetrics();
        getView().fireChangeEventForAsset(J.a(this.mScreenWidth, this.mScreenHeight));
        getView().fireChangeEventForAsset(H.a(this.mMaxWidth, this.mMaxHeight));
        if ((this.mAdWidth != -1) && (this.mAdHeight != -1)) {
            getView().fireChangeEventForAsset(F.a(this.mAdWidth, this.mAdHeight));
        }
    }

    private Date parseDate(String paramString) {
        Object localObject1 = null;
        int i = 0;
        for (; ; ) {
            Object localObject2 = localObject1;
            if (i < DATE_FORMATS.length) {
            }
            try {
                localObject2 = new SimpleDateFormat(DATE_FORMATS[i]).parse(paramString);
                localObject1 = localObject2;
                localObject2 = localObject1;
                if (localObject1 != null) {
                    localObject2 = localObject1;
                    return (Date) localObject2;
                }
            } catch (ParseException localParseException) {
                Object localObject3 = localObject1;
                i += 1;
                localObject1 = localObject3;
            }
        }
    }

    private String parseRecurrenceRule(Map paramMap) {
        StringBuilder localStringBuilder = new StringBuilder();
        String str;
        if (paramMap.containsKey("frequency")) {
            str = (String) paramMap.get("frequency");
            if (!paramMap.containsKey("interval")) {
                break label381;
            }
        }
        label381:
        for (int i = Integer.parseInt((String) paramMap.get("interval")); ; i = -1) {
            if ("daily".equals(str)) {
                localStringBuilder.append("FREQ=DAILY;");
                if (i != -1) {
                    localStringBuilder.append("INTERVAL=" + i + ";");
                }
            }
            for (; ; ) {
                return localStringBuilder.toString();
                if ("weekly".equals(str)) {
                    localStringBuilder.append("FREQ=WEEKLY;");
                    if (i != -1) {
                        localStringBuilder.append("INTERVAL=" + i + ";");
                    }
                    if (paramMap.containsKey("daysInWeek")) {
                        paramMap = translateWeekIntegersToDays((String) paramMap.get("daysInWeek"));
                        if (paramMap == null) {
                            throw new IllegalArgumentException("invalid ");
                        }
                        localStringBuilder.append("BYDAY=" + paramMap + ";");
                    }
                } else {
                    if (!"monthly".equals(str)) {
                        break;
                    }
                    localStringBuilder.append("FREQ=MONTHLY;");
                    if (i != -1) {
                        localStringBuilder.append("INTERVAL=" + i + ";");
                    }
                    if (paramMap.containsKey("daysInMonth")) {
                        paramMap = translateMonthIntegersToDays((String) paramMap.get("daysInMonth"));
                        if (paramMap == null) {
                            throw new IllegalArgumentException();
                        }
                        localStringBuilder.append("BYMONTHDAY=" + paramMap + ";");
                    }
                }
            }
            throw new IllegalArgumentException("frequency is only supported for daily, weekly, and monthly.");
        }
    }

    private void resetToDefaultState() {
        setNativeCloseButtonEnabled(false);
        this.mAdContainerLayout.removeAllViewsInLayout();
        this.mExpandLayout.removeAllViewsInLayout();
        if (this.mRootView != null) {
            this.mRootView.removeView(this.mExpandLayout);
        }
        Object localObject;
        if (this.resizedContentView != null) {
            localObject = getContext();
            if (!c.l((Context) localObject)) {
                break label158;
            }
            c.a(IAdefines.IAbannerDefaultHeight.d.e, (Context) localObject);
        }
        for (; ; ) {
            this.resizedContentView.setLayoutParams(getView().getAdConfig().a(getView(), getContext()));
            getView().requestLayout();
            localObject = (ViewGroup) this.mPlaceholderView.getParent();
            if (localObject != null) {
                ((ViewGroup) localObject).addView(getView(), this.mViewIndexInParent, getView().getAdConfig().a(getView(), getContext()));
                ((ViewGroup) localObject).removeView(this.mPlaceholderView);
                ((ViewGroup) localObject).invalidate();
            }
            return;
            label158:
            if (c.m((Context) localObject)) {
                if (c.n((Context) localObject) == 1) {
                }
                for (float f = IAdefines.IAbannerDefaultHeight.b.e; ; f = IAdefines.IAbannerDefaultHeight.c.e) {
                    c.a(f, (Context) localObject);
                    break;
                }
            }
            c.a(IAdefines.IAbannerDefaultHeight.a.e, (Context) localObject);
        }
    }

    private void setOrientationLock(IAmraidWebViewController.ForceOrientationType paramForceOrientationType) {
        paramForceOrientationType = this.mViewState;
        paramForceOrientationType = IAbaseWebView.IAviewState.c;
    }

    private void setOrientationLockEnabled(boolean paramBoolean) {
        Object localObject = getContext();
        try {
            localObject = (Activity) localObject;
            if (paramBoolean) {
            }
            for (int i = ((Activity) localObject).getResources().getConfiguration().orientation; ; i = this.mOriginalRequestedOrientation) {
                ((Activity) localObject).setRequestedOrientation(i);
                return;
            }
            return;
        } catch (ClassCastException localClassCastException) {
            InneractiveAdView.Log.d("Inneractive_debug", "Failed to modify the device orientation.");
        }
    }

    private void swapViewWithPlaceholderView() {
        ViewGroup localViewGroup = (ViewGroup) getView().getParent();
        if (localViewGroup == null) {
            return;
        }
        int j = localViewGroup.getChildCount();
        int i = 0;
        while ((i < j) && (localViewGroup.getChildAt(i) != getView())) {
            i += 1;
        }
        this.mViewIndexInParent = i;
        c.a(this.mPlaceholderView);
        localViewGroup.addView(this.mPlaceholderView, i, new ViewGroup.LayoutParams(getView().getWidth(), getView().getHeight()));
        localViewGroup.removeView(getView());
    }

    private Map translateJSParamsToAndroidCalendarEventMapping(Map paramMap) {
        HashMap localHashMap = new HashMap();
        if ((!paramMap.containsKey("description")) || (!paramMap.containsKey("start"))) {
            throw new IllegalArgumentException("Missing start and description fields");
        }
        localHashMap.put("title", paramMap.get("description"));
        if ((paramMap.containsKey("start")) && (paramMap.get("start") != null)) {
            Date localDate = parseDate((String) paramMap.get("start"));
            if (localDate != null) {
                localHashMap.put("beginTime", Long.valueOf(localDate.getTime()));
                if ((paramMap.containsKey("end")) && (paramMap.get("end") != null)) {
                    localDate = parseDate((String) paramMap.get("end"));
                    if (localDate == null) {
                        break label339;
                    }
                    localHashMap.put("endTime", Long.valueOf(localDate.getTime()));
                }
                if (paramMap.containsKey("location")) {
                    localHashMap.put("eventLocation", paramMap.get("location"));
                }
                if (paramMap.containsKey("summary")) {
                    localHashMap.put("description", paramMap.get("summary"));
                }
                if (paramMap.containsKey("transparency")) {
                    if (!"transparent".equals(paramMap.get("transparency"))) {
                        break label350;
                    }
                }
            }
        }
        label339:
        label350:
        for (int i = 1; ; i = 0) {
            localHashMap.put("availability", Integer.valueOf(i));
            localHashMap.put("rrule", parseRecurrenceRule(paramMap));
            return localHashMap;
            throw new IllegalArgumentException("Invalid calendar event: start time is malformed. Date format expecting (yyyy-MM-DDTHH:MM:SS-xx:xx) or (yyyy-MM-DDTHH:MM-xx:xx) i.e. 2013-08-14T09:00:01-08:00");
            throw new IllegalArgumentException("Invalid calendar event: start is null.");
            throw new IllegalArgumentException("Invalid calendar event: end time is malformed. Date format expecting (yyyy-MM-DDTHH:MM:SS-xx:xx) or (yyyy-MM-DDTHH:MM-xx:xx) i.e. 2013-08-14T09:00:01-08:00");
        }
    }

    private String translateMonthIntegersToDays(String paramString) {
        StringBuilder localStringBuilder = new StringBuilder();
        boolean[] arrayOfBoolean = new boolean[63];
        paramString = paramString.split(",");
        int i = 0;
        while (i < paramString.length) {
            int j = Integer.parseInt(paramString[i]);
            if (arrayOfBoolean[(j + 31)] == 0) {
                localStringBuilder.append(dayNumberToDayOfMonthString(j) + ",");
                arrayOfBoolean[(j + 31)] = true;
            }
            i += 1;
        }
        if (paramString.length == 0) {
            throw new IllegalArgumentException("must have at least 1 day of the month if specifying repeating weekly");
        }
        localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
        return localStringBuilder.toString();
    }

    private String translateWeekIntegersToDays(String paramString) {
        StringBuilder localStringBuilder = new StringBuilder();
        boolean[] arrayOfBoolean = new boolean[7];
        paramString = paramString.split(",");
        int i = 0;
        while (i < paramString.length) {
            int k = Integer.parseInt(paramString[i]);
            int j = k;
            if (k == 7) {
                j = 0;
            }
            if (arrayOfBoolean[j] == 0) {
                localStringBuilder.append(dayNumberToDayOfWeekString(j) + ",");
                arrayOfBoolean[j] = true;
            }
            i += 1;
        }
        if (paramString.length == 0) {
            throw new IllegalArgumentException("must have at least 1 day of the week if specifying repeating weekly");
        }
        localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
        return localStringBuilder.toString();
    }

    protected final void close() {
        if ((this.mViewState == IAbaseWebView.IAviewState.c) || (this.mViewState == IAbaseWebView.IAviewState.d)) {
            resetToDefaultState();
            setOrientationLockEnabled(false);
            this.mViewState = IAbaseWebView.IAviewState.b;
            getView().fireChangeEventForAsset(K.a(this.mViewState));
        }
        for (; ; ) {
            if (getView().getListener() != null) {
                getView().getListener().onClose(getView(), this.mViewState);
            }
            return;
            if (this.mViewState == IAbaseWebView.IAviewState.b) {
                getView().setVisibility(4);
                this.mViewState = IAbaseWebView.IAviewState.e;
                getView().fireChangeEventForAsset(K.a(this.mViewState));
            }
        }
    }

    protected final void createCalendarEvent(Map paramMap) {
        Context localContext = getView().getContext();
        if (c.k(localContext)) {
            Intent localIntent;
            try {
                paramMap = translateJSParamsToAndroidCalendarEventMapping(paramMap);
                localIntent = new Intent("android.intent.action.INSERT").setType("vnd.android.cursor.item/event");
                Iterator localIterator = paramMap.keySet().iterator();
                for (; ; ) {
                    if (!localIterator.hasNext()) {
                        break label240;
                    }
                    str = (String) localIterator.next();
                    localObject = paramMap.get(str);
                    if (!(localObject instanceof Long)) {
                        break;
                    }
                    localIntent.putExtra(str, ((Long) localObject).longValue());
                }
            } catch (ActivityNotFoundException paramMap) {
                for (; ; ) {
                    InneractiveAdView.Log.d("Inneractive_debug", "There is no calendar app installed!");
                    getView().fireErrorEvent(IAmraidActionFactory.MraidJavascriptCommand.o, "Action is unsupported on this device - no calendar app installed");
                    return;
                    if (!(localObject instanceof Integer)) {
                        break;
                    }
                    localIntent.putExtra(str, ((Integer) localObject).intValue());
                }
            } catch (IllegalArgumentException paramMap) {
                for (; ; ) {
                    String str;
                    Object localObject;
                    InneractiveAdView.Log.d("Inneractive_debug", "invalid parameters for create calendar " + paramMap.getMessage());
                    getView().fireErrorEvent(IAmraidActionFactory.MraidJavascriptCommand.o, paramMap.getMessage());
                    return;
                    localIntent.putExtra(str, (String) localObject);
                }
            } catch (Exception paramMap) {
                InneractiveAdView.Log.d("Inneractive_debug", "Failed to create calendar event.");
                getView().fireErrorEvent(IAmraidActionFactory.MraidJavascriptCommand.o, "could not create calendar event");
                return;
            }
            label240:
            localIntent.setFlags(268435456);
            localContext.startActivity(localIntent);
            return;
        }
        InneractiveAdView.Log.d("Inneractive_debug", "createCalendarEvent supported for devices post-ICS");
        getView().fireErrorEvent(IAmraidActionFactory.MraidJavascriptCommand.o, "Action is unsupported on this device (need Android version Ice Cream Sandwich or above)");
    }

    public final void destroy() {
        try {
            this.mOrientationBroadcastReceiver.unregister();
            return;
        } catch (IllegalArgumentException localIllegalArgumentException) {
            while (localIllegalArgumentException.getMessage().contains("Receiver not registered")) {
            }
            throw localIllegalArgumentException;
        }
    }

    protected final void displayDownloadImageAlert(String paramString) {
        Context localContext = getContext();
        if (!c.j(localContext)) {
            getView().fireErrorEvent(IAmraidActionFactory.MraidJavascriptCommand.j, "Error downloading file - the device does not have an SD card mounted, or the Android permission is not granted.");
            InneractiveAdView.Log.d("Inneractive_debug", "Error downloading file. Please check if the Android permission is not granted, or maybe the device does not have an SD card mounted? ");
            return;
        }
        if ((localContext instanceof Activity)) {
            displayDialog(paramString);
            return;
        }
        displayToast("Downloading image to Picture gallery...");
        downloadImage(paramString);
    }

    protected final void displayVideo(String paramString) {
        InneractiveRichMediaVideoPlayerActivity.a(getContext(), paramString);
    }

    protected final void expand(String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2) {
        if (this.mExpandMode == IAmraidWebView.ExpandMode.DISABLED) {
        }
        do {
            do {
                return;
            } while (this.mViewState != IAbaseWebView.IAviewState.b);
            if ((paramString != null) && (!URLUtil.isValidUrl(paramString))) {
                getView().fireErrorEvent(IAmraidActionFactory.MraidJavascriptCommand.b, "URL passed to expand() was invalid.");
                return;
            }
            this.mRootView = ((FrameLayout) getView().getRootView().findViewById(16908290));
            useCustomClose(paramBoolean1);
            setOrientationLockEnabled(paramBoolean2);
            swapViewWithPlaceholderView();
            this.mAdHeight = paramInt2;
            this.mAdWidth = paramInt1;
            IAmraidWebView localIAmraidWebView = getView();
            if (paramString != null) {
                this.mSecondExpandView = N.createInstance(getContext(), getView().getAdConfig(), IAmraidWebView.ExpandMode.DISABLED, IAmraidWebView.NativeCloseButtonMode.AD_CONTROLLED, IAmraidWebView.MraidPlacementType.INLINE);
                this.mSecondExpandView.setListener(new IAmraidWebViewController .2 (this));
                this.mSecondExpandView.loadUrl(paramString);
                localIAmraidWebView = this.mSecondExpandView;
            }
            expandLayouts(localIAmraidWebView, (int) (paramInt1 * this.mDensity), (int) (paramInt2 * this.mDensity));
            c.a(this.mExpandLayout);
            this.mRootView.addView(this.mExpandLayout, new RelativeLayout.LayoutParams(-2, -2));
            if ((localIAmraidWebView != null) && (!localIAmraidWebView.hasFocus())) {
                localIAmraidWebView.requestFocus();
            }
            if ((this.mNativeCloseButtonMode == IAmraidWebView.NativeCloseButtonMode.ALWAYS_VISIBLE) || ((!this.mAdWantsCustomCloseButton) && (this.mNativeCloseButtonMode != IAmraidWebView.NativeCloseButtonMode.ALWAYS_HIDDEN))) {
                setNativeCloseButtonEnabled(true);
            }
            this.mViewState = IAbaseWebView.IAviewState.c;
            getView().fireChangeEventForAsset(K.a(this.mViewState));
            if ((this.mAdWidth != -1) && (this.mAdHeight != -1)) {
                getView().fireChangeEventForAsset(F.a(this.mAdWidth, this.mAdHeight));
            }
        } while (getView().getListener() == null);
        getView().getListener().onExpand(getView());
    }

    final FrameLayout generateAdContainerLayout() {
        return new FrameLayout(getContext());
    }

    final RelativeLayout generateExpandLayout() {
        return new RelativeLayout(getContext());
    }

    final FrameLayout generatePlaceholderView() {
        return new FrameLayout(getContext());
    }

    protected final void getCurrentPosition() {
        getView().fireErrorEvent(IAmraidActionFactory.MraidJavascriptCommand.k, "Unsupported action getCurrentPosition");
    }

    protected final void getDefaultPosition() {
        getView().fireErrorEvent(IAmraidActionFactory.MraidJavascriptCommand.l, "Unsupported action getDefaultPosition");
    }

    protected final void getMaxSize() {
        getView().fireChangeEventForAsset(H.a(this.mMaxWidth, this.mMaxHeight));
    }

    protected final void getResizeProperties() {
    }

    protected final void getScreenSize() {
        getView().fireChangeEventForAsset(J.a(this.mScreenWidth, this.mScreenHeight));
    }

    public final IAmraidWebView getView() {
        return this.mMraidView;
    }

    protected final void initializeJavaScriptState() {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(J.a(this.mScreenWidth, this.mScreenHeight));
        localArrayList.add(H.a(this.mMaxWidth, this.mMaxHeight));
        getView().fireChangeEventForAssets(localArrayList);
        this.mViewState = IAbaseWebView.IAviewState.b;
        getView().fireChangeEventForAsset(K.a(this.mViewState));
        initializeSupportedFunctionsAssets();
    }

    protected final void initializeSupportedFunctionsAssets() {
        Context localContext = getContext();
        IAmraidWebView localIAmraidWebView = getView();
        L localL = new L();
        Intent localIntent = new Intent("android.intent.action.DIAL");
        localIntent.setData(Uri.parse("tel:"));
        localL = localL.b(c.a(localContext, localIntent));
        localIntent = new Intent("android.intent.action.VIEW");
        localIntent.setData(Uri.parse("sms:"));
        localIAmraidWebView.fireChangeEventForAsset(localL.a(c.a(localContext, localIntent)).c(c.k(localContext)).e(c.a(localContext, new Intent(localContext, InneractiveRichMediaVideoPlayerActivity.class))).d(c.j(localContext)));
    }

    protected final boolean isExpanded() {
        return this.mViewState == IAbaseWebView.IAviewState.c;
    }

    protected final void resize(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, String paramString) {
        int j = 0;
        this.mRootView = ((FrameLayout) getView().getRootView().findViewById(16908290));
        if (this.mExpandMode == IAmraidWebView.ExpandMode.DISABLED) {
            return;
        }
        if ((this.mViewState != IAbaseWebView.IAviewState.b) && (this.mViewState != IAbaseWebView.IAviewState.d)) {
            getView().fireErrorEvent(IAmraidActionFactory.MraidJavascriptCommand.e, "Ad can be resized only if it's state is default or resized.");
            return;
        }
        if ((paramInt1 < 0) && (paramInt2 < 0)) {
            getView().fireErrorEvent(IAmraidActionFactory.MraidJavascriptCommand.e, "Creative size passed to resize() was invalid.");
            return;
        }
        useCustomClose(false);
        if ((this.mNativeCloseButtonMode == IAmraidWebView.NativeCloseButtonMode.ALWAYS_VISIBLE) || ((!this.mAdWantsCustomCloseButton) && (this.mNativeCloseButtonMode != IAmraidWebView.NativeCloseButtonMode.ALWAYS_HIDDEN))) {
            setNativeCloseButtonEnabled(true);
        }
        setOrientationLockEnabled(false);
        this.mAdHeight = paramInt2;
        this.mAdWidth = paramInt1;
        this.resizedContentView = getView();
        int i;
        if (!paramBoolean) {
            i = paramInt3 + paramInt1 - this.mScreenWidth;
            if (i > 0) {
                i = paramInt3 - i;
                label176:
                paramInt3 = i;
                if (i < 0) {
                    paramInt3 = 0;
                }
                int k = paramInt4 + paramInt2 - this.mScreenHeight;
                i = paramInt4;
                if (k > 0) {
                    i = paramInt4 - k;
                }
                if (i < 0) {
                    paramInt4 = j;
                }
            }
        }
        for (; ; ) {
            paramString = new FrameLayout.LayoutParams(c.b(getContext(), paramInt1), c.b(getContext(), paramInt2));
            paramString.leftMargin = paramInt3;
            paramString.topMargin = paramInt4;
            if ((paramInt3 == 0) && (paramInt4 == 0)) {
                paramString.gravity = 17;
            }
            this.resizedContentView.setLayoutParams(paramString);
            if (this.mViewState != IAbaseWebView.IAviewState.d) {
                this.mViewState = IAbaseWebView.IAviewState.d;
                getView().fireChangeEventForAsset(K.a(this.mViewState));
                if ((this.mAdWidth != -1) && (this.mAdHeight != -1)) {
                    getView().fireChangeEventForAsset(F.a(this.mAdWidth, this.mAdHeight));
                }
            }
            if (getView().getListener() == null) {
                break;
            }
            getView().getListener().onResize(getView());
            return;
            paramInt4 = i;
            continue;
            i = paramInt3;
            break label176;
        }
    }

    protected final void setNativeCloseButtonEnabled(boolean paramBoolean) {
        if (this.mRootView == null) {
            return;
        }
        Object localObject;
        if (paramBoolean) {
            if (this.mCloseButton == null) {
                localObject = new StateListDrawable();
                BitmapDrawable localBitmapDrawable = IAdefines.IAresources.h.a(this.mRootView.getContext());
                ((StateListDrawable) localObject).addState(new int[]{-16842919}, localBitmapDrawable);
                localBitmapDrawable = IAdefines.IAresources.i.a(this.mRootView.getContext());
                ((StateListDrawable) localObject).addState(new int[]{16842919}, localBitmapDrawable);
                this.mCloseButton = new ImageButton(getContext());
                this.mCloseButton.setImageDrawable((Drawable) localObject);
                this.mCloseButton.setBackgroundDrawable(null);
                this.mCloseButton.setOnClickListener(new IAmraidWebViewController .7 (this));
            }
            int i = (int) (50.0F * this.mDensity + 0.5F);
            localObject = new FrameLayout.LayoutParams(i, i, 5);
            c.a(this.mCloseButton);
            this.mAdContainerLayout.addView(this.mCloseButton, (ViewGroup.LayoutParams) localObject);
        }
        for (; ; ) {
            localObject = getView();
            if (((IAmraidWebView) localObject).getOnCloseButtonStateChangeListener() == null) {
                break;
            }
            ((IAmraidWebView) localObject).getOnCloseButtonStateChangeListener().onCloseButtonStateChange((IAmraidWebView) localObject, paramBoolean);
            return;
            this.mAdContainerLayout.removeView(this.mCloseButton);
        }
    }

    protected final void setOrientationProperties(boolean paramBoolean, String paramString) {
        setOrientationLockEnabled(paramBoolean);
        if ("protrait".equals(paramString)) {
            this.forceOrientation = IAmraidWebViewController.ForceOrientationType.PORTRAIT;
        }
        for (; ; ) {
            setOrientationLock(this.forceOrientation);
            return;
            if ("landscape".equals(paramString)) {
                this.forceOrientation = IAmraidWebViewController.ForceOrientationType.LANDSCAPE;
            } else {
                this.forceOrientation = IAmraidWebViewController.ForceOrientationType.NONE;
            }
        }
    }

    protected final void setResizeProperties() {
    }

    protected final void useCustomClose(boolean paramBoolean) {
        this.mAdWantsCustomCloseButton = paramBoolean;
        IAmraidWebView localIAmraidWebView = getView();
        if (!paramBoolean) {
        }
        for (paramBoolean = true; ; paramBoolean = false) {
            if (localIAmraidWebView.getOnCloseButtonStateChangeListener() != null) {
                localIAmraidWebView.getOnCloseButtonStateChangeListener().onCloseButtonStateChange(localIAmraidWebView, paramBoolean);
            }
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/IAmraidWebViewController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */