var a = new Vue({
  el: "#app",
  components: {
    navigator: nv,
  },
  data() {
    return {
      aoActiveName: "1",
      onTop: false,
      screenWidth: window.innerWidth,
      userData: {
        userName: "jecosine",
        expired: new Date(),
        avatarUrl: "img/avatar.jpg",
        address: "Chongqing",
        shopCart: {},
      },
      searchResult: [],
      activeIndex: "1",
      activeIndex2: "1",
      searchInput: {
        type: "1",
        text: "",
      },
    };
  },
  methods: {
    cutStr(str, len) {
      // var cl = this.getStrLength(str);
      var l = str.length;
      var blen = 0;
      var res = "";
      var i = 0;
      for (i = 0; i < l; i++) {
        if (blen > len - 3) {
          break;
        }
        if ((str.charCodeAt(i) & 0xff00) != 0) {
          blen++;
        }
        blen++;
        res = res.concat(str[i]);
      }
      return i === l ? res : res.concat("...");
    },
    doSearch(e) {
      window.open(
        "/search?s=" + this.searchInput.text + "&t=" + this.searchInput.type
      );
    },
    handleOnTop(a) {
      // console.log("to top!", a);
      this.onTop = true;
    },
    handleLeaveTop() {
      this.onTop = false;
      console.log("leave top!");
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
    handleClick(v) {},
    handleOrderTab: function (tab, event) {
      console.log(tab.label, event);
      this.orderFilter = tab.label;
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
  computed: {
    totalPrice: function () {
      let tt = 0.0;
      let temp;
      for (let i in this.multipleSelection) {
        // console.log(i);
        temp = this.multipleSelection[i];
        tt += temp.price * temp.amount;
      }
      return tt;
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
    var that = this;
    if (window.location.search) {
      $.ajax({
        type: "get",
        cache: false,
        async: false,
        url: "/searchresult" + window.location.search,
        success: function (res) {
          // console.log(res);
          that.searchResult = res.data;
        },
        error: function (xhr, status, err) {
          console.log("failed:" + status);
        },
      });
      this.searchResult.forEach((item, i) => {
        item.pics = JSON.parse(item.pics);
      });
    }
    this.searchInput.text = $.getUrlParam("s");
  },
});
