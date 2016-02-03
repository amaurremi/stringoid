package com.quoord.tapatalkpro.ics.ics.blog;

import android.view.View;
import com.quoord.tapatalkpro.bean.ImageInThread;
import com.quoord.tapatalkpro.bean.ParseableData;

import java.util.ArrayList;

public class Blog
        implements ParseableData {
    private String avatar = null;
    private String blog_id = null;
    private String category_count = null;
    private String category_id = null;
    private String category_name = null;
    private String category_parent = null;
    private String comment_account = null;
    private String comment_id = null;
    private String content = null;
    public ArrayList<ImageInThread> mBeansFinished = new ArrayList();
    private String next_id = null;
    private String next_title = null;
    private String password = null;
    private String pre_title = null;
    private String prev_id = null;
    private String status = null;
    private String timestamp = null;
    private String title = null;
    private String user_id = null;
    private String user_name = null;

    public void addImageBeanToFinished(ImageInThread paramImageInThread) {
        this.mBeansFinished.add(paramImageInThread);
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getBlog_id() {
        return this.blog_id;
    }

    public String getCategory_count() {
        return this.category_count;
    }

    public String getCategory_id() {
        return this.category_id;
    }

    public String getCategory_name() {
        return this.category_name;
    }

    public String getCategory_parent() {
        return this.category_parent;
    }

    public String getComment_account() {
        return this.comment_account;
    }

    public String getComment_id() {
        return this.comment_id;
    }

    public String getContent() {
        return this.content;
    }

    public int getFloor() {
        return 0;
    }

    public ArrayList getImageBeans() {
        return null;
    }

    public ArrayList<ImageInThread> getImageBeansFinished() {
        return this.mBeansFinished;
    }

    public String getNext_id() {
        return this.next_id;
    }

    public String getNext_title() {
        return this.next_title;
    }

    public String getPassword() {
        return this.password;
    }

    public String getPostId() {
        return null;
    }

    public int getPostTimeStamp() {
        return (int) (Integer.parseInt(getTimestamp()) / 1000L);
    }

    public String getPre_title() {
        return this.pre_title;
    }

    public String getPrev_id() {
        return this.prev_id;
    }

    public String getStatus() {
        return this.status;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUser_id() {
        return this.user_id;
    }

    public String getUser_name() {
        return this.user_name;
    }

    public boolean isDeleted() {
        return false;
    }

    public void setAttachLay(View paramView) {
    }

    public void setAvatar(String paramString) {
        this.avatar = paramString;
    }

    public void setBlog_id(String paramString) {
        this.blog_id = paramString;
    }

    public void setCategory_count(String paramString) {
        this.category_count = paramString;
    }

    public void setCategory_id(String paramString) {
        this.category_id = paramString;
    }

    public void setCategory_name(String paramString) {
        this.category_name = paramString;
    }

    public void setCategory_parent(String paramString) {
        this.category_parent = paramString;
    }

    public void setComment_account(String paramString) {
        this.comment_account = paramString;
    }

    public void setComment_id(String paramString) {
        this.comment_id = paramString;
    }

    public void setContent(String paramString) {
        this.content = paramString;
    }

    public void setNext_id(String paramString) {
        this.next_id = paramString;
    }

    public void setNext_title(String paramString) {
        this.next_title = paramString;
    }

    public void setPassword(String paramString) {
        this.password = paramString;
    }

    public void setPre_title(String paramString) {
        this.pre_title = paramString;
    }

    public void setPrev_id(String paramString) {
        this.prev_id = paramString;
    }

    public void setStatus(String paramString) {
        this.status = paramString;
    }

    public void setTimestamp(String paramString) {
        this.timestamp = paramString;
    }

    public void setTitle(String paramString) {
        this.title = paramString;
    }

    public void setUser_id(String paramString) {
        this.user_id = paramString;
    }

    public void setUser_name(String paramString) {
        this.user_name = paramString;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ics/ics/blog/Blog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */