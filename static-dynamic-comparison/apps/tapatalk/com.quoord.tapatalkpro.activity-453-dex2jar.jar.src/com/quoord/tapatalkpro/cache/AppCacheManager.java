package com.quoord.tapatalkpro.cache;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class AppCacheManager {
    public static final String CASH_CATEGORY_FILE = "new_ics_categories_cash_file.cache";
    public static final String FUNCTION_CONFIG_CATCH_FILE = "function_config_catch_file.cache";
    public static String cacheBasePath;
    public static String cacheLongtermPath;
    public static String cacheSessionPath;
    public static String favoriteForumLogo;
    public static String remoteImageCache;
    public static String rootPath;

    public static void cacheData(String paramString, Object paramObject) {
        if ((paramString != null) && (paramString.length() > 0)) {
        }
        try {
            paramString = new FileOutputStream(paramString);
            ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(new BufferedOutputStream(paramString, 10000));
            localObjectOutputStream.writeObject(paramObject);
            localObjectOutputStream.close();
            paramString.close();
            return;
        } catch (IOException paramString) {
        }
    }

    public static void cacheExploreData(String paramString, Object paramObject) {
        if ((paramString != null) && (paramString.length() > 0)) {
        }
        try {
            paramString = new FileOutputStream(cacheBasePath + paramString);
            ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(new BufferedOutputStream(paramString, 10000));
            localObjectOutputStream.writeObject(paramObject);
            localObjectOutputStream.close();
            paramString.close();
            return;
        } catch (IOException paramString) {
        }
    }

    public static void cacheForumCookiesData(String paramString, Object paramObject) {
        cacheData(paramString, paramObject);
    }

    public static void cacheForumStatusData(String paramString, Object paramObject) {
        cacheData(paramString, paramObject);
    }

    public static boolean checkFile(String paramString) {
        if ((paramString == null) || (paramString.length() == 0)) {
        }
        while (!new File(paramString).exists()) {
            return false;
        }
        return true;
    }

    public static void cleanSessionCache(Context paramContext, String paramString) {
        if ((paramString != null) && (!paramString.equals(""))) {
        }
        try {
            del(getSessionCacheDir(paramContext) + paramString);
            return;
        } catch (Exception paramContext) {
            paramContext.printStackTrace();
        }
    }

    public static void clearForumCache(Context paramContext, String paramString) {
        String str = getNewCachePath(paramString, "");
        paramString = getLongtermCacheDir(paramContext) + str;
        paramContext = getSessionCacheDir(paramContext) + str;
        try {
            del(paramString);
            del(paramContext);
            return;
        } catch (Exception paramContext) {
            paramContext.printStackTrace();
        }
    }

    public static void createCacheDir(Context paramContext) {
        rootPath = getRootCacheDir(paramContext);
        cacheBasePath = getBaseCacheDir(paramContext);
        cacheSessionPath = getSessionCacheDir(paramContext);
        cacheLongtermPath = rootPath + "cache/longterm/";
        favoriteForumLogo = getFavForumLogoCacheDir(paramContext);
        remoteImageCache = getRemoteImageCacheDir(paramContext);
        paramContext = new File(rootPath);
        if (!paramContext.exists()) {
            paramContext.mkdir();
        }
        paramContext = new File(cacheBasePath);
        if (!paramContext.exists()) {
            paramContext.mkdir();
        }
        paramContext = new File(cacheSessionPath);
        if (!paramContext.exists()) {
            paramContext.mkdir();
        }
        paramContext = new File(cacheLongtermPath);
        if (!paramContext.exists()) {
            paramContext.mkdir();
        }
        paramContext = new File(favoriteForumLogo);
        if (!paramContext.exists()) {
            paramContext.mkdir();
        }
        paramContext = new File(remoteImageCache);
        if (!paramContext.exists()) {
            paramContext.mkdir();
        }
    }

    public static void del(String paramString) {
        try {
            paramString = new File(paramString);
            File[] arrayOfFile;
            int j;
            int i;
            if ((paramString.exists()) && (paramString.isDirectory())) {
                if (paramString.listFiles().length == 0) {
                    paramString.delete();
                    return;
                }
                arrayOfFile = paramString.listFiles();
                j = paramString.listFiles().length;
                i = 0;
            }
            while (i < j) {
                if (arrayOfFile[i].isDirectory()) {
                    del(arrayOfFile[i].getAbsolutePath());
                }
                arrayOfFile[i].delete();
                i += 1;
                continue;
                paramString.delete();
                return;
            }
        } catch (Exception paramString) {
        }
    }

    public static String getBaseCacheDir(Context paramContext) {
        return getRootCacheDir(paramContext) + "/";
    }

    public static Object getCacheData(String paramString) {
        try {
            if (new File(paramString).exists()) {
                paramString = new FileInputStream(paramString);
                BufferedInputStream localBufferedInputStream = new BufferedInputStream(paramString, 10000);
                ObjectInputStream localObjectInputStream = new ObjectInputStream(localBufferedInputStream);
                Object localObject = localObjectInputStream.readObject();
                localObjectInputStream.close();
                localBufferedInputStream.close();
                paramString.close();
                return localObject;
            }
            return null;
        } catch (Exception paramString) {
        }
        return null;
    }

    public static String getCloudAccountUrl(Context paramContext) {
        paramContext = getLongtermCacheDir(paramContext);
        File localFile = new File(paramContext);
        if (!localFile.exists()) {
            localFile.mkdirs();
        }
        return paramContext + "cloudaccount.cache";
    }

    public static String getColorUrl(Context paramContext) {
        paramContext = getLongtermCacheDir(paramContext);
        File localFile = new File(paramContext);
        if (!localFile.exists()) {
            localFile.mkdirs();
        }
        return paramContext + "color.cache";
    }

    public static String getCookieCacheUrl(Context paramContext, String paramString1, String paramString2) {
        return getForumBaseCacheUrl(paramContext, paramString1, paramString2) + "/1.cache";
    }

    public static ExploreCache getExploreData() {
        Object localObject = cacheBasePath + "new_ics_categories_cash_file.cache";
        if (checkFile((String) localObject)) {
            localObject = getCacheData((String) localObject);
            if ((localObject instanceof ExploreCache)) {
                localObject = (ExploreCache) localObject;
                if (System.currentTimeMillis() - ((ExploreCache) localObject).writeTime < ((ExploreCache) localObject).saveForTime) {
                    return (ExploreCache) localObject;
                }
            }
        }
        return null;
    }

    public static String getFavForumLogoCacheDir(Context paramContext) {
        return getRootCacheDir(paramContext) + "/favoriteForumLogo/";
    }

    public static String getFeedTempAccountUrl(Context paramContext) {
        paramContext = getLongtermCacheDir(paramContext);
        File localFile = new File(paramContext);
        if (!localFile.exists()) {
            localFile.mkdirs();
        }
        return paramContext + "feed_temp_account.cache";
    }

    public static String getForumBaseCacheUrl(Context paramContext, String paramString1, String paramString2) {
        paramContext = getLongtermCacheDir(paramContext) + getNewCachePath(paramString1, paramString2);
        paramString1 = new File(paramContext);
        if (!paramString1.exists()) {
            paramString1.mkdirs();
        }
        return paramContext;
    }

    public static String getForumCacheUrl(Context paramContext, String paramString1, String paramString2) {
        return getForumBaseCacheUrl(paramContext, paramString1, paramString2) + "/getForum.cache";
    }

    public static ForumCookiesCache getForumCookiesData(String paramString) {
        if (checkFile(paramString)) {
            Object localObject = getCacheData(paramString);
            if ((localObject instanceof ForumCookiesCache)) {
                localObject = (ForumCookiesCache) localObject;
                if (System.currentTimeMillis() - ((ForumCookiesCache) localObject).writeTime < ((ForumCookiesCache) localObject).saveForTime) {
                    return (ForumCookiesCache) localObject;
                }
                del(paramString);
            }
        }
        return null;
    }

    public static String getForumSessionBaseCacheUrl(Context paramContext, String paramString1, String paramString2) {
        paramContext = getSessionCacheDir(paramContext) + getNewCachePath(paramString1, paramString2);
        paramString1 = new File(paramContext);
        if (!paramString1.exists()) {
            paramString1.mkdirs();
        }
        return paramContext;
    }

    public static ProtectedForumCache getForumSessionProtected(String paramString) {
        if (checkFile(paramString)) {
            Object localObject = getCacheData(paramString);
            if ((localObject instanceof ProtectedForumCache)) {
                localObject = (ProtectedForumCache) localObject;
                if (System.currentTimeMillis() - ((ProtectedForumCache) localObject).writeTime < ((ProtectedForumCache) localObject).saveForTime) {
                    return (ProtectedForumCache) localObject;
                }
                del(paramString);
            }
        }
        return null;
    }

    public static String getForumSessionProtectedUrl(Context paramContext, String paramString1, String paramString2) {
        return getForumSessionBaseCacheUrl(paramContext, paramString1, paramString2) + "/protected.cache";
    }

    public static String getForumStatusCacheUrl(Context paramContext, String paramString1, String paramString2) {
        return getForumBaseCacheUrl(paramContext, paramString1, paramString2) + "/forumStatus.cache";
    }

    public static ForumStatusCache getForumStatusData(String paramString) {
        if (checkFile(paramString)) {
            paramString = getCacheData(paramString);
            if ((paramString instanceof ForumStatusCache)) {
                paramString = (ForumStatusCache) paramString;
                if (System.currentTimeMillis() - paramString.writeTime < paramString.saveForTime) {
                    return paramString;
                }
            }
        }
        return null;
    }

    public static ForumStatusCache getForumStatusDataIgnoreCacheTime(String paramString) {
        if (checkFile(paramString)) {
            paramString = getCacheData(paramString);
            if ((paramString instanceof ForumStatusCache)) {
                return (ForumStatusCache) paramString;
            }
        }
        return null;
    }

    public static String getForumUseNameUrl(Context paramContext, String paramString1, String paramString2) {
        return getForumBaseCacheUrl(paramContext, paramString1, paramString2) + "/userName.cache";
    }

    public static FunctionConfigCache getFunctionConfigCache(String paramString) {
        if (checkFile(paramString)) {
            paramString = getCacheData(paramString);
            if ((paramString instanceof FunctionConfigCache)) {
                paramString = (FunctionConfigCache) paramString;
                if (System.currentTimeMillis() - paramString.writeTime < paramString.saveForTime) {
                    return paramString;
                }
            }
        }
        return null;
    }

    public static String getFunctionConfigCacheFileUrl(Context paramContext) {
        paramContext = getBaseCacheDir(paramContext);
        File localFile = new File(paramContext);
        if (!localFile.exists()) {
            localFile.mkdirs();
        }
        return paramContext + "function_config_catch_file.cache";
    }

    public static String getGroupUrl(Context paramContext) {
        paramContext = getLongtermCacheDir(paramContext);
        File localFile = new File(paramContext);
        if (!localFile.exists()) {
            localFile.mkdirs();
        }
        return paramContext + "group.cache";
    }

    public static String getLongtermCacheDir(Context paramContext) {
        return getRootCacheDir(paramContext) + "/longterm/";
    }

    public static String getModerateCookieCacheUrl(Context paramContext, String paramString1, String paramString2) {
        return getForumBaseCacheUrl(paramContext, paramString1, paramString2) + "/moderate.cache";
    }

    public static String getNetWorkUrl(Context paramContext) {
        paramContext = getLongtermCacheDir(paramContext);
        File localFile = new File(paramContext);
        if (!localFile.exists()) {
            localFile.mkdirs();
        }
        return paramContext + "netWorkAdapter.cache";
    }

    public static String getNewCachePath(String paramString1, String paramString2) {
        if (paramString1 != null) {
            String str = paramString1.replace("http://", "").replace("https://", "").replaceAll("/", "");
            paramString1 = str;
            if (paramString2 != null) {
                paramString1 = str;
                if (!paramString2.equals("")) {
                    paramString1 = str + "/" + paramString2.toLowerCase();
                }
            }
            return paramString1;
        }
        return null;
    }

    public static String getOrderUrl(Context paramContext) {
        paramContext = getLongtermCacheDir(paramContext);
        File localFile = new File(paramContext);
        if (!localFile.exists()) {
            localFile.mkdirs();
        }
        return paramContext + "order.cache";
    }

    public static String getPostDatasFile(Context paramContext) {
        paramContext = getLongtermCacheDir(paramContext);
        File localFile = new File(paramContext);
        if (!localFile.exists()) {
            localFile.mkdirs();
        }
        return paramContext + "postDatas.cache";
    }

    public static String getRebrandAdapterUrl(Context paramContext) {
        paramContext = getLongtermCacheDir(paramContext);
        File localFile = new File(paramContext);
        if (!localFile.exists()) {
            localFile.mkdirs();
        }
        return paramContext + "rebrandAdapter.cache";
    }

    public static String getRebrandingForumUrl(Context paramContext) {
        paramContext = getLongtermCacheDir(paramContext);
        File localFile = new File(paramContext);
        if (!localFile.exists()) {
            localFile.mkdirs();
        }
        return paramContext + "rebranding_tapatalkforum.cache";
    }

    public static String getRebrandingUrl(Context paramContext) {
        paramContext = getLongtermCacheDir(paramContext);
        File localFile = new File(paramContext);
        if (!localFile.exists()) {
            localFile.mkdirs();
        }
        return paramContext + "rebranding.cache";
    }

    public static String getRecentForumCacheUrl(Context paramContext, String paramString1, String paramString2) {
        return getForumBaseCacheUrl(paramContext, paramString1, paramString2) + "/getRecentForum.cache";
    }

    public static String getRemoteImageCacheDir(Context paramContext) {
        remoteImageCache = getRootCacheDir(paramContext) + "/remote-image-cache/";
        paramContext = new File(remoteImageCache);
        if (!paramContext.exists()) {
            paramContext.mkdir();
        }
        return remoteImageCache;
    }

    public static String getRootCacheDir(Context paramContext) {
        if ((rootPath != null) && (!rootPath.equals(""))) {
            if (!new File(rootPath).exists()) {
                makeRootDir(paramContext);
            }
            return rootPath;
        }
        makeRootDir(paramContext);
        return rootPath;
    }

    public static String getSearchHistoryUrl(Context paramContext, String paramString1, String paramString2) {
        return getForumBaseCacheUrl(paramContext, paramString1, paramString2) + "/searchHistory.cache";
    }

    public static String getSessionCacheDir(Context paramContext) {
        return getRootCacheDir(paramContext) + "/session/";
    }

    public static String getSubscribeTopicUrl(Context paramContext) {
        paramContext = getLongtermCacheDir(paramContext);
        File localFile = new File(paramContext);
        if (!localFile.exists()) {
            localFile.mkdirs();
        }
        return paramContext + "subscribeTopic.cache";
    }

    public static String getThreadCacheUrl(Context paramContext, String paramString1, String paramString2) {
        paramContext = getSessionCacheDir(paramContext) + getNewCachePath(paramString1, null);
        paramString1 = new File(paramContext);
        if (!paramString1.exists()) {
            paramString1.mkdirs();
        }
        return paramContext + "/getThread.cache." + paramString2;
    }

    @TargetApi(9)
    private static boolean isExternalStorageRemovable() {
        return (Build.VERSION.SDK_INT < 9) || (Environment.isExternalStorageRemovable());
    }

    public static void makeRootDir(Context paramContext) {
        File localFile1 = null;
        if (("mounted".equals(Environment.getExternalStorageState())) || (!isExternalStorageRemovable())) {
            localFile1 = paramContext.getExternalCacheDir();
        }
        File localFile2 = localFile1;
        if (localFile1 == null) {
            localFile2 = paramContext.getCacheDir();
        }
        rootPath = localFile2.getPath();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/cache/AppCacheManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */