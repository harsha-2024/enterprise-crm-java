import React, { useState } from 'react'
import { Paper, TextField, Button, List, ListItem } from '@mui/material'

export default function Sequences(){
  const [name, setName] = useState('New Sequence')
  const [steps, setSteps] = useState([{ dayOffset:0, templateId:'welcome' }])
  const add = ()=> setSteps([...steps, { dayOffset: steps.length*2, templateId:'followup' }])
  return (
    <Paper sx={{p:2}}>
      <TextField size="small" label="Name" value={name} onChange={e=>setName(e.target.value)} />
      <Button sx={{ml:1}} onClick={add}>Add Step</Button>
      <List>
        {steps.map((s,i)=>(<ListItem key={i}>Day +{s.dayOffset} → {s.templateId}</ListItem>))}
      </List>
    </Paper>
  )
}
