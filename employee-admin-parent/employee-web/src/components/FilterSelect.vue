<!--
 * @Author: YeShaoKang 630471737@qq.com
 * @Date: 2023-09-03 23:49:58
 * @LastEditors: YeShaoKang 630471737@qq.com
 * @LastEditTime: 2023-09-04 21:55:38
 * @FilePath: \employee-web\src\components\filterSelect.vue
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
-->
<template>
    <el-select v-model="parentValue" clearable placeholder="请选择" @change="emitValue" :required="required">
        <el-option v-for="item in codeList" :key="item.id" :label="item.typeDesc" :value="item.id">
        </el-option>
    </el-select>
</template>

<script>
export default {
    name: 'FilterSelect',
    props: [
        'type', 'required', 'value'
    ],
    data() {
        return {
            codeList: [],
            parentValue: ''
        }
    },
    mounted() {
        this.getOptionsByType()
        if (this.value) {
            this.parentValue = this.value
        }
    },
    methods: {
        getOptionsByType() {
            this.$axios.get(`/api/code/${this.type}`)
                .then(res => {
                    this.codeList = res.data
                })
        },
        emitValue() {
            this.$emit('input', this.parentValue)
        }
    }
}
</script>

<style></style>