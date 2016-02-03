package com.mopub.mobileads.util.vast;

import android.content.Context;
import android.view.Display;
import android.view.WindowManager;
import com.mopub.common.CacheService;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.AsyncTasks;
import com.mopub.mobileads.VastVideoDownloadTask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class VastManager
        implements e {
    private static final List<String> a = Arrays.asList(new String[]{"video/mp4", "video/3gpp"});
    private static final List<String> b = Arrays.asList(new String[]{"image/jpeg", "image/png", "image/bmp", "image/gif"});
    private VastManager.VastManagerListener c;
    private VastXmlManagerAggregator d;
    private double e;
    private int f;

    public VastManager(Context paramContext) {
        a(paramContext);
    }

    private double a(int paramInt1, int paramInt2) {
        double d1 = paramInt1 / paramInt2 / this.e;
        double d2 = paramInt1 * paramInt2 / this.f;
        return Math.abs(Math.log(d1)) * 40.0D + Math.abs(Math.log(d2)) * 60.0D;
    }

    private void a(Context paramContext) {
        paramContext = ((WindowManager) paramContext.getSystemService("window")).getDefaultDisplay();
        int j = paramContext.getWidth();
        int k = paramContext.getHeight();
        int i = Math.max(j, k);
        j = Math.min(j, k);
        this.e = (i / j);
        this.f = (j * i);
    }

    private boolean a(VastVideoConfiguration paramVastVideoConfiguration) {
        String str = paramVastVideoConfiguration.getNetworkMediaFileUrl();
        if (CacheService.containsKeyDiskCache(str)) {
            paramVastVideoConfiguration.setDiskMediaFileUrl(CacheService.getFilePathDiskCache(str));
            return true;
        }
        return false;
    }

    private VastVideoConfiguration c(List<b> paramList) {
        VastVideoConfiguration localVastVideoConfiguration = new VastVideoConfiguration();
        ArrayList localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        paramList = paramList.iterator();
        while (paramList.hasNext()) {
            b localb = (b) paramList.next();
            localVastVideoConfiguration.addImpressionTrackers(localb.b());
            localVastVideoConfiguration.addStartTrackers(localb.c());
            localVastVideoConfiguration.addFirstQuartileTrackers(localb.d());
            localVastVideoConfiguration.addMidpointTrackers(localb.e());
            localVastVideoConfiguration.addThirdQuartileTrackers(localb.f());
            localVastVideoConfiguration.addCompleteTrackers(localb.g());
            localVastVideoConfiguration.addClickTrackers(localb.i());
            if (localVastVideoConfiguration.getClickThroughUrl() == null) {
                localVastVideoConfiguration.setClickThroughUrl(localb.h());
            }
            localArrayList1.addAll(localb.j());
            localArrayList2.addAll(localb.k());
        }
        localVastVideoConfiguration.setNetworkMediaFileUrl(a(localArrayList1));
        localVastVideoConfiguration.setVastCompanionAd(b(localArrayList2));
        return localVastVideoConfiguration;
    }

    String a(List<d> paramList) {
        ArrayList localArrayList = new ArrayList(paramList);
        double d1 = Double.POSITIVE_INFINITY;
        paramList = null;
        Iterator localIterator = localArrayList.iterator();
        Object localObject1;
        while (localIterator.hasNext()) {
            Object localObject2 = (d) localIterator.next();
            Object localObject3 = ((d) localObject2).c();
            localObject1 = ((d) localObject2).d();
            if ((!a.contains(localObject3)) || (localObject1 == null)) {
                localIterator.remove();
            } else {
                localObject3 = ((d) localObject2).a();
                localObject2 = ((d) localObject2).b();
                if ((localObject3 != null) && (((Integer) localObject3).intValue() > 0) && (localObject2 != null) && (((Integer) localObject2).intValue() > 0)) {
                    double d2 = a(((Integer) localObject3).intValue(), ((Integer) localObject2).intValue());
                    if (d2 >= d1) {
                        break label200;
                    }
                    paramList = (List<d>) localObject1;
                    d1 = d2;
                }
            }
        }
        label200:
        for (; ; ) {
            break;
            localObject1 = paramList;
            if (paramList == null) {
                localObject1 = paramList;
                if (!localArrayList.isEmpty()) {
                    localObject1 = ((d) localArrayList.get(0)).d();
                }
            }
            return (String) localObject1;
        }
    }

    VastCompanionAd b(List<c> paramList) {
        ArrayList localArrayList = new ArrayList(paramList);
        double d1 = Double.POSITIVE_INFINITY;
        Iterator localIterator = localArrayList.iterator();
        paramList = null;
        while (localIterator.hasNext()) {
            c localc = (c) localIterator.next();
            Object localObject1 = localc.c();
            Object localObject2 = localc.d();
            if ((!b.contains(localObject1)) || (localObject2 == null)) {
                localIterator.remove();
            } else {
                localObject1 = localc.a();
                localObject2 = localc.b();
                if ((localObject1 != null) && (((Integer) localObject1).intValue() > 0) && (localObject2 != null) && (((Integer) localObject2).intValue() > 0)) {
                    double d2 = a(((Integer) localObject1).intValue(), ((Integer) localObject2).intValue());
                    if (d2 >= d1) {
                        break label231;
                    }
                    d1 = d2;
                    paramList = localc;
                }
            }
        }
        label231:
        for (; ; ) {
            break;
            if ((paramList == null) && (!localArrayList.isEmpty())) {
                paramList = (c) localArrayList.get(0);
            }
            for (; ; ) {
                if (paramList != null) {
                    return new VastCompanionAd(paramList.a(), paramList.b(), paramList.d(), paramList.e(), new ArrayList(paramList.f()));
                }
                return null;
            }
        }
    }

    public void cancel() {
        if (this.d != null) {
            this.d.cancel(true);
            this.d = null;
        }
    }

    public void onAggregationComplete(List<b> paramList) {
        this.d = null;
        if (paramList == null) {
            if (this.c != null) {
                this.c.onVastVideoConfigurationPrepared(null);
            }
        }
        do {
            do {
                return;
                paramList = c(paramList);
                if (!a(paramList)) {
                    break;
                }
            } while (this.c == null);
            this.c.onVastVideoConfigurationPrepared(paramList);
            return;
            VastVideoDownloadTask localVastVideoDownloadTask = new VastVideoDownloadTask(new a(this, paramList));
            try {
                AsyncTasks.safeExecuteOnExecutor(localVastVideoDownloadTask, new String[]{paramList.getNetworkMediaFileUrl()});
                return;
            } catch (Exception paramList) {
                MoPubLog.d("Failed to download vast video", paramList);
            }
        } while (this.c == null);
        this.c.onVastVideoConfigurationPrepared(null);
    }

    public void prepareVastVideoConfiguration(String paramString, VastManager.VastManagerListener paramVastManagerListener) {
        if (this.d == null) {
            this.c = paramVastManagerListener;
            this.d = new VastXmlManagerAggregator(this);
        }
        try {
            AsyncTasks.safeExecuteOnExecutor(this.d, new String[]{paramString});
            return;
        } catch (Exception paramString) {
            do {
                MoPubLog.d("Failed to aggregate vast xml", paramString);
            } while (this.c == null);
            this.c.onVastVideoConfigurationPrepared(null);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/util/vast/VastManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */