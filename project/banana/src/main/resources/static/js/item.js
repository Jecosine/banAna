/*
 * @Date: 2020-08-27 01:59:44
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-09-22 08:55:33
 */
// var rdata = JSON.parse(regionData);
var a = new Vue({
    el: "#app",
    components: {
        'navigator' : nv
    },
    data() {
        return {
            shopRate: 4.5,
            qty: 0,
            typeOption: '',
            regionData: regionData,
            addressValue: '',
            thumbWidth: 0,
            previewOffset: 0,
            showIndex: 0,
            itemData: {},
            // itemData: {
            //     "itemName": "",
            //     "itemAddress": "",
            //     "pics": [
            //         '/img/1.jpg',
            //         '/img/1.jpg',
            //         '/img/2.jpg'
            //     ],
            //     "price": 1550.00,
            //     "itemIndex": 1,
            //     "itemRemain": 100,
            //     "statisticData" : {"sale": 12314,"want": 4312,"comment": 2145}
            // },
            searchInput: {
                type: "1",
                text: ''
            }, 
            onTop: true,
            screenWidth: window.innerWidth,
            userData: {},
            activeIndex: '1',
            activeIndex2: '1'
        }
        
    },
    methods: {
        handleOnTop(a)
        {
            // console.log("to top!", a);
            this.onTop = true;
        },
        handleLeaveTop()
        {
            this.onTop = false;
        },
        addToCart()
        {
            let that = this;
            console.log("Addd>>>");
    //         private String cartId;
    // private String itemId;
    // private Integer itemCount;
    // private String businessId;
    // private String userId;
    // private Float price;
            cartItem = {
                cartId: '',
                itemId: that.itemData.itemId,
                itemCount: that.itemData.itemCount,
                businessId: that.itemData.businessId,
                userId: '',
                price: that.itemData.price,
                pics: JSON.stringify(that.itemData.pics),
                itemName: that.itemData.itemName
            }
            console.log(cartItem);

            $.ajax({
                type: "post",
                cache: false,
                async: false,
                contentType:'application/json',
                url: "/cart/addItemToCartService",
                data: JSON.stringify(cartItem),
                success: function(res)
                {
                    console.log(res.data);
                },
                error: function(xhr, status, err)
                {
                    console.log("failed:" + status);
                }
            });
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
    mounted: function()
    {
        const that = this;
        this.thumbWidth = this.itemData.pics.length * 69 - parseInt($("#detail-image-thumb-group").css("width").slice(0, -2))
        console.log(this.thumbWidth);
        window.addEventListener("totop", that.handleOnTop);
        window.addEventListener("leavetop", that.handleLeaveTop);
        window.onresize = () => {
            return (() => {
                that.screenWidth = window.innerWidth;
            })();
        }
    },
    created: function()
    {
        let that = this;
        $.ajax({
            type: "get",
            cache: false,
            async: false,
            url: "/item/info?itemId=" + $.getUrlParam('itemId'),
            success: function(res)
            {
                console.log(res.data);
                that.itemData = res.data;
            },
            error: function(xhr, status, err)
            {
                console.log("failed:" + status);
            }
        });
        this.itemData.pics = JSON.parse(this.itemData.pics);
        this.itemData["statisticData"] = {"sale": 12314,"want": 4312,"comment": 2145};
        if (!this.itemData.typeJson)
        this.itemData.typeJson = ["default"];
        this.itemData.itemCount = 1;
    }
})