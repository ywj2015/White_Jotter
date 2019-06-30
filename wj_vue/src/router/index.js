import Vue from 'vue'
import Router from 'vue-router'
import Login from '../components/Login'
import AppIndex from '../components/home/AppIndex'
import Home from '../components/Home'
import LibraryIndex from '../components/library/LibraryIndex'
import JotterIndex from '../components/jotter/JotterIndex'
import More from '../components/common/More'
import Editor from '../components/jotter/Editor'
import Admin from '../components/admin/AdminIndex'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/home',
      name: 'Home',
      component: Home,
      redirect: '/index',
      children: [
        {
          path: '/index',
          name: 'AppIndex',
          component: AppIndex
        },
        {
          path: '/library',
          name: 'Library',
          component: LibraryIndex
        },
        {
          path: '/editor',
          name: 'Editor',
          component: Editor
        },
        {
          path: '/jotter',
          name: 'Jotter',
          component: JotterIndex
        }
      ]
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/more',
      name: 'More',
      component: More
    },
    {
      path: '/admin',
      name: 'Admin',
      component: Admin
    }
  ]
})
