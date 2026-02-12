import React, { useEffect, useState } from 'react'
import api from '../../api/axios'
import { Paper, TextField, Button, List, ListItem, ListItemText } from '@mui/material'

export default function NotesDemo(){
  const [items, setItems] = useState([])
  const [text, setText] = useState('')
  const entityType = 'deal'; const entityId = 'demo-deal'
  const load = async ()=>{ const r = await api.get('/api/notes', { params: { entityType, entityId } }); setItems(r.data.content||[]) }
  useEffect(()=>{ load() },[])
  const add = async ()=>{ await api.post('/api/notes', { entityType, entityId, body: text }); setText(''); load() }
  return (
    <Paper sx={{p:2}}>
      <div>
        <TextField size="small" label="New note" value={text} onChange={e=>setText(e.target.value)} sx={{mr:1}} />
        <Button variant="contained" onClick={add}>Add</Button>
      </div>
      <List>
        {(items||[]).map(n => (<ListItem key={n.id}><ListItemText primary={n.body} secondary={n.createdAt} /></ListItem>))}
      </List>
    </Paper>
  )
}
