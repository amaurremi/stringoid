package com.quoord.tapatalkpro.alarm;

public abstract interface IAlarmMonitor {
    public abstract void registerAccount(String paramString1, String paramString2, IAlarmListener paramIAlarmListener);

    public abstract void removeAccount(IAlarmListener paramIAlarmListener);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/alarm/IAlarmMonitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */