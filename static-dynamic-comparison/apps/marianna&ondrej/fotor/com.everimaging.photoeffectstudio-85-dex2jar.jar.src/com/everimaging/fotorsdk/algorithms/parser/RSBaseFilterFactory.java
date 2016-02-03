package com.everimaging.fotorsdk.algorithms.parser;

import com.everimaging.fotorsdk.algorithms.filter.base.a;
import com.everimaging.fotorsdk.algorithms.filter.base.aa;
import com.everimaging.fotorsdk.algorithms.filter.base.ab;
import com.everimaging.fotorsdk.algorithms.filter.base.ac;
import com.everimaging.fotorsdk.algorithms.filter.base.ad;
import com.everimaging.fotorsdk.algorithms.filter.base.ae;
import com.everimaging.fotorsdk.algorithms.filter.base.af;
import com.everimaging.fotorsdk.algorithms.filter.base.ag;
import com.everimaging.fotorsdk.algorithms.filter.base.ah;
import com.everimaging.fotorsdk.algorithms.filter.base.ai;
import com.everimaging.fotorsdk.algorithms.filter.base.aj;
import com.everimaging.fotorsdk.algorithms.filter.base.ak;
import com.everimaging.fotorsdk.algorithms.filter.base.al;
import com.everimaging.fotorsdk.algorithms.filter.base.am;
import com.everimaging.fotorsdk.algorithms.filter.base.an;
import com.everimaging.fotorsdk.algorithms.filter.base.ao;
import com.everimaging.fotorsdk.algorithms.filter.base.b;
import com.everimaging.fotorsdk.algorithms.filter.base.c;
import com.everimaging.fotorsdk.algorithms.filter.base.d;
import com.everimaging.fotorsdk.algorithms.filter.base.e;
import com.everimaging.fotorsdk.algorithms.filter.base.g;
import com.everimaging.fotorsdk.algorithms.filter.base.h;
import com.everimaging.fotorsdk.algorithms.filter.base.i;
import com.everimaging.fotorsdk.algorithms.filter.base.j;
import com.everimaging.fotorsdk.algorithms.filter.base.k;
import com.everimaging.fotorsdk.algorithms.filter.base.l;
import com.everimaging.fotorsdk.algorithms.filter.base.m;
import com.everimaging.fotorsdk.algorithms.filter.base.n;
import com.everimaging.fotorsdk.algorithms.filter.base.o;
import com.everimaging.fotorsdk.algorithms.filter.base.p;
import com.everimaging.fotorsdk.algorithms.filter.base.q;
import com.everimaging.fotorsdk.algorithms.filter.base.r;
import com.everimaging.fotorsdk.algorithms.filter.base.s;
import com.everimaging.fotorsdk.algorithms.filter.base.t;
import com.everimaging.fotorsdk.algorithms.filter.base.u;
import com.everimaging.fotorsdk.algorithms.filter.base.v;
import com.everimaging.fotorsdk.algorithms.filter.base.w;
import com.everimaging.fotorsdk.algorithms.filter.base.x;
import com.everimaging.fotorsdk.algorithms.filter.base.y;
import com.everimaging.fotorsdk.algorithms.filter.base.z;
import com.everimaging.fotorsdk.algorithms.params.base.RSBaseParams;

public class RSBaseFilterFactory {
    public static com.everimaging.fotorsdk.algorithms.f a(BaseFilter paramBaseFilter, RSBaseParams paramRSBaseParams) {
        return paramBaseFilter.get(paramRSBaseParams);
    }

    public static abstract enum BaseFilter {
        ANISOTROPIC_DIFFUSION, BRIGHT, BRIGHTNESS, COLOR_NEG_LUM, CONST_COLOR, CONTRAST, CURVE, DIFFERENCE_BLEND, DISCOLORATION, EDGE_DETECTON, EMBOSS, FACET, FRAME, GAMMA, GRADIENT_COLOR, HALF_TONE, HIGHLIGHTS, HSL_ADJUSTMENT, HSV_SATURATION, INVERT, LAYER_BLEND, LEVEL, MASCARA, MIN, MONOCHROME, MULTIPLY_MATRIX_PLUS_BIAS, NOISE, RED_EYE_REMOVER, RGB_AVERAGE, SATURATION, SHADOWS, SHARPENING, SKETCH, SMOOTH, SPECIAL_TRANS, TABLE_TEXTURE, TECHNICOLOR, TEETH_WHITENING, TILT_SHIFT, VIGNETTE, WHITE_BALANCE;

        private BaseFilter() {
        }

        abstract com.everimaging.fotorsdk.algorithms.f get(RSBaseParams paramRSBaseParams);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/parser/RSBaseFilterFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */