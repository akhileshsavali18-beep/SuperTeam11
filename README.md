# SuperTeam11

SuperTeam11 is a fantasy-cricket app project scaffold.

## Project areas
- `web/`: download-only landing page.
- `admin/`: manual match admin UI prototype (currently browser-local demo data only).
- `backend/`: backend contract and environment template.
- `android/`: Android implementation notes.
- `docs/PROJECT_PLAN.md`: project scope and phased plan.

## Brand assets
- `superteam11_logo.png`: app logo and branding.
- `superteam11_splash.png`: splash/welcome artwork.

## Important status
This is an initial scaffold, not yet a complete production app. The admin page currently stores demo matches in the browser and does not sync with an Android app. Authentication, database-backed match management, a native Android APK, and deployment are still to be implemented. No cricket API key or payment gateway is configured.

## Development order
1. Native Android shell and session navigation.
2. Secure backend authentication and database.
3. Manual match CRUD shared with admin and app.
4. Optional server-side cricket API adapter.
5. Website APK download link after a successful build.
6. Security, compliance, and end-to-end tests.

Real-money deposits, entry fees, cash prizes, and withdrawals must remain disabled until applicable legal and platform requirements are verified.
