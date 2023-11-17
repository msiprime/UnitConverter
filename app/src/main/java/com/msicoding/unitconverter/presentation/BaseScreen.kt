package com.msicoding.unitconverter.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.lifecycle.viewmodel.compose.viewModel
import com.msicoding.unitconverter.Converter
import com.msicoding.unitconverter.ConverterViewModel
import com.msicoding.unitconverter.presentation.ui.theme.UnitConverterTheme

@Composable
fun BaseScreen(
    modifier: Modifier = Modifier,
    converterViewModel: ConverterViewModel = viewModel()
) {
    val list = converterViewModel.getConversions()
    Column(modifier = Modifier.padding(30.dp)) {
        TopScreen(list)
        Spacer(modifier = modifier.height(20.dp))
        HistoryScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    UnitConverterTheme {

    }
}

@Composable
fun TopScreen(list: List<Converter>) {

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConversionMenu(list: List<Converter>, modifier: Modifier) {

    var displayingText by remember {
        mutableStateOf("Select the conversion type")
    }
    var textFieldSize by remember {
        mutableStateOf(Size.Zero)
    }
    var expanded by remember {
        mutableStateOf(false)
    }
    var icon = if (expanded)
        Icons.Filled.KeyboardArrowUp
    else Icons.Filled.KeyboardArrowDown

    OutlinedTextField(
        value = displayingText, onValueChange = {
            displayingText = it
        }, textStyle = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
        modifier = modifier
            .fillMaxWidth()
            .onGloballyPositioned { cordinates ->
                textFieldSize = cordinates.size.toSize()
            },
        label = {
            Text(text = "Conversion type")
        },
        trailingIcon = {
            Icon(
                icon, contentDescription = "icon"
            )
            modifier.clickable {
                expanded = !expanded
            }
        }, readOnly = true
    )
    DropdownMenu(
        expanded = expanded, onDismissRequest = { expanded = false }, modifier = modifier.width(
            with(LocalDensity.current) {
                textFieldSize.width.toDp()
            })
    ) {
        list.forEach { conversion ->

            DropdownMenuItem(
                text = {
                    Text(
                        text = conversion.description,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                },
                onClick = {
                    displayingText = conversion.description
                    expanded = false
                })

        }
    }

}

@Composable
fun InputBlock() {

}

@Composable
fun ResultBLock() {

}

@Composable
fun HistoryScreen() {

}

@Composable
fun hi() {

}