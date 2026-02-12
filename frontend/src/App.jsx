import React, { useMemo, useState } from 'react'
import { Routes, Route, Navigate, Link } from 'react-router-dom'
import { AppBar, Toolbar, Button, Container, Switch } from '@mui/material'
import { createTheme, ThemeProvider } from '@mui/material/styles'
import { useTranslation } from 'react-i18next'
import Login from './pages/Login'
import Dashboard from './pages/Dashboard'
import NotesDemo from './modules/notes/NotesDemo'
import AttachmentsDemo from './modules/attachments/AttachmentsDemo'
import ImportWizard from './modules/import/ImportWizard'
import Sequences from './modules/sequences/Sequences'
import Reports from './modules/reports/Reports'
import ProtectedRoute from './components/ProtectedRoute'

export default function App(){
  const { t } = useTranslation()
  const [dark, setDark] = useState(false)
  const theme = useMemo(()=>createTheme({ palette:{ mode: dark?'dark':'light' } }),[dark])
  const token = localStorage.getItem('token')

  return (
    <ThemeProvider theme={theme}>
      <AppBar position="static">
        <Toolbar>
          <Button color="inherit" component={Link} to="/">{t('dashboard')}</Button>
          <Button color="inherit" component={Link} to="/notes">{t('notes')}</Button>
          <Button color="inherit" component={Link} to="/attachments">{t('attachments')}</Button>
          <Button color="inherit" component={Link} to="/import">{t('import')}</Button>
          <Button color="inherit" component={Link} to="/sequences">{t('sequences')}</Button>
          <Button color="inherit" component={Link} to="/reports">{t('reports')}</Button>
          <div style={{flex:1}} />
          <Switch checked={dark} onChange={()=>setDark(v=>!v)} />
          {token ? (
            <Button color="inherit" onClick={()=>{localStorage.clear(); location.href='/login'}}>{t('logout')}</Button>
          ) : (
            <Button color="inherit" component={Link} to="/login">{t('login')}</Button>
          )}
        </Toolbar>
      </AppBar>
      <Container sx={{mt:2}}>
        <Routes>
          <Route path="/login" element={<Login />} />
          <Route path="/" element={<ProtectedRoute><Dashboard/></ProtectedRoute>} />
          <Route path="/notes" element={<ProtectedRoute><NotesDemo/></ProtectedRoute>} />
          <Route path="/attachments" element={<ProtectedRoute><AttachmentsDemo/></ProtectedRoute>} />
          <Route path="/import" element={<ProtectedRoute><ImportWizard/></ProtectedRoute>} />
          <Route path="/sequences" element={<ProtectedRoute><Sequences/></ProtectedRoute>} />
          <Route path="/reports" element={<ProtectedRoute><Reports/></ProtectedRoute>} />
          <Route path="*" element={<Navigate to="/" />} />
        </Routes>
      </Container>
    </ThemeProvider>
  )
}
