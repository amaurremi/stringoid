package com.google.android.gms.analytics;

import android.text.TextUtils;

import java.util.HashMap;
import java.util.Map;

public class HitBuilders {
    @Deprecated
    public static class AppViewBuilder
            extends HitBuilders.HitBuilder<AppViewBuilder> {
        public AppViewBuilder() {
            u.cy().a(u.a.uS);
            set("&t", "appview");
        }
    }

    public static class EventBuilder
            extends HitBuilders.HitBuilder<EventBuilder> {
        public EventBuilder() {
            u.cy().a(u.a.uG);
            set("&t", "event");
        }

        public EventBuilder(String paramString1, String paramString2) {
            this();
            setCategory(paramString1);
            setAction(paramString2);
        }

        public EventBuilder setAction(String paramString) {
            set("&ea", paramString);
            return this;
        }

        public EventBuilder setCategory(String paramString) {
            set("&ec", paramString);
            return this;
        }

        public EventBuilder setLabel(String paramString) {
            set("&el", paramString);
            return this;
        }

        public EventBuilder setValue(long paramLong) {
            set("&ev", Long.toString(paramLong));
            return this;
        }
    }

    public static class ExceptionBuilder
            extends HitBuilders.HitBuilder<ExceptionBuilder> {
        public ExceptionBuilder() {
            u.cy().a(u.a.up);
            set("&t", "exception");
        }

        public ExceptionBuilder setDescription(String paramString) {
            set("&exd", paramString);
            return this;
        }

        public ExceptionBuilder setFatal(boolean paramBoolean) {
            set("&exf", ak.u(paramBoolean));
            return this;
        }
    }

    protected static class HitBuilder<T extends HitBuilder> {
        private Map<String, String> vl = new HashMap();

        public Map<String, String> build() {
            return this.vl;
        }

        protected String get(String paramString) {
            return (String) this.vl.get(paramString);
        }

        public final T set(String paramString1, String paramString2) {
            u.cy().a(u.a.tI);
            if (paramString1 != null) {
                this.vl.put(paramString1, paramString2);
                return this;
            }
            aa.z(" HitBuilder.set() called with a null paramName.");
            return this;
        }

        public final T setAll(Map<String, String> paramMap) {
            u.cy().a(u.a.tJ);
            if (paramMap == null) {
                return this;
            }
            this.vl.putAll(new HashMap(paramMap));
            return this;
        }

        public T setCampaignParamsFromUrl(String paramString) {
            u.cy().a(u.a.tL);
            paramString = ak.O(paramString);
            if (TextUtils.isEmpty(paramString)) {
                return this;
            }
            paramString = ak.N(paramString);
            set("&cc", (String) paramString.get("utm_content"));
            set("&cm", (String) paramString.get("utm_medium"));
            set("&cn", (String) paramString.get("utm_campaign"));
            set("&cs", (String) paramString.get("utm_source"));
            set("&ck", (String) paramString.get("utm_term"));
            set("&ci", (String) paramString.get("utm_id"));
            set("&gclid", (String) paramString.get("gclid"));
            set("&dclid", (String) paramString.get("dclid"));
            set("&gmob_t", (String) paramString.get("gmob_t"));
            return this;
        }

        public T setCustomDimension(int paramInt, String paramString) {
            set(o.q(paramInt), paramString);
            return this;
        }

        public T setCustomMetric(int paramInt, float paramFloat) {
            set(o.r(paramInt), Float.toString(paramFloat));
            return this;
        }

        protected T setHitType(String paramString) {
            set("&t", paramString);
            return this;
        }

        public T setNewSession() {
            set("&sc", "start");
            return this;
        }

        public T setNonInteraction(boolean paramBoolean) {
            set("&ni", ak.u(paramBoolean));
            return this;
        }
    }

    public static class ItemBuilder
            extends HitBuilders.HitBuilder<ItemBuilder> {
        public ItemBuilder() {
            u.cy().a(u.a.uH);
            set("&t", "item");
        }

        public ItemBuilder setCategory(String paramString) {
            set("&iv", paramString);
            return this;
        }

        public ItemBuilder setCurrencyCode(String paramString) {
            set("&cu", paramString);
            return this;
        }

        public ItemBuilder setName(String paramString) {
            set("&in", paramString);
            return this;
        }

        public ItemBuilder setPrice(double paramDouble) {
            set("&ip", Double.toString(paramDouble));
            return this;
        }

        public ItemBuilder setQuantity(long paramLong) {
            set("&iq", Long.toString(paramLong));
            return this;
        }

        public ItemBuilder setSku(String paramString) {
            set("&ic", paramString);
            return this;
        }

        public ItemBuilder setTransactionId(String paramString) {
            set("&ti", paramString);
            return this;
        }
    }

    public static class ScreenViewBuilder
            extends HitBuilders.HitBuilder<ScreenViewBuilder> {
        public ScreenViewBuilder() {
            u.cy().a(u.a.uS);
            set("&t", "appview");
        }
    }

    public static class SocialBuilder
            extends HitBuilders.HitBuilder<SocialBuilder> {
        public SocialBuilder() {
            u.cy().a(u.a.us);
            set("&t", "social");
        }

        public SocialBuilder setAction(String paramString) {
            set("&sa", paramString);
            return this;
        }

        public SocialBuilder setNetwork(String paramString) {
            set("&sn", paramString);
            return this;
        }

        public SocialBuilder setTarget(String paramString) {
            set("&st", paramString);
            return this;
        }
    }

    public static class TimingBuilder
            extends HitBuilders.HitBuilder<TimingBuilder> {
        public TimingBuilder() {
            u.cy().a(u.a.ur);
            set("&t", "timing");
        }

        public TimingBuilder(String paramString1, String paramString2, long paramLong) {
            this();
            setVariable(paramString2);
            setValue(paramLong);
            setCategory(paramString1);
        }

        public TimingBuilder setCategory(String paramString) {
            set("&utc", paramString);
            return this;
        }

        public TimingBuilder setLabel(String paramString) {
            set("&utl", paramString);
            return this;
        }

        public TimingBuilder setValue(long paramLong) {
            set("&utt", Long.toString(paramLong));
            return this;
        }

        public TimingBuilder setVariable(String paramString) {
            set("&utv", paramString);
            return this;
        }
    }

    public static class TransactionBuilder
            extends HitBuilders.HitBuilder<TransactionBuilder> {
        public TransactionBuilder() {
            u.cy().a(u.a.uo);
            set("&t", "transaction");
        }

        public TransactionBuilder setAffiliation(String paramString) {
            set("&ta", paramString);
            return this;
        }

        public TransactionBuilder setCurrencyCode(String paramString) {
            set("&cu", paramString);
            return this;
        }

        public TransactionBuilder setRevenue(double paramDouble) {
            set("&tr", Double.toString(paramDouble));
            return this;
        }

        public TransactionBuilder setShipping(double paramDouble) {
            set("&ts", Double.toString(paramDouble));
            return this;
        }

        public TransactionBuilder setTax(double paramDouble) {
            set("&tt", Double.toString(paramDouble));
            return this;
        }

        public TransactionBuilder setTransactionId(String paramString) {
            set("&ti", paramString);
            return this;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/analytics/HitBuilders.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */