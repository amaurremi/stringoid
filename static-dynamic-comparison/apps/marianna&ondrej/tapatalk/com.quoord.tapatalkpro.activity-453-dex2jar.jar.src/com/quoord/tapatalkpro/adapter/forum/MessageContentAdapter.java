package com.quoord.tapatalkpro.adapter.forum;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.Editable;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.Html.TagHandler;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.MovementMethod;
import android.text.style.URLSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.quoord.gif.GifDrawable;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.activity.forum.ProfilesActivity;
import com.quoord.tapatalkpro.activity.forum.ThreadActivity;
import com.quoord.tapatalkpro.activity.forum.ThreadOuterFragment;
import com.quoord.tapatalkpro.adapter.forum.conversation.ConvDetailAdapter;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.ImageInThread;
import com.quoord.tapatalkpro.bean.ParseableData;
import com.quoord.tapatalkpro.bean.PostData;
import com.quoord.tapatalkpro.bean.Topic;
import com.quoord.tapatalkpro.ics.ics.blog.Blog;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.ui.CustomImageViewLayout;
import com.quoord.tapatalkpro.ui.ThreadQuoteHelper;
import com.quoord.tapatalkpro.util.AvatarTool;
import com.quoord.tapatalkpro.util.BBcodeUtil.BBElement;
import com.quoord.tapatalkpro.util.ForumUrlUtil;
import com.quoord.tapatalkpro.util.GifTypeandLocalUrl;
import com.quoord.tapatalkpro.util.ImageInThreadLoader;
import com.quoord.tapatalkpro.util.ImageInThreadLoader.ImageCallBack;
import com.quoord.tapatalkpro.util.ImageItem;
import com.quoord.tapatalkpro.util.PatchedTextView;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tapatalkpro.view.TapaButton;
import com.quoord.tapatalkpro.youtube.YoutubeFullscreenActivity;
import com.quoord.tools.QuoordGalleryActivity;
import com.quoord.tools.bitmap.ui.GifImageView;
import com.wbtech.ums.UmsAgent;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.xml.sax.XMLReader;

public class MessageContentAdapter {
    public static String username;
    private ImageView avatar_bg;
    private String descrip = null;
    private String fid;
    int fontSize;
    ForumStatus forumStatus;
    private TextView goTextView;
    private GifImageView iconImage = null;
    private boolean isContainImage = false;
    private boolean isNestedQuote = false;
    ForumRootAdapter mAdapter;
    Activity mContext;
    private GifTypeandLocalUrl mLocalUrl;
    TextView moreTextView = null;
    private TextView nameTextView = null;
    int position;
    private SharedPreferences prefs;
    private String tid;
    private String title;
    private Typeface typeface;

    public MessageContentAdapter(Activity paramActivity, BaseAdapter paramBaseAdapter, ForumStatus paramForumStatus, int paramInt, Typeface paramTypeface) {
        this.mContext = paramActivity;
        this.forumStatus = paramForumStatus;
        this.mAdapter = ((ForumRootAdapter) paramBaseAdapter);
        this.fontSize = paramInt;
        this.typeface = paramTypeface;
        GifDrawable.context = paramActivity;
        if (this.prefs == null) {
            this.prefs = Prefs.get(this.mContext);
        }
    }

    public MessageContentAdapter(Activity paramActivity, ForumRootAdapter paramForumRootAdapter, ForumStatus paramForumStatus) {
        this.isContainImage = false;
        this.mContext = paramActivity;
        this.forumStatus = paramForumStatus;
        this.mAdapter = paramForumRootAdapter;
        this.fontSize = SettingsFragment.getFontSize(this.mContext);
        GifDrawable.context = paramActivity;
        if (this.prefs == null) {
            this.prefs = Prefs.get(this.mContext);
        }
    }

    private void doByoVglink(String paramString) {
        paramString = new Intent("android.intent.action.VIEW", Uri.parse(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf("http://apicdn.viglink.com/api/click?key=")).append(this.forumStatus.getVigLinkId()).toString())).append("&out=").append(URLEncoder.encode(paramString)).toString())).append("&loc=").append(URLEncoder.encode(this.forumStatus.getUrl())).toString() + "&subid=" + Util.getMD5(this.forumStatus.getForumId())));
        try {
            this.mContext.startActivity(paramString);
            return;
        } catch (Exception paramString) {
            paramString.printStackTrace();
        }
    }

    private boolean doFilter(String paramString1, String paramString2) {
        return (!paramString1.toLowerCase().contains(paramString2)) && (!paramString1.toLowerCase().contains("play.google.com")) && (!paramString1.toLowerCase().contains("market.android.com")) && (!paramString1.toLowerCase().contains("facebook.com")) && (!paramString1.toLowerCase().contains("twitter.com")) && (!paramString1.toLowerCase().contains("youtube.com")) && (!paramString1.toLowerCase().contains("cnn.com")) && (!paramString1.toLowerCase().contains("photobucket.com")) && (!paramString1.toLowerCase().contains("forbe.com")) && (!paramString1.toLowerCase().contains("github.com")) && (!paramString1.toLowerCase().contains("imgur.com")) && (!paramString1.toLowerCase().contains("mediafire.com")) && (!paramString1.toLowerCase().contains("soundcloud.com")) && (!paramString1.toLowerCase().contains("docs.google.com")) && (!paramString1.toLowerCase().contains("wikipedia.org")) && (!paramString1.toLowerCase().contains("bbc.co.uk")) && (!paramString1.toLowerCase().contains("today.com")) && (!paramString1.toLowerCase().contains("baidu.com")) && (!paramString1.toLowerCase().contains("dropboxusercontent.com")) && (!paramString1.toLowerCase().contains("imageshack.com")) && (!paramString1.toLowerCase().contains("drive.google.com"));
    }

    private void doSkimlik(String paramString) {
        if (!this.mContext.getResources().getBoolean(2131558401)) {
        }
        for (paramString = new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf("http://link2.tapatalk.com/")).append("?id=11082X693941").toString())).append("&url=").append(URLEncoder.encode(paramString)).toString())).append("&xs=1").toString())).append("&xcust=").append(Util.getMD5(this.forumStatus.getForumId())).toString() + "&sref=4"; ; paramString = new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf("http://go.redirectingat.com/?id=")).append(this.forumStatus.getSkimId()).toString())).append("&xs=1").toString())).append("&url=").append(URLEncoder.encode(paramString)).toString() + "&sref=" + URLEncoder.encode(TapatalkApp.rebranding_name)) {
            paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
            try {
                this.mContext.startActivity(paramString);
                return;
            } catch (Exception paramString) {
                paramString.printStackTrace();
            }
        }
    }

    private void doVglink(String paramString) {
        if (this.mContext.getResources().getBoolean(2131558409)) {
        }
        for (String str = "http://pt.tapatalk.com/redirect.php" + "?app_id=4"; ; str = "http://pt.tapatalk.com/redirect.php" + "?app_id=5") {
            paramString = new Intent("android.intent.action.VIEW", Uri.parse(new StringBuilder(String.valueOf(str)).append("&fid=").append(this.forumStatus.getForumId()).toString() + "&url=" + URLEncoder.encode(paramString)));
            try {
                this.mContext.startActivity(paramString);
                return;
            } catch (Exception paramString) {
                paramString.printStackTrace();
            }
        }
    }

    private void doWeb(String paramString1, String paramString2) {
        try {
            if (paramString1.contains("tapatalk://uid")) {
                paramString1 = paramString2.replace("@", "");
                paramString2 = new Intent(this.mContext, ProfilesActivity.class);
                paramString2.putExtra("forumStatus", this.forumStatus);
                paramString2.putExtra("iconusername", paramString1);
                this.mContext.startActivity(paramString2);
                return;
            }
            paramString2 = this.forumStatus.getUrl().replace("www.", "").replace("http://", "");
            if (paramString1.contains("/redirect.php?")) {
                paramString1 = new Intent("android.intent.action.VIEW", Uri.parse(paramString1));
                try {
                    this.mContext.startActivity(paramString1);
                    return;
                } catch (Exception paramString1) {
                    paramString1.printStackTrace();
                    return;
                }
            }
            HashMap localHashMap = ForumUrlUtil.getIdFromUrl(paramString1);
            if ((paramString1.contains(paramString2)) && (localHashMap.size() > 0)) {
                ForumUrlUtil.openForumByIds(this.mContext, this.forumStatus, localHashMap, this.mAdapter.stackType, false);
                return;
            }
            paramString2 = paramString1.replaceAll("\"", "").replaceAll("^=", "").trim();
            paramString1 = paramString2;
            if (!paramString2.startsWith("http://")) {
                paramString1 = paramString2;
                if (!paramString2.startsWith("https://")) {
                    paramString1 = "http://" + paramString2;
                }
            }
            if (this.mContext.getResources().getBoolean(2131558401)) {
                if ((this.forumStatus.getVigLinkId() != null) && (!this.forumStatus.getVigLinkId().equalsIgnoreCase("")) && (doFilter(paramString1, this.forumStatus.getUrl().toLowerCase()))) {
                    doByoVglink(paramString1);
                    return;
                }
                if ((this.forumStatus.getSkimId() != null) && (!this.forumStatus.getSkimId().equalsIgnoreCase("")) && (doFilter(paramString1, this.forumStatus.getUrl().toLowerCase()))) {
                    doSkimlik(paramString1);
                    return;
                }
                paramString1 = new Intent("android.intent.action.VIEW", Uri.parse(paramString1.replaceAll("&amp;", "&")));
                try {
                    this.mContext.startActivity(paramString1);
                    return;
                } catch (Exception paramString1) {
                    paramString1.printStackTrace();
                    return;
                }
            }
            doVglink(paramString1);
            return;
        } catch (Exception paramString1) {
        }
    }

    private void goGalley(ParseableData paramParseableData, ImageInThread paramImageInThread) {
        Intent localIntent = new Intent(this.mContext, QuoordGalleryActivity.class);
        ArrayList localArrayList = new ArrayList();
        Collections.sort(paramParseableData.getImageBeansFinished());
        int i = 0;
        for (; ; ) {
            if (i >= paramParseableData.getImageBeansFinished().size()) {
                localIntent.putExtra("data", localArrayList);
                localIntent.putExtra("forumstatus", this.forumStatus);
                localIntent.putExtra("position", paramImageInThread.position);
                if ((paramParseableData instanceof PostData)) {
                    localIntent.putExtra("auther_name", ((PostData) paramParseableData).authorName);
                }
                if ((paramParseableData instanceof Blog)) {
                    localIntent.putExtra("auther_name", ((Blog) paramParseableData).getUser_name());
                }
                this.mContext.startActivity(localIntent);
                return;
            }
            localArrayList.add(((ImageInThread) paramParseableData.getImageBeansFinished().get(i)).getLocalIconUri());
            i += 1;
        }
    }

    private void goWebview(ImageInThread paramImageInThread) {
        doWeb(paramImageInThread.description, null);
    }

    public void addBeanToFinished(ImageInThread paramImageInThread, String paramString1, ParseableData paramParseableData, String paramString2) {
        if ((paramString1 != null) && ((paramString1.contains("http://img.youtube.com/vi/")) || (paramString1.contains("dailymotion.com/thumbnail/video")) || (paramString1.contains("pt.tapatalk.com/vimeo.php?id=")))) {
            paramString1 = new ImageView(this.mContext);
            paramString1.setImageResource(2130839008);
            ((LinearLayout) ((RelativeLayout) ((LinearLayout) paramImageInThread.iv.getParent()).getParent()).getChildAt(1)).setVisibility(0);
            ((LinearLayout) ((RelativeLayout) ((LinearLayout) paramImageInThread.iv.getParent()).getParent()).getChildAt(1)).removeAllViews();
            ((LinearLayout) ((RelativeLayout) ((LinearLayout) paramImageInThread.iv.getParent()).getParent()).getChildAt(1)).addView(paramString1);
        }
        for (; ; ) {
            setBigImageOnClickListener(paramImageInThread, paramImageInThread.sourceUrl, paramParseableData);
            return;
            if ((paramParseableData != null) && (paramParseableData.getImageBeansFinished() != null)) {
                paramImageInThread.position = paramParseableData.getImageBeansFinished().size();
                paramImageInThread.type = paramString2;
                paramParseableData.addImageBeanToFinished(paramImageInThread);
            }
        }
    }

    public void getImageView(ImageInThread paramImageInThread, ImageView paramImageView, ParseableData paramParseableData, View paramView) {
        if (!Util.is2GState(this.mContext)) {
            showPhoto(SettingsFragment.isShowPhotos(this.mContext), paramImageInThread, paramImageView, paramParseableData, paramView);
            return;
        }
        showPhoto(SettingsFragment.isShowPhotosWithSlowConn(this.mContext), paramImageInThread, paramImageView, paramParseableData, paramView);
    }

    public String getQuoteString(String paramString) {
        String str = paramString.replaceAll("&quot;", "\"").replaceAll("&amp;", "&");
        if ((str.contains(" ")) && (str.startsWith("\""))) {
            paramString = str.split("\"")[1];
        }
        do {
            do {
                return paramString;
                if (str.contains(" ")) {
                    paramString = str.split(" ");
                    if (((paramString[0].trim().endsWith("\"")) && (paramString[0].trim().startsWith("\""))) || ((paramString[0].trim().endsWith("'")) && (paramString[0].trim().startsWith("'")))) {
                        return paramString[0].substring(1, paramString[0].length() - 1);
                    }
                    return paramString[0];
                }
                if ((str.endsWith("\"")) && (str.startsWith("\""))) {
                    break;
                }
                paramString = str;
            } while (!str.endsWith("'"));
            paramString = str;
        } while (!str.startsWith("'"));
        return str.substring(1, str.length() - 1);
    }

    public void getQuoteView() {
        if (this.descrip != null) {
            final String str1;
            String str2;
            if (this.descrip.contains("post")) {
                str1 = quoteFomat("post=([\\s\\S]+)", this.descrip);
                this.goTextView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View paramAnonymousView) {
                        paramAnonymousView = new Topic();
                        paramAnonymousView.setPostId(MessageContentAdapter.this.getQuoteString(str1));
                        paramAnonymousView.openThreadByPost(MessageContentAdapter.this.mContext, MessageContentAdapter.this.forumStatus);
                    }
                });
                if ((this.descrip == null) || (!this.descrip.contains("name"))) {
                    break label239;
                }
                str1 = quoteFomat("name=([\\s\\S]+)", this.descrip);
                username = getQuoteString(str1);
                this.nameTextView.setText(getQuoteString(str1));
                if (!this.descrip.contains("uid")) {
                    break label220;
                }
                if (!this.forumStatus.isSupport_avatar()) {
                    break label201;
                }
                str2 = quoteFomat("uid=([\\s\\S]+)", this.descrip);
                if (Util.is2GState(this.mContext)) {
                    break label186;
                }
                showAvatar(SettingsFragment.isShowAvatar(this.mContext), str2);
            }
            for (; ; ) {
                this.iconImage.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View paramAnonymousView) {
                        if (MessageContentAdapter.this.mAdapter.forumStatus.isLogin()) {
                            paramAnonymousView = new Intent(MessageContentAdapter.this.mContext, ProfilesActivity.class);
                            paramAnonymousView.putExtra("forumStatus", MessageContentAdapter.this.forumStatus);
                            paramAnonymousView.putExtra("iconusername", MessageContentAdapter.this.getQuoteString(str1));
                            MessageContentAdapter.this.mContext.startActivityForResult(paramAnonymousView, 41);
                            return;
                        }
                        Toast.makeText(MessageContentAdapter.this.mContext, MessageContentAdapter.this.mContext.getString(2131099865), 1).show();
                    }
                });
                return;
                this.goTextView.setVisibility(8);
                break;
                label186:
                showAvatar(SettingsFragment.isShowAvatarWithSlowConn(this.mContext), str2);
            }
            label201:
            this.iconImage.setVisibility(8);
            this.avatar_bg.setVisibility(8);
            return;
            label220:
            this.iconImage.setVisibility(8);
            this.avatar_bg.setVisibility(8);
            return;
            label239:
            this.iconImage.setVisibility(8);
            this.avatar_bg.setVisibility(8);
            this.nameTextView.setVisibility(8);
            this.goTextView.setVisibility(8);
            return;
        }
        this.iconImage.setVisibility(8);
        this.avatar_bg.setVisibility(8);
        this.nameTextView.setVisibility(8);
        this.goTextView.setVisibility(8);
    }

    public View[] getViewFromPost(List<BBcodeUtil.BBElement> paramList, ParseableData paramParseableData, int paramInt, boolean paramBoolean) {
        this.position = paramInt;
        return getViewFromPost(paramList, paramParseableData, paramBoolean);
    }

    public View[] getViewFromPost(List<BBcodeUtil.BBElement> paramList, ParseableData paramParseableData, boolean paramBoolean) {
        View[] arrayOfView = new View[paramList.size()];
        int i = 0;
        if (i >= paramList.size()) {
            return arrayOfView;
        }
        ArrayList localArrayList = ((BBcodeUtil.BBElement) paramList.get(i)).content;
        Object localObject2;
        final Object localObject1;
        if (((BBcodeUtil.BBElement) paramList.get(i)).type == "QUOTE") {
            this.descrip = ((BBcodeUtil.BBElement) paramList.get(i)).getDescription();
            if (paramBoolean) {
                this.isNestedQuote = true;
                localObject2 = this.mContext.getLayoutInflater().inflate(2130903331, null);
                ((View) localObject2).setPadding(0, 0, 0, (int) this.mContext.getResources().getDimension(2131427358));
                localObject1 = (TextView) ((View) localObject2).findViewById(2131231551);
                if ((this.descrip != null) && (this.descrip.contains("name"))) {
                    ((TextView) localObject1).setVisibility(0);
                    ((TextView) localObject1).setText(getQuoteString(quoteFomat("name=([\\s\\S]+)", this.descrip)) + this.mContext.getResources().getString(2131099740));
                }
                localObject1 = (LinearLayout) ((View) localObject2).findViewById(2131231552);
            }
        }
        int j;
        Object localObject4;
        for (; ; ) {
            arrayOfView[i] = localObject2;
            j = 0;
            if (j < localArrayList.size()) {
                break label634;
            }
            i += 1;
            break;
            localObject2 = this.mContext.getLayoutInflater().inflate(2130903332, null);
            if (SettingsFragment.isLightTheme(this.mContext)) {
                ((View) localObject2).setBackgroundColor(Color.parseColor("#eeeeee"));
            }
            for (; ; ) {
                ((View) localObject2).setPadding((int) this.mContext.getResources().getDimension(2131427357), 0, 0, (int) this.mContext.getResources().getDimension(2131427358));
                this.moreTextView = ((TextView) ((View) localObject2).findViewById(2131231559));
                this.iconImage = ((GifImageView) ((View) localObject2).findViewById(2131231264));
                this.nameTextView = ((TextView) ((View) localObject2).findViewById(2131231556));
                this.avatar_bg = ((ImageView) ((View) localObject2).findViewById(2131230795));
                this.goTextView = ((TextView) ((View) localObject2).findViewById(2131231557));
                localObject1 = (LinearLayout) ((View) localObject2).findViewById(2131231558);
                getQuoteView();
                break;
                ((View) localObject2).setBackgroundColor(Color.parseColor("#38393a"));
            }
            if (((BBcodeUtil.BBElement) paramList.get(i)).type == "SPOIL") {
                localObject2 = (LinearLayout) this.mContext.getLayoutInflater().inflate(2130903369, null);
                localObject4 = (TapaButton) ((View) localObject2).findViewById(2131231608);
                localObject1 = (LinearLayout) ((View) localObject2).findViewById(2131231609);
                ((LinearLayout) localObject1).setVisibility(8);
                ((TapaButton) localObject4).setOnClickListener(new View.OnClickListener() {
                    public void onClick(View paramAnonymousView) {
                        if (localObject1.getVisibility() == 8) {
                            localObject1.setVisibility(0);
                            return;
                        }
                        localObject1.setVisibility(8);
                    }
                });
            } else if (((BBcodeUtil.BBElement) paramList.get(i)).type == "CODE") {
                localObject2 = (LinearLayout) this.mContext.getLayoutInflater().inflate(2130903094, null);
                localObject1 = (LinearLayout) ((View) localObject2).findViewById(2131230922);
            } else {
                localObject2 = new LinearLayout(this.mContext);
                ((LinearLayout) localObject2).setOrientation(1);
                ((View) localObject2).setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
                localObject1 = (LinearLayout) localObject2;
            }
        }
        label634:
        BBcodeUtil.BBElement localBBElement = (BBcodeUtil.BBElement) localArrayList.get(j);
        int k;
        if ((localBBElement.content != null) && (localBBElement.content.size() > 0)) {
            localObject2 = new ArrayList();
            ((ArrayList) localObject2).add(localBBElement);
            localObject2 = getViewFromPost((List) localObject2, paramParseableData, this.position, true);
            k = 0;
            for (; ; ) {
                if (k >= localObject2.length) {
                    if ((!this.isContainImage) && ((((LinearLayout) localObject1).getId() == 2131231558) || (((LinearLayout) localObject1).getId() == 2131231552))) {
                        ((LinearLayout) localObject1).measure(0, 0);
                        ((LinearLayout) localObject1).getMeasuredHeight();
                        if (((LinearLayout) localObject1).getMeasuredHeight() > 400) {
                            ((LinearLayout) localObject1).getLayoutParams().height = 300;
                            if (this.moreTextView != null) {
                                this.moreTextView.setVisibility(0);
                                this.moreTextView.setOnClickListener(new MoreOnclick(this.moreTextView, (LinearLayout) localObject1));
                            }
                        }
                    }
                    j += 1;
                    break;
                }
                ((LinearLayout) localObject1).addView(localObject2[k]);
                k += 1;
            }
        }
        Object localObject5;
        Object localObject6;
        if (localBBElement.getType().equalsIgnoreCase("IMG")) {
            this.isContainImage = true;
            localObject4 = this.mContext.getLayoutInflater().inflate(2130903226, null);
            localObject5 = ((View) localObject4).findViewById(2131231203);
            ((View) localObject5).setBackgroundDrawable(ThemeUtil.getDrawableByPicName("image_load", this.mContext));
            localObject6 = new ImageInThread();
            ((ImageInThread) localObject6).clickView = ((ImageView) ((View) localObject4).findViewById(2131231285));
            localObject2 = ((ImageInThread) localObject6).clickView;
            if (SettingsFragment.isLightTheme(this.mContext)) {
            }
            for (k = 2130838947; ; k = 2130838948) {
                ((ImageView) localObject2).setImageResource(k);
                ((ImageInThread) localObject6).pb = ((ProgressBar) ((View) localObject4).findViewById(2131231286));
                ((ImageInThread) localObject6).iv = ((CustomImageViewLayout) ((View) localObject4).findViewById(2131230863));
                ImageView localImageView = (ImageView) ((View) localObject4).findViewById(2131231288);
                ((ImageInThread) localObject6).sourceUrl = localBBElement.getValue();
                if (localBBElement.getDescription() != null) {
                    ((ImageInThread) localObject6).description = localBBElement.getDescription();
                }
                if (Util.getHost(this.forumStatus.getUrl()).equalsIgnoreCase(Util.getHost(localBBElement.getValue()))) {
                    ((ImageInThread) localObject6).pb.setVisibility(0);
                    ((ImageInThread) localObject6).setCookies(this.forumStatus.getCookie());
                }
                ((ImageInThread) localObject6).pb.setVisibility(0);
                ((ImageInThread) localObject6).iv.setNeedbackground();
                if ((this.mContext instanceof ThreadActivity)) {
                    this.tid = ((ThreadActivity) this.mContext).outerFragment.mTopic.getId();
                    this.fid = ((ThreadActivity) this.mContext).outerFragment.mTopic.getForumId();
                    this.title = ((ThreadActivity) this.mContext).outerFragment.mTopic.getTitle();
                }
                localObject2 = localObject4;
                if (((ImageInThread) localObject6).sourceUrl != null) {
                    if (this.mContext.getResources().getBoolean(2131558401)) {
                        UmsAgent.onEvent(this.mContext, ((ImageInThread) localObject6).sourceUrl, paramParseableData.getPostId());
                    }
                    getImageView((ImageInThread) localObject6, localImageView, paramParseableData, (View) localObject5);
                    localObject2 = localObject4;
                }
                if (localObject2 != null) {
                    ((LinearLayout) localObject1).addView((View) localObject2);
                }
                if ((this.isContainImage) || ((((LinearLayout) localObject1).getId() != 2131231558) && (((LinearLayout) localObject1).getId() != 2131231552))) {
                    break;
                }
                ((LinearLayout) localObject1).measure(0, 0);
                if (((LinearLayout) localObject1).getMeasuredHeight() <= 400) {
                    break;
                }
                if (!this.isNestedQuote) {
                    ((LinearLayout) localObject1).getLayoutParams().height = 300;
                }
                if (this.moreTextView == null) {
                    break;
                }
                this.moreTextView.setVisibility(0);
                this.moreTextView.setOnClickListener(new MoreOnclick(this.moreTextView, (LinearLayout) localObject1));
                break;
            }
        }
        if (localBBElement.getType().equalsIgnoreCase("TEXT")) {
            localObject4 = new PatchedTextView(this.mContext);
            if (this.fontSize > 0) {
                ((PatchedTextView) localObject4).setTextSize(this.fontSize);
            }
            if (this.typeface != null) {
                ((PatchedTextView) localObject4).setTypeface(this.typeface);
            }
            localObject5 = new MGifGetter();
            ((MGifGetter) localObject5).view = ((View) localObject4);
            if (Pattern.compile("Sent\\sfrom.*?[<br><br\\s*?/>$|\n]", 2).matcher(localBBElement.getValue()).find()) {
                if ((this.mAdapter instanceof ConvDetailAdapter)) {
                    localObject2 = localBBElement.getValue().replaceAll("(?im)(Sent\\sfrom.*?)($|\n|<br>|<br\\s*?/>)", "<small> <i><font color=\"" + this.mContext.getResources().getColor(2131165283) + "\">$1</font><i></small>$2");
                    localObject2 = Pattern.compile("<a href=http:\\/\\/tapatalk.com/m\\?id=(.+?)\\>Tapatalk<\\/a\\><\\/font\\>").matcher((CharSequence) localObject2).replaceAll("</font><a href=http://tapatalk.com/m?id=$1><font color=\"blue\">now Free</font></a>");
                }
            }
        }
        for (; ; ) {
            try {
                if (((this.mAdapter instanceof ThreadAdapter)) && (((ThreadAdapter) this.mAdapter).currentMethod != null) && (((ThreadAdapter) this.mAdapter).currentMethod.equals("get_announcement"))) {
                    ((PatchedTextView) localObject4).setText((CharSequence) localObject2);
                    ((View) localObject4).setPadding(0, 10, 10, 16);
                    localObject2 = new MyLinkMovementMethod();
                    ((PatchedTextView) localObject4).setMovementMethod((MovementMethod) localObject2);
                    if (!SettingsFragment.isLightTheme(this.mContext)) {
                        break label2210;
                    }
                    ((PatchedTextView) localObject4).setTextColor(this.mContext.getResources().getColor(2131165310));
                    ((PatchedTextView) localObject4).setLinkTextColor(this.mContext.getResources().getColor(2131165329));
                    ((PatchedTextView) localObject4).setLineSpacing(2.0F, 1.0F);
                    ((PatchedTextView) localObject4).setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                    if (localBBElement.isQuote()) {
                        ((PatchedTextView) localObject4).setTextSize(this.fontSize - 2);
                        ((PatchedTextView) localObject4).setTextColor(this.mContext.getResources().getColor(2131165275));
                    }
                    localObject2 = localObject4;
                    if (paramParseableData == null) {
                        break;
                    }
                    localObject2 = localObject4;
                    if (!paramParseableData.isDeleted()) {
                        break;
                    }
                    ((PatchedTextView) localObject4).setTextColor(-7829368);
                    ((PatchedTextView) localObject4).setPaintFlags(((PatchedTextView) localObject4).getPaintFlags() | 0x10);
                    localObject2 = localObject4;
                    break;
                    localObject2 = localBBElement.getValue().replaceAll("(?im)(Sent\\sfrom.*?)($|\n|<br>|<br\\s*?/>)", "<small> <i><font color=\"" + this.mContext.getResources().getColor(2131165283) + "\">$1</font><i></small>$2");
                    localObject2 = Pattern.compile("<a href=http:\\/\\/tapatalk.com/m\\?id=(.+?)\\>Tapatalk<\\/a\\><\\/font\\>").matcher((CharSequence) localObject2).replaceAll("</font><a href=http://tapatalk.com/m?id=$1><font color=\"blue\">now Free</font></a>");
                    continue;
                }
                localObject2 = Html.fromHtml((String) localObject2, (Html.ImageGetter) localObject5, new MyTagHandler());
                ((PatchedTextView) localObject4).setText((CharSequence) localObject2);
                ((View) localObject4).setPadding(0, 10, 10, 16);
                continue;
            } catch (Exception localException1) {
                ((PatchedTextView) localObject4).setText(localBBElement.getValue());
                ((View) localObject4).setPadding(0, 10, 10, 16);
                continue;
            }
            label2168:
            label2210:
            try {
                String str = this.prefs.getString("prefernece.customersignature", null);
                localObject6 = "(?im)(" + str + ".*?" + ")($|\n|<br>|<br\\s*?/>)";
                if ((str != null) && (!str.equals("")) && (localBBElement.getValue() != null) && (localBBElement.getValue().contains(str))) {
                }
                for (str = localBBElement.getValue().replaceAll((String) localObject6, "<small> <i><font color=\"" + this.mContext.getResources().getColor(2131165283) + "\">$1</font><i></small>$2"); ; localObject3 = localBBElement.getValue()) {
                    try {
                        if ((!(this.mAdapter instanceof ThreadAdapter)) || (((ThreadAdapter) this.mAdapter).currentMethod == null) || (!((ThreadAdapter) this.mAdapter).currentMethod.equals("get_announcement"))) {
                            break label2168;
                        }
                        ((PatchedTextView) localObject4).setText(str);
                        ((View) localObject4).setPadding(0, 10, 10, 16);
                    } catch (Exception localException2) {
                        ((PatchedTextView) localObject4).setText(localBBElement.getValue());
                        ((View) localObject4).setPadding(0, 10, 10, 16);
                    }
                    break;
                }
                localObject3 = Html.fromHtml((String) localObject3, (Html.ImageGetter) localObject5, new MyTagHandler());
                ((PatchedTextView) localObject4).setText((CharSequence) localObject3);
                ((View) localObject4).setPadding(0, 10, 10, 16);
            } catch (Exception localException3) {
            }
            ((PatchedTextView) localObject4).setTextColor(-1);
            continue;
            Object localObject3 = null;
            break;
        }
    }

    public void loadingImage(final ImageInThread paramImageInThread, final ImageView paramImageView, final ParseableData paramParseableData) {
        this.mLocalUrl = ImageInThreadLoader.getLocalStringAndType(this.forumStatus, paramImageInThread, paramImageInThread.sourceUrl, new ImageInThreadLoader.ImageCallBack() {
            public void imageLoad(ImageInThread paramAnonymousImageInThread, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3) {
                if (paramAnonymousString1 != null) {
                    if (!paramAnonymousString1.equals("BROKEN")) {
                        paramAnonymousImageInThread.pb.setVisibility(8);
                        paramImageInThread.clickView.setVisibility(8);
                        paramAnonymousImageInThread.iv.setCustomUrl(paramAnonymousString1);
                        paramAnonymousImageInThread.setLocalIconUri(paramAnonymousString1);
                        paramAnonymousImageInThread.iv.setVisibility(0);
                        if ((paramAnonymousString3 != null) && (paramAnonymousString3.equals(ImageItem.GIF))) {
                            paramImageView.setVisibility(0);
                        }
                        MessageContentAdapter.this.addBeanToFinished(paramAnonymousImageInThread, paramAnonymousImageInThread.sourceUrl, paramParseableData, paramAnonymousString3);
                        paramAnonymousImageInThread.iv.forceDraw();
                    }
                } else {
                    return;
                }
                paramAnonymousImageInThread.pb.setVisibility(8);
                paramImageInThread.clickView.setVisibility(8);
                paramAnonymousImageInThread.iv.setVisibility(0);
                paramAnonymousImageInThread.iv.setCustomUrl("BROKEN");
                paramAnonymousImageInThread.iv.forceDraw();
            }
        }, this.tid, this.fid, paramParseableData.getPostTimeStamp(), paramParseableData.getPostId(), this.title, paramParseableData.getFloor(), this.mContext);
        if (this.mLocalUrl != null) {
            if (!this.mLocalUrl.localUrl.equals("BROKEN")) {
                paramImageInThread.pb.setVisibility(8);
                paramImageInThread.clickView.setVisibility(8);
                paramImageInThread.iv.setCustomUrl(this.mLocalUrl.localUrl);
                paramImageInThread.setLocalIconUri(this.mLocalUrl.localUrl);
                paramImageInThread.iv.setVisibility(0);
                addBeanToFinished(paramImageInThread, paramImageInThread.sourceUrl, paramParseableData, this.mLocalUrl.type);
                paramImageInThread.iv.forceDraw();
                if ((this.mLocalUrl.type != null) && (this.mLocalUrl.type.equals(ImageItem.GIF))) {
                    paramImageView.setVisibility(0);
                    this.mLocalUrl.type = ImageItem.GIF;
                }
                ((View) paramImageInThread.iv.getParent()).postInvalidate();
            }
        } else {
            return;
        }
        paramImageInThread.pb.setVisibility(8);
        paramImageInThread.clickView.setVisibility(8);
        paramImageInThread.iv.setVisibility(0);
        paramImageInThread.iv.setImageResource(2130837846);
        paramImageInThread.iv.forceDraw();
    }

    public String quoteFomat(String paramString1, String paramString2) {
        String str = "";
        paramString2 = Pattern.compile(paramString1).matcher(paramString2);
        for (paramString1 = str; ; paramString1 = paramString2.group(1)) {
            if (!paramString2.find()) {
                return paramString1;
            }
        }
    }

    public String replaceBlank(String paramString) {
        String str = "";
        if (paramString != null) {
            str = Pattern.compile("\\s*|\t|\r|\n").matcher("").replaceAll("");
        }
        return str;
    }

    public void setBigImageOnClickListener(final ImageInThread paramImageInThread, final String paramString, final ParseableData paramParseableData) {
        paramImageInThread.iv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                Object localObject;
                if ((paramString != null) && (paramString.contains("http://img.youtube.com/vi/"))) {
                    paramAnonymousView = paramString.split("/");
                    localObject = "http://www.youtube.com/watch?v=" + paramAnonymousView[(paramAnonymousView.length - 2)];
                    if (((MessageContentAdapter.this.mAdapter instanceof ThreadAdapter)) || ((MessageContentAdapter.this.mAdapter instanceof BlogAdapter)) || ((MessageContentAdapter.this.mAdapter instanceof ConvDetailAdapter)) || ((MessageContentAdapter.this.mAdapter instanceof PMContentAdapter))) {
                        Intent localIntent = new Intent(MessageContentAdapter.this.mContext, YoutubeFullscreenActivity.class);
                        localIntent.putExtra("youtube_url", paramAnonymousView[(paramAnonymousView.length - 2)]);
                        localIntent.putExtra("url", (String) localObject);
                        MessageContentAdapter.this.mContext.startActivity(localIntent);
                    }
                }
                do {
                    do {
                        do {
                            return;
                            if ((paramString == null) || (!paramString.contains("pt.tapatalk.com/vimeo.php?id="))) {
                                break;
                            }
                            paramAnonymousView = paramString;
                            paramAnonymousView = "http://vimeo.com/" + paramAnonymousView.substring(paramAnonymousView.lastIndexOf("=") + 1, paramAnonymousView.length());
                        }
                        while ((!(MessageContentAdapter.this.mAdapter instanceof ThreadAdapter)) && (!(MessageContentAdapter.this.mAdapter instanceof BlogAdapter)) && (!(MessageContentAdapter.this.mAdapter instanceof ConvDetailAdapter)) && (!(MessageContentAdapter.this.mAdapter instanceof PMContentAdapter)));
                        localObject = new Intent("android.intent.action.VIEW");
                        ((Intent) localObject).setData(Uri.parse(paramAnonymousView));
                        MessageContentAdapter.this.mContext.startActivity((Intent) localObject);
                        return;
                        if ((paramString == null) || (!paramString.contains("dailymotion.com/thumbnail/video"))) {
                            break;
                        }
                        paramAnonymousView = paramString.replace("/thumbnail", "");
                    }
                    while ((!(MessageContentAdapter.this.mAdapter instanceof ThreadAdapter)) && (!(MessageContentAdapter.this.mAdapter instanceof BlogAdapter)) && (!(MessageContentAdapter.this.mAdapter instanceof ConvDetailAdapter)) && (!(MessageContentAdapter.this.mAdapter instanceof PMContentAdapter)));
                    localObject = new Intent("android.intent.action.VIEW");
                    ((Intent) localObject).setData(Uri.parse(paramAnonymousView));
                    MessageContentAdapter.this.mContext.startActivity((Intent) localObject);
                    return;
                }
                while ((!(MessageContentAdapter.this.mAdapter instanceof ThreadAdapter)) && (!(MessageContentAdapter.this.mAdapter instanceof ConvDetailAdapter)) && (!(MessageContentAdapter.this.mAdapter instanceof PMContentAdapter)) && (!(MessageContentAdapter.this.mAdapter instanceof BlogAdapter)));
                if (paramImageInThread.description == null) {
                    MessageContentAdapter.this.goGalley(paramParseableData, paramImageInThread);
                    return;
                }
                MessageContentAdapter.this.showImageDailog(paramParseableData, paramImageInThread);
            }
        });
    }

    public void showAvatar(boolean paramBoolean, String paramString) {
        if (paramBoolean) {
            AvatarTool.showAvatar(this.mContext, this.forumStatus, this.iconImage, this.forumStatus.getPrefectUrl() + "mobiquo/avatar.php?user_id=" + getQuoteString(paramString), 0);
            return;
        }
        this.iconImage.setVisibility(8);
        this.avatar_bg.setVisibility(8);
    }

    public void showImageDailog(final ParseableData paramParseableData, final ImageInThread paramImageInThread) {
        new AlertDialog.Builder(this.mContext).setMessage(paramImageInThread.description).setPositiveButton(this.mContext.getString(2131100541), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                MessageContentAdapter.this.goWebview(paramImageInThread);
            }
        }).setNegativeButton(this.mContext.getString(2131100542), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                MessageContentAdapter.this.goGalley(paramParseableData, paramImageInThread);
            }
        }).create().show();
    }

    public void showPhoto(boolean paramBoolean, final ImageInThread paramImageInThread, final ImageView paramImageView, final ParseableData paramParseableData, View paramView) {
        if (paramBoolean) {
            paramImageInThread.clickView.setVisibility(8);
            loadingImage(paramImageInThread, paramImageView, paramParseableData);
            return;
        }
        paramImageInThread.pb.setVisibility(8);
        paramImageInThread.clickView.setVisibility(0);
        if (ImageInThreadLoader.checkLocalImg(this.mContext, paramImageInThread.sourceUrl)) {
            loadingImage(paramImageInThread, paramImageView, paramParseableData);
        }
        paramView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                paramImageInThread.clickView.setVisibility(8);
                paramImageInThread.pb.setVisibility(0);
                MessageContentAdapter.this.loadingImage(paramImageInThread, paramImageView, paramParseableData);
            }
        });
    }

    public class LoadOnclick
            implements View.OnClickListener {
        public LoadOnclick() {
        }

        public void onClick(View paramView) {
        }
    }

    public class MGifGetter
            implements Html.ImageGetter {
        public View view;

        public MGifGetter() {
        }

        public Drawable getDrawable(String paramString) {
            int i = MessageContentAdapter.this.mContext.getResources().getIdentifier(MessageContentAdapter.this.mContext.getPackageName() + ":drawable/" + paramString, null, null);
            paramString = MessageContentAdapter.this.mContext.getResources();
            if (i != 0) {
                paramString = paramString.openRawResource(i);
                Object localObject = ImageItem.getImageType(paramString);
                try {
                    paramString.reset();
                    if ((localObject != null) && (((String) localObject).equalsIgnoreCase("image/gif"))) {
                        localObject = new GifDrawable();
                        ((GifDrawable) localObject).setGifImage(paramString);
                        ((GifDrawable) localObject).setBounds(0, 0, ((GifDrawable) localObject).getIntrinsicWidth(), ((GifDrawable) localObject).getIntrinsicHeight());
                        ((GifDrawable) localObject).setContainerView(this.view);
                        return (Drawable) localObject;
                    }
                } catch (IOException localIOException) {
                    for (; ; ) {
                        localIOException.printStackTrace();
                    }
                    try {
                        paramString = MessageContentAdapter.this.mContext.getResources().getDrawable(i);
                        paramString.setBounds(0, 0, paramString.getIntrinsicWidth(), paramString.getIntrinsicHeight());
                        return paramString;
                    } catch (Exception paramString) {
                        paramString = MessageContentAdapter.this.mContext.getResources().getDrawable(2130839428);
                        paramString.setBounds(0, 0, paramString.getIntrinsicWidth(), paramString.getIntrinsicHeight());
                        return paramString;
                    }
                }
            }
            paramString = MessageContentAdapter.this.mContext.getResources().getDrawable(2130839428);
            paramString.setBounds(0, 0, paramString.getIntrinsicWidth(), paramString.getIntrinsicHeight());
            return paramString;
        }
    }

    public class MoreOnclick
            implements View.OnClickListener {
        LinearLayout linearLayout;
        TextView textView;

        public MoreOnclick(View paramView, LinearLayout paramLinearLayout) {
            this.textView = ((TextView) paramView);
            this.linearLayout = paramLinearLayout;
        }

        public void onClick(View paramView) {
            try {
                if ((this.linearLayout.getParent() instanceof LinearLayout)) {
                    this.linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                    this.textView.setVisibility(8);
                }
                if ((this.linearLayout.getParent() instanceof RelativeLayout)) {
                    this.linearLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
                    this.textView.setVisibility(8);
                }
                return;
            } catch (Exception paramView) {
            }
        }
    }

    class MyLinkMovementMethod
            implements MovementMethod {
        private MovementMethod mParen = null;
        private String mUrl = null;

        public MyLinkMovementMethod() {
        }

        private boolean action(String paramString) {
            if (paramString.trim().startsWith("http")) {
                MessageContentAdapter.this.doWeb(paramString, null);
                return true;
            }
            return false;
        }

        public boolean canSelectArbitrarily() {
            return this.mParen.canSelectArbitrarily();
        }

        public void initialize(TextView paramTextView, Spannable paramSpannable) {
            this.mParen.initialize(paramTextView, paramSpannable);
        }

        public boolean onGenericMotionEvent(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent) {
            return false;
        }

        public boolean onKeyDown(TextView paramTextView, Spannable paramSpannable, int paramInt, KeyEvent paramKeyEvent) {
            this.mUrl = paramSpannable.toString();
            switch (paramInt) {
                default:
                    return this.mParen.onKeyDown(paramTextView, paramSpannable, paramInt, paramKeyEvent);
            }
            action(this.mUrl);
            return true;
        }

        public boolean onKeyOther(TextView paramTextView, Spannable paramSpannable, KeyEvent paramKeyEvent) {
            return this.mParen.onKeyOther(paramTextView, paramSpannable, paramKeyEvent);
        }

        public boolean onKeyUp(TextView paramTextView, Spannable paramSpannable, int paramInt, KeyEvent paramKeyEvent) {
            return this.mParen.onKeyUp(paramTextView, paramSpannable, paramInt, paramKeyEvent);
        }

        public void onTakeFocus(TextView paramTextView, Spannable paramSpannable, int paramInt) {
            this.mParen.onTakeFocus(paramTextView, paramSpannable, paramInt);
        }

        public boolean onTouchEvent(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent) {
            this.mUrl = paramSpannable.toString();
            switch (paramMotionEvent.getAction()) {
                default:
                    return this.mParen.onTouchEvent(paramTextView, paramSpannable, paramMotionEvent);
                case 1:
                    int i = (int) paramMotionEvent.getX();
                    int j = (int) paramMotionEvent.getY();
                    int k = paramTextView.getTotalPaddingLeft();
                    int m = paramTextView.getTotalPaddingTop();
                    int n = paramTextView.getScrollX();
                    int i1 = paramTextView.getScrollY();
                    paramTextView = paramTextView.getLayout();
                    i = paramTextView.getOffsetForHorizontal(paramTextView.getLineForVertical(j - m + i1), i - k + n);
                    paramTextView = (URLSpan[]) paramSpannable.getSpans(i, i, URLSpan.class);
                    if (paramTextView.length != 0) {
                        if (paramMotionEvent.getAction() == 0) {
                            Selection.setSelection(paramSpannable, paramSpannable.getSpanStart(paramTextView[0]), paramSpannable.getSpanEnd(paramTextView[0]));
                        }
                        for (; ; ) {
                            return true;
                            MessageContentAdapter.this.doWeb(paramTextView[0].getURL(), paramSpannable.toString().substring(paramSpannable.getSpanStart(paramTextView[0]), paramSpannable.getSpanEnd(paramTextView[0])));
                        }
                    }
                    if ((MessageContentAdapter.this.mAdapter instanceof ThreadAdapter)) {
                        ((ThreadAdapter) MessageContentAdapter.this.mAdapter).mFocusItemPosition = MessageContentAdapter.this.position;
                        if ((MessageContentAdapter.this.mContext instanceof ThreadActivity)) {
                            if ((((ThreadActivity) MessageContentAdapter.this.mContext).outerFragment.quoteHelper != null) && (((ThreadActivity) MessageContentAdapter.this.mContext).outerFragment.quoteHelper.multiQuoteIds != null) && (((ThreadActivity) MessageContentAdapter.this.mContext).outerFragment.quoteHelper.multiQuoteIds.size() > 0)) {
                                ((ThreadActivity) MessageContentAdapter.this.mContext).outerFragment.quoteHelper.actionMulti(MessageContentAdapter.this.forumStatus, ((ThreadAdapter) MessageContentAdapter.this.mAdapter).getPost(MessageContentAdapter.this.position));
                            }
                        } else if (((MessageContentAdapter.this.mContext instanceof SlidingMenuActivity)) && ((((SlidingMenuActivity) MessageContentAdapter.this.mContext).outerFragment instanceof ThreadOuterFragment))) {
                            if ((((ThreadOuterFragment) ((SlidingMenuActivity) MessageContentAdapter.this.mContext).outerFragment).quoteHelper == null) || (((ThreadOuterFragment) ((SlidingMenuActivity) MessageContentAdapter.this.mContext).outerFragment).quoteHelper.multiQuoteIds == null) || (((ThreadOuterFragment) ((SlidingMenuActivity) MessageContentAdapter.this.mContext).outerFragment).quoteHelper.multiQuoteIds.size() <= 0)) {
                                break label629;
                            }
                            ((ThreadOuterFragment) ((SlidingMenuActivity) MessageContentAdapter.this.mContext).outerFragment).quoteHelper.actionMulti(MessageContentAdapter.this.forumStatus, ((ThreadAdapter) MessageContentAdapter.this.mAdapter).getPost(MessageContentAdapter.this.position));
                        }
                        for (; ; ) {
                            return true;
                            if ((MessageContentAdapter.this.forumStatus == null) || (!MessageContentAdapter.this.forumStatus.isLogin()) || ((ThreadAdapter) MessageContentAdapter.this.mAdapter == null) || (((ThreadAdapter) MessageContentAdapter.this.mAdapter).getPost(MessageContentAdapter.this.position) == null)) {
                                break;
                            }
                            ((ThreadAdapter) MessageContentAdapter.this.mAdapter).getPost(MessageContentAdapter.this.position).showQuickAction(MessageContentAdapter.this.forumStatus, MessageContentAdapter.this.position);
                            break;
                            label629:
                            if ((MessageContentAdapter.this.forumStatus != null) && (MessageContentAdapter.this.forumStatus.isLogin()) && ((ThreadAdapter) MessageContentAdapter.this.mAdapter != null) && (((ThreadAdapter) MessageContentAdapter.this.mAdapter).getPost(MessageContentAdapter.this.position) != null)) {
                                ((ThreadAdapter) MessageContentAdapter.this.mAdapter).getPost(MessageContentAdapter.this.position).showQuickAction(MessageContentAdapter.this.forumStatus, MessageContentAdapter.this.position);
                            }
                        }
                    }
                    boolean bool = MessageContentAdapter.this.mAdapter instanceof ConvDetailAdapter;
                    return false;
            }
            return true;
        }

        public boolean onTrackballEvent(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent) {
            return this.mParen.onTrackballEvent(paramTextView, paramSpannable, paramMotionEvent);
        }
    }

    public class MyTagHandler
            implements Html.TagHandler {
        boolean first = true;
        int index = 1;
        String parent = null;

        public MyTagHandler() {
        }

        public void handleTag(boolean paramBoolean, String paramString, Editable paramEditable, XMLReader paramXMLReader) {
            if (paramString.equals("ul")) {
                this.parent = "ul";
            }
            for (; ; ) {
                if (paramString.equals("li")) {
                    if (!this.parent.equals("ul")) {
                        break label82;
                    }
                    if (!this.first) {
                        break;
                    }
                    paramEditable.append("\n\t鈥�");
                    this.first = false;
                }
                return;
                if (paramString.equals("ol")) {
                    this.parent = "ol";
                }
            }
            this.first = true;
            return;
            label82:
            if (this.first) {
                paramEditable.append("\n\t" + this.index + ". ");
                this.first = false;
                this.index += 1;
                return;
            }
            this.first = true;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/forum/MessageContentAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */