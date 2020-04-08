<template>

  <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="login-form">
    <h2 class="login_title">系统登录</h2>
  <el-form-item label="用户账号" prop="username">
    <el-input v-model="ruleForm.username"></el-input>
  </el-form-item>
    <el-form-item label="用户密码" prop="password">
      <el-input v-model="ruleForm.password"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="submitForm('ruleForm')">登录</el-button>
      <el-button @click="resetForm('ruleForm')">注册</el-button>
    </el-form-item>
</el-form>
</template>
<script>
  export default {
    data() {
      return {
        ruleForm: {
          username: '',
          password: '',
        },
        rules: {
          username: [
            { required: true, message: '请输入用户账号', trigger: 'blur' },
            { min: 3, max: 8, message: '长度在 3 到 8 个字符', trigger: 'blur' }
          ],
          password: [
            { required: true, message: '请输入用户密码', trigger: 'blur' },
            { min: 6, max: 12, message: '长度在 6 到 12 个字符', trigger: 'blur' }
          ]
        },
      };
    },
    methods: {
      submitForm(formName) {
        const _this = this;
        this.$refs[formName].validate((valid) => {
          if (valid) {
            _this.$axios.post('/login',
                              _this.$qs.stringify({ username: _this.ruleForm.username, password: _this.ruleForm.password }),
                      { headers:{ 'Content-Type':'application/x-www-form-urlencoded' }}).then(function (resp) {
              if (resp.status == 200){
                if (resp.data.status == 'success'){
                  _this.$router.push({path:'/home'})
                } else {
                  _this.$alert(resp.data.msg)
                }
              } else {
                _this.$alert("登陆失败，请检查网络！")
              }
            })
          } else {
          }
        });
      },

      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    }
  }
</script>
<style>
  .login-form {
    border-radius: 15px;
    background-clip: padding-box;
    margin: 180px auto;
    width: 350px;
    padding: 35px 35px 15px 35px;
    background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6c6;
  }

  .login_title {
    margin: 0px auto 40px auto;
    text-align: center;
    color: #505458;
  }
</style>
