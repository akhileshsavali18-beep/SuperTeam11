# SuperTeam11 Android app

This repository is being scaffolded in stages. The current web/admin pages are prototypes, not production authentication or shared database services.

## Intended Android navigation
- Launch splash artwork from `superteam11_splash.png`.
- Restore authenticated session.
- If signed in, open Home.
- Otherwise show Login/Signup.
- Use `superteam11_logo.png` for app icon and branding.

## Next implementation
Add a native Android project (Kotlin), backend authentication, database-backed manual matches, and a secured admin API. Do not store production passwords or secrets in the client.