package com.quoord.tools;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class LoginStatus
        implements Serializable, ForumHttpStatus {
    private static final long serialVersionUID = 3849158853365795150L;
    private int apiLevel;
    private String appVersion = "";
    private HashMap<String, String> cookies = new HashMap();
    private String ext;
    private String folder;
    private String forumIconUrl;
    private Integer forumId;
    private String forumName;
    private boolean guestOkay = true;
    private boolean isAgent = false;
    private boolean isContentType = true;
    private boolean isLogin = false;
    private boolean isRequestZip = false;
    private boolean isSupportConve;
    private String lowerUserName;
    private String passWord;
    private String url;
    private boolean useZip = true;
    private String userName;

    public int getApiLevel() {
        return this.apiLevel;
    }

    public String getAppVersion(Context paramContext) {
        if ((this.appVersion == null) || (this.appVersion.equals(""))) {
            try {
                this.appVersion = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
                return this.appVersion;
            } catch (PackageManager.NameNotFoundException paramContext) {
                for (; ; ) {
                    paramContext.printStackTrace();
                }
            }
        }
        return this.appVersion;
    }

    public String getCookie() {
        StringBuilder localStringBuilder = new StringBuilder();
        if ((this.cookies != null) && (this.cookies.size() > 0)) {
            Iterator localIterator = this.cookies.entrySet().iterator();
            for (; ; ) {
                if (!localIterator.hasNext()) {
                    return localStringBuilder.toString();
                }
                Object localObject = (Map.Entry) localIterator.next();
                String str = (String) ((Map.Entry) localObject).getKey();
                localObject = (String) ((Map.Entry) localObject).getValue();
                if ((localStringBuilder != null) && (localStringBuilder.length() != 0)) {
                    localStringBuilder.append("; ");
                }
                localStringBuilder.append(str);
                localStringBuilder.append("=");
                localStringBuilder.append((String) localObject);
            }
        }
        return "tapatalk=1";
    }

    public HashMap<String, String> getCookies() {
        return this.cookies;
    }

    public String getExt() {
        return this.ext;
    }

    public String getFolder() {
        return this.folder;
    }

    public String getForumIconUrl() {
        return this.forumIconUrl;
    }

    public Integer getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public String getLoginUrl() {
        String str2 = "";
        String str1 = str2;
        if (this.url != null) {
            str1 = str2;
            if (!this.url.equals("")) {
                if (!this.url.endsWith("/")) {
                    break label77;
                }
                str1 = this.url + this.folder + "/mobiquo." + this.ext;
            }
        }
        return str1;
        label77:
        return this.url + "/" + this.folder + "/mobiquo." + this.ext;
    }

    public String getLowerUserName() {
        return this.lowerUserName;
    }

    public String getPassWord() {
        return this.passWord;
    }

    public String getPrimaryKey() {
        return getForumId() + getUserName();
    }

    public String getUrl() {
        return this.url;
    }

    public boolean getUseZip() {
        return this.useZip;
    }

    public String getUserName() {
        return this.userName;
    }

    public boolean isAgent() {
        return this.isAgent;
    }

    public boolean isContentType() {
        return this.isContentType;
    }

    public boolean isGuestOkay() {
        return this.guestOkay;
    }

    public boolean isLogin() {
        return this.isLogin;
    }

    public boolean isRequestZip() {
        return this.isRequestZip;
    }

    public boolean isSupportConve() {
        return this.isSupportConve;
    }

    public void setAgent(boolean paramBoolean) {
        this.isAgent = paramBoolean;
    }

    public void setApiLevel(int paramInt) {
        this.apiLevel = paramInt;
    }

    public void setAppVersion(String paramString) {
        this.appVersion = paramString;
    }

    public void setContentType(boolean paramBoolean) {
        this.isContentType = paramBoolean;
    }

    public void setCookies(HashMap<String, String> paramHashMap) {
        this.cookies = paramHashMap;
    }

    public void setExt(String paramString) {
        this.ext = paramString;
    }

    public void setFolder(String paramString) {
        this.folder = paramString;
    }

    public void setForumIconUrl(String paramString) {
        this.forumIconUrl = paramString;
    }

    public void setForumId(Integer paramInteger) {
        this.forumId = paramInteger;
    }

    public void setForumName(String paramString) {
        this.forumName = paramString;
    }

    public void setGuestOkay(boolean paramBoolean) {
        this.guestOkay = paramBoolean;
    }

    public void setLogin(boolean paramBoolean) {
        this.isLogin = paramBoolean;
    }

    public void setLowerUserName(String paramString) {
        this.lowerUserName = paramString;
    }

    public void setPassWord(String paramString) {
        this.passWord = paramString;
    }

    public void setRequestZip(boolean paramBoolean) {
        this.isRequestZip = paramBoolean;
    }

    public void setSupportConve(boolean paramBoolean) {
        this.isSupportConve = paramBoolean;
    }

    public void setUrl(String paramString) {
        this.url = paramString;
    }

    public void setUserName(String paramString) {
        this.userName = paramString;
    }

    public void setZip(boolean paramBoolean) {
        this.useZip = paramBoolean;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tools/LoginStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */