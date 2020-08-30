var xdata = [];
var totalRead = 0;

var ydata = [];
var tempdata = [];
var tb = new Vue({
  el: '#all-container',
  data: function() {
    return { 
      curId: this.getId(),
      selectedRole: undefined,
      infoActive: "1",
      visible: false,
      form: {},
      searchInput: "",
      titleAvatar: "",
      collSider: false,
      activeTag: "",
      userInfoCol: true,
      uicConst: true,
      tableData: [],
      total: 10,
      totalRead: 0,
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
        url: "/passage/getInfoById?" + window.location.search.slice(2),
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
    // this.loading = false;
  },
  created() {
    this.loading = true;        
    this.fetchData()
  },
});
// tb.fetchData();
// document.onload = () => {tb.loading = true; }
var tempdata;
tempdata = $.ajax({
  url: "/passage/getData" + window.location.search,
  method: "GET",
  async: false
}).then((res)=>{
  console.log(res);
  tempdata = res == null ? [] : res;           
  tempdata.forEach((item, index) => {
    xdata.push(item["x"]);
    ydata.push(parseInt(item["y"]));
  });
  ydata.forEach((i)=>{totalRead += i;})
  tb.totalRead = totalRead;
  // setTimeout(()=>{
  //   tb.totalRead = totalRead;
  // }, 500);
  console.log(tempdata);
});
var myChart = echarts.init(document.getElementById('main-chart'), 'westeros');
var option = {
    title: {
        text: '近一月的数据'
    },
    tooltip: {},
    legend: {
        data:['阅读量'],
        x: 'right'
    },
    visualMap: {
      top: 30,
      right: 0,
      pieces: [{
          gt: 0,
          lte: 1000,
          color: '#a5e7f0'
      }, {
          gt: 1000,
          lte: 2000,
          color: '#59c4e6'
      }, {
          gt: 2000,
          lte: 6000,
          color: '#516b91'}
      ],
      outOfRange: {
          color: '#999'
      }
  },
    toolbox: {
      left: 'center',
      feature: {
          dataZoom: {
              yAxisIndex: 'none'
          },
          restore: {},
          saveAsImage: {}
      }
  },
  dataZoom: [{
      startValue: '2014-06-01'
  }, {
      type: 'inside'
  }],
    xAxis: {
      type: 'category',
      boundaryGap: false,
      data: xdata
    },
    yAxis: {
      type: 'value'
    },
    series: [{
      name:'阅读量',
      type:'line',
      smooth:false,
      symbol: 'none',
      stack: 'a',
      
      data: ydata,
      markLine: {
          silent: true,
          data: [{
              yAxis: 1000
          }, {
              yAxis: 2000
          }, {
              yAxis: 3000
          }, {
              yAxis: 4000
          }]
      }
    }]
};
myChart.setOption(option);