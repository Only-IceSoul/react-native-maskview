//
//  MaskView.swift
//  ReactNativeMaskview
//
//  Created by Juan J LF on 8/10/21.
//  Copyright © 2021 Facebook. All rights reserved.
//


import Foundation
import UIKit

@objc(MaskView)
class MaskView: RCTViewManager {

    override func view() -> UIView! {
       return MaskedView()
     }
   override class func requiresMainQueueSetup() -> Bool {
        return true
    }
}
