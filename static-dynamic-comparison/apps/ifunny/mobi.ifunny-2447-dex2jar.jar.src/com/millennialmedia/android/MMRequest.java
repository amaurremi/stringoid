package com.millennialmedia.android;

import android.location.Location;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class MMRequest {
    public static final String EDUCATION_ASSOCIATES = "associates";
    public static final String EDUCATION_BACHELORS = "bachelors";
    public static final String EDUCATION_DOCTORATE = "doctorate";
    public static final String EDUCATION_HIGH_SCHOOL = "highschool";
    public static final String EDUCATION_IN_COLLEGE = "incollege";
    public static final String EDUCATION_MASTERS = "masters";
    public static final String EDUCATION_OTHER = "other";
    public static final String EDUCATION_SOME_COLLEGE = "somecollege";
    public static final String ETHNICITY_ASIAN = "asian";
    public static final String ETHNICITY_BLACK = "black";
    public static final String ETHNICITY_HISPANIC = "hispanic";
    public static final String ETHNICITY_INDIAN = "indian";
    public static final String ETHNICITY_MIDDLE_EASTERN = "middleeastern";
    public static final String ETHNICITY_NATIVE_AMERICAN = "nativeamerican";
    public static final String ETHNICITY_OTHER = "other";
    public static final String ETHNICITY_PACIFIC_ISLANDER = "pacificislander";
    public static final String ETHNICITY_WHITE = "white";
    public static final String GENDER_FEMALE = "female";
    public static final String GENDER_MALE = "male";
    public static final String GENDER_OTHER = "other";
    public static final String KEY_AGE = "age";
    public static final String KEY_CHILDREN = "children";
    public static final String KEY_EDUCATION = "education";
    public static final String KEY_ETHNICITY = "ethnicity";
    public static final String KEY_GENDER = "gender";
    public static final String KEY_HEIGHT = "hsht";
    public static final String KEY_INCOME = "income";
    public static final String KEY_KEYWORDS = "keywords";
    public static final String KEY_MARITAL_STATUS = "marital";
    public static final String KEY_POLITICS = "politics";
    public static final String KEY_VENDOR = "vendor";
    public static final String KEY_WIDTH = "hswd";
    public static final String KEY_ZIP_CODE = "zip";
    public static final String MARITAL_DIVORCED = "divorced";
    public static final String MARITAL_ENGAGED = "engaged";
    public static final String MARITAL_MARRIED = "married";
    public static final String MARITAL_OTHER = "other";
    public static final String MARITAL_RELATIONSHIP = "relationship";
    public static final String MARITAL_SINGLE = "single";
    static Location l;
    String a = null;
    String b = null;
    String c = null;
    String d = null;
    String e = null;
    String f = null;
    String g = null;
    String h = null;
    String i = null;
    String j = null;
    String k = null;
    private Map<String, String> m = new HashMap();

    static void b(Map<String, String> paramMap) {
        if (l != null) {
            paramMap.put("lat", Double.toString(l.getLatitude()));
            paramMap.put("long", Double.toString(l.getLongitude()));
            if (l.hasAccuracy()) {
                paramMap.put("ha", Float.toString(l.getAccuracy()));
                paramMap.put("va", Float.toString(l.getAccuracy()));
            }
            if (l.hasSpeed()) {
                paramMap.put("spd", Float.toString(l.getSpeed()));
            }
            if (l.hasBearing()) {
                paramMap.put("brg", Float.toString(l.getBearing()));
            }
            if (l.hasAltitude()) {
                paramMap.put("alt", Double.toString(l.getAltitude()));
            }
            paramMap.put("tslr", Long.toString(l.getTime()));
            paramMap.put("loc", "true");
            paramMap.put("lsrc", l.getProvider());
            return;
        }
        paramMap.put("loc", "false");
    }

    public static Location getUserLocation() {
        return l;
    }

    public static void setUserLocation(Location paramLocation) {
        if (paramLocation == null) {
            return;
        }
        l = paramLocation;
    }

    void a(Map<String, String> paramMap) {
        Iterator localIterator = this.m.entrySet().iterator();
        while (localIterator.hasNext()) {
            Map.Entry localEntry = (Map.Entry) localIterator.next();
            paramMap.put(localEntry.getKey(), localEntry.getValue());
        }
        if (this.a != null) {
            paramMap.put("age", this.a);
        }
        if (this.b != null) {
            paramMap.put("children", this.b);
        }
        if (this.c != null) {
            paramMap.put("education", this.c);
        }
        if (this.d != null) {
            paramMap.put("ethnicity", this.d);
        }
        if (this.e != null) {
            paramMap.put("gender", this.e);
        }
        if (this.f != null) {
            paramMap.put("income", this.f);
        }
        if (this.g != null) {
            paramMap.put("keywords", this.g);
        }
        if (this.h != null) {
            paramMap.put("marital", this.h);
        }
        if (this.i != null) {
            paramMap.put("politics", this.i);
        }
        if (this.j != null) {
            paramMap.put("vendor", this.j);
        }
        if (this.k != null) {
            paramMap.put("zip", this.k);
        }
    }

    public MMRequest put(String paramString1, String paramString2) {
        if (paramString1.equals("age")) {
            this.a = paramString2;
            return this;
        }
        if (paramString1.equals("children")) {
            this.b = paramString2;
            return this;
        }
        if (paramString1.equals("education")) {
            this.c = paramString2;
            return this;
        }
        if (paramString1.equals("ethnicity")) {
            this.d = paramString2;
            return this;
        }
        if (paramString1.equals("gender")) {
            this.e = paramString2;
            return this;
        }
        if (paramString1.equals("income")) {
            this.f = paramString2;
            return this;
        }
        if (paramString1.equals("keywords")) {
            this.g = paramString2;
            return this;
        }
        if (paramString1.equals("marital")) {
            this.h = paramString2;
            return this;
        }
        if (paramString1.equals("politics")) {
            this.i = paramString2;
            return this;
        }
        if (paramString1.equals("vendor")) {
            this.j = paramString2;
            return this;
        }
        if (paramString1.equals("zip")) {
            this.k = paramString2;
            return this;
        }
        if (paramString2 != null) {
            this.m.put(paramString1, paramString2);
            return this;
        }
        this.m.remove(paramString1);
        return this;
    }

    public void setAge(String paramString) {
        this.a = paramString;
    }

    public void setChildren(String paramString) {
        this.b = paramString;
    }

    public void setEducation(String paramString) {
        this.c = paramString;
    }

    public void setEthnicity(String paramString) {
        this.d = paramString;
    }

    public void setGender(String paramString) {
        this.e = paramString;
    }

    public void setIncome(String paramString) {
        this.f = paramString;
    }

    public void setKeywords(String paramString) {
        this.g = paramString;
    }

    public void setMarital(String paramString) {
        this.h = paramString;
    }

    public void setMetaValues(Map<String, String> paramMap) {
        if (paramMap == null) {
        }
        for (; ; ) {
            return;
            paramMap = paramMap.entrySet().iterator();
            while (paramMap.hasNext()) {
                Map.Entry localEntry = (Map.Entry) paramMap.next();
                put((String) localEntry.getKey(), (String) localEntry.getValue());
            }
        }
    }

    public void setPolitics(String paramString) {
        this.i = paramString;
    }

    public void setVendor(String paramString) {
        this.j = paramString;
    }

    public void setZip(String paramString) {
        this.k = paramString;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/MMRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */