// import { Vue } from './vue'

// login simulation
var user = {
    'userName': 'jecosine',
    'expired': new Date(),
    'avatarUrl': '../static/img/avatar.jpg',
    'shopCart': {

    }
}

// define scroll
var banner = $("#banner-container")

localStorage.setItem('user', JSON.stringify(user));

var navComponent = Vue.component('navigator', {
    props: ['shopChartData', 'userData'],
    template: '<div>'
});
var a = new Vue({
    el: '#navigation-container',
    data() {
        return {
            onTop: true,
            isCollapsed: false,
            screenWidth: window.innerWidth,
            userData: user,
            activeIndex: '1',
            activeIndex2: '1'
        };
    },
    computed: {
    },
    methods: {
        handleSelect(key, keyPath) {
            console.log(key, keyPath);
        },
        handleOnTop(a)
        {
            // console.log("to top!", a);
            this.onTop = true;
        },
        handleLeaveTop()
        {
            this.onTop = false;
            console.log("leave top!");
        }
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
        window.addEventListener("totop", that.handleOnTop);
        window.addEventListener("leavetop", that.handleLeaveTop);
        window.onresize = () => {
            return (() => {
                that.screenWidth = window.innerWidth;
            })();
        }
        
    }
    
})

window.onscroll = () => {
    // console.log(window.scrollY);

    if(window.scrollY == 0)
    {
        // console.log("into event");
        var event = document.createEvent('HTMLEvents');
        event.initEvent("totop", false, true);
        window.dispatchEvent(event);
        // that.$emit("to-top", '1');

        // $("#navigation-mask").stop().animate({opacity: 0}, 200);
    }
    else
    {
        if(a.onTop)
        {
            var event = document.createEvent('HTMLEvents');
            event.initEvent("leavetop", false, true);
            window.dispatchEvent(event);
        }
        // this.$emit("scrollleavetop");
        // $("#navigation-mask").stop().animate({opacity: 1}, 200);
    }

}
var b = new Vue({
    el: '#main-container',
    data() {
        return {
            rightContainerWidth: 0,
            activeName: 'second',
            showByIndex: null,
            cateData: undefined,
            searchInput: {
                type: "1",
                text: undefined
            }, 
            heatRank: [
                {
                    "itemName": "排行榜测测试试测试试排行榜测测试试测试试排行榜测测试试测试试排行榜测测试试测试试",
                    "shopName": "shop1",
                    "itemUrl": "#",
                    "statisticData" : {"view": 12314,"want": 4312,"sale": 2145}
                },
                {
                    "itemName": "item test 2",
                    "shopName": "shop1",
                    "itemUrl": "#",
                    "statisticData" : {"view": 12314,"want": 4312,"sale": 2145}
                    
                    
                },
                {
                    "itemName": "item test 3",
                    "shopName": "shop1",
                    "itemUrl": "#",
                    "statisticData" : {"view": 12314,"want": 4312,"sale": 2145}
                    
                    
                },
                {
                    "itemName": "item test 1",
                    "shopName": "shop1",
                    "itemUrl": "#",
                    "statisticData" : {"view": 12314,"want": 4312,"sale": 2145}
                    
                    
                },
                {
                    "itemName": "item test 2",
                    "shopName": "shop1",
                    "itemUrl": "#",
                    "statisticData" : {"view": 12314,"want": 4312,"sale": 2145}
                    
                    
                },
                {
                    "itemName": "item test 3",
                    "shopName": "shop1",
                    "itemUrl": "#",
                    "statisticData" : {"view": 12314,"want": 4312,"sale": 2145}
                    
                    
                }
            ],
            recommend: {
                // "itemCount": 
            }
        };
    },
    methods: {
        getStrLength(str) {
            var l = str.length;
            var blen = 0;
            for(i=0; i<l; i++) {
                if ((str.charCodeAt(i) & 0xff00) != 0) {
                    blen ++;
                }
                blen ++;
            }
            return blen
        },
        cutStr(str, len) {
            // var cl = this.getStrLength(str);
            var l = str.length;
            var blen = 0;
            var res = "";
            var i = 0;
            for(i=0; i<l; i++) {
                if (blen > len - 3)
                {
                    break;
                }
                if ((str.charCodeAt(i) & 0xff00) != 0) {
                    blen ++;
                }
                blen ++;
                res = res.concat(str[i]);
            }
            return (i === l)?res:res.concat("...");
        },
        handleClick(tab, event) {
            console.log(tab, event);
        },
        handleHover(event)
        {
            console.log("???");
        },
        logout() {
            // setTimeout(
            //     () => {
            //         console.log(this.showByIndex);
            //     },
            //     1000
            // ) 
            this.showByIndex = null
            // console.log("out");
            // this.showByIndex = showByIndex;
        }

    },
    computed: {
        // rightContainerWidth: function() {
        //     console.log($("#cate-right-container").css("width").slice(0, -2));
        //     return parseInt($("#cate-right-container").css("width").slice(0, -2));
        // },
        cateRightStyle: function() {
            return {
                "height": this.cateData.cateCount * 50 + 'px'
            }
        },
        cardWidth: function() {
            console.log((window.innerWidth < 1200) ? 6 : 4);
            return (window.innerWidth < 1200) ? 6 : 4;
        },
        cardColCount: function() {
            return (window.innerWidth < 1200) ? 8 : 12;
        }
    },
    watch: {
        screenWidth(val) {
            if (!this.timer)
            {
                this.screenWidth = val;
                this.timer = true;
                let that = this;
                setTimeout(() => {
                    console.log(that.screenWidth);
                    that.timer = false;
                }, 500);

            }
        }
    },
    mounted: function()
    {
        
        console.log($("#cate-right-container").css("width").slice(0, -2));
        this.rightContainerWidth = parseInt($("#cate-right-container").css("width").slice(0, -2)) - 20;
        
    },
    created: function()
    {
        var that = this;
        console.log("loading cate");
        $.ajax({
            type: "get",
            cache: false,
            async: false,
            url: "../static/json/cate.json",
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
})
// window.onscroll = () => {
//     // console.log(window.scrollY);

//     if(window.scrollY == 0)
//     {
//         // $("#navigation-mask").stop().animate({opacity: 0}, 200);
//     }
//     else
//     {
//         // $("#navigation-mask").stop().animate({opacity: 1}, 200);
//     }

// }


$("#scroll-btn").click(() => {
    window.scrollTo({ 
        top: window.innerHeight, 
        left: 0,
        behavior: "smooth" 
    });
})