package com.facebook.internal;

import com.facebook.Settings;

import java.util.concurrent.Executor;

class WorkQueue {
    public static final int DEFAULT_MAX_CONCURRENT = 8;
    private final Executor executor;
    private final int maxConcurrent;
    private WorkQueue.WorkNode pendingJobs;
    private int runningCount = 0;
    private WorkQueue.WorkNode runningJobs = null;
    private final Object workLock = new Object();

    static {
        if (!WorkQueue.class.desiredAssertionStatus()) {
        }
        for (boolean bool = true; ; bool = false) {
            $assertionsDisabled = bool;
            return;
        }
    }

    WorkQueue() {
        this(8);
    }

    WorkQueue(int paramInt) {
        this(paramInt, Settings.getExecutor());
    }

    WorkQueue(int paramInt, Executor paramExecutor) {
        this.maxConcurrent = paramInt;
        this.executor = paramExecutor;
    }

    private void execute(WorkQueue.WorkNode paramWorkNode) {
        this.executor.execute(new WorkQueue .1 (this, paramWorkNode));
    }

    private void finishItemAndStartNew(WorkQueue.WorkNode paramWorkNode) {
        WorkQueue.WorkNode localWorkNode = null;
        Object localObject = this.workLock;
        if (paramWorkNode != null) {
        }
        try {
            this.runningJobs = paramWorkNode.removeFromList(this.runningJobs);
            this.runningCount -= 1;
            paramWorkNode = localWorkNode;
            if (this.runningCount < this.maxConcurrent) {
                localWorkNode = this.pendingJobs;
                paramWorkNode = localWorkNode;
                if (localWorkNode != null) {
                    this.pendingJobs = localWorkNode.removeFromList(this.pendingJobs);
                    this.runningJobs = localWorkNode.addToList(this.runningJobs, false);
                    this.runningCount += 1;
                    localWorkNode.setIsRunning(true);
                    paramWorkNode = localWorkNode;
                }
            }
            if (paramWorkNode != null) {
                execute(paramWorkNode);
            }
            return;
        } finally {
        }
    }

    private void startItem() {
        finishItemAndStartNew(null);
    }

    WorkQueue.WorkItem addActiveWorkItem(Runnable paramRunnable) {
        return addActiveWorkItem(paramRunnable, true);
    }

    WorkQueue.WorkItem addActiveWorkItem(Runnable arg1, boolean paramBoolean) {
        WorkQueue.WorkNode localWorkNode = new WorkQueue.WorkNode(this, ???);
        synchronized (this.workLock) {
            this.pendingJobs = localWorkNode.addToList(this.pendingJobs, paramBoolean);
            startItem();
            return localWorkNode;
        }
    }

    void validate() {
        Object localObject3 = this.workLock;
        int j = 0;
        int i = 0;
        try {
            if (this.runningJobs != null) {
                Object localObject1 = this.runningJobs;
                WorkQueue.WorkNode localWorkNode;
                do {
                    ((WorkQueue.WorkNode) localObject1).verify(true);
                    j = i + 1;
                    localWorkNode = ((WorkQueue.WorkNode) localObject1).getNext();
                    i = j;
                    localObject1 = localWorkNode;
                } while (localWorkNode != this.runningJobs);
            }
            if ((!$assertionsDisabled) && (this.runningCount != j)) {
                throw new AssertionError();
            }
        } finally {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/internal/WorkQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */