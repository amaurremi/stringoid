package mobi.beyondpod.schedulercore;

import android.os.SystemClock;
import java.util.Random;
import java.util.UUID;
import mobi.beyondpod.rsscore.helpers.AnalyticsTracker;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.StringUtils;

public class OperationBase
{
  private static String TAG = OperationBase.class.getSimpleName();
  static Random _Random = new Random(SystemClock.elapsedRealtime());
  protected String _Description = "Unknown";
  protected UUID _ID = null;
  protected String _Name = "Unknown";
  OperationCompletedCallback _OnOperationCompleted;
  private ScheduledTask _Owner;
  protected boolean m_IsModified;
  
  protected OperationBase(String paramString1, String paramString2, UUID paramUUID)
  {
    this._Description = paramString2;
    this._Name = paramString1;
    this._ID = paramUUID;
  }
  
  public static boolean Compare(OperationBase paramOperationBase1, OperationBase paramOperationBase2)
  {
    return StringUtils.EqualsIgnoreCase(paramOperationBase1.Description(), paramOperationBase2.Description());
  }
  
  public OperationBase CreateInstance(String paramString)
  {
    return this;
  }
  
  public String Description()
  {
    return this._Description;
  }
  
  public void Execute(OperationCompletedCallback paramOperationCompletedCallback)
  {
    AnalyticsTracker.OnBPScheduledTaskStarted(Name());
    CoreHelper.WriteLogEntryInProduction(TAG, "#=> Executing Operation: " + Name());
    this._OnOperationCompleted = paramOperationCompletedCallback;
  }
  
  protected long GenerateRandomOffest(long paramLong1, long paramLong2)
  {
    return CoreHelper.GenerateRandomNumber(paramLong1, paramLong2, _Random);
  }
  
  public UUID ID()
  {
    return this._ID;
  }
  
  public boolean IsConfigurable()
  {
    return false;
  }
  
  public boolean IsModified()
  {
    return this.m_IsModified;
  }
  
  public String Name()
  {
    return this._Name;
  }
  
  protected void OnOperationCompleted()
  {
    CoreHelper.WriteLogEntryInProduction(TAG, "*=> Operation Execution completed: " + Name());
    if (this._OnOperationCompleted != null) {
      this._OnOperationCompleted.OnOperationComplete();
    }
  }
  
  public ScheduledTask Owner()
  {
    return this._Owner;
  }
  
  public String SerializedData()
  {
    return "";
  }
  
  public void SetIsModified(boolean paramBoolean)
  {
    this.m_IsModified = paramBoolean;
  }
  
  public void SetOwner(ScheduledTask paramScheduledTask)
  {
    this._Owner = paramScheduledTask;
  }
  
  public long StartTimeBias()
  {
    return 0L;
  }
  
  public String toString()
  {
    return Name();
  }
  
  public static abstract interface OperationCompletedCallback
  {
    public abstract void OnOperationComplete();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/schedulercore/OperationBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */