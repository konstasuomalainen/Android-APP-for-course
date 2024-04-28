plugins {
    alias(libs.plugins.androidApplication)
}

android {
    namespace = "com.example.hellojava"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.hellojava"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {




    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation("com.android.volley:volley:1.2.1")
    implementation(libs.constraintlayout)
    implementation(libs.datastore.preferences)
    implementation(libs.datastore.preferences.rxjava2)
    implementation(libs.datastore.preferences.rxjava3)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.navigation.fragment)
    implementation(libs.androidx.navigation.ui)
    implementation(libs.androidx.recyclerview)
    implementation(libs.androidx.recyclerview.selection)
    implementation(libs.cardview.v7)
    implementation(libs.recyclerview.v7)
    implementation(libs.support.gridlayout.v7)
    implementation(libs.support.recyclerview.v7)
    implementation(libs.recyclerview)
    implementation(libs.recyclerview.selection)

    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)



}