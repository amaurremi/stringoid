package mobi.beyondpod.sync;

import android.os.Handler;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Comparator;
import java.util.Date;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.repository.RepositoryPersistence;

public abstract class TrackedChangeBase
{
  public static final int CHANGE_TYPE_ENCLOSURE_MARKED_AS_DOWNLOADED = 5;
  public static final int CHANGE_TYPE_ENCLOSURE_MARKED_AS_NOT_DOWNLOADED = 6;
  public static final int CHANGE_TYPE_ENCLOSURE_STREAMABLE_TRACK_ADDED = 4;
  public static final int CHANGE_TYPE_EPISODE_DELETED = 9;
  public static final int CHANGE_TYPE_EPISODE_DOWNLOADED = 7;
  public static final int CHANGE_TYPE_EPISODE_PLAYED = 8;
  public static final int CHANGE_TYPE_EPISODE_UPDATED = 15;
  public static final int CHANGE_TYPE_FEED_ADDED = 1;
  public static final int CHANGE_TYPE_FEED_DELETED = 2;
  public static final int CHANGE_TYPE_FEED_MODIFIED = 3;
  public static final int CHANGE_TYPE_FEED_PUSH = 14;
  public static final int CHANGE_TYPE_POST_READ = 12;
  public static final int CHANGE_TYPE_POST_STARRED = 10;
  public static final int CHANGE_TYPE_POST_UNREAD = 13;
  public static final int CHANGE_TYPE_POST_UNSTARRED = 11;
  public static final int SYNC_STATUS_SYNC_DOWN_APPLIED = 4;
  public static final int SYNC_STATUS_SYNC_DOWN_PENDING = 3;
  public static final int SYNC_STATUS_SYNC_UP_PENDING = 2;
  public static final int SYNC_STATUS_SYNC_UP_SYNCED = 1;
  public static final int SYNC_STATUS_UNKNOWN = 0;
  public static Comparator<TrackedChangeBase> TimestampComparator = new Comparator()
  {
    public int compare(TrackedChangeBase paramAnonymousTrackedChangeBase1, TrackedChangeBase paramAnonymousTrackedChangeBase2)
    {
      if (paramAnonymousTrackedChangeBase1.TimeStamp() == paramAnonymousTrackedChangeBase2.TimeStamp()) {
        return 0;
      }
      if (paramAnonymousTrackedChangeBase1.TimeStamp() > paramAnonymousTrackedChangeBase2.TimeStamp()) {
        return 1;
      }
      return -1;
    }
  };
  protected static final String _BlobDelimiter = "|$*|";
  protected String _Blob;
  protected int _ChangeType;
  private boolean _Deleted = false;
  boolean _IsModified = false;
  protected String _MessageId;
  private Long _StorageRowID = null;
  private int _SyncStatus = 0;
  protected long _TimeStamp;
  
  public TrackedChangeBase(int paramInt)
  {
    this._ChangeType = paramInt;
    this._TimeStamp = new Date().getTime();
  }
  
  public TrackedChangeBase(Long paramLong, long paramLong1, int paramInt1, int paramInt2, String paramString)
  {
    this._TimeStamp = paramLong1;
    this._ChangeType = paramInt1;
    this._SyncStatus = paramInt2;
    this._StorageRowID = paramLong;
    this._Blob = paramString;
  }
  
  public static void LogSyncEvent(String paramString1, String paramString2, TrackedChangeBase paramTrackedChangeBase)
  {
    CoreHelper.WriteTraceEntry(paramString1, paramString2);
    RepositoryPersistence.RepositoryHandler().post(new Runnable()
    {
      public void run()
      {
        String str = TrackedChangeBase.this + "\r\n";
        try
        {
          BufferedWriter localBufferedWriter = new BufferedWriter(new FileWriter(Configuration.SyncLogFilePath(), true), 8192);
          localBufferedWriter.write(str);
          localBufferedWriter.close();
          return;
        }
        catch (Exception localException) {}
      }
    });
  }
  
  private String StorageType()
  {
    if (this._StorageRowID == null) {
      return "+";
    }
    if (IsMarkedForDeletion()) {
      return "-";
    }
    if (IsModified()) {
      return "*";
    }
    return "_";
  }
  
  private String SyncStatusName()
  {
    switch (this._SyncStatus)
    {
    default: 
      return "NA";
    case 2: 
      return "UP";
    case 1: 
      return "US";
    case 3: 
      return "DP";
    }
    return "DS";
  }
  
  public abstract void ApplyRemoteChange();
  
  public String Blob()
  {
    return this._Blob;
  }
  
  public String ChangeName()
  {
    switch (this._ChangeType)
    {
    default: 
      return "UNKNOWN";
    case 1: 
      return "FEED_ADDED";
    case 2: 
      return "FEED_DELETED";
    case 3: 
      return "FEED_MODIFIED";
    case 14: 
      return "FEED_PUSH";
    case 5: 
      return "ENCL_MARKED_AS_DOWNLOADED";
    case 6: 
      return "ENCL_MARKED_AS_NOT_DOWNLOADED";
    case 4: 
      return "EP_ADDED";
    case 7: 
      return "EP_DOWNLOADED";
    case 8: 
      return "EP_PLAYED";
    case 9: 
      return "EP_DELETED";
    case 15: 
      return "EP_UPDATED";
    case 12: 
      return "POST_READ";
    case 13: 
      return "POST_UNREAD";
    case 10: 
      return "POST_STARRED";
    }
    return "POST_UNSTARRED";
  }
  
  public int ChangeType()
  {
    return this._ChangeType;
  }
  
  public abstract String FriendlyName();
  
  public void InitRowID(Long paramLong)
  {
    this._StorageRowID = paramLong;
  }
  
  public boolean IsMarkedForDeletion()
  {
    return this._Deleted;
  }
  
  public boolean IsModified()
  {
    return this._IsModified;
  }
  
  public boolean IsNew()
  {
    return this._StorageRowID == null;
  }
  
  protected abstract boolean IsValid();
  
  public void MarkDeleted()
  {
    this._Deleted = true;
  }
  
  public abstract String MessageId();
  
  protected String[] ParseBlob()
  {
    if (StringUtils.IsNullOrEmpty(this._Blob)) {
      return new String[0];
    }
    return this._Blob.split("\\|\\$\\*\\|");
  }
  
  public abstract void PrepareForSave();
  
  public Long RowID()
  {
    return this._StorageRowID;
  }
  
  protected void SaveToBlob(String... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    for (;;)
    {
      if (i == paramVarArgs.length)
      {
        this._Blob = localStringBuilder.toString();
        return;
      }
      String str = paramVarArgs[i];
      if (str != null) {
        localStringBuilder.append(str.replace("|$*|", " "));
      }
      if (i < paramVarArgs.length - 1) {
        localStringBuilder.append("|$*|");
      }
      i += 1;
    }
  }
  
  public void SetIsModified(boolean paramBoolean)
  {
    this._IsModified = paramBoolean;
  }
  
  public int SyncStatus()
  {
    return this._SyncStatus;
  }
  
  public long TimeStamp()
  {
    return this._TimeStamp;
  }
  
  public void UpdateTo(TrackedChangeBase paramTrackedChangeBase)
  {
    this._TimeStamp = paramTrackedChangeBase.TimeStamp();
    this._IsModified = true;
  }
  
  public void setSyncStatus(int paramInt)
  {
    this._IsModified = true;
    this._SyncStatus = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("St:").append(StorageType()).append(", Sync:").append(SyncStatusName()).append(" : ").append(new Date(TimeStamp())).append(" => ").append(ChangeName()).append(" (");
    if (IsValid()) {}
    for (String str = "V";; str = "I") {
      return str + ") " + FriendlyName();
    }
  }
  
  public void updateSyncStatusTo(int paramInt)
  {
    this._SyncStatus = paramInt;
    this._IsModified = true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/sync/TrackedChangeBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */