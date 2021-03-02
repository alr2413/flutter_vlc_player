import UIKit
import Foundation

class VlcViewOutput: NSObject, FlutterTexture{
    
    private var latestPixelBuffer: CVPixelBuffer? = nil
    
    func copyPixelBuffer() -> Unmanaged<CVPixelBuffer>? {
        if let buffer = self.latestPixelBuffer {
            return Unmanaged<CVPixelBuffer>.passRetained(buffer)
        } else {
            return nil
        }
    }
    
    func captureOutput(){
//        latestPixelBuffer =
//        registry.textureFrameAvailable(textureId)
    }
    
}
