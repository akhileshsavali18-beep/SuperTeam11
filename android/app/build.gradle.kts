plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.compose")
}

android {
    namespace = "com.superteam11.app"
    compileSdk = 35

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }

    defaultConfig {
        applicationId = "com.superteam11.app"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "0.1.0"
    }

    // Only include the two brand images, not the entire repository root.
    sourceSets["main"].assets.srcDir(layout.buildDirectory.dir("generated/superteam11Assets"))
    buildFeatures {
        compose = true
    }
}

val copySuperTeam11Assets by tasks.registering(Copy::class) {
    from(rootProject.file("../superteam11_logo.png"))
    from(rootProject.file("../superteam11_splash.png"))
    into(layout.buildDirectory.dir("generated/superteam11Assets"))
}

tasks.named("preBuild").configure {
    dependsOn(copySuperTeam11Assets)
}

dependencies {
    implementation("androidx.core:core-ktx:1.15.0")
    implementation("androidx.activity:activity-compose:1.10.0")
    implementation(platform("androidx.compose:compose-bom:2025.01.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.8.7")
}
