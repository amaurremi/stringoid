package mobi.beyondpod.schedulercore;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.SystemClock;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.rsscore.categories.CategoryManager;
import mobi.beyondpod.rsscore.categories.FeedCategory;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.DateTime;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.helpers.TimeSpan;
import mobi.beyondpod.rsscore.helpers.XmlTextWriter;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.rsscore.rss.ItemStateHistory;
import mobi.beyondpod.rsscore.rss.LicenseManager;
import mobi.beyondpod.services.scheduler.CommandReceiver;
import mobi.beyondpod.sync.ChangeTracker;
import org.xml.sax.helpers.AttributesImpl;

public class ScheduledTasksManager
{
  private static String MANUAL_CATEGORY_UPDATE_TASK_ID = "MANUAL_CATEGORY_UPDATE_TASK:";
  public static final String SCHEDULER_ACTION = "mobi.beyondpod.scheduling.SCHEDULED_TASK";
  private static String TAG = ScheduledTasksManager.class.getSimpleName();
  public static final String TASK_EXTRA = "task_id";
  public static final String TIME_EXTRA = "task_start_time";
  private static SyncGoogleReaderScheduledTask _GoogleReaderSyncTask;
  private static HashMap<UUID, OperationBase> _Operations = new HashMap();
  private static ArrayList<OperationBase> _OperationsForAssignment = new ArrayList(6);
  private static HashMap<String, ScheduledTask> _ScheduledTasks = new HashMap();
  private static SyncChangeTrackingScheduledTask _SyncChangesTask;
  private static UpdateSmartPlayFeedsScheduledTask _UpdateSmartPlayTask;
  
  static
  {
    _GoogleReaderSyncTask = new SyncGoogleReaderScheduledTask();
    _UpdateSmartPlayTask = new UpdateSmartPlayFeedsScheduledTask();
    _SyncChangesTask = new SyncChangeTrackingScheduledTask();
    LoadOperations();
  }
  
  public static int ActiveTaskCount()
  {
    return ActiveTasks().size();
  }
  
  public static List<ScheduledTask> ActiveTasks()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = _ScheduledTasks.values().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return localArrayList;
      }
      ScheduledTask localScheduledTask = (ScheduledTask)localIterator.next();
      if ((localScheduledTask.Active) && (localScheduledTask.Event.StartTime() != null) && (localScheduledTask.Event.StartTime().compareTo(new Date()) > 0)) {
        localArrayList.add(localScheduledTask);
      }
    }
  }
  
  public static String BuildAdHockCategoryUpdateTaskID(String paramString)
  {
    return MANUAL_CATEGORY_UPDATE_TASK_ID + paramString;
  }
  
  private static Intent BuildIntent(ScheduledTask paramScheduledTask)
  {
    Intent localIntent = new Intent("mobi.beyondpod.scheduling.SCHEDULED_TASK");
    localIntent.setData(Uri.parse("bpscheduler:task/" + paramScheduledTask.TaskID()));
    localIntent.putExtra("task_id", paramScheduledTask.TaskID());
    if (paramScheduledTask.Event.StartTime() != null) {}
    for (long l = paramScheduledTask.Event.StartTime().getTime();; l = paramScheduledTask.Event.Recurrence().getTotalMilliseconds())
    {
      localIntent.putExtra("task_start_time", l);
      return localIntent;
    }
  }
  
  private static PendingIntent BuildPendingIntentForTask(ScheduledTask paramScheduledTask)
  {
    return PendingIntent.getBroadcast(BeyondPodApplication.GetInstance(), 0, BuildIntent(paramScheduledTask), 268435456);
  }
  
  public static void ClearAllTasks()
  {
    _ScheduledTasks.clear();
  }
  
  public static void DeleteScheduledTask(ScheduledTask paramScheduledTask)
  {
    if (paramScheduledTask != null)
    {
      UnregisterTask(paramScheduledTask);
      FeedRepository.DeleteScheduledTask(paramScheduledTask);
    }
  }
  
  public static void DeleteScheduledTaskFromDevice(ScheduledTask paramScheduledTask)
  {
    AlarmManager localAlarmManager = (AlarmManager)BeyondPodApplication.GetInstance().getSystemService("alarm");
    PendingIntent localPendingIntent = BuildPendingIntentForTask(paramScheduledTask);
    localAlarmManager.cancel(localPendingIntent);
    localPendingIntent.cancel();
    CoreHelper.WriteTraceEntry(TAG, "Removed scheduled task: " + paramScheduledTask);
  }
  
  public static void DeleteScheduledTasksFromDevice()
  {
    Iterator localIterator = _ScheduledTasks.values().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      DeleteScheduledTaskFromDevice((ScheduledTask)localIterator.next());
    }
  }
  
  public static String DumpRepository()
  {
    String str = "";
    Iterator localIterator = _ScheduledTasks.values().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return str;
      }
      ScheduledTask localScheduledTask = (ScheduledTask)localIterator.next();
      str = str + localScheduledTask + "\n";
    }
  }
  
  public static boolean ExecuteTaskFor(String paramString, OperationBase.OperationCompletedCallback paramOperationCompletedCallback)
  {
    Object localObject = GetTaskById(paramString);
    if (localObject == null) {
      if (paramString.startsWith(MANUAL_CATEGORY_UPDATE_TASK_ID))
      {
        localObject = paramString.replace(MANUAL_CATEGORY_UPDATE_TASK_ID, "");
        if ("ALL FEEDS".equals(((String)localObject).toUpperCase()))
        {
          paramString = CategoryManager.AllFeeds;
          if (paramString != CategoryManager.CategoryNull) {
            break label113;
          }
          CoreHelper.WriteLogEntry(TAG, "Scheduled task MANUAL CATEGORY UPDATE was invoked with an invalid category '" + (String)localObject + "'");
        }
      }
    }
    label113:
    do
    {
      return false;
      if ("UNCATEGORIZED".equals(((String)localObject).toUpperCase()))
      {
        paramString = CategoryManager.Unassigned;
        break;
      }
      paramString = CategoryManager.GetCategoryByValue((String)localObject);
      break;
      localObject = ((OperationBase)Operations().get(OperationUpdateCategory.OperationID)).CreateInstance("");
      ((OperationUpdateCategory)localObject).setCategoryToUpdate(paramString.Value());
      ((OperationBase)localObject).Execute(paramOperationCompletedCallback);
      return true;
      CoreHelper.WriteLogEntry(TAG, String.format("Unable to find task for key: %s", new Object[] { paramString }));
      return false;
      if (((ScheduledTask)localObject).Event.OccursInTheFuture()) {
        SetScheduledTaskToDevice((ScheduledTask)localObject);
      }
    } while (!((ScheduledTask)localObject).CheckIfCanExecute());
    ((ScheduledTask)localObject).Operation().Execute(paramOperationCompletedCallback);
    return true;
  }
  
  public static ArrayList<ScheduledTask> FindOverlappingTasksWith(Event paramEvent)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = _ScheduledTasks.values().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return localArrayList;
      }
      ScheduledTask localScheduledTask = (ScheduledTask)localIterator.next();
      if ((localScheduledTask.Active) && (localScheduledTask.Event.StartTime() != null) && (localScheduledTask.Event.OverlapsWith(paramEvent))) {
        localArrayList.add(localScheduledTask);
      }
    }
  }
  
  public static ScheduledTask GetFirstTaskToExecuteAfter(Date paramDate)
  {
    Object localObject = null;
    double d1 = 2.147483647E9D;
    Iterator localIterator = _ScheduledTasks.values().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return (ScheduledTask)localObject;
      }
      ScheduledTask localScheduledTask = (ScheduledTask)localIterator.next();
      if ((localScheduledTask.Active) && (localScheduledTask.Event.StartTime() != null) && (paramDate.compareTo(localScheduledTask.Event.StartTime()) < 0))
      {
        double d2 = localScheduledTask.Event.StartTime().getTime() - paramDate.getTime();
        if (d2 < d1)
        {
          d1 = d2;
          localObject = localScheduledTask;
        }
      }
    }
  }
  
  public static ScheduledTask GetLastTaskThatExecutedBefore(Date paramDate)
  {
    Object localObject = null;
    double d1 = 2.147483647E9D;
    Iterator localIterator = _ScheduledTasks.values().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return (ScheduledTask)localObject;
      }
      ScheduledTask localScheduledTask = (ScheduledTask)localIterator.next();
      if ((localScheduledTask.Active) && (localScheduledTask.Event.UnadjustedStartTime() != null) && (paramDate.compareTo(localScheduledTask.Event.UnadjustedStartTime()) >= 0))
      {
        double d2 = paramDate.getTime() - localScheduledTask.Event.UnadjustedStartTime().getTime();
        if (d2 < d1)
        {
          d1 = d2;
          localObject = localScheduledTask;
        }
      }
    }
  }
  
  public static ScheduledTask GetTaskById(String paramString)
  {
    if (_GoogleReaderSyncTask.TaskID().equals(paramString)) {
      return _GoogleReaderSyncTask;
    }
    if (_UpdateSmartPlayTask.TaskID().equals(paramString)) {
      return _UpdateSmartPlayTask;
    }
    if (_SyncChangesTask.TaskID().equals(paramString)) {
      return _SyncChangesTask;
    }
    if (_ScheduledTasks.containsKey(paramString)) {
      return (ScheduledTask)_ScheduledTasks.get(paramString);
    }
    return null;
  }
  
  public static boolean HasPendingIntentForTask(ScheduledTask paramScheduledTask)
  {
    boolean bool = false;
    if (PendingIntent.getBroadcast(BeyondPodApplication.GetInstance(), 0, BuildIntent(paramScheduledTask), 536870912) != null) {
      bool = true;
    }
    return bool;
  }
  
  private static void LoadOperations()
  {
    _Operations.put(OperationUpdateCategory.OperationID, new OperationUpdateCategory());
  }
  
  public static ScheduledTask LoadTask(long paramLong1, String paramString1, boolean paramBoolean, int paramInt1, Date paramDate, int paramInt2, long paramLong2, UUID paramUUID, String paramString2)
  {
    paramString1 = new ScheduledTask(paramString1);
    paramString1.InitRowID(Long.valueOf(paramLong1));
    paramString1.Active = paramBoolean;
    paramString1.MinBatteryLevelRequired = paramInt1;
    paramString1.Event = new Event(paramDate, paramInt2, new TimeSpan(paramLong2));
    if (_Operations.containsKey(paramUUID)) {
      paramString1.SetOperation(((OperationBase)_Operations.get(paramUUID)).CreateInstance(paramString2));
    }
    RegisterTask(paramString1);
    return paramString1;
  }
  
  public static ScheduledTask LoadTask(AttributesImpl paramAttributesImpl)
  {
    ScheduledTask localScheduledTask = new ScheduledTask(paramAttributesImpl.getValue("", "id"));
    localScheduledTask.Active = StringUtils.TryParseBooleanFromString(paramAttributesImpl.getValue("", "active"), false);
    localScheduledTask.MinBatteryLevelRequired = StringUtils.TryParseIntFromString(paramAttributesImpl.getValue("", "minBattLevel"), Integer.valueOf(6)).intValue();
    localScheduledTask.Event = new Event(new Date(StringUtils.TryParseLongFromString(paramAttributesImpl.getValue("", "startTime"), Long.valueOf(new Date().getTime())).longValue()), StringUtils.TryParseIntFromString(paramAttributesImpl.getValue("", "recInterval"), Integer.valueOf(1)).intValue(), new TimeSpan(StringUtils.TryParseLongFromString(paramAttributesImpl.getValue("", "recPeriod"), Long.valueOf(1L)).longValue()));
    UUID localUUID = StringUtils.TryParseUUIDFromString(paramAttributesImpl.getValue("", "operationId"), null);
    paramAttributesImpl = paramAttributesImpl.getValue("", "state");
    if (_Operations.containsKey(localUUID)) {
      localScheduledTask.SetOperation(((OperationBase)_Operations.get(localUUID)).CreateInstance(paramAttributesImpl));
    }
    RegisterTask(localScheduledTask);
    return localScheduledTask;
  }
  
  public static HashMap<UUID, OperationBase> Operations()
  {
    return _Operations;
  }
  
  public static ArrayList<OperationBase> OperationsForAssignment()
  {
    return _OperationsForAssignment;
  }
  
  public static void RegisterTask(ScheduledTask paramScheduledTask)
  {
    _ScheduledTasks.put(paramScheduledTask.TaskID(), paramScheduledTask);
  }
  
  public static int RegisteredTaskCount()
  {
    int i = 0;
    Iterator localIterator = _ScheduledTasks.values().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return i;
      }
      ScheduledTask localScheduledTask = (ScheduledTask)localIterator.next();
      if ((localScheduledTask.Active) && (localScheduledTask.Event.StartTime() != null) && (localScheduledTask.Event.StartTime().compareTo(new Date()) > 0) && (localScheduledTask.ExistsOnDevice())) {
        i += 1;
      }
    }
  }
  
  public static int RescheduleAllActiveTasks()
  {
    CoreHelper.WriteLogEntry(TAG, "Rescheduling all active scheduled tasks...");
    DeleteScheduledTasksFromDevice();
    int j;
    if (LicenseManager.IfInRestrictedMode())
    {
      CoreHelper.WriteTraceEntry(TAG, "Application is running in restricted mode! (Expired on: " + DateTime.FormatDate(LicenseManager.TrialExpirationDate()) + ") Scheduling is disabled!");
      j = 0;
      return j;
    }
    int i = 0;
    Iterator localIterator = _ScheduledTasks.values().iterator();
    for (;;)
    {
      j = i;
      if (!localIterator.hasNext()) {
        break;
      }
      ScheduledTask localScheduledTask = (ScheduledTask)localIterator.next();
      if (localScheduledTask.Active)
      {
        SetScheduledTaskToDevice(localScheduledTask);
        i += 1;
      }
    }
  }
  
  public static void RescheduleAllActiveTasksIfNeeded()
  {
    if (ActiveTaskCount() != RegisteredTaskCount()) {
      RescheduleAllActiveTasks();
    }
  }
  
  public static void SaveTasks(XmlTextWriter paramXmlTextWriter)
  {
    for (;;)
    {
      try
      {
        paramXmlTextWriter.WriteStartElement("scheduledTasks");
        Iterator localIterator = _ScheduledTasks.values().iterator();
        if (!localIterator.hasNext())
        {
          paramXmlTextWriter.WriteEndElement("scheduledTasks");
          return;
        }
        ScheduledTask localScheduledTask = (ScheduledTask)localIterator.next();
        paramXmlTextWriter.WriteStartElement("task");
        paramXmlTextWriter.WriteAttributeString("id", localScheduledTask.TaskID());
        String str;
        if (localScheduledTask.Active)
        {
          str = "1";
          paramXmlTextWriter.WriteAttributeString("active", str);
          paramXmlTextWriter.WriteAttributeString("minBattLevel", Integer.toString(localScheduledTask.MinBatteryLevelRequired));
          paramXmlTextWriter.WriteAttributeString("startTime", Long.toString(localScheduledTask.Event.UnadjustedStartTime().getTime()));
          paramXmlTextWriter.WriteAttributeString("recPeriod", Long.toString(localScheduledTask.Event.getRecurrencePeriod().getTotalMilliseconds()));
          paramXmlTextWriter.WriteAttributeString("recInterval", Integer.toString(localScheduledTask.Event.getRecurrenceInterval()));
          paramXmlTextWriter.WriteAttributeString("operationId", localScheduledTask.Operation().ID().toString());
          paramXmlTextWriter.WriteAttributeString("state", localScheduledTask.Operation().SerializedData());
          paramXmlTextWriter.WriteEndElement("task");
        }
        else
        {
          str = "0";
        }
      }
      catch (Exception paramXmlTextWriter)
      {
        CoreHelper.LogException(TAG, "Unable to save ScheduledTasks", paramXmlTextWriter);
        return;
      }
    }
  }
  
  public static void ScheduleGoogleSynUpdateIfNeeded()
  {
    if (ItemStateHistory.HasUnsynchronizedGoogleReaderItems())
    {
      CoreHelper.WriteTraceEntry(TAG, "Scheduling Google Sync Task");
      SetScheduledTaskToDevice(_GoogleReaderSyncTask);
    }
  }
  
  public static boolean ScheduleSyncTaskIfSyncIsEnabled(int paramInt, TimeSpan paramTimeSpan, boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (ChangeTracker.IsTrackingEnabled()) {
      if (!ChangeTracker.HasUploadPendingChanges())
      {
        bool1 = bool2;
        if (!paramBoolean) {}
      }
      else
      {
        if (paramInt != 0) {
          break label60;
        }
        DeleteScheduledTaskFromDevice(_SyncChangesTask);
        CoreHelper.WriteTraceEntryInDebug(TAG, "Executing Change Sync Task without a delay!");
        CommandReceiver.StartScheduledTask(BeyondPodApplication.GetInstance().getApplicationContext(), "BPT#SYNC_CHANGE_TRACKING");
      }
    }
    for (;;)
    {
      bool1 = true;
      return bool1;
      label60:
      _SyncChangesTask.Event.setRecurrenceInterval(paramInt);
      _SyncChangesTask.Event.setRecurrencePeriod(paramTimeSpan);
      long l1 = new Date().getTime();
      long l2 = _SyncChangesTask.Event.Recurrence().getTotalMilliseconds();
      CoreHelper.WriteTraceEntryInDebug(TAG, "Scheduling Change Sync Task for: " + DateTime.HOURMINSECFORMAT.format(new Date(l1 + l2)));
      ((AlarmManager)BeyondPodApplication.GetInstance().getSystemService("alarm")).set(2, SystemClock.elapsedRealtime() + _SyncChangesTask.Event.Recurrence().getTotalMilliseconds(), PendingIntent.getBroadcast(BeyondPodApplication.GetInstance(), 0, BuildIntent(_SyncChangesTask), 1073741824));
    }
  }
  
  public static void SetScheduledTaskToDevice(ScheduledTask paramScheduledTask)
  {
    AlarmManager localAlarmManager = (AlarmManager)BeyondPodApplication.GetInstance().getSystemService("alarm");
    if (paramScheduledTask.Event.StartTime() == null)
    {
      localAlarmManager.set(2, SystemClock.elapsedRealtime() + paramScheduledTask.Event.Recurrence().getTotalMilliseconds(), PendingIntent.getBroadcast(BeyondPodApplication.GetInstance(), 0, BuildIntent(paramScheduledTask), 1073741824));
      CoreHelper.WriteTraceEntry(TAG, "Scheduled ELAPSED_REALTIME_WAKEUP task: " + paramScheduledTask);
      return;
    }
    long l = paramScheduledTask.Operation().StartTimeBias();
    if (l > 0L) {}
    for (String str = " (Bias: +" + l / 1000L + "s.)";; str = "")
    {
      localAlarmManager.setRepeating(0, paramScheduledTask.Event.StartTime().getTime() + l, 900000L, BuildPendingIntentForTask(paramScheduledTask));
      CoreHelper.WriteTraceEntry(TAG, "Scheduled RTC_WAKEUP task: " + paramScheduledTask + str);
      return;
    }
  }
  
  public static Collection<ScheduledTask> Tasks()
  {
    return _ScheduledTasks.values();
  }
  
  public static void UnregisterAndClearAllTasks()
  {
    Iterator localIterator = new ArrayList(_ScheduledTasks.values()).iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      UnregisterTask((ScheduledTask)localIterator.next());
    }
  }
  
  public static void UnregisterTask(ScheduledTask paramScheduledTask)
  {
    if (_ScheduledTasks.containsKey(paramScheduledTask.TaskID())) {
      _ScheduledTasks.remove(paramScheduledTask.TaskID());
    }
    DeleteScheduledTaskFromDevice(paramScheduledTask);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/schedulercore/ScheduledTasksManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */