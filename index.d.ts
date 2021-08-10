import React from "react";
import { Constructor, NativeMethods, ViewProps } from "react-native";

type Color = number | string;

//atributo dasharray y todo el drawable view, actualizar inset con dip en android, traer el color de gradient
interface MaskViewProps extends ViewProps {
    
    mask: React.ReactElement
}

declare class MaskComponent extends React.Component<MaskViewProps> {}
declare const MaskViewBase: Constructor<NativeMethods> & typeof MaskComponent;

export default class MaskView extends MaskViewBase {}