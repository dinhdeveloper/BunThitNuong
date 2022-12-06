package com.example.customer.main.view

import android.app.Activity
import android.content.Intent
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.customer.main.activity.MainActivity
import com.example.customer.main.activity.SignInUpActivity
import com.example.customer.ui.theme.colorToolbar
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    circleColor: Color = Color.Magenta,
    animationDelay: Int = 1000
) {
    val activity = (LocalContext.current as? Activity)

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(colorToolbar)
            .fillMaxSize()

    ) {
        val circles = listOf(
            remember {
                Animatable(initialValue = 0f)
            },
            remember {
                Animatable(initialValue = 0f)
            },
            remember {
                Animatable(initialValue = 0f)
            }
        )
        circles.forEachIndexed { index, animatable ->
            LaunchedEffect(Unit) {
                delay(timeMillis = (animationDelay / 3L) * (index + 1))
                animatable.animateTo(
                    targetValue = 1f,
                    animationSpec = infiniteRepeatable(
                        animation = tween(
                            durationMillis = animationDelay,
                            easing = LinearEasing
                        ),
                        repeatMode = RepeatMode.Restart
                    )
                )
            }
        }
        Box(
            modifier = Modifier
                .size(size = 200.dp)
                .background(color = Color.Transparent)
        ) {
            circles.forEachIndexed { index, animatable ->
                Box(
                    modifier = Modifier
                        .scale(scale = animatable.value)
                        .size(size = 200.dp)
                        .clip(shape = CircleShape)
                        .background(
                            color = circleColor
                                .copy(alpha = (1 - animatable.value))
                        )
                ) {
                }
            }
        }


        LaunchedEffect(Unit) {
            delay(3000)
            activity?.startActivity(Intent(activity, SignInUpActivity::class.java))
            activity?.finish()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSplashScreen() {
    SplashScreen()
}