package com.bright.listofmessages.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
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
import com.bright.listofmessages.R
import com.bright.listofmessages.data.Program
import com.bright.listofmessages.ui.theme.Border
import com.bright.listofmessages.ui.theme.ImageSize
import com.bright.listofmessages.ui.theme.Padding


@Composable
fun ProgramCard(program: Program) {

    Row(modifier = Modifier.padding(Padding.medium, Padding.small)) {


        Box (
            modifier = Modifier
                .border(Border.small, MaterialTheme.colorScheme.primary, CircleShape)
                .padding(Padding.extraSmall)
        ){
            Image(
                painter = painterResource(id = R.drawable.maharishi_logo),
                contentDescription = "miu program",
                modifier = Modifier
                    .clip(CircleShape)
                    .size(ImageSize.imageSize)
            )
        }

        Spacer(modifier = Modifier.width(Padding.medium))
         var isExpanded by remember {
            mutableStateOf(false)
        }
        Column(
            modifier = Modifier.clickable { isExpanded = !isExpanded }
        ) {
            Text(
                text = program.name,
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(Padding.small))
            Text(
                text = program.description,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = if(isExpanded) Int.MAX_VALUE else 1
            )
            if(isExpanded)  Divider()
        }
    }
}


@Preview
@Composable
fun PreviewProgramCard() {
    ProgramCard(
        program = Program(
            name = "Program Name",
            description = "Program Description"
        )
    )
}