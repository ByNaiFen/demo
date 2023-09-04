/*
 * @Author: YeShaoKang 630471737@qq.com
 * @Date: 2023-09-02 20:16:00
 * @LastEditors: YeShaoKang 630471737@qq.com
 * @LastEditTime: 2023-09-04 02:38:21
 * @FilePath: \employee-admin-parent\employee-web\src\router\index.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'login',
    component: () => import(/* webpackChunkName: "about" */ '@/views/Login.vue')
  },
  /*首页路由 */
  {
    path: "/admin",
    name: "Home",
    component: () => import("@/views/index.vue"),
    children: [
      /*职工统计 */
      {
        path: "employee-count",
        name: "employeeCount",
        component: () => import("@/views/admin/employee/EmployeeCount.vue"),
      },
      /*职工列表*/
      {
        path: "employee-list",
        name: "employeeList",
        component: () => import("@/views/admin/employee/EmployeeList.vue"),
      },
      /*c测试*/
      {
        path: "code",
        name: "code",
        component: () => import("@/components/FilterSelect.vue"),
      }
    ]
  }
]

const router = new VueRouter({
  routes
})

router.beforeEach((to, from, next) => {
  if (to.path == "/") {  //如果要去登录页
    next();  //,就放行
  } else {
    const token = localStorage.getItem('token'); //获取token
    token ? next() : next('/')  //如果有令牌就放行,否则就回登录页
  }
})

export default router
