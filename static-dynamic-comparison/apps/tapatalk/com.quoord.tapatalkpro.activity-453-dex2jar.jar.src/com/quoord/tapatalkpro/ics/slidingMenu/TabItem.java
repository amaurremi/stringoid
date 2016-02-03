package com.quoord.tapatalkpro.ics.slidingMenu;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.bean.ListItemClickable;
import com.quoord.tapatalkpro.byo.RebrandingOrderName;
import com.quoord.tapatalkpro.resourcefactory.AbsColorFactory;
import com.quoord.tapatalkpro.resourcefactory.AbsColorRender;
import com.quoord.tapatalkpro.resourcefactory.backlist.BackListItemBackColorFactory;
import com.quoord.tapatalkpro.resourcefactory.backlist.BackListItemCharacterColorFactory;
import com.quoord.tapatalkpro.util.Prefs;

import java.io.Serializable;
import java.util.HashMap;

public class TabItem
        implements Serializable, ListItemClickable {
    private static final long serialVersionUID = -8330381032587748407L;
    private String display_name;
    private int icon;
    private int iconSelected;
    private boolean isDiver = false;
    private boolean isSelected = false;
    AbsColorRender itemBackColorRender;
    AbsColorFactory itemCharacterColorFactory;
    AbsColorRender itemCharacterColorRender;
    AbsColorFactory itemColorBackFactory;
    private int menuid;
    private String name;
    private String order;
    private String tabName;
    private String value;

    public TabItem(Activity paramActivity, String paramString1, String paramString2, String paramString3, boolean paramBoolean) {
        initTabItem(paramActivity, paramString1, paramString2, paramString3, paramBoolean);
        setValue(paramString3);
        setName(paramString1);
    }

    public TabItem(String paramString, boolean paramBoolean, int paramInt) {
        this.tabName = paramString;
        this.isDiver = paramBoolean;
        this.menuid = paramInt;
    }

    private void initColorRender(Context paramContext) {
        if ((this.itemBackColorRender == null) || (this.itemCharacterColorRender == null)) {
            this.itemColorBackFactory = new BackListItemBackColorFactory();
            this.itemBackColorRender = this.itemColorBackFactory.createColorRender(paramContext, -1);
            this.itemCharacterColorFactory = new BackListItemCharacterColorFactory();
            this.itemCharacterColorRender = this.itemCharacterColorFactory.createColorRender(paramContext, -1);
        }
    }

    private void setListSelector(View paramView, Context paramContext) {
        StateListDrawable localStateListDrawable = new StateListDrawable();
        paramContext = new BackListItemBackColorFactory().createColorRender(paramContext, -1);
        ColorDrawable localColorDrawable = new ColorDrawable(paramContext.getSelectedColor());
        localStateListDrawable.addState(new int[]{16842919}, localColorDrawable);
        localColorDrawable = new ColorDrawable(paramContext.getSelectedColor());
        localStateListDrawable.addState(new int[]{16842913}, localColorDrawable);
        localColorDrawable = new ColorDrawable(paramContext.getSelectedColor());
        localStateListDrawable.addState(new int[]{16842908}, localColorDrawable);
        paramContext = new ColorDrawable(paramContext.getDefaultColor());
        localStateListDrawable.addState(new int[0], paramContext);
        paramView.setBackgroundDrawable(localStateListDrawable);
    }

    public View createView(int paramInt, View paramView, ForumActivityStatus paramForumActivityStatus) {
        initColorRender(paramForumActivityStatus.getDefaultActivity());
        paramView = Prefs.get(paramForumActivityStatus.getDefaultActivity());
        ColorDrawable localColorDrawable = new ColorDrawable(Color.parseColor("#33000000"));
        if (!isDiver()) {
            View localView = LayoutInflater.from(paramForumActivityStatus.getDefaultActivity()).inflate(2130903215, null);
            TextView localTextView = (TextView) localView.findViewById(2131231255);
            ImageView localImageView = (ImageView) localView.findViewById(2131231256);
            localTextView.setText(getTabName());
            localTextView.setTextColor(this.itemCharacterColorRender.getDefaultColor());
            if ((SettingsFragment.isRebranding(paramForumActivityStatus.getDefaultActivity())) && (paramView.contains("primary_color"))) {
                if (isSelected()) {
                    localView.setBackgroundDrawable(localColorDrawable);
                    localImageView.setImageResource(getIconSelected());
                    return localView;
                }
                localView.setBackgroundDrawable(getTabIndicatorColor(paramForumActivityStatus.getDefaultActivity()));
                localImageView.setImageResource(getIcon());
                return localView;
            }
            if (isSelected()) {
                localView.setBackgroundColor(this.itemBackColorRender.getSelectedColor());
                localImageView.setImageResource(getIconSelected());
                return localView;
            }
            setListSelector(localView, paramForumActivityStatus.getDefaultActivity());
            localImageView.setImageResource(getIcon());
            return localView;
        }
        paramView = LayoutInflater.from(paramForumActivityStatus.getDefaultActivity()).inflate(2130903214, null);
        ((TextView) paramView.findViewById(2131231255)).setText(getTabName());
        return paramView;
    }

    public View createView(HashMap paramHashMap, View paramView, ForumActivityStatus paramForumActivityStatus) {
        return null;
    }

    public boolean equals(Object paramObject) {
        return ((TabItem) paramObject).getMenuid() == this.menuid;
    }

    public String getDisplay_name() {
        return this.display_name;
    }

    public int getIcon() {
        return this.icon;
    }

    public int getIconSelected() {
        return this.iconSelected;
    }

    public int getMenuid() {
        return this.menuid;
    }

    public String getName() {
        return this.name;
    }

    public String getOrder() {
        return this.order;
    }

    public StateListDrawable getTabIndicatorColor(Context paramContext) {
        StateListDrawable localStateListDrawable = new StateListDrawable();
        Object localObject = Prefs.get(paramContext);
        ColorDrawable localColorDrawable = null;
        try {
            if (((SharedPreferences) localObject).contains("primary_color")) {
                localColorDrawable = new ColorDrawable(Color.parseColor("#" + ((SharedPreferences) localObject).getString("primary_color", "")));
            }
            localObject = new ColorDrawable(Color.parseColor("#33000000"));
            localStateListDrawable.addState(new int[]{16842919}, (Drawable) localObject);
            localStateListDrawable.addState(new int[]{16842908}, (Drawable) localObject);
            localStateListDrawable.addState(new int[]{16842913}, localColorDrawable);
            paramContext = paramContext.getResources().getDrawable(2131165212);
            localStateListDrawable.addState(new int[0], paramContext);
            return localStateListDrawable;
        } catch (Exception paramContext) {
            paramContext.printStackTrace();
        }
        return localStateListDrawable;
    }

    public String getTabName() {
        return this.tabName;
    }

    public String getValue() {
        return this.value;
    }

    public void initTabItem(Activity paramActivity, String paramString1, String paramString2, String paramString3, boolean paramBoolean) {
        new RebrandingOrderName(paramActivity);
        if (paramString1.equalsIgnoreCase(RebrandingOrderName.ORDER_PROFILE)) {
            setTabItem(paramActivity, 1010, "", paramString2, 0, 0, 0, paramBoolean);
        }
        for (; ; ) {
            setValue(paramString3);
            setName(paramString1);
            return;
            if (paramString1.equalsIgnoreCase(RebrandingOrderName.ORDER_ALERT)) {
                setTabItem(paramActivity, 1024, RebrandingOrderName.ORDER_ALERT, paramString2, 2130839015, 2130839014, 2130839014, paramBoolean);
            } else if (paramString1.equalsIgnoreCase(RebrandingOrderName.ORDER_SUBSCRIBE)) {
                setTabItem(paramActivity, 1019, RebrandingOrderName.ORDER_SUBSCRIBE, paramString2, 2130839059, 2130839058, 2130839058, paramBoolean);
            } else if (paramString1.equalsIgnoreCase(RebrandingOrderName.ORDER_PARTICIPATED)) {
                setTabItem(paramActivity, 1014, RebrandingOrderName.ORDER_PARTICIPATED, paramString2, 2130839081, 2130839080, 2130839080, paramBoolean);
            } else if (paramString1.equalsIgnoreCase(RebrandingOrderName.ORDER_UNREAD)) {
                setTabItem(paramActivity, 1013, RebrandingOrderName.ORDER_UNREAD, paramString2, 2130839104, 2130839103, 2130839103, paramBoolean);
            } else if (paramString1.equalsIgnoreCase(RebrandingOrderName.ORDER_MESSAGES)) {
                setTabItem(paramActivity, 1035, RebrandingOrderName.ORDER_MESSAGES, paramString2, 2130839021, 2130839020, 2130839020, paramBoolean);
            } else if (paramString1.equalsIgnoreCase(RebrandingOrderName.ORDER_TIMELINE)) {
                setTabItem(paramActivity, 1016, RebrandingOrderName.ORDER_TIMELINE, paramString2, 2130839100, 2130839099, 2130839099, paramBoolean);
            } else if (paramString1.equalsIgnoreCase(RebrandingOrderName.ORDER_BROWSE)) {
                setTabItem(paramActivity, 1018, RebrandingOrderName.ORDER_BROWSE, paramString2, 2130839030, 2130839029, 2130839029, paramBoolean);
            } else if (paramString1.equalsIgnoreCase(RebrandingOrderName.ORDER_SEARCH)) {
                setTabItem(paramActivity, 1011, RebrandingOrderName.ORDER_SEARCH, paramString2, 2130839011, 2130839010, 2130839010, paramBoolean);
            } else if (paramString1.equalsIgnoreCase(RebrandingOrderName.ORDER_PEOPLE)) {
                setTabItem(paramActivity, 1028, RebrandingOrderName.ORDER_PEOPLE, paramString2, 2130839049, 2130839048, 2130839048, paramBoolean);
            } else if (paramString1.equalsIgnoreCase(RebrandingOrderName.ORDER_BLOG)) {
                setTabItem(paramActivity, 1201, RebrandingOrderName.ORDER_BLOG, paramString2, 2130839040, 2130839039, 2130839039, paramBoolean);
            } else if (paramString1.equalsIgnoreCase(RebrandingOrderName.ORDER_LOGINE)) {
                setTabItem(paramActivity, 1027, RebrandingOrderName.ORDER_LOGINE, paramString2, 2130839045, 2130839044, 2130839044, paramBoolean);
            } else if (paramString1.equalsIgnoreCase(RebrandingOrderName.ORDER_REGISTER)) {
                setTabItem(paramActivity, 1026, RebrandingOrderName.ORDER_REGISTER, paramString2, 2130839051, 2130839051, 2130839052, paramBoolean);
            } else if (paramString1.equalsIgnoreCase(RebrandingOrderName.ORDER_WEB)) {
                setTabItem(paramActivity, paramString3.hashCode() + 2000, RebrandingOrderName.ORDER_WEB, paramString2, 2130839067, 2130839066, 2130839066, paramBoolean);
            } else if (paramString1.equalsIgnoreCase(RebrandingOrderName.ORDER_SUBFORUM)) {
                setTabItem(paramActivity, paramString3.hashCode() + 2000, RebrandingOrderName.ORDER_SUBFORUM, paramString2, 2130839062, 2130839061, 2130839061, paramBoolean);
            } else if (paramString1.equalsIgnoreCase(RebrandingOrderName.ORDER_MODERATION)) {
                setTabItem(paramActivity, 1038, RebrandingOrderName.ORDER_MODERATION, paramString2, 2130839045, 2130839044, 2130839044, paramBoolean);
            }
        }
    }

    public boolean isDiver() {
        return this.isDiver;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public boolean onClick(View paramView, ForumActivityStatus paramForumActivityStatus) {
        return false;
    }

    public boolean onLongClick(View paramView, ForumActivityStatus paramForumActivityStatus) {
        return false;
    }

    public void selfChange(View paramView, ForumActivityStatus paramForumActivityStatus) {
    }

    public void setDisplay_name(String paramString) {
        this.display_name = paramString;
    }

    public void setDrawable(Activity paramActivity, String paramString1, String paramString2, String paramString3, boolean paramBoolean) {
        initTabItem(paramActivity, paramString1, paramString2, paramString3, paramBoolean);
    }

    public void setIcon(int paramInt) {
        this.icon = paramInt;
    }

    public void setIconSelected(int paramInt) {
        this.iconSelected = paramInt;
    }

    public void setMenuid(int paramInt) {
        this.menuid = paramInt;
    }

    public void setName(String paramString) {
        this.name = paramString;
    }

    public void setOrder(String paramString) {
        this.order = paramString;
    }

    public void setSelected(boolean paramBoolean) {
        this.isSelected = paramBoolean;
    }

    public void setTabItem(Activity paramActivity, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean) {
        Prefs.get(paramActivity);
        setMenuid(paramInt1);
        if ((paramString2.equals("")) || (paramString2 == null)) {
            setDisplay_name(paramString1);
            setTabName(paramString1);
            setSelected(paramBoolean);
            if (!SettingsFragment.isLightTheme(paramActivity)) {
                break label76;
            }
            setIcon(paramInt2);
        }
        for (; ; ) {
            setIconSelected(paramInt4);
            return;
            setDisplay_name(paramString2);
            setTabName(paramString2);
            break;
            label76:
            setIcon(paramInt3);
        }
    }

    public void setTabName(String paramString) {
        this.tabName = paramString;
    }

    public void setValue(String paramString) {
        this.value = paramString;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ics/slidingMenu/TabItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */