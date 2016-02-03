package com.facebook.internal;

class WorkQueue$WorkNode
        implements WorkQueue.WorkItem {
    private final Runnable callback;
    private boolean isRunning;
    private WorkNode next;
    private WorkNode prev;

    static {
        if (!WorkQueue.class.desiredAssertionStatus()) {
        }
        for (boolean bool = true; ; bool = false) {
            $assertionsDisabled = bool;
            return;
        }
    }

    WorkQueue$WorkNode(WorkQueue paramWorkQueue, Runnable paramRunnable) {
        this.callback = paramRunnable;
    }

    WorkNode addToList(WorkNode paramWorkNode, boolean paramBoolean) {
        assert (this.next == null);
        assert (this.prev == null);
        if (paramWorkNode == null) {
            this.prev = this;
            this.next = this;
            paramWorkNode = this;
        }
        while (paramBoolean) {
            return this;
            this.next = paramWorkNode;
            this.prev = paramWorkNode.prev;
            WorkNode localWorkNode = this.next;
            this.prev.next = this;
            localWorkNode.prev = this;
        }
        return paramWorkNode;
    }

    public boolean cancel() {
        synchronized (WorkQueue.access$100(this.this$0)) {
            if (!isRunning()) {
                WorkQueue.access$202(this.this$0, removeFromList(WorkQueue.access$200(this.this$0)));
                return true;
            }
            return false;
        }
    }

    Runnable getCallback() {
        return this.callback;
    }

    WorkNode getNext() {
        return this.next;
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    public void moveToFront() {
        synchronized (WorkQueue.access$100(this.this$0)) {
            if (!isRunning()) {
                WorkQueue.access$202(this.this$0, removeFromList(WorkQueue.access$200(this.this$0)));
                WorkQueue.access$202(this.this$0, addToList(WorkQueue.access$200(this.this$0), true));
            }
            return;
        }
    }

    WorkNode removeFromList(WorkNode paramWorkNode) {
        assert (this.next != null);
        assert (this.prev != null);
        WorkNode localWorkNode = paramWorkNode;
        if (paramWorkNode == this) {
            if (this.next != this) {
                break label93;
            }
        }
        label93:
        for (localWorkNode = null; ; localWorkNode = this.next) {
            this.next.prev = this.prev;
            this.prev.next = this.next;
            this.prev = null;
            this.next = null;
            return localWorkNode;
        }
    }

    void setIsRunning(boolean paramBoolean) {
        this.isRunning = paramBoolean;
    }

    void verify(boolean paramBoolean) {
        assert (this.prev.next == this);
        assert (this.next.prev == this);
        assert (isRunning() == paramBoolean);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/internal/WorkQueue$WorkNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */