// ReactNativeMaskviewModule.java

package com.jjlf.rnmaskview;

import androidx.annotation.NonNull;

import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;

public class MaskViewNoneManager extends ViewGroupManager<MaskViewNone> {

    @Override
    public String getName() {
        return "JJSMaskViewNone";
    }

    @Override
    protected MaskViewNone createViewInstance(@NonNull ThemedReactContext reactContext) {
        return new MaskViewNone(reactContext);
    }

    @Override
    public void setBackgroundColor(@NonNull MaskViewNone view, int backgroundColor) {
        view.setBgColor(backgroundColor);
    }
}