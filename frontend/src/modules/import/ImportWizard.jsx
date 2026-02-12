import React, { useState } from 'react'
import api from '../../api/axios'
import { Paper, Typography, Button } from '@mui/material'

export default function ImportWizard(){
  const [file, setFile] = useState(null)
  const [msg, setMsg] = useState('')
  const upload = async ()=>{
    const fd = new FormData(); fd.append('file', file)
    const r = await api.post('/api/import/contacts/csv', fd, { headers: { 'Content-Type': 'multipart/form-data' } })
    setMsg(r.data)
  }
  return (
    <Paper sx={{p:2}}>
      <Typography variant="h6" gutterBottom>Import Contacts (CSV)</Typography>
      <input type="file" accept="text/csv" onChange={e=>setFile(e.target.files[0])} />
      <Button variant="contained" onClick={upload} disabled={!file} sx={{ml:1}}>Upload</Button>
      {msg && <div style={{marginTop:12}}>{msg}</div>}
    </Paper>
  )
}
