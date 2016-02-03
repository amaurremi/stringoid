package com.everimaging.fotorsdk.algorithms.filter;

import android.content.Context;
import android.content.res.Resources;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.Element;
import android.support.v8.renderscript.FieldPacker;
import android.support.v8.renderscript.Float2;
import android.support.v8.renderscript.Float3;
import android.support.v8.renderscript.Float4;
import android.support.v8.renderscript.RSRuntimeException;
import android.support.v8.renderscript.RenderScript;
import android.support.v8.renderscript.Sampler;
import android.support.v8.renderscript.Script.LaunchOptions;
import android.support.v8.renderscript.ScriptC;
import android.support.v8.renderscript.Type;

public class d
        extends ScriptC {
    private Allocation A;
    private Allocation B;
    private Allocation C;
    private Sampler D;
    private float E;
    private float F;
    private float G;
    private float H;
    private float I;
    private float J;
    private float K;
    private float L;
    private float M;
    private float N;
    private float O;
    private float P;
    private float Q;
    private float R;
    private float S;
    private float T;
    private float U;
    private float V;
    private float W;
    private float X;
    private float Y;
    private float Z;
    private Element a;
    private int aA;
    private int aB;
    private Allocation aC;
    private Allocation aD;
    private Allocation aE;
    private Allocation aF;
    private Allocation aG;
    private Allocation aH;
    private Allocation aI;
    private Float3 aJ;
    private Float3 aK;
    private Float3 aL;
    private Float3 aM;
    private Float3 aN;
    private Float3 aO;
    private Float3 aP;
    private Float3 aQ;
    private Float3 aR;
    private Float3 aS;
    private Float3 aT;
    private Float3 aU;
    private Float3 aV;
    private Float3 aW;
    private float aX;
    private float aY;
    private Float2 aZ;
    private float aa;
    private float ab;
    private float ac;
    private float ad;
    private float ae;
    private float af;
    private float ag;
    private float ah;
    private float ai;
    private float aj;
    private float ak;
    private float al;
    private float am;
    private float an;
    private float ao;
    private boolean ap;
    private boolean aq;
    private int ar;
    private int as;
    private int at;
    private int au;
    private int av;
    private int aw;
    private int ax;
    private int ay;
    private int az;
    private Element b;
    private Float2 ba;
    private Float2 bb;
    private Float4 bc;
    private float bd;
    private float be;
    private float bf;
    private Float2 bg;
    private Float2 bh;
    private Float4[] bi;
    private Float2 bj;
    private float bk;
    private float bl;
    private Float4 bm;
    private float bn;
    private float bo;
    private int bp;
    private Float4 bq;
    private Float2 br;
    private Float2 bs;
    private int bt;
    private int bu;
    private int bv;
    private int bw;
    private float bx;
    private float[] by;
    private float bz;
    private Element c;
    private Element d;
    private Element e;
    private Element f;
    private Element g;
    private Element h;
    private Element i;
    private Element j;
    private FieldPacker k;
    private Float3 l = new Float3();
    private Float3 m;
    private Float3 n;
    private Float2 o;
    private Float3 p;
    private Float3 q;
    private Float3 r;
    private int s;
    private Float2[] t;
    private Allocation u;
    private Allocation v;
    private Allocation w;
    private Allocation x;
    private Allocation y;
    private Allocation z;

    public d(RenderScript paramRenderScript) {
        this(paramRenderScript, paramRenderScript.getApplicationContext().getResources(), paramRenderScript.getApplicationContext().getResources().getIdentifier("basefilter", "raw", paramRenderScript.getApplicationContext().getPackageName()));
    }

    public d(RenderScript paramRenderScript, Resources paramResources, int paramInt) {
        super(paramRenderScript, paramResources, paramInt);
        this.l.x = 0.299F;
        this.l.y = 0.587F;
        this.l.z = 0.114F;
        this.e = Element.F32_3(paramRenderScript);
        this.m = new Float3();
        this.m.x = 0.299F;
        this.m.y = 0.587F;
        this.m.z = 0.114F;
        this.n = new Float3();
        this.n.x = 0.5F;
        this.n.y = 0.5F;
        this.n.z = 0.5F;
        this.o = new Float2();
        this.o.x = 0.5F;
        this.o.y = 0.5F;
        this.d = Element.F32_2(paramRenderScript);
        this.p = new Float3();
        this.p.x = 0.915F;
        this.p.y = -0.587F;
        this.p.z = -0.144F;
        this.q = new Float3();
        this.q.x = -0.299F;
        this.q.y = 0.413F;
        this.q.z = -0.144F;
        this.r = new Float3();
        this.r.x = -0.299F;
        this.r.y = -0.587F;
        this.r.z = 0.886F;
        this.s = 256;
        this.g = Element.I32(paramRenderScript);
        this.t = new Float2[4];
        this.t[0] = new Float2();
        this.t[0].x = -1.0F;
        this.t[0].y = 0.0F;
        this.t[1] = new Float2();
        this.t[1].x = 1.0F;
        this.t[1].y = 0.0F;
        this.t[2] = new Float2();
        this.t[2].x = 0.0F;
        this.t[2].y = -1.0F;
        this.t[3] = new Float2();
        this.t[3].x = 0.0F;
        this.t[3].y = 1.0F;
        this.i = Element.SCRIPT(paramRenderScript);
        this.a = Element.ALLOCATION(paramRenderScript);
        this.h = Element.SAMPLER(paramRenderScript);
        this.c = Element.F32(paramRenderScript);
        this.b = Element.BOOLEAN(paramRenderScript);
        this.f = Element.F32_4(paramRenderScript);
        this.by = new float[25];
        this.by[0] = -2.0F;
        this.by[1] = -4.0F;
        this.by[2] = -4.0F;
        this.by[3] = -4.0F;
        this.by[4] = -2.0F;
        this.by[5] = -4.0F;
        this.by[6] = 0.0F;
        this.by[7] = 8.0F;
        this.by[8] = 0.0F;
        this.by[9] = -4.0F;
        this.by[10] = -4.0F;
        this.by[11] = 8.0F;
        this.by[12] = 24.0F;
        this.by[13] = 8.0F;
        this.by[14] = -4.0F;
        this.by[15] = -4.0F;
        this.by[16] = 0.0F;
        this.by[17] = 8.0F;
        this.by[18] = 0.0F;
        this.by[19] = -4.0F;
        this.by[20] = -2.0F;
        this.by[21] = -4.0F;
        this.by[22] = -4.0F;
        this.by[23] = -4.0F;
        this.by[24] = -2.0F;
        this.bz = 0.45F;
        this.j = Element.U8_4(paramRenderScript);
    }

    public void A(float paramFloat) {
        try {
            setVar(56, paramFloat);
            this.ae = paramFloat;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void A(Allocation paramAllocation1, Allocation paramAllocation2) {
        A(paramAllocation1, paramAllocation2, null);
    }

    public void A(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(30, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void B(float paramFloat) {
        try {
            setVar(57, paramFloat);
            this.af = paramFloat;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void B(Allocation paramAllocation1, Allocation paramAllocation2) {
        B(paramAllocation1, paramAllocation2, null);
    }

    public void B(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(31, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void C(float paramFloat) {
        try {
            setVar(58, paramFloat);
            this.ag = paramFloat;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void C(Allocation paramAllocation1, Allocation paramAllocation2) {
        C(paramAllocation1, paramAllocation2, null);
    }

    public void C(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(32, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void D(float paramFloat) {
        try {
            setVar(59, paramFloat);
            this.ah = paramFloat;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void D(Allocation paramAllocation1, Allocation paramAllocation2) {
        D(paramAllocation1, paramAllocation2, null);
    }

    public void D(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(33, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void E(float paramFloat) {
        try {
            setVar(60, paramFloat);
            this.ai = paramFloat;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void E(Allocation paramAllocation1, Allocation paramAllocation2) {
        E(paramAllocation1, paramAllocation2, null);
    }

    public void E(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(34, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void F(float paramFloat) {
        try {
            setVar(61, paramFloat);
            this.aj = paramFloat;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void F(Allocation paramAllocation1, Allocation paramAllocation2) {
        F(paramAllocation1, paramAllocation2, null);
    }

    public void F(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(35, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void G(float paramFloat) {
        try {
            setVar(62, paramFloat);
            this.ak = paramFloat;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void G(Allocation paramAllocation1, Allocation paramAllocation2) {
        G(paramAllocation1, paramAllocation2, null);
    }

    public void G(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(36, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void H(float paramFloat) {
        try {
            setVar(63, paramFloat);
            this.al = paramFloat;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void H(Allocation paramAllocation1, Allocation paramAllocation2) {
        H(paramAllocation1, paramAllocation2, null);
    }

    public void H(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(37, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void I(float paramFloat) {
        try {
            setVar(64, paramFloat);
            this.am = paramFloat;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void I(Allocation paramAllocation1, Allocation paramAllocation2) {
        I(paramAllocation1, paramAllocation2, null);
    }

    public void I(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(38, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void J(float paramFloat) {
        try {
            setVar(65, paramFloat);
            this.an = paramFloat;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void J(Allocation paramAllocation1, Allocation paramAllocation2) {
        J(paramAllocation1, paramAllocation2, null);
    }

    public void J(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(39, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void K(float paramFloat) {
        try {
            setVar(66, paramFloat);
            this.ao = paramFloat;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void K(Allocation paramAllocation1, Allocation paramAllocation2) {
        K(paramAllocation1, paramAllocation2, null);
    }

    public void K(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(40, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void L(float paramFloat) {
        try {
            setVar(103, paramFloat);
            this.aX = paramFloat;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void L(Allocation paramAllocation1, Allocation paramAllocation2) {
        L(paramAllocation1, paramAllocation2, null);
    }

    public void L(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(41, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void M(float paramFloat) {
        try {
            setVar(104, paramFloat);
            this.aY = paramFloat;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void M(Allocation paramAllocation1, Allocation paramAllocation2) {
        M(paramAllocation1, paramAllocation2, null);
    }

    public void M(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(42, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void N(float paramFloat) {
        try {
            setVar(109, paramFloat);
            this.bd = paramFloat;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void N(Allocation paramAllocation1, Allocation paramAllocation2) {
        N(paramAllocation1, paramAllocation2, null);
    }

    public void N(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(43, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void O(float paramFloat) {
        try {
            setVar(110, paramFloat);
            this.be = paramFloat;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void O(Allocation paramAllocation1, Allocation paramAllocation2) {
        O(paramAllocation1, paramAllocation2, null);
    }

    public void O(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(44, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void P(float paramFloat) {
        try {
            setVar(111, paramFloat);
            this.bf = paramFloat;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void P(Allocation paramAllocation1, Allocation paramAllocation2) {
        P(paramAllocation1, paramAllocation2, null);
    }

    public void P(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(45, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void Q(float paramFloat) {
        try {
            setVar(116, paramFloat);
            this.bk = paramFloat;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void Q(Allocation paramAllocation1, Allocation paramAllocation2) {
        Q(paramAllocation1, paramAllocation2, null);
    }

    public void Q(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(46, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void R(float paramFloat) {
        try {
            setVar(117, paramFloat);
            this.bl = paramFloat;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void R(Allocation paramAllocation1, Allocation paramAllocation2) {
        R(paramAllocation1, paramAllocation2, null);
    }

    public void R(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(47, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void S(float paramFloat) {
        try {
            setVar(119, paramFloat);
            this.bn = paramFloat;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void S(Allocation paramAllocation1, Allocation paramAllocation2) {
        S(paramAllocation1, paramAllocation2, null);
    }

    public void S(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(48, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void T(float paramFloat) {
        try {
            setVar(120, paramFloat);
            this.bo = paramFloat;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void T(Allocation paramAllocation1, Allocation paramAllocation2) {
        T(paramAllocation1, paramAllocation2, null);
    }

    public void T(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(49, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void U(float paramFloat) {
        try {
            setVar(129, paramFloat);
            this.bx = paramFloat;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void U(Allocation paramAllocation1, Allocation paramAllocation2) {
        U(paramAllocation1, paramAllocation2, null);
    }

    public void U(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(50, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void V(Allocation paramAllocation1, Allocation paramAllocation2) {
        V(paramAllocation1, paramAllocation2, null);
    }

    public void V(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(51, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void W(Allocation paramAllocation1, Allocation paramAllocation2) {
        W(paramAllocation1, paramAllocation2, null);
    }

    public void W(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(52, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void X(Allocation paramAllocation1, Allocation paramAllocation2) {
        X(paramAllocation1, paramAllocation2, null);
    }

    public void X(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(53, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void Y(Allocation paramAllocation1, Allocation paramAllocation2) {
        Y(paramAllocation1, paramAllocation2, null);
    }

    public void Y(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(54, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void Z(Allocation paramAllocation1, Allocation paramAllocation2) {
        Z(paramAllocation1, paramAllocation2, null);
    }

    public void Z(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(55, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void a() {
        invoke(0);
    }

    public void a(float paramFloat) {
        try {
            setVar(30, paramFloat);
            this.E = paramFloat;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void a(int paramInt) {
        try {
            setVar(69, paramInt);
            this.ar = paramInt;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void a(Allocation paramAllocation) {
        try {
            setVar(10, paramAllocation);
            this.u = paramAllocation;
            return;
        } finally {
            paramAllocation =finally;
            throw paramAllocation;
        }
    }

    public void a(Allocation paramAllocation1, Allocation paramAllocation2) {
        a(paramAllocation1, paramAllocation2, null);
    }

    public void a(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(1, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void a(Allocation paramAllocation, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation.getType().getElement().isCompatible(this.c)) {
            throw new RSRuntimeException("Type mismatch with F32!");
        }
        forEach(9, paramAllocation, null, null, paramLaunchOptions);
    }

    public void a(Float2 paramFloat2) {
        try {
            this.aZ = paramFloat2;
            FieldPacker localFieldPacker = new FieldPacker(8);
            localFieldPacker.addF32(paramFloat2);
            setVar(105, localFieldPacker, this.d, new int[]{4});
            return;
        } finally {
            paramFloat2 =finally;
            throw paramFloat2;
        }
    }

    public void a(Float3 paramFloat3) {
        try {
            this.aJ = paramFloat3;
            FieldPacker localFieldPacker = new FieldPacker(16);
            localFieldPacker.addF32(paramFloat3);
            setVar(89, localFieldPacker, this.e, new int[]{4});
            return;
        } finally {
            paramFloat3 =finally;
            throw paramFloat3;
        }
    }

    public void a(Float4 paramFloat4) {
        try {
            this.bc = paramFloat4;
            FieldPacker localFieldPacker = new FieldPacker(16);
            localFieldPacker.addF32(paramFloat4);
            setVar(108, localFieldPacker, this.f, new int[]{4});
            return;
        } finally {
            paramFloat4 =finally;
            throw paramFloat4;
        }
    }

    public void a(Sampler paramSampler) {
        try {
            setVar(29, paramSampler);
            this.D = paramSampler;
            return;
        } finally {
            paramSampler =finally;
            throw paramSampler;
        }
    }

    /* Error */
    public void a(boolean paramBoolean) {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: getfield 485	com/everimaging/fotorsdk/algorithms/filter/d:k	Landroid/support/v8/renderscript/FieldPacker;
        //   6: ifnull +36 -> 42
        //   9: aload_0
        //   10: getfield 485	com/everimaging/fotorsdk/algorithms/filter/d:k	Landroid/support/v8/renderscript/FieldPacker;
        //   13: invokevirtual 488	android/support/v8/renderscript/FieldPacker:reset	()V
        //   16: aload_0
        //   17: getfield 485	com/everimaging/fotorsdk/algorithms/filter/d:k	Landroid/support/v8/renderscript/FieldPacker;
        //   20: iload_1
        //   21: invokevirtual 491	android/support/v8/renderscript/FieldPacker:addBoolean	(Z)V
        //   24: aload_0
        //   25: bipush 67
        //   27: aload_0
        //   28: getfield 485	com/everimaging/fotorsdk/algorithms/filter/d:k	Landroid/support/v8/renderscript/FieldPacker;
        //   31: invokevirtual 494	com/everimaging/fotorsdk/algorithms/filter/d:setVar	(ILandroid/support/v8/renderscript/FieldPacker;)V
        //   34: aload_0
        //   35: iload_1
        //   36: putfield 496	com/everimaging/fotorsdk/algorithms/filter/d:ap	Z
        //   39: aload_0
        //   40: monitorexit
        //   41: return
        //   42: aload_0
        //   43: new 461	android/support/v8/renderscript/FieldPacker
        //   46: dup
        //   47: iconst_1
        //   48: invokespecial 463	android/support/v8/renderscript/FieldPacker:<init>	(I)V
        //   51: putfield 485	com/everimaging/fotorsdk/algorithms/filter/d:k	Landroid/support/v8/renderscript/FieldPacker;
        //   54: goto -38 -> 16
        //   57: astore_2
        //   58: aload_0
        //   59: monitorexit
        //   60: aload_2
        //   61: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	62	0	this	d
        //   0	62	1	paramBoolean	boolean
        //   57	4	2	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	16	57	finally
        //   16	39	57	finally
        //   42	54	57	finally
    }

    public void a(Float4[] paramArrayOfFloat4) {
        int i1 = 0;
        try {
            this.bi = paramArrayOfFloat4;
            FieldPacker localFieldPacker = new FieldPacker(128);
            while (i1 < 8) {
                localFieldPacker.addF32(paramArrayOfFloat4[i1]);
                i1 += 1;
            }
            setVar(114, localFieldPacker, this.f, new int[]{8});
            return;
        } finally {
        }
    }

    public void aA(Allocation paramAllocation1, Allocation paramAllocation2) {
        aA(paramAllocation1, paramAllocation2, null);
    }

    public void aA(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(82, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void aB(Allocation paramAllocation1, Allocation paramAllocation2) {
        aB(paramAllocation1, paramAllocation2, null);
    }

    public void aB(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(83, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void aC(Allocation paramAllocation1, Allocation paramAllocation2) {
        aC(paramAllocation1, paramAllocation2, null);
    }

    public void aC(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(84, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void aD(Allocation paramAllocation1, Allocation paramAllocation2) {
        aD(paramAllocation1, paramAllocation2, null);
    }

    public void aD(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(85, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void aE(Allocation paramAllocation1, Allocation paramAllocation2) {
        aE(paramAllocation1, paramAllocation2, null);
    }

    public void aE(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(86, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void aF(Allocation paramAllocation1, Allocation paramAllocation2) {
        aF(paramAllocation1, paramAllocation2, null);
    }

    public void aF(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(87, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void aG(Allocation paramAllocation1, Allocation paramAllocation2) {
        aG(paramAllocation1, paramAllocation2, null);
    }

    public void aG(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(89, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void aH(Allocation paramAllocation1, Allocation paramAllocation2) {
        aH(paramAllocation1, paramAllocation2, null);
    }

    public void aH(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(90, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void aI(Allocation paramAllocation1, Allocation paramAllocation2) {
        aI(paramAllocation1, paramAllocation2, null);
    }

    public void aI(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(91, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void aJ(Allocation paramAllocation1, Allocation paramAllocation2) {
        aJ(paramAllocation1, paramAllocation2, null);
    }

    public void aJ(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(92, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void aK(Allocation paramAllocation1, Allocation paramAllocation2) {
        aK(paramAllocation1, paramAllocation2, null);
    }

    public void aK(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(93, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void aL(Allocation paramAllocation1, Allocation paramAllocation2) {
        aL(paramAllocation1, paramAllocation2, null);
    }

    public void aL(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(94, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void aM(Allocation paramAllocation1, Allocation paramAllocation2) {
        aM(paramAllocation1, paramAllocation2, null);
    }

    public void aM(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(95, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void aN(Allocation paramAllocation1, Allocation paramAllocation2) {
        aN(paramAllocation1, paramAllocation2, null);
    }

    public void aN(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(96, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void aO(Allocation paramAllocation1, Allocation paramAllocation2) {
        aO(paramAllocation1, paramAllocation2, null);
    }

    public void aO(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(97, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void aP(Allocation paramAllocation1, Allocation paramAllocation2) {
        aQ(paramAllocation1, paramAllocation2, null);
    }

    public void aP(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(98, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void aQ(Allocation paramAllocation1, Allocation paramAllocation2) {
        aR(paramAllocation1, paramAllocation2, null);
    }

    public void aQ(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(99, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void aR(Allocation paramAllocation1, Allocation paramAllocation2) {
        aS(paramAllocation1, paramAllocation2, null);
    }

    public void aR(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(100, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void aS(Allocation paramAllocation1, Allocation paramAllocation2) {
        aT(paramAllocation1, paramAllocation2, null);
    }

    public void aS(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(101, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void aT(Allocation paramAllocation1, Allocation paramAllocation2) {
        aU(paramAllocation1, paramAllocation2, null);
    }

    public void aT(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(102, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void aU(Allocation paramAllocation1, Allocation paramAllocation2) {
        aV(paramAllocation1, paramAllocation2, null);
    }

    public void aU(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.c)) {
            throw new RSRuntimeException("Type mismatch with F32!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.c)) {
            throw new RSRuntimeException("Type mismatch with F32!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(103, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void aV(Allocation paramAllocation1, Allocation paramAllocation2) {
        aW(paramAllocation1, paramAllocation2, null);
    }

    public void aV(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(104, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void aW(Allocation paramAllocation1, Allocation paramAllocation2) {
        aX(paramAllocation1, paramAllocation2, null);
    }

    public void aW(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(105, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void aX(Allocation paramAllocation1, Allocation paramAllocation2) {
        aY(paramAllocation1, paramAllocation2, null);
    }

    public void aX(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(106, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void aY(Allocation paramAllocation1, Allocation paramAllocation2) {
        aZ(paramAllocation1, paramAllocation2, null);
    }

    public void aY(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(107, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void aZ(Allocation paramAllocation1, Allocation paramAllocation2) {
        ba(paramAllocation1, paramAllocation2, null);
    }

    public void aZ(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(108, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void aa(Allocation paramAllocation1, Allocation paramAllocation2) {
        aa(paramAllocation1, paramAllocation2, null);
    }

    public void aa(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(56, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void ab(Allocation paramAllocation1, Allocation paramAllocation2) {
        ab(paramAllocation1, paramAllocation2, null);
    }

    public void ab(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(57, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void ac(Allocation paramAllocation1, Allocation paramAllocation2) {
        ac(paramAllocation1, paramAllocation2, null);
    }

    public void ac(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(58, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void ad(Allocation paramAllocation1, Allocation paramAllocation2) {
        ad(paramAllocation1, paramAllocation2, null);
    }

    public void ad(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(59, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void ae(Allocation paramAllocation1, Allocation paramAllocation2) {
        ae(paramAllocation1, paramAllocation2, null);
    }

    public void ae(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(60, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void af(Allocation paramAllocation1, Allocation paramAllocation2) {
        af(paramAllocation1, paramAllocation2, null);
    }

    public void af(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(61, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void ag(Allocation paramAllocation1, Allocation paramAllocation2) {
        ag(paramAllocation1, paramAllocation2, null);
    }

    public void ag(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(62, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void ah(Allocation paramAllocation1, Allocation paramAllocation2) {
        ah(paramAllocation1, paramAllocation2, null);
    }

    public void ah(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(63, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void ai(Allocation paramAllocation1, Allocation paramAllocation2) {
        ai(paramAllocation1, paramAllocation2, null);
    }

    public void ai(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(64, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void aj(Allocation paramAllocation1, Allocation paramAllocation2) {
        aj(paramAllocation1, paramAllocation2, null);
    }

    public void aj(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(65, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void ak(Allocation paramAllocation1, Allocation paramAllocation2) {
        ak(paramAllocation1, paramAllocation2, null);
    }

    public void ak(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(66, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void al(Allocation paramAllocation1, Allocation paramAllocation2) {
        al(paramAllocation1, paramAllocation2, null);
    }

    public void al(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(67, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void am(Allocation paramAllocation1, Allocation paramAllocation2) {
        am(paramAllocation1, paramAllocation2, null);
    }

    public void am(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(68, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void an(Allocation paramAllocation1, Allocation paramAllocation2) {
        an(paramAllocation1, paramAllocation2, null);
    }

    public void an(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(69, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void ao(Allocation paramAllocation1, Allocation paramAllocation2) {
        ao(paramAllocation1, paramAllocation2, null);
    }

    public void ao(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(70, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void ap(Allocation paramAllocation1, Allocation paramAllocation2) {
        ap(paramAllocation1, paramAllocation2, null);
    }

    public void ap(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(71, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void aq(Allocation paramAllocation1, Allocation paramAllocation2) {
        aq(paramAllocation1, paramAllocation2, null);
    }

    public void aq(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(72, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void ar(Allocation paramAllocation1, Allocation paramAllocation2) {
        ar(paramAllocation1, paramAllocation2, null);
    }

    public void ar(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(73, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void as(Allocation paramAllocation1, Allocation paramAllocation2) {
        as(paramAllocation1, paramAllocation2, null);
    }

    public void as(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(74, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void at(Allocation paramAllocation1, Allocation paramAllocation2) {
        at(paramAllocation1, paramAllocation2, null);
    }

    public void at(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(75, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void au(Allocation paramAllocation1, Allocation paramAllocation2) {
        au(paramAllocation1, paramAllocation2, null);
    }

    public void au(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(76, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void av(Allocation paramAllocation1, Allocation paramAllocation2) {
        av(paramAllocation1, paramAllocation2, null);
    }

    public void av(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(77, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void aw(Allocation paramAllocation1, Allocation paramAllocation2) {
        aw(paramAllocation1, paramAllocation2, null);
    }

    public void aw(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(78, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void ax(Allocation paramAllocation1, Allocation paramAllocation2) {
        ax(paramAllocation1, paramAllocation2, null);
    }

    public void ax(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(79, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void ay(Allocation paramAllocation1, Allocation paramAllocation2) {
        ay(paramAllocation1, paramAllocation2, null);
    }

    public void ay(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(80, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void az(Allocation paramAllocation1, Allocation paramAllocation2) {
        az(paramAllocation1, paramAllocation2, null);
    }

    public void az(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(81, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void b() {
        invoke(2);
    }

    public void b(float paramFloat) {
        try {
            setVar(31, paramFloat);
            this.F = paramFloat;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void b(int paramInt) {
        try {
            setVar(70, paramInt);
            this.as = paramInt;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void b(Allocation paramAllocation) {
        try {
            setVar(11, paramAllocation);
            this.v = paramAllocation;
            return;
        } finally {
            paramAllocation =finally;
            throw paramAllocation;
        }
    }

    public void b(Allocation paramAllocation1, Allocation paramAllocation2) {
        b(paramAllocation1, paramAllocation2, null);
    }

    public void b(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(2, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void b(Allocation paramAllocation, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        forEach(10, paramAllocation, null, null, paramLaunchOptions);
    }

    public void b(Float2 paramFloat2) {
        try {
            this.ba = paramFloat2;
            FieldPacker localFieldPacker = new FieldPacker(8);
            localFieldPacker.addF32(paramFloat2);
            setVar(106, localFieldPacker, this.d, new int[]{4});
            return;
        } finally {
            paramFloat2 =finally;
            throw paramFloat2;
        }
    }

    public void b(Float3 paramFloat3) {
        try {
            this.aK = paramFloat3;
            FieldPacker localFieldPacker = new FieldPacker(16);
            localFieldPacker.addF32(paramFloat3);
            setVar(90, localFieldPacker, this.e, new int[]{4});
            return;
        } finally {
            paramFloat3 =finally;
            throw paramFloat3;
        }
    }

    public void b(Float4 paramFloat4) {
        try {
            this.bm = paramFloat4;
            FieldPacker localFieldPacker = new FieldPacker(16);
            localFieldPacker.addF32(paramFloat4);
            setVar(118, localFieldPacker, this.f, new int[]{4});
            return;
        } finally {
            paramFloat4 =finally;
            throw paramFloat4;
        }
    }

    /* Error */
    public void b(boolean paramBoolean) {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: getfield 485	com/everimaging/fotorsdk/algorithms/filter/d:k	Landroid/support/v8/renderscript/FieldPacker;
        //   6: ifnull +36 -> 42
        //   9: aload_0
        //   10: getfield 485	com/everimaging/fotorsdk/algorithms/filter/d:k	Landroid/support/v8/renderscript/FieldPacker;
        //   13: invokevirtual 488	android/support/v8/renderscript/FieldPacker:reset	()V
        //   16: aload_0
        //   17: getfield 485	com/everimaging/fotorsdk/algorithms/filter/d:k	Landroid/support/v8/renderscript/FieldPacker;
        //   20: iload_1
        //   21: invokevirtual 491	android/support/v8/renderscript/FieldPacker:addBoolean	(Z)V
        //   24: aload_0
        //   25: bipush 68
        //   27: aload_0
        //   28: getfield 485	com/everimaging/fotorsdk/algorithms/filter/d:k	Landroid/support/v8/renderscript/FieldPacker;
        //   31: invokevirtual 494	com/everimaging/fotorsdk/algorithms/filter/d:setVar	(ILandroid/support/v8/renderscript/FieldPacker;)V
        //   34: aload_0
        //   35: iload_1
        //   36: putfield 619	com/everimaging/fotorsdk/algorithms/filter/d:aq	Z
        //   39: aload_0
        //   40: monitorexit
        //   41: return
        //   42: aload_0
        //   43: new 461	android/support/v8/renderscript/FieldPacker
        //   46: dup
        //   47: iconst_1
        //   48: invokespecial 463	android/support/v8/renderscript/FieldPacker:<init>	(I)V
        //   51: putfield 485	com/everimaging/fotorsdk/algorithms/filter/d:k	Landroid/support/v8/renderscript/FieldPacker;
        //   54: goto -38 -> 16
        //   57: astore_2
        //   58: aload_0
        //   59: monitorexit
        //   60: aload_2
        //   61: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	62	0	this	d
        //   0	62	1	paramBoolean	boolean
        //   57	4	2	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	16	57	finally
        //   16	39	57	finally
        //   42	54	57	finally
    }

    public void ba(Allocation paramAllocation1, Allocation paramAllocation2) {
        bb(paramAllocation1, paramAllocation2, null);
    }

    public void ba(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(110, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void bb(Allocation paramAllocation1, Allocation paramAllocation2) {
        bc(paramAllocation1, paramAllocation2, null);
    }

    public void bb(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(111, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void bc(Allocation paramAllocation1, Allocation paramAllocation2) {
        bd(paramAllocation1, paramAllocation2, null);
    }

    public void bc(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(112, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void bd(Allocation paramAllocation1, Allocation paramAllocation2) {
        be(paramAllocation1, paramAllocation2, null);
    }

    public void bd(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(113, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void be(Allocation paramAllocation1, Allocation paramAllocation2) {
        bf(paramAllocation1, paramAllocation2, null);
    }

    public void be(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(114, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void bf(Allocation paramAllocation1, Allocation paramAllocation2) {
        bg(paramAllocation1, paramAllocation2, null);
    }

    public void bf(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(115, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void bg(Allocation paramAllocation1, Allocation paramAllocation2) {
        bh(paramAllocation1, paramAllocation2, null);
    }

    public void bg(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(116, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void bh(Allocation paramAllocation1, Allocation paramAllocation2) {
        bi(paramAllocation1, paramAllocation2, null);
    }

    public void bh(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(117, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void bi(Allocation paramAllocation1, Allocation paramAllocation2) {
        bj(paramAllocation1, paramAllocation2, null);
    }

    public void bi(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(118, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void bj(Allocation paramAllocation1, Allocation paramAllocation2) {
        bk(paramAllocation1, paramAllocation2, null);
    }

    public void bj(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(119, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void bk(Allocation paramAllocation1, Allocation paramAllocation2) {
        bl(paramAllocation1, paramAllocation2, null);
    }

    public void bk(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(120, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void bl(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(121, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void c() {
        invoke(3);
    }

    public void c(float paramFloat) {
        try {
            setVar(32, paramFloat);
            this.G = paramFloat;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void c(int paramInt) {
        try {
            setVar(71, paramInt);
            this.at = paramInt;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void c(Allocation paramAllocation) {
        try {
            setVar(12, paramAllocation);
            this.w = paramAllocation;
            return;
        } finally {
            paramAllocation =finally;
            throw paramAllocation;
        }
    }

    public void c(Allocation paramAllocation1, Allocation paramAllocation2) {
        c(paramAllocation1, paramAllocation2, null);
    }

    public void c(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(3, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void c(Float2 paramFloat2) {
        try {
            this.bb = paramFloat2;
            FieldPacker localFieldPacker = new FieldPacker(8);
            localFieldPacker.addF32(paramFloat2);
            setVar(107, localFieldPacker, this.d, new int[]{4});
            return;
        } finally {
            paramFloat2 =finally;
            throw paramFloat2;
        }
    }

    public void c(Float3 paramFloat3) {
        try {
            this.aL = paramFloat3;
            FieldPacker localFieldPacker = new FieldPacker(16);
            localFieldPacker.addF32(paramFloat3);
            setVar(91, localFieldPacker, this.e, new int[]{4});
            return;
        } finally {
            paramFloat3 =finally;
            throw paramFloat3;
        }
    }

    public void c(Float4 paramFloat4) {
        try {
            this.bq = paramFloat4;
            FieldPacker localFieldPacker = new FieldPacker(16);
            localFieldPacker.addF32(paramFloat4);
            setVar(122, localFieldPacker, this.f, new int[]{4});
            return;
        } finally {
            paramFloat4 =finally;
            throw paramFloat4;
        }
    }

    public void d() {
        invoke(4);
    }

    public void d(float paramFloat) {
        try {
            setVar(33, paramFloat);
            this.H = paramFloat;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void d(int paramInt) {
        try {
            setVar(72, paramInt);
            this.au = paramInt;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void d(Allocation paramAllocation) {
        try {
            setVar(13, paramAllocation);
            this.x = paramAllocation;
            return;
        } finally {
            paramAllocation =finally;
            throw paramAllocation;
        }
    }

    public void d(Allocation paramAllocation1, Allocation paramAllocation2) {
        d(paramAllocation1, paramAllocation2, null);
    }

    public void d(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.c)) {
            throw new RSRuntimeException("Type mismatch with F32!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.c)) {
            throw new RSRuntimeException("Type mismatch with F32!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(4, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void d(Float2 paramFloat2) {
        try {
            this.bg = paramFloat2;
            FieldPacker localFieldPacker = new FieldPacker(8);
            localFieldPacker.addF32(paramFloat2);
            setVar(112, localFieldPacker, this.d, new int[]{4});
            return;
        } finally {
            paramFloat2 =finally;
            throw paramFloat2;
        }
    }

    public void d(Float3 paramFloat3) {
        try {
            this.aM = paramFloat3;
            FieldPacker localFieldPacker = new FieldPacker(16);
            localFieldPacker.addF32(paramFloat3);
            setVar(92, localFieldPacker, this.e, new int[]{4});
            return;
        } finally {
            paramFloat3 =finally;
            throw paramFloat3;
        }
    }

    public void e() {
        invoke(5);
    }

    public void e(float paramFloat) {
        try {
            setVar(34, paramFloat);
            this.I = paramFloat;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void e(int paramInt) {
        try {
            setVar(73, paramInt);
            this.av = paramInt;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void e(Allocation paramAllocation) {
        try {
            setVar(14, paramAllocation);
            this.y = paramAllocation;
            return;
        } finally {
            paramAllocation =finally;
            throw paramAllocation;
        }
    }

    public void e(Allocation paramAllocation1, Allocation paramAllocation2) {
        e(paramAllocation1, paramAllocation2, null);
    }

    public void e(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(5, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void e(Float2 paramFloat2) {
        try {
            this.bh = paramFloat2;
            FieldPacker localFieldPacker = new FieldPacker(8);
            localFieldPacker.addF32(paramFloat2);
            setVar(113, localFieldPacker, this.d, new int[]{4});
            return;
        } finally {
            paramFloat2 =finally;
            throw paramFloat2;
        }
    }

    public void e(Float3 paramFloat3) {
        try {
            this.aN = paramFloat3;
            FieldPacker localFieldPacker = new FieldPacker(16);
            localFieldPacker.addF32(paramFloat3);
            setVar(93, localFieldPacker, this.e, new int[]{4});
            return;
        } finally {
            paramFloat3 =finally;
            throw paramFloat3;
        }
    }

    public void f() {
        invoke(6);
    }

    public void f(float paramFloat) {
        try {
            setVar(35, paramFloat);
            this.J = paramFloat;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void f(int paramInt) {
        try {
            setVar(74, paramInt);
            this.aw = paramInt;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void f(Allocation paramAllocation) {
        try {
            setVar(16, paramAllocation);
            this.z = paramAllocation;
            return;
        } finally {
            paramAllocation =finally;
            throw paramAllocation;
        }
    }

    public void f(Allocation paramAllocation1, Allocation paramAllocation2) {
        f(paramAllocation1, paramAllocation2, null);
    }

    public void f(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(6, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void f(Float2 paramFloat2) {
        try {
            this.bj = paramFloat2;
            FieldPacker localFieldPacker = new FieldPacker(8);
            localFieldPacker.addF32(paramFloat2);
            setVar(115, localFieldPacker, this.d, new int[]{4});
            return;
        } finally {
            paramFloat2 =finally;
            throw paramFloat2;
        }
    }

    public void f(Float3 paramFloat3) {
        try {
            this.aO = paramFloat3;
            FieldPacker localFieldPacker = new FieldPacker(16);
            localFieldPacker.addF32(paramFloat3);
            setVar(94, localFieldPacker, this.e, new int[]{4});
            return;
        } finally {
            paramFloat3 =finally;
            throw paramFloat3;
        }
    }

    public void g(float paramFloat) {
        try {
            setVar(36, paramFloat);
            this.K = paramFloat;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void g(int paramInt) {
        try {
            setVar(75, paramInt);
            this.ax = paramInt;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void g(Allocation paramAllocation) {
        try {
            setVar(26, paramAllocation);
            this.A = paramAllocation;
            return;
        } finally {
            paramAllocation =finally;
            throw paramAllocation;
        }
    }

    public void g(Allocation paramAllocation1, Allocation paramAllocation2) {
        g(paramAllocation1, paramAllocation2, null);
    }

    public void g(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(7, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void g(Float2 paramFloat2) {
        try {
            this.br = paramFloat2;
            FieldPacker localFieldPacker = new FieldPacker(8);
            localFieldPacker.addF32(paramFloat2);
            setVar(123, localFieldPacker, this.d, new int[]{4});
            return;
        } finally {
            paramFloat2 =finally;
            throw paramFloat2;
        }
    }

    public void g(Float3 paramFloat3) {
        try {
            this.aP = paramFloat3;
            FieldPacker localFieldPacker = new FieldPacker(16);
            localFieldPacker.addF32(paramFloat3);
            setVar(95, localFieldPacker, this.e, new int[]{4});
            return;
        } finally {
            paramFloat3 =finally;
            throw paramFloat3;
        }
    }

    public void h(float paramFloat) {
        try {
            setVar(37, paramFloat);
            this.L = paramFloat;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void h(int paramInt) {
        try {
            setVar(76, paramInt);
            this.ay = paramInt;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void h(Allocation paramAllocation) {
        try {
            setVar(27, paramAllocation);
            this.B = paramAllocation;
            return;
        } finally {
            paramAllocation =finally;
            throw paramAllocation;
        }
    }

    public void h(Allocation paramAllocation1, Allocation paramAllocation2) {
        h(paramAllocation1, paramAllocation2, null);
    }

    public void h(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.c)) {
            throw new RSRuntimeException("Type mismatch with F32!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.c)) {
            throw new RSRuntimeException("Type mismatch with F32!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(8, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void h(Float2 paramFloat2) {
        try {
            this.bs = paramFloat2;
            FieldPacker localFieldPacker = new FieldPacker(8);
            localFieldPacker.addF32(paramFloat2);
            setVar(124, localFieldPacker, this.d, new int[]{4});
            return;
        } finally {
            paramFloat2 =finally;
            throw paramFloat2;
        }
    }

    public void h(Float3 paramFloat3) {
        try {
            this.aQ = paramFloat3;
            FieldPacker localFieldPacker = new FieldPacker(16);
            localFieldPacker.addF32(paramFloat3);
            setVar(96, localFieldPacker, this.e, new int[]{4});
            return;
        } finally {
            paramFloat3 =finally;
            throw paramFloat3;
        }
    }

    public void i(float paramFloat) {
        try {
            setVar(38, paramFloat);
            this.M = paramFloat;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void i(int paramInt) {
        try {
            setVar(77, paramInt);
            this.az = paramInt;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void i(Allocation paramAllocation) {
        try {
            setVar(28, paramAllocation);
            this.C = paramAllocation;
            return;
        } finally {
            paramAllocation =finally;
            throw paramAllocation;
        }
    }

    public void i(Allocation paramAllocation1, Allocation paramAllocation2) {
        i(paramAllocation1, paramAllocation2, null);
    }

    public void i(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(11, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void i(Float3 paramFloat3) {
        try {
            this.aR = paramFloat3;
            FieldPacker localFieldPacker = new FieldPacker(16);
            localFieldPacker.addF32(paramFloat3);
            setVar(97, localFieldPacker, this.e, new int[]{4});
            return;
        } finally {
            paramFloat3 =finally;
            throw paramFloat3;
        }
    }

    public void j(float paramFloat) {
        try {
            setVar(39, paramFloat);
            this.N = paramFloat;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void j(int paramInt) {
        try {
            setVar(78, paramInt);
            this.aA = paramInt;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void j(Allocation paramAllocation) {
        this.aC = paramAllocation;
        if (paramAllocation == null) {
            bindAllocation(null, 80);
            return;
        }
        bindAllocation(paramAllocation, 80);
    }

    public void j(Allocation paramAllocation1, Allocation paramAllocation2) {
        j(paramAllocation1, paramAllocation2, null);
    }

    public void j(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(12, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void j(Float3 paramFloat3) {
        try {
            this.aS = paramFloat3;
            FieldPacker localFieldPacker = new FieldPacker(16);
            localFieldPacker.addF32(paramFloat3);
            setVar(98, localFieldPacker, this.e, new int[]{4});
            return;
        } finally {
            paramFloat3 =finally;
            throw paramFloat3;
        }
    }

    public void k(float paramFloat) {
        try {
            setVar(40, paramFloat);
            this.O = paramFloat;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void k(int paramInt) {
        try {
            setVar(79, paramInt);
            this.aB = paramInt;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void k(Allocation paramAllocation) {
        this.aD = paramAllocation;
        if (paramAllocation == null) {
            bindAllocation(null, 81);
            return;
        }
        bindAllocation(paramAllocation, 81);
    }

    public void k(Allocation paramAllocation1, Allocation paramAllocation2) {
        k(paramAllocation1, paramAllocation2, null);
    }

    public void k(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(13, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void k(Float3 paramFloat3) {
        try {
            this.aT = paramFloat3;
            FieldPacker localFieldPacker = new FieldPacker(16);
            localFieldPacker.addF32(paramFloat3);
            setVar(99, localFieldPacker, this.e, new int[]{4});
            return;
        } finally {
            paramFloat3 =finally;
            throw paramFloat3;
        }
    }

    public void l(float paramFloat) {
        try {
            setVar(41, paramFloat);
            this.P = paramFloat;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void l(int paramInt) {
        try {
            setVar(121, paramInt);
            this.bp = paramInt;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void l(Allocation paramAllocation) {
        this.aE = paramAllocation;
        if (paramAllocation == null) {
            bindAllocation(null, 82);
            return;
        }
        bindAllocation(paramAllocation, 82);
    }

    public void l(Allocation paramAllocation1, Allocation paramAllocation2) {
        l(paramAllocation1, paramAllocation2, null);
    }

    public void l(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(14, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void l(Float3 paramFloat3) {
        try {
            this.aU = paramFloat3;
            FieldPacker localFieldPacker = new FieldPacker(16);
            localFieldPacker.addF32(paramFloat3);
            setVar(100, localFieldPacker, this.e, new int[]{4});
            return;
        } finally {
            paramFloat3 =finally;
            throw paramFloat3;
        }
    }

    public void m(float paramFloat) {
        try {
            setVar(42, paramFloat);
            this.Q = paramFloat;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void m(int paramInt) {
        try {
            setVar(125, paramInt);
            this.bt = paramInt;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void m(Allocation paramAllocation) {
        this.aF = paramAllocation;
        if (paramAllocation == null) {
            bindAllocation(null, 83);
            return;
        }
        bindAllocation(paramAllocation, 83);
    }

    public void m(Allocation paramAllocation1, Allocation paramAllocation2) {
        m(paramAllocation1, paramAllocation2, null);
    }

    public void m(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(15, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void m(Float3 paramFloat3) {
        try {
            this.aV = paramFloat3;
            FieldPacker localFieldPacker = new FieldPacker(16);
            localFieldPacker.addF32(paramFloat3);
            setVar(101, localFieldPacker, this.e, new int[]{4});
            return;
        } finally {
            paramFloat3 =finally;
            throw paramFloat3;
        }
    }

    public void n(float paramFloat) {
        try {
            setVar(43, paramFloat);
            this.R = paramFloat;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void n(int paramInt) {
        try {
            setVar(126, paramInt);
            this.bu = paramInt;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void n(Allocation paramAllocation) {
        this.aG = paramAllocation;
        if (paramAllocation == null) {
            bindAllocation(null, 84);
            return;
        }
        bindAllocation(paramAllocation, 84);
    }

    public void n(Allocation paramAllocation1, Allocation paramAllocation2) {
        n(paramAllocation1, paramAllocation2, null);
    }

    public void n(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(16, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void n(Float3 paramFloat3) {
        try {
            this.aW = paramFloat3;
            FieldPacker localFieldPacker = new FieldPacker(16);
            localFieldPacker.addF32(paramFloat3);
            setVar(102, localFieldPacker, this.e, new int[]{4});
            return;
        } finally {
            paramFloat3 =finally;
            throw paramFloat3;
        }
    }

    public void o(float paramFloat) {
        try {
            setVar(44, paramFloat);
            this.S = paramFloat;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void o(int paramInt) {
        try {
            setVar(127, paramInt);
            this.bv = paramInt;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void o(Allocation paramAllocation) {
        this.aH = paramAllocation;
        if (paramAllocation == null) {
            bindAllocation(null, 85);
            return;
        }
        bindAllocation(paramAllocation, 85);
    }

    public void o(Allocation paramAllocation1, Allocation paramAllocation2) {
        o(paramAllocation1, paramAllocation2, null);
    }

    public void o(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(17, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void p(float paramFloat) {
        try {
            setVar(45, paramFloat);
            this.T = paramFloat;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void p(int paramInt) {
        try {
            setVar(128, paramInt);
            this.bw = paramInt;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void p(Allocation paramAllocation) {
        this.aI = paramAllocation;
        if (paramAllocation == null) {
            bindAllocation(null, 86);
            return;
        }
        bindAllocation(paramAllocation, 86);
    }

    public void p(Allocation paramAllocation1, Allocation paramAllocation2) {
        p(paramAllocation1, paramAllocation2, null);
    }

    public void p(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(18, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void q(float paramFloat) {
        try {
            setVar(46, paramFloat);
            this.U = paramFloat;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void q(Allocation paramAllocation) {
        a(paramAllocation, null);
    }

    public void q(Allocation paramAllocation1, Allocation paramAllocation2) {
        q(paramAllocation1, paramAllocation2, null);
    }

    public void q(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(20, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void r(float paramFloat) {
        try {
            setVar(47, paramFloat);
            this.V = paramFloat;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void r(Allocation paramAllocation) {
        b(paramAllocation, null);
    }

    public void r(Allocation paramAllocation1, Allocation paramAllocation2) {
        r(paramAllocation1, paramAllocation2, null);
    }

    public void r(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(21, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void s(float paramFloat) {
        try {
            setVar(48, paramFloat);
            this.W = paramFloat;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void s(Allocation paramAllocation1, Allocation paramAllocation2) {
        s(paramAllocation1, paramAllocation2, null);
    }

    public void s(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(22, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void t(float paramFloat) {
        try {
            setVar(49, paramFloat);
            this.X = paramFloat;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void t(Allocation paramAllocation1, Allocation paramAllocation2) {
        t(paramAllocation1, paramAllocation2, null);
    }

    public void t(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(23, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void u(float paramFloat) {
        try {
            setVar(50, paramFloat);
            this.Y = paramFloat;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void u(Allocation paramAllocation1, Allocation paramAllocation2) {
        u(paramAllocation1, paramAllocation2, null);
    }

    public void u(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(24, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void v(float paramFloat) {
        try {
            setVar(51, paramFloat);
            this.Z = paramFloat;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void v(Allocation paramAllocation1, Allocation paramAllocation2) {
        v(paramAllocation1, paramAllocation2, null);
    }

    public void v(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(25, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void w(float paramFloat) {
        try {
            setVar(52, paramFloat);
            this.aa = paramFloat;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void w(Allocation paramAllocation1, Allocation paramAllocation2) {
        w(paramAllocation1, paramAllocation2, null);
    }

    public void w(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(26, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void x(float paramFloat) {
        try {
            setVar(53, paramFloat);
            this.ab = paramFloat;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void x(Allocation paramAllocation1, Allocation paramAllocation2) {
        x(paramAllocation1, paramAllocation2, null);
    }

    public void x(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.c)) {
            throw new RSRuntimeException("Type mismatch with F32!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.c)) {
            throw new RSRuntimeException("Type mismatch with F32!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(27, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void y(float paramFloat) {
        try {
            setVar(54, paramFloat);
            this.ac = paramFloat;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void y(Allocation paramAllocation1, Allocation paramAllocation2) {
        y(paramAllocation1, paramAllocation2, null);
    }

    public void y(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(28, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }

    public void z(float paramFloat) {
        try {
            setVar(55, paramFloat);
            this.ad = paramFloat;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void z(Allocation paramAllocation1, Allocation paramAllocation2) {
        z(paramAllocation1, paramAllocation2, null);
    }

    public void z(Allocation paramAllocation1, Allocation paramAllocation2, Script.LaunchOptions paramLaunchOptions) {
        if (!paramAllocation1.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!paramAllocation2.getType().getElement().isCompatible(this.j)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type localType1 = paramAllocation1.getType();
        Type localType2 = paramAllocation2.getType();
        if ((localType1.getCount() != localType2.getCount()) || (localType1.getX() != localType2.getX()) || (localType1.getY() != localType2.getY()) || (localType1.getZ() != localType2.getZ()) || (localType1.hasFaces() != localType2.hasFaces()) || (localType1.hasMipmaps() != localType2.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(29, paramAllocation1, paramAllocation2, null, paramLaunchOptions);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/filter/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */