/*
 * @Author: YeShaoKang 630471737@qq.com
 * @Date: 2023-09-02 20:16:00
 * @LastEditors: YeShaoKang 630471737@qq.com
 * @LastEditTime: 2023-09-02 22:58:04
 * @FilePath: \employee-admin-parent\employee-web\src\main.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
import Vue from 'vue'
import './plugins/axios'
import App from './App.vue'
import router from './router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import qs from 'qs';

Vue.config.productionTip = false
Vue.use(ElementUI);
Vue.prototype.$qs=qs

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
