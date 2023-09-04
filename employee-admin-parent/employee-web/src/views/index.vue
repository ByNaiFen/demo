<template>
    <div>
        <el-container class="home-container">
            <el-aside width="200px">
                <Aside></Aside>
            </el-aside>
            <el-main>
                <router-view />
            </el-main>
        </el-container>
    </div>
</template>

<script>
import Aside from "./admin/home/Aside.vue";
export default {
    name: 'AppIndex',
    data() {
        return {};
    },
    created() {
    },
    methods: {},
    components: {
        Aside
    }
}
</script>

<style scoped>
.home-container {
    height: 100%;
}

.el-main,
.el-container {
    height: 100vh;
}

.el-header {
    background: #E6A23C;
}
</style>
