package com.bright.listofmessages

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bright.listofmessages.ui.theme.ListOfMessagesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListOfMessagesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Conversation(
                        listOf(
                            Message("author1", "The conversation is getting more interesting. It's time to play with animations! You will add the ability to expand a message to show a longer one, animating both the content size and the background color."),
                            Message("author2", "Composable functions can store local state in memory by using remember, and track changes to the value passed to mutableStateOf. Composables (and their children) using this state will get redrawn automatically when the value is updated. "),
                            Message("author3", "Android Compose revolutionizes the way developers create user interfaces for Android applications. With its declarative syntax, developers can describe UI components in a more intuitive and concise manner, focusing on what should be displayed rather than how it should be rendered. "),
                            Message("author4", "By encapsulating mutable state within composable functions, Compose ensures that UI components automatically update when the underlying state changes, eliminating the need for manual synchronization and reducing the risk of bugs. "),
                            Message("author5", "The conversation is getting more interesting. It's time to play with animations! You will add the ability to expand a message to show a longer one, animating both the content size and the background color."),
                            Message("author6", "Composable functions can store local state in memory by using remember, and track changes to the value passed to mutableStateOf. Composables (and their children) using this state will get redrawn automatically when the value is updated. "),
                            Message("author7", "Android Compose revolutionizes the way developers create user interfaces for Android applications. With its declarative syntax, developers can describe UI components in a more intuitive and concise manner, focusing on what should be displayed rather than how it should be rendered. "),
                            Message("author8", "By encapsulating mutable state within composable functions, Compose ensures that UI components automatically update when the underlying state changes, eliminating the need for manual synchronization and reducing the risk of bugs. "),
                            Message("author9", "The conversation is getting more interesting. It's time to play with animations! You will add the ability to expand a message to show a longer one, animating both the content size and the background color."),
                            Message("author10", "Composable functions can store local state in memory by using remember, and track changes to the value passed to mutableStateOf. Composables (and their children) using this state will get redrawn automatically when the value is updated. "),
                            Message("author11", "Android Compose revolutionizes the way developers create user interfaces for Android applications. With its declarative syntax, developers can describe UI components in a more intuitive and concise manner, focusing on what should be displayed rather than how it should be rendered. "),
                            Message("author12", "By encapsulating mutable state within composable functions, Compose ensures that UI components automatically update when the underlying state changes, eliminating the need for manual synchronization and reducing the risk of bugs. "),
                            Message("author13", "The conversation is getting more interesting. It's time to play with animations! You will add the ability to expand a message to show a longer one, animating both the content size and the background color."),
                            Message("author14", "Composable functions can store local state in memory by using remember, and track changes to the value passed to mutableStateOf. Composables (and their children) using this state will get redrawn automatically when the value is updated. "),
                            Message("author15", "Android Compose revolutionizes the way developers create user interfaces for Android applications. With its declarative syntax, developers can describe UI components in a more intuitive and concise manner, focusing on what should be displayed rather than how it should be rendered. "),
                            Message("author16", "By encapsulating mutable state within composable functions, Compose ensures that UI components automatically update when the underlying state changes, eliminating the need for manual synchronization and reducing the risk of bugs. ")
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        items(messages) {message -> MessageCard(message)}
    }
}

@Composable
fun MessageCard(message: Message) {
    Row {
        Image(
            painter = painterResource(id = R.drawable.person),
            contentDescription = "person",
            modifier = Modifier
                .clip(CircleShape)
                .size(70.dp)
                .border(width = 2.dp, shape = CircleShape, color = Color.LightGray)
        )
        Spacer(modifier = Modifier.width(4.dp))
        //create a mutable state variable that trigger UI updates when its value changes
        var isExpanded by remember {
            mutableStateOf(false)
        }
        Column(
            modifier = Modifier.clickable { isExpanded = !isExpanded }
        ) {
            Text(
                text = message.author,
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleSmall
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = message.body,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = if(isExpanded) Int.MAX_VALUE else 1
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ConversationPreview() {
    ListOfMessagesTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Conversation(
                listOf(
                    Message("author1", "The conversation is getting more interesting. It's time to play with animations! You will add the ability to expand a message to show a longer one, animating both the content size and the background color."),
                    Message("author2", "Composable functions can store local state in memory by using remember, and track changes to the value passed to mutableStateOf. Composables (and their children) using this state will get redrawn automatically when the value is updated. "),
                    Message("author3", "Android Compose revolutionizes the way developers create user interfaces for Android applications. With its declarative syntax, developers can describe UI components in a more intuitive and concise manner, focusing on what should be displayed rather than how it should be rendered. "),
                    Message("author4", "By encapsulating mutable state within composable functions, Compose ensures that UI components automatically update when the underlying state changes, eliminating the need for manual synchronization and reducing the risk of bugs. ")
                )
            )
        }
    }
}

data class Message(
    val author: String,
    val body: String
)