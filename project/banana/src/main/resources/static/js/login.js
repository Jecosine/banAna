/*
 * @Date: 2020-08-26 22:02:05
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-08-26 22:02:09
 */
var a = new Vue({
    el: "#login-app",
    data() {
        var validateUserName = (rule, value, callback) => {
            if (!value) {
                return callback(new Error('Username can not be empty'));
            }
            setTimeout(() => {
                // console.log(":" + value)
                if (value.length > 10) {
                    callback(new Error('Invalid username'));
                }
                callback();
            }, 1000);
        };
        var validatePass = (rule, value, callback) => {
            if (value === '') {
                callback(new Error('Password can not be empty'));
            } else {
                callback();
            }
        };
        return {
            loading: false,
            loginForm: {
                userName: '',
                password: ''
            },
            rules: {
                userName: [
                    { validator: validateUserName, trigger: 'blur' }
                ],
                password: [
                    { validator: validatePass, trigger: 'blur' }
                ]

            },
        };
    },
    methods: {
        submitForm: function(formName) {
            let that = this;
            console.log("press submit");
            this.loading = true;
            this.$refs[formName].validate((valid) => {
                if (valid) {
                    console.log(JSON.stringify(this.loginForm));
                    setTimeout(() => {
                        this.loading = false;
                    }, 1000);
                } else {
                    console.log('error submit!!');
                    return false;
                }
            });
            $.ajax({
                url: "/user/loginService",
                contentType: "application/x-www-form-urlencoded",
                type: "post",
                data: $("#login-form").serialize(),
                success: (res) => {
                    console.log(res);
                    if(res.status === 0) {
                        window.location.href = '/';
                        window.localStorage.setItem("user_data", JSON.stringify(res.data));
                    } else {
                    console.log("login failed!");
                    that.$message.error("Login Failed, check your username or password.");
                    }
                    $("#err").text((res["status"] == -1) ? res["message"] : "");
                },
                error: () => {
                    console.log("Failed");
                }
            })
        },
        resetForm(formName) {
            console.log("ASDSAD");
            this.$refs[formName].resetFields();
        }
    }
})
