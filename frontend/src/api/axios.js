import axios from 'axios'
const api = axios.create({ baseURL: import.meta.env.VITE_API_BASE || 'http://localhost:8080' })
api.interceptors.request.use(cfg => { const t = localStorage.getItem('token'); if(t) cfg.headers['Authorization'] = `Bearer ${t}`; const tenant = localStorage.getItem('tenantId') || 'demo-tenant'; cfg.headers['X-Tenant-ID'] = tenant; return cfg })
export default api
