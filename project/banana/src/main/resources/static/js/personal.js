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
      activeIndex2: '1',
      form: {
        name: '',
        region: '',
        date1: '',
        date2: '',
        delivery: false,
        type: [],
        resource: '',
        desc: ''
      },
      imageUrl: '',
      fileList: []
    }
  },
  methods: {
    onSubmit: function()
    {

    },
    handleOpen: function()
    {

    },
    handleClose: function()
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
      const isJPG = file.raw.type  === 'image/jpeg';
      const isLt2M = file.size / 1024 / 1024 < 2;

      if (!isJPG) {
        this.$message.error('上传头像图片只能是 JPG 格式!');
      }
      if (!isLt2M) {
        this.$message.error('上传头像图片大小不能超过 2MB!');
      }
      if(isJPG && isLt2M)
        this.imageUrl = URL.createObjectURL(file.raw);
      else
        return false;
      return true;
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