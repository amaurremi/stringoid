package com.quoord.tapatalkpro.bean;

import android.app.Activity;
import android.content.res.Resources;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.sqlhelper.FavoriateSqlHelper;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tools.ImageTools;
import com.quoord.tools.net.JSONUtil;
import com.quoord.tools.roundedimageview.RoundedImageView;
import org.json.JSONException;
import org.json.JSONObject;

public class Feed {
    public static int BOTTOM_ALERT_ITEM = 2;
    public static int MID_ALERT_ITEM = 0;
    public static int ONE_ALERT_ITEM = 3;
    public static final String TAG_CONVERSATION = "conv";
    public static final String TAG_LIKE = "like";
    public static final String TAG_NEW = "newtopic";
    public static final String TAG_PM = "pm";
    public static final String TAG_QUOTE = "quote";
    public static final String TAG_SUBSCRIBE = "sub";
    public static final String TAG_TAG = "tag";
    public static final String TAG_THANK = "thank";
    public static final String TAG_TOPIC = "topic";
    public static int TOP_ALERT_ITEM = 0;
    private String author = null;
    private int dateline;
    private String feedForumUrl = null;
    private String feed_id = null;
    private String feed_img = null;
    private String feed_name = null;
    private String feed_title = null;
    private String fid = null;
    private String iconUrl = null;
    private String id = null;
    private String sub_id = null;
    private String type = null;
    private String uid = null;

    static {
        MID_ALERT_ITEM = 1;
    }

    public static Feed createFeeds(JSONObject paramJSONObject, Activity paramActivity, FavoriateSqlHelper paramFavoriateSqlHelper)
            throws JSONException {
        paramActivity = new Feed();
        JSONUtil localJSONUtil = new JSONUtil(paramJSONObject);
        paramActivity.setFeed_id(localJSONUtil.optString("feed_id"));
        paramActivity.setFid(localJSONUtil.optString("fid"));
        paramActivity.setFeed_name(localJSONUtil.optString("name"));
        paramActivity.setType(localJSONUtil.optString("type"));
        paramActivity.setDateline(localJSONUtil.optInteger("dateline").intValue());
        paramActivity.setId(localJSONUtil.optString("id"));
        paramActivity.setSub_id(localJSONUtil.optString("subid"));
        paramActivity.setFeed_title(localJSONUtil.optString("title"));
        paramActivity.setUid(localJSONUtil.optString("uid"));
        paramActivity.setAuthor(localJSONUtil.optString("author"));
        if (paramJSONObject.has("topic_image")) {
            paramActivity.setFeed_img(localJSONUtil.optString("topic_image"));
        }
        if (paramFavoriateSqlHelper.getFavrivateById(paramActivity.getFid()) != null) {
            paramJSONObject = paramFavoriateSqlHelper.getFavrivateById(paramActivity.getFid());
            paramActivity.setIcon(paramJSONObject.getIconUrl());
            paramActivity.setFeedForumUrl(paramJSONObject.getForumUrl());
        }
        return paramActivity;
    }

    private void setUserAvatar(TapatalkForum paramTapatalkForum) {
    }

    public View createView(int paramInt1, View paramView, ViewGroup paramViewGroup, Activity paramActivity, int paramInt2) {
        if ((paramView == null) || (!(paramView.getTag() instanceof ViewHolder))) {
            paramViewGroup = new ViewHolder();
            paramView = LayoutInflater.from(paramActivity).inflate(2130903160, null);
            paramViewGroup.alertLay = ((RelativeLayout) paramView.findViewById(2131231068));
            paramViewGroup.feedIcon = ((ImageView) paramView.findViewById(2131231069));
            paramViewGroup.feedForumName = ((TextView) paramView.findViewById(2131231071));
            paramViewGroup.feedTitle = ((TextView) paramView.findViewById(2131231072));
            paramViewGroup.feedTimeStamp = ((TextView) paramView.findViewById(2131231074));
            paramViewGroup.feedImage = ((ImageView) paramView.findViewById(2131231073));
            paramViewGroup.contentView = ((RelativeLayout) paramView.findViewById(2131231070));
            paramViewGroup.diver = ((ImageView) paramView.findViewById(2131230776));
            paramView.setTag(paramViewGroup);
            if (!SettingsFragment.isLightTheme(paramActivity)) {
                break label450;
            }
            paramViewGroup.alertLay.setBackgroundColor(paramActivity.getResources().getColor(2131165213));
            paramViewGroup.feedForumName.setTextColor(paramActivity.getResources().getColor(2131165214));
            paramViewGroup.feedTimeStamp.setTextColor(paramActivity.getResources().getColor(2131165283));
            paramViewGroup.diver.setBackgroundColor(paramActivity.getResources().getColor(2131165220));
            label226:
            paramViewGroup.feedForumName.setText(getFeed_name());
            paramViewGroup.feedTitle.setText(getContent(paramActivity));
            if ((Util.isEmpty(getFeedForumUrl())) || (Util.isEmpty(getAuthor()))) {
                break label525;
            }
            String str = getFeedForumUrl() + "/mobiquo/avatar.php?username=" + getAuthor();
            ((RoundedImageView) paramViewGroup.feedIcon).setBackgroundDrawable(paramActivity.getResources().getDrawable(2130839528));
            ImageTools.glideLoad(str, paramViewGroup.feedIcon, 2130837858);
            label335:
            paramViewGroup.feedTimeStamp.setText(Util.getShortTimeString(paramActivity, getDateline()));
            if (Util.is2GState(paramActivity)) {
                break label575;
            }
            if ((!SettingsFragment.isEnableTopicImg(paramActivity)) || (this.feed_img == null) || (this.feed_img.equals(""))) {
                break label563;
            }
            paramViewGroup.feedImage.setVisibility(0);
            ImageTools.glideLoad(this.feed_img, paramViewGroup.feedImage);
            label406:
            if (paramInt2 != ONE_ALERT_ITEM) {
                if (paramInt2 != TOP_ALERT_ITEM) {
                    break label637;
                }
                paramViewGroup.diver.setVisibility(0);
            }
        }
        for (; ; ) {
            paramViewGroup.alertLay.bringToFront();
            return paramView;
            paramViewGroup = (ViewHolder) paramView.getTag();
            break;
            label450:
            paramViewGroup.alertLay.setBackgroundColor(paramActivity.getResources().getColor(2131165214));
            paramViewGroup.feedForumName.setTextColor(paramActivity.getResources().getColor(2131165213));
            paramViewGroup.feedTimeStamp.setTextColor(paramActivity.getResources().getColor(2131165294));
            paramViewGroup.diver.setBackgroundColor(paramActivity.getResources().getColor(2131165332));
            break label226;
            label525:
            ((RoundedImageView) paramViewGroup.feedIcon).setBackgroundDrawable(paramActivity.getResources().getDrawable(2130839528));
            ImageTools.glideLoad(this.iconUrl, paramViewGroup.feedIcon, 2130837858);
            break label335;
            label563:
            paramViewGroup.feedImage.setVisibility(8);
            break label406;
            label575:
            if ((SettingsFragment.isEnableTopicImgWithSlowConn(paramActivity)) && (this.feed_img != null) && (!this.feed_img.equals(""))) {
                paramViewGroup.feedImage.setVisibility(0);
                ImageTools.glideLoad(this.feed_img, paramViewGroup.feedImage);
                break label406;
            }
            paramViewGroup.feedImage.setVisibility(8);
            break label406;
            label637:
            if (paramInt2 != BOTTOM_ALERT_ITEM) {
                paramViewGroup.diver.setVisibility(0);
            }
        }
    }

    public String getAuthor() {
        return this.author;
    }

    public Spanned getContent(Activity paramActivity) {
        if (SettingsFragment.isLightTheme(paramActivity)) {
            return Html.fromHtml("<font color = #000000><b>" + getAuthor() + "</b></font>" + "<font color = #6e6e6e>" + getTypeContent(paramActivity) + "</font>" + "<font color = #6e6e6e>" + getFeed_title() + "</font>");
        }
        return Html.fromHtml("<font color = #ffffff>" + getAuthor() + "</font>" + "<font color = #cccccc>" + getTypeContent(paramActivity) + "</font>" + "<font color = #cccccc>" + getFeed_title() + "</font>");
    }

    public int getDateline() {
        return this.dateline;
    }

    public String getFeedForumUrl() {
        return this.feedForumUrl;
    }

    public String getFeed_id() {
        return this.feed_id;
    }

    public String getFeed_img() {
        return this.feed_img;
    }

    public String getFeed_name() {
        return this.feed_name;
    }

    public String getFeed_title() {
        return this.feed_title;
    }

    public String getFid() {
        return this.fid;
    }

    public String getIcon() {
        return this.iconUrl;
    }

    public String getId() {
        return this.id;
    }

    public String getSub_id() {
        return this.sub_id;
    }

    public String getType() {
        return this.type;
    }

    public String getTypeContent(Activity paramActivity) {
        String str = null;
        if (this.type.equals("quote")) {
            str = paramActivity.getResources().getString(2131100731);
        }
        do {
            return str;
            if (this.type.equals("like")) {
                return paramActivity.getResources().getString(2131100732);
            }
            if (this.type.equals("thank")) {
                return paramActivity.getResources().getString(2131100733);
            }
            if (this.type.equals("tag")) {
                return paramActivity.getResources().getString(2131100734);
            }
            if (this.type.equals("sub")) {
                return paramActivity.getResources().getString(2131100735);
            }
            if (this.type.equals("newtopic")) {
                return paramActivity.getResources().getString(2131100738);
            }
            if (this.type.equals("pm")) {
                return paramActivity.getResources().getString(2131100737);
            }
        } while (!this.type.equals("conv"));
        return paramActivity.getResources().getString(2131100736);
    }

    public String getUid() {
        return this.uid;
    }

    public void setAuthor(String paramString) {
        this.author = paramString;
    }

    public void setDateline(int paramInt) {
        this.dateline = paramInt;
    }

    public void setFeedForumUrl(String paramString) {
        this.feedForumUrl = paramString;
    }

    public void setFeed_id(String paramString) {
        this.feed_id = paramString;
    }

    public void setFeed_img(String paramString) {
        this.feed_img = paramString;
    }

    public void setFeed_name(String paramString) {
        this.feed_name = paramString;
    }

    public void setFeed_title(String paramString) {
        this.feed_title = paramString;
    }

    public void setFid(String paramString) {
        this.fid = paramString;
    }

    public void setIcon(String paramString) {
        this.iconUrl = paramString;
    }

    public void setId(String paramString) {
        this.id = paramString;
    }

    public void setSub_id(String paramString) {
        this.sub_id = paramString;
    }

    public void setType(String paramString) {
        this.type = paramString;
    }

    public void setUid(String paramString) {
        this.uid = paramString;
    }

    public class ViewHolder {
        public RelativeLayout alertLay;
        public RelativeLayout contentView;
        public ImageView diver;
        public TextView feedForumName;
        public ImageView feedIcon;
        public ImageView feedImage;
        public TextView feedTimeStamp;
        public TextView feedTitle;

        public ViewHolder() {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/bean/Feed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */