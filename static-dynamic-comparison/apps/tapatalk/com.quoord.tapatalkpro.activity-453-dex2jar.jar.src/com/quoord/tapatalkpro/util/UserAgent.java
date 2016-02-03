package com.quoord.tapatalkpro.util;

import android.content.Context;
import android.content.res.Resources;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tools.ForumHttpStatus;

import java.net.HttpURLConnection;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

public class UserAgent {
    private static final String byo_agent_header = "Mozilla/5.0 (iPhone; U; CPU iPhone OS 3_1_3 like Mac OS X; fr-fr) AppleWebKit/528.18 (KHTML, like Gecko) Version/4.0 Mobile/7E18 Safari/528.16 BYO-4/";
    private static final String byo_header = "Mozilla/5.0 Firefox/3.5.6 BYO-4/";
    private static final String ics_agent_header = "Mozilla/5.0 (iPhone; U; CPU iPhone OS 3_1_3 like Mac OS X; fr-fr) AppleWebKit/528.18 (KHTML, like Gecko) Version/4.0 Mobile/7E18 Safari/528.16 Tapatalk/";
    private static final String ics_header = "Mozilla/5.0 Firefox/3.5.6 Tapatalk/";
    private static final String normal_header = "Mozilla/5.0 (iPhone; U; CPU iPhone OS 3_1_3 like Mac OS X; fr-fr) AppleWebKit/528.18 (KHTML, like Gecko) Version/4.0 Mobile/7E18 Safari/528.16";
    private static final String proboards_version = "proboards";
    private static final String userAgent = "User-Agent";

    public static void setHTTPGetHeader(Context paramContext, HttpGet paramHttpGet, ForumStatus paramForumStatus) {
        if (paramContext.getResources().getBoolean(2131558401)) {
            if (paramForumStatus == null) {
                paramHttpGet.setHeader("User-Agent", "Mozilla/5.0 (iPhone; U; CPU iPhone OS 3_1_3 like Mac OS X; fr-fr) AppleWebKit/528.18 (KHTML, like Gecko) Version/4.0 Mobile/7E18 Safari/528.16");
            }
        }
        for (; ; ) {
            return;
            if (paramForumStatus.isAgent()) {
                paramHttpGet.setHeader("User-Agent", "Mozilla/5.0 (iPhone; U; CPU iPhone OS 3_1_3 like Mac OS X; fr-fr) AppleWebKit/528.18 (KHTML, like Gecko) Version/4.0 Mobile/7E18 Safari/528.16 BYO-4/" + paramForumStatus.getAppVersion(paramContext));
                return;
            }
            paramHttpGet.setHeader("User-Agent", "Mozilla/5.0 Firefox/3.5.6 BYO-4/" + paramForumStatus.getAppVersion(paramContext));
            return;
            if (paramForumStatus == null) {
                paramHttpGet.setHeader("User-Agent", "Mozilla/5.0 (iPhone; U; CPU iPhone OS 3_1_3 like Mac OS X; fr-fr) AppleWebKit/528.18 (KHTML, like Gecko) Version/4.0 Mobile/7E18 Safari/528.16");
                return;
            }
            if (paramForumStatus.isAgent()) {
                paramHttpGet.setHeader("User-Agent", "Mozilla/5.0 (iPhone; U; CPU iPhone OS 3_1_3 like Mac OS X; fr-fr) AppleWebKit/528.18 (KHTML, like Gecko) Version/4.0 Mobile/7E18 Safari/528.16 Tapatalk/" + paramForumStatus.getAppVersion(paramContext));
            }
            while (paramForumStatus.getAppVersion(paramContext).equalsIgnoreCase("proboards")) {
                paramHttpGet.setHeader("fromapp", "tapatalk");
                return;
                paramHttpGet.setHeader("User-Agent", "Mozilla/5.0 Firefox/3.5.6 Tapatalk/" + paramForumStatus.getAppVersion(paramContext));
            }
        }
    }

    public static void setHTTPPostHeader(Context paramContext, HttpPost paramHttpPost, ForumHttpStatus paramForumHttpStatus) {
        if (paramContext.getResources().getBoolean(2131558401)) {
            if (paramForumHttpStatus == null) {
                paramHttpPost.setHeader("User-Agent", "Mozilla/5.0 (iPhone; U; CPU iPhone OS 3_1_3 like Mac OS X; fr-fr) AppleWebKit/528.18 (KHTML, like Gecko) Version/4.0 Mobile/7E18 Safari/528.16");
            }
        }
        for (; ; ) {
            return;
            if (paramForumHttpStatus.isAgent()) {
                paramHttpPost.setHeader("User-Agent", "Mozilla/5.0 (iPhone; U; CPU iPhone OS 3_1_3 like Mac OS X; fr-fr) AppleWebKit/528.18 (KHTML, like Gecko) Version/4.0 Mobile/7E18 Safari/528.16 BYO-4/" + paramForumHttpStatus.getAppVersion(paramContext));
                return;
            }
            paramHttpPost.setHeader("User-Agent", "Mozilla/5.0 Firefox/3.5.6 BYO-4/" + paramForumHttpStatus.getAppVersion(paramContext));
            return;
            if (paramForumHttpStatus == null) {
                paramHttpPost.setHeader("User-Agent", "Mozilla/5.0 (iPhone; U; CPU iPhone OS 3_1_3 like Mac OS X; fr-fr) AppleWebKit/528.18 (KHTML, like Gecko) Version/4.0 Mobile/7E18 Safari/528.16");
                return;
            }
            if (paramForumHttpStatus.isAgent()) {
                paramHttpPost.setHeader("User-Agent", "Mozilla/5.0 (iPhone; U; CPU iPhone OS 3_1_3 like Mac OS X; fr-fr) AppleWebKit/528.18 (KHTML, like Gecko) Version/4.0 Mobile/7E18 Safari/528.16 Tapatalk/" + paramForumHttpStatus.getAppVersion(paramContext));
            }
            while (paramForumHttpStatus.getAppVersion(paramContext).equalsIgnoreCase("proboards")) {
                paramHttpPost.setHeader("fromapp", "tapatalk");
                return;
                paramHttpPost.setHeader("User-Agent", "Mozilla/5.0 Firefox/3.5.6 Tapatalk/" + paramForumHttpStatus.getAppVersion(paramContext));
            }
        }
    }

    public static void setHTTPURLConn(Context paramContext, HttpURLConnection paramHttpURLConnection, ForumHttpStatus paramForumHttpStatus) {
        if (paramContext.getResources().getBoolean(2131558401)) {
            if (paramForumHttpStatus == null) {
                paramHttpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (iPhone; U; CPU iPhone OS 3_1_3 like Mac OS X; fr-fr) AppleWebKit/528.18 (KHTML, like Gecko) Version/4.0 Mobile/7E18 Safari/528.16");
            }
        }
        for (; ; ) {
            return;
            if (paramForumHttpStatus.isAgent()) {
                paramHttpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (iPhone; U; CPU iPhone OS 3_1_3 like Mac OS X; fr-fr) AppleWebKit/528.18 (KHTML, like Gecko) Version/4.0 Mobile/7E18 Safari/528.16 BYO-4/" + paramForumHttpStatus.getAppVersion(paramContext));
                return;
            }
            paramHttpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0 Firefox/3.5.6 BYO-4/" + paramForumHttpStatus.getAppVersion(paramContext));
            return;
            if (paramForumHttpStatus == null) {
                paramHttpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (iPhone; U; CPU iPhone OS 3_1_3 like Mac OS X; fr-fr) AppleWebKit/528.18 (KHTML, like Gecko) Version/4.0 Mobile/7E18 Safari/528.16");
                return;
            }
            if (paramForumHttpStatus.isAgent()) {
                paramHttpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (iPhone; U; CPU iPhone OS 3_1_3 like Mac OS X; fr-fr) AppleWebKit/528.18 (KHTML, like Gecko) Version/4.0 Mobile/7E18 Safari/528.16 Tapatalk/" + paramForumHttpStatus.getAppVersion(paramContext));
            }
            while (paramForumHttpStatus.getAppVersion(paramContext).equalsIgnoreCase("proboards")) {
                paramHttpURLConnection.setRequestProperty("fromapp", "tapatalk");
                return;
                paramHttpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0 Firefox/3.5.6 Tapatalk/" + paramForumHttpStatus.getAppVersion(paramContext));
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/util/UserAgent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */