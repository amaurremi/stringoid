package com.flurry.sdk;

import com.flurry.org.codehaus.jackson.annotate.JacksonAnnotation;
import com.flurry.org.codehaus.jackson.annotate.JsonAnyGetter;
import com.flurry.org.codehaus.jackson.annotate.JsonAnySetter;
import com.flurry.org.codehaus.jackson.annotate.JsonAutoDetect;
import com.flurry.org.codehaus.jackson.annotate.JsonBackReference;
import com.flurry.org.codehaus.jackson.annotate.JsonCreator;
import com.flurry.org.codehaus.jackson.annotate.JsonGetter;
import com.flurry.org.codehaus.jackson.annotate.JsonIgnore;
import com.flurry.org.codehaus.jackson.annotate.JsonIgnoreProperties;
import com.flurry.org.codehaus.jackson.annotate.JsonIgnoreType;
import com.flurry.org.codehaus.jackson.annotate.JsonManagedReference;
import com.flurry.org.codehaus.jackson.annotate.JsonProperty;
import com.flurry.org.codehaus.jackson.annotate.JsonPropertyOrder;
import com.flurry.org.codehaus.jackson.annotate.JsonRawValue;
import com.flurry.org.codehaus.jackson.annotate.JsonSetter;
import com.flurry.org.codehaus.jackson.annotate.JsonSubTypes;
import com.flurry.org.codehaus.jackson.annotate.JsonSubTypes.Type;
import com.flurry.org.codehaus.jackson.annotate.JsonTypeInfo;
import com.flurry.org.codehaus.jackson.annotate.JsonTypeInfo.As;
import com.flurry.org.codehaus.jackson.annotate.JsonTypeInfo.Id;
import com.flurry.org.codehaus.jackson.annotate.JsonTypeInfo.None;
import com.flurry.org.codehaus.jackson.annotate.JsonTypeName;
import com.flurry.org.codehaus.jackson.annotate.JsonUnwrapped;
import com.flurry.org.codehaus.jackson.annotate.JsonValue;
import com.flurry.org.codehaus.jackson.annotate.JsonWriteNullProperties;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

public class my
        extends iq {
    public iq.a a(mq parammq) {
        JsonManagedReference localJsonManagedReference = (JsonManagedReference) parammq.a(JsonManagedReference.class);
        if (localJsonManagedReference != null) {
            return iq.a.a(localJsonManagedReference.value());
        }
        parammq = (JsonBackReference) parammq.a(JsonBackReference.class);
        if (parammq != null) {
            return iq.a.b(parammq.value());
        }
        return null;
    }

    public kg.a a(mm parammm, kg.a parama) {
        kg localkg = (kg) parammm.a(kg.class);
        if (localkg != null) {
            return localkg.h();
        }
        parammm = (JsonWriteNullProperties) parammm.a(JsonWriteNullProperties.class);
        if (parammm != null) {
            if (parammm.value()) {
                return kg.a.a;
            }
            return kg.a.b;
        }
        return parama;
    }

    public ne<?> a(mn parammn, ne<?> paramne) {
        parammn = (JsonAutoDetect) parammn.a(JsonAutoDetect.class);
        if (parammn == null) {
            return paramne;
        }
        return paramne.a(parammn);
    }

    protected ni<?> a(jn<?> paramjn, mm parammm, sh paramsh) {
        Object localObject2 = null;
        JsonTypeInfo localJsonTypeInfo = (JsonTypeInfo) parammm.a(JsonTypeInfo.class);
        Object localObject1 = (ki) parammm.a(ki.class);
        kh localkh;
        if (localObject1 != null) {
            if (localJsonTypeInfo == null) {
                return null;
            }
            localObject1 = paramjn.d(parammm, ((ki) localObject1).a());
            localkh = (kh) parammm.a(kh.class);
            if (localkh != null) {
                break label205;
            }
        }
        label205:
        for (paramjn = (jn<?>) localObject2; ; paramjn = paramjn.e(parammm, localkh.a())) {
            if (paramjn != null) {
                paramjn.a(paramsh);
            }
            localObject1 = ((ni) localObject1).a(localJsonTypeInfo.use(), paramjn);
            paramsh = localJsonTypeInfo.include();
            paramjn = paramsh;
            if (paramsh == JsonTypeInfo.As.EXTERNAL_PROPERTY) {
                paramjn = paramsh;
                if ((parammm instanceof mn)) {
                    paramjn = JsonTypeInfo.As.PROPERTY;
                }
            }
            paramjn = ((ni) localObject1).a(paramjn).a(localJsonTypeInfo.property());
            parammm = localJsonTypeInfo.defaultImpl();
            if (parammm == JsonTypeInfo.None.class) {
                return paramjn;
            }
            return paramjn.a(parammm);
            if (localJsonTypeInfo == null) {
                return null;
            }
            if (localJsonTypeInfo.use() == JsonTypeInfo.Id.NONE) {
                return c();
            }
            localObject1 = b();
            break;
        }
        return paramjn;
    }

    public ni<?> a(jn<?> paramjn, mn parammn, sh paramsh) {
        return a(paramjn, parammn, paramsh);
    }

    public ni<?> a(jn<?> paramjn, mq parammq, sh paramsh) {
        if (paramsh.f()) {
            return null;
        }
        return a(paramjn, parammq, paramsh);
    }

    public Boolean a(mn parammn) {
        parammn = (kc) parammn.a(kc.class);
        if (parammn == null) {
            return null;
        }
        if (parammn.a()) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public Class<?> a(mm parammm, sh paramsh) {
        parammm = (kg) parammm.a(kg.class);
        if (parammm != null) {
            parammm = parammm.e();
            if (parammm != kl.class) {
                return parammm;
            }
        }
        return null;
    }

    public Class<?> a(mm parammm, sh paramsh, String paramString) {
        parammm = (kd) parammm.a(kd.class);
        if (parammm != null) {
            parammm = parammm.d();
            if (parammm != kl.class) {
                return parammm;
            }
        }
        return null;
    }

    public String a(mt parammt) {
        if (parammt != null) {
            parammt = (JsonProperty) parammt.a(JsonProperty.class);
            if (parammt != null) {
                return parammt.value();
            }
        }
        return null;
    }

    public String a(Enum<?> paramEnum) {
        return paramEnum.name();
    }

    public List<nf> a(mm parammm) {
        parammm = (JsonSubTypes) parammm.a(JsonSubTypes.class);
        if (parammm == null) {
            parammm = null;
            return parammm;
        }
        JsonSubTypes.Type[] arrayOfType = parammm.value();
        ArrayList localArrayList = new ArrayList(arrayOfType.length);
        int j = arrayOfType.length;
        int i = 0;
        for (; ; ) {
            parammm = localArrayList;
            if (i >= j) {
                break;
            }
            parammm = arrayOfType[i];
            localArrayList.add(new nf(parammm.value(), parammm.name()));
            i += 1;
        }
    }

    public boolean a(mo parammo) {
        return m(parammo);
    }

    public boolean a(mp parammp) {
        return m(parammp);
    }

    public boolean a(mr parammr) {
        return m(parammr);
    }

    public boolean a(Annotation paramAnnotation) {
        return paramAnnotation.annotationType().getAnnotation(JacksonAnnotation.class) != null;
    }

    public ni<?> b(jn<?> paramjn, mq parammq, sh paramsh) {
        if (!paramsh.f()) {
            throw new IllegalArgumentException("Must call method with a container type (got " + paramsh + ")");
        }
        return a(paramjn, parammq, paramsh);
    }

    protected nu b() {
        return new nu();
    }

    public Boolean b(mq parammq) {
        parammq = (JsonUnwrapped) parammq.a(JsonUnwrapped.class);
        if ((parammq != null) && (parammq.enabled())) {
            return Boolean.TRUE;
        }
        return null;
    }

    public Class<?> b(mm parammm, sh paramsh) {
        parammm = (kg) parammm.a(kg.class);
        if (parammm != null) {
            parammm = parammm.f();
            if (parammm != kl.class) {
                return parammm;
            }
        }
        return null;
    }

    public Class<?> b(mm parammm, sh paramsh, String paramString) {
        parammm = (kd) parammm.a(kd.class);
        if (parammm != null) {
            parammm = parammm.e();
            if (parammm != kl.class) {
                return parammm;
            }
        }
        return null;
    }

    public Object b(mm parammm) {
        Object localObject = (kg) parammm.a(kg.class);
        if (localObject != null) {
            localObject = ((kg) localObject).a();
            if (localObject != jk.a.class) {
                return localObject;
            }
        }
        localObject = (JsonRawValue) parammm.a(JsonRawValue.class);
        if ((localObject != null) && (((JsonRawValue) localObject).value())) {
            return new ps(parammm.d());
        }
        return null;
    }

    public String b(mn parammn) {
        parammn = (kf) parammn.a(kf.class);
        if (parammn == null) {
            return null;
        }
        return parammn.a();
    }

    public String b(mp parammp) {
        JsonProperty localJsonProperty = (JsonProperty) parammp.a(JsonProperty.class);
        if (localJsonProperty != null) {
            return localJsonProperty.value();
        }
        if ((parammp.b(kg.class)) || (parammp.b(kk.class))) {
            return "";
        }
        return null;
    }

    public String b(mr parammr) {
        Object localObject = (JsonProperty) parammr.a(JsonProperty.class);
        if (localObject != null) {
            return ((JsonProperty) localObject).value();
        }
        localObject = (JsonGetter) parammr.a(JsonGetter.class);
        if (localObject != null) {
            return ((JsonGetter) localObject).value();
        }
        if ((parammr.b(kg.class)) || (parammr.b(kk.class))) {
            return "";
        }
        return null;
    }

    protected nu c() {
        return nu.b();
    }

    public Class<? extends jk<?>> c(mm parammm) {
        parammm = (kg) parammm.a(kg.class);
        if (parammm != null) {
            parammm = parammm.c();
            if (parammm != jk.a.class) {
                return parammm;
            }
        }
        return null;
    }

    public Class<?> c(mm parammm, sh paramsh, String paramString) {
        parammm = (kd) parammm.a(kd.class);
        if (parammm != null) {
            parammm = parammm.f();
            if (parammm != kl.class) {
                return parammm;
            }
        }
        return null;
    }

    public String c(mp parammp) {
        JsonProperty localJsonProperty = (JsonProperty) parammp.a(JsonProperty.class);
        if (localJsonProperty != null) {
            return localJsonProperty.value();
        }
        if ((parammp.b(kd.class)) || (parammp.b(kk.class)) || (parammp.b(JsonBackReference.class)) || (parammp.b(JsonManagedReference.class))) {
            return "";
        }
        return null;
    }

    public boolean c(mq parammq) {
        return m(parammq);
    }

    public boolean c(mr parammr) {
        parammr = (JsonValue) parammr.a(JsonValue.class);
        return (parammr != null) && (parammr.value());
    }

    public String[] c(mn parammn) {
        parammn = (JsonIgnoreProperties) parammn.a(JsonIgnoreProperties.class);
        if (parammn == null) {
            return null;
        }
        return parammn.value();
    }

    public Boolean d(mn parammn) {
        parammn = (JsonIgnoreProperties) parammn.a(JsonIgnoreProperties.class);
        if (parammn == null) {
            return null;
        }
        return Boolean.valueOf(parammn.ignoreUnknown());
    }

    public Class<? extends jk<?>> d(mm parammm) {
        parammm = (kg) parammm.a(kg.class);
        if (parammm != null) {
            parammm = parammm.b();
            if (parammm != jk.a.class) {
                return parammm;
            }
        }
        return null;
    }

    public Object d(mq parammq) {
        Object localObject = (ka) parammq.a(ka.class);
        if (localObject == null) {
            localObject = null;
        }
        String str;
        do {
            return localObject;
            str = ((ka) localObject).a();
            localObject = str;
        } while (str.length() != 0);
        if (!(parammq instanceof mr)) {
            return parammq.d().getName();
        }
        localObject = (mr) parammq;
        if (((mr) localObject).f() == 0) {
            return parammq.d().getName();
        }
        return ((mr) localObject).a(0).getName();
    }

    public String d(mr parammr) {
        Object localObject = (JsonProperty) parammr.a(JsonProperty.class);
        if (localObject != null) {
            return ((JsonProperty) localObject).value();
        }
        localObject = (JsonSetter) parammr.a(JsonSetter.class);
        if (localObject != null) {
            return ((JsonSetter) localObject).value();
        }
        if ((parammr.b(kd.class)) || (parammr.b(kk.class)) || (parammr.b(JsonBackReference.class)) || (parammr.b(JsonManagedReference.class))) {
            return "";
        }
        return null;
    }

    public Boolean e(mn parammn) {
        parammn = (JsonIgnoreType) parammn.a(JsonIgnoreType.class);
        if (parammn == null) {
            return null;
        }
        return Boolean.valueOf(parammn.value());
    }

    public Class<?> e(mm parammm) {
        parammm = (kg) parammm.a(kg.class);
        if (parammm != null) {
            parammm = parammm.d();
            if (parammm != kl.class) {
                return parammm;
            }
        }
        return null;
    }

    public boolean e(mr parammr) {
        return parammr.b(JsonAnySetter.class);
    }

    public kg.b f(mm parammm) {
        parammm = (kg) parammm.a(kg.class);
        if (parammm == null) {
            return null;
        }
        return parammm.g();
    }

    public Object f(mn parammn) {
        parammn = (ke) parammn.a(ke.class);
        if (parammn != null) {
            parammn = parammn.a();
            if (parammn.length() > 0) {
                return parammn;
            }
        }
        return null;
    }

    public boolean f(mr parammr) {
        return parammr.b(JsonAnyGetter.class);
    }

    public String g(mn parammn) {
        parammn = (JsonTypeName) parammn.a(JsonTypeName.class);
        if (parammn == null) {
            return null;
        }
        return parammn.value();
    }

    public Class<?>[] g(mm parammm) {
        parammm = (kk) parammm.a(kk.class);
        if (parammm == null) {
            return null;
        }
        return parammm.a();
    }

    public String[] h(mn parammn) {
        parammn = (JsonPropertyOrder) parammn.a(JsonPropertyOrder.class);
        if (parammn == null) {
            return null;
        }
        return parammn.value();
    }

    public Boolean i(mn parammn) {
        parammn = (JsonPropertyOrder) parammn.a(JsonPropertyOrder.class);
        if (parammn == null) {
            return null;
        }
        return Boolean.valueOf(parammn.alphabetic());
    }

    public Class<? extends jl> i(mm parammm) {
        parammm = (kd) parammm.a(kd.class);
        if (parammm != null) {
            parammm = parammm.c();
            if (parammm != jl.a.class) {
                return parammm;
            }
        }
        return null;
    }

    public Class<? extends jg<?>> j(mm parammm) {
        parammm = (kd) parammm.a(kd.class);
        if (parammm != null) {
            parammm = parammm.b();
            if (parammm != jg.a.class) {
                return parammm;
            }
        }
        return null;
    }

    public Object j(mn parammn) {
        parammn = (kj) parammn.a(kj.class);
        if (parammn == null) {
            return null;
        }
        return parammn.a();
    }

    public boolean k(mm parammm) {
        return parammm.b(JsonCreator.class);
    }

    public Class<? extends jg<?>> l(mm parammm) {
        parammm = (kd) parammm.a(kd.class);
        if (parammm != null) {
            parammm = parammm.a();
            if (parammm != jg.a.class) {
                return parammm;
            }
        }
        return null;
    }

    protected boolean m(mm parammm) {
        parammm = (JsonIgnore) parammm.a(JsonIgnore.class);
        return (parammm != null) && (parammm.value());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/my.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */