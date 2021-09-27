# MaskView

Mask

[x] android: api 21+   
[x] ios : 10.0+   

<img src="./src/img/preview.jpg" width="200">


## Getting started

`$ npm install react-native-maskview --save`  
`$ react-native link react-native-maskview`  
  
or

`$ yarn add react-native-maskview `
    

## IOS

cd ios   
pod install

**Add Swift**

/ios/name_project

add a .swift file  
  

# Usage
```javascript
import {MaskView , MaskViewH} from 'react-native-maskview';

// (Android) MaskViewH Layer type Hardware
// TODO: What to do with the module?

   <MaskView  style={{width:300,height:300,backgroundColor:'purple',justifyContent:'center',alignItems:'center'}}
   mask={
       <View style={{flex:1,display:'flex',justifyContent:'center',alignItems:'center'}}>
                 <TextReact > MASK TEXT </TextReact>
             </View>
   } >


         <Painter style={{width:250,height:250,backgroundColor:'green'}}>
              <Rect  x={0} y={0}  w={150} h={170} fill={colorOrange} shadowOpacity={1} shadowOffset={{x:10,y:10}}/>
       </Painter>
   </MaskView>

```


## Props   

| Name | description  | default |
| --- | --- | --- |
| mask | An view whose alpha channel is used to mask a view’s content.  | undefined |


