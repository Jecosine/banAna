var tb = new Vue({
  el: '#all-container',
  data: function() {
    return { 
      visible: false,
      searchInput: "",
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
      }]
    }
  },
  methods: {
    handleSelectionChange(val) {
      this.multipleSelection = val;
      console.log(val)
    },
    handleClick(row) {
      window.location.href="/admin/view?pid="+row.pid;
      console.log(row);
    },
    handleEdit(row) {
      window.location.href="/admin/edit?pid="+row.pid;
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
        url: "/passage/getInfo",
        method: "GET",
        async: false
      }).then((res)=>{
        that.loading = false;
        console.log(res);
        setTimeout(()=>{
          tb.tableData = res == null ? [] : res;
          tb.loading = false;
          tb.total = tb.tableData.length;                
          console.log(tb.tableData.length);
        }, 1000);
      });
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