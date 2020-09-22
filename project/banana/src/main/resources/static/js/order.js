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
      addressSelect: "1",
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
      multipleSelection: [],
    //   totalPrice: 0,
    };
  },
  methods: {
    objectSpanMethod({ row, column, rowIndex, columnIndex }) {
      if (columnIndex === 0) {
        if (rowIndex % 2 === 0) {
          return {
            rowspan: 2,
            colspan: 1
          };
        } else {
          return {
            rowspan: 0,
            colspan: 0
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
    }
  },
  created: function()
  {
    let that = this;
    $.ajax({
        type: "get",
        cache: false,
        async: false,
        url: "/user/currentinfo",
        success: function(res)
        {
            console.log(res.data);
            that.userData = res.data;
            // window.localStorage.setItem("user_auth", JSON.stringify(res.data));
        },
        error: function(xhr, status, err)
        {
            console.log("failed:" + status);
        }
    });
    resdata = [{"orderId":"db916d3de7624405b20e","orderDateTime":null,"businessId":"c9a841ae09","userId":"524a2be500","businessName":"天猫超市","orderPrice":111.700005,"orderItemList":[{"cartId":null,"itemId":"0264e3fa35","itemCount":1,"businessId":"c9a841ae09","businessName":null,"userId":null,"price":17.9,"pics":"[\"//g-search2.alicdn.com/img/bao/uploaded/i4/i3/725677994/O1CN011OGlcB28vIlV4Tfzl_!!0-item_pic.jpg\"]","itemName":"【长城牌】香辣豆豉鱼罐头184g午餐下酒菜特产即食拌饭鲮鱼肉罐头","typeCode":null,"typeJson":null,"typeObject":null,"typeCodeObject":null,"selected":null},{"cartId":null,"itemId":"02b8501aad","itemCount":1,"businessId":"c9a841ae09","businessName":null,"userId":null,"price":93.8,"pics":"[\"//g-search3.alicdn.com/img/bao/uploaded/i4/i4/725677994/O1CN011qAY7328vIlkEalLj_!!0-item_pic.jpg\"]","itemName":"富力鲜猫罐头85g*13罐泰国进口成幼猫白肉猫零食补充营养增肥","typeCode":null,"typeJson":null,"typeObject":null,"typeCodeObject":null,"selected":null}],"orderStatus":"Unpaid"}];
    let _tableData = [];
    resdata.forEach((item, i) => {
        item.orderItemList.forEach((item1, j) => {
            item1["businessName"] = item.businessName;
            item1["pics"] = JSON.parse(item1["pics"]);
        });
        console.log(item.orderItemList);
        _tableData = _tableData.concat(item.orderItemList);
    });
    this.tableData = _tableData;

  }
});
