package com.quoord.tapatalkpro.bean;

public class ForumIconAndName {
    private String forumIconUrl;
    public int forumId;
    private String forumName;
    private boolean hasFeed;
    public int order;
    public String uid;

    public ForumIconAndName() {
    }

    public ForumIconAndName(int paramInt, String paramString) {
        this.uid = paramString;
        this.forumId = paramInt;
    }

    public boolean equals(Object paramObject) {
        boolean bool2 = false;
        boolean bool1 = bool2;
        if ((paramObject instanceof ForumIconAndName)) {
            bool1 = bool2;
            if (((ForumIconAndName) paramObject).forumId == this.forumId) {
                bool1 = true;
            }
        }
        return bool1;
    }

    public String getForumIconUrl() {
        return this.forumIconUrl;
    }

    public int getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public boolean isHasFeed() {
        return this.hasFeed;
    }

    public void setForumIconUrl(String paramString) {
        this.forumIconUrl = paramString;
    }

    public void setForumId(int paramInt) {
        this.forumId = paramInt;
    }

    public void setForumName(String paramString) {
        this.forumName = paramString;
    }

    public void setHasFeed(boolean paramBoolean) {
        this.hasFeed = paramBoolean;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/bean/ForumIconAndName.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */