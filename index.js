// main index.js

import { Platform } from "react-native";
import MaskViewMobile from "./src/MaskView";
import MaskViewWeb from "./src/MaskViewWeb";

const MaskView = Platform.OS === "ios"
  || Platform.OS === "android"
  ? MaskViewMobile : MaskViewWeb;

export default MaskView;

