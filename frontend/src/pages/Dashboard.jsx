import React from 'react'
import { Paper, Typography, Button } from '@mui/material'
import api from '../api/axios'

export default function Dashboard(){
  const connect = async ()=>{
    const r = await api.get('/api/oauth/msft/authorize')
    window.location.href = r.data.url
  }
  return (
    <Paper sx={{p:2}}>
      <Typography variant="h5" gutterBottom>CRM Enterprise Wired</Typography>
      <Typography gutterBottom>Connect Microsoft 365 for email & calendar.</Typography>
      <Button variant="contained" onClick={connect}>Connect Microsoft 365</Button>
    </Paper>
  )
}
