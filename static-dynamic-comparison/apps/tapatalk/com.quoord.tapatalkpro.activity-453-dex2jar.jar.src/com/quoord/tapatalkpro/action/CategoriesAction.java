package com.quoord.tapatalkpro.action;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.quoord.tapatalkpro.bean.TapatalkCategory;
import com.quoord.tapatalkpro.cache.AppCacheManager;
import com.quoord.tapatalkpro.cache.ExploreCache;
import com.quoord.tapatalkpro.util.CategoryStringUtil;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tools.directoryurl.DirectoryUrlUtil;
import com.quoord.tools.net.JSONUtil;
import com.quoord.tools.net.TapatalkAjaxAction;
import com.quoord.tools.net.TapatalkAjaxAction.ActionCallBack;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CategoriesAction {
    private CategoriesActionCallBack actionCallBack;
    private Activity mActivity;

    public CategoriesAction(Activity paramActivity) {
        this.mActivity = paramActivity;
    }

    private void getRemoteCategorys() {
        String str = DirectoryUrlUtil.getCategoriesUrl(this.mActivity);
        new TapatalkAjaxAction(this.mActivity).getJsonObjectAction(str, new TapatalkAjaxAction.ActionCallBack() {
            public void actionCallBack(Object paramAnonymousObject) {
                ArrayList localArrayList = new ArrayList();
                if (localArrayList == null) {
                    return;
                }
                for (; ; ) {
                    try {
                        paramAnonymousObject = (JSONArray) ((JSONObject) paramAnonymousObject).get("list");
                        int j = ((JSONArray) paramAnonymousObject).length();
                        i = 0;
                        if (i < j) {
                            continue;
                        }
                    } catch (JSONException paramAnonymousObject) {
                        int i;
                        ((JSONException) paramAnonymousObject).printStackTrace();
                        continue;
                    }
                    CategoriesAction.this.shortCategoriesListByLanguage(localArrayList);
                    CategoriesAction.this.saveToExploreCache(localArrayList);
                    CategoriesAction.this.actionCallBack.actionCallBack(localArrayList);
                    return;
                    try {
                        JSONObject localJSONObject = ((JSONArray) paramAnonymousObject).getJSONObject(i);
                        localArrayList.add(CategoriesAction.this.getCategory(localJSONObject));
                        i += 1;
                    } catch (JSONException paramAnonymousObject) {
                        ((JSONException) paramAnonymousObject).printStackTrace();
                    }
                }
            }
        });
    }

    private void setCategoryUserName(TapatalkCategory paramTapatalkCategory) {
        if ((paramTapatalkCategory.getId() != null) && (CategoryStringUtil.getNameMap().get(Integer.valueOf(Integer.parseInt(paramTapatalkCategory.getId()))) != null)) {
            String str = this.mActivity.getString(((Integer) CategoryStringUtil.getNameMap().get(Integer.valueOf(Integer.parseInt(paramTapatalkCategory.getId())))).intValue());
            if ((str != null) && (!str.equals(""))) {
                paramTapatalkCategory.setName(str);
            }
        }
        int i;
        if (paramTapatalkCategory.hasChild()) {
            i = 0;
        }
        for (; ; ) {
            if (i >= paramTapatalkCategory.getChildCat().size()) {
                return;
            }
            setCategoryUserName((TapatalkCategory) paramTapatalkCategory.getChildCat().get(i));
            i += 1;
        }
    }

    public void getCategories(CategoriesActionCallBack paramCategoriesActionCallBack) {
        this.actionCallBack = paramCategoriesActionCallBack;
        ArrayList localArrayList = new ArrayList();
        ExploreCache localExploreCache = AppCacheManager.getExploreData();
        paramCategoriesActionCallBack = localArrayList;
        int i;
        if (localExploreCache != null) {
            paramCategoriesActionCallBack = localArrayList;
            if (localExploreCache.categoryData != null) {
                paramCategoriesActionCallBack = localArrayList;
                if (localExploreCache.categoryData.size() > 0) {
                    localArrayList = localExploreCache.categoryData;
                    paramCategoriesActionCallBack = localArrayList;
                    if (localArrayList != null) {
                        TapatalkCategory localTapatalkCategory = (TapatalkCategory) localArrayList.get(0);
                        paramCategoriesActionCallBack = localArrayList;
                        if (localTapatalkCategory != null) {
                            paramCategoriesActionCallBack = localArrayList;
                            if (localTapatalkCategory.getId() != null) {
                                paramCategoriesActionCallBack = localArrayList;
                                if (!localTapatalkCategory.getName().equals(this.mActivity.getString(((Integer) CategoryStringUtil.getNameMap().get(Integer.valueOf(Integer.parseInt(localTapatalkCategory.getId())))).intValue()))) {
                                    i = 0;
                                }
                            }
                        }
                    }
                }
            }
        }
        for (; ; ) {
            if (i >= localArrayList.size()) {
                shortCategoriesListByLanguage(localArrayList);
                localExploreCache.categoryData.clear();
                localExploreCache.categoryData.addAll(localArrayList);
                AppCacheManager.cacheExploreData("new_ics_categories_cash_file.cache", localExploreCache);
                paramCategoriesActionCallBack = localArrayList;
                if ((paramCategoriesActionCallBack == null) || (paramCategoriesActionCallBack.size() <= 0)) {
                    break;
                }
                this.actionCallBack.actionCallBack(paramCategoriesActionCallBack);
                return;
            }
            setCategoryUserName((TapatalkCategory) localArrayList.get(i));
            i += 1;
        }
        getRemoteCategorys();
    }

    public TapatalkCategory getCategory(JSONObject paramJSONObject) {
        if (paramJSONObject == null) {
            return null;
        }
        TapatalkCategory localTapatalkCategory = new TapatalkCategory();
        JSONUtil localJSONUtil = new JSONUtil(paramJSONObject);
        Object localObject;
        label112:
        label127:
        int j;
        int i;
        try {
            if (paramJSONObject.has("cat_image_new")) {
                localTapatalkCategory.setIconURL(localJSONUtil.optString("cat_image_new"));
                localTapatalkCategory.setNumberOfForums(localJSONUtil.optInteger("count").intValue());
                localTapatalkCategory.setId(localJSONUtil.optString("id"));
                localObject = null;
            }
        } catch (JSONException paramJSONObject) {
            String str;
            paramJSONObject.printStackTrace();
            return localTapatalkCategory;
        }
        try {
            str = this.mActivity.getString(((Integer) CategoryStringUtil.getNameMap().get(Integer.valueOf(Integer.parseInt(localTapatalkCategory.getId())))).intValue());
            localObject = str;
        } catch (Exception localException) {
            break label112;
        }
        if (Util.checkString((String) localObject)) {
            localTapatalkCategory.setName((String) localObject);
            if (paramJSONObject.has("child")) {
                paramJSONObject = (JSONArray) paramJSONObject.get("child");
                j = paramJSONObject.length();
                if ((paramJSONObject != null) && (j > 0)) {
                    i = 0;
                    break label290;
                }
            }
        }
        for (; ; ) {
            localTapatalkCategory.setOb(localJSONUtil.optInteger("ob").intValue());
            localTapatalkCategory.setObName(localJSONUtil.optString("ob_name"));
            localTapatalkCategory.setCat_order(localJSONUtil.optInteger("cat_order").intValue());
            return localTapatalkCategory;
            localTapatalkCategory.setIconURL(localJSONUtil.optString("cat_image"));
            break;
            localTapatalkCategory.setName(paramJSONObject.getString("name"));
            break label127;
            label290:
            do {
                localObject = getCategory(paramJSONObject.getJSONObject(i));
                if ((localObject != null) && (((TapatalkCategory) localObject).getOb() == 1)) {
                    localTapatalkCategory.addChildCat((TapatalkCategory) localObject);
                }
                i += 1;
            } while (i < j);
        }
    }

    public ArrayList<TapatalkCategory> getPopularCategorys(ArrayList<TapatalkCategory> paramArrayList) {
        ArrayList localArrayList = new ArrayList();
        int i;
        if ((paramArrayList != null) && (paramArrayList.size() > 0)) {
            i = 0;
            if (i < paramArrayList.size()) {
            }
        } else {
            return localArrayList;
        }
        if ((((TapatalkCategory) paramArrayList.get(i)).getOb() == 1) && (!localArrayList.contains(Integer.valueOf(((TapatalkCategory) paramArrayList.get(i)).getOb())))) {
            localArrayList.add((TapatalkCategory) paramArrayList.get(i));
        }
        int j;
        if ((((TapatalkCategory) paramArrayList.get(i)).getChildCat() != null) && (((TapatalkCategory) paramArrayList.get(i)).getChildCat().size() > 0)) {
            j = 0;
        }
        for (; ; ) {
            if (j >= ((TapatalkCategory) paramArrayList.get(i)).getChildCat().size()) {
                i += 1;
                break;
            }
            if ((((TapatalkCategory) ((TapatalkCategory) paramArrayList.get(i)).getChildCat().get(j)).getOb() == 1) && (!localArrayList.contains(((TapatalkCategory) paramArrayList.get(i)).getChildCat().get(j)))) {
                localArrayList.add((TapatalkCategory) ((TapatalkCategory) paramArrayList.get(i)).getChildCat().get(j));
            }
            j += 1;
        }
    }

    public void saveToExploreCache(ArrayList<TapatalkCategory> paramArrayList) {
        ExploreCache localExploreCache = new ExploreCache();
        localExploreCache.writeTime = System.currentTimeMillis();
        localExploreCache.saveForTime = 86400000L;
        localExploreCache.categoryData = new ArrayList();
        localExploreCache.categoryData.addAll(paramArrayList);
        AppCacheManager.cacheExploreData("new_ics_categories_cash_file.cache", localExploreCache);
    }

    public void shortCategoriesListByLanguage(ArrayList<TapatalkCategory> paramArrayList) {
        try {
            Collections.sort(paramArrayList, new Comparator() {
                public int compare(TapatalkCategory paramAnonymousTapatalkCategory1, TapatalkCategory paramAnonymousTapatalkCategory2) {
                    paramAnonymousTapatalkCategory1 = paramAnonymousTapatalkCategory1.getName();
                    paramAnonymousTapatalkCategory2 = paramAnonymousTapatalkCategory2.getName();
                    Collator localCollator = Collator.getInstance(CategoriesAction.this.mActivity.getResources().getConfiguration().locale);
                    if (localCollator.compare(paramAnonymousTapatalkCategory1, paramAnonymousTapatalkCategory2) < 0) {
                        return -1;
                    }
                    if (localCollator.compare(paramAnonymousTapatalkCategory1, paramAnonymousTapatalkCategory2) > 0) {
                        return 1;
                    }
                    return 0;
                }
            });
            return;
        } catch (Exception paramArrayList) {
        }
    }

    public static abstract interface CategoriesActionCallBack {
        public abstract void actionCallBack(ArrayList<TapatalkCategory> paramArrayList);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/action/CategoriesAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */