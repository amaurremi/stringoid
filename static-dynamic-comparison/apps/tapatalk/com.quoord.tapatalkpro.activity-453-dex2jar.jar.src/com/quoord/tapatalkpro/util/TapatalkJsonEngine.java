package com.quoord.tapatalkpro.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.action.TapatalkAccountAction;
import com.quoord.tapatalkpro.adapter.CallBackInterface;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tools.tracking.GoogleAnalyticsTools;
import com.quoord.xmlrpc.XMLRPCClient;
import com.quoord.xmlrpc.XmlRpcParser;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.security.KeyStore;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.json.JSONArray;
import org.json.JSONObject;
import org.kxml2.io.KXmlParser;

public class TapatalkJsonEngine {
    public static String AB_TID_CARD_REG = "https://log.tapatalk.com/ab_tid_card_reg.php";
    public static String API_IMAGE;
    public static String APP_SESSION;
    public static String AU_ADD_ACCOUNT;
    public static String AU_ADD_SUSCRIBED_FORUM;
    public static String AU_DELETE_ACCONT;
    public static String AU_DELETE_IMAGE;
    public static String AU_DELETE_SUBSCRIBED_FORUM;
    public static String AU_GET_ACCONT;
    public static String AU_GET_FEED;
    public static String AU_GET_IMAGE;
    public static String AU_GET_INFO;
    public static String AU_GET_SUSCRIBED_FORUMS;
    public static String AU_IDENTIFY;
    public static String AU_INVITE_USER;
    public static String AU_LOG_TOPIC_SUBSCRIPTION;
    public static String AU_UPDATE_ACCOUNT_ORDER;
    public static String AU_UPDATE_FEED;
    public static String AU_UPDATE_PUSH_SETTING;
    public static String CHANGE_PASS_WORD;
    public static String CHECK_PLUGIN_VERSION;
    public static String COMMON;
    public static String FEED_LOG;
    public static String FEED_TRENDING_TOPIC_THUMBUP = "http://search.tapatalk.com/api/thumbup";
    public static String FILE_UPLOAD;
    public static String FORUMS_CATEGORY;
    public static String GETFORUM_DEVICE;
    public static String GET_BIND_VIMEO;
    public static String GET_CATEGORY;
    public static String GET_CA_PUPULAR;
    public static String GET_FEED_FORUMS_PUSH;
    public static String GET_FEED_TOPICS_PUSH;
    public static String GET_FORUMS;
    public static String GET_FORUM_BY_BYO_ACCOUNT;
    public static String GET_FORUM_BY_URL;
    public static String GET_FUNCTION_CONFIG;
    public static String GET_IAB_RECOMMOND_FORUMS;
    public static String GET_MULTI_POPULAR;
    public static String GET_NESTED;
    public static String GET_POPULAR;
    public static String GET_RECOMMENDED;
    public static String GET_RECOMMEND_FORUMS_BY_FIDS;
    public static String GET_REMOVE_VIMEO;
    public static String GET_ROOT;
    public static String GET_SEARCH_TERMS;
    public static String GET_UPLOAD_VIMEO_COMPLETE;
    public static String GET_UPLOAD_VIMEO_TICKET;
    public static String ICS_SEARCH_FORUM;
    public static String ICS_SEARCH_TOPIC;
    public static String IMAGE;
    public static String LOG_CONV;
    public static String LOG_RECOMMEND_PUSH;
    public static String LOG_RECOMMEND_TOPIC;
    public static String LOG_TOPIC;
    public static String LOG_TOP_TOPIC;
    public static String MANAGE_ACCOUNT_URL;
    public static String MIGRATE_TWITTER_WITH_EMAIL;
    public static String NESTED_CATEGORY = "https://directory.tapatalk.com/get_nested_category2.json";
    public static String NEW_PM;
    public static String NEW_SESSION;
    public static String NEW_TOPIC;
    public static String OB_GET_IAB_CATEGORY;
    public static String REGIEST;
    public static String REGIEST_RB;
    public static String REGISTER_TAPATALK_ID_LOG;
    public static String REPLAY_POST;
    public static String REPORT_FORUMS;
    public static String RESEDNG;
    public static String RESET_PASS_WORD;
    public static String ROOT_CATEGORY = "https://directory.tapatalk.com/get_root_category.php";
    public static String SEARCH;
    public static String SIGNIN;
    public static String SIGNINWITHFACEBOOK;
    public static String SIGNINWITHGOOGLE;
    public static String SIGNINWITHTWITTER;
    public static String SIGNIN_LOG;
    public static String SIGNUP;
    public static String SUB_TOPIC;
    public static String UPLOAD_AVATAR;
    public static String UPLOAD_PROFILE;
    public static String V2_SEARCH;
    private static boolean useBackUp = false;
    private Context context;
    private CallBackInterface mAdapter = null;
    private Object result = null;

    static {
        GET_ROOT = "https://directory.tapatalk.com/get_iab_root_category.json";
        GET_NESTED = "https://directory.tapatalk.com/get_iab_nested_category.json";
        GET_CATEGORY = "https://directory.tapatalk.com/get_random_forums_by_iab_category.php";
        SEARCH = "https://directory.tapatalk.com/search.php";
        FORUMS_CATEGORY = "https://directory.tapatalk.com/get_forums_by_iab_category.php";
        GETFORUM_DEVICE = "https://directory.tapatalk.com/get_forums_by_device_id.php";
        GET_FORUMS = "https://directory.tapatalk.com/get_forums.php";
        REPORT_FORUMS = "https://directory.tapatalk.com/report_forum.php";
        NEW_SESSION = "https://log.tapatalk.com/new_session.php";
        REPLAY_POST = "https://log.tapatalk.com/reply_post.php";
        SUB_TOPIC = "https://log.tapatalk.com/subscribed_topic.php";
        NEW_PM = "https://log.tapatalk.com/new_pm.php";
        LOG_CONV = "https://log.tapatalk.com/new_convo.php";
        REGIEST = "https://log.tapatalk.com/register_token.php";
        GET_RECOMMENDED = "https://directory.tapatalk.com/get_recommended.php";
        NEW_TOPIC = "https://log.tapatalk.com/new_topic.php";
        FILE_UPLOAD = "https://log.tapatalk.com/file_upload.php";
        COMMON = "https://log.tapatalk.com/common.php";
        IMAGE = "http://log.tapatalk.com/image_download.php";
        SIGNUP = "https://directory.tapatalk.com/au_sign_up.php";
        SIGNIN = "https://directory.tapatalk.com/au_sign_in.php";
        MIGRATE_TWITTER_WITH_EMAIL = "https://directory.tapatalk.com/migrate_twitter_with_email.php";
        RESEDNG = "https://directory.tapatalk.com/au_resend_code.php";
        AU_ADD_ACCOUNT = "https://directory.tapatalk.com/au_add_account.php";
        AU_DELETE_IMAGE = "https://directory.tapatalk.com/au_delete_image.php";
        AU_GET_IMAGE = "https://directory.tapatalk.com/au_get_images.php";
        CHANGE_PASS_WORD = "https://directory.tapatalk.com/au_change_password.php";
        RESET_PASS_WORD = "https://directory.tapatalk.com/au_reset_password.php";
        AU_GET_ACCONT = "https://directory.tapatalk.com/au_get_accounts.php";
        AU_GET_INFO = "https://directory.tapatalk.com/au_get_info.php";
        AU_DELETE_ACCONT = "https://directory.tapatalk.com/au_delete_account.php";
        SIGNINWITHTWITTER = "https://directory.tapatalk.com/au_sign_in_twitter.php";
        SIGNINWITHFACEBOOK = "https://directory.tapatalk.com/au_sign_in_facebook.php";
        SIGNINWITHGOOGLE = "https://directory.tapatalk.com/au_sign_in_google.php";
        CHECK_PLUGIN_VERSION = "https://directory.tapatalk.com/check_plugin_version.php";
        AU_ADD_SUSCRIBED_FORUM = "https://directory.tapatalk.com/au_add_subscribed_forum.php";
        AU_GET_SUSCRIBED_FORUMS = "https://directory.tapatalk.com/au_get_subscribed_forums.php";
        AU_DELETE_SUBSCRIBED_FORUM = "https://directory.tapatalk.com/au_delete_subscribed_forum.php";
        REGIEST_RB = "https://log.tapatalk.com/register_token_rb.php";
        SIGNIN_LOG = "https://directory.tapatalk.com/au_log_signin.php";
        AU_UPDATE_PUSH_SETTING = "https://directory.tapatalk.com/au_update_push_setting.php";
        APP_SESSION = "https://log.tapatalk.com/app_session.php";
        GET_FUNCTION_CONFIG = "https://directory.tapatalk.com/get_function_config.php";
        GET_FORUM_BY_URL = "https://directory.tapatalk.com/get_forum_by_url.php";
        GET_CA_PUPULAR = "https://search.tapatalk.com/api/cat_popular";
        GET_MULTI_POPULAR = "https://search.tapatalk.com/api/popular/multi_forum";
        GET_POPULAR = "https://search.tapatalk.com/api/popular";
        GET_IAB_RECOMMOND_FORUMS = "https://directory.tapatalk.com/get_recommend_forums_by_iab_category.php";
        V2_SEARCH = "https://search.tapatalk.com/v2/search";
        GET_FEED_FORUMS_PUSH = "https://directory.tapatalk.com/au_get_recommended_forums.php";
        GET_FEED_TOPICS_PUSH = "https://search.tapatalk.com/api/popular/recommend";
        LOG_RECOMMEND_TOPIC = "https://log.tapatalk.com/recommend_topic.php";
        LOG_TOP_TOPIC = "http://log.tapatalk.com/log_top_topic_push.php";
        GET_SEARCH_TERMS = "https://directory.tapatalk.com/get_search_hot_terms.php";
        AU_GET_FEED = "https://directory.tapatalk.com/au_get_feed.php";
        AU_UPDATE_FEED = "https://directory.tapatalk.com/au_update_feed.php";
        AU_UPDATE_ACCOUNT_ORDER = "https://directory.tapatalk.com/au_update_account_order.php";
        REGISTER_TAPATALK_ID_LOG = "http://log.tapatalk.com/notify_register.php?is_reg=";
        LOG_RECOMMEND_PUSH = "https://log.tapatalk.com/recommend_push.php";
        LOG_TOPIC = "http://search.tapatalk.com/log/log_topic";
        GET_RECOMMEND_FORUMS_BY_FIDS = "https://directory.tapatalk.com/get_recommend_forums_by_fids.php";
        AU_LOG_TOPIC_SUBSCRIPTION = "https://directory.tapatalk.com/au_log_topic_subscription.php";
        MANAGE_ACCOUNT_URL = "https://directory.tapatalk.com/id/manage.php";
        AU_IDENTIFY = "https://directory.tapatalk.com/au_identify.php";
        AU_INVITE_USER = "https://directory.tapatalk.com/au_invite_user.php";
        ICS_SEARCH_FORUM = "https://search.tapatalk.com/search_forum";
        ICS_SEARCH_TOPIC = "https://search.tapatalk.com/search_topic";
        OB_GET_IAB_CATEGORY = "https://directory.tapatalk.com/get_ob_forums_by_iab_category.php";
        UPLOAD_AVATAR = "https://search.tapatalk.com/action/upload_avatar";
        UPLOAD_PROFILE = "https://directory.tapatalk.com/au_update_profile.php";
        API_IMAGE = "https://search.tapatalk.com/api/image?fid=";
        GET_FORUM_BY_BYO_ACCOUNT = "https://directory.tapatalk.com/get_forums_by_byo_accounts.php";
        FEED_LOG = "http://search.tapatalk.com/log/log_feed";
        GET_UPLOAD_VIMEO_TICKET = "https://directory.tapatalk.com/vimeolib/ticket.php";
        GET_UPLOAD_VIMEO_COMPLETE = "https://directory.tapatalk.com/vimeolib/complete.php";
        GET_BIND_VIMEO = "https://directory.tapatalk.com/vimeolib/bind.php";
        GET_REMOVE_VIMEO = "https://directory.tapatalk.com/vimeolib/remove.php";
    }

    public TapatalkJsonEngine(Context paramContext, CallBackInterface paramCallBackInterface) {
        this.mAdapter = paramCallBackInterface;
        this.context = paramContext;
    }

    public static void auAddAccount(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt) {
        auAddAccount(paramContext, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, "", paramInt, 0);
    }

    public static void auAddAccount(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, TapatalkForum paramTapatalkForum) {
        auAddAccount(paramContext, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, "", TapatalkAccountAction.getCurrentForumOrder(paramContext, paramTapatalkForum), 0);
    }

    public static void auAddAccount(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt1, int paramInt2) {
        if (!paramContext.getResources().getBoolean(2131558401)) {
            boolean bool = Prefs.get(paramContext).getBoolean("login", false);
            int i = Prefs.get(paramContext).getInt("tapatalk_auid", -1);
            if ((bool) && (i >= 0)) {
                String str2 = Prefs.get(paramContext).getString("token", "");
                String str1;
                if (paramString5 != null) {
                    str1 = paramString5;
                    if (!paramString5.equals("")) {
                    }
                } else {
                    str1 = "0";
                }
                paramString5 = AU_ADD_ACCOUNT + "?au_id=" + i + "&token=" + str2 + "&fid=" + paramString1 + "&use_au_email=" + str1;
                paramString1 = paramString5;
                if (paramString2 != null) {
                    paramString1 = paramString5;
                    if (!paramString2.equals("")) {
                        paramString1 = paramString5 + "&username=" + URLEncoder.encode(paramString2);
                    }
                }
                paramString2 = paramString1;
                if (paramString3 != null) {
                    paramString2 = paramString1;
                    if (!paramString3.equals("")) {
                        paramString2 = paramString1 + "&display_name=" + URLEncoder.encode(paramString3);
                    }
                }
                paramString1 = paramString2;
                if (paramString4 != null) {
                    paramString1 = paramString2;
                    if (!paramString4.equals("")) {
                        paramString1 = paramString2 + "&uid=" + paramString4;
                    }
                }
                paramString2 = paramString1;
                if (paramString6 != null) {
                    paramString2 = paramString1;
                    if (!paramString6.equals("")) {
                        paramString2 = paramString1 + "&channel=" + paramString6;
                    }
                }
                paramString1 = paramString2;
                if (paramString7 != null) {
                    paramString1 = paramString2;
                    if (!paramString7.equals("")) {
                        paramString1 = paramString2 + "&email=" + URLEncoder.encode(paramString7);
                    }
                }
                paramString2 = paramString1 + "&list_order=" + paramInt1;
                paramString1 = paramString2;
                if (paramInt2 != 0) {
                    paramString1 = paramString2 + "&post=" + paramInt2;
                }
                callLogin(paramContext, paramString1);
            }
        }
    }

    public static void auAddAccount(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt, TapatalkForum paramTapatalkForum) {
        auAddAccount(paramContext, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, TapatalkAccountAction.getCurrentForumOrder(paramContext, paramTapatalkForum), paramInt);
    }

    public static void auUpdatePushSetting(final Context paramContext, final String paramString1, final String paramString2, Map paramMap) {
        new Thread() {
            public void run() {
                String str = "";
                Iterator localIterator = TapatalkJsonEngine.this.keySet().iterator();
                for (; ; ) {
                    if (!localIterator.hasNext()) {
                        str = TapatalkJsonEngine.AU_UPDATE_PUSH_SETTING + "?" + "fid=" + paramString1 + "&uid=" + paramString2 + str;
                        TapatalkJsonEngine.callLogin(paramContext, str, true);
                        return;
                    }
                    Object localObject = localIterator.next();
                    if (((Integer) TapatalkJsonEngine.this.get(localObject)).intValue() == 1) {
                        str = str + "&" + localObject.toString() + "=1";
                    } else {
                        str = str + "&" + localObject.toString() + "=0";
                    }
                }
            }
        }.start();
    }

    public static void callLogin(Context paramContext, String paramString) {
        callLogin(paramContext, paramString, false);
    }

    public static void callLogin(final Context paramContext, String paramString, final boolean paramBoolean) {
        if (paramString.contains("directory")) {
            GoogleAnalyticsTools.trackEvent(paramContext, "network", paramString.replace("https://directory.tapatalk.com/", "").replaceAll("\\..*?$", ""));
        }
        new Thread() {
            /* Error */
            public void run() {
                // Byte code:
                //   0: aload_0
                //   1: getfield 19	com/quoord/tapatalkpro/util/TapatalkJsonEngine$3:val$url	Ljava/lang/String;
                //   4: ldc 36
                //   6: invokevirtual 42	java/lang/String:endsWith	(Ljava/lang/String;)Z
                //   9: ifeq +357 -> 366
                //   12: new 44	java/lang/StringBuilder
                //   15: dup
                //   16: aload_0
                //   17: getfield 19	com/quoord/tapatalkpro/util/TapatalkJsonEngine$3:val$url	Ljava/lang/String;
                //   20: invokestatic 48	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
                //   23: invokespecial 51	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
                //   26: getstatic 56	com/quoord/tapatalkpro/TapatalkApp:APP_KEY	Ljava/lang/String;
                //   29: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
                //   32: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
                //   35: astore_2
                //   36: new 44	java/lang/StringBuilder
                //   39: dup
                //   40: aload_2
                //   41: invokestatic 48	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
                //   44: invokespecial 51	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
                //   47: ldc 66
                //   49: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
                //   52: aload_0
                //   53: getfield 21	com/quoord/tapatalkpro/util/TapatalkJsonEngine$3:val$context	Landroid/content/Context;
                //   56: invokestatic 72	com/quoord/tapatalkpro/util/Util:getDeviceLocal	(Landroid/content/Context;)Ljava/lang/String;
                //   59: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
                //   62: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
                //   65: astore_2
                //   66: new 74	org/apache/http/conn/scheme/SchemeRegistry
                //   69: dup
                //   70: invokespecial 75	org/apache/http/conn/scheme/SchemeRegistry:<init>	()V
                //   73: astore_3
                //   74: invokestatic 80	java/security/KeyStore:getDefaultType	()Ljava/lang/String;
                //   77: invokestatic 84	java/security/KeyStore:getInstance	(Ljava/lang/String;)Ljava/security/KeyStore;
                //   80: astore 4
                //   82: aload 4
                //   84: aconst_null
                //   85: aconst_null
                //   86: invokevirtual 88	java/security/KeyStore:load	(Ljava/io/InputStream;[C)V
                //   89: new 90	com/quoord/tapatalkpro/util/MySSLSocketFactory
                //   92: dup
                //   93: aload 4
                //   95: invokespecial 93	com/quoord/tapatalkpro/util/MySSLSocketFactory:<init>	(Ljava/security/KeyStore;)V
                //   98: astore 4
                //   100: aload 4
                //   102: getstatic 99	org/apache/http/conn/ssl/SSLSocketFactory:ALLOW_ALL_HOSTNAME_VERIFIER	Lorg/apache/http/conn/ssl/X509HostnameVerifier;
                //   105: invokevirtual 103	org/apache/http/conn/ssl/SSLSocketFactory:setHostnameVerifier	(Lorg/apache/http/conn/ssl/X509HostnameVerifier;)V
                //   108: aload_3
                //   109: new 105	org/apache/http/conn/scheme/Scheme
                //   112: dup
                //   113: ldc 107
                //   115: aload 4
                //   117: sipush 443
                //   120: invokespecial 110	org/apache/http/conn/scheme/Scheme:<init>	(Ljava/lang/String;Lorg/apache/http/conn/scheme/SocketFactory;I)V
                //   123: invokevirtual 114	org/apache/http/conn/scheme/SchemeRegistry:register	(Lorg/apache/http/conn/scheme/Scheme;)Lorg/apache/http/conn/scheme/Scheme;
                //   126: pop
                //   127: new 116	org/apache/http/params/BasicHttpParams
                //   130: dup
                //   131: invokespecial 117	org/apache/http/params/BasicHttpParams:<init>	()V
                //   134: astore 4
                //   136: aload 4
                //   138: getstatic 123	org/apache/http/HttpVersion:HTTP_1_1	Lorg/apache/http/HttpVersion;
                //   141: invokestatic 129	org/apache/http/params/HttpProtocolParams:setVersion	(Lorg/apache/http/params/HttpParams;Lorg/apache/http/ProtocolVersion;)V
                //   144: aload 4
                //   146: ldc -125
                //   148: invokestatic 135	org/apache/http/params/HttpProtocolParams:setContentCharset	(Lorg/apache/http/params/HttpParams;Ljava/lang/String;)V
                //   151: aload_3
                //   152: new 105	org/apache/http/conn/scheme/Scheme
                //   155: dup
                //   156: ldc -119
                //   158: invokestatic 143	org/apache/http/conn/scheme/PlainSocketFactory:getSocketFactory	()Lorg/apache/http/conn/scheme/PlainSocketFactory;
                //   161: bipush 80
                //   163: invokespecial 110	org/apache/http/conn/scheme/Scheme:<init>	(Ljava/lang/String;Lorg/apache/http/conn/scheme/SocketFactory;I)V
                //   166: invokevirtual 114	org/apache/http/conn/scheme/SchemeRegistry:register	(Lorg/apache/http/conn/scheme/Scheme;)Lorg/apache/http/conn/scheme/Scheme;
                //   169: pop
                //   170: new 116	org/apache/http/params/BasicHttpParams
                //   173: dup
                //   174: invokespecial 117	org/apache/http/params/BasicHttpParams:<init>	()V
                //   177: astore 4
                //   179: aload 4
                //   181: getstatic 123	org/apache/http/HttpVersion:HTTP_1_1	Lorg/apache/http/HttpVersion;
                //   184: invokestatic 129	org/apache/http/params/HttpProtocolParams:setVersion	(Lorg/apache/http/params/HttpParams;Lorg/apache/http/ProtocolVersion;)V
                //   187: aload 4
                //   189: ldc -125
                //   191: invokestatic 135	org/apache/http/params/HttpProtocolParams:setContentCharset	(Lorg/apache/http/params/HttpParams;Ljava/lang/String;)V
                //   194: aload 4
                //   196: sipush 30000
                //   199: invokestatic 149	org/apache/http/params/HttpConnectionParams:setConnectionTimeout	(Lorg/apache/http/params/HttpParams;I)V
                //   202: aload 4
                //   204: sipush 30000
                //   207: invokestatic 152	org/apache/http/params/HttpConnectionParams:setSoTimeout	(Lorg/apache/http/params/HttpParams;I)V
                //   210: new 154	org/apache/http/impl/client/DefaultHttpClient
                //   213: dup
                //   214: new 156	org/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager
                //   217: dup
                //   218: aload 4
                //   220: aload_3
                //   221: invokespecial 159	org/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager:<init>	(Lorg/apache/http/params/HttpParams;Lorg/apache/http/conn/scheme/SchemeRegistry;)V
                //   224: aload 4
                //   226: invokespecial 162	org/apache/http/impl/client/DefaultHttpClient:<init>	(Lorg/apache/http/conn/ClientConnectionManager;Lorg/apache/http/params/HttpParams;)V
                //   229: astore_3
                //   230: new 164	org/apache/http/client/methods/HttpGet
                //   233: dup
                //   234: aload_2
                //   235: invokespecial 165	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
                //   238: astore_2
                //   239: new 167	java/util/ArrayList
                //   242: dup
                //   243: invokespecial 168	java/util/ArrayList:<init>	()V
                //   246: pop
                //   247: aload_3
                //   248: aload_2
                //   249: invokeinterface 174 2 0
                //   254: invokeinterface 180 1 0
                //   259: invokeinterface 186 1 0
                //   264: astore_3
                //   265: aconst_null
                //   266: astore_2
                //   267: aload_3
                //   268: ifnull +30 -> 298
                //   271: new 188	java/io/ByteArrayOutputStream
                //   274: dup
                //   275: invokespecial 189	java/io/ByteArrayOutputStream:<init>	()V
                //   278: astore_2
                //   279: sipush 128
                //   282: newarray <illegal type>
                //   284: astore 4
                //   286: aload_3
                //   287: aload 4
                //   289: invokevirtual 195	java/io/InputStream:read	([B)I
                //   292: istore_1
                //   293: iload_1
                //   294: iconst_m1
                //   295: if_icmpne +147 -> 442
                //   298: aload_2
                //   299: invokevirtual 198	java/io/ByteArrayOutputStream:flush	()V
                //   302: aload_2
                //   303: invokevirtual 199	java/io/ByteArrayOutputStream:toString	()Ljava/lang/String;
                //   306: invokevirtual 202	java/lang/String:trim	()Ljava/lang/String;
                //   309: astore_2
                //   310: aload_0
                //   311: getfield 23	com/quoord/tapatalkpro/util/TapatalkJsonEngine$3:val$retry	Z
                //   314: ifeq +51 -> 365
                //   317: new 204	org/json/JSONObject
                //   320: dup
                //   321: aload_2
                //   322: invokespecial 205	org/json/JSONObject:<init>	(Ljava/lang/String;)V
                //   325: ldc -49
                //   327: invokevirtual 211	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
                //   330: invokevirtual 214	java/lang/Object:toString	()Ljava/lang/String;
                //   333: ldc -40
                //   335: invokevirtual 220	java/lang/String:equals	(Ljava/lang/Object;)Z
                //   338: ifeq +27 -> 365
                //   341: aload_0
                //   342: getfield 19	com/quoord/tapatalkpro/util/TapatalkJsonEngine$3:val$url	Ljava/lang/String;
                //   345: ldc -34
                //   347: invokevirtual 226	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
                //   350: ifeq +115 -> 465
                //   353: aload_0
                //   354: getfield 21	com/quoord/tapatalkpro/util/TapatalkJsonEngine$3:val$context	Landroid/content/Context;
                //   357: aload_0
                //   358: getfield 19	com/quoord/tapatalkpro/util/TapatalkJsonEngine$3:val$url	Ljava/lang/String;
                //   361: iconst_0
                //   362: invokestatic 227	com/quoord/tapatalkpro/util/TapatalkJsonEngine:callLogin	(Landroid/content/Context;Ljava/lang/String;Z)V
                //   365: return
                //   366: aload_0
                //   367: getfield 19	com/quoord/tapatalkpro/util/TapatalkJsonEngine$3:val$url	Ljava/lang/String;
                //   370: ldc 36
                //   372: invokevirtual 226	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
                //   375: ifeq +35 -> 410
                //   378: new 44	java/lang/StringBuilder
                //   381: dup
                //   382: aload_0
                //   383: getfield 19	com/quoord/tapatalkpro/util/TapatalkJsonEngine$3:val$url	Ljava/lang/String;
                //   386: invokestatic 48	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
                //   389: invokespecial 51	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
                //   392: ldc -27
                //   394: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
                //   397: getstatic 56	com/quoord/tapatalkpro/TapatalkApp:APP_KEY	Ljava/lang/String;
                //   400: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
                //   403: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
                //   406: astore_2
                //   407: goto -371 -> 36
                //   410: new 44	java/lang/StringBuilder
                //   413: dup
                //   414: aload_0
                //   415: getfield 19	com/quoord/tapatalkpro/util/TapatalkJsonEngine$3:val$url	Ljava/lang/String;
                //   418: invokestatic 48	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
                //   421: invokespecial 51	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
                //   424: ldc 36
                //   426: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
                //   429: getstatic 56	com/quoord/tapatalkpro/TapatalkApp:APP_KEY	Ljava/lang/String;
                //   432: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
                //   435: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
                //   438: astore_2
                //   439: goto -403 -> 36
                //   442: aload_2
                //   443: aload 4
                //   445: iconst_0
                //   446: iload_1
                //   447: invokevirtual 233	java/io/ByteArrayOutputStream:write	([BII)V
                //   450: goto -164 -> 286
                //   453: astore_2
                //   454: aload_2
                //   455: invokevirtual 236	org/apache/http/client/ClientProtocolException:printStackTrace	()V
                //   458: return
                //   459: astore_2
                //   460: aload_2
                //   461: invokevirtual 237	java/lang/Exception:printStackTrace	()V
                //   464: return
                //   465: aload_0
                //   466: getfield 21	com/quoord/tapatalkpro/util/TapatalkJsonEngine$3:val$context	Landroid/content/Context;
                //   469: aload_0
                //   470: getfield 19	com/quoord/tapatalkpro/util/TapatalkJsonEngine$3:val$url	Ljava/lang/String;
                //   473: iconst_0
                //   474: invokestatic 227	com/quoord/tapatalkpro/util/TapatalkJsonEngine:callLogin	(Landroid/content/Context;Ljava/lang/String;Z)V
                //   477: return
                //   478: astore_2
                //   479: aload_2
                //   480: invokevirtual 238	java/io/IOException:printStackTrace	()V
                //   483: return
                // Local variable table:
                //   start	length	slot	name	signature
                //   0	484	0	this	3
                //   292	155	1	i	int
                //   35	408	2	localObject1	Object
                //   453	2	2	localClientProtocolException	org.apache.http.client.ClientProtocolException
                //   459	2	2	localException	Exception
                //   478	2	2	localIOException	java.io.IOException
                //   73	214	3	localObject2	Object
                //   80	364	4	localObject3	Object
                // Exception table:
                //   from	to	target	type
                //   247	265	453	org/apache/http/client/ClientProtocolException
                //   271	286	453	org/apache/http/client/ClientProtocolException
                //   286	293	453	org/apache/http/client/ClientProtocolException
                //   298	365	453	org/apache/http/client/ClientProtocolException
                //   442	450	453	org/apache/http/client/ClientProtocolException
                //   465	477	453	org/apache/http/client/ClientProtocolException
                //   74	247	459	java/lang/Exception
                //   247	265	459	java/lang/Exception
                //   271	286	459	java/lang/Exception
                //   286	293	459	java/lang/Exception
                //   298	365	459	java/lang/Exception
                //   442	450	459	java/lang/Exception
                //   454	458	459	java/lang/Exception
                //   465	477	459	java/lang/Exception
                //   479	483	459	java/lang/Exception
                //   247	265	478	java/io/IOException
                //   271	286	478	java/io/IOException
                //   286	293	478	java/io/IOException
                //   298	365	478	java/io/IOException
                //   442	450	478	java/io/IOException
                //   465	477	478	java/io/IOException
            }
        }.start();
    }

    public static Thread doAction(String paramString, final Handler paramHandler) {
        new Thread() {
            public void run() {
                EngineResponse localEngineResponse = new EngineResponse();
                for (; ; ) {
                    try {
                        if (TapatalkJsonEngine.this.endsWith("?")) {
                            localObject1 = TapatalkJsonEngine.this + TapatalkApp.APP_KEY;
                            localObject2 = new SchemeRegistry();
                            localObject3 = KeyStore.getInstance(KeyStore.getDefaultType());
                            ((KeyStore) localObject3).load(null, null);
                            localObject3 = new MySSLSocketFactory((KeyStore) localObject3);
                            ((SSLSocketFactory) localObject3).setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
                            ((SchemeRegistry) localObject2).register(new Scheme("https", (SocketFactory) localObject3, 443));
                            localObject3 = new BasicHttpParams();
                            HttpProtocolParams.setVersion((HttpParams) localObject3, HttpVersion.HTTP_1_1);
                            HttpProtocolParams.setContentCharset((HttpParams) localObject3, "UTF-8");
                            ((SchemeRegistry) localObject2).register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
                            localObject3 = new BasicHttpParams();
                            HttpProtocolParams.setVersion((HttpParams) localObject3, HttpVersion.HTTP_1_1);
                            HttpConnectionParams.setConnectionTimeout((HttpParams) localObject3, 30000);
                            HttpConnectionParams.setSoTimeout((HttpParams) localObject3, 30000);
                            HttpProtocolParams.setContentCharset((HttpParams) localObject3, "UTF-8");
                            localObject2 = new ThreadSafeClientConnManager((HttpParams) localObject3, (SchemeRegistry) localObject2);
                        }
                    } catch (SocketTimeoutException localSocketTimeoutException) {
                        Object localObject1;
                        Object localObject3;
                        byte[] arrayOfByte;
                        int i;
                        localSocketTimeoutException.printStackTrace();
                        localEngineResponse.setMethod(TapatalkJsonEngine.this);
                        localEngineResponse.setResponse("");
                        localEngineResponse.setSuccess(false);
                        Message localMessage1 = paramHandler.obtainMessage(4, localEngineResponse);
                        paramHandler.sendMessage(localMessage1);
                        return;
                        if (!((String) localObject2).startsWith("[")) {
                            continue;
                        }
                        Object localObject2 = new JSONArray((String) localObject2);
                        localEngineResponse.setMethod(localMessage1);
                        localEngineResponse.setResponse(localObject2);
                        localEngineResponse.setSuccess(true);
                        continue;
                        localEngineResponse.setMethod(localMessage1);
                        localEngineResponse.setResponse(localObject2);
                        localEngineResponse.setSuccess(true);
                        continue;
                        localEngineResponse.setMethod(localMessage1);
                        localEngineResponse.setResponse("");
                        localEngineResponse.setSuccess(false);
                        continue;
                    } catch (Exception localException2) {
                        localException2.printStackTrace();
                        localEngineResponse.setMethod(TapatalkJsonEngine.this);
                        localEngineResponse.setResponse("");
                        localEngineResponse.setSuccess(false);
                        Message localMessage2 = paramHandler.obtainMessage(4, localEngineResponse);
                        paramHandler.sendMessage(localMessage2);
                    }
                    try {
                        localObject3 = new DefaultHttpClient((ClientConnectionManager) localObject2, (HttpParams) localObject3).execute(new HttpGet((String) localObject1)).getEntity().getContent();
                        localObject2 = null;
                        if (localObject3 != null) {
                            localObject2 = new ByteArrayOutputStream();
                            arrayOfByte = new byte[''];
                            i = ((InputStream) localObject3).read(arrayOfByte);
                            if (i != -1) {
                                continue;
                            }
                        }
                        ((ByteArrayOutputStream) localObject2).flush();
                        localObject2 = ((ByteArrayOutputStream) localObject2).toString().trim();
                        if ((localObject2 == null) || (((String) localObject2).length() <= 0)) {
                            continue;
                        }
                        if (!((String) localObject2).startsWith("{")) {
                            continue;
                        }
                        localObject2 = new JSONObject((String) localObject2);
                        localEngineResponse.setMethod((String) localObject1);
                        localEngineResponse.setResponse(localObject2);
                        localEngineResponse.setSuccess(true);
                    } catch (Exception localException1) {
                        localException1.printStackTrace();
                        continue;
                    }
                    localObject1 = paramHandler.obtainMessage(4, localEngineResponse);
                    paramHandler.sendMessage((Message) localObject1);
                    return;
                    if (TapatalkJsonEngine.this.contains("?")) {
                        localObject1 = TapatalkJsonEngine.this + "&" + TapatalkApp.APP_KEY;
                    } else {
                        localObject1 = TapatalkJsonEngine.this + "?" + TapatalkApp.APP_KEY;
                        continue;
                        ((ByteArrayOutputStream) localObject2).write(arrayOfByte, 0, i);
                    }
                }
            }
        };
    }

    public static void logImage(String paramString1, final String paramString2) {
        new Thread() {
            public void run() {
                Object localObject = TapatalkJsonEngine.IMAGE + "?" + "fid=" + TapatalkJsonEngine.this + "&" + TapatalkApp.APP_KEY + "&bulk=1";
                ByteArrayEntity localByteArrayEntity = new ByteArrayEntity(paramString2.getBytes());
                HttpPost localHttpPost = new HttpPost((String) localObject);
                localHttpPost.setEntity(localByteArrayEntity);
                localObject = XMLRPCClient.getThreadSafeHttpClient((String) localObject);
                try {
                    ((HttpClient) localObject).execute(localHttpPost);
                    return;
                } catch (Exception localException) {
                    localException.printStackTrace();
                }
            }
        }.start();
    }

    public void addSubscribeForum(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {
        call(AU_ADD_SUSCRIBED_FORUM + "?au_id=" + paramString1 + "&token=" + paramString2 + "&fid=" + paramString3 + "&sfid=" + paramString4 + "&sub_only=" + paramString5 + "&name=" + paramString6);
    }

    public void call(String paramString) {
        if (paramString.contains("directory")) {
            String str = paramString.replace("https://directory.tapatalk.com/", "").replaceAll("\\..*?$", "");
            GoogleAnalyticsTools.trackEvent(this.context, "network", str);
        }
        this.mAdapter.setOpCancel(false);
        doAction(paramString, new Handler(Looper.getMainLooper()) {
            public void handleMessage(Message paramAnonymousMessage) {
                switch (paramAnonymousMessage.what) {
                }
                do {
                    return;
                    paramAnonymousMessage = (EngineResponse) paramAnonymousMessage.obj;
                } while (TapatalkJsonEngine.this.mAdapter.isOpCancel());
                try {
                    TapatalkJsonEngine.this.mAdapter.callBack(paramAnonymousMessage);
                    return;
                } catch (Exception paramAnonymousMessage) {
                    paramAnonymousMessage.printStackTrace();
                }
            }
        }).start();
    }

    public void callUri(final String paramString) {
        if (paramString.contains("directory")) {
            String str = paramString.replace("https://directory.tapatalk.com/", "").replaceAll("\\..*?$", "");
            GoogleAnalyticsTools.trackEvent(this.context, "network/", str);
        }
        this.mAdapter.setOpCancel(false);
        new AsyncTask() {
            protected EngineResponse doInBackground(String... paramAnonymousVarArgs) {
                paramAnonymousVarArgs = new EngineResponse();
                try {
                    Object localObject1 = new SchemeRegistry();
                    Object localObject2 = KeyStore.getInstance(KeyStore.getDefaultType());
                    ((KeyStore) localObject2).load(null, null);
                    localObject2 = new MySSLSocketFactory((KeyStore) localObject2);
                    ((SSLSocketFactory) localObject2).setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
                    ((SchemeRegistry) localObject1).register(new Scheme("https", (SocketFactory) localObject2, 443));
                    localObject2 = new BasicHttpParams();
                    HttpProtocolParams.setVersion((HttpParams) localObject2, HttpVersion.HTTP_1_1);
                    HttpProtocolParams.setContentCharset((HttpParams) localObject2, "UTF-8");
                    ((SchemeRegistry) localObject1).register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
                    localObject1 = new ThreadSafeClientConnManager((HttpParams) localObject2, (SchemeRegistry) localObject1);
                    try {
                        localObject1 = new DefaultHttpClient((ClientConnectionManager) localObject1, (HttpParams) localObject2).execute(new HttpGet(paramString)).getEntity().getContent();
                        localObject2 = new KXmlParser();
                        ((KXmlParser) localObject2).setInput(new InputStreamReader((InputStream) localObject1));
                        localObject1 = new XmlRpcParser((KXmlParser) localObject2);
                        TapatalkJsonEngine.this.result = ((XmlRpcParser) localObject1).parseResponse();
                        paramAnonymousVarArgs.setMethod("rebranding_network");
                        paramAnonymousVarArgs.setResponse(TapatalkJsonEngine.this.result);
                        paramAnonymousVarArgs.setSuccess(true);
                        return paramAnonymousVarArgs;
                    } catch (Exception localException1) {
                        localException1.printStackTrace();
                        return paramAnonymousVarArgs;
                    }
                    return paramAnonymousVarArgs;
                } catch (Exception localException2) {
                    localException2.printStackTrace();
                }
            }

            protected void onPostExecute(EngineResponse paramAnonymousEngineResponse) {
                try {
                    TapatalkJsonEngine.this.mAdapter.callBack(paramAnonymousEngineResponse);
                    return;
                } catch (Exception paramAnonymousEngineResponse) {
                    paramAnonymousEngineResponse.printStackTrace();
                }
            }

            protected void onProgressUpdate(Integer... paramAnonymousVarArgs) {
                super.onProgressUpdate(paramAnonymousVarArgs);
            }
        }.execute(new String[0]);
    }

    public void delSubscribeForum(String paramString1, String paramString2, String paramString3, String paramString4) {
        call(AU_DELETE_SUBSCRIBED_FORUM + "?au_id=" + paramString1 + "&token=" + paramString2 + "&fid=" + paramString3 + "&sfid=" + paramString4);
    }

    public void getSubscribeForum(String paramString1, String paramString2, String paramString3) {
        call(AU_GET_SUSCRIBED_FORUMS + "?au_id=" + paramString1 + "&token=" + paramString2 + "&fid=" + paramString3);
    }

    public void setCallBack(Context paramContext, CallBackInterface paramCallBackInterface) {
        this.mAdapter = paramCallBackInterface;
        this.context = paramContext;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/util/TapatalkJsonEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */