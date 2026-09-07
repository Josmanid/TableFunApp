package com.example.tablefunapp.screens

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.dp
import com.example.tablefunapp.models.CueAnimation

@Composable
fun Modifier.cueAnimation(
    animation: CueAnimation,
    isPlaying: Boolean
): Modifier {
    val transition = rememberInfiniteTransition(label = "cue")

    val offsetY by transition.animateFloat(
        initialValue = 0f,
        targetValue = -12f,
        animationSpec = infiniteRepeatable(
            animation = tween(400, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "offsetY"
    )

    val offsetY2 by transition.animateFloat(
        initialValue = 0f,
        targetValue = -12f,
        animationSpec = infiniteRepeatable(
            animation = tween(176, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "offsetY2"
    )

    val offsetY3 by transition.animateFloat(
        initialValue = 0f,
        targetValue = -10f,
        animationSpec = infiniteRepeatable(
            animation = tween(94, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "offsetY3"
    )

    val scale by transition.animateFloat(
        initialValue = 1f,
        targetValue = 1.08f,
        animationSpec = infiniteRepeatable(
            animation = tween(500),
            repeatMode = RepeatMode.Reverse
        ),
        label = "scale"
    )

    val rotation by transition.animateFloat(
        initialValue = -4f,
        targetValue = 4f,
        animationSpec = infiniteRepeatable(
            animation = tween(400),
            repeatMode = RepeatMode.Reverse
        ),
        label = "rotation"
    )

    val rotation2 by transition.animateFloat(
        initialValue = -4f,
        targetValue = 4f,
        animationSpec = infiniteRepeatable(
            animation = tween(316),
            repeatMode = RepeatMode.Reverse
        ),
        label = "rotationf"
    )

    val spin by transition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(3000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "spin"
    )

    if (!isPlaying) return this

    return when (animation) {
        CueAnimation.BOUNCE -> this.offset(y = offsetY.dp)
        CueAnimation.FASTBOUNCE -> this.offset(y = offsetY2.dp)
        CueAnimation.FASTESTBOUNCE -> this.offset(y = offsetY3.dp)
        CueAnimation.PULSE -> this.scale(scale)
        CueAnimation.WOBBLE -> this.rotate(rotation)
        CueAnimation.FASTWOBBLE -> this.rotate(rotation2)
        CueAnimation.SHAKE -> this.offset(x = rotation.dp)
        CueAnimation.SPIN -> this.rotate(spin)
    }
}