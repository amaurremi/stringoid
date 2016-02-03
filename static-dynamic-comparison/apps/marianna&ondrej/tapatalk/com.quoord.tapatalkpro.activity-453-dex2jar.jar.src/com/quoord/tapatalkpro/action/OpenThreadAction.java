package com.quoord.tapatalkpro.action;

import android.app.Activity;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.bean.Topic;
import com.quoord.tapatalkpro.sqlhelper.FavoriateSqlHelper;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tools.directoryurl.DirectoryUrlUtil;
import com.quoord.tools.net.TapatalkAjaxAction;
import com.quoord.tools.net.TapatalkAjaxAction.ActionCallBack;

import java.util.ArrayList;

import org.json.JSONArray;

public class OpenThreadAction {
    public static void openThread(Activity paramActivity, final Topic paramTopic, final String paramString) {
        new FeedAction(paramActivity, false);
        Object localObject2 = new FavoriateSqlHelper(paramActivity, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version)).getFavrivateById(paramTopic.getTapatalkForumId());
        ArrayList localArrayList = TapatalkAccountAction.getCurrnentAllAccount(paramActivity);
        Object localObject1 = localObject2;
        int i;
        if (localObject2 == null) {
            i = 0;
            localObject1 = localObject2;
            if (i < localArrayList.size()) {
            }
        } else {
            if (localObject1 != null) {
                Util.saveFavoriate(paramActivity, (TapatalkForum) localObject1, paramString, true);
            }
            localObject2 = localObject1;
            if (localObject1 == null) {
                localObject2 = TapatalkAccountAction.getFeedTempTapatalkForums(paramActivity);
                i = 0;
            }
        }
        for (; ; ) {
            if (i >= ((ArrayList) localObject2).size()) {
                localObject2 = localObject1;
                if (localObject2 == null) {
                    break label210;
                }
                paramTopic.openThreadFromFeed((TapatalkForum) localObject2, paramActivity, paramString);
                return;
                if (((TapatalkForum) localArrayList.get(i)).getId().intValue() == Integer.parseInt(paramTopic.getTapatalkForumId())) {
                    localObject1 = (TapatalkForum) localArrayList.get(i);
                }
                i += 1;
                break;
            }
            if (((TapatalkForum) ((ArrayList) localObject2).get(i)).getId().intValue() == Integer.parseInt(paramTopic.getTapatalkForumId())) {
                localObject1 = (TapatalkForum) ((ArrayList) localObject2).get(i);
            }
            i += 1;
        }
        label210:
        ((ForumActivityStatus) paramActivity).showProgress();
        localObject1 = DirectoryUrlUtil.createGetForumById(paramActivity, paramTopic.getTapatalkForumId());
        new TapatalkAjaxAction(paramActivity).getJsonArrayAction((String) localObject1, new TapatalkAjaxAction.ActionCallBack() {
            public void actionCallBack(Object paramAnonymousObject) {
                paramAnonymousObject = (JSONArray) paramAnonymousObject;
                ArrayList localArrayList = new ArrayList();
                if (paramAnonymousObject != null) {
                }
                try {
                    int j = ((JSONArray) paramAnonymousObject).length();
                    int i;
                    if (j > 0) {
                        i = 0;
                    }
                    for (; ; ) {
                        if (i >= j) {
                            ((ForumActivityStatus) OpenThreadAction.this).closeProgress();
                            if (localArrayList.size() > 0) {
                                paramAnonymousObject = (TapatalkForum) localArrayList.get(0);
                                paramTopic.openThreadFromFeed((TapatalkForum) paramAnonymousObject, OpenThreadAction.this, paramString);
                                TapatalkAccountAction.saveFeedTempTapatalkForum(OpenThreadAction.this, (TapatalkForum) paramAnonymousObject);
                            }
                            return;
                        }
                        localArrayList.add(TapatalkForum.getForum(((JSONArray) paramAnonymousObject).getJSONObject(i), null, null, null));
                        i += 1;
                    }
                    return;
                } catch (Exception paramAnonymousObject) {
                }
            }
        });
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/action/OpenThreadAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */