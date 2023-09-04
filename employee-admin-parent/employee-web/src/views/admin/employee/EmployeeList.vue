<!--
 * @Author: YeShaoKang 630471737@qq.com
 * @Date: 2023-09-03 23:11:42
 * @LastEditors: YeShaoKang 630471737@qq.com
 * @LastEditTime: 2023-09-05 00:59:35
 * @FilePath: \employee-web\src\views\admin\employee\EmployeeList.vue
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
-->
<template>
    <div>
        <el-header>
            <el-form :inline="true" :model="searchObject" class="demo-form-inline">
                <el-form-item label="姓名">
                    <el-input placeholder="姓名" v-model="searchObject.empName" clearable />
                </el-form-item>
                <el-form-item label="部门">
                    <filter-select :type="1003" v-model="searchObject.deptName" />
                </el-form-item>
                <el-form-item label="学历">
                    <filter-select :type="1004" v-model="searchObject.empDegreeName" />
                </el-form-item>

                <el-button type="primary" @click="searchHandle">查询</el-button>
                <el-button type="primary" @click="openDialog('add')">添加</el-button>
                <el-button type="primary" @click="exportExcel">导出</el-button>
            </el-form>
        </el-header>
        <el-main>
            <el-table :data="pageData.records" style="width: 100%">
                <el-table-column type="index" label="序号" />
                <el-table-column prop="empName" label="职工姓名" />
                <el-table-column prop="sex" label="性别">
                    <template slot-scope="scope">
                        <span v-if="scope.row.sex == 10021001">男</span>
                        <span v-if="scope.row.sex == 10021002">女</span>
                    </template>
                </el-table-column>
                <el-table-column prop="age" label="年龄" />
                <el-table-column prop="deptName" label="部门名称">
                    <template slot-scope="scope">
                        <span v-if="scope.row.deptName == 10031001">业务部</span>
                        <span v-if="scope.row.deptName == 10031002">后勤部</span>
                        <span v-if="scope.row.deptName == 10031003">人事部</span>
                    </template>
                </el-table-column>
                <el-table-column prop="empDegreeName" label="学历">
                    <template slot-scope="scope">
                        <span v-if="scope.row.empDegreeName == 10041001">大专</span>
                        <span v-if="scope.row.empDegreeName == 10041002">本科</span>
                        <span v-if="scope.row.empDegreeName == 10041003">研究生</span>
                    </template>
                </el-table-column>
                <el-table-column label="操作">
                    <template slot-scope="scope">
                        <el-button @click="openDialog('edit', scope.row)" type="text" size="small">编辑</el-button>
                        <el-button @click="del(scope.row.id)" type="text" size="small">删除</el-button>
                    </template>
                </el-table-column>
            </el-table>
        </el-main>

        <el-footer>
            <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange"
                :current-page="pageData.current" :page-sizes="[10, 20, 100, 500]" :page-size="pageData.size"
                layout="total, sizes, prev, pager, next, jumper" :total="pageData.total">
            </el-pagination>
        </el-footer>
        <employee-dialog v-if="dialogFormVisible" :rowsData="rowsData" :operateType="operateType"
            @closeDialog="closeDialog" />
    </div>
</template>

<script>
import FilterSelect from '@/components/FilterSelect.vue';
import employeeDialog from '@/views/admin/employee/EmployeeDialog.vue';
export default {
    name: 'EmployeeList',
    components: {
        FilterSelect,
        employeeDialog
    },
    data() {
        return {
            searchObject: {
                empName: '',
                deptName: '',
                empDegreeName: '',
                pageSize: '10',
                pageNum: '1',
            },
            dialogFormVisible: false,
            operateType: 'detail',
            rowsData: '',
            pageData: {
                current: 1,
                size: 10
            }
        }
    },
    mounted() {
        this.searchHandle()
    },
    methods: {
        searchHandle() {
            this.$axios.get('/api/employee/query?' + this.$qs.stringify(this.searchObject))
                .then(res => {
                    this.pageData = res.data.data
                })
        },
        exportExcel() {
            this.$axios.get('/api/employee/export', { responseType: 'blob' })
                .then(response => {
                    const url = window.URL.createObjectURL(new Blob([response.data]));
                    const link = document.createElement('a');
                    link.href = url;
                    link.setAttribute('download', '职工列表.xlsx');
                    document.body.appendChild(link);
                    link.click();
                });
        },
        openDialog(operateType, rowsData) {
            this.operateType = operateType
            this.rowsData = rowsData
            console.log(rowsData)
            this.dialogFormVisible = true
        },
        del(id) {
            this.$confirm('确认删除?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(() => {
                this.$axios.post(`/api/employee/delete/${id}`)
                    .then(res => {
                        if (res.data.status == 200) {
                            this.$message({
                                type: 'success',
                                message: '删除成功!'
                            });
                            this.searchHandle()
                        }
                    })
            }).catch(() => {
                this.$message({
                    type: 'info',
                    message: '已取消删除'
                });
            });
        },
        closeDialog() {
            this.dialogFormVisible = false
            this.searchHandle()
        },
        handleSizeChange(val) {
            this.searchObject.pageSize = val
            this.searchHandle()
        },
        handleCurrentChange(val) {
            this.searchObject.pageNum = val
            this.searchHandle()
        }
    },
}
</script>

<style></style>