package com.everimaging.fotorsdk.algorithms.params.base;

import android.support.v8.renderscript.Allocation;

public class RSCurveBaseFilterParams
        extends RSBaseParams {
    private float[] controlPoints;
    private float[] controlPointsB;
    private float[] controlPointsG;
    private float[] controlPointsR;
    private Allocation curveB;
    private Allocation curveG;
    private Allocation curveR;
    private ECurveMode mode;

    public float[] getControlPoints() {
        return this.controlPoints;
    }

    public float[] getControlPointsB() {
        return this.controlPointsB;
    }

    public float[] getControlPointsG() {
        return this.controlPointsG;
    }

    public float[] getControlPointsR() {
        return this.controlPointsR;
    }

    public Allocation getCurveB() {
        return this.curveB;
    }

    public Allocation getCurveG() {
        return this.curveG;
    }

    public Allocation getCurveR() {
        return this.curveR;
    }

    public ECurveMode getMode() {
        return this.mode;
    }

    public RSBaseParams.RSParamTypes getRSParamType() {
        return RSBaseParams.RSParamTypes.CURVE;
    }

    public void setControlPoints(float[] paramArrayOfFloat) {
        this.controlPoints = paramArrayOfFloat;
    }

    public void setControlPointsB(float[] paramArrayOfFloat) {
        this.controlPointsB = paramArrayOfFloat;
    }

    public void setControlPointsG(float[] paramArrayOfFloat) {
        this.controlPointsG = paramArrayOfFloat;
    }

    public void setControlPointsR(float[] paramArrayOfFloat) {
        this.controlPointsR = paramArrayOfFloat;
    }

    public void setCurveB(Allocation paramAllocation) {
        this.curveB = paramAllocation;
    }

    public void setCurveG(Allocation paramAllocation) {
        this.curveG = paramAllocation;
    }

    public void setCurveR(Allocation paramAllocation) {
        this.curveR = paramAllocation;
    }

    public void setMode(ECurveMode paramECurveMode) {
        this.mode = paramECurveMode;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/params/base/RSCurveBaseFilterParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */