package com.quoord.tapatalkpro.ics.ics.blog;

import android.app.ActionBar;
import android.app.Activity;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.quoord.tapatalkpro.adapter.forum.BlogsAdapter;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.util.AvatarTool;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tapatalkpro.view.AuthorView;
import com.quoord.tapatalkpro.view.ShortContentView;
import com.quoord.tapatalkpro.view.TitleTextView;

public class Blogs {
    private BlogsAdapter adapter = null;
    private String avatar = null;
    private String blog_id = null;
    private String blog_title = null;
    private String category_count = null;
    private String category_id = null;
    private String category_name = null;
    private String category_parent = null;
    private String comment_count = null;
    final Handler handler = new Handler() {
        public void handleMessage(Message paramAnonymousMessage) {
            Blogs.this.adapter.notifyDataSetChanged();
        }
    };
    public BlogViewHodler holder;
    private String mLocalUrl = null;
    private String next = null;
    private String password = null;
    private String preview = null;
    private ImageView previewImage;
    private String preview_image = null;
    private String status = null;
    private String timestamp = null;
    private String user_id = null;
    private String user_name = null;

    public String getAvatar() {
        return this.avatar;
    }

    public View getBlogView(int paramInt1, View paramView, ViewGroup paramViewGroup, BlogsAdapter paramBlogsAdapter, Activity paramActivity, int paramInt2) {
        if ((paramView == null) || (paramView.getTag() == null) || (!(paramView.getTag() instanceof BlogViewHodler))) {
            this.holder = new BlogViewHodler();
            paramView = LayoutInflater.from(paramActivity.getApplicationContext()).inflate(2130903074, null);
            this.holder.layout = ((RelativeLayout) paramView.findViewById(2131230864));
            this.holder.title = ((TitleTextView) paramView.findViewById(2131230868));
            this.holder.author_name = ((AuthorView) paramView.findViewById(2131230874));
            this.holder.shortContent = ((ShortContentView) paramView.findViewById(2131230869));
            this.holder.comment_count = ((TextView) paramView.findViewById(2131230872));
            this.holder.preview_image_lay = ((LinearLayout) paramView.findViewById(2131230866));
            this.holder.preview_image_lay_bg = ((LinearLayout) paramView.findViewById(2131230867));
            this.holder.imgView = ((ImageView) paramView.findViewById(2131230871));
            if (SettingsFragment.isLightTheme(paramActivity)) {
                this.holder.title.setTextColor(paramActivity.getResources().getColor(2131165310));
                this.holder.title.setTextSize(16.0F);
                this.holder.author_name.setTextSize(12.0F);
                this.holder.author_name.setTextColor(paramActivity.getResources().getColor(2131165283));
                this.holder.shortContent.setTextSize(13.0F);
                this.holder.shortContent.setTextColor(paramActivity.getResources().getColor(2131165512));
                this.holder.comment_count.setTextSize(12.0F);
                this.holder.layout.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("topic_item_bg", paramActivity));
                this.holder.split = ((TextView) paramView.findViewById(2131230873));
                paramView.setTag(this.holder);
                label333:
                if ((getPreview_image() == null) || (getPreview_image().equals(""))) {
                    break label744;
                }
                this.holder.preview_image_lay.setVisibility(0);
                this.holder.preview_image_lay_bg.setVisibility(0);
                if (this.previewImage == null) {
                    this.previewImage = new ImageView(paramActivity);
                    this.previewImage.setScaleType(ImageView.ScaleType.FIT_XY);
                    this.previewImage.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                }
                if (this.holder.preview_image_lay != null) {
                    this.holder.preview_image_lay.removeAllViews();
                }
                if (this.previewImage.getParent() != null) {
                    ((ViewGroup) this.previewImage.getParent()).removeAllViews();
                }
                if (this.holder.preview_image_lay != null) {
                    this.holder.preview_image_lay.addView(this.previewImage);
                }
                AvatarTool.showLogo(paramActivity, this.previewImage, getPreview_image(), 6);
                label503:
                this.holder.title.setText(getBlog_title());
                if ((getUser_name() != null) && (getTimestamp() != null) && (!getTimestamp().equals("")) && (!getTimestamp().equals("null"))) {
                    this.holder.author_name.setText(getUser_name() + " posts " + Util.getShortTimeString(paramActivity, Integer.parseInt(getTimestamp())));
                }
                this.holder.shortContent.setText(getPreview());
                if (!getComment_count().equals("0")) {
                    break label771;
                }
                this.holder.imgView.setVisibility(8);
                this.holder.comment_count.setVisibility(8);
                this.holder.split.setVisibility(8);
            }
        }
        for (; ; ) {
            if (((paramActivity instanceof SlidingMenuActivity)) && (((SlidingMenuActivity) paramActivity).getShowSlectionStatus())) {
                if (paramInt2 == paramInt1) {
                    paramView.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("topic_select_bg", paramActivity));
                    return paramView;
                    this.holder.title.setTextColor(paramActivity.getResources().getColor(2131165213));
                    break;
                    this.holder = ((BlogViewHodler) paramView.getTag());
                    break label333;
                    label744:
                    this.holder.preview_image_lay_bg.setVisibility(8);
                    this.holder.preview_image_lay.setVisibility(8);
                    break label503;
                    label771:
                    this.holder.imgView.setVisibility(0);
                    this.holder.comment_count.setVisibility(0);
                    this.holder.split.setVisibility(0);
                    this.holder.comment_count.setText(getComment_count());
                    continue;
                }
                paramView.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("topic_item_bg", paramActivity));
                return paramView;
            }
        }
        paramView.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("topic_item_bg", paramActivity));
        return paramView;
    }

    public String getBlog_id() {
        return this.blog_id;
    }

    public String getBlog_title() {
        return this.blog_title;
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

    public String getComment_count() {
        return this.comment_count;
    }

    public String getNext() {
        return this.next;
    }

    public String getPassword() {
        return this.password;
    }

    public String getPreview() {
        return this.preview;
    }

    public String getPreview_image() {
        return this.preview_image;
    }

    public String getStatus() {
        return this.status;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public String getUser_id() {
        return this.user_id;
    }

    public String getUser_name() {
        return this.user_name;
    }

    public void openBlog(Activity paramActivity, ForumStatus paramForumStatus, String paramString1, String paramString2, String paramString3) {
        paramForumStatus = BlogFragment.newInstance(paramForumStatus, paramString1, paramString2, paramString3);
        ((SlidingMenuActivity) paramActivity).getActionBar().setDisplayShowTitleEnabled(false);
        ((SlidingMenuActivity) paramActivity).showDetail(paramForumStatus);
    }

    public void setAvatar(String paramString) {
        this.avatar = paramString;
    }

    public void setBlog_id(String paramString) {
        this.blog_id = paramString;
    }

    public void setBlog_title(String paramString) {
        this.blog_title = paramString;
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

    public void setComment_count(String paramString) {
        this.comment_count = paramString;
    }

    public void setNext(String paramString) {
        this.next = paramString;
    }

    public void setPassword(String paramString) {
        this.password = paramString;
    }

    public void setPreview(String paramString) {
        this.preview = paramString;
    }

    public void setPreview_image(String paramString) {
        this.preview_image = paramString;
    }

    public void setStatus(String paramString) {
        this.status = paramString;
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

    public class BlogViewHodler {
        public AuthorView author_name;
        public TextView comment_count;
        public ImageView imgView;
        public RelativeLayout layout;
        public LinearLayout preview_image_lay;
        public LinearLayout preview_image_lay_bg;
        public ShortContentView shortContent;
        public TextView split;
        public TitleTextView title;

        public BlogViewHodler() {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ics/ics/blog/Blogs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */