package com.quoord.tapatalkpro.util;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.quoord.newonboarding.ObEntryActivity;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.action.TapatalkAccountAction;
import com.quoord.tapatalkpro.activity.directory.ics.AccountEntryActivity;
import com.quoord.tapatalkpro.activity.forum.PMContentActivity;
import com.quoord.tapatalkpro.activity.forum.ThreadActivity;
import com.quoord.tapatalkpro.activity.forum.conversation.ConverSationActivity;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.Forum;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.bean.TapatalkId;
import com.quoord.tapatalkpro.cache.AppCacheManager;
import com.quoord.tapatalkpro.ics.forum.ForumListFragment;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.ics.tapatalkid.TapatalkIdFactory;
import com.quoord.tapatalkpro.sqlhelper.FavoriateSqlHelper;
import com.quoord.tools.TapatalkLog;
import com.quoord.tools.net.UrlAnalyseUtil;
import com.quoord.tools.tracking.GoogleAnalyticsTools;

import java.net.URI;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONArray;
import org.json.JSONException;

public class ForumUrlUtil {
    private static String channel = "banner";
    private static int page = -1;
    private static int perpage = -1;

    public static Thread doGetForum(final TapatalkForum paramTapatalkForum, Activity paramActivity, final Handler paramHandler, final HashMap<String, String> paramHashMap) {
        new Thread() {
            public void run() {
                ForumStatus localForumStatus = new ForumStatus(ForumUrlUtil.this);
                localForumStatus.tapatalkForum = paramTapatalkForum;
                localForumStatus.setSupprotBBcode(true);
                if (paramHashMap.size() > 0) {
                    localMessage = paramHandler.obtainMessage();
                    localHashMap = new HashMap();
                    localHashMap.put("forumStatus", localForumStatus);
                    localHashMap.put("ids", paramHashMap);
                    localMessage.what = 1;
                    localMessage.obj = localHashMap;
                    paramHandler.sendMessage(localMessage);
                    return;
                }
                Message localMessage = paramHandler.obtainMessage();
                HashMap localHashMap = new HashMap();
                localHashMap.put("forumStatus", localForumStatus);
                localHashMap.put("shouldAddFav", Boolean.valueOf(true));
                localMessage.what = 2;
                localMessage.obj = localHashMap;
                paramHandler.sendMessage(localMessage);
            }
        };
    }

    public static HashMap<String, String> getIdFromUrl(String paramString) {
        HashMap localHashMap = new HashMap();
        Object localObject2 = new String[5];
        Object localObject1 = new String[11];
        String[] arrayOfString = new String[3];
        Object localObject3 = new String[2];
        Object localObject4 = new String[2];
        if ((paramString.contains("/content/")) || (paramString.contains("/blogs/")) || (paramString.contains("/files/file/")) || (paramString.contains("content.php"))) {
            return localHashMap;
        }
        localObject2[0] = "(\\?|&|;)(f|fid|board)=(\\d+)(\\W|$)";
        localObject2[1] = "\\W(f|forum)-?(\\d+)(\\W|$)";
        localObject2[2] = "\\/forum\\/(\\d+)-(\\w|-)+(\\W|$)";
        localObject2[3] = "forumdisplay\\.php(\\?|\\/)(\\d+)(\\W|$)";
        localObject2[4] = "(index\\.php\\?|\\/)forums\\/.+\\.(\\d+)";
        localObject1[0] = "(\\?|&|;)(t|tid|topic|threadid)=(\\d+)(\\W|$)";
        localObject1[1] = "[\\/&\\?#](t|(\\w|-)+-t_|topic|article)-?(\\d+)([^\\w-]|$)";
        localObject1[2] = "showthread\\.php(\\?|\\/)(\\d+)(\\W|$)";
        localObject1[3] = "(index\\.php\\?|\\/)threads\\/(.+\\.)?(\\d+)";
        localObject1[4] = "(index\\.php\\?|\\/)topic\\/(\\d+)";
        localObject1[5] = "(archive\\/.*?\\/)t-(\\d+)";
        localObject1[6] = "(\\?|\\/)(\\w|-)+-t(\\d+)(\\.|\\/|\\?|#|$)";
        localObject1[7] = "(\\?|\\/)(\\d+)-(\\w|-)+(\\.|\\/$|$)";
        localObject1[8] = "(\\?|\\/)(\\d+)-(\\w|-)+(\\.|\\/|$)";
        localObject1[9] = "(\\?|\\/)(\\w|-)+-(\\d+)\\/(\\w|-)+-(\\d+)(\\.|\\/|$)";
        localObject1[10] = "(\\?|\\/)(\\w|-)+-(\\d+)(\\.|\\/|$)";
        arrayOfString[0] = "(\\?|&|;)(p|pid)=(\\d+)(\\W|$)";
        arrayOfString[1] = "\\W(p|(\\w|-)+-p|post|posts|msg)(-|_|\\/)?(\\d+)(\\W|$)";
        arrayOfString[2] = "__p__(\\d+)(\\W|$)";
        localObject3[0] = "\\/conversations\\/.*?\\.(\\d+)\\/";
        localObject3[1] = "(index\\.php\\?|\\/).*?conversations\\/.*?\\.(\\d+)\\/";
        localObject4[0] = "(private\\.php\\?|\\/).*?\\&pmid=(\\d+)";
        localObject4[1] = "(ucp\\.php\\?|\\/).*?(i=pm\\&mode=view).*?\\&p=(\\d+)";
        int i = 0;
        label222:
        if (i >= localObject4.length) {
            label229:
            i = 0;
            label231:
            if (i < localObject3.length) {
                break label378;
            }
            label238:
            i = 0;
            label240:
            if (i < localObject2.length) {
                break label456;
            }
            label247:
            i = 0;
        }
        int j;
        for (; ; ) {
            if (i >= localObject1.length) {
            }
            label298:
            label378:
            label456:
            do {
                i = 0;
                for (; ; ) {
                    if (i >= arrayOfString.length) {
                        break label298;
                    }
                    localObject1 = Pattern.compile(arrayOfString[i], 2).matcher(paramString);
                    j = 0;
                    if (((Matcher) localObject1).find()) {
                        break label711;
                    }
                    if (j != 0) {
                        break;
                    }
                    i += 1;
                }
                break;
                Matcher localMatcher = Pattern.compile(localObject4[i], 2).matcher(paramString);
                j = 0;
                if (!localMatcher.find()) {
                    if (j != 0) {
                        break label229;
                    }
                    i += 1;
                    break label222;
                }
                if (i == 0) {
                    localHashMap.put("pm", localMatcher.group(2));
                }
                for (; ; ) {
                    j = 1;
                    break;
                    if (i == 1) {
                        localHashMap.put("pm", localMatcher.group(3));
                    }
                }
                localObject4 = Pattern.compile(localObject3[i], 2).matcher(paramString);
                j = 0;
                if (!((Matcher) localObject4).find()) {
                    if (j != 0) {
                        break label238;
                    }
                    i += 1;
                    break label231;
                }
                if (i == 0) {
                    localHashMap.put("cid", ((Matcher) localObject4).group(1));
                }
                for (; ; ) {
                    j = 1;
                    break;
                    if (i == 1) {
                        localHashMap.put("cid", ((Matcher) localObject4).group(2));
                    }
                }
                localObject3 = Pattern.compile(localObject2[i], 2).matcher(paramString);
                j = 0;
                if (!((Matcher) localObject3).find()) {
                    if (j != 0) {
                        break label247;
                    }
                    i += 1;
                    break label240;
                }
                if (i == 0) {
                    localHashMap.put("fid", ((Matcher) localObject3).group(3));
                }
                for (; ; ) {
                    j = 1;
                    break;
                    if (i == 2) {
                        localHashMap.put("fid", ((Matcher) localObject3).group(1));
                    } else {
                        localHashMap.put("fid", ((Matcher) localObject3).group(2));
                    }
                }
                localObject2 = Pattern.compile(localObject1[i], 2).matcher(paramString);
                j = 0;
                if (((Matcher) localObject2).find()) {
                    break label585;
                }
            } while (j != 0);
            i += 1;
        }
        label585:
        if ((i == 0) || (i == 1) || (i == 6) || (i == 10)) {
            localHashMap.put("tid", ((Matcher) localObject2).group(3));
        }
        for (; ; ) {
            j = 1;
            break;
            if (i == 9) {
                localHashMap.put("tid", ((Matcher) localObject2).group(5));
            } else if ((i == 8) || (i == 7)) {
                localHashMap.put("tid", ((Matcher) localObject2).group(2));
            } else if (i == 3) {
                localHashMap.put("tid", ((Matcher) localObject2).group(3));
            } else {
                localHashMap.put("tid", ((Matcher) localObject2).group(2));
            }
        }
        label711:
        if (i == 0) {
            localHashMap.put("pid", ((Matcher) localObject1).group(3));
        }
        for (; ; ) {
            j = 1;
            break;
            if (i == 1) {
                localHashMap.put("pid", ((Matcher) localObject1).group(4));
            } else {
                localHashMap.put("pid", ((Matcher) localObject1).group(1));
            }
        }
    }

    public static String getLogoNameFromUrl(String paramString1, String paramString2) {
        paramString1 = paramString1.split("/");
        paramString1 = paramString1[(paramString1.length - 1)];
        return paramString2 + "/" + paramString1;
    }

    public static String getPostUrl(ForumStatus paramForumStatus, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean) {
        String str2 = "";
        String str3 = paramForumStatus.getUrl();
        String str1 = str3;
        if (!str3.endsWith("/")) {
            str1 = str3 + "/";
        }
        if (paramForumStatus.isVB()) {
            if (paramBoolean) {
                paramString3 = str1 + "announcement.php?a=" + paramString2;
            }
        }
        do {
            return paramString3;
            return str1 + "showthread.php?p=" + paramString1;
            if (paramForumStatus.isIP()) {
                return str1 + "index.php?/topic/" + paramString2 + "-" + paramString3.replace(" ", "-") + "#entry" + paramString1;
            }
            if (paramForumStatus.isPB()) {
                return str1 + "viewtopic.php?p=" + paramString1 + "#p" + paramString1;
            }
            if (paramForumStatus.isSMF()) {
                return str1 + "index.php?topic=" + paramString2 + ".msg" + paramString1 + ".msg#" + paramString1;
            }
            if (paramForumStatus.isXF()) {
                return str1 + "index.php?posts/" + paramString1;
            }
            if (paramForumStatus.isMB()) {
                return str1 + "showthread.php?pid=" + paramString1 + "#pid" + paramString1;
            }
            if (paramForumStatus.isBB()) {
                return str1 + "?post_type=topic&p=" + paramString2 + "#post-" + paramString1;
            }
            if ((paramForumStatus.isKN2()) || (paramForumStatus.isKN1())) {
                return str1 + "index.php?option=com_kunena&func=view&catid=" + paramString4 + "&id=" + paramString1;
            }
            if (paramForumStatus.isKN3()) {
                return str1 + "index.php/forum?view=topic&catid=" + paramString4 + "&id=" + paramString2 + "#" + paramString1;
            }
            if (TapatalkApp.rebranding_id.equals("81333")) {
                return str1 + "reply/" + paramString1;
            }
            paramString3 = str2;
        } while (!str1.contains("proboards"));
        return paramForumStatus.getPrefectUrl() + "post/" + paramString1 + "/thread/" + paramString2;
    }

    public static String getTopicUrl(ForumStatus paramForumStatus, String paramString1, String paramString2, String paramString3, boolean paramBoolean) {
        String str2 = "";
        String str3 = paramForumStatus.getUrl();
        String str1 = str3;
        if (!str3.endsWith("/")) {
            str1 = str3 + "/";
        }
        if (paramForumStatus.isVB()) {
            if (paramBoolean) {
                paramString2 = str1 + "announcement.php?a=" + paramString1;
            }
        }
        do {
            do {
                return paramString2;
                return str1 + "showthread.php?t=" + paramString1;
                if (paramForumStatus.isIP()) {
                    return str1 + "index.php?/topic/" + paramString1 + "-" + paramString2.replace(" ", "-");
                }
                if (paramForumStatus.isPB()) {
                    return str1 + "viewtopic.php?t=" + paramString1;
                }
                if (paramForumStatus.isSMF()) {
                    return str1 + "index.php?topic=" + paramString1 + ".0";
                }
                if (paramForumStatus.isXF()) {
                    return str1 + "index.php?threads/" + paramString1 + "/";
                }
                if (paramForumStatus.isMB()) {
                    return str1 + "showthread.php?tid=" + paramString1;
                }
                if (paramForumStatus.isBB()) {
                    return str1 + "?post_type=topic&p=" + paramString1;
                }
                if ((paramForumStatus.isKN1()) || (paramForumStatus.isKN2())) {
                    return str1 + "index.php?option=com_kunena&func=view&catid=" + paramString3 + "&id=" + paramString1;
                }
                if (paramForumStatus.isKN3()) {
                    return str1 + "index.php/forum?view=topic&catid=" + paramString3 + "&id=" + paramString1 + "#" + paramString1;
                }
                if (TapatalkApp.rebranding_id.equals("81333")) {
                    return str1 + "index.php?/topic/" + paramString1;
                }
                paramString2 = str2;
            } while (paramForumStatus.tapatalkForum.getType() == null);
            paramString2 = str2;
        } while (!paramForumStatus.tapatalkForum.getType().equals("proboards"));
        return str1 + "thread/" + paramString1 + "/";
    }

    public static void openByConverSationId(Activity paramActivity, ForumStatus paramForumStatus, String paramString) {
        Intent localIntent = new Intent();
        localIntent.setClass(paramActivity, ConverSationActivity.class);
        localIntent.putExtra("conv_id", paramString);
        localIntent.putExtra("forumStatus", paramForumStatus);
        paramActivity.startActivityForResult(localIntent, 8);
    }

    public static void openByPMContentId(Activity paramActivity, ForumStatus paramForumStatus, String paramString) {
        Intent localIntent = new Intent();
        localIntent.setClass(paramActivity, PMContentActivity.class);
        localIntent.putExtra("pmid", paramString);
        localIntent.putExtra("forumStatus", paramForumStatus);
        paramActivity.startActivityForResult(localIntent, 8);
    }

    public static void openForum(Activity paramActivity, ForumStatus paramForumStatus, String paramString1, String paramString2) {
        new Forum().setId(paramString1);
        if ((paramActivity instanceof SlidingMenuActivity)) {
            ((SlidingMenuActivity) paramActivity).backStack(true);
            ((SlidingMenuActivity) paramActivity).addFragmentToStack(ForumListFragment.newInstance(paramString2, 1018), paramString2, true);
            return;
        }
        paramString1 = new Intent(paramActivity, SlidingMenuActivity.class);
        paramString1.putExtra("isOpenSubForumFromPostUrl", true);
        paramString1.putExtra("forum", paramForumStatus.tapatalkForum);
        paramActivity.startActivity(paramString1);
        paramActivity.finish();
    }

    public static void openForumByIds(Activity paramActivity, ForumStatus paramForumStatus, HashMap paramHashMap, String paramString, boolean paramBoolean) {
        openForumByIds(paramActivity, paramForumStatus, paramHashMap, paramString, paramBoolean, false);
    }

    public static void openForumByIds(Activity paramActivity, ForumStatus paramForumStatus, HashMap paramHashMap, String paramString, boolean paramBoolean1, boolean paramBoolean2) {
        openForumByIds(paramActivity, paramForumStatus, paramHashMap, paramString, paramBoolean1, paramBoolean2, -1, -1);
    }

    public static void openForumByIds(Activity paramActivity, ForumStatus paramForumStatus, HashMap paramHashMap, String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2) {
        paramForumStatus.tapatalkForum.setApiLevel(3);
        if ((paramForumStatus.isSignInForumUser(paramActivity)) || ((paramForumStatus.tapatalkForum.getUserName() != null) && (paramForumStatus.tapatalkForum.getPassword() != null) && (paramForumStatus.tapatalkForum.getPassword().length() > 0))) {
            paramForumStatus.setLogin(true);
        }
        if ((paramHashMap.containsKey("cid")) && (((String) paramHashMap.get("cid")).length() > 0)) {
            openByConverSationId(paramActivity, paramForumStatus, (String) paramHashMap.get("cid"));
            ((SlidingMenuActivity) paramActivity).forumStatus = paramForumStatus;
            if (paramBoolean2) {
                ((SlidingMenuActivity) paramActivity).viewFromOutUrl = true;
            }
            if (paramBoolean1) {
                ((SlidingMenuActivity) paramActivity).dealWithOutCallback();
            }
        }
        for (; ; ) {
            if (!Util.isFavoriate(paramActivity, paramForumStatus.tapatalkForum.getId().intValue())) {
                TapatalkJsonEngine.auAddAccount(paramActivity, paramForumStatus.tapatalkForum.getId(), "Guest", null, "0", null, ((SlidingMenuActivity) paramActivity).channel, paramForumStatus.tapatalkForum);
                TapatalkAccountAction.addToCurrenForums(paramForumStatus.tapatalkForum, paramActivity);
            }
            return;
            if ((paramHashMap.containsKey("pm")) && (((String) paramHashMap.get("pm")).length() > 0)) {
                openByPMContentId(paramActivity, paramForumStatus, (String) paramHashMap.get("pm"));
                ((SlidingMenuActivity) paramActivity).forumStatus = paramForumStatus;
                if (paramBoolean2) {
                    ((SlidingMenuActivity) paramActivity).viewFromOutUrl = true;
                }
                if (paramBoolean1) {
                    ((SlidingMenuActivity) paramActivity).dealWithOutCallback();
                }
            } else {
                if ((paramHashMap.containsKey("pid")) && (((String) paramHashMap.get("pid")).length() > 0)) {
                    paramForumStatus.setSupportGoPost(true);
                    if (paramInt2 != SettingsFragment.getPostPerPageChoice(paramActivity)) {
                        openThreadByPost(paramActivity, paramForumStatus, (String) paramHashMap.get("pid"), paramInt2);
                    }
                    for (; ; ) {
                        ((SlidingMenuActivity) paramActivity).forumStatus = paramForumStatus;
                        if (paramBoolean2) {
                            ((SlidingMenuActivity) paramActivity).viewFromOutUrl = true;
                        }
                        if (!paramBoolean1) {
                            break;
                        }
                        ((SlidingMenuActivity) paramActivity).dealWithOutCallback();
                        break;
                        openThreadByPost(paramActivity, paramForumStatus, (String) paramHashMap.get("pid"));
                    }
                }
                if ((paramHashMap.containsKey("tid")) && (((String) paramHashMap.get("tid")).length() > 0)) {
                    if ((paramInt1 != -1) && (paramInt2 != -1)) {
                        openThreadByThread(paramActivity, paramForumStatus, (String) paramHashMap.get("tid"), paramInt1, paramInt2);
                    }
                    for (; ; ) {
                        ((SlidingMenuActivity) paramActivity).forumStatus = paramForumStatus;
                        if (paramBoolean2) {
                            ((SlidingMenuActivity) paramActivity).viewFromOutUrl = true;
                        }
                        if (!paramBoolean1) {
                            break;
                        }
                        ((SlidingMenuActivity) paramActivity).dealWithOutCallback();
                        break;
                        openThreadByThread(paramActivity, paramForumStatus, (String) paramHashMap.get("tid"));
                    }
                }
                if ((paramHashMap.containsKey("fid")) && (((String) paramHashMap.get("fid")).length() > 0)) {
                    openForum(paramActivity, paramForumStatus, (String) paramHashMap.get("fid"), paramString);
                    ((SlidingMenuActivity) paramActivity).forumStatus = paramForumStatus;
                    if (paramBoolean2) {
                        ((SlidingMenuActivity) paramActivity).viewFromOutUrl = true;
                    }
                    if (paramBoolean1) {
                        ((SlidingMenuActivity) paramActivity).dealWithOutCallback();
                    }
                }
            }
        }
    }

    public static void openForumByUrl(Activity paramActivity, ForumStatus paramForumStatus) {
        Intent localIntent = new Intent();
        localIntent.setClass(paramActivity, SlidingMenuActivity.class);
        localIntent.putExtra("forumStatus", paramForumStatus);
        localIntent.putExtra("forumId", paramForumStatus.tapatalkForum.getId());
        localIntent.putExtra("viewFromOutUrl", true);
        paramActivity.startActivityForResult(localIntent, 8);
    }

    public static void openForumByUrl(Activity paramActivity, ForumStatus paramForumStatus, boolean paramBoolean) {
        Intent localIntent = new Intent();
        localIntent.setClass(paramActivity, SlidingMenuActivity.class);
        localIntent.putExtra("forumStatus", paramForumStatus);
        localIntent.putExtra("forum", paramForumStatus.tapatalkForum);
        localIntent.putExtra("forumId", paramForumStatus.tapatalkForum.getId());
        localIntent.putExtra("viewFromOutUrl", true);
        paramActivity.startActivityForResult(localIntent, 8);
        if (!Util.isFavoriate(paramActivity, paramForumStatus.tapatalkForum.getId().intValue())) {
            TapatalkJsonEngine.auAddAccount(paramActivity, paramForumStatus.tapatalkForum.getId(), "Guest", null, "0", null, ((SlidingMenuActivity) paramActivity).channel, paramForumStatus.tapatalkForum);
            TapatalkAccountAction.addToCurrenForums(paramForumStatus.tapatalkForum, paramActivity);
        }
        paramActivity.finish();
    }

    public static void openFromUrl(Intent paramIntent, Activity paramActivity, final String paramString) {
        page = -1;
        perpage = -1;
        Object localObject1;
        Object localObject2;
        int i;
        try {
            localObject1 = paramIntent.getData().toString();
            TapatalkLog.d("open scheme ", (String) localObject1);
            paramIntent = (Intent) localObject1;
            if (((String) localObject1).contains("apicdn.viglink.com/api/")) {
                localObject2 = Pattern.compile("apicdn\\.viglink\\.com.*?out=(.*?)[&|$]", 2).matcher((CharSequence) localObject1);
            }
            for (paramIntent = (Intent) localObject1; ; paramIntent = ((Matcher) localObject2).group(1)) {
                if (!((Matcher) localObject2).find()) {
                    i = 0;
                    if (paramActivity.getResources().getBoolean(2131558401)) {
                        break label720;
                    }
                    if (!Pattern.compile("tapatalk://(.*?)location=explore(.*?)").matcher(paramIntent).matches()) {
                        break;
                    }
                    startExplore(paramActivity);
                    return;
                }
            }
            if (paramIntent.equals("tapatalk://")) {
                if ((paramActivity instanceof SlidingMenuActivity)) {
                    ((SlidingMenuActivity) paramActivity).channel = "banner";
                }
                startEntry(paramActivity);
                return;
            }
        } catch (Exception paramIntent) {
            startEntry(paramActivity);
            return;
        }
        if (paramIntent.contains("tapa:")) {
            localObject1 = paramIntent.replace("tapa:", "http:");
            i = 1;
        }
        for (; ; ) {
            label185:
            final HashMap localHashMap;
            final URI localURI;
            label269:
            FavoriateSqlHelper localFavoriateSqlHelper;
            label382:
            boolean bool;
            if (i != 0) {
                GoogleAnalyticsTools.trackEvent(paramActivity, "launch", "tapatalk");
                Util.logAppSession(paramActivity);
                paramIntent = URLDecoder.decode((String) localObject1);
                localHashMap = getIdFromUrl(paramIntent);
                localURI = URI.create(paramIntent);
                if ((localURI.getScheme() == null) || (localURI.getScheme().equals(""))) {
                    break label796;
                }
                paramIntent = localURI.getScheme() + "://" + localURI.getHost() + localURI.getPath();
                localFavoriateSqlHelper = new FavoriateSqlHelper(paramActivity, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version));
                if (i == 0) {
                    break label826;
                }
                localObject2 = localURI.getPath();
                localObject1 = localObject2;
                if (localObject2 != null) {
                    localObject1 = localObject2;
                    if (!((String) localObject2).equals("")) {
                        localObject1 = localObject2;
                        if (((String) localObject2).endsWith("/")) {
                            localObject1 = ((String) localObject2).substring(0, ((String) localObject2).length() - 1);
                        }
                    }
                }
                localObject1 = localFavoriateSqlHelper.getFavrivateByUrl(localURI.getHost() + (String) localObject1);
                if ((localObject1 == null) || ((!paramIntent.contains(((TapatalkForum) localObject1).getUrl().replace("http://", "").replace("www.", "").replaceAll("\\/$", ""))) && (!paramIntent.contains(((TapatalkForum) localObject1).getUrl().replace("https://", "").replace("www.", "").replaceAll("\\/$", ""))))) {
                    break label859;
                }
                paramIntent = ForumStatus.initialForumStatus(paramActivity, (TapatalkForum) localObject1, null, null, true);
                if (Util.isLoggedForum(paramActivity, ((TapatalkForum) localObject1).getId(), ((TapatalkForum) localObject1).getUserNameOrDisplayName(), ((TapatalkForum) localObject1).getPassword())) {
                    paramIntent.setLogin(true);
                }
                if (localHashMap.size() <= 0) {
                    break label852;
                }
                TapatalkLog.d("open scheme ", localHashMap.toString());
                if ((page == -1) || (perpage == -1)) {
                    break label841;
                }
                openForumByIds(paramActivity, paramIntent, localHashMap, paramString, true, true, page, perpage);
                return;
                localObject1 = paramIntent;
                if (!paramIntent.contains("tapatalk:")) {
                    continue;
                }
                localObject1 = UrlAnalyseUtil.getParamterMaps(paramIntent.toLowerCase());
                if (((HashMap) localObject1).containsKey("channel")) {
                    channel = (String) ((HashMap) localObject1).get("channel");
                }
                bool = ((HashMap) localObject1).containsKey("page");
                if (!bool) {
                }
            }
            try {
                page = Integer.valueOf((String) ((HashMap) localObject1).get("page")).intValue();
                if (page <= 0) {
                    page = 1;
                }
                bool = ((HashMap) localObject1).containsKey("perpage");
                if (bool) {
                }
                try {
                    perpage = Integer.valueOf((String) ((HashMap) localObject1).get("perpage")).intValue();
                    if (perpage <= 0) {
                        perpage = SettingsFragment.getPostPerPageChoice(paramActivity);
                    }
                    if ((paramActivity instanceof SlidingMenuActivity)) {
                        ((SlidingMenuActivity) paramActivity).channel = channel;
                    }
                    localObject1 = paramIntent.replace("tapatalk:", "http:");
                    i = 1;
                    continue;
                    label720:
                    localObject1 = paramIntent;
                    if (!paramIntent.contains("tapatalk-byo:")) {
                        continue;
                    }
                    paramIntent.replace("tapatalk-byo:", "http:");
                    paramIntent = new ForumStatus(paramActivity);
                    paramString = AppCacheManager.getRebrandingForumUrl(paramActivity);
                    if (AppCacheManager.checkFile(paramString)) {
                        paramIntent.tapatalkForum = ((TapatalkForum) AppCacheManager.getCacheData(paramString));
                    }
                    openForumByUrl(paramActivity, paramIntent, false);
                    return;
                    GoogleAnalyticsTools.trackEvent(paramActivity, "launch", "link");
                    break label185;
                    label796:
                    paramIntent = localURI.getHost() + localURI.getPath();
                    break label269;
                    label826:
                    localObject1 = localFavoriateSqlHelper.getFavrivateByUrl(localURI.getHost());
                    break label382;
                    label841:
                    openForumByIds(paramActivity, paramIntent, localHashMap, paramString, true, true);
                    return;
                    label852:
                    openForumByUrl(paramActivity, paramIntent, false);
                    return;
                    label859:
                    paramString = new Handler() {
                        public void handleMessage(Message paramAnonymousMessage) {
                            super.handleMessage(paramAnonymousMessage);
                            switch (paramAnonymousMessage.what) {
                                default:
                                    return;
                                case 1:
                                    paramAnonymousMessage = (HashMap) paramAnonymousMessage.obj;
                                    if ((ForumUrlUtil.page != -1) && (ForumUrlUtil.perpage != -1)) {
                                        TapatalkLog.d("open scheme ", ((HashMap) paramAnonymousMessage.get("ids")).toString());
                                        ForumUrlUtil.openForumByIds(ForumUrlUtil.this, (ForumStatus) paramAnonymousMessage.get("forumStatus"), (HashMap) paramAnonymousMessage.get("ids"), paramString, true, true, ForumUrlUtil.page, ForumUrlUtil.perpage);
                                        return;
                                    }
                                    ForumUrlUtil.openForumByIds(ForumUrlUtil.this, (ForumStatus) paramAnonymousMessage.get("forumStatus"), (HashMap) paramAnonymousMessage.get("ids"), paramString, true, true);
                                    return;
                                case 2:
                                    paramAnonymousMessage = (HashMap) paramAnonymousMessage.obj;
                                    ForumUrlUtil.openForumByUrl(ForumUrlUtil.this, (ForumStatus) paramAnonymousMessage.get("forumStatus"), true);
                                    return;
                                case 3:
                                    ForumUrlUtil.startEntry(ForumUrlUtil.this);
                                    return;
                            }
                            paramAnonymousMessage = (EngineResponse) paramAnonymousMessage.obj;
                            ArrayList localArrayList;
                            int i;
                            if (Boolean.valueOf(paramAnonymousMessage.isSuccess()).booleanValue()) {
                                for (; ; ) {
                                    try {
                                        paramAnonymousMessage.getMethod();
                                        paramAnonymousMessage = (JSONArray) paramAnonymousMessage.getResponse();
                                        localArrayList = new ArrayList();
                                        i = 0;
                                        if (i >= paramAnonymousMessage.length()) {
                                            String str = localURI.getPath();
                                            paramAnonymousMessage = str;
                                            if (str.endsWith("/")) {
                                                paramAnonymousMessage = str.substring(0, str.length() - 1);
                                            }
                                            str = null;
                                            if (localArrayList.size() != 0) {
                                                break label349;
                                            }
                                            ForumUrlUtil.startEntry(ForumUrlUtil.this);
                                            paramAnonymousMessage = str;
                                            if (paramAnonymousMessage == null) {
                                                break;
                                            }
                                            ThreadPoolManager.addExecuteTask(ForumUrlUtil.doGetForum(paramAnonymousMessage, ForumUrlUtil.this, this, localHashMap));
                                            return;
                                        }
                                    } catch (Exception paramAnonymousMessage) {
                                        ForumUrlUtil.startEntry(ForumUrlUtil.this);
                                        return;
                                    }
                                    try {
                                        localArrayList.add(TapatalkForum.getForum(paramAnonymousMessage.getJSONObject(i), null, null, null));
                                        i += 1;
                                    } catch (JSONException localJSONException) {
                                        for (; ; ) {
                                            localJSONException.printStackTrace();
                                        }
                                    }
                                    label349:
                                    if (localArrayList.size() != 1) {
                                        break label489;
                                    }
                                    paramAnonymousMessage = (TapatalkForum) localArrayList.get(0);
                                }
                            }
                            for (; ; ) {
                                label371:
                                if (i >= localArrayList.size()) {
                                    paramAnonymousMessage = localJSONException;
                                    if (0 != 0) {
                                        break;
                                    }
                                    i = 0;
                                }
                                for (; ; ) {
                                    paramAnonymousMessage = localJSONException;
                                    if (i >= localArrayList.size()) {
                                        break;
                                    }
                                    if (((TapatalkForum) localArrayList.get(i)).getUrl().contains(localURI.getHost())) {
                                        paramAnonymousMessage = (TapatalkForum) localArrayList.get(i);
                                        break;
                                        if (((TapatalkForum) localArrayList.get(i)).getUrl().contains(paramAnonymousMessage)) {
                                            paramAnonymousMessage = (TapatalkForum) localArrayList.get(i);
                                            return;
                                        }
                                        i += 1;
                                        break label371;
                                    }
                                    i += 1;
                                }
                                ForumUrlUtil.startEntry(ForumUrlUtil.this);
                                return;
                                label489:
                                i = 0;
                            }
                        }
                    };
                    if (i != 0) {
                    }
                    for (paramIntent = TapatalkJsonEngine.SEARCH + "?" + "search=" + URLEncoder.encode(new StringBuilder(String.valueOf(localURI.getHost())).append(localURI.getPath()).toString()) + "&page=" + 1 + "&per_page=20&type=url_match"; ; paramIntent = TapatalkJsonEngine.SEARCH + "?" + "search=" + URLEncoder.encode(localURI.getHost()) + "&page=" + 1 + "&per_page=20") {
                        ThreadPoolManager.addExecuteTask(TapatalkJsonEngine.doAction(paramIntent, paramString));
                        return;
                    }
                } catch (Exception localException1) {
                    for (; ; ) {
                    }
                }
            } catch (Exception localException2) {
                for (; ; ) {
                }
            }
        }
    }

    public static void openThreadByPost(Activity paramActivity, ForumStatus paramForumStatus, String paramString) {
        Intent localIntent = new Intent();
        localIntent.setClass(paramActivity, ThreadActivity.class);
        localIntent.putExtra("topic_id", "");
        localIntent.putExtra("topic_title", "");
        localIntent.putExtra("reply_count", 0);
        localIntent.putExtra("forumid", paramForumStatus.tapatalkForum.getId());
        localIntent.putExtra("isNew", false);
        localIntent.putExtra("forumStatus", paramForumStatus);
        localIntent.putExtra("post_id", paramString);
        localIntent.putExtra("getPost", true);
        paramActivity.startActivityForResult(localIntent, 8);
    }

    public static void openThreadByPost(Activity paramActivity, ForumStatus paramForumStatus, String paramString, int paramInt) {
        Intent localIntent = new Intent();
        localIntent.setClass(paramActivity, ThreadActivity.class);
        localIntent.putExtra("topic_id", "");
        localIntent.putExtra("topic_title", "");
        localIntent.putExtra("reply_count", 0);
        localIntent.putExtra("perpage", paramInt);
        localIntent.putExtra("forumid", paramForumStatus.tapatalkForum.getId());
        localIntent.putExtra("isNew", false);
        localIntent.putExtra("forumStatus", paramForumStatus);
        localIntent.putExtra("post_id", paramString);
        localIntent.putExtra("getPost", true);
        paramActivity.startActivityForResult(localIntent, 8);
    }

    public static void openThreadByThread(Activity paramActivity, ForumStatus paramForumStatus, String paramString) {
        Intent localIntent = new Intent();
        localIntent.setClass(paramActivity, ThreadActivity.class);
        localIntent.putExtra("topic_id", paramString);
        localIntent.putExtra("topic_title", "");
        localIntent.putExtra("reply_count", 0);
        localIntent.putExtra("forumid", "0");
        localIntent.putExtra("isNew", false);
        localIntent.putExtra("forumStatus", paramForumStatus);
        paramActivity.startActivityForResult(localIntent, 8);
    }

    public static void openThreadByThread(Activity paramActivity, ForumStatus paramForumStatus, String paramString, int paramInt1, int paramInt2) {
        Intent localIntent = new Intent();
        localIntent.setClass(paramActivity, ThreadActivity.class);
        localIntent.putExtra("topic_id", paramString);
        localIntent.putExtra("topic_title", "");
        localIntent.putExtra("reply_count", 0);
        localIntent.putExtra("forumid", "0");
        localIntent.putExtra("isNew", false);
        localIntent.putExtra("page", paramInt1);
        localIntent.putExtra("perpage", paramInt2);
        localIntent.putExtra("forumStatus", paramForumStatus);
        paramActivity.startActivityForResult(localIntent, 8);
    }

    public static void startEntry(Activity paramActivity) {
        Toast.makeText(paramActivity, paramActivity.getString(2131100201), 1).show();
        if (!TapatalkIdFactory.getTapatalkId(paramActivity).isHasAccounts()) {
            paramActivity.startActivity(new Intent(paramActivity, ObEntryActivity.class));
        }
        for (; ; ) {
            paramActivity.finish();
            return;
            paramActivity.startActivity(new Intent(paramActivity, AccountEntryActivity.class));
        }
    }

    public static void startExplore(Activity paramActivity) {
        Intent localIntent = new Intent(paramActivity, AccountEntryActivity.class);
        localIntent.putExtra(AccountEntryActivity.ENTRY_FLAG, 2);
        paramActivity.startActivity(localIntent);
        paramActivity.finish();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/util/ForumUrlUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */