package com.quoord.tapatalkpro.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.amazon.device.ads.Ad;
import com.amazon.device.ads.AdError;
import com.amazon.device.ads.AdLayout;
import com.amazon.device.ads.AdProperties;
import com.amazon.device.ads.AdTargetingOptions;
import com.androidquery.AQuery;
import com.androidquery.callback.AjaxStatus;
import com.androidquery.callback.BitmapAjaxCallback;
import com.flurry.android.FlurryAdListener;
import com.flurry.android.FlurryAdSize;
import com.flurry.android.FlurryAdType;
import com.flurry.android.FlurryAds;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest.Builder;
import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.quoord.tapatalkpro.bean.Forum;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.Topic;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tools.TapatalkLog;

import java.io.Serializable;
import java.util.ArrayList;

public class FlurryAdbean
        implements Serializable {
    private static final long serialVersionUID = -1862217771612282509L;
    private String BannerURL;
    private String SecondaryImpThirdPartyTrackingPixelUrl;
    private String VideoTrackingPixelUrl;
    private LinearLayout adInnerContainer;
    private RelativeLayout adOutterContainer = null;
    private String author;
    private String authorImg;
    private String authorUrl;
    private String body;
    private FlurryAdbean childAdbean;
    private boolean hasTracked = false;
    private boolean isAdmobe;
    private boolean isAmazon;
    private boolean isDfp;
    private boolean isFlurry;
    private boolean isGetAdsView = false;
    private boolean isMM;
    private boolean isOpenX;
    private boolean isPostRelease = true;
    private String mediation;
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

    private void getAD2View(Activity paramActivity, BaseAdapter paramBaseAdapter, ForumStatus paramForumStatus, Topic paramTopic) {
        TapatalkLog.e("Ads", "get ad2 view");
        if (this.childAdbean.isFlurry) {
            getFlurryAdView(paramActivity, paramBaseAdapter, paramForumStatus, paramTopic);
            return;
        }
        if (this.childAdbean.isAmazon) {
            getAmazonAdsView(paramActivity, paramBaseAdapter, paramForumStatus, paramTopic);
            return;
        }
        if (this.childAdbean.isAdmobe) {
            getAdmobView(paramActivity, paramBaseAdapter, paramForumStatus, paramTopic);
            return;
        }
        if (this.childAdbean.isDfp) {
            getDfpView(paramActivity, paramBaseAdapter, paramForumStatus, paramTopic);
            return;
        }
        getIMGAdView(paramActivity, paramBaseAdapter, paramForumStatus, paramTopic);
    }

    private Bitmap resizeBannerImage(Activity paramActivity, Bitmap paramBitmap) {
        int i = paramActivity.getResources().getDimensionPixelOffset(2131427396);
        int j = paramActivity.getResources().getDimensionPixelOffset(2131427397);
        paramActivity = new Matrix();
        float f;
        Bitmap localBitmap;
        if (i > paramBitmap.getWidth()) {
            f = i / paramBitmap.getWidth();
            paramActivity.postScale(f, f);
            localBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), paramActivity, true);
            paramActivity = null;
            if ((localBitmap.getWidth() > i) || (localBitmap.getHeight() > j)) {
                paramActivity = new Rect((paramBitmap.getWidth() - i) / 2, (paramBitmap.getHeight() - j) / 2, (paramBitmap.getWidth() - i) / 2 + i, (paramBitmap.getHeight() - j) / 2 + j);
            }
            if (paramActivity != null) {
                return Util.cutBitmap(localBitmap, paramActivity, Bitmap.Config.RGB_565, i, j);
            }
        } else {
            f = paramBitmap.getWidth() / i;
            paramActivity.postScale(f, f);
            return Bitmap.createBitmap(paramBitmap, 0, 0, i, (int) (paramBitmap.getHeight() / f), paramActivity, true);
        }
        return localBitmap;
    }

    public void getAdmobView(final Activity paramActivity, final BaseAdapter paramBaseAdapter, final ForumStatus paramForumStatus, final Topic paramTopic) {
        final AdView localAdView;
        if (!this.isGetAdsView) {
            localAdView = new AdView(paramActivity);
            localAdView.setAdSize(com.google.android.gms.ads.AdSize.BANNER);
            localAdView.setAdUnitId(getBody());
            localAdView.setAdListener(new com.google.android.gms.ads.AdListener() {
                public void onAdClosed() {
                    super.onAdClosed();
                }

                public void onAdFailedToLoad(int paramAnonymousInt) {
                    FlurryAdbean.this.adOutterContainer.setVisibility(8);
                    FlurryAdbean.this.adInnerContainer.setVisibility(8);
                    FlurryAdbean.this.isGetAdsView = false;
                    if (FlurryAdbean.this.childAdbean != null) {
                        FlurryAdbean.this.getAD2View(paramActivity, paramBaseAdapter, paramForumStatus, paramTopic);
                    }
                }

                public void onAdLeftApplication() {
                    super.onAdLeftApplication();
                }

                public void onAdLoaded() {
                    FlurryAdbean.this.isGetAdsView = false;
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            if (FlurryAdbean.this.adInnerContainer.getChildCount() > 0) {
                                FlurryAdbean.this.adInnerContainer.removeAllViews();
                            }
                            FlurryAdbean.this.adInnerContainer.addView(this.val$adView);
                            FlurryAdbean.this.adOutterContainer.setVisibility(0);
                            FlurryAdbean.this.adInnerContainer.setVisibility(0);
                            FlurryAdbean.this.adOutterContainer.invalidate();
                            this.val$adapter.notifyDataSetChanged();
                        }
                    }, 300L);
                    FlurryAdbean.this.trackingAdView();
                }

                public void onAdOpened() {
                    FlurryAdbean.this.trackingAdViewClick();
                }
            });
            paramBaseAdapter = new Bundle();
            if (!SettingsFragment.isLightTheme(paramActivity)) {
                break label150;
            }
            paramBaseAdapter.putString("color_bg", "e8e8e8");
            paramBaseAdapter.putString("color_text", "3b3b3b");
            paramBaseAdapter.putString("color_border", "e8e8e8");
        }
        for (; ; ) {
            paramBaseAdapter.putString("color_link", "598ecb");
            paramBaseAdapter.putString("color_url", "598ecb");
            paramActivity = new AdMobExtras(paramBaseAdapter);
            localAdView.loadAd(new AdRequest.Builder().addNetworkExtras(paramActivity).build());
            this.isGetAdsView = true;
            return;
            label150:
            paramBaseAdapter.putString("color_bg", "1c1d1e");
            paramBaseAdapter.putString("color_text", "a8a8a8");
            paramBaseAdapter.putString("color_border", "1c1d1e");
        }
    }

    public void getAmazonAdsView(final Activity paramActivity, final BaseAdapter paramBaseAdapter, final ForumStatus paramForumStatus, final Topic paramTopic) {
        if (!this.isGetAdsView) {
            final AdLayout localAdLayout = new AdLayout(paramActivity, com.amazon.device.ads.AdSize.SIZE_320x50);
            localAdLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            localAdLayout.setListener(new com.amazon.device.ads.AdListener() {
                public void onAdCollapsed(Ad paramAnonymousAd) {
                }

                public void onAdDismissed(Ad paramAnonymousAd) {
                }

                public void onAdExpanded(Ad paramAnonymousAd) {
                }

                public void onAdFailedToLoad(Ad paramAnonymousAd, AdError paramAnonymousAdError) {
                    FlurryAdbean.this.adOutterContainer.setVisibility(8);
                    FlurryAdbean.this.isGetAdsView = false;
                    if (FlurryAdbean.this.childAdbean != null) {
                        FlurryAdbean.this.getAD2View(paramActivity, paramBaseAdapter, paramForumStatus, paramTopic);
                    }
                }

                public void onAdLoaded(Ad paramAnonymousAd, AdProperties paramAnonymousAdProperties) {
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            if (FlurryAdbean.this.adInnerContainer.getChildCount() > 0) {
                                FlurryAdbean.this.adInnerContainer.removeAllViews();
                            }
                            FlurryAdbean.this.adInnerContainer.addView(this.val$adView);
                            FlurryAdbean.this.adOutterContainer.setVisibility(0);
                            FlurryAdbean.this.adInnerContainer.setVisibility(0);
                            FlurryAdbean.this.adOutterContainer.invalidate();
                            FlurryAdbean.this.isGetAdsView = false;
                            this.val$adapter.notifyDataSetChanged();
                        }
                    }, 300L);
                    FlurryAdbean.this.trackingAdView();
                }
            });
            localAdLayout.loadAd(new AdTargetingOptions());
            this.isGetAdsView = true;
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

    public FlurryAdbean getChildAdbean() {
        return this.childAdbean;
    }

    public void getDfpView(final Activity paramActivity, final BaseAdapter paramBaseAdapter, final ForumStatus paramForumStatus, final Topic paramTopic) {
        final PublisherAdView localPublisherAdView;
        Bundle localBundle;
        int i;
        if (!this.isGetAdsView) {
            localPublisherAdView = new PublisherAdView(paramActivity);
            localPublisherAdView.setAdSizes(new com.google.android.gms.ads.AdSize[]{new com.google.android.gms.ads.AdSize(320, 50)});
            localPublisherAdView.setAdUnitId(getBody());
            localPublisherAdView.setAdListener(new com.google.android.gms.ads.AdListener() {
                public void onAdClosed() {
                    super.onAdClosed();
                }

                public void onAdFailedToLoad(int paramAnonymousInt) {
                    FlurryAdbean.this.adOutterContainer.setVisibility(8);
                    FlurryAdbean.this.adInnerContainer.setVisibility(8);
                    FlurryAdbean.this.isGetAdsView = false;
                    if (FlurryAdbean.this.childAdbean != null) {
                        FlurryAdbean.this.getAD2View(paramActivity, paramBaseAdapter, paramForumStatus, paramTopic);
                    }
                }

                public void onAdLeftApplication() {
                }

                public void onAdLoaded() {
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            FlurryAdbean.this.isGetAdsView = false;
                            if (FlurryAdbean.this.adInnerContainer.getChildCount() > 0) {
                                FlurryAdbean.this.adInnerContainer.removeAllViews();
                            }
                            FlurryAdbean.this.adInnerContainer.addView(this.val$adView);
                            FlurryAdbean.this.adOutterContainer.setVisibility(0);
                            FlurryAdbean.this.adInnerContainer.setVisibility(0);
                            FlurryAdbean.this.adOutterContainer.invalidate();
                            this.val$adapter.notifyDataSetChanged();
                        }
                    }, 300L);
                    FlurryAdbean.this.trackingAdView();
                }

                public void onAdOpened() {
                    FlurryAdbean.this.trackingAdViewClick();
                }
            });
            localBundle = new Bundle();
            if (!SettingsFragment.isLightTheme(paramActivity)) {
                break label282;
            }
            localBundle.putString("Color", "e8e8e8");
            if ((paramForumStatus != null) && (paramForumStatus.getUrl() != null)) {
                String[] arrayOfString = Util.getHost(paramForumStatus.getUrl()).split("\\.");
                paramBaseAdapter = Util.getHost(paramForumStatus.getUrl());
                if (arrayOfString.length > 2) {
                    paramBaseAdapter = arrayOfString[1] + "." + arrayOfString[2];
                }
                localBundle.putString("sitename", paramBaseAdapter);
            }
            paramForumStatus = paramForumStatus.getForumHierarch(paramActivity, paramTopic.getForumId());
            paramBaseAdapter = "";
            paramActivity = paramBaseAdapter;
            if (paramForumStatus.size() != 0) {
                if (paramForumStatus.size() <= 1) {
                    break label385;
                }
                i = 0;
                paramActivity = paramBaseAdapter;
                if (i < paramForumStatus.size()) {
                    break label296;
                }
            }
        }
        for (; ; ) {
            localBundle.putString("forum_id", paramActivity);
            localBundle.putString("thread_id", paramTopic.getId());
            localPublisherAdView.loadAd(new PublisherAdRequest.Builder().addNetworkExtras(new AdMobExtras(localBundle)).setManualImpressionsEnabled(true).build());
            this.isGetAdsView = true;
            return;
            label282:
            localBundle.putString("Color", "1c1d1e");
            break;
            label296:
            if (i < paramForumStatus.size() - 1) {
            }
            for (paramActivity = paramActivity + ((Forum) paramForumStatus.get(i)).getId() + ","; ; paramActivity = paramActivity + ((Forum) paramForumStatus.get(i)).getId()) {
                i += 1;
                break;
            }
            label385:
            paramActivity = "" + ((Forum) paramForumStatus.get(0)).getId();
        }
    }

    public void getFlurryAdView(final Activity paramActivity, final BaseAdapter paramBaseAdapter, final ForumStatus paramForumStatus, final Topic paramTopic) {
        if (!this.isGetAdsView) {
            this.isGetAdsView = true;
            if (this.adInnerContainer.getChildCount() > 0) {
                this.adInnerContainer.removeAllViews();
            }
            FlurryAds.fetchAd(paramActivity, this.body, this.adInnerContainer, FlurryAdSize.BANNER_BOTTOM);
            FlurryAds.setAdListener(new FlurryAdListener() {
                public void onAdClicked(String paramAnonymousString) {
                    FlurryAdbean.this.trackingAdViewClick();
                }

                public void onAdClosed(String paramAnonymousString) {
                    if (FlurryAdbean.this.adInnerContainer.getChildCount() > 0) {
                        FlurryAdbean.this.adInnerContainer.removeAllViews();
                    }
                    FlurryAdbean.this.adInnerContainer.setVisibility(8);
                }

                public void onAdOpened(String paramAnonymousString) {
                }

                public void onApplicationExit(String paramAnonymousString) {
                }

                public void onRenderFailed(String paramAnonymousString) {
                    FlurryAdbean.this.adOutterContainer.setVisibility(8);
                    FlurryAdbean.this.adInnerContainer.setVisibility(8);
                    paramBaseAdapter.notifyDataSetChanged();
                    FlurryAdbean.this.isGetAdsView = false;
                    if (FlurryAdbean.this.childAdbean != null) {
                        FlurryAdbean.this.getAD2View(paramActivity, paramBaseAdapter, paramForumStatus, paramTopic);
                    }
                }

                public void onRendered(String paramAnonymousString) {
                }

                public void onVideoCompleted(String paramAnonymousString) {
                }

                public boolean shouldDisplayAd(String paramAnonymousString, FlurryAdType paramAnonymousFlurryAdType) {
                    return true;
                }

                public void spaceDidFailToReceiveAd(String paramAnonymousString) {
                }

                public void spaceDidReceiveAd(String paramAnonymousString) {
                    if (FlurryAdbean.this.adInnerContainer.getVisibility() != 0) {
                        new Handler().postDelayed(new Runnable() {
                            public void run() {
                                FlurryAdbean.this.isGetAdsView = false;
                                FlurryAds.displayAd(this.val$context, FlurryAdbean.this.body, FlurryAdbean.this.adInnerContainer);
                                if (FlurryAdbean.this.adInnerContainer.getChildCount() > 0) {
                                    FlurryAdbean.this.adOutterContainer.setVisibility(0);
                                    FlurryAdbean.this.adInnerContainer.setVisibility(0);
                                }
                                for (; ; ) {
                                    FlurryAdbean.this.adInnerContainer.invalidate();
                                    this.val$adapter.notifyDataSetChanged();
                                    return;
                                    FlurryAdbean.this.adOutterContainer.setVisibility(8);
                                    FlurryAdbean.this.adInnerContainer.setVisibility(8);
                                }
                            }
                        }, 300L);
                        FlurryAdbean.this.trackingAdView();
                    }
                    if (FlurryAdbean.this.childAdbean != null) {
                        new Handler().postDelayed(new Runnable() {
                            public void run() {
                                FlurryAdbean.this.getAD2View(this.val$context, this.val$adapter, this.val$forumStatus, this.val$topic);
                            }
                        }, 15000L);
                    }
                }
            });
        }
    }

    public void getIMGAdView(final Activity paramActivity, final BaseAdapter paramBaseAdapter, final ForumStatus paramForumStatus, final Topic paramTopic) {
        if (!this.isGetAdsView) {
            final ImageView localImageView = new ImageView(paramActivity);
            localImageView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            ((AQuery) new AQuery(paramActivity).id(localImageView)).image(this.BannerURL, true, true, 0, 0, new BitmapAjaxCallback() {
                public void callback(String paramAnonymousString, ImageView paramAnonymousImageView, Bitmap paramAnonymousBitmap, AjaxStatus paramAnonymousAjaxStatus) {
                    FlurryAdbean.this.isGetAdsView = false;
                    if (paramAnonymousBitmap != null) {
                        paramAnonymousImageView.setImageBitmap(FlurryAdbean.this.resizeBannerImage(paramActivity, paramAnonymousBitmap));
                        if (FlurryAdbean.this.adInnerContainer.getChildCount() > 0) {
                            FlurryAdbean.this.adInnerContainer.removeAllViews();
                        }
                        FlurryAdbean.this.adInnerContainer.addView(localImageView);
                        FlurryAdbean.this.adOutterContainer.setVisibility(0);
                        FlurryAdbean.this.adInnerContainer.setVisibility(0);
                        FlurryAdbean.this.trackingAdView();
                    }
                    do {
                        return;
                        FlurryAdbean.this.adOutterContainer.setVisibility(8);
                    } while (FlurryAdbean.this.childAdbean == null);
                    FlurryAdbean.this.getAD2View(paramActivity, paramBaseAdapter, paramForumStatus, paramTopic);
                }
            });
            localImageView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramAnonymousView) {
                    FlurryAdbean.this.trackingAdViewClick();
                    paramAnonymousView = new Intent();
                    paramAnonymousView.setAction("android.intent.action.VIEW");
                    paramAnonymousView.setData(Uri.parse(FlurryAdbean.this.getTargetUrl()));
                    paramActivity.startActivity(paramAnonymousView);
                }
            });
            this.isGetAdsView = true;
        }
    }

    public String getMediation() {
        return this.mediation;
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

    public View getPtBannerAdView(Activity paramActivity, BaseAdapter paramBaseAdapter, ForumStatus paramForumStatus, Topic paramTopic) {
        if (this.childAdbean != null) {
            TapatalkLog.e("Ads", "adview1 have ads2");
        }
        if (this.adOutterContainer == null) {
            this.adOutterContainer = ((RelativeLayout) LayoutInflater.from(paramActivity).inflate(2130903049, null));
            this.adInnerContainer = ((LinearLayout) this.adOutterContainer.findViewById(2131230775));
            TextView localTextView = (TextView) this.adOutterContainer.findViewById(2131230776);
            if (SettingsFragment.isLightTheme(paramActivity)) {
                localTextView.setBackgroundColor(Color.parseColor("#e8e8e8"));
                if (!this.isFlurry) {
                    break label125;
                }
                getFlurryAdView(paramActivity, paramBaseAdapter, paramForumStatus, paramTopic);
            }
            for (; ; ) {
                return this.adOutterContainer;
                localTextView.setBackgroundColor(Color.parseColor("#37393b"));
                break;
                label125:
                if (this.isAmazon) {
                    getAmazonAdsView(paramActivity, paramBaseAdapter, paramForumStatus, paramTopic);
                } else if (this.isAdmobe) {
                    getAdmobView(paramActivity, paramBaseAdapter, paramForumStatus, paramTopic);
                } else if (this.isDfp) {
                    getDfpView(paramActivity, paramBaseAdapter, paramForumStatus, paramTopic);
                } else {
                    getIMGAdView(paramActivity, paramBaseAdapter, paramForumStatus, paramTopic);
                }
            }
        }
        this.adOutterContainer.invalidate();
        return this.adOutterContainer;
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

    public boolean isAdmobe() {
        return this.isAdmobe;
    }

    public boolean isAmazon() {
        return this.isAmazon;
    }

    public boolean isDfp() {
        return this.isDfp;
    }

    public boolean isFlurry() {
        return this.isFlurry;
    }

    public boolean isHasTracked() {
        return this.hasTracked;
    }

    public boolean isMM() {
        return this.isMM;
    }

    public boolean isOpenX() {
        return this.isOpenX;
    }

    public boolean isPostRelease() {
        return this.isPostRelease;
    }

    public void setAdmobe(boolean paramBoolean) {
        this.isAdmobe = paramBoolean;
    }

    public void setAmazon(boolean paramBoolean) {
        this.isAmazon = paramBoolean;
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

    public void setChildAdbean(FlurryAdbean paramFlurryAdbean) {
        this.childAdbean = paramFlurryAdbean;
    }

    public void setDfp(boolean paramBoolean) {
        this.isDfp = paramBoolean;
    }

    public void setFlurry(boolean paramBoolean) {
        this.isFlurry = paramBoolean;
    }

    public void setHasTracked(boolean paramBoolean) {
        this.hasTracked = paramBoolean;
    }

    public void setMM(boolean paramBoolean) {
        this.isMM = paramBoolean;
    }

    public void setMediation(String paramString) {
        this.mediation = paramString;
    }

    public void setOpenX(boolean paramBoolean) {
        this.isOpenX = paramBoolean;
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

    public void trackingAdView() {
        if (!this.hasTracked) {
            Log.e("ads", "tracking ads view");
            if ((this.primaryImpressionPixelUrl != null) && (!this.primaryImpressionPixelUrl.equals(""))) {
                new Thread() {
                    public void run() {
                        try {
                            AdBean.getImageStream(FlurryAdbean.this.primaryImpressionPixelUrl, null);
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
                            AdBean.getImageStream(FlurryAdbean.this.thirdPartyTrackingPixelUrl, FlurryAdbean.this.permanentLink);
                            return;
                        } catch (Exception localException) {
                            localException.printStackTrace();
                        }
                    }
                }.start();
            }
            this.hasTracked = true;
        }
    }

    public void trackingAdViewClick() {
        new Thread() {
            public void run() {
                try {
                    AdBean.getImageStream(FlurryAdbean.this.getSecondaryImpressionPixelUrl(), FlurryAdbean.this.getPermanentLink());
                    return;
                } catch (Exception localException) {
                    localException.printStackTrace();
                }
            }
        }.start();
        new Thread() {
            public void run() {
                try {
                    AdBean.getImageStream(FlurryAdbean.this.getSecondaryImpThirdPartyTrackingPixelUrl(), FlurryAdbean.this.getPermanentLink());
                    return;
                } catch (Exception localException) {
                    localException.printStackTrace();
                }
            }
        }.start();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ads/FlurryAdbean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */