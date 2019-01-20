package com.cxz.xbanner;

import android.content.Context;
import android.widget.Scroller;

/**
 * @author chenxz
 * @date 2019/1/20
 * @desc
 */
public class XBannerScroller extends Scroller {

    // 值越大，滑动越慢
    private int mDuration = 800;


    public XBannerScroller(Context context, int duration) {
        super(context);
        mDuration = duration;
    }

    @Override
    public void startScroll(int startX, int startY, int dx, int dy) {
        super.startScroll(startX, startY, dx, dy, mDuration);
    }

    @Override
    public void startScroll(int startX, int startY, int dx, int dy, int duration) {
        super.startScroll(startX, startY, dx, dy, mDuration);
    }
}
