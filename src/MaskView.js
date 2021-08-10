import * as React from 'react';
import { View, StyleSheet, requireNativeComponent } from 'react-native';



const NativeMaskView = requireNativeComponent ? requireNativeComponent('MaskView',null) : null

  
const MaskView = NativeMaskView ? (props) =>{
    const { element, children, ...otherViewProps } = props;

    return (
      <NativeMaskView {...otherViewProps}>
        <View pointerEvents="none" style={StyleSheet.absoluteFill}>
          {element}
        </View>
        {children}
      </NativeMaskView>
    )
    
  } : null

  export default MaskView