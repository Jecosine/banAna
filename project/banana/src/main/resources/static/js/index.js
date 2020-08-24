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
            activeName: 'second',
            showByIndex: 0,
            cateData: {}
        };
    },
    methods: {
        handleClick(tab, event) {
            console.log(tab, event);
        },
        handleHover(event)
        {
            console.log("???");
        }
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