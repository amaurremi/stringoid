package mobi.beyondpod.schedulercore;

import java.util.Date;
import mobi.beyondpod.rsscore.helpers.CoreHelper;

public class ScheduledTask
{
  public static final int Default_Min_BatteryLevel = 6;
  private static String TAG = ScheduledTask.class.getSimpleName();
  public boolean Active = true;
  public Event Event;
  public int MinBatteryLevelRequired = 6;
  protected OperationBase _Operation;
  protected String _TaskID;
  private boolean m_IsModified = true;
  private Long m_StorageRowID;
  
  public ScheduledTask(String paramString)
  {
    this._TaskID = paramString;
  }
  
  public ScheduledTask(Event paramEvent, OperationBase paramOperationBase)
  {
    this.Event = paramEvent;
    SetOperation(paramOperationBase);
  }
  
  public static int Compare(ScheduledTask paramScheduledTask1, ScheduledTask paramScheduledTask2)
  {
    if (((paramScheduledTask1.Event == null) || (paramScheduledTask1.Event.StartTime() == null)) && ((paramScheduledTask2.Event == null) || (paramScheduledTask2.Event.StartTime() == null))) {
      return 0;
    }
    if ((paramScheduledTask1.Event == null) || (paramScheduledTask1.Event.StartTime() == null)) {
      return -1;
    }
    if ((paramScheduledTask2.Event == null) || (paramScheduledTask2.Event.StartTime() == null)) {
      return 1;
    }
    return paramScheduledTask1.Event.StartTime().compareTo(paramScheduledTask2.Event.StartTime());
  }
  
  public boolean CheckIfCanExecute()
  {
    if (!this.Active)
    {
      CoreHelper.WriteLogEntry(TAG, String.format(" Task %s is Inactive!", new Object[] { this }));
      return false;
    }
    if (CoreHelper.IsDevicePlugged()) {
      return true;
    }
    int i = this.MinBatteryLevelRequired;
    int j = CoreHelper.PowerBatteryStrength();
    if (j < i)
    {
      CoreHelper.WriteLogEntry(TAG, String.format(" Task %s requires battery level of at least %s%%! Current battery level: %s%%! Task was not executed!", new Object[] { this, Integer.valueOf(i), Integer.valueOf(j) }));
      return false;
    }
    return true;
  }
  
  public boolean ExistsOnDevice()
  {
    return ScheduledTasksManager.HasPendingIntentForTask(this);
  }
  
  public void InitRowID(Long paramLong)
  {
    this.m_StorageRowID = paramLong;
  }
  
  public boolean IsModified()
  {
    return (this.m_IsModified) || (this.Event.IsModified()) || (Operation().IsModified());
  }
  
  public OperationBase Operation()
  {
    return this._Operation;
  }
  
  public Long RowID()
  {
    return this.m_StorageRowID;
  }
  
  public void SetIsModified(boolean paramBoolean)
  {
    this.m_IsModified = paramBoolean;
  }
  
  public void SetOperation(OperationBase paramOperationBase)
  {
    this._Operation = paramOperationBase;
    paramOperationBase.SetOwner(this);
  }
  
  public String TaskID()
  {
    if (this._TaskID == null) {
      this._TaskID = ("BPT#" + Long.toString(System.currentTimeMillis()));
    }
    return this._TaskID;
  }
  
  public String toString()
  {
    OperationBase localOperationBase = Operation();
    Event localEvent = this.Event;
    if (this.Active) {}
    for (String str = "";; str = "Inactive!") {
      return String.format("%s, %s, %s (%s)", new Object[] { localOperationBase, localEvent, str, TaskID() });
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/schedulercore/ScheduledTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */