package com.quoord.tapatalkpro.bean;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.activity.directory.ics.IcsRecommendActivity;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.sqlhelper.FavoriateSqlHelper;
import com.quoord.tapatalkpro.util.AvatarTool;
import com.quoord.tapatalkpro.util.PasswordCrypt;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.TapatalkJsonEngine;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tools.net.JSONUtil;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

import org.json.JSONObject;

public class TapatalkForum
        extends BaseBean
        implements Serializable {
    public static final String FORUMURL = "prefernece.forumurl";
    private static final long serialVersionUID = 6862912461520093927L;
    private TapatalkForumAccount account = new TapatalkForumAccount();
    private int apiLevel = 3;
    private boolean canSignInWithTapatalkId;
    private String categoryName;
    private String cms_url;
    private Date creationDate;
    private String description;
    private int dfp = 0;
    private String displayName;
    private String ext;
    private String folder;
    private String forumUrl = null;
    private String ga;
    private boolean hasImage;
    private boolean hasPushKey = false;
    private Integer hide = Integer.valueOf(0);
    private Integer iab_catid;
    private String iconUrl;
    private Integer id;
    private String inboxId;
    private boolean isCurrentUserSso = false;
    private boolean isFeed = false;
    private String isFromByoAccountChannel;
    private boolean isMD5;
    private boolean isPMEnable = true;
    private int isPR = 0;
    private int isPT = 0;
    private boolean isPush = false;
    private boolean isPushConv = false;
    private boolean isPushLike = false;
    private boolean isPushNewTopic = false;
    private boolean isPushPM = false;
    private boolean isPushQuote = false;
    private boolean isPushSub = false;
    private boolean isPushTag = false;
    private boolean isPushThank = false;
    private boolean isSelected = false;
    private boolean isSupportConve = false;
    private Integer mTapatalkUserCount = null;
    private Integer mTotalThreads = null;
    private String mUseEmail = null;
    private String mVersion;
    private boolean media_sharing = false;
    private String name;
    private String networkCode = null;
    private String outBoxId;
    private String parentCategory;
    private String password;
    private int poistionInData;
    private String propertyCode = null;
    private int signatureType = 1;
    private String slotName = null;
    private String slotNameWeb = null;
    private boolean supportTkUpload = true;
    private String type;
    private int unreadPMNotificaion;
    private int unreadSubNotificaion;
    private String url;
    private Bitmap userIcon;
    private String userIconUrl = null;
    private String userId = "0";
    private String userName;
    private boolean viglinkSupport = false;

    public static TapatalkForum getForum(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3) {
        return getForum(paramJSONObject, paramString1, paramString2, paramString3, "");
    }

    public static TapatalkForum getForum(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3, String paramString4) {
        localTapatalkForum = new TapatalkForum();
        if (paramString1 != null) {
        }
        try {
            localTapatalkForum.setUserName(paramString1);
            if (paramString2 != null) {
                localTapatalkForum.setmUseEmail(paramString2);
            }
            if ((paramString3 != null) && (!paramString3.equals("0"))) {
                localTapatalkForum.setUserId(paramString3);
            }
            if (paramString4 != null) {
                localTapatalkForum.setDisplayName(paramString4);
            }
            paramString1 = new JSONUtil(paramJSONObject);
            localTapatalkForum.setIab_catid(paramString1.optInteger("iab_catid", null));
            localTapatalkForum.setId(paramString1.optInteger("id", null));
            localTapatalkForum.setHasImage(paramString1.optBoolean("topic_image", Boolean.valueOf(false)).booleanValue());
            if (paramJSONObject.has("forum_name")) {
                localTapatalkForum.setName(paramString1.optString("forum_name"));
            }
            for (; ; ) {
                localTapatalkForum.setDescription(paramString1.optString("description"));
                localTapatalkForum.setCategoryName(paramString1.optString("category"));
                if (paramJSONObject.has("created")) {
                    localTapatalkForum.setCreationDate((Date) paramString1.opt("created"));
                }
                localTapatalkForum.setFolder(paramString1.optString("mobiquo_dir"));
                localTapatalkForum.setExt(paramString1.optString("ext"));
                localTapatalkForum.setUrl(paramString1.optString("url"));
                localTapatalkForum.setSignatureType(paramString1.optInteger("tapatalk_signature").intValue());
                localTapatalkForum.setViglinkSupport(paramString1.optBoolean("viglink_support", Boolean.valueOf(false)).booleanValue());
                localTapatalkForum.setSupportTkUpload(paramString1.optBoolean("hosted_image_support", Boolean.valueOf(false)).booleanValue());
                localTapatalkForum.setMedia_sharing(paramString1.optBoolean("media_sharing", Boolean.valueOf(false)).booleanValue());
                paramJSONObject = paramString1.optString("logo", "");
                if (!paramJSONObject.equals("")) {
                    localTapatalkForum.setIconUrl(paramJSONObject.replace("90x90", "HD"));
                }
                localTapatalkForum.setSupportedPR(paramString1.optInteger("pr").intValue());
                localTapatalkForum.setIsPT(paramString1.optInteger("pt").intValue());
                localTapatalkForum.setDfp(paramString1.optInteger("dfp").intValue());
                localTapatalkForum.setNetworkCode(paramString1.optString("dfp_network_code"));
                localTapatalkForum.setPropertyCode(paramString1.optString("dfp_property_code"));
                localTapatalkForum.setSlotName(paramString1.optString("android_dfp_320x50"));
                localTapatalkForum.setSlotNameWeb(paramString1.optString("android_dfp_300x250"));
                localTapatalkForum.setForumUrl(paramString1.optString("android_product_url"));
                localTapatalkForum.setCms_url(paramString1.optString("cms_url"));
                localTapatalkForum.setGa(paramString1.optString("ga"));
                localTapatalkForum.setType(paramString1.optString("type"));
                localTapatalkForum.setVersion(paramString1.optString("type"));
                localTapatalkForum.setFeed(paramString1.optBoolean("feed").booleanValue());
                localTapatalkForum.setTotalThreads(paramString1.optInteger("total_threads", Integer.valueOf(0)));
                localTapatalkForum.setTapatalkUserCount(paramString1.optInteger("tapatalk_user_count", Integer.valueOf(0)));
                return localTapatalkForum;
                localTapatalkForum.setName(paramString1.optString("name"));
            }
            return localTapatalkForum;
        } catch (Exception paramJSONObject) {
            paramJSONObject.printStackTrace();
        }
    }

    /* Error */
    private void readObject(java.io.ObjectInputStream paramObjectInputStream)
            throws IOException, java.lang.ClassNotFoundException {
        // Byte code:
        //   0: aload_1
        //   1: invokevirtual 417	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
        //   4: astore_2
        //   5: aload_1
        //   6: invokevirtual 417	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
        //   9: astore_3
        //   10: aload_0
        //   11: aload_2
        //   12: checkcast 156	java/lang/Integer
        //   15: putfield 419	com/quoord/tapatalkpro/bean/TapatalkForum:iab_catid	Ljava/lang/Integer;
        //   18: aload_0
        //   19: aload_3
        //   20: checkcast 156	java/lang/Integer
        //   23: putfield 421	com/quoord/tapatalkpro/bean/TapatalkForum:id	Ljava/lang/Integer;
        //   26: aload_0
        //   27: aload_1
        //   28: invokevirtual 417	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
        //   31: checkcast 191	java/lang/String
        //   34: putfield 423	com/quoord/tapatalkpro/bean/TapatalkForum:name	Ljava/lang/String;
        //   37: aload_0
        //   38: aload_1
        //   39: invokevirtual 417	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
        //   42: checkcast 191	java/lang/String
        //   45: putfield 425	com/quoord/tapatalkpro/bean/TapatalkForum:description	Ljava/lang/String;
        //   48: aload_0
        //   49: aload_1
        //   50: invokevirtual 417	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
        //   53: checkcast 270	java/util/Date
        //   56: putfield 427	com/quoord/tapatalkpro/bean/TapatalkForum:creationDate	Ljava/util/Date;
        //   59: aload_0
        //   60: aload_1
        //   61: invokevirtual 417	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
        //   64: checkcast 191	java/lang/String
        //   67: putfield 429	com/quoord/tapatalkpro/bean/TapatalkForum:url	Ljava/lang/String;
        //   70: aload_0
        //   71: aload_1
        //   72: invokevirtual 417	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
        //   75: checkcast 191	java/lang/String
        //   78: putfield 431	com/quoord/tapatalkpro/bean/TapatalkForum:iconUrl	Ljava/lang/String;
        //   81: aload_0
        //   82: aload_1
        //   83: invokevirtual 417	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
        //   86: checkcast 191	java/lang/String
        //   89: putfield 433	com/quoord/tapatalkpro/bean/TapatalkForum:userName	Ljava/lang/String;
        //   92: aload_0
        //   93: aload_1
        //   94: invokevirtual 417	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
        //   97: checkcast 191	java/lang/String
        //   100: putfield 435	com/quoord/tapatalkpro/bean/TapatalkForum:folder	Ljava/lang/String;
        //   103: aload_0
        //   104: aload_1
        //   105: invokevirtual 417	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
        //   108: checkcast 191	java/lang/String
        //   111: putfield 437	com/quoord/tapatalkpro/bean/TapatalkForum:categoryName	Ljava/lang/String;
        //   114: aload_0
        //   115: aload_1
        //   116: invokevirtual 417	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
        //   119: checkcast 191	java/lang/String
        //   122: putfield 439	com/quoord/tapatalkpro/bean/TapatalkForum:parentCategory	Ljava/lang/String;
        //   125: aload_0
        //   126: aload_1
        //   127: invokevirtual 417	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
        //   130: checkcast 223	java/lang/Boolean
        //   133: invokevirtual 234	java/lang/Boolean:booleanValue	()Z
        //   136: putfield 92	com/quoord/tapatalkpro/bean/TapatalkForum:supportTkUpload	Z
        //   139: aload_0
        //   140: aload_1
        //   141: invokevirtual 417	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
        //   144: checkcast 223	java/lang/Boolean
        //   147: invokevirtual 234	java/lang/Boolean:booleanValue	()Z
        //   150: putfield 94	com/quoord/tapatalkpro/bean/TapatalkForum:viglinkSupport	Z
        //   153: aload_0
        //   154: aload_1
        //   155: invokevirtual 417	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
        //   158: checkcast 156	java/lang/Integer
        //   161: invokevirtual 296	java/lang/Integer:intValue	()I
        //   164: putfield 96	com/quoord/tapatalkpro/bean/TapatalkForum:signatureType	I
        //   167: aload_0
        //   168: aload_1
        //   169: invokevirtual 417	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
        //   172: checkcast 191	java/lang/String
        //   175: putfield 441	com/quoord/tapatalkpro/bean/TapatalkForum:password	Ljava/lang/String;
        //   178: aload_0
        //   179: aload_1
        //   180: invokevirtual 417	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
        //   183: checkcast 156	java/lang/Integer
        //   186: invokevirtual 296	java/lang/Integer:intValue	()I
        //   189: putfield 98	com/quoord/tapatalkpro/bean/TapatalkForum:dfp	I
        //   192: aload_0
        //   193: aload_1
        //   194: invokevirtual 417	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
        //   197: checkcast 191	java/lang/String
        //   200: putfield 102	com/quoord/tapatalkpro/bean/TapatalkForum:propertyCode	Ljava/lang/String;
        //   203: aload_0
        //   204: aload_1
        //   205: invokevirtual 417	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
        //   208: checkcast 191	java/lang/String
        //   211: putfield 104	com/quoord/tapatalkpro/bean/TapatalkForum:slotName	Ljava/lang/String;
        //   214: aload_0
        //   215: aload_1
        //   216: invokevirtual 417	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
        //   219: checkcast 191	java/lang/String
        //   222: putfield 106	com/quoord/tapatalkpro/bean/TapatalkForum:slotNameWeb	Ljava/lang/String;
        //   225: aload_0
        //   226: aload_1
        //   227: invokevirtual 417	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
        //   230: checkcast 191	java/lang/String
        //   233: putfield 443	com/quoord/tapatalkpro/bean/TapatalkForum:inboxId	Ljava/lang/String;
        //   236: aload_0
        //   237: aload_1
        //   238: invokevirtual 417	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
        //   241: checkcast 191	java/lang/String
        //   244: putfield 445	com/quoord/tapatalkpro/bean/TapatalkForum:outBoxId	Ljava/lang/String;
        //   247: aload_0
        //   248: aload_1
        //   249: invokevirtual 417	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
        //   252: checkcast 156	java/lang/Integer
        //   255: invokevirtual 296	java/lang/Integer:intValue	()I
        //   258: putfield 447	com/quoord/tapatalkpro/bean/TapatalkForum:unreadPMNotificaion	I
        //   261: aload_0
        //   262: aload_1
        //   263: invokevirtual 417	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
        //   266: checkcast 156	java/lang/Integer
        //   269: invokevirtual 296	java/lang/Integer:intValue	()I
        //   272: putfield 449	com/quoord/tapatalkpro/bean/TapatalkForum:unreadSubNotificaion	I
        //   275: aload_0
        //   276: aload_1
        //   277: invokevirtual 417	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
        //   280: checkcast 191	java/lang/String
        //   283: putfield 451	com/quoord/tapatalkpro/bean/TapatalkForum:ext	Ljava/lang/String;
        //   286: aload_0
        //   287: aload_1
        //   288: invokevirtual 417	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
        //   291: checkcast 191	java/lang/String
        //   294: putfield 110	com/quoord/tapatalkpro/bean/TapatalkForum:userId	Ljava/lang/String;
        //   297: aload_0
        //   298: aload_1
        //   299: invokevirtual 417	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
        //   302: checkcast 223	java/lang/Boolean
        //   305: invokevirtual 234	java/lang/Boolean:booleanValue	()Z
        //   308: putfield 453	com/quoord/tapatalkpro/bean/TapatalkForum:isMD5	Z
        //   311: aload_0
        //   312: aload_1
        //   313: invokevirtual 417	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
        //   316: checkcast 156	java/lang/Integer
        //   319: invokevirtual 296	java/lang/Integer:intValue	()I
        //   322: putfield 112	com/quoord/tapatalkpro/bean/TapatalkForum:isPR	I
        //   325: aload_0
        //   326: aload_1
        //   327: invokevirtual 417	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
        //   330: checkcast 223	java/lang/Boolean
        //   333: invokevirtual 234	java/lang/Boolean:booleanValue	()Z
        //   336: putfield 455	com/quoord/tapatalkpro/bean/TapatalkForum:hasImage	Z
        //   339: aload_0
        //   340: aload_1
        //   341: invokevirtual 417	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
        //   344: checkcast 223	java/lang/Boolean
        //   347: invokevirtual 234	java/lang/Boolean:booleanValue	()Z
        //   350: putfield 118	com/quoord/tapatalkpro/bean/TapatalkForum:isPushSub	Z
        //   353: aload_0
        //   354: aload_1
        //   355: invokevirtual 417	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
        //   358: checkcast 223	java/lang/Boolean
        //   361: invokevirtual 234	java/lang/Boolean:booleanValue	()Z
        //   364: putfield 120	com/quoord/tapatalkpro/bean/TapatalkForum:isPushPM	Z
        //   367: aload_0
        //   368: aload_1
        //   369: invokevirtual 417	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
        //   372: checkcast 223	java/lang/Boolean
        //   375: invokevirtual 234	java/lang/Boolean:booleanValue	()Z
        //   378: putfield 122	com/quoord/tapatalkpro/bean/TapatalkForum:isPushConv	Z
        //   381: aload_0
        //   382: aload_1
        //   383: invokevirtual 417	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
        //   386: checkcast 223	java/lang/Boolean
        //   389: invokevirtual 234	java/lang/Boolean:booleanValue	()Z
        //   392: putfield 124	com/quoord/tapatalkpro/bean/TapatalkForum:isPushTag	Z
        //   395: aload_0
        //   396: aload_1
        //   397: invokevirtual 417	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
        //   400: checkcast 223	java/lang/Boolean
        //   403: invokevirtual 234	java/lang/Boolean:booleanValue	()Z
        //   406: putfield 128	com/quoord/tapatalkpro/bean/TapatalkForum:isPushLike	Z
        //   409: aload_0
        //   410: aload_1
        //   411: invokevirtual 417	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
        //   414: checkcast 223	java/lang/Boolean
        //   417: invokevirtual 234	java/lang/Boolean:booleanValue	()Z
        //   420: putfield 126	com/quoord/tapatalkpro/bean/TapatalkForum:isPushQuote	Z
        //   423: aload_0
        //   424: aload_1
        //   425: invokevirtual 417	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
        //   428: checkcast 223	java/lang/Boolean
        //   431: invokevirtual 234	java/lang/Boolean:booleanValue	()Z
        //   434: putfield 130	com/quoord/tapatalkpro/bean/TapatalkForum:isPushNewTopic	Z
        //   437: aload_0
        //   438: aload_1
        //   439: invokevirtual 417	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
        //   442: checkcast 223	java/lang/Boolean
        //   445: invokevirtual 234	java/lang/Boolean:booleanValue	()Z
        //   448: putfield 136	com/quoord/tapatalkpro/bean/TapatalkForum:isPush	Z
        //   451: aload_0
        //   452: aload_1
        //   453: invokevirtual 417	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
        //   456: checkcast 223	java/lang/Boolean
        //   459: invokevirtual 234	java/lang/Boolean:booleanValue	()Z
        //   462: putfield 134	com/quoord/tapatalkpro/bean/TapatalkForum:hasPushKey	Z
        //   465: aload_0
        //   466: aload_1
        //   467: invokevirtual 417	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
        //   470: checkcast 191	java/lang/String
        //   473: putfield 457	com/quoord/tapatalkpro/bean/TapatalkForum:mVersion	Ljava/lang/String;
        //   476: aload_0
        //   477: aload_1
        //   478: invokevirtual 417	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
        //   481: checkcast 156	java/lang/Integer
        //   484: invokevirtual 296	java/lang/Integer:intValue	()I
        //   487: putfield 138	com/quoord/tapatalkpro/bean/TapatalkForum:apiLevel	I
        //   490: aload_0
        //   491: aload_1
        //   492: invokevirtual 417	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
        //   495: checkcast 223	java/lang/Boolean
        //   498: invokevirtual 234	java/lang/Boolean:booleanValue	()Z
        //   501: putfield 140	com/quoord/tapatalkpro/bean/TapatalkForum:isSupportConve	Z
        //   504: aload_0
        //   505: aload_1
        //   506: invokevirtual 417	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
        //   509: checkcast 223	java/lang/Boolean
        //   512: invokevirtual 234	java/lang/Boolean:booleanValue	()Z
        //   515: putfield 142	com/quoord/tapatalkpro/bean/TapatalkForum:isPMEnable	Z
        //   518: aload_0
        //   519: aload_1
        //   520: invokevirtual 417	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
        //   523: checkcast 191	java/lang/String
        //   526: putfield 144	com/quoord/tapatalkpro/bean/TapatalkForum:forumUrl	Ljava/lang/String;
        //   529: aload_0
        //   530: aload_1
        //   531: invokevirtual 417	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
        //   534: checkcast 191	java/lang/String
        //   537: putfield 116	com/quoord/tapatalkpro/bean/TapatalkForum:mUseEmail	Ljava/lang/String;
        //   540: aload_0
        //   541: aload_1
        //   542: invokevirtual 417	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
        //   545: checkcast 191	java/lang/String
        //   548: putfield 459	com/quoord/tapatalkpro/bean/TapatalkForum:cms_url	Ljava/lang/String;
        //   551: aload_0
        //   552: aload_1
        //   553: invokevirtual 417	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
        //   556: checkcast 223	java/lang/Boolean
        //   559: invokevirtual 234	java/lang/Boolean:booleanValue	()Z
        //   562: putfield 461	com/quoord/tapatalkpro/bean/TapatalkForum:canSignInWithTapatalkId	Z
        //   565: aload_0
        //   566: aload_1
        //   567: invokevirtual 417	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
        //   570: checkcast 191	java/lang/String
        //   573: putfield 463	com/quoord/tapatalkpro/bean/TapatalkForum:displayName	Ljava/lang/String;
        //   576: aload_0
        //   577: aload_1
        //   578: invokevirtual 417	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
        //   581: checkcast 156	java/lang/Integer
        //   584: invokevirtual 296	java/lang/Integer:intValue	()I
        //   587: putfield 114	com/quoord/tapatalkpro/bean/TapatalkForum:isPT	I
        //   590: aload_0
        //   591: aload_1
        //   592: invokevirtual 417	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
        //   595: checkcast 223	java/lang/Boolean
        //   598: invokevirtual 234	java/lang/Boolean:booleanValue	()Z
        //   601: putfield 132	com/quoord/tapatalkpro/bean/TapatalkForum:isPushThank	Z
        //   604: aload_0
        //   605: aload_1
        //   606: invokevirtual 417	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
        //   609: checkcast 191	java/lang/String
        //   612: putfield 465	com/quoord/tapatalkpro/bean/TapatalkForum:ga	Ljava/lang/String;
        //   615: aload_0
        //   616: aload_1
        //   617: invokevirtual 417	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
        //   620: checkcast 191	java/lang/String
        //   623: putfield 467	com/quoord/tapatalkpro/bean/TapatalkForum:type	Ljava/lang/String;
        //   626: aload_0
        //   627: aload_1
        //   628: invokevirtual 417	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
        //   631: checkcast 223	java/lang/Boolean
        //   634: invokevirtual 234	java/lang/Boolean:booleanValue	()Z
        //   637: putfield 146	com/quoord/tapatalkpro/bean/TapatalkForum:isSelected	Z
        //   640: aload_0
        //   641: aload_1
        //   642: invokevirtual 417	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
        //   645: checkcast 223	java/lang/Boolean
        //   648: invokevirtual 234	java/lang/Boolean:booleanValue	()Z
        //   651: putfield 148	com/quoord/tapatalkpro/bean/TapatalkForum:isFeed	Z
        //   654: aload_0
        //   655: aload_1
        //   656: invokevirtual 417	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
        //   659: checkcast 156	java/lang/Integer
        //   662: putfield 419	com/quoord/tapatalkpro/bean/TapatalkForum:iab_catid	Ljava/lang/Integer;
        //   665: aload_0
        //   666: aload_1
        //   667: invokevirtual 417	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
        //   670: checkcast 156	java/lang/Integer
        //   673: putfield 150	com/quoord/tapatalkpro/bean/TapatalkForum:mTotalThreads	Ljava/lang/Integer;
        //   676: aload_0
        //   677: aload_1
        //   678: invokevirtual 417	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
        //   681: checkcast 156	java/lang/Integer
        //   684: putfield 152	com/quoord/tapatalkpro/bean/TapatalkForum:mTapatalkUserCount	Ljava/lang/Integer;
        //   687: aload_0
        //   688: aload_1
        //   689: invokevirtual 417	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
        //   692: checkcast 191	java/lang/String
        //   695: putfield 469	com/quoord/tapatalkpro/bean/TapatalkForum:isFromByoAccountChannel	Ljava/lang/String;
        //   698: aload_0
        //   699: aload_1
        //   700: invokevirtual 417	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
        //   703: checkcast 156	java/lang/Integer
        //   706: putfield 162	com/quoord/tapatalkpro/bean/TapatalkForum:hide	Ljava/lang/Integer;
        //   709: aload_0
        //   710: aload_1
        //   711: invokevirtual 417	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
        //   714: checkcast 223	java/lang/Boolean
        //   717: invokevirtual 234	java/lang/Boolean:booleanValue	()Z
        //   720: putfield 154	com/quoord/tapatalkpro/bean/TapatalkForum:media_sharing	Z
        //   723: aload_0
        //   724: aload_1
        //   725: invokevirtual 417	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
        //   728: checkcast 223	java/lang/Boolean
        //   731: invokevirtual 234	java/lang/Boolean:booleanValue	()Z
        //   734: putfield 164	com/quoord/tapatalkpro/bean/TapatalkForum:isCurrentUserSso	Z
        //   737: aload_0
        //   738: aload_1
        //   739: invokevirtual 417	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
        //   742: checkcast 191	java/lang/String
        //   745: putfield 166	com/quoord/tapatalkpro/bean/TapatalkForum:userIconUrl	Ljava/lang/String;
        //   748: return
        //   749: astore 4
        //   751: aload_0
        //   752: aload_2
        //   753: checkcast 156	java/lang/Integer
        //   756: putfield 421	com/quoord/tapatalkpro/bean/TapatalkForum:id	Ljava/lang/Integer;
        //   759: aload_0
        //   760: aload_3
        //   761: checkcast 191	java/lang/String
        //   764: putfield 423	com/quoord/tapatalkpro/bean/TapatalkForum:name	Ljava/lang/String;
        //   767: goto -730 -> 37
        //   770: astore_1
        //   771: return
        //   772: astore_2
        //   773: goto -64 -> 709
        //   776: astore_2
        //   777: goto -123 -> 654
        //   780: astore_2
        //   781: goto -155 -> 626
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	784	0	this	TapatalkForum
        //   0	784	1	paramObjectInputStream	java.io.ObjectInputStream
        //   4	749	2	localObject1	Object
        //   772	1	2	localException1	Exception
        //   776	1	2	localException2	Exception
        //   780	1	2	localException3	Exception
        //   9	752	3	localObject2	Object
        //   749	1	4	localException4	Exception
        // Exception table:
        //   from	to	target	type
        //   10	37	749	java/lang/Exception
        //   709	748	770	java/lang/Exception
        //   654	709	772	java/lang/Exception
        //   626	654	776	java/lang/Exception
        //   225	626	780	java/lang/Exception
    }

    private void writeObject(ObjectOutputStream paramObjectOutputStream)
            throws IOException {
        paramObjectOutputStream.writeObject(this.id);
        paramObjectOutputStream.writeObject(this.name);
        paramObjectOutputStream.writeObject(this.description);
        paramObjectOutputStream.writeObject(this.creationDate);
        paramObjectOutputStream.writeObject(this.url);
        paramObjectOutputStream.writeObject(this.iconUrl);
        paramObjectOutputStream.writeObject(this.userName);
        paramObjectOutputStream.writeObject(this.folder);
        paramObjectOutputStream.writeObject(this.categoryName);
        paramObjectOutputStream.writeObject(this.parentCategory);
        paramObjectOutputStream.writeObject(Boolean.valueOf(this.supportTkUpload));
        paramObjectOutputStream.writeObject(Boolean.valueOf(this.viglinkSupport));
        paramObjectOutputStream.writeObject(Integer.valueOf(this.signatureType));
        paramObjectOutputStream.writeObject(this.password);
        paramObjectOutputStream.writeObject(Integer.valueOf(this.dfp));
        paramObjectOutputStream.writeObject(this.propertyCode);
        paramObjectOutputStream.writeObject(this.slotName);
        paramObjectOutputStream.writeObject(this.slotNameWeb);
        paramObjectOutputStream.writeObject(this.inboxId);
        paramObjectOutputStream.writeObject(this.outBoxId);
        paramObjectOutputStream.writeObject(Integer.valueOf(this.unreadPMNotificaion));
        paramObjectOutputStream.writeObject(Integer.valueOf(this.unreadSubNotificaion));
        paramObjectOutputStream.writeObject(this.ext);
        paramObjectOutputStream.writeObject(this.userId);
        paramObjectOutputStream.writeObject(Boolean.valueOf(this.isMD5));
        paramObjectOutputStream.writeObject(Integer.valueOf(this.isPR));
        paramObjectOutputStream.writeObject(Boolean.valueOf(this.hasImage));
        paramObjectOutputStream.writeObject(Boolean.valueOf(this.isPushSub));
        paramObjectOutputStream.writeObject(Boolean.valueOf(this.isPushPM));
        paramObjectOutputStream.writeObject(Boolean.valueOf(this.isPushConv));
        paramObjectOutputStream.writeObject(Boolean.valueOf(this.isPushTag));
        paramObjectOutputStream.writeObject(Boolean.valueOf(this.isPushLike));
        paramObjectOutputStream.writeObject(Boolean.valueOf(this.isPushQuote));
        paramObjectOutputStream.writeObject(Boolean.valueOf(this.isPushNewTopic));
        paramObjectOutputStream.writeObject(Boolean.valueOf(this.isPush));
        paramObjectOutputStream.writeObject(Boolean.valueOf(this.hasPushKey));
        paramObjectOutputStream.writeObject(this.mVersion);
        paramObjectOutputStream.writeObject(Integer.valueOf(this.apiLevel));
        paramObjectOutputStream.writeObject(Boolean.valueOf(this.isSupportConve));
        paramObjectOutputStream.writeObject(Boolean.valueOf(this.isPMEnable));
        paramObjectOutputStream.writeObject(this.forumUrl);
        try {
            paramObjectOutputStream.writeObject(this.mUseEmail);
            paramObjectOutputStream.writeObject(this.cms_url);
            paramObjectOutputStream.writeObject(Boolean.valueOf(this.canSignInWithTapatalkId));
            paramObjectOutputStream.writeObject(this.displayName);
            paramObjectOutputStream.writeObject(Integer.valueOf(this.isPT));
            paramObjectOutputStream.writeObject(Boolean.valueOf(this.isPushThank));
            paramObjectOutputStream.writeObject(this.ga);
            paramObjectOutputStream.writeObject(this.type);
            try {
                paramObjectOutputStream.writeObject(Boolean.valueOf(this.isSelected));
                paramObjectOutputStream.writeObject(Boolean.valueOf(this.isFeed));
                try {
                    paramObjectOutputStream.writeObject(this.iab_catid);
                    paramObjectOutputStream.writeObject(this.mTotalThreads);
                    paramObjectOutputStream.writeObject(this.mTapatalkUserCount);
                    paramObjectOutputStream.writeObject(this.isFromByoAccountChannel);
                    paramObjectOutputStream.writeObject(this.hide);
                    try {
                        paramObjectOutputStream.writeObject(Boolean.valueOf(this.media_sharing));
                        paramObjectOutputStream.writeObject(Boolean.valueOf(this.isCurrentUserSso));
                        paramObjectOutputStream.writeObject(this.userIconUrl);
                        return;
                    } catch (Exception paramObjectOutputStream) {
                    }
                } catch (Exception localException1) {
                    for (; ; ) {
                    }
                }
            } catch (Exception localException2) {
                for (; ; ) {
                }
            }
        } catch (Exception localException3) {
            for (; ; ) {
            }
        }
    }

    public boolean equals(Object paramObject) {
        if ((paramObject instanceof TapatalkForum)) {
            if ((getUserId() != null) && (((TapatalkForum) paramObject).getUserId() != null) && (!getUserId().equals("0")) && (!((TapatalkForum) paramObject).getUserId().equals("0"))) {
            }
            for (int i = 1; (i != 0) && ((getId() + getUserId()).hashCode() == (((TapatalkForum) paramObject).getId() + ((TapatalkForum) paramObject).getUserId()).hashCode()); i = 0) {
                return true;
            }
            return (getId() + getUserNameOrDisplayName().toLowerCase()).hashCode() == (((TapatalkForum) paramObject).getId() + ((TapatalkForum) paramObject).getUserNameOrDisplayName().toLowerCase()).hashCode();
        }
        return false;
    }

    public TapatalkForumAccount getAccount() {
        return this.account;
    }

    public int getApiLevel() {
        return this.apiLevel;
    }

    public String getCacheUsernameDir() {
        return getUserNameOrDisplayName().toLowerCase();
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public String getCms_url() {
        return this.cms_url;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public boolean getCurrentUserSso() {
        return this.isCurrentUserSso;
    }

    public String getDescription() {
        return this.description;
    }

    public int getDfp() {
        return this.dfp;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getDisplayNameOrUsername() {
        if (!Util.isEmpty(getDisplayName())) {
            return getDisplayName();
        }
        if (!Util.isEmpty(getUserName())) {
            return this.userName;
        }
        return null;
    }

    public String getExt() {
        if (this.ext == null) {
            return "php";
        }
        return this.ext;
    }

    public String getFolder() {
        if (this.folder == null) {
            return "mobiquo";
        }
        return this.folder;
    }

    public String getForumUrl() {
        return this.forumUrl;
    }

    public View getForumView(int paramInt, View paramView, ViewGroup paramViewGroup, Activity paramActivity, BaseAdapter paramBaseAdapter) {
        if ((paramView == null) || (paramView.getTag() == null)) {
            paramView = paramActivity.getLayoutInflater().inflate(2130903129, null);
            paramViewGroup = new ViewHolder(null);
            paramViewGroup.icon = ((ImageView) paramView.findViewById(2131230992));
            paramViewGroup.text = ((TextView) paramView.findViewById(2131230904));
            paramViewGroup.description = ((TextView) paramView.findViewById(2131230993));
            paramViewGroup.category = ((TextView) paramView.findViewById(2131230994));
            paramView.setTag(paramViewGroup);
            paramViewGroup.text.setText(getName());
            paramViewGroup.description.setText(getDescription());
            if (!SettingsFragment.isLightTheme(paramActivity)) {
                paramViewGroup.text.setTextColor(-1);
            }
            paramViewGroup.text.setTextColor(paramActivity.getResources().getColor(17170435));
            paramViewGroup.description.setTextColor(paramActivity.getResources().getColor(17170439));
            if ((getCategoryName() == null) || (getCategoryName().length() <= 0)) {
                break label263;
            }
            paramViewGroup.category.setVisibility(0);
            paramViewGroup.category.setText(getParentCategory() + " / " + getCategoryName() + " ");
        }
        for (; ; ) {
            AvatarTool.showLogo(paramActivity, paramViewGroup.icon, getIconUrl(), 5);
            return paramView;
            paramViewGroup = (ViewHolder) paramView.getTag();
            break;
            label263:
            paramViewGroup.category.setVisibility(8);
        }
    }

    public String getFromByoAccountChannel() {
        return this.isFromByoAccountChannel;
    }

    public String getGa() {
        return this.ga;
    }

    public Integer getHide() {
        return this.hide;
    }

    public Integer getIab_catid() {
        return this.iab_catid;
    }

    public void getIconFromFile(Context paramContext) {
        try {
            paramContext = paramContext.openFileInput(getIconUrl().hashCode());
            byte[] arrayOfByte = new byte['Ѐ'];
            ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
            for (; ; ) {
                if (paramContext.read(arrayOfByte) == -1) {
                    paramContext.close();
                    localByteArrayOutputStream.close();
                    setIcon(BitmapFactory.decodeByteArray(localByteArrayOutputStream.toByteArray(), 0, localByteArrayOutputStream.size()));
                    return;
                }
                localByteArrayOutputStream.write(arrayOfByte, 0, arrayOfByte.length);
            }
            return;
        } catch (Exception paramContext) {
            setIcon(null);
        }
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public Integer getId() {
        if (this.id == null) {
            return Integer.valueOf(0);
        }
        return this.id;
    }

    public String getInboxId() {
        return this.inboxId;
    }

    public int getIsPT() {
        return this.isPT;
    }

    public String getLowerUserName() {
        if (this.userName != null) {
            this.userName = this.userName.trim();
        }
        if (this.userName == null) {
            this.userName = "";
        }
        return this.userName.toLowerCase();
    }

    public String getName() {
        return this.name;
    }

    public String getNetworkCode() {
        return this.networkCode;
    }

    public String getNotificationString(Activity paramActivity) {
        Object localObject2 = null;
        SharedPreferences localSharedPreferences = paramActivity.getSharedPreferences("notificationsetting", 0);
        Object localObject1 = localObject2;
        if (isPushConv()) {
            localObject1 = localObject2;
            if (localSharedPreferences.contains(getId() + paramActivity.getResources().getString(2131100355))) {
                localObject1 = localObject2;
                if (localSharedPreferences.getBoolean(getId() + paramActivity.getResources().getString(2131100355), false)) {
                    localObject1 = paramActivity.getString(2131100192);
                }
            }
        }
        localObject2 = localObject1;
        if (isPushPM()) {
            localObject2 = localObject1;
            if (localSharedPreferences.contains(getId() + paramActivity.getResources().getString(2131100355))) {
                localObject2 = localObject1;
                if (localSharedPreferences.getBoolean(getId() + paramActivity.getResources().getString(2131100355), false)) {
                    localObject2 = paramActivity.getString(2131100192);
                }
            }
        }
        localObject1 = localObject2;
        if (isPushSub()) {
            localObject1 = localObject2;
            if (localSharedPreferences.contains(getId() + paramActivity.getResources().getString(2131100356))) {
                localObject1 = localObject2;
                if (localSharedPreferences.getBoolean(getId() + paramActivity.getResources().getString(2131100356), false)) {
                    if ((localObject2 == null) || (((String) localObject2).length() <= 0)) {
                        break label898;
                    }
                    localObject1 = localObject2 + " / " + paramActivity.getString(2131100363);
                }
            }
        }
        localObject2 = localObject1;
        if (isPushLike()) {
            localObject2 = localObject1;
            if (localSharedPreferences.contains(getId() + paramActivity.getResources().getString(2131100357))) {
                localObject2 = localObject1;
                if (localSharedPreferences.getBoolean(getId() + paramActivity.getResources().getString(2131100357), false)) {
                    if ((localObject1 == null) || (((String) localObject1).length() <= 0)) {
                        break label909;
                    }
                    localObject2 = localObject1 + " / " + paramActivity.getString(2131100364);
                }
            }
        }
        label488:
        localObject1 = localObject2;
        if (isPushQuote()) {
            localObject1 = localObject2;
            if (localSharedPreferences.contains(getId() + paramActivity.getResources().getString(2131100358))) {
                localObject1 = localObject2;
                if (localSharedPreferences.getBoolean(getId() + paramActivity.getResources().getString(2131100358), false)) {
                    if ((localObject2 == null) || (((String) localObject2).length() <= 0)) {
                        break label920;
                    }
                    localObject1 = localObject2 + " / " + paramActivity.getString(2131100365);
                }
            }
        }
        label624:
        localObject2 = localObject1;
        if (isPushTag()) {
            localObject2 = localObject1;
            if (localSharedPreferences.contains(getId() + paramActivity.getResources().getString(2131100360))) {
                localObject2 = localObject1;
                if (localSharedPreferences.getBoolean(getId() + paramActivity.getResources().getString(2131100360), false)) {
                    if ((localObject1 == null) || (((String) localObject1).length() <= 0)) {
                        break label931;
                    }
                }
            }
        }
        label898:
        label909:
        label920:
        label931:
        for (localObject2 = localObject1 + " / " + paramActivity.getString(2131100366); ; localObject2 = paramActivity.getString(2131100366)) {
            localObject1 = localObject2;
            if (isPushNewTopic()) {
                localObject1 = localObject2;
                if (localSharedPreferences.contains(getId() + paramActivity.getResources().getString(2131100359))) {
                    localObject1 = localObject2;
                    if (localSharedPreferences.getBoolean(getId() + paramActivity.getResources().getString(2131100359), false)) {
                        if ((localObject2 == null) || (((String) localObject2).length() <= 0)) {
                            break label942;
                        }
                        localObject1 = localObject2 + " / " + paramActivity.getString(2131100367);
                    }
                }
            }
            return (String) localObject1;
            localObject1 = paramActivity.getString(2131100363);
            break;
            localObject2 = paramActivity.getString(2131100364);
            break label488;
            localObject1 = paramActivity.getString(2131100365);
            break label624;
        }
        label942:
        return paramActivity.getString(2131100367);
    }

    public String getOutBoxId() {
        return this.outBoxId;
    }

    public String getParentCategory() {
        return this.parentCategory;
    }

    public String getPassword() {
        Object localObject = new PasswordCrypt();
        ((PasswordCrypt) localObject).setPassword("3x5sxzdbb1s");
        try {
            String str = ((PasswordCrypt) localObject).decrypt(this.password);
            if (str != null) {
                localObject = str;
                if (str.length() != 0) {
                }
            } else {
                localObject = this.password;
            }
            return (String) localObject;
        } catch (Exception localException) {
        }
        return this.password;
    }

    public int getPoistionInData() {
        return this.poistionInData;
    }

    public String getPrimaryKey() {
        return getId() + getLowerUserName();
    }

    public String getPropertyCode() {
        return this.propertyCode;
    }

    public String getRawPassword() {
        return this.password;
    }

    public int getSignatureType() {
        return this.signatureType;
    }

    public String getSlotName() {
        return this.slotName;
    }

    public String getSlotNameWeb() {
        return this.slotNameWeb;
    }

    public Integer getTapatalkUserCount() {
        return this.mTapatalkUserCount;
    }

    public Integer getTotalThreads() {
        return this.mTotalThreads;
    }

    public String getType() {
        return this.type;
    }

    public int getUnreadPMNotificaion() {
        return this.unreadPMNotificaion;
    }

    public int getUnreadSubNotificaion() {
        return this.unreadSubNotificaion;
    }

    public String getUrl() {
        return this.url;
    }

    public Bitmap getUserIcon() {
        return this.userIcon;
    }

    public String getUserIconUrl() {
        return this.userIconUrl;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getUserName() {
        if (this.userName != null) {
            this.userName = this.userName.trim();
        }
        return this.userName;
    }

    public String getUserNameOrDisplayName() {
        if ((getUserName() != null) && (!this.userName.equals(""))) {
            return this.userName;
        }
        if ((getDisplayName() != null) && (!getDisplayName().equals(""))) {
            return getDisplayName();
        }
        return "";
    }

    public String getVersion() {
        return this.mVersion;
    }

    public String getmUseEmail() {
        return this.mUseEmail;
    }

    public boolean hasPassword() {
        return (this.password != null) && (this.password.length() != 0);
    }

    public boolean hasUsername() {
        return (getUserName() != null) && (getUserName().length() > 0);
    }

    public boolean isCanSignInWithTapatalkId(Activity paramActivity) {
        return this.canSignInWithTapatalkId;
    }

    public boolean isFeed() {
        return this.isFeed;
    }

    public boolean isHasImage() {
        return this.hasImage;
    }

    public boolean isHasPushKey() {
        return this.hasPushKey;
    }

    public boolean isHide() {
        if (this.hide == null) {
        }
        while (this.hide.intValue() != 1) {
            return false;
        }
        return true;
    }

    public boolean isMedia_sharing() {
        return this.media_sharing;
    }

    public boolean isPMEnable() {
        return this.isPMEnable;
    }

    public Integer isPRSupport() {
        return Integer.valueOf(this.isPR);
    }

    public boolean isPush() {
        return this.isPush;
    }

    public boolean isPushConv() {
        return this.isPushConv;
    }

    public boolean isPushLike() {
        return this.isPushLike;
    }

    public boolean isPushNewTopic() {
        return this.isPushNewTopic;
    }

    public boolean isPushPM() {
        return this.isPushPM;
    }

    public boolean isPushQuote() {
        return this.isPushQuote;
    }

    public boolean isPushSub() {
        return this.isPushSub;
    }

    public boolean isPushTag() {
        return this.isPushTag;
    }

    public boolean isPushThank() {
        return this.isPushThank;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public boolean isSupportConve() {
        return this.isSupportConve;
    }

    public boolean isSupportMD5() {
        return this.isMD5;
    }

    public boolean isSupportTkUpload() {
        return this.supportTkUpload;
    }

    public boolean isViglinkSupport() {
        return this.viglinkSupport;
    }

    public void openTapatalkForum(Activity paramActivity, boolean paramBoolean) {
        openTapatalkForum(paramActivity, paramBoolean, false, null, "account");
    }

    public void openTapatalkForum(Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2, String paramString) {
        openTapatalkForum(paramActivity, paramBoolean1, paramBoolean2, null, paramString);
    }

    public void openTapatalkForum(Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2, HashMap<String, String> paramHashMap, String paramString) {
        Intent localIntent = new Intent();
        localIntent.setClass(paramActivity, SlidingMenuActivity.class);
        localIntent.putExtra("forum", this);
        if (paramHashMap != null) {
            if (!paramHashMap.containsKey("pid")) {
                break label207;
            }
            localIntent.putExtra("pid", (String) paramHashMap.get("pid"));
        }
        for (; ; ) {
            paramHashMap = new FavoriateSqlHelper(paramActivity, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version)).getFavrivateById(getId());
            if ((paramHashMap != null) && (paramHashMap.getUserName() != null) && (paramHashMap.getUserName().equalsIgnoreCase(getUserName()))) {
                setPassword(paramHashMap.getPassword());
                setSupportConve(paramHashMap.isSupportConve);
                setPMEnable(paramHashMap.isPMEnable);
            }
            localIntent.putExtra("shouldLogin", paramBoolean1);
            localIntent.putExtra("isGoFeed", paramBoolean2);
            localIntent.putExtra("channel", paramString);
            if (!(paramActivity instanceof IcsRecommendActivity)) {
                break;
            }
            paramActivity.startActivityForResult(localIntent, 100);
            return;
            label207:
            if (paramHashMap.containsKey("tid")) {
                localIntent.putExtra("tid", (String) paramHashMap.get("tid"));
            } else if (paramHashMap.containsKey("fid")) {
                localIntent.putExtra("fid", (String) paramHashMap.get("fid"));
            }
        }
        paramActivity.startActivity(localIntent);
    }

    public void report(Context paramContext) {
        TapatalkJsonEngine.callLogin(paramContext, TapatalkJsonEngine.REPORT_FORUMS + "?fid=" + getId());
    }

    public void saveIconToFile(Context paramContext) {
        if ((getIconUrl() != null) && (Util.checkLocalData(getLocalIconUri()))) {
            try {
                FileInputStream localFileInputStream = new FileInputStream(getLocalIconUri());
                paramContext.deleteFile(getIconUrl().hashCode());
                paramContext = paramContext.openFileOutput(getIconUrl().hashCode(), 0);
                byte[] arrayOfByte = new byte['Ѐ'];
                for (; ; ) {
                    int i = localFileInputStream.read(arrayOfByte);
                    if (i <= 0) {
                        localFileInputStream.close();
                        paramContext.flush();
                        paramContext.close();
                        return;
                    }
                    paramContext.write(arrayOfByte, 0, i);
                }
                return;
            } catch (Exception paramContext) {
                paramContext.printStackTrace();
            }
        }
    }

    public void setApiLevel(int paramInt) {
        this.apiLevel = paramInt;
    }

    public void setCanSignInWithTapatalkId(boolean paramBoolean) {
        this.canSignInWithTapatalkId = paramBoolean;
    }

    public void setCategoryName(String paramString) {
        this.categoryName = paramString;
    }

    public void setCms_url(String paramString) {
        this.cms_url = paramString;
    }

    public void setCreationDate(Date paramDate) {
        this.creationDate = paramDate;
    }

    public void setCurrentUserSso(boolean paramBoolean) {
        this.isCurrentUserSso = paramBoolean;
    }

    public void setDescription(String paramString) {
        this.description = paramString;
    }

    public void setDfp(int paramInt) {
        this.dfp = paramInt;
    }

    public void setDisplayName(String paramString) {
        this.displayName = paramString;
    }

    public void setExt(String paramString) {
        this.ext = paramString;
    }

    public void setFeed(boolean paramBoolean) {
        this.isFeed = paramBoolean;
    }

    public void setFolder(String paramString) {
        this.folder = paramString;
    }

    public void setForumUrl(String paramString) {
        this.forumUrl = paramString;
    }

    public void setFromByoAccountChannel(String paramString) {
        this.isFromByoAccountChannel = paramString;
    }

    public void setGa(String paramString) {
        this.ga = paramString;
    }

    public void setHasImage(boolean paramBoolean) {
        this.hasImage = paramBoolean;
    }

    public void setHasPushKey(boolean paramBoolean) {
        this.hasPushKey = paramBoolean;
    }

    public void setHide(Integer paramInteger) {
        this.hide = paramInteger;
    }

    public void setIab_catid(Integer paramInteger) {
        this.iab_catid = paramInteger;
    }

    public void setIconUrl(String paramString) {
        this.iconUrl = paramString;
    }

    public void setId(Integer paramInteger) {
        this.id = paramInteger;
        if (this.account != null) {
            this.account.setForumId(paramInteger.intValue());
        }
    }

    public void setInboxId(String paramString) {
        this.inboxId = paramString;
    }

    public void setIsPT(int paramInt) {
        this.isPT = paramInt;
    }

    public void setLocalIconUri(String paramString, Context paramContext) {
        this.localIconUri = paramString;
        saveIconToFile(paramContext);
    }

    public void setMD5(boolean paramBoolean) {
        this.isMD5 = paramBoolean;
    }

    public void setMedia_sharing(boolean paramBoolean) {
        this.media_sharing = paramBoolean;
    }

    public void setName(String paramString) {
        this.name = paramString;
    }

    public void setNetworkCode(String paramString) {
        this.networkCode = paramString;
    }

    public void setOutBoxId(String paramString) {
        this.outBoxId = paramString;
    }

    public void setPMEnable(boolean paramBoolean) {
        this.isPMEnable = paramBoolean;
    }

    public void setParentCategory(String paramString) {
        this.parentCategory = paramString;
    }

    public void setPassword(String paramString) {
        this.password = paramString;
    }

    public void setPoistionInData(int paramInt) {
        this.poistionInData = paramInt;
    }

    public void setPropertyCode(String paramString) {
        this.propertyCode = paramString;
    }

    public void setPush(boolean paramBoolean) {
        this.isPush = paramBoolean;
    }

    public void setPushConv(boolean paramBoolean) {
        this.isPushConv = paramBoolean;
    }

    public void setPushLike(boolean paramBoolean) {
        this.isPushLike = paramBoolean;
    }

    public void setPushNewTopic(boolean paramBoolean) {
        this.isPushNewTopic = paramBoolean;
    }

    public void setPushPM(boolean paramBoolean) {
        this.isPushPM = paramBoolean;
    }

    public void setPushQuote(boolean paramBoolean) {
        this.isPushQuote = paramBoolean;
    }

    public void setPushSub(boolean paramBoolean) {
        this.isPushSub = paramBoolean;
    }

    public void setPushTag(boolean paramBoolean) {
        this.isPushTag = paramBoolean;
    }

    public void setPushThank(boolean paramBoolean) {
        this.isPushThank = paramBoolean;
    }

    public void setRawPassword(String paramString) {
        this.password = paramString;
    }

    public void setSelected(boolean paramBoolean) {
        this.isSelected = paramBoolean;
    }

    public void setSignatureType(int paramInt) {
        this.signatureType = paramInt;
    }

    public void setSlotName(String paramString) {
        this.slotName = paramString;
    }

    public void setSlotNameWeb(String paramString) {
        this.slotNameWeb = paramString;
    }

    public void setSupportConve(boolean paramBoolean) {
        this.isSupportConve = paramBoolean;
    }

    public void setSupportTkUpload(boolean paramBoolean) {
        this.supportTkUpload = paramBoolean;
    }

    public void setSupportedPR(int paramInt) {
        this.isPR = paramInt;
    }

    public void setTapatalkUserCount(Integer paramInteger) {
        this.mTapatalkUserCount = paramInteger;
    }

    public void setTotalThreads(Integer paramInteger) {
        this.mTotalThreads = paramInteger;
    }

    public void setType(String paramString) {
        this.type = paramString;
    }

    public void setUnEncodePassword(String paramString) {
        if (paramString == null) {
            return;
        }
        String str = paramString;
        if (this.isMD5) {
            str = Util.getMD5(paramString);
        }
        paramString = new PasswordCrypt();
        paramString.setPassword("3x5sxzdbb1s");
        this.password = paramString.encrypt(str);
    }

    public void setUnreadPMNotificaion(int paramInt) {
        this.unreadPMNotificaion = paramInt;
    }

    public void setUnreadSubNotificaion(int paramInt) {
        this.unreadSubNotificaion = paramInt;
    }

    public void setUrl(String paramString) {
        this.url = paramString;
    }

    public void setUserIcon(Bitmap paramBitmap) {
        this.userIcon = paramBitmap;
    }

    public void setUserIconUrl(String paramString) {
        this.userIconUrl = paramString;
    }

    public void setUserId(String paramString) {
        this.userId = paramString;
    }

    public void setUserName(String paramString) {
        this.userName = paramString;
    }

    public void setVersion(String paramString) {
        this.mVersion = paramString;
    }

    public void setViglinkSupport(boolean paramBoolean) {
        this.viglinkSupport = paramBoolean;
    }

    public void setmUseEmail(String paramString) {
        this.mUseEmail = paramString;
    }

    public void setmVersion(String paramString, Context paramContext) {
        if (paramString.startsWith("wbb")) {
            paramContext = Prefs.get(paramContext).edit();
            paramContext.putBoolean("should_rate", false);
            paramContext.commit();
        }
        for (; ; ) {
            this.mVersion = paramString;
            return;
            if (paramString.startsWith("dev")) {
                paramContext = Prefs.get(paramContext).edit();
                paramContext.putBoolean("should_rate", false);
                paramContext.commit();
            }
        }
    }

    private static class ViewHolder {
        TextView category;
        TextView description;
        ImageView icon;
        TextView text;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/bean/TapatalkForum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */