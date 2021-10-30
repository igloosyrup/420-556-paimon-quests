import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '@/views/Home'
import About from '@/views/About'
import PaimonHome from '@/views/PaimonHome'
import Login from '@/views/Login'
import Register from '@/views/Register'
import Error404 from '@/components/Error404'
Vue.use(VueRouter)

const routes = [
  { path: '/', name: 'Home', component: Home },
  { path: '/home', component: Home },
  { path: '/about', name: 'About', component: About },
  { path: '/paimon',  name: 'Paimon', component: PaimonHome },
  { path: '/login',  name: 'Login', component: Login },
  { path: '/register',  name: 'Register', component: Register },
  { path: '/:catchAll(.*)', name: 'Error404', component: Error404 }
]

const router = new VueRouter({
  mode: "history",
  routes
})

export default router
