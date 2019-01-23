package com.cxz.xbanner.transformer;

import android.support.v4.view.ViewCompat;
import android.view.View;

/**
 * @author chenxz
 * @date 2019/1/20
 * @desc
 */
public class ZoomPageTransformer extends XPageTransformer {
    private float mMinScale = 0.85f;
    private float mMinAlpha = 0.65f;

    public ZoomPageTransformer() {
    }

    public ZoomPageTransformer(float minAlpha, float minScale) {
        setMinAlpha(minAlpha);
        setMinScale(minScale);
    }

    @Override
    public void handleInvisiblePage(View view, float position) {
        ViewCompat.setAlpha(view, 0);
    }

    @Override
    public void handleLeftPage(View view, float position) {
        float scale = Math.max(mMinScale, 1 + position);
        float vertMargin = view.getHeight() * (1 - scale) / 2;
        float horzMargin = view.getWidth() * (1 - scale) / 2;
        ViewCompat.setTranslationX(view, horzMargin - vertMargin / 2);
        ViewCompat.setScaleX(view, scale);
        ViewCompat.setScaleY(view, scale);
        ViewCompat.setAlpha(view, mMinAlpha + (scale - mMinScale) / (1 - mMinScale) * (1 - mMinAlpha));
    }

    @Override
    public void handleRightPage(View view, float position) {
        float scale = Math.max(mMinScale, 1 - position);
        float vertMargin = view.getHeight() * (1 - scale) / 2;
        float horzMargin = view.getWidth() * (1 - scale) / 2;
        ViewCompat.setTranslationX(view, -horzMargin + vertMargin / 2);
        ViewCompat.setScaleX(view, scale);
        ViewCompat.setScaleY(view, scale);
        ViewCompat.setAlpha(view, mMinAlpha + (scale - mMinScale) / (1 - mMinScale) * (1 - mMinAlpha));
    }

    public void setMinAlpha(float minAlpha) {
        if (minAlpha >= 0.6f && minAlpha <= 1.0f) {
            mMinAlpha = minAlpha;
        }
    }

    public void setMinScale(float minScale) {
        if (minScale >= 0.6f && minScale <= 1.0f) {
            mMinScale = minScale;
        }
    }
}