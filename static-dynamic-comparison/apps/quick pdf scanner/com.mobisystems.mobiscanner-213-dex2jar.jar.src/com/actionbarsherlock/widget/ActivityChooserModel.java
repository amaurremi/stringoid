package com.actionbarsherlock.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import org.xmlpull.v1.XmlSerializer;

class ActivityChooserModel
  extends DataSetObservable
{
  private static final String ATTRIBUTE_ACTIVITY = "activity";
  private static final String ATTRIBUTE_TIME = "time";
  private static final String ATTRIBUTE_WEIGHT = "weight";
  private static final boolean DEBUG = false;
  private static final int DEFAULT_ACTIVITY_INFLATION = 5;
  private static final float DEFAULT_HISTORICAL_RECORD_WEIGHT = 1.0F;
  public static final String DEFAULT_HISTORY_FILE_NAME = "activity_choser_model_history.xml";
  public static final int DEFAULT_HISTORY_MAX_LENGTH = 50;
  private static final String HISTORY_FILE_EXTENSION = ".xml";
  private static final int INVALID_INDEX = -1;
  private static final String LOG_TAG = ActivityChooserModel.class.getSimpleName();
  private static final Executor SERIAL_EXECUTOR = Executors.newSingleThreadExecutor();
  private static final String TAG_HISTORICAL_RECORD = "historical-record";
  private static final String TAG_HISTORICAL_RECORDS = "historical-records";
  private static final Map<String, ActivityChooserModel> sDataModelRegistry;
  private static final Object sRegistryLock = new Object();
  private final List<ActivityResolveInfo> mActivites = new ArrayList();
  private OnChooseActivityListener mActivityChoserModelPolicy;
  private ActivitySorter mActivitySorter = new DefaultSorter(null);
  private boolean mCanReadHistoricalData = true;
  private final Context mContext;
  private final Handler mHandler = new Handler();
  private final List<HistoricalRecord> mHistoricalRecords = new ArrayList();
  private boolean mHistoricalRecordsChanged = true;
  private final String mHistoryFileName;
  private int mHistoryMaxSize = 50;
  private final Object mInstanceLock = new Object();
  private Intent mIntent;
  private boolean mReadShareHistoryCalled = false;
  
  static
  {
    sDataModelRegistry = new HashMap();
  }
  
  private ActivityChooserModel(Context paramContext, String paramString)
  {
    this.mContext = paramContext.getApplicationContext();
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.endsWith(".xml")))
    {
      this.mHistoryFileName = (paramString + ".xml");
      return;
    }
    this.mHistoryFileName = paramString;
  }
  
  private boolean addHisoricalRecord(HistoricalRecord paramHistoricalRecord)
  {
    synchronized (this.mInstanceLock)
    {
      boolean bool = this.mHistoricalRecords.add(paramHistoricalRecord);
      if (bool)
      {
        this.mHistoricalRecordsChanged = true;
        pruneExcessiveHistoricalRecordsLocked();
        persistHistoricalData();
        sortActivities();
      }
      return bool;
    }
  }
  
  public static ActivityChooserModel get(Context paramContext, String paramString)
  {
    synchronized (sRegistryLock)
    {
      ActivityChooserModel localActivityChooserModel2 = (ActivityChooserModel)sDataModelRegistry.get(paramString);
      ActivityChooserModel localActivityChooserModel1 = localActivityChooserModel2;
      if (localActivityChooserModel2 == null)
      {
        localActivityChooserModel1 = new ActivityChooserModel(paramContext, paramString);
        sDataModelRegistry.put(paramString, localActivityChooserModel1);
      }
      localActivityChooserModel1.readHistoricalData();
      return localActivityChooserModel1;
    }
  }
  
  private void loadActivitiesLocked()
  {
    this.mActivites.clear();
    if (this.mIntent != null)
    {
      List localList = this.mContext.getPackageManager().queryIntentActivities(this.mIntent, 0);
      int j = localList.size();
      int i = 0;
      while (i < j)
      {
        ResolveInfo localResolveInfo = (ResolveInfo)localList.get(i);
        this.mActivites.add(new ActivityResolveInfo(localResolveInfo));
        i += 1;
      }
      sortActivities();
      return;
    }
    notifyChanged();
  }
  
  private void persistHistoricalData()
  {
    synchronized (this.mInstanceLock)
    {
      if (!this.mReadShareHistoryCalled) {
        throw new IllegalStateException("No preceding call to #readHistoricalData");
      }
    }
    if (!this.mHistoricalRecordsChanged) {
      return;
    }
    this.mHistoricalRecordsChanged = false;
    this.mCanReadHistoricalData = true;
    if (!TextUtils.isEmpty(this.mHistoryFileName)) {
      SERIAL_EXECUTOR.execute(new HistoryPersister(null));
    }
  }
  
  private void pruneExcessiveHistoricalRecordsLocked()
  {
    List localList = this.mHistoricalRecords;
    int j = localList.size() - this.mHistoryMaxSize;
    if (j <= 0) {}
    for (;;)
    {
      return;
      this.mHistoricalRecordsChanged = true;
      int i = 0;
      while (i < j)
      {
        HistoricalRecord localHistoricalRecord = (HistoricalRecord)localList.remove(0);
        i += 1;
      }
    }
  }
  
  private void readHistoricalData()
  {
    synchronized (this.mInstanceLock)
    {
      if ((!this.mCanReadHistoricalData) || (!this.mHistoricalRecordsChanged)) {
        return;
      }
      this.mCanReadHistoricalData = false;
      this.mReadShareHistoryCalled = true;
      if (!TextUtils.isEmpty(this.mHistoryFileName)) {
        SERIAL_EXECUTOR.execute(new HistoryLoader(null));
      }
      return;
    }
  }
  
  private void sortActivities()
  {
    synchronized (this.mInstanceLock)
    {
      if ((this.mActivitySorter != null) && (!this.mActivites.isEmpty()))
      {
        this.mActivitySorter.sort(this.mIntent, this.mActivites, Collections.unmodifiableList(this.mHistoricalRecords));
        notifyChanged();
      }
      return;
    }
  }
  
  public Intent chooseActivity(int paramInt)
  {
    Object localObject = (ActivityResolveInfo)this.mActivites.get(paramInt);
    localObject = new ComponentName(((ActivityResolveInfo)localObject).resolveInfo.activityInfo.packageName, ((ActivityResolveInfo)localObject).resolveInfo.activityInfo.name);
    Intent localIntent1 = new Intent(this.mIntent);
    localIntent1.setComponent((ComponentName)localObject);
    if (this.mActivityChoserModelPolicy != null)
    {
      Intent localIntent2 = new Intent(localIntent1);
      if (this.mActivityChoserModelPolicy.onChooseActivity(this, localIntent2)) {
        return null;
      }
    }
    addHisoricalRecord(new HistoricalRecord((ComponentName)localObject, System.currentTimeMillis(), 1.0F));
    return localIntent1;
  }
  
  public ResolveInfo getActivity(int paramInt)
  {
    synchronized (this.mInstanceLock)
    {
      ResolveInfo localResolveInfo = ((ActivityResolveInfo)this.mActivites.get(paramInt)).resolveInfo;
      return localResolveInfo;
    }
  }
  
  public int getActivityCount()
  {
    synchronized (this.mInstanceLock)
    {
      int i = this.mActivites.size();
      return i;
    }
  }
  
  public int getActivityIndex(ResolveInfo paramResolveInfo)
  {
    List localList = this.mActivites;
    int j = localList.size();
    int i = 0;
    while (i < j)
    {
      if (((ActivityResolveInfo)localList.get(i)).resolveInfo == paramResolveInfo) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public ResolveInfo getDefaultActivity()
  {
    synchronized (this.mInstanceLock)
    {
      if (!this.mActivites.isEmpty())
      {
        ResolveInfo localResolveInfo = ((ActivityResolveInfo)this.mActivites.get(0)).resolveInfo;
        return localResolveInfo;
      }
      return null;
    }
  }
  
  public int getHistoryMaxSize()
  {
    synchronized (this.mInstanceLock)
    {
      int i = this.mHistoryMaxSize;
      return i;
    }
  }
  
  public int getHistorySize()
  {
    synchronized (this.mInstanceLock)
    {
      int i = this.mHistoricalRecords.size();
      return i;
    }
  }
  
  public Intent getIntent()
  {
    synchronized (this.mInstanceLock)
    {
      Intent localIntent = this.mIntent;
      return localIntent;
    }
  }
  
  public void setActivitySorter(ActivitySorter paramActivitySorter)
  {
    synchronized (this.mInstanceLock)
    {
      if (this.mActivitySorter == paramActivitySorter) {
        return;
      }
      this.mActivitySorter = paramActivitySorter;
      sortActivities();
      return;
    }
  }
  
  public void setDefaultActivity(int paramInt)
  {
    ActivityResolveInfo localActivityResolveInfo1 = (ActivityResolveInfo)this.mActivites.get(paramInt);
    ActivityResolveInfo localActivityResolveInfo2 = (ActivityResolveInfo)this.mActivites.get(0);
    if (localActivityResolveInfo2 != null) {}
    for (float f = localActivityResolveInfo2.weight - localActivityResolveInfo1.weight + 5.0F;; f = 1.0F)
    {
      addHisoricalRecord(new HistoricalRecord(new ComponentName(localActivityResolveInfo1.resolveInfo.activityInfo.packageName, localActivityResolveInfo1.resolveInfo.activityInfo.name), System.currentTimeMillis(), f));
      return;
    }
  }
  
  public void setHistoryMaxSize(int paramInt)
  {
    synchronized (this.mInstanceLock)
    {
      if (this.mHistoryMaxSize == paramInt) {
        return;
      }
      this.mHistoryMaxSize = paramInt;
      pruneExcessiveHistoricalRecordsLocked();
      sortActivities();
      return;
    }
  }
  
  public void setIntent(Intent paramIntent)
  {
    synchronized (this.mInstanceLock)
    {
      if (this.mIntent == paramIntent) {
        return;
      }
      this.mIntent = paramIntent;
      loadActivitiesLocked();
      return;
    }
  }
  
  public void setOnChooseActivityListener(OnChooseActivityListener paramOnChooseActivityListener)
  {
    this.mActivityChoserModelPolicy = paramOnChooseActivityListener;
  }
  
  public static abstract interface ActivityChooserModelClient
  {
    public abstract void setActivityChooserModel(ActivityChooserModel paramActivityChooserModel);
  }
  
  public final class ActivityResolveInfo
    implements Comparable<ActivityResolveInfo>
  {
    public final ResolveInfo resolveInfo;
    public float weight;
    
    public ActivityResolveInfo(ResolveInfo paramResolveInfo)
    {
      this.resolveInfo = paramResolveInfo;
    }
    
    public int compareTo(ActivityResolveInfo paramActivityResolveInfo)
    {
      return Float.floatToIntBits(paramActivityResolveInfo.weight) - Float.floatToIntBits(this.weight);
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        paramObject = (ActivityResolveInfo)paramObject;
      } while (Float.floatToIntBits(this.weight) == Float.floatToIntBits(((ActivityResolveInfo)paramObject).weight));
      return false;
    }
    
    public int hashCode()
    {
      return Float.floatToIntBits(this.weight) + 31;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append("resolveInfo:").append(this.resolveInfo.toString());
      localStringBuilder.append("; weight:").append(new BigDecimal(this.weight));
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
  }
  
  public static abstract interface ActivitySorter
  {
    public abstract void sort(Intent paramIntent, List<ActivityChooserModel.ActivityResolveInfo> paramList, List<ActivityChooserModel.HistoricalRecord> paramList1);
  }
  
  private final class DefaultSorter
    implements ActivityChooserModel.ActivitySorter
  {
    private static final float WEIGHT_DECAY_COEFFICIENT = 0.95F;
    private final Map<String, ActivityChooserModel.ActivityResolveInfo> mPackageNameToActivityMap = new HashMap();
    
    private DefaultSorter() {}
    
    public void sort(Intent paramIntent, List<ActivityChooserModel.ActivityResolveInfo> paramList, List<ActivityChooserModel.HistoricalRecord> paramList1)
    {
      paramIntent = this.mPackageNameToActivityMap;
      paramIntent.clear();
      int j = paramList.size();
      int i = 0;
      Object localObject;
      while (i < j)
      {
        localObject = (ActivityChooserModel.ActivityResolveInfo)paramList.get(i);
        ((ActivityChooserModel.ActivityResolveInfo)localObject).weight = 0.0F;
        paramIntent.put(((ActivityChooserModel.ActivityResolveInfo)localObject).resolveInfo.activityInfo.packageName, localObject);
        i += 1;
      }
      i = paramList1.size();
      float f1 = 1.0F;
      i -= 1;
      if (i >= 0)
      {
        localObject = (ActivityChooserModel.HistoricalRecord)paramList1.get(i);
        ActivityChooserModel.ActivityResolveInfo localActivityResolveInfo = (ActivityChooserModel.ActivityResolveInfo)paramIntent.get(((ActivityChooserModel.HistoricalRecord)localObject).activity.getPackageName());
        if (localActivityResolveInfo == null) {
          break label180;
        }
        float f2 = localActivityResolveInfo.weight;
        localActivityResolveInfo.weight = (((ActivityChooserModel.HistoricalRecord)localObject).weight * f1 + f2);
        f1 = 0.95F * f1;
      }
      label180:
      for (;;)
      {
        i -= 1;
        break;
        Collections.sort(paramList);
        return;
      }
    }
  }
  
  public static final class HistoricalRecord
  {
    public final ComponentName activity;
    public final long time;
    public final float weight;
    
    public HistoricalRecord(ComponentName paramComponentName, long paramLong, float paramFloat)
    {
      this.activity = paramComponentName;
      this.time = paramLong;
      this.weight = paramFloat;
    }
    
    public HistoricalRecord(String paramString, long paramLong, float paramFloat)
    {
      this(ComponentName.unflattenFromString(paramString), paramLong, paramFloat);
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        paramObject = (HistoricalRecord)paramObject;
        if (this.activity == null)
        {
          if (((HistoricalRecord)paramObject).activity != null) {
            return false;
          }
        }
        else if (!this.activity.equals(((HistoricalRecord)paramObject).activity)) {
          return false;
        }
        if (this.time != ((HistoricalRecord)paramObject).time) {
          return false;
        }
      } while (Float.floatToIntBits(this.weight) == Float.floatToIntBits(((HistoricalRecord)paramObject).weight));
      return false;
    }
    
    public int hashCode()
    {
      if (this.activity == null) {}
      for (int i = 0;; i = this.activity.hashCode()) {
        return ((i + 31) * 31 + (int)(this.time ^ this.time >>> 32)) * 31 + Float.floatToIntBits(this.weight);
      }
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append("; activity:").append(this.activity);
      localStringBuilder.append("; time:").append(this.time);
      localStringBuilder.append("; weight:").append(new BigDecimal(this.weight));
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
  }
  
  private final class HistoryLoader
    implements Runnable
  {
    private HistoryLoader() {}
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 17	com/actionbarsherlock/widget/ActivityChooserModel$HistoryLoader:this$0	Lcom/actionbarsherlock/widget/ActivityChooserModel;
      //   4: invokestatic 35	com/actionbarsherlock/widget/ActivityChooserModel:access$400	(Lcom/actionbarsherlock/widget/ActivityChooserModel;)Landroid/content/Context;
      //   7: aload_0
      //   8: getfield 17	com/actionbarsherlock/widget/ActivityChooserModel$HistoryLoader:this$0	Lcom/actionbarsherlock/widget/ActivityChooserModel;
      //   11: invokestatic 39	com/actionbarsherlock/widget/ActivityChooserModel:access$300	(Lcom/actionbarsherlock/widget/ActivityChooserModel;)Ljava/lang/String;
      //   14: invokevirtual 45	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
      //   17: astore_2
      //   18: invokestatic 51	android/util/Xml:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
      //   21: astore_3
      //   22: aload_3
      //   23: aload_2
      //   24: aconst_null
      //   25: invokeinterface 57 3 0
      //   30: iconst_0
      //   31: istore_1
      //   32: iload_1
      //   33: iconst_1
      //   34: if_icmpeq +18 -> 52
      //   37: iload_1
      //   38: iconst_2
      //   39: if_icmpeq +13 -> 52
      //   42: aload_3
      //   43: invokeinterface 61 1 0
      //   48: istore_1
      //   49: goto -17 -> 32
      //   52: ldc 63
      //   54: aload_3
      //   55: invokeinterface 67 1 0
      //   60: invokevirtual 73	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   63: ifne +56 -> 119
      //   66: new 29	org/xmlpull/v1/XmlPullParserException
      //   69: dup
      //   70: ldc 75
      //   72: invokespecial 78	org/xmlpull/v1/XmlPullParserException:<init>	(Ljava/lang/String;)V
      //   75: athrow
      //   76: astore_3
      //   77: invokestatic 81	com/actionbarsherlock/widget/ActivityChooserModel:access$1100	()Ljava/lang/String;
      //   80: new 83	java/lang/StringBuilder
      //   83: dup
      //   84: invokespecial 84	java/lang/StringBuilder:<init>	()V
      //   87: ldc 86
      //   89: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   92: aload_0
      //   93: getfield 17	com/actionbarsherlock/widget/ActivityChooserModel$HistoryLoader:this$0	Lcom/actionbarsherlock/widget/ActivityChooserModel;
      //   96: invokestatic 39	com/actionbarsherlock/widget/ActivityChooserModel:access$300	(Lcom/actionbarsherlock/widget/ActivityChooserModel;)Ljava/lang/String;
      //   99: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   102: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   105: aload_3
      //   106: invokestatic 99	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   109: pop
      //   110: aload_2
      //   111: ifnull +7 -> 118
      //   114: aload_2
      //   115: invokevirtual 104	java/io/FileInputStream:close	()V
      //   118: return
      //   119: new 106	java/util/ArrayList
      //   122: dup
      //   123: invokespecial 107	java/util/ArrayList:<init>	()V
      //   126: astore 4
      //   128: aload_3
      //   129: invokeinterface 61 1 0
      //   134: istore_1
      //   135: iload_1
      //   136: iconst_1
      //   137: if_icmpne +73 -> 210
      //   140: aload_0
      //   141: getfield 17	com/actionbarsherlock/widget/ActivityChooserModel$HistoryLoader:this$0	Lcom/actionbarsherlock/widget/ActivityChooserModel;
      //   144: invokestatic 111	com/actionbarsherlock/widget/ActivityChooserModel:access$500	(Lcom/actionbarsherlock/widget/ActivityChooserModel;)Ljava/lang/Object;
      //   147: astore_3
      //   148: aload_3
      //   149: monitorenter
      //   150: new 113	java/util/LinkedHashSet
      //   153: dup
      //   154: aload 4
      //   156: invokespecial 116	java/util/LinkedHashSet:<init>	(Ljava/util/Collection;)V
      //   159: astore 4
      //   161: aload_0
      //   162: getfield 17	com/actionbarsherlock/widget/ActivityChooserModel$HistoryLoader:this$0	Lcom/actionbarsherlock/widget/ActivityChooserModel;
      //   165: invokestatic 120	com/actionbarsherlock/widget/ActivityChooserModel:access$600	(Lcom/actionbarsherlock/widget/ActivityChooserModel;)Ljava/util/List;
      //   168: astore 5
      //   170: aload 5
      //   172: invokeinterface 125 1 0
      //   177: iconst_1
      //   178: isub
      //   179: istore_1
      //   180: iload_1
      //   181: iflt +170 -> 351
      //   184: aload 4
      //   186: aload 5
      //   188: iload_1
      //   189: invokeinterface 129 2 0
      //   194: checkcast 131	com/actionbarsherlock/widget/ActivityChooserModel$HistoricalRecord
      //   197: invokeinterface 136 2 0
      //   202: pop
      //   203: iload_1
      //   204: iconst_1
      //   205: isub
      //   206: istore_1
      //   207: goto -27 -> 180
      //   210: iload_1
      //   211: iconst_3
      //   212: if_icmpeq -84 -> 128
      //   215: iload_1
      //   216: iconst_4
      //   217: if_icmpeq -89 -> 128
      //   220: ldc -118
      //   222: aload_3
      //   223: invokeinterface 67 1 0
      //   228: invokevirtual 73	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   231: ifne +58 -> 289
      //   234: new 29	org/xmlpull/v1/XmlPullParserException
      //   237: dup
      //   238: ldc -116
      //   240: invokespecial 78	org/xmlpull/v1/XmlPullParserException:<init>	(Ljava/lang/String;)V
      //   243: athrow
      //   244: astore_3
      //   245: invokestatic 81	com/actionbarsherlock/widget/ActivityChooserModel:access$1100	()Ljava/lang/String;
      //   248: new 83	java/lang/StringBuilder
      //   251: dup
      //   252: invokespecial 84	java/lang/StringBuilder:<init>	()V
      //   255: ldc 86
      //   257: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   260: aload_0
      //   261: getfield 17	com/actionbarsherlock/widget/ActivityChooserModel$HistoryLoader:this$0	Lcom/actionbarsherlock/widget/ActivityChooserModel;
      //   264: invokestatic 39	com/actionbarsherlock/widget/ActivityChooserModel:access$300	(Lcom/actionbarsherlock/widget/ActivityChooserModel;)Ljava/lang/String;
      //   267: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   270: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   273: aload_3
      //   274: invokestatic 99	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   277: pop
      //   278: aload_2
      //   279: ifnull -161 -> 118
      //   282: aload_2
      //   283: invokevirtual 104	java/io/FileInputStream:close	()V
      //   286: return
      //   287: astore_2
      //   288: return
      //   289: aload 4
      //   291: new 131	com/actionbarsherlock/widget/ActivityChooserModel$HistoricalRecord
      //   294: dup
      //   295: aload_3
      //   296: aconst_null
      //   297: ldc -114
      //   299: invokeinterface 146 3 0
      //   304: aload_3
      //   305: aconst_null
      //   306: ldc -108
      //   308: invokeinterface 146 3 0
      //   313: invokestatic 154	java/lang/Long:parseLong	(Ljava/lang/String;)J
      //   316: aload_3
      //   317: aconst_null
      //   318: ldc -100
      //   320: invokeinterface 146 3 0
      //   325: invokestatic 162	java/lang/Float:parseFloat	(Ljava/lang/String;)F
      //   328: invokespecial 165	com/actionbarsherlock/widget/ActivityChooserModel$HistoricalRecord:<init>	(Ljava/lang/String;JF)V
      //   331: invokeinterface 166 2 0
      //   336: pop
      //   337: goto -209 -> 128
      //   340: astore_3
      //   341: aload_2
      //   342: ifnull +7 -> 349
      //   345: aload_2
      //   346: invokevirtual 104	java/io/FileInputStream:close	()V
      //   349: aload_3
      //   350: athrow
      //   351: aload 5
      //   353: invokeinterface 125 1 0
      //   358: aload 4
      //   360: invokeinterface 167 1 0
      //   365: if_icmpne +16 -> 381
      //   368: aload_3
      //   369: monitorexit
      //   370: aload_2
      //   371: ifnull -253 -> 118
      //   374: aload_2
      //   375: invokevirtual 104	java/io/FileInputStream:close	()V
      //   378: return
      //   379: astore_2
      //   380: return
      //   381: aload 5
      //   383: invokeinterface 170 1 0
      //   388: aload 5
      //   390: aload 4
      //   392: invokeinterface 174 2 0
      //   397: pop
      //   398: aload_0
      //   399: getfield 17	com/actionbarsherlock/widget/ActivityChooserModel$HistoryLoader:this$0	Lcom/actionbarsherlock/widget/ActivityChooserModel;
      //   402: iconst_1
      //   403: invokestatic 178	com/actionbarsherlock/widget/ActivityChooserModel:access$702	(Lcom/actionbarsherlock/widget/ActivityChooserModel;Z)Z
      //   406: pop
      //   407: aload_0
      //   408: getfield 17	com/actionbarsherlock/widget/ActivityChooserModel$HistoryLoader:this$0	Lcom/actionbarsherlock/widget/ActivityChooserModel;
      //   411: invokestatic 182	com/actionbarsherlock/widget/ActivityChooserModel:access$1000	(Lcom/actionbarsherlock/widget/ActivityChooserModel;)Landroid/os/Handler;
      //   414: new 11	com/actionbarsherlock/widget/ActivityChooserModel$HistoryLoader$1
      //   417: dup
      //   418: aload_0
      //   419: invokespecial 185	com/actionbarsherlock/widget/ActivityChooserModel$HistoryLoader$1:<init>	(Lcom/actionbarsherlock/widget/ActivityChooserModel$HistoryLoader;)V
      //   422: invokevirtual 191	android/os/Handler:post	(Ljava/lang/Runnable;)Z
      //   425: pop
      //   426: aload_3
      //   427: monitorexit
      //   428: aload_2
      //   429: ifnull -311 -> 118
      //   432: aload_2
      //   433: invokevirtual 104	java/io/FileInputStream:close	()V
      //   436: return
      //   437: astore_2
      //   438: return
      //   439: astore 4
      //   441: aload_3
      //   442: monitorexit
      //   443: aload 4
      //   445: athrow
      //   446: astore_2
      //   447: return
      //   448: astore_2
      //   449: goto -100 -> 349
      //   452: astore_2
      //   453: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	454	0	this	HistoryLoader
      //   31	187	1	i	int
      //   17	266	2	localFileInputStream	java.io.FileInputStream
      //   287	88	2	localIOException1	IOException
      //   379	54	2	localIOException2	IOException
      //   437	1	2	localIOException3	IOException
      //   446	1	2	localIOException4	IOException
      //   448	1	2	localIOException5	IOException
      //   452	1	2	localFileNotFoundException	FileNotFoundException
      //   21	34	3	localXmlPullParser	org.xmlpull.v1.XmlPullParser
      //   76	53	3	localXmlPullParserException	org.xmlpull.v1.XmlPullParserException
      //   244	73	3	localIOException6	IOException
      //   340	102	3	localObject2	Object
      //   126	265	4	localObject3	Object
      //   439	5	4	localObject4	Object
      //   168	221	5	localList	List
      // Exception table:
      //   from	to	target	type
      //   18	30	76	org/xmlpull/v1/XmlPullParserException
      //   42	49	76	org/xmlpull/v1/XmlPullParserException
      //   52	76	76	org/xmlpull/v1/XmlPullParserException
      //   119	128	76	org/xmlpull/v1/XmlPullParserException
      //   128	135	76	org/xmlpull/v1/XmlPullParserException
      //   140	150	76	org/xmlpull/v1/XmlPullParserException
      //   220	244	76	org/xmlpull/v1/XmlPullParserException
      //   289	337	76	org/xmlpull/v1/XmlPullParserException
      //   443	446	76	org/xmlpull/v1/XmlPullParserException
      //   18	30	244	java/io/IOException
      //   42	49	244	java/io/IOException
      //   52	76	244	java/io/IOException
      //   119	128	244	java/io/IOException
      //   128	135	244	java/io/IOException
      //   140	150	244	java/io/IOException
      //   220	244	244	java/io/IOException
      //   289	337	244	java/io/IOException
      //   443	446	244	java/io/IOException
      //   282	286	287	java/io/IOException
      //   18	30	340	finally
      //   42	49	340	finally
      //   52	76	340	finally
      //   77	110	340	finally
      //   119	128	340	finally
      //   128	135	340	finally
      //   140	150	340	finally
      //   220	244	340	finally
      //   245	278	340	finally
      //   289	337	340	finally
      //   443	446	340	finally
      //   374	378	379	java/io/IOException
      //   432	436	437	java/io/IOException
      //   150	180	439	finally
      //   184	203	439	finally
      //   351	370	439	finally
      //   381	428	439	finally
      //   441	443	439	finally
      //   114	118	446	java/io/IOException
      //   345	349	448	java/io/IOException
      //   0	18	452	java/io/FileNotFoundException
    }
  }
  
  private final class HistoryPersister
    implements Runnable
  {
    private HistoryPersister() {}
    
    public void run()
    {
      ArrayList localArrayList;
      synchronized (ActivityChooserModel.this.mInstanceLock)
      {
        localArrayList = new ArrayList(ActivityChooserModel.this.mHistoricalRecords);
      }
      for (;;)
      {
        try
        {
          ??? = ActivityChooserModel.this.mContext.openFileOutput(ActivityChooserModel.this.mHistoryFileName, 0);
          localXmlSerializer = Xml.newSerializer();
          int j;
          int i;
          ActivityChooserModel.HistoricalRecord localHistoricalRecord;
          localXmlSerializer.endTag(null, "historical-records");
        }
        catch (FileNotFoundException localObject2)
        {
          try
          {
            localXmlSerializer.setOutput((OutputStream)???, null);
            localXmlSerializer.startDocument("UTF-8", Boolean.valueOf(true));
            localXmlSerializer.startTag(null, "historical-records");
            j = localArrayList.size();
            i = 0;
            if (i >= j) {
              break label241;
            }
            localHistoricalRecord = (ActivityChooserModel.HistoricalRecord)localArrayList.remove(0);
            localXmlSerializer.startTag(null, "historical-record");
            localXmlSerializer.attribute(null, "activity", localHistoricalRecord.activity.flattenToString());
            localXmlSerializer.attribute(null, "time", String.valueOf(localHistoricalRecord.time));
            localXmlSerializer.attribute(null, "weight", String.valueOf(localHistoricalRecord.weight));
            localXmlSerializer.endTag(null, "historical-record");
            i += 1;
            continue;
            localObject2 = finally;
            throw ((Throwable)localObject2);
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            XmlSerializer localXmlSerializer;
            Log.e(ActivityChooserModel.LOG_TAG, "Error writing historical recrod file: " + ActivityChooserModel.this.mHistoryFileName, localIllegalArgumentException);
            if (localIOException1 == null) {
              continue;
            }
            try
            {
              localIOException1.close();
              return;
            }
            catch (IOException localIOException2)
            {
              return;
            }
          }
          catch (IllegalStateException localIllegalStateException)
          {
            Log.e(ActivityChooserModel.LOG_TAG, "Error writing historical recrod file: " + ActivityChooserModel.this.mHistoryFileName, localIllegalStateException);
            if (localIOException2 == null) {
              continue;
            }
            try
            {
              localIOException2.close();
              return;
            }
            catch (IOException localIOException3)
            {
              return;
            }
          }
          catch (IOException localIOException6)
          {
            Log.e(ActivityChooserModel.LOG_TAG, "Error writing historical recrod file: " + ActivityChooserModel.this.mHistoryFileName, localIOException6);
            if (localIOException3 == null) {
              continue;
            }
            try
            {
              localIOException3.close();
              return;
            }
            catch (IOException localIOException4)
            {
              return;
            }
          }
          finally
          {
            if (localIOException4 == null) {
              break label421;
            }
          }
          localFileNotFoundException = localFileNotFoundException;
          Log.e(ActivityChooserModel.LOG_TAG, "Error writing historical recrod file: " + ActivityChooserModel.this.mHistoryFileName, localFileNotFoundException);
          return;
        }
        label241:
        localXmlSerializer.endDocument();
        if (localFileNotFoundException != null) {
          try
          {
            localFileNotFoundException.close();
            return;
          }
          catch (IOException localIOException1)
          {
            return;
          }
        }
      }
      try
      {
        localIOException4.close();
        label421:
        throw ((Throwable)localObject3);
      }
      catch (IOException localIOException5)
      {
        for (;;) {}
      }
    }
  }
  
  public static abstract interface OnChooseActivityListener
  {
    public abstract boolean onChooseActivity(ActivityChooserModel paramActivityChooserModel, Intent paramIntent);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/actionbarsherlock/widget/ActivityChooserModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */