package com.everimaging.fotorsdk.algorithms.xml.entity;

public class AllocationEntityBorders {
    private AllocationEntity mBottom = null;
    private AllocationEntity mLeft = null;
    private AllocationEntity mLeftBottom = null;
    private AllocationEntity mLeftTop = null;
    private AllocationEntity mRight = null;
    private AllocationEntity mRightBottom = null;
    private AllocationEntity mRightTop = null;
    private AllocationEntity mTop = null;
    private AllocationEntity mUnity;

    public AllocationEntity getBottom() {
        return this.mBottom;
    }

    public AllocationEntity getLeft() {
        return this.mLeft;
    }

    public AllocationEntity getLeftBottom() {
        return this.mLeftBottom;
    }

    public AllocationEntity getLeftTop() {
        return this.mLeftTop;
    }

    public AllocationEntity getRight() {
        return this.mRight;
    }

    public AllocationEntity getRightBottom() {
        return this.mRightBottom;
    }

    public AllocationEntity getRightTop() {
        return this.mRightTop;
    }

    public AllocationEntity getTop() {
        return this.mTop;
    }

    public AllocationEntity getUnity() {
        return this.mUnity;
    }

    public void release() {
        if (this.mLeftTop != null) {
            this.mLeftTop.release();
        }
        if (this.mTop != null) {
            this.mTop.release();
        }
        if (this.mRightTop != null) {
            this.mRightTop.release();
        }
        if (this.mRight != null) {
            this.mRight.release();
        }
        if (this.mRightBottom != null) {
            this.mRightBottom.release();
        }
        if (this.mBottom != null) {
            this.mBottom.release();
        }
        if (this.mLeftBottom != null) {
            this.mLeftBottom.release();
        }
        if (this.mLeft != null) {
            this.mLeft.release();
        }
        if (this.mUnity != null) {
            this.mUnity.release();
        }
    }

    public void setBottom(AllocationEntity paramAllocationEntity) {
        this.mBottom = paramAllocationEntity;
    }

    public void setLeft(AllocationEntity paramAllocationEntity) {
        this.mLeft = paramAllocationEntity;
    }

    public void setLeftBottom(AllocationEntity paramAllocationEntity) {
        this.mLeftBottom = paramAllocationEntity;
    }

    public void setLeftTop(AllocationEntity paramAllocationEntity) {
        this.mLeftTop = paramAllocationEntity;
    }

    public void setRight(AllocationEntity paramAllocationEntity) {
        this.mRight = paramAllocationEntity;
    }

    public void setRightBottom(AllocationEntity paramAllocationEntity) {
        this.mRightBottom = paramAllocationEntity;
    }

    public void setRightTop(AllocationEntity paramAllocationEntity) {
        this.mRightTop = paramAllocationEntity;
    }

    public void setTop(AllocationEntity paramAllocationEntity) {
        this.mTop = paramAllocationEntity;
    }

    public void setUnity(AllocationEntity paramAllocationEntity) {
        this.mUnity = paramAllocationEntity;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/xml/entity/AllocationEntityBorders.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */