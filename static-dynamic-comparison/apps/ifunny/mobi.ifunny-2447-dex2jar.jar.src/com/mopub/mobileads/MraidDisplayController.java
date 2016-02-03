package com.mopub.mobileads;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Environment;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
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
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Drawables;
import com.mopub.mobileads.util.Interstitials;
import com.mopub.mobileads.util.Mraids;

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

class MraidDisplayController
        extends MraidAbstractController {
    private static final int CLOSE_BUTTON_SIZE_DP = 50;
    private static final String[] DATE_FORMATS = {"yyyy-MM-dd'T'HH:mm:ssZZZZZ", "yyyy-MM-dd'T'HH:mmZZZZZ"};
    private static final String LOGTAG = "MraidDisplayController";
    private static final int MAX_NUMBER_DAYS_IN_MONTH = 31;
    private static final long VIEWABILITY_TIMER_MILLIS = 3000L;
    private FrameLayout mAdContainerLayout;
    private boolean mAdWantsCustomCloseButton;
    private ImageView mCloseButton;
    private final View.OnClickListener mCloseOnClickListener;
    protected float mDensity;
    private RelativeLayout mExpansionLayout;
    private final MraidView.ExpansionStyle mExpansionStyle;
    private Handler mHandler = new Handler();
    private final MraidView.NativeCloseButtonStyle mNativeCloseButtonStyle;
    private MraidDisplayController.OrientationBroadcastReceiver mOrientationBroadcastReceiver = new MraidDisplayController.OrientationBroadcastReceiver(this);
    private final int mOriginalRequestedOrientation;
    private FrameLayout mPlaceholderView;
    private FrameLayout mRootView;
    protected int mScreenHeight = -1;
    protected int mScreenWidth = -1;
    private MraidView mTwoPartExpansionView;
    private int mViewIndexInParent;
    private MraidView.ViewState mViewState = MraidView.ViewState.HIDDEN;

    MraidDisplayController(MraidView paramMraidView, MraidView.ExpansionStyle paramExpansionStyle, MraidView.NativeCloseButtonStyle paramNativeCloseButtonStyle) {
        super(paramMraidView);
        this.mExpansionStyle = paramExpansionStyle;
        this.mNativeCloseButtonStyle = paramNativeCloseButtonStyle;
        paramMraidView = getContext();
        if ((paramMraidView instanceof Activity)) {
        }
        for (int i = ((Activity) paramMraidView).getRequestedOrientation(); ; i = -1) {
            this.mOriginalRequestedOrientation = i;
            initialize();
            this.mCloseOnClickListener = new MraidDisplayController .1 (this);
            this.mAdContainerLayout = createAdContainerLayout();
            this.mExpansionLayout = createExpansionLayout();
            this.mPlaceholderView = createPlaceholderView();
            return;
        }
    }

    private String dayNumberToDayOfMonthString(int paramInt) {
        if ((paramInt != 0) && (paramInt >= -31) && (paramInt <= 31)) {
            return "" + paramInt;
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

    private void downloadImage(String paramString) {
        File localFile = getPictureStoragePath();
        localFile.mkdirs();
        new Thread(new MraidDisplayController .4 (this, paramString, localFile)).start();
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
        localView.setOnTouchListener(new MraidDisplayController .6 (this));
        this.mExpansionLayout.addView(localView, new RelativeLayout.LayoutParams(-1, -1));
        this.mAdContainerLayout.addView(paramView, new RelativeLayout.LayoutParams(-1, -1));
        addCloseEventRegion(this.mAdContainerLayout);
        paramView = new RelativeLayout.LayoutParams(j, paramInt1);
        paramView.addRule(13);
        this.mExpansionLayout.addView(this.mAdContainerLayout, paramView);
    }

    private Context getContext() {
        return getMraidView().getContext();
    }

    private int getDisplayRotation() {
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
            paramHttpResponse = paramHttpResponse.getFirstHeader("Content-Type");
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
        this.mViewState = MraidView.ViewState.LOADING;
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
            this.mScreenHeight = ((int) ((m - j - i) * (160.0D / localDisplayMetrics.densityDpi)));
            return;
        }
    }

    private void onOrientationChanged(int paramInt) {
        initializeScreenMetrics();
        getMraidView().fireChangeEventForProperty(MraidScreenSizeProperty.createWithSize(this.mScreenWidth, this.mScreenHeight));
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

    private String parseRecurrenceRule(Map<String, String> paramMap) {
        StringBuilder localStringBuilder = new StringBuilder();
        String str;
        if (paramMap.containsKey("frequency")) {
            str = (String) paramMap.get("frequency");
            if (!paramMap.containsKey("interval")) {
                break label396;
            }
        }
        label396:
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

    private void resetViewToDefaultState() {
        setNativeCloseButtonEnabled(false);
        this.mAdContainerLayout.removeAllViewsInLayout();
        this.mExpansionLayout.removeAllViewsInLayout();
        this.mRootView.removeView(this.mExpansionLayout);
        getMraidView().requestLayout();
        ViewGroup localViewGroup = (ViewGroup) this.mPlaceholderView.getParent();
        localViewGroup.addView(getMraidView(), this.mViewIndexInParent);
        localViewGroup.removeView(this.mPlaceholderView);
        localViewGroup.invalidate();
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
            Log.d("MraidDisplayController", "Unable to modify device orientation.");
        }
    }

    private void showUserDialog(String paramString) {
        new AlertDialog.Builder(getContext()).setTitle("Save Image").setMessage("Download image to Picture gallery?").setNegativeButton("Cancel", null).setPositiveButton("Okay", new MraidDisplayController
        .5 (this, paramString)).setCancelable(true).show();
    }

    private void showUserToast(String paramString) {
        this.mHandler.post(new MraidDisplayController .3 (this, paramString));
    }

    private void swapViewWithPlaceholderView() {
        ViewGroup localViewGroup = (ViewGroup) getMraidView().getParent();
        if (localViewGroup == null) {
            return;
        }
        int j = localViewGroup.getChildCount();
        int i = 0;
        for (; ; ) {
            if ((i >= j) || (localViewGroup.getChildAt(i) == getMraidView())) {
                this.mViewIndexInParent = i;
                localViewGroup.addView(this.mPlaceholderView, i, new ViewGroup.LayoutParams(getMraidView().getWidth(), getMraidView().getHeight()));
                localViewGroup.removeView(getMraidView());
                return;
            }
            i += 1;
        }
    }

    private Map<String, Object> translateJSParamsToAndroidCalendarEventMapping(Map<String, String> paramMap) {
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
                        break label342;
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
                    if (!((String) paramMap.get("transparency")).equals("transparent")) {
                        break label353;
                    }
                }
            }
        }
        label342:
        label353:
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

    void addCloseEventRegion(FrameLayout paramFrameLayout) {
        int i = Dips.dipsToIntPixels(50.0F, getContext());
        Interstitials.addCloseEventRegion(paramFrameLayout, new FrameLayout.LayoutParams(i, i, 53), this.mCloseOnClickListener);
    }

    protected void close() {
        if (this.mViewState == MraidView.ViewState.EXPANDED) {
            resetViewToDefaultState();
            setOrientationLockEnabled(false);
            this.mViewState = MraidView.ViewState.DEFAULT;
            getMraidView().fireChangeEventForProperty(MraidStateProperty.createWithViewState(this.mViewState));
        }
        for (; ; ) {
            if (getMraidView().getMraidListener() != null) {
                getMraidView().getMraidListener().onClose(getMraidView(), this.mViewState);
            }
            return;
            if (this.mViewState == MraidView.ViewState.DEFAULT) {
                getMraidView().setVisibility(4);
                this.mViewState = MraidView.ViewState.HIDDEN;
                getMraidView().fireChangeEventForProperty(MraidStateProperty.createWithViewState(this.mViewState));
            }
        }
    }

    FrameLayout createAdContainerLayout() {
        return new FrameLayout(getContext());
    }

    protected void createCalendarEvent(Map<String, String> paramMap) {
        Context localContext = getMraidView().getContext();
        if (Mraids.isCalendarAvailable(localContext)) {
            Intent localIntent;
            try {
                paramMap = translateJSParamsToAndroidCalendarEventMapping(paramMap);
                localIntent = new Intent("android.intent.action.INSERT").setType("vnd.android.cursor.item/event");
                Iterator localIterator = paramMap.keySet().iterator();
                for (; ; ) {
                    if (!localIterator.hasNext()) {
                        break label243;
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
                    Log.d("MraidDisplayController", "no calendar app installed");
                    getMraidView().fireErrorEvent(MraidCommandFactory.MraidJavascriptCommand.CREATE_CALENDAR_EVENT, "Action is unsupported on this device - no calendar app installed");
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
                    Log.d("MraidDisplayController", "create calendar: invalid parameters " + paramMap.getMessage());
                    getMraidView().fireErrorEvent(MraidCommandFactory.MraidJavascriptCommand.CREATE_CALENDAR_EVENT, paramMap.getMessage());
                    return;
                    localIntent.putExtra(str, (String) localObject);
                }
            } catch (Exception paramMap) {
                Log.d("MraidDisplayController", "could not create calendar event");
                getMraidView().fireErrorEvent(MraidCommandFactory.MraidJavascriptCommand.CREATE_CALENDAR_EVENT, "could not create calendar event");
                return;
            }
            label243:
            localIntent.setFlags(268435456);
            localContext.startActivity(localIntent);
            return;
        }
        Log.d("MraidDisplayController", "unsupported action createCalendarEvent for devices pre-ICS");
        getMraidView().fireErrorEvent(MraidCommandFactory.MraidJavascriptCommand.CREATE_CALENDAR_EVENT, "Action is unsupported on this device (need Android version Ice Cream Sandwich or above)");
    }

    RelativeLayout createExpansionLayout() {
        return new RelativeLayout(getContext());
    }

    FrameLayout createPlaceholderView() {
        return new FrameLayout(getContext());
    }

    public void destroy() {
        try {
            this.mOrientationBroadcastReceiver.unregister();
            return;
        } catch (IllegalArgumentException localIllegalArgumentException) {
            while (localIllegalArgumentException.getMessage().contains("Receiver not registered")) {
            }
            throw localIllegalArgumentException;
        }
    }

    protected void expand(String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2) {
        if (this.mExpansionStyle == MraidView.ExpansionStyle.DISABLED) {
        }
        do {
            return;
            if ((paramString != null) && (!URLUtil.isValidUrl(paramString))) {
                getMraidView().fireErrorEvent(MraidCommandFactory.MraidJavascriptCommand.EXPAND, "URL passed to expand() was invalid.");
                return;
            }
            this.mRootView = ((FrameLayout) getMraidView().getRootView().findViewById(16908290));
            useCustomClose(paramBoolean1);
            setOrientationLockEnabled(paramBoolean2);
            swapViewWithPlaceholderView();
            MraidView localMraidView = getMraidView();
            if (paramString != null) {
                this.mTwoPartExpansionView = new MraidView(getContext(), getMraidView().getAdConfiguration(), MraidView.ExpansionStyle.DISABLED, MraidView.NativeCloseButtonStyle.AD_CONTROLLED, MraidView.PlacementType.INLINE);
                this.mTwoPartExpansionView.setMraidListener(new MraidDisplayController .2 (this));
                this.mTwoPartExpansionView.loadUrl(paramString);
                localMraidView = this.mTwoPartExpansionView;
            }
            expandLayouts(localMraidView, (int) (paramInt1 * this.mDensity), (int) (paramInt2 * this.mDensity));
            this.mRootView.addView(this.mExpansionLayout, new RelativeLayout.LayoutParams(-1, -1));
            if ((this.mNativeCloseButtonStyle == MraidView.NativeCloseButtonStyle.ALWAYS_VISIBLE) || ((!this.mAdWantsCustomCloseButton) && (this.mNativeCloseButtonStyle != MraidView.NativeCloseButtonStyle.ALWAYS_HIDDEN))) {
                setNativeCloseButtonEnabled(true);
            }
            this.mViewState = MraidView.ViewState.EXPANDED;
            getMraidView().fireChangeEventForProperty(MraidStateProperty.createWithViewState(this.mViewState));
        } while (getMraidView().getMraidListener() == null);
        getMraidView().getMraidListener().onExpand(getMraidView());
    }

    @Deprecated
    public View.OnClickListener getCloseOnClickListener() {
        return this.mCloseOnClickListener;
    }

    protected void getCurrentPosition() {
        getMraidView().fireErrorEvent(MraidCommandFactory.MraidJavascriptCommand.GET_CURRENT_POSITION, "Unsupported action getCurrentPosition");
    }

    protected void getDefaultPosition() {
        getMraidView().fireErrorEvent(MraidCommandFactory.MraidJavascriptCommand.GET_DEFAULT_POSITION, "Unsupported action getDefaultPosition");
    }

    protected void getMaxSize() {
        getMraidView().fireErrorEvent(MraidCommandFactory.MraidJavascriptCommand.GET_MAX_SIZE, "Unsupported action getMaxSize");
    }

    protected void getScreenSize() {
        getMraidView().fireErrorEvent(MraidCommandFactory.MraidJavascriptCommand.GET_SCREEN_SIZE, "Unsupported action getScreenSize");
    }

    protected void initializeJavaScriptState() {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(MraidScreenSizeProperty.createWithSize(this.mScreenWidth, this.mScreenHeight));
        localArrayList.add(MraidViewableProperty.createWithViewable(getMraidView().getIsVisible()));
        getMraidView().fireChangeEventForProperties(localArrayList);
        this.mViewState = MraidView.ViewState.DEFAULT;
        getMraidView().fireChangeEventForProperty(MraidStateProperty.createWithViewState(this.mViewState));
        initializeSupportedFunctionsProperty();
    }

    protected void initializeSupportedFunctionsProperty() {
        Context localContext = getContext();
        getMraidView().fireChangeEventForProperty(new MraidSupportsProperty().withTel(Mraids.isTelAvailable(localContext)).withSms(Mraids.isSmsAvailable(localContext)).withCalendar(Mraids.isCalendarAvailable(localContext)).withInlineVideo(Mraids.isInlineVideoAvailable(localContext)).withStorePicture(Mraids.isStorePictureSupported(localContext)));
    }

    protected boolean isExpanded() {
        return this.mViewState == MraidView.ViewState.EXPANDED;
    }

    protected void setNativeCloseButtonEnabled(boolean paramBoolean) {
        if (this.mRootView == null) {
            return;
        }
        Object localObject;
        if (paramBoolean) {
            if (this.mCloseButton == null) {
                localObject = new StateListDrawable();
                Drawable localDrawable = Drawables.INTERSTITIAL_CLOSE_BUTTON_NORMAL.decodeImage(this.mRootView.getContext());
                ((StateListDrawable) localObject).addState(new int[]{-16842919}, localDrawable);
                localDrawable = Drawables.INTERSTITIAL_CLOSE_BUTTON_PRESSED.decodeImage(this.mRootView.getContext());
                ((StateListDrawable) localObject).addState(new int[]{16842919}, localDrawable);
                this.mCloseButton = new ImageButton(getContext());
                this.mCloseButton.setImageDrawable((Drawable) localObject);
                this.mCloseButton.setBackgroundDrawable(null);
                this.mCloseButton.setOnClickListener(new MraidDisplayController .7 (this));
            }
            int i = Dips.dipsToIntPixels(50.0F, getContext());
            localObject = new FrameLayout.LayoutParams(i, i, 5);
            this.mAdContainerLayout.addView(this.mCloseButton, (ViewGroup.LayoutParams) localObject);
        }
        for (; ; ) {
            localObject = getMraidView();
            if (((MraidView) localObject).getOnCloseButtonStateChangeListener() == null) {
                break;
            }
            ((MraidView) localObject).getOnCloseButtonStateChangeListener().onCloseButtonStateChange((MraidView) localObject, paramBoolean);
            return;
            this.mAdContainerLayout.removeView(this.mCloseButton);
        }
    }

    protected void showUserDownloadImageAlert(String paramString) {
        Context localContext = getContext();
        if (!Mraids.isStorePictureSupported(localContext)) {
            getMraidView().fireErrorEvent(MraidCommandFactory.MraidJavascriptCommand.STORE_PICTURE, "Error downloading file - the device does not have an SD card mounted, or the Android permission is not granted.");
            MoPubLog.d("Error downloading file - the device does not have an SD card mounted, or the Android permission is not granted.");
            return;
        }
        if ((localContext instanceof Activity)) {
            showUserDialog(paramString);
            return;
        }
        showUserToast("Downloading image to Picture gallery...");
        downloadImage(paramString);
    }

    protected void showVideo(String paramString) {
        MraidVideoPlayerActivity.startMraid(getContext(), paramString, getMraidView().getAdConfiguration());
    }

    protected void useCustomClose(boolean paramBoolean) {
        this.mAdWantsCustomCloseButton = paramBoolean;
        MraidView localMraidView = getMraidView();
        if (!paramBoolean) {
        }
        for (paramBoolean = true; ; paramBoolean = false) {
            if (localMraidView.getOnCloseButtonStateChangeListener() != null) {
                localMraidView.getOnCloseButtonStateChangeListener().onCloseButtonStateChange(localMraidView, paramBoolean);
            }
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/MraidDisplayController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */