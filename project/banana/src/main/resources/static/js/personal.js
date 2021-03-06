var a = new Vue({
  el: "#app",
  components: {
    navigator: nv,
  },
  data() {
    return {
      aoActiveName: "1",
      onTop: true,
      screenWidth: window.innerWidth,
      userData: {},
      regionData: regionData,
      activeIndex: "1",
      activeIndex2: "1",
      form: {
        name: "",
        region: "",
        qq: "",
        gender: "",
        email: false,
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
          orderDateTime: "2020/03/05 20:02:11",
          orderId: "12hj3vjv22",
          shopName: "Shop Name 1",
          orderStatus: "Unpaid",
          price: 1000.0,
          items: [
            {
              name: "Item 1",
              imgUrl: "#",
              amount: 1,
              price: 100,
            },
            {
              name: "Item 1",
              imgUrl: "#",
              amount: 1,
              price: 100,
            },
            {
              name: "Item 1",
              imgUrl: "#",
              amount: 1,
              price: 100,
            },
            {
              name: "Item 1",
              imgUrl: "#",
              amount: 1,
              price: 100,
            },
            {
              name: "Item 1",
              imgUrl: "#",
              amount: 1,
              price: 100,
            },
            {
              name: "Item 1",
              imgUrl: "#",
              amount: 1,
              price: 100,
            },
          ],
        },
      ],
      orderMultipleSelection: [],
      multipleSelection: [],
      orderMultipleSelection: [],
      orderFilter: "All",
      profileLoading: false,
      giftLoading: false
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
    handleOrderSelectionChange(val) {
        this.orderMultipleSelection = val;
    },
    handleSelectionChange(val) {
      this.multipleSelection = val;
    },
    handleClick(v) {},
    handleOrderTab: function (tab, event) {
      console.log(tab.label, event);
      this.orderFilter = tab.label;
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    removeContact(item) {
      var index = this.form.contact.indexOf(item);
      if (index !== -1) {
        this.form.contact.splice(index, 1);
      }
    },
    buyGift(e)
    {
        let that = this;
        this.giftLoading = true;
        let temp = JSON.parse(JSON.stringify(that.userData));
        temp.contact = JSON.stringify(temp.contact);
        temp.point += e;
        $.ajax({
            type: "post",
            cache: false,
            async: false,
            contentType: "application/json",
            data: JSON.stringify(temp),
            url: "/user/info",
            success: function (res) {
              console.log(res);
              setTimeout(() => {
                  that.giftLoading=false;
                  if(res.status===0)
                  {
                      that.$message({
                          message: "Buy successfully",
                          type: "success"
                      });
                      that.userData.point = temp.point;
                  } else {
                    that.$message.error("Update Failed");
                  }
              }, 500);
            },
            error: function (xhr, status, err) {
              console.log("failed:" + status);
              that.$message.error("Update Failed");

            },
          });
      
    },
    addDomain() {
      this.form.contact.push({
        name: "",
        phone: "",
        address: "",
        key: Date.now(),
      });
    },
    submitOrder: function () {
      let that = this;
      let _selected = that.multipleSelection;
      _selected.forEach((item, i) => {
        item.pics = JSON.stringify(item.pics);
        item.typeJson = JSON.stringify(item.typeJson);
        // item.typeCode = JSON.stringify(item.typeCode);
      });
      $.ajax({
        type: "post",
        cache: false,
        async: false,
        contentType: "application/json",
        data: JSON.stringify(_selected),
        url: "/newOrder",
        success: function (res) {
          console.log(res);
          window.location.href = "/order/" + res.data;
        },
        error: function (xhr, status, err) {
          console.log("failed:" + status);
        },
      });
      console.log(JSON.stringify(_selected));
      console.log(_selected);
    },
    deleteItem: function (e) {
      console.log(e);
      let that = this;
      this.$alert("Confirm deleting this item?", "Delete Cart Item", {
        confirmButtonText: "Yes",
        callback: (action) => {
          if(action == 'confirm')
          {
              e.pics = JSON.stringify(e.pics);
              e.typeJson = JSON.stringify(e.typeJson);
            $.ajax({
                type: "post",
                cache: false,
                async: false,
                contentType: "application/json",
                data: JSON.stringify(e),
                url: "/cart/deleteItemFromCartService",
                success: function (res) {
                  console.log(res);
                  if(res.status === 0)
                  {
                    that.$message({
                        message: "Deleted successfully",
                        type: "success"
                    });
                    window.location.replace("/personal?tab=5");
                  } else {
                    that.$message.error("Deleted failed");
                  }
                  
                //   window.location.reload();
                },
                error: function (xhr, status, err) {
                  console.log("failed:" + status);
                },
              });
          }
        },
      });
    },
    onSubmit: function () {
      let that = this;
      that.profileLoading = true;
      let _form = JSON.parse(JSON.stringify(that.form));
      console.log(_form);
      
      _form.contact = JSON.stringify(_form.contact);

      $.ajax({
        type: "post",
        cache: false,
        async: false,
        contentType: "application/json",
        data: JSON.stringify(_form),
        url: "/user/info",
        success: function (res) {
          console.log(res);
          setTimeout(() => {
              that.profileLoading=false;
              if(res.status===0)
              {
                  that.$message({
                      message: "Update successfully",
                      type: "success"
                  });
              } else {
                that.$message.error("Update Failed");
              }
          }, 500);
        //   window.location.replace("/personal");
          // window.location.href = "/order/" + res.data;
        },
        error: function (xhr, status, err) {
          console.log("failed:" + status);
        },
      });
    },
    handleOpen: function () {},
    handleClose: function () {},
    handleSelect(key, keyPath) {
      this.activeIndex = key;
    },
    handleAvatarSuccess(res, file) {
      this.imageUrl = URL.createObjectURL(file.raw);
      console.log(res);
      this.form.avatarUrl = "/file/" + res.message;
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
    totalPrice: function () {
      let tt = 0.0;
      let temp;
      for (let i in this.multipleSelection) {
        // console.log(i);
        temp = this.multipleSelection[i];
        tt += temp.price * temp.itemCount;
      }
      return tt.toFixed(2);
    },
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
    // var that = this;
    // get user data
    // $.ajax({
    //     type: "get",
    //     cache: false,
    //     async: false,
    //     url: "json/user.json",
    //     success: function (res) {
    //         console.log(res);
    //         that.cateData = res;
    //     },
    //     error: function (xhr, status, err) {
    //         console.log("failed:" + status);
    //     },
    // });
    this.activeIndex = $.getUrlParam("tab") || "1";
    let that = this;
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
    // get cart data
    $.ajax({
      type: "get",
      cache: false,
      async: false,
      url: "/cart/getCartService",
      success: function (res) {
        console.log(res);
        that.tableData = res.data;
        if (that.tableData != null)
          that.tableData.forEach((item, i) => {
            item.pics = JSON.parse(item.pics);
            item.typeJson = JSON.parse(item.typeJson);
          });
      },
      error: function (xhr, status, err) {
        console.log("failed:" + status);
      },
    });
    // get order data
    $.ajax({
      type: "get",
      cache: false,
      async: false,
      url: "/order/getByUserId",
      success: function (res) {
        console.log(res);
        that.orderData = res.data;
        if (that.orderData != null)
          that.orderData.forEach((item, i) => {
            item.orderItemListParsed = JSON.parse(item.orderItemListParsed);
            item.orderItemListParsed.forEach((item, i) => {
              item.pics = JSON.parse(item.pics);
              item.typeJson = JSON.parse(item.typeJson);
              item.typeCode = JSON.parse(item.typeCode);
            });
          });
        else
          that.orderData = []
      },
      error: function (xhr, status, err) {
        console.log("failed:" + status);
      },
    });
  },
});
