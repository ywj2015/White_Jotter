<template>
    <div id="poster">
        <el-form class="login-container" label-position="left"
                label-width="0px">
            <h3 class="login_title">系统登录</h3>
            <el-form-item>
                <el-input type="text" v-model="loginForm.username"
                        auto-complete="off" placeholder="账号"></el-input>
            </el-form-item>
            <el-form-item>
                <el-input type="password" v-model="loginForm.password" 
                        placeholder="密码" auto-complete="off"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" style="width: 100%;background: #505458;border: none"
                            @click="login">登录</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
export default {
    name: "Login",
    data() {
        return {
            loginForm: {
                username: "",
                password: ""
            },
            responseResult: []
        }
    },
    methods: {
        login() {
            this.$axios
                .post('/login', {
                    username: this.loginForm.username,
                    password: this.loginForm.password
                })
                .then(successResponse => {
                    if (successResponse.data.code === 200) {
                        this.$router.replace({path: '/index'})
                    }
                })
                .catch(failResponse => {
            })
        }
    },
}
</script>

<style scoped>
    .login-container {
        border-radius: 15px;
        background-clip: padding-box;
        margin: 90px auto;
        width: 350px;
        padding: 35px 35px 15px 35px;
        background: #fff;
        border: 1px solid #eeaaee;
        box-shadow: 0 0 25px #cac6ca;
    }

    .login_title {
        text-align: center;
        margin: 0px auto 40px;
        color: #505458;
    }

    #poster {
        background: url("../assets/back.jpg") no-repeat;
        background-position: center;
        width: 100%;
        height: 100%;
        background-size: cover;
        position: fixed;
    }

    body {
        margin: 0px;
        padding: 0px;
    }
</style>
