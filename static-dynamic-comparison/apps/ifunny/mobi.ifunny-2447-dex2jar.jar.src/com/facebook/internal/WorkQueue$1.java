package com.facebook.internal;

class WorkQueue$1
        implements Runnable {
    WorkQueue$1(WorkQueue paramWorkQueue, WorkQueue.WorkNode paramWorkNode) {
    }

    public void run() {
        try {
            this.val$node.getCallback().run();
            return;
        } finally {
            WorkQueue.access$000(this.this$0, this.val$node);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/internal/WorkQueue$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */