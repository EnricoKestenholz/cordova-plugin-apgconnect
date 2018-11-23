How to implement the plugin

ANDROID

IN build.gradle

ADD under allprojects:

        maven {
            url "https://jitpack.io"
            credentials { username "AUTH_TOKEN_JITPACK" }
        }

CHANGE AUTH_TOKEN_JITPACK with your own token

MOVE  jcenter() at the end of allprojects not at the beginning

IN project.properties

UPDATE play services and firebase to minimum version 11.8.0:
com.google.android.gms:play-services-analytics:11.8.0
com.google.android.gms:play-services-gcm:11.8.0
com.google.firebase:firebase-messaging:11.8.0

ADD under dependencies:

 compile "com.github.APGSGA:apgconnect-android:2.1"

IN app/src/main/java/podspec/apgconnect change

	AUTH_TOKEN with APG auth_token


IPHONE

POD integration

ADD spec repo to Podfile

source 'https://github.com/CocoaPods/Specs.git'
source 'https://apgsga.githost.io/adtech/apgconnect-podspec.git'

ADD APGconnect

pod 'APGconnect'

JAVASCRIPT APPLICATION

The plugin initialisation is done at the initialisation of the plugin, no need to do it programmatically from the application.

In android, after changes on location permission you have to callback
apgconnect.permissionGranted();

Call every new page to check if there are new keywords
NOTE: The keywords call is asyncronous.

iOS doesn't do the callback directly from the plugin but receives the data onsuccess, so the newPage

if(ios){ //check if ios
    apgconnect.newPage('', window.__APGconnect__callback);
}else if(android){ //check if android
    apgconnect.newPage();
}
