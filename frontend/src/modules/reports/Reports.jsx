import React from 'react'
import { Paper, Typography } from '@mui/material'
import { PieChart, Pie, Cell, Tooltip, ResponsiveContainer } from 'recharts'

export default function Reports(){
  const chart = [ { name:'Won', value:12 }, { name:'Lost', value:7 }, { name:'Open', value:23 } ]
  const COLORS = ['#2e7d32','#c62828','#1565c0']
  return (
    <Paper sx={{p:2}}>
      <Typography variant="h6" gutterBottom>Pipeline Summary</Typography>
      <ResponsiveContainer width="100%" height={300}>
        <PieChart>
          <Pie data={chart} dataKey="value" nameKey="name" cx="50%" cy="50%" outerRadius={100} label>
            {chart.map((entry, index) => (<Cell key={`c-${index}`} fill={COLORS[index % COLORS.length]} />))}
          </Pie>
          <Tooltip />
        </PieChart>
      </ResponsiveContainer>
    </Paper>
  )
}
