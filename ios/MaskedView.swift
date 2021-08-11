//
//  MaskedView.swift
//  ReactNativeMaskview
//
//  Created by Juan J LF on 8/10/21.
//  Copyright © 2021 Facebook. All rights reserved.
//

import Foundation
import UIKit


@objc(MaskedView)
class MaskedView: UIView {
    


    init() {
        super.init(frame: .zero)
    }

    
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
        
    }
    
    
    override func didUpdateReactSubviews() {
        
        if reactSubviews() == nil {
            return
        }
        
        let m = self.reactSubviews()!.first
        self.mask = m
        
        for i in 1..<self.reactSubviews()!.count {
            let v = self.reactSubviews()![i]
            self.addSubview(v)
        }
    }
    
    override func display(_ layer: CALayer) {
        
    }
 
    
    

}
