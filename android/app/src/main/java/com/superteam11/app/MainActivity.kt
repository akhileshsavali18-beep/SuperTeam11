package com.superteam11.app

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

private val Red = Color(0xFFF20D18)
private val Ink = Color(0xFF0B0B0D)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { SuperTeam11App() }
    }
}

@Composable
private fun SuperTeam11App() {
    val context = LocalContext.current
    val prefs = remember { context.getSharedPreferences("superteam11_session_demo", 0) }
    var page by remember { mutableStateOf("splash") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isSignup by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        delay(1000)
        page = if (prefs.getBoolean("demo_logged_in", false)) "home" else "auth"
    }

    MaterialTheme(colorScheme = lightColorScheme(primary = Red, background = Color.White)) {
        when (page) {
            "splash" -> ArtworkScreen("superteam11_splash.png")
            "auth" -> {
                Column(
                    modifier = Modifier.fillMaxSize().background(Color.White).verticalScroll(rememberScrollState()).padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Artwork("superteam11_splash.png", Modifier.fillMaxWidth().height(250.dp))
                    Spacer(Modifier.height(16.dp))
                    Text(if (isSignup) "Create your account" else "Welcome back", fontSize = 28.sp, fontWeight = FontWeight.Bold, color = Ink)
                    Text("SuperTeam11", color = Red, fontWeight = FontWeight.Bold)
                    Spacer(Modifier.height(20.dp))
                    OutlinedTextField(value = email, onValueChange = { email = it }, label = { Text("Email (demo UI)") }, singleLine = true, modifier = Modifier.fillMaxWidth())
                    Spacer(Modifier.height(10.dp))
                    OutlinedTextField(value = password, onValueChange = { password = it }, label = { Text("Password (demo UI)") }, visualTransformation = PasswordVisualTransformation(), singleLine = true, modifier = Modifier.fillMaxWidth())
                    Spacer(Modifier.height(16.dp))
                    Button(onClick = {
                        // Prototype only: real backend authentication is not implemented.
                        if (email.contains("@") && password.length >= 6) {
                            prefs.edit().putBoolean("demo_logged_in", true).apply()
                            page = "home"
                        }
                    }, modifier = Modifier.fillMaxWidth().height(52.dp), shape = RoundedCornerShape(12.dp)) {
                        Text(if (isSignup) "Create account (demo)" else "Login (demo)")
                    }
                    TextButton(onClick = { isSignup = !isSignup }) {
                        Text(if (isSignup) "Already have an account? Login" else "New here? Create account")
                    }
                    Text("Prototype only — do not use real credentials.", color = Color.Gray, fontSize = 12.sp)
                }
            }
            else -> {
                Column(Modifier.fillMaxSize().background(Color(0xFFF7F7F8)).padding(20.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Artwork("superteam11_logo.png", Modifier.size(52.dp))
                        Spacer(Modifier.width(12.dp))
                        Column {
                            Text("SuperTeam11", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Ink)
                            Text("Fantasy Cricket", color = Red, fontWeight = FontWeight.SemiBold)
                        }
                    }
                    Spacer(Modifier.height(24.dp))
                    Text("Upcoming Matches", fontSize = 22.sp, fontWeight = FontWeight.Bold)
                    Spacer(Modifier.height(10.dp))
                    Card(colors = CardDefaults.cardColors(containerColor = Color.White)) {
                        Column(Modifier.fillMaxWidth().padding(18.dp)) {
                            Text("No matches added yet", fontWeight = FontWeight.Bold)
                            Text("Admin-created matches will appear here after backend integration.", color = Color.Gray)
                        }
                    }
                    Spacer(Modifier.height(12.dp))
                    Text("Manual match and live API integration are not connected yet.", color = Color.Gray, fontSize = 13.sp)
                    Spacer(Modifier.weight(1f))
                    OutlinedButton(onClick = {
                        prefs.edit().remove("demo_logged_in").apply()
                        page = "auth"
                    }, modifier = Modifier.fillMaxWidth()) { Text("Logout (demo)") }
                }
            }
        }
    }
}

@Composable
private fun ArtworkScreen(asset: String) {
    Box(Modifier.fillMaxSize().background(Ink), contentAlignment = Alignment.Center) {
        Artwork(asset, Modifier.fillMaxSize())
    }
}

@Composable
private fun Artwork(asset: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val bitmap = remember(asset) {
        runCatching { context.assets.open(asset).use { BitmapFactory.decodeStream(it).asImageBitmap() } }.getOrNull()
    }
    if (bitmap != null) {
        Image(bitmap = bitmap, contentDescription = if (asset.contains("logo")) "SuperTeam11 logo" else "SuperTeam11 welcome artwork", modifier = modifier)
    } else {
        Box(modifier.background(Ink), contentAlignment = Alignment.Center) {
            Text("SuperTeam11", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 24.sp)
        }
    }
}
