<template>
    <div class="login-container">
      <el-card class="login-card">
        <h2 class="login-title">忘记密码</h2>
        <el-form
          ref="forgotPasswordForm"
          :model="form"
          :rules="rules"
          class="forgot-password-form"
        >
          <el-form-item prop="email">
            <el-input
              v-model="form.email"
              placeholder="请输入您的邮箱"
            ></el-input>
          </el-form-item>
          <el-form-item>
            <el-button
              type="primary"
              @click="submitForm"
              :loading="loading"
              class="login-button"
              >重置密码</el-button
            >
          </el-form-item>
        </el-form>
        <div class="extra-links">
          <el-link type="primary" @click="goToLogin">返回登录</el-link>
        </div>
      </el-card>
    </div>
  </template>
  
  <script>
  export default {
    name: 'ForgotPassword',
    data() {
      return {
        form: {
          email: ''
        },
        rules: {
          email: [
            { required: true, message: '请输入邮箱', trigger: 'blur' },
            {
              type: 'email',
              message: '请输入正确的邮箱格式',
              trigger: ['blur', 'change']
            }
          ]
        },
        loading: false
      }
    },
    methods: {
      submitForm() {
        this.$refs.forgotPasswordForm.validate((valid) => {
          if (valid) {
            this.loading = true
            // 在这里执行重置密码逻辑
            // ...
            // 模拟提交延迟
            setTimeout(() => {
              this.loading = false
              this.$message.success('重置密码邮件已发送')
            }, 2000)
          } else {
            return false
          }
        })
      },
      goToLogin() {
        this.$router.push('/login')
      }
    }
  }
  </script>
  
  <style scoped>
  body,
  html {
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
    justify-content: center;
    margin-top: 10px;
  }
  </style>
  