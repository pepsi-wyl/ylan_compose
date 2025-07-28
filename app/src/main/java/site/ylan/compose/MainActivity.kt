package site.ylan.compose

import android.content.res.Configuration
import android.os.Bundle
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import site.ylan.compose.ui.Component.AlertDialogExample
import site.ylan.compose.ui.Component.CheckboxMinimalExample
import site.ylan.compose.ui.Component.CheckboxParentExample
import site.ylan.compose.ui.Component.ChipExample
import site.ylan.compose.ui.Component.DatePickerDocked
import site.ylan.compose.ui.Component.DatePickerFieldToModal
import site.ylan.compose.ui.Component.DetailedDrawerExample
import site.ylan.compose.ui.Component.DropdownMenuWithDetails
import site.ylan.compose.ui.Component.HorizontalDividerExample
import site.ylan.compose.ui.Component.HorizontalMultiBrowseCarouselDemo
import site.ylan.compose.ui.Component.HorizontalUncontainedCarouselDemo
import site.ylan.compose.ui.Component.IndeterminateCircularIndicator
import site.ylan.compose.ui.Component.LinearDeterminateIndicator
import site.ylan.compose.ui.Component.LongBasicDropdownMenu
import site.ylan.compose.ui.Component.MinimalDialog
import site.ylan.compose.ui.Component.MinimalDropdownMenu
import site.ylan.compose.ui.Component.VerticalDividerExample
import site.ylan.compose.ui.Component.WithImageDialog
import site.ylan.compose.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                // Conversation(MsgData.messages)
                // HorizontalMultiBrowseCarouselDemo()
                // HorizontalUncontainedCarouselDemo()
                // CheckboxMinimalExample()
                // CheckboxParentExample()
                // ChipExample()
                // AlertDialogExample()
                // MinimalDialog()
                // WithImageDialog()
                // HorizontalDividerExample()
                // VerticalDividerExample()
                // DatePickerDocked()
                // DatePickerFieldToModal()
                // MinimalDropdownMenu()
                // LongBasicDropdownMenu()
                // DropdownMenuWithDetails()
                // DetailedDrawerExample(
                //    content = {
                //        Text("DetailedDrawerExample")
                //    }
                // )
                // LinearDeterminateIndicator()
                IndeterminateCircularIndicator()
            }
        }
    }
}

// 定义
@Composable
fun MessageCard(msg: Message) {
    var isExpanded by remember {
        mutableStateOf(false)
    }

    val surfaceColor by animateColorAsState(
        targetValue = if (isExpanded) {
            MaterialTheme.colorScheme.primary
        } else {
            MaterialTheme.colorScheme.surface
        }
    )

    Surface(
        shape = MaterialTheme.shapes.large,
        tonalElevation = 5.dp,
        shadowElevation = 2.dp,
        modifier = Modifier
            .padding(start = 18.dp, end = 18.dp, bottom = 6.dp, top = 0.dp)
            .clickable {
                isExpanded = !isExpanded
            },
        color = surfaceColor,
    ) {
        Row(
            modifier = Modifier.padding(start = 12.dp, end = 12.dp, bottom = 8.dp, top = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "profile picture",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .border(0.5.dp, MaterialTheme.colorScheme.primary, shape = CircleShape)
            )

            Spacer(
                Modifier.padding(horizontal = 4.dp)
            )

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = msg.author,
                    color = MaterialTheme.colorScheme.secondary,
                    style = MaterialTheme.typography.titleMedium,
                )

                Spacer(
                    Modifier.padding(vertical = 4.dp)
                )

                Text(
                    text = msg.body,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    modifier = Modifier
                        .animateContentSize()
                        .padding(1.dp)
                )
            }

            Spacer(
                Modifier.padding(horizontal = 12.dp)
            )

            Button(
                shape = RoundedCornerShape(20),
                onClick = {

                }
            ) {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = null,
                    modifier = Modifier.size(ButtonDefaults.IconSize)
                )
                Spacer(
                    modifier = Modifier.size(ButtonDefaults.IconSpacing)
                )
                Text("确认")
            }
        }
    }
}

@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .systemBarsPadding()
    ) {
        items(
            items = messages,
            key = { message ->
                message.id
            }
        ) { message ->
            MessageCard(message)
        }
    }
}

@Preview(name = "Light Mode")
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, name = "Dark Mode")
@Composable
fun MessageCardPreview() {
    AppTheme {
        MessageCard(Message(author = "Jetpack Compose", body = "TEST"))
    }
}

@Preview(name = "Light Mode")
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, name = "Dark Mode")
@Composable
fun ConversationPreview() {
    AppTheme {
        Conversation(MsgData.messages)
    }
}

// Model
data class Message(
    val id: Int = 1,
    val author: String,
    val body: String
)

// Data
object MsgData {
    private const val AUTHOR: String = "Jetpack Compose"
    val messages = listOf(
        Message(1, AUTHOR, "我们开始更新啦"),
        Message(2, AUTHOR, "为了给广大的读者一个更好的体验，从今天起，我们公众号决定陆续发一些其他作者的高质量文章"),
        Message(3, AUTHOR, "每逢佳节倍思亲，从今天起，参加我们公众号活动的同学可以获得精美礼品一份！！"),
        Message(4, AUTHOR, "荣华梦一场，功名纸半张，是非海波千丈，马蹄踏碎禁街霜，听几度头鸡唱"),
        Message(5, AUTHOR, "唤归来，西湖山上野猿哀。二十年多少风流怪，花落花开。望云霄拜将台，袖星斗安邦策，破烟月迷魂寨。酸斋笑我，我笑酸斋"),
        Message(6, AUTHOR, "伤心尽处露笑颜，醉里孤单写狂欢。两路殊途情何奈，三千弱水忧忘川。花开彼岸朦胧色，月过长空爽朗天。青鸟思飞无侧羽，重山万水亦徒然"),
        Message(7, AUTHOR, "又到绿杨曾折处，不语垂鞭，踏遍清秋路。衰草连天无意绪，雁声远向萧关去。恨天涯行役苦，只恨西风，吹梦成今古。明日客程还几许，沾衣况是新寒雨"),
        Message(8, AUTHOR, "莫笑农家腊酒浑，丰年留客足鸡豚。山重水复疑无路，柳暗花明又一村。箫鼓追随春社近，衣冠简朴古风存。从今若许闲乘月，拄杖无时夜叩门"),
        Message(9, AUTHOR, "为了给广大的读者一个更好的体验，从今天起，我们公众号决定陆续发一些其他作者的高质量文章"),
        Message(10, AUTHOR, "每逢佳节倍思亲，从今天起，参加我们公众号活动的同学可以获得精美礼品一份！！"),
        Message(11, AUTHOR, "荣华梦一场，功名纸半张，是非海波千丈，马蹄踏碎禁街霜，听几度头鸡唱"),
        Message(12, AUTHOR, "唤归来，西湖山上野猿哀。二十年多少风流怪，花落花开。望云霄拜将台，袖星斗安邦策，破烟月迷魂寨。酸斋笑我，我笑酸斋"),
        Message(13, AUTHOR, "伤心尽处露笑颜，醉里孤单写狂欢。两路殊途情何奈，三千弱水忧忘川。花开彼岸朦胧色，月过长空爽朗天。青鸟思飞无侧羽，重山万水亦徒然"),
        Message(14, AUTHOR, "又到绿杨曾折处，不语垂鞭，踏遍清秋路。衰草连天无意绪，雁声远向萧关去。恨天涯行役苦，只恨西风，吹梦成今古。明日客程还几许，沾衣况是新寒雨"),
        Message(15, AUTHOR, "莫笑农家腊酒浑，丰年留客足鸡豚。山重水复疑无路，柳暗花明又一村。箫鼓追随春社近，衣冠简朴古风存。从今若许闲乘月，拄杖无时夜叩门"),
    )
}