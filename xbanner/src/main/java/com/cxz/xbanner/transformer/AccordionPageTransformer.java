package com.cxz.xbanner.transformer;

import android.support.v4.view.ViewCompat;
import android.view.View;

/**
 * @author chenxz
 * @date 2019/1/20
 * @desc
 */
public class AccordionPageTransformer extends XPageTransformer {
    @Override
    public void handleInvisiblePage(View view, float position) {

    }

    @Override
    public void handleLeftPage(View view, float position) {
        ViewCompat.setPivotX(view, view.getWidth());
        ViewCompat.setScaleX(view, 1.0f + position);
    }

    @Override
    public void handleRightPage(View view, float position) {
        ViewCompat.setPivotX(view, 0);
        ViewCompat.setScaleX(view, 1.0f - position);
        ViewCompat.setAlpha(view, 1);
    }
}
