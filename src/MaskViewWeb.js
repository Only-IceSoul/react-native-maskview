import React, { useEffect, useLayoutEffect, useRef } from 'react';
import { View, StyleSheet } from 'react-native';

const html2canvas = require('html2canvas.js')
console.log(html2canvas)
const MaskView = (props) =>{
    const { element, children, ...otherViewProps } = props;
    const refMask = useRef(null)
    const mainRef = useRef(null)

    useEffect(()=>{
      //  console.log("there is ", c)
    //   html2canvas(mainRef.current, {
    //     onrendered: function (canvas) {
    //         console.log("existe canvas ",canvas)
    //     },
    //     width: width,
    //     height: height,
    //     useCORS: true,
    //     taintTest: false,
    //     allowTaint: false
    // });
    },[])

    return (
      <div ref={mainRef} {...otherViewProps}>
        <div pointerEvents="none" ref={refMask} style={{visibility:'hidden',...StyleSheet.absoluteFill}}>
          {element}
        </div>
        {children}
      </div>
    )
    
  }

  export default MaskView