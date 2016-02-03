package com.quoord.tapatalkpro.bean;

import android.text.Html;
import android.text.Spanned;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;

public class User
        extends BaseBean {
    private boolean canBan;
    private String currentActivity;
    private String description;
    private String displayText;
    private String display_name;
    private String icon_url;
    private String id;
    private boolean isBan;
    private String name;
    private boolean online;
    private int post_count;
    private Date reg_time;
    Spanned spannDisplay;
    private String topicId;

    public static User getUser(HashMap paramHashMap) {
        User localUser = new User();
        byte[] arrayOfByte = (byte[]) paramHashMap.get("user_name");
        String str1 = "";
        Object localObject;
        if (paramHashMap.containsKey("display_text")) {
            localObject = (byte[]) paramHashMap.get("display_text");
        }
        try {
            str1 = new String((byte[]) localObject, "UTF-8");
        } catch (UnsupportedEncodingException localUnsupportedEncodingException2) {
            try {
                localObject = new String(arrayOfByte, "UTF-8");
                if (!paramHashMap.containsKey("display_name")) {
                }
            } catch (UnsupportedEncodingException localUnsupportedEncodingException2) {
                try {
                    for (; ; ) {
                        String str4 = new String((byte[]) paramHashMap.get("display_name"), "UTF-8");
                        localUser.setDisplay_name(str4);
                        localUser.setName((String) localObject);
                        localUser.setDisplayText(str1);
                        if (paramHashMap.containsKey("icon_url")) {
                            localUser.setIconUrl((String) paramHashMap.get("icon_url"));
                        }
                        return localUser;
                        localUnsupportedEncodingException1 = localUnsupportedEncodingException1;
                        String str2 = new String((byte[]) localObject);
                    }
                    localUnsupportedEncodingException2 = localUnsupportedEncodingException2;
                    String str3 = new String(arrayOfByte);
                } catch (UnsupportedEncodingException localUnsupportedEncodingException3) {
                    for (; ; ) {
                        String str5 = new String(arrayOfByte);
                    }
                }
            }
        }
    }

    public String getCurrentActivity() {
        return this.currentActivity;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDisplayText() {
        return this.displayText;
    }

    public String getDisplay_name() {
        if (this.display_name == null) {
            return this.name;
        }
        return this.display_name;
    }

    public String getIconUrl() {
        return this.icon_url;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Spanned getParsedDisplayText() {
        if (this.spannDisplay == null) {
            if (this.displayText == null) {
                break label67;
            }
        }
        label67:
        for (this.displayText = this.displayText.replaceAll("(?i)\\[TOPIC\\](.+?)\\[\\/TOPIC\\]", "\\<a href=\"" + this.topicId + "\"\\>$1\\<\\/a\\>"); ; this.displayText = "") {
            this.spannDisplay = Html.fromHtml(this.displayText);
            return this.spannDisplay;
        }
    }

    public int getPostCount() {
        return this.post_count;
    }

    public Date getRegTime() {
        return this.reg_time;
    }

    public String getTopicId() {
        return this.topicId;
    }

    public boolean isBan() {
        return this.isBan;
    }

    public boolean isCanBan() {
        return this.canBan;
    }

    public boolean isOnline() {
        return this.online;
    }

    public void setBan(boolean paramBoolean) {
        this.isBan = paramBoolean;
    }

    public void setCanBan(boolean paramBoolean) {
        this.canBan = paramBoolean;
    }

    public void setCurrentActivity(String paramString) {
        this.currentActivity = paramString;
    }

    public void setDescription(String paramString) {
        this.description = paramString;
    }

    public void setDisplayText(String paramString) {
        this.displayText = paramString;
    }

    public void setDisplay_name(String paramString) {
        this.display_name = paramString;
    }

    public void setIconUrl(String paramString) {
        this.icon_url = paramString;
    }

    public void setId(String paramString) {
        this.id = paramString;
    }

    public void setName(String paramString) {
        this.name = paramString;
    }

    public void setOnline(boolean paramBoolean) {
        this.online = paramBoolean;
    }

    public void setPostCount(int paramInt) {
        this.post_count = paramInt;
    }

    public void setRegTime(Date paramDate) {
        this.reg_time = paramDate;
    }

    public void setTopicId(String paramString) {
        this.topicId = paramString;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/bean/User.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */