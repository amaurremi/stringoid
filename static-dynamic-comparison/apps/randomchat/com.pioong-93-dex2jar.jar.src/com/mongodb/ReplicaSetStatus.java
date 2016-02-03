package com.mongodb;

import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.util.annotations.Immutable;
import org.bson.util.annotations.ThreadSafe;

@ThreadSafe
public class ReplicaSetStatus
  extends ConnectionStatus
{
  static final Logger _rootLogger = Logger.getLogger("com.mongodb.ReplicaSetStatus");
  static final int inetAddrCacheMS = Integer.parseInt(System.getProperty("com.mongodb.inetAddrCacheMS", "300000"));
  static final int slaveAcceptableLatencyMS = Integer.parseInt(System.getProperty("com.mongodb.slaveAcceptableLatencyMS", "15"));
  private final AtomicReference<String> _lastPrimarySignal = new AtomicReference();
  private final AtomicReference<Logger> _logger = new AtomicReference(_rootLogger);
  final ReplicaSetHolder _replicaSetHolder = new ReplicaSetHolder();
  
  ReplicaSetStatus(Mongo paramMongo, List<ServerAddress> paramList)
  {
    super(paramList, paramMongo);
    this._updater = new Updater(paramList);
  }
  
  ConnectionStatus.Node ensureMaster()
  {
    ReplicaSetNode localReplicaSetNode = getMasterNode();
    if (localReplicaSetNode != null) {
      return localReplicaSetNode;
    }
    this._replicaSetHolder.waitForNextUpdate();
    localReplicaSetNode = getMasterNode();
    if (localReplicaSetNode != null) {
      return localReplicaSetNode;
    }
    return null;
  }
  
  ServerAddress getASecondary()
  {
    ReplicaSetNode localReplicaSetNode = this._replicaSetHolder.get().getASecondary();
    if (localReplicaSetNode == null) {
      return null;
    }
    return localReplicaSetNode._addr;
  }
  
  public ServerAddress getMaster()
  {
    ReplicaSetNode localReplicaSetNode = getMasterNode();
    if (localReplicaSetNode == null) {
      return null;
    }
    return localReplicaSetNode.getServerAddress();
  }
  
  ReplicaSetNode getMasterNode()
  {
    checkClosed();
    return this._replicaSetHolder.get().getMaster();
  }
  
  public int getMaxBsonObjectSize()
  {
    return this._replicaSetHolder.get().getMaxBsonObjectSize();
  }
  
  public String getName()
  {
    return this._replicaSetHolder.get().getSetName();
  }
  
  List<ServerAddress> getServerAddressList()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this._replicaSetHolder.get().getAll().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((ReplicaSetNode)localIterator.next()).getServerAddress());
    }
    return localArrayList;
  }
  
  boolean hasServerUp()
  {
    Iterator localIterator = this._replicaSetHolder.get().getAll().iterator();
    while (localIterator.hasNext()) {
      if (((ReplicaSetNode)localIterator.next()).isOk()) {
        return true;
      }
    }
    return false;
  }
  
  public boolean isMaster(ServerAddress paramServerAddress)
  {
    if (paramServerAddress == null) {
      return false;
    }
    return paramServerAddress.equals(getMaster());
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{replSetName: ").append(this._replicaSetHolder.get().getSetName());
    localStringBuilder.append(", members: ").append(this._replicaSetHolder);
    localStringBuilder.append(", updaterIntervalMS: ").append(updaterIntervalMS);
    localStringBuilder.append(", updaterIntervalNoMasterMS: ").append(updaterIntervalNoMasterMS);
    localStringBuilder.append(", slaveAcceptableLatencyMS: ").append(slaveAcceptableLatencyMS);
    localStringBuilder.append(", inetAddrCacheMS: ").append(inetAddrCacheMS);
    localStringBuilder.append(", latencySmoothFactor: ").append(latencySmoothFactor);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  @Immutable
  static class ReplicaSet
  {
    private int acceptableLatencyMS;
    final List<ReplicaSetStatus.ReplicaSetNode> acceptableMembers;
    final List<ReplicaSetStatus.ReplicaSetNode> acceptableSecondaries;
    final List<ReplicaSetStatus.ReplicaSetNode> all;
    final ReplicaSetStatus.ReplicaSetErrorStatus errorStatus;
    final ReplicaSetStatus.ReplicaSetNode master;
    final Random random;
    final String setName;
    
    public ReplicaSet(List<ReplicaSetStatus.ReplicaSetNode> paramList, Random paramRandom, int paramInt)
    {
      this.random = paramRandom;
      this.all = Collections.unmodifiableList(new ArrayList(paramList));
      this.acceptableLatencyMS = paramInt;
      this.errorStatus = validate();
      this.setName = determineSetName();
      this.acceptableSecondaries = Collections.unmodifiableList(calculateGoodMembers(this.all, calculateBestPingTime(this.all, false), paramInt, false));
      this.acceptableMembers = Collections.unmodifiableList(calculateGoodMembers(this.all, calculateBestPingTime(this.all, true), paramInt, true));
      this.master = findMaster();
    }
    
    static float calculateBestPingTime(List<ReplicaSetStatus.ReplicaSetNode> paramList, boolean paramBoolean)
    {
      float f = Float.MAX_VALUE;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ReplicaSetStatus.ReplicaSetNode localReplicaSetNode = (ReplicaSetStatus.ReplicaSetNode)paramList.next();
        if (((localReplicaSetNode.secondary()) || ((paramBoolean) && (localReplicaSetNode.master()))) && (localReplicaSetNode._pingTime < f)) {
          f = localReplicaSetNode._pingTime;
        }
      }
      return f;
    }
    
    static List<ReplicaSetStatus.ReplicaSetNode> calculateGoodMembers(List<ReplicaSetStatus.ReplicaSetNode> paramList, float paramFloat, int paramInt, boolean paramBoolean)
    {
      ArrayList localArrayList = new ArrayList(paramList.size());
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ReplicaSetStatus.ReplicaSetNode localReplicaSetNode = (ReplicaSetStatus.ReplicaSetNode)paramList.next();
        if (((localReplicaSetNode.secondary()) || ((paramBoolean) && (localReplicaSetNode.master()))) && (localReplicaSetNode._pingTime - paramInt <= paramFloat)) {
          localArrayList.add(localReplicaSetNode);
        }
      }
      return localArrayList;
    }
    
    private void checkStatus()
    {
      if (!this.errorStatus.isOk()) {
        throw new MongoException(this.errorStatus.getError());
      }
    }
    
    private String determineSetName()
    {
      Iterator localIterator = this.all.iterator();
      while (localIterator.hasNext())
      {
        String str = ((ReplicaSetStatus.ReplicaSetNode)localIterator.next()).getSetName();
        if ((str != null) && (!str.equals(""))) {
          return str;
        }
      }
      return null;
    }
    
    private ReplicaSetStatus.ReplicaSetNode findMaster()
    {
      Iterator localIterator = this.all.iterator();
      while (localIterator.hasNext())
      {
        ReplicaSetStatus.ReplicaSetNode localReplicaSetNode = (ReplicaSetStatus.ReplicaSetNode)localIterator.next();
        if (localReplicaSetNode.master()) {
          return localReplicaSetNode;
        }
      }
      return null;
    }
    
    static List<ReplicaSetStatus.ReplicaSetNode> getMembersByTags(List<ReplicaSetStatus.ReplicaSetNode> paramList, List<ReplicaSetStatus.Tag> paramList1)
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ReplicaSetStatus.ReplicaSetNode localReplicaSetNode = (ReplicaSetStatus.ReplicaSetNode)paramList.next();
        if ((paramList1 != null) && (localReplicaSetNode.getTags() != null) && (localReplicaSetNode.getTags().containsAll(paramList1))) {
          localArrayList.add(localReplicaSetNode);
        }
      }
      return localArrayList;
    }
    
    private ReplicaSetStatus.ReplicaSetErrorStatus validate()
    {
      HashSet localHashSet = new HashSet();
      Iterator localIterator = this.all.iterator();
      while (localIterator.hasNext())
      {
        String str = ((ReplicaSetStatus.ReplicaSetNode)localIterator.next()).getSetName();
        if ((str != null) && (!str.equals(""))) {
          localHashSet.add(str);
        }
      }
      if (localHashSet.size() <= 1) {
        return new ReplicaSetStatus.ReplicaSetErrorStatus(true, null);
      }
      return new ReplicaSetStatus.ReplicaSetErrorStatus(false, "nodes with different set names detected: " + localHashSet.toString());
    }
    
    public ReplicaSetStatus.ReplicaSetNode getAMember()
    {
      checkStatus();
      if (this.acceptableMembers.isEmpty()) {
        return null;
      }
      return (ReplicaSetStatus.ReplicaSetNode)this.acceptableMembers.get(this.random.nextInt(this.acceptableMembers.size()));
    }
    
    public ReplicaSetStatus.ReplicaSetNode getAMember(List<ReplicaSetStatus.Tag> paramList)
    {
      checkStatus();
      if (paramList.isEmpty()) {
        return getAMember();
      }
      paramList = getGoodMembersByTags(paramList);
      if (paramList.isEmpty()) {
        return null;
      }
      return (ReplicaSetStatus.ReplicaSetNode)paramList.get(this.random.nextInt(paramList.size()));
    }
    
    public ReplicaSetStatus.ReplicaSetNode getASecondary()
    {
      checkStatus();
      if (this.acceptableSecondaries.isEmpty()) {
        return null;
      }
      return (ReplicaSetStatus.ReplicaSetNode)this.acceptableSecondaries.get(this.random.nextInt(this.acceptableSecondaries.size()));
    }
    
    public ReplicaSetStatus.ReplicaSetNode getASecondary(List<ReplicaSetStatus.Tag> paramList)
    {
      checkStatus();
      if (paramList.isEmpty()) {
        return getASecondary();
      }
      paramList = getGoodSecondariesByTags(paramList);
      if (paramList.isEmpty()) {
        return null;
      }
      return (ReplicaSetStatus.ReplicaSetNode)paramList.get(this.random.nextInt(paramList.size()));
    }
    
    public List<ReplicaSetStatus.ReplicaSetNode> getAll()
    {
      checkStatus();
      return this.all;
    }
    
    public ReplicaSetStatus.ReplicaSetErrorStatus getErrorStatus()
    {
      return this.errorStatus;
    }
    
    public List<ReplicaSetStatus.ReplicaSetNode> getGoodMembersByTags(List<ReplicaSetStatus.Tag> paramList)
    {
      checkStatus();
      paramList = getMembersByTags(this.all, paramList);
      return calculateGoodMembers(paramList, calculateBestPingTime(paramList, true), this.acceptableLatencyMS, true);
    }
    
    List<ReplicaSetStatus.ReplicaSetNode> getGoodSecondaries(List<ReplicaSetStatus.ReplicaSetNode> paramList)
    {
      ArrayList localArrayList = new ArrayList(paramList.size());
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ReplicaSetStatus.ReplicaSetNode localReplicaSetNode = (ReplicaSetStatus.ReplicaSetNode)paramList.next();
        if (localReplicaSetNode.isOk()) {
          localArrayList.add(localReplicaSetNode);
        }
      }
      return localArrayList;
    }
    
    public List<ReplicaSetStatus.ReplicaSetNode> getGoodSecondariesByTags(List<ReplicaSetStatus.Tag> paramList)
    {
      checkStatus();
      paramList = getMembersByTags(this.all, paramList);
      return calculateGoodMembers(paramList, calculateBestPingTime(paramList, false), this.acceptableLatencyMS, false);
    }
    
    public ReplicaSetStatus.ReplicaSetNode getMaster()
    {
      checkStatus();
      return this.master;
    }
    
    public int getMaxBsonObjectSize()
    {
      if (hasMaster()) {
        return getMaster().getMaxBsonObjectSize();
      }
      return 4194304;
    }
    
    public String getSetName()
    {
      checkStatus();
      return this.setName;
    }
    
    public boolean hasMaster()
    {
      return getMaster() != null;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[ ");
      Iterator localIterator = getAll().iterator();
      while (localIterator.hasNext()) {
        localStringBuilder.append(((ReplicaSetStatus.ReplicaSetNode)localIterator.next()).toJSON()).append(",");
      }
      localStringBuilder.setLength(localStringBuilder.length() - 1);
      localStringBuilder.append(" ]");
      return localStringBuilder.toString();
    }
  }
  
  @Immutable
  static final class ReplicaSetErrorStatus
  {
    final String error;
    final boolean ok;
    
    ReplicaSetErrorStatus(boolean paramBoolean, String paramString)
    {
      this.ok = paramBoolean;
      this.error = paramString;
    }
    
    public String getError()
    {
      return this.error;
    }
    
    public boolean isOk()
    {
      return this.ok;
    }
  }
  
  @ThreadSafe
  class ReplicaSetHolder
  {
    private volatile ReplicaSetStatus.ReplicaSet members;
    
    ReplicaSetHolder() {}
    
    public void close()
    {
      try
      {
        this.members = null;
        notifyAll();
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    ReplicaSetStatus.ReplicaSet get()
    {
      try
      {
        for (;;)
        {
          ReplicaSetStatus.ReplicaSet localReplicaSet1 = this.members;
          if (localReplicaSet1 == null) {
            try
            {
              wait(ReplicaSetStatus.this._mongo.getMongoOptions().getConnectTimeout());
            }
            catch (InterruptedException localInterruptedException)
            {
              throw new MongoInterruptedException("Interrupted while waiting for next update to replica set status", localInterruptedException);
            }
          }
        }
        localReplicaSet2 = this.members;
      }
      finally {}
      ReplicaSetStatus.ReplicaSet localReplicaSet2;
      return localReplicaSet2;
    }
    
    void set(ReplicaSetStatus.ReplicaSet paramReplicaSet)
    {
      if (paramReplicaSet == null) {
        try
        {
          throw new IllegalArgumentException("members can not be null");
        }
        finally {}
      }
      this.members = paramReplicaSet;
      notifyAll();
    }
    
    public String toString()
    {
      ReplicaSetStatus.ReplicaSet localReplicaSet = this.members;
      if (localReplicaSet != null) {
        return localReplicaSet.toString();
      }
      return "none";
    }
    
    void waitForNextUpdate()
    {
      try
      {
        wait(ReplicaSetStatus.this._mongo.getMongoOptions().getConnectTimeout());
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        throw new MongoInterruptedException("Interrupted while waiting for next update to replica set status", localInterruptedException);
      }
      finally {}
    }
  }
  
  @Immutable
  static class ReplicaSetNode
    extends ConnectionStatus.Node
  {
    private final boolean _isMaster;
    private final boolean _isSecondary;
    private final Set<String> _names;
    private final String _setName;
    private final Set<ReplicaSetStatus.Tag> _tags;
    
    ReplicaSetNode(ServerAddress paramServerAddress, Set<String> paramSet, String paramString, float paramFloat, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, LinkedHashMap<String, String> paramLinkedHashMap, int paramInt)
    {
      super(paramServerAddress, paramInt, paramBoolean1);
      this._names = Collections.unmodifiableSet(new HashSet(paramSet));
      this._setName = paramString;
      this._isMaster = paramBoolean2;
      this._isSecondary = paramBoolean3;
      this._tags = Collections.unmodifiableSet(getTagsFromMap(paramLinkedHashMap));
    }
    
    private static Set<ReplicaSetStatus.Tag> getTagsFromMap(LinkedHashMap<String, String> paramLinkedHashMap)
    {
      HashSet localHashSet = new HashSet();
      paramLinkedHashMap = paramLinkedHashMap.entrySet().iterator();
      while (paramLinkedHashMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramLinkedHashMap.next();
        localHashSet.add(new ReplicaSetStatus.Tag((String)localEntry.getKey(), (String)localEntry.getValue()));
      }
      return localHashSet;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass())) {
          return false;
        }
        paramObject = (ReplicaSetNode)paramObject;
        if (this._isMaster != ((ReplicaSetNode)paramObject)._isMaster) {
          return false;
        }
        if (this._maxBsonObjectSize != ((ReplicaSetNode)paramObject)._maxBsonObjectSize) {
          return false;
        }
        if (this._isSecondary != ((ReplicaSetNode)paramObject)._isSecondary) {
          return false;
        }
        if (this._ok != ((ReplicaSetNode)paramObject)._ok) {
          return false;
        }
        if (Float.compare(((ReplicaSetNode)paramObject)._pingTime, this._pingTime) != 0) {
          return false;
        }
        if (!this._addr.equals(((ReplicaSetNode)paramObject)._addr)) {
          return false;
        }
        if (!this._names.equals(((ReplicaSetNode)paramObject)._names)) {
          return false;
        }
        if (!this._tags.equals(((ReplicaSetNode)paramObject)._tags)) {
          return false;
        }
      } while (this._setName.equals(((ReplicaSetNode)paramObject)._setName));
      return false;
    }
    
    public Set<String> getNames()
    {
      return this._names;
    }
    
    public float getPingTime()
    {
      return this._pingTime;
    }
    
    public String getSetName()
    {
      return this._setName;
    }
    
    public Set<ReplicaSetStatus.Tag> getTags()
    {
      return this._tags;
    }
    
    public int hashCode()
    {
      int m = 1;
      int n = this._addr.hashCode();
      int i;
      int i1;
      int i2;
      int j;
      label56:
      int k;
      if (this._pingTime != 0.0F)
      {
        i = Float.floatToIntBits(this._pingTime);
        i1 = this._names.hashCode();
        i2 = this._tags.hashCode();
        if (!this._ok) {
          break label132;
        }
        j = 1;
        if (!this._isMaster) {
          break label137;
        }
        k = 1;
        label65:
        if (!this._isSecondary) {
          break label142;
        }
      }
      for (;;)
      {
        return (((((((n * 31 + i) * 31 + i1) * 31 + i2) * 31 + j) * 31 + k) * 31 + m) * 31 + this._setName.hashCode()) * 31 + this._maxBsonObjectSize;
        i = 0;
        break;
        label132:
        j = 0;
        break label56;
        label137:
        k = 0;
        break label65;
        label142:
        m = 0;
      }
    }
    
    public boolean master()
    {
      return (this._ok) && (this._isMaster);
    }
    
    public boolean secondary()
    {
      return (this._ok) && (this._isSecondary);
    }
    
    public String toJSON()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("{ address:'").append(this._addr).append("', ");
      localStringBuilder.append("ok:").append(this._ok).append(", ");
      localStringBuilder.append("ping:").append(this._pingTime).append(", ");
      localStringBuilder.append("isMaster:").append(this._isMaster).append(", ");
      localStringBuilder.append("isSecondary:").append(this._isSecondary).append(", ");
      localStringBuilder.append("setName:").append(this._setName).append(", ");
      localStringBuilder.append("maxBsonObjectSize:").append(this._maxBsonObjectSize).append(", ");
      if ((this._tags != null) && (this._tags.size() > 0))
      {
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = this._tags.iterator();
        while (localIterator.hasNext()) {
          localArrayList.add(((ReplicaSetStatus.Tag)localIterator.next()).toDBObject());
        }
        localStringBuilder.append(new BasicDBObject("tags", localArrayList));
      }
      localStringBuilder.append("}");
      return localStringBuilder.toString();
    }
  }
  
  @Immutable
  static final class Tag
  {
    final String key;
    final String value;
    
    Tag(String paramString1, String paramString2)
    {
      this.key = paramString1;
      this.value = paramString2;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass())) {
          return false;
        }
        paramObject = (Tag)paramObject;
        if (this.key != null)
        {
          if (this.key.equals(((Tag)paramObject).key)) {}
        }
        else {
          while (((Tag)paramObject).key != null) {
            return false;
          }
        }
        if (this.value == null) {
          break;
        }
      } while (this.value.equals(((Tag)paramObject).value));
      for (;;)
      {
        return false;
        if (((Tag)paramObject).value == null) {
          break;
        }
      }
    }
    
    public int hashCode()
    {
      int j = 0;
      if (this.key != null) {}
      for (int i = this.key.hashCode();; i = 0)
      {
        if (this.value != null) {
          j = this.value.hashCode();
        }
        return i * 31 + j;
      }
    }
    
    public DBObject toDBObject()
    {
      return new BasicDBObject(this.key, this.value);
    }
  }
  
  static class UpdatableReplicaSetNode
    extends ConnectionStatus.UpdatableNode
  {
    private final List<UpdatableReplicaSetNode> _all;
    boolean _isMaster = false;
    boolean _isSecondary = false;
    private final AtomicReference<String> _lastPrimarySignal;
    private final AtomicReference<Logger> _logger;
    private final Set<String> _names = Collections.synchronizedSet(new HashSet());
    String _setName;
    final LinkedHashMap<String, String> _tags = new LinkedHashMap();
    
    UpdatableReplicaSetNode(ServerAddress paramServerAddress, List<UpdatableReplicaSetNode> paramList, AtomicReference<Logger> paramAtomicReference, Mongo paramMongo, MongoOptions paramMongoOptions, AtomicReference<String> paramAtomicReference1)
    {
      super(paramMongo, paramMongoOptions);
      this._all = paramList;
      this._names.add(paramServerAddress.toString());
      this._logger = paramAtomicReference;
      this._lastPrimarySignal = paramAtomicReference1;
    }
    
    private UpdatableReplicaSetNode findNode(String paramString, List<UpdatableReplicaSetNode> paramList, AtomicReference<Logger> paramAtomicReference)
    {
      Object localObject = paramList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        UpdatableReplicaSetNode localUpdatableReplicaSetNode = (UpdatableReplicaSetNode)((Iterator)localObject).next();
        if (localUpdatableReplicaSetNode._names.contains(paramString)) {
          return localUpdatableReplicaSetNode;
        }
      }
      try
      {
        localObject = new ServerAddress(paramString);
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          paramAtomicReference = (UpdatableReplicaSetNode)paramList.next();
          if (paramAtomicReference._addr.equals(localObject))
          {
            paramAtomicReference._names.add(paramString);
            return paramAtomicReference;
          }
        }
      }
      catch (UnknownHostException paramList)
      {
        ((Logger)paramAtomicReference.get()).log(Level.WARNING, "couldn't resolve host [" + paramString + "]");
        return null;
      }
      return null;
    }
    
    private void updateAddr()
    {
      try
      {
        if (this._addr.updateInetAddress())
        {
          this._port = new DBPort(this._addr, null, this._mongoOptions);
          this._mongo.getConnector().updatePortPool(this._addr);
          ((Logger)this._logger.get()).log(Level.INFO, "Address of host " + this._addr.toString() + " changed to " + this._addr.getSocketAddress().toString());
        }
        return;
      }
      catch (UnknownHostException localUnknownHostException)
      {
        ((Logger)this._logger.get()).log(Level.WARNING, null, localUnknownHostException);
      }
    }
    
    /* Error */
    UpdatableReplicaSetNode _addIfNotHere(String paramString)
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_1
      //   2: aload_0
      //   3: getfield 55	com/mongodb/ReplicaSetStatus$UpdatableReplicaSetNode:_all	Ljava/util/List;
      //   6: aload_0
      //   7: getfield 69	com/mongodb/ReplicaSetStatus$UpdatableReplicaSetNode:_logger	Ljava/util/concurrent/atomic/AtomicReference;
      //   10: invokespecial 197	com/mongodb/ReplicaSetStatus$UpdatableReplicaSetNode:findNode	(Ljava/lang/String;Ljava/util/List;Ljava/util/concurrent/atomic/AtomicReference;)Lcom/mongodb/ReplicaSetStatus$UpdatableReplicaSetNode;
      //   13: astore_2
      //   14: aload_2
      //   15: ifnonnull +101 -> 116
      //   18: new 2	com/mongodb/ReplicaSetStatus$UpdatableReplicaSetNode
      //   21: dup
      //   22: new 57	com/mongodb/ServerAddress
      //   25: dup
      //   26: aload_1
      //   27: invokespecial 107	com/mongodb/ServerAddress:<init>	(Ljava/lang/String;)V
      //   30: aload_0
      //   31: getfield 55	com/mongodb/ReplicaSetStatus$UpdatableReplicaSetNode:_all	Ljava/util/List;
      //   34: aload_0
      //   35: getfield 69	com/mongodb/ReplicaSetStatus$UpdatableReplicaSetNode:_logger	Ljava/util/concurrent/atomic/AtomicReference;
      //   38: aload_0
      //   39: getfield 164	com/mongodb/ReplicaSetStatus$UpdatableReplicaSetNode:_mongo	Lcom/mongodb/Mongo;
      //   42: aload_0
      //   43: getfield 153	com/mongodb/ReplicaSetStatus$UpdatableReplicaSetNode:_mongoOptions	Lcom/mongodb/MongoOptions;
      //   46: aload_0
      //   47: getfield 71	com/mongodb/ReplicaSetStatus$UpdatableReplicaSetNode:_lastPrimarySignal	Ljava/util/concurrent/atomic/AtomicReference;
      //   50: invokespecial 199	com/mongodb/ReplicaSetStatus$UpdatableReplicaSetNode:<init>	(Lcom/mongodb/ServerAddress;Ljava/util/List;Ljava/util/concurrent/atomic/AtomicReference;Lcom/mongodb/Mongo;Lcom/mongodb/MongoOptions;Ljava/util/concurrent/atomic/AtomicReference;)V
      //   53: astore_3
      //   54: aload_0
      //   55: getfield 55	com/mongodb/ReplicaSetStatus$UpdatableReplicaSetNode:_all	Ljava/util/List;
      //   58: aload_3
      //   59: invokeinterface 200 2 0
      //   64: pop
      //   65: aload_3
      //   66: areturn
      //   67: astore_3
      //   68: aload_0
      //   69: getfield 69	com/mongodb/ReplicaSetStatus$UpdatableReplicaSetNode:_logger	Ljava/util/concurrent/atomic/AtomicReference;
      //   72: invokevirtual 119	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
      //   75: checkcast 121	java/util/logging/Logger
      //   78: getstatic 127	java/util/logging/Level:WARNING	Ljava/util/logging/Level;
      //   81: new 129	java/lang/StringBuilder
      //   84: dup
      //   85: invokespecial 130	java/lang/StringBuilder:<init>	()V
      //   88: ldc -124
      //   90: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   93: aload_1
      //   94: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   97: ldc -118
      //   99: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   102: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   105: invokevirtual 143	java/util/logging/Logger:log	(Ljava/util/logging/Level;Ljava/lang/String;)V
      //   108: aload_2
      //   109: areturn
      //   110: astore_2
      //   111: aload_3
      //   112: astore_2
      //   113: goto -45 -> 68
      //   116: aload_2
      //   117: areturn
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	118	0	this	UpdatableReplicaSetNode
      //   0	118	1	paramString	String
      //   13	96	2	localUpdatableReplicaSetNode1	UpdatableReplicaSetNode
      //   110	1	2	localUnknownHostException1	UnknownHostException
      //   112	5	2	localObject	Object
      //   53	13	3	localUpdatableReplicaSetNode2	UpdatableReplicaSetNode
      //   67	45	3	localUnknownHostException2	UnknownHostException
      // Exception table:
      //   from	to	target	type
      //   18	54	67	java/net/UnknownHostException
      //   54	65	110	java/net/UnknownHostException
    }
    
    public void close()
    {
      this._port.close();
      this._port = null;
    }
    
    protected Logger getLogger()
    {
      return (Logger)this._logger.get();
    }
    
    void update(Set<UpdatableReplicaSetNode> paramSet)
    {
      CommandResult localCommandResult = update();
      if ((localCommandResult == null) || (!this._ok)) {}
      do
      {
        do
        {
          return;
          this._isMaster = localCommandResult.getBoolean("ismaster", false);
          this._isSecondary = localCommandResult.getBoolean("secondary", false);
          this._lastPrimarySignal.set(localCommandResult.getString("primary"));
          Iterator localIterator;
          Object localObject;
          if (localCommandResult.containsField("hosts"))
          {
            localIterator = ((List)localCommandResult.get("hosts")).iterator();
            while (localIterator.hasNext())
            {
              localObject = _addIfNotHere(localIterator.next().toString());
              if ((localObject != null) && (paramSet != null)) {
                paramSet.add(localObject);
              }
            }
          }
          if (localCommandResult.containsField("passives"))
          {
            localIterator = ((List)localCommandResult.get("passives")).iterator();
            while (localIterator.hasNext())
            {
              localObject = _addIfNotHere(localIterator.next().toString());
              if ((localObject != null) && (paramSet != null)) {
                paramSet.add(localObject);
              }
            }
          }
          if (localCommandResult.containsField("tags"))
          {
            paramSet = (DBObject)localCommandResult.get("tags");
            localIterator = paramSet.keySet().iterator();
            while (localIterator.hasNext())
            {
              localObject = (String)localIterator.next();
              this._tags.put(localObject, paramSet.get((String)localObject).toString());
            }
          }
        } while (!localCommandResult.containsField("setName"));
        this._setName = localCommandResult.getString("setName", "");
      } while (this._logger.get() != null);
      this._logger.set(Logger.getLogger(ReplicaSetStatus._rootLogger.getName() + "." + this._setName));
    }
  }
  
  class Updater
    extends ConnectionStatus.BackgroundUpdater
  {
    private final List<ReplicaSetStatus.UpdatableReplicaSetNode> _all;
    private volatile long _nextResolveTime;
    private final Random _random = new Random();
    
    Updater()
    {
      super();
      this._all = new ArrayList(localIterator.size());
      Iterator localIterator = localIterator.iterator();
      while (localIterator.hasNext())
      {
        ServerAddress localServerAddress = (ServerAddress)localIterator.next();
        this._all.add(new ReplicaSetStatus.UpdatableReplicaSetNode(localServerAddress, this._all, ReplicaSetStatus.this._logger, ReplicaSetStatus.this._mongo, ReplicaSetStatus.this._mongoOptions, ReplicaSetStatus.this._lastPrimarySignal));
      }
      this._nextResolveTime = (System.currentTimeMillis() + ReplicaSetStatus.inetAddrCacheMS);
    }
    
    private void closeAllNodes()
    {
      Iterator localIterator = this._all.iterator();
      while (localIterator.hasNext())
      {
        ReplicaSetStatus.UpdatableReplicaSetNode localUpdatableReplicaSetNode = (ReplicaSetStatus.UpdatableReplicaSetNode)localIterator.next();
        try
        {
          localUpdatableReplicaSetNode.close();
        }
        catch (Throwable localThrowable) {}
      }
    }
    
    private List<ReplicaSetStatus.ReplicaSetNode> createNodeList()
    {
      ArrayList localArrayList = new ArrayList(this._all.size());
      Iterator localIterator = this._all.iterator();
      while (localIterator.hasNext())
      {
        ReplicaSetStatus.UpdatableReplicaSetNode localUpdatableReplicaSetNode = (ReplicaSetStatus.UpdatableReplicaSetNode)localIterator.next();
        localArrayList.add(new ReplicaSetStatus.ReplicaSetNode(localUpdatableReplicaSetNode._addr, localUpdatableReplicaSetNode._names, localUpdatableReplicaSetNode._setName, localUpdatableReplicaSetNode._pingTimeMS, localUpdatableReplicaSetNode._ok, localUpdatableReplicaSetNode._isMaster, localUpdatableReplicaSetNode._isSecondary, localUpdatableReplicaSetNode._tags, localUpdatableReplicaSetNode._maxBsonObjectSize));
      }
      return localArrayList;
    }
    
    private void updateInetAddresses()
    {
      long l = System.currentTimeMillis();
      if ((ReplicaSetStatus.inetAddrCacheMS > 0) && (this._nextResolveTime < l))
      {
        this._nextResolveTime = (ReplicaSetStatus.inetAddrCacheMS + l);
        Iterator localIterator = this._all.iterator();
        while (localIterator.hasNext()) {
          ((ReplicaSetStatus.UpdatableReplicaSetNode)localIterator.next()).updateAddr();
        }
      }
    }
    
    public void run()
    {
      for (;;)
      {
        try
        {
          if (!Thread.interrupted()) {
            j = ConnectionStatus.updaterIntervalNoMasterMS;
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          ReplicaSetStatus.ReplicaSet localReplicaSet;
          long l;
          ReplicaSetStatus.this._replicaSetHolder.close();
          closeAllNodes();
          return;
        }
        try
        {
          updateAll();
          updateInetAddresses();
          localReplicaSet = new ReplicaSetStatus.ReplicaSet(createNodeList(), this._random, ReplicaSetStatus.slaveAcceptableLatencyMS);
          ReplicaSetStatus.this._replicaSetHolder.set(localReplicaSet);
          i = j;
          if (localReplicaSet.getErrorStatus().isOk())
          {
            i = j;
            if (localReplicaSet.hasMaster())
            {
              ReplicaSetStatus.this._mongo.getConnector().setMaster(localReplicaSet.getMaster());
              i = ConnectionStatus.updaterIntervalMS;
            }
          }
        }
        catch (Exception localException)
        {
          ((Logger)ReplicaSetStatus.this._logger.get()).log(Level.WARNING, "couldn't do update pass", localException);
          i = j;
          continue;
        }
        l = i;
        Thread.sleep(l);
      }
    }
    
    public void updateAll()
    {
      try
      {
        HashSet localHashSet = new HashSet();
        int i = 0;
        while (i < this._all.size())
        {
          ((ReplicaSetStatus.UpdatableReplicaSetNode)this._all.get(i)).update(localHashSet);
          i += 1;
        }
        if (localHashSet.size() > 0)
        {
          Iterator localIterator = this._all.iterator();
          while (localIterator.hasNext()) {
            if (!localHashSet.contains(localIterator.next())) {
              localIterator.remove();
            }
          }
        }
      }
      finally {}
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/ReplicaSetStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */