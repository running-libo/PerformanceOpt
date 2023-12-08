package com.example.performanceopt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.performanceopt.idlehandler.ARouterInitTask
import com.example.performanceopt.idlehandler.WebviewInitTask
import com.example.performanceopt.idlehandler.TaskDispatcher
import com.example.performanceopt.ui.theme.PerformanceOptTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        TaskDispatcher()
            .addTask(ARouterInitTask())
            .addTask(WebviewInitTask())
            .start()
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PerformanceOptTheme {
        Greeting("Android")
    }
}