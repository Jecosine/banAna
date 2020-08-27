/*
 * @Date: 2020-08-27 01:59:44
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-08-27 13:19:03
 */
var a = new Vue({
    el: "#app",
    components: {
        'navigator' : nv
    },
    data() {
        return {
            thumbWidth: 0,
            previewOffset: 0,
            showIndex: 0,
            itemData: {
                "itemName": "Test item",
                "itemPreview": [
                    '../static/img/1.jpg',
                    '../static/img/1.jpg',
                    '../static/img/1.jpg',
                    '../static/img/1.jpg',
                    '../static/img/1.jpg',
                    '../static/img/1.jpg',
                    '../static/img/1.jpg',
                    '../static/img/2.jpg'
                ],
                "itemPrice": 1550.00,
                "itemIndex": 1,
                "itemRemain": 100
            },
            searchInput: {
                type: "1",
                text: ''
            }, 
            onTop: true,
            screenWidth: window.innerWidth,
            userData: {
                'userName': 'jecosine',
                'expired': new Date(),
                'avatarUrl': '../static/img/avatar.jpg',
                'shopCart': {

                }
            },
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
        this.thumbWidth = this.itemData.itemPreview.length * 69 - parseInt($("#detail-image-thumb-group").css("width").slice(0, -2))
        console.log(this.thumbWidth);
        window.addEventListener("totop", that.handleOnTop);
        window.addEventListener("leavetop", that.handleLeaveTop);
        window.onresize = () => {
            return (() => {
                that.screenWidth = window.innerWidth;
            })();
        }
        
    }
})