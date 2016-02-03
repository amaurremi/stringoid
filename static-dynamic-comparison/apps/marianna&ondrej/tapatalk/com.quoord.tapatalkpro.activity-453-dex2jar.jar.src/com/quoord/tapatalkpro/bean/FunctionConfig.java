package com.quoord.tapatalkpro.bean;

import android.content.Context;
import com.quoord.tapatalkpro.action.FunctionConfigAction;
import com.quoord.tapatalkpro.action.FunctionConfigAction.GetFunctionConfigActionBack;
import com.quoord.tapatalkpro.cache.AppCacheManager;
import com.quoord.tapatalkpro.cache.FunctionConfigCache;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class FunctionConfig
        implements Serializable {
    private static final long serialVersionUID = -1024453345674621370L;
    private Integer mEnableNewInvitation = null;
    private Integer mInvitation = null;
    private Integer mInvitationClickTimes = null;
    private Integer mInvitationMaxNumOneTime = null;
    private Integer mNewInvitaionDisplayPeriod = null;
    private Integer mTidRegPush = null;

    public FunctionConfig() {
    }

    public FunctionConfig(Context paramContext) {
    }

    public static FunctionConfig getFunctionConfig(Context paramContext) {
        Object localObject2 = null;
        Object localObject3 = AppCacheManager.getFunctionConfigCacheFileUrl(paramContext);
        Object localObject1 = localObject2;
        if (AppCacheManager.checkFile((String) localObject3)) {
            localObject3 = AppCacheManager.getFunctionConfigCache((String) localObject3);
            localObject1 = localObject2;
            if (localObject3 != null) {
                localObject1 = ((FunctionConfigCache) localObject3).functionConfig;
            }
        }
        if (localObject1 == null) {
            startInitialize(paramContext);
        }
        return (FunctionConfig) localObject1;
    }

    private void readObject(ObjectInputStream paramObjectInputStream) {
        try {
            this.mInvitation = ((Integer) paramObjectInputStream.readObject());
            this.mInvitationClickTimes = ((Integer) paramObjectInputStream.readObject());
            this.mInvitationMaxNumOneTime = ((Integer) paramObjectInputStream.readObject());
            this.mTidRegPush = ((Integer) paramObjectInputStream.readObject());
            this.mNewInvitaionDisplayPeriod = ((Integer) paramObjectInputStream.readObject());
            this.mEnableNewInvitation = ((Integer) paramObjectInputStream.readObject());
            return;
        } catch (Exception paramObjectInputStream) {
        }
    }

    public static void startInitialize(Context paramContext) {
        String str = AppCacheManager.getFunctionConfigCacheFileUrl(paramContext);
        if ((AppCacheManager.checkFile(str)) && (AppCacheManager.getFunctionConfigCache(str) != null)) {
            return;
        }
        new FunctionConfigAction(paramContext).getFunctionConfig(new FunctionConfigAction.GetFunctionConfigActionBack() {
            public void setFunctionConfig(FunctionConfig paramAnonymousFunctionConfig) {
                FunctionConfigCache localFunctionConfigCache = new FunctionConfigCache();
                localFunctionConfigCache.writeTime = System.currentTimeMillis();
                localFunctionConfigCache.saveForTime = 86400000L;
                localFunctionConfigCache.functionConfig = paramAnonymousFunctionConfig;
                AppCacheManager.cacheData(AppCacheManager.getFunctionConfigCacheFileUrl(FunctionConfig.this), localFunctionConfigCache);
            }
        });
    }

    private void writeObject(ObjectOutputStream paramObjectOutputStream) {
        try {
            paramObjectOutputStream.writeObject(this.mInvitation);
            paramObjectOutputStream.writeObject(this.mInvitationClickTimes);
            paramObjectOutputStream.writeObject(this.mInvitationMaxNumOneTime);
            paramObjectOutputStream.writeObject(this.mTidRegPush);
            paramObjectOutputStream.writeObject(this.mNewInvitaionDisplayPeriod);
            paramObjectOutputStream.writeObject(this.mEnableNewInvitation);
            return;
        } catch (Exception paramObjectOutputStream) {
        }
    }

    public Integer getEnableNewInvitation() {
        return this.mEnableNewInvitation;
    }

    public Integer getInvitation() {
        return this.mInvitation;
    }

    public Integer getInvitationClickTimes() {
        return this.mInvitationClickTimes;
    }

    public Integer getInvitationMaxNumOneTime() {
        return this.mInvitationMaxNumOneTime;
    }

    public Integer getNewInvitaionDisplayPeriod() {
        return this.mNewInvitaionDisplayPeriod;
    }

    public Integer getTidRegPush() {
        return this.mTidRegPush;
    }

    public void setEnableNewInvitation(Integer paramInteger) {
        this.mEnableNewInvitation = paramInteger;
    }

    public void setInvitation(Integer paramInteger) {
        this.mInvitation = paramInteger;
    }

    public void setInvitationClickTimes(Integer paramInteger) {
        this.mInvitationClickTimes = paramInteger;
    }

    public void setInvitationMaxNumOneTime(Integer paramInteger) {
        this.mInvitationMaxNumOneTime = paramInteger;
    }

    public void setNewInvitaionDisplayPeriod(Integer paramInteger) {
        this.mNewInvitaionDisplayPeriod = paramInteger;
    }

    public void setTidRegPush(Integer paramInteger) {
        this.mTidRegPush = paramInteger;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/bean/FunctionConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */