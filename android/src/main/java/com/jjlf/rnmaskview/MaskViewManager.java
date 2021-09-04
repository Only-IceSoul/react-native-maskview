// ReactNativeMaskviewModule.java

package com.jjlf.rnmaskview;

import androidx.annotation.NonNull;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;

public class MaskViewManager  extends ViewGroupManager<MaskView> {

    @Override
    public String getName() {
        return "JJSMaskView";
    }

    @Override
    protected MaskView createViewInstance(@NonNull ThemedReactContext reactContext) {
        return new MaskView(reactContext);
    }


}