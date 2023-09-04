<template>
    <el-table-column :prop="prop" :label="label">
        <template slot-scope="scope">
            <span>{{ formatter(scope.cellValue) }}</span>
        </template>
    </el-table-column>
</template>

<script>
export default {
    name: 'FilterTableColumn',
    props: ['prop', 'label'],
    data() {
        return {
        }
    },
    mounted() {
    },
    methods: {
        formatter(cellValue) {
            return this.$axios.get(`/api/code/id/${cellValue}`)
                .then(res => {
                    return res.data.typeDesc
                })
        }
    },
}
</script>

<style></style>