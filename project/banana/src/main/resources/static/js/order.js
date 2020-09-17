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
      userData: {
        userName: "jecosine",
        expired: new Date(),
        avatarUrl: "../static/img/avatar.jpg",
        address: "Chongqing",
        shopCart: {},
      },
      tableData: [
        {
          date: "2016-05-03",
          name: "Test Item",
          imgUrl: "#",
          amount: 1,
          price: 100.0,
          shop: {
              name: "banana",
              url: "#"
          },
          type: "Blue;128G",
        },
        {
          date: "2016-05-02",
          name: "Test Item",
          imgUrl: "#",
          amount: 2,
          price: 100.0,
          shop: {
              name: "banana",
              url: "#"
          },
          type: "Blue;128G",
        },
        {
          date: "2016-05-04",
          name: "Test Item",
          imgUrl: "#",
          amount: 1,
          price: 100.0,
          shop: {
              name: "banana",
              url: "#"
          },
          type: "Blue;128G",
        },
        {
          date: "2016-05-01",
          name: "Test Item",
          imgUrl: "#",
          amount: 1,
          price: 100.0,
          shop: {
              name: "banana",
              url: "#"
          },
          type: "Blue;128G",
        },
        {
          date: "2016-05-08",
          name: "Test Item",
          imgUrl: "#",
          amount: 1,
          price: 100.0,
          shop: {
              name: "banana",
              url: "#"
          },
          type: "Blue;128G",
        },
        {
          date: "2016-05-06",
          name: "Test Item",
          imgUrl: "#",
          amount: 1,
          price: 100.0,
          shop: {
              name: "banana",
              url: "#"
          },
          type: "Blue;128G",
        },
        {
          date: "2016-05-07",
          name: "Test Item",
          imgUrl: "#",
          amount: 1,
          price: 100.0,
          shop: {
              name: "banana",
              url: "#"
          },
          type: "Blue;128G",
        },
      ],
      multipleSelection: [],
    //   totalPrice: 0,
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
  },
  computed: {
    totalPrice() {
      console.log(this.tableData);
      let tt = 0.0;
      let temp;
      for (let i in this.tableData) {        
        temp = this.tableData[i];
        tt += temp.price * temp.amount;
      }
      return tt;
    },
    testComputed() {
      console.log(this.tableData);

        return 100;
    }
  },
});
