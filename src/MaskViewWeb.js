import React from 'react';


const MaskView = (props) =>{
    const { mask,  ...otherViewProps } = props;
  

    return (
      <div {...otherViewProps}  >
 
      </div>
    )
    
  }

  export default MaskView