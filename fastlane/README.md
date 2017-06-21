fastlane documentation
================
# Installation

Make sure you have the latest version of the Xcode command line tools installed:

```
xcode-select --install
```

## Choose your installation method:

<table width="100%" >
<tr>
<th width="33%"><a href="http://brew.sh">Homebrew</a></td>
<th width="33%">Installer Script</td>
<th width="33%">Rubygems</td>
</tr>
<tr>
<td width="33%" align="center">macOS</td>
<td width="33%" align="center">macOS</td>
<td width="33%" align="center">macOS or Linux with Ruby 2.0.0 or above</td>
</tr>
<tr>
<td width="33%"><code>brew cask install fastlane</code></td>
<td width="33%"><a href="https://download.fastlane.tools">Download the zip file</a>. Then double click on the <code>install</code> script (or run it in a terminal window).</td>
<td width="33%"><code>sudo gem install fastlane -NV</code></td>
</tr>
</table>

# Available Actions
## Android
### android deploy
```
fastlane android deploy
```
Deploy a new version to the Google Play
### android deployBeta
```
fastlane android deployBeta
```
Deploy a new version to the Google Play
### android prepareBuild
```
fastlane android prepareBuild
```
Deploy a new version to the Google Play
### android projectClean
```
fastlane android projectClean
```
Project clean up. Running clean
### android createDebugBuild
```
fastlane android createDebugBuild
```
Creating debug build. Running assembleDebug
### android runUiTestCases
```
fastlane android runUiTestCases
```
UI testing. assembleDebugAndroidTest
### android takeScreenshots
```
fastlane android takeScreenshots
```
Creating screenshots. Running screengrab
### android makeReleaseBuild
```
fastlane android makeReleaseBuild
```
Creating release build. Running assembleRelease
### android uploadBuildProduction
```
fastlane android uploadBuildProduction
```
Uploading on production. Running supply(apk: './app/build/outputs/apk/app-release.apk')
### android uploadBuildBeta
```
fastlane android uploadBuildBeta
```
Uploading on beta. Running supply(apk: './app/build/outputs/apk/app-release.apk')

----

This README.md is auto-generated and will be re-generated every time [fastlane](https://fastlane.tools) is run.
More information about fastlane can be found on [fastlane.tools](https://fastlane.tools).
The documentation of fastlane can be found on [docs.fastlane.tools](https://docs.fastlane.tools).
