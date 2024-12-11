<template>
  <div class="login-container">
    <el-card class="login-card">
      <h2 class="login-title">Wan Studio</h2>
      <el-form ref="loginForm" :model="loginForm" :rules="rules">
        <el-form-item prop="username">
          <el-input v-model="loginForm.username" placeholder="请输入用户名"></el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input v-model="loginForm.password" type="password" placeholder="请输入密码"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="login" :loading="loading" class="login-button">登录</el-button>
        </el-form-item>
      </el-form>
      <div class="extra-links">
        <el-button type="text" @click="register">注册</el-button>
        <el-link type="primary" @click="forgotPassword">忘记密码</el-link>
      </div>
    </el-card>
  </div>
</template>

<script>
export default {
  name: 'SignIn',
  data() {
    return {
      loginForm: {
        username: '',
        password: ''
      },
      rules: {
        username: [
          { required: true, message: '请输入用户名', trigger: 'blur' }
        ],
        password: [
          { required: true, message: '请输入密码', trigger: 'blur' }
        ]
      },
      loading: false
    }
  },
  methods: {
    login() {
      this.$refs.loginForm.validate(valid => {
        if (valid) {
          this.loading = true
          // 在这里执行登录逻辑
          // ...
          // 模拟登录延迟
          setTimeout(() => {
            this.loading = false
            this.$message.success('登录成功')
          }, 2000)
        } else {
          return false
        }
      })
    },
    register() {
      this.$router.push('/sign-up')
    },
    forgotPassword() {
      this.$router.push('/forgot-password')
    }
  }
}
</script>

<style scoped>
body, html {
  margin: 0;
  padding: 0;
  height: 100%;
}

.login-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background: linear-gradient(to right, #3498db, #9b59b6);
}

.login-card {
  width: 300px;
}

.login-title {
  text-align: center;
  margin-bottom: 20px;
}

.login-button {
  width: 100%;
}

.extra-links {
  display: flex;
  justify-content: space-between;
  margin-top: 10px;
}
</style>
