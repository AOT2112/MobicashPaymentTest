package com.compasplus.mobicashpaymenttest.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarColors
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberSearchBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.compasplus.mobicashpaymenttest.R

@Composable
fun SimpleSearchBar(modifier : Modifier = Modifier) {
    val containerColor = MaterialTheme.colorScheme.surface
    val iconsColor = MaterialTheme.colorScheme.surfaceTint
    val textFieldColors = TextFieldDefaults.colors(
        focusedContainerColor = containerColor,
        unfocusedContainerColor = containerColor,
        disabledContainerColor = containerColor,
        errorContainerColor = containerColor,
        
        focusedLeadingIconColor = iconsColor,
        unfocusedLeadingIconColor = iconsColor,
        disabledLeadingIconColor = iconsColor,
        errorLeadingIconColor = iconsColor,

        focusedTrailingIconColor = iconsColor,
        unfocusedTrailingIconColor = iconsColor,
        disabledTrailingIconColor = iconsColor,
        errorTrailingIconColor = iconsColor
    )

    @OptIn(ExperimentalMaterial3Api::class)
    val searchState = rememberSearchBarState()
    var query by remember { mutableStateOf<String?>(null) }
    @OptIn(ExperimentalMaterial3Api::class)
    SearchBar(
        state = searchState,
        inputField = {
            SearchBarDefaults.InputField(
                query = query ?: "",
                onQueryChange = { query = it },
                onSearch = { },
                expanded = false,
                onExpandedChange = { },
                placeholder = {
                    Text(
                        stringResource(R.string.search),
                        fontSize = MaterialTheme.typography.bodyLarge.fontSize
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search",
                        //tint = iconsColor
                    )
                },
                trailingIcon = {
                    if (query.isNullOrEmpty()) {
                        IconButton(
                            onClick = { }
                        ) {
                            Icon(
                                Icons.Outlined.Check,
                                contentDescription = "Voice"
                            )
                        }
                    }
                    else {
                        IconButton(
                            onClick = { query = null }
                        ) {
                            Icon(
                                Icons.Outlined.Close,
                                contentDescription = "Close"
                            )
                        }
                    }
                },
                colors = textFieldColors
            )
        },
        modifier = modifier.height(50.dp)
            .fillMaxWidth(),
        shape = CornerShape,
        colors = SearchBarColors(
            containerColor,
            iconsColor,
            textFieldColors),
        shadowElevation = ShadowElevation
    )
}