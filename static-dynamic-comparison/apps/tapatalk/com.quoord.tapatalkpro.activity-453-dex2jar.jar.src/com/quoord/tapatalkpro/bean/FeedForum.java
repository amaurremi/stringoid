package com.quoord.tapatalkpro.bean;

public class FeedForum {
    private int forumid;
    private boolean isFeed;
    private String name;
    private boolean select;

    public int getForumid() {
        return this.forumid;
    }

    public String getName() {
        return this.name;
    }

    public boolean isFeed() {
        return this.isFeed;
    }

    public boolean isSelect() {
        return this.select;
    }

    public void setFeed(boolean paramBoolean) {
        this.isFeed = paramBoolean;
    }

    public void setForumid(int paramInt) {
        this.forumid = paramInt;
    }

    public void setName(String paramString) {
        this.name = paramString;
    }

    public void setSelect(boolean paramBoolean) {
        this.select = paramBoolean;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/bean/FeedForum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */