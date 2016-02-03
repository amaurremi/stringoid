package com.quoord.tapatalkpro.alarm.notification;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.quoord.tapatalkpro.util.Prefs;

public class NotificationSettingCheckItemBean {
    private Integer forumId;
    private boolean isChecked;
    private String keyString;
    private String showString;

    public NotificationSettingCheckItemBean(String paramString1, String paramString2, Integer paramInteger) {
        this.showString = paramString1;
        this.forumId = paramInteger;
        this.keyString = paramString2;
    }

    private void changeCheck(Activity paramActivity, boolean paramBoolean) {
        setChecked(paramBoolean);
        paramActivity = Prefs.get(paramActivity).edit();
        paramActivity.putBoolean(getSaveKey(), paramBoolean);
        paramActivity.commit();
    }

    public Integer getForumId() {
        return this.forumId;
    }

    public String getKeyString() {
        return this.keyString;
    }

    public String getSaveKey() {
        return getForumId() + getKeyString();
    }

    public String getShowString() {
        return this.showString;
    }

    public View getView(final Activity paramActivity) {
        RelativeLayout localRelativeLayout = (RelativeLayout) paramActivity.getLayoutInflater().inflate(2130903093, null);
        CheckBox localCheckBox = (CheckBox) localRelativeLayout.findViewById(2131230920);
        localCheckBox.setChecked(isChecked());
        localCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean) {
                NotificationSettingCheckItemBean.this.changeCheck(paramActivity, paramAnonymousBoolean);
            }
        });
        ((TextView) localRelativeLayout.findViewById(2131230919)).setText(getShowString());
        return localRelativeLayout;
    }

    public boolean isChecked() {
        return this.isChecked;
    }

    public void setChecked(boolean paramBoolean) {
        this.isChecked = paramBoolean;
    }

    public void setForumId(Integer paramInteger) {
        this.forumId = paramInteger;
    }

    public void setKeyString(String paramString) {
        this.keyString = paramString;
    }

    public void setShowString(String paramString) {
        this.showString = paramString;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/alarm/notification/NotificationSettingCheckItemBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */