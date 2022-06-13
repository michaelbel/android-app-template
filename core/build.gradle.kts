import org.michaelbel.template.BuildTools
import org.michaelbel.template.CompileSdk
import org.michaelbel.template.MinSdk
import org.michaelbel.template.TargetSdk
import org.michaelbel.template.dependencies.TestRunner
import org.michaelbel.template.dependencies.apiAccompanistDependencies
import org.michaelbel.template.dependencies.apiChuckerDependencies
import org.michaelbel.template.dependencies.apiCoilDependencies
import org.michaelbel.template.dependencies.apiComposeDependencies
import org.michaelbel.template.dependencies.apiFirebaseDependencies
import org.michaelbel.template.dependencies.apiGooglePlayServicesDependencies
import org.michaelbel.template.dependencies.apiJetpackDependencies
import org.michaelbel.template.dependencies.apiKotlinDependencies
import org.michaelbel.template.dependencies.apiLifecycleDependencies
import org.michaelbel.template.dependencies.apiMaterialDependencies
import org.michaelbel.template.dependencies.apiNavigationDependencies
import org.michaelbel.template.dependencies.apiPagingDependencies
import org.michaelbel.template.dependencies.apiRetrofitDependencies
import org.michaelbel.template.dependencies.apiRoomDependencies
import org.michaelbel.template.dependencies.apiStartupDependencies
import org.michaelbel.template.dependencies.apiTestDependencies
import org.michaelbel.template.dependencies.apiTimberDependencies
import org.michaelbel.template.dependencies.apiViewBindingPropertyDelegateDependencies
import org.michaelbel.template.dependencies.implementationHiltDependencies

plugins {
    id("com.android.library")
    id("kotlinx-serialization")
    id("dagger.hilt.android.plugin")
    id("io.gitlab.arturbosch.detekt")
    kotlin("android")
    kotlin("kapt")
    id("com.google.devtools.ksp") version "1.6.21-1.0.6"
}

android {
    compileSdk = CompileSdk
    buildToolsVersion = BuildTools

    defaultConfig {
        minSdk = MinSdk
        targetSdk = TargetSdk
        testInstrumentationRunner = TestRunner
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    testOptions {
        unitTests.isIncludeAndroidResources = true
        unitTests.isReturnDefaultValues = true
    }

    buildFeatures {
        buildConfig = true
    }
}

kotlin {
    sourceSets.debug {
        kotlin.srcDir("build/generated/ksp/debug/kotlin")
    }
}

dependencies {
    implementationHiltDependencies()
    apiKotlinDependencies()
    apiJetpackDependencies()
    apiComposeDependencies()
    apiLifecycleDependencies()
    apiPagingDependencies()
    apiRoomDependencies()
    apiGooglePlayServicesDependencies()
    apiMaterialDependencies()
    apiAccompanistDependencies()
    apiFirebaseDependencies()
    apiRetrofitDependencies()
    apiCoilDependencies()
    apiTimberDependencies()
    apiChuckerDependencies()
    apiTestDependencies()
    apiViewBindingPropertyDelegateDependencies()
    apiStartupDependencies()
    apiNavigationDependencies()
}