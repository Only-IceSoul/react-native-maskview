import * as React from 'react';
import { View, StyleSheet, requireNativeComponent } from 'react-native';



const NativeMaskView = requireNativeComponent ? requireNativeComponent('JJSMaskView',null) : null

  
const MaskView = NativeMaskView ? (props) =>{
    const { mask, children, ...otherViewProps } = props;

    return (
      <NativeMaskView {...otherViewProps}>
        <View pointerEvents="none" style={StyleSheet.absoluteFill}>
          {mask}
        </View>
        {children}
      </NativeMaskView>
    )
    
  } : null

  export default MaskView