import Vue from 'vue'
import Router from 'vue-router'
import Login from '../components/Login'
import Home from "../components/Home";
import BlogSelect from "../components/BlogSelect";
import BlogInsert from "../components/BlogInsert";
import BlogUpdate from "../components/BlogUpdate";
import UserManager from "../components/UserManager";
import DataCharts from "../components/DataCharts";

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: '登录',
      component: Login
    },
    {
      path: '/home',
      name: '博客系统',
      component: Home,
      show: true,
      iconClass: 'el-icon-eleme',
      //默认选中 pageOne
      redirect: '/BlogSelect',
      children:[
        {
          path: '/BlogSelect',
          name: '博客列表',
          component: BlogSelect,
          iconClass: 'el-icon-more-outline',
          show: true,
        },
        {
          path: '/BlogInsert',
          name: '发表博客',
          component: BlogInsert,
          iconClass: 'el-icon-circle-plus-outline',
          show: true,
        },
        {
          path: '/BlogUpdate',
          component: BlogUpdate,
          show: false
        },
        {
          path: '/UserManager',
          name: '用户管理',
          component: UserManager,
          iconClass: 'el-icon-s-custom',
          show: true
        },
        {
          path: '/DataCharts',
          name: '数据视图',
          component: DataCharts,
          iconClass: 'el-icon-view',
          show: true
        }
      ]
    },
  ]
})
