package com.quoord.tapatalkpro.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.widget.Toast;
import com.quoord.tapatalkpro.action.directory.UploadVimeoAction;
import com.quoord.tapatalkpro.action.directory.UploadVimeoAction.UploadVimeoActionActionCallBack;
import com.quoord.tapatalkpro.activity.forum.CreateTopicActivity;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.adapter.forum.AttachDialogHelperAdapter;
import com.quoord.tapatalkpro.adapter.forum.NewPostAdapter;
import com.quoord.tapatalkpro.adapter.forum.UploadAdapter;
import com.quoord.tapatalkpro.adapter.forum.VideoAndPhotoDialogHelperAdapter;
import com.quoord.tapatalkpro.bean.AttachmentInfo;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.bean.UploadImageInfo;
import com.quoord.tapatalkpro.bean.UploadVimeoTicket;
import com.quoord.tapatalkpro.ics.tapatalkid.SignInWithOtherUtil;
import com.quoord.tools.net.JSONUtil;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.json.JSONException;
import org.json.JSONObject;

public class UploadAttachmentTool {
    static String CRLF;
    public static int GALLERY = 4;
    public static int UPDATEUPLOADPROGRESS = 3;
    public static int VIMEO = 10;
    public static final int VIMEO_FROM_CAMERA = 1;
    public static final int VIMEO_FROM_LOCAL = 2;
    static String boundary = "*****mgd*****";
    static String twoHyphens;
    final HostnameVerifier DO_NOT_VERIFY = new HostnameVerifier() {
        public boolean verify(String paramAnonymousString, SSLSession paramAnonymousSSLSession) {
            return true;
        }
    };
    private AttachmentInfo achInfo;
    private AlertDialog alert;
    private DataOutputStream dataStream = null;
    private String fid;
    private String filename;
    private ForumActivityStatus forumActivityStatus;
    private ForumStatus forumStatus;
    private String id;
    private String imageName;
    private InputStream inputStream;
    private Activity mActivity;
    public UploadAdapter mAdapter;
    private int mSize;
    private String mimeType;
    private Uri photoUri;
    private String postId;
    private ProgressDialog progressDialog;
    private boolean stopThread = false;
    private Thread thread;
    private String ticketId;
    private String topicId;
    private String uid;
    private Uri uploadFilePath;
    private UploadVimeoAction uploadVimeoAction;
    private UploadVimeoTicket uploadVimeoTicket;
    private String vimeoId;

    static {
        CRLF = "\r\n";
        twoHyphens = "--";
    }

    public UploadAttachmentTool(Activity paramActivity, ForumStatus paramForumStatus, ForumActivityStatus paramForumActivityStatus, String paramString1, String paramString2) {
        this.mActivity = paramActivity;
        this.forumStatus = paramForumStatus;
        this.forumActivityStatus = paramForumActivityStatus;
        this.postId = paramString1;
        this.topicId = paramString2;
        initData();
    }

    private String getResponse(HttpURLConnection paramHttpURLConnection) {
        try {
            DataInputStream localDataInputStream = new DataInputStream(paramHttpURLConnection.getInputStream());
            byte[] arrayOfByte = new byte['Ѐ'];
            paramHttpURLConnection.getResponseMessage();
            int i = localDataInputStream.read(arrayOfByte, 0, 1024);
            localDataInputStream.close();
            if (i > 0) {
                paramHttpURLConnection = new String(arrayOfByte, 0, i);
                return paramHttpURLConnection;
            }
            return "";
        } catch (Exception paramHttpURLConnection) {
            paramHttpURLConnection.printStackTrace();
            System.out.println(" biffed it getting HTTPResponse");
        }
        return "";
    }

    public static UploadImageInfo getUploadImageInfo(String paramString) {
        UploadImageInfo localUploadImageInfo = new UploadImageInfo();
        try {
            paramString = new JSONUtil(new JSONObject(paramString));
            localUploadImageInfo.setResult(paramString.optInteger("result").intValue());
            localUploadImageInfo.setResult_text(paramString.optString("result_text"));
            localUploadImageInfo.setId(paramString.optString("id"));
            localUploadImageInfo.setUrl(paramString.optString("url"));
            localUploadImageInfo.setThumbnail_url(paramString.optString("thumbnail_url"));
            return localUploadImageInfo;
        } catch (JSONException paramString) {
            paramString.printStackTrace();
        }
        return localUploadImageInfo;
    }

    private void trustAllHosts() {
        X509TrustManager local8 = new X509TrustManager() {
            public void checkClientTrusted(X509Certificate[] paramAnonymousArrayOfX509Certificate, String paramAnonymousString)
                    throws CertificateException {
            }

            public void checkServerTrusted(X509Certificate[] paramAnonymousArrayOfX509Certificate, String paramAnonymousString)
                    throws CertificateException {
            }

            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        };
        try {
            SSLContext localSSLContext = SSLContext.getInstance("TLS");
            SecureRandom localSecureRandom = new SecureRandom();
            localSSLContext.init(null, new TrustManager[]{local8}, localSecureRandom);
            HttpsURLConnection.setDefaultSSLSocketFactory(localSSLContext.getSocketFactory());
            return;
        } catch (Exception localException) {
            localException.printStackTrace();
        }
    }

    public void bindVimeo() {
        if (this.vimeoId != null) {
            this.uploadVimeoAction.bindVimeo(new UploadVimeoAction.UploadVimeoActionActionCallBack() {
                public void actionCallBack(UploadVimeoTicket paramAnonymousUploadVimeoTicket) {
                }
            }, this.vimeoId, this.topicId, this.postId, this.filename);
        }
    }

    /* Error */
    public void getFileInfo() {
        // Byte code:
        //   0: aload_0
        //   1: getfield 121	com/quoord/tapatalkpro/util/UploadAttachmentTool:mActivity	Landroid/app/Activity;
        //   4: invokevirtual 322	android/app/Activity:getContentResolver	()Landroid/content/ContentResolver;
        //   7: aload_0
        //   8: getfield 324	com/quoord/tapatalkpro/util/UploadAttachmentTool:photoUri	Landroid/net/Uri;
        //   11: iconst_3
        //   12: anewarray 193	java/lang/String
        //   15: dup
        //   16: iconst_0
        //   17: ldc_w 326
        //   20: aastore
        //   21: dup
        //   22: iconst_1
        //   23: ldc_w 328
        //   26: aastore
        //   27: dup
        //   28: iconst_2
        //   29: ldc_w 330
        //   32: aastore
        //   33: aconst_null
        //   34: aconst_null
        //   35: aconst_null
        //   36: invokevirtual 336	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //   39: astore_1
        //   40: aload_1
        //   41: ifnull +52 -> 93
        //   44: aload_1
        //   45: invokeinterface 342 1 0
        //   50: ifeq +43 -> 93
        //   53: aload_0
        //   54: aload_1
        //   55: iconst_0
        //   56: invokeinterface 346 2 0
        //   61: putfield 348	com/quoord/tapatalkpro/util/UploadAttachmentTool:mimeType	Ljava/lang/String;
        //   64: aload_0
        //   65: aload_1
        //   66: iconst_1
        //   67: invokeinterface 346 2 0
        //   72: putfield 350	com/quoord/tapatalkpro/util/UploadAttachmentTool:imageName	Ljava/lang/String;
        //   75: aload_0
        //   76: aload_1
        //   77: iconst_2
        //   78: invokeinterface 354 2 0
        //   83: putfield 356	com/quoord/tapatalkpro/util/UploadAttachmentTool:mSize	I
        //   86: aload_1
        //   87: invokeinterface 357 1 0
        //   92: return
        //   93: aconst_null
        //   94: astore 4
        //   96: aconst_null
        //   97: astore 5
        //   99: aconst_null
        //   100: astore_3
        //   101: aload 5
        //   103: astore_1
        //   104: aload_0
        //   105: aload_0
        //   106: getfield 324	com/quoord/tapatalkpro/util/UploadAttachmentTool:photoUri	Landroid/net/Uri;
        //   109: invokevirtual 362	android/net/Uri:toString	()Ljava/lang/String;
        //   112: putfield 350	com/quoord/tapatalkpro/util/UploadAttachmentTool:imageName	Ljava/lang/String;
        //   115: aload 5
        //   117: astore_1
        //   118: aload_0
        //   119: getfield 350	com/quoord/tapatalkpro/util/UploadAttachmentTool:imageName	Ljava/lang/String;
        //   122: ldc_w 364
        //   125: invokevirtual 368	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
        //   128: ifeq +41 -> 169
        //   131: aload 5
        //   133: astore_1
        //   134: aload_0
        //   135: aload_0
        //   136: getfield 370	com/quoord/tapatalkpro/util/UploadAttachmentTool:achInfo	Lcom/quoord/tapatalkpro/bean/AttachmentInfo;
        //   139: aload_0
        //   140: getfield 350	com/quoord/tapatalkpro/util/UploadAttachmentTool:imageName	Ljava/lang/String;
        //   143: ldc_w 372
        //   146: invokevirtual 376	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
        //   149: aload_0
        //   150: getfield 350	com/quoord/tapatalkpro/util/UploadAttachmentTool:imageName	Ljava/lang/String;
        //   153: ldc_w 372
        //   156: invokevirtual 376	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
        //   159: arraylength
        //   160: iconst_1
        //   161: isub
        //   162: aaload
        //   163: invokevirtual 381	com/quoord/tapatalkpro/bean/AttachmentInfo:getUploadType	(Ljava/lang/String;)Ljava/lang/String;
        //   166: putfield 348	com/quoord/tapatalkpro/util/UploadAttachmentTool:mimeType	Ljava/lang/String;
        //   169: aload 5
        //   171: astore_1
        //   172: new 383	java/lang/StringBuilder
        //   175: dup
        //   176: invokespecial 384	java/lang/StringBuilder:<init>	()V
        //   179: invokestatic 390	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
        //   182: invokevirtual 394	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   185: ldc_w 396
        //   188: invokevirtual 399	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   191: invokevirtual 400	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   194: astore_2
        //   195: aload 5
        //   197: astore_1
        //   198: aload_0
        //   199: getfield 350	com/quoord/tapatalkpro/util/UploadAttachmentTool:imageName	Ljava/lang/String;
        //   202: aload_2
        //   203: invokevirtual 368	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
        //   206: ifeq +134 -> 340
        //   209: aload 5
        //   211: astore_1
        //   212: aload_0
        //   213: aload_0
        //   214: getfield 350	com/quoord/tapatalkpro/util/UploadAttachmentTool:imageName	Ljava/lang/String;
        //   217: aload_2
        //   218: invokevirtual 376	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
        //   221: iconst_1
        //   222: aaload
        //   223: putfield 350	com/quoord/tapatalkpro/util/UploadAttachmentTool:imageName	Ljava/lang/String;
        //   226: aload 5
        //   228: astore_1
        //   229: new 402	java/io/File
        //   232: dup
        //   233: new 383	java/lang/StringBuilder
        //   236: dup
        //   237: aload_2
        //   238: invokestatic 406	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
        //   241: invokespecial 407	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   244: aload_0
        //   245: getfield 350	com/quoord/tapatalkpro/util/UploadAttachmentTool:imageName	Ljava/lang/String;
        //   248: invokevirtual 399	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   251: invokevirtual 400	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   254: invokespecial 408	java/io/File:<init>	(Ljava/lang/String;)V
        //   257: astore_2
        //   258: aload 5
        //   260: astore_1
        //   261: aload_0
        //   262: getfield 350	com/quoord/tapatalkpro/util/UploadAttachmentTool:imageName	Ljava/lang/String;
        //   265: ldc_w 396
        //   268: invokevirtual 368	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
        //   271: ifeq +34 -> 305
        //   274: aload 5
        //   276: astore_1
        //   277: aload_0
        //   278: aload_0
        //   279: getfield 350	com/quoord/tapatalkpro/util/UploadAttachmentTool:imageName	Ljava/lang/String;
        //   282: ldc_w 410
        //   285: invokevirtual 376	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
        //   288: aload_0
        //   289: getfield 350	com/quoord/tapatalkpro/util/UploadAttachmentTool:imageName	Ljava/lang/String;
        //   292: ldc_w 410
        //   295: invokevirtual 376	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
        //   298: arraylength
        //   299: iconst_1
        //   300: isub
        //   301: aaload
        //   302: putfield 350	com/quoord/tapatalkpro/util/UploadAttachmentTool:imageName	Ljava/lang/String;
        //   305: aload 5
        //   307: astore_1
        //   308: new 412	java/io/FileInputStream
        //   311: dup
        //   312: aload_2
        //   313: invokespecial 415	java/io/FileInputStream:<init>	(Ljava/io/File;)V
        //   316: astore_2
        //   317: aload_0
        //   318: aload_2
        //   319: invokevirtual 418	java/io/FileInputStream:available	()I
        //   322: putfield 356	com/quoord/tapatalkpro/util/UploadAttachmentTool:mSize	I
        //   325: aload_2
        //   326: ifnull -234 -> 92
        //   329: aload_2
        //   330: invokevirtual 419	java/io/FileInputStream:close	()V
        //   333: return
        //   334: astore_1
        //   335: aload_1
        //   336: invokevirtual 420	java/io/IOException:printStackTrace	()V
        //   339: return
        //   340: aload 5
        //   342: astore_1
        //   343: new 402	java/io/File
        //   346: dup
        //   347: aload_0
        //   348: getfield 324	com/quoord/tapatalkpro/util/UploadAttachmentTool:photoUri	Landroid/net/Uri;
        //   351: invokevirtual 362	android/net/Uri:toString	()Ljava/lang/String;
        //   354: invokespecial 408	java/io/File:<init>	(Ljava/lang/String;)V
        //   357: astore_2
        //   358: goto -100 -> 258
        //   361: astore_1
        //   362: aload_3
        //   363: astore_2
        //   364: aload_1
        //   365: astore_3
        //   366: aload_2
        //   367: astore_1
        //   368: aload_3
        //   369: invokevirtual 421	java/io/FileNotFoundException:printStackTrace	()V
        //   372: aload_2
        //   373: ifnull -281 -> 92
        //   376: aload_2
        //   377: invokevirtual 419	java/io/FileInputStream:close	()V
        //   380: return
        //   381: astore_1
        //   382: aload_1
        //   383: invokevirtual 420	java/io/IOException:printStackTrace	()V
        //   386: return
        //   387: astore_3
        //   388: aload 4
        //   390: astore_2
        //   391: aload_2
        //   392: astore_1
        //   393: aload_3
        //   394: invokevirtual 420	java/io/IOException:printStackTrace	()V
        //   397: aload_2
        //   398: ifnull -306 -> 92
        //   401: aload_2
        //   402: invokevirtual 419	java/io/FileInputStream:close	()V
        //   405: return
        //   406: astore_1
        //   407: aload_1
        //   408: invokevirtual 420	java/io/IOException:printStackTrace	()V
        //   411: return
        //   412: astore_3
        //   413: aload_1
        //   414: astore_2
        //   415: aload_3
        //   416: astore_1
        //   417: aload_2
        //   418: ifnull +7 -> 425
        //   421: aload_2
        //   422: invokevirtual 419	java/io/FileInputStream:close	()V
        //   425: aload_1
        //   426: athrow
        //   427: astore_2
        //   428: aload_2
        //   429: invokevirtual 420	java/io/IOException:printStackTrace	()V
        //   432: goto -7 -> 425
        //   435: astore_1
        //   436: goto -19 -> 417
        //   439: astore_3
        //   440: goto -49 -> 391
        //   443: astore_3
        //   444: goto -78 -> 366
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	447	0	this	UploadAttachmentTool
        //   39	269	1	localObject1	Object
        //   334	2	1	localIOException1	java.io.IOException
        //   342	1	1	localObject2	Object
        //   361	4	1	localFileNotFoundException1	java.io.FileNotFoundException
        //   367	1	1	localObject3	Object
        //   381	2	1	localIOException2	java.io.IOException
        //   392	1	1	localObject4	Object
        //   406	8	1	localIOException3	java.io.IOException
        //   416	10	1	localObject5	Object
        //   435	1	1	localObject6	Object
        //   194	228	2	localObject7	Object
        //   427	2	2	localIOException4	java.io.IOException
        //   100	269	3	localFileNotFoundException2	java.io.FileNotFoundException
        //   387	7	3	localIOException5	java.io.IOException
        //   412	4	3	localObject8	Object
        //   439	1	3	localIOException6	java.io.IOException
        //   443	1	3	localFileNotFoundException3	java.io.FileNotFoundException
        //   94	295	4	localObject9	Object
        //   97	244	5	localObject10	Object
        // Exception table:
        //   from	to	target	type
        //   329	333	334	java/io/IOException
        //   104	115	361	java/io/FileNotFoundException
        //   118	131	361	java/io/FileNotFoundException
        //   134	169	361	java/io/FileNotFoundException
        //   172	195	361	java/io/FileNotFoundException
        //   198	209	361	java/io/FileNotFoundException
        //   212	226	361	java/io/FileNotFoundException
        //   229	258	361	java/io/FileNotFoundException
        //   261	274	361	java/io/FileNotFoundException
        //   277	305	361	java/io/FileNotFoundException
        //   308	317	361	java/io/FileNotFoundException
        //   343	358	361	java/io/FileNotFoundException
        //   376	380	381	java/io/IOException
        //   104	115	387	java/io/IOException
        //   118	131	387	java/io/IOException
        //   134	169	387	java/io/IOException
        //   172	195	387	java/io/IOException
        //   198	209	387	java/io/IOException
        //   212	226	387	java/io/IOException
        //   229	258	387	java/io/IOException
        //   261	274	387	java/io/IOException
        //   277	305	387	java/io/IOException
        //   308	317	387	java/io/IOException
        //   343	358	387	java/io/IOException
        //   401	405	406	java/io/IOException
        //   104	115	412	finally
        //   118	131	412	finally
        //   134	169	412	finally
        //   172	195	412	finally
        //   198	209	412	finally
        //   212	226	412	finally
        //   229	258	412	finally
        //   261	274	412	finally
        //   277	305	412	finally
        //   308	317	412	finally
        //   343	358	412	finally
        //   368	372	412	finally
        //   393	397	412	finally
        //   421	425	427	java/io/IOException
        //   317	325	435	finally
        //   317	325	439	java/io/IOException
        //   317	325	443	java/io/FileNotFoundException
    }

    public String getId() {
        return this.id;
    }

    public void getTicket(UploadAdapter paramUploadAdapter, Uri paramUri) {
        this.stopThread = false;
        showVimeoUploadDialog();
        this.mAdapter = paramUploadAdapter;
        this.uploadFilePath = paramUri;
        this.uploadVimeoAction.getUploadVimeoTicket(new UploadVimeoAction.UploadVimeoActionActionCallBack() {
            public void actionCallBack(UploadVimeoTicket paramAnonymousUploadVimeoTicket) {
                UploadAttachmentTool.this.uploadVimeoTicket = paramAnonymousUploadVimeoTicket;
                if (UploadAttachmentTool.this.uploadVimeoTicket != null) {
                    if (!UploadAttachmentTool.this.uploadVimeoTicket.isResult()) {
                        UploadAttachmentTool.this.progressDialog.cancel();
                        UploadAttachmentTool.this.showVimeoFailedDialog();
                        Toast.makeText(UploadAttachmentTool.this.mActivity, UploadAttachmentTool.this.uploadVimeoTicket.getResult_code(), 0).show();
                        return;
                    }
                    UploadAttachmentTool.this.ticketId = UploadAttachmentTool.this.uploadVimeoTicket.getTicketId();
                    UploadAttachmentTool.this.uploadVimeoToEndpoint(UploadAttachmentTool.this.uploadVimeoTicket);
                    return;
                }
                UploadAttachmentTool.this.progressDialog.cancel();
                UploadAttachmentTool.this.showVimeoFailedDialog();
            }
        });
    }

    public void getVideoAndPhoto() {
        new AlertDialog.Builder(this.mActivity).setTitle(this.mActivity.getString(2131099804)).setAdapter(new VideoAndPhotoDialogHelperAdapter(this.mActivity, this.forumStatus), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                paramAnonymousDialogInterface = new SignInWithOtherUtil(UploadAttachmentTool.this.mActivity);
                if (UploadAttachmentTool.this.forumStatus.isTapatalkSignIn(UploadAttachmentTool.this.mActivity)) {
                    if (paramAnonymousInt == 0) {
                        paramAnonymousDialogInterface = new Intent("android.intent.action.PICK");
                        paramAnonymousDialogInterface.setType("image/*,video/*");
                        UploadAttachmentTool.this.mActivity.startActivityForResult(paramAnonymousDialogInterface, 0);
                        return;
                    }
                    if (paramAnonymousInt == 1) {
                        paramAnonymousDialogInterface = Environment.getExternalStorageDirectory() + File.separator + "tmpPhoto.jpg";
                        Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
                        localIntent.putExtra("output", Uri.fromFile(new File(paramAnonymousDialogInterface)));
                        localIntent.putExtra("android.intent.extra.videoQuality", 1);
                        UploadAttachmentTool.this.mActivity.startActivityForResult(localIntent, 1);
                        return;
                    }
                    paramAnonymousDialogInterface = new Intent("android.media.action.VIDEO_CAPTURE");
                    paramAnonymousDialogInterface.putExtra("android.intent.extra.videoQuality", 1);
                    UploadAttachmentTool.this.mActivity.startActivityForResult(paramAnonymousDialogInterface, 10);
                    return;
                }
                paramAnonymousDialogInterface.showShouldSignInDialog();
            }
        }).create().show();
    }

    public void getVimeoFile() {
        new AlertDialog.Builder(this.mActivity).setTitle(this.mActivity.getString(2131099804)).setAdapter(new AttachDialogHelperAdapter(this.mActivity, this.forumStatus), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                if (paramAnonymousInt == 0) {
                    paramAnonymousDialogInterface = new Intent();
                    paramAnonymousDialogInterface.setAction("android.intent.action.PICK");
                    paramAnonymousDialogInterface.setType("video/*");
                    UploadAttachmentTool.this.mActivity.startActivityForResult(paramAnonymousDialogInterface, UploadAttachmentTool.VIMEO);
                    return;
                }
                paramAnonymousDialogInterface = new Intent("android.media.action.VIDEO_CAPTURE");
                paramAnonymousDialogInterface.putExtra("android.intent.extra.videoQuality", 1);
                UploadAttachmentTool.this.mActivity.startActivityForResult(paramAnonymousDialogInterface, UploadAttachmentTool.VIMEO);
            }
        }).create().show();
    }

    public String getVimeoId() {
        return this.vimeoId;
    }

    public void initData() {
        this.uid = this.forumStatus.getUserId();
        this.fid = this.forumStatus.getForumId();
        this.filename = (this.forumStatus.tapatalkForum.getUserName() + "-" + this.forumStatus.tapatalkForum.getName());
        this.uploadVimeoAction = new UploadVimeoAction(this.mActivity);
        this.achInfo = new AttachmentInfo();
    }

    public void removeVimeo() {
        if (this.vimeoId != null) {
            this.uploadVimeoAction.removeVimeo(new UploadVimeoAction.UploadVimeoActionActionCallBack() {
                public void actionCallBack(UploadVimeoTicket paramAnonymousUploadVimeoTicket) {
                }
            }, this.vimeoId, this.id);
        }
    }

    public void setId(String paramString) {
        this.id = paramString;
    }

    public void setVimeoId(String paramString) {
        this.vimeoId = paramString;
    }

    public void showVimeoFailedDialog() {
        this.stopThread = true;
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.mActivity);
        localBuilder.setTitle(this.mActivity.getString(2131100922));
        localBuilder.setMessage(this.mActivity.getString(2131100923));
        localBuilder.setPositiveButton(this.mActivity.getString(2131100925), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                UploadAttachmentTool.this.getTicket(UploadAttachmentTool.this.mAdapter, UploadAttachmentTool.this.uploadFilePath);
            }
        });
        localBuilder.setNegativeButton(this.mActivity.getString(2131100924), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
            }
        });
        this.alert = localBuilder.create();
        this.alert.show();
        this.alert.setCanceledOnTouchOutside(false);
    }

    public void showVimeoUploadDialog() {
        this.progressDialog = new ProgressDialog(this.mActivity);
        this.progressDialog.setIcon(17301640);
        this.progressDialog.setTitle(this.mActivity.getString(2131100203));
        this.progressDialog.setProgressStyle(1);
        this.progressDialog.setMax(100);
        this.progressDialog.setProgress(0);
        this.progressDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public void onDismiss(DialogInterface paramAnonymousDialogInterface) {
                UploadAttachmentTool.this.stopThread = true;
            }
        });
        this.progressDialog.setButton(this.mActivity.getString(2131100924), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                UploadAttachmentTool.this.progressDialog.cancel();
                UploadAttachmentTool.this.showVimeoFailedDialog();
            }
        });
        this.progressDialog.setCanceledOnTouchOutside(false);
        this.progressDialog.show();
    }

    public String splitString(String paramString) {
        if ("".contains(paramString)) {
            "".split(paramString);
        }
        return "";
    }

    public String uploadVimeo(UploadVimeoTicket paramUploadVimeoTicket) {
        try {
            Object localObject;
            label57:
            int i;
            if (paramUploadVimeoTicket.getEndpoint_secure() != null) {
                paramUploadVimeoTicket = paramUploadVimeoTicket.getEndpoint_secure();
                if (paramUploadVimeoTicket == null) {
                    break label305;
                }
                localObject = new URL(paramUploadVimeoTicket);
                if (!paramUploadVimeoTicket.startsWith("https")) {
                    break label256;
                }
                trustAllHosts();
                paramUploadVimeoTicket = (HttpsURLConnection) ((URL) localObject).openConnection();
                paramUploadVimeoTicket.setHostnameVerifier(this.DO_NOT_VERIFY);
                this.mAdapter.getFileStream();
                this.progressDialog.setMax(this.mAdapter.realSize);
                paramUploadVimeoTicket.setRequestMethod("PUT");
                paramUploadVimeoTicket.setRequestProperty("Content-Type", "multipart/form-data");
                paramUploadVimeoTicket.setRequestProperty("UserAgent", "Tapatalk");
                paramUploadVimeoTicket.setRequestProperty("Content-Length", String.valueOf(this.mAdapter.getInputStream().available()));
                paramUploadVimeoTicket.setUseCaches(false);
                paramUploadVimeoTicket.setDoOutput(true);
                this.dataStream = new DataOutputStream(paramUploadVimeoTicket.getOutputStream());
                localObject = new byte['Ѐ'];
                i = 0;
                this.inputStream = this.mAdapter.getInputStream();
            }
            for (; ; ) {
                int j = this.inputStream.read((byte[]) localObject, 0, localObject.length);
                if ((j == -1) || (this.stopThread)) {
                    this.mAdapter.getInputStream();
                    this.inputStream.close();
                    this.dataStream.flush();
                    this.dataStream.close();
                    paramUploadVimeoTicket = getResponse(paramUploadVimeoTicket);
                    this.progressDialog.setProgress((int) (i * 0.9D));
                    return paramUploadVimeoTicket;
                    paramUploadVimeoTicket = paramUploadVimeoTicket.getEndpoint();
                    break;
                    label256:
                    paramUploadVimeoTicket = (HttpURLConnection) ((URL) localObject).openConnection();
                    break label57;
                }
                i += j;
                this.progressDialog.setProgress((int) (i * 0.7D));
                this.dataStream.write((byte[]) localObject, 0, j);
            }
            return null;
        } catch (Exception paramUploadVimeoTicket) {
            paramUploadVimeoTicket.printStackTrace();
        }
    }

    public void uploadVimeoComplete() {
        String str1 = this.forumStatus.getUserId();
        String str2 = this.forumStatus.getForumId();
        String str3 = this.forumStatus.tapatalkForum.getUserName() + "-" + this.forumStatus.tapatalkForum.getName();
        String str4 = this.forumStatus.tapatalkForum.getUserName();
        this.uploadVimeoAction.uploadVimeoComplete(new UploadVimeoAction.UploadVimeoActionActionCallBack() {
            public void actionCallBack(UploadVimeoTicket paramAnonymousUploadVimeoTicket) {
                UploadAttachmentTool.this.progressDialog.cancel();
                if (paramAnonymousUploadVimeoTicket != null) {
                    if (paramAnonymousUploadVimeoTicket.isResult()) {
                        UploadAttachmentTool.this.setVimeoId(paramAnonymousUploadVimeoTicket.getVideo_id());
                        UploadAttachmentTool.this.setId(paramAnonymousUploadVimeoTicket.getId());
                        if (((UploadAttachmentTool.this.mActivity instanceof CreateTopicActivity)) && (((CreateTopicActivity) UploadAttachmentTool.this.mActivity).mAdapter != null)) {
                            ((CreateTopicActivity) UploadAttachmentTool.this.mActivity).mAdapter.videoIds.add(UploadAttachmentTool.this.vimeoId);
                            ((CreateTopicActivity) UploadAttachmentTool.this.mActivity).mAdapter.ids.add(UploadAttachmentTool.this.id);
                        }
                        ((CreateTopicActivity) UploadAttachmentTool.this.mActivity).initUplodvimeoEditText(UploadAttachmentTool.this.getVimeoId());
                        return;
                    }
                    UploadAttachmentTool.this.showVimeoFailedDialog();
                    return;
                }
                UploadAttachmentTool.this.showVimeoFailedDialog();
            }
        }, str1, str2, this.ticketId, str3, str4);
    }

    public void uploadVimeoToEndpoint(final UploadVimeoTicket paramUploadVimeoTicket) {
        this.thread = new Thread(new Runnable() {
            public void run() {
                UploadAttachmentTool.this.uploadVimeo(paramUploadVimeoTicket);
                if (!UploadAttachmentTool.this.stopThread) {
                    UploadAttachmentTool.this.uploadVimeoComplete();
                }
            }
        });
        this.thread.start();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/util/UploadAttachmentTool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */