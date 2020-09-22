var a = new Vue({
    el: "#app",
    components: {
        navigator: nv,
    },
    data() {
        return {
            aoActiveName: '1',
            onTop: true,
            screenWidth: window.innerWidth,
            userData: {
                userName: "jecosine",
                expired: new Date(),
                avatarUrl: "img/avatar.jpg",
                address: "Chongqing",
                shopCart: {},
            },
            regionData: regionData,
            activeIndex: "1",
            activeIndex2: "1",
            form: {
                name: "jecosine",
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
            tableData: [],
            // tableData: [
            //     {
            //         date: "2016-05-03",
            //         name: "Test Item",
            //         imgUrl: "#",
            //         amount: 1,
            //         price: 100.00,
            //         orderStatus: 'Unpaid',
            //         address: "上海市普陀区金沙江路 1518 弄",
            //     }
            // ],
            orderData: [
                {
                    orderDateTime: '2020/03/05 20:02:11',
                    orderId: '12hj3vjv22',
                    shopName: "Shop Name 1",
                    orderStatus: 'Unpaid',
                    price: 1000.00,
                    items: [
                        {
                            name: "Item 1",
                            imgUrl: "#",
                            amount: 1,
                            price: 100
                        },
                        {
                            name: "Item 1",
                            imgUrl: "#",
                            amount: 1,
                            price: 100
                        },
                        {
                            name: "Item 1",
                            imgUrl: "#",
                            amount: 1,
                            price: 100
                        },{
                            name: "Item 1",
                            imgUrl: "#",
                            amount: 1,
                            price: 100
                        },{
                            name: "Item 1",
                            imgUrl: "#",
                            amount: 1,
                            price: 100
                        },{
                            name: "Item 1",
                            imgUrl: "#",
                            amount: 1,
                            price: 100
                        },
                    ]            
                }
              ],
            orderMultipleSelection: [],
            multipleSelection: [],
            orderFilter: 'All'
        };
    },
    methods: {
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
        handleOrderTab: function(tab, event) {
            console.log(tab.label, event);
            this.orderFilter = tab.label;
        },
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
        handleClick(v)
        {

        },
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
    computed: {
    },
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
        // get user dat
        // get cart data
        $.ajax({
            type: "get",
            cache: false,
            async: false,
            url: "/cart/getCartService",
            success: function (res) {
                console.log(res);
                that.tableData = res.data;
                if (that.tableData!=null)
                that.tableData.forEach((item, i) => {
                    item.pics = JSON.parse(item.pics);
                });
            },
            error: function (xhr, status, err) {
                console.log("failed:" + status);
            },
        });
    },
});
