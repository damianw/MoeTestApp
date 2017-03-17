//
//  ViewController.swift
//  MoeTestApp
//
//  Created by Christian Bator on 3/16/17.
//  Copyright © 2017 Christian Bator. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    
    override func viewDidLoad() {
        super.viewDidLoad()
        let provider = ImageProvider()
        let image = provider.fetchImage()
        (self.view.viewWithTag(5) as! UIImageView).image = image
    }

}
