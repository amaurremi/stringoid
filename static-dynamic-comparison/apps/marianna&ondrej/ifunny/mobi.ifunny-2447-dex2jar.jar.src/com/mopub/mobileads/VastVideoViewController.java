package com.mopub.mobileads;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.VideoView;
import com.mopub.common.DownloadResponse;
import com.mopub.common.DownloadTask;
import com.mopub.common.DownloadTask.DownloadTaskListener;
import com.mopub.common.HttpClient;
import com.mopub.common.HttpResponses;
import com.mopub.common.MoPubBrowser;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.AsyncTasks;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Drawables;
import com.mopub.mobileads.util.vast.VastCompanionAd;
import com.mopub.mobileads.util.vast.VastVideoConfiguration;

import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;

public class VastVideoViewController
        extends BaseVideoViewController
        implements DownloadTask.DownloadTaskListener {
    static final int DEFAULT_VIDEO_DURATION_FOR_CLOSE_BUTTON = 5000;
    private static final float FIRST_QUARTER_MARKER = 0.25F;
    static final int MAX_VIDEO_DURATION_FOR_CLOSE_BUTTON = 16000;
    private static final int MAX_VIDEO_RETRIES = 1;
    private static final float MID_POINT_MARKER = 0.5F;
    private static final int MOPUB_BROWSER_REQUEST_CODE = 1;
    private static final float THIRD_QUARTER_MARKER = 0.75F;
    static final String VAST_VIDEO_CONFIGURATION = "vast_video_configuration";
    private static final long VIDEO_PROGRESS_TIMER_CHECKER_DELAY = 50L;
    private static final int VIDEO_VIEW_FILE_PERMISSION_ERROR = Integer.MIN_VALUE;
    private static final ThreadPoolExecutor sThreadPoolExecutor = new ThreadPoolExecutor(10, 50, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private final View.OnTouchListener mClickThroughListener;
    private final ImageView mCompanionAdImageView;
    private final Handler mHandler = new Handler();
    private boolean mIsFirstMarkHit;
    private boolean mIsSecondMarkHit;
    private boolean mIsStartMarkHit;
    private boolean mIsThirdMarkHit;
    private boolean mIsVideoFinishedPlaying;
    private boolean mIsVideoProgressShouldBeChecked = false;
    private int mSeekerPositionOnPause = -1;
    private int mShowCloseButtonDelay = 5000;
    private boolean mShowCloseButtonEventFired;
    private final VastCompanionAd mVastCompanionAd;
    private final VastVideoConfiguration mVastVideoConfiguration;
    private final VastVideoToolbar mVastVideoToolbar;
    private final Runnable mVideoProgressCheckerRunnable;
    private int mVideoRetries = 0;
    private final VideoView mVideoView;

    VastVideoViewController(Context paramContext, Bundle paramBundle, long paramLong, BaseVideoViewController.BaseVideoViewControllerListener paramBaseVideoViewControllerListener) {
        super(paramContext, paramLong, paramBaseVideoViewControllerListener);
        paramBundle = paramBundle.getSerializable("vast_video_configuration");
        if ((paramBundle != null) && ((paramBundle instanceof VastVideoConfiguration))) {
            this.mVastVideoConfiguration = ((VastVideoConfiguration) paramBundle);
            if (this.mVastVideoConfiguration.getDiskMediaFileUrl() == null) {
                throw new IllegalStateException("VastVideoConfiguration does not have a video disk path");
            }
        } else {
            throw new IllegalStateException("VastVideoConfiguration is invalid");
        }
        this.mVastCompanionAd = this.mVastVideoConfiguration.getVastCompanionAd();
        this.mClickThroughListener = new VastVideoViewController .1 (this);
        createVideoBackground(paramContext);
        this.mVideoView = createVideoView(paramContext);
        this.mVideoView.requestFocus();
        this.mVastVideoToolbar = createVastVideoToolBar(paramContext);
        getLayout().addView(this.mVastVideoToolbar);
        this.mCompanionAdImageView = createCompanionAdImageView(paramContext);
        HttpClient.makeTrackingHttpRequest(this.mVastVideoConfiguration.getImpressionTrackers(), paramContext);
        this.mVideoProgressCheckerRunnable = createVideoProgressCheckerRunnable();
    }

    private ImageView createCompanionAdImageView(Context paramContext) {
        RelativeLayout localRelativeLayout = new RelativeLayout(paramContext);
        localRelativeLayout.setGravity(17);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
        localLayoutParams.addRule(3, this.mVastVideoToolbar.getId());
        getLayout().addView(localRelativeLayout, localLayoutParams);
        paramContext = new ImageView(paramContext);
        paramContext.setVisibility(4);
        localRelativeLayout.addView(paramContext, new RelativeLayout.LayoutParams(-1, -1));
        return paramContext;
    }

    private VastVideoToolbar createVastVideoToolBar(Context paramContext) {
        paramContext = new VastVideoToolbar(paramContext);
        paramContext.setCloseButtonOnTouchListener(new VastVideoViewController .4 (this));
        paramContext.setLearnMoreButtonOnTouchListener(this.mClickThroughListener);
        return paramContext;
    }

    private void createVideoBackground(Context paramContext) {
        GradientDrawable localGradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.argb(0, 0, 0, 0), Color.argb(255, 0, 0, 0)});
        paramContext = new LayerDrawable(new Drawable[]{Drawables.THATCHED_BACKGROUND.decodeImage(paramContext), localGradientDrawable});
        getLayout().setBackgroundDrawable(paramContext);
    }

    private Runnable createVideoProgressCheckerRunnable() {
        return new VastVideoViewController .3 (this);
    }

    private VideoView createVideoView(Context paramContext) {
        VideoView localVideoView = new VideoView(paramContext);
        localVideoView.setOnPreparedListener(new VastVideoViewController .5 (this));
        localVideoView.setOnTouchListener(this.mClickThroughListener);
        localVideoView.setOnCompletionListener(new VastVideoViewController .6 (this, paramContext, localVideoView));
        localVideoView.setOnErrorListener(new VastVideoViewController .7 (this));
        localVideoView.setVideoPath(this.mVastVideoConfiguration.getDiskMediaFileUrl());
        return localVideoView;
    }

    private void downloadCompanionAd() {
        if (this.mVastCompanionAd != null) {
        }
        try {
            HttpGet localHttpGet = HttpClient.initializeHttpGet(this.mVastCompanionAd.getImageUrl(), getContext());
            AsyncTasks.safeExecuteOnExecutor(new DownloadTask(this), new HttpUriRequest[]{localHttpGet});
            return;
        } catch (Exception localException) {
            MoPubLog.d("Failed to download companion ad", localException);
        }
    }

    private void handleClick(List<String> paramList, String paramString) {
        HttpClient.makeTrackingHttpRequest(paramList, getContext());
        videoClicked();
        paramList = new Bundle();
        paramList.putString("URL", paramString);
        getBaseVideoViewControllerListener().onStartActivityForResult(MoPubBrowser.class, 1, paramList);
    }

    private boolean isLongVideo(int paramInt) {
        return paramInt >= 16000;
    }

    private void makeVideoInteractable() {
        this.mShowCloseButtonEventFired = true;
        this.mVastVideoToolbar.makeInteractable();
    }

    private boolean shouldAllowClickThrough() {
        return this.mShowCloseButtonEventFired;
    }

    private boolean shouldBeInteractable() {
        return (!this.mShowCloseButtonEventFired) && (this.mVideoView.getCurrentPosition() > this.mShowCloseButtonDelay);
    }

    private void startProgressChecker() {
        if (!this.mIsVideoProgressShouldBeChecked) {
            this.mIsVideoProgressShouldBeChecked = true;
            this.mHandler.post(this.mVideoProgressCheckerRunnable);
        }
    }

    private void stopProgressChecker() {
        if (this.mIsVideoProgressShouldBeChecked) {
            this.mIsVideoProgressShouldBeChecked = false;
            this.mHandler.removeCallbacks(this.mVideoProgressCheckerRunnable);
        }
    }

    boolean backButtonEnabled() {
        return this.mShowCloseButtonEventFired;
    }

    @Deprecated
    ImageView getCompanionAdImageView() {
        return this.mCompanionAdImageView;
    }

    @Deprecated
    boolean getIsVideoProgressShouldBeChecked() {
        return this.mIsVideoProgressShouldBeChecked;
    }

    @Deprecated
    int getShowCloseButtonDelay() {
        return this.mShowCloseButtonDelay;
    }

    @Deprecated
    Runnable getVideoProgressCheckerRunnable() {
        return this.mVideoProgressCheckerRunnable;
    }

    @Deprecated
    int getVideoRetries() {
        return this.mVideoRetries;
    }

    VideoView getVideoView() {
        return this.mVideoView;
    }

    @Deprecated
    boolean isShowCloseButtonEventFired() {
        return this.mShowCloseButtonEventFired;
    }

    @Deprecated
    boolean isVideoFinishedPlaying() {
        return this.mIsVideoFinishedPlaying;
    }

    void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        if ((paramInt1 == 1) && (paramInt2 == -1)) {
            getBaseVideoViewControllerListener().onFinish();
        }
    }

    public void onComplete(String paramString, DownloadResponse paramDownloadResponse) {
        if ((paramDownloadResponse != null) && (paramDownloadResponse.getStatusCode() == 200)) {
            paramString = HttpResponses.asBitmap(paramDownloadResponse);
            if (paramString != null) {
                int i = Dips.dipsToIntPixels(paramString.getWidth(), getContext());
                int j = Dips.dipsToIntPixels(paramString.getHeight(), getContext());
                int k = this.mCompanionAdImageView.getMeasuredWidth();
                int m = this.mCompanionAdImageView.getMeasuredHeight();
                if ((i < k) && (j < m)) {
                    this.mCompanionAdImageView.getLayoutParams().width = i;
                    this.mCompanionAdImageView.getLayoutParams().height = j;
                }
                this.mCompanionAdImageView.setImageBitmap(paramString);
                this.mCompanionAdImageView.setOnClickListener(new VastVideoViewController .2 (this));
            }
        }
    }

    void onCreate() {
        super.onCreate();
        getBaseVideoViewControllerListener().onSetRequestedOrientation(0);
        broadcastAction("com.mopub.action.interstitial.show");
        downloadCompanionAd();
    }

    void onDestroy() {
        stopProgressChecker();
        broadcastAction("com.mopub.action.interstitial.dismiss");
    }

    void onPause() {
        stopProgressChecker();
        this.mSeekerPositionOnPause = this.mVideoView.getCurrentPosition();
        this.mVideoView.pause();
    }

    void onResume() {
        this.mVideoRetries = 0;
        startProgressChecker();
        this.mVideoView.seekTo(this.mSeekerPositionOnPause);
        if (!this.mIsVideoFinishedPlaying) {
            this.mVideoView.start();
        }
    }

    /* Error */
    boolean retryMediaPlayer(android.media.MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2) {
        // Byte code:
        //   0: invokestatic 559	com/mopub/common/util/VersionCode:currentApiLevel	()Lcom/mopub/common/util/VersionCode;
        //   3: getstatic 563	com/mopub/common/util/VersionCode:JELLY_BEAN	Lcom/mopub/common/util/VersionCode;
        //   6: invokevirtual 567	com/mopub/common/util/VersionCode:isBelow	(Lcom/mopub/common/util/VersionCode;)Z
        //   9: ifeq +130 -> 139
        //   12: iload_2
        //   13: iconst_1
        //   14: if_icmpne +125 -> 139
        //   17: iload_3
        //   18: ldc 31
        //   20: if_icmpne +119 -> 139
        //   23: aload_0
        //   24: getfield 98	com/mopub/mobileads/VastVideoViewController:mVideoRetries	I
        //   27: iconst_1
        //   28: if_icmpge +111 -> 139
        //   31: aconst_null
        //   32: astore 5
        //   34: aload_1
        //   35: invokevirtual 572	android/media/MediaPlayer:reset	()V
        //   38: new 574	java/io/FileInputStream
        //   41: dup
        //   42: new 576	java/io/File
        //   45: dup
        //   46: aload_0
        //   47: getfield 108	com/mopub/mobileads/VastVideoViewController:mVastVideoConfiguration	Lcom/mopub/mobileads/util/vast/VastVideoConfiguration;
        //   50: invokevirtual 112	com/mopub/mobileads/util/vast/VastVideoConfiguration:getDiskMediaFileUrl	()Ljava/lang/String;
        //   53: invokespecial 577	java/io/File:<init>	(Ljava/lang/String;)V
        //   56: invokespecial 580	java/io/FileInputStream:<init>	(Ljava/io/File;)V
        //   59: astore 4
        //   61: aload_1
        //   62: aload 4
        //   64: invokevirtual 584	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
        //   67: invokevirtual 588	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;)V
        //   70: aload_1
        //   71: invokevirtual 591	android/media/MediaPlayer:prepareAsync	()V
        //   74: aload_0
        //   75: getfield 144	com/mopub/mobileads/VastVideoViewController:mVideoView	Landroid/widget/VideoView;
        //   78: invokevirtual 551	android/widget/VideoView:start	()V
        //   81: aload 4
        //   83: invokestatic 597	com/mopub/common/util/Streams:closeStream	(Ljava/io/Closeable;)V
        //   86: aload_0
        //   87: aload_0
        //   88: getfield 98	com/mopub/mobileads/VastVideoViewController:mVideoRetries	I
        //   91: iconst_1
        //   92: iadd
        //   93: putfield 98	com/mopub/mobileads/VastVideoViewController:mVideoRetries	I
        //   96: iconst_1
        //   97: ireturn
        //   98: astore_1
        //   99: aconst_null
        //   100: astore_1
        //   101: aload_1
        //   102: invokestatic 597	com/mopub/common/util/Streams:closeStream	(Ljava/io/Closeable;)V
        //   105: aload_0
        //   106: aload_0
        //   107: getfield 98	com/mopub/mobileads/VastVideoViewController:mVideoRetries	I
        //   110: iconst_1
        //   111: iadd
        //   112: putfield 98	com/mopub/mobileads/VastVideoViewController:mVideoRetries	I
        //   115: iconst_0
        //   116: ireturn
        //   117: astore_1
        //   118: aload 5
        //   120: astore 4
        //   122: aload 4
        //   124: invokestatic 597	com/mopub/common/util/Streams:closeStream	(Ljava/io/Closeable;)V
        //   127: aload_0
        //   128: aload_0
        //   129: getfield 98	com/mopub/mobileads/VastVideoViewController:mVideoRetries	I
        //   132: iconst_1
        //   133: iadd
        //   134: putfield 98	com/mopub/mobileads/VastVideoViewController:mVideoRetries	I
        //   137: aload_1
        //   138: athrow
        //   139: iconst_0
        //   140: ireturn
        //   141: astore_1
        //   142: goto -20 -> 122
        //   145: astore_1
        //   146: aload 4
        //   148: astore_1
        //   149: goto -48 -> 101
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	152	0	this	VastVideoViewController
        //   0	152	1	paramMediaPlayer	android.media.MediaPlayer
        //   0	152	2	paramInt1	int
        //   0	152	3	paramInt2	int
        //   59	88	4	localObject1	Object
        //   32	87	5	localObject2	Object
        // Exception table:
        //   from	to	target	type
        //   34	61	98	java/lang/Exception
        //   34	61	117	finally
        //   61	81	141	finally
        //   61	81	145	java/lang/Exception
    }

    @Deprecated
    void setCloseButtonVisible(boolean paramBoolean) {
        this.mShowCloseButtonEventFired = paramBoolean;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/VastVideoViewController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */