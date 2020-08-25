var tb = new Vue({
  el: '#all-container',
  data: function() {
    return { 
      curId: this.getId(),
      selectedRole: undefined,
      infoActive: "1",
      visible: false,
      searchInput: "",
      titleAvatar: "",
      collSider: false,
      activeTag: "",
      userInfoCol: true,
      uicConst: true,
      tableData: [],
      total: 10,
      currentPage: 1,
      loading: false,
      pagesize: 15,
      search: '',
      value: '',
      parts: [{
        value: 1,
        label: "体育"
      },{
        value: 2,
        label: "财经"
      },{
        value: 3,
        label: "科技"
      },{
        value: 4,
        label: "教育"
      }],
      roles: ["分区编辑","分区总管","账户总管"],
      dialogImageUrl:"",
      dialogVisible: false,
      form: {
        title: '',
        region: '',
        date1: '',
        date2: '',
        delivery: false,
        type: [],
        resource: '',
        desc: ''
      }
    }
  },
  methods: {
    getId: ()=> {
      var that = this;
      var str=window.location.search;
      if (str.indexOf("id")!=-1){           
        var pos_start=str.indexOf("id")+"id".length+1;
        var pos_end=str.indexOf("&",pos_start);
        if (pos_end==-1){
          return str.substring(pos_start);
        }else{
          return null;
        }
      }
    },
    handlePictureCardPreview(file) {
      this.dialogImageUrl = file.url;
      this.dialogVisible = true;
    },
    handleAvatarSuccess(res, file) {
      this.titleAvatar = URL.createObjectURL(file.raw);
    },
    beforeAvatarUpload(file) {
      const isValid = file.type === 'image/jpeg' || file.type === 'image/png';            
      const isLt2M = file.size / 1024 / 1024 < 2;
      if (!isValid) {
        this.$message.error('上传头像图片只能是 JPG/PNG 格式!');
      }
      if (!isLt2M) {
        this.$message.error('上传头像图片大小不能超过 2MB!');
      }
      return isValid && isLt2M;
    },
  
    handleSelectionChange(val) {
      this.multipleSelection = val;
      console.log(val)
    },
    handleClick(row) {
      console.log(row);
    },
    handleOpen: (key)=>{
      console.log(key);
    },
    handleClose: (key, keyPath)=>{
      console.log(key, keyPath);
    },
    fetchData: () => {
      var that = this;
      var tempdata;
      tempdata = $.ajax({
        url: "/user/getById" + window.location.search,
        method: "GET",
        async: false
      }).then((res)=>{
        that.loading = false;
        console.log(res);
        setTimeout(()=>{
          tb.form = res == null ? [] : res;
          tb.loading = false;                
          console.log(tb.form);
        }, 1000);
      });            
    },
    currentChange: (page) => {
      tb.currentPage = page;
      console.log("call currentchange:",page)
    }
  },
  mounted() {
    this.fetchData();
    
    // this.loading = false;
  },
  created() {
    this.loading = true;
  },
});
// tb.fetchData();
// document.onload = () => {tb.loading = true; }