package com.google.tagmanager;

import com.google.analytics.containertag.proto.MutableDebug.EventInfo;

abstract interface DebugInformationHandler
{
  public abstract void receiveEventInfo(MutableDebug.EventInfo paramEventInfo);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/tagmanager/DebugInformationHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */