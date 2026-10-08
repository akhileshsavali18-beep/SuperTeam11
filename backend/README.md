# SuperTeam11 backend

No live cricket API or payment gateway is configured.

Planned endpoints:
- `POST /api/auth/signup`
- `POST /api/auth/login`
- `GET /api/matches`
- `POST /api/admin/matches` (admin only)
- `PATCH /api/admin/matches/{id}` (admin only)
- `DELETE /api/admin/matches/{id}` (admin only)
- `GET /api/config/cricket-provider` (non-secret status only)

Manual matches must be persisted in a database, not browser localStorage. Passwords must be hashed and admin endpoints authenticated/authorized. Store provider API keys only in server-side environment secrets.