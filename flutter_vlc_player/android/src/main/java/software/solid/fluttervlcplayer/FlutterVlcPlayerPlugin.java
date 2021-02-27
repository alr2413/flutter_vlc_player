package software.solid.fluttervlcplayer;

import android.util.Log;

import androidx.annotation.NonNull;

import io.flutter.FlutterInjector;
import io.flutter.embedding.engine.plugins.FlutterPlugin;

public class FlutterVlcPlayerPlugin implements FlutterPlugin {

    private static final String TAG = "FlutterVlcPlayerPlugin";
    private FlutterVlcPlayerBuilder flutterVlcPlayerBuilder;

    public FlutterVlcPlayerPlugin() {
    }

    @SuppressWarnings("deprecation")
    private FlutterVlcPlayerPlugin(io.flutter.plugin.common.PluginRegistry.Registrar registrar) {
        this.flutterVlcPlayerBuilder =
                new FlutterVlcPlayerBuilder(
                        registrar.context(),
                        registrar.messenger(),
                        registrar::lookupKeyForAsset,
                        registrar::lookupKeyForAsset,
                        registrar.textures());
        flutterVlcPlayerBuilder.startListening(registrar.messenger());
    }

    @SuppressWarnings("deprecation")
    public static void registerWith(io.flutter.plugin.common.PluginRegistry.Registrar registrar) {
        final FlutterVlcPlayerPlugin plugin = new FlutterVlcPlayerPlugin(registrar);
        registrar.addViewDestroyListener(view -> {
            plugin.flutterVlcPlayerBuilder.onDestroy();
            return false; // We are not interested in assuming ownership of the NativeView.
        });
    }

    @Override
    public void onAttachedToEngine(@NonNull FlutterPluginBinding binding) {
        final FlutterInjector injector = FlutterInjector.instance();
        this.flutterVlcPlayerBuilder =
                new FlutterVlcPlayerBuilder(
                        binding.getApplicationContext(),
                        binding.getBinaryMessenger(),
                        injector.flutterLoader()::getLookupKeyForAsset,
                        injector.flutterLoader()::getLookupKeyForAsset,
                        binding.getTextureRegistry());
        flutterVlcPlayerBuilder.startListening(binding.getBinaryMessenger());
    }

    @Override
    public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
        if (flutterVlcPlayerBuilder == null) {
            Log.wtf(TAG, "Detached from the engine before registering to it.");
        }
        flutterVlcPlayerBuilder.stopListening(binding.getBinaryMessenger());
        flutterVlcPlayerBuilder.onDestroy();
        flutterVlcPlayerBuilder = null;
    }
}
