#
# To learn more about a Podspec see http://guides.cocoapods.org/syntax/podspec.html.
# Run `pod lib lint flutter_vlc_player.podspec' to validate before publishing.
#
Pod::Spec.new do |s|
  s.name             = 'flutter_vlc_player'
  s.version          = '5.0.3'
  s.summary          = 'A new flutter plugin project.'
  s.description      = <<-DESC
  A VLC-powered alternative to Flutter video_player. Supports multiple players on one screen.
                       DESC
  s.homepage         = 'https://github.com/solid-software/flutter_vlc_player'
  s.license          = { :file => '../LICENSE' }
  s.author           = { 'Your Company' => 'email@example.com' }
  s.source           = { :path => '.' }
  s.source_files     = 'Classes/**/*'
  s.public_header_files = 'Classes/**/*.h'
  s.dependency 'FlutterMacOS'
  s.platform = :osx, '10.11'
  s.dependency 'VLCKit', '~>3.3.15'
  s.static_framework = true

  s.pod_target_xcconfig = { 'DEFINES_MODULE' => 'YES' }
  s.swift_version = '5.0'
end