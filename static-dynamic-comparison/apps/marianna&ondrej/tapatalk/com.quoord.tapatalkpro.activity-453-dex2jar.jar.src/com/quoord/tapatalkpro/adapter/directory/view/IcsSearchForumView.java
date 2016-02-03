package com.quoord.tapatalkpro.adapter.directory.view;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Handler;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.bean.TapatalkForumForSearch;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tools.ImageTools;
import com.quoord.tools.net.JSONUtil;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.json.JSONObject;

public class IcsSearchForumView {
    private ImageView addImg;
    private View addView;
    private String channel;
    private boolean isAdded = false;
    private Activity mActivity;
    private TapatalkForum mForum;
    private SearchForumTag mTag;
    private boolean needHiddenAddView;

    public IcsSearchForumView(Activity paramActivity, String paramString, boolean paramBoolean) {
        this.mActivity = paramActivity;
        this.channel = paramString;
        this.needHiddenAddView = paramBoolean;
    }

    private void hideDescription(final TapatalkForumViewHolder paramTapatalkForumViewHolder) {
        if (paramTapatalkForumViewHolder == null) {
        }
        while ((paramTapatalkForumViewHolder.forumIcon == null) || (paramTapatalkForumViewHolder.forumDescriptionTv == null)) {
            return;
        }
        paramTapatalkForumViewHolder.forumDescriptionTv.setVisibility(8);
        new Handler().post(new Runnable() {
            public void run() {
                RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams) paramTapatalkForumViewHolder.forumIcon.getLayoutParams();
                localLayoutParams.setMargins(localLayoutParams.leftMargin, localLayoutParams.topMargin, localLayoutParams.rightMargin, Util.getPxFromDip(IcsSearchForumView.this.mActivity, 20.0F));
                paramTapatalkForumViewHolder.forumIcon.setLayoutParams(localLayoutParams);
            }
        });
    }

    private TapatalkForumViewHolder initViewHolder(View paramView) {
        TapatalkForumViewHolder localTapatalkForumViewHolder = new TapatalkForumViewHolder(null);
        localTapatalkForumViewHolder.itemLayout = paramView.findViewById(2131231229);
        localTapatalkForumViewHolder.forumIcon = ((ImageView) paramView.findViewById(2131231230));
        localTapatalkForumViewHolder.forumNameTv = ((TextView) paramView.findViewById(2131231234));
        localTapatalkForumViewHolder.forumDescriptionTv = ((TextView) paramView.findViewById(2131231239));
        localTapatalkForumViewHolder.proboardImg = ((ImageView) paramView.findViewById(2131231231));
        localTapatalkForumViewHolder.tapatalkUserCountIcon = ((ImageView) paramView.findViewById(2131231235));
        localTapatalkForumViewHolder.tapatalkUserCountTv = ((TextView) paramView.findViewById(2131231236));
        localTapatalkForumViewHolder.totalThreadsIcon = ((ImageView) paramView.findViewById(2131231237));
        localTapatalkForumViewHolder.totalThreadsTv = ((TextView) paramView.findViewById(2131231238));
        localTapatalkForumViewHolder.trendingDiscussionContainer = paramView.findViewById(2131231240);
        localTapatalkForumViewHolder.addImg = ((ImageView) paramView.findViewById(2131231233));
        localTapatalkForumViewHolder.addArea = paramView.findViewById(2131231232);
        return localTapatalkForumViewHolder;
    }

    private void updateViewHolder(TapatalkForumViewHolder paramTapatalkForumViewHolder, int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
        Object localObject = this.mForum;
        if (localObject == null) {
            return;
        }
        if (paramBoolean1) {
            Util.setBg(paramTapatalkForumViewHolder.forumIcon, this.mActivity.getResources().getDrawable(2130837534));
            if (paramBoolean2) {
                Util.setBg(paramTapatalkForumViewHolder.itemLayout, this.mActivity.getResources().getDrawable(2130838975));
                if (((TapatalkForum) localObject).getName() != null) {
                    paramTapatalkForumViewHolder.forumNameTv.setText(((TapatalkForum) localObject).getName());
                }
                if ((((TapatalkForum) localObject).getDescription() == null) || (((TapatalkForum) localObject).getDescription().equals(""))) {
                    break label362;
                }
                paramTapatalkForumViewHolder.forumDescriptionTv.setText(((TapatalkForum) localObject).getDescription());
                paramTapatalkForumViewHolder.forumDescriptionTv.setVisibility(0);
                label120:
                if ((((TapatalkForum) localObject).getTapatalkUserCount() != null) && (((TapatalkForum) localObject).getTapatalkUserCount().intValue() != 0)) {
                    break label370;
                }
                paramTapatalkForumViewHolder.tapatalkUserCountIcon.setVisibility(8);
                paramTapatalkForumViewHolder.tapatalkUserCountTv.setVisibility(8);
                label157:
                if ((((TapatalkForum) localObject).getTotalThreads() != null) && (((TapatalkForum) localObject).getTotalThreads().intValue() != 0)) {
                    break label414;
                }
                paramTapatalkForumViewHolder.totalThreadsIcon.setVisibility(8);
                paramTapatalkForumViewHolder.totalThreadsTv.setVisibility(8);
                label194:
                ImageTools.glideLoad(((TapatalkForum) localObject).getIconUrl(), paramTapatalkForumViewHolder.forumIcon);
                if ((((TapatalkForum) localObject).getType() == null) || (!((TapatalkForum) localObject).getType().equals("proboards"))) {
                    break label458;
                }
                paramTapatalkForumViewHolder.proboardImg.setVisibility(0);
                label235:
                if (SearchForumTag.ADD_BTN_SHOW_UNCONTAINED != this.mTag) {
                    break label490;
                }
                if (!Util.isFavoriate(this.mActivity, this.mForum.getId().intValue())) {
                    break label470;
                }
                paramTapatalkForumViewHolder.addArea.setVisibility(8);
            }
        }
        for (; ; ) {
            if ((localObject instanceof TapatalkForumForSearch)) {
                if (((TapatalkForumForSearch) localObject).getTrendingDiscussionJson() == null) {
                    paramTapatalkForumViewHolder.trendingDiscussionContainer.setVisibility(8);
                    return;
                    Util.setBg(paramTapatalkForumViewHolder.itemLayout, this.mActivity.getResources().getDrawable(2130838974));
                    break;
                    Util.setBg(paramTapatalkForumViewHolder.itemLayout, ThemeUtil.getBgDrawableByPicNameForList("list_item_bg_normal", this.mActivity, paramBoolean2));
                    Util.setBg(paramTapatalkForumViewHolder.forumIcon, ThemeUtil.getDrawableByPicName("avator_background", this.mActivity));
                    break;
                    label362:
                    hideDescription(paramTapatalkForumViewHolder);
                    break label120;
                    label370:
                    paramTapatalkForumViewHolder.tapatalkUserCountIcon.setVisibility(0);
                    paramTapatalkForumViewHolder.tapatalkUserCountTv.setVisibility(0);
                    NumberFormat localNumberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
                    paramTapatalkForumViewHolder.tapatalkUserCountTv.setText(localNumberFormat.format(((TapatalkForum) localObject).getTapatalkUserCount()));
                    break label157;
                    label414:
                    paramTapatalkForumViewHolder.totalThreadsIcon.setVisibility(0);
                    paramTapatalkForumViewHolder.totalThreadsTv.setVisibility(0);
                    localNumberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
                    paramTapatalkForumViewHolder.totalThreadsTv.setText(localNumberFormat.format(((TapatalkForum) localObject).getTotalThreads()));
                    break label194;
                    label458:
                    paramTapatalkForumViewHolder.proboardImg.setVisibility(8);
                    break label235;
                    label470:
                    paramTapatalkForumViewHolder.addArea.setVisibility(0);
                    paramTapatalkForumViewHolder.addImg.setImageResource(2130839293);
                    continue;
                    label490:
                    if (SearchForumTag.ADD_BTN_SHOW_ADD == this.mTag) {
                        paramTapatalkForumViewHolder.addArea.setVisibility(0);
                        paramTapatalkForumViewHolder.addImg.setImageResource(2130837512);
                        continue;
                    }
                    if (SearchForumTag.ADD_BTN_SHOW_CHECK == this.mTag) {
                        paramTapatalkForumViewHolder.addArea.setVisibility(0);
                        paramTapatalkForumViewHolder.addImg.setImageResource(2130837513);
                        continue;
                    }
                    if (SearchForumTag.ADD_BTN_DONT_SHOW != this.mTag) {
                        continue;
                    }
                    paramTapatalkForumViewHolder.addArea.setVisibility(8);
                    continue;
                }
                ((LinearLayout) paramTapatalkForumViewHolder.trendingDiscussionContainer).removeAllViews();
                localObject = new TrendingDiscussionView(this.mActivity, ((TapatalkForumForSearch) localObject).getTrendingDiscussionJson(), paramBoolean1);
                ((LinearLayout) paramTapatalkForumViewHolder.trendingDiscussionContainer).addView(((TrendingDiscussionView) localObject).tdArea);
                paramTapatalkForumViewHolder.trendingDiscussionContainer.setVisibility(0);
                return;
            }
        }
        paramTapatalkForumViewHolder.trendingDiscussionContainer.setVisibility(8);
    }

    public ImageView getAddImg() {
        return this.addImg;
    }

    public View getAddView() {
        return this.addView;
    }

    public View getSearchForumView(TapatalkForum paramTapatalkForum, SearchForumTag paramSearchForumTag, int paramInt, View paramView, ViewGroup paramViewGroup, boolean paramBoolean) {
        return getSearchForumView(paramTapatalkForum, paramSearchForumTag, paramInt, paramView, paramViewGroup, paramBoolean, false);
    }

    public View getSearchForumView(TapatalkForum paramTapatalkForum, SearchForumTag paramSearchForumTag, int paramInt, View paramView, ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2) {
        this.mForum = paramTapatalkForum;
        this.mTag = paramSearchForumTag;
        if (paramView == null) {
            paramView = this.mActivity.getLayoutInflater().inflate(2130903204, null);
            paramTapatalkForum = initViewHolder(paramView);
            paramView.setTag(paramTapatalkForum);
        }
        for (; ; ) {
            updateViewHolder(paramTapatalkForum, paramInt, paramBoolean1, paramBoolean2);
            this.addView = paramTapatalkForum.addArea;
            this.addImg = paramTapatalkForum.addImg;
            return paramView;
            paramTapatalkForum = (TapatalkForumViewHolder) paramView.getTag();
        }
    }

    public TapatalkForum getmForum() {
        return this.mForum;
    }

    public boolean isAdded() {
        return this.isAdded;
    }

    public void setAddImg(ImageView paramImageView) {
        this.addImg = paramImageView;
    }

    public void setAddView(View paramView) {
        this.addView = paramView;
    }

    public void setAdded(boolean paramBoolean) {
        this.isAdded = paramBoolean;
    }

    public void setOnAddListener(View.OnClickListener paramOnClickListener) {
        this.addView.setOnClickListener(paramOnClickListener);
    }

    public void setmForum(TapatalkForum paramTapatalkForum) {
        this.mForum = paramTapatalkForum;
    }

    public static enum SearchForumTag {
        ADD_BTN_SHOW_ADD, ADD_BTN_SHOW_CHECK, ADD_BTN_SHOW_UNCONTAINED, ADD_BTN_DONT_SHOW;
    }

    private static class TapatalkForumViewHolder {
        View addArea;
        ImageView addImg;
        TextView forumDescriptionTv;
        ImageView forumIcon;
        TextView forumNameTv;
        View itemLayout;
        ImageView proboardImg;
        ImageView tapatalkUserCountIcon;
        TextView tapatalkUserCountTv;
        ImageView totalThreadsIcon;
        TextView totalThreadsTv;
        View trendingDiscussionContainer;
    }

    private class TrendingDiscussionView {
        private Activity activity;
        private boolean isOb = false;
        private JSONObject json = null;
        private View tdArea = null;
        private TextView tdDetailTv = null;
        private ImageView tdIcon = null;
        private ImageView tdImg = null;
        private RelativeLayout tdLayout = null;
        private TextView tdTimeTv = null;
        private TextView tdTitleTv = null;

        public TrendingDiscussionView(Activity paramActivity, JSONObject paramJSONObject, boolean paramBoolean) {
            this.activity = paramActivity;
            this.json = paramJSONObject;
            this.isOb = paramBoolean;
            initBaseLayout();
            initData();
        }

        private void initBaseLayout() {
            this.tdArea = this.activity.getLayoutInflater().inflate(2130903203, null);
            this.tdLayout = ((RelativeLayout) this.tdArea.findViewById(2131231222));
            this.tdIcon = ((ImageView) this.tdArea.findViewById(2131231223));
            this.tdImg = ((ImageView) this.tdArea.findViewById(2131231227));
            this.tdTitleTv = ((TextView) this.tdArea.findViewById(2131231225));
            this.tdDetailTv = ((TextView) this.tdArea.findViewById(2131231228));
            this.tdTimeTv = ((TextView) this.tdArea.findViewById(2131231224));
            if (this.isOb) {
                Util.setBg(this.tdImg, IcsSearchForumView.this.mActivity.getResources().getDrawable(2130838996));
                Util.setBg(this.tdLayout, IcsSearchForumView.this.mActivity.getResources().getDrawable(2130838994));
            }
            for (; ; ) {
                this.tdIcon.setImageResource(2130838918);
                this.tdTitleTv.setText(this.activity.getString(2131100809));
                return;
                Util.setBg(this.tdImg, ThemeUtil.getDrawableByPicName("avator_background", IcsSearchForumView.this.mActivity));
                Util.setBg(this.tdLayout, ThemeUtil.getDrawableByPicName("list_subitem_bg_normal", IcsSearchForumView.this.mActivity));
            }
        }

        private void initData() {
            JSONUtil localJSONUtil = new JSONUtil(this.json);
            Object localObject = localJSONUtil.optString("topic_image", "");
            if (((String) localObject).equals("")) {
                Util.setBg(this.tdImg, ThemeUtil.getDrawableByPicName("search_result_trending_defimg", IcsSearchForumView.this.mActivity));
                String str = localJSONUtil.optString("title", "");
                localObject = str;
                if (Util.isEmpty(str)) {
                    localObject = localJSONUtil.optString("topic_title", "");
                }
                localObject = "<b>" + (String) localObject + "</b>";
                this.tdDetailTv.setText(Html.fromHtml((String) localObject));
                int i = localJSONUtil.optInteger("timestamp", Integer.valueOf(0)).intValue();
                if (i == 0) {
                    break label159;
                }
                this.tdTimeTv.setText(Util.getSmartTimeString(this.activity, i));
            }
            label159:
            do {
                return;
                ImageTools.glideLoad((String) localObject, this.tdImg);
                break;
                localObject = this.json.optString("post_time");
            } while ((localObject == null) || (!((String) localObject).equals("")));
            try {
                localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse((String) localObject);
                this.tdTimeTv.setText(Util.getShortTimeString(IcsSearchForumView.this.mActivity, Util.stringFormat((Date) localObject)));
                return;
            } catch (Exception localException) {
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/directory/view/IcsSearchForumView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */