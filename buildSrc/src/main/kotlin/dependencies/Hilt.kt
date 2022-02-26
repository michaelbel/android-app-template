@file:Suppress("SpellCheckingInspection", "unused")

package org.michaelbel.template.dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.michaelbel.template.extensions.implementation
import org.michaelbel.template.extensions.kapt

/**
 * Hilt
 *
 * @see <a href="https://github.com/google/dagger/releases">Hilt</a>
 */

private const val HiltVersion = "2.41"

const val HiltPlugin = "com.google.dagger:hilt-android-gradle-plugin:$HiltVersion"
private const val HiltAndroid = "com.google.dagger:hilt-android:$HiltVersion"
private const val HiltCompiler = "com.google.dagger:hilt-compiler:$HiltVersion"

fun DependencyHandler.implementationHiltDependencies() {
    implementation(HiltAndroid)
    kapt(HiltCompiler)
}