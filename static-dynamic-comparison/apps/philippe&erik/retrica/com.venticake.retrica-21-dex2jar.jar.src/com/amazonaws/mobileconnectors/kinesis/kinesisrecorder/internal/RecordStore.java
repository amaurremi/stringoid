package com.amazonaws.mobileconnectors.kinesis.kinesisrecorder.internal;

public abstract interface RecordStore
{
  public abstract RecordStore.RecordIterator iterator();
  
  public abstract boolean put(String paramString);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/RecordStore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */