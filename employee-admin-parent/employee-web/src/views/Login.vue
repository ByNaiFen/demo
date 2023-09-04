<template>
    <div>
        <div class="login">
            <div class="container">
                <span class="logoS tajustify">欢迎登录</span>
            </div>
            <div class="wrapper">
                <div class="container clearfix">
                    <div class="login-form fr">
                        <div>
                            <h3><span class="checked">帐号登录</span></h3>
                            <div class="input">
                                <div class="el-input">
                                    <input type="text" autocomplete="off" maxlength="11" placeholder="请输入账号"
                                        class="el-input__inner" v-model="loginInfo.username" />
                                </div>
                            </div>
                            <div class="input">
                                <div class="el-input el-input--suffix">
                                    <input type="password" autocomplete="off" placeholder="请输入密码" v-model="loginInfo.password"
                                        @keydown.enter="login" class="el-input__inner" /><span
                                        class="el-input__suffix"><span class="el-input__suffix-inner"></span></span>
                                </div>
                            </div>
                            <div class="btn-box">
                                <a href="javascript:;" class="btn" @click="login">登录</a>
                            </div>
                        </div>
                        <div class="tips">
                            <div class="reg clearfix">
                                <!-- <span class="regsp">快捷登录</span><span>|</span -->
                                <!-- ><span class="regsp" @click="gotoReg">立即注册</span><span>|</span -->
                                <!-- ><span class="regsp">忘记密码</span> -->
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
</template>
  
<script>
export default {
    name: 'loginForm',
    data() {
        return {
            loginInfo: {
                username: 'admin',
                password: 'admin'
            }
        }
    },
    methods: {
        login() {
            this.$axios.post('/api/login', this.loginInfo)
                .then(res => {
                    if (res.data.status == 200) {
                        window.localStorage.setItem('token', res.data.data)
                        window.localStorage.setItem('username', this.username)
                        this.$router.push('/admin')
                    } else {
                        this.$message.error(res.data.msg)
                    }
                })
        },
        gotoReg() {
            this.$router.push({
                path: '/register'
            });
        }
    }
}
</script>
  
<style>
a,
button,
div,
dl,
dt,
h1,
h2,
h3,
h4,
h5,
h6,
input,
li,
p,
select,
textarea,
ul {
    margin: 0;
    padding: 0;
    outline: none;
}

div {
    display: block;
}

/* 头部样式 */
.login>.container {
    width: 1200px;
    margin: 0 auto;
    padding: 20px 0;
}

a {
    text-decoration: none;
}

.login>.container .logoS {
    font-size: 20px;
    display: inline-block;
    width: 100px;
}


.login .wrapper {
    background: -webkit-gradient(linear, left top, left bottom, from(#c01733), to(#ff7273));
    background: linear-gradient(180deg, #c01733, #ff7273);
}

/* 背景 */
.login .wrapper .container {
    background: url(https://show.daeyes.com/imgs/lbg3.png) no-repeat 0;
    width: 1100px;
    height: 600px;
    margin: 0 auto;
}

.clearfix:after,
.clearfix:before {
    content: " ";
    display: table;
}

/* 账号登录 */
.login .wrapper .container .login-form {
    background-color: #fff;
    box-sizing: border-box;
    padding-left: 31px;
    padding-right: 31px;
    width: 412px;
    margin: 150px auto;
    border-radius: 15px;
    color: #999;
}

.fr {
    float: right;
}

.login .wrapper .container .login-form h3 {
    line-height: 23px;
    font-size: 20px;
    text-align: center;
    margin: 20px auto;
}

.login .wrapper .container .login-form .input {
    display: inline-block;
    width: 348px;
    height: 50px;
    margin-bottom: 20px;
    border-radius: 10px;
}

.el-input {
    position: relative;
    font-size: 14px;
    display: inline-block;
    width: 100%;
}

.login .wrapper .container .login-form .btn {
    width: 80%;
    line-height: 40px;
    margin-top: 10px;
    font-size: 16px;
    margin: 10px 10%;
}

.btn,
.btn:hover {
    transition: all .5s linear;
}

.btn {
    display: inline-block;
    width: 110px;
    line-height: 30px;
    text-align: center;
    background-color: #c01733;
    color: #fff;
    border: none;
    cursor: pointer;
    border-radius: 30px;
}

.login .wrapper .container .login-form .tips {
    margin-top: 14px;
    margin-bottom: 30px;
    display: -webkit-box;
    display: -ms-flexbox;
    display: flex;
    -webkit-box-pack: center;
    -ms-flex-pack: center;
    justify-content: center;
    font-size: 14px;
    cursor: pointer;
}

.login .wrapper .container .login-form .tips .reg span {
    margin: 0 7px;
}

.login .wrapper .container .login-form .tips .reg {
    color: #999;
}
</style>
  