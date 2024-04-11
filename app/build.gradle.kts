plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.cpp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.cpp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

    }
    signingConfigs {
        create("release") {
            storeFile = file("test.jks")
            storePassword = "123456"
            keyAlias = "test"
            keyPassword = "123456"
            enableV1Signing = true
            enableV2Signing = true
            enableV3Signing = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("release")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    externalNativeBuild {
        cmake {
            path = file("src/main/cpp/CMakeLists.txt")
            version = "3.22.1"
        }
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

}
