package com.cherlan.weatherapp.presentation.navigation


import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.graphics.drawable.toDrawable
import com.cherlan.weatherapp.R
import com.cherlan.weatherapp.data.model.BottomNavigation

val items = listOf(
    BottomNavigation(
        title = "Home",
        icon = Icons.Rounded.Home
    ),
//    BottomNavigation(
//        title = "Maps",
//        icon = (R.drawable.map).toDrawable()
//    ),
    BottomNavigation(
        title = "Location",
        icon = Icons.Rounded.LocationOn
    ),
    BottomNavigation(
        title = "Settings",
        icon = Icons.Rounded.Settings
    )
)



@Preview
@Composable
fun BottomNavigationBar() {
    NavigationBar(
    ) {
        Row(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.inverseOnSurface)
        ) {
            items.forEachIndexed() { index, item ->
                NavigationBarItem(
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.title,
                            tint = MaterialTheme.colorScheme.onBackground
                        )
                    },
                    label = {
                        Text(
                            text = item.title,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    },
                    selected = index == 0,
                    onClick = {
                    }
                )
            }
        }
    }
}










