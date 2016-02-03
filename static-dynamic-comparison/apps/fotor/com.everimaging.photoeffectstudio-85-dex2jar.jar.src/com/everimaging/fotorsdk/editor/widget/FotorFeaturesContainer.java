package com.everimaging.fotorsdk.editor.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.everimaging.fotorsdk.editor.FotorFeaturesFactory;
import com.everimaging.fotorsdk.editor.FotorFeaturesFactory.FeatureType;
import com.everimaging.fotorsdk.editor.R.id;
import com.everimaging.fotorsdk.editor.R.layout;
import com.everimaging.fotorsdk.editor.widget.entity.FeatureInfo;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;
import com.everimaging.fotorsdk.widget.FotorNavigationButton;
import com.everimaging.fotorsdk.widget.lib.hlist.HListView;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class FotorFeaturesContainer
        extends FrameLayout
        implements View.OnClickListener {
    private static final String TAG = FotorFeaturesContainer.class.getSimpleName();
    private static final FotorLoggerFactory.c logger = FotorLoggerFactory.a(TAG, FotorLoggerFactory.LoggerType.CONSOLE);
    private FeaturesAdapter mAdapter;
    private String mApiKey;
    private List<String> mFeatureList;
    private FeatureOnClickListener mFeatureOnClickListener;
    private HListView mHListView;

    public FotorFeaturesContainer(Context paramContext, String paramString, List<String> paramList) {
        super(paramContext);
        this.mFeatureList = paramList;
        this.mApiKey = paramString;
        if (paramList == null) {
            this.mFeatureList = Arrays.asList(FotorFeaturesFactory.getAllFeatures());
        }
        logger.c(new Object[]{"featureList:" + this.mFeatureList});
        setupViews();
    }

    private String getFeatureResName(String paramString) {
        return "fotor_feature_" + paramString.toLowerCase(Locale.US);
    }

    private static native boolean nativeSetupFC(FotorFeaturesContainer paramFotorFeaturesContainer, String paramString, List<String> paramList);

    private void setupViews() {
        logger.c(new Object[]{"setupViews"});
        this.mHListView = new HListView(getContext());
        this.mHListView.setId(R.id.fotor_features_listview);
        this.mHListView.setHeaderDividersEnabled(true);
        this.mHListView.setFooterDividersEnabled(true);
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -1);
        localLayoutParams.gravity = 17;
        addView(this.mHListView, localLayoutParams);
        nativeSetupFC(this, this.mApiKey, this.mFeatureList);
    }

    public void onClick(View paramView) {
        int i = Integer.parseInt(paramView.getTag().toString());
        paramView = (FeatureInfo) this.mAdapter.getItem(i);
        if (this.mFeatureOnClickListener != null) {
            this.mFeatureOnClickListener.onClick(paramView.getFeatureType());
        }
    }

    public void setFeatureOnClickListener(FeatureOnClickListener paramFeatureOnClickListener) {
        this.mFeatureOnClickListener = paramFeatureOnClickListener;
    }

    public static abstract interface FeatureOnClickListener {
        public abstract void onClick(FotorFeaturesFactory.FeatureType paramFeatureType);
    }

    class FeaturesAdapter
            extends BaseAdapter {
        private Context mContext;
        private List<FeatureInfo> mFeatureInfos;
        private LayoutInflater mInflater;

        public FeaturesAdapter(List<FeatureInfo> paramList) {
            this.mContext = paramList;
            List localList;
            this.mFeatureInfos = localList;
            this.mInflater = ((LayoutInflater) this.mContext.getSystemService("layout_inflater"));
        }

        public int getCount() {
            return this.mFeatureInfos.size();
        }

        public Object getItem(int paramInt) {
            return this.mFeatureInfos.get(paramInt);
        }

        public long getItemId(int paramInt) {
            return paramInt;
        }

        public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
            Object localObject = (FeatureInfo) this.mFeatureInfos.get(paramInt);
            FotorNavigationButton localFotorNavigationButton;
            if (paramView == null) {
                paramView = this.mInflater.inflate(R.layout.fotor_main_footer_item, null);
                paramViewGroup = new ViewHolder(null);
                paramViewGroup.button = ((FotorNavigationButton) paramView.findViewById(R.id.fotor_navigation_button));
                paramView.setTag(paramViewGroup);
                paramViewGroup.button.setImageResource(((FeatureInfo) localObject).getThumbnailResID());
                localFotorNavigationButton = paramViewGroup.button;
                if (((FeatureInfo) localObject).getTitleResID() != 0) {
                    break label139;
                }
            }
            label139:
            for (localObject = null; ; localObject = FotorFeaturesContainer.this.getResources().getString(((FeatureInfo) localObject).getTitleResID())) {
                localFotorNavigationButton.setButtonName((CharSequence) localObject);
                paramViewGroup.button.setTag(Integer.valueOf(paramInt));
                paramViewGroup.button.setIsShowPressedBackground(true);
                paramViewGroup.button.setOnClickListener(FotorFeaturesContainer.this);
                return paramView;
                paramViewGroup = (ViewHolder) paramView.getTag();
                break;
            }
        }

        private class ViewHolder {
            FotorNavigationButton button;

            private ViewHolder() {
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/editor/widget/FotorFeaturesContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */