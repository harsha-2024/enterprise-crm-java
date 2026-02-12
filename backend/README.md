# CRM Enterprise (Spring Boot + React + MongoDB)

Enterprise-ready CRM starter including pipelines (drag-and-drop API), notes & timelines, file attachments, import/export, email queue, tasks/reminders (scheduling), advanced RBAC stubs, reports, webhooks/Zapier hooks, multi-tenancy, and i18n/theming on the frontend.

> **Multi-tenant header:** Include `X-Tenant-ID: <your-tenant-id>` in every request.

## Quick start (backend)
```bash
cd backend
mvn spring-boot:run
```

Environment:
- `MONGODB_URI` (default `mongodb://localhost:27017/crm`)
- `JWT_SECRET`, `JWT_EXP`
- SMTP: `SMTP_HOST`, `SMTP_PORT`, `SMTP_USER`, `SMTP_PASS`, `SMTP_AUTH`, `SMTP_TLS`
- Storage: `STORAGE_PROVIDER` = `local|s3|azure|gcs` + relevant creds

Swagger UI at `http://localhost:8080/swagger-ui.html`

## Endpoints (highlights)
- Auth: `POST /api/auth/login`
- Pipelines: `GET/POST/PUT /api/pipelines`
- Deal board: `GET /api/board/{pipelineId}/{stageId}`, `POST /api/board/move`
- Notes: `GET/POST /api/notes?entityType=deal&entityId=...`
- Attachments: `GET/POST /api/attachments` (multipart upload; provider TODO)
- Import/Export: `POST /api/import-export/contacts/csv`, `GET /api/import-export/contacts/csv`
- Email: `POST /api/email/send` (queued via SMTP)
- Reports: `GET /api/reports/pipeline-summary`
- Webhooks: `POST/GET /api/webhooks/subscriptions`, inbound Zapier example `POST /api/webhooks/inbound/zapier`

## Notes
- RBAC, calendar sync, provider integrations (S3/Azure/GCS, Graph/Gmail) are scaffolded for rapid completion once you share preferences/credentials.
- Frontend includes i18n (en/nl) and dark/light theme with a Kanban board UI stub.
