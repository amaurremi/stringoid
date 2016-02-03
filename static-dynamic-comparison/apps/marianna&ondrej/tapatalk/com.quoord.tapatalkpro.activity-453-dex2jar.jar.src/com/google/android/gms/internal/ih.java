package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.Person.AgeRange;
import com.google.android.gms.plus.model.people.Person.Cover;
import com.google.android.gms.plus.model.people.Person.Cover.CoverInfo;
import com.google.android.gms.plus.model.people.Person.Cover.CoverPhoto;
import com.google.android.gms.plus.model.people.Person.Image;
import com.google.android.gms.plus.model.people.Person.Name;
import com.google.android.gms.plus.model.people.Person.Organizations;
import com.google.android.gms.plus.model.people.Person.PlacesLived;
import com.google.android.gms.plus.model.people.Person.Urls;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class ih
        extends ga
        implements SafeParcelable, Person {
    public static final ii CREATOR = new ii();
    private static final HashMap<String, ga.a<?, ?>> UI = new HashMap();
    private String HA;
    private final Set<Integer> UJ;
    private String VH;
    private a VI;
    private String VJ;
    private String VK;
    private int VL;
    private b VM;
    private String VN;
    private c VO;
    private boolean VP;
    private String VQ;
    private d VR;
    private String VS;
    private int VT;
    private List<f> VU;
    private List<g> VV;
    private int VW;
    private int VX;
    private String VY;
    private List<h> VZ;
    private boolean Wa;
    private int lZ;
    private String ro;
    private String wp;
    private final int xH;

    static {
        UI.put("aboutMe", ga.a.j("aboutMe", 2));
        UI.put("ageRange", ga.a.a("ageRange", 3, a.class));
        UI.put("birthday", ga.a.j("birthday", 4));
        UI.put("braggingRights", ga.a.j("braggingRights", 5));
        UI.put("circledByCount", ga.a.g("circledByCount", 6));
        UI.put("cover", ga.a.a("cover", 7, b.class));
        UI.put("currentLocation", ga.a.j("currentLocation", 8));
        UI.put("displayName", ga.a.j("displayName", 9));
        UI.put("gender", ga.a.a("gender", 12, new fx().f("male", 0).f("female", 1).f("other", 2), false));
        UI.put("id", ga.a.j("id", 14));
        UI.put("image", ga.a.a("image", 15, c.class));
        UI.put("isPlusUser", ga.a.i("isPlusUser", 16));
        UI.put("language", ga.a.j("language", 18));
        UI.put("name", ga.a.a("name", 19, d.class));
        UI.put("nickname", ga.a.j("nickname", 20));
        UI.put("objectType", ga.a.a("objectType", 21, new fx().f("person", 0).f("page", 1), false));
        UI.put("organizations", ga.a.b("organizations", 22, f.class));
        UI.put("placesLived", ga.a.b("placesLived", 23, g.class));
        UI.put("plusOneCount", ga.a.g("plusOneCount", 24));
        UI.put("relationshipStatus", ga.a.a("relationshipStatus", 25, new fx().f("single", 0).f("in_a_relationship", 1).f("engaged", 2).f("married", 3).f("its_complicated", 4).f("open_relationship", 5).f("widowed", 6).f("in_domestic_partnership", 7).f("in_civil_union", 8), false));
        UI.put("tagline", ga.a.j("tagline", 26));
        UI.put("url", ga.a.j("url", 27));
        UI.put("urls", ga.a.b("urls", 28, h.class));
        UI.put("verified", ga.a.i("verified", 29));
    }

    public ih() {
        this.xH = 2;
        this.UJ = new HashSet();
    }

    public ih(String paramString1, String paramString2, c paramc, int paramInt, String paramString3) {
        this.xH = 2;
        this.UJ = new HashSet();
        this.HA = paramString1;
        this.UJ.add(Integer.valueOf(9));
        this.wp = paramString2;
        this.UJ.add(Integer.valueOf(14));
        this.VO = paramc;
        this.UJ.add(Integer.valueOf(15));
        this.VT = paramInt;
        this.UJ.add(Integer.valueOf(21));
        this.ro = paramString3;
        this.UJ.add(Integer.valueOf(27));
    }

    ih(Set<Integer> paramSet, int paramInt1, String paramString1, a parama, String paramString2, String paramString3, int paramInt2, b paramb, String paramString4, String paramString5, int paramInt3, String paramString6, c paramc, boolean paramBoolean1, String paramString7, d paramd, String paramString8, int paramInt4, List<f> paramList, List<g> paramList1, int paramInt5, int paramInt6, String paramString9, String paramString10, List<h> paramList2, boolean paramBoolean2) {
        this.UJ = paramSet;
        this.xH = paramInt1;
        this.VH = paramString1;
        this.VI = parama;
        this.VJ = paramString2;
        this.VK = paramString3;
        this.VL = paramInt2;
        this.VM = paramb;
        this.VN = paramString4;
        this.HA = paramString5;
        this.lZ = paramInt3;
        this.wp = paramString6;
        this.VO = paramc;
        this.VP = paramBoolean1;
        this.VQ = paramString7;
        this.VR = paramd;
        this.VS = paramString8;
        this.VT = paramInt4;
        this.VU = paramList;
        this.VV = paramList1;
        this.VW = paramInt5;
        this.VX = paramInt6;
        this.VY = paramString9;
        this.ro = paramString10;
        this.VZ = paramList2;
        this.Wa = paramBoolean2;
    }

    public static ih i(byte[] paramArrayOfByte) {
        Parcel localParcel = Parcel.obtain();
        localParcel.unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
        localParcel.setDataPosition(0);
        paramArrayOfByte = CREATOR.aN(localParcel);
        localParcel.recycle();
        return paramArrayOfByte;
    }

    protected boolean a(ga.a parama) {
        return this.UJ.contains(Integer.valueOf(parama.ff()));
    }

    protected Object aq(String paramString) {
        return null;
    }

    protected boolean ar(String paramString) {
        return false;
    }

    protected Object b(ga.a parama) {
        switch (parama.ff()) {
            case 10:
            case 11:
            case 13:
            case 17:
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + parama.ff());
            case 2:
                return this.VH;
            case 3:
                return this.VI;
            case 4:
                return this.VJ;
            case 5:
                return this.VK;
            case 6:
                return Integer.valueOf(this.VL);
            case 7:
                return this.VM;
            case 8:
                return this.VN;
            case 9:
                return this.HA;
            case 12:
                return Integer.valueOf(this.lZ);
            case 14:
                return this.wp;
            case 15:
                return this.VO;
            case 16:
                return Boolean.valueOf(this.VP);
            case 18:
                return this.VQ;
            case 19:
                return this.VR;
            case 20:
                return this.VS;
            case 21:
                return Integer.valueOf(this.VT);
            case 22:
                return this.VU;
            case 23:
                return this.VV;
            case 24:
                return Integer.valueOf(this.VW);
            case 25:
                return Integer.valueOf(this.VX);
            case 26:
                return this.VY;
            case 27:
                return this.ro;
            case 28:
                return this.VZ;
        }
        return Boolean.valueOf(this.Wa);
    }

    public int describeContents() {
        ii localii = CREATOR;
        return 0;
    }

    public HashMap<String, ga.a<?, ?>> eY() {
        return UI;
    }

    public boolean equals(Object paramObject) {
        if (!(paramObject instanceof ih)) {
            return false;
        }
        if (this == paramObject) {
            return true;
        }
        paramObject = (ih) paramObject;
        Iterator localIterator = UI.values().iterator();
        while (localIterator.hasNext()) {
            ga.a locala = (ga.a) localIterator.next();
            if (a(locala)) {
                if (((ih) paramObject).a(locala)) {
                    if (!b(locala).equals(((ih) paramObject).b(locala))) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else if (((ih) paramObject).a(locala)) {
                return false;
            }
        }
        return true;
    }

    public String getAboutMe() {
        return this.VH;
    }

    public Person.AgeRange getAgeRange() {
        return this.VI;
    }

    public String getBirthday() {
        return this.VJ;
    }

    public String getBraggingRights() {
        return this.VK;
    }

    public int getCircledByCount() {
        return this.VL;
    }

    public Person.Cover getCover() {
        return this.VM;
    }

    public String getCurrentLocation() {
        return this.VN;
    }

    public String getDisplayName() {
        return this.HA;
    }

    public int getGender() {
        return this.lZ;
    }

    public String getId() {
        return this.wp;
    }

    public Person.Image getImage() {
        return this.VO;
    }

    public String getLanguage() {
        return this.VQ;
    }

    public Person.Name getName() {
        return this.VR;
    }

    public String getNickname() {
        return this.VS;
    }

    public int getObjectType() {
        return this.VT;
    }

    public List<Person.Organizations> getOrganizations() {
        return (ArrayList) this.VU;
    }

    public List<Person.PlacesLived> getPlacesLived() {
        return (ArrayList) this.VV;
    }

    public int getPlusOneCount() {
        return this.VW;
    }

    public int getRelationshipStatus() {
        return this.VX;
    }

    public String getTagline() {
        return this.VY;
    }

    public String getUrl() {
        return this.ro;
    }

    public List<Person.Urls> getUrls() {
        return (ArrayList) this.VZ;
    }

    int getVersionCode() {
        return this.xH;
    }

    public boolean hasAboutMe() {
        return this.UJ.contains(Integer.valueOf(2));
    }

    public boolean hasAgeRange() {
        return this.UJ.contains(Integer.valueOf(3));
    }

    public boolean hasBirthday() {
        return this.UJ.contains(Integer.valueOf(4));
    }

    public boolean hasBraggingRights() {
        return this.UJ.contains(Integer.valueOf(5));
    }

    public boolean hasCircledByCount() {
        return this.UJ.contains(Integer.valueOf(6));
    }

    public boolean hasCover() {
        return this.UJ.contains(Integer.valueOf(7));
    }

    public boolean hasCurrentLocation() {
        return this.UJ.contains(Integer.valueOf(8));
    }

    public boolean hasDisplayName() {
        return this.UJ.contains(Integer.valueOf(9));
    }

    public boolean hasGender() {
        return this.UJ.contains(Integer.valueOf(12));
    }

    public boolean hasId() {
        return this.UJ.contains(Integer.valueOf(14));
    }

    public boolean hasImage() {
        return this.UJ.contains(Integer.valueOf(15));
    }

    public boolean hasIsPlusUser() {
        return this.UJ.contains(Integer.valueOf(16));
    }

    public boolean hasLanguage() {
        return this.UJ.contains(Integer.valueOf(18));
    }

    public boolean hasName() {
        return this.UJ.contains(Integer.valueOf(19));
    }

    public boolean hasNickname() {
        return this.UJ.contains(Integer.valueOf(20));
    }

    public boolean hasObjectType() {
        return this.UJ.contains(Integer.valueOf(21));
    }

    public boolean hasOrganizations() {
        return this.UJ.contains(Integer.valueOf(22));
    }

    public boolean hasPlacesLived() {
        return this.UJ.contains(Integer.valueOf(23));
    }

    public boolean hasPlusOneCount() {
        return this.UJ.contains(Integer.valueOf(24));
    }

    public boolean hasRelationshipStatus() {
        return this.UJ.contains(Integer.valueOf(25));
    }

    public boolean hasTagline() {
        return this.UJ.contains(Integer.valueOf(26));
    }

    public boolean hasUrl() {
        return this.UJ.contains(Integer.valueOf(27));
    }

    public boolean hasUrls() {
        return this.UJ.contains(Integer.valueOf(28));
    }

    public boolean hasVerified() {
        return this.UJ.contains(Integer.valueOf(29));
    }

    public int hashCode() {
        Iterator localIterator = UI.values().iterator();
        int i = 0;
        if (localIterator.hasNext()) {
            ga.a locala = (ga.a) localIterator.next();
            if (!a(locala)) {
                break label68;
            }
            int j = locala.ff();
            i = b(locala).hashCode() + (i + j);
        }
        label68:
        for (; ; ) {
            break;
            return i;
        }
    }

    public boolean isDataValid() {
        return true;
    }

    public boolean isPlusUser() {
        return this.VP;
    }

    public boolean isVerified() {
        return this.Wa;
    }

    List<g> jA() {
        return this.VV;
    }

    List<h> jB() {
        return this.VZ;
    }

    public ih jC() {
        return this;
    }

    Set<Integer> ja() {
        return this.UJ;
    }

    a jv() {
        return this.VI;
    }

    b jw() {
        return this.VM;
    }

    c jx() {
        return this.VO;
    }

    d jy() {
        return this.VR;
    }

    List<f> jz() {
        return this.VU;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        ii localii = CREATOR;
        ii.a(this, paramParcel, paramInt);
    }

    public static final class a
            extends ga
            implements SafeParcelable, Person.AgeRange {
        public static final ij CREATOR = new ij();
        private static final HashMap<String, ga.a<?, ?>> UI = new HashMap();
        private final Set<Integer> UJ;
        private int Wb;
        private int Wc;
        private final int xH;

        static {
            UI.put("max", ga.a.g("max", 2));
            UI.put("min", ga.a.g("min", 3));
        }

        public a() {
            this.xH = 1;
            this.UJ = new HashSet();
        }

        a(Set<Integer> paramSet, int paramInt1, int paramInt2, int paramInt3) {
            this.UJ = paramSet;
            this.xH = paramInt1;
            this.Wb = paramInt2;
            this.Wc = paramInt3;
        }

        protected boolean a(ga.a parama) {
            return this.UJ.contains(Integer.valueOf(parama.ff()));
        }

        protected Object aq(String paramString) {
            return null;
        }

        protected boolean ar(String paramString) {
            return false;
        }

        protected Object b(ga.a parama) {
            switch (parama.ff()) {
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + parama.ff());
                case 2:
                    return Integer.valueOf(this.Wb);
            }
            return Integer.valueOf(this.Wc);
        }

        public int describeContents() {
            ij localij = CREATOR;
            return 0;
        }

        public HashMap<String, ga.a<?, ?>> eY() {
            return UI;
        }

        public boolean equals(Object paramObject) {
            if (!(paramObject instanceof a)) {
                return false;
            }
            if (this == paramObject) {
                return true;
            }
            paramObject = (a) paramObject;
            Iterator localIterator = UI.values().iterator();
            while (localIterator.hasNext()) {
                ga.a locala = (ga.a) localIterator.next();
                if (a(locala)) {
                    if (((a) paramObject).a(locala)) {
                        if (!b(locala).equals(((a) paramObject).b(locala))) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                } else if (((a) paramObject).a(locala)) {
                    return false;
                }
            }
            return true;
        }

        public int getMax() {
            return this.Wb;
        }

        public int getMin() {
            return this.Wc;
        }

        int getVersionCode() {
            return this.xH;
        }

        public boolean hasMax() {
            return this.UJ.contains(Integer.valueOf(2));
        }

        public boolean hasMin() {
            return this.UJ.contains(Integer.valueOf(3));
        }

        public int hashCode() {
            Iterator localIterator = UI.values().iterator();
            int i = 0;
            if (localIterator.hasNext()) {
                ga.a locala = (ga.a) localIterator.next();
                if (!a(locala)) {
                    break label68;
                }
                int j = locala.ff();
                i = b(locala).hashCode() + (i + j);
            }
            label68:
            for (; ; ) {
                break;
                return i;
            }
        }

        public boolean isDataValid() {
            return true;
        }

        public a jD() {
            return this;
        }

        Set<Integer> ja() {
            return this.UJ;
        }

        public void writeToParcel(Parcel paramParcel, int paramInt) {
            ij localij = CREATOR;
            ij.a(this, paramParcel, paramInt);
        }
    }

    public static final class b
            extends ga
            implements SafeParcelable, Person.Cover {
        public static final ik CREATOR = new ik();
        private static final HashMap<String, ga.a<?, ?>> UI = new HashMap();
        private final Set<Integer> UJ;
        private a Wd;
        private b We;
        private int Wf;
        private final int xH;

        static {
            UI.put("coverInfo", ga.a.a("coverInfo", 2, a.class));
            UI.put("coverPhoto", ga.a.a("coverPhoto", 3, b.class));
            UI.put("layout", ga.a.a("layout", 4, new fx().f("banner", 0), false));
        }

        public b() {
            this.xH = 1;
            this.UJ = new HashSet();
        }

        b(Set<Integer> paramSet, int paramInt1, a parama, b paramb, int paramInt2) {
            this.UJ = paramSet;
            this.xH = paramInt1;
            this.Wd = parama;
            this.We = paramb;
            this.Wf = paramInt2;
        }

        protected boolean a(ga.a parama) {
            return this.UJ.contains(Integer.valueOf(parama.ff()));
        }

        protected Object aq(String paramString) {
            return null;
        }

        protected boolean ar(String paramString) {
            return false;
        }

        protected Object b(ga.a parama) {
            switch (parama.ff()) {
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + parama.ff());
                case 2:
                    return this.Wd;
                case 3:
                    return this.We;
            }
            return Integer.valueOf(this.Wf);
        }

        public int describeContents() {
            ik localik = CREATOR;
            return 0;
        }

        public HashMap<String, ga.a<?, ?>> eY() {
            return UI;
        }

        public boolean equals(Object paramObject) {
            if (!(paramObject instanceof b)) {
                return false;
            }
            if (this == paramObject) {
                return true;
            }
            paramObject = (b) paramObject;
            Iterator localIterator = UI.values().iterator();
            while (localIterator.hasNext()) {
                ga.a locala = (ga.a) localIterator.next();
                if (a(locala)) {
                    if (((b) paramObject).a(locala)) {
                        if (!b(locala).equals(((b) paramObject).b(locala))) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                } else if (((b) paramObject).a(locala)) {
                    return false;
                }
            }
            return true;
        }

        public Person.Cover.CoverInfo getCoverInfo() {
            return this.Wd;
        }

        public Person.Cover.CoverPhoto getCoverPhoto() {
            return this.We;
        }

        public int getLayout() {
            return this.Wf;
        }

        int getVersionCode() {
            return this.xH;
        }

        public boolean hasCoverInfo() {
            return this.UJ.contains(Integer.valueOf(2));
        }

        public boolean hasCoverPhoto() {
            return this.UJ.contains(Integer.valueOf(3));
        }

        public boolean hasLayout() {
            return this.UJ.contains(Integer.valueOf(4));
        }

        public int hashCode() {
            Iterator localIterator = UI.values().iterator();
            int i = 0;
            if (localIterator.hasNext()) {
                ga.a locala = (ga.a) localIterator.next();
                if (!a(locala)) {
                    break label68;
                }
                int j = locala.ff();
                i = b(locala).hashCode() + (i + j);
            }
            label68:
            for (; ; ) {
                break;
                return i;
            }
        }

        public boolean isDataValid() {
            return true;
        }

        a jE() {
            return this.Wd;
        }

        b jF() {
            return this.We;
        }

        public b jG() {
            return this;
        }

        Set<Integer> ja() {
            return this.UJ;
        }

        public void writeToParcel(Parcel paramParcel, int paramInt) {
            ik localik = CREATOR;
            ik.a(this, paramParcel, paramInt);
        }

        public static final class a
                extends ga
                implements SafeParcelable, Person.Cover.CoverInfo {
            public static final il CREATOR = new il();
            private static final HashMap<String, ga.a<?, ?>> UI = new HashMap();
            private final Set<Integer> UJ;
            private int Wg;
            private int Wh;
            private final int xH;

            static {
                UI.put("leftImageOffset", ga.a.g("leftImageOffset", 2));
                UI.put("topImageOffset", ga.a.g("topImageOffset", 3));
            }

            public a() {
                this.xH = 1;
                this.UJ = new HashSet();
            }

            a(Set<Integer> paramSet, int paramInt1, int paramInt2, int paramInt3) {
                this.UJ = paramSet;
                this.xH = paramInt1;
                this.Wg = paramInt2;
                this.Wh = paramInt3;
            }

            protected boolean a(ga.a parama) {
                return this.UJ.contains(Integer.valueOf(parama.ff()));
            }

            protected Object aq(String paramString) {
                return null;
            }

            protected boolean ar(String paramString) {
                return false;
            }

            protected Object b(ga.a parama) {
                switch (parama.ff()) {
                    default:
                        throw new IllegalStateException("Unknown safe parcelable id=" + parama.ff());
                    case 2:
                        return Integer.valueOf(this.Wg);
                }
                return Integer.valueOf(this.Wh);
            }

            public int describeContents() {
                il localil = CREATOR;
                return 0;
            }

            public HashMap<String, ga.a<?, ?>> eY() {
                return UI;
            }

            public boolean equals(Object paramObject) {
                if (!(paramObject instanceof a)) {
                    return false;
                }
                if (this == paramObject) {
                    return true;
                }
                paramObject = (a) paramObject;
                Iterator localIterator = UI.values().iterator();
                while (localIterator.hasNext()) {
                    ga.a locala = (ga.a) localIterator.next();
                    if (a(locala)) {
                        if (((a) paramObject).a(locala)) {
                            if (!b(locala).equals(((a) paramObject).b(locala))) {
                                return false;
                            }
                        } else {
                            return false;
                        }
                    } else if (((a) paramObject).a(locala)) {
                        return false;
                    }
                }
                return true;
            }

            public int getLeftImageOffset() {
                return this.Wg;
            }

            public int getTopImageOffset() {
                return this.Wh;
            }

            int getVersionCode() {
                return this.xH;
            }

            public boolean hasLeftImageOffset() {
                return this.UJ.contains(Integer.valueOf(2));
            }

            public boolean hasTopImageOffset() {
                return this.UJ.contains(Integer.valueOf(3));
            }

            public int hashCode() {
                Iterator localIterator = UI.values().iterator();
                int i = 0;
                if (localIterator.hasNext()) {
                    ga.a locala = (ga.a) localIterator.next();
                    if (!a(locala)) {
                        break label68;
                    }
                    int j = locala.ff();
                    i = b(locala).hashCode() + (i + j);
                }
                label68:
                for (; ; ) {
                    break;
                    return i;
                }
            }

            public boolean isDataValid() {
                return true;
            }

            public a jH() {
                return this;
            }

            Set<Integer> ja() {
                return this.UJ;
            }

            public void writeToParcel(Parcel paramParcel, int paramInt) {
                il localil = CREATOR;
                il.a(this, paramParcel, paramInt);
            }
        }

        public static final class b
                extends ga
                implements SafeParcelable, Person.Cover.CoverPhoto {
            public static final im CREATOR = new im();
            private static final HashMap<String, ga.a<?, ?>> UI = new HashMap();
            private final Set<Integer> UJ;
            private int kr;
            private int ks;
            private String ro;
            private final int xH;

            static {
                UI.put("height", ga.a.g("height", 2));
                UI.put("url", ga.a.j("url", 3));
                UI.put("width", ga.a.g("width", 4));
            }

            public b() {
                this.xH = 1;
                this.UJ = new HashSet();
            }

            b(Set<Integer> paramSet, int paramInt1, int paramInt2, String paramString, int paramInt3) {
                this.UJ = paramSet;
                this.xH = paramInt1;
                this.ks = paramInt2;
                this.ro = paramString;
                this.kr = paramInt3;
            }

            protected boolean a(ga.a parama) {
                return this.UJ.contains(Integer.valueOf(parama.ff()));
            }

            protected Object aq(String paramString) {
                return null;
            }

            protected boolean ar(String paramString) {
                return false;
            }

            protected Object b(ga.a parama) {
                switch (parama.ff()) {
                    default:
                        throw new IllegalStateException("Unknown safe parcelable id=" + parama.ff());
                    case 2:
                        return Integer.valueOf(this.ks);
                    case 3:
                        return this.ro;
                }
                return Integer.valueOf(this.kr);
            }

            public int describeContents() {
                im localim = CREATOR;
                return 0;
            }

            public HashMap<String, ga.a<?, ?>> eY() {
                return UI;
            }

            public boolean equals(Object paramObject) {
                if (!(paramObject instanceof b)) {
                    return false;
                }
                if (this == paramObject) {
                    return true;
                }
                paramObject = (b) paramObject;
                Iterator localIterator = UI.values().iterator();
                while (localIterator.hasNext()) {
                    ga.a locala = (ga.a) localIterator.next();
                    if (a(locala)) {
                        if (((b) paramObject).a(locala)) {
                            if (!b(locala).equals(((b) paramObject).b(locala))) {
                                return false;
                            }
                        } else {
                            return false;
                        }
                    } else if (((b) paramObject).a(locala)) {
                        return false;
                    }
                }
                return true;
            }

            public int getHeight() {
                return this.ks;
            }

            public String getUrl() {
                return this.ro;
            }

            int getVersionCode() {
                return this.xH;
            }

            public int getWidth() {
                return this.kr;
            }

            public boolean hasHeight() {
                return this.UJ.contains(Integer.valueOf(2));
            }

            public boolean hasUrl() {
                return this.UJ.contains(Integer.valueOf(3));
            }

            public boolean hasWidth() {
                return this.UJ.contains(Integer.valueOf(4));
            }

            public int hashCode() {
                Iterator localIterator = UI.values().iterator();
                int i = 0;
                if (localIterator.hasNext()) {
                    ga.a locala = (ga.a) localIterator.next();
                    if (!a(locala)) {
                        break label68;
                    }
                    int j = locala.ff();
                    i = b(locala).hashCode() + (i + j);
                }
                label68:
                for (; ; ) {
                    break;
                    return i;
                }
            }

            public boolean isDataValid() {
                return true;
            }

            public b jI() {
                return this;
            }

            Set<Integer> ja() {
                return this.UJ;
            }

            public void writeToParcel(Parcel paramParcel, int paramInt) {
                im localim = CREATOR;
                im.a(this, paramParcel, paramInt);
            }
        }
    }

    public static final class c
            extends ga
            implements SafeParcelable, Person.Image {
        public static final in CREATOR = new in();
        private static final HashMap<String, ga.a<?, ?>> UI = new HashMap();
        private final Set<Integer> UJ;
        private String ro;
        private final int xH;

        static {
            UI.put("url", ga.a.j("url", 2));
        }

        public c() {
            this.xH = 1;
            this.UJ = new HashSet();
        }

        public c(String paramString) {
            this.UJ = new HashSet();
            this.xH = 1;
            this.ro = paramString;
            this.UJ.add(Integer.valueOf(2));
        }

        c(Set<Integer> paramSet, int paramInt, String paramString) {
            this.UJ = paramSet;
            this.xH = paramInt;
            this.ro = paramString;
        }

        protected boolean a(ga.a parama) {
            return this.UJ.contains(Integer.valueOf(parama.ff()));
        }

        protected Object aq(String paramString) {
            return null;
        }

        protected boolean ar(String paramString) {
            return false;
        }

        protected Object b(ga.a parama) {
            switch (parama.ff()) {
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + parama.ff());
            }
            return this.ro;
        }

        public int describeContents() {
            in localin = CREATOR;
            return 0;
        }

        public HashMap<String, ga.a<?, ?>> eY() {
            return UI;
        }

        public boolean equals(Object paramObject) {
            if (!(paramObject instanceof c)) {
                return false;
            }
            if (this == paramObject) {
                return true;
            }
            paramObject = (c) paramObject;
            Iterator localIterator = UI.values().iterator();
            while (localIterator.hasNext()) {
                ga.a locala = (ga.a) localIterator.next();
                if (a(locala)) {
                    if (((c) paramObject).a(locala)) {
                        if (!b(locala).equals(((c) paramObject).b(locala))) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                } else if (((c) paramObject).a(locala)) {
                    return false;
                }
            }
            return true;
        }

        public String getUrl() {
            return this.ro;
        }

        int getVersionCode() {
            return this.xH;
        }

        public boolean hasUrl() {
            return this.UJ.contains(Integer.valueOf(2));
        }

        public int hashCode() {
            Iterator localIterator = UI.values().iterator();
            int i = 0;
            if (localIterator.hasNext()) {
                ga.a locala = (ga.a) localIterator.next();
                if (!a(locala)) {
                    break label68;
                }
                int j = locala.ff();
                i = b(locala).hashCode() + (i + j);
            }
            label68:
            for (; ; ) {
                break;
                return i;
            }
        }

        public boolean isDataValid() {
            return true;
        }

        public c jJ() {
            return this;
        }

        Set<Integer> ja() {
            return this.UJ;
        }

        public void writeToParcel(Parcel paramParcel, int paramInt) {
            in localin = CREATOR;
            in.a(this, paramParcel, paramInt);
        }
    }

    public static final class d
            extends ga
            implements SafeParcelable, Person.Name {
        public static final io CREATOR = new io();
        private static final HashMap<String, ga.a<?, ?>> UI = new HashMap();
        private final Set<Integer> UJ;
        private String Vh;
        private String Vk;
        private String Wi;
        private String Wj;
        private String Wk;
        private String Wl;
        private final int xH;

        static {
            UI.put("familyName", ga.a.j("familyName", 2));
            UI.put("formatted", ga.a.j("formatted", 3));
            UI.put("givenName", ga.a.j("givenName", 4));
            UI.put("honorificPrefix", ga.a.j("honorificPrefix", 5));
            UI.put("honorificSuffix", ga.a.j("honorificSuffix", 6));
            UI.put("middleName", ga.a.j("middleName", 7));
        }

        public d() {
            this.xH = 1;
            this.UJ = new HashSet();
        }

        d(Set<Integer> paramSet, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {
            this.UJ = paramSet;
            this.xH = paramInt;
            this.Vh = paramString1;
            this.Wi = paramString2;
            this.Vk = paramString3;
            this.Wj = paramString4;
            this.Wk = paramString5;
            this.Wl = paramString6;
        }

        protected boolean a(ga.a parama) {
            return this.UJ.contains(Integer.valueOf(parama.ff()));
        }

        protected Object aq(String paramString) {
            return null;
        }

        protected boolean ar(String paramString) {
            return false;
        }

        protected Object b(ga.a parama) {
            switch (parama.ff()) {
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + parama.ff());
                case 2:
                    return this.Vh;
                case 3:
                    return this.Wi;
                case 4:
                    return this.Vk;
                case 5:
                    return this.Wj;
                case 6:
                    return this.Wk;
            }
            return this.Wl;
        }

        public int describeContents() {
            io localio = CREATOR;
            return 0;
        }

        public HashMap<String, ga.a<?, ?>> eY() {
            return UI;
        }

        public boolean equals(Object paramObject) {
            if (!(paramObject instanceof d)) {
                return false;
            }
            if (this == paramObject) {
                return true;
            }
            paramObject = (d) paramObject;
            Iterator localIterator = UI.values().iterator();
            while (localIterator.hasNext()) {
                ga.a locala = (ga.a) localIterator.next();
                if (a(locala)) {
                    if (((d) paramObject).a(locala)) {
                        if (!b(locala).equals(((d) paramObject).b(locala))) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                } else if (((d) paramObject).a(locala)) {
                    return false;
                }
            }
            return true;
        }

        public String getFamilyName() {
            return this.Vh;
        }

        public String getFormatted() {
            return this.Wi;
        }

        public String getGivenName() {
            return this.Vk;
        }

        public String getHonorificPrefix() {
            return this.Wj;
        }

        public String getHonorificSuffix() {
            return this.Wk;
        }

        public String getMiddleName() {
            return this.Wl;
        }

        int getVersionCode() {
            return this.xH;
        }

        public boolean hasFamilyName() {
            return this.UJ.contains(Integer.valueOf(2));
        }

        public boolean hasFormatted() {
            return this.UJ.contains(Integer.valueOf(3));
        }

        public boolean hasGivenName() {
            return this.UJ.contains(Integer.valueOf(4));
        }

        public boolean hasHonorificPrefix() {
            return this.UJ.contains(Integer.valueOf(5));
        }

        public boolean hasHonorificSuffix() {
            return this.UJ.contains(Integer.valueOf(6));
        }

        public boolean hasMiddleName() {
            return this.UJ.contains(Integer.valueOf(7));
        }

        public int hashCode() {
            Iterator localIterator = UI.values().iterator();
            int i = 0;
            if (localIterator.hasNext()) {
                ga.a locala = (ga.a) localIterator.next();
                if (!a(locala)) {
                    break label68;
                }
                int j = locala.ff();
                i = b(locala).hashCode() + (i + j);
            }
            label68:
            for (; ; ) {
                break;
                return i;
            }
        }

        public boolean isDataValid() {
            return true;
        }

        public d jK() {
            return this;
        }

        Set<Integer> ja() {
            return this.UJ;
        }

        public void writeToParcel(Parcel paramParcel, int paramInt) {
            io localio = CREATOR;
            io.a(this, paramParcel, paramInt);
        }
    }

    public static class e {
        public static int bi(String paramString) {
            if (paramString.equals("person")) {
                return 0;
            }
            if (paramString.equals("page")) {
                return 1;
            }
            throw new IllegalArgumentException("Unknown objectType string: " + paramString);
        }
    }

    public static final class f
            extends ga
            implements SafeParcelable, Person.Organizations {
        public static final ip CREATOR = new ip();
        private static final HashMap<String, ga.a<?, ?>> UI = new HashMap();
        private String EB;
        private String HD;
        private int LF;
        private final Set<Integer> UJ;
        private String Vg;
        private String Vw;
        private String Wm;
        private String Wn;
        private boolean Wo;
        private String mName;
        private final int xH;

        static {
            UI.put("department", ga.a.j("department", 2));
            UI.put("description", ga.a.j("description", 3));
            UI.put("endDate", ga.a.j("endDate", 4));
            UI.put("location", ga.a.j("location", 5));
            UI.put("name", ga.a.j("name", 6));
            UI.put("primary", ga.a.i("primary", 7));
            UI.put("startDate", ga.a.j("startDate", 8));
            UI.put("title", ga.a.j("title", 9));
            UI.put("type", ga.a.a("type", 10, new fx().f("work", 0).f("school", 1), false));
        }

        public f() {
            this.xH = 1;
            this.UJ = new HashSet();
        }

        f(Set<Integer> paramSet, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean, String paramString6, String paramString7, int paramInt2) {
            this.UJ = paramSet;
            this.xH = paramInt1;
            this.Wm = paramString1;
            this.HD = paramString2;
            this.Vg = paramString3;
            this.Wn = paramString4;
            this.mName = paramString5;
            this.Wo = paramBoolean;
            this.Vw = paramString6;
            this.EB = paramString7;
            this.LF = paramInt2;
        }

        protected boolean a(ga.a parama) {
            return this.UJ.contains(Integer.valueOf(parama.ff()));
        }

        protected Object aq(String paramString) {
            return null;
        }

        protected boolean ar(String paramString) {
            return false;
        }

        protected Object b(ga.a parama) {
            switch (parama.ff()) {
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + parama.ff());
                case 2:
                    return this.Wm;
                case 3:
                    return this.HD;
                case 4:
                    return this.Vg;
                case 5:
                    return this.Wn;
                case 6:
                    return this.mName;
                case 7:
                    return Boolean.valueOf(this.Wo);
                case 8:
                    return this.Vw;
                case 9:
                    return this.EB;
            }
            return Integer.valueOf(this.LF);
        }

        public int describeContents() {
            ip localip = CREATOR;
            return 0;
        }

        public HashMap<String, ga.a<?, ?>> eY() {
            return UI;
        }

        public boolean equals(Object paramObject) {
            if (!(paramObject instanceof f)) {
                return false;
            }
            if (this == paramObject) {
                return true;
            }
            paramObject = (f) paramObject;
            Iterator localIterator = UI.values().iterator();
            while (localIterator.hasNext()) {
                ga.a locala = (ga.a) localIterator.next();
                if (a(locala)) {
                    if (((f) paramObject).a(locala)) {
                        if (!b(locala).equals(((f) paramObject).b(locala))) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                } else if (((f) paramObject).a(locala)) {
                    return false;
                }
            }
            return true;
        }

        public String getDepartment() {
            return this.Wm;
        }

        public String getDescription() {
            return this.HD;
        }

        public String getEndDate() {
            return this.Vg;
        }

        public String getLocation() {
            return this.Wn;
        }

        public String getName() {
            return this.mName;
        }

        public String getStartDate() {
            return this.Vw;
        }

        public String getTitle() {
            return this.EB;
        }

        public int getType() {
            return this.LF;
        }

        int getVersionCode() {
            return this.xH;
        }

        public boolean hasDepartment() {
            return this.UJ.contains(Integer.valueOf(2));
        }

        public boolean hasDescription() {
            return this.UJ.contains(Integer.valueOf(3));
        }

        public boolean hasEndDate() {
            return this.UJ.contains(Integer.valueOf(4));
        }

        public boolean hasLocation() {
            return this.UJ.contains(Integer.valueOf(5));
        }

        public boolean hasName() {
            return this.UJ.contains(Integer.valueOf(6));
        }

        public boolean hasPrimary() {
            return this.UJ.contains(Integer.valueOf(7));
        }

        public boolean hasStartDate() {
            return this.UJ.contains(Integer.valueOf(8));
        }

        public boolean hasTitle() {
            return this.UJ.contains(Integer.valueOf(9));
        }

        public boolean hasType() {
            return this.UJ.contains(Integer.valueOf(10));
        }

        public int hashCode() {
            Iterator localIterator = UI.values().iterator();
            int i = 0;
            if (localIterator.hasNext()) {
                ga.a locala = (ga.a) localIterator.next();
                if (!a(locala)) {
                    break label68;
                }
                int j = locala.ff();
                i = b(locala).hashCode() + (i + j);
            }
            label68:
            for (; ; ) {
                break;
                return i;
            }
        }

        public boolean isDataValid() {
            return true;
        }

        public boolean isPrimary() {
            return this.Wo;
        }

        public f jL() {
            return this;
        }

        Set<Integer> ja() {
            return this.UJ;
        }

        public void writeToParcel(Parcel paramParcel, int paramInt) {
            ip localip = CREATOR;
            ip.a(this, paramParcel, paramInt);
        }
    }

    public static final class g
            extends ga
            implements SafeParcelable, Person.PlacesLived {
        public static final iq CREATOR = new iq();
        private static final HashMap<String, ga.a<?, ?>> UI = new HashMap();
        private final Set<Integer> UJ;
        private boolean Wo;
        private String mValue;
        private final int xH;

        static {
            UI.put("primary", ga.a.i("primary", 2));
            UI.put("value", ga.a.j("value", 3));
        }

        public g() {
            this.xH = 1;
            this.UJ = new HashSet();
        }

        g(Set<Integer> paramSet, int paramInt, boolean paramBoolean, String paramString) {
            this.UJ = paramSet;
            this.xH = paramInt;
            this.Wo = paramBoolean;
            this.mValue = paramString;
        }

        protected boolean a(ga.a parama) {
            return this.UJ.contains(Integer.valueOf(parama.ff()));
        }

        protected Object aq(String paramString) {
            return null;
        }

        protected boolean ar(String paramString) {
            return false;
        }

        protected Object b(ga.a parama) {
            switch (parama.ff()) {
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + parama.ff());
                case 2:
                    return Boolean.valueOf(this.Wo);
            }
            return this.mValue;
        }

        public int describeContents() {
            iq localiq = CREATOR;
            return 0;
        }

        public HashMap<String, ga.a<?, ?>> eY() {
            return UI;
        }

        public boolean equals(Object paramObject) {
            if (!(paramObject instanceof g)) {
                return false;
            }
            if (this == paramObject) {
                return true;
            }
            paramObject = (g) paramObject;
            Iterator localIterator = UI.values().iterator();
            while (localIterator.hasNext()) {
                ga.a locala = (ga.a) localIterator.next();
                if (a(locala)) {
                    if (((g) paramObject).a(locala)) {
                        if (!b(locala).equals(((g) paramObject).b(locala))) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                } else if (((g) paramObject).a(locala)) {
                    return false;
                }
            }
            return true;
        }

        public String getValue() {
            return this.mValue;
        }

        int getVersionCode() {
            return this.xH;
        }

        public boolean hasPrimary() {
            return this.UJ.contains(Integer.valueOf(2));
        }

        public boolean hasValue() {
            return this.UJ.contains(Integer.valueOf(3));
        }

        public int hashCode() {
            Iterator localIterator = UI.values().iterator();
            int i = 0;
            if (localIterator.hasNext()) {
                ga.a locala = (ga.a) localIterator.next();
                if (!a(locala)) {
                    break label68;
                }
                int j = locala.ff();
                i = b(locala).hashCode() + (i + j);
            }
            label68:
            for (; ; ) {
                break;
                return i;
            }
        }

        public boolean isDataValid() {
            return true;
        }

        public boolean isPrimary() {
            return this.Wo;
        }

        public g jM() {
            return this;
        }

        Set<Integer> ja() {
            return this.UJ;
        }

        public void writeToParcel(Parcel paramParcel, int paramInt) {
            iq localiq = CREATOR;
            iq.a(this, paramParcel, paramInt);
        }
    }

    public static final class h
            extends ga
            implements SafeParcelable, Person.Urls {
        public static final ir CREATOR = new ir();
        private static final HashMap<String, ga.a<?, ?>> UI = new HashMap();
        private int LF;
        private final Set<Integer> UJ;
        private String Wp;
        private final int Wq = 4;
        private String mValue;
        private final int xH;

        static {
            UI.put("label", ga.a.j("label", 5));
            UI.put("type", ga.a.a("type", 6, new fx().f("home", 0).f("work", 1).f("blog", 2).f("profile", 3).f("other", 4).f("otherProfile", 5).f("contributor", 6).f("website", 7), false));
            UI.put("value", ga.a.j("value", 4));
        }

        public h() {
            this.xH = 2;
            this.UJ = new HashSet();
        }

        h(Set<Integer> paramSet, int paramInt1, String paramString1, int paramInt2, String paramString2, int paramInt3) {
            this.UJ = paramSet;
            this.xH = paramInt1;
            this.Wp = paramString1;
            this.LF = paramInt2;
            this.mValue = paramString2;
        }

        protected boolean a(ga.a parama) {
            return this.UJ.contains(Integer.valueOf(parama.ff()));
        }

        protected Object aq(String paramString) {
            return null;
        }

        protected boolean ar(String paramString) {
            return false;
        }

        protected Object b(ga.a parama) {
            switch (parama.ff()) {
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + parama.ff());
                case 5:
                    return this.Wp;
                case 6:
                    return Integer.valueOf(this.LF);
            }
            return this.mValue;
        }

        public int describeContents() {
            ir localir = CREATOR;
            return 0;
        }

        public HashMap<String, ga.a<?, ?>> eY() {
            return UI;
        }

        public boolean equals(Object paramObject) {
            if (!(paramObject instanceof h)) {
                return false;
            }
            if (this == paramObject) {
                return true;
            }
            paramObject = (h) paramObject;
            Iterator localIterator = UI.values().iterator();
            while (localIterator.hasNext()) {
                ga.a locala = (ga.a) localIterator.next();
                if (a(locala)) {
                    if (((h) paramObject).a(locala)) {
                        if (!b(locala).equals(((h) paramObject).b(locala))) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                } else if (((h) paramObject).a(locala)) {
                    return false;
                }
            }
            return true;
        }

        public String getLabel() {
            return this.Wp;
        }

        public int getType() {
            return this.LF;
        }

        public String getValue() {
            return this.mValue;
        }

        int getVersionCode() {
            return this.xH;
        }

        public boolean hasLabel() {
            return this.UJ.contains(Integer.valueOf(5));
        }

        public boolean hasType() {
            return this.UJ.contains(Integer.valueOf(6));
        }

        public boolean hasValue() {
            return this.UJ.contains(Integer.valueOf(4));
        }

        public int hashCode() {
            Iterator localIterator = UI.values().iterator();
            int i = 0;
            if (localIterator.hasNext()) {
                ga.a locala = (ga.a) localIterator.next();
                if (!a(locala)) {
                    break label68;
                }
                int j = locala.ff();
                i = b(locala).hashCode() + (i + j);
            }
            label68:
            for (; ; ) {
                break;
                return i;
            }
        }

        public boolean isDataValid() {
            return true;
        }

        @Deprecated
        public int jN() {
            return 4;
        }

        public h jO() {
            return this;
        }

        Set<Integer> ja() {
            return this.UJ;
        }

        public void writeToParcel(Parcel paramParcel, int paramInt) {
            ir localir = CREATOR;
            ir.a(this, paramParcel, paramInt);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/ih.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */