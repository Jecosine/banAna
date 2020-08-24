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
window.onmousewheel = (e) => {
    // console.log(e);
    e = e || window.event; 
    
    if (window.scrollY == 0)
    {
        // console.log(e);
        if(e.wheelDelta < 0)
        {
            window.scrollTo({ 
                top: window.innerHeight, 
                left: 0,
                behavior: "smooth" 
            });
        }    
        
    }
}

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
        };
    },
    methods: {

    },    
})