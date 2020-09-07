var a = new Vue({
  el: "#app",
  components: {
      'navigator' : nv
  },
  data() {
    return  {

    }
  },
  methods: {

  },
  computed: {

  },
  watch: {

  },
  mounted: function() {
    
  },
  created: function()
  {
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