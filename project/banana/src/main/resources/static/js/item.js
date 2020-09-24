/*
 * @Date: 2020-08-27 01:59:44
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-09-22 08:55:33
 */
// var rdata = JSON.parse(regionData);
var a = new Vue({
  el: "#app",
  components: {
    navigator: nv,
  },
  data() {
    return {
      shopRate: 4.5,
      qty: 0,
      typeOption: "",
      regionData: regionData,
      addressValue: "",
      thumbWidth: 0,
      previewOffset: 0,
      showIndex: 0,
      itemData: {},
      searchInput: {
        type: "1",
        text: "",
      },
      onTop: true,
      screenWidth: window.innerWidth,
      userData: {},
      activeIndex: "1",
      activeIndex2: "1",
      loading: false,
      typeCode: '1',
    };
  },
  methods: {
    handleOnTop(a) {
      // console.log("to top!", a);
      this.onTop = true;
    },
    handleLeaveTop() {
      this.onTop = false;
    },
    addToCart() {
      let that = this;
      this.loading = true;

      cartItem = {
        cartId: "",
        itemId: that.itemData.itemId,
        itemCount: that.itemData.itemCount,
        businessId: that.itemData.businessId,
        userId: "",
        price: that.itemData.price,
        pics: JSON.stringify(that.itemData.pics),
        itemName: that.itemData.itemName,
        typeJson: JSON.stringify(that.itemData.typeJson),
        typeCode: JSON.parse([that.typeCode]),
        itemStatus: 'active'
      };
      console.log(cartItem);

      $.ajax({
        type: "post",
        cache: false,
        async: false,
        contentType: "application/json",
        url: "/cart/addItemToCartService",
        data: JSON.stringify(cartItem),
        success: function (res) {
          console.log(res);
          if (res.status == 0) {
            setTimeout(() => {
              that.loading = false;
              that.$message({
                message: "Add to cart successfully !",
                type: "success",
              });
            }, 500);
          } else {
            setTimeout(() => {
              that.loading = false;
              that.$message.error("Add to cart failed !");
            }, 500);
          }
        },
        error: function (xhr, status, err) {
          console.log("failed:" + status);
        },
      });
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
  mounted: function () {
    const that = this;
    this.thumbWidth =
      this.itemData.pics.length * 69 -
      parseInt($("#detail-image-thumb-group").css("width").slice(0, -2));
    console.log(this.thumbWidth);
    window.addEventListener("totop", that.handleOnTop);
    window.addEventListener("leavetop", that.handleLeaveTop);
    window.onresize = () => {
      return (() => {
        that.screenWidth = window.innerWidth;
      })();
    };
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
      url: "/item/info?itemId=" + $.getUrlParam("itemId"),
      success: function (res) {
        console.log(res.data);
        that.itemData = res.data;
      },
      error: function (xhr, status, err) {
        console.log("failed:" + status);
      },
    });
    this.itemData.pics = JSON.parse(this.itemData.pics);
    this.itemData["statisticData"] = { sale: 12314, want: 4312, comment: 2145 };
    if (!this.itemData.typeJson) this.itemData.typeJson = ["default"]; else this.itemData.typeJson = JSON.parse(this.itemData.typeJson)[0];
    this.itemData.itemCount = 1;
  },
});
