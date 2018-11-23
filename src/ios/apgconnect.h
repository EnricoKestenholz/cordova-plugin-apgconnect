#import <Cordova/CDVPlugin.h>

@interface apgconnect : CDVPlugin <NSXMLParserDelegate>

- (void)init:(CDVInvokedUrlCommand *)command;
- (void)newPage:(CDVInvokedUrlCommand *)command;
- (void)permissionGranted:(CDVInvokedUrlCommand *)command;

@end