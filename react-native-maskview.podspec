# react-native-maskview.podspec

require "json"

package = JSON.parse(File.read(File.join(__dir__, "package.json")))

Pod::Spec.new do |s|
  s.name         = "react-native-maskview"
  s.version      = package["version"]
  s.summary      = package["description"]
  s.description  = <<-DESC
                  react-native-maskview
                   DESC
  s.homepage     = "https://github.com/Only-IceSoul/react-native-maskview"
  # brief license entry:
  s.license      = "MIT"
  # optional - use expanded license entry instead:
  # s.license    = { :type => "MIT", :file => "LICENSE" }
  s.authors      = { "Juan J LF" => "justin_lf@msn.com" }
  s.platforms    = { :ios => "10.0" }
  s.source       = { :git => "https://github.com/Only-IceSoul/react-native-maskview.git", :tag => "#{s.version}" }

  s.source_files = "ios/**/*.{h,c,cc,cpp,m,mm,swift}"
  s.requires_arc = true

  s.dependency "React"
  # ...
  # s.dependency "..."
end

