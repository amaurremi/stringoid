package com.google.android.apps.analytics;

abstract interface HitStore
{
  public abstract void clearReferrer();
  
  public abstract void deleteHit(long paramLong);
  
  public abstract int getNumStoredHits();
  
  public abstract Referrer getReferrer();
  
  public abstract String getSessionId();
  
  public abstract int getStoreId();
  
  public abstract String getVisitorCustomVar(int paramInt);
  
  public abstract String getVisitorId();
  
  public abstract void loadExistingSession();
  
  public abstract Hit[] peekHits();
  
  public abstract Hit[] peekHits(int paramInt);
  
  public abstract void putEvent(Event paramEvent);
  
  public abstract void setAnonymizeIp(boolean paramBoolean);
  
  public abstract boolean setReferrer(String paramString);
  
  public abstract void setSampleRate(int paramInt);
  
  public abstract void startNewVisit();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/google/android/apps/analytics/HitStore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */