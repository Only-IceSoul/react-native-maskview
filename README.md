# MaskView

Mask

Hardware Accelerated 

[x] android: api 21+   
[x] ios : 10.0+   
[ ] web:   


## Getting started

`$ npm install react-native-maskview --save`  
`$ react-native link react-native-maskview`  
  
or

`$ yarn add react-native-maskview `
    

## IOS

**Add Swift**

(If you are using expo sdk >=42 you don't need to do this)

/ios/name_project

add a .swift file  
  

# Usage
```javascript
import MaskView from 'react-native-drawableview';

// TODO: What to do with the module?

   <MaskView 
   mask={
       <View>
            <Text>Hello World</Text>
       </View>
   } >


        <View  style={{backgroundColor:'red'}}/>
   </MaskView>

```


## Props   

| Name | description  | default |
| --- | --- | --- |
| mask | An view whose alpha channel is used to mask a view’s content.  | undefined |


