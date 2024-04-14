plugins {
    alias(libs.plugins.androidApplication)
}

android {
    namespace = "com.lampro.lam_android_day8"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.lampro.lam_android_day8"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation ("com.squareup.retrofit2:retrofit:2.11.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.11.0")
    implementation ("com.google.code.gson:gson:2.10.1")
    //thư viện xử lý hình ảnh:
    implementation("com.github.bumptech.glide:glide:4.16.0")
//thư viện cung cấp đơn vị sdp (scale trên từng kích thước màn hình):
    implementation("com.intuit.sdp:sdp-android:1.1.0")
//thư viện cung cấp đơn vị ssp (scale theo màn hình cho văn bản):
    implementation("com.intuit.ssp:ssp-android:1.1.0")
//thư viện thay đổi hình dạng hình ảnh:
    implementation("jp.wasabeef:glide-transformations:4.3.0")
    // If you want to use the GPU Filters
    implementation("jp.co.cyberagent.android:gpuimage:2.1.0")
// thu vien retrofit show log
    implementation ("com.squareup.okhttp3:logging-interceptor:4.11.0")
    debugImplementation ("com.github.chuckerteam.chucker:library:4.0.0")
    releaseImplementation ("com.github.chuckerteam.chucker:library-no-op:4.0.0")
}