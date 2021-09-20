// main index.js

import { Platform } from "react-native";
import MaskViewMobile from "./src/MaskView";
import MaskViewNMobile from "./src/MaskViewN";
import MaskViewWeb from "./src/MaskViewWeb";

export const MaskView = Platform.OS === "ios"
  || Platform.OS === "android"
  ? MaskViewMobile : MaskViewWeb;

  export const MaskViewN = Platform.OS === "ios"
  ? MaskViewMobile : ( Platform.OS === "android"
  ? MaskViewNMobile : MaskViewWeb)





