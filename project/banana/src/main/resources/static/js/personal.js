var a = new Vue({
  el: "#app",
  components: {
      'navigator' : nv
  },
  data() {
    return  {
      onTop: true,
      screenWidth: window.innerWidth,
      userData: {
          'userName': 'jecosine',
          'expired': new Date(),
          'avatarUrl': '../static/img/avatar.jpg',
          'address': "Chongqing",
          'shopCart': {

          }
      },
      activeIndex: '1',
      activeIndex2: '1'
    }
  },
  methods: {
    handleOpen: function()
    {

    },
    handleClose: function()
    {
      
    }
  },
  computed: {

  },
  watch: {
    screenWidth(val) {
      if (!this.timer)
      {
          this.screenWidth = val;
          this.timer = true;
          let that = this;
          if(this.screenWidth > 1200)
              this.isCollapsed = false;
          setTimeout(() => {
              // console.log(that.screenWidth);
              that.timer = false;
          }, 500);
      }
    }
  },
  mounted: function() {
    
  },
  created: function()
  {
    var that = this;
    $.ajax({
      type: "get",
      cache: false,
      async: false,
      url: "../static/json/user.json",
      success: function(res)
      {
          console.log(res);
          that.cateData = res;
      },
      error: function(xhr, status, err)
      {
          console.log("failed:" + status);
      }
  })
  }

});