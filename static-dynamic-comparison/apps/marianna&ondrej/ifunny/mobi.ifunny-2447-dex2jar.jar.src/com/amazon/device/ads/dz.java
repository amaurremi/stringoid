package com.amazon.device.ads;

class dz
        implements Runnable {
    dz(dy paramdy, hy paramhy) {
    }

    public void run() {
        try {
            this.a.e();
            return;
        } catch (ic localic) {
            switch (ea.a[localic.a().ordinal()]) {
                default:
                    return;
                case 1:
                    dv.b(dy.c(), "Unable to submit metrics for ad due to an Invalid Client Protocol, msg: %s", new Object[]{localic.getMessage()});
                    return;
                case 2:
                    dv.b(dy.c(), "Unable to submit metrics for ad due to Network Failure, msg: %s", new Object[]{localic.getMessage()});
                    return;
            }
        }
        dv.b(dy.c(), "Unable to submit metrics for ad due to a Malformed Pixel URL, msg: %s", new Object[]{localic.getMessage()});
        dv.b(dy.c(), "Unable to submit metrics for ad because of unsupported character encoding, msg: %s", new Object[]{localic.getMessage()});
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/dz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */