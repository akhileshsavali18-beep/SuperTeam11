# SuperTeam11 — Project Plan

## Product structure
- Android app: main fantasy-cricket experience.
- Website: download/information page only.
- Admin panel: manage matches manually and prepare an API integration.
- Backend: shared by Android app and admin panel.

## Brand assets
- `superteam11_logo.png`: logo only; use for app icon, headers, and other branding locations as appropriate.
- `superteam11_splash.png`: splash/welcome artwork and login/signup artwork.

## Launch flow
1. Show splash artwork when the app opens.
2. Check the persisted authentication session.
3. If the user is authenticated, navigate to Home.
4. Otherwise, show Login/Signup.
5. On logout, return to Login/Signup.

## Match management
- Manual match creation must work without an external cricket API.
- Keep an API integration layer that can be configured later.
- If no API provider/key is configured, clearly show API mode as unconfigured; do not invent live scores.

## Initial development order
1. Confirm repository and asset paths.
2. Choose the Android app and backend structure.
3. Implement authentication/session navigation.
4. Implement database schema and manual match management.
5. Implement admin panel.
6. Add the configurable cricket API adapter.
7. Build the download-only website.
8. Test and document deployment.

## Wallet and real-money features
Design interfaces and isolated modules separately. Do not enable deposits, entry-fee collection, cash prizes, or withdrawals until applicable legal and platform requirements have been verified. No payment gateway is configured at this stage.
