package com.example.shikiliteappcompose.presentation.screens


import android.graphics.drawable.Drawable
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.LazyColumn

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.shikiliteappcompose.presentation.screens.home.HomeScreenViewModel
import dagger.hilt.android.AndroidEntryPoint
import com.example.shikiliteappcompose.R
import com.example.shikiliteappcompose.presentation.screens.components.DarkBackgroundImage
import com.example.shikiliteappcompose.presentation.screens.components.OngoingsLazyRowWithTitle
import com.example.shikiliteappcompose.presentation.screens.components.SearchView
import com.example.shikiliteappcompose.presentation.screens.components.StyledTextWithSpacing
import com.example.shikiliteappcompose.presentation.screens.home.HomeScreenEvent
import com.example.shikiliteappcompose.presentation.screens.home.ImageWithDescription
import com.example.shikiliteappcompose.presentation.ui.theme.*
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState


@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel = hiltViewModel()
) {
    val swipeRefreshState = rememberSwipeRefreshState(isRefreshing = viewModel.state.isRefreshing)
    val state = viewModel.state

    DarkBackgroundImage(
        imageId = R.drawable.back,
        backgroundColor = BackgroundColor,
        modifier = Modifier
    )
    SwipeRefresh(
        state = swipeRefreshState,
        onRefresh = { viewModel.onEvent(HomeScreenEvent.Refresh) }) {

        Column(
            modifier =
            Modifier
                .fillMaxSize()
                .padding(3.dp)
        )
        {
            Row(modifier = Modifier.fillMaxWidth().padding(vertical = 5.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.shikimoriicon), colorFilter = ColorFilter.tint(color = Color.White),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(50.dp)
                        .height(50.dp)
                        .padding(horizontal = 5.dp)
                )
                Box(modifier = Modifier)
                {
                    SearchView(
                        modifier = Modifier
                            .background(
                                color = SearchViewBackgroundColor,
                                shape = RoundedCornerShape(19.dp)
                            ).align(Center).height(50.dp)
                    )
                }
            }



            Spacer(modifier = Modifier.height(8.dp))

            OngoingsLazyRowWithTitle(
                titleTextId = R.string.ongoings,
                ongoings = state.onGoingsList,
                modifier = Modifier,
                titleBackgroundColor = BlockColor80
            )

            StyledTextWithSpacing(
                stringId = R.string.recently_watched,
                backgroundColor = SkyBlue40,
                modifier = Modifier
            )


            LazyVerticalGrid(columns = GridCells.Fixed(3),
                content = {
                    items(state.recentlyWatchedList.size) { i ->
                        val watchedListItem = state.recentlyWatchedList[i]
                        ImageWithDescription(
                            imagePath = watchedListItem.thumbPath,
                            descriptionText = watchedListItem.titleName
                        )
                    }
                })
        }
    }

}

