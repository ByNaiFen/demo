<template>
    <el-dialog title="职工信息" visible @close="closeDialog">
        <el-form :model="addObject" ref="EmployeeDialogForm" :inline="true" :rules="rules">
            <el-form-item label="姓名" prop="empName">
                <el-input placeholder="姓名" v-model="addObject.empName" clearable />
            </el-form-item>
            <el-form-item label="职工性别" prop="sex">
                <filter-select :type="1002" v-model="addObject.sex" />
            </el-form-item>
            <el-form-item label="职工年龄" prop="age">
                <el-input v-model.number="addObject.age" />
            </el-form-item>
            <el-form-item label="部门名字" prop="deptName">
                <filter-select :type="1003" v-model="addObject.deptName" />
            </el-form-item>
            <el-form-item label="学历" prop="empDegreeName">
                <filter-select :type="1004" v-model="addObject.empDegreeName" />
            </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
            <el-button @click="closeDialog">取 消</el-button>
            <el-button type="primary" @click="submit('EmployeeDialogForm')">提交</el-button>
        </div>
    </el-dialog>
</template>

<script>
import FilterSelect from '@/components/FilterSelect.vue';
export default {
    name: 'EmployeeDialog',
    components: {
        FilterSelect
    },
    props: {
        rowsData: { type: Object },
        operateType: { type: String },
    },
    data() {
        return {
            addObject: {
                empName: '',
                sex: '',
                age: '',
                deptName: '',
                empDegreeName: ''
            },
            rules: {
                empName: [
                    { required: true, message: '请输入姓名', trigger: 'blur' },
                    { min: 2, max: 5, message: '长度在 2 到 5 个字符', trigger: 'blur' }
                ],
                sex: [
                    { required: true, message: '请选择性别', trigger: 'change' }
                ],
                age: [
                    { required: true, message: '请输入年龄', trigger: 'change' }
                ],
                deptName: [
                    { required: true, message: '请选择部门', trigger: 'change' }
                ],
                empDegreeName: [
                    { required: true, message: '请选择学历', trigger: 'change' }
                ],
            }
        }
    },
    mounted() {
        if (this.rowsData) {
            this.addObject = this.rowsData
        }
    },
    methods: {
        closeDialog() {
            this.$emit('closeDialog')
        },
        submit(formName) {
            this.$refs[formName].validate((valid) => {
                if (valid) {
                    let apiUrl = ''
                    if (this.operateType == 'add') {
                        apiUrl = '/api/employee/add'
                    } else if (this.operateType == 'edit') {
                        apiUrl = '/api/employee/update'
                    }
                    this.$axios.post(apiUrl, this.addObject)
                        .then(res => {
                            if (res.data.status == 200) {
                                this.$message.success(res.data.msg)
                                this.closeDialog()
                            } else {
                                this.$message.error(res.data.msg)
                            }
                        })
                } else {
                    return false;
                }
            })
        }
    },
}
</script>

<style></style>