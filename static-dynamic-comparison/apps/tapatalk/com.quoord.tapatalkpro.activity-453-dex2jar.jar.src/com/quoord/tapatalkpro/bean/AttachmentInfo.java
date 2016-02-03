package com.quoord.tapatalkpro.bean;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.MediaScannerConnectionClient;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RemoteViews;
import android.widget.TextView;
import android.widget.Toast;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.activity.forum.ThreadActivity;
import com.quoord.tapatalkpro.activity.forum.ThreadFragment;
import com.quoord.tapatalkpro.activity.forum.ThreadOuterFragment;
import com.quoord.tapatalkpro.adapter.forum.BlogAdapter;
import com.quoord.tapatalkpro.adapter.forum.ForumRootAdapter;
import com.quoord.tapatalkpro.adapter.forum.PMContentAdapter;
import com.quoord.tapatalkpro.adapter.forum.ThreadAdapter;
import com.quoord.tapatalkpro.adapter.forum.conversation.ConvDetailAdapter;
import com.quoord.tapatalkpro.ics.ics.blog.Blog;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.ui.CustomImageViewLayout;
import com.quoord.tapatalkpro.util.GifTypeandLocalUrl;
import com.quoord.tapatalkpro.util.ImageInThreadLoader;
import com.quoord.tapatalkpro.util.ImageInThreadLoader.ImageCallBack;
import com.quoord.tapatalkpro.util.ImageItem;
import com.quoord.tapatalkpro.util.MySSLSocketFactory;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tapatalkpro.youtube.YoutubeFullscreenActivity;
import com.quoord.tools.QuoordGalleryActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Random;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

@SuppressLint({"NewApi"})
public class AttachmentInfo {
    private static String fid;
    private static GifTypeandLocalUrl mLocalUrl;
    public static Random sRandom = new Random(SystemClock.uptimeMillis());
    private static String tid = null;
    private static String title;
    public int MAX_PROGRESS = 100;
    private final String[][] MIME_MapTable;
    private TextView attachInfo;
    public String attachmentId;
    private Notification.Builder builder = null;
    public String contentType;
    int currentCount = 0;
    private int currentMax;
    private String currentMime;
    public RelativeLayout downAndView;
    private Handler handler = null;
    public ImageView iconView;
    private PendingIntent intent = null;
    private boolean isDownload = false;
    boolean isDownloadCancel = false;
    public String localUri;
    private NotificationManager manager = null;
    public String mimeType;
    public String name;
    private Notification notification = null;
    public Uri scanUri;
    public long size;
    private Thread thread;
    public String url;
    private RemoteViews view = null;

    static {
        fid = null;
        title = null;
    }

    public AttachmentInfo() {
        String[] arrayOfString1 = {".conf", "text/plain"};
        String[] arrayOfString2 = {".html", "text/html"};
        String[] arrayOfString3 = {".mpc", "application/vnd.mpohun.certificate"};
        String[] arrayOfString4 = {".tar", "application/x-tar"};
        String[] arrayOfString5 = {".wma", "audio/x-ms-wma"};
        String[] arrayOfString6 = {".wmv", "audio/x-ms-wmv"};
        String[] arrayOfString7 = {".ram", "audio/x-pn-realaudio"};
        this.MIME_MapTable = new String[][]{{".3gp", "video/3gpp"}, {".apk", "application/vnd.android.package-archive"}, {".asf", "video/x-ms-asf"}, {".avi", "video/x-msvideo"}, {".bin", "application/octet-stream"}, {".bmp", "image/bmp"}, {".c", "text/plain"}, {".class", "application/octet-stream"}, arrayOfString1, {".cpp", "text/plain"}, {".doc", "application/msword"}, {".exe", "application/octet-stream"}, {".gif", "image/gif"}, {".gtar", "application/x-gtar"}, {".gz", "application/x-gzip"}, {".h", "text/plain"}, {".htm", "text/html"}, arrayOfString2, {".jar", "application/java-archive"}, {".java", "text/plain"}, {".jpeg", "image/jpeg"}, {".jpg", "image/jpeg"}, {".js", "application/x-javascript"}, {".log", "text/plain"}, {".m3u", "audio/x-mpegurl"}, {".m4a", "audio/mp4a-latm"}, {".m4b", "audio/mp4a-latm"}, {".m4p", "audio/mp4a-latm"}, {".m4u", "video/vnd.mpegurl"}, {".m4v", "video/x-m4v"}, {".mov", "video/quicktime"}, {".mp2", "audio/x-mpeg"}, {".mp3", "audio/x-mpeg"}, {".mp4", "video/mp4"}, arrayOfString3, {".mpe", "video/mpeg"}, {".mpeg", "video/mpeg"}, {".mpg", "video/mpeg"}, {".mpg4", "video/mp4"}, {".mpga", "audio/mpeg"}, {".msg", "application/vnd.ms-outlook"}, {".ogg", "audio/ogg"}, {".pdf", "application/pdf"}, {".png", "image/png"}, {".pps", "application/vnd.ms-powerpoint"}, {".ppt", "application/vnd.ms-powerpoint"}, {".prop", "text/plain"}, {".rar", "application/x-rar-compressed"}, {".rc", "text/plain"}, {".rmvb", "audio/x-pn-realaudio"}, {".rtf", "application/rtf"}, {".sh", "text/plain"}, arrayOfString4, {".tgz", "application/x-compressed"}, {".txt", "text/plain"}, {".UnknownType", "*/*"}, {".wav", "audio/wav"}, arrayOfString5, arrayOfString6, {".wps", "application/vnd.ms-works"}, {".xml", "text/xml"}, {".z", "application/x-compress"}, {".zip", "application/zip"}, {".aiff", "audio/aiff"}, {".ico", "image/x-icon"}, {".css", "application/x-pointplus"}, {".hqx", "application/binhex"}, {".ps", "application/postscript"}, arrayOfString7, {".swf", "application/x-shockwave-flash"}, {".viv", "video/vivo"}, {"", "*/*"}};
    }

    private static View addAttachment(final ForumActivityStatus paramForumActivityStatus, HashMap paramHashMap, final ForumRootAdapter paramForumRootAdapter) {
        String str = (String) paramHashMap.get("url");
        final ForumStatus localForumStatus = paramForumActivityStatus.getForumStatus();
        AttachmentInfo localAttachmentInfo = new AttachmentInfo();
        FrameLayout localFrameLayout = (FrameLayout) paramForumActivityStatus.getDefaultActivity().getLayoutInflater().inflate(2130903271, null);
        try {
            if (paramHashMap.containsKey("filesize")) {
                localAttachmentInfo.size = ((Integer) paramHashMap.get("filesize")).intValue();
            }
            if (paramHashMap.containsKey("content_type")) {
                localAttachmentInfo.contentType = ((String) paramHashMap.get("content_type"));
            }
            if (paramHashMap.get("filename") == null) {
                localAttachmentInfo.name = ("Attachment-" + str.hashCode());
                paramHashMap = (TextView) localFrameLayout.findViewById(2131230958);
                final TextView localTextView = (TextView) localFrameLayout.findViewById(2131231390);
                ImageView localImageView = (ImageView) localFrameLayout.findViewById(2131230957);
                RelativeLayout localRelativeLayout = (RelativeLayout) localFrameLayout.findViewById(2131230955);
                localAttachmentInfo.downAndView = localRelativeLayout;
                localAttachmentInfo.iconView = localImageView;
                localAttachmentInfo.url = str;
                localAttachmentInfo.attachInfo = localTextView;
                localFrameLayout.setTag(localAttachmentInfo);
                paramForumRootAdapter = new Handler() {
                    Button view;

                    public void handleMessage(Message paramAnonymousMessage) {
                        if (Boolean.valueOf(paramAnonymousMessage.obj.toString()).booleanValue()) {
                            AttachmentInfo.this.isDownload = true;
                            if (AttachmentInfo.this.isDownload) {
                                break label74;
                            }
                            AttachmentInfo.this.attachInfo.setText(AttachmentInfo.formatSize(AttachmentInfo.this.size));
                        }
                        for (; ; ) {
                            localTextView.invalidate();
                            paramForumRootAdapter.notifyDataSetChanged();
                            super.handleMessage(paramAnonymousMessage);
                            return;
                            label74:
                            AttachmentInfo.this.attachInfo.setText("Saved " + AttachmentInfo.formatSize(AttachmentInfo.this.size));
                        }
                    }
                };
                new Thread() {
                    public void run() {
                        Object localObject = new File(SettingsFragment.getDownloadLocation(AttachmentInfo.this.getDefaultActivity()) + File.separator + this.val$fileName);
                        boolean bool = false;
                        if (((File) localObject).exists()) {
                            bool = true;
                        }
                        localObject = new Message();
                        ((Message) localObject).obj = Boolean.valueOf(bool);
                        paramForumRootAdapter.sendMessage((Message) localObject);
                    }
                }.start();
                localRelativeLayout.setTag(localAttachmentInfo);
                localRelativeLayout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View paramAnonymousView) {
                        if (!AttachmentInfo.this.isDownload) {
                            AttachmentInfo.this.download(paramForumActivityStatus.getDefaultActivity(), localForumStatus);
                            return;
                        }
                        AttachmentInfo.this.setViewBtn(paramForumActivityStatus.getDefaultActivity());
                    }
                });
                paramHashMap.setText(localAttachmentInfo.name);
                if (localAttachmentInfo.isDownload) {
                    break label417;
                }
                localTextView.setText(formatSize(localAttachmentInfo.size));
            }
            for (; ; ) {
                if (localForumStatus.isLightTheme()) {
                    break label449;
                }
                paramHashMap.setTextColor(-1);
                localFrameLayout.findViewById(2131230955).setBackgroundResource(2130839441);
                return localFrameLayout;
                try {
                    localAttachmentInfo.name = new String((byte[]) paramHashMap.get("filename"), "UTF-8");
                } catch (Exception localException) {
                    localAttachmentInfo.name = new String((byte[]) paramHashMap.get("filename"));
                }
                break;
                label417:
                localException.setText("Saved " + formatSize(localAttachmentInfo.size));
            }
            label449:
            paramHashMap.setTextColor(-16777216);
            return localFrameLayout;
        } catch (Exception paramForumActivityStatus) {
        }
        return localFrameLayout;
    }

    public static void addBeanToFinished(Activity paramActivity, ForumRootAdapter paramForumRootAdapter, ImageInThread paramImageInThread, String paramString1, ParseableData paramParseableData, String paramString2, ForumStatus paramForumStatus) {
        if ((paramString1 != null) && (paramString1.contains("http://img.youtube.com/vi/"))) {
            paramString1 = new ImageView(paramActivity);
            paramString1.setImageResource(2130839008);
            ((LinearLayout) ((RelativeLayout) ((LinearLayout) paramImageInThread.iv.getParent()).getParent()).getChildAt(1)).setVisibility(0);
            ((LinearLayout) ((RelativeLayout) ((LinearLayout) paramImageInThread.iv.getParent()).getParent()).getChildAt(1)).removeAllViews();
            ((LinearLayout) ((RelativeLayout) ((LinearLayout) paramImageInThread.iv.getParent()).getParent()).getChildAt(1)).addView(paramString1);
        }
        for (; ; ) {
            setBigImageOnClickListener(paramActivity, paramForumRootAdapter, paramImageInThread, paramImageInThread.sourceUrl, paramParseableData, paramForumStatus);
            return;
            if ((paramParseableData != null) && (paramParseableData.getImageBeansFinished() != null)) {
                paramImageInThread.position = paramParseableData.getImageBeansFinished().size();
                paramImageInThread.type = paramString2;
                paramParseableData.addImageBeanToFinished(paramImageInThread);
            }
        }
    }

    private static String chooseUniqueFilename(String paramString1, String paramString2) {
        String str = paramString1 + "." + paramString2;
        if (!new File(str).exists()) {
            return str;
        }
        paramString1 = paramString1 + "-";
        int j = 1;
        int i = 1;
        if (i >= 1000000000) {
            return null;
        }
        int k = 0;
        for (; ; ) {
            if (k >= 9) {
                i *= 10;
                break;
            }
            str = paramString1 + j + "." + paramString2;
            if (!new File(str).exists()) {
                return str;
            }
            j += sRandom.nextInt(i) + 1;
            k += 1;
        }
    }

    public static void download(final Activity paramActivity, String paramString) {
        if (!Environment.getExternalStorageState().equals("mounted")) {
            Toast.makeText(paramActivity, paramActivity.getString(2131100169), 1).show();
            return;
        }
        final Object localObject1 = paramString.split("/");
        localObject1 = localObject1[(localObject1.length - 1)];
        final Object localObject2 = new File(SettingsFragment.getDownloadLocation(paramActivity));
        if (!((File) localObject2).exists()) {
            ((File) localObject2).mkdir();
        }
        localObject2 = SettingsFragment.getDownloadLocation(paramActivity) + File.separator + (String) localObject1;
        RemoteViews localRemoteViews = new RemoteViews(paramActivity.getPackageName(), 2130903067);
        final NotificationManager localNotificationManager = (NotificationManager) paramActivity.getSystemService("notification");
        final Notification.Builder localBuilder = new Notification.Builder(paramActivity);
        final Handler local8 = new Handler() {
            public void handleMessage(Message paramAnonymousMessage) {
                int i = Integer.valueOf(paramAnonymousMessage.obj.toString()).intValue();
                AttachmentInfo.this.setProgressBar(2131230848, 100, i, false);
                AttachmentInfo.this.setTextViewText(2131230847, i + "%");
                AttachmentInfo.this.setTextViewText(2131230846, localObject1);
                Object localObject = BitmapFactory.decodeResource(paramActivity.getResources(), 2130837871);
                if (i == 100) {
                    localNotificationManager.cancel(localObject1.hashCode());
                    localObject = new Notification(2130837871, "", System.currentTimeMillis());
                    Intent localIntent = new Intent("android.intent.action.VIEW");
                    localIntent.setDataAndType(Uri.fromFile(new File(localObject2)), "application/vnd.android.package-archive");
                    paramActivity.startActivity(localIntent);
                    ((Notification) localObject).setLatestEventInfo(paramActivity, localObject1, paramActivity.getString(2131100267), PendingIntent.getActivity(paramActivity, 0, localIntent, 0));
                    ((Notification) localObject).flags = 16;
                    localNotificationManager.notify(localObject1.hashCode(), (Notification) localObject);
                }
                for (; ; ) {
                    super.handleMessage(paramAnonymousMessage);
                    return;
                    localBuilder.setContent(AttachmentInfo.this);
                    localBuilder.setLargeIcon((Bitmap) localObject);
                    localBuilder.setSmallIcon(2130837871);
                    localBuilder.setOngoing(true);
                    localNotificationManager.notify(localObject1.hashCode(), localBuilder.getNotification());
                }
            }
        };
        localRemoteViews.setProgressBar(2131230848, 100, 0, false);
        localRemoteViews.setTextViewText(2131230847, "0%");
        localRemoteViews.setTextViewText(2131230846, (CharSequence) localObject1);
        localBuilder.setOngoing(true);
        localBuilder.setContent(localRemoteViews);
        localBuilder.setLargeIcon(BitmapFactory.decodeResource(paramActivity.getResources(), 2130837871));
        localBuilder.setSmallIcon(2130837871);
        localBuilder.setTicker("Downloading new Beta");
        localNotificationManager.notify(((String) localObject1).hashCode(), localBuilder.getNotification());
        new Thread() {
            public void run() {
                Object localObject1 = new SchemeRegistry();
                try {
                    localObject2 = KeyStore.getInstance(KeyStore.getDefaultType());
                    ((KeyStore) localObject2).load(null, null);
                    localObject2 = new MySSLSocketFactory((KeyStore) localObject2);
                    ((SSLSocketFactory) localObject2).setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
                    ((SchemeRegistry) localObject1).register(new Scheme("https", (SocketFactory) localObject2, 443));
                } catch (Exception localException2) {
                    try {
                        Object localObject2 = new BasicHttpParams();
                        HttpProtocolParams.setVersion((HttpParams) localObject2, HttpVersion.HTTP_1_1);
                        HttpProtocolParams.setContentCharset((HttpParams) localObject2, "UTF-8");
                        ((SchemeRegistry) localObject1).register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
                        localObject1 = new DefaultHttpClient(new ThreadSafeClientConnManager((HttpParams) localObject2, (SchemeRegistry) localObject1), (HttpParams) localObject2);
                        localObject2 = new HttpGet(AttachmentInfo.this);
                        int i = 0;
                        localObject1 = ((HttpClient) localObject1).execute((HttpUriRequest) localObject2).getEntity();
                        long l = ((HttpEntity) localObject1).getContentLength();
                        ((HttpEntity) localObject1).getContentType().getValue();
                        localObject2 = ((HttpEntity) localObject1).getContent();
                        localObject1 = null;
                        byte[] arrayOfByte;
                        int j;
                        int i1;
                        if (localObject2 != null) {
                            localObject1 = new FileOutputStream(new File(localObject2));
                            arrayOfByte = new byte['Ѐ'];
                            j = 0;
                            i1 = (int) l;
                        }
                        for (; ; ) {
                            int k = ((InputStream) localObject2).read(arrayOfByte);
                            if (k == -1) {
                                ((FileOutputStream) localObject1).flush();
                                if (localObject1 != null) {
                                    ((FileOutputStream) localObject1).close();
                                }
                                return;
                                localException2 = localException2;
                                localException2.printStackTrace();
                                break;
                            }
                            ((FileOutputStream) localObject1).write(arrayOfByte, 0, k);
                            int m = j + k;
                            k = i;
                            try {
                                int n = m * 100 / i1;
                                j = m;
                                if (i < n) {
                                    i = n;
                                    k = i;
                                    Message localMessage = new Message();
                                    k = i;
                                    localMessage.obj = Integer.valueOf(n);
                                    k = i;
                                    local8.sendMessage(localMessage);
                                    j = m;
                                }
                            } catch (Exception localException3) {
                                localException3.printStackTrace();
                                j = m;
                                i = k;
                            }
                        }
                        Notification localNotification;
                        return;
                    } catch (Exception localException1) {
                        localException1.printStackTrace();
                        localNotificationManager.cancel(localObject1.hashCode());
                        localNotification = new Notification(2130837871, paramActivity.getString(2131100268), System.currentTimeMillis());
                        localNotification.setLatestEventInfo(paramActivity, localObject1, paramActivity.getString(2131100268), PendingIntent.getActivity(paramActivity, 0, new Intent(), 0));
                        localNotification.flags = 16;
                        localNotificationManager.notify(localObject1.hashCode(), localNotification);
                        localException1.printStackTrace();
                    }
                }
            }
        }.start();
    }

    private static String formatSize(long paramLong) {
        if (paramLong <= 0L) {
            return "";
        }
        return Util.formatSize((float) paramLong);
    }

    public static void getAttachView(final ForumActivityStatus paramForumActivityStatus, final ForumRootAdapter paramForumRootAdapter, Object[] paramArrayOfObject, final ParseableData paramParseableData) {
        LinearLayout localLinearLayout = new LinearLayout(paramForumActivityStatus.getDefaultActivity());
        localLinearLayout.setOrientation(1);
        final ForumStatus localForumStatus = paramForumActivityStatus.getForumStatus();
        int i = 0;
        if (i >= paramArrayOfObject.length) {
            paramParseableData.setAttachLay(localLinearLayout);
            return;
        }
        Object localObject1 = (HashMap) paramArrayOfObject[i];
        final Object localObject2;
        View localView;
        int j;
        label162:
        ImageInThread localImageInThread;
        if (((String) ((HashMap) localObject1).get("content_type")).equals("image")) {
            localObject2 = (RelativeLayout) paramForumActivityStatus.getDefaultActivity().getLayoutInflater().inflate(2130903226, null);
            localView = ((RelativeLayout) localObject2).findViewById(2131231203);
            localView.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("image_load", paramForumActivityStatus.getDefaultActivity()));
            localLinearLayout.addView((View) localObject2);
            ImageView localImageView = (ImageView) ((RelativeLayout) localObject2).findViewById(2131231285);
            if (SettingsFragment.isLightTheme(paramForumActivityStatus.getDefaultActivity())) {
                j = 2130838947;
                localImageView.setImageResource(j);
                ProgressBar localProgressBar = (ProgressBar) ((RelativeLayout) localObject2).findViewById(2131231286);
                CustomImageViewLayout localCustomImageViewLayout = (CustomImageViewLayout) ((RelativeLayout) localObject2).findViewById(2131230863);
                localObject2 = (ImageView) ((RelativeLayout) localObject2).findViewById(2131231288);
                localImageInThread = new ImageInThread();
                if (Util.getHost(localForumStatus.getUrl()).equalsIgnoreCase(Util.getHost((String) ((HashMap) localObject1).get("url")))) {
                    localImageInThread.setCookies(localForumStatus.getCookie());
                }
                localProgressBar.setVisibility(0);
                localImageInThread.sourceUrl = ((String) ((HashMap) localObject1).get("url"));
                localImageInThread.iv = localCustomImageViewLayout;
                localImageInThread.pb = localProgressBar;
                localImageInThread.clickView = localImageView;
                localObject1 = localImageInThread.clickView;
                if (!SettingsFragment.isLightTheme(paramForumActivityStatus.getDefaultActivity())) {
                    break label463;
                }
                j = 2130838947;
                label322:
                ((ImageView) localObject1).setImageResource(j);
                localImageInThread.iv.setNeedbackground();
                if ((paramForumActivityStatus instanceof ThreadActivity)) {
                    tid = ((ThreadActivity) paramForumActivityStatus).outerFragment.mTopic.getId();
                    fid = ((ThreadActivity) paramForumActivityStatus).outerFragment.mTopic.getForumId();
                    title = ((ThreadActivity) paramForumActivityStatus).outerFragment.mTopic.getTitle();
                }
                if (localImageInThread.sourceUrl != null) {
                    if (Util.is2GState(paramForumActivityStatus.getDefaultActivity())) {
                        break label543;
                    }
                    if (!SettingsFragment.isShowPhotos(paramForumActivityStatus.getDefaultActivity())) {
                        break label471;
                    }
                    localImageInThread.clickView.setVisibility(8);
                    loadingImage(localImageInThread, (ImageView) localObject2, paramParseableData, localForumStatus, paramForumActivityStatus, paramForumRootAdapter);
                }
            }
        }
        for (; ; ) {
            i += 1;
            break;
            j = 2130838948;
            break label162;
            label463:
            j = 2130838948;
            break label322;
            label471:
            localImageInThread.pb.setVisibility(8);
            localImageInThread.clickView.setVisibility(0);
            if (ImageInThreadLoader.checkLocalImg(paramForumActivityStatus.getDefaultActivity(), localImageInThread.sourceUrl)) {
                loadingImage(localImageInThread, (ImageView) localObject2, paramParseableData, localForumStatus, paramForumActivityStatus, paramForumRootAdapter);
            }
            localView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramAnonymousView) {
                    AttachmentInfo.this.clickView.setVisibility(8);
                    AttachmentInfo.this.pb.setVisibility(0);
                    AttachmentInfo.loadingImage(AttachmentInfo.this, localObject2, paramParseableData, localForumStatus, paramForumActivityStatus, paramForumRootAdapter);
                }
            });
            continue;
            label543:
            if (SettingsFragment.isShowAvatarWithSlowConn(paramForumActivityStatus.getDefaultActivity())) {
                localImageInThread.clickView.setVisibility(8);
                loadingImage(localImageInThread, (ImageView) localObject2, paramParseableData, localForumStatus, paramForumActivityStatus, paramForumRootAdapter);
            } else {
                localImageInThread.pb.setVisibility(8);
                localImageInThread.clickView.setVisibility(0);
                if (ImageInThreadLoader.checkLocalImg(paramForumActivityStatus.getDefaultActivity(), localImageInThread.sourceUrl)) {
                    loadingImage(localImageInThread, (ImageView) localObject2, paramParseableData, localForumStatus, paramForumActivityStatus, paramForumRootAdapter);
                }
                localView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View paramAnonymousView) {
                        AttachmentInfo.this.clickView.setVisibility(8);
                        AttachmentInfo.this.pb.setVisibility(0);
                        AttachmentInfo.loadingImage(AttachmentInfo.this, localObject2, paramParseableData, localForumStatus, paramForumActivityStatus, paramForumRootAdapter);
                    }
                });
                continue;
                localLinearLayout.addView(addAttachment(paramForumActivityStatus, (HashMap) localObject1, paramForumRootAdapter));
            }
        }
    }

    private String getMIMEType(File paramFile) {
        String str1 = "*/*";
        paramFile = paramFile.getName();
        int i = paramFile.lastIndexOf(".");
        if (i < 0) {
            return "*/*";
        }
        String str2 = paramFile.substring(i, paramFile.length()).toLowerCase();
        if (str2 == "") {
            return "*/*";
        }
        i = 0;
        paramFile = str1;
        for (; ; ) {
            if (i >= this.MIME_MapTable.length) {
                return paramFile;
            }
            if (str2.equals(this.MIME_MapTable[i][0])) {
                paramFile = this.MIME_MapTable[i][1];
            }
            i += 1;
        }
    }

    public static void loadingImage(ImageInThread paramImageInThread, ImageView paramImageView, final ParseableData paramParseableData, final ForumStatus paramForumStatus, final ForumActivityStatus paramForumActivityStatus, final ForumRootAdapter paramForumRootAdapter) {
        mLocalUrl = ImageInThreadLoader.getLocalStringAndType(paramForumStatus, paramImageInThread, paramImageInThread.sourceUrl, new ImageInThreadLoader.ImageCallBack() {
            public void imageLoad(ImageInThread paramAnonymousImageInThread, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3) {
                if (paramAnonymousString1 != null) {
                    if (!paramAnonymousString1.equals("BROKEN")) {
                        paramAnonymousImageInThread.pb.setVisibility(8);
                        paramAnonymousImageInThread.clickView.setVisibility(8);
                        paramAnonymousImageInThread.iv.setCustomUrl(paramAnonymousString1);
                        paramAnonymousImageInThread.setLocalIconUri(paramAnonymousString1);
                        paramAnonymousImageInThread.iv.setVisibility(0);
                        if ((paramAnonymousString3 != null) && (paramAnonymousString3.equals(ImageItem.GIF))) {
                            AttachmentInfo.this.setVisibility(0);
                        }
                        AttachmentInfo.addBeanToFinished(paramForumActivityStatus.getDefaultActivity(), paramForumRootAdapter, paramAnonymousImageInThread, paramAnonymousImageInThread.sourceUrl, paramParseableData, paramAnonymousString3, paramForumStatus);
                        paramAnonymousImageInThread.iv.forceDraw();
                    }
                } else {
                    return;
                }
                paramAnonymousImageInThread.pb.setVisibility(8);
                paramAnonymousImageInThread.clickView.setVisibility(8);
                paramAnonymousImageInThread.iv.setVisibility(0);
                paramAnonymousImageInThread.iv.setCustomUrl("BROKEN");
                paramAnonymousImageInThread.iv.forceDraw();
            }
        }, tid, fid, paramParseableData.getPostTimeStamp(), paramParseableData.getPostId(), title, paramParseableData.getFloor(), paramForumActivityStatus.getDefaultActivity());
        if (mLocalUrl != null) {
            if (!mLocalUrl.equals("BROKEN")) {
                paramImageInThread.pb.setVisibility(8);
                paramImageInThread.clickView.setVisibility(8);
                paramImageInThread.iv.setCustomUrl(mLocalUrl.localUrl);
                paramImageInThread.setLocalIconUri(mLocalUrl.localUrl);
                paramImageInThread.iv.setVisibility(0);
                if ((mLocalUrl.type != null) && (mLocalUrl.type.equals(ImageItem.GIF))) {
                    paramImageView.setVisibility(0);
                    mLocalUrl.type = ImageItem.GIF;
                }
                addBeanToFinished(paramForumActivityStatus.getDefaultActivity(), paramForumRootAdapter, paramImageInThread, paramImageInThread.sourceUrl, paramParseableData, mLocalUrl.type, paramForumStatus);
                paramImageInThread.iv.forceDraw();
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

    public static void setBigImageOnClickListener(final Activity paramActivity, final ForumRootAdapter paramForumRootAdapter, final ImageInThread paramImageInThread, String paramString, final ParseableData paramParseableData, final ForumStatus paramForumStatus) {
        paramImageInThread.iv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                if ((AttachmentInfo.this != null) && (AttachmentInfo.this.contains("http://img.youtube.com/vi/"))) {
                    paramAnonymousView = AttachmentInfo.this.split("/");
                    localObject = "http://www.youtube.com/watch?v=" + paramAnonymousView[(paramAnonymousView.length - 2)];
                    if (((paramForumRootAdapter instanceof ThreadAdapter)) || ((paramForumRootAdapter instanceof BlogAdapter)) || ((paramForumRootAdapter instanceof ConvDetailAdapter))) {
                        localIntent = new Intent(paramActivity, YoutubeFullscreenActivity.class);
                        localIntent.putExtra("youtube_url", paramAnonymousView[(paramAnonymousView.length - 2)]);
                        localIntent.putExtra("url", (String) localObject);
                        paramActivity.startActivity(localIntent);
                    }
                }
                while ((!(paramForumRootAdapter instanceof ThreadAdapter)) && (!(paramForumRootAdapter instanceof ConvDetailAdapter)) && (!(paramForumRootAdapter instanceof PMContentAdapter)) && (!(paramForumRootAdapter instanceof BlogAdapter))) {
                    Intent localIntent;
                    return;
                }
                paramAnonymousView = new Intent(paramActivity, QuoordGalleryActivity.class);
                Object localObject = new ArrayList();
                Collections.sort(paramParseableData.getImageBeansFinished());
                int i = 0;
                for (; ; ) {
                    if (i >= paramParseableData.getImageBeansFinished().size()) {
                        paramAnonymousView.putExtra("data", (Serializable) localObject);
                        paramAnonymousView.putExtra("forumstatus", paramForumStatus);
                        paramAnonymousView.putExtra("position", paramImageInThread.position);
                        if ((paramParseableData instanceof PostData)) {
                            paramAnonymousView.putExtra("auther_name", ((PostData) paramParseableData).authorName);
                        }
                        if ((paramParseableData instanceof Blog)) {
                            paramAnonymousView.putExtra("auther_name", ((Blog) paramParseableData).getUser_name());
                        }
                        paramActivity.startActivity(paramAnonymousView);
                        return;
                    }
                    ((ArrayList) localObject).add(((ImageInThread) paramParseableData.getImageBeansFinished().get(i)).getLocalIconUri());
                    i += 1;
                }
            }
        });
    }

    private void setProgress(int paramInt, String paramString) {
        try {
            int i = paramInt * 100 / this.currentMax;
            if (this.currentCount < i) {
                this.currentCount = i;
                Message localMessage = new Message();
                localMessage.obj = Integer.valueOf(i);
                this.handler.sendMessage(localMessage);
                if (this.currentMax == paramInt) {
                    if (this.contentType.equalsIgnoreCase("image")) {
                        this.iconView.setImageBitmap(Util.getRemotePicSmall(paramString));
                        this.mimeType = this.currentMime;
                    }
                    if (!this.isDownloadCancel) {
                        this.isDownload = false;
                    }
                }
            }
            return;
        } catch (Exception paramString) {
            paramString.printStackTrace();
        }
    }

    @SuppressLint({"NewApi"})
    public void download(final Activity paramActivity, final ForumStatus paramForumStatus) {
        if (!Environment.getExternalStorageState().equals("mounted")) {
            Toast.makeText(paramActivity, paramActivity.getString(2131100169), 1).show();
            return;
        }
        if (paramForumStatus.getUrl().contains("rcgroups.com")) {
            this.url = this.url.replace("attachment.php", "attachmentNew.php");
        }
        final String str1 = this.name;
        final String str2 = this.url;
        new StringBuilder(String.valueOf(str2.hashCode())).append("-").append(this.name).toString();
        Object localObject = new File(SettingsFragment.getDownloadLocation(paramActivity));
        if (!((File) localObject).exists()) {
            ((File) localObject).mkdir();
        }
        this.isDownloadCancel = false;
        int j = str1.indexOf('.');
        int i = j;
        localObject = str1;
        if (j < 0) {
            localObject = str1 + ".UnknownType";
            i = ((String) localObject).indexOf('.');
        }
        str1 = ((String) localObject).substring(i + 1);
        localObject = ((String) localObject).substring(0, i);
        this.localUri = (SettingsFragment.getDownloadLocation(paramActivity) + File.separator + chooseUniqueFilename((String) localObject, str1));
        this.handler = new Handler() {
            public void handleMessage(Message paramAnonymousMessage) {
                int i = Integer.valueOf(paramAnonymousMessage.obj.toString()).intValue();
                AttachmentInfo.this.view.setProgressBar(2131230848, 100, i, false);
                AttachmentInfo.this.view.setTextViewText(2131230847, i + "%");
                AttachmentInfo.this.view.setTextViewText(2131230846, AttachmentInfo.this.name);
                Object localObject = BitmapFactory.decodeResource(paramActivity.getResources(), 2130837871);
                if (i == 100) {
                    AttachmentInfo.this.isDownload = true;
                    if (!AttachmentInfo.this.isDownload) {
                        AttachmentInfo.this.attachInfo.setText(AttachmentInfo.formatSize(AttachmentInfo.this.size));
                        if ((paramActivity instanceof ThreadActivity)) {
                            localObject = (ThreadActivity) paramActivity;
                            if ((((ThreadActivity) localObject).outerFragment.getCurrentFragment() != null) && (((ThreadActivity) localObject).outerFragment.getCurrentFragment().mThreadAdapter != null)) {
                                ((ThreadActivity) localObject).outerFragment.getCurrentFragment().mThreadAdapter.notifyDataSetChanged();
                            }
                        }
                        AttachmentInfo.this.currentCount = 0;
                        AttachmentInfo.this.manager.cancel(AttachmentInfo.this.name.hashCode());
                        localObject = new Notification(2130837871, "", System.currentTimeMillis());
                        ((Notification) localObject).setLatestEventInfo(paramActivity, AttachmentInfo.this.name, paramActivity.getString(2131100267), PendingIntent.getActivity(paramActivity, 0, AttachmentInfo.this.getIntent(paramActivity), 0));
                        ((Notification) localObject).flags = 16;
                        AttachmentInfo.this.manager.notify(AttachmentInfo.this.name.hashCode(), (Notification) localObject);
                    }
                }
                for (; ; ) {
                    super.handleMessage(paramAnonymousMessage);
                    return;
                    AttachmentInfo.this.attachInfo.setText("Saved " + AttachmentInfo.formatSize(AttachmentInfo.this.size));
                    break;
                    if (Build.VERSION.SDK_INT < 11) {
                        AttachmentInfo.this.notification.contentView = AttachmentInfo.this.view;
                        AttachmentInfo.this.notification.flags = 2;
                        AttachmentInfo.this.manager.notify(AttachmentInfo.this.name.hashCode(), AttachmentInfo.this.notification);
                    } else {
                        AttachmentInfo.this.builder.setContent(AttachmentInfo.this.view);
                        AttachmentInfo.this.builder.setLargeIcon((Bitmap) localObject);
                        AttachmentInfo.this.builder.setSmallIcon(2130837871);
                        AttachmentInfo.this.builder.setOngoing(true);
                        AttachmentInfo.this.manager.notify(AttachmentInfo.this.name.hashCode(), AttachmentInfo.this.builder.getNotification());
                    }
                }
            }
        };
        this.manager = ((NotificationManager) paramActivity.getSystemService("notification"));
        this.intent = PendingIntent.getActivity(paramActivity, 0, new Intent(), 0);
        if (Build.VERSION.SDK_INT < 11) {
            this.view = new RemoteViews(paramActivity.getPackageName(), 2130903066);
            this.view.setProgressBar(2131230848, 100, 0, false);
            this.view.setTextViewText(2131230847, "0%");
            this.view.setTextViewText(2131230846, this.name);
            this.notification = new Notification(2130837871, paramActivity.getText(2131100266), System.currentTimeMillis());
            this.notification.contentIntent = this.intent;
            this.notification.flags = 2;
            this.notification.setLatestEventInfo(paramActivity, this.name, "", this.intent);
            this.notification.contentView = this.view;
            this.manager.notify(this.name.hashCode(), this.notification);
        }
        for (; ; ) {
            this.thread = new Thread() {
                /* Error */
                public void run() {
                    // Byte code:
                    //   0: new 39	org/apache/http/conn/scheme/SchemeRegistry
                    //   3: dup
                    //   4: invokespecial 40	org/apache/http/conn/scheme/SchemeRegistry:<init>	()V
                    //   7: astore 8
                    //   9: invokestatic 46	java/security/KeyStore:getDefaultType	()Ljava/lang/String;
                    //   12: invokestatic 50	java/security/KeyStore:getInstance	(Ljava/lang/String;)Ljava/security/KeyStore;
                    //   15: astore 9
                    //   17: aload 9
                    //   19: aconst_null
                    //   20: aconst_null
                    //   21: invokevirtual 54	java/security/KeyStore:load	(Ljava/io/InputStream;[C)V
                    //   24: new 56	com/quoord/tapatalkpro/util/MySSLSocketFactory
                    //   27: dup
                    //   28: aload 9
                    //   30: invokespecial 59	com/quoord/tapatalkpro/util/MySSLSocketFactory:<init>	(Ljava/security/KeyStore;)V
                    //   33: astore 9
                    //   35: aload 9
                    //   37: getstatic 65	org/apache/http/conn/ssl/SSLSocketFactory:ALLOW_ALL_HOSTNAME_VERIFIER	Lorg/apache/http/conn/ssl/X509HostnameVerifier;
                    //   40: invokevirtual 69	org/apache/http/conn/ssl/SSLSocketFactory:setHostnameVerifier	(Lorg/apache/http/conn/ssl/X509HostnameVerifier;)V
                    //   43: aload 8
                    //   45: new 71	org/apache/http/conn/scheme/Scheme
                    //   48: dup
                    //   49: ldc 73
                    //   51: aload 9
                    //   53: sipush 443
                    //   56: invokespecial 76	org/apache/http/conn/scheme/Scheme:<init>	(Ljava/lang/String;Lorg/apache/http/conn/scheme/SocketFactory;I)V
                    //   59: invokevirtual 80	org/apache/http/conn/scheme/SchemeRegistry:register	(Lorg/apache/http/conn/scheme/Scheme;)Lorg/apache/http/conn/scheme/Scheme;
                    //   62: pop
                    //   63: new 82	org/apache/http/params/BasicHttpParams
                    //   66: dup
                    //   67: invokespecial 83	org/apache/http/params/BasicHttpParams:<init>	()V
                    //   70: astore 9
                    //   72: aload 9
                    //   74: getstatic 89	org/apache/http/HttpVersion:HTTP_1_1	Lorg/apache/http/HttpVersion;
                    //   77: invokestatic 95	org/apache/http/params/HttpProtocolParams:setVersion	(Lorg/apache/http/params/HttpParams;Lorg/apache/http/ProtocolVersion;)V
                    //   80: aload 9
                    //   82: ldc 97
                    //   84: invokestatic 101	org/apache/http/params/HttpProtocolParams:setContentCharset	(Lorg/apache/http/params/HttpParams;Ljava/lang/String;)V
                    //   87: aload 8
                    //   89: new 71	org/apache/http/conn/scheme/Scheme
                    //   92: dup
                    //   93: ldc 103
                    //   95: invokestatic 109	org/apache/http/conn/scheme/PlainSocketFactory:getSocketFactory	()Lorg/apache/http/conn/scheme/PlainSocketFactory;
                    //   98: bipush 80
                    //   100: invokespecial 76	org/apache/http/conn/scheme/Scheme:<init>	(Ljava/lang/String;Lorg/apache/http/conn/scheme/SocketFactory;I)V
                    //   103: invokevirtual 80	org/apache/http/conn/scheme/SchemeRegistry:register	(Lorg/apache/http/conn/scheme/Scheme;)Lorg/apache/http/conn/scheme/Scheme;
                    //   106: pop
                    //   107: new 111	org/apache/http/impl/client/DefaultHttpClient
                    //   110: dup
                    //   111: new 113	org/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager
                    //   114: dup
                    //   115: aload 9
                    //   117: aload 8
                    //   119: invokespecial 116	org/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager:<init>	(Lorg/apache/http/params/HttpParams;Lorg/apache/http/conn/scheme/SchemeRegistry;)V
                    //   122: aload 9
                    //   124: invokespecial 119	org/apache/http/impl/client/DefaultHttpClient:<init>	(Lorg/apache/http/conn/ClientConnectionManager;Lorg/apache/http/params/HttpParams;)V
                    //   127: astore 8
                    //   129: new 121	org/apache/http/client/methods/HttpGet
                    //   132: dup
                    //   133: aload_0
                    //   134: getfield 24	com/quoord/tapatalkpro/bean/AttachmentInfo$2:val$newUrl	Ljava/lang/String;
                    //   137: invokespecial 124	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
                    //   140: astore 9
                    //   142: aload_0
                    //   143: getfield 26	com/quoord/tapatalkpro/bean/AttachmentInfo$2:val$forumStatus	Lcom/quoord/tapatalkpro/bean/ForumStatus;
                    //   146: invokevirtual 129	com/quoord/tapatalkpro/bean/ForumStatus:getUrl	()Ljava/lang/String;
                    //   149: invokestatic 135	com/quoord/tapatalkpro/util/Util:getHost	(Ljava/lang/String;)Ljava/lang/String;
                    //   152: aload_0
                    //   153: getfield 24	com/quoord/tapatalkpro/bean/AttachmentInfo$2:val$newUrl	Ljava/lang/String;
                    //   156: invokestatic 135	com/quoord/tapatalkpro/util/Util:getHost	(Ljava/lang/String;)Ljava/lang/String;
                    //   159: invokevirtual 141	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
                    //   162: ifeq +17 -> 179
                    //   165: aload 9
                    //   167: ldc -113
                    //   169: aload_0
                    //   170: getfield 26	com/quoord/tapatalkpro/bean/AttachmentInfo$2:val$forumStatus	Lcom/quoord/tapatalkpro/bean/ForumStatus;
                    //   173: invokevirtual 146	com/quoord/tapatalkpro/bean/ForumStatus:getCookie	()Ljava/lang/String;
                    //   176: invokevirtual 150	org/apache/http/client/methods/HttpGet:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
                    //   179: aload 9
                    //   181: ldc -104
                    //   183: aload_0
                    //   184: getfield 26	com/quoord/tapatalkpro/bean/AttachmentInfo$2:val$forumStatus	Lcom/quoord/tapatalkpro/bean/ForumStatus;
                    //   187: invokevirtual 129	com/quoord/tapatalkpro/bean/ForumStatus:getUrl	()Ljava/lang/String;
                    //   190: invokestatic 155	com/quoord/tapatalkpro/util/Util:getRefer	(Ljava/lang/String;)Ljava/lang/String;
                    //   193: invokevirtual 150	org/apache/http/client/methods/HttpGet:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
                    //   196: aload_0
                    //   197: getfield 28	com/quoord/tapatalkpro/bean/AttachmentInfo$2:val$mContext	Landroid/app/Activity;
                    //   200: aload 9
                    //   202: aload_0
                    //   203: getfield 26	com/quoord/tapatalkpro/bean/AttachmentInfo$2:val$forumStatus	Lcom/quoord/tapatalkpro/bean/ForumStatus;
                    //   206: invokestatic 161	com/quoord/tapatalkpro/util/UserAgent:setHTTPGetHeader	(Landroid/content/Context;Lorg/apache/http/client/methods/HttpGet;Lcom/quoord/tapatalkpro/bean/ForumStatus;)V
                    //   209: aload 8
                    //   211: aload 9
                    //   213: invokeinterface 167 2 0
                    //   218: invokeinterface 173 1 0
                    //   223: astore 11
                    //   225: aload 11
                    //   227: invokeinterface 179 1 0
                    //   232: lstore 5
                    //   234: aload 11
                    //   236: invokeinterface 183 1 0
                    //   241: invokeinterface 188 1 0
                    //   246: astore 9
                    //   248: aload 9
                    //   250: ldc -66
                    //   252: invokevirtual 141	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
                    //   255: ifne +17 -> 272
                    //   258: aload 9
                    //   260: astore 8
                    //   262: aload 9
                    //   264: ldc -64
                    //   266: invokevirtual 141	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
                    //   269: ifeq +28 -> 297
                    //   272: invokestatic 198	android/webkit/MimeTypeMap:getSingleton	()Landroid/webkit/MimeTypeMap;
                    //   275: aload_0
                    //   276: getfield 30	com/quoord/tapatalkpro/bean/AttachmentInfo$2:val$extension	Ljava/lang/String;
                    //   279: invokevirtual 201	android/webkit/MimeTypeMap:getMimeTypeFromExtension	(Ljava/lang/String;)Ljava/lang/String;
                    //   282: astore 10
                    //   284: aload 9
                    //   286: astore 8
                    //   288: aload 10
                    //   290: ifnull +7 -> 297
                    //   293: aload 10
                    //   295: astore 8
                    //   297: aload_0
                    //   298: getfield 22	com/quoord/tapatalkpro/bean/AttachmentInfo$2:this$0	Lcom/quoord/tapatalkpro/bean/AttachmentInfo;
                    //   301: aload 8
                    //   303: invokestatic 205	com/quoord/tapatalkpro/bean/AttachmentInfo:access$8	(Lcom/quoord/tapatalkpro/bean/AttachmentInfo;Ljava/lang/String;)V
                    //   306: lload 5
                    //   308: lstore_3
                    //   309: lload 5
                    //   311: lconst_0
                    //   312: lcmp
                    //   313: ifgt +11 -> 324
                    //   316: aload_0
                    //   317: getfield 22	com/quoord/tapatalkpro/bean/AttachmentInfo$2:this$0	Lcom/quoord/tapatalkpro/bean/AttachmentInfo;
                    //   320: getfield 209	com/quoord/tapatalkpro/bean/AttachmentInfo:size	J
                    //   323: lstore_3
                    //   324: aload 11
                    //   326: invokeinterface 213 1 0
                    //   331: astore 10
                    //   333: aconst_null
                    //   334: astore 9
                    //   336: aload 10
                    //   338: ifnull +108 -> 446
                    //   341: new 215	java/io/File
                    //   344: dup
                    //   345: aload_0
                    //   346: getfield 22	com/quoord/tapatalkpro/bean/AttachmentInfo$2:this$0	Lcom/quoord/tapatalkpro/bean/AttachmentInfo;
                    //   349: getfield 218	com/quoord/tapatalkpro/bean/AttachmentInfo:localUri	Ljava/lang/String;
                    //   352: invokespecial 219	java/io/File:<init>	(Ljava/lang/String;)V
                    //   355: astore 11
                    //   357: new 221	java/io/FileOutputStream
                    //   360: dup
                    //   361: aload 11
                    //   363: invokespecial 224	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
                    //   366: astore 9
                    //   368: sipush 1024
                    //   371: newarray <illegal type>
                    //   373: astore 12
                    //   375: iconst_0
                    //   376: istore_1
                    //   377: aload_0
                    //   378: getfield 22	com/quoord/tapatalkpro/bean/AttachmentInfo$2:this$0	Lcom/quoord/tapatalkpro/bean/AttachmentInfo;
                    //   381: lload_3
                    //   382: l2i
                    //   383: invokestatic 228	com/quoord/tapatalkpro/bean/AttachmentInfo:access$9	(Lcom/quoord/tapatalkpro/bean/AttachmentInfo;I)V
                    //   386: aload 10
                    //   388: aload 12
                    //   390: invokevirtual 234	java/io/InputStream:read	([B)I
                    //   393: istore_2
                    //   394: iload_2
                    //   395: iconst_m1
                    //   396: if_icmpeq +13 -> 409
                    //   399: aload_0
                    //   400: getfield 22	com/quoord/tapatalkpro/bean/AttachmentInfo$2:this$0	Lcom/quoord/tapatalkpro/bean/AttachmentInfo;
                    //   403: getfield 238	com/quoord/tapatalkpro/bean/AttachmentInfo:isDownloadCancel	Z
                    //   406: ifeq +66 -> 472
                    //   409: aload_0
                    //   410: getfield 22	com/quoord/tapatalkpro/bean/AttachmentInfo$2:this$0	Lcom/quoord/tapatalkpro/bean/AttachmentInfo;
                    //   413: getfield 238	com/quoord/tapatalkpro/bean/AttachmentInfo:isDownloadCancel	Z
                    //   416: istore 7
                    //   418: iload 7
                    //   420: ifne +207 -> 627
                    //   423: new 240	com/quoord/tapatalkpro/bean/AttachmentInfo$MediaScannerNotifier
                    //   426: dup
                    //   427: aload_0
                    //   428: getfield 28	com/quoord/tapatalkpro/bean/AttachmentInfo$2:val$mContext	Landroid/app/Activity;
                    //   431: aload 11
                    //   433: invokevirtual 243	java/io/File:getAbsolutePath	()Ljava/lang/String;
                    //   436: aload 8
                    //   438: aload_0
                    //   439: getfield 22	com/quoord/tapatalkpro/bean/AttachmentInfo$2:this$0	Lcom/quoord/tapatalkpro/bean/AttachmentInfo;
                    //   442: invokespecial 246	com/quoord/tapatalkpro/bean/AttachmentInfo$MediaScannerNotifier:<init>	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/quoord/tapatalkpro/bean/AttachmentInfo;)V
                    //   445: pop
                    //   446: aload 9
                    //   448: invokevirtual 249	java/io/FileOutputStream:flush	()V
                    //   451: aload 9
                    //   453: ifnull +8 -> 461
                    //   456: aload 9
                    //   458: invokevirtual 252	java/io/FileOutputStream:close	()V
                    //   461: return
                    //   462: astore 9
                    //   464: aload 9
                    //   466: invokevirtual 255	java/lang/Exception:printStackTrace	()V
                    //   469: goto -406 -> 63
                    //   472: aload 9
                    //   474: aload 12
                    //   476: iconst_0
                    //   477: iload_2
                    //   478: invokevirtual 259	java/io/FileOutputStream:write	([BII)V
                    //   481: iload_1
                    //   482: iload_2
                    //   483: iadd
                    //   484: istore_1
                    //   485: aload_0
                    //   486: getfield 22	com/quoord/tapatalkpro/bean/AttachmentInfo$2:this$0	Lcom/quoord/tapatalkpro/bean/AttachmentInfo;
                    //   489: iload_1
                    //   490: aload_0
                    //   491: getfield 22	com/quoord/tapatalkpro/bean/AttachmentInfo$2:this$0	Lcom/quoord/tapatalkpro/bean/AttachmentInfo;
                    //   494: getfield 218	com/quoord/tapatalkpro/bean/AttachmentInfo:localUri	Ljava/lang/String;
                    //   497: invokestatic 263	com/quoord/tapatalkpro/bean/AttachmentInfo:access$10	(Lcom/quoord/tapatalkpro/bean/AttachmentInfo;ILjava/lang/String;)V
                    //   500: goto -114 -> 386
                    //   503: astore 8
                    //   505: aload_0
                    //   506: getfield 22	com/quoord/tapatalkpro/bean/AttachmentInfo$2:this$0	Lcom/quoord/tapatalkpro/bean/AttachmentInfo;
                    //   509: invokestatic 267	com/quoord/tapatalkpro/bean/AttachmentInfo:access$5	(Lcom/quoord/tapatalkpro/bean/AttachmentInfo;)Landroid/app/NotificationManager;
                    //   512: aload_0
                    //   513: getfield 22	com/quoord/tapatalkpro/bean/AttachmentInfo$2:this$0	Lcom/quoord/tapatalkpro/bean/AttachmentInfo;
                    //   516: getfield 270	com/quoord/tapatalkpro/bean/AttachmentInfo:name	Ljava/lang/String;
                    //   519: invokevirtual 274	java/lang/String:hashCode	()I
                    //   522: invokevirtual 280	android/app/NotificationManager:cancel	(I)V
                    //   525: new 282	android/app/Notification
                    //   528: dup
                    //   529: ldc_w 283
                    //   532: aload_0
                    //   533: getfield 28	com/quoord/tapatalkpro/bean/AttachmentInfo$2:val$mContext	Landroid/app/Activity;
                    //   536: ldc_w 284
                    //   539: invokevirtual 290	android/app/Activity:getString	(I)Ljava/lang/String;
                    //   542: invokestatic 295	java/lang/System:currentTimeMillis	()J
                    //   545: invokespecial 298	android/app/Notification:<init>	(ILjava/lang/CharSequence;J)V
                    //   548: astore 9
                    //   550: aload 9
                    //   552: aload_0
                    //   553: getfield 28	com/quoord/tapatalkpro/bean/AttachmentInfo$2:val$mContext	Landroid/app/Activity;
                    //   556: aload_0
                    //   557: getfield 22	com/quoord/tapatalkpro/bean/AttachmentInfo$2:this$0	Lcom/quoord/tapatalkpro/bean/AttachmentInfo;
                    //   560: getfield 270	com/quoord/tapatalkpro/bean/AttachmentInfo:name	Ljava/lang/String;
                    //   563: aload_0
                    //   564: getfield 28	com/quoord/tapatalkpro/bean/AttachmentInfo$2:val$mContext	Landroid/app/Activity;
                    //   567: ldc_w 284
                    //   570: invokevirtual 290	android/app/Activity:getString	(I)Ljava/lang/String;
                    //   573: aload_0
                    //   574: getfield 28	com/quoord/tapatalkpro/bean/AttachmentInfo$2:val$mContext	Landroid/app/Activity;
                    //   577: iconst_0
                    //   578: new 300	android/content/Intent
                    //   581: dup
                    //   582: invokespecial 301	android/content/Intent:<init>	()V
                    //   585: iconst_0
                    //   586: invokestatic 307	android/app/PendingIntent:getActivity	(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;
                    //   589: invokevirtual 311	android/app/Notification:setLatestEventInfo	(Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Landroid/app/PendingIntent;)V
                    //   592: aload 9
                    //   594: bipush 16
                    //   596: putfield 315	android/app/Notification:flags	I
                    //   599: aload_0
                    //   600: getfield 22	com/quoord/tapatalkpro/bean/AttachmentInfo$2:this$0	Lcom/quoord/tapatalkpro/bean/AttachmentInfo;
                    //   603: invokestatic 267	com/quoord/tapatalkpro/bean/AttachmentInfo:access$5	(Lcom/quoord/tapatalkpro/bean/AttachmentInfo;)Landroid/app/NotificationManager;
                    //   606: aload_0
                    //   607: getfield 22	com/quoord/tapatalkpro/bean/AttachmentInfo$2:this$0	Lcom/quoord/tapatalkpro/bean/AttachmentInfo;
                    //   610: getfield 270	com/quoord/tapatalkpro/bean/AttachmentInfo:name	Ljava/lang/String;
                    //   613: invokevirtual 274	java/lang/String:hashCode	()I
                    //   616: aload 9
                    //   618: invokevirtual 319	android/app/NotificationManager:notify	(ILandroid/app/Notification;)V
                    //   621: aload 8
                    //   623: invokevirtual 255	java/lang/Exception:printStackTrace	()V
                    //   626: return
                    //   627: aload_0
                    //   628: getfield 22	com/quoord/tapatalkpro/bean/AttachmentInfo$2:this$0	Lcom/quoord/tapatalkpro/bean/AttachmentInfo;
                    //   631: aload_0
                    //   632: getfield 22	com/quoord/tapatalkpro/bean/AttachmentInfo$2:this$0	Lcom/quoord/tapatalkpro/bean/AttachmentInfo;
                    //   635: invokestatic 323	com/quoord/tapatalkpro/bean/AttachmentInfo:access$11	(Lcom/quoord/tapatalkpro/bean/AttachmentInfo;)I
                    //   638: aload_0
                    //   639: getfield 22	com/quoord/tapatalkpro/bean/AttachmentInfo$2:this$0	Lcom/quoord/tapatalkpro/bean/AttachmentInfo;
                    //   642: getfield 218	com/quoord/tapatalkpro/bean/AttachmentInfo:localUri	Ljava/lang/String;
                    //   645: invokestatic 263	com/quoord/tapatalkpro/bean/AttachmentInfo:access$10	(Lcom/quoord/tapatalkpro/bean/AttachmentInfo;ILjava/lang/String;)V
                    //   648: goto -202 -> 446
                    //   651: astore 8
                    //   653: goto -207 -> 446
                    // Local variable table:
                    //   start	length	slot	name	signature
                    //   0	656	0	this	2
                    //   376	114	1	i	int
                    //   393	91	2	j	int
                    //   308	74	3	l1	long
                    //   232	78	5	l2	long
                    //   416	3	7	bool	boolean
                    //   7	430	8	localObject1	Object
                    //   503	119	8	localException1	Exception
                    //   651	1	8	localException2	Exception
                    //   15	442	9	localObject2	Object
                    //   462	11	9	localException3	Exception
                    //   548	69	9	localNotification	Notification
                    //   282	105	10	localObject3	Object
                    //   223	209	11	localObject4	Object
                    //   373	102	12	arrayOfByte	byte[]
                    // Exception table:
                    //   from	to	target	type
                    //   9	63	462	java/lang/Exception
                    //   209	258	503	java/lang/Exception
                    //   262	272	503	java/lang/Exception
                    //   272	284	503	java/lang/Exception
                    //   297	306	503	java/lang/Exception
                    //   316	324	503	java/lang/Exception
                    //   324	333	503	java/lang/Exception
                    //   341	375	503	java/lang/Exception
                    //   377	386	503	java/lang/Exception
                    //   386	394	503	java/lang/Exception
                    //   399	409	503	java/lang/Exception
                    //   409	418	503	java/lang/Exception
                    //   446	451	503	java/lang/Exception
                    //   456	461	503	java/lang/Exception
                    //   472	481	503	java/lang/Exception
                    //   485	500	503	java/lang/Exception
                    //   627	648	503	java/lang/Exception
                    //   423	446	651	java/lang/Exception
                }
            };
            this.thread.start();
            return;
            this.view = new RemoteViews(paramActivity.getPackageName(), 2130903067);
            this.view.setProgressBar(2131230848, 100, 0, false);
            this.view.setTextViewText(2131230847, "0%");
            this.view.setTextViewText(2131230846, this.name);
            this.builder = new Notification.Builder(paramActivity);
            this.builder.setOngoing(true);
            this.builder.setContent(this.view);
            localObject = BitmapFactory.decodeResource(paramActivity.getResources(), 2130837871);
            this.builder.setLargeIcon((Bitmap) localObject);
            this.builder.setSmallIcon(2130837871);
            this.builder.setTicker(paramActivity.getText(2131100266));
            this.manager.notify(this.name.hashCode(), this.builder.getNotification());
        }
    }

    public Intent getIntent(Activity paramActivity) {
        File localFile = new File(this.localUri);
        Object localObject = getMIMEType(localFile);
        if (this.localUri.toLowerCase().endsWith(".apk")) {
            localObject = new Intent("android.intent.action.VIEW");
            ((Intent) localObject).setDataAndType(Uri.fromFile(localFile), "application/vnd.android.package-archive");
            paramActivity.startActivity((Intent) localObject);
            return (Intent) localObject;
        }
        paramActivity = new Intent("android.intent.action.VIEW");
        paramActivity.setDataAndType(Uri.fromFile(localFile), (String) localObject);
        return paramActivity;
    }

    public String getUploadType(String paramString) {
        String str = "";
        int i = 0;
        for (; ; ) {
            if (i >= this.MIME_MapTable.length) {
                return str;
            }
            if (this.MIME_MapTable[i][0].endsWith(paramString)) {
                str = this.MIME_MapTable[i][1];
            }
            i += 1;
        }
    }

    public void setViewBtn(Activity paramActivity) {
        if (this.localUri == null) {
            this.localUri = (SettingsFragment.getDownloadLocation(paramActivity) + File.separator + this.name);
        }
        File localFile;
        Object localObject;
        if (this.isDownload) {
            localFile = new File(this.localUri);
            localObject = getMIMEType(localFile);
            if (this.localUri.toLowerCase().endsWith(".apk")) {
                localObject = new Intent("android.intent.action.VIEW");
                ((Intent) localObject).setDataAndType(Uri.fromFile(localFile), "application/vnd.android.package-archive");
                paramActivity.startActivity((Intent) localObject);
            }
        } else {
            return;
        }
        Intent localIntent = new Intent("android.intent.action.VIEW");
        localIntent.setDataAndType(Uri.fromFile(localFile), (String) localObject);
        try {
            paramActivity.startActivity(localIntent);
            return;
        } catch (Exception localException) {
            Toast.makeText(paramActivity, paramActivity.getString(2131099942), 1).show();
        }
    }

    private static class MediaScannerNotifier
            implements MediaScannerConnection.MediaScannerConnectionClient {
        private MediaScannerConnection mConnection;
        private AttachmentInfo mInfo;
        private String mMimeType;
        private String mPath;

        public MediaScannerNotifier(Context paramContext, String paramString1, String paramString2, AttachmentInfo paramAttachmentInfo) {
            this.mPath = paramString1;
            this.mInfo = paramAttachmentInfo;
            this.mMimeType = paramString2;
            this.mConnection = new MediaScannerConnection(paramContext, this);
            this.mConnection.connect();
        }

        public void onMediaScannerConnected() {
            this.mConnection.scanFile(this.mPath, this.mMimeType);
        }

        public void onScanCompleted(String paramString, Uri paramUri) {
            if (paramUri != null) {
            }
            try {
                this.mInfo.scanUri = paramUri;
                return;
            } finally {
                this.mConnection.disconnect();
            }
        }
    }

    private static class Mycomparator
            implements Comparator<Object> {
        public int compare(Object paramObject1, Object paramObject2) {
            return ((HashMap) paramObject1).get("content_type").toString().compareTo(((HashMap) paramObject2).get("content_type").toString());
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/bean/AttachmentInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */