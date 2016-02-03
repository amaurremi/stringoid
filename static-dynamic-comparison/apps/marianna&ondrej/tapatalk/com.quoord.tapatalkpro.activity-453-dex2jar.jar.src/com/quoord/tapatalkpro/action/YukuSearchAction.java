package com.quoord.tapatalkpro.action;

import android.app.Activity;
import android.os.Handler;
import android.widget.Toast;
import com.quoord.tapatalkpro.activity.directory.ics.IcsRebrandingEntryActivity;
import com.quoord.tapatalkpro.activity.directory.ics.YukuSearchFragment;
import com.quoord.tapatalkpro.activity.directory.ics.YukuSearchFragment.YukuForum;
import com.quoord.tapatalkpro.adapter.CallBackInterface;
import com.quoord.tapatalkpro.adapter.directory.ics.RebrandAdapter;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.ForumItemBean;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.cache.AppCacheManager;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tapatalkpro.util.YukuJsonEngine;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class YukuSearchAction
        implements CallBackInterface {
    private YukuJsonEngine engine;
    public YukuSearchFragment fragment;
    private Activity mActivity;
    private String query;
    private RebrandAdapter rebrandAdapter;
    public ArrayList<Object> searchDatas = new ArrayList();
    private String url = "http://www.yuku.com/mobiquo/search?search=";

    public YukuSearchAction(Activity paramActivity, String paramString, RebrandAdapter paramRebrandAdapter) {
        this.mActivity = paramActivity;
        this.rebrandAdapter = paramRebrandAdapter;
        this.engine = new YukuJsonEngine(this);
        this.query = paramString;
        try {
            this.engine.Call(this.url + paramString);
            return;
        } catch (Exception paramActivity) {
            paramActivity.printStackTrace();
        }
    }

    public void addForumItemBean(JSONArray paramJSONArray) {
        try {
            paramJSONArray = (JSONObject) paramJSONArray.get(0);
            Object localObject = new TapatalkForum();
            ((TapatalkForum) localObject).setUrl((String) paramJSONArray.get("url"));
            ((TapatalkForum) localObject).setName((String) paramJSONArray.get("name"));
            ((TapatalkForum) localObject).setId(Integer.valueOf(Util.getMD5((String) paramJSONArray.get("id")).hashCode()));
            ((TapatalkForum) localObject).openTapatalkForum(this.mActivity, false);
            localObject = new ForumItemBean();
            ((ForumItemBean) localObject).setForumName((String) paramJSONArray.get("name"));
            ((ForumItemBean) localObject).setForumId(Util.getMD5((String) paramJSONArray.get("id")).hashCode());
            ((ForumItemBean) localObject).setForumUrl((String) paramJSONArray.get("url"));
            if (!this.rebrandAdapter.forumItemId.contains(Integer.valueOf(paramJSONArray.get("id").hashCode()))) {
                this.rebrandAdapter.mDatas.add(localObject);
                this.rebrandAdapter.forumItemId.add(Integer.valueOf(Util.getMD5((String) paramJSONArray.get("id")).hashCode()));
            }
            AppCacheManager.cacheData(this.rebrandAdapter.cacheFile, this.rebrandAdapter.mDatas);
            return;
        } catch (Exception paramJSONArray) {
        }
    }

    public void addNoSearchResult() {
        if ((this.mActivity instanceof IcsRebrandingEntryActivity)) {
            this.fragment = YukuSearchFragment.newInstance(this.query);
            ((IcsRebrandingEntryActivity) this.mActivity).addFragmentToStack(this.fragment, "all_in_one_stack_tag", true);
        }
        this.searchDatas.add("no result");
        new Handler().postDelayed(new Runnable() {
            public void run() {
                if ((YukuSearchAction.this.mActivity instanceof IcsRebrandingEntryActivity)) {
                    YukuSearchAction.this.fragment.setYukuForum(new YukuSearchFragment.YukuForum() {
                        public ArrayList<Object> AddYukuForum() {
                            YukuSearchAction.this.fragment.setLoadingMoreEnabled(false);
                            return YukuSearchAction.this.searchDatas;
                        }
                    });
                }
                YukuSearchAction.this.fragment.YukuForum();
            }
        }, 300L);
    }

    public void addSearchResultForumItemBean(JSONArray paramJSONArray) {
        for (; ; ) {
            int i;
            try {
                if (!(this.mActivity instanceof IcsRebrandingEntryActivity)) {
                    break label211;
                }
                this.fragment = YukuSearchFragment.newInstance(this.query);
                ((IcsRebrandingEntryActivity) this.mActivity).addFragmentToStack(this.fragment, "all_in_one_stack_tag", true);
            } catch (Exception paramJSONArray) {
                JSONObject localJSONObject;
                ForumItemBean localForumItemBean;
                return;
            }
            if (i >= paramJSONArray.length()) {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        if ((YukuSearchAction.this.mActivity instanceof IcsRebrandingEntryActivity)) {
                            YukuSearchAction.this.fragment.setYukuForum(new YukuSearchFragment.YukuForum() {
                                public ArrayList<Object> AddYukuForum() {
                                    YukuSearchAction.this.fragment.setLoadingMoreEnabled(false);
                                    return YukuSearchAction.this.searchDatas;
                                }
                            });
                        }
                        YukuSearchAction.this.fragment.YukuForum();
                    }
                }, 300L);
                return;
            }
            localJSONObject = (JSONObject) paramJSONArray.get(i);
            localForumItemBean = new ForumItemBean();
            localForumItemBean.setForumName((String) localJSONObject.get("name"));
            localForumItemBean.setForumId(Util.getMD5((String) localJSONObject.get("id")).hashCode());
            localForumItemBean.setForumUrl((String) localJSONObject.get("url"));
            if ((localJSONObject.has("logo_new")) && (!((String) localJSONObject.get("logo_new")).equals(""))) {
                localForumItemBean.setIconUrl((String) localJSONObject.get("logo_new"));
                this.searchDatas.add(localForumItemBean);
                i += 1;
            } else {
                localForumItemBean.setIconUrl(localJSONObject.getString("logo"));
                continue;
                label211:
                i = 0;
            }
        }
    }

    public void callBack(EngineResponse paramEngineResponse) {
        if (paramEngineResponse.getMethod().contains("search?")) {
            if (!paramEngineResponse.isSuccess()) {
                break label71;
            }
            paramEngineResponse = (JSONArray) paramEngineResponse.getResponse();
            if (paramEngineResponse.length() != 1) {
                break label48;
            }
            addForumItemBean(paramEngineResponse);
        }
        for (; ; ) {
            this.rebrandAdapter.notifyDataSetChanged();
            return;
            label48:
            if (paramEngineResponse.length() > 1) {
                addSearchResultForumItemBean(paramEngineResponse);
            } else {
                addNoSearchResult();
                continue;
                label71:
                Toast.makeText(this.mActivity, (String) paramEngineResponse.getResponse(), 1).show();
            }
        }
    }

    public boolean isOpCancel() {
        return false;
    }

    public void setOpCancel(boolean paramBoolean) {
    }

    public void updateSubclassDialog(int paramInt) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/action/YukuSearchAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */