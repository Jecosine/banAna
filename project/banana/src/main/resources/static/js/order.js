var a = new Vue({
  el: "#app",
  components: {
    navigator: nv,
  },
  data() {
    return {
      addressInfo: [
        {
          name: "Test name 1",
          address: "Address Test 1",
          phone: "13452455515",
        },
        {
          name: "Test name 2",
          address: "Address Test 2",
          phone: "13452455515",
        },
      ],
      addressSelect: 0,
      onTop: true,
      screenWidth: window.innerWidth,
      userData: {},
      // tableData: [
      //   {
      //     date: "2016-05-03",
      //     name: "Test Item",
      //     imgUrl: "#",
      //     amount: 1,
      //     price: 100.0,
      //     shop: {
      //         name: "banana",
      //         url: "#"
      //     },
      //     type: "Blue;128G",
      //   },
      //   {
      //     date: "2016-05-02",
      //     name: "Test Item",
      //     imgUrl: "#",
      //     amount: 2,
      //     price: 100.0,
      //     shop: {
      //         name: "banana",
      //         url: "#"
      //     },
      //     type: "Blue;128G",
      //   },
      //   {
      //     date: "2016-05-04",
      //     name: "Test Item",
      //     imgUrl: "#",
      //     amount: 1,
      //     price: 100.0,
      //     shop: {
      //         name: "banana",
      //         url: "#"
      //     },
      //     type: "Blue;128G",
      //   },
      //   {
      //     date: "2016-05-01",
      //     name: "Test Item",
      //     imgUrl: "#",
      //     amount: 1,
      //     price: 100.0,
      //     shop: {
      //         name: "banana",
      //         url: "#"
      //     },
      //     type: "Blue;128G",
      //   },
      //   {
      //     date: "2016-05-08",
      //     name: "Test Item",
      //     imgUrl: "#",
      //     amount: 1,
      //     price: 100.0,
      //     shop: {
      //         name: "banana",
      //         url: "#"
      //     },
      //     type: "Blue;128G",
      //   },
      //   {
      //     date: "2016-05-06",
      //     name: "Test Item",
      //     imgUrl: "#",
      //     amount: 1,
      //     price: 100.0,
      //     shop: {
      //         name: "banana",
      //         url: "#"
      //     },
      //     type: "Blue;128G",
      //   },
      //   {
      //     date: "2016-05-07",
      //     name: "Test Item",
      //     imgUrl: "#",
      //     amount: 1,
      //     price: 100.0,
      //     shop: {
      //         name: "banana",
      //         url: "#"
      //     },
      //     type: "Blue;128G",
      //   },
      // ],
      tableData: [],
      resdata: [],
      multipleSelection: [],
      OrderIndexArr: [],
      hoverOrderArr: [],
      orderLoading: false
      //   totalPrice: 0,
    };
  },
  methods: {
    confirmOrder: function()
    {
      

      let that = this;
      this.orderLoading = true;
      console.log(that.backupData);
      this.backupData.forEach((item, i) => {
        item.orderStatus = "Unpaid";
        item.orderItemList = undefined;
        item.address = JSON.stringify(that.addressInfo[that.addressSelect]);
      });
      this.backupData.orderItemList = JSON.stringify(this.backupData.orderItemList);
      $.ajax({
        type: "post",
        cache: false,
        async: false,
        contentType: "application/json",
        data: JSON.stringify(that.backupData),
        url: "/order/update",
        success: function (res) {
          console.log(res.data);
          if(res.status === 0)
          {
            
            setTimeout(() => {
              that.orderLoading = false;
              that.$message({
                message: "Successfully submit order",
                type: "success"
              });
              // window.location.href="/paid";
            }, 500);
          }
          
          // window.localStorage.setItem("user_auth", JSON.stringify(res.data));
        },
        error: function (xhr, status, err) {
          that.$message.error("Failed to submit order");
          console.log("failed:" + status);
        },
      });
    },
    objectSpanMethod({ row, column, rowIndex, columnIndex }) {
      if (columnIndex === 0) {
        if (rowIndex % 2 === 0) {
          return {
            rowspan: 2,
            colspan: 1,
          };
        } else {
          return {
            rowspan: 0,
            colspan: 0,
          };
        }
      }
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
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    removeContact(item) {
      var index = this.form.address.indexOf(item);
      if (index !== -1) {
        this.form.address.splice(index, 1);
      }
    },
    getOrderNumber() {
      let OrderObj = {}
      this.tableData.forEach((element, index) => {
          element.rowIndex = index
          if (OrderObj[element.businessId]) {
            OrderObj[element.businessId].push(index)
          } else {
            OrderObj[element.businessId] = []
            OrderObj[element.businessId].push(index)
          }
      })
      for (let k in OrderObj) {
        if (OrderObj[k].length > 1) {
          this.OrderIndexArr.push(OrderObj[k])
        }
      }
    },
    objectSpanMethod({row,column,rowIndex,columnIndex}) {
      if (columnIndex === 0 || columnIndex === 3 || columnIndex === 4) {
        for (let i = 0; i < this.OrderIndexArr.length; i++) {
          let element = this.OrderIndexArr[i]
          for (let j = 0; j < element.length; j++) {
            let item = element[j]
            if (rowIndex == item) {
              if (j == 0) {
                return {
                  rowspan: element.length,
                  colspan: 1
                }
              } else if (j != 0) {
                return {
                  rowspan: 0,
                  colspan: 0
                }
              }
            }
          }
        }
      }
    },
  },
  computed: {
    totalPrice() {
      console.log(this.tableData);
      let tt = 0.0;
      let temp;
      for (let i in this.tableData) {
        temp = this.tableData[i];
        tt += temp.price * temp.itemCount;
      }
      return tt.toFixed(2);
    },
    testComputed() {
      console.log(this.tableData);

      return 100;
    },
  },
  created: function () {
    let that = this;
    $.ajax({
      type: "get",
      cache: false,
      async: false,
      url: "/user/currentinfo",
      success: function (res) {
        console.log(res.data);
        that.userData = res.data;
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
      url: "/order/getById?id=" + window.location.href.split("/").pop(),
      success: function (res) {
        // console.log(res.data);
        that.resdata = res.data;
        that.backupData = res.data.slice();
        let _tableData = [];
        that.resdata.forEach((item, i) => {
          item.orderItemList = JSON.parse(item.orderItemListParsed);
          item.orderItemList.forEach((item1, j) => {
            item1["businessName"] = item.businessName;
            item1["pics"] = JSON.parse(item1["pics"]);
            item1.typeJson = JSON.parse(item1.typeJson);
            item1.typeCode = JSON.parse(item1.typeCode);
          });
          // console.log(item.orderItemList);
          _tableData = _tableData.concat(item.orderItemList);
        });
        that.tableData = _tableData;
        that.getOrderNumber();
        // window.localStorage.setItem("user_auth", JSON.stringify(res.data));
      },
      error: function (xhr, status, err) {
        console.log("failed:" + status);
      },
    });
    // resdata = [
    //   {
    //     orderId: "db916d3de7624405b20e",
    //     orderDateTime: null,
    //     businessId: "c9a841ae09",
    //     userId: "524a2be500",
    //     businessName: "天猫超市",
    //     orderPrice: 111.700005,
    //     orderItemList: [
    //       {
    //         cartId: null,
    //         itemId: "0264e3fa35",
    //         itemCount: 1,
    //         businessId: "c9a841ae09",
    //         businessName: null,
    //         userId: null,
    //         price: 17.9,
    //         pics:
    //           '["//g-search2.alicdn.com/img/bao/uploaded/i4/i3/725677994/O1CN011OGlcB28vIlV4Tfzl_!!0-item_pic.jpg"]',
    //         itemName:
    //           "【长城牌】香辣豆豉鱼罐头184g午餐下酒菜特产即食拌饭鲮鱼肉罐头",
    //         typeCode: null,
    //         typeJson: null,
    //         typeObject: null,
    //         typeCodeObject: null,
    //         selected: null,
    //       },
    //       {
    //         cartId: null,
    //         itemId: "02b8501aad",
    //         itemCount: 1,
    //         businessId: "c9a841ae09",
    //         businessName: null,
    //         userId: null,
    //         price: 93.8,
    //         pics:
    //           '["//g-search3.alicdn.com/img/bao/uploaded/i4/i4/725677994/O1CN011qAY7328vIlkEalLj_!!0-item_pic.jpg"]',
    //         itemName:
    //           "富力鲜猫罐头85g*13罐泰国进口成幼猫白肉猫零食补充营养增肥",
    //         typeCode: null,
    //         typeJson: null,
    //         typeObject: null,
    //         typeCodeObject: null,
    //         selected: null,
    //       },
    //     ],
    //     orderStatus: "Unpaid",
    //   },
    // ];
    

  },
});
