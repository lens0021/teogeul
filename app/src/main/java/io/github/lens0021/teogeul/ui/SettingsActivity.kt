package io.github.lens0021.teogeul.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import io.github.lens0021.teogeul.IMEService
import io.github.lens0021.teogeul.R
import io.github.lens0021.teogeul.model.KeyMappings

@AndroidEntryPoint
class SettingsActivity : ComponentActivity() {
    private val viewModel: SettingsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize IME instance if needed
        if (IMEService.getInstance() == null) {
            IMEService(this)
        }

        setContent {
            MaterialTheme(
                colorScheme = dynamicLightColorScheme(),
            ) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "main",
                    ) {
                        composable("main") { SettingsMainScreen(navController, viewModel) }
                        composable("about") { AboutScreen(navController) }
                    }
                }
            }
        }
    }

    @Composable
    private fun dynamicLightColorScheme(): ColorScheme = lightColorScheme()
}

// ===== Main Screen =====

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsMainScreen(
    navController: NavController,
    viewModel: SettingsViewModel,
) {
    val hardwareHangulLayout by viewModel.hardwareHangulLayout.collectAsState()
    val hardwareAlphabetLayout by viewModel.hardwareAlphabetLayout.collectAsState()
    val useMoachigi by viewModel.hardwareUseMoachigi.collectAsState()
    val fullMoachigi by viewModel.hardwareFullMoachigi.collectAsState()
    val moachingiDelay by viewModel.hardwareFullMoachingiDelay.collectAsState()
    val useStandardJamo by viewModel.systemUseStandardJamo.collectAsState()
    val startHangulMode by viewModel.systemStartHangulMode.collectAsState()
    val keyMappingsString by viewModel.systemKeyMappings.collectAsState()

    val hardwareHangulEntries = stringArrayResource(R.array.keyboard_hangul_layout).toList()
    val hardwareHangulValues = stringArrayResource(R.array.keyboard_hangul_layout_id).toList()
    val hardwareAlphabetEntries = stringArrayResource(R.array.keyboard_alphabet_layout).toList()
    val hardwareAlphabetValues = stringArrayResource(R.array.keyboard_alphabet_layout_id).toList()
    val startHangulEntries = stringArrayResource(R.array.start_hangul_mode_entries).toList()
    val startHangulValues = stringArrayResource(R.array.start_hangul_mode_values).toList()

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
    ) {
        // ===== Installation Section =====
        item {
            EnableInputMethodPreference(
                title = stringResource(R.string.preference_method_enabler_title),
                summary = stringResource(R.string.preference_method_enabler_summary),
            )
        }

        item {
            PickInputMethodPreference(
                title = stringResource(R.string.preference_method_picker_title),
            )
        }

        item { HorizontalDivider() }

        item {
            KeyboardListPreference(
                title = stringResource(R.string.preference_hardware_hangul_title),
                summary = stringResource(R.string.preference_hardware_hangul_summary),
                entries = hardwareHangulEntries,
                entryValues = hardwareHangulValues,
                selectedValue = hardwareHangulLayout,
                onValueChange = { viewModel.updatePreference("hardware_hangul_layout", it) },
            )
        }

        item {
            KeyboardListPreference(
                title = stringResource(R.string.preference_hardware_alphabet_title),
                summary = stringResource(R.string.preference_hardware_alphabet_summary),
                entries = hardwareAlphabetEntries,
                entryValues = hardwareAlphabetValues,
                selectedValue = hardwareAlphabetLayout,
                onValueChange = { viewModel.updatePreference("hardware_alphabet_layout", it) },
            )
        }

        item {
            CheckboxPreference(
                title = stringResource(R.string.preference_hardware_use_moachigi_title),
                summary = stringResource(R.string.preference_hardware_use_moachigi_summary),
                checked = useMoachigi,
                onCheckedChange = { viewModel.updatePreference("hardware_use_moachigi", it) },
            )
        }

        item {
            CheckboxPreference(
                title = stringResource(R.string.preference_hardware_full_moachigi_title),
                summary = stringResource(R.string.preference_hardware_full_moachigi_summary),
                checked = fullMoachigi,
                onCheckedChange = { viewModel.updatePreference("hardware_full_moachigi", it) },
            )
        }

        item {
            IntEditTextPreference(
                title = stringResource(R.string.preference_hardware_full_moachigi_delay_title),
                summary = stringResource(R.string.preference_hardware_full_moachigi_delay_summary),
                value = moachingiDelay,
                onValueChange = { viewModel.updatePreference("hardware_full_moachigi_delay", it) },
            )
        }

        item {
            CheckboxPreference(
                title = stringResource(R.string.preference_system_use_standard_jamo_title),
                summary = stringResource(R.string.preference_system_use_standard_jamo_summary),
                checked = useStandardJamo,
                onCheckedChange = { viewModel.updatePreference("system_use_standard_jamo", it) },
            )
        }

        item {
            ListPreference(
                title = stringResource(R.string.preference_system_start_hangul_mode_title),
                summary = stringResource(R.string.preference_system_start_hangul_mode_summary),
                entries = startHangulEntries,
                entryValues = startHangulValues,
                selectedValue = startHangulMode,
                onValueChange = { viewModel.updatePreference("system_start_hangul_mode", it) },
            )
        }

        item {
            val keyMappings =
                remember(keyMappingsString) {
                    KeyMappings.parse(keyMappingsString)
                }

            KeyMappingsPreference(
                title = stringResource(R.string.preference_key_mappings_title),
                mappings = keyMappings.mappings,
                onMappingsChange = { newMappings ->
                    viewModel.updatePreference(
                        "system_key_mappings",
                        KeyMappings(newMappings).serialize(),
                    )
                },
            )
        }

        item { HorizontalDivider() }

        // ===== IME Info Section =====
        item {
            SettingSectionItem(
                title = stringResource(R.string.preference_aboutime_menu),
                icon = Icons.Default.Info,
                onClick = { navController.navigate("about") },
            )
        }
    }
}

@Composable
private fun SettingSectionItem(
    title: String,
    icon: ImageVector,
    onClick: () -> Unit,
) {
    Surface(
        modifier =
            Modifier
                .fillMaxWidth()
                .clickable(onClick = onClick),
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier.padding(end = 16.dp),
            )
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
            )
        }
    }
    HorizontalDivider()
}

// ===== About Screen =====

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutScreen(navController: NavController) {
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.preference_aboutime_menu)) },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
            )
        },
    ) { paddingValues ->
        LazyColumn(
            modifier =
                Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
        ) {
            item {
                PreferenceItem(
                    title = stringResource(R.string.preference_about_license),
                    summary = stringResource(R.string.teogeul_korean_license),
                    onClick = {
                        val intent =
                            Intent(Intent.ACTION_VIEW, Uri.parse("https://www.apache.org/licenses/LICENSE-2.0"))
                        context.startActivity(intent)
                    },
                )
            }

            item {
                PreferenceItem(
                    title = stringResource(R.string.preference_about_source_code),
                    summary = "https://github.com/lens0021/Teogeul",
                    onClick = {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/lens0021/teogeul"))
                        context.startActivity(intent)
                    },
                )
            }
        }
    }
}
