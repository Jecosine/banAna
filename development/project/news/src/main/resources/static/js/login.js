var tb = new Vue({
  el: '#all-container',
  data: function() {
    return { 
      visible: false,
      collSider: false,
      userInfoCol: true,
      uicConst: true,
      search: '',
      userConfig: undefined,
      ruleForm: {
        email: '',
        password: ''
      },
      dialogVisible: false
    }
  },
  methods: {
    handleClose() {
      this.ruleForm.password = "";
      this.dialogVisible = false;
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    submitForm() {
      var that = this;
      var dt = {
          "email":that.ruleForm.email,
          "password":that.ruleForm.password
        };
      $.ajax({
        url: "/user/loginService",
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify(dt),
        async: false
      }).then((res)=>{
        console.log(res);
        if (res.status && res.status != 0)
          that.dialogVisible = true;
        else {
          window.location.href = "/admin/todo";
        }
      });
    },
  },
  mounted() {
  },
  created() {
    
  },
});
