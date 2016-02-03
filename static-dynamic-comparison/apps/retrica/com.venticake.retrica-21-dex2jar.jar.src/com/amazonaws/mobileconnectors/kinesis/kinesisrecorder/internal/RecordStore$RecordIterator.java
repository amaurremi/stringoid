package com.amazonaws.mobileconnectors.kinesis.kinesisrecorder.internal;

import java.util.Iterator;

public abstract interface RecordStore$RecordIterator
  extends Iterator<String>
{
  public abstract void removeReadRecords();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/RecordStore$RecordIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */