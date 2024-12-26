package com.dingdangmaoup

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.dingdangmaoup.theme.DingTempereTheme
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import dingtempere.composeapp.generated.resources.Res
import dingtempere.composeapp.generated.resources.compose_multiplatform


data class Message(val author: String, val body: String)

@Composable
fun converation(messages: List<Message>) {

    LazyColumn {
        items(messages) { message ->
            MessageCard(message)
        }
    }
}

fun getMsgData(num: Int): List<Message> {
    val messages = (1..num).map { Message("Message $it", """
        hello, everyone
        hidden line
    """.trimIndent()) }
    return messages
}


@Composable
@Preview
fun App() {
    DingTempereTheme {
        val msgData = getMsgData(100)
        converation(msgData)
//        MessageCard(Message("dingdangmaoup","hello everyone"))
//        var showContent by remember { mutableStateOf(false) }
//        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
//            Button(onClick = { showContent = !showContent }) {
//                Text("Click me!")
//            }
//            AnimatedVisibility(showContent) {
//                val greeting = remember { Greeting().greet() }
//                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
//                    Image(painterResource(Res.drawable.compose_multiplatform), null)
//                    Text("Compose: $greeting")
//                }
//            }
//        }
    }
}

@Composable
fun MessageCard(message: Message) {
    var flag by remember { mutableStateOf(false) }
    var isExpanded by remember { mutableStateOf(false) }
    Surface(
        shape = MaterialTheme.shapes.medium,
        elevation = 5.dp,
        modifier = Modifier.padding(all = 8.dp).fillMaxWidth().clickable {
//            flag = true
            isExpanded = !isExpanded
        }
    ) {


        if (flag) {
            Dialog(
                onDismissRequest = { flag = false }
            ) {
                Box(
                    modifier = Modifier
                        .size(300.dp)
                        .background(Color.White),
                    contentAlignment = Alignment.Center
                ) {
                    Column {
                        LinearProgressIndicator()
                        Text("加载中 ing...")
                    }
                }
            }

        }
        Row(
            modifier = Modifier.padding(all = 8.dp)
        ) {
            Image(
                painterResource(Res.drawable.compose_multiplatform),
                contentDescription = "profile picture",
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .border(1.5.dp, MaterialTheme.colors.secondary, shape = CircleShape)
            )
            Spacer(Modifier.padding(horizontal = 8.dp))
            Column {
                Text(
                    text = message.author,
                    color = MaterialTheme.colors.secondaryVariant,
                    style = MaterialTheme.typography.subtitle2
                )
                Spacer(Modifier.padding(vertical = 4.dp))
                Text(
                    text = message.body,
                    style = MaterialTheme.typography.body2,
                    // 修改 maxLines 参数，在默认情况下，只显示一行文本内容
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    // Composable 大小的动画效果
                    modifier = Modifier.animateContentSize()
                )
            }
        }
    }


}
