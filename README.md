# CRM Enterprise Wired (Spring Boot + React + MongoDB)

**Wired features**: Microsoft 365 OAuth scaffolding, S3 presigned uploads, per-tenant settings, schedulers, and extended React UI (notes, attachments, import wizard, sequences, reports).

## Run with Docker
```bash
docker compose up --build
```

- API: http://localhost:8080
- UI : http://localhost:5173

### Configure (env)
- S3: `AWS_REGION`, `ATTACHMENTS_BUCKET`, and AWS credentials (`AWS_ACCESS_KEY_ID`, `AWS_SECRET_ACCESS_KEY`) in your shell/host.
- Microsoft 365: `MSFT_TENANT_ID`, `MSFT_CLIENT_ID`, `MSFT_CLIENT_SECRET`, `OAUTH_REDIRECT_URI`.
- JWT: `JWT_SECRET`.

> Multi-tenant: UI sends `X-Tenant-ID` from `localStorage.tenantId`.

## OAuth flow (Microsoft 365)
1. Open UI → Dashboard → **Connect Microsoft 365**
2. Complete login → Redirect back to `/oauth/callback` (handled by frontend; server sample echoes code).
3. (Extend) Exchange `code` for refresh token server-side and store encrypted in `oauth_tokens`.

## S3 presigned uploads
- `POST /api/attachments/presign` → returns presigned URL.
- Client uploads directly to S3, then `POST /api/attachments` saves metadata.

## Notes & Timeline
- `GET/POST /api/notes?entityType=&entityId=`

## Import/Export
- `POST /api/import/contacts/csv` (demo handler in server). 

## RBAC
- Roles scaffold: TENANT_ADMIN, SALES_MANAGER, SALES_REP, SUPPORT, READ_ONLY.

---
MIT License © 2026
