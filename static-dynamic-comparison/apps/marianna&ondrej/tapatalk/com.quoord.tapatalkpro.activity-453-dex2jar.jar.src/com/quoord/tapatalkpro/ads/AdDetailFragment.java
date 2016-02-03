package com.quoord.tapatalkpro.ads;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.Html;
import android.text.Html.TagHandler;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.method.MovementMethod;
import android.text.style.URLSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.ImageInThread;
import com.quoord.tapatalkpro.cache.AppCacheManager;
import com.quoord.tapatalkpro.ics.BaseListFragment;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.ui.CustomImageViewLayout;
import com.quoord.tapatalkpro.util.BBcodeUtil;
import com.quoord.tapatalkpro.util.BBcodeUtil.BBElement;
import com.quoord.tapatalkpro.util.DownloadUtil;
import com.quoord.tapatalkpro.util.PatchedTextView;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tapatalkpro.youtube.YoutubeFullscreenActivity;
import com.quoord.tools.TwoPanelController;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.xml.sax.XMLReader;

public class AdDetailFragment
        extends BaseListFragment
        implements TwoPanelController {
    private String SecondaryImpThirdPartyTrackingPixelUrl;
    String VideoTrackingPixelUrl;
    private TextView author;
    private ImageView authorImg;
    private String authorImgTxt;
    private String authorTxt;
    private ActionBar bar;
    private View bg;
    private ImageView bottomImageView;
    private RelativeLayout bottomLink;
    private ScrollView content;
    private RelativeLayout htmlBody;
    private String htmlBodyTxt;
    private List<ImageInThread> imageList = new ArrayList();
    private boolean isPostRelease;
    private TextView link;
    private Activity mActivity;
    private HashMap mDatas;
    private MyHandler myHandler;
    private String permLink;
    private String permanentLink;
    private String secondaryImpressionPixelUrl;
    private String shareTrackingUrl;
    private ForumStatus status;
    private String tilteTxt;
    private String trackShareLink;

    private void doWeb(String paramString1, String paramString2) {
        try {
            paramString2 = paramString1.replaceAll("\"", "").replaceAll("^=", "").trim();
            paramString1 = paramString2;
            if (!paramString2.startsWith("http://")) {
                paramString1 = paramString2;
                if (!paramString2.startsWith("https://")) {
                    paramString1 = "http://" + paramString2;
                }
            }
            paramString1 = new Intent("android.intent.action.VIEW", Uri.parse(paramString1.replaceAll("&amp;", "&")));
            try {
                startActivity(paramString1);
                return;
            } catch (Exception paramString1) {
                paramString1.printStackTrace();
                return;
            }
            return;
        } catch (Exception paramString1) {
        }
    }

    public static AdDetailFragment newInstance(HashMap paramHashMap) {
        AdDetailFragment localAdDetailFragment = new AdDetailFragment();
        localAdDetailFragment.mDatas = paramHashMap;
        return localAdDetailFragment;
    }

    public BaseAdapter getAdapter() {
        return null;
    }

    public Bitmap getBitMap(Context paramContext, String paramString) {
        String str = AppCacheManager.getRemoteImageCacheDir(paramContext) + paramString.hashCode();
        if (new File(str).exists()) {
            return BitmapFactory.decodeFile(str);
        }
        return getBitMapFormNet(paramContext, paramString);
    }

    /* Error */
    public Bitmap getBitMapFormNet(Context paramContext, String paramString) {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aconst_null
        //   3: astore_3
        //   4: new 235	java/net/URL
        //   7: dup
        //   8: aload_2
        //   9: invokespecial 236	java/net/URL:<init>	(Ljava/lang/String;)V
        //   12: astore_2
        //   13: aload_2
        //   14: invokevirtual 240	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   17: checkcast 242	java/net/HttpURLConnection
        //   20: astore_1
        //   21: aload_1
        //   22: iconst_1
        //   23: invokevirtual 246	java/net/HttpURLConnection:setDoInput	(Z)V
        //   26: aload_1
        //   27: invokevirtual 249	java/net/HttpURLConnection:connect	()V
        //   30: aload_1
        //   31: invokevirtual 253	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
        //   34: invokestatic 257	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
        //   37: astore_1
        //   38: aload_0
        //   39: monitorexit
        //   40: aload_1
        //   41: areturn
        //   42: astore_2
        //   43: aload_1
        //   44: invokevirtual 263	android/content/Context:getResources	()Landroid/content/res/Resources;
        //   47: ldc_w 264
        //   50: invokestatic 268	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
        //   53: astore_1
        //   54: goto -16 -> 38
        //   57: astore_1
        //   58: aload_1
        //   59: invokevirtual 189	java/lang/Exception:printStackTrace	()V
        //   62: aload_3
        //   63: astore_1
        //   64: goto -26 -> 38
        //   67: astore_1
        //   68: aload_0
        //   69: monitorexit
        //   70: aload_1
        //   71: athrow
        //   72: astore_1
        //   73: goto -5 -> 68
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	76	0	this	AdDetailFragment
        //   0	76	1	paramContext	Context
        //   0	76	2	paramString	String
        //   3	60	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   4	13	42	java/net/MalformedURLException
        //   13	38	57	java/lang/Exception
        //   13	38	67	finally
        //   58	62	67	finally
        //   4	13	72	finally
        //   43	54	72	finally
    }

    public View[] getViewFromBody(List<BBcodeUtil.BBElement> paramList, String paramString, ForumStatus paramForumStatus) {
        View[] arrayOfView = new View[paramList.size()];
        int i = 0;
        if (i >= paramList.size()) {
            return arrayOfView;
        }
        ArrayList localArrayList = ((BBcodeUtil.BBElement) paramList.get(i)).content;
        Object localObject2;
        final Object localObject1;
        if (((BBcodeUtil.BBElement) paramList.get(i)).type == "QUOTE") {
            localObject2 = (LinearLayout) this.mActivity.getLayoutInflater().inflate(2130903331, null);
            localObject1 = (LinearLayout) ((LinearLayout) localObject2).getChildAt(1);
        }
        int j;
        Object localObject4;
        for (; ; ) {
            arrayOfView[i] = localObject2;
            j = 0;
            if (j < localArrayList.size()) {
                break label256;
            }
            i += 1;
            break;
            if (((BBcodeUtil.BBElement) paramList.get(i)).type == "SPOIL") {
                localObject2 = (LinearLayout) this.mActivity.getLayoutInflater().inflate(2130903369, null);
                localObject4 = (Button) ((LinearLayout) localObject2).findViewById(2131231608);
                localObject1 = (LinearLayout) ((LinearLayout) localObject2).findViewById(2131231609);
                ((LinearLayout) localObject1).setVisibility(8);
                ((Button) localObject4).setOnClickListener(new View.OnClickListener() {
                    public void onClick(View paramAnonymousView) {
                        if (localObject1.getVisibility() == 8) {
                            localObject1.setVisibility(0);
                            return;
                        }
                        localObject1.setVisibility(8);
                    }
                });
            } else {
                localObject2 = new LinearLayout(this.mActivity);
                ((LinearLayout) localObject2).setOrientation(1);
                ((LinearLayout) localObject2).setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
                localObject1 = localObject2;
            }
        }
        label256:
        BBcodeUtil.BBElement localBBElement = (BBcodeUtil.BBElement) localArrayList.get(j);
        int k;
        if ((localBBElement.content != null) && (localBBElement.content.size() > 0)) {
            new ArrayList().add(localBBElement);
            localObject2 = getViewFromBody(paramList, paramString, paramForumStatus);
            k = 0;
            label314:
            if (k < localObject2.length) {
            }
        }
        label734:
        for (; ; ) {
            j += 1;
            break;
            ((LinearLayout) localObject1).addView(localObject2[k]);
            k += 1;
            break label314;
            if (localBBElement.getType().equalsIgnoreCase("IMG")) {
                localObject2 = this.mActivity.getLayoutInflater().inflate(2130903226, null);
                localObject4 = new ImageInThread();
                ((ImageInThread) localObject4).clickView = ((ImageView) ((View) localObject2).findViewById(2131231285));
                ((ImageInThread) localObject4).clickView.setVisibility(8);
                ((ImageInThread) localObject4).pb = ((ProgressBar) ((View) localObject2).findViewById(2131231286));
                ((ImageInThread) localObject4).iv = ((CustomImageViewLayout) ((View) localObject2).findViewById(2131230863));
                ((ImageInThread) localObject4).sourceUrl = localBBElement.getValue();
                ((ImageInThread) localObject4).pb.setVisibility(0);
                new GetImageThread(this.mActivity, ((ImageInThread) localObject4).sourceUrl, (ImageInThread) localObject4).start();
            }
            for (; ; ) {
                if (localObject2 == null) {
                    break label734;
                }
                ((LinearLayout) localObject1).addView((View) localObject2);
                break;
                if (localBBElement.getType().equalsIgnoreCase("TEXT")) {
                    localObject4 = new PatchedTextView(this.mActivity);
                    try {
                        localObject2 = Html.fromHtml(localBBElement.getValue(), null, new MyTagHandler());
                        ((PatchedTextView) localObject4).setText((CharSequence) localObject2);
                        localObject2 = new MyLinkMovementMethod();
                        ((PatchedTextView) localObject4).setMovementMethod((MovementMethod) localObject2);
                        if (paramForumStatus.isLightTheme()) {
                            ((PatchedTextView) localObject4).setTextColor(getResources().getColor(2131165310));
                            ((PatchedTextView) localObject4).setLinkTextColor(getResources().getColor(2131165329));
                            ((PatchedTextView) localObject4).setLineSpacing(2.0F, 1.0F);
                            ((PatchedTextView) localObject4).setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                            localObject2 = localObject4;
                            if (!localBBElement.isQuote()) {
                                continue;
                            }
                            ((PatchedTextView) localObject4).setTypeface(Typeface.defaultFromStyle(2), 2);
                            ((PatchedTextView) localObject4).setTextColor(getResources().getColor(2131165275));
                            localObject2 = localObject4;
                        }
                    } catch (Exception localException) {
                        for (; ; ) {
                            ((PatchedTextView) localObject4).setText(localBBElement.getValue());
                            continue;
                            ((PatchedTextView) localObject4).setTextColor(-1);
                        }
                    }
                } else {
                    Object localObject3 = null;
                }
            }
        }
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        paramBundle = this.mActivity.getActionBar();
        paramBundle.setDisplayHomeAsUpEnabled(true);
        this.myHandler = new MyHandler(Looper.getMainLooper());
        if (this.mDatas != null) {
            this.tilteTxt = ((String) this.mDatas.get("postTitle"));
            paramBundle.setTitle(this.tilteTxt);
            this.authorTxt = ((String) this.mDatas.get("postAuthor"));
            this.htmlBodyTxt = ((String) this.mDatas.get("postHtmlBody"));
            this.secondaryImpressionPixelUrl = ((String) this.mDatas.get("secondaryImpressionPixelUrl"));
            this.SecondaryImpThirdPartyTrackingPixelUrl = ((String) this.mDatas.get("SecondaryImpThirdPartyTrackingPixelUrl"));
            this.VideoTrackingPixelUrl = ((String) this.mDatas.get("VideoTrackingPixelUrl"));
            this.trackShareLink = ((String) this.mDatas.get("trackShareLink"));
            this.permanentLink = ((String) this.mDatas.get("permanentLink"));
            this.isPostRelease = ((Boolean) this.mDatas.get("ispostrelease")).booleanValue();
        }
        if (!this.isPostRelease) {
            this.bottomImageView.setImageResource(2130839352);
        }
        try {
            if (SettingsFragment.isLightTheme(this.mActivity)) {
                this.bg.setBackgroundResource(2131165503);
            }
            this.bottomLink.setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramAnonymousView) {
                    paramAnonymousView = new Intent(AdDetailFragment.this.mActivity, AdWebviewActivity.class);
                    paramAnonymousView.putExtra("ispost", AdDetailFragment.this.isPostRelease);
                    AdDetailFragment.this.startActivity(paramAnonymousView);
                }
            });
            new Thread() {
                public void run() {
                    try {
                        AdBean.getImageStream(AdDetailFragment.this.secondaryImpressionPixelUrl, AdDetailFragment.this.permanentLink);
                        return;
                    } catch (Exception localException) {
                        localException.printStackTrace();
                    }
                }
            }.start();
            new Thread() {
                public void run() {
                    try {
                        AdBean.getImageStream(AdDetailFragment.this.SecondaryImpThirdPartyTrackingPixelUrl, AdDetailFragment.this.permanentLink);
                        return;
                    } catch (Exception localException) {
                        localException.printStackTrace();
                    }
                }
            }.start();
            if (this.mDatas != null) {
                this.status = ((ForumStatus) this.mDatas.get("com.quoord.tapatalkpro.ads.AdBean"));
            }
            int i;
            if ((this.htmlBodyTxt != null) && (!this.htmlBodyTxt.equals(""))) {
                this.htmlBodyTxt = this.htmlBodyTxt.replaceAll("(?i)\\[b(.*?)\\](.+?)\\[\\/b\\]", "<b$1\\>$2\\<\\/b\\>");
                this.htmlBodyTxt = this.htmlBodyTxt.replaceAll("(?i)\\[u(.*?)\\](.+?)\\[\\/u\\]", "<u$1\\>$2\\<\\/u\\>");
                this.htmlBodyTxt = this.htmlBodyTxt.replaceAll("(?i)\\[i(.*?)\\](.+?)\\[\\/i\\]", "<i$1\\>$2\\<\\/i\\>");
                this.htmlBodyTxt = this.htmlBodyTxt.replace("\r", "<br />");
                new ArrayList();
                paramBundle = getViewFromBody(BBcodeUtil.process(this.htmlBodyTxt, this.status, false, true, false, 0), this.htmlBodyTxt, this.status);
                if (this.mDatas != null) {
                    this.authorImgTxt = ((String) this.mDatas.get("postAuthorImg"));
                    this.author.setText(this.authorTxt);
                }
                i = 0;
            }
            for (; ; ) {
                if (i >= paramBundle.length) {
                    new Thread() {
                        public void run() {
                            Object localObject = AdDetailFragment.this.getBitMap(AdDetailFragment.this.mActivity, AdDetailFragment.this.authorImgTxt);
                            localObject = AdDetailFragment.this.myHandler.obtainMessage(1, 0, 0, localObject);
                            AdDetailFragment.this.myHandler.sendMessage((Message) localObject);
                        }
                    }.start();
                    return;
                }
                if (paramBundle[i] != null) {
                    this.htmlBody.addView(paramBundle[i]);
                }
                i += 1;
            }
        } catch (Exception paramBundle) {
            for (; ; ) {
            }
        }
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        this.mActivity = getActivity();
    }

    public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater) {
        super.onCreateOptionsMenu(paramMenu, paramMenuInflater);
        paramMenu.add(0, 0, 0, 2131100054).setIcon(2130837638);
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramLayoutInflater = paramLayoutInflater.inflate(2130903050, null);
        this.bg = paramLayoutInflater.findViewById(2131230777);
        this.link = ((TextView) paramLayoutInflater.findViewById(2131230785));
        this.link.getPaint().setFlags(8);
        this.bottomLink = ((RelativeLayout) paramLayoutInflater.findViewById(2131230783));
        this.author = ((TextView) paramLayoutInflater.findViewById(2131230781));
        this.htmlBody = ((RelativeLayout) paramLayoutInflater.findViewById(2131230782));
        this.authorImg = ((ImageView) paramLayoutInflater.findViewById(2131230780));
        this.authorImg.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("avator_background", getActivity()));
        this.bottomImageView = ((ImageView) paramLayoutInflater.findViewById(2131230786));
        this.content = ((ScrollView) paramLayoutInflater.findViewById(2131230778));
        return paramLayoutInflater;
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
        }
        for (; ; ) {
            return true;
            paramMenuItem = new Intent("android.intent.action.SEND");
            paramMenuItem.setType("text/plain");
            paramMenuItem.putExtra("android.intent.extra.SUBJECT", this.tilteTxt);
            paramMenuItem.putExtra("android.intent.extra.TEXT", this.permanentLink);
            startActivity(Intent.createChooser(paramMenuItem, this.mActivity.getTitle()));
            new Thread() {
                public void run() {
                    try {
                        AdBean.getImageStream(AdDetailFragment.this.trackShareLink, AdDetailFragment.this.permanentLink);
                        return;
                    } catch (Exception localException) {
                        localException.printStackTrace();
                    }
                }
            }.start();
            this.mActivity.finish();
        }
    }

    public void setActionBar(Activity paramActivity) {
        if (this.bar == null) {
            this.bar = paramActivity.getActionBar();
        }
        setBar();
    }

    public void setBar() {
        this.bar.setDisplayShowTitleEnabled(true);
        this.bar.setNavigationMode(0);
        this.bar.setTitle(this.tilteTxt);
    }

    class GetImageThread
            extends Thread {
        ImageInThread bean;
        Context context;
        String url;

        public GetImageThread(Context paramContext, String paramString, ImageInThread paramImageInThread) {
            this.context = paramContext;
            this.url = paramString;
            this.bean = paramImageInThread;
        }

        public void run() {
            Object localObject = DownloadUtil.getRomoteBitmapLocalUrl(this.context, this.url);
            HashMap localHashMap = new HashMap();
            localHashMap.put("localurl", localObject);
            localHashMap.put("url", this.url);
            localHashMap.put("ImageInThread", this.bean);
            localObject = AdDetailFragment.this.myHandler.obtainMessage(2, 0, 0, localHashMap);
            AdDetailFragment.this.myHandler.sendMessage((Message) localObject);
        }
    }

    public static abstract interface ImageCallBack {
        public abstract void imageLoad(ImageInThread paramImageInThread, String paramString1, String paramString2);
    }

    class MyHandler
            extends Handler {
        public MyHandler() {
        }

        public MyHandler(Looper paramLooper) {
            super();
        }

        public void handleMessage(Message paramMessage) {
            super.handleMessage(paramMessage);
            switch (paramMessage.what) {
            }
            Object localObject1;
            final String str;
            do {
                return;
                paramMessage = (Bitmap) paramMessage.obj;
                AdDetailFragment.this.authorImg.setImageBitmap(paramMessage);
                return;
                localObject1 = (HashMap) paramMessage.obj;
                paramMessage = (String) ((HashMap) localObject1).get("localurl");
                str = (String) ((HashMap) localObject1).get("url");
                localObject1 = (ImageInThread) ((HashMap) localObject1).get("ImageInThread");
            } while (!((ImageInThread) localObject1).sourceUrl.equals(str));
            if ((str != null) && (str.contains("http://img.youtube.com/vi/"))) {
                final Object localObject2 = str.split("/");
                str = "http://www.youtube.com/watch?v=" + localObject2[(localObject2.length - 2)];
                ImageView localImageView = new ImageView(AdDetailFragment.this.mActivity);
                localImageView.setImageResource(2130839008);
                ((LinearLayout) ((RelativeLayout) ((LinearLayout) ((ImageInThread) localObject1).iv.getParent()).getParent()).getChildAt(1)).setVisibility(0);
                ((LinearLayout) ((RelativeLayout) ((LinearLayout) ((ImageInThread) localObject1).iv.getParent()).getParent()).getChildAt(1)).removeAllViews();
                ((LinearLayout) ((RelativeLayout) ((LinearLayout) ((ImageInThread) localObject1).iv.getParent()).getParent()).getChildAt(1)).addView(localImageView);
                localObject2 = localObject2[(localObject2.length - 2)];
                ((ImageInThread) localObject1).iv.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View paramAnonymousView) {
                        new Thread() {
                            public void run() {
                                try {
                                    AdBean.getImageStream(AdDetailFragment.this.VideoTrackingPixelUrl, AdDetailFragment.this.permanentLink);
                                    return;
                                } catch (Exception localException) {
                                    localException.printStackTrace();
                                }
                            }
                        }.start();
                        paramAnonymousView = new Intent(AdDetailFragment.this.mActivity, YoutubeFullscreenActivity.class);
                        paramAnonymousView.putExtra("youtube_url", localObject2);
                        paramAnonymousView.putExtra("url", str);
                        AdDetailFragment.this.startActivity(paramAnonymousView);
                    }
                });
            }
            if (!paramMessage.equals("BROKEN")) {
                ((ImageInThread) localObject1).pb.setVisibility(8);
                ((ImageInThread) localObject1).iv.setCustomUrl(paramMessage);
                ((ImageInThread) localObject1).setLocalIconUri(paramMessage);
                ((ImageInThread) localObject1).iv.setVisibility(0);
                ((ImageInThread) localObject1).iv.setNeedbackground();
                ((ImageInThread) localObject1).iv.setImageBitmap(Util.getRemotePic(paramMessage));
                ((ImageInThread) localObject1).iv.forceDraw();
                AdDetailFragment.this.imageList.add(localObject1);
                return;
            }
            ((ImageInThread) localObject1).pb.setVisibility(8);
            ((ImageInThread) localObject1).iv.setVisibility(0);
            ((ImageInThread) localObject1).iv.forceDraw();
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
                AdDetailFragment.this.doWeb(paramString, null);
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
            boolean bool = true;
            this.mUrl = paramSpannable.toString();
            switch (paramMotionEvent.getAction()) {
                default:
                    bool = this.mParen.onTouchEvent(paramTextView, paramSpannable, paramMotionEvent);
                case 0:
                    return bool;
            }
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
                    return true;
                }
                AdDetailFragment.this.doWeb(paramTextView[0].getURL(), paramSpannable.toString().substring(paramSpannable.getSpanStart(paramTextView[0]), paramSpannable.getSpanEnd(paramTextView[0])));
                return true;
            }
            return false;
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
                    paramEditable.append("\n\t• ");
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ads/AdDetailFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */