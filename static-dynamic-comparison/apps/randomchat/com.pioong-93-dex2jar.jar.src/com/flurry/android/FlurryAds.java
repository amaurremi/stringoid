package com.flurry.android;

import android.app.KeyguardManager;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Pair;
import android.view.ViewGroup;
import com.flurry.org.apache.avro.io.BinaryEncoder;
import com.flurry.org.apache.avro.io.Decoder;
import com.flurry.org.apache.avro.io.DecoderFactory;
import com.flurry.org.apache.avro.io.Encoder;
import com.flurry.org.apache.avro.io.EncoderFactory;
import com.flurry.org.apache.avro.specific.SpecificDatumReader;
import com.flurry.org.apache.avro.specific.SpecificDatumWriter;
import com.flurry.org.apache.avro.specific.SpecificRecordBase;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class FlurryAds
  implements bm
{
  private static List<Integer> cr;
  private static DecoderFactory cs;
  private static ag ct;
  static String d = "FlurryAgent";
  private static FlurryAds dc;
  private String aS;
  private String aW;
  private Map<Integer, ByteBuffer> aX;
  private long bb;
  private long bc;
  private boolean cA = true;
  private volatile String cB = null;
  private volatile String cC = null;
  private volatile float cD;
  private volatile float cE;
  private volatile Map<String, String> cF;
  private cz cG;
  private AdUnit cH;
  private long cI;
  aj cJ;
  private Handler cK;
  dc cL;
  FlurryFreqCapManager cM = FlurryFreqCapManager.an();
  private ICustomAdNetworkHandler cN;
  private final k cO;
  private final bq cP;
  private FlurryAdListener cQ;
  private int cR;
  private volatile List<cz> cS = new CopyOnWriteArrayList();
  private volatile Map<String, cz> cT = new HashMap();
  private volatile List<cz> cU = new ArrayList();
  private volatile List<String> cV = new ArrayList();
  private volatile boolean cW = false;
  private Map<String, String> cX;
  private AdUnit cY;
  private bf cZ;
  private w cu;
  private boolean cv = false;
  private boolean cw = false;
  private File cx = null;
  private File cy = null;
  private String cz;
  private final Map<String, String> da;
  private final Set<String> db;
  private boolean dd;
  private FlurryUserIdProvider de;
  
  FlurryAds()
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("open", "directOpen");
    ((Map)localObject).put("expand", "doExpand");
    ((Map)localObject).put("collapse", "doCollapse");
    this.da = Collections.unmodifiableMap((Map)localObject);
    localObject = new HashSet();
    ((Set)localObject).addAll(Arrays.asList(new String[] { "closeAd", "processRedirect", "nextFrame", "nextAdUnit", "notifyUser" }));
    this.db = Collections.unmodifiableSet((Set)localObject);
    localObject = new HandlerThread("FlurryAdThread");
    ((HandlerThread)localObject).start();
    this.cK = new Handler(((HandlerThread)localObject).getLooper());
    this.cJ = new aj();
    cr = Arrays.asList(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5) });
    cs = new DecoderFactory();
    ct = new ag(this);
    this.cu = new w(this);
    this.cL = new dc();
    this.aS = Build.VERSION.RELEASE;
    this.cz = Build.DEVICE;
    this.cF = new HashMap();
    this.cO = new j();
    this.cP = new h();
  }
  
  private Map<CharSequence, CharSequence> N()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.cX.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (Map.Entry)localIterator.next();
      Object localObject2 = (String)((Map.Entry)localObject1).getKey();
      String str = (String)((Map.Entry)localObject1).getValue();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject2 = str;
      if (str == null) {
        localObject2 = "";
      }
      localHashMap.put(localObject1, localObject2);
    }
    return localHashMap;
  }
  
  private void P()
  {
    try
    {
      cq localcq = new cq(this);
      this.cK.post(localcq);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private byte[] Q()
  {
    Object localObject2 = R();
    Object localObject4;
    BinaryEncoder localBinaryEncoder;
    synchronized (this.cS)
    {
      localObject4 = ct.a(this.cS);
      if (((List)localObject4).size() == 0) {
        return null;
      }
      ??? = SdkLogRequest.aa().setApiKey(FlurryAgent.w()).setAdReportedIds((List)localObject2).setSdkAdLogs((List)localObject4).setTestDevice(false).setAgentTimestamp(System.currentTimeMillis()).build();
      new StringBuilder().append("Got ad log request:").append(((SdkLogRequest)???).toString()).toString();
      localObject2 = new SpecificDatumWriter(SdkLogRequest.class);
      localObject4 = new ByteArrayOutputStream();
      localBinaryEncoder = EncoderFactory.get().directBinaryEncoder((OutputStream)localObject4, null);
    }
    try
    {
      ((SpecificDatumWriter)localObject2).write(???, localBinaryEncoder);
      localBinaryEncoder.flush();
      return ((ByteArrayOutputStream)localObject4).toByteArray();
    }
    catch (IOException localIOException)
    {
      new StringBuilder().append("Error generating adlog request").append(localIOException.getMessage()).toString();
    }
    localObject3 = finally;
    throw ((Throwable)localObject3);
    return null;
  }
  
  private List<AdReportedId> R()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = ByteBuffer.wrap(this.aW.getBytes());
    localArrayList.add(AdReportedId.aq().setId((ByteBuffer)localObject).setType(0).build());
    localObject = this.aX.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      localArrayList.add(AdReportedId.aq().setId((ByteBuffer)localEntry.getValue()).setType(((Integer)localEntry.getKey()).intValue()).build());
    }
    return localArrayList;
  }
  
  private void T()
  {
    try
    {
      new cm(this).execute(new Void[0]);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void V()
  {
    try
    {
      new co(this).execute(new Void[0]);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private bf a(Context paramContext, AdUnit paramAdUnit)
  {
    this.cY = paramAdUnit;
    if (paramAdUnit == null) {
      return null;
    }
    Object localObject1 = paramAdUnit.getAdFrames();
    Object localObject3;
    int i;
    String str2;
    String str1;
    Object localObject2;
    if (((List)localObject1).size() > 0)
    {
      localObject3 = (AdFrame)((List)localObject1).get(0);
      i = ((AdFrame)localObject3).getBinding().intValue();
      str2 = ((AdFrame)localObject3).getContent().toString();
      str1 = ((AdFrame)localObject3).getAdSpaceLayout().getFormat().toString();
      String str3 = ((AdFrame)localObject3).getAdGuid().toString();
      localObject2 = (cz)this.cT.get(str3);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = cx.a(this, str3);
      }
      localObject1 = a((cz)localObject1, "requested", true, null);
      onEvent(new cw("filled", Collections.emptyMap(), paramContext, paramAdUnit, (cz)localObject1, 0), this, 1);
      localObject2 = cx.b(((AdFrame)localObject3).getAdSpaceLayout());
      if ((this.cY != null) && (this.cY == paramAdUnit)) {
        break label184;
      }
    }
    for (;;)
    {
      return this.cZ;
      return null;
      label184:
      this.cZ = null;
      localObject3 = this.cN;
      if ((i == 4) && (localObject3 != null))
      {
        localObject2 = ((ICustomAdNetworkHandler)localObject3).getAdFromNetwork(paramContext, (AdCreative)localObject2, str2);
        if (localObject2 != null)
        {
          ((p)localObject2).K = this;
          ((p)localObject2).L = ((cz)localObject1);
          ((p)localObject2).N = 0;
          ((p)localObject2).M = paramAdUnit;
          this.cZ = new at((p)localObject2, paramAdUnit);
          continue;
        }
      }
      if (str1.equals("takeover"))
      {
        this.cG = ((cz)localObject1);
        this.cH = paramAdUnit;
        paramContext = this.cP.a(paramContext, this, (cz)localObject1, paramAdUnit);
        if (paramContext != null) {
          this.cZ = new cb(paramContext, paramAdUnit);
        }
      }
      else
      {
        paramContext = this.cO.b(paramContext, this, (cz)localObject1, paramAdUnit);
        if (paramContext != null) {
          this.cZ = new at(paramContext, paramAdUnit);
        }
      }
    }
  }
  
  private bu a(String paramString, boolean paramBoolean, Map<String, String> paramMap)
  {
    try
    {
      paramString = new bu(paramString, paramBoolean, M(), paramMap);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private static <A extends SpecificRecordBase> A a(byte[] paramArrayOfByte, Class<A> paramClass)
  {
    Object localObject = cs.binaryDecoder(new ByteArrayInputStream(paramArrayOfByte), null);
    try
    {
      localObject = (SpecificRecordBase)new SpecificDatumReader(paramClass).read(null, (Decoder)localObject);
      return (A)localObject;
    }
    catch (ClassCastException localClassCastException)
    {
      new StringBuilder().append("ClassCastException in parseAvroBinary:").append(localClassCastException.getMessage()).toString();
      new StringBuilder().append("ClassCastException in parseAvroBinary: bytes = ").append(paramArrayOfByte).append(" type = ").append(paramClass.getSimpleName()).toString();
      return null;
    }
    catch (IOException localIOException)
    {
      new StringBuilder().append("IOException in parseAvroBinary:").append(localIOException.getMessage()).toString();
      new StringBuilder().append("IOException in parseAvroBinary: bytes = ").append(paramArrayOfByte).append(" type = ").append(paramClass.getSimpleName()).toString();
    }
    return null;
  }
  
  private String a(cz paramcz, AdUnit paramAdUnit, af paramaf, String paramString)
  {
    Pattern localPattern = Pattern.compile(".*?(%\\{\\w+\\}).*?");
    for (paramaf = localPattern.matcher(paramString); paramaf.matches(); paramaf = localPattern.matcher(paramString)) {
      paramString = this.cu.a(paramcz, paramAdUnit, paramString, paramaf.group(1));
    }
    return paramString;
  }
  
  private static List<af> a(AdFrame paramAdFrame, cw paramcw)
  {
    ArrayList localArrayList = new ArrayList();
    paramAdFrame = paramAdFrame.getCallbacks();
    String str3 = paramcw.eW;
    Iterator localIterator1 = paramAdFrame.iterator();
    while (localIterator1.hasNext())
    {
      paramAdFrame = (Callback)localIterator1.next();
      if (paramAdFrame.getEvent().toString().equals(str3))
      {
        Iterator localIterator2 = paramAdFrame.getActions().iterator();
        while (localIterator2.hasNext())
        {
          paramAdFrame = (CharSequence)localIterator2.next();
          HashMap localHashMap = new HashMap();
          String str2 = paramAdFrame.toString();
          int i = str2.indexOf('?');
          paramAdFrame = str2;
          if (i != -1)
          {
            String str1 = str2.substring(0, i);
            str2 = str2.substring(i + 1);
            paramAdFrame = str2;
            if (str2.contains("%{eventParams}"))
            {
              paramAdFrame = str2.replace("%{eventParams}", "");
              localHashMap.putAll(paramcw.bv);
            }
            localHashMap.putAll(bd.t(paramAdFrame));
            paramAdFrame = str1;
          }
          localArrayList.add(new af(paramAdFrame, localHashMap, paramcw));
        }
      }
    }
    return localArrayList;
  }
  
  private void a(Context paramContext, String paramString, boolean paramBoolean, AdUnit paramAdUnit)
  {
    this.cK.post(new cu(this, paramString, paramAdUnit, paramContext, paramBoolean));
  }
  
  private void a(FlurryFreqCapManager paramFlurryFreqCapManager, DataOutputStream paramDataOutputStream)
  {
    try
    {
      paramFlurryFreqCapManager = paramFlurryFreqCapManager.ao().iterator();
      while (paramFlurryFreqCapManager.hasNext())
      {
        FlurryFreqCapInfo localFlurryFreqCapInfo = (FlurryFreqCapInfo)paramFlurryFreqCapManager.next();
        try
        {
          paramDataOutputStream.writeShort(1);
          localFlurryFreqCapInfo.a(paramDataOutputStream);
        }
        catch (IOException localIOException)
        {
          db.c(d, "unable to convert freqCap to byte[]: " + localFlurryFreqCapInfo.getIdHash());
        }
      }
    }
    finally {}
  }
  
  private void a(SdkLogResponse paramSdkLogResponse)
  {
    try
    {
      if (paramSdkLogResponse.getResult().toString().equals("success")) {
        this.cS.removeAll(this.cU);
      }
      return;
    }
    finally
    {
      paramSdkLogResponse = finally;
      throw paramSdkLogResponse;
    }
  }
  
  private void a(List<cz> paramList, DataOutputStream paramDataOutputStream)
  {
    try
    {
      int j = paramList.size();
      int i = 0;
      for (;;)
      {
        if (i < j) {
          try
          {
            ((cz)paramList.get(i)).a(paramDataOutputStream);
            i += 1;
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              db.c(d, "unable to convert adLog to byte[]: " + ((cz)paramList.get(i)).at());
            }
          }
        }
      }
    }
    finally {}
  }
  
  private boolean a(Context paramContext, String paramString, FlurryAdSize paramFlurryAdSize, long paramLong)
  {
    boolean bool1 = false;
    if (i(paramString)) {
      bool1 = true;
    }
    for (;;)
    {
      return bool1;
      paramContext = new bw(this, paramContext, paramString, paramFlurryAdSize, null, false, false);
      paramContext.execute(new Void[0]);
      try
      {
        paramContext.get(paramLong, TimeUnit.MILLISECONDS);
        boolean bool2 = i(paramString);
        if (bool2) {
          return true;
        }
      }
      catch (InterruptedException paramContext)
      {
        paramContext.printStackTrace();
        return false;
      }
      catch (ExecutionException paramContext)
      {
        paramContext.printStackTrace();
        return false;
      }
      catch (TimeoutException paramContext) {}
    }
    return false;
  }
  
  static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    paramString2 = new Intent(paramString2);
    paramString2.setData(Uri.parse(paramString1));
    return bd.a(paramContext, paramString2);
  }
  
  private static byte[] a(InputStream paramInputStream)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[''];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    return localByteArrayOutputStream.toByteArray();
  }
  
  private byte[] a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, FlurryAdSize paramFlurryAdSize)
  {
    Object localObject1 = R();
    Object localObject2 = new ArrayList();
    Iterator localIterator = this.cM.ao().iterator();
    while (localIterator.hasNext())
    {
      FlurryFreqCapInfo localFlurryFreqCapInfo = (FlurryFreqCapInfo)localIterator.next();
      ((List)localObject2).add(FrequencyCapInfo.ak().setIdHash(localFlurryFreqCapInfo.getIdHash()).setExpirationTime(localFlurryFreqCapInfo.getExpirationTime()).setNewCap(localFlurryFreqCapInfo.getNewCap()).setPreviousCap(localFlurryFreqCapInfo.getPreviousCap()).setPreviousCapType(localFlurryFreqCapInfo.getPreviousCapType()).setServeTime(localFlurryFreqCapInfo.getServeTime()).setViews(localFlurryFreqCapInfo.getViews()).build());
    }
    localObject1 = AdRequest.ab().setApiKey(FlurryAgent.w()).setAdSpaceName("").setBindings(cr).setAdReportedIds((List)localObject1).setLocation(Location.as().setLat(this.cD).setLon(this.cE).build()).setTestDevice(this.cW).setAgentVersion(Integer.toString(FlurryAgent.getAgentVersion())).setSessionId(this.bb).setAdViewContainer(AdViewContainer.A().setScreenHeight(paramInt4).setScreenWidth(paramInt3).setViewHeight(paramInt2).setViewWidth(paramInt1).build()).setLocale(FlurryAgent.getLocale()).setTimezone(FlurryAgent.x()).setOsVersion(this.aS).setDevicePlatform(this.cz).setCanDoSKAppStore(false).setNetworkStatus(1).setFrequencyCapInfos((List)localObject2).build();
    if (paramBoolean) {
      ((AdRequest)localObject1).a(Boolean.valueOf(paramBoolean));
    }
    for (;;)
    {
      if (paramFlurryAdSize != null) {
        ((AdRequest)localObject1).a(TestAds.al().setAdspacePlacement(paramFlurryAdSize.getValue()).build());
      }
      if (this.cX != null) {
        ((AdRequest)localObject1).c(N());
      }
      new StringBuilder().append("Got ad request: ").append(localObject1).toString();
      paramString = new SpecificDatumWriter(AdRequest.class);
      paramFlurryAdSize = new ByteArrayOutputStream();
      localObject2 = EncoderFactory.get().directBinaryEncoder(paramFlurryAdSize, null);
      try
      {
        paramString.write(localObject1, (Encoder)localObject2);
        ((BinaryEncoder)localObject2).flush();
        return paramFlurryAdSize.toByteArray();
      }
      catch (IOException paramString)
      {
        paramString.getMessage();
      }
      ((AdRequest)localObject1).b(paramString);
    }
    return new byte[0];
  }
  
  private static int b(byte[] paramArrayOfByte)
  {
    CrcMessageDigest localCrcMessageDigest = new CrcMessageDigest();
    localCrcMessageDigest.update(paramArrayOfByte);
    return localCrcMessageDigest.getChecksum();
  }
  
  private boolean b(byte[] paramArrayOfByte, String paramString)
  {
    if (paramString == null) {
      return false;
    }
    StringBuilder localStringBuilder;
    String str;
    if (paramString.equals("/v5/getAds.do"))
    {
      localStringBuilder = new StringBuilder();
      if (this.cB != null) {
        str = this.cB;
      }
    }
    for (;;)
    {
      str = str + paramString;
      paramArrayOfByte = c(paramArrayOfByte, str);
      if (paramArrayOfByte != null) {}
      try
      {
        if (paramString.equals("/postAdLog.do")) {
          c(paramArrayOfByte);
        }
        return true;
        if (FlurryAgent.getUseHttps())
        {
          str = "https://ads.flurry.com";
          continue;
        }
        str = "http://ads.flurry.com";
        continue;
        localStringBuilder = new StringBuilder();
        if (this.cC != null) {
          str = this.cC;
        }
        for (;;)
        {
          str = str + paramString;
          break;
          if (FlurryAgent.getUseHttps()) {
            str = "https://adlog.flurry.com";
          } else {
            str = "http://adlog.flurry.com";
          }
        }
      }
      catch (IOException paramArrayOfByte)
      {
        for (;;)
        {
          db.d(d, "IOException: " + paramArrayOfByte.toString());
        }
      }
    }
  }
  
  private void c(byte[] paramArrayOfByte)
    throws IOException
  {
    paramArrayOfByte = (SdkLogResponse)a(paramArrayOfByte, SdkLogResponse.class);
    if (paramArrayOfByte != null)
    {
      new StringBuilder().append("Got ad log response: ").append(paramArrayOfByte).toString();
      if (!paramArrayOfByte.getResult().toString().equals("success")) {
        break label58;
      }
      a(paramArrayOfByte);
    }
    for (;;)
    {
      return;
      label58:
      paramArrayOfByte = paramArrayOfByte.getErrors().iterator();
      while (paramArrayOfByte.hasNext())
      {
        CharSequence localCharSequence = (CharSequence)paramArrayOfByte.next();
        db.d(d, localCharSequence.toString());
      }
    }
  }
  
  private byte[] c(byte[] paramArrayOfByte, String paramString)
  {
    Object localObject1 = new ByteArrayEntity(paramArrayOfByte);
    ((ByteArrayEntity)localObject1).setContentType("avro/binary");
    Object localObject2 = new HttpPost(paramString);
    ((HttpPost)localObject2).setEntity((HttpEntity)localObject1);
    ((HttpPost)localObject2).setHeader("accept", "avro/binary");
    ((HttpPost)localObject2).setHeader("FM-Checksum", Integer.toString(b(paramArrayOfByte)));
    paramArrayOfByte = new BasicHttpParams();
    HttpConnectionParams.setConnectionTimeout(paramArrayOfByte, 10000);
    HttpConnectionParams.setSoTimeout(paramArrayOfByte, 15000);
    ((HttpPost)localObject2).getParams().setBooleanParameter("http.protocol.expect-continue", false);
    paramArrayOfByte = cn.a(paramArrayOfByte);
    try
    {
      paramArrayOfByte = paramArrayOfByte.execute((HttpUriRequest)localObject2);
      int i = paramArrayOfByte.getStatusLine().getStatusCode();
      if ((i == 200) && (paramArrayOfByte.getEntity() != null) && (paramArrayOfByte.getEntity().getContentLength() != 0L))
      {
        db.e(d, "Request successful");
        localObject2 = a(paramArrayOfByte.getEntity().getContent());
        ((ByteArrayEntity)localObject1).consumeContent();
        localObject1 = Integer.toString(b((byte[])localObject2));
        if (!paramArrayOfByte.containsHeader("FM-Checksum")) {
          break label315;
        }
        if (paramArrayOfByte.getFirstHeader("FM-Checksum").getValue().equals(localObject1)) {
          return (byte[])localObject2;
        }
      }
      else
      {
        db.d(d, "Request to url = " + paramString + " failed with HTTP = " + i);
      }
    }
    catch (IOException paramArrayOfByte)
    {
      for (;;)
      {
        db.b(d, "Request to url = " + paramString + " failed with IOException = " + paramArrayOfByte.toString(), paramArrayOfByte);
      }
    }
    return null;
    label315:
    return (byte[])localObject2;
  }
  
  public static void clearTargetingKeywords()
  {
    getInstance().cX = null;
  }
  
  public static void clearUserCookies()
  {
    getInstance().cF.clear();
  }
  
  public static void displayAd(Context paramContext, String paramString, ViewGroup paramViewGroup)
  {
    if (paramContext == null)
    {
      db.d(d, "Context passed to displayAd was null.");
      return;
    }
    if (paramString == null)
    {
      db.d(d, "Ad space name passed to displayAd was null.");
      return;
    }
    if (paramString.length() == 0)
    {
      db.d(d, "Ad space name passed to displayAd was empty.");
      return;
    }
    if (paramViewGroup == null)
    {
      db.d(d, "ViewGroup  passed to displayAd was null.");
      return;
    }
    getInstance().g(paramContext);
    for (;;)
    {
      FlurryAds localFlurryAds;
      try
      {
        localFlurryAds = dc;
        bf localbf = localFlurryAds.n(paramString);
        if (localbf == null) {
          break;
        }
        if (localFlurryAds.cQ != null)
        {
          if ((localbf instanceof at)) {
            localFlurryAds.cQ.shouldDisplayAd(paramString.toString(), FlurryAdType.WEB_BANNER);
          }
        }
        else
        {
          localbf.a(paramContext, paramViewGroup);
          return;
        }
      }
      catch (Throwable paramContext)
      {
        db.b(d, "", paramContext);
        return;
      }
      localFlurryAds.cQ.shouldDisplayAd(paramString.toString(), FlurryAdType.WEB_TAKEOVER);
    }
  }
  
  static boolean e(Context paramContext, String paramString)
  {
    int i = 0;
    for (;;)
    {
      if (i < 5)
      {
        if ((i(paramContext) == true) && (!h(paramContext)))
        {
          HttpResponse localHttpResponse = bd.a(paramString, 10000, 15000, true);
          if ((localHttpResponse == null) || (localHttpResponse.getStatusLine().getStatusCode() != 200)) {
            break label84;
          }
          new StringBuilder().append("URL hit succeeded for: ").append(paramString).toString();
          return true;
        }
        try
        {
          Thread.sleep(100L);
          label84:
          i += 1;
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            localInterruptedException.getMessage();
          }
        }
      }
    }
    return false;
  }
  
  public static void enableTestAds(boolean paramBoolean)
  {
    getInstance().cW = paramBoolean;
  }
  
  public static void fetchAd(Context paramContext, String paramString, ViewGroup paramViewGroup, FlurryAdSize paramFlurryAdSize)
  {
    if (paramContext == null) {
      db.d(d, "Context passed to fetchAd was null.");
    }
    FlurryAds localFlurryAds;
    do
    {
      return;
      if (paramString == null)
      {
        db.d(d, "Ad space name passed to fetchAd was null.");
        return;
      }
      if (paramString.length() == 0)
      {
        db.d(d, "Ad space name passed to fetchAd was empty.");
        return;
      }
      if (paramViewGroup == null)
      {
        db.d(d, "ViewGroup passed to fetchAd was null.");
        return;
      }
      if (paramFlurryAdSize == null)
      {
        db.d(d, "FlurryAdSize passed to fetchAd was null.");
        return;
      }
      getInstance().g(paramContext);
      try
      {
        localFlurryAds = dc;
        if ((localFlurryAds.i(paramString)) && (!h(paramContext)))
        {
          localFlurryAds.c(paramContext, paramString);
          return;
        }
      }
      catch (Throwable paramContext)
      {
        db.b(d, "", paramContext);
        return;
      }
    } while (h(paramContext));
    new bw(localFlurryAds, paramContext, paramString, paramFlurryAdSize, paramViewGroup, true, false).execute(new Void[0]);
  }
  
  private void g(Context paramContext)
  {
    try
    {
      if (!this.dd)
      {
        this.cx = paramContext.getFileStreamPath(".flurryadlog." + Integer.toString(FlurryAgent.w().hashCode(), 16));
        this.cy = paramContext.getFileStreamPath(".flurryfreqcap." + Integer.toString(FlurryAgent.w().hashCode(), 16));
        String str = paramContext.getPackageName();
        this.cA = a(paramContext, "market://details?id=" + str, "android.intent.action.VIEW");
        this.cJ.bE = paramContext;
        T();
        db.c(d, "Attempting to load FreqCap data");
        V();
        this.dd = true;
      }
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static boolean getAd(Context paramContext, String paramString, ViewGroup paramViewGroup, FlurryAdSize paramFlurryAdSize, long paramLong)
  {
    if (paramContext == null)
    {
      db.d(d, "Context passed to getAd was null.");
      return false;
    }
    if (paramString == null)
    {
      db.d(d, "Ad space name passed to getAd was null.");
      return false;
    }
    if (paramString.length() == 0)
    {
      db.d(d, "Ad space name passed to getAd was empty.");
      return false;
    }
    if (paramViewGroup == null)
    {
      db.d(d, "ViewGroup passed to getAd was null.");
      return false;
    }
    if (paramFlurryAdSize == null)
    {
      db.d(d, "FlurryAdSize passed to getAd was null.");
      return false;
    }
    getInstance().g(paramContext);
    try
    {
      boolean bool = dc.a(paramContext, paramString, paramFlurryAdSize, paramViewGroup, paramLong);
      return bool;
    }
    catch (Throwable paramContext)
    {
      db.b(d, "", paramContext);
    }
    return false;
  }
  
  static FlurryAds getInstance()
  {
    if (dc == null) {
      dc = new FlurryAds();
    }
    return dc;
  }
  
  private static boolean h(Context paramContext)
  {
    return ((KeyguardManager)paramContext.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
  }
  
  private static boolean i(Context paramContext)
  {
    boolean bool2;
    if (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0)
    {
      bool2 = true;
      return bool2;
    }
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((paramContext != null) && ((paramContext.isConnected()) || (paramContext.isRoaming()))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 = bool1;
      if (bool1) {
        break;
      }
      db.g(d, "No connectivity found.");
      return bool1;
    }
  }
  
  private boolean i(String paramString)
  {
    return this.cJ.i(paramString);
  }
  
  public static void initializeAds(Context paramContext)
  {
    if (paramContext == null)
    {
      db.d(d, "Context passed to initializeAds was null.");
      return;
    }
    getInstance().g(paramContext);
    try
    {
      FlurryAds localFlurryAds = dc;
      db.e(d, "Initializing ads -- requesting ads with precaching enabled on the server");
      int i = 0;
      if (!FlurryAgent.m()) {
        i = 500;
      }
      localFlurryAds.cK.postDelayed(new cr(localFlurryAds, paramContext), i);
      return;
    }
    catch (Throwable paramContext)
    {
      db.b(d, "", paramContext);
    }
  }
  
  public static boolean isAdAvailable(Context paramContext, String paramString, FlurryAdSize paramFlurryAdSize, long paramLong)
  {
    if (paramContext == null)
    {
      db.d(d, "Context passed to isAdAvailable was null.");
      return false;
    }
    if (paramString == null)
    {
      db.d(d, "Ad space name passed to isAdAvailable was null.");
      return false;
    }
    if (paramString.length() == 0)
    {
      db.d(d, "Ad space name passed to isAdAvailable was empty.");
      return false;
    }
    if (paramFlurryAdSize == null)
    {
      db.d(d, "FlurryAdSize passed to isAdAvailable was null.");
      return false;
    }
    getInstance().g(paramContext);
    try
    {
      boolean bool = dc.a(paramContext, paramString, paramFlurryAdSize, paramLong);
      return bool;
    }
    catch (Throwable paramContext)
    {
      db.b(d, "", paramContext);
    }
    return false;
  }
  
  private AdUnit l(String paramString)
  {
    return this.cJ.h(paramString);
  }
  
  private bf n(String paramString)
  {
    return this.cL.n(paramString);
  }
  
  private void o(String paramString)
  {
    this.cL.o(paramString);
  }
  
  public static void removeAd(Context paramContext, String paramString, ViewGroup paramViewGroup)
  {
    if (paramContext == null)
    {
      db.d(d, "Context passed to removeAd was null.");
      return;
    }
    if (paramString == null)
    {
      db.d(d, "Ad space name passed to removeAd was null.");
      return;
    }
    if (paramString.length() == 0)
    {
      db.d(d, "Ad space name passed to removeAd was empty.");
      return;
    }
    if (paramViewGroup == null)
    {
      db.d(d, "ViewGroup passed to removeAd was null.");
      return;
    }
    getInstance().g(paramContext);
    try
    {
      dc.d(paramContext, paramString);
      return;
    }
    catch (Throwable paramContext)
    {
      db.b(d, "", paramContext);
    }
  }
  
  public static void setAdListener(FlurryAdListener paramFlurryAdListener)
  {
    getInstance().cQ = paramFlurryAdListener;
  }
  
  public static void setAdLogUrl(String paramString)
  {
    getInstance().cC = paramString;
  }
  
  public static void setAdServerUrl(String paramString)
  {
    getInstance().cB = paramString;
  }
  
  public static void setCustomAdNetworkHandler(ICustomAdNetworkHandler paramICustomAdNetworkHandler)
  {
    if (paramICustomAdNetworkHandler == null)
    {
      db.d(d, "ICustomAdNetworkHandler passed to setCustomAdNetworkHandler was null.");
      return;
    }
    getInstance().cN = paramICustomAdNetworkHandler;
  }
  
  public static void setLocation(float paramFloat1, float paramFloat2)
  {
    getInstance().cD = paramFloat1;
    getInstance().cE = paramFloat2;
  }
  
  public static void setTargetingKeywords(Map<String, String> paramMap)
  {
    if (paramMap == null) {
      db.d(d, "targetingKeywords Map passed to setTargetingKeywords was null.");
    }
    while (paramMap == null) {
      return;
    }
    getInstance().cX = paramMap;
  }
  
  public static void setUserCookies(Map<String, String> paramMap)
  {
    if (paramMap == null) {
      db.d(d, "userCookies Map passed to setUserCookies was null.");
    }
    for (;;)
    {
      return;
      FlurryAds localFlurryAds = getInstance();
      if ((paramMap != null) && (paramMap.size() > 0))
      {
        paramMap = paramMap.entrySet().iterator();
        while (paramMap.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramMap.next();
          if ((localEntry.getKey() != null) && (localEntry.getValue() != null)) {
            localFlurryAds.cF.put(localEntry.getKey(), localEntry.getValue());
          } else {
            db.g(d, "User cookie keys and values may not be null.");
          }
        }
      }
    }
  }
  
  static String w()
  {
    return FlurryAgent.w();
  }
  
  final void J()
  {
    this.cM.ap();
  }
  
  final void K()
  {
    P();
  }
  
  final long L()
  {
    return this.bb;
  }
  
  /* Error */
  final long M()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 1479	android/os/SystemClock:elapsedRealtime	()J
    //   5: aload_0
    //   6: getfield 1481	com/flurry/android/FlurryAds:bc	J
    //   9: lsub
    //   10: lstore_1
    //   11: lload_1
    //   12: aload_0
    //   13: getfield 1483	com/flurry/android/FlurryAds:cI	J
    //   16: lcmp
    //   17: ifle +17 -> 34
    //   20: aload_0
    //   21: lload_1
    //   22: putfield 1483	com/flurry/android/FlurryAds:cI	J
    //   25: aload_0
    //   26: getfield 1483	com/flurry/android/FlurryAds:cI	J
    //   29: lstore_1
    //   30: aload_0
    //   31: monitorexit
    //   32: lload_1
    //   33: lreturn
    //   34: aload_0
    //   35: getfield 1483	com/flurry/android/FlurryAds:cI	J
    //   38: lconst_1
    //   39: ladd
    //   40: lstore_1
    //   41: aload_0
    //   42: lload_1
    //   43: putfield 1483	com/flurry/android/FlurryAds:cI	J
    //   46: goto -26 -> 20
    //   49: astore_3
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_3
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	FlurryAds
    //   10	33	1	l	long
    //   49	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	20	49	finally
    //   20	30	49	finally
    //   34	46	49	finally
  }
  
  final Map<String, String> O()
  {
    Map localMap = this.cF;
    if (this.de != null)
    {
      localObject = this.de;
      if (((FlurryUserIdProvider)localObject).mContext != null) {
        break label48;
      }
    }
    label48:
    for (Object localObject = "";; localObject = ((FlurryUserIdProvider)localObject).mContext.getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0).getString("flurry_last_user_id", ""))
    {
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localMap.put("appCloudUserId", localObject);
      }
      return localMap;
    }
  }
  
  /* Error */
  final void S()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 100	com/flurry/android/FlurryAds:cx	Ljava/io/File;
    //   6: invokestatic 1519	com/flurry/android/bc:b	(Ljava/io/File;)Z
    //   9: istore_1
    //   10: iload_1
    //   11: ifne +10 -> 21
    //   14: aconst_null
    //   15: invokestatic 1522	com/flurry/android/bd:a	(Ljava/io/Closeable;)V
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: new 748	java/io/DataOutputStream
    //   24: dup
    //   25: new 1524	java/io/FileOutputStream
    //   28: dup
    //   29: aload_0
    //   30: getfield 100	com/flurry/android/FlurryAds:cx	Ljava/io/File;
    //   33: invokespecial 1527	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   36: invokespecial 1530	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   39: astore_3
    //   40: aload_3
    //   41: astore_2
    //   42: aload_3
    //   43: ldc_w 1531
    //   46: invokevirtual 752	java/io/DataOutputStream:writeShort	(I)V
    //   49: aload_3
    //   50: astore_2
    //   51: aload_0
    //   52: getfield 121	com/flurry/android/FlurryAds:cS	Ljava/util/List;
    //   55: astore 4
    //   57: aload_3
    //   58: astore_2
    //   59: aload 4
    //   61: monitorenter
    //   62: aload_0
    //   63: aload_0
    //   64: getfield 121	com/flurry/android/FlurryAds:cS	Ljava/util/List;
    //   67: aload_3
    //   68: invokespecial 1533	com/flurry/android/FlurryAds:a	(Ljava/util/List;Ljava/io/DataOutputStream;)V
    //   71: aload 4
    //   73: monitorexit
    //   74: aload_3
    //   75: astore_2
    //   76: aload_3
    //   77: iconst_0
    //   78: invokevirtual 752	java/io/DataOutputStream:writeShort	(I)V
    //   81: aload_3
    //   82: invokestatic 1522	com/flurry/android/bd:a	(Ljava/io/Closeable;)V
    //   85: goto -67 -> 18
    //   88: astore_2
    //   89: aload_0
    //   90: monitorexit
    //   91: aload_2
    //   92: athrow
    //   93: astore 5
    //   95: aload 4
    //   97: monitorexit
    //   98: aload_3
    //   99: astore_2
    //   100: aload 5
    //   102: athrow
    //   103: astore 4
    //   105: aload_3
    //   106: astore_2
    //   107: getstatic 90	com/flurry/android/FlurryAds:d	Ljava/lang/String;
    //   110: ldc_w 308
    //   113: aload 4
    //   115: invokestatic 1216	com/flurry/android/db:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   118: aload_3
    //   119: invokestatic 1522	com/flurry/android/bd:a	(Ljava/io/Closeable;)V
    //   122: goto -104 -> 18
    //   125: aload_2
    //   126: invokestatic 1522	com/flurry/android/bd:a	(Ljava/io/Closeable;)V
    //   129: aload_3
    //   130: athrow
    //   131: astore_3
    //   132: goto -7 -> 125
    //   135: astore 4
    //   137: aconst_null
    //   138: astore_3
    //   139: goto -34 -> 105
    //   142: astore_3
    //   143: aconst_null
    //   144: astore_2
    //   145: goto -20 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	this	FlurryAds
    //   9	2	1	bool	boolean
    //   41	35	2	localDataOutputStream1	DataOutputStream
    //   88	4	2	localObject1	Object
    //   99	46	2	localDataOutputStream2	DataOutputStream
    //   39	91	3	localDataOutputStream3	DataOutputStream
    //   131	1	3	localObject2	Object
    //   138	1	3	localObject3	Object
    //   142	1	3	localObject4	Object
    //   55	41	4	localList	List
    //   103	11	4	localThrowable1	Throwable
    //   135	1	4	localThrowable2	Throwable
    //   93	8	5	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   14	18	88	finally
    //   81	85	88	finally
    //   118	122	88	finally
    //   125	131	88	finally
    //   62	74	93	finally
    //   95	98	93	finally
    //   42	49	103	java/lang/Throwable
    //   51	57	103	java/lang/Throwable
    //   59	62	103	java/lang/Throwable
    //   76	81	103	java/lang/Throwable
    //   100	103	103	java/lang/Throwable
    //   42	49	131	finally
    //   51	57	131	finally
    //   59	62	131	finally
    //   76	81	131	finally
    //   100	103	131	finally
    //   107	118	131	finally
    //   2	10	135	java/lang/Throwable
    //   21	40	135	java/lang/Throwable
    //   2	10	142	finally
    //   21	40	142	finally
  }
  
  /* Error */
  final void U()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 116	com/flurry/android/FlurryAds:cM	Lcom/flurry/android/FlurryFreqCapManager;
    //   6: invokevirtual 1472	com/flurry/android/FlurryFreqCapManager:ap	()V
    //   9: aload_0
    //   10: getfield 102	com/flurry/android/FlurryAds:cy	Ljava/io/File;
    //   13: invokestatic 1519	com/flurry/android/bc:b	(Ljava/io/File;)Z
    //   16: istore_1
    //   17: iload_1
    //   18: ifne +10 -> 28
    //   21: aconst_null
    //   22: invokestatic 1522	com/flurry/android/bd:a	(Ljava/io/Closeable;)V
    //   25: aload_0
    //   26: monitorexit
    //   27: return
    //   28: new 748	java/io/DataOutputStream
    //   31: dup
    //   32: new 1524	java/io/FileOutputStream
    //   35: dup
    //   36: aload_0
    //   37: getfield 102	com/flurry/android/FlurryAds:cy	Ljava/io/File;
    //   40: invokespecial 1527	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   43: invokespecial 1530	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   46: astore_3
    //   47: aload_3
    //   48: astore_2
    //   49: aload_0
    //   50: getfield 116	com/flurry/android/FlurryAds:cM	Lcom/flurry/android/FlurryFreqCapManager;
    //   53: astore 4
    //   55: aload_3
    //   56: astore_2
    //   57: aload 4
    //   59: monitorenter
    //   60: aload_0
    //   61: aload_0
    //   62: getfield 116	com/flurry/android/FlurryAds:cM	Lcom/flurry/android/FlurryFreqCapManager;
    //   65: aload_3
    //   66: invokespecial 1536	com/flurry/android/FlurryAds:a	(Lcom/flurry/android/FlurryFreqCapManager;Ljava/io/DataOutputStream;)V
    //   69: aload 4
    //   71: monitorexit
    //   72: aload_3
    //   73: astore_2
    //   74: aload_3
    //   75: iconst_0
    //   76: invokevirtual 752	java/io/DataOutputStream:writeShort	(I)V
    //   79: aload_3
    //   80: invokestatic 1522	com/flurry/android/bd:a	(Ljava/io/Closeable;)V
    //   83: goto -58 -> 25
    //   86: astore_2
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_2
    //   90: athrow
    //   91: astore 5
    //   93: aload 4
    //   95: monitorexit
    //   96: aload_3
    //   97: astore_2
    //   98: aload 5
    //   100: athrow
    //   101: astore 4
    //   103: aload_3
    //   104: astore_2
    //   105: getstatic 90	com/flurry/android/FlurryAds:d	Ljava/lang/String;
    //   108: ldc_w 308
    //   111: aload 4
    //   113: invokestatic 1216	com/flurry/android/db:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   116: aload_3
    //   117: invokestatic 1522	com/flurry/android/bd:a	(Ljava/io/Closeable;)V
    //   120: goto -95 -> 25
    //   123: aload_2
    //   124: invokestatic 1522	com/flurry/android/bd:a	(Ljava/io/Closeable;)V
    //   127: aload_3
    //   128: athrow
    //   129: astore_3
    //   130: goto -7 -> 123
    //   133: astore 4
    //   135: aconst_null
    //   136: astore_3
    //   137: goto -34 -> 103
    //   140: astore_3
    //   141: aconst_null
    //   142: astore_2
    //   143: goto -20 -> 123
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	FlurryAds
    //   16	2	1	bool	boolean
    //   48	26	2	localDataOutputStream1	DataOutputStream
    //   86	4	2	localObject1	Object
    //   97	46	2	localDataOutputStream2	DataOutputStream
    //   46	82	3	localDataOutputStream3	DataOutputStream
    //   129	1	3	localObject2	Object
    //   136	1	3	localObject3	Object
    //   140	1	3	localObject4	Object
    //   53	41	4	localFlurryFreqCapManager	FlurryFreqCapManager
    //   101	11	4	localThrowable1	Throwable
    //   133	1	4	localThrowable2	Throwable
    //   91	8	5	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   2	9	86	finally
    //   21	25	86	finally
    //   79	83	86	finally
    //   116	120	86	finally
    //   123	129	86	finally
    //   60	72	91	finally
    //   93	96	91	finally
    //   49	55	101	java/lang/Throwable
    //   57	60	101	java/lang/Throwable
    //   74	79	101	java/lang/Throwable
    //   98	101	101	java/lang/Throwable
    //   49	55	129	finally
    //   57	60	129	finally
    //   74	79	129	finally
    //   98	101	129	finally
    //   105	116	129	finally
    //   9	17	133	java/lang/Throwable
    //   28	47	133	java/lang/Throwable
    //   9	17	140	finally
    //   28	47	140	finally
  }
  
  final cz W()
  {
    return this.cG;
  }
  
  final AdUnit X()
  {
    return this.cH;
  }
  
  /* Error */
  final cz a(cz paramcz, String paramString, boolean paramBoolean, Map<String, String> paramMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 381	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 382	java/lang/StringBuilder:<init>	()V
    //   9: ldc_w 1542
    //   12: invokevirtual 388	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: aload_1
    //   16: invokevirtual 639	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   19: ldc_w 1544
    //   22: invokevirtual 388	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_2
    //   26: invokevirtual 388	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc_w 1544
    //   32: invokevirtual 388	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: iload_3
    //   36: invokevirtual 1547	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   39: ldc_w 1544
    //   42: invokevirtual 388	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload 4
    //   47: invokevirtual 639	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   50: ldc_w 1549
    //   53: invokevirtual 388	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 392	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: pop
    //   60: aload_1
    //   61: monitorenter
    //   62: aload_0
    //   63: getfield 121	com/flurry/android/FlurryAds:cS	Ljava/util/List;
    //   66: aload_1
    //   67: invokeinterface 1551 2 0
    //   72: ifne +35 -> 107
    //   75: aload_0
    //   76: getfield 121	com/flurry/android/FlurryAds:cS	Ljava/util/List;
    //   79: aload_1
    //   80: invokeinterface 461 2 0
    //   85: pop
    //   86: new 381	java/lang/StringBuilder
    //   89: dup
    //   90: invokespecial 382	java/lang/StringBuilder:<init>	()V
    //   93: ldc_w 1553
    //   96: invokevirtual 388	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: aload_1
    //   100: invokevirtual 639	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   103: invokevirtual 392	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: pop
    //   107: aload_1
    //   108: aload_0
    //   109: aload_2
    //   110: iload_3
    //   111: aload 4
    //   113: invokespecial 1555	com/flurry/android/FlurryAds:a	(Ljava/lang/String;ZLjava/util/Map;)Lcom/flurry/android/bu;
    //   116: invokevirtual 1558	com/flurry/android/cz:a	(Lcom/flurry/android/bu;)V
    //   119: aload_1
    //   120: monitorexit
    //   121: aload_0
    //   122: monitorexit
    //   123: aload_1
    //   124: areturn
    //   125: astore_2
    //   126: aload_1
    //   127: monitorexit
    //   128: aload_2
    //   129: athrow
    //   130: astore_1
    //   131: aload_0
    //   132: monitorexit
    //   133: aload_1
    //   134: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	this	FlurryAds
    //   0	135	1	paramcz	cz
    //   0	135	2	paramString	String
    //   0	135	3	paramBoolean	boolean
    //   0	135	4	paramMap	Map<String, String>
    // Exception table:
    //   from	to	target	type
    //   62	107	125	finally
    //   107	121	125	finally
    //   126	128	125	finally
    //   2	62	130	finally
    //   128	130	130	finally
  }
  
  final List<AdUnit> a(Context paramContext, String paramString, ViewGroup paramViewGroup, boolean paramBoolean, FlurryAdSize paramFlurryAdSize)
  {
    this.cM.ap();
    int i = bd.n(paramContext);
    int j = bd.o(paramContext);
    switch (paramContext.getResources().getConfiguration().orientation)
    {
    }
    for (Pair localPair = Pair.create(Integer.valueOf(i), Integer.valueOf(j));; localPair = Pair.create(Integer.valueOf(j), Integer.valueOf(i)))
    {
      int i1 = ((Integer)localPair.first).intValue();
      int i2 = ((Integer)localPair.second).intValue();
      localPair = Pair.create(Integer.valueOf(bd.n(paramContext)), Integer.valueOf(bd.o(paramContext)));
      int n = ((Integer)localPair.first).intValue();
      int k = ((Integer)localPair.second).intValue();
      int m;
      if (!paramFlurryAdSize.equals(FlurryAdSize.BANNER_BOTTOM))
      {
        m = n;
        j = k;
        if (!paramFlurryAdSize.equals(FlurryAdSize.BANNER_TOP)) {}
      }
      else
      {
        i = k;
        if (paramViewGroup != null)
        {
          i = k;
          if (paramViewGroup.getHeight() > 0) {
            i = bd.a(paramContext, paramViewGroup.getHeight());
          }
        }
        m = n;
        j = i;
        if (paramViewGroup != null)
        {
          m = n;
          j = i;
          if (paramViewGroup.getWidth() > 0)
          {
            m = bd.a(paramContext, paramViewGroup.getWidth());
            j = i;
          }
        }
      }
      paramViewGroup = a(paramString, m, j, i1, i2, paramBoolean, paramFlurryAdSize);
      if ((paramViewGroup != null) && (paramViewGroup.length >= 1)) {
        break;
      }
      return Collections.emptyList();
    }
    if (this.cB != null) {
      paramContext = this.cB + "/v5/getAds.do";
    }
    for (;;)
    {
      paramContext = c(paramViewGroup, paramContext);
      if ((paramContext != null) && (paramContext.length >= 1)) {
        break;
      }
      return Collections.emptyList();
      if (FlurryAgent.getUseHttps()) {
        paramContext = "https://ads.flurry.com/v5/getAds.do";
      } else {
        paramContext = "http://ads.flurry.com/v5/getAds.do";
      }
    }
    paramContext = (AdResponse)a(paramContext, AdResponse.class);
    if (paramContext == null) {
      return Collections.emptyList();
    }
    new StringBuilder().append("Got ad response: ").append(paramContext).toString();
    if (paramContext.getErrors().size() > 0)
    {
      db.d(d, "Ad server responded with the following error(s):");
      paramContext = paramContext.getErrors().iterator();
      while (paramContext.hasNext())
      {
        paramString = (CharSequence)paramContext.next();
        db.d(d, paramString.toString());
      }
      return Collections.emptyList();
    }
    if ((!TextUtils.isEmpty(paramString)) && ((paramContext.getAdUnits() == null) || (paramContext.getAdUnits().size() == 0)))
    {
      db.d(d, "Ad server responded but sent no ad units.");
      return Collections.emptyList();
    }
    return paramContext.getAdUnits();
  }
  
  final void a(Context paramContext, long paramLong1, long paramLong2)
  {
    this.de = new FlurryUserIdProvider(paramContext);
    this.bb = paramLong1;
    this.bc = paramLong2;
    this.cI = 0L;
  }
  
  final void a(Context paramContext, String paramString, AdUnit paramAdUnit)
  {
    if (paramString.startsWith("market://details?id="))
    {
      paramAdUnit = paramAdUnit.getAdSpace().toString();
      if (this.cA)
      {
        if (!b(paramContext, paramString, paramAdUnit)) {
          db.d(d, "Cannot launch Google Play url " + paramString);
        }
        return;
      }
      paramString = paramString.substring("market://details?id=".length());
      b(paramContext, "https://market.android.com/details?id=" + paramString, paramAdUnit);
      return;
    }
    db.g(d, "Unexpected Google Play url scheme: " + paramString);
  }
  
  final void a(AdUnit paramAdUnit)
  {
    this.cH = paramAdUnit;
  }
  
  final void a(cz paramcz)
  {
    try
    {
      if (this.cS.size() < 32767)
      {
        this.cS.add(paramcz);
        this.cT.put(paramcz.at(), paramcz);
      }
      return;
    }
    finally
    {
      paramcz = finally;
      throw paramcz;
    }
  }
  
  final boolean a(Context paramContext, Intent paramIntent, String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    Object localObject;
    if (paramContext != null)
    {
      bool1 = bool2;
      if (paramIntent != null)
      {
        bool1 = bool2;
        if (paramString != null)
        {
          bool1 = bool2;
          if (bd.a(paramContext, paramIntent))
          {
            if ((paramContext == null) || (paramIntent == null)) {
              break label151;
            }
            localObject = paramIntent.resolveActivity(paramContext.getPackageManager());
          }
        }
      }
    }
    label151:
    for (bool1 = paramContext.getPackageName().equals(((ComponentName)localObject).getPackageName());; bool1 = false)
    {
      if (bool1) {}
      for (paramIntent = new Intent(paramIntent);; paramIntent = (Intent)localObject)
      {
        if (paramIntent != null) {
          paramIntent.putExtra("adSpaceName", paramString);
        }
        try
        {
          paramContext.startActivity(paramIntent);
          bool1 = true;
          return bool1;
        }
        catch (ActivityNotFoundException paramContext)
        {
          db.b(d, "Cannot launch Activity", paramContext);
          return false;
        }
        localObject = new Intent(paramContext, FlurryFullscreenTakeoverActivity.class);
        ((Intent)localObject).putExtra("targetIntent", paramIntent);
      }
    }
  }
  
  final boolean a(Context paramContext, String paramString, ViewGroup paramViewGroup)
  {
    c(paramContext, paramString);
    if (n(paramString) == null) {
      return false;
    }
    displayAd(paramContext, paramString, paramViewGroup);
    return true;
  }
  
  final boolean a(Context paramContext, String paramString, FlurryAdSize paramFlurryAdSize, ViewGroup paramViewGroup, long paramLong)
  {
    if (!i(paramString))
    {
      if ((i(paramContext)) && (!h(paramContext)))
      {
        boolean bool1;
        if (paramLong == 0L)
        {
          bool1 = true;
          if (paramLong != 0L) {
            break label113;
          }
        }
        label113:
        for (boolean bool2 = true;; bool2 = false)
        {
          paramFlurryAdSize = new bw(this, paramContext, paramString, paramFlurryAdSize, paramViewGroup, bool1, bool2);
          paramFlurryAdSize.execute(new Void[0]);
          if (paramLong <= 0L) {
            break label163;
          }
          try
          {
            paramFlurryAdSize.get(paramLong, TimeUnit.MILLISECONDS);
            if (!i(paramString)) {
              break label163;
            }
            bool1 = a(paramContext, paramString, paramViewGroup);
            return bool1;
          }
          catch (InterruptedException paramContext)
          {
            paramContext.printStackTrace();
            return false;
          }
          catch (ExecutionException paramContext)
          {
            paramContext.printStackTrace();
            return false;
          }
          catch (TimeoutException paramContext)
          {
            return false;
          }
          bool1 = false;
          break;
        }
      }
      else if ((!i(paramContext)) && (this.cQ != null))
      {
        this.cQ.spaceDidFailToReceiveAd(paramString.toString());
      }
      label163:
      return false;
    }
    if (!h(paramContext)) {
      return a(paramContext, paramString, paramViewGroup);
    }
    return false;
  }
  
  final void b(cz paramcz)
  {
    this.cG = paramcz;
  }
  
  final void b(DataInputStream paramDataInputStream)
    throws IOException
  {
    try
    {
      while (paramDataInputStream.readUnsignedShort() != 0) {
        synchronized (this.cS)
        {
          this.cS.add(new cz(paramDataInputStream));
        }
      }
      this.cv = true;
    }
    finally {}
  }
  
  final void b(String paramString, boolean paramBoolean)
  {
    this.cR += 1;
    if ((1 == this.cR) && (this.cQ != null)) {
      this.cQ.onAdOpened(paramString);
    }
    if ((paramBoolean) && (this.cQ != null)) {
      this.cQ.onApplicationExit(paramString);
    }
  }
  
  final void b(Map<Integer, ByteBuffer> paramMap)
  {
    this.aX = paramMap;
  }
  
  final boolean b(Context paramContext, String paramString1, String paramString2)
  {
    return a(paramContext, new Intent("android.intent.action.VIEW").setData(Uri.parse(paramString1)), paramString2);
  }
  
  final void c(Context paramContext, String paramString)
  {
    AdUnit localAdUnit = l(paramString);
    if (localAdUnit == null) {
      if (this.cQ != null) {
        this.cQ.spaceDidFailToReceiveAd(paramString.toString());
      }
    }
    do
    {
      return;
      this.cZ = null;
      paramContext = a(paramContext, localAdUnit);
      this.cL.a(paramString, paramContext);
    } while (this.cQ == null);
    this.cQ.spaceDidReceiveAd(paramString.toString());
  }
  
  final void c(DataInputStream paramDataInputStream)
    throws IOException
  {
    try
    {
      while (paramDataInputStream.readShort() != 0) {
        synchronized (this.cM)
        {
          this.cM.a(new FlurryFreqCapInfo(paramDataInputStream));
        }
      }
      this.cw = true;
    }
    finally {}
  }
  
  final void d(Context paramContext, String paramString)
  {
    new StringBuilder().append("_removeAd(context = ").append(paramContext).append(", adSpaceName = ").append(paramString).append(")").toString();
    paramContext = this.cL.A(paramString);
    if (paramContext == null)
    {
      o(paramString);
      return;
    }
    paramContext.stop();
    ViewGroup localViewGroup = paramContext.h();
    if (localViewGroup != null)
    {
      paramContext.removeAllViews();
      localViewGroup.removeView(paramContext);
    }
    o(paramString);
    this.cL.B(paramString);
  }
  
  final void d(List<cz> paramList)
  {
    this.cU = paramList;
  }
  
  final void e(List<AdUnit> paramList)
  {
    this.cJ.b(paramList);
  }
  
  final String getPhoneId()
  {
    return this.aW;
  }
  
  final void j(String paramString)
  {
    this.cR -= 1;
    if ((this.cR == 0) && (this.cQ != null)) {
      this.cQ.onAdClosed(paramString);
    }
  }
  
  final void k(String paramString)
  {
    this.aW = paramString;
  }
  
  final void m(String paramString)
  {
    byte[] arrayOfByte = Q();
    if (arrayOfByte != null) {
      b(arrayOfByte, paramString);
    }
  }
  
  public void onEvent(cw paramcw, bm parambm, int paramInt)
  {
    new StringBuilder().append("onEvent:event=").append(paramcw.eW).append(",params=").append(paramcw.bv).toString();
    Object localObject1 = a((AdFrame)paramcw.M.getAdFrames().get(paramcw.eX), paramcw);
    Object localObject2;
    Object localObject3;
    if (((List)localObject1).isEmpty())
    {
      localObject2 = this.da.entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        if (((String)((Map.Entry)localObject3).getKey()).equals(paramcw.eW)) {
          ((List)localObject1).add(new af((String)((Map.Entry)localObject3).getValue(), paramcw.bv, paramcw));
        }
      }
    }
    if (paramcw.eW.equals("adWillClose"))
    {
      localObject2 = ((List)localObject1).iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject3 = (af)((Iterator)localObject2).next();
      } while (!this.db.contains(((af)localObject3).bu));
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        ((List)localObject1).add(new af("closeAd", Collections.emptyMap(), paramcw));
      }
      if ((paramcw.eW.equals("renderFailed")) && (this.cQ != null)) {
        this.cQ.onRenderFailed(paramcw.M.getAdSpace().toString());
      }
      if ((paramcw.eW.equals("clicked")) && (this.cQ != null)) {
        this.cQ.onAdClicked(paramcw.M.getAdSpace().toString());
      }
      if ((paramcw.eW.equals("videoCompleted")) && (this.cQ != null)) {
        this.cQ.onVideoCompleted(paramcw.M.getAdSpace().toString());
      }
      localObject3 = ((List)localObject1).iterator();
      localObject1 = null;
      if (((Iterator)localObject3).hasNext())
      {
        localObject2 = (af)((Iterator)localObject3).next();
        if (!((af)localObject2).bu.equals("logEvent")) {
          break label625;
        }
        ((af)localObject2).bv.put("__sendToServer", "true");
        localObject1 = localObject2;
      }
      label625:
      for (;;)
      {
        if (((af)localObject2).bu.equals("loadAdComponents"))
        {
          Iterator localIterator = ((af)localObject2).bw.bv.entrySet().iterator();
          while (localIterator.hasNext())
          {
            Map.Entry localEntry = (Map.Entry)localIterator.next();
            ((af)localObject2).bv.put(((String)localEntry.getKey()).toString(), ((String)localEntry.getValue()).toString());
          }
        }
        db.f(d, ((af)localObject2).toString());
        parambm.performAction$3deb3ec3((af)localObject2, this, paramInt + 1);
        break;
        if (localObject1 == null)
        {
          localObject1 = new HashMap();
          ((Map)localObject1).put("__sendToServer", "false");
          paramcw = new af("logEvent", (Map)localObject1, paramcw);
          parambm.performAction$3deb3ec3(paramcw, this, paramInt + 1);
          db.f(d, paramcw.toString());
        }
        return;
      }
    }
  }
  
  public void performAction$3deb3ec3(af paramaf, FlurryAds paramFlurryAds, int paramInt)
  {
    int i = 1;
    boolean bool2 = false;
    new StringBuilder().append("performAction:action=").append(paramaf.bu).append(",params=").append(paramaf.bv).append(",triggering event=").append(paramaf.bw.eW).toString();
    String str1 = paramaf.bu;
    Object localObject1 = paramaf.bw.J;
    cz localcz = paramaf.bw.L;
    AdUnit localAdUnit = paramaf.bw.M;
    Object localObject3 = localAdUnit.getAdSpace().toString();
    if (paramInt > 10) {
      new StringBuilder().append("Maximum depth for event/action loop exceeded when performing action:").append(str1).append(",").append(paramaf.bv).append(",triggered by:").append(paramaf.bw.eW).toString();
    }
    label816:
    do
    {
      do
      {
        do
        {
          do
          {
            boolean bool1;
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        return;
                        if (str1.equals("directOpen"))
                        {
                          if (paramaf.bv.containsKey("url"))
                          {
                            paramFlurryAds = (String)paramaf.bv.get("url");
                            if (paramFlurryAds.startsWith("market://"))
                            {
                              a((Context)localObject1, paramFlurryAds, localAdUnit);
                              return;
                            }
                            if ("true".equals(paramaf.bv.get("native")))
                            {
                              b((Context)localObject1, a(localcz, localAdUnit, paramaf, paramFlurryAds), (String)localObject3);
                              return;
                            }
                            paramaf = new Intent((Context)localObject1, FlurryFullscreenTakeoverActivity.class);
                            paramaf.putExtra("url", paramFlurryAds);
                            if (bd.a((Context)localObject1, paramaf))
                            {
                              a((Context)localObject1, paramaf, (String)localObject3);
                              return;
                            }
                            db.g(d, "Can't start FlurryFullscreenTakeoverActivity, was it declared in the manifest? Falling back to default browser");
                            b((Context)localObject1, paramFlurryAds, (String)localObject3);
                            return;
                          }
                          db.d(d, "failed to perform directOpen action: no url in " + paramaf.bw.eW);
                          return;
                        }
                        if (!str1.equals("delete")) {
                          break;
                        }
                        if (paramaf.bv.containsKey("count"))
                        {
                          paramaf = (String)paramaf.bv.get("count");
                          try
                          {
                            paramInt = Integer.parseInt(paramaf);
                            this.cJ.a((String)localObject3, paramInt);
                            return;
                          }
                          catch (NumberFormatException paramFlurryAds)
                          {
                            for (;;)
                            {
                              new StringBuilder().append("caught NumberFormatException with count parameter in deleteAds:").append(paramaf).toString();
                              paramInt = -1;
                            }
                          }
                        }
                      } while (!paramaf.bv.containsKey("groupId"));
                      paramaf = (String)paramaf.bv.get("groupId");
                      this.cJ.b((String)localObject3, paramaf);
                      return;
                      if (!str1.equals("processRedirect")) {
                        break;
                      }
                    } while (!paramaf.bv.containsKey("url"));
                    paramFlurryAds = (String)paramaf.bv.get("url");
                    if ("true".equals(paramaf.bv.get("native")))
                    {
                      b((Context)localObject1, a(localcz, localAdUnit, paramaf, paramFlurryAds), (String)localObject3);
                      return;
                    }
                    if (paramFlurryAds.startsWith("http"))
                    {
                      paramFlurryAds = a(localcz, localAdUnit, paramaf, paramFlurryAds);
                      paramaf = new ab(this, (Context)localObject1, paramFlurryAds);
                      try
                      {
                        paramaf = (String)paramaf.execute(new Void[0]).get();
                        if (paramaf != null)
                        {
                          a((Context)localObject1, paramaf, true, localAdUnit);
                          return;
                        }
                      }
                      catch (InterruptedException paramaf)
                      {
                        for (;;)
                        {
                          paramaf.printStackTrace();
                          paramaf = "";
                        }
                      }
                      catch (ExecutionException paramaf)
                      {
                        for (;;)
                        {
                          paramaf.printStackTrace();
                          paramaf = "";
                        }
                        db.g(d, "Redirect URL could not be found for: " + paramFlurryAds);
                        return;
                      }
                    }
                    a((Context)localObject1, paramFlurryAds, false, localAdUnit);
                    return;
                    if (!str1.equals("verifyUrl")) {
                      break;
                    }
                  } while (!paramaf.bv.containsKey("url"));
                  localObject3 = (String)paramaf.bv.get("url");
                  localObject3 = ((Context)localObject1).getPackageManager().getLaunchIntentForPackage((String)localObject3);
                  if ((localObject3 != null) && (bd.a((Context)localObject1, (Intent)localObject3))) {
                    if (i == 0) {
                      break label816;
                    }
                  }
                  for (localObject1 = "urlVerified";; localObject1 = "urlNotVerified")
                  {
                    paramFlurryAds.onEvent(new cw((String)localObject1, Collections.emptyMap(), paramaf.bw.J, localAdUnit, localcz, paramaf.bw.eX), this, paramInt + 1);
                    return;
                    i = 0;
                    break;
                  }
                  if (!str1.equals("launchPackage")) {
                    break;
                  }
                } while (!paramaf.bv.containsKey("package"));
                paramaf = (String)paramaf.bv.get("package");
                paramFlurryAds = ((Context)localObject1).getPackageManager().getLaunchIntentForPackage(paramaf);
                if ((paramFlurryAds != null) && (bd.a((Context)localObject1, paramFlurryAds)))
                {
                  a((Context)localObject1, paramFlurryAds, localAdUnit.getAdSpace().toString());
                  return;
                }
                a((Context)localObject1, "https://play.google.com/store/apps/details?id=" + paramaf, false, localAdUnit);
                return;
                if (!str1.equals("sendUrlAsync")) {
                  break;
                }
              } while (!paramaf.bv.containsKey("url"));
              paramaf = a(localcz, localAdUnit, paramaf, (String)paramaf.bv.get("url"));
              new StringBuilder().append("url after is: ").append(paramaf).toString();
              paramaf = new ct(this, (Context)localObject1, paramaf);
              this.cK.post(paramaf);
              return;
              if (str1.equals("sendAdLogs"))
              {
                P();
                return;
              }
              if (str1.equals("logEvent"))
              {
                if ((paramaf.bv.containsKey("__sendToServer")) && (((String)paramaf.bv.get("__sendToServer")).equals("true"))) {}
                for (bool1 = true;; bool1 = false)
                {
                  paramaf.bv.remove("__sendToServer");
                  a(paramaf.bw.L, paramaf.bw.eW, bool1, paramaf.bv);
                  return;
                }
              }
            } while (str1.equals("nextFrame"));
            if (str1.equals("nextAdUnit"))
            {
              paramFlurryAds = this.cL.A((String)localObject3);
              if ((paramFlurryAds != null) && (paramaf.bv.containsKey("delay")))
              {
                paramInt = paramaf.bw.eX;
                bool1 = bool2;
                if (localAdUnit != null)
                {
                  bool1 = bool2;
                  if (localAdUnit.getAdFrames().size() > 0) {
                    bool1 = ((AdFrame)localAdUnit.getAdFrames().get(paramInt)).getAdSpaceLayout().getFormat().toString().equals("banner");
                  }
                }
                if (bool1) {
                  try
                  {
                    l = Long.parseLong((String)paramaf.bv.get("delay"));
                    paramFlurryAds.a(l * 1000L);
                    return;
                  }
                  catch (NumberFormatException localNumberFormatException)
                  {
                    for (;;)
                    {
                      new StringBuilder().append("caught NumberFormatException with delay parameter in nextAdUnit:").append((String)paramaf.bv.get("delay")).toString();
                      long l = 30L;
                    }
                  }
                }
              }
              if (paramFlurryAds != null)
              {
                paramFlurryAds.post(new cp(this, localNumberFormatException, (String)localObject3, paramFlurryAds));
                return;
              }
              if (paramaf.bw.eW.equals("renderFailed"))
              {
                c(localNumberFormatException, (String)localObject3);
                return;
              }
              this.cY = l((String)localObject3);
              a(localNumberFormatException, this.cY);
              return;
            }
            if (!str1.equals("checkCap")) {
              break;
            }
          } while (!paramaf.bv.containsKey("idHash"));
          String str2 = (String)paramaf.bv.get("idHash");
          localObject3 = this.cM.y(str2);
          str1 = "capNotExhausted";
          Object localObject2 = localObject3;
          if (localObject3 != null)
          {
            localObject2 = localObject3;
            if (FlurryFreqCapManager.d(((FlurryFreqCapInfo)localObject3).getExpirationTime()))
            {
              db.f(d, "Discarding expired frequency cap info for idHash=" + str2);
              this.cM.z(str2);
              localObject2 = null;
            }
          }
          localObject3 = str1;
          if (localObject2 != null)
          {
            localObject3 = str1;
            if (((FlurryFreqCapInfo)localObject2).getViews() >= ((FlurryFreqCapInfo)localObject2).getNewCap())
            {
              db.f(d, "Frequency cap exhausted for idHash=" + str2);
              localObject3 = "capExhausted";
            }
          }
          paramFlurryAds.onEvent(new cw((String)localObject3, Collections.emptyMap(), paramaf.bw.J, localAdUnit, localcz, paramaf.bw.eX), this, paramInt + 1);
          return;
          if (!str1.equals("updateViewCount")) {
            break;
          }
        } while (!paramaf.bv.containsKey("idHash"));
        paramaf = (String)paramaf.bv.get("idHash");
        paramaf = this.cM.y(paramaf);
      } while (paramaf == null);
      paramaf.updateViews();
      db.f(d, "updateViewCount:idHash=" + paramaf.getIdHash() + ",newCap=" + paramaf.getNewCap() + ",prevCap=" + paramaf.getPreviousCap() + ",views=" + paramaf.getViews());
    } while (paramaf.getViews() <= paramaf.getNewCap());
    new StringBuilder().append("FlurryAdAction: !! rendering a capped object: ").append(paramaf.getIdHash()).toString();
    return;
    new StringBuilder().append("Unknown action:").append(str1).append(",triggered by:").append(paramaf.bw.eW).toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/FlurryAds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */