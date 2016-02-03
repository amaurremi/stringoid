package com.quoord.tapatalkpro.bean;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.quoord.tapatalkpro.adapter.forum.ForumRootAdapter;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tapatalkpro.view.ShortContentView;
import com.quoord.tools.bitmap.ui.GifImageView;

public class Alert {
    public static int BOTTOM_ALERT_ITEM = 2;
    public static int MID_ALERT_ITEM;
    public static int ONE_ALERT_ITEM = 3;
    public static int TOP_ALERT_ITEM = 0;
    private String content = null;
    private String content_id = null;
    private String content_type = null;
    private Drawable drawable = null;
    private String icon_url = null;
    private String message = null;
    private String timestamp = null;
    private String tip = null;
    private String user_id = null;
    private String user_name = null;

    static {
        MID_ALERT_ITEM = 1;
    }

    public Spanned getAlertString(int paramInt) {
        Spanned localSpanned = null;
        if (getMessage().contains("\"")) {
            this.tip = getMessage().substring(0, getMessage().indexOf("\""));
            this.content = ("\"" + getMessage().substring(getMessage().indexOf("\"") + 1, getMessage().lastIndexOf("\"")) + "\"");
            localSpanned = Html.fromHtml(this.tip + "<b><i><font color=\"" + paramInt + "\"" + " size=\"" + 18 + "\"" + ">" + this.content + "</font><i><b>");
        }
        return localSpanned;
    }

    public Spanned getAlertString(Context paramContext) {
        paramContext = null;
        if (getMessage().contains("\"")) {
            this.tip = getMessage().substring(0, getMessage().indexOf("\""));
            this.content = getMessage().substring(getMessage().indexOf("\"") + 1, getMessage().lastIndexOf("\""));
            paramContext = Html.fromHtml(this.content);
        }
        return paramContext;
    }

    public View getAlertView(int paramInt1, View paramView, ViewGroup paramViewGroup, ForumRootAdapter paramForumRootAdapter, Activity paramActivity, int paramInt2, boolean paramBoolean) {
        if ((paramView == null) || (paramView.getTag() == null) || (!(paramView.getTag() instanceof AlertViewHolder))) {
            paramViewGroup = new AlertViewHolder();
            paramView = LayoutInflater.from(paramActivity).inflate(2130903179, null);
            paramViewGroup.avaterbg = ((ImageView) paramView.findViewById(2131230795));
            paramViewGroup.alert_icon = ((GifImageView) paramView.findViewById(2131231136));
            paramViewGroup.typeIcon = ((ImageView) paramView.findViewById(2131231137));
            paramViewGroup.alert_name = ((TextView) paramView.findViewById(2131231138));
            ThemeUtil.setAuthorColor(paramActivity, paramViewGroup.alert_name);
            paramViewGroup.alert_message = ((ShortContentView) paramView.findViewById(2131231139));
            paramViewGroup.AlertTimestamp = ((TextView) paramView.findViewById(2131231074));
            paramViewGroup.alertLay = ((RelativeLayout) paramView.findViewById(2131231135));
            paramViewGroup.diver = ((ImageView) paramView.findViewById(2131230776));
            paramViewGroup.diver.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("forum_item_diver", paramActivity));
            paramViewGroup.avaterbg.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("avator_background", paramActivity));
            paramViewGroup.avaterbg.bringToFront();
            paramView.setTag(paramViewGroup);
            paramViewGroup.alert_name.setText(getUser_name());
            paramViewGroup.typeIcon.setImageDrawable(getIcon());
            paramViewGroup.alert_message.setText(getAlertString(paramActivity));
            if (SettingsFragment.getTimeStyle(paramActivity) != 0) {
                break label352;
            }
            paramViewGroup.AlertTimestamp.setText(Util.getSmartTime(paramActivity, Integer.parseInt(this.timestamp)));
        }
        for (; ; ) {
            Util.getUserImage(paramActivity, paramForumRootAdapter.forumStatus, paramViewGroup.alert_icon, getIcon_url(), paramViewGroup.avaterbg);
            if (paramInt2 != ONE_ALERT_ITEM) {
                break label374;
            }
            paramViewGroup.alertLay.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("forum_one_item_bg", paramActivity));
            paramViewGroup.diver.setVisibility(8);
            paramViewGroup.alertLay.bringToFront();
            paramViewGroup.alert_message.setPadding(0, 0, 0, (int) paramActivity.getResources().getDimension(2131427359));
            return paramView;
            paramViewGroup = (AlertViewHolder) paramView.getTag();
            break;
            label352:
            paramViewGroup.AlertTimestamp.setText(Util.getShortTimeString(paramActivity, Integer.parseInt(this.timestamp)));
        }
        label374:
        if (paramInt2 == TOP_ALERT_ITEM) {
            if (!paramBoolean) {
                paramViewGroup.alertLay.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("forum_top_item_bg", paramActivity));
            }
            for (; ; ) {
                paramViewGroup.diver.setVisibility(0);
                break;
                paramViewGroup.alertLay.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("top_bg_selected", paramActivity));
            }
        }
        if (paramInt2 == BOTTOM_ALERT_ITEM) {
            if (!paramBoolean) {
                paramViewGroup.alertLay.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("forum_bottom_item_bg", paramActivity));
            }
            for (; ; ) {
                paramViewGroup.diver.setVisibility(8);
                break;
                paramViewGroup.alertLay.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("bottom_bg_selected", paramActivity));
            }
        }
        if (!paramBoolean) {
            paramViewGroup.alertLay.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("forum_mid_item_bg", paramActivity));
        }
        for (; ; ) {
            paramViewGroup.diver.setVisibility(0);
            break;
            paramViewGroup.alertLay.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("forum_mid_bg_select", paramActivity));
        }
    }

    public String getContent_id() {
        return this.content_id;
    }

    public String getContent_type() {
        return this.content_type;
    }

    public Drawable getIcon() {
        return this.drawable;
    }

    public String getIcon_url() {
        return this.icon_url;
    }

    public Alert getInstance() {
        return this;
    }

    public String getMessage() {
        return this.message;
    }

    public String getTimestamp(Context paramContext) {
        return Util.getTimeString(paramContext, Integer.parseInt(this.timestamp));
    }

    public String getUser_id() {
        return this.user_id;
    }

    public String getUser_name() {
        return this.user_name;
    }

    public void setContent_id(String paramString) {
        this.content_id = paramString;
    }

    public void setContent_type(String paramString) {
        this.content_type = paramString;
    }

    public void setIcon(Context paramContext, String paramString) {
        if ((paramString.equals("pm")) || (paramString.equals("conv"))) {
            this.drawable = paramContext.getResources().getDrawable(2130839214);
            return;
        }
        if (paramString.equals("announcement")) {
            this.drawable = paramContext.getResources().getDrawable(2130837523);
            return;
        }
        if ((paramString.equals("like")) || (paramString.equals("thank"))) {
            this.drawable = paramContext.getResources().getDrawable(2130839007);
            return;
        }
        this.drawable = paramContext.getResources().getDrawable(2130839458);
    }

    public void setIcon_url(String paramString) {
        this.icon_url = paramString;
    }

    public void setMessage(String paramString) {
        this.message = paramString;
    }

    public void setTimestamp(String paramString) {
        this.timestamp = paramString;
    }

    public void setUser_id(String paramString) {
        this.user_id = paramString;
    }

    public void setUser_name(String paramString) {
        this.user_name = paramString;
    }

    public static class AlertViewHolder {
        public TextView AlertTimestamp;
        public RelativeLayout alertLay;
        public GifImageView alert_icon;
        public ShortContentView alert_message;
        public TextView alert_name;
        public ImageView avaterbg;
        public ImageView diver;
        public ImageView typeIcon;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/bean/Alert.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */