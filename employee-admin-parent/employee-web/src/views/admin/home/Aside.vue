<!--
 * @Author: YeShaoKang 630471737@qq.com
 * @Date: 2023-09-02 22:26:46
 * @LastEditors: YeShaoKang 630471737@qq.com
 * @LastEditTime: 2023-09-03 23:08:34
 * @FilePath: \employee-admin-parent\employee-web\src\views\admin\home\Aside.vue
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
-->
<template>
    <div>
        <el-aside width="200px">
            <!-- :default-openeds="['1']" 默认展开项 -->
            <el-menu router style="background-color: #435375">
                <el-menu-item @click="gotoIndex('/admin')">首页</el-menu-item>

                <el-submenu index="2">
                    <template slot="title"><i class="el-icon-menu">
                        </i>职工管理</template>
                    <el-menu-item-group>
                        <el-menu-item index="2-1"
                        @click="gotoIndex('/admin/employee-count')">职工统计</el-menu-item>
                    </el-menu-item-group>
                    
                    <el-menu-item-group>
                        <el-menu-item index="2-2"
                        @click="gotoIndex('/admin/employee-list')">职工列表</el-menu-item>
                    </el-menu-item-group>
                </el-submenu>

                <el-menu-item-group>
                    <el-menu-item @click="logout()">注销</el-menu-item>
                </el-menu-item-group>
            </el-menu>
        </el-aside>
    </div>
</template>

<script>
export default {
    name: 'AppAside',
    data() {
        return {
            username: '',
            menu: []
        }
    },
    mounted() {
    },
    methods: {
        gotoIndex(router) {
            this.$router.push(router)
        },
        logout() {
            this.$confirm('确认注销吗?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'info'
            }).then(() => {
                window.localStorage.setItem('username', '')
                window.localStorage.setItem('token', '')
                this.$router.push('/login')
            })
        }
    }
}
</script>

<style>
.el-aside{
    height: 100vh;
}
.el-menu-item{
    color: rgb(62, 142, 213);
}
.el-menu-item-group{
    background: #3f476e;
}
</style>
