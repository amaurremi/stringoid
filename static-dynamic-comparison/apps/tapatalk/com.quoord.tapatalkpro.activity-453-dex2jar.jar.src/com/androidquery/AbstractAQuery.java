package com.androidquery;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Gallery;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import com.androidquery.auth.AccountHandle;
import com.androidquery.callback.AbstractAjaxCallback;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.BitmapAjaxCallback;
import com.androidquery.callback.ImageOptions;
import com.androidquery.callback.Transformer;
import com.androidquery.util.AQUtility;
import com.androidquery.util.Common;
import com.androidquery.util.Constants;
import com.androidquery.util.WebImage;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.nio.channels.FileChannel;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.entity.StringEntity;
import org.json.JSONObject;

public abstract class AbstractAQuery<T extends AbstractAQuery<T>>
        implements Constants {
    private static Class<?>[] LAYER_TYPE_SIG = {Integer.TYPE, Paint.class};
    private static final Class<?>[] ON_CLICK_SIG = {View.class};
    private static Class<?>[] ON_ITEM_SIG = {AdapterView.class, View.class, Integer.TYPE, Long.TYPE};
    private static Class<?>[] ON_SCROLLED_STATE_SIG = {AbsListView.class, Integer.TYPE};
    private static final Class<?>[] OVER_SCROLL_SIG;
    private static Class<?>[] PENDING_TRANSITION_SIG;
    private static final Class<?>[] TEXT_CHANGE_SIG = {CharSequence.class, Integer.TYPE, Integer.TYPE, Integer.TYPE};
    private static WeakHashMap<Dialog, Void> dialogs = new WeakHashMap();
    private Activity act;
    protected AccountHandle ah;
    private Constructor<T> constructor;
    private Context context;
    private int policy = 0;
    protected Object progress;
    private HttpHost proxy;
    private View root;
    private Transformer trans;
    protected View view;

    static {
        PENDING_TRANSITION_SIG = new Class[]{Integer.TYPE, Integer.TYPE};
        OVER_SCROLL_SIG = new Class[]{Integer.TYPE};
    }

    public AbstractAQuery(Activity paramActivity) {
        this.act = paramActivity;
    }

    public AbstractAQuery(Activity paramActivity, View paramView) {
        this.root = paramView;
        this.view = paramView;
        this.act = paramActivity;
    }

    public AbstractAQuery(Context paramContext) {
        this.context = paramContext;
    }

    public AbstractAQuery(View paramView) {
        this.root = paramView;
        this.view = paramView;
    }

    private View findView(int paramInt) {
        View localView = null;
        if (this.root != null) {
            localView = this.root.findViewById(paramInt);
        }
        while (this.act == null) {
            return localView;
        }
        return this.act.findViewById(paramInt);
    }

    private View findView(String paramString) {
        Object localObject2 = null;
        Object localObject1;
        if (this.root != null) {
            localObject1 = this.root.findViewWithTag(paramString);
        }
        View localView;
        do {
            do {
                return (View) localObject1;
                localObject1 = localObject2;
            } while (this.act == null);
            localView = ((ViewGroup) this.act.findViewById(16908290)).getChildAt(0);
            localObject1 = localObject2;
        } while (localView == null);
        return localView.findViewWithTag(paramString);
    }

    private View findView(int... paramVarArgs) {
        View localView = findView(paramVarArgs[0]);
        int i = 1;
        for (; ; ) {
            if ((i >= paramVarArgs.length) || (localView == null)) {
                return localView;
            }
            localView = localView.findViewById(paramVarArgs[i]);
            i += 1;
        }
    }

    private Constructor<T> getConstructor() {
        if (this.constructor == null) {
        }
        try {
            this.constructor = getClass().getConstructor(new Class[]{View.class});
            return this.constructor;
        } catch (Exception localException) {
            for (; ; ) {
                localException.printStackTrace();
            }
        }
    }

    private Common setScrollListener() {
        AbsListView localAbsListView = (AbsListView) this.view;
        Common localCommon2 = (Common) localAbsListView.getTag(1090453506);
        Common localCommon1 = localCommon2;
        if (localCommon2 == null) {
            localCommon1 = new Common();
            localAbsListView.setOnScrollListener(localCommon1);
            localAbsListView.setTag(1090453506, localCommon1);
            AQUtility.debug("set scroll listenr");
        }
        return localCommon1;
    }

    private void size(boolean paramBoolean1, int paramInt, boolean paramBoolean2) {
        ViewGroup.LayoutParams localLayoutParams;
        int i;
        if (this.view != null) {
            localLayoutParams = this.view.getLayoutParams();
            Context localContext = getContext();
            i = paramInt;
            if (paramInt > 0) {
                i = paramInt;
                if (paramBoolean2) {
                    i = AQUtility.dip2pixel(localContext, paramInt);
                }
            }
            if (!paramBoolean1) {
                break label66;
            }
            localLayoutParams.width = i;
        }
        for (; ; ) {
            this.view.setLayoutParams(localLayoutParams);
            return;
            label66:
            localLayoutParams.height = i;
        }
    }

    public T adapter(Adapter paramAdapter) {
        if ((this.view instanceof AdapterView)) {
            ((AdapterView) this.view).setAdapter(paramAdapter);
        }
        return self();
    }

    public T adapter(ExpandableListAdapter paramExpandableListAdapter) {
        if ((this.view instanceof ExpandableListView)) {
            ((ExpandableListView) this.view).setAdapter(paramExpandableListAdapter);
        }
        return self();
    }

    public <K> T ajax(AjaxCallback<K> paramAjaxCallback) {
        return invoke(paramAjaxCallback);
    }

    public <K> T ajax(String paramString, Class<K> paramClass, long paramLong, AjaxCallback<K> paramAjaxCallback) {
        ((AjaxCallback) ((AjaxCallback) ((AjaxCallback) paramAjaxCallback.type(paramClass)).url(paramString)).fileCache(true)).expire(paramLong);
        return ajax(paramAjaxCallback);
    }

    public <K> T ajax(String paramString1, Class<K> paramClass, long paramLong, Object paramObject, String paramString2) {
        AjaxCallback localAjaxCallback = new AjaxCallback();
        ((AjaxCallback) ((AjaxCallback) ((AjaxCallback) localAjaxCallback.type(paramClass)).weakHandler(paramObject, paramString2)).fileCache(true)).expire(paramLong);
        return ajax(paramString1, paramClass, localAjaxCallback);
    }

    public <K> T ajax(String paramString, Class<K> paramClass, AjaxCallback<K> paramAjaxCallback) {
        ((AjaxCallback) paramAjaxCallback.type(paramClass)).url(paramString);
        return ajax(paramAjaxCallback);
    }

    public <K> T ajax(String paramString1, Class<K> paramClass, Object paramObject, String paramString2) {
        AjaxCallback localAjaxCallback = new AjaxCallback();
        ((AjaxCallback) localAjaxCallback.type(paramClass)).weakHandler(paramObject, paramString2);
        return ajax(paramString1, paramClass, localAjaxCallback);
    }

    public <K> T ajax(String paramString, Map<String, ?> paramMap, Class<K> paramClass, AjaxCallback<K> paramAjaxCallback) {
        ((AjaxCallback) ((AjaxCallback) paramAjaxCallback.type(paramClass)).url(paramString)).params(paramMap);
        return ajax(paramAjaxCallback);
    }

    public <K> T ajax(String paramString1, Map<String, ?> paramMap, Class<K> paramClass, Object paramObject, String paramString2) {
        AjaxCallback localAjaxCallback = new AjaxCallback();
        ((AjaxCallback) localAjaxCallback.type(paramClass)).weakHandler(paramObject, paramString2);
        return ajax(paramString1, paramMap, paramClass, localAjaxCallback);
    }

    public T ajaxCancel() {
        AjaxCallback.cancel();
        return self();
    }

    public T animate(int paramInt) {
        return animate(paramInt, null);
    }

    public T animate(int paramInt, Animation.AnimationListener paramAnimationListener) {
        Animation localAnimation = AnimationUtils.loadAnimation(getContext(), paramInt);
        localAnimation.setAnimationListener(paramAnimationListener);
        return animate(localAnimation);
    }

    public T animate(Animation paramAnimation) {
        if ((this.view != null) && (paramAnimation != null)) {
            this.view.startAnimation(paramAnimation);
        }
        return self();
    }

    public T auth(AccountHandle paramAccountHandle) {
        this.ah = paramAccountHandle;
        return self();
    }

    public T background(int paramInt) {
        if (this.view != null) {
            if (paramInt == 0) {
                break label24;
            }
            this.view.setBackgroundResource(paramInt);
        }
        for (; ; ) {
            return self();
            label24:
            this.view.setBackgroundDrawable(null);
        }
    }

    public T backgroundColor(int paramInt) {
        if (this.view != null) {
            this.view.setBackgroundColor(paramInt);
        }
        return self();
    }

    public T backgroundColorId(int paramInt) {
        if (this.view != null) {
            this.view.setBackgroundColor(getContext().getResources().getColor(paramInt));
        }
        return self();
    }

    public T cache(String paramString, long paramLong) {
        return ajax(paramString, byte[].class, paramLong, null, null);
    }

    public T checked(boolean paramBoolean) {
        if ((this.view instanceof CompoundButton)) {
            ((CompoundButton) this.view).setChecked(paramBoolean);
        }
        return self();
    }

    public T clear() {
        Object localObject;
        if (this.view != null) {
            if (!(this.view instanceof ImageView)) {
                break label43;
            }
            localObject = (ImageView) this.view;
            ((ImageView) localObject).setImageBitmap(null);
            ((ImageView) localObject).setTag(1090453505, null);
        }
        for (; ; ) {
            return self();
            label43:
            if ((this.view instanceof WebView)) {
                localObject = (WebView) this.view;
                ((WebView) localObject).stopLoading();
                ((WebView) localObject).clearView();
                ((WebView) localObject).setTag(1090453505, null);
            } else if ((this.view instanceof TextView)) {
                ((TextView) this.view).setText("");
            }
        }
    }

    public T click() {
        if (this.view != null) {
            this.view.performClick();
        }
        return self();
    }

    public T clickable(boolean paramBoolean) {
        if (this.view != null) {
            this.view.setClickable(paramBoolean);
        }
        return self();
    }

    public T clicked(View.OnClickListener paramOnClickListener) {
        if (this.view != null) {
            this.view.setOnClickListener(paramOnClickListener);
        }
        return self();
    }

    public T clicked(Object paramObject, String paramString) {
        return clicked(new Common().forward(paramObject, paramString, true, ON_CLICK_SIG));
    }

    protected T create(View paramView) {
        View localView = null;
        try {
            paramView = (AbstractAQuery) getConstructor().newInstance(new Object[]{paramView});
            localView = paramView;
            paramView.act = this.act;
            return paramView;
        } catch (Exception paramView) {
            paramView.printStackTrace();
        }
        return localView;
    }

    public T dataChanged() {
        if ((this.view instanceof AdapterView)) {
            Adapter localAdapter = ((AdapterView) this.view).getAdapter();
            if ((localAdapter instanceof BaseAdapter)) {
                ((BaseAdapter) localAdapter).notifyDataSetChanged();
            }
        }
        return self();
    }

    public <K> T delete(String paramString, Class<K> paramClass, AjaxCallback<K> paramAjaxCallback) {
        ((AjaxCallback) ((AjaxCallback) paramAjaxCallback.url(paramString)).type(paramClass)).method(2);
        return ajax(paramAjaxCallback);
    }

    public <K> T delete(String paramString1, Class<K> paramClass, Object paramObject, String paramString2) {
        AjaxCallback localAjaxCallback = new AjaxCallback();
        localAjaxCallback.weakHandler(paramObject, paramString2);
        return delete(paramString1, paramClass, localAjaxCallback);
    }

    public T dismiss() {
        Iterator localIterator = dialogs.keySet().iterator();
        for (; ; ) {
            if (!localIterator.hasNext()) {
                return self();
            }
            Dialog localDialog = (Dialog) localIterator.next();
            try {
                localDialog.dismiss();
                localIterator.remove();
            } catch (Exception localException) {
                for (; ; ) {
                }
            }
        }
    }

    public T dismiss(Dialog paramDialog) {
        if (paramDialog != null) {
        }
        try {
            dialogs.remove(paramDialog);
            paramDialog.dismiss();
            return self();
        } catch (Exception paramDialog) {
            for (; ; ) {
            }
        }
    }

    public T download(String paramString, File paramFile, AjaxCallback<File> paramAjaxCallback) {
        ((AjaxCallback) ((AjaxCallback) paramAjaxCallback.url(paramString)).type(File.class)).targetFile(paramFile);
        return ajax(paramAjaxCallback);
    }

    public T download(String paramString1, File paramFile, Object paramObject, String paramString2) {
        AjaxCallback localAjaxCallback = new AjaxCallback();
        localAjaxCallback.weakHandler(paramObject, paramString2);
        return download(paramString1, paramFile, localAjaxCallback);
    }

    public T enabled(boolean paramBoolean) {
        if (this.view != null) {
            this.view.setEnabled(paramBoolean);
        }
        return self();
    }

    public T expand(int paramInt, boolean paramBoolean) {
        ExpandableListView localExpandableListView;
        if ((this.view instanceof ExpandableListView)) {
            localExpandableListView = (ExpandableListView) this.view;
            if (!paramBoolean) {
                break label33;
            }
            localExpandableListView.expandGroup(paramInt);
        }
        for (; ; ) {
            return self();
            label33:
            localExpandableListView.collapseGroup(paramInt);
        }
    }

    public T expand(boolean paramBoolean) {
        ExpandableListView localExpandableListView;
        int i;
        if ((this.view instanceof ExpandableListView)) {
            localExpandableListView = (ExpandableListView) this.view;
            ExpandableListAdapter localExpandableListAdapter = localExpandableListView.getExpandableListAdapter();
            if (localExpandableListAdapter != null) {
                int j = localExpandableListAdapter.getGroupCount();
                i = 0;
                if (i < j) {
                    break label51;
                }
            }
        }
        return self();
        label51:
        if (paramBoolean) {
            localExpandableListView.expandGroup(i);
        }
        for (; ; ) {
            i += 1;
            break;
            localExpandableListView.collapseGroup(i);
        }
    }

    public T find(int paramInt) {
        return create(findView(paramInt));
    }

    public Button getButton() {
        return (Button) this.view;
    }

    public File getCachedFile(String paramString) {
        File localFile2 = AQUtility.getExistedCacheByUrl(AQUtility.getCacheDir(getContext(), 1), paramString);
        File localFile1 = localFile2;
        if (localFile2 == null) {
            localFile1 = AQUtility.getExistedCacheByUrl(AQUtility.getCacheDir(getContext(), 0), paramString);
        }
        return localFile1;
    }

    public Bitmap getCachedImage(int paramInt) {
        return BitmapAjaxCallback.getMemoryCached(getContext(), paramInt);
    }

    public Bitmap getCachedImage(String paramString) {
        return getCachedImage(paramString, 0);
    }

    public Bitmap getCachedImage(String paramString, int paramInt) {
        Bitmap localBitmap2 = BitmapAjaxCallback.getMemoryCached(paramString, paramInt);
        Bitmap localBitmap1 = localBitmap2;
        if (localBitmap2 == null) {
            paramString = getCachedFile(paramString);
            localBitmap1 = localBitmap2;
            if (paramString != null) {
                localBitmap1 = BitmapAjaxCallback.getResizedImage(paramString.getAbsolutePath(), null, paramInt, true, 0);
            }
        }
        return localBitmap1;
    }

    public CheckBox getCheckBox() {
        return (CheckBox) this.view;
    }

    public Context getContext() {
        if (this.act != null) {
            return this.act;
        }
        if (this.root != null) {
            return this.root.getContext();
        }
        return this.context;
    }

    public EditText getEditText() {
        return (EditText) this.view;
    }

    public Editable getEditable() {
        Editable localEditable = null;
        if ((this.view instanceof EditText)) {
            localEditable = ((EditText) this.view).getEditableText();
        }
        return localEditable;
    }

    public ExpandableListView getExpandableListView() {
        return (ExpandableListView) this.view;
    }

    public Gallery getGallery() {
        return (Gallery) this.view;
    }

    public GridView getGridView() {
        return (GridView) this.view;
    }

    public ImageView getImageView() {
        return (ImageView) this.view;
    }

    public ListView getListView() {
        return (ListView) this.view;
    }

    public ProgressBar getProgressBar() {
        return (ProgressBar) this.view;
    }

    public RatingBar getRatingBar() {
        return (RatingBar) this.view;
    }

    public SeekBar getSeekBar() {
        return (SeekBar) this.view;
    }

    public Object getSelectedItem() {
        Object localObject = null;
        if ((this.view instanceof AdapterView)) {
            localObject = ((AdapterView) this.view).getSelectedItem();
        }
        return localObject;
    }

    public int getSelectedItemPosition() {
        int i = -1;
        if ((this.view instanceof AdapterView)) {
            i = ((AdapterView) this.view).getSelectedItemPosition();
        }
        return i;
    }

    public Spinner getSpinner() {
        return (Spinner) this.view;
    }

    public Object getTag() {
        Object localObject = null;
        if (this.view != null) {
            localObject = this.view.getTag();
        }
        return localObject;
    }

    public Object getTag(int paramInt) {
        Object localObject = null;
        if (this.view != null) {
            localObject = this.view.getTag(paramInt);
        }
        return localObject;
    }

    public CharSequence getText() {
        CharSequence localCharSequence = null;
        if ((this.view instanceof TextView)) {
            localCharSequence = ((TextView) this.view).getText();
        }
        return localCharSequence;
    }

    public TextView getTextView() {
        return (TextView) this.view;
    }

    public View getView() {
        return this.view;
    }

    public WebView getWebView() {
        return (WebView) this.view;
    }

    public T gone() {
        return visibility(8);
    }

    public T hardwareAccelerated11() {
        if (this.act != null) {
            this.act.getWindow().setFlags(16777216, 16777216);
        }
        return self();
    }

    public T height(int paramInt) {
        size(false, paramInt, true);
        return self();
    }

    public T height(int paramInt, boolean paramBoolean) {
        size(false, paramInt, paramBoolean);
        return self();
    }

    public T id(int paramInt) {
        return id(findView(paramInt));
    }

    public T id(View paramView) {
        this.view = paramView;
        reset();
        return self();
    }

    public T id(String paramString) {
        return id(findView(paramString));
    }

    public T id(int... paramVarArgs) {
        return id(findView(paramVarArgs));
    }

    public T image(int paramInt) {
        ImageView localImageView;
        if ((this.view instanceof ImageView)) {
            localImageView = (ImageView) this.view;
            localImageView.setTag(1090453505, null);
            if (paramInt != 0) {
                break label40;
            }
            localImageView.setImageBitmap(null);
        }
        for (; ; ) {
            return self();
            label40:
            localImageView.setImageResource(paramInt);
        }
    }

    public T image(Bitmap paramBitmap) {
        if ((this.view instanceof ImageView)) {
            ImageView localImageView = (ImageView) this.view;
            localImageView.setTag(1090453505, null);
            localImageView.setImageBitmap(paramBitmap);
        }
        return self();
    }

    public T image(Bitmap paramBitmap, float paramFloat) {
        BitmapAjaxCallback localBitmapAjaxCallback = new BitmapAjaxCallback();
        localBitmapAjaxCallback.ratio(paramFloat).bitmap(paramBitmap);
        return image(localBitmapAjaxCallback);
    }

    public T image(Drawable paramDrawable) {
        if ((this.view instanceof ImageView)) {
            ImageView localImageView = (ImageView) this.view;
            localImageView.setTag(1090453505, null);
            localImageView.setImageDrawable(paramDrawable);
        }
        return self();
    }

    public T image(BitmapAjaxCallback paramBitmapAjaxCallback) {
        if ((this.view instanceof ImageView)) {
            paramBitmapAjaxCallback.imageView((ImageView) this.view);
            invoke(paramBitmapAjaxCallback);
        }
        return self();
    }

    public T image(File paramFile, int paramInt) {
        return image(paramFile, true, paramInt, null);
    }

    public T image(File paramFile, boolean paramBoolean, int paramInt, BitmapAjaxCallback paramBitmapAjaxCallback) {
        BitmapAjaxCallback localBitmapAjaxCallback = paramBitmapAjaxCallback;
        if (paramBitmapAjaxCallback == null) {
            localBitmapAjaxCallback = new BitmapAjaxCallback();
        }
        localBitmapAjaxCallback.file(paramFile);
        paramBitmapAjaxCallback = null;
        if (paramFile != null) {
            paramBitmapAjaxCallback = paramFile.getAbsolutePath();
        }
        return image(paramBitmapAjaxCallback, paramBoolean, true, paramInt, 0, localBitmapAjaxCallback);
    }

    public T image(String paramString) {
        return image(paramString, true, true, 0, 0);
    }

    public T image(String paramString, ImageOptions paramImageOptions) {
        return image(paramString, paramImageOptions, null);
    }

    protected T image(String paramString1, ImageOptions paramImageOptions, String paramString2) {
        if ((this.view instanceof ImageView)) {
            BitmapAjaxCallback.async(this.act, getContext(), (ImageView) this.view, paramString1, this.progress, this.ah, paramImageOptions, this.proxy, paramString2);
            reset();
        }
        return self();
    }

    public T image(String paramString, boolean paramBoolean1, boolean paramBoolean2) {
        return image(paramString, paramBoolean1, paramBoolean2, 0, 0);
    }

    public T image(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2) {
        return image(paramString, paramBoolean1, paramBoolean2, paramInt1, paramInt2, null, 0);
    }

    public T image(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, Bitmap paramBitmap, int paramInt3) {
        return image(paramString, paramBoolean1, paramBoolean2, paramInt1, paramInt2, paramBitmap, paramInt3, 0.0F);
    }

    public T image(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, Bitmap paramBitmap, int paramInt3, float paramFloat) {
        return image(paramString, paramBoolean1, paramBoolean2, paramInt1, paramInt2, paramBitmap, paramInt3, paramFloat, 0, null);
    }

    protected T image(String paramString1, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, Bitmap paramBitmap, int paramInt3, float paramFloat, int paramInt4, String paramString2) {
        if ((this.view instanceof ImageView)) {
            BitmapAjaxCallback.async(this.act, getContext(), (ImageView) this.view, paramString1, paramBoolean1, paramBoolean2, paramInt1, paramInt2, paramBitmap, paramInt3, paramFloat, Float.MAX_VALUE, this.progress, this.ah, this.policy, paramInt4, this.proxy, paramString2);
            reset();
        }
        return self();
    }

    public T image(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, BitmapAjaxCallback paramBitmapAjaxCallback) {
        ((BitmapAjaxCallback) ((BitmapAjaxCallback) paramBitmapAjaxCallback.targetWidth(paramInt1).fallback(paramInt2).url(paramString)).memCache(paramBoolean1)).fileCache(paramBoolean2);
        return image(paramBitmapAjaxCallback);
    }

    public View inflate(View paramView, int paramInt, ViewGroup paramViewGroup) {
        if (paramView != null) {
            Integer localInteger = (Integer) paramView.getTag(1090453507);
            if ((localInteger != null) && (localInteger.intValue() == paramInt)) {
                return paramView;
            }
        }
        if (this.act != null) {
        }
        for (paramView = this.act.getLayoutInflater(); ; paramView = (LayoutInflater) getContext().getSystemService("layout_inflater")) {
            paramView = paramView.inflate(paramInt, paramViewGroup, false);
            paramView.setTag(1090453507, Integer.valueOf(paramInt));
            return paramView;
        }
    }

    public T invalidate(String paramString) {
        paramString = getCachedFile(paramString);
        if (paramString != null) {
            paramString.delete();
        }
        return self();
    }

    public T invisible() {
        return visibility(4);
    }

    protected <K> T invoke(AbstractAjaxCallback<?, K> paramAbstractAjaxCallback) {
        if (this.ah != null) {
            paramAbstractAjaxCallback.auth(this.ah);
        }
        if (this.progress != null) {
            paramAbstractAjaxCallback.progress(this.progress);
        }
        if (this.trans != null) {
            paramAbstractAjaxCallback.transformer(this.trans);
        }
        paramAbstractAjaxCallback.policy(this.policy);
        if (this.proxy != null) {
            paramAbstractAjaxCallback.proxy(this.proxy.getHostName(), this.proxy.getPort());
        }
        if (this.act != null) {
            paramAbstractAjaxCallback.async(this.act);
        }
        for (; ; ) {
            reset();
            return self();
            paramAbstractAjaxCallback.async(getContext());
        }
    }

    public Object invoke(String paramString, Class<?>[] paramArrayOfClass, Object... paramVarArgs) {
        View localView = this.view;
        Object localObject = localView;
        if (localView == null) {
            localObject = this.act;
        }
        return AQUtility.invokeHandler(localObject, paramString, false, false, paramArrayOfClass, paramVarArgs);
    }

    public boolean isChecked() {
        boolean bool = false;
        if ((this.view instanceof CompoundButton)) {
            bool = ((CompoundButton) this.view).isChecked();
        }
        return bool;
    }

    public boolean isExist() {
        return this.view != null;
    }

    public T itemClicked(AdapterView.OnItemClickListener paramOnItemClickListener) {
        if ((this.view instanceof AdapterView)) {
            ((AdapterView) this.view).setOnItemClickListener(paramOnItemClickListener);
        }
        return self();
    }

    public T itemClicked(Object paramObject, String paramString) {
        return itemClicked(new Common().forward(paramObject, paramString, true, ON_ITEM_SIG));
    }

    public T itemSelected(AdapterView.OnItemSelectedListener paramOnItemSelectedListener) {
        if ((this.view instanceof AdapterView)) {
            ((AdapterView) this.view).setOnItemSelectedListener(paramOnItemSelectedListener);
        }
        return self();
    }

    public T itemSelected(Object paramObject, String paramString) {
        return itemSelected(new Common().forward(paramObject, paramString, true, ON_ITEM_SIG));
    }

    public T longClick() {
        if (this.view != null) {
            this.view.performLongClick();
        }
        return self();
    }

    public T longClicked(View.OnLongClickListener paramOnLongClickListener) {
        if (this.view != null) {
            this.view.setOnLongClickListener(paramOnLongClickListener);
        }
        return self();
    }

    public T longClicked(Object paramObject, String paramString) {
        return longClicked(new Common().forward(paramObject, paramString, true, ON_CLICK_SIG));
    }

    public File makeSharedFile(String paramString1, String paramString2) {
        FileOutputStream localFileOutputStream = null;
        try {
            paramString1 = getCachedFile(paramString1);
            if (paramString1 == null) {
                break label138;
            }
            Object localObject1 = AQUtility.getTempDir();
            if (localObject1 == null) {
                break label138;
            }
            paramString2 = new File((File) localObject1, paramString2);
            try {
                paramString2.createNewFile();
                paramString1 = new FileInputStream(paramString1);
                localFileOutputStream = new FileOutputStream(paramString2);
                localObject1 = paramString1.getChannel();
                FileChannel localFileChannel = localFileOutputStream.getChannel();
                try {
                    ((FileChannel) localObject1).transferTo(0L, ((FileChannel) localObject1).size(), localFileChannel);
                    return paramString2;
                } finally {
                    AQUtility.close(paramString1);
                    AQUtility.close(localFileOutputStream);
                    AQUtility.close((Closeable) localObject1);
                    AQUtility.close(localFileChannel);
                }
                AQUtility.debug(paramString1);
            } catch (Exception paramString1) {
            }
        } catch (Exception paramString1) {
            for (; ; ) {
                paramString2 = localFileOutputStream;
            }
        }
        return paramString2;
        label138:
        return null;
    }

    public T margin(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
        if (this.view != null) {
            ViewGroup.LayoutParams localLayoutParams = this.view.getLayoutParams();
            if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
                Context localContext = getContext();
                int i = AQUtility.dip2pixel(localContext, paramFloat1);
                int j = AQUtility.dip2pixel(localContext, paramFloat2);
                int k = AQUtility.dip2pixel(localContext, paramFloat3);
                int m = AQUtility.dip2pixel(localContext, paramFloat4);
                ((ViewGroup.MarginLayoutParams) localLayoutParams).setMargins(i, j, k, m);
                this.view.setLayoutParams(localLayoutParams);
            }
        }
        return self();
    }

    public T overridePendingTransition5(int paramInt1, int paramInt2) {
        if (this.act != null) {
            AQUtility.invokeHandler(this.act, "overridePendingTransition", false, false, PENDING_TRANSITION_SIG, new Object[]{Integer.valueOf(paramInt1), Integer.valueOf(paramInt2)});
        }
        return self();
    }

    public T parent(int paramInt) {
        Object localObject1 = this.view;
        Object localObject2 = null;
        for (; ; ) {
            if (localObject1 == null) {
                localObject1 = localObject2;
            }
            ViewParent localViewParent;
            do {
                do {
                    return create((View) localObject1);
                } while (((View) localObject1).getId() == paramInt);
                localViewParent = ((View) localObject1).getParent();
                localObject1 = localObject2;
            } while (!(localViewParent instanceof View));
            localObject1 = (View) localViewParent;
        }
    }

    public T policy(int paramInt) {
        this.policy = paramInt;
        return self();
    }

    public <K> T post(String paramString1, String paramString2, HttpEntity paramHttpEntity, Class<K> paramClass, AjaxCallback<K> paramAjaxCallback) {
        ((AjaxCallback) ((AjaxCallback) ((AjaxCallback) ((AjaxCallback) paramAjaxCallback.url(paramString1)).type(paramClass)).method(1)).header("Content-Type", paramString2)).param("%entity", paramHttpEntity);
        return ajax(paramAjaxCallback);
    }

    public <K> T post(String paramString, JSONObject paramJSONObject, Class<K> paramClass, AjaxCallback<K> paramAjaxCallback) {
        try {
            paramString = post(paramString, "application/json", new StringEntity(paramJSONObject.toString(), "UTF-8"), paramClass, paramAjaxCallback);
            return paramString;
        } catch (UnsupportedEncodingException paramString) {
            throw new IllegalArgumentException(paramString);
        }
    }

    public T progress(int paramInt) {
        this.progress = findView(paramInt);
        return self();
    }

    public T progress(Dialog paramDialog) {
        this.progress = paramDialog;
        return self();
    }

    public T progress(Object paramObject) {
        this.progress = paramObject;
        return self();
    }

    public T proxy(String paramString, int paramInt) {
        this.proxy = new HttpHost(paramString, paramInt);
        return self();
    }

    public <K> T put(String paramString1, String paramString2, HttpEntity paramHttpEntity, Class<K> paramClass, AjaxCallback<K> paramAjaxCallback) {
        ((AjaxCallback) ((AjaxCallback) ((AjaxCallback) ((AjaxCallback) paramAjaxCallback.url(paramString1)).type(paramClass)).method(3)).header("Content-Type", paramString2)).param("%entity", paramHttpEntity);
        return ajax(paramAjaxCallback);
    }

    public <K> T put(String paramString, JSONObject paramJSONObject, Class<K> paramClass, AjaxCallback<K> paramAjaxCallback) {
        try {
            paramString = put(paramString, "application/json", new StringEntity(paramJSONObject.toString(), "UTF-8"), paramClass, paramAjaxCallback);
            return paramString;
        } catch (UnsupportedEncodingException paramString) {
            throw new IllegalArgumentException(paramString);
        }
    }

    public T rating(float paramFloat) {
        if ((this.view instanceof RatingBar)) {
            ((RatingBar) this.view).setRating(paramFloat);
        }
        return self();
    }

    public T recycle(View paramView) {
        this.root = paramView;
        this.view = paramView;
        reset();
        this.context = null;
        return self();
    }

    protected void reset() {
        this.ah = null;
        this.progress = null;
        this.trans = null;
        this.policy = 0;
        this.proxy = null;
    }

    public T scrolled(AbsListView.OnScrollListener paramOnScrollListener) {
        if ((this.view instanceof AbsListView)) {
            setScrollListener().forward(paramOnScrollListener);
        }
        return self();
    }

    public T scrolledBottom(Object paramObject, String paramString) {
        if ((this.view instanceof AbsListView)) {
            setScrollListener().forward(paramObject, paramString, true, ON_SCROLLED_STATE_SIG);
        }
        return self();
    }

    protected T self() {
        return this;
    }

    public T setLayerType11(int paramInt, Paint paramPaint) {
        if (this.view != null) {
            AQUtility.invokeHandler(this.view, "setLayerType", false, false, LAYER_TYPE_SIG, new Object[]{Integer.valueOf(paramInt), paramPaint});
        }
        return self();
    }

    public T setOverScrollMode9(int paramInt) {
        if ((this.view instanceof AbsListView)) {
            AQUtility.invokeHandler(this.view, "setOverScrollMode", false, false, OVER_SCROLL_SIG, new Object[]{Integer.valueOf(paramInt)});
        }
        return self();
    }

    public T setSelection(int paramInt) {
        if ((this.view instanceof AdapterView)) {
            ((AdapterView) this.view).setSelection(paramInt);
        }
        return self();
    }

    public boolean shouldDelay(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup, String paramString) {
        return Common.shouldDelay(paramInt1, paramInt2, paramView, paramViewGroup, paramString);
    }

    public boolean shouldDelay(int paramInt, View paramView, ViewGroup paramViewGroup, String paramString) {
        if ((paramViewGroup instanceof ExpandableListView)) {
            throw new IllegalArgumentException("Please use the other shouldDelay methods for expandable list.");
        }
        return Common.shouldDelay(paramInt, paramView, paramViewGroup, paramString);
    }

    public boolean shouldDelay(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup, String paramString) {
        return Common.shouldDelay(paramInt, -1, paramView, paramViewGroup, paramString);
    }

    @Deprecated
    public boolean shouldDelay(View paramView, ViewGroup paramViewGroup, String paramString, float paramFloat) {
        return Common.shouldDelay(paramView, paramViewGroup, paramString, paramFloat, true);
    }

    @Deprecated
    public boolean shouldDelay(View paramView, ViewGroup paramViewGroup, String paramString, float paramFloat, boolean paramBoolean) {
        return Common.shouldDelay(paramView, paramViewGroup, paramString, paramFloat, paramBoolean);
    }

    public T show(Dialog paramDialog) {
        if (paramDialog != null) {
        }
        try {
            paramDialog.show();
            dialogs.put(paramDialog, null);
            return self();
        } catch (Exception paramDialog) {
            for (; ; ) {
            }
        }
    }

    public <K> T sync(AjaxCallback<K> paramAjaxCallback) {
        ajax(paramAjaxCallback);
        paramAjaxCallback.block();
        return self();
    }

    public T tag(int paramInt, Object paramObject) {
        if (this.view != null) {
            this.view.setTag(paramInt, paramObject);
        }
        return self();
    }

    public T tag(Object paramObject) {
        if (this.view != null) {
            this.view.setTag(paramObject);
        }
        return self();
    }

    public T text(int paramInt) {
        if ((this.view instanceof TextView)) {
            ((TextView) this.view).setText(paramInt);
        }
        return self();
    }

    public T text(int paramInt, Object... paramVarArgs) {
        Context localContext = getContext();
        if (localContext != null) {
            text(localContext.getString(paramInt, paramVarArgs));
        }
        return self();
    }

    public T text(Spanned paramSpanned) {
        if ((this.view instanceof TextView)) {
            ((TextView) this.view).setText(paramSpanned);
        }
        return self();
    }

    public T text(CharSequence paramCharSequence) {
        if ((this.view instanceof TextView)) {
            ((TextView) this.view).setText(paramCharSequence);
        }
        return self();
    }

    public T text(CharSequence paramCharSequence, boolean paramBoolean) {
        if ((paramBoolean) && ((paramCharSequence == null) || (paramCharSequence.length() == 0))) {
            return gone();
        }
        return text(paramCharSequence);
    }

    public T textChanged(Object paramObject, String paramString) {
        if ((this.view instanceof TextView)) {
            ((TextView) this.view).addTextChangedListener(new Common().forward(paramObject, paramString, true, TEXT_CHANGE_SIG));
        }
        return self();
    }

    public T textColor(int paramInt) {
        if ((this.view instanceof TextView)) {
            ((TextView) this.view).setTextColor(paramInt);
        }
        return self();
    }

    public T textColorId(int paramInt) {
        return textColor(getContext().getResources().getColor(paramInt));
    }

    public T textSize(float paramFloat) {
        if ((this.view instanceof TextView)) {
            ((TextView) this.view).setTextSize(paramFloat);
        }
        return self();
    }

    public T transformer(Transformer paramTransformer) {
        this.trans = paramTransformer;
        return self();
    }

    public T transparent(boolean paramBoolean) {
        if (this.view != null) {
            AQUtility.transparent(this.view, paramBoolean);
        }
        return self();
    }

    public T typeface(Typeface paramTypeface) {
        if ((this.view instanceof TextView)) {
            ((TextView) this.view).setTypeface(paramTypeface);
        }
        return self();
    }

    public T visibility(int paramInt) {
        if ((this.view != null) && (this.view.getVisibility() != paramInt)) {
            this.view.setVisibility(paramInt);
        }
        return self();
    }

    public T visible() {
        return visibility(0);
    }

    public T webImage(String paramString) {
        return webImage(paramString, true, false, -16777216);
    }

    public T webImage(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt) {
        if ((this.view instanceof WebView)) {
            setLayerType11(1, null);
            new WebImage((WebView) this.view, paramString, this.progress, paramBoolean1, paramBoolean2, paramInt).load();
            this.progress = null;
        }
        return self();
    }

    public T width(int paramInt) {
        size(true, paramInt, true);
        return self();
    }

    public T width(int paramInt, boolean paramBoolean) {
        size(true, paramInt, paramBoolean);
        return self();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/androidquery/AbstractAQuery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */