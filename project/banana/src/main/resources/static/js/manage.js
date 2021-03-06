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
            userData: {},
            regionData: regionData,
            activeIndex: "2",
            activeIndex2: "1",
            form: { },
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
              ],
              itemData: [],
            itemFilter: 'All',
            orderMultipleSelection: [],
            multipleSelection: [],
            orderFilter: 'All'
        };
    },
    methods: {
        
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
        handleOrderTab: function (tab, event) {
            console.log(tab.label, event);
            this.itemFilter = tab.label;
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
        getCate(e)
        {
            return e;
        }
    },
    computed: {
    },
    handleOrderSelectionChange(val) {
        this.orderMultipleSelection = val;
    },
    handleSelectionChange(val) {
        this.multipleSelection = val;
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
    mounted: function () {
        // var myChart = echarts.init(document.getElementById("chart1"));

        // option = {
        //   legend: {},
        //   tooltip: {},
        //   dataset: {
        //     source: [
        //       ["product", "2015", "2016", "2017"],
        //       ["Mobile", 43.3, 85.8, 93.7],
        //       ["Tablet", 32.45, 75.8, 83.7],
        //       ["Eletronic", 63.3, 85.8, 103.7],
        //       ["PC", 83.1, 73.4, 55.1],
        //       ["Televison", 86.4, 65.2, 82.5],
        //       ["GameBox", 72.4, 53.9, 39.1],
        //     ],
        //   },
        //   xAxis: { type: "category" },
        //   yAxis: {},
        //   // Declare several bar series, each will be mapped
        //   // to a column of dataset.source by default.
        //   series: [{ type: "bar" }, { type: "bar" }, { type: "bar" }],
        // };
        // myChart.setOption(option);
      
    },
    created: function () {
        var that = this;
        // get user data
        $.ajax({
            type: "get",
            cache: false,
            async: false,
            url: "/user/currentinfo",
            success: function (res) {
              console.log(res.data);
              that.userData = res.data;
              that.form = that.userData;
              if (that.form.contact == undefined) {
                that.form.contact = [];
              } else 
              that.form.contact = JSON.parse(that.form.contact);
              // window.localStorage.setItem("user_auth", JSON.stringify(res.data));
            },
            error: function (xhr, status, err) {
              console.log("failed:" + status);
            },
          });
        
        $.ajax({
            type: "get",
            cache: false,
            async: false,
            url: "/item/getByBusinessId",
            success: function (res) {
                console.log(res);
                that.itemData = res.data;
                if (that.itemData!=null)
                that.itemData.forEach((item, i) => {
                    item.pics = JSON.parse(item.pics);
                });
            },
            error: function (xhr, status, err) {
                console.log("failed:" + status);
            },
        });
    },
});
