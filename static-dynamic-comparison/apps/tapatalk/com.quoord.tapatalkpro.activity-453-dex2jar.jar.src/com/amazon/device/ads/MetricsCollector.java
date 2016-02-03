package com.amazon.device.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

class MetricsCollector {
    private String adTypeMetricTag;
    protected Vector<MetricHit> metricHits = new Vector(60);

    public String getAdTypeMetricTag() {
        return this.adTypeMetricTag;
    }

    public Vector<MetricHit> getMetricHits() {
        return this.metricHits;
    }

    public void incrementMetric(Metrics.MetricType paramMetricType) {
        this.metricHits.add(new MetricHitIncrement(paramMetricType, 1));
    }

    public boolean isMetricsCollectorEmpty() {
        return this.metricHits.isEmpty();
    }

    public void publishMetricInMilliseconds(Metrics.MetricType paramMetricType, long paramLong) {
        this.metricHits.add(new MetricHitTotalTime(paramMetricType, paramLong));
    }

    public void publishMetricInMillisecondsFromNanoseconds(Metrics.MetricType paramMetricType, long paramLong) {
        publishMetricInMilliseconds(paramMetricType, Utils.convertToMillisecondsFromNanoseconds(paramLong));
    }

    public void setAdType(AdProperties.AdType paramAdType) {
        this.adTypeMetricTag = paramAdType.getAdTypeMetricTag();
    }

    public void setMetricString(Metrics.MetricType paramMetricType, String paramString) {
        this.metricHits.add(new MetricHitString(paramMetricType, paramString));
    }

    public void startMetric(Metrics.MetricType paramMetricType) {
        startMetricInMillisecondsFromNanoseconds(paramMetricType, System.nanoTime());
    }

    public void startMetricInMillisecondsFromNanoseconds(Metrics.MetricType paramMetricType, long paramLong) {
        paramLong = Utils.convertToMillisecondsFromNanoseconds(paramLong);
        this.metricHits.add(new MetricHitStartTime(paramMetricType, paramLong));
    }

    public void stopMetric(Metrics.MetricType paramMetricType) {
        stopMetricInMillisecondsFromNanoseconds(paramMetricType, System.nanoTime());
    }

    public void stopMetricInMillisecondsFromNanoseconds(Metrics.MetricType paramMetricType, long paramLong) {
        paramLong = Utils.convertToMillisecondsFromNanoseconds(paramLong);
        this.metricHits.add(new MetricHitStopTime(paramMetricType, paramLong));
    }

    static class CompositeMetricsCollector
            extends MetricsCollector {
        private final ArrayList<MetricsCollector> collectors;

        public CompositeMetricsCollector(ArrayList<MetricsCollector> paramArrayList) {
            this.collectors = paramArrayList;
        }

        public void incrementMetric(Metrics.MetricType paramMetricType) {
            Iterator localIterator = this.collectors.iterator();
            while (localIterator.hasNext()) {
                ((MetricsCollector) localIterator.next()).incrementMetric(paramMetricType);
            }
        }

        public void publishMetricInMilliseconds(Metrics.MetricType paramMetricType, long paramLong) {
            Iterator localIterator = this.collectors.iterator();
            while (localIterator.hasNext()) {
                ((MetricsCollector) localIterator.next()).publishMetricInMilliseconds(paramMetricType, paramLong);
            }
        }

        public void publishMetricInMillisecondsFromNanoseconds(Metrics.MetricType paramMetricType, long paramLong) {
            Iterator localIterator = this.collectors.iterator();
            while (localIterator.hasNext()) {
                ((MetricsCollector) localIterator.next()).publishMetricInMillisecondsFromNanoseconds(paramMetricType, paramLong);
            }
        }

        public void setMetricString(Metrics.MetricType paramMetricType, String paramString) {
            Iterator localIterator = this.collectors.iterator();
            while (localIterator.hasNext()) {
                ((MetricsCollector) localIterator.next()).setMetricString(paramMetricType, paramString);
            }
        }

        public void startMetric(Metrics.MetricType paramMetricType) {
            Iterator localIterator = this.collectors.iterator();
            while (localIterator.hasNext()) {
                ((MetricsCollector) localIterator.next()).startMetric(paramMetricType);
            }
        }

        public void startMetricInMillisecondsFromNanoseconds(Metrics.MetricType paramMetricType, long paramLong) {
            Iterator localIterator = this.collectors.iterator();
            while (localIterator.hasNext()) {
                ((MetricsCollector) localIterator.next()).startMetricInMillisecondsFromNanoseconds(paramMetricType, paramLong);
            }
        }

        public void stopMetric(Metrics.MetricType paramMetricType) {
            Iterator localIterator = this.collectors.iterator();
            while (localIterator.hasNext()) {
                ((MetricsCollector) localIterator.next()).stopMetric(paramMetricType);
            }
        }

        public void stopMetricInMillisecondsFromNanoseconds(Metrics.MetricType paramMetricType, long paramLong) {
            Iterator localIterator = this.collectors.iterator();
            while (localIterator.hasNext()) {
                ((MetricsCollector) localIterator.next()).stopMetricInMillisecondsFromNanoseconds(paramMetricType, paramLong);
            }
        }
    }

    static class MetricHit {
        public final Metrics.MetricType metric;

        public MetricHit(Metrics.MetricType paramMetricType) {
            this.metric = paramMetricType;
        }
    }

    static class MetricHitIncrement
            extends MetricsCollector.MetricHit {
        public final int increment;

        public MetricHitIncrement(Metrics.MetricType paramMetricType, int paramInt) {
            super();
            this.increment = paramInt;
        }
    }

    static class MetricHitStartTime
            extends MetricsCollector.MetricHit {
        public final long startTime;

        public MetricHitStartTime(Metrics.MetricType paramMetricType, long paramLong) {
            super();
            this.startTime = paramLong;
        }
    }

    static class MetricHitStopTime
            extends MetricsCollector.MetricHit {
        public final long stopTime;

        public MetricHitStopTime(Metrics.MetricType paramMetricType, long paramLong) {
            super();
            this.stopTime = paramLong;
        }
    }

    static class MetricHitString
            extends MetricsCollector.MetricHit {
        public final String text;

        public MetricHitString(Metrics.MetricType paramMetricType, String paramString) {
            super();
            this.text = paramString;
        }
    }

    static class MetricHitTotalTime
            extends MetricsCollector.MetricHit {
        public final long totalTime;

        public MetricHitTotalTime(Metrics.MetricType paramMetricType, long paramLong) {
            super();
            this.totalTime = paramLong;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/MetricsCollector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */