package com.example.customer.ui.customview

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.customer.ui.theme.LightBlack
import com.example.customer.ui.theme.bgOgran
import com.example.customer.ui.theme.colorButtonChoose
import com.example.customer.ui.theme.colorToolbar
import dinhtc.android.customer.R


@Preview(showBackground = true)
@Composable
fun ToolBarScreenPreview() {
    ToolBarScreen(
        "TopAppBar"
    )
}

@Composable
fun ToolBarScreen(
    textToolbar : String,
    onBack: (() -> Unit)? = null
) {
    TopAppBar(
        title = {
            Text(text = textToolbar)
        },
        elevation = 10.dp,
        backgroundColor = MaterialTheme.colors.surface,
        contentColor = MaterialTheme.colors.onSurface,
        navigationIcon = {
            IconButton(onClick = { onBack?.invoke() }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = null
                )
            }
        },
        actions = {
//            IconButton(onClick = { /* doSomething() */ }) {
//                Icon(Icons.Filled.Favorite, contentDescription = null)
//            }

            IconButton(onClick = { /* doSomething() */ }) {
                Icon(Icons.Filled.Refresh, contentDescription = null)
            }

//            IconButton(
//                onClick = { /* doSomething() */ }) {
//                Icon(Icons.Filled.Call, contentDescription = null)
//            }
        }
    )


//    Row(
//        verticalAlignment = Alignment.CenterVertically,
//        horizontalArrangement = Arrangement.Center,
//        modifier = Modifier
//            .background(colorToolbar)
//            .padding(vertical = 10.dp, horizontal = 5.dp)
//    ) {
//        Image(
//            painter = painterResource(id = R.drawable.ic_back),
//            contentDescription = null,
//            modifier = Modifier
//                .width(30.dp)
//                .height(30.dp)
//                .padding(6.dp)
//                .clickable {
//                    onClickMenu()
//                }
//        )
//
//        Spacer(modifier = Modifier.weight(1f))
//
//        if (visibleItem) {
//            Image(
//                painter = painterResource(id = R.drawable.ic_ring_notification),
//                contentDescription = null,
//                modifier = Modifier
//                    .width(30.dp)
//                    .height(30.dp)
//                    .padding(5.dp)
//                    .clickable {
//                        onClickProcessOrder()
//                    }
//            )
//        }
//    }
}