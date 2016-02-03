package com.quoord.tapatalkpro.ads;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.bean.ListItemClickable;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.util.AvatarTool;
import com.quoord.tapatalkpro.util.MySSLSocketFactory;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tools.bitmap.ui.GifImageView;

import java.io.InputStream;
import java.io.Serializable;
import java.security.KeyStore;
import java.util.HashMap;

import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;

public class AdBean
        implements Serializable, ListItemClickable {
    public static final String ISSUBSCRIBEEDTAB = "isSubscribedTab";
    public static final String SER_FORUM_STATUS_KEY = "com.quoord.tapatalkpro.ads.AdBean";
    public static final String SER_KEY = "com.quoord.tapatalkpro.ads.AdBean";
    public static final String SHOWFORUMNAME = "showForumName";
    public static final String SHOWREPLYNUM = "showreplynum";
    public static final String SHOWSELECTBG = "showSelectBg";
    private static final long serialVersionUID = 1L;
    private String BannerURL;
    private String SecondaryImpThirdPartyTrackingPixelUrl;
    private String VideoTrackingPixelUrl;
    private String author;
    private String authorImg;
    private String authorUrl;
    private String body;
    private boolean hasTracked = false;
    private String isFlurry;
    private boolean isPostRelease = true;
    private String permLink;
    private String permanentLink;
    private String primaryImpressionPixelUrl;
    private String secondaryImpressionPixelUrl;
    private String shareTrackinUrl;
    private String targetUrl;
    private String thirdPartyTrackingPixelUrl;
    private String title;
    private String trackShareLink;
    private String viewInApp;
    private String views;

    public static InputStream getImageStream(String paramString1, String paramString2)
            throws Exception {
        DefaultHttpClient localDefaultHttpClient;
        if (Util.checkString(paramString1)) {
            localDefaultHttpClient = getThreadSafeHttpClient(paramString1);
            paramString1 = new HttpGet(paramString1);
            if ((paramString2 != null) && (!paramString2.equals(""))) {
                paramString1.setHeader("Referer", paramString2);
            }
            paramString1.setHeader("User-Agent", "android " + Build.VERSION.SDK_INT);
        }
        try {
            localDefaultHttpClient.execute(paramString1);
            return null;
        } catch (Exception paramString1) {
            for (; ; ) {
                paramString1.printStackTrace();
            }
        }
    }

    public static DefaultHttpClient getThreadSafeHttpClient(String paramString) {
        SchemeRegistry localSchemeRegistry = new SchemeRegistry();
        try {
            if (paramString.startsWith("https")) {
                paramString = KeyStore.getInstance(KeyStore.getDefaultType());
                paramString.load(null, null);
                paramString = new MySSLSocketFactory(paramString);
                paramString.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
                localSchemeRegistry.register(new Scheme("https", paramString, 443));
            }
            paramString = new BasicHttpParams();
            HttpProtocolParams.setVersion(paramString, HttpVersion.HTTP_1_1);
            HttpProtocolParams.setContentCharset(paramString, "UTF-8");
            localSchemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
            HttpConnectionParams.setConnectionTimeout(paramString, 7000);
            HttpConnectionParams.setSoTimeout(paramString, 10000);
            return new DefaultHttpClient(new ThreadSafeClientConnManager(paramString, localSchemeRegistry), paramString);
        } catch (Exception paramString) {
            for (; ; ) {
                paramString.printStackTrace();
            }
        }
    }

    public View createView(int paramInt, View paramView, ForumActivityStatus paramForumActivityStatus) {
        return createView(0, paramView, paramForumActivityStatus);
    }

    public View createView(HashMap paramHashMap, View paramView, ForumActivityStatus paramForumActivityStatus) {
        AdBeanHolder localAdBeanHolder;
        if ((paramView == null) || (paramView.getTag() == null) || (!(paramView.getTag() instanceof AdBeanHolder))) {
            paramView = LayoutInflater.from(paramForumActivityStatus.getDefaultActivity()).inflate(2130903054, null);
            localAdBeanHolder = new AdBeanHolder();
            localAdBeanHolder.usericon = ((GifImageView) paramView.findViewById(2131230794));
            localAdBeanHolder.avaterbg = ((ImageView) paramView.findViewById(2131230795));
            localAdBeanHolder.topicauthor = ((TextView) paramView.findViewById(2131230797));
            localAdBeanHolder.topictitle = ((TextView) paramView.findViewById(2131230800));
            localAdBeanHolder.shortcontent = ((TextView) paramView.findViewById(2131230801));
            localAdBeanHolder.viewTimes = ((TextView) paramView.findViewById(2131230798));
            localAdBeanHolder.backLay = ((RelativeLayout) paramView.findViewById(2131230793));
            paramView.setTag(localAdBeanHolder);
            AvatarTool.showAvatar(paramForumActivityStatus.getDefaultActivity(), null, localAdBeanHolder.usericon, this.authorImg, 0);
            ThemeUtil.setAuthorColor(paramForumActivityStatus.getDefaultActivity(), localAdBeanHolder.topicauthor);
            localAdBeanHolder.topictitle.setTypeface(Typeface.defaultFromStyle(1), 1);
            if (SettingsFragment.getColorMode(paramForumActivityStatus.getDefaultActivity()).booleanValue()) {
                break label589;
            }
            localAdBeanHolder.topictitle.setTextColor(paramForumActivityStatus.getDefaultActivity().getResources().getColor(2131165279));
            localAdBeanHolder.shortcontent.setTextColor(paramForumActivityStatus.getDefaultActivity().getResources().getColor(2131165461));
            label266:
            localAdBeanHolder.topicauthor.setText(this.author);
            localAdBeanHolder.viewTimes.setText(this.views);
            localAdBeanHolder.topictitle.setText(this.title);
            String str = this.body.replaceAll("\\[b\\]", "").replaceAll("\\[\\/b\\]", "").replaceAll("\\[u\\]", "").replaceAll("\\[\\/u\\]", "").replaceAll("\\[i\\]", "").replaceAll("\\[\\/i\\]", "").replaceAll("\r\n", "").replaceAll("\\[youtube\\]", "").replaceAll("\\[\\/youtube\\]", "").replaceAll("\\[url\\]", "").replaceAll("\\[\\/url\\]", "").replaceAll("\\[img\\]", "").replaceAll("\\[\\/img\\]", "").replaceAll("\n\n", "\n");
            localAdBeanHolder.shortcontent.setText(str);
            if (!this.hasTracked) {
                if ((this.primaryImpressionPixelUrl != null) && (!this.primaryImpressionPixelUrl.equals(""))) {
                    new Thread() {
                        public void run() {
                            try {
                                AdBean.getImageStream(AdBean.this.primaryImpressionPixelUrl, null);
                                return;
                            } catch (Exception localException) {
                                localException.printStackTrace();
                            }
                        }
                    }.start();
                }
                if ((this.thirdPartyTrackingPixelUrl != null) && (!this.thirdPartyTrackingPixelUrl.equals(""))) {
                    new Thread() {
                        public void run() {
                            try {
                                AdBean.getImageStream(AdBean.this.thirdPartyTrackingPixelUrl, AdBean.this.permanentLink);
                                return;
                            } catch (Exception localException) {
                                localException.printStackTrace();
                            }
                        }
                    }.start();
                }
                this.hasTracked = true;
            }
            if ((paramHashMap.get("showSelectBg") == null) || (!((Boolean) paramHashMap.get("showSelectBg")).booleanValue())) {
                break label638;
            }
            localAdBeanHolder.backLay.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("topic_select_bg", paramForumActivityStatus.getDefaultActivity()));
        }
        for (; ; ) {
            localAdBeanHolder.avaterbg.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("avator_background", paramForumActivityStatus.getDefaultActivity()));
            localAdBeanHolder.avaterbg.bringToFront();
            return paramView;
            localAdBeanHolder = (AdBeanHolder) paramView.getTag();
            break;
            label589:
            localAdBeanHolder.topictitle.setTextColor(paramForumActivityStatus.getDefaultActivity().getResources().getColor(2131165213));
            localAdBeanHolder.shortcontent.setTextColor(paramForumActivityStatus.getDefaultActivity().getResources().getColor(2131165458));
            break label266;
            label638:
            localAdBeanHolder.backLay.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("topic_item_bg", paramForumActivityStatus.getDefaultActivity()));
        }
    }

    public String getAuthor() {
        return this.author;
    }

    public String getAuthorImg() {
        return this.authorImg;
    }

    public String getAuthorUrl() {
        return this.authorUrl;
    }

    public String getBannerURL() {
        return this.BannerURL;
    }

    public String getBody() {
        return this.body;
    }

    public String getIsFlurry() {
        return this.isFlurry;
    }

    public String getPermLink() {
        return this.permLink;
    }

    public String getPermanentLink() {
        return this.permanentLink;
    }

    public String getPrimaryImpressionPixelUrl() {
        return this.primaryImpressionPixelUrl;
    }

    public String getSecondaryImpThirdPartyTrackingPixelUrl() {
        return this.SecondaryImpThirdPartyTrackingPixelUrl;
    }

    public String getSecondaryImpressionPixelUrl() {
        return this.secondaryImpressionPixelUrl;
    }

    public String getShareTrackinUrl() {
        return this.shareTrackinUrl;
    }

    public String getTargetUrl() {
        return this.targetUrl;
    }

    public String getThirdPartyTrackingPixelUrl() {
        return this.thirdPartyTrackingPixelUrl;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTrackShareLink() {
        return this.trackShareLink;
    }

    public String getVideoTrackingPixelUrl() {
        return this.VideoTrackingPixelUrl;
    }

    public String getViewInApp() {
        return this.viewInApp;
    }

    public String getViews() {
        return this.views;
    }

    public boolean isPostRelease() {
        return this.isPostRelease;
    }

    public boolean onClick(View paramView, ForumActivityStatus paramForumActivityStatus) {
        if (!Util.checkString(getTargetUrl())) {
            paramView = new HashMap();
            paramView.put("postTitle", getTitle());
            paramView.put("postAuthor", getAuthor());
            paramView.put("postAuthorImg", getAuthorImg());
            paramView.put("postHtmlBody", getBody());
            paramView.put("secondaryImpressionPixelUrl", getSecondaryImpressionPixelUrl());
            paramView.put("VideoTrackingPixelUrl", getVideoTrackingPixelUrl());
            paramView.put("thirdPartyTrackingPixelUrl", getThirdPartyTrackingPixelUrl());
            paramView.put("trackShareLink", getTrackShareLink());
            paramView.put("permanentLink", getPermanentLink());
            paramView.put("ispostrelease", Boolean.valueOf(isPostRelease()));
            paramView.put("permlink", getPermLink());
            paramView.put("sharetrackingurl", getShareTrackinUrl());
            paramView.put("com.quoord.tapatalkpro.ads.AdBean", paramForumActivityStatus.getForumStatus());
            paramView = AdDetailFragment.newInstance(paramView);
            ((SlidingMenuActivity) paramForumActivityStatus.getDefaultActivity()).getActionBar().setDisplayShowTitleEnabled(false);
            ((SlidingMenuActivity) paramForumActivityStatus.getDefaultActivity()).showDetail(paramView);
        }
        for (; ; ) {
            return true;
            new Thread() {
                public void run() {
                    try {
                        AdBean.getImageStream(AdBean.this.getSecondaryImpressionPixelUrl(), AdBean.this.getPermanentLink());
                        return;
                    } catch (Exception localException) {
                        localException.printStackTrace();
                    }
                }
            }.start();
            new Thread() {
                public void run() {
                    try {
                        AdBean.getImageStream(AdBean.this.getSecondaryImpThirdPartyTrackingPixelUrl(), AdBean.this.getPermanentLink());
                        return;
                    } catch (Exception localException) {
                        localException.printStackTrace();
                    }
                }
            }.start();
            paramView = new Intent();
            paramView.setAction("android.intent.action.VIEW");
            paramView.setData(Uri.parse(getTargetUrl()));
            paramForumActivityStatus.getDefaultActivity().startActivity(paramView);
        }
    }

    public boolean onLongClick(View paramView, ForumActivityStatus paramForumActivityStatus) {
        return false;
    }

    public void selfChange(View paramView, ForumActivityStatus paramForumActivityStatus) {
    }

    public void setAuthor(String paramString) {
        this.author = paramString;
    }

    public void setAuthorImg(String paramString) {
        this.authorImg = paramString;
    }

    public void setAuthorUrl(String paramString) {
        this.authorUrl = paramString;
    }

    public void setBannerURL(String paramString) {
        this.BannerURL = paramString;
    }

    public void setBody(String paramString) {
        this.body = paramString;
    }

    public void setIsFlurry(String paramString) {
        this.isFlurry = paramString;
    }

    public void setPermLink(String paramString) {
        this.permLink = paramString;
    }

    public void setPermanentLink(String paramString) {
        this.permanentLink = paramString;
    }

    public void setPostRelease(boolean paramBoolean) {
        this.isPostRelease = paramBoolean;
    }

    public void setPrimaryImpressionPixelUrl(String paramString) {
        this.primaryImpressionPixelUrl = paramString;
    }

    public void setSecondaryImpThirdPartyTrackingPixelUrl(String paramString) {
        this.SecondaryImpThirdPartyTrackingPixelUrl = paramString;
    }

    public void setSecondaryImpressionPixelUrl(String paramString) {
        this.secondaryImpressionPixelUrl = paramString;
    }

    public void setShareTrackinUrl(String paramString) {
        this.shareTrackinUrl = paramString;
    }

    public void setTargetUrl(String paramString) {
        this.targetUrl = paramString;
    }

    public void setThirdPartyTrackingPixelUrl(String paramString) {
        this.thirdPartyTrackingPixelUrl = paramString;
    }

    public void setTitle(String paramString) {
        this.title = paramString;
    }

    public void setTrackShareLink(String paramString) {
        this.trackShareLink = paramString;
    }

    public void setVideoTrackingPixelUrl(String paramString) {
        this.VideoTrackingPixelUrl = paramString;
    }

    public void setViewInApp(String paramString) {
        this.viewInApp = paramString;
    }

    public void setViews(String paramString) {
        this.views = paramString;
    }

    public static class AdBeanHolder {
        public ImageView avaterbg;
        public View backLay;
        public TextView shortcontent;
        public TextView topicauthor;
        public TextView topictitle;
        public GifImageView usericon;
        public TextView viewTimes;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ads/AdBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */