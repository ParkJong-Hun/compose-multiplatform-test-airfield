package presentation.pages.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import domain.entity.City
import org.jetbrains.compose.ui.tooling.preview.Preview
import presentation.di.koinViewModel
import presentation.pages.home.components.organism.AdditionalInfoCard
import presentation.pages.home.components.organism.MainInfo
import presentation.pages.home.components.organism.Title

// TODO use SharedTransitionScope
@Composable
fun NavGraphBuilder.HomePage(
    homeViewModel: HomeViewModel = koinViewModel(),
) {
    val state by homeViewModel.uiState.collectAsState()
    HomePageBody(
        state = state,
        onClickSetting = homeViewModel::onClickCity,
        onClickCurrentLocation = homeViewModel::onClickCurrentLocation,
    )
}

@Composable
private fun HomePageBody(
    state: HomeUiState,
    onClickSetting: (City) -> Unit,
    onClickCurrentLocation: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.primary.copy(alpha = 0.1f))
            .padding(20.dp),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Title(
                title = state.title,
                onClickSetting = onClickSetting,
                onClickCurrentLocation = onClickCurrentLocation,
            )
            if (state.temperature != null || state.description != null) {
                MainInfo(
                    temperature = state.temperature,
                    description = state.description,
                )
            }
            if (state.humidity != null || state.rainfall != null) {
                AdditionalInfoCard(
                    humidity = state.humidity,
                    rainfall = state.rainfall,
                )
            }
        }
        if (state.isLoading) {
            CircularProgressIndicator()
        }
    }
}

@Preview
@Composable
@Suppress("unused")
private fun HomePageBodyPreview() {
    HomePageBody(
        state = HomeUiState(),
        onClickSetting = {},
        onClickCurrentLocation = {},
    )
}