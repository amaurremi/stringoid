package com.uservoice.uservoicesdk;

import com.uservoice.uservoicesdk.model.ClientConfig;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Config {
    private Map<String, String> customFields = new HashMap();
    private String email;
    private int forumId = -1;
    private String guid;
    private String key;
    private String name;
    private String secret;
    private boolean showContactUs = true;
    private boolean showForum = true;
    private boolean showKnowledgeBase = true;
    private boolean showPostIdea = true;
    private String site;
    private int topicId = -1;
    private Map<String, Object> userTraits = new HashMap();

    public Config(String paramString) {
        this.site = paramString;
    }

    public Config(String paramString1, String paramString2, String paramString3) {
        this.site = paramString1;
        this.key = paramString2;
        this.secret = paramString3;
    }

    public Map<String, String> getCustomFields() {
        return this.customFields;
    }

    public String getEmail() {
        return this.email;
    }

    public int getForumId() {
        if ((this.forumId == -1) && (Session.getInstance().getClientConfig() != null)) {
            return Session.getInstance().getClientConfig().getDefaultForumId();
        }
        return this.forumId;
    }

    public String getGuid() {
        return this.guid;
    }

    public String getKey() {
        return this.key;
    }

    public String getName() {
        return this.name;
    }

    public String getSecret() {
        return this.secret;
    }

    public String getSite() {
        return this.site;
    }

    public int getTopicId() {
        return this.topicId;
    }

    public Map<String, Object> getUserTraits() {
        return this.userTraits;
    }

    public void identifyUser(String paramString1, String paramString2, String paramString3) {
        this.guid = paramString1;
        this.name = paramString2;
        this.email = paramString3;
        putUserTrait("id", paramString1);
        putUserTrait("name", paramString2);
        putUserTrait("email", paramString3);
    }

    public void putAccountTrait(String paramString, float paramFloat) {
        putUserTrait("account_" + paramString, paramFloat);
    }

    public void putAccountTrait(String paramString, int paramInt) {
        putUserTrait("account_" + paramString, paramInt);
    }

    public void putAccountTrait(String paramString1, String paramString2) {
        putUserTrait("account_" + paramString1, paramString2);
    }

    public void putAccountTrait(String paramString, Date paramDate) {
        putUserTrait("account_" + paramString, paramDate);
    }

    public void putAccountTrait(String paramString, boolean paramBoolean) {
        putUserTrait("account_" + paramString, paramBoolean);
    }

    public void putUserTrait(String paramString, float paramFloat) {
        this.userTraits.put(paramString, Float.valueOf(paramFloat));
    }

    public void putUserTrait(String paramString, int paramInt) {
        this.userTraits.put(paramString, Integer.valueOf(paramInt));
    }

    public void putUserTrait(String paramString1, String paramString2) {
        this.userTraits.put(paramString1, paramString2);
    }

    public void putUserTrait(String paramString, Date paramDate) {
        this.userTraits.put(paramString, Long.valueOf(paramDate.getTime() / 1000L));
    }

    public void putUserTrait(String paramString, boolean paramBoolean) {
        this.userTraits.put(paramString, Boolean.valueOf(paramBoolean));
    }

    public void setCustomFields(Map<String, String> paramMap) {
        this.customFields = paramMap;
    }

    public void setForumId(int paramInt) {
        this.forumId = paramInt;
    }

    public void setShowContactUs(boolean paramBoolean) {
        this.showContactUs = paramBoolean;
    }

    public void setShowForum(boolean paramBoolean) {
        this.showForum = paramBoolean;
    }

    public void setShowKnowledgeBase(boolean paramBoolean) {
        this.showKnowledgeBase = paramBoolean;
    }

    public void setShowPostIdea(boolean paramBoolean) {
        this.showPostIdea = paramBoolean;
    }

    public void setTopicId(int paramInt) {
        this.topicId = paramInt;
    }

    public boolean shouldShowContactUs() {
        if ((Session.getInstance().getClientConfig() != null) && (!Session.getInstance().getClientConfig().isTicketSystemEnabled())) {
            return false;
        }
        return this.showContactUs;
    }

    public boolean shouldShowForum() {
        if ((Session.getInstance().getClientConfig() != null) && (!Session.getInstance().getClientConfig().isFeedbackEnabled())) {
            return false;
        }
        return this.showForum;
    }

    public boolean shouldShowKnowledgeBase() {
        if ((Session.getInstance().getClientConfig() != null) && (!Session.getInstance().getClientConfig().isTicketSystemEnabled())) {
            return false;
        }
        return this.showKnowledgeBase;
    }

    public boolean shouldShowPostIdea() {
        if ((Session.getInstance().getClientConfig() != null) && (!Session.getInstance().getClientConfig().isFeedbackEnabled())) {
            return false;
        }
        return this.showPostIdea;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/uservoice/uservoicesdk/Config.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */