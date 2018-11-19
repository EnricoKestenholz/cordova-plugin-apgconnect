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