import i18n from 'i18next'
import { initReactI18next } from 'react-i18next'

const resources = { en: { translation: { appName:'CRM Enterprise Wired', dashboard:'Dashboard', notes:'Notes', attachments:'Attachments', import:'Import', sequences:'Sequences', reports:'Reports', oauth:'Connect Mail/Calendar', board:'Board', pipelines:'Pipelines', login:'Login', logout:'Logout' } } }

i18n.use(initReactI18next).init({ resources, lng:'en', fallbackLng:'en', interpolation:{ escapeValue:false } })
export default i18n
