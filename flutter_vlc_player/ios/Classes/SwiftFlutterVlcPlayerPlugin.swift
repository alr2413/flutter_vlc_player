import Foundation
import Flutter

public class SwiftFlutterVlcPlayerPlugin: NSObject, FlutterPlugin {
    public static func register(with registrar: FlutterPluginRegistrar) {
        let instance = VLCViewBuilder(registrar: registrar)
        registrar.publish(instance)
    }
}
