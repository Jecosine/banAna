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
            userData: user,
            activeIndex: '1',
            activeIndex2: '1'
        };
    },
    methods: {
        handleSelect(key, keyPath) {
            console.log(key, keyPath);
        }
    },
    
})

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
                    "itemName": "排行榜测试试测试试1",
                    "itemUrl": "#"
                },
                {
                    "itemName": "item test 2",
                    "itemUrl": "#"
                },
                {
                    "itemName": "item test 3",
                    "itemUrl": "#"
                },
                {
                    "itemName": "item test 1",
                    "itemUrl": "#"
                },
                {
                    "itemName": "item test 2",
                    "itemUrl": "#"
                },
                {
                    "itemName": "item test 3",
                    "itemUrl": "#"
                }
            ]
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
window.onscroll = () => {
    // console.log(window.scrollY);

    if(window.scrollY == 0)
    {
        $("#navigation-mask").stop().animate({opacity: 0}, 200);
    }
    else
    {
        $("#navigation-mask").stop().animate({opacity: 1}, 200);
    }

}


$("#scroll-btn").click(() => {
    window.scrollTo({ 
        top: window.innerHeight, 
        left: 0,
        behavior: "smooth" 
    });
})