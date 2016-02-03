package com.everimaging.fotorsdk.algorithms.xml.entity;

import com.everimaging.fotorsdk.algorithms.f;
import com.everimaging.fotorsdk.algorithms.params.base.RSBaseParams;
import com.everimaging.fotorsdk.algorithms.parser.RSBaseFilterFactory;
import com.everimaging.fotorsdk.algorithms.parser.RSBaseFilterFactory.BaseFilter;

public class BaseFilterEntity {
    private RSBaseFilterFactory.BaseFilter mBaseFilter = null;
    private AllocationEntityBorders mBorder;
    private AllocationEntity mDst = null;
    private RSBaseParams mParams;
    private f mRSFilter = null;
    private AllocationEntity mSrc = null;
    private AllocationEntity mTableTex = null;
    private AllocationEntity mTex = null;

    private static RSBaseFilterFactory.BaseFilter toBaseFilter(String paramString) {
        if (paramString.equals("AnisotropicDiffusion")) {
            return RSBaseFilterFactory.BaseFilter.ANISOTROPIC_DIFFUSION;
        }
        if (paramString.equals("Bright")) {
            return RSBaseFilterFactory.BaseFilter.BRIGHT;
        }
        if (paramString.equals("Brightness")) {
            return RSBaseFilterFactory.BaseFilter.BRIGHTNESS;
        }
        if (paramString.equals("ColorNegLum")) {
            return RSBaseFilterFactory.BaseFilter.COLOR_NEG_LUM;
        }
        if (paramString.equals("ConstColor")) {
            return RSBaseFilterFactory.BaseFilter.CONST_COLOR;
        }
        if (paramString.equals("Contrast")) {
            return RSBaseFilterFactory.BaseFilter.CONTRAST;
        }
        if (paramString.equals("Curve")) {
            return RSBaseFilterFactory.BaseFilter.CURVE;
        }
        if (paramString.equals("DifferenceBlend")) {
            return RSBaseFilterFactory.BaseFilter.DIFFERENCE_BLEND;
        }
        if (paramString.equals("Discoloration")) {
            return RSBaseFilterFactory.BaseFilter.DISCOLORATION;
        }
        if (paramString.equals("EdgeDetection")) {
            return RSBaseFilterFactory.BaseFilter.EDGE_DETECTON;
        }
        if (paramString.equals("Emboss")) {
            return RSBaseFilterFactory.BaseFilter.EMBOSS;
        }
        if (paramString.equals("Facet")) {
            return RSBaseFilterFactory.BaseFilter.FACET;
        }
        if (paramString.equals("Frame")) {
            return RSBaseFilterFactory.BaseFilter.FRAME;
        }
        if (paramString.equals("Gamma")) {
            return RSBaseFilterFactory.BaseFilter.GAMMA;
        }
        if (paramString.equals("GradientColor")) {
            return RSBaseFilterFactory.BaseFilter.GRADIENT_COLOR;
        }
        if (paramString.equals("HalfTone")) {
            return RSBaseFilterFactory.BaseFilter.HALF_TONE;
        }
        if (paramString.equals("Highlights")) {
            return RSBaseFilterFactory.BaseFilter.HIGHLIGHTS;
        }
        if (paramString.equals("HSLAdjustment")) {
            return RSBaseFilterFactory.BaseFilter.HSL_ADJUSTMENT;
        }
        if (paramString.equals("HSVSaturation")) {
            return RSBaseFilterFactory.BaseFilter.HSV_SATURATION;
        }
        if (paramString.equals("Invert")) {
            return RSBaseFilterFactory.BaseFilter.INVERT;
        }
        if (paramString.equals("LayerBlend")) {
            return RSBaseFilterFactory.BaseFilter.LAYER_BLEND;
        }
        if (paramString.equals("Level")) {
            return RSBaseFilterFactory.BaseFilter.LEVEL;
        }
        if (paramString.equals("Mascara")) {
            return RSBaseFilterFactory.BaseFilter.MASCARA;
        }
        if (paramString.equals("Min")) {
            return RSBaseFilterFactory.BaseFilter.MIN;
        }
        if (paramString.equals("Monochrome")) {
            return RSBaseFilterFactory.BaseFilter.MONOCHROME;
        }
        if (paramString.equals("MultiplyMatrixPlusBias")) {
            return RSBaseFilterFactory.BaseFilter.MULTIPLY_MATRIX_PLUS_BIAS;
        }
        if (paramString.equals("Noise")) {
            return RSBaseFilterFactory.BaseFilter.NOISE;
        }
        if (paramString.equals("RedEyeRemover")) {
            return RSBaseFilterFactory.BaseFilter.RED_EYE_REMOVER;
        }
        if (paramString.equals("RGBAverage")) {
            return RSBaseFilterFactory.BaseFilter.RGB_AVERAGE;
        }
        if (paramString.equals("Saturation")) {
            return RSBaseFilterFactory.BaseFilter.SATURATION;
        }
        if (paramString.equals("Shadows")) {
            return RSBaseFilterFactory.BaseFilter.SHADOWS;
        }
        if (paramString.equals("Sharpening")) {
            return RSBaseFilterFactory.BaseFilter.SHARPENING;
        }
        if (paramString.equals("Sketch")) {
            return RSBaseFilterFactory.BaseFilter.SKETCH;
        }
        if (paramString.equals("Smooth")) {
            return RSBaseFilterFactory.BaseFilter.SMOOTH;
        }
        if (paramString.equals("SpecialTrans")) {
            return RSBaseFilterFactory.BaseFilter.SPECIAL_TRANS;
        }
        if (paramString.equals("TableTexture")) {
            return RSBaseFilterFactory.BaseFilter.TABLE_TEXTURE;
        }
        if (paramString.equals("Technicolor")) {
            return RSBaseFilterFactory.BaseFilter.TECHNICOLOR;
        }
        if (paramString.equals("TeethWhitening")) {
            return RSBaseFilterFactory.BaseFilter.TEETH_WHITENING;
        }
        if (paramString.equals("Vignette")) {
            return RSBaseFilterFactory.BaseFilter.VIGNETTE;
        }
        if (paramString.equals("WhiteBalance")) {
            return RSBaseFilterFactory.BaseFilter.WHITE_BALANCE;
        }
        return null;
    }

    public void finish() {
        this.mRSFilter = null;
    }

    public AllocationEntityBorders getBorder() {
        return this.mBorder;
    }

    public AllocationEntity getDst() {
        return this.mDst;
    }

    public RSBaseFilterFactory.BaseFilter getFilterType() {
        return this.mBaseFilter;
    }

    public RSBaseParams getParams() {
        return this.mParams;
    }

    public f getRSFilter() {
        if (this.mRSFilter == null) {
            this.mRSFilter = RSBaseFilterFactory.a(this.mBaseFilter, getParams());
        }
        return this.mRSFilter;
    }

    public AllocationEntity getSrc() {
        return this.mSrc;
    }

    public AllocationEntity getTableTex() {
        return this.mTableTex;
    }

    public AllocationEntity getTex() {
        return this.mTex;
    }

    public void release() {
        this.mSrc = null;
        this.mDst = null;
        this.mTex = null;
        this.mTableTex = null;
        if (this.mBorder != null) {
            this.mBorder.release();
        }
    }

    public void setBaseFilterType(RSBaseFilterFactory.BaseFilter paramBaseFilter) {
        this.mBaseFilter = paramBaseFilter;
    }

    public void setBaseFilterType(String paramString) {
        this.mBaseFilter = toBaseFilter(paramString);
    }

    public void setBorder(AllocationEntityBorders paramAllocationEntityBorders) {
        this.mBorder = paramAllocationEntityBorders;
    }

    public void setDst(AllocationEntity paramAllocationEntity) {
        this.mDst = paramAllocationEntity;
    }

    public void setParams(RSBaseParams paramRSBaseParams) {
        this.mParams = paramRSBaseParams;
    }

    public void setSrc(AllocationEntity paramAllocationEntity) {
        this.mSrc = paramAllocationEntity;
    }

    public void setTableTex(AllocationEntity paramAllocationEntity) {
        this.mTableTex = paramAllocationEntity;
    }

    public void setTex(AllocationEntity paramAllocationEntity) {
        this.mTex = paramAllocationEntity;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/xml/entity/BaseFilterEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */