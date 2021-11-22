import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '@/views/Home'
import About from '@/views/About'
import Login from '@/views/Login'
import Register from '@/views/Register'
import Error404 from '@/components/Error404'
import User from '@/views/User'
import Admin from '@/views/Admin'
import store from '@/store/store.js'
import EditUser from '@/views/EditUser'
import NewQuest from '@/views/NewQuest'

Vue.use(VueRouter)

const routes = [
  { path: '/', name: 'Home', component: Home },
  { path: '/home', component: Home },
  { path: '/about', name: 'About', component: About },
  { path: '/login', name: 'Login', component: Login },
  { path: '/register', name: 'Register', component: Register },
  { path: '/user', name: 'User', component: User },
  { path: '/admin', name: 'Admin', component: Admin },
  { path: '/edit-user', name: 'EditUser', component: EditUser },
  { path: '/new-quest', name: 'NewQuest', component: NewQuest },
  { path: '/:catchAll(.*)', name: 'Error404', component: Error404 }
]

const router = new VueRouter({
  mode: "history",
  routes,
})

router.beforeEach((to, from, next) => {
  if (to.name !== 'Login' && to.name !== 'Home' && to.name !== 'About' && to.name !== 'Register' && ( store.getters.currentUser == undefined ||
      store.getters.currentUser == "")) 
        next({ name: 'Home' })
  else if ((to.name == 'Login' || to.name == 'Register') && ( store.getters.currentUser != undefined && 
      store.getters.currentUser != ""))
        next({ name: 'Home'})
  else
    next()
})

export default router
