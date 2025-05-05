#import <Cordova/CDV.h>

@interface NativeTimer : CDVPlugin
- (void)setTimeout:(CDVInvokedUrlCommand*)command;
- (void)clearTimeout:(CDVInvokedUrlCommand*)command;
@end
