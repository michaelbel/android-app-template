package org.michaelbel.template.features.config

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.michaelbel.template.features.config.ui.RemoteConfigScreen

/**
 * Firebase Remote Config.
 */
@AndroidEntryPoint
class RemoteConfigFragment: Fragment() {

    private val viewModel: RemoteConfigViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(inflater.context).apply {
        setContent {
            ProvideWindowInsets {
                RemoteConfigScreen(::onNavigationIconClick)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.customRemoteParam.collect {
                Snackbar.make(view, "Custom Remote Param = $it", Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    private fun onNavigationIconClick() {
        findNavController().popBackStack()
    }
}