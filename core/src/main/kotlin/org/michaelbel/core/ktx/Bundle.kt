@file:Suppress("unused")

package org.michaelbel.core.ktx

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlin.reflect.KProperty

inline fun <reified T> Activity.argumentDelegate(): LazyProvider<Activity, T> {
    return argumentDelegate { activity: Activity -> activity.intent?.extras }
}

inline fun <reified T> Fragment.argumentDelegate(): LazyProvider<Fragment, T> {
    return argumentDelegate { fragment: Fragment -> fragment.requireArguments() }
}

inline fun <F, reified T> argumentDelegate(
    crossinline provideArguments: (F) -> Bundle?
): LazyProvider<F, T> =
        object: LazyProvider<F, T> {
            override fun provideDelegate(thisRef: F, prop: KProperty<*>): Lazy<T> = lazy {
                val bundle: Bundle? = provideArguments(thisRef)
                bundle?.get(prop.name) as T
            }
        }

interface LazyProvider<A, T> {
    operator fun provideDelegate(thisRef: A, prop: KProperty<*>): Lazy<T>
}