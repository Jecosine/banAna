var tb = new Vue({
  el: '#all-container',
  data: function() {
    return { 
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
        url: "/res/json/data.json",
        method: "GET",
        async: false
      }).then((res)=>{
        that.loading = false;
        console.log(res);
        setTimeout(()=>{
          tb.tableData = res.tableData == null ? [] : res.tableData;
          tb.loading = false;
          tb.total = tb.tableData.length;
          
          console.log(tb.tableData.length);
        }, 1000);
      });
      

      
      // setTimeout(()=>{
      //   that.loading = false;
      //   console.log(that.loading);
      // }, 1000);
      
    },
    currentChange: (page) => {
      tb.currentPage = page;
      console.log("call currentchange:",page)
    }
  },
  mounted() {
    this.loading = true;
    this.fetchData();
    // this.loading = false;
  },
  created() {
    
  },
});
// tb.fetchData();
// document.onload = () => {tb.loading = true; }
var toolbarOptions = [
  ['bold', 'italic', 'underline', 'strike'],        // toggled buttons
  ['blockquote', 'code-block'],
  [{ 'list': 'ordered'}, { 'list': 'bullet' }],
  [{ 'script': 'sub'}, { 'script': 'super' }],      // superscript/subscript
  [{ 'indent': '-1'}, { 'indent': '+1' }],          // outdent/indent
  [{ 'header': [1, 2, 3, 4, 5, 6, false] }],
   // dropdown with defaults from theme
  [{ 'font': [] }],
  [{ 'align': [] }],                                      // remove formatting button
  ['image']
];
var quill = new Quill('#editor', {
  theme: 'snow',
  modules: {
    toolbar: toolbarOptions
  }
});