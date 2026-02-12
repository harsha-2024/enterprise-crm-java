import React, { useState } from 'react'
import api from '../api/axios'
import { TextField, Button, Paper, Typography } from '@mui/material'

export default function Login(){
  const [email, setEmail] = useState('admin@crm.local')
  const [password, setPassword] = useState('ChangeMe123!')
  const [tenantId, setTenantId] = useState('demo-tenant')
  const [error, setError] = useState('')
  const submit = async (e)=>{
    e.preventDefault(); setError('')
    try{ const res = await api.post('/api/auth/login', { email, password }); localStorage.setItem('token', res.data.token); localStorage.setItem('tenantId', tenantId); location.href='/' }catch(err){ setError('Login failed') }
  }
  return (
    <Paper sx={{maxWidth:420, m:'40px auto', p:3}}>
      <Typography variant="h6" gutterBottom>Login</Typography>
      <form onSubmit={submit}>
        <TextField label="Tenant ID" fullWidth margin="normal" value={tenantId} onChange={e=>setTenantId(e.target.value)} />
        <TextField label="Email" fullWidth margin="normal" value={email} onChange={e=>setEmail(e.target.value)} />
        <TextField label="Password" type="password" fullWidth margin="normal" value={password} onChange={e=>setPassword(e.target.value)} />
        {error && <Typography color="error">{error}</Typography>}
        <Button type="submit" variant="contained" fullWidth sx={{mt:2}}>Sign in</Button>
      </form>
    </Paper>
  )
}
