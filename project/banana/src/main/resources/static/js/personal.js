var a = new Vue({
    el: "#app",
    components: {
        navigator: nv,
    },
    data() {
        return {
            onTop: true,
            screenWidth: window.innerWidth,
            userData: {
                userName: "jecosine",
                expired: new Date(),
                avatarUrl: "../static/img/avatar.jpg",
                address: "Chongqing",
                shopCart: {},
            },
            regionData: regionData,
            activeIndex: "1",
            activeIndex2: "1",
            form: {
                name: "Banana",
                region: "",
                date1: "",
                date2: "",
                delivery: false,
                type: [],
                resource: "",
                address: [
                    {
                        key: Date.now(),
                        name: "Jecosine",
                        phone: "12345678910",
                        address: "Guangdong",
                    },
                ],
                desc: "",
            },
            imageUrl: "",
            fileList: [],
            tableData: [
                {
                    date: "2016-05-03",
                    name: "Test Item",
                    imgUrl: "#",
                    address: "上海市普陀区金沙江路 1518 弄",
                },
                {
                    date: "2016-05-02",
                    name: "Test Item",
                    imgUrl: "#",
                    address: "上海市普陀区金沙江路 1518 弄",
                },
                {
                    date: "2016-05-04",
                    name: "Test Item",
                    imgUrl: "#",
                    address: "上海市普陀区金沙江路 1518 弄",
                },
                {
                    date: "2016-05-01",
                    name: "Test Item",
                    imgUrl: "#",
                    address: "上海市普陀区金沙江路 1518 弄",
                },
                {
                    date: "2016-05-08",
                    name: "Test Item",
                    imgUrl: "#",
                    address: "上海市普陀区金沙江路 1518 弄",
                },
                {
                    date: "2016-05-06",
                    name: "Test Item",
                    imgUrl: "#",
                    address: "上海市普陀区金沙江路 1518 弄",
                },
                {
                    date: "2016-05-07",
                    name: "Test Item",
                    imgUrl: "#",
                    address: "上海市普陀区金沙江路 1518 弄",
                },
            ],
            multipleSelection: [],
        };
    },
    methods: {
        toggleSelection(rows) {
            if (rows) {
                rows.forEach((row) => {
                    this.$refs.multipleTable.toggleRowSelection(row);
                });
            } else {
                this.$refs.multipleTable.clearSelection();
            }
        },
        handleSelectionChange(val) {
            this.multipleSelection = val;
        },
        resetForm(formName) {
            this.$refs[formName].resetFields();
        },
        removeContact(item) {
            var index = this.form.address.indexOf(item);
            if (index !== -1) {
                this.form.address.splice(index, 1);
            }
        },
        addDomain() {
            this.form.address.push({
                phone: "",
                address: "",
                key: Date.now(),
            });
        },

        onSubmit: function () {},
        handleOpen: function () {},
        handleClose: function () {},
        handleSelect(key, keyPath) {
            this.activeIndex = key;
        },
        handleAvatarSuccess(res, file) {
            this.imageUrl = URL.createObjectURL(file.raw);
        },
        beforeAvatarUpload(file) {
            console.log(file);
            const isJPG = file.raw.type === "image/jpeg";
            const isLt2M = file.size / 1024 / 1024 < 2;

            if (!isJPG) {
                this.$message.error("上传头像图片只能是 JPG 格式!");
            }
            if (!isLt2M) {
                this.$message.error("上传头像图片大小不能超过 2MB!");
            }
            if (isJPG && isLt2M) this.imageUrl = URL.createObjectURL(file.raw);
            else return false;
            return true;
        },
    },
    computed: {},
    watch: {
        screenWidth(val) {
            if (!this.timer) {
                this.screenWidth = val;
                this.timer = true;
                let that = this;
                if (this.screenWidth > 1200) this.isCollapsed = false;
                setTimeout(() => {
                    // console.log(that.screenWidth);
                    that.timer = false;
                }, 500);
            }
        },
    },
    mounted: function () {},
    created: function () {
        var that = this;
        $.ajax({
            type: "get",
            cache: false,
            async: false,
            url: "../static/json/user.json",
            success: function (res) {
                console.log(res);
                that.cateData = res;
            },
            error: function (xhr, status, err) {
                console.log("failed:" + status);
            },
        });
    },
});
