//
//  ObjCViewController.m
//  MoeTestApp
//
//  Created by Damian Wieczorek on 3/17/17.
//  Copyright © 2017 Damian Wieczorek. All rights reserved.
//

#import "ObjCViewController.h"
#import "ImageProvider.h"

@interface ObjCViewController ()

@end

@implementation ObjCViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    ImageProvider *provider = [[ImageProvider alloc] init];
    UIImage* image = [provider fetchImage];
    UIImageView* view = [self.view viewWithTag:5];
    
    view.image = image;
}

@end
