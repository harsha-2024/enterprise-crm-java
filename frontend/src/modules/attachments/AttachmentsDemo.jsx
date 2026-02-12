import React, { useEffect, useState } from 'react'
import api from '../../api/axios'
import { Paper, Button, List, ListItem, ListItemText } from '@mui/material'

export default function AttachmentsDemo(){
  const [items, setItems] = useState([])
  const entityType = 'deal'; const entityId = 'demo-deal'
  const load = async ()=>{ const r = await api.get('/api/attachments', { params: { entityType, entityId } }); setItems(r.data.content||[]) }
  useEffect(()=>{ load() },[])
  const onFile = async (e)=>{
    const file = e.target.files[0]; if(!file) return
    const presign = await api.post('/api/attachments/presign', { entityType, entityId, fileName:file.name, contentType: file.type, size: file.size })
    const { url, headers, objectKey, bucket } = presign.data
    await fetch(url, { method:'PUT', headers, body:file })
    await api.post('/api/attachments', { entityType, entityId, objectKey, bucket, url: url.split('?')[0], contentType: file.type, size: file.size })
    load()
  }
  return (
    <Paper sx={{p:2}}>
      <input type="file" onChange={onFile} />
      <List>
        {items.map(a => (<ListItem key={a.id}><ListItemText primary={a.objectKey} secondary={`${a.size} • ${a.contentType}`} /></ListItem>))}
      </List>
    </Paper>
  )
}
