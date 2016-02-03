package com.quoord.tapatalkpro.bean;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ForumItemBean
        implements Serializable {
    TapatalkForum forum1;
    private int forumId;
    private String forumName;
    private String forumUrl;
    private String iconUrl;
    private String userName;

    private void readObject(ObjectInputStream paramObjectInputStream)
            throws IOException, ClassNotFoundException {
        this.forumName = ((String) paramObjectInputStream.readObject());
        this.forumId = ((Integer) paramObjectInputStream.readObject()).intValue();
        this.forumUrl = ((String) paramObjectInputStream.readObject());
        this.iconUrl = ((String) paramObjectInputStream.readObject());
    }

    private void writeObject(ObjectOutputStream paramObjectOutputStream)
            throws IOException {
        paramObjectOutputStream.writeObject(this.forumName);
        paramObjectOutputStream.writeObject(Integer.valueOf(this.forumId));
        paramObjectOutputStream.writeObject(this.forumUrl);
        paramObjectOutputStream.writeObject(this.iconUrl);
    }

    public int getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public String getForumUrl() {
        return this.forumUrl;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setForumId(int paramInt) {
        this.forumId = paramInt;
    }

    public void setForumName(String paramString) {
        this.forumName = paramString;
    }

    public void setForumUrl(String paramString) {
        this.forumUrl = paramString;
    }

    public void setIconUrl(String paramString) {
        this.iconUrl = paramString;
    }

    public void setUserName(String paramString) {
        this.userName = paramString;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/bean/ForumItemBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */