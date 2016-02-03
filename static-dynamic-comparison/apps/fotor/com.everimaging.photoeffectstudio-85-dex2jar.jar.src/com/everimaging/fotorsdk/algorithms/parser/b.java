package com.everimaging.fotorsdk.algorithms.parser;

import com.everimaging.fotorsdk.algorithms.params.base.RSBaseParams;
import com.everimaging.fotorsdk.algorithms.parser.params.aa;
import com.everimaging.fotorsdk.algorithms.parser.params.ab;
import com.everimaging.fotorsdk.algorithms.parser.params.ac;
import com.everimaging.fotorsdk.algorithms.parser.params.ad;
import com.everimaging.fotorsdk.algorithms.parser.params.ae;
import com.everimaging.fotorsdk.algorithms.parser.params.af;
import com.everimaging.fotorsdk.algorithms.parser.params.ag;
import com.everimaging.fotorsdk.algorithms.parser.params.ah;
import com.everimaging.fotorsdk.algorithms.parser.params.ai;
import com.everimaging.fotorsdk.algorithms.parser.params.aj;
import com.everimaging.fotorsdk.algorithms.parser.params.ak;
import com.everimaging.fotorsdk.algorithms.parser.params.al;
import com.everimaging.fotorsdk.algorithms.parser.params.am;
import com.everimaging.fotorsdk.algorithms.parser.params.d;
import com.everimaging.fotorsdk.algorithms.parser.params.e;
import com.everimaging.fotorsdk.algorithms.parser.params.f;
import com.everimaging.fotorsdk.algorithms.parser.params.g;
import com.everimaging.fotorsdk.algorithms.parser.params.h;
import com.everimaging.fotorsdk.algorithms.parser.params.i;
import com.everimaging.fotorsdk.algorithms.parser.params.j;
import com.everimaging.fotorsdk.algorithms.parser.params.k;
import com.everimaging.fotorsdk.algorithms.parser.params.l;
import com.everimaging.fotorsdk.algorithms.parser.params.m;
import com.everimaging.fotorsdk.algorithms.parser.params.n;
import com.everimaging.fotorsdk.algorithms.parser.params.o;
import com.everimaging.fotorsdk.algorithms.parser.params.p;
import com.everimaging.fotorsdk.algorithms.parser.params.q;
import com.everimaging.fotorsdk.algorithms.parser.params.r;
import com.everimaging.fotorsdk.algorithms.parser.params.s;
import com.everimaging.fotorsdk.algorithms.parser.params.t;
import com.everimaging.fotorsdk.algorithms.parser.params.u;
import com.everimaging.fotorsdk.algorithms.parser.params.v;
import com.everimaging.fotorsdk.algorithms.parser.params.w;
import com.everimaging.fotorsdk.algorithms.parser.params.x;
import com.everimaging.fotorsdk.algorithms.parser.params.y;
import com.everimaging.fotorsdk.algorithms.parser.params.z;
import org.xmlpull.v1.XmlPullParser;

public class b {
    private static final String a = b.class.getSimpleName();

    public static RSBaseParams a(RSBaseFilterFactory.BaseFilter paramBaseFilter, XmlPullParser paramXmlPullParser) {
        paramBaseFilter = a(paramBaseFilter);
        if (paramBaseFilter == null) {
            com.everimaging.fotorsdk.algorithms.c.b(a, "Not implementation param type parser.");
            return null;
        }
        return paramBaseFilter.a(paramXmlPullParser);
    }

    private static a a(RSBaseFilterFactory.BaseFilter paramBaseFilter) {
        switch (1. a[paramBaseFilter.ordinal()])
        {
            default:
                return null;
            case 1:
                return new com.everimaging.fotorsdk.algorithms.parser.params.a();
            case 2:
                return new com.everimaging.fotorsdk.algorithms.parser.params.b();
            case 3:
                return new com.everimaging.fotorsdk.algorithms.parser.params.c();
            case 4:
                return new d();
            case 5:
                return new e();
            case 6:
                return new f();
            case 7:
                return new g();
            case 8:
                return new h();
            case 9:
                return new i();
            case 10:
                return new j();
            case 11:
                return new k();
            case 12:
                return new l();
            case 13:
                return new m();
            case 14:
                return new n();
            case 15:
                return new o();
            case 16:
                return new r();
            case 17:
                return new s();
            case 18:
                return new p();
            case 19:
                return new q();
            case 20:
                return new t();
            case 21:
                return new u();
            case 22:
                return new v();
            case 23:
                return new w();
            case 24:
                return new x();
            case 25:
                return new y();
            case 26:
                return new z();
            case 27:
                return new aa();
            case 28:
                return new ac();
            case 29:
                return new ab();
            case 30:
                return new ad();
            case 31:
                return new ae();
            case 32:
                return new af();
            case 33:
                return new ag();
            case 34:
                return new ah();
            case 35:
                return new ai();
            case 36:
                return new aj();
            case 37:
                return new ak();
            case 38:
                return new al();
        }
        return new am();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/parser/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */